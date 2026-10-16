package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.container.CreationTime;
import com.google.android.exoplayer2.container.Mp4LocationData;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
/* loaded from: classes4.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static boolean canTrimSamplesWithTimestampChange(int i) {
        return i != 1;
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static final class UdtaInfo {
        public final Metadata metaMetadata;
        public final Metadata smtaMetadata;
        public final Metadata xyzMetadata;

        public UdtaInfo(Metadata metadata, Metadata metadata2, Metadata metadata3) {
            this.metaMetadata = metadata;
            this.smtaMetadata = metadata2;
            this.xyzMetadata = metadata3;
        }
    }

    public static final class MvhdInfo {
        public final Metadata metadata;
        public final long timescale;

        public MvhdInfo(Metadata metadata, long j) {
            this.metadata = metadata;
            this.timescale = j;
        }
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Track apply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i);
            if (containerAtom2.type == 1953653099 && (apply = function.apply(parseTrak(containerAtom2, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(apply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835297121))).getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212)), gaplessInfoHolder));
            }
        }
        return arrayList;
    }

    public static UdtaInfo parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        Metadata metadata3 = null;
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = parseUdtaMeta(parsableByteArray, position + readInt);
            } else if (readInt2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata2 = parseSmta(parsableByteArray, position + readInt);
            } else if (readInt2 == -1451722374) {
                metadata3 = parseXyz(parsableByteArray);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return new UdtaInfo(metadata, metadata2, metadata3);
    }

    public static MvhdInfo parseMvhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0) {
            j = parsableByteArray.readUnsignedInt();
            parsableByteArray.skipBytes(4);
        } else {
            long readLong = parsableByteArray.readLong();
            parsableByteArray.skipBytes(8);
            j = readLong;
        }
        return new MvhdInfo(new Metadata(new CreationTime((j - 2082844800) * 1000)), parsableByteArray.readUnsignedInt());
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1751411826);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1801812339);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1768715124);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 >= 0 && readInt4 < readInt) {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            } else {
                Log.w(TAG, "Skipped metadata with unknown key index: " + readInt4);
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> parseEdts;
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(1835297121));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1751411826))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1953196132))).data);
        long j2 = j == -9223372036854775807L ? parseTkhd.duration : j;
        long j3 = parseMvhd(leafAtom.data).timescale;
        long scaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, j3) : -9223372036854775807L;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(1835626086))).getContainerAtomOfType(1937007212));
        Pair<Long, String> parseMdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(1835296868))).data);
        Atom.LeafAtom leafAtomOfType = containerAtom3.getLeafAtomOfType(1937011556);
        if (leafAtomOfType == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        StsdData parseStsd = parseStsd(leafAtomOfType.data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom.getContainerAtomOfType(1701082227)) == null || (parseEdts = parseEdts(containerAtomOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) parseEdts.first;
            jArr2 = (long[]) parseEdts.second;
            jArr = jArr3;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), j3, scaleLargeTimestamp, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v22, types: [boolean] */
    private static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        long j;
        long[] jArr;
        int i5;
        int i6;
        long j2;
        int i7;
        int[] iArr;
        long[] jArr2;
        int i8;
        int[] iArr2;
        long[] jArr3;
        int i9;
        long j3;
        int i10;
        ?? r11;
        int i11;
        int i12;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1937011578);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType, track.format);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(1937013298);
            if (leafAtomOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(1937007471);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1668232756));
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011555))).data;
        ParsableByteArray parsableByteArray3 = ((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(1937011827))).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(1937011571);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(1668576371);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            i = parsableByteArray5.readUnsignedIntToInt();
        } else {
            i = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            i3 = parsableByteArray4.readUnsignedIntToInt();
            if (i3 > 0) {
                i2 = parsableByteArray4.readUnsignedIntToInt() - 1;
                i4 = 0;
            } else {
                i2 = -1;
                i4 = 0;
                parsableByteArray4 = null;
            }
        } else {
            i2 = -1;
            i3 = 0;
            i4 = 0;
        }
        int fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
        String str = track.format.sampleMimeType;
        int i13 = (fixedSampleSize == -1 || !(("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && readUnsignedIntToInt == 0 && i == 0 && i3 == 0)) ? i4 : 1;
        SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
        if (i13 != 0) {
            long[] jArr4 = new long[chunkIterator.length];
            int[] iArr3 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr4[chunkIterator.index] = chunkIterator.offset;
                iArr3[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr4, iArr3, readUnsignedIntToInt3);
            long[] jArr5 = rechunk.offsets;
            iArr = rechunk.sizes;
            int i14 = rechunk.maximumSize;
            long[] jArr6 = rechunk.timestamps;
            int[] iArr4 = rechunk.flags;
            j2 = rechunk.duration;
            jArr2 = jArr5;
            i8 = i14;
            jArr = jArr6;
            iArr2 = iArr4;
            j = 0;
        } else {
            long[] jArr7 = new long[sampleCount];
            j = 0;
            int[] iArr5 = new int[sampleCount];
            jArr = new long[sampleCount];
            ParsableByteArray parsableByteArray6 = parsableByteArray5;
            int[] iArr6 = new int[sampleCount];
            ParsableByteArray parsableByteArray7 = parsableByteArray4;
            int i15 = i2;
            int i16 = i4;
            int i17 = i16;
            int i18 = i17;
            int i19 = i18;
            long j4 = 0;
            long j5 = 0;
            int i20 = i;
            int i21 = readUnsignedIntToInt3;
            int i22 = readUnsignedIntToInt2;
            int i23 = readUnsignedIntToInt;
            int i24 = i19;
            while (true) {
                if (i16 >= sampleCount) {
                    i5 = i22;
                    i6 = i18;
                    break;
                }
                long j6 = j5;
                int i25 = i18;
                boolean z2 = true;
                while (i25 == 0) {
                    z2 = chunkIterator.moveNext();
                    if (!z2) {
                        break;
                    }
                    int i26 = i22;
                    long j7 = chunkIterator.offset;
                    i25 = chunkIterator.numSamples;
                    j6 = j7;
                    i22 = i26;
                    i21 = i21;
                    sampleCount = sampleCount;
                }
                int i27 = sampleCount;
                i5 = i22;
                int i28 = i21;
                if (!z2) {
                    Log.w(TAG, "Unexpected end of chunk data");
                    long[] copyOf = Arrays.copyOf(jArr7, i16);
                    iArr5 = Arrays.copyOf(iArr5, i16);
                    jArr = Arrays.copyOf(jArr, i16);
                    iArr6 = Arrays.copyOf(iArr6, i16);
                    jArr7 = copyOf;
                    sampleCount = i16;
                    i6 = i25;
                    break;
                }
                if (parsableByteArray6 != null) {
                    int i29 = i19;
                    while (i29 == 0 && i20 > 0) {
                        i29 = parsableByteArray6.readUnsignedIntToInt();
                        i17 = parsableByteArray6.readInt();
                        i20--;
                    }
                    i19 = i29 - 1;
                }
                jArr7[i16] = j6;
                int readNextSampleSize = sampleSizeBox.readNextSampleSize();
                iArr5[i16] = readNextSampleSize;
                if (readNextSampleSize > i24) {
                    i24 = readNextSampleSize;
                }
                jArr[i16] = j4 + i17;
                iArr6[i16] = parsableByteArray7 == null ? 1 : i4;
                if (i16 == i15) {
                    iArr6[i16] = 1;
                    i3--;
                    if (i3 > 0) {
                        i15 = ((ParsableByteArray) Assertions.checkNotNull(parsableByteArray7)).readUnsignedIntToInt() - 1;
                    }
                }
                j4 += i28;
                int i30 = i5 - 1;
                if (i30 != 0 || i23 <= 0) {
                    i21 = i28;
                } else {
                    i30 = parsableByteArray3.readUnsignedIntToInt();
                    i23--;
                    i21 = parsableByteArray3.readInt();
                }
                i22 = i30;
                long j8 = j6 + iArr5[i16];
                i18 = i25 - 1;
                i16++;
                j5 = j8;
                sampleCount = i27;
            }
            j2 = j4 + i17;
            if (parsableByteArray6 != null) {
                while (i20 > 0) {
                    if (parsableByteArray6.readUnsignedIntToInt() != 0) {
                        i7 = i4;
                        break;
                    }
                    parsableByteArray6.readInt();
                    i20--;
                }
            }
            i7 = 1;
            if (i3 != 0 || i5 != 0 || i6 != 0 || i23 != 0 || i19 != 0 || i7 == 0) {
                Log.w(TAG, "Inconsistent stbl box for track " + track.id + ": remainingSynchronizationSamples " + i3 + ", remainingSamplesAtTimestampDelta " + i5 + ", remainingSamplesInChunk " + i6 + ", remainingTimestampDeltaChanges " + i23 + ", remainingSamplesAtTimestampOffset " + i19 + (i7 == 0 ? ", ctts invalid" : ""));
            }
            iArr = iArr5;
            jArr2 = jArr7;
            i8 = i24;
            iArr2 = iArr6;
        }
        long j9 = j2;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j9, 1000000L, track.timescale);
        if (track.editListDurations == null) {
            Util.scaleLargeTimestampsInPlace(jArr, 1000000L, track.timescale);
            return new TrackSampleTable(track, jArr2, iArr, i8, jArr, iArr2, scaleLargeTimestamp);
        }
        int i31 = sampleCount;
        int[] iArr7 = iArr;
        if (track.editListDurations.length == 1 && track.type == 1 && jArr.length >= 2) {
            long j10 = ((long[]) Assertions.checkNotNull(track.editListMediaTimes))[i4];
            long scaleLargeTimestamp2 = j10 + Util.scaleLargeTimestamp(track.editListDurations[i4], track.timescale, track.movieTimescale);
            long[] jArr8 = jArr2;
            long[] jArr9 = jArr;
            boolean canApplyEditWithGaplessInfo = canApplyEditWithGaplessInfo(jArr9, j9, j10, scaleLargeTimestamp2);
            jArr = jArr9;
            j9 = j9;
            if (canApplyEditWithGaplessInfo) {
                long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j10 - jArr[i4], track.format.sampleRate, track.timescale);
                long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(j9 - scaleLargeTimestamp2, track.format.sampleRate, track.timescale);
                if ((scaleLargeTimestamp3 != j || scaleLargeTimestamp4 != j) && scaleLargeTimestamp3 <= 2147483647L && scaleLargeTimestamp4 <= 2147483647L) {
                    gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp3;
                    gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr, 1000000L, track.timescale);
                    return new TrackSampleTable(track, jArr8, iArr7, i8, jArr, iArr2, Util.scaleLargeTimestamp(track.editListDurations[i4], 1000000L, track.movieTimescale));
                }
            }
            jArr2 = jArr8;
            iArr7 = iArr7;
        }
        if (track.editListDurations.length == 1 && track.editListDurations[i4] == j) {
            long j11 = ((long[]) Assertions.checkNotNull(track.editListMediaTimes))[i4];
            for (int i32 = i4; i32 < jArr.length; i32++) {
                jArr[i32] = Util.scaleLargeTimestamp(jArr[i32] - j11, 1000000L, track.timescale);
            }
            return new TrackSampleTable(track, jArr2, iArr7, i8, jArr, iArr2, Util.scaleLargeTimestamp(j9 - j11, 1000000L, track.timescale));
        }
        ?? r10 = track.type == 1 ? 1 : i4;
        int[] iArr8 = new int[track.editListDurations.length];
        int[] iArr9 = new int[track.editListDurations.length];
        long[] jArr10 = (long[]) Assertions.checkNotNull(track.editListMediaTimes);
        int i33 = i4;
        int i34 = i33;
        int i35 = i34;
        int i36 = i35;
        while (i33 < track.editListDurations.length) {
            int[] iArr10 = iArr8;
            int[] iArr11 = iArr9;
            long j12 = jArr10[i33];
            int i37 = i8;
            if (j12 != -1) {
                int i38 = i33;
                int i39 = i34;
                long scaleLargeTimestamp5 = Util.scaleLargeTimestamp(track.editListDurations[i33], track.timescale, track.movieTimescale);
                i10 = i38;
                iArr10[i10] = Util.binarySearchFloor(jArr, j12, true, true);
                long j13 = j12 + scaleLargeTimestamp5;
                r11 = i4;
                iArr11[i10] = Util.binarySearchCeil(jArr, j13, (boolean) r10, (boolean) r11);
                while (true) {
                    i11 = iArr10[i10];
                    i12 = iArr11[i10];
                    if (i11 >= i12 || (iArr2[i11] & 1) != 0) {
                        break;
                    }
                    iArr10[i10] = i11 + 1;
                }
                i35 += i12 - i11;
                i34 = i39 | (i36 != i11 ? 1 : r11 == true ? 1 : 0);
                i36 = i12;
            } else {
                i10 = i33;
                r11 = i4;
            }
            i8 = i37;
            i4 = r11;
            iArr9 = iArr11;
            i33 = i10 + 1;
            iArr8 = iArr10;
        }
        int i40 = i8;
        int[] iArr12 = iArr8;
        int[] iArr13 = iArr9;
        int i41 = i4;
        int i42 = i34 | (i35 != i31 ? 1 : i41);
        long[] jArr11 = i42 != 0 ? new long[i35] : jArr2;
        int[] iArr14 = i42 != 0 ? new int[i35] : iArr7;
        int i43 = i42 != 0 ? i41 : i40;
        int[] iArr15 = i42 != 0 ? new int[i35] : iArr2;
        long[] jArr12 = new long[i35];
        int i44 = i43;
        int i45 = i41;
        long j14 = j;
        while (i41 < track.editListDurations.length) {
            long j15 = track.editListMediaTimes[i41];
            int i46 = i42;
            int i47 = iArr12[i41];
            long[] jArr13 = jArr;
            int i48 = iArr13[i41];
            long[] jArr14 = jArr12;
            if (i46 != 0) {
                int i49 = i48 - i47;
                System.arraycopy(jArr2, i47, jArr11, i45, i49);
                System.arraycopy(iArr7, i47, iArr14, i45, i49);
                System.arraycopy(iArr2, i47, iArr15, i45, i49);
            }
            while (i47 < i48) {
                long[] jArr15 = jArr2;
                int[] iArr16 = iArr7;
                long scaleLargeTimestamp6 = Util.scaleLargeTimestamp(j14, 1000000L, track.movieTimescale);
                long scaleLargeTimestamp7 = Util.scaleLargeTimestamp(jArr13[i47] - j15, 1000000L, track.timescale);
                int i50 = i47;
                if (canTrimSamplesWithTimestampChange(track.type)) {
                    jArr3 = jArr11;
                    i9 = i48;
                    j3 = j;
                    scaleLargeTimestamp7 = Math.max(j3, scaleLargeTimestamp7);
                } else {
                    jArr3 = jArr11;
                    i9 = i48;
                    j3 = j;
                }
                jArr14[i45] = scaleLargeTimestamp6 + scaleLargeTimestamp7;
                if (i46 != 0 && iArr14[i45] > i44) {
                    i44 = iArr16[i50];
                }
                i45++;
                j = j3;
                iArr7 = iArr16;
                i48 = i9;
                jArr11 = jArr3;
                i47 = i50 + 1;
                jArr2 = jArr15;
            }
            j14 += track.editListDurations[i41];
            i41++;
            jArr2 = jArr2;
            jArr = jArr13;
            jArr12 = jArr14;
            iArr7 = iArr7;
            jArr11 = jArr11;
            i42 = i46;
        }
        return new TrackSampleTable(track, jArr11, iArr14, i44, jArr12, iArr15, Util.scaleLargeTimestamp(j14, 1000000L, track.movieTimescale));
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short readShort = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String readString = parsableByteArray.readString(readShort);
        int max = Math.max(readString.lastIndexOf(43), readString.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(readString.substring(0, max)), Float.parseFloat(readString.substring(max, readString.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static Metadata parseSmta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1935766900) {
                if (readInt < 14) {
                    return null;
                }
                parsableByteArray.skipBytes(5);
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if (readUnsignedByte != 12 && readUnsignedByte != 13) {
                    return null;
                }
                float f = readUnsignedByte == 12 ? 240.0f : 120.0f;
                parsableByteArray.skipBytes(1);
                return new Metadata(new SmtaMetadataEntry(f, parsableByteArray.readUnsignedByte()));
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i = parseFullAtomVersion == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i3 < i) {
                if (parsableByteArray.getData()[position + i3] != -1) {
                    long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (readUnsignedInt != 0) {
                        j = readUnsignedInt;
                    }
                } else {
                    i3++;
                }
            } else {
                parsableByteArray.skipBytes(i);
                break;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = 180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 4 : 8);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        int i3 = 0;
        while (i3 < readInt) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt2 > 0, "childAtomSize must be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1831958048 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1211250227 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                StsdData stsdData2 = stsdData;
                int i4 = i3;
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData2, i4);
                stsdData = stsdData2;
                i3 = i4;
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1835823201 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1685353336 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 1953984371 || readInt3 == 778924082 || readInt3 == 778924083 || readInt3 == 1835557169 || readInt3 == 1835560241 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                StsdData stsdData3 = stsdData;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData3, i3);
                stsdData = stsdData3;
            } else if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
            } else if (readInt3 == 1835365492) {
                parseMetaDataSampleEntry(parsableByteArray, readInt3, position, i, stsdData);
            } else if (readInt3 == 1667329389) {
                stsdData.format = new Format.Builder().setId(i).setSampleMimeType("application/x-camera-motion").build();
            }
            parsableByteArray.setPosition(position + readInt2);
            i3++;
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = "application/ttml+xml";
        ImmutableList immutableList = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableList = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableList).build();
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str;
        DrmInitData drmInitData2;
        int i7;
        int i8;
        String str2;
        float f;
        List<byte[]> list;
        int i9;
        int i10;
        String str3;
        int i11;
        int i12;
        int i13;
        String str4;
        int i14 = i2;
        int i15 = i3;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i14 + 16);
        parsableByteArray.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int i16 = i;
        if (i16 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i14, i15);
            if (parseSampleEntryEncryptionData != null) {
                i16 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str5 = "video/3gpp";
        if (i16 != 1831958048) {
            str = i16 == 1211250227 ? "video/3gpp" : null;
        } else {
            str = "video/mpeg";
        }
        float f2 = 1.0f;
        String str6 = null;
        List<byte[]> list2 = null;
        byte[] bArr = null;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        ByteBuffer byteBuffer = null;
        EsdsData esdsData = null;
        boolean z = false;
        while (position - i14 < i15) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (readInt == 0 && parsableByteArray.getPosition() - i2 == i15) {
                break;
            }
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list2 = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f2 = parse.pixelWidthHeightRatio;
                }
                str6 = parse.codecs;
                i11 = parse.colorSpace;
                i12 = parse.colorRange;
                i13 = parse.colorTransfer;
                str4 = "video/avc";
            } else if (readInt2 == 1752589123) {
                ExtractorUtil.checkContainerInput(str == null, null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list2 = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                if (!z) {
                    f2 = parse2.pixelWidthHeightRatio;
                }
                str6 = parse2.codecs;
                i11 = parse2.colorSpace;
                i12 = parse2.colorRange;
                i13 = parse2.colorTransfer;
                str4 = "video/hevc";
            } else {
                if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                    drmInitData2 = drmInitData3;
                    i7 = position;
                    i8 = i16;
                    str2 = str5;
                    f = f2;
                    list = list2;
                    i9 = i18;
                    i10 = i20;
                    DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray);
                    if (parse3 != null) {
                        str6 = parse3.codecs;
                        str = "video/dolby-vision";
                    }
                } else {
                    i7 = position;
                    if (readInt2 == 1987076931) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        str3 = i16 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        parsableByteArray.setPosition(position2 + 12);
                        parsableByteArray.skipBytes(2);
                        boolean z2 = (parsableByteArray.readUnsignedByte() & 1) != 0;
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                        i18 = ColorInfo.isoColorPrimariesToColorSpace(readUnsignedByte);
                        i19 = z2 ? 1 : 2;
                        i20 = ColorInfo.isoTransferCharacteristicsToColorTransfer(readUnsignedByte2);
                    } else if (readInt2 == 1635135811) {
                        ExtractorUtil.checkContainerInput(str == null, null);
                        str3 = "video/av01";
                    } else if (readInt2 == 1668050025) {
                        if (byteBuffer == null) {
                            byteBuffer = allocateHdrStaticInfo();
                        }
                        ByteBuffer byteBuffer2 = byteBuffer;
                        byteBuffer2.position(21);
                        byteBuffer2.putShort(parsableByteArray.readShort());
                        byteBuffer2.putShort(parsableByteArray.readShort());
                        byteBuffer = byteBuffer2;
                        drmInitData2 = drmInitData3;
                        i8 = i16;
                        str2 = str5;
                        position = i7 + readInt;
                        i14 = i2;
                        i15 = i3;
                        stsdData2 = stsdData;
                        i16 = i8;
                        str5 = str2;
                        drmInitData3 = drmInitData2;
                    } else if (readInt2 == 1835295606) {
                        if (byteBuffer == null) {
                            byteBuffer = allocateHdrStaticInfo();
                        }
                        ByteBuffer byteBuffer3 = byteBuffer;
                        short readShort = parsableByteArray.readShort();
                        short readShort2 = parsableByteArray.readShort();
                        short readShort3 = parsableByteArray.readShort();
                        i8 = i16;
                        short readShort4 = parsableByteArray.readShort();
                        str2 = str5;
                        short readShort5 = parsableByteArray.readShort();
                        short readShort6 = parsableByteArray.readShort();
                        drmInitData2 = drmInitData3;
                        short readShort7 = parsableByteArray.readShort();
                        List<byte[]> list3 = list2;
                        short readShort8 = parsableByteArray.readShort();
                        long readUnsignedInt = parsableByteArray.readUnsignedInt();
                        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                        byteBuffer3.position(1);
                        byteBuffer3.putShort(readShort5);
                        byteBuffer3.putShort(readShort6);
                        byteBuffer3.putShort(readShort);
                        byteBuffer3.putShort(readShort2);
                        byteBuffer3.putShort(readShort3);
                        byteBuffer3.putShort(readShort4);
                        byteBuffer3.putShort(readShort7);
                        byteBuffer3.putShort(readShort8);
                        byteBuffer3.putShort((short) (readUnsignedInt / 10000));
                        byteBuffer3.putShort((short) (readUnsignedInt2 / 10000));
                        byteBuffer = byteBuffer3;
                        list2 = list3;
                        f2 = f2;
                        position = i7 + readInt;
                        i14 = i2;
                        i15 = i3;
                        stsdData2 = stsdData;
                        i16 = i8;
                        str5 = str2;
                        drmInitData3 = drmInitData2;
                    } else {
                        drmInitData2 = drmInitData3;
                        i8 = i16;
                        str2 = str5;
                        f = f2;
                        list = list2;
                        if (readInt2 == 1681012275) {
                            ExtractorUtil.checkContainerInput(str == null, null);
                            str = str2;
                        } else if (readInt2 == 1702061171) {
                            ExtractorUtil.checkContainerInput(str == null, null);
                            esdsData = parseEsdsFromParent(parsableByteArray, position2);
                            String str7 = esdsData.mimeType;
                            byte[] bArr2 = esdsData.initializationData;
                            list2 = bArr2 != null ? ImmutableList.of(bArr2) : list;
                            str = str7;
                            f2 = f;
                            position = i7 + readInt;
                            i14 = i2;
                            i15 = i3;
                            stsdData2 = stsdData;
                            i16 = i8;
                            str5 = str2;
                            drmInitData3 = drmInitData2;
                        } else if (readInt2 == 1885434736) {
                            f2 = parsePaspFromParent(parsableByteArray, position2);
                            list2 = list;
                            z = true;
                            position = i7 + readInt;
                            i14 = i2;
                            i15 = i3;
                            stsdData2 = stsdData;
                            i16 = i8;
                            str5 = str2;
                            drmInitData3 = drmInitData2;
                        } else if (readInt2 == 1937126244) {
                            bArr = parseProjFromParent(parsableByteArray, position2, readInt);
                        } else if (readInt2 == 1936995172) {
                            int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                            parsableByteArray.skipBytes(3);
                            if (readUnsignedByte3 == 0) {
                                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                                if (readUnsignedByte4 == 0) {
                                    i17 = 0;
                                } else if (readUnsignedByte4 == 1) {
                                    i17 = 1;
                                } else if (readUnsignedByte4 == 2) {
                                    i17 = 2;
                                } else if (readUnsignedByte4 == 3) {
                                    i17 = 3;
                                }
                            }
                        } else {
                            i9 = i18;
                            if (readInt2 == 1668246642) {
                                i10 = i20;
                                if (i9 == -1 && i10 == -1) {
                                    int readInt3 = parsableByteArray.readInt();
                                    if (readInt3 == TYPE_nclx || readInt3 == TYPE_nclc) {
                                        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                                        int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                                        parsableByteArray.skipBytes(2);
                                        boolean z3 = readInt == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                        i18 = ColorInfo.isoColorPrimariesToColorSpace(readUnsignedShort3);
                                        i19 = z3 ? 1 : 2;
                                        i20 = ColorInfo.isoTransferCharacteristicsToColorTransfer(readUnsignedShort4);
                                    } else {
                                        Log.w(TAG, "Unsupported color type: " + Atom.getAtomTypeString(readInt3));
                                    }
                                }
                            } else {
                                i10 = i20;
                            }
                        }
                        list2 = list;
                        f2 = f;
                        position = i7 + readInt;
                        i14 = i2;
                        i15 = i3;
                        stsdData2 = stsdData;
                        i16 = i8;
                        str5 = str2;
                        drmInitData3 = drmInitData2;
                    }
                    str = str3;
                    drmInitData2 = drmInitData3;
                    i8 = i16;
                    str2 = str5;
                    position = i7 + readInt;
                    i14 = i2;
                    i15 = i3;
                    stsdData2 = stsdData;
                    i16 = i8;
                    str5 = str2;
                    drmInitData3 = drmInitData2;
                }
                i20 = i10;
                i18 = i9;
                list2 = list;
                f2 = f;
                position = i7 + readInt;
                i14 = i2;
                i15 = i3;
                stsdData2 = stsdData;
                i16 = i8;
                str5 = str2;
                drmInitData3 = drmInitData2;
            }
            i20 = i13;
            i18 = i11;
            drmInitData2 = drmInitData3;
            i7 = position;
            i19 = i12;
            i8 = i16;
            str2 = str5;
            str = str4;
            position = i7 + readInt;
            i14 = i2;
            i15 = i3;
            stsdData2 = stsdData;
            i16 = i8;
            str5 = str2;
            drmInitData3 = drmInitData2;
        }
        DrmInitData drmInitData4 = drmInitData3;
        float f3 = f2;
        List<byte[]> list4 = list2;
        int i21 = i18;
        int i22 = i20;
        if (str == null) {
            return;
        }
        Format.Builder drmInitData5 = new Format.Builder().setId(i4).setSampleMimeType(str).setCodecs(str6).setWidth(readUnsignedShort).setHeight(readUnsignedShort2).setPixelWidthHeightRatio(f3).setRotationDegrees(i5).setProjectionData(bArr).setStereoMode(i17).setInitializationData(list4).setDrmInitData(drmInitData4);
        int i23 = i19;
        if (i21 != -1 || i23 != -1 || i22 != -1 || byteBuffer != null) {
            drmInitData5.setColorInfo(new ColorInfo(i21, i23, i22, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (esdsData != null) {
            drmInitData5.setAverageBitrate(Ints.saturatedCast(esdsData.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsData.peakBitrate));
        }
        stsdData.format = drmInitData5.build();
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (readNullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(readNullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(1701606260);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        for (int i = 0; i < readUnsignedIntToInt; i++) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int i6;
        int readUnsignedFixedPoint1616;
        int readInt;
        int i7;
        String str2;
        String str3;
        int i8;
        boolean z2;
        int i9 = i2;
        int i10 = i3;
        DrmInitData drmInitData2 = drmInitData;
        parsableByteArray.setPosition(i9 + 16);
        if (z) {
            i6 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            readInt = parsableByteArray.readInt();
            if (i6 == 1) {
                parsableByteArray.skipBytes(16);
            }
            i7 = readUnsignedShort;
        } else {
            if (i6 != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            readUnsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            i7 = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(20);
            readInt = 0;
        }
        int position = parsableByteArray.getPosition();
        int i11 = i;
        if (i11 == 1701733217) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i9, i10);
            if (parseSampleEntryEncryptionData != null) {
                i11 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        if (i11 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i11 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i11 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i11 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i11 == 1685353320 || i11 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i11 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i11 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i11 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i11 == 1935767394) {
            str2 = "audio/amr-wb";
        } else {
            str3 = "audio/raw";
            if (i11 == 1819304813 || i11 == 1936684916) {
                i8 = 2;
            } else if (i11 == 1953984371) {
                i8 = 268435456;
            } else if (i11 == 778924082 || i11 == 778924083) {
                str2 = "audio/mpeg";
            } else if (i11 == 1835557169) {
                str2 = "audio/mha1";
            } else if (i11 == 1835560241) {
                str2 = "audio/mhm1";
            } else if (i11 == 1634492771) {
                str2 = "audio/alac";
            } else if (i11 == 1634492791) {
                str2 = "audio/g711-alaw";
            } else if (i11 == 1970037111) {
                str2 = "audio/g711-mlaw";
            } else if (i11 == 1332770163) {
                str2 = "audio/opus";
            } else if (i11 == 1716281667) {
                str2 = "audio/flac";
            } else if (i11 == 1835823201) {
                str2 = "audio/true-hd";
            } else {
                i8 = -1;
                str3 = null;
            }
            String str4 = str3;
            EsdsData esdsData = null;
            String str5 = null;
            List<byte[]> list = null;
            while (position - i9 < i10) {
                parsableByteArray.setPosition(position);
                int readInt2 = parsableByteArray.readInt();
                ExtractorUtil.checkContainerInput(readInt2 > 0, "childAtomSize must be positive");
                int readInt3 = parsableByteArray.readInt();
                if (readInt3 == 1835557187) {
                    int i12 = readInt2 - 13;
                    byte[] bArr = new byte[i12];
                    parsableByteArray.setPosition(position + 13);
                    parsableByteArray.readBytes(bArr, 0, i12);
                    list = ImmutableList.of(bArr);
                } else {
                    if (readInt3 == 1702061171 || (z && readInt3 == 2002876005)) {
                        int findBoxPosition = readInt3 == 1702061171 ? position : findBoxPosition(parsableByteArray, 1702061171, position, readInt2);
                        if (findBoxPosition != -1) {
                            esdsData = parseEsdsFromParent(parsableByteArray, findBoxPosition);
                            str4 = esdsData.mimeType;
                            byte[] bArr2 = esdsData.initializationData;
                            if (bArr2 != null) {
                                if ("audio/mp4a-latm".equals(str4)) {
                                    AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr2);
                                    readUnsignedFixedPoint1616 = parseAudioSpecificConfig.sampleRateHz;
                                    i7 = parseAudioSpecificConfig.channelCount;
                                    str5 = parseAudioSpecificConfig.codecs;
                                }
                                list = ImmutableList.of(bArr2);
                            }
                        }
                    } else {
                        if (readInt3 == 1684103987) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData2);
                        } else if (readInt3 == 1684366131) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitData2);
                        } else if (readInt3 == 1684103988) {
                            parsableByteArray.setPosition(position + 8);
                            stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitData2);
                        } else if (readInt3 == 1684892784) {
                            if (readInt <= 0) {
                                throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + readInt, null);
                            }
                            readUnsignedFixedPoint1616 = readInt;
                            i7 = 2;
                        } else if (readInt3 == 1684305011 || readInt3 == 1969517683) {
                            z2 = false;
                            stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str4).setChannelCount(i7).setSampleRate(readUnsignedFixedPoint1616).setDrmInitData(drmInitData2).setLanguage(str).build();
                        } else if (readInt3 == 1682927731) {
                            int i13 = readInt2 - 8;
                            byte[] bArr3 = opusMagic;
                            byte[] copyOf = Arrays.copyOf(bArr3, bArr3.length + i13);
                            parsableByteArray.setPosition(position + 8);
                            parsableByteArray.readBytes(copyOf, bArr3.length, i13);
                            list = OpusUtil.buildInitializationData(copyOf);
                        } else if (readInt3 == 1684425825) {
                            byte[] bArr4 = new byte[readInt2 - 8];
                            bArr4[0] = 102;
                            bArr4[1] = 76;
                            bArr4[2] = 97;
                            bArr4[3] = 67;
                            parsableByteArray.setPosition(position + 12);
                            parsableByteArray.readBytes(bArr4, 4, readInt2 - 12);
                            list = ImmutableList.of(bArr4);
                        } else if (readInt3 == 1634492771) {
                            int i14 = readInt2 - 12;
                            byte[] bArr5 = new byte[i14];
                            parsableByteArray.setPosition(position + 12);
                            parsableByteArray.readBytes(bArr5, 0, i14);
                            Pair<Integer, Integer> parseAlacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr5);
                            int intValue = ((Integer) parseAlacAudioSpecificConfig.first).intValue();
                            int intValue2 = ((Integer) parseAlacAudioSpecificConfig.second).intValue();
                            list = ImmutableList.of(bArr5);
                            readUnsignedFixedPoint1616 = intValue;
                            i7 = intValue2;
                        } else {
                            z2 = false;
                        }
                        z2 = false;
                    }
                    position += readInt2;
                    i9 = i2;
                    i10 = i3;
                }
                position += readInt2;
                i9 = i2;
                i10 = i3;
            }
            if (stsdData.format == null || str4 == null) {
            }
            Format.Builder language = new Format.Builder().setId(i4).setSampleMimeType(str4).setCodecs(str5).setChannelCount(i7).setSampleRate(readUnsignedFixedPoint1616).setPcmEncoding(i8).setInitializationData(list).setDrmInitData(drmInitData2).setLanguage(str);
            if (esdsData != null) {
                language.setAverageBitrate(Ints.saturatedCast(esdsData.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsData.peakBitrate));
            }
            stsdData.format = language.build();
            return;
        }
        str3 = str2;
        i8 = -1;
        String str42 = str3;
        EsdsData esdsData2 = null;
        String str52 = null;
        List<byte[]> list2 = null;
        while (position - i9 < i10) {
        }
        if (stsdData.format == null) {
        }
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        long j = readUnsignedInt2;
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        if (j <= 0) {
            j = -1;
        }
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, j, readUnsignedInt > 0 ? readUnsignedInt : -1L);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String str = null;
        Integer num = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(num != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
        ExtractorUtil.checkContainerInput(parseSchiFromParent != null, "tenc atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Util.castNonNull(parseSchiFromParent));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & 240) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long readUnsignedInt;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                readUnsignedInt = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                readUnsignedInt = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = readUnsignedInt;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    private static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if ("audio/raw".equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (readUnsignedIntToInt == 0 || readUnsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(AtomParsers.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + readUnsignedIntToInt);
                    readUnsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = readUnsignedIntToInt == 0 ? -1 : readUnsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.google.android.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int readUnsignedByte = this.data.readUnsignedByte();
                this.currentByte = readUnsignedByte;
                return (readUnsignedByte & 240) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}

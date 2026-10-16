package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.adjust.sdk.Constants;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.audio.Ac3Util;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.GaplessInfoHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.CodecSpecificDataUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.mbridge.msdk.playercommon.exoplayer2.video.AvcConfig;
import com.mbridge.msdk.playercommon.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 3;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_text = Util.getIntegerCodeForString("text");
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_meta = Util.getIntegerCodeForString(Constants.REFERRER_API_META);

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

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
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

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
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

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fixedSampleSize = parsableByteArray.readUnsignedIntToInt();
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == 0 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
        public boolean isFixedSampleSize() {
            return false;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.AtomParsers.SampleSizeBox
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
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            int readUnsignedByte = this.data.readUnsignedByte();
            this.currentByte = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
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

    public static final class UnhandledEditListException extends ParserException {
    }

    private AtomParsers() {
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(3, 0, length)] && jArr[Util.constrainValue(jArr.length - 3, 0, length)] < j3 && j3 <= j;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int i6;
        int readUnsignedFixedPoint1616;
        int i7;
        int i8;
        DrmInitData drmInitData2;
        int i9;
        String str2;
        int i10;
        boolean z2;
        int i11;
        int i12 = i2;
        int i13 = i3;
        String str3 = str;
        DrmInitData drmInitData3 = drmInitData;
        parsableByteArray.setPosition(i12 + 16);
        if (z) {
            i6 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            i6 = 0;
        }
        int i14 = 2;
        boolean z3 = true;
        if (i6 == 0 || i6 == 1) {
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            readUnsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
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
        }
        int position = parsableByteArray.getPosition();
        int i15 = i;
        if (i15 == Atom.TYPE_enca) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i12, i13);
            if (parseSampleEntryEncryptionData != null) {
                i15 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData4 = drmInitData3;
        String str4 = "audio/raw";
        int i16 = readUnsignedFixedPoint1616;
        String str5 = i15 == Atom.TYPE_ac_3 ? "audio/ac3" : i15 == Atom.TYPE_ec_3 ? "audio/eac3" : i15 == Atom.TYPE_dtsc ? "audio/vnd.dts" : (i15 == Atom.TYPE_dtsh || i15 == Atom.TYPE_dtsl) ? "audio/vnd.dts.hd" : i15 == Atom.TYPE_dtse ? "audio/vnd.dts.hd;profile=lbr" : i15 == Atom.TYPE_samr ? "audio/3gpp" : i15 == Atom.TYPE_sawb ? "audio/amr-wb" : (i15 == Atom.TYPE_lpcm || i15 == Atom.TYPE_sowt) ? "audio/raw" : i15 == Atom.TYPE__mp3 ? "audio/mpeg" : i15 == Atom.TYPE_alac ? "audio/alac" : null;
        int i17 = i16;
        int i18 = i7;
        int i19 = position;
        byte[] bArr = null;
        while (i19 - i12 < i13) {
            parsableByteArray.setPosition(i19);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0 ? z3 : false, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            int i20 = Atom.TYPE_esds;
            if (readInt2 == i20 || (z && readInt2 == Atom.TYPE_wave)) {
                i8 = i19;
                drmInitData2 = drmInitData4;
                i9 = readInt;
                str2 = str4;
                i10 = 2;
                z2 = true;
                i11 = i17;
                int findEsdsPosition = readInt2 == i20 ? i8 : findEsdsPosition(parsableByteArray, i8, i9);
                if (findEsdsPosition != -1) {
                    Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, findEsdsPosition);
                    str5 = (String) parseEsdsFromParent.first;
                    bArr = (byte[]) parseEsdsFromParent.second;
                    if ("audio/mp4a-latm".equals(str5)) {
                        Pair<Integer, Integer> parseAacAudioSpecificConfig = CodecSpecificDataUtil.parseAacAudioSpecificConfig(bArr);
                        int intValue = ((Integer) parseAacAudioSpecificConfig.first).intValue();
                        i18 = ((Integer) parseAacAudioSpecificConfig.second).intValue();
                        i17 = intValue;
                        i19 = i9 + i8;
                        str4 = str2;
                        drmInitData4 = drmInitData2;
                        i14 = i10;
                        z3 = z2;
                        i12 = i2;
                        i13 = i3;
                        str3 = str;
                    }
                }
            } else {
                if (readInt2 == Atom.TYPE_dac3) {
                    parsableByteArray.setPosition(i19 + 8);
                    stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str3, drmInitData4);
                } else if (readInt2 == Atom.TYPE_dec3) {
                    parsableByteArray.setPosition(i19 + 8);
                    stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str3, drmInitData4);
                } else if (readInt2 == Atom.TYPE_ddts) {
                    drmInitData2 = drmInitData4;
                    i11 = i17;
                    i8 = i19;
                    i9 = readInt;
                    str2 = str4;
                    i10 = 2;
                    z2 = true;
                    stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str5, null, -1, -1, i18, i11, null, drmInitData2, 0, str);
                } else {
                    i8 = i19;
                    drmInitData2 = drmInitData4;
                    i9 = readInt;
                    str2 = str4;
                    i10 = 2;
                    z2 = true;
                    i11 = i17;
                    if (readInt2 == Atom.TYPE_alac) {
                        byte[] bArr2 = new byte[i9];
                        parsableByteArray.setPosition(i8);
                        parsableByteArray.readBytes(bArr2, 0, i9);
                        bArr = bArr2;
                    }
                }
                i8 = i19;
                drmInitData2 = drmInitData4;
                i9 = readInt;
                str2 = str4;
                i10 = 2;
                z2 = true;
                i11 = i17;
            }
            i17 = i11;
            i19 = i9 + i8;
            str4 = str2;
            drmInitData4 = drmInitData2;
            i14 = i10;
            z3 = z2;
            i12 = i2;
            i13 = i3;
            str3 = str;
        }
        int i21 = i14;
        DrmInitData drmInitData5 = drmInitData4;
        String str6 = str4;
        int i22 = i17;
        if (stsdData.format != null || str5 == null) {
            return;
        }
        stsdData.format = Format.createAudioSampleFormat(Integer.toString(i4), str5, null, -1, -1, i18, i22, str6.equals(str5) ? i21 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitData5, 0, str);
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String str = null;
        Integer num = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == Atom.TYPE_schi) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        Assertions.checkArgument(num != null, "frma atom is mandatory");
        Assertions.checkArgument(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
        Assertions.checkArgument(parseSchiFromParent != null, "tenc atom is mandatory");
        return Pair.create(num, parseSchiFromParent);
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create(null, null);
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

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts".equals(mimeTypeFromMp4ObjectType) || "audio/vnd.dts.hd".equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
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

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        int readInt = parsableByteArray.readInt();
        if (readInt == TYPE_soun) {
            return 1;
        }
        if (readInt == TYPE_vide) {
            return 2;
        }
        if (readInt == TYPE_text || readInt == TYPE_sbtl || readInt == TYPE_subt || readInt == TYPE_clcp) {
            return 3;
        }
        return readInt == TYPE_meta ? 4 : -1;
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

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 4 : 8);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static Metadata parseMetaAtom(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        parsableByteArray.skipBytes(Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0 ? 16 : 8);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
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
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:197:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0231  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        long j;
        int i8;
        long scaleLargeTimestamp;
        Track track2;
        long[] jArr3;
        long[] jArr4;
        int i9;
        long j2;
        int i10;
        int i11;
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_co64);
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = containerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsableByteArray3 = containerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = null;
        ParsableByteArray parsableByteArray5 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray6 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray6 != null) {
            parsableByteArray6.setPosition(12);
            i = parsableByteArray6.readUnsignedIntToInt();
        } else {
            i = 0;
        }
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            i2 = parsableByteArray5.readUnsignedIntToInt();
            r16 = i2 > 0 ? parsableByteArray5.readUnsignedIntToInt() - 1 : -1;
            if (stz2SampleSizeBox.isFixedSampleSize()) {
                i3 = 0;
            } else {
                i3 = 0;
                if ("audio/raw".equals(track.format.sampleMimeType) && readUnsignedIntToInt == 0 && i == 0 && i2 == 0) {
                    i4 = 1;
                    String str = TAG;
                    if (i4 == 0) {
                        long[] jArr5 = new long[sampleCount];
                        i6 = 1;
                        int[] iArr3 = new int[sampleCount];
                        ParsableByteArray parsableByteArray7 = parsableByteArray6;
                        long[] jArr6 = new long[sampleCount];
                        int[] iArr4 = new int[sampleCount];
                        int i12 = r16;
                        SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                        int i13 = i3;
                        int i14 = i13;
                        int i15 = i14;
                        i7 = i15;
                        int i16 = i7;
                        long j3 = 0;
                        long j4 = 0;
                        while (i13 < sampleCount) {
                            while (i15 == 0) {
                                Assertions.checkState(chunkIterator.moveNext());
                                long j5 = chunkIterator.offset;
                                i15 = chunkIterator.numSamples;
                                j4 = j5;
                                sampleCount = sampleCount;
                            }
                            int i17 = sampleCount;
                            if (parsableByteArray7 != null) {
                                while (i16 == 0 && i > 0) {
                                    i16 = parsableByteArray7.readUnsignedIntToInt();
                                    i14 = parsableByteArray7.readInt();
                                    i--;
                                }
                                i16--;
                            }
                            jArr5[i13] = j4;
                            int readNextSampleSize = sampleSizeBox.readNextSampleSize();
                            iArr3[i13] = readNextSampleSize;
                            if (readNextSampleSize > i7) {
                                i7 = readNextSampleSize;
                            }
                            jArr6[i13] = j3 + i14;
                            iArr4[i13] = parsableByteArray4 == null ? 1 : i3;
                            if (i13 == i12) {
                                iArr4[i13] = 1;
                                i2--;
                                if (i2 > 0) {
                                    i12 = parsableByteArray4.readUnsignedIntToInt() - 1;
                                }
                            }
                            j3 += readUnsignedIntToInt3;
                            readUnsignedIntToInt2--;
                            if (readUnsignedIntToInt2 == 0 && readUnsignedIntToInt > 0) {
                                readUnsignedIntToInt--;
                                readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
                                readUnsignedIntToInt3 = parsableByteArray3.readInt();
                            }
                            j4 += iArr3[i13];
                            i15--;
                            i13++;
                            sampleCount = i17;
                        }
                        i5 = sampleCount;
                        long j6 = j3 + i14;
                        Assertions.checkArgument(i16 == 0 ? 1 : i3);
                        while (i > 0) {
                            Assertions.checkArgument(parsableByteArray7.readUnsignedIntToInt() == 0 ? 1 : i3);
                            parsableByteArray7.readInt();
                            i--;
                        }
                        if (i2 != 0 || readUnsignedIntToInt2 != 0 || i15 != 0 || readUnsignedIntToInt != 0) {
                            Log.w(TAG, "Inconsistent stbl box for track " + track.id + ": remainingSynchronizationSamples " + i2 + ", remainingSamplesAtTimestampDelta " + readUnsignedIntToInt2 + ", remainingSamplesInChunk " + i15 + ", remainingTimestampDeltaChanges " + readUnsignedIntToInt);
                        }
                        iArr = iArr4;
                        jArr = jArr6;
                        jArr2 = jArr5;
                        iArr2 = iArr3;
                        j = j6;
                    } else {
                        i5 = sampleCount;
                        i6 = 1;
                        int i18 = chunkIterator.length;
                        long[] jArr7 = new long[i18];
                        int[] iArr5 = new int[i18];
                        while (chunkIterator.moveNext()) {
                            int i19 = chunkIterator.index;
                            jArr7[i19] = chunkIterator.offset;
                            iArr5[i19] = chunkIterator.numSamples;
                        }
                        Format format = track.format;
                        FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(format.pcmEncoding, format.channelCount), jArr7, iArr5, readUnsignedIntToInt3);
                        long[] jArr8 = rechunk.offsets;
                        int[] iArr6 = rechunk.sizes;
                        i7 = rechunk.maximumSize;
                        long[] jArr9 = rechunk.timestamps;
                        int[] iArr7 = rechunk.flags;
                        long j7 = rechunk.duration;
                        jArr = jArr9;
                        iArr = iArr7;
                        jArr2 = jArr8;
                        iArr2 = iArr6;
                        j = j7;
                    }
                    i8 = i7;
                    scaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track.timescale);
                    if (track.editListDurations != null || gaplessInfoHolder.hasGaplessInfo()) {
                        long[] jArr10 = jArr;
                        Util.scaleLargeTimestampsInPlace(jArr10, 1000000L, track.timescale);
                        return new TrackSampleTable(track, jArr2, iArr2, i8, jArr10, iArr, scaleLargeTimestamp);
                    }
                    long[] jArr11 = track.editListDurations;
                    int i20 = i6;
                    if (jArr11.length == i20 && track.type == i20 && jArr.length >= 2) {
                        long j8 = track.editListMediaTimes[i3];
                        long scaleLargeTimestamp2 = j8 + Util.scaleLargeTimestamp(jArr11[i3], track.timescale, track.movieTimescale);
                        long j9 = j;
                        long[] jArr12 = jArr;
                        boolean canApplyEditWithGaplessInfo = canApplyEditWithGaplessInfo(jArr12, j9, j8, scaleLargeTimestamp2);
                        j = j9;
                        if (canApplyEditWithGaplessInfo) {
                            long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j8 - jArr12[i3], track.format.sampleRate, track.timescale);
                            long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(j - scaleLargeTimestamp2, track.format.sampleRate, track.timescale);
                            if ((scaleLargeTimestamp3 != 0 || scaleLargeTimestamp4 != 0) && scaleLargeTimestamp3 <= 2147483647L && scaleLargeTimestamp4 <= 2147483647L) {
                                gaplessInfoHolder.encoderDelay = (int) scaleLargeTimestamp3;
                                gaplessInfoHolder.encoderPadding = (int) scaleLargeTimestamp4;
                                Util.scaleLargeTimestampsInPlace(jArr12, 1000000L, track.timescale);
                                return new TrackSampleTable(track, jArr2, iArr2, i8, jArr12, iArr, scaleLargeTimestamp);
                            }
                        }
                        jArr3 = jArr12;
                        track2 = track;
                    } else {
                        track2 = track;
                        jArr3 = jArr;
                    }
                    long[] jArr13 = track2.editListDurations;
                    if (jArr13.length == 1 && jArr13[i3] == 0) {
                        long j10 = track2.editListMediaTimes[i3];
                        for (int i21 = i3; i21 < jArr3.length; i21++) {
                            jArr3[i21] = Util.scaleLargeTimestamp(jArr3[i21] - j10, 1000000L, track2.timescale);
                        }
                        return new TrackSampleTable(track2, jArr2, iArr2, i8, jArr3, iArr, Util.scaleLargeTimestamp(j - j10, 1000000L, track2.timescale));
                    }
                    boolean z2 = track2.type == 1 ? 1 : i3;
                    int i22 = i3;
                    int i23 = i22;
                    int i24 = i23;
                    int i25 = i24;
                    while (true) {
                        long[] jArr14 = track2.editListDurations;
                        if (i22 >= jArr14.length) {
                            break;
                        }
                        long j11 = track2.editListMediaTimes[i22];
                        if (j11 != -1) {
                            int i26 = i25;
                            long scaleLargeTimestamp5 = Util.scaleLargeTimestamp(jArr14[i22], track2.timescale, track2.movieTimescale);
                            i10 = i22;
                            i11 = i8;
                            int binarySearchCeil = Util.binarySearchCeil(jArr3, j11, true, true);
                            int binarySearchCeil2 = Util.binarySearchCeil(jArr3, j11 + scaleLargeTimestamp5, z2, (boolean) i3);
                            i23 += binarySearchCeil2 - binarySearchCeil;
                            int i27 = i24 != binarySearchCeil ? 1 : 0;
                            i24 = binarySearchCeil2;
                            i25 = i27 | i26;
                        } else {
                            i10 = i22;
                            i11 = i8;
                        }
                        i22 = i10 + 1;
                        i8 = i11;
                        i3 = 0;
                    }
                    int i28 = i8;
                    int i29 = (i23 != i5 ? 1 : 0) | i25;
                    long[] jArr15 = i29 != 0 ? new long[i23] : jArr2;
                    int[] iArr8 = i29 != 0 ? new int[i23] : iArr2;
                    if (i29 != 0) {
                        i28 = 0;
                    }
                    int[] iArr9 = i29 != 0 ? new int[i23] : iArr;
                    long[] jArr16 = new long[i23];
                    int i30 = i28;
                    int i31 = 0;
                    int i32 = 0;
                    long j12 = 0;
                    while (true) {
                        long[] jArr17 = track2.editListDurations;
                        int i33 = i29;
                        if (i31 >= jArr17.length) {
                            return new TrackSampleTable(track2, jArr15, iArr8, i30, jArr16, iArr9, Util.scaleLargeTimestamp(j12, 1000000L, track2.timescale));
                        }
                        int i34 = i30;
                        long j13 = track2.editListMediaTimes[i31];
                        long j14 = jArr17[i31];
                        if (j13 != -1) {
                            i9 = i31;
                            String str2 = str;
                            j2 = j14;
                            long scaleLargeTimestamp6 = Util.scaleLargeTimestamp(j14, track2.timescale, track2.movieTimescale) + j13;
                            jArr4 = jArr16;
                            int binarySearchCeil3 = Util.binarySearchCeil(jArr3, j13, true, true);
                            int binarySearchCeil4 = Util.binarySearchCeil(jArr3, scaleLargeTimestamp6, z2, false);
                            if (i33 != 0) {
                                int i35 = binarySearchCeil4 - binarySearchCeil3;
                                System.arraycopy(jArr2, binarySearchCeil3, jArr15, i32, i35);
                                System.arraycopy(iArr2, binarySearchCeil3, iArr8, i32, i35);
                                System.arraycopy(iArr, binarySearchCeil3, iArr9, i32, i35);
                            }
                            if (binarySearchCeil3 < binarySearchCeil4 && (iArr9[i32] & 1) == 0) {
                                Log.w(str2, "Ignoring edit list: edit does not start with a sync sample.");
                                throw new UnhandledEditListException();
                            }
                            str = str2;
                            int i36 = i34;
                            while (binarySearchCeil3 < binarySearchCeil4) {
                                long[] jArr18 = jArr2;
                                int[] iArr10 = iArr2;
                                jArr4[i32] = Util.scaleLargeTimestamp(j12, 1000000L, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr3[binarySearchCeil3] - j13, 1000000L, track2.timescale);
                                if (i33 != 0 && iArr8[i32] > i36) {
                                    i36 = iArr10[binarySearchCeil3];
                                }
                                i32++;
                                binarySearchCeil3++;
                                jArr2 = jArr18;
                                iArr2 = iArr10;
                            }
                            i30 = i36;
                        } else {
                            jArr4 = jArr16;
                            i9 = i31;
                            j2 = j14;
                            i30 = i34;
                        }
                        j12 += j2;
                        i31 = i9 + 1;
                        i29 = i33;
                        jArr16 = jArr4;
                        jArr2 = jArr2;
                        iArr2 = iArr2;
                    }
                }
            }
            i4 = i3;
            String str3 = TAG;
            if (i4 == 0) {
            }
            i8 = i7;
            scaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track.timescale);
            if (track.editListDurations != null) {
            }
            long[] jArr102 = jArr;
            Util.scaleLargeTimestampsInPlace(jArr102, 1000000L, track.timescale);
            return new TrackSampleTable(track, jArr2, iArr2, i8, jArr102, iArr, scaleLargeTimestamp);
        }
        i2 = 0;
        parsableByteArray4 = parsableByteArray5;
        if (stz2SampleSizeBox.isFixedSampleSize()) {
        }
        i4 = i3;
        String str32 = TAG;
        if (i4 == 0) {
        }
        i8 = i7;
        scaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, track.timescale);
        if (track.editListDurations != null) {
        }
        long[] jArr1022 = jArr;
        Util.scaleLargeTimestampsInPlace(jArr1022, 1000000L, track.timescale);
        return new TrackSampleTable(track, jArr2, iArr2, i8, jArr1022, iArr, scaleLargeTimestamp);
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        int i3 = 0;
        while (i3 < readInt) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkArgument(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == Atom.TYPE_avc1 || readInt3 == Atom.TYPE_avc3 || readInt3 == Atom.TYPE_encv || readInt3 == Atom.TYPE_mp4v || readInt3 == Atom.TYPE_hvc1 || readInt3 == Atom.TYPE_hev1 || readInt3 == Atom.TYPE_s263 || readInt3 == Atom.TYPE_vp08 || readInt3 == Atom.TYPE_vp09) {
                StsdData stsdData2 = stsdData;
                int i4 = i3;
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData2, i4);
                stsdData = stsdData2;
                i3 = i4;
            } else if (readInt3 == Atom.TYPE_mp4a || readInt3 == Atom.TYPE_enca || readInt3 == Atom.TYPE_ac_3 || readInt3 == Atom.TYPE_ec_3 || readInt3 == Atom.TYPE_dtsc || readInt3 == Atom.TYPE_dtse || readInt3 == Atom.TYPE_dtsh || readInt3 == Atom.TYPE_dtsl || readInt3 == Atom.TYPE_samr || readInt3 == Atom.TYPE_sawb || readInt3 == Atom.TYPE_lpcm || readInt3 == Atom.TYPE_sowt || readInt3 == Atom.TYPE__mp3 || readInt3 == Atom.TYPE_alac) {
                StsdData stsdData3 = stsdData;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData3, i3);
                stsdData = stsdData3;
            } else if (readInt3 == Atom.TYPE_TTML || readInt3 == Atom.TYPE_tx3g || readInt3 == Atom.TYPE_wvtt || readInt3 == Atom.TYPE_stpp || readInt3 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
            } else if (readInt3 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i), "application/x-camera-motion", null, -1, null);
            }
            parsableByteArray.setPosition(position + readInt2);
            i3++;
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) throws ParserException {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = "application/ttml+xml";
        List list = null;
        long j = Long.MAX_VALUE;
        if (i != Atom.TYPE_TTML) {
            if (i == Atom.TYPE_tx3g) {
                int i5 = i3 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == Atom.TYPE_wvtt) {
                str2 = "application/x-mp4-vtt";
            } else if (i == Atom.TYPE_stpp) {
                j = 0;
            } else {
                if (i != Atom.TYPE_c608) {
                    throw new IllegalStateException();
                }
                stsdData.requiredSampleTransformation = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        stsdData.format = Format.createTextSampleFormat(Integer.toString(i4), str2, null, -1, 0, str, -1, null, j, list);
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
            if (i3 >= i) {
                parsableByteArray.skipBytes(i);
                break;
            }
            if (parsableByteArray.data[position + i3] != -1) {
                long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                if (readUnsignedInt != 0) {
                    j = readUnsignedInt;
                }
            } else {
                i3++;
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

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
        int parseHdlr = parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data);
        if (parseHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j2 = j == -9223372036854775807L ? parseTkhd.duration : j;
        long parseMvhd = parseMvhd(leafAtom.data);
        long scaleLargeTimestamp = j2 != -9223372036854775807L ? Util.scaleLargeTimestamp(j2, 1000000L, parseMvhd) : -9223372036854775807L;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> parseEdts = parseEdts(containerAtom.getContainerAtomOfType(Atom.TYPE_edts));
            long[] jArr3 = (long[]) parseEdts.first;
            jArr2 = (long[]) parseEdts.second;
            jArr = jArr3;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, parseHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, scaleLargeTimestamp, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseMetaAtom(parsableByteArray, position + readInt);
            }
            parsableByteArray.skipBytes(readInt - 8);
        }
        return null;
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str;
        List<byte[]> list;
        DrmInitData drmInitData2 = drmInitData;
        parsableByteArray.setPosition(i2 + 16);
        parsableByteArray.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str2 = null;
        int i7 = i;
        if (i7 == Atom.TYPE_encv) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i2, i3);
            if (parseSampleEntryEncryptionData != null) {
                i7 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        DrmInitData drmInitData3 = drmInitData2;
        float f = 1.0f;
        List<byte[]> list2 = null;
        byte[] bArr = null;
        int i8 = -1;
        boolean z = false;
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (readInt == 0 && parsableByteArray.getPosition() - i2 == i3) {
                break;
            }
            int i9 = 1;
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_avcC) {
                Assertions.checkState(str2 == null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list = parse.initializationData;
                stsdData.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f = parse.pixelWidthAspectRatio;
                }
                str = "video/avc";
            } else if (readInt2 == Atom.TYPE_hvcC) {
                Assertions.checkState(str2 == null);
                parsableByteArray.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list = parse2.initializationData;
                stsdData.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str = "video/hevc";
            } else {
                if (readInt2 == Atom.TYPE_vpcC) {
                    Assertions.checkState(str2 == null);
                    str = i7 == Atom.TYPE_vp08 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (readInt2 == Atom.TYPE_d263) {
                    Assertions.checkState(str2 == null);
                    str = "video/3gpp";
                } else {
                    if (readInt2 == Atom.TYPE_esds) {
                        Assertions.checkState(str2 == null);
                        Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                        str2 = (String) parseEsdsFromParent.first;
                        list2 = Collections.singletonList((byte[]) parseEsdsFromParent.second);
                    } else if (readInt2 == Atom.TYPE_pasp) {
                        f = parsePaspFromParent(parsableByteArray, position2);
                        z = true;
                    } else if (readInt2 == Atom.TYPE_sv3d) {
                        bArr = parseProjFromParent(parsableByteArray, position2, readInt);
                    } else if (readInt2 == Atom.TYPE_st3d) {
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        parsableByteArray.skipBytes(3);
                        if (readUnsignedByte == 0) {
                            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                            if (readUnsignedByte2 != 0) {
                                if (readUnsignedByte2 != 1) {
                                    i9 = 2;
                                    if (readUnsignedByte2 != 2) {
                                        if (readUnsignedByte2 == 3) {
                                            i8 = 3;
                                        }
                                    }
                                }
                                i8 = i9;
                            } else {
                                i8 = 0;
                            }
                        }
                    }
                    position += readInt;
                }
                str2 = str;
                position += readInt;
            }
            list2 = list;
            str2 = str;
            position += readInt;
        }
        if (str2 == null) {
            return;
        }
        stsdData.format = Format.createVideoSampleFormat(Integer.toString(i4), str2, null, -1, -1, readUnsignedShort, readUnsignedShort2, -1.0f, list2, i5, f, bArr, i8, null, drmInitData3);
    }
}

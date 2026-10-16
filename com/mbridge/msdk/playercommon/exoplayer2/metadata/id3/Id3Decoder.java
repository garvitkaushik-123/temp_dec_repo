package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes6.dex */
public final class Id3Decoder implements MetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    private static final String TAG = "Id3Decoder";
    private final FramePredicate framePredicate;
    public static final FramePredicate NO_FRAMES_PREDICATE = new FramePredicate() { // from class: com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.1
        @Override // com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
        public boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return false;
        }
    };
    public static final int ID3_TAG = Util.getIntegerCodeForString("ID3");

    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    private static final class Id3Header {
        private final int framesSize;
        private final boolean isUnsynchronized;
        private final int majorVersion;

        public Id3Header(int i, boolean z, int i2) {
            this.majorVersion = i;
            this.isUnsynchronized = z;
            this.framesSize = i2;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i, int i2) {
        return i2 <= i ? new byte[0] : Arrays.copyOfRange(bArr, i, i2);
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i, int i2) throws UnsupportedEncodingException {
        int indexOfZeroByte;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.readBytes(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            indexOfZeroByte = 2;
        } else {
            indexOfZeroByte = indexOfZeroByte(bArr, 0);
            String lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"));
            str = lowerInvariant.indexOf(47) == -1 ? "image/" + lowerInvariant : lowerInvariant;
        }
        int i4 = bArr[indexOfZeroByte + 1] & 255;
        int i5 = indexOfZeroByte + 2;
        int indexOfEos = indexOfEos(bArr, i5, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i5, indexOfEos - i5, charsetName), i4, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), i3));
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) throws UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (readUnsignedInt == 4294967295L) {
            readUnsignedInt = -1;
        }
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt2 == 4294967295L ? -1L : readUnsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, readUnsignedInt, j, id3FrameArr);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate) throws UnsupportedEncodingException {
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray.data, position);
        String str = new String(parsableByteArray.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray.data, position2);
            strArr[i4] = new String(parsableByteArray.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte), charsetName));
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x01a1, code lost:
    
        if (r4 == 67) goto L137;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0209 A[Catch: UnsupportedEncodingException -> 0x022b, all -> 0x0234, TRY_LEAVE, TryCatch #0 {all -> 0x0234, blocks: (B:62:0x0209, B:123:0x022b, B:137:0x01f6, B:138:0x01fb), top: B:52:0x0112 }] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v26 */
    /* JADX WARN: Type inference failed for: r16v27 */
    /* JADX WARN: Type inference failed for: r16v28 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9, types: [com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Frame] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22, types: [com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Id3Frame decodeFrame(int i, ParsableByteArray parsableByteArray, boolean z, int i2, FramePredicate framePredicate) {
        int readUnsignedIntToInt;
        ?? r1;
        int i3;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ?? r16;
        int i6;
        int i7;
        int i8;
        int i9;
        Id3Frame decodeBinaryFrame;
        ParsableByteArray parsableByteArray2;
        Object obj;
        boolean evaluate;
        int i10 = i;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
        boolean z6 = false;
        int readUnsignedByte4 = i10 >= 3 ? parsableByteArray.readUnsignedByte() : 0;
        if (i10 == 4) {
            readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (!z) {
                readUnsignedIntToInt = (((readUnsignedIntToInt >> 24) & 255) << 21) | (readUnsignedIntToInt & 255) | (((readUnsignedIntToInt >> 8) & 255) << 7) | (((readUnsignedIntToInt >> 16) & 255) << 14);
            }
        } else {
            readUnsignedIntToInt = i10 == 3 ? parsableByteArray.readUnsignedIntToInt() : parsableByteArray.readUnsignedInt24();
        }
        int i11 = readUnsignedIntToInt;
        int readUnsignedShort = i10 >= 3 ? parsableByteArray.readUnsignedShort() : 0;
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && i11 == 0 && readUnsignedShort == 0) {
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        int position = parsableByteArray.getPosition() + i11;
        if (position > parsableByteArray.limit()) {
            Log.w(TAG, "Frame size exceeds remaining tag data");
            parsableByteArray.setPosition(parsableByteArray.limit());
            return null;
        }
        if (framePredicate != null) {
            evaluate = framePredicate.evaluate(i10, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
            i10 = i10;
            r1 = readUnsignedByte2;
            i3 = readUnsignedByte;
            i4 = readUnsignedByte3;
            i5 = readUnsignedByte4;
            if (!evaluate) {
                parsableByteArray.setPosition(position);
                return null;
            }
        } else {
            r1 = readUnsignedByte2;
            i3 = readUnsignedByte;
            i4 = readUnsignedByte3;
            i5 = readUnsignedByte4;
        }
        if (i10 == 3) {
            boolean z7 = (readUnsignedShort & 128) != 0;
            boolean z8 = (readUnsignedShort & 64) != 0;
            boolean z9 = (readUnsignedShort & 32) != 0;
            z5 = false;
            z6 = z7;
            z4 = z8 ? 1 : 0;
            z2 = z9;
            z3 = z6;
            r16 = z8;
        } else if (i10 == 4) {
            boolean z10 = (readUnsignedShort & 64) != 0;
            boolean z11 = (readUnsignedShort & 8) != 0;
            boolean z12 = (readUnsignedShort & 4) != 0;
            boolean z13 = (readUnsignedShort & 2) != 0;
            z3 = (readUnsignedShort & 1) != 0;
            z6 = z11 ? 1 : 0;
            z2 = z10;
            r16 = z11;
            z4 = z12;
            z5 = z13;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            r16 = evaluate;
        }
        if (z6 || z4) {
            Log.w(TAG, "Skipping unsupported compressed or encrypted frame");
            parsableByteArray.setPosition(position);
            return null;
        }
        if (z2) {
            i11--;
            parsableByteArray.skipBytes(1);
        }
        if (z3) {
            i11 -= 4;
            parsableByteArray.skipBytes(4);
        }
        if (z5) {
            i11 = removeUnsynchronization(parsableByteArray, i11);
        }
        try {
            try {
                try {
                    try {
                        if (i3 == 84 && r1 == 88 && i4 == 88 && (i10 == 2 || i5 == 88)) {
                            decodeBinaryFrame = decodeTxxxFrame(parsableByteArray, i11);
                        } else if (i3 == 84) {
                            decodeBinaryFrame = decodeTextInformationFrame(parsableByteArray, i11, getFrameId(i10, i3, r1, i4, i5));
                        } else if (i3 == 87 && r1 == 88 && i4 == 88 && (i10 == 2 || i5 == 88)) {
                            decodeBinaryFrame = decodeWxxxFrame(parsableByteArray, i11);
                        } else if (i3 == 87) {
                            decodeBinaryFrame = decodeUrlLinkFrame(parsableByteArray, i11, getFrameId(i10, i3, r1, i4, i5));
                        } else if (i3 == 80 && r1 == 82 && i4 == 73 && i5 == 86) {
                            decodeBinaryFrame = decodePrivFrame(parsableByteArray, i11);
                        } else {
                            r16 = 0;
                            try {
                                if (i3 != 71 || r1 != 69 || i4 != 79 || (i5 != 66 && i10 != 2)) {
                                    if (i10 == 2) {
                                        if (i3 == 80 && r1 == 73 && i4 == 67) {
                                            decodeBinaryFrame = decodeApicFrame(parsableByteArray, i11, i10);
                                        }
                                        if (i3 != 67 && r1 == 79 && i4 == 77 && (i5 == 77 || i10 == 2)) {
                                            decodeBinaryFrame = decodeCommentFrame(parsableByteArray, i11);
                                        } else if (i3 != 67 && r1 == 72 && i4 == 65 && i5 == 80) {
                                            i6 = r1;
                                            i7 = i4;
                                            i8 = i11;
                                            i9 = i5;
                                            try {
                                                decodeBinaryFrame = decodeChapterFrame(parsableByteArray, i8, i10, z, i2, framePredicate);
                                                i10 = i;
                                                r1 = parsableByteArray;
                                                r16 = r16;
                                            } catch (UnsupportedEncodingException unused) {
                                                r1 = parsableByteArray;
                                                Log.w(TAG, "Unsupported character encoding");
                                                r1.setPosition(position);
                                                return r16;
                                            } catch (Throwable th) {
                                                th = th;
                                                r1 = parsableByteArray;
                                                r1.setPosition(position);
                                                throw th;
                                            }
                                        } else {
                                            i6 = r1;
                                            i7 = i4;
                                            i8 = i11;
                                            i9 = i5;
                                            if (i3 != 67 && i6 == 84 && i7 == 79 && i9 == 67) {
                                                i10 = i;
                                                ParsableByteArray parsableByteArray3 = parsableByteArray;
                                                decodeBinaryFrame = decodeChapterTOCFrame(parsableByteArray3, i8, i10, z, i2, framePredicate);
                                                r1 = parsableByteArray3;
                                                r16 = r16;
                                            } else {
                                                i10 = i;
                                                ParsableByteArray parsableByteArray4 = parsableByteArray;
                                                decodeBinaryFrame = decodeBinaryFrame(parsableByteArray4, i8, getFrameId(i10, i3, i6, i7, i9));
                                                r1 = parsableByteArray4;
                                                r16 = r16;
                                            }
                                        }
                                    } else {
                                        if (i3 == 65) {
                                            if (r1 == 80) {
                                                if (i4 == 73) {
                                                }
                                            }
                                        }
                                        if (i3 != 67) {
                                        }
                                        if (i3 != 67) {
                                        }
                                        i6 = r1;
                                        i7 = i4;
                                        i8 = i11;
                                        i9 = i5;
                                        if (i3 != 67) {
                                        }
                                        i10 = i;
                                        ParsableByteArray parsableByteArray42 = parsableByteArray;
                                        decodeBinaryFrame = decodeBinaryFrame(parsableByteArray42, i8, getFrameId(i10, i3, i6, i7, i9));
                                        r1 = parsableByteArray42;
                                        r16 = r16;
                                    }
                                    if (decodeBinaryFrame == null) {
                                        Log.w(TAG, "Failed to decode frame: id=" + getFrameId(i10, i3, i6, i7, i9) + ", frameSize=" + i8);
                                    }
                                    r1.setPosition(position);
                                    return decodeBinaryFrame;
                                }
                                decodeBinaryFrame = decodeGeobFrame(parsableByteArray, i11);
                                i6 = r1;
                                i7 = i4;
                                parsableByteArray2 = parsableByteArray;
                                i8 = i11;
                                obj = r16;
                                i9 = i5;
                                r1 = parsableByteArray2;
                                r16 = obj;
                                if (decodeBinaryFrame == null) {
                                }
                                r1.setPosition(position);
                                return decodeBinaryFrame;
                            } catch (UnsupportedEncodingException unused2) {
                                r1 = parsableByteArray;
                            }
                        }
                        i6 = r1;
                        i7 = i4;
                        parsableByteArray2 = parsableByteArray;
                        i8 = i11;
                        obj = null;
                        i9 = i5;
                        r1 = parsableByteArray2;
                        r16 = obj;
                        if (decodeBinaryFrame == null) {
                        }
                        r1.setPosition(position);
                        return decodeBinaryFrame;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (UnsupportedEncodingException unused3) {
                    r1 = parsableByteArray;
                    r16 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                r1 = parsableByteArray;
            }
        } catch (UnsupportedEncodingException unused4) {
        }
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i3 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i3, readUnsignedByte);
        String decodeStringIfValid = decodeStringIfValid(bArr, i3, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, decodeStringIfValid, decodeStringIfValid(bArr, delimiterLength, indexOfEos2, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), i2));
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w(TAG, "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (readUnsignedInt24 != ID3_TAG) {
            Log.w(TAG, "Unexpected first three bytes of ID3 tag header: " + readUnsignedInt24);
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                Log.w(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else {
            if (readUnsignedByte != 4) {
                Log.w(TAG, "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
                return null;
            }
            if ((readUnsignedByte2 & 64) != 0) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                readSynchSafeInt -= 10;
            }
        }
        return new Id3Header(readUnsignedByte, readUnsignedByte < 4 && (readUnsignedByte2 & 128) != 0, readSynchSafeInt);
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i));
    }

    private static String decodeStringIfValid(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new TextInformationFrame("TXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte), charsetName));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength), "ISO-8859-1"));
    }

    private static int delimiterLength(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static String getCharsetName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : C.UTF16_NAME;
    }

    private static String getFrameId(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static int indexOfEos(byte[] bArr, int i, int i2) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return indexOfZeroByte;
        }
        while (indexOfZeroByte < bArr.length - 1) {
            if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                return indexOfZeroByte;
            }
            indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i2 = position + 1;
            if (i2 >= i) {
                return i;
            }
            if ((bArr[position] & 255) == 255 && bArr[i2] == 0) {
                System.arraycopy(bArr, position + 2, bArr, i2, (i - position) - 2);
                i--;
            }
            position = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r10 & 1) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0084, code lost:
    
        if ((r10 & 128) != 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean validateFrames(ParsableByteArray parsableByteArray, int i, int i2, boolean z) {
        int readUnsignedInt24;
        long readUnsignedInt242;
        int i3;
        int i4;
        int position = parsableByteArray.getPosition();
        while (true) {
            try {
                boolean z2 = true;
                if (parsableByteArray.bytesLeft() < i2) {
                    return true;
                }
                if (i >= 3) {
                    readUnsignedInt24 = parsableByteArray.readInt();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt();
                    i3 = parsableByteArray.readUnsignedShort();
                } else {
                    readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
                    readUnsignedInt242 = parsableByteArray.readUnsignedInt24();
                    i3 = 0;
                }
                if (readUnsignedInt24 == 0 && readUnsignedInt242 == 0 && i3 == 0) {
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & readUnsignedInt242) != 0) {
                        return false;
                    }
                    readUnsignedInt242 = (((readUnsignedInt242 >> 24) & 255) << 21) | (readUnsignedInt242 & 255) | (((readUnsignedInt242 >> 8) & 255) << 7) | (((readUnsignedInt242 >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i4 = (i3 & 64) != 0 ? 1 : 0;
                } else {
                    if (i == 3) {
                        i4 = (i3 & 32) != 0 ? 1 : 0;
                    } else {
                        i4 = 0;
                        z2 = false;
                    }
                    if (z2) {
                        i4 += 4;
                    }
                    if (readUnsignedInt242 < i4) {
                        return false;
                    }
                    if (parsableByteArray.bytesLeft() < readUnsignedInt242) {
                        return false;
                    }
                    parsableByteArray.skipBytes((int) readUnsignedInt242);
                }
            } finally {
                parsableByteArray.setPosition(position);
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.framePredicate = framePredicate;
    }

    public Metadata decode(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i2 = decodeHeader.majorVersion == 2 ? 6 : 10;
        int i3 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            i3 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + i3);
        boolean z = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i2, false)) {
            if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i2, true)) {
                Log.w(TAG, "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
            z = true;
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z, i2, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata(arrayList);
    }
}

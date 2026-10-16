package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.util.Log;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class NalUnitUtil {
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    private static final String TAG = "NalUnitUtil";
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object scratchEscapePositionsLock = new Object();
    private static int[] scratchEscapePositions = new int[10];

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    public static final class SpsData {
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.seqParameterSetId = i;
            this.width = i2;
            this.height = i3;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i4;
            this.picOrderCountType = i5;
            this.picOrderCntLsbLength = i6;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    private NalUnitUtil() {
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 >= position) {
                byteBuffer.clear();
                return;
            }
            int i4 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i4 == 1 && (byteBuffer.get(i3) & Ascii.US) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i4 == 0) {
                i2++;
            }
            if (i4 != 0) {
                i2 = 0;
            }
            i = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        Assertions.checkState(i3 >= 0);
        if (i3 != 0) {
            if (zArr != null) {
                if (zArr[0]) {
                    clearPrefixFlags(zArr);
                    return i - 3;
                }
                if (i3 > 1 && zArr[1] && bArr[i] == 1) {
                    clearPrefixFlags(zArr);
                    return i - 2;
                }
                if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
                    clearPrefixFlags(zArr);
                    return i - 1;
                }
            }
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                byte b = bArr[i5];
                if ((b & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                        if (zArr != null) {
                            clearPrefixFlags(zArr);
                        }
                        return i6;
                    }
                    i5 -= 2;
                }
                i5 += 3;
            }
            if (zArr != null) {
                boolean z = i3 > 2 ? false : false;
                zArr[0] = z;
                zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
                zArr[2] = bArr[i4] == 0;
            }
        }
        return i2;
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & Ascii.US;
    }

    public static boolean isNalUnitSei(String str, byte b) {
        return ("video/avc".equals(str) && (b & Ascii.US) == 6) || ("video/hevc".equals(str) && ((b & 126) >> 1) == 39);
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpsData parseSpsNalUnit(byte[] bArr, int i, int i2) {
        int readUnsignedExpGolombCodedInt;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        boolean readBit;
        float f;
        int readBits;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readBits2 = parsableNalUnitBitArray.readBits(8);
        parsableNalUnitBitArray.skipBits(16);
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readBits2 == 100 || readBits2 == 110 || readBits2 == 122 || readBits2 == 244 || readBits2 == 44 || readBits2 == 83 || readBits2 == 86 || readBits2 == 118 || readBits2 == 128 || readBits2 == 138) {
            readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            boolean readBit2 = readUnsignedExpGolombCodedInt == 3 ? parsableNalUnitBitArray.readBit() : false;
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                int i4 = readUnsignedExpGolombCodedInt != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i4) {
                    if (parsableNalUnitBitArray.readBit()) {
                        skipScalingList(parsableNalUnitBitArray, i5 < 6 ? 16 : 64);
                    }
                    i5++;
                }
            }
            z = readBit2;
        } else {
            readUnsignedExpGolombCodedInt = 1;
            z = false;
        }
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt4 == 0) {
            i3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
            z2 = z;
        } else {
            if (readUnsignedExpGolombCodedInt4 == 1) {
                boolean readBit3 = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                long readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                z2 = z;
                for (int i6 = 0; i6 < readUnsignedExpGolombCodedInt5; i6++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z3 = readBit3;
                i3 = 0;
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.skipBit();
                int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                readBit = parsableNalUnitBitArray.readBit();
                int i7 = 2 - (readBit ? 1 : 0);
                int i8 = readUnsignedExpGolombCodedInt7 * i7;
                if (!readBit) {
                    parsableNalUnitBitArray.skipBit();
                }
                parsableNalUnitBitArray.skipBit();
                int i9 = readUnsignedExpGolombCodedInt6 * 16;
                int i10 = i8 * 16;
                if (parsableNalUnitBitArray.readBit()) {
                    int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    if (readUnsignedExpGolombCodedInt != 0) {
                        int i11 = readUnsignedExpGolombCodedInt == 3 ? 1 : 2;
                        i7 *= readUnsignedExpGolombCodedInt == 1 ? 2 : 1;
                        r7 = i11;
                    }
                    i9 -= (readUnsignedExpGolombCodedInt8 + readUnsignedExpGolombCodedInt9) * r7;
                    i10 -= (readUnsignedExpGolombCodedInt10 + readUnsignedExpGolombCodedInt11) * i7;
                }
                int i12 = i9;
                int i13 = i10;
                if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
                    readBits = parsableNalUnitBitArray.readBits(8);
                    if (readBits != 255) {
                        int readBits3 = parsableNalUnitBitArray.readBits(16);
                        int readBits4 = parsableNalUnitBitArray.readBits(16);
                        if (readBits3 != 0 && readBits4 != 0) {
                            f = readBits3 / readBits4;
                        }
                    } else {
                        float[] fArr = ASPECT_RATIO_IDC_VALUES;
                        if (readBits < fArr.length) {
                            f = fArr[readBits];
                        } else {
                            Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits);
                        }
                    }
                    return new SpsData(readUnsignedExpGolombCodedInt2, i12, i13, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i3, z3);
                }
                f = 1.0f;
                return new SpsData(readUnsignedExpGolombCodedInt2, i12, i13, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i3, z3);
            }
            z2 = z;
            i3 = 0;
        }
        z3 = false;
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt62 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        int readUnsignedExpGolombCodedInt72 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        readBit = parsableNalUnitBitArray.readBit();
        int i72 = 2 - (readBit ? 1 : 0);
        int i82 = readUnsignedExpGolombCodedInt72 * i72;
        if (!readBit) {
        }
        parsableNalUnitBitArray.skipBit();
        int i92 = readUnsignedExpGolombCodedInt62 * 16;
        int i102 = i82 * 16;
        if (parsableNalUnitBitArray.readBit()) {
        }
        int i122 = i92;
        int i132 = i102;
        if (parsableNalUnitBitArray.readBit()) {
            readBits = parsableNalUnitBitArray.readBits(8);
            if (readBits != 255) {
            }
            return new SpsData(readUnsignedExpGolombCodedInt2, i122, i132, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i3, z3);
        }
        f = 1.0f;
        return new SpsData(readUnsignedExpGolombCodedInt2, i122, i132, f, z2, readBit, readUnsignedExpGolombCodedInt3, readUnsignedExpGolombCodedInt4, i3, z3);
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                try {
                    i3 = findNextUnescapeIndex(bArr, i3, i);
                    if (i3 < i) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i4) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i4] = i3;
                        i3 += 3;
                        i4++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = scratchEscapePositions[i7] - i5;
                System.arraycopy(bArr, i5, bArr, i6, i8);
                int i9 = i6 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i6 = i9 + 2;
                bArr[i10] = 0;
                i5 += i8 + 3;
            }
            System.arraycopy(bArr, i5, bArr, i6, i2 - i6);
        }
        return i2;
    }
}

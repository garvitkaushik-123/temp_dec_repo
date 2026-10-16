package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: classes4.dex */
public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z;
        try {
            parsableByteArray.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i = 0;
            int i2 = 0;
            while (true) {
                z = true;
                if (i >= readUnsignedByte2) {
                    break;
                }
                parsableByteArray.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i2 += readUnsignedShort2 + 4;
                    parsableByteArray.skipBytes(readUnsignedShort2);
                }
                i++;
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i2];
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            float f = 1.0f;
            String str = null;
            int i9 = 0;
            for (int i10 = 0; i10 < readUnsignedByte2; i10++) {
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 63;
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                int i11 = 0;
                while (i11 < readUnsignedShort3) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    boolean z2 = z;
                    int i12 = readUnsignedByte;
                    System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, i9, NalUnitUtil.NAL_START_CODE.length);
                    int length = i9 + NalUnitUtil.NAL_START_CODE.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    if (readUnsignedByte3 == 33 && i11 == 0) {
                        NalUnitUtil.H265SpsData parseH265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + readUnsignedShort4);
                        i4 = parseH265SpsNalUnit.width;
                        i5 = parseH265SpsNalUnit.height;
                        i6 = parseH265SpsNalUnit.colorSpace;
                        int i13 = parseH265SpsNalUnit.colorRange;
                        int i14 = parseH265SpsNalUnit.colorTransfer;
                        float f2 = parseH265SpsNalUnit.pixelWidthHeightRatio;
                        str = CodecSpecificDataUtil.buildHevcCodecString(parseH265SpsNalUnit.generalProfileSpace, parseH265SpsNalUnit.generalTierFlag, parseH265SpsNalUnit.generalProfileIdc, parseH265SpsNalUnit.generalProfileCompatibilityFlags, parseH265SpsNalUnit.constraintBytes, parseH265SpsNalUnit.generalLevelIdc);
                        f = f2;
                        i8 = i14;
                        i7 = i13;
                    }
                    i9 = length + readUnsignedShort4;
                    parsableByteArray.skipBytes(readUnsignedShort4);
                    i11++;
                    z = z2;
                    readUnsignedByte = i12;
                }
            }
            return new HevcConfig(i2 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), readUnsignedByte + 1, i4, i5, i6, i7, i8, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e);
        }
    }

    private HevcConfig(List<byte[]> list, int i, int i2, int i3, int i4, int i5, int i6, float f, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.colorSpace = i4;
        this.colorRange = i5;
        this.colorTransfer = i6;
        this.pixelWidthHeightRatio = f;
        this.codecs = str;
    }
}

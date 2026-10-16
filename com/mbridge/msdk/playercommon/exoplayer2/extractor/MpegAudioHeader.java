package com.mbridge.msdk.playercommon.exoplayer2.extractor;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes6.dex */
public final class MpegAudioHeader {
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;
    private static final String[] MIME_TYPE_BY_LAYER = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] SAMPLING_RATE_V1 = {44100, 48000, 32000};
    private static final int[] BITRATE_V1_L1 = {32, 64, 96, 128, 160, 192, 224, 256, 288, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 352, 384, TTAdConstant.PACKAGE_NAME_CODE, 448};
    private static final int[] BITRATE_V2_L1 = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    private static final int[] BITRATE_V1_L2 = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 384};
    private static final int[] BITRATE_V1_L3 = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE};
    private static final int[] BITRATE_V2 = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    public static int getFrameSize(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i6 = SAMPLING_RATE_V1[i5];
        if (i2 == 2) {
            i6 /= 2;
        } else if (i2 == 0) {
            i6 /= 4;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? BITRATE_V1_L1[i4 - 1] : BITRATE_V2_L1[i4 - 1]) * 12000) / i6) + i7) * 4;
        }
        int i8 = i2 == 3 ? i3 == 2 ? BITRATE_V1_L2[i4 - 1] : BITRATE_V1_L3[i4 - 1] : BITRATE_V2[i4 - 1];
        if (i2 == 3) {
            return ((i8 * 144000) / i6) + i7;
        }
        return (((i3 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i8) / i6) + i7;
    }

    public static boolean populateHeader(int i, MpegAudioHeader mpegAudioHeader) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return false;
        }
        int i10 = SAMPLING_RATE_V1[i5];
        if (i2 == 2) {
            i10 /= 2;
        } else if (i2 == 0) {
            i10 /= 4;
        }
        int i11 = i10;
        int i12 = (i >>> 9) & 1;
        if (i3 == 3) {
            i6 = i2 == 3 ? BITRATE_V1_L1[i4 - 1] : BITRATE_V2_L1[i4 - 1];
            i8 = (((i6 * 12000) / i11) + i12) * 4;
            i9 = 384;
        } else {
            if (i2 == 3) {
                i6 = i3 == 2 ? BITRATE_V1_L2[i4 - 1] : BITRATE_V1_L3[i4 - 1];
                i7 = (144000 * i6) / i11;
            } else {
                i6 = BITRATE_V2[i4 - 1];
                r9 = i3 == 1 ? 576 : 1152;
                i7 = ((i3 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i6) / i11;
            }
            i8 = i7 + i12;
            i9 = r9;
        }
        mpegAudioHeader.setValues(i2, MIME_TYPE_BY_LAYER[3 - i3], i8, i11, ((i >> 6) & 3) == 3 ? 1 : 2, i6 * 1000, i9);
        return true;
    }

    private void setValues(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        this.version = i;
        this.mimeType = str;
        this.frameSize = i2;
        this.sampleRate = i3;
        this.channels = i4;
        this.bitrate = i5;
        this.samplesPerFrame = i6;
    }
}

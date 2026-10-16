package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.extractor.ts.TsExtractor;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1381a = {1, 2, 3, 6};
    public static final int[] b = {48000, 44100, 32000};
    public static final int[] c = {24000, 22050, 16000};
    public static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 384, 448, 512, 576, 640};
    public static final int[] f = {69, 87, 104, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 174, 208, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = b;
        if (i >= 3 || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f;
        if (i3 >= 19) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return ((i2 % 2) + iArr2[i3]) * 2;
        }
        int i5 = e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }
}

package com.instagram.common.viewpoint.core;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;

/* loaded from: assets/audience_network/classes2.dex */
public interface M0<T> {
    public static final C8I A00;
    public static final C8H A01;
    public static final C8H A02;
    public static final C8H A03;
    public static final C8H A04;
    public static final C8H A05;
    public static final C8H A06;
    public static final C8H A07;
    public static final C8H A08;
    public static final C8H A09;
    public static final C8H A0A;
    public static final C8H A0B;
    public static final C8H A0C;
    public static final C8H A0D;
    public static final C8H A0E;
    public static final C8H A0F;
    public static final C8H A0G;
    public static final C8H A0H;
    public static final C8H A0I;
    public static final C8H A0J;
    public static final C8H A0K;
    public static final C8H A0L;
    public static final C8G A0M;
    public static final C8F A0N;
    public static final C8F A0O;
    public static final C8F A0P;
    public static final C8F A0Q;
    public static final C8F A0R;
    public static final C8F A0S;
    public static final C8F A0T;
    public static final C8F A0U;
    public static final C8F A0V;
    public static final C8F A0W;
    public static final C8E A0X;
    public static final C8E A0Y;
    public static final C8D A0Z;
    public static final C8D A0a;
    public static final C8D A0b;
    public static final C8D A0c;
    public static final C8D A0d;
    public static final C8D A0e;
    public static final C8D A0f;
    public static final C8D A0g;
    public static final C8D A0h;
    public static final C8D A0i;
    public static final C8D A0j;
    public static final C8D A0k;
    public static final C8D A0l;
    public static final C8D A0m;
    public static final C8D A0n;
    public static final C8D A0o;

    String getName();

    /* JADX WARN: Type inference failed for: r0v1, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v101, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v19, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v31, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v37, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v39, types: [com.facebook.ads.redexgen.X.8E] */
    /* JADX WARN: Type inference failed for: r0v41, types: [com.facebook.ads.redexgen.X.8E] */
    /* JADX WARN: Type inference failed for: r0v43, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v45, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v47, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v49, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v51, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v53, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v55, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v57, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v59, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v61, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v63, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v65, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v67, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v69, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v71, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v73, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v75, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v77, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v79, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v81, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v83, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v85, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v87, types: [com.facebook.ads.redexgen.X.8F] */
    /* JADX WARN: Type inference failed for: r0v89, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v91, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v93, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v95, types: [com.facebook.ads.redexgen.X.8D] */
    /* JADX WARN: Type inference failed for: r0v97, types: [com.facebook.ads.redexgen.X.8H] */
    /* JADX WARN: Type inference failed for: r0v99, types: [com.facebook.ads.redexgen.X.8D] */
    static {
        final String A002 = AnonymousClass11.A00(436, 12, 127);
        A0j = new AbstractC2150kY<String>(A002) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A003 = AnonymousClass11.A00(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 10, 52);
        A0O = new AbstractC2150kY<Integer>(A003) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A004 = AnonymousClass11.A00(Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 2, 48);
        A0g = new AbstractC2150kY<String>(A004) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A005 = AnonymousClass11.A00(36, 15, 90);
        A01 = new AbstractC2150kY<Boolean>(A005) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A006 = AnonymousClass11.A00(380, 21, 109);
        A0I = new AbstractC2150kY<Boolean>(A006) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A007 = AnonymousClass11.A00(156, 7, 19);
        A03 = new AbstractC2150kY<Boolean>(A007) { // from class: com.facebook.ads.redexgen.X.8H
        };
        A00 = new C8I(AnonymousClass11.A00(543, 1, 66));
        final String A008 = AnonymousClass11.A00(574, 10, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        A0W = new AbstractC2150kY<Integer>(A008) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A009 = AnonymousClass11.A00(492, 11, 50);
        A0K = new AbstractC2150kY<Boolean>(A009) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0010 = AnonymousClass11.A00(134, 13, 79);
        A0e = new AbstractC2150kY<String>(A0010) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0011 = AnonymousClass11.A00(163, 14, 61);
        A04 = new AbstractC2150kY<Boolean>(A0011) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0012 = AnonymousClass11.A00(346, 15, 42);
        A0G = new AbstractC2150kY<Boolean>(A0012) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0013 = AnonymousClass11.A00(70, 12, 99);
        A02 = new AbstractC2150kY<Boolean>(A0013) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0014 = AnonymousClass11.A00(177, 12, 126);
        A05 = new AbstractC2150kY<Boolean>(A0014) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0015 = AnonymousClass11.A00(189, 11, 64);
        A06 = new AbstractC2150kY<Boolean>(A0015) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0016 = AnonymousClass11.A00(476, 10, 126);
        A0l = new AbstractC2150kY<String>(A0016) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0017 = AnonymousClass11.A00(448, 14, 48);
        A0k = new AbstractC2150kY<String>(A0017) { // from class: com.facebook.ads.redexgen.X.8D
        };
        A0M = new C8G(AnonymousClass11.A00(551, 9, 42));
        final String A0018 = AnonymousClass11.A00(503, 11, 102);
        A0U = new AbstractC2150kY<Integer>(A0018) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A0019 = AnonymousClass11.A00(334, 12, 0);
        A0Y = new AbstractC2150kY<Long>(A0019) { // from class: com.facebook.ads.redexgen.X.8E
        };
        final String A0020 = AnonymousClass11.A00(307, 27, 127);
        A0X = new AbstractC2150kY<Long>(A0020) { // from class: com.facebook.ads.redexgen.X.8E
        };
        final String A0021 = AnonymousClass11.A00(0, 18, 82);
        A0Z = new AbstractC2150kY<String>(A0021) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0022 = AnonymousClass11.A00(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 9, 1);
        A0B = new AbstractC2150kY<Boolean>(A0022) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0023 = AnonymousClass11.A00(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 14, 78);
        A09 = new AbstractC2150kY<Boolean>(A0023) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0024 = AnonymousClass11.A00(470, 6, 3);
        A0S = new AbstractC2150kY<Integer>(A0024) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A0025 = AnonymousClass11.A00(401, 7, 26);
        A0h = new AbstractC2150kY<String>(A0025) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0026 = AnonymousClass11.A00(147, 9, 95);
        A0f = new AbstractC2150kY<String>(A0026) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0027 = AnonymousClass11.A00(200, 18, 0);
        A07 = new AbstractC2150kY<Boolean>(A0027) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0028 = AnonymousClass11.A00(89, 16, 55);
        A0N = new AbstractC2150kY<Integer>(A0028) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A0029 = AnonymousClass11.A00(408, 4, 54);
        A0Q = new AbstractC2150kY<Integer>(A0029) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A0030 = AnonymousClass11.A00(234, 16, 43);
        A0P = new AbstractC2150kY<Integer>(A0030) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A0031 = AnonymousClass11.A00(285, 19, 13);
        A0D = new AbstractC2150kY<Boolean>(A0031) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0032 = AnonymousClass11.A00(259, 26, 26);
        A0C = new AbstractC2150kY<Boolean>(A0032) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0033 = AnonymousClass11.A00(584, 16, 113);
        A0o = new AbstractC2150kY<String>(A0033) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0034 = AnonymousClass11.A00(105, 19, 88);
        A0d = new AbstractC2150kY<String>(A0034) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0035 = AnonymousClass11.A00(462, 8, 35);
        A0i = new AbstractC2150kY<String>(A0035) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0036 = AnonymousClass11.A00(18, 18, 106);
        A0a = new AbstractC2150kY<String>(A0036) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0037 = AnonymousClass11.A00(539, 4, 96);
        A0V = new AbstractC2150kY<Integer>(A0037) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A0038 = AnonymousClass11.A00(TTAdConstant.IMAGE_URL_CODE, 13, 35);
        A0J = new AbstractC2150kY<Boolean>(A0038) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0039 = AnonymousClass11.A00(IronSourceError.ERROR_NO_INTERNET_CONNECTION, 19, 35);
        A0L = new AbstractC2150kY<Boolean>(A0039) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0040 = AnonymousClass11.A00(361, 19, 14);
        A0H = new AbstractC2150kY<Boolean>(A0040) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0041 = AnonymousClass11.A00(560, 14, 108);
        A0n = new AbstractC2150kY<String>(A0041) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0042 = AnonymousClass11.A00(58, 12, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
        A0c = new AbstractC2150kY<String>(A0042) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0043 = AnonymousClass11.A00(425, 11, 47);
        A0R = new AbstractC2150kY<Integer>(A0043) { // from class: com.facebook.ads.redexgen.X.8F
        };
        final String A0044 = AnonymousClass11.A00(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, 3, 26);
        A0A = new AbstractC2150kY<Boolean>(A0044) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0045 = AnonymousClass11.A00(544, 2, 108);
        A0E = new AbstractC2150kY<Boolean>(A0045) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0046 = AnonymousClass11.A00(82, 7, 5);
        A08 = new AbstractC2150kY<Boolean>(A0046) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0047 = AnonymousClass11.A00(51, 7, 99);
        A0b = new AbstractC2150kY<String>(A0047) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0048 = AnonymousClass11.A00(546, 5, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        A0F = new AbstractC2150kY<Boolean>(A0048) { // from class: com.facebook.ads.redexgen.X.8H
        };
        final String A0049 = AnonymousClass11.A00(EventTypeExtended.EVENT_TYPE_EXTENDED_IMPRESSION_OPPORTUNITY_VALUE, 6, 89);
        A0m = new AbstractC2150kY<String>(A0049) { // from class: com.facebook.ads.redexgen.X.8D
        };
        final String A0050 = AnonymousClass11.A00(486, 6, 90);
        A0T = new AbstractC2150kY<Integer>(A0050) { // from class: com.facebook.ads.redexgen.X.8F
        };
    }
}

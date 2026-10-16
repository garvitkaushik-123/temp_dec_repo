package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.AdSettings;
import com.facebook.ads.RewardData;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.ads.redexgen.X.ea, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1797ea {
    public static byte[] A05;
    public Executor A00 = YG.A06;
    public final C1929gi A01;
    public final InterfaceC1470Yh A02;
    public final ZU A03;
    public final String A04;

    static {
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 76);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{5, Ascii.DC4, Ascii.DC4, Ascii.CR, 8, 19, Ascii.US, Ascii.US, Ascii.ESC, Ascii.RS, -27, -38, -38, 34, 34, 34, -39, -48, Ascii.RS, -39, 17, Ascii.FF, Ascii.SO, Ascii.DLE, Ascii.CR, Ascii.SUB, Ascii.SUB, Ascii.SYN, -39, Ascii.SO, Ascii.SUB, Ascii.CAN, -38, Ascii.FF, 32, Ascii.SI, Ascii.DC4, Ascii.DLE, Ascii.EM, Ascii.SO, Ascii.DLE, 10, Ascii.EM, Ascii.DLE, Ascii.US, 34, Ascii.SUB, Ascii.GS, Ascii.SYN, -38, Ascii.RS, Ascii.DLE, Ascii.GS, 33, Ascii.DLE, Ascii.GS, 10, Ascii.RS, Ascii.DC4, Ascii.SI, Ascii.DLE, 10, Ascii.GS, Ascii.DLE, 34, Ascii.FF, Ascii.GS, Ascii.SI, -31, -19, -19, -23, -20, -77, -88, -88, -16, -16, -16, -89, -33, -38, -36, -34, -37, -24, -24, -28, -89, -36, -24, -26, -88, -38, -18, -35, -30, -34, -25, -36, -34, -40, -25, -34, -19, -16, -24, -21, -28, -88, -20, -34, -21, -17, -34, -21, -40, -20, -30, -35, -34, -40, -21, -34, -16, -38, -21, -35, Ascii.DC4, 7, Ascii.US, 35, Ascii.CAN, 19, 42, 47, 35, Ascii.RS};
    }

    public C1797ea(C1929gi c1929gi, ZU zu, String str, InterfaceC1470Yh interfaceC1470Yh) {
        this.A01 = c1929gi;
        this.A03 = zu;
        this.A04 = str;
        this.A02 = interfaceC1470Yh;
    }

    public static String A04(RewardData rewardData, String str, String str2) {
        String urlPrefix;
        if (rewardData != null) {
            String serverSideProxyURL = AdSettings.getUrlPrefix();
            if (serverSideProxyURL == null || serverSideProxyURL.isEmpty()) {
                urlPrefix = A03(68, 60, 45);
            } else {
                String urlPrefix2 = A03(5, 63, 95);
                urlPrefix = String.format(Locale.US, urlPrefix2, serverSideProxyURL);
            }
            Uri A00 = XB.A00(urlPrefix);
            Uri.Builder uriBuilder = new Uri.Builder();
            String urlPrefix3 = A00.getScheme();
            uriBuilder.scheme(urlPrefix3);
            String urlPrefix4 = A00.getAuthority();
            uriBuilder.authority(urlPrefix4);
            String urlPrefix5 = A00.getPath();
            uriBuilder.path(urlPrefix5);
            String urlPrefix6 = A00.getQuery();
            uriBuilder.query(urlPrefix6);
            String urlPrefix7 = A00.getFragment();
            uriBuilder.fragment(urlPrefix7);
            String serverSideProxyURL2 = A03(134, 4, 110);
            String urlPrefix8 = rewardData.getUserID();
            uriBuilder.appendQueryParameter(serverSideProxyURL2, urlPrefix8);
            String serverSideProxyURL3 = A03(128, 2, 88);
            String urlPrefix9 = rewardData.getCurrency();
            uriBuilder.appendQueryParameter(serverSideProxyURL3, urlPrefix9);
            String urlPrefix10 = A03(130, 4, 99);
            uriBuilder.appendQueryParameter(urlPrefix10, str);
            String urlPrefix11 = A03(0, 5, 88);
            uriBuilder.appendQueryParameter(urlPrefix11, str2);
            String urlPrefix12 = uriBuilder.build().toString();
            return urlPrefix12;
        }
        return null;
    }

    public final void A06() {
        if (!TextUtils.isEmpty(this.A04)) {
            AsyncTaskC1900gF asyncTaskC1900gF = new AsyncTaskC1900gF(this.A01, new HashMap());
            asyncTaskC1900gF.A07(new F8(this));
            asyncTaskC1900gF.executeOnExecutor(this.A00, this.A04);
        }
    }
}

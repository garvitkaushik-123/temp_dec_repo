package com.instagram.common.viewpoint.core;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.Vs, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1406Vs {
    public static String[] A00 = {"TYvyTugW0LIK7CMS2wYs9G2uUGgA7Dke", "WsEiqL7ZS4BTI966aPHoJ2dPx2Ea0F4I", "bsmL1TSWcO8d5RdSDpnXrtDP3Rd3pXtR", "xkYelsmw9O3RFB2zMTQOqufEggZJfpsf", "Ou1dyJktpNGGcf9tDpPKvHuJxEoqg2O4", "MwtSqX2RTtZq4kMpP", "Xg7OrQNETkr2DWt43s", "zI20iJtpElrzvKbVLZsd1iWpdjTxU8BC"};

    public static EnumC1404Vq A00(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.widthPixels / displayMetrics.density);
        int screenWidth = displayMetrics.heightPixels;
        int screenHeight = (int) (screenWidth / displayMetrics.density);
        if (XY.A04(i, screenHeight)) {
            return EnumC1404Vq.A0I;
        }
        if (screenHeight > i) {
            EnumC1404Vq enumC1404Vq = EnumC1404Vq.A0K;
            String[] strArr = A00;
            String str = strArr[5];
            String str2 = strArr[6];
            int screenHeight2 = str.length();
            int screenWidth2 = str2.length();
            if (screenHeight2 == screenWidth2) {
                throw new RuntimeException();
            }
            A00[7] = "zEjIxhk858iOsdYr9SgRsiKXnD8rO3VU";
            return enumC1404Vq;
        }
        return EnumC1404Vq.A0H;
    }

    public static void A01(DisplayMetrics displayMetrics, View view, EnumC1403Vp enumC1403Vp) {
        int ceil;
        int i = (int) (displayMetrics.widthPixels / displayMetrics.density);
        int screenWidth = enumC1403Vp.A04();
        if (i >= screenWidth) {
            ceil = displayMetrics.widthPixels;
        } else {
            int screenWidth2 = enumC1403Vp.A04();
            ceil = (int) Math.ceil(screenWidth2 * displayMetrics.density);
        }
        int screenWidth3 = enumC1403Vp.A03();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ceil, (int) Math.ceil(screenWidth3 * displayMetrics.density));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}

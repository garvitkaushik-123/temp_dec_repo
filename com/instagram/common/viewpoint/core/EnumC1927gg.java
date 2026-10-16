package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.facebook.ads.redexgen.X.gg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class EnumC1927gg {
    public static byte[] A01;
    public static String[] A02 = {"4MR", "ox3", "IUsSI7rcrCx1ERgKd0rYF5wqQshT9MFY", "XMpLbdKCI8ptDt9BVBTjCKDwrbbZ39Yk", "reDnu4iC6gOf", "58W6JAylc1sA", "T5hdxNMEH3a8tXz2YdYKh9bF2ZTD6zRG", "CM8HCV1eVyulF3snUIL5CjajvzNLA86A"};
    public static final /* synthetic */ EnumC1927gg[] A03;
    public static final EnumC1927gg A04;
    public static final EnumC1927gg A05;
    public String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[5].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "zM61rMpjrvDScug74JUjCxPutIg5FxhC";
            strArr2[7] = "TMGBJitMUu1pxt90KbWrvOLR2BVfJ6J0";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 11);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-86, -83, -80, -80, -104, -109, -121, -124, -105, -120, -116, -113, -110, -110, -88, -93, -105, -108, -89, -104};
    }

    static {
        A01();
        A04 = new EnumC1927gg(A00(0, 4, 89), 0, A00(10, 4, 27));
        A05 = new EnumC1927gg(A00(4, 6, 56), 1, A00(14, 6, 40));
        A03 = A02();
    }

    public EnumC1927gg(String str, int i, String str2) {
        this.A00 = str2;
    }

    public static /* synthetic */ EnumC1927gg[] A02() {
        EnumC1927gg[] enumC1927ggArr = new EnumC1927gg[2];
        enumC1927ggArr[0] = A04;
        EnumC1927gg enumC1927gg = A05;
        String[] strArr = A02;
        if (strArr[5].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A02[2] = "lJSENTz9psORZi9A2zDcPU2PQxg7yytN";
        enumC1927ggArr[1] = enumC1927gg;
        return enumC1927ggArr;
    }

    public final String A03() {
        return this.A00;
    }

    public static EnumC1927gg valueOf(String str) {
        return (EnumC1927gg) Enum.valueOf(EnumC1927gg.class, str);
    }

    public static EnumC1927gg[] values() {
        return (EnumC1927gg[]) A03.clone();
    }
}

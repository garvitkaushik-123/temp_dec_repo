package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class K7 {
    public static byte[] A05;
    public static String[] A06 = {"rlpJzJvMZPS96752sWOw4hHmtt9HQE0Q", "UPlQWo", "ZXUw26V2c7", "6tEwv6Up9NP4MOjnWwfRMdieV7ltrfDK", "1MWXcVZusFrtXDSpfsJ6Y4yHAb", "3y9vGkKnNQnOlcIPORqt4hFWNeEUPhWe", "", "J1HUrfSw1j9IlDpk2TzINIeAn4Xj8ByV"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A06;
            if (strArr[0].charAt(28) == strArr[3].charAt(28)) {
                throw new RuntimeException();
            }
            A06[6] = "";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 99);
            i4++;
        }
    }

    public static void A02() {
        A05 = new byte[]{122, 107, 66, 95, SignedBytes.MAX_POWER_OF_TWO, 76, 89, Ascii.ETB, 89, 82, 88, 2, 5, Ascii.DLE, 3, 5, 118, 113, 124, 105, 96, 33, 48, 45, 33};
    }

    static {
        A02();
    }

    public K7(int i, int i2, int i3, int i4, int i5) {
        this.A02 = i;
        this.A00 = i2;
        this.A03 = i3;
        this.A04 = i4;
        this.A01 = i5;
    }

    public static K7 A00(String str) {
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        String A01 = A01(1, 7, 78);
        AbstractC07133y.A07(str.startsWith(A01));
        int startTimeIndex = A01.length();
        String[] keys = TextUtils.split(str.substring(startTimeIndex), A01(0, 1, 53));
        int i5 = 0;
        while (true) {
            int startTimeIndex2 = keys.length;
            int textIndex = -1;
            if (i5 < startTimeIndex2) {
                String A012 = AbstractC2124k7.A01(keys[i5].trim());
                int startTimeIndex3 = A012.hashCode();
                switch (startTimeIndex3) {
                    case 100571:
                        if (A012.equals(A01(8, 3, 95))) {
                            textIndex = 1;
                            break;
                        }
                        break;
                    case 3556653:
                        if (A012.equals(A01(21, 4, 54))) {
                            textIndex = 3;
                            break;
                        }
                        break;
                    case 109757538:
                        if (A012.equals(A01(11, 5, 18))) {
                            textIndex = 0;
                            break;
                        }
                        break;
                    case 109780401:
                        int endTimeIndex = A06[7].charAt(11);
                        if (endTimeIndex == 70) {
                            throw new RuntimeException();
                        }
                        A06[6] = "";
                        if (A012.equals(A01(16, 5, 102))) {
                            textIndex = 2;
                            break;
                        }
                        break;
                }
                switch (textIndex) {
                    case 0:
                        i = i5;
                        break;
                    case 1:
                        i2 = i5;
                        break;
                    case 2:
                        i3 = i5;
                        break;
                    case 3:
                        i4 = i5;
                        break;
                }
                i5++;
            } else {
                if (i != -1 && i2 != -1 && i4 != -1) {
                    return new K7(i, i2, i3, i4, keys.length);
                }
                return null;
            }
        }
    }
}

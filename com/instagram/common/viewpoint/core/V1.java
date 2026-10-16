package com.instagram.common.viewpoint.core;

import com.ironsource.D5;

/* loaded from: assets/audience_network/classes2.dex */
public final class V1 {
    public static String[] A04 = {"VndfGBIDInq1AmGKWEXIYtH", "X1ufgR44W1Z84U", D5.q, "", "za8Aa", "xjBfTCMiG1bFh7NB9hwMlLVXQHNbTqdl", "vkDSrNK7CnANJUjGZxXcCXY", "njWPP"};
    public EnumC1388Uy A01 = EnumC1388Uy.A03;
    public EnumC1389Uz A02 = EnumC1389Uz.A06;
    public V0 A03 = V0.A02;
    public EnumC1387Ux A00 = EnumC1387Ux.A02;

    public final void A00() {
        this.A00 = EnumC1387Ux.A03;
    }

    public final void A01() {
        this.A02 = EnumC1389Uz.A04;
    }

    public final void A02() {
        this.A02 = EnumC1389Uz.A05;
    }

    public final void A03() {
        this.A03 = V0.A03;
    }

    public final boolean A04() {
        if (this.A02 != EnumC1389Uz.A06) {
            EnumC1389Uz enumC1389Uz = this.A02;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[6] = "r152EQyYeE04Ovy9QYMfnLx";
            strArr2[0] = "I6yTYbMajK96Zgvn6mn7gLC";
            if (enumC1389Uz != EnumC1389Uz.A02 && this.A02 != EnumC1389Uz.A05) {
                return false;
            }
        }
        return true;
    }

    public final boolean A05() {
        return this.A02 == EnumC1389Uz.A06 || this.A02 == EnumC1389Uz.A02;
    }

    public final boolean A06() {
        return this.A03 == V0.A03;
    }

    public final boolean A07() {
        return this.A00 == EnumC1387Ux.A03;
    }
}

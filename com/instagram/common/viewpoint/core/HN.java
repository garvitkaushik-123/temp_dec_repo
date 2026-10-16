package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public final class HN {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public String A06;

    public final boolean A00(int i) {
        boolean A06;
        int i2;
        int i3;
        int padding;
        int bitrateIndex;
        String[] strArr;
        int[] iArr;
        int version;
        int[] iArr2;
        int version2;
        int[] iArr3;
        int[] iArr4;
        int version3;
        int[] iArr5;
        A06 = HO.A06(i);
        if (!A06 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (padding = (i >>> 12) & 15) == 0 || padding == 15 || (bitrateIndex = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.A05 = i2;
        strArr = HO.A08;
        int version4 = 3 - i3;
        this.A06 = strArr[version4];
        iArr = HO.A07;
        int version5 = iArr[bitrateIndex];
        this.A03 = version5;
        if (i2 == 2) {
            int version6 = this.A03;
            this.A03 = version6 / 2;
        } else if (i2 == 0) {
            int version7 = this.A03;
            this.A03 = version7 / 4;
        }
        int samplingRateIndex = (i >>> 9) & 1;
        version = HO.A02(i2, i3);
        this.A04 = version;
        if (i3 == 3) {
            if (i2 == 3) {
                iArr5 = HO.A02;
                int version8 = padding - 1;
                version3 = iArr5[version8];
            } else {
                iArr4 = HO.A06;
                int version9 = padding - 1;
                version3 = iArr4[version9];
            }
            this.A00 = version3;
            int version10 = this.A00;
            int i4 = version10 * 12;
            int version11 = this.A03;
            this.A02 = ((i4 / version11) + samplingRateIndex) * 4;
        } else {
            if (i2 == 3) {
                if (i3 != 2) {
                    int version12 = padding - 1;
                    version2 = HO.A0C()[version12];
                } else {
                    iArr3 = HO.A03;
                    int version13 = padding - 1;
                    version2 = iArr3[version13];
                }
                this.A00 = version2;
                int version14 = this.A00;
                int i5 = version14 * 144;
                int version15 = this.A03;
                this.A02 = (i5 / version15) + samplingRateIndex;
            } else {
                iArr2 = HO.A05;
                int version16 = padding - 1;
                this.A00 = iArr2[version16];
                int bitrateIndex2 = i3 == 1 ? 72 : 144;
                int version17 = this.A00;
                int bitrateIndex3 = bitrateIndex2 * version17;
                int version18 = this.A03;
                this.A02 = (bitrateIndex3 / version18) + samplingRateIndex;
            }
        }
        int version19 = i >> 6;
        this.A01 = (version19 & 3) == 3 ? 1 : 2;
        return true;
    }
}

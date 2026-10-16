package com.bytedance.adsdk.DbA.Os.DbA;

import java.util.Arrays;

/* loaded from: classes3.dex */
public class aGH {
    private final int[] DbA;
    private final float[] eli;

    public aGH(float[] fArr, int[] iArr) {
        this.eli = fArr;
        this.DbA = iArr;
    }

    public float[] eli() {
        return this.eli;
    }

    public int[] DbA() {
        return this.DbA;
    }

    public int Os() {
        return this.DbA.length;
    }

    public void eli(aGH agh, aGH agh2, float f) {
        if (agh.DbA.length != agh2.DbA.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + agh.DbA.length + " vs " + agh2.DbA.length + ")");
        }
        for (int i = 0; i < agh.DbA.length; i++) {
            this.eli[i] = com.bytedance.adsdk.DbA.MGA.ui.eli(agh.eli[i], agh2.eli[i], f);
            this.DbA[i] = com.bytedance.adsdk.DbA.MGA.DbA.eli(f, agh.DbA[i], agh2.DbA[i]);
        }
    }

    public aGH eli(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = eli(fArr[i]);
        }
        return new aGH(fArr, iArr);
    }

    private int eli(float f) {
        int binarySearch = Arrays.binarySearch(this.eli, f);
        if (binarySearch >= 0) {
            return this.DbA[binarySearch];
        }
        int i = -(binarySearch + 1);
        if (i == 0) {
            return this.DbA[0];
        }
        int[] iArr = this.DbA;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.eli;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.DbA.MGA.DbA.eli((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}

package com.bytedance.adsdk.DbA.MGA;

/* loaded from: classes3.dex */
public class aGH {
    private int DbA;
    private float eli;

    public void eli(float f) {
        float f2 = this.eli + f;
        this.eli = f2;
        int i = this.DbA + 1;
        this.DbA = i;
        if (i == Integer.MAX_VALUE) {
            this.eli = f2 / 2.0f;
            this.DbA = i / 2;
        }
    }
}

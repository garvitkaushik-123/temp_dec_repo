package com.bytedance.adsdk.DbA.kb;

import io.bidmachine.iab.vast.tags.VastAttributes;

/* loaded from: classes3.dex */
public class Os {
    private float DbA;
    private float eli;

    public Os(float f, float f2) {
        this.eli = f;
        this.DbA = f2;
    }

    public Os() {
        this(1.0f, 1.0f);
    }

    public float eli() {
        return this.eli;
    }

    public float DbA() {
        return this.DbA;
    }

    public void eli(float f, float f2) {
        this.eli = f;
        this.DbA = f2;
    }

    public boolean DbA(float f, float f2) {
        return this.eli == f && this.DbA == f2;
    }

    public String toString() {
        return eli() + VastAttributes.HORIZONTAL_POSITION + DbA();
    }
}

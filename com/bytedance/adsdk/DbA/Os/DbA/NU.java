package com.bytedance.adsdk.DbA.Os.DbA;

/* loaded from: classes3.dex */
public class NU implements Os {
    private final com.bytedance.adsdk.DbA.Os.eli.NU<Float, Float> DbA;
    private final String eli;

    public NU(String str, com.bytedance.adsdk.DbA.Os.eli.NU<Float, Float> nu) {
        this.eli = str;
        this.DbA = nu;
    }

    public String eli() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.eli.NU<Float, Float> DbA() {
        return this.DbA;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.dV(fc, eliVar, this);
    }
}

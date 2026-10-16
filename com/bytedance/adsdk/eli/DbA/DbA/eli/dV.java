package com.bytedance.adsdk.eli.DbA.DbA.eli;

/* loaded from: classes3.dex */
public abstract class dV implements com.bytedance.adsdk.eli.DbA.DbA.eli {
    protected com.bytedance.adsdk.eli.DbA.DbA.eli DbA;
    protected com.bytedance.adsdk.eli.DbA.aGH.Os Os;
    protected com.bytedance.adsdk.eli.DbA.DbA.eli eli;

    protected dV(com.bytedance.adsdk.eli.DbA.aGH.Os os) {
        this.Os = os;
    }

    public void eli(com.bytedance.adsdk.eli.DbA.DbA.eli eliVar) {
        this.eli = eliVar;
    }

    public void DbA(com.bytedance.adsdk.eli.DbA.DbA.eli eliVar) {
        this.DbA = eliVar;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public com.bytedance.adsdk.eli.DbA.aGH.ui eli() {
        return com.bytedance.adsdk.eli.DbA.aGH.MGA.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public String DbA() {
        return this.eli.DbA() + this.Os.eli() + this.DbA.DbA();
    }

    public String toString() {
        return DbA();
    }
}

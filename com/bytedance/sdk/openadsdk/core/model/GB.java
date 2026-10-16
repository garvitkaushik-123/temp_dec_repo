package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.utils.eU;

/* loaded from: classes3.dex */
public class GB {
    public long DbA;
    private long FC;
    private long MGA;
    private long aAs;
    private int du;
    public boolean eli;
    private long kb;
    private long ui;
    private long wC;
    private eU Os = eU.Os();
    private eU aGH = eU.Os();

    public void eli(eU eUVar, eU eUVar2, int i, eU eUVar3) {
        this.ui = eUVar.eli(this.Os);
        this.MGA = eUVar2.eli(eUVar);
        this.kb = i;
        this.wC = eUVar3.eli(eUVar2);
    }

    public void eli(eU eUVar) {
        this.Os = eUVar;
    }

    public void DbA(eU eUVar) {
        this.aGH = eUVar;
        this.FC = eUVar.eli(this.Os);
    }

    public eU eli() {
        return this.Os;
    }

    public long DbA() {
        return this.ui;
    }

    public long Os() {
        return this.MGA;
    }

    public long aGH() {
        return this.kb;
    }

    public long ui() {
        return this.wC;
    }

    public long MGA() {
        return this.FC;
    }

    public long kb() {
        return this.aAs;
    }

    public void eli(long j) {
        this.aAs = j;
    }

    public int wC() {
        return this.du;
    }

    public void eli(int i) {
        this.du = i;
    }
}

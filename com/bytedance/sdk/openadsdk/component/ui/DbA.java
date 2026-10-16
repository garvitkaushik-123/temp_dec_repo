package com.bytedance.sdk.openadsdk.component.ui;

import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class DbA {
    private int DbA;
    private String MGA;
    private ev Os;
    private com.bytedance.sdk.openadsdk.core.model.eli aGH;
    private int eli;
    private boolean kb;
    private int ui;

    public DbA(int i, int i2, ev evVar, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        this.eli = i;
        this.DbA = i2;
        this.Os = evVar;
        this.aGH = eliVar;
    }

    public DbA(int i, int i2, int i3, String str) {
        this.eli = i;
        this.DbA = i2;
        this.ui = i3;
        this.MGA = str;
    }

    public com.bytedance.sdk.openadsdk.core.model.eli eli() {
        return this.aGH;
    }

    public void eli(boolean z) {
        this.kb = z;
    }

    public int DbA() {
        return this.eli;
    }

    public int Os() {
        return this.DbA;
    }

    public ev aGH() {
        return this.Os;
    }

    public int ui() {
        return this.ui;
    }

    public String MGA() {
        return this.MGA;
    }
}

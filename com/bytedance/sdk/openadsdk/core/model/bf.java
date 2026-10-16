package com.bytedance.sdk.openadsdk.core.model;

/* loaded from: classes3.dex */
public class bf {
    private long eli = 10000;
    private long DbA = 10000;
    private long Os = 10;
    private long aGH = 20;
    private String ui = "";

    public long eli() {
        return this.eli;
    }

    public void eli(long j) {
        if (j <= 0) {
            this.eli = 10L;
        } else {
            this.eli = j;
        }
    }

    public long DbA() {
        return this.DbA;
    }

    public void DbA(long j) {
        if (j < 0) {
            this.DbA = 20L;
        } else {
            this.DbA = j;
        }
    }

    public long Os() {
        return this.Os;
    }

    public void Os(long j) {
        if (j <= 0) {
            this.Os = 10L;
        } else {
            this.Os = j;
        }
    }

    public long aGH() {
        return this.aGH;
    }

    public void aGH(long j) {
        if (j < 0) {
            this.aGH = 20L;
        } else {
            this.aGH = j;
        }
    }

    public String ui() {
        return this.ui;
    }

    public void eli(String str) {
        this.ui = str;
    }
}

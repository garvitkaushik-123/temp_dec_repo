package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class nGm {
    private int DbA;
    private String MGA;
    private int Os;
    private double aGH;
    private String eli;
    private boolean ui;

    public String eli() {
        return this.eli;
    }

    public void eli(String str) {
        this.eli = str;
    }

    public int DbA() {
        return this.DbA;
    }

    public void eli(int i) {
        this.DbA = i;
    }

    public int Os() {
        return this.Os;
    }

    public void DbA(int i) {
        this.Os = i;
    }

    public double aGH() {
        return this.aGH;
    }

    public boolean ui() {
        return !TextUtils.isEmpty(this.eli) && this.DbA > 0 && this.Os > 0;
    }

    public boolean MGA() {
        return this.ui;
    }

    public void eli(boolean z) {
        this.ui = z;
    }

    public String kb() {
        return this.MGA;
    }

    public void DbA(String str) {
        this.MGA = str;
    }
}

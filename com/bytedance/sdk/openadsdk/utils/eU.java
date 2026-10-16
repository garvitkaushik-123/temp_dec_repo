package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class eU {
    private long DbA;
    public long eli;

    public long eli() {
        return this.DbA;
    }

    private eU(boolean z) {
        if (z) {
            ui();
        }
    }

    public static eU DbA() {
        return new eU(true);
    }

    public static eU Os() {
        return new eU(false);
    }

    public long aGH() {
        return SystemClock.elapsedRealtime() - this.DbA;
    }

    public long eli(eU eUVar) {
        return Math.abs(eUVar.DbA - this.DbA);
    }

    public void ui() {
        this.eli = System.currentTimeMillis();
        this.DbA = SystemClock.elapsedRealtime();
    }

    public boolean MGA() {
        return this.DbA > 0;
    }

    public String toString() {
        return String.valueOf(this.eli);
    }
}

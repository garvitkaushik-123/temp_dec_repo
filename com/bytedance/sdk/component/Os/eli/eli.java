package com.bytedance.sdk.component.Os.eli;

import android.os.SystemClock;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class eli {
    long DbA;
    long MGA;
    long Os;
    long aGH;
    long eli = SystemClock.elapsedRealtime();
    long kb;
    long ui;
    long wC;

    public void eli() {
        this.Os = SystemClock.elapsedRealtime();
    }

    public void DbA() {
        this.aGH = SystemClock.elapsedRealtime();
    }

    public void Os() {
        this.ui = SystemClock.elapsedRealtime();
    }

    public long aGH() {
        return this.eli;
    }

    public void ui() {
        this.MGA = SystemClock.elapsedRealtime();
    }

    public long MGA() {
        return this.MGA;
    }

    public long kb() {
        return this.Os;
    }

    public long wC() {
        return this.aGH;
    }

    public long FC() {
        return this.ui;
    }

    public long aAs() {
        return this.kb;
    }

    public void du() {
        this.kb = SystemClock.elapsedRealtime();
    }

    public long nlS() {
        return this.wC;
    }

    public void NU() {
        this.wC = SystemClock.elapsedRealtime();
    }

    public long nn() {
        return this.DbA;
    }

    public void Dfc() {
        this.DbA = SystemClock.elapsedRealtime();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.eli + ", asyncCallExecTs=" + this.DbA + ", requestStartExecTs=" + this.Os + ", requestConnectStartTs=" + this.aGH + ", requestConnectFinishTs=" + this.ui + ", reqCallServerStartTs=" + this.kb + ", reqCallServerFinishTs=" + this.wC + AbstractJsonLexerKt.END_OBJ;
    }
}

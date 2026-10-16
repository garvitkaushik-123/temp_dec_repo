package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class aAs extends kb {
    private long DbA;
    private long eli;

    @Override // com.bytedance.sdk.openadsdk.core.widget.kb
    protected boolean eli() {
        return false;
    }

    public aAs(Context context) {
        super(context);
        setVisibility(8);
        setClickable(true);
    }

    public void Os() {
        setVisibility(8);
        if (this.eli != 0) {
            this.DbA = SystemClock.elapsedRealtime();
        }
    }

    public void DbA(ev evVar, int i) {
        if (isShown()) {
            return;
        }
        DbA();
        setVisibility(0);
        this.eli = SystemClock.elapsedRealtime();
        eli(evVar, i);
    }

    public boolean aGH() {
        return this.eli > 0 && this.DbA > 0;
    }

    public long getDisplayDuration() {
        if (this.eli == 0) {
            return 0L;
        }
        if (this.DbA == 0) {
            this.DbA = SystemClock.elapsedRealtime();
        }
        return this.DbA - this.eli;
    }
}

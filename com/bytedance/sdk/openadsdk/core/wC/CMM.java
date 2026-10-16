package com.bytedance.sdk.openadsdk.core.wC;

import android.os.SystemClock;
import com.ironsource.C3040d4;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class CMM implements com.bytedance.sdk.openadsdk.core.aAs.kb.Os {
    private String MGA;
    private long eli = 0;
    private long DbA = 0;
    private int Os = 0;
    private String aGH = null;
    private String ui = null;
    private final AtomicBoolean kb = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
    public void eli(String str) {
        this.MGA = str;
        this.eli = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
    public void eli(int i, String str, String str2) {
        this.Os = i;
        this.aGH = str;
        this.ui = str2;
        this.DbA = SystemClock.elapsedRealtime();
        this.kb.set(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
    public void DbA(String str) {
        this.ui = str;
        this.DbA = SystemClock.elapsedRealtime();
        this.kb.set(true);
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, String str) {
        if (this.kb.get()) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, false, str, "success", this.DbA - this.eli, this.ui, this.MGA, 0, null);
        } else {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, false, str, C3040d4.f.e, this.DbA - this.eli, this.ui, this.MGA, this.Os, this.aGH);
        }
    }
}

package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;

/* loaded from: classes4.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1240a = true;
    public String b;

    public boolean getAllowFullscreen() {
        return this.f1240a;
    }

    public String getMediationName() {
        return IAConfigManager.O.l;
    }

    public String getMediationVersion() {
        return IAConfigManager.O.n;
    }
}

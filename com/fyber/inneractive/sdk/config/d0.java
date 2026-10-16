package com.fyber.inneractive.sdk.config;

/* loaded from: classes4.dex */
public final class d0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1079a;

    public d0(IAConfigManager iAConfigManager) {
        this.f1079a = iAConfigManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAConfigManager iAConfigManager = this.f1079a;
        if (iAConfigManager.p == null) {
            iAConfigManager.p = j.a(iAConfigManager.f);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new c0(this));
    }
}

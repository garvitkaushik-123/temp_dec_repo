package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class p0 implements com.digitalturbine.ignite.authenticator.listeners.internal.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1814a;
    public final /* synthetic */ String b;
    public final /* synthetic */ v0 c;

    public p0(v0 v0Var, String str, String str2) {
        this.c = v0Var;
        this.f1814a = str;
        this.b = str2;
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.internal.a
    public final void a() {
        v0 v0Var = this.c;
        v0Var.b.a(v0Var.c, new com.fyber.inneractive.sdk.ignite.g(v0Var.f, v0Var.d, v0Var.h.f1242a));
        this.c.d("onShowInstallStarted();");
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.internal.a
    public final void a(String str) {
        v0 v0Var = this.c;
        v0Var.b.m();
        v0Var.d("onInstallationFailed();");
        v0 v0Var2 = this.c;
        v0Var2.h.a(com.fyber.inneractive.sdk.network.t.IGNITE_FLOW_FAILED_TO_INSTALL_APP, this.f1814a, this.b, v0Var2.d);
    }
}

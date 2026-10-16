package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name */
    public final String f1802a;
    public final com.fyber.inneractive.sdk.util.e1 b;
    public final /* synthetic */ i c;

    public h(i iVar, String str, com.fyber.inneractive.sdk.util.e1 e1Var) {
        this.c = iVar;
        this.b = e1Var;
        this.f1802a = str;
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final String a() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final String c() {
        return "open";
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final void d() {
        i iVar = this.c;
        String str = this.f1802a;
        com.fyber.inneractive.sdk.util.e1 e1Var = this.b;
        j1 j1Var = iVar.g;
        if (j1Var != null) {
            com.fyber.inneractive.sdk.util.e0 e0Var = j1Var.a(str, e1Var).f1751a;
        }
    }

    public final String toString() {
        return "action: open url: " + this.f1802a;
    }
}

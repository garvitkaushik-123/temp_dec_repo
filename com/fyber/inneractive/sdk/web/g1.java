package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class g1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f1801a;

    public g1(i1 i1Var) {
        this.f1801a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.measurement.tracker.e eVar;
        i1 i1Var = this.f1801a;
        if (i1Var.H == null || (eVar = i1Var.I) == null) {
            return;
        }
        eVar.c();
    }
}

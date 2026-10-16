package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class l0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f1807a;

    public l0(m0 m0Var) {
        this.f1807a = m0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v0 v0Var = this.f1807a.f1809a;
        if (v0Var.y) {
            return;
        }
        v0Var.e(v0Var.k);
    }
}

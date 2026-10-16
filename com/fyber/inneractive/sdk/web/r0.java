package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f1818a;

    public r0(v0 v0Var) {
        this.f1818a = v0Var;
    }

    public final void a(boolean z) {
        if (this.f1818a.u.compareAndSet(false, true)) {
            this.f1818a.d("onCancelResult(" + z + ");");
            this.f1818a.v.set(false);
        }
    }
}

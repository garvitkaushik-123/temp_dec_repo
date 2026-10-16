package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class e1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f1798a;

    public e1(i1 i1Var) {
        this.f1798a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m mVar = this.f1798a.b;
        if (mVar != null) {
            mVar.getViewTreeObserver().addOnPreDrawListener(this.f1798a.K);
        }
    }
}

package com.fyber.inneractive.sdk.web;

import android.view.ViewTreeObserver;

/* loaded from: classes4.dex */
public final class f1 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f1800a;

    public f1(i1 i1Var) {
        this.f1800a = i1Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        m mVar;
        m mVar2 = this.f1800a.b;
        if (mVar2 == null) {
            return false;
        }
        mVar2.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f1800a.k();
        i1 i1Var = this.f1800a;
        i1Var.a(new com.fyber.inneractive.sdk.mraid.b0(i1Var.G));
        i1 i1Var2 = this.f1800a;
        if (i1Var2.G == c0.INTERSTITIAL && (mVar = i1Var2.b) != null) {
            mVar.a("if (window.showInterstitial) { showInterstitial(); }");
        }
        this.f1800a.j();
        i1 i1Var3 = this.f1800a;
        i1Var3.a(com.fyber.inneractive.sdk.util.o.a(i1Var3.b), true);
        this.f1800a.n();
        com.fyber.inneractive.sdk.util.r.b.postDelayed(this.f1800a.L, 100L);
        return false;
    }
}

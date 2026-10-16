package com.fyber.inneractive.sdk.web;

import android.view.ViewTreeObserver;

/* loaded from: classes4.dex */
public final class p implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1813a;

    public p(i0 i0Var) {
        this.f1813a = i0Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        m mVar = this.f1813a.b;
        if (mVar == null) {
            return false;
        }
        mVar.getViewTreeObserver().removeOnPreDrawListener(this);
        i0 i0Var = this.f1813a;
        i0Var.a(i0Var.b.getContext(), true);
        return false;
    }
}

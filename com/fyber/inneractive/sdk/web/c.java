package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1792a;

    public c(i1 i1Var) {
        this.f1792a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.e("Removing clicked state after timeout", new Object[0]);
        this.f1792a.i();
    }
}

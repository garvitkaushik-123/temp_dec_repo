package com.fyber.inneractive.sdk.web;

/* loaded from: classes4.dex */
public final class a1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f1790a;

    public a1(b1 b1Var) {
        this.f1790a = b1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1790a.f1791a.evictAll();
        } catch (Throwable unused) {
        }
    }
}

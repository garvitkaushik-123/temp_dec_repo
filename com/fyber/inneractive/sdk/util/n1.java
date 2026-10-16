package com.fyber.inneractive.sdk.util;

/* loaded from: classes4.dex */
public final class n1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q1 f1769a;

    public n1(q1 q1Var) {
        this.f1769a = q1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q1 q1Var = this.f1769a;
        q1Var.getClass();
        r.f1777a.execute(new p1(q1Var));
    }
}

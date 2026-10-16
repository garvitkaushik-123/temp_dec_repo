package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f1251a;

    public z(a0 a0Var) {
        this.f1251a = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a0 a0Var = this.f1251a;
        a0Var.getClass();
        IAlog.a("%sRe-enabling clicks, grace period has passed", IAlog.a(a0Var));
        a0 a0Var2 = this.f1251a;
        a0Var2.f = true;
        a0Var2.g = null;
    }
}

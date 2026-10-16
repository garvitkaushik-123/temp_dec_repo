package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r1;
import com.fyber.inneractive.sdk.util.t1;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class j0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f1206a;
    public final /* synthetic */ n0 b;

    public j0(n0 n0Var, long j) {
        this.b = n0Var;
        this.f1206a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.G()) {
            n0 n0Var = this.b;
            n0Var.n = new i0(this);
            long a2 = n0Var.a(this.f1206a);
            n0 n0Var2 = this.b;
            n0Var2.getClass();
            t1 t1Var = new t1(TimeUnit.MILLISECONDS, a2);
            n0Var2.o = t1Var;
            t1Var.e = new m0(n0Var2);
            r1 r1Var = new r1(t1Var);
            t1Var.c = r1Var;
            t1Var.d = false;
            r1Var.sendEmptyMessage(1932593528);
            n0 n0Var3 = this.b;
            n0Var3.getClass();
            IAlog.a("%sad contains custom close. Will show transparent x in %d", IAlog.a(n0Var3), Long.valueOf(a2));
            this.b.l = null;
        } else {
            n0 n0Var4 = this.b;
            n0Var4.getClass();
            IAlog.a("%sad does not contain custom close. Showing close button", IAlog.a(n0Var4));
            this.b.d(false);
        }
        Runnable runnable = this.b.l;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.b.l = null;
        }
    }
}

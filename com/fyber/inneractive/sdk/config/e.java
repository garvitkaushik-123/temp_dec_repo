package com.fyber.inneractive.sdk.config;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.util.r1;
import com.fyber.inneractive.sdk.util.t1;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class e implements r {
    public t1 c;
    public final x0 d;
    public final d f;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f1080a = new AtomicBoolean(false);
    public boolean b = false;
    public final Handler e = new Handler(Looper.getMainLooper(), new b(this));

    public e(x0 x0Var) {
        c cVar = new c(this);
        this.f = new d(this);
        this.d = x0Var;
        Application application = com.fyber.inneractive.sdk.util.o.f1770a;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(cVar);
        }
    }

    public final void a() {
        s sVar = IAConfigManager.O.u;
        if (!sVar.d) {
            sVar.c.add(this);
        }
        t1 t1Var = new t1(TimeUnit.MINUTES, r0.u.b.a("session_duration", 30, 1));
        this.c = t1Var;
        t1Var.e = this.f;
    }

    @Override // com.fyber.inneractive.sdk.config.r
    public final void onGlobalConfigChanged(s sVar, o oVar) {
        t1 t1Var = this.c;
        if (t1Var != null) {
            t1Var.d = false;
            t1Var.f = 0L;
            r1 r1Var = t1Var.c;
            if (r1Var != null) {
                r1Var.removeMessages(1932593528);
            }
            t1 t1Var2 = new t1(TimeUnit.MINUTES, oVar.a("session_duration", 30, 1), this.c.f);
            this.c = t1Var2;
            t1Var2.e = this.f;
        }
        sVar.c.remove(this);
    }
}

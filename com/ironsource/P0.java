package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes6.dex */
public class P0 {

    /* renamed from: a, reason: collision with root package name */
    private final N0 f2985a;
    private final InterfaceC3216nb b;
    private final C3064eb c = c();
    private Timer d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            P0.this.b.b();
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            P0.this.b.b();
        }
    }

    public P0(N0 n0, InterfaceC3216nb interfaceC3216nb) {
        this.f2985a = n0;
        this.b = interfaceC3216nb;
    }

    private synchronized void b(long j) {
        j();
        Timer timer = new Timer();
        this.d = timer;
        timer.schedule(new b(), j);
    }

    private C3064eb c() {
        return new C3064eb(new a(), com.ironsource.lifecycle.b.d(), new Ff());
    }

    private synchronized void j() {
        Timer timer = this.d;
        if (timer != null) {
            timer.cancel();
            this.d = null;
        }
    }

    public void a() {
        if (this.f2985a.a() == N0.a.MANUAL_WITH_AUTOMATIC_RELOAD) {
            IronLog.INTERNAL.verbose();
            i();
        }
    }

    protected boolean d() {
        return this.f2985a.c() > 0;
    }

    public void e() {
        if (this.f2985a.e()) {
            IronLog.INTERNAL.verbose();
            b(this.f2985a.c());
        }
    }

    public void f() {
        if (this.f2985a.a() == N0.a.AUTOMATIC_LOAD_AFTER_CLOSE) {
            IronLog.INTERNAL.verbose();
            b(this.f2985a.d());
        }
    }

    public void g() {
        if (this.f2985a.e()) {
            IronLog.INTERNAL.verbose();
            b(0L);
        }
    }

    public void h() {
        if (this.f2985a.a() != N0.a.AUTOMATIC_LOAD_WHILE_SHOW || this.f2985a.d() < 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        b(this.f2985a.d());
    }

    protected void i() {
        C3064eb c3064eb = this.c;
        if (c3064eb != null) {
            c3064eb.b();
        }
    }

    public void k() {
        if (this.f2985a.a() != N0.a.MANUAL_WITH_AUTOMATIC_RELOAD || this.f2985a.b() <= 0) {
            return;
        }
        IronLog.INTERNAL.verbose();
        a(this.f2985a.b());
    }

    protected N0 b() {
        return this.f2985a;
    }

    protected void a(long j) {
        C3064eb c3064eb = this.c;
        if (c3064eb != null) {
            c3064eb.a(j);
        }
    }
}

package com.ironsource;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.ironsource.fb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3081fb implements W9 {
    private Timer b;
    private long e;
    private Runnable f;

    /* renamed from: a, reason: collision with root package name */
    private String f3298a = "INTERNAL";
    private boolean c = false;
    private Long d = null;

    /* renamed from: com.ironsource.fb$a */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C3081fb.this.f.run();
        }
    }

    public C3081fb(long j, Runnable runnable, boolean z) {
        this.e = j;
        this.f = runnable;
        if (z) {
            g();
        }
    }

    private synchronized void f() {
        Timer timer = this.b;
        if (timer != null) {
            timer.cancel();
            this.b = null;
        }
    }

    private synchronized void h() {
        if (this.b == null) {
            Timer timer = new Timer();
            this.b = timer;
            timer.schedule(new a(), this.e);
            Calendar.getInstance().setTimeInMillis(this.d.longValue());
        }
    }

    @Override // com.ironsource.W9
    public void a() {
        if (this.b != null) {
            f();
        }
    }

    @Override // com.ironsource.W9
    public void b() {
        Long l;
        if (this.b == null && (l = this.d) != null) {
            long longValue = l.longValue() - System.currentTimeMillis();
            this.e = longValue;
            if (longValue > 0) {
                h();
            } else {
                e();
                this.f.run();
            }
        }
    }

    @Override // com.ironsource.W9
    public void c() {
    }

    @Override // com.ironsource.W9
    public void d() {
    }

    public void e() {
        f();
        this.c = false;
        this.d = null;
        com.ironsource.lifecycle.b.d().b(this);
    }

    public void g() {
        if (this.c) {
            return;
        }
        this.c = true;
        com.ironsource.lifecycle.b.d().a(this);
        this.d = Long.valueOf(System.currentTimeMillis() + this.e);
        if (com.ironsource.lifecycle.b.d().e()) {
            return;
        }
        h();
    }
}

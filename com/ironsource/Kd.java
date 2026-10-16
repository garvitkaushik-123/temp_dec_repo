package com.ironsource;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes6.dex */
public class Kd {

    /* renamed from: a, reason: collision with root package name */
    private C3241p2 f2929a;
    private Ld b;
    private Timer c = null;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Kd.this.b.b();
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Kd.this.b.b();
        }
    }

    public Kd(C3241p2 c3241p2, Ld ld) {
        this.f2929a = c3241p2;
        this.b = ld;
    }

    private void d() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }

    public synchronized void a() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new b(), this.f2929a.b());
    }

    public void b() {
        synchronized (this) {
            d();
        }
        this.b.b();
    }

    public synchronized void c() {
        d();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new a(), this.f2929a.j());
    }
}

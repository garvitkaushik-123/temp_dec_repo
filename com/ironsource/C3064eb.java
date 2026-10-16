package com.ironsource;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.ironsource.eb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3064eb {
    private static final String g = "eb";

    /* renamed from: a, reason: collision with root package name */
    private final com.ironsource.lifecycle.b f3271a;
    private final Runnable b;
    private final Ff c;
    private Timer e;
    private final Object d = new Object();
    private final W9 f = new a();

    /* renamed from: com.ironsource.eb$a */
    class a implements W9 {
        a() {
        }

        @Override // com.ironsource.W9
        public void a() {
            C3064eb.this.c.c(System.currentTimeMillis());
            C3064eb.this.c();
        }

        @Override // com.ironsource.W9
        public void b() {
            C3064eb.this.c.b(System.currentTimeMillis());
            C3064eb c3064eb = C3064eb.this;
            c3064eb.b(c3064eb.c.a());
        }

        @Override // com.ironsource.W9
        public void c() {
        }

        @Override // com.ironsource.W9
        public void d() {
        }
    }

    /* renamed from: com.ironsource.eb$b */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C3064eb c3064eb = C3064eb.this;
            c3064eb.f3271a.b(c3064eb.f);
            C3064eb.this.c.b();
            C3064eb.this.b.run();
        }
    }

    public C3064eb(Runnable runnable, com.ironsource.lifecycle.b bVar, Ff ff) {
        this.b = runnable;
        this.f3271a = bVar;
        this.c = ff;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.d) {
            Timer timer = this.e;
            if (timer != null) {
                timer.cancel();
                this.e = null;
            }
        }
    }

    public void a() {
        a(0L);
    }

    public void b() {
        c();
        this.f3271a.b(this.f);
        this.c.b();
    }

    public void a(long j) {
        if (j < 0) {
            Log.d(g, "cannot start timer with delay < 0");
            return;
        }
        this.f3271a.a(this.f);
        this.c.a(j);
        if (this.f3271a.e()) {
            this.c.c(System.currentTimeMillis());
        } else {
            b(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        synchronized (this.d) {
            c();
            Timer timer = new Timer();
            this.e = timer;
            timer.schedule(new b(), j);
        }
    }
}

package com.applovin.impl;

import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class d7 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f437a;
    private Timer b;
    private long c;
    private long d;
    private long e;
    private boolean f;
    private final Runnable g;
    private long h;
    private final Object i = new Object();

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                d7.this.g.run();
                synchronized (d7.this.i) {
                    if (d7.this.f) {
                        d7.this.c = System.currentTimeMillis();
                        d7 d7Var = d7.this;
                        d7Var.d = d7Var.e;
                    } else {
                        d7.this.b = null;
                    }
                }
            } catch (Throwable th) {
                try {
                    if (d7.this.f437a != null) {
                        d7.this.f437a.O();
                        if (com.applovin.impl.sdk.o.a()) {
                            d7.this.f437a.O().a("Timer", "Encountered error while executing timed task", th);
                        }
                        d7.this.f437a.E().a("Timer", "executingTimedTask", th);
                    }
                    synchronized (d7.this.i) {
                        if (d7.this.f) {
                            d7.this.c = System.currentTimeMillis();
                            d7 d7Var2 = d7.this;
                            d7Var2.d = d7Var2.e;
                        } else {
                            d7.this.b = null;
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (d7.this.i) {
                        if (d7.this.f) {
                            d7.this.c = System.currentTimeMillis();
                            d7 d7Var3 = d7.this;
                            d7Var3.d = d7Var3.e;
                        } else {
                            d7.this.b = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    private d7(com.applovin.impl.sdk.k kVar, Runnable runnable) {
        this.f437a = kVar;
        this.g = runnable;
    }

    public long c() {
        if (this.b == null) {
            return this.d - this.h;
        }
        return this.d - (System.currentTimeMillis() - this.c);
    }

    public void d() {
        synchronized (this.i) {
            Timer timer = this.b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.h = Math.max(1L, System.currentTimeMillis() - this.c);
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.k kVar = this.f437a;
                        if (kVar != null) {
                            kVar.O();
                            if (com.applovin.impl.sdk.o.a()) {
                                this.f437a.O();
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.f437a.O().a("Timer", "Encountered error while pausing timer", th);
                                }
                            }
                        }
                        this.b = null;
                    } finally {
                        this.b = null;
                    }
                }
            }
        }
    }

    public void e() {
        d7 d7Var;
        synchronized (this.i) {
            try {
                try {
                    long j = this.h;
                    if (j > 0) {
                        try {
                            long j2 = this.d - j;
                            this.d = j2;
                            if (j2 < 0) {
                                this.d = 0L;
                            }
                            this.b = new Timer();
                            d7Var = this;
                            try {
                                d7Var.a(b(), this.d, this.f, this.e);
                                d7Var.c = System.currentTimeMillis();
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    com.applovin.impl.sdk.k kVar = d7Var.f437a;
                                    if (kVar != null) {
                                        kVar.O();
                                        if (com.applovin.impl.sdk.o.a()) {
                                            d7Var.f437a.O();
                                            if (com.applovin.impl.sdk.o.a()) {
                                                d7Var.f437a.O().a("Timer", "Encountered error while resuming timer", th);
                                            }
                                        }
                                    }
                                    d7Var.h = 0L;
                                } finally {
                                    d7Var.h = 0L;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            d7Var = this;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    private TimerTask b() {
        return new a();
    }

    public static d7 a(long j, com.applovin.impl.sdk.k kVar, Runnable runnable) {
        return a(j, false, kVar, runnable);
    }

    public static d7 a(long j, boolean z, com.applovin.impl.sdk.k kVar, Runnable runnable) {
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create a scheduled timer. Invalid fire time passed in: " + j + ".");
        }
        if (runnable != null) {
            d7 d7Var = new d7(kVar, runnable);
            d7Var.c = System.currentTimeMillis();
            d7Var.d = j;
            d7Var.f = z;
            d7Var.e = j;
            try {
                d7Var.b = new Timer();
                d7Var.a(d7Var.b(), j, z, d7Var.e);
                return d7Var;
            } catch (OutOfMemoryError e) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("Timer", "Failed to create timer due to OOM error", e);
                }
                return d7Var;
            }
        }
        throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
    }

    public void a() {
        synchronized (this.i) {
            Timer timer = this.b;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.b = null;
                } catch (Throwable th) {
                    try {
                        com.applovin.impl.sdk.k kVar = this.f437a;
                        if (kVar != null) {
                            kVar.O();
                            if (com.applovin.impl.sdk.o.a()) {
                                this.f437a.O();
                                if (com.applovin.impl.sdk.o.a()) {
                                    this.f437a.O().a("Timer", "Encountered error while cancelling timer", th);
                                }
                            }
                        }
                        this.b = null;
                    } catch (Throwable th2) {
                        this.b = null;
                        this.h = 0L;
                        throw th2;
                    }
                }
                this.h = 0L;
            }
        }
    }

    private void a(TimerTask timerTask, long j, boolean z, long j2) {
        if (z) {
            this.b.schedule(timerTask, j, j2);
        } else {
            this.b.schedule(timerTask, j);
        }
    }
}

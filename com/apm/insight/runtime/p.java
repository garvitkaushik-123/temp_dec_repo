package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: ThreadWithHandler.java */
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final HandlerThread f344a;
    private volatile Handler d;
    private final Queue<c> b = new ConcurrentLinkedQueue();
    private final Queue<Message> c = new ConcurrentLinkedQueue();
    private final Object e = new Object();

    public p(String str) {
        this.f344a = new b(str);
    }

    public final Handler a() {
        return this.d;
    }

    public final void b() {
        this.f344a.start();
    }

    public final HandlerThread c() {
        return this.f344a;
    }

    private Message b(Runnable runnable) {
        return Message.obtain(this.d, runnable);
    }

    public final boolean a(Runnable runnable) {
        return a(b(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j) {
        return a(b(runnable), j);
    }

    static {
        new Object() { // from class: com.apm.insight.runtime.p.1
        };
        new Object() { // from class: com.apm.insight.runtime.p.2
        };
    }

    private boolean a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j);
    }

    private boolean b(Message message, long j) {
        if (this.d == null) {
            synchronized (this.e) {
                if (this.d == null) {
                    this.b.add(new c(message, j));
                    return true;
                }
            }
        }
        try {
            return this.d.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* compiled from: ThreadWithHandler.java */
    class b extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        private volatile int f346a;
        private volatile boolean b;

        b(String str) {
            super(str);
            this.f346a = 0;
            this.b = false;
        }

        @Override // android.os.HandlerThread
        protected final void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (p.this.e) {
                p.this.d = new Handler();
            }
            p.this.d.post(p.this.new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    try {
                        com.apm.insight.b.f.a(com.apm.insight.e.g()).a().c();
                        if (this.f346a < 5) {
                            com.apm.insight.c.a();
                            j.a(th, "NPTH_CATCH");
                        } else if (!this.b) {
                            this.b = true;
                            com.apm.insight.c.a();
                            j.a(new RuntimeException(), "NPTH_ERR_MAX");
                        }
                        this.f346a++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* compiled from: ThreadWithHandler.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!p.this.c.isEmpty()) {
                if (p.this.d != null) {
                    try {
                        p.this.d.sendMessageAtFrontOfQueue((Message) p.this.c.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
            while (!p.this.b.isEmpty()) {
                c cVar = (c) p.this.b.poll();
                if (p.this.d != null) {
                    try {
                        p.this.d.sendMessageAtTime(cVar.f347a, cVar.b);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    /* compiled from: ThreadWithHandler.java */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        Message f347a;
        long b;

        c(Message message, long j) {
            this.f347a = message;
            this.b = j;
        }
    }
}

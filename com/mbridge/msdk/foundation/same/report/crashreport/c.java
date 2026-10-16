package com.mbridge.msdk.foundation.same.report.crashreport;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

/* compiled from: AnrMonitor.java */
/* loaded from: classes6.dex */
public class c extends Thread {
    private static volatile c e;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f4313a;
    private volatile b b;
    private com.mbridge.msdk.foundation.same.report.crashreport.a c;
    private int d;

    /* compiled from: AnrMonitor.java */
    private class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private long f4314a;
        private boolean b;
        private long c;

        private b() {
            this.f4314a = SystemClock.uptimeMillis();
        }

        void b() {
            this.b = false;
            this.c = SystemClock.uptimeMillis();
            c.this.f4313a.postAtFrontOfQueue(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                this.b = true;
                this.f4314a = SystemClock.uptimeMillis();
            }
        }

        boolean a() {
            return !this.b || this.f4314a - this.c >= ((long) c.this.d);
        }
    }

    private c() {
        super("AnrMonitor-Thread");
        this.f4313a = new Handler(Looper.getMainLooper());
        this.d = 5000;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            if (isInterrupted() || !(this.b == null || this.b.b)) {
                try {
                    Thread.sleep(this.d);
                } catch (Exception unused) {
                }
            } else {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = new b();
                    }
                    this.b.b();
                    long j = this.d;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    while (j > 0) {
                        try {
                            wait(j);
                        } catch (InterruptedException e2) {
                            Log.w("AnrMonitor", e2.toString());
                        }
                        j = this.d - (SystemClock.uptimeMillis() - uptimeMillis);
                    }
                    if (!this.b.a()) {
                        com.mbridge.msdk.foundation.same.report.crashreport.a aVar = this.c;
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.c != null) {
                        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                        this.c.a(d.b(stackTrace), stackTrace);
                    }
                }
            }
        }
    }

    public static c a() {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c();
                }
            }
        }
        return e;
    }

    public c a(int i, com.mbridge.msdk.foundation.same.report.crashreport.a aVar) {
        this.d = i;
        this.c = aVar;
        return this;
    }
}

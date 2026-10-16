package com.mbridge.msdk.tracker.network;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: NetworkDispatcher.java */
/* loaded from: classes6.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<t<?>> f4945a;
    private final m b;
    private final b c;
    private final w d;
    private volatile boolean e = false;

    public n(BlockingQueue<t<?>> blockingQueue, m mVar, b bVar, w wVar) {
        this.f4945a = blockingQueue;
        this.b = mVar;
        this.c = bVar;
        this.d = wVar;
    }

    private void a(t<?> tVar) {
        TrafficStats.setThreadStatsTag(tVar.s());
    }

    void b(t<?> tVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tVar.a(3);
        try {
            try {
                tVar.a("network-queue-take");
            } catch (b0 e) {
                e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                a(tVar, e);
                tVar.x();
            } catch (Exception e2) {
                c0.a(e2, "Unhandled exception %s", e2.toString());
                a0 a0Var = new a0(e2);
                a0Var.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.d.a(tVar, a0Var);
                tVar.x();
            }
            if (tVar.v()) {
                tVar.c("network-discard-cancelled");
                tVar.x();
                return;
            }
            if (tVar.y()) {
                a(tVar);
            }
            q a2 = this.b.a(tVar);
            tVar.a("network-http-complete");
            if (a2.e && tVar.u()) {
                tVar.c("not-modified");
                tVar.x();
                return;
            }
            v<?> a3 = tVar.a(a2);
            tVar.a("network-parse-complete");
            if (tVar.z() && a3.b != null) {
                this.c.a(tVar.e(), a3.b);
                tVar.a("network-cache-written");
            }
            tVar.w();
            this.d.a(tVar, a3);
            tVar.a(a3);
        } finally {
            tVar.a(4);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                c0.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void a() throws InterruptedException {
        b(this.f4945a.take());
    }

    private void a(t<?> tVar, b0 b0Var) {
        this.d.a(tVar, tVar.c(b0Var));
    }
}

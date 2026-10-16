package com.mbridge.msdk.tracker;

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ExecutorManager.java */
/* loaded from: classes6.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private volatile ThreadPoolExecutor f4927a;

    /* compiled from: ExecutorManager.java */
    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "MBridgeTrackThread");
        }
    }

    /* compiled from: ExecutorManager.java */
    private static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f4929a;

        public b(Runnable runnable) {
            this.f4929a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y.b(this.f4929a)) {
                return;
            }
            try {
                this.f4929a.run();
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.f4921a) {
                    Log.e("TrackManager", "execute error", e);
                }
            }
        }
    }

    public void a(Runnable runnable) {
        if (this.f4927a == null) {
            this.f4927a = a();
        }
        if (this.f4927a.isShutdown()) {
            return;
        }
        this.f4927a.execute(new b(runnable));
    }

    private ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(), new ThreadPoolExecutor.DiscardPolicy());
    }
}

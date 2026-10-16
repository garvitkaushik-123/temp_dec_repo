package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

/* loaded from: classes6.dex */
final class BackgroundPoster implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f4154a = new PendingPostQueue();
    private volatile boolean b;
    private final EventBus c;

    BackgroundPoster(EventBus eventBus) {
        this.c = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        PendingPost a2 = PendingPost.a(subscription, obj);
        synchronized (this) {
            this.f4154a.a(a2);
            if (!this.b) {
                this.b = true;
                EventBus.n.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                PendingPost a2 = this.f4154a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f4154a.a();
                        if (a2 == null) {
                            return;
                        }
                    }
                }
                this.c.a(a2);
            } catch (InterruptedException e) {
                Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                return;
            } finally {
                this.b = false;
            }
        }
    }
}

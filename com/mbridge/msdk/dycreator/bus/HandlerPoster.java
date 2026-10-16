package com.mbridge.msdk.dycreator.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes6.dex */
final class HandlerPoster extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final PendingPostQueue f4160a;
    private final int b;
    private final EventBus c;
    private boolean d;

    HandlerPoster(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.c = eventBus;
        this.b = i;
        this.f4160a = new PendingPostQueue();
    }

    void a(Subscription subscription, Object obj) {
        PendingPost a2 = PendingPost.a(subscription, obj);
        synchronized (this) {
            this.f4160a.a(a2);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost a2 = this.f4160a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f4160a.a();
                        if (a2 == null) {
                            return;
                        }
                    }
                }
                this.c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.d = true;
        } finally {
            this.d = false;
        }
    }
}

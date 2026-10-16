package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.ironsource.af, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C2997af extends Thread {
    private static C2997af b;

    /* renamed from: a, reason: collision with root package name */
    private a f3185a;

    /* renamed from: com.ironsource.af$a */
    private class a extends HandlerThread {

        /* renamed from: a, reason: collision with root package name */
        private Handler f3186a;

        a(String str) {
            super(str);
            setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.d());
        }

        Handler a() {
            return this.f3186a;
        }

        void b() {
            this.f3186a = new Handler(getLooper());
        }
    }

    private C2997af() {
        a aVar = new a(getClass().getSimpleName());
        this.f3185a = aVar;
        aVar.start();
        this.f3185a.b();
    }

    public static synchronized C2997af a() {
        C2997af c2997af;
        synchronized (C2997af.class) {
            if (b == null) {
                b = new C2997af();
            }
            c2997af = b;
        }
        return c2997af;
    }

    public synchronized void a(Runnable runnable) {
        a aVar = this.f3185a;
        if (aVar == null) {
            return;
        }
        Handler a2 = aVar.a();
        if (a2 != null) {
            a2.post(runnable);
        }
    }
}

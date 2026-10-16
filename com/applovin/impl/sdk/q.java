package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes2.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private final Queue f726a = new LinkedList();
    private final Object b = new Object();

    q() {
    }

    void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.b) {
            if (b() <= 25) {
                this.f726a.offer(appLovinAdImpl);
            } else {
                o.h("AppLovinSdk", "Maximum queue capacity reached - discarding ad...");
            }
        }
    }

    int b() {
        int size;
        synchronized (this.b) {
            size = this.f726a.size();
        }
        return size;
    }

    boolean c() {
        boolean z;
        synchronized (this.b) {
            z = b() == 0;
        }
        return z;
    }

    AppLovinAdImpl d() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.b) {
            appLovinAdImpl = (AppLovinAdImpl) this.f726a.peek();
        }
        return appLovinAdImpl;
    }

    void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.b) {
            this.f726a.remove(appLovinAdImpl);
        }
    }

    AppLovinAdImpl a() {
        AppLovinAdImpl appLovinAdImpl;
        synchronized (this.b) {
            appLovinAdImpl = !c() ? (AppLovinAdImpl) this.f726a.poll() : null;
        }
        return appLovinAdImpl;
    }
}

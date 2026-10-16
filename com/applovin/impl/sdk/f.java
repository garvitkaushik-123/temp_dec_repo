package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.d7;
import com.applovin.impl.o3;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class f implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a, reason: collision with root package name */
    private d7 f685a;
    private final Object b = new Object();
    private final AtomicBoolean c = new AtomicBoolean();
    private boolean d;
    private final k e;
    private final WeakReference f;
    private long g;

    public interface a {
        void onAdRefresh();
    }

    public f(k kVar, a aVar) {
        this.f = new WeakReference(aVar);
        this.e = kVar;
    }

    private void e() {
        if (((Boolean) this.e.a(o3.u7)).booleanValue()) {
            k();
        }
    }

    private void f() {
        if (((Boolean) this.e.a(o3.u7)).booleanValue()) {
            synchronized (this.b) {
                if (this.d) {
                    this.e.O();
                    if (o.a()) {
                        this.e.O().a("AdRefreshManager", "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                    }
                } else if (this.e.n0().isApplicationPaused()) {
                    this.e.O();
                    if (o.a()) {
                        this.e.O().a("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                    }
                } else {
                    d7 d7Var = this.f685a;
                    if (d7Var != null) {
                        d7Var.e();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        l();
        a aVar = (a) this.f.get();
        if (aVar != null) {
            aVar.onAdRefresh();
        }
    }

    private void k() {
        synchronized (this.b) {
            d7 d7Var = this.f685a;
            if (d7Var != null) {
                d7Var.d();
            } else {
                this.e.O();
                if (o.a()) {
                    this.e.O().a("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                }
                this.c.set(true);
            }
        }
    }

    private void l() {
        synchronized (this.b) {
            this.f685a = null;
            if (!((Boolean) this.e.a(o3.v7)).booleanValue()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private void n() {
        synchronized (this.b) {
            d7 d7Var = this.f685a;
            if (d7Var != null) {
                d7Var.e();
            } else {
                this.c.set(false);
            }
        }
    }

    public void a(long j) {
        synchronized (this.b) {
            a();
            this.g = j;
            this.f685a = d7.a(j, this.e, new Runnable() { // from class: com.applovin.impl.sdk.f$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.i();
                }
            });
            if (!((Boolean) this.e.a(o3.v7)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.e.a(o3.u7)).booleanValue() && (this.e.I().c() || this.e.n0().isApplicationPaused())) {
                this.f685a.d();
            }
            if (this.c.compareAndSet(true, false) && ((Boolean) this.e.a(o3.w7)).booleanValue()) {
                this.e.O();
                if (o.a()) {
                    this.e.O().a("AdRefreshManager", "Pausing refresh for a previous request.");
                }
                this.f685a.d();
            }
        }
    }

    public long b() {
        long c;
        synchronized (this.b) {
            d7 d7Var = this.f685a;
            c = d7Var != null ? d7Var.c() : -1L;
        }
        return c;
    }

    public void c() {
        if (((Boolean) this.e.a(o3.t7)).booleanValue()) {
            k();
        }
    }

    public void d() {
        boolean z;
        a aVar;
        if (((Boolean) this.e.a(o3.t7)).booleanValue()) {
            synchronized (this.b) {
                if (this.d) {
                    this.e.O();
                    if (o.a()) {
                        this.e.O().a("AdRefreshManager", "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                    }
                    return;
                }
                if (this.e.I().c()) {
                    this.e.O();
                    if (o.a()) {
                        this.e.O().a("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
                    }
                    return;
                }
                if (this.f685a != null) {
                    long b = this.g - b();
                    long longValue = ((Long) this.e.a(o3.s7)).longValue();
                    if (longValue >= 0 && b > longValue) {
                        a();
                        z = true;
                        if (z || (aVar = (a) this.f.get()) == null) {
                        }
                        aVar.onAdRefresh();
                        return;
                    }
                    this.f685a.e();
                }
                z = false;
                if (z) {
                }
            }
        }
    }

    public boolean g() {
        return this.d;
    }

    public boolean h() {
        boolean z;
        synchronized (this.b) {
            z = this.f685a != null;
        }
        return z;
    }

    public void j() {
        synchronized (this.b) {
            k();
            this.d = true;
        }
    }

    public void m() {
        synchronized (this.b) {
            n();
            this.d = false;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            c();
            return;
        }
        if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            d();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            e();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            f();
        }
    }

    public void a() {
        synchronized (this.b) {
            d7 d7Var = this.f685a;
            if (d7Var != null) {
                d7Var.a();
                l();
            }
        }
    }
}

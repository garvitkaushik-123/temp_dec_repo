package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.k7;
import com.applovin.impl.v4;
import com.ironsource.C3040d4;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class SessionTracker {
    public static final String ACTION_APPLICATION_PAUSED = "com.applovin.application_paused";
    public static final String ACTION_APPLICATION_RESUMED = "com.applovin.application_resumed";

    /* renamed from: a, reason: collision with root package name */
    final k f668a;
    private final String b = UUID.randomUUID().toString();
    private final AtomicBoolean c = new AtomicBoolean();
    private final AtomicBoolean d = new AtomicBoolean();
    private final AtomicInteger e = new AtomicInteger();
    private final AtomicLong f = new AtomicLong();
    private final AtomicLong g = new AtomicLong();
    private Date h;
    private Date i;

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            SessionTracker.this.b();
        }
    }

    class b implements ComponentCallbacks2 {
        b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            SessionTracker.this.e.set(i);
            if (i == 20) {
                SessionTracker.this.a();
            }
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                if (k7.g()) {
                    SessionTracker.this.b();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                SessionTracker.this.a();
            }
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f672a;

        static {
            int[] iArr = new int[e.values().length];
            f672a = iArr;
            try {
                iArr[e.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f672a[e.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f672a[e.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum e {
        STARTED(C3040d4.h.d0),
        PAUSED(C3040d4.h.e0),
        RESUMED("resumed");


        /* renamed from: a, reason: collision with root package name */
        private final String f673a;

        e(String str) {
            this.f673a = str;
        }

        public String b() {
            return this.f673a;
        }
    }

    SessionTracker(k kVar) {
        this.f668a = kVar;
        Application application = (Application) k.o();
        application.registerActivityLifecycleCallbacks(new a());
        application.registerComponentCallbacks(new b());
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new c(), intentFilter);
    }

    private void d() {
        this.f668a.O();
        if (o.a()) {
            this.f668a.O().a("SessionTracker", "Application Resumed");
        }
        this.g.set(System.currentTimeMillis());
        boolean booleanValue = ((Boolean) this.f668a.a(v4.r3)).booleanValue();
        long longValue = ((Long) this.f668a.a(v4.s3)).longValue();
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_RESUMED), null);
        if (this.c.getAndSet(false)) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(longValue);
        if (this.i == null || System.currentTimeMillis() - this.i.getTime() >= millis) {
            this.f668a.G().trackEvent("resumed");
            if (booleanValue) {
                this.i = new Date();
            }
        }
        if (booleanValue) {
            return;
        }
        this.i = new Date();
    }

    public long getAppEnteredBackgroundTimeMillis() {
        return this.f.get();
    }

    public long getAppEnteredForegroundTimeMillis() {
        return this.g.get();
    }

    public e getCurrentApplicationState() {
        return this.d.get() ? e.PAUSED : this.f.get() != 0 ? e.RESUMED : e.STARTED;
    }

    public long getCurrentApplicationStateDurationMillis() {
        long n;
        long currentTimeMillis = System.currentTimeMillis();
        int i = d.f672a[getCurrentApplicationState().ordinal()];
        if (i == 1) {
            n = k.n();
        } else if (i == 2) {
            n = this.f.get();
        } else {
            if (i != 3) {
                return -1L;
            }
            n = this.g.get();
        }
        return currentTimeMillis - n;
    }

    public int getLastTrimMemoryLevel() {
        return this.e.get();
    }

    public String getSessionId() {
        return this.b;
    }

    public boolean isApplicationPaused() {
        return this.d.get();
    }

    public void pauseForClick() {
        this.c.set(true);
    }

    public void resumeForClick() {
        this.c.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.d.compareAndSet(false, true)) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d.compareAndSet(true, false)) {
            d();
        }
    }

    private void c() {
        this.f668a.O();
        if (o.a()) {
            this.f668a.O().a("SessionTracker", "Application Paused");
        }
        this.f.set(System.currentTimeMillis());
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_PAUSED), null);
        if (this.c.get()) {
            return;
        }
        boolean booleanValue = ((Boolean) this.f668a.a(v4.r3)).booleanValue();
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f668a.a(v4.t3)).longValue());
        if (this.h == null || System.currentTimeMillis() - this.h.getTime() >= millis) {
            this.f668a.G().trackEvent(C3040d4.h.e0);
            if (booleanValue) {
                this.h = new Date();
            }
        }
        if (booleanValue) {
            return;
        }
        this.h = new Date();
    }
}

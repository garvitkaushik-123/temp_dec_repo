package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;

/* renamed from: com.ironsource.c8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3024c8 extends C3343v3 {
    private static final C3024c8 d = new C3024c8();
    private LevelPlayInterstitialListener b = null;
    private LevelPlayInterstitialListener c = null;

    /* renamed from: com.ironsource.c8$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3212a;

        a(AdInfo adInfo) {
            this.f3212a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.b;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdShowSucceeded(c3024c8.a(this.f3212a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + C3024c8.this.a(this.f3212a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3213a;
        final /* synthetic */ AdInfo b;

        b(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f3213a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.c;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdShowFailed(this.f3213a, c3024c8.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + C3024c8.this.a(this.b) + ", error = " + this.f3213a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.c8$c */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3214a;
        final /* synthetic */ AdInfo b;

        c(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f3214a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.b;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdShowFailed(this.f3214a, c3024c8.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + C3024c8.this.a(this.b) + ", error = " + this.f3214a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.c8$d */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3215a;

        d(AdInfo adInfo) {
            this.f3215a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.c;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdClicked(c3024c8.a(this.f3215a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C3024c8.this.a(this.f3215a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$e */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3216a;

        e(AdInfo adInfo) {
            this.f3216a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.b;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdClicked(c3024c8.a(this.f3216a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C3024c8.this.a(this.f3216a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$f */
    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3217a;

        f(AdInfo adInfo) {
            this.f3217a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.c;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdReady(c3024c8.a(this.f3217a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + C3024c8.this.a(this.f3217a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$g */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3218a;

        g(AdInfo adInfo) {
            this.f3218a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.b;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdReady(c3024c8.a(this.f3218a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + C3024c8.this.a(this.f3218a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$h */
    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3219a;

        h(IronSourceError ironSourceError) {
            this.f3219a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            LevelPlayInterstitialListener levelPlayInterstitialListener = C3024c8.this.c;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdLoadFailed(this.f3219a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3219a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.c8$i */
    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3220a;

        i(IronSourceError ironSourceError) {
            this.f3220a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            LevelPlayInterstitialListener levelPlayInterstitialListener = C3024c8.this.b;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdLoadFailed(this.f3220a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3220a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.c8$j */
    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3221a;

        j(AdInfo adInfo) {
            this.f3221a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.c;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdOpened(c3024c8.a(this.f3221a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + C3024c8.this.a(this.f3221a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$k */
    class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3222a;

        k(AdInfo adInfo) {
            this.f3222a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.b;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdOpened(c3024c8.a(this.f3222a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + C3024c8.this.a(this.f3222a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$l */
    class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3223a;

        l(AdInfo adInfo) {
            this.f3223a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.c;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdClosed(c3024c8.a(this.f3223a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + C3024c8.this.a(this.f3223a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$m */
    class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3224a;

        m(AdInfo adInfo) {
            this.f3224a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.b;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdClosed(c3024c8.a(this.f3224a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + C3024c8.this.a(this.f3224a));
            }
        }
    }

    /* renamed from: com.ironsource.c8$n */
    class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3225a;

        n(AdInfo adInfo) {
            this.f3225a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3024c8 c3024c8 = C3024c8.this;
            LevelPlayInterstitialListener levelPlayInterstitialListener = c3024c8.c;
            if (levelPlayInterstitialListener != null) {
                levelPlayInterstitialListener.onAdShowSucceeded(c3024c8.a(this.f3225a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + C3024c8.this.a(this.f3225a));
            }
        }
    }

    private C3024c8() {
    }

    public static synchronized C3024c8 a() {
        C3024c8 c3024c8;
        synchronized (C3024c8.class) {
            c3024c8 = d;
        }
        return c3024c8;
    }

    public synchronized void b(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.c = levelPlayInterstitialListener;
    }

    public void c(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }

    public synchronized void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.b = levelPlayInterstitialListener;
    }

    public void b(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(ironSourceError));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(ironSourceError));
        }
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(ironSourceError, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(ironSourceError, adInfo));
        }
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}

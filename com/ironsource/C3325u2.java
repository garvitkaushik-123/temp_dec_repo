package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;

/* renamed from: com.ironsource.u2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3325u2 extends C3343v3 {
    private static final C3325u2 d = new C3325u2();
    private LevelPlayBannerListener b = null;
    private LevelPlayBannerListener c = null;

    /* renamed from: com.ironsource.u2$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3856a;

        a(AdInfo adInfo) {
            this.f3856a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.b;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdLeftApplication(c3325u2.a(this.f3856a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + C3325u2.this.a(this.f3856a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3857a;

        b(AdInfo adInfo) {
            this.f3857a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.c;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdClicked(c3325u2.a(this.f3857a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C3325u2.this.a(this.f3857a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$c */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3858a;

        c(AdInfo adInfo) {
            this.f3858a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.b;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdClicked(c3325u2.a(this.f3858a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + C3325u2.this.a(this.f3858a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$d */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3859a;

        d(AdInfo adInfo) {
            this.f3859a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.c;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdLoaded(c3325u2.a(this.f3859a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + C3325u2.this.a(this.f3859a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$e */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3860a;

        e(AdInfo adInfo) {
            this.f3860a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.b;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdLoaded(c3325u2.a(this.f3860a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + C3325u2.this.a(this.f3860a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$f */
    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3861a;

        f(IronSourceError ironSourceError) {
            this.f3861a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            LevelPlayBannerListener levelPlayBannerListener = C3325u2.this.c;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdLoadFailed(this.f3861a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3861a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.u2$g */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3862a;

        g(IronSourceError ironSourceError) {
            this.f3862a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            LevelPlayBannerListener levelPlayBannerListener = C3325u2.this.b;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdLoadFailed(this.f3862a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3862a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.u2$h */
    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3863a;

        h(AdInfo adInfo) {
            this.f3863a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.c;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdScreenPresented(c3325u2.a(this.f3863a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + C3325u2.this.a(this.f3863a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$i */
    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3864a;

        i(AdInfo adInfo) {
            this.f3864a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.b;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdScreenPresented(c3325u2.a(this.f3864a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + C3325u2.this.a(this.f3864a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$j */
    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3865a;

        j(AdInfo adInfo) {
            this.f3865a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.c;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdScreenDismissed(c3325u2.a(this.f3865a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + C3325u2.this.a(this.f3865a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$k */
    class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3866a;

        k(AdInfo adInfo) {
            this.f3866a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.b;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdScreenDismissed(c3325u2.a(this.f3866a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + C3325u2.this.a(this.f3866a));
            }
        }
    }

    /* renamed from: com.ironsource.u2$l */
    class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3867a;

        l(AdInfo adInfo) {
            this.f3867a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3325u2 c3325u2 = C3325u2.this;
            LevelPlayBannerListener levelPlayBannerListener = c3325u2.c;
            if (levelPlayBannerListener != null) {
                levelPlayBannerListener.onAdLeftApplication(c3325u2.a(this.f3867a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + C3325u2.this.a(this.f3867a));
            }
        }
    }

    private C3325u2() {
    }

    public static C3325u2 a() {
        return d;
    }

    public void b(LevelPlayBannerListener levelPlayBannerListener) {
        this.c = levelPlayBannerListener;
    }

    public void c(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
        }
    }

    public void a(LevelPlayBannerListener levelPlayBannerListener) {
        this.b = levelPlayBannerListener;
    }

    public LevelPlayBannerListener b() {
        return this.b;
    }

    public void a(IronSourceError ironSourceError) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(ironSourceError));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(ironSourceError));
        }
    }

    public void b(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(adInfo));
        }
    }
}

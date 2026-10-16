package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;

/* renamed from: com.ironsource.ld, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3184ld extends C3343v3 {
    private static final C3184ld d = new C3184ld();
    private LevelPlayRewardedVideoBaseListener b = null;
    private LevelPlayRewardedVideoBaseListener c = null;

    /* renamed from: com.ironsource.ld$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3449a;
        final /* synthetic */ AdInfo b;

        a(boolean z, AdInfo adInfo) {
            this.f3449a = z;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                if (this.f3449a) {
                    ((LevelPlayRewardedVideoListener) levelPlayRewardedVideoBaseListener).onAdAvailable(c3184ld.a(this.b));
                    IronLog.CALLBACK.info("onAdAvailable() adInfo = " + C3184ld.this.a(this.b));
                } else {
                    ((LevelPlayRewardedVideoListener) levelPlayRewardedVideoBaseListener).onAdUnavailable();
                    IronLog.CALLBACK.info("onAdUnavailable()");
                }
            }
        }
    }

    /* renamed from: com.ironsource.ld$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3450a;
        final /* synthetic */ AdInfo b;

        b(Placement placement, AdInfo adInfo) {
            this.f3450a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdRewarded(this.f3450a, c3184ld.a(this.b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f3450a + ", adInfo = " + C3184ld.this.a(this.b));
            }
        }
    }

    /* renamed from: com.ironsource.ld$c */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3451a;
        final /* synthetic */ AdInfo b;

        c(Placement placement, AdInfo adInfo) {
            this.f3451a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdRewarded(this.f3451a, c3184ld.a(this.b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f3451a + ", adInfo = " + C3184ld.this.a(this.b));
            }
        }
    }

    /* renamed from: com.ironsource.ld$d */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3452a;
        final /* synthetic */ AdInfo b;

        d(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f3452a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdShowFailed(this.f3452a, c3184ld.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + C3184ld.this.a(this.b) + ", error = " + this.f3452a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.ld$e */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3453a;
        final /* synthetic */ AdInfo b;

        e(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f3453a = ironSourceError;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdShowFailed(this.f3453a, c3184ld.a(this.b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + C3184ld.this.a(this.b) + ", error = " + this.f3453a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.ld$f */
    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3454a;
        final /* synthetic */ AdInfo b;

        f(Placement placement, AdInfo adInfo) {
            this.f3454a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdClicked(this.f3454a, c3184ld.a(this.b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f3454a + ", adInfo = " + C3184ld.this.a(this.b));
            }
        }
    }

    /* renamed from: com.ironsource.ld$g */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f3455a;
        final /* synthetic */ AdInfo b;

        g(Placement placement, AdInfo adInfo) {
            this.f3455a = placement;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdClicked(this.f3455a, c3184ld.a(this.b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f3455a + ", adInfo = " + C3184ld.this.a(this.b));
            }
        }
    }

    /* renamed from: com.ironsource.ld$h */
    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3456a;

        h(AdInfo adInfo) {
            this.f3456a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                ((LevelPlayRewardedVideoManualListener) levelPlayRewardedVideoBaseListener).onAdReady(c3184ld.a(this.f3456a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + C3184ld.this.a(this.f3456a));
            }
        }
    }

    /* renamed from: com.ironsource.ld$i */
    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3457a;

        i(AdInfo adInfo) {
            this.f3457a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                ((LevelPlayRewardedVideoManualListener) levelPlayRewardedVideoBaseListener).onAdReady(c3184ld.a(this.f3457a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + C3184ld.this.a(this.f3457a));
            }
        }
    }

    /* renamed from: com.ironsource.ld$j */
    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3458a;

        j(IronSourceError ironSourceError) {
            this.f3458a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = C3184ld.this.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                ((LevelPlayRewardedVideoManualListener) levelPlayRewardedVideoBaseListener).onAdLoadFailed(this.f3458a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3458a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.ld$k */
    class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f3459a;

        k(IronSourceError ironSourceError) {
            this.f3459a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = C3184ld.this.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                ((LevelPlayRewardedVideoManualListener) levelPlayRewardedVideoBaseListener).onAdLoadFailed(this.f3459a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f3459a.getErrorMessage());
            }
        }
    }

    /* renamed from: com.ironsource.ld$l */
    class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3460a;

        l(AdInfo adInfo) {
            this.f3460a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdOpened(c3184ld.a(this.f3460a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + C3184ld.this.a(this.f3460a));
            }
        }
    }

    /* renamed from: com.ironsource.ld$m */
    class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3461a;

        m(AdInfo adInfo) {
            this.f3461a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdOpened(c3184ld.a(this.f3461a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + C3184ld.this.a(this.f3461a));
            }
        }
    }

    /* renamed from: com.ironsource.ld$n */
    class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3462a;

        n(AdInfo adInfo) {
            this.f3462a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdClosed(c3184ld.a(this.f3462a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + C3184ld.this.a(this.f3462a));
            }
        }
    }

    /* renamed from: com.ironsource.ld$o */
    class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f3463a;

        o(AdInfo adInfo) {
            this.f3463a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.b;
            if (levelPlayRewardedVideoBaseListener != null) {
                levelPlayRewardedVideoBaseListener.onAdClosed(c3184ld.a(this.f3463a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + C3184ld.this.a(this.f3463a));
            }
        }
    }

    /* renamed from: com.ironsource.ld$p */
    class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3464a;
        final /* synthetic */ AdInfo b;

        p(boolean z, AdInfo adInfo) {
            this.f3464a = z;
            this.b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3184ld c3184ld = C3184ld.this;
            LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = c3184ld.c;
            if (levelPlayRewardedVideoBaseListener != null) {
                if (this.f3464a) {
                    ((LevelPlayRewardedVideoListener) levelPlayRewardedVideoBaseListener).onAdAvailable(c3184ld.a(this.b));
                    IronLog.CALLBACK.info("onAdAvailable() adInfo = " + C3184ld.this.a(this.b));
                } else {
                    ((LevelPlayRewardedVideoListener) levelPlayRewardedVideoBaseListener).onAdUnavailable();
                    IronLog.CALLBACK.info("onAdUnavailable()");
                }
            }
        }
    }

    private C3184ld() {
    }

    public void b() {
    }

    public void c() {
    }

    public static C3184ld a() {
        return d;
    }

    public void b(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.c = levelPlayRewardedVideoBaseListener;
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
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
    }

    public void a(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.b = levelPlayRewardedVideoBaseListener;
    }

    public void b(AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new o(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(ironSourceError));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(ironSourceError));
    }

    public void b(Placement placement, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(placement, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(placement, adInfo));
        }
    }

    public void a(boolean z, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new p(z, adInfo));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(z, adInfo));
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(ironSourceError, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(ironSourceError, adInfo));
        }
    }

    public void a(Placement placement, AdInfo adInfo) {
        if (this.c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(placement, adInfo));
        } else if (this.b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(placement, adInfo));
        }
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}

package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinFullscreenImmersiveActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v1;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class m2 implements AppLovinInterstitialAdDialog {

    /* renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f541a;
    private final WeakReference b;
    private final Map c = Collections.synchronizedMap(new HashMap());
    private volatile AppLovinAdLoadListener d;
    private volatile AppLovinAdDisplayListener e;
    private volatile AppLovinAdVideoPlaybackListener f;
    private volatile AppLovinAdClickListener g;
    private volatile com.applovin.impl.sdk.ad.b h;

    class a implements AppLovinAdLoadListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            m2.this.b(appLovinAd);
            m2.this.showAndRender(appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            m2.this.b(i);
        }
    }

    public m2(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f541a = appLovinSdk.a();
        this.b = new WeakReference(context);
    }

    private Context e() {
        return (Context) this.b.get();
    }

    private long g() {
        String str = this.f541a.o0().getExtraParameters().get("fullscreen_ad_display_delay_enabled");
        if (str == null || Boolean.parseBoolean(str)) {
            return Math.max(0L, ((Long) this.f541a.a(v4.T1)).longValue());
        }
        return 0L;
    }

    public AppLovinAdDisplayListener c() {
        return this.e;
    }

    public AppLovinAdVideoPlaybackListener d() {
        return this.f;
    }

    public com.applovin.impl.sdk.ad.b f() {
        return this.h;
    }

    public Map h() {
        return this.c;
    }

    public boolean i() {
        final com.applovin.impl.sdk.ad.b bVar = this.h;
        if (bVar == null) {
            return false;
        }
        bVar.A0();
        bVar.setHasShown(false);
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.m2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                m2.this.b(bVar);
            }
        });
        return true;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.g = appLovinAdClickListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.e = appLovinAdDisplayListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.d = appLovinAdLoadListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f = appLovinAdVideoPlaybackListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setExtraInfo(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        this.c.put(str, obj);
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void show() {
        a(new a());
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd) {
        if (appLovinAd.getType() != AppLovinAdType.INCENTIVIZED) {
            Map a2 = e2.a((AppLovinAdImpl) appLovinAd);
            CollectionUtils.putStringIfValid("source", "showInterstitialAd", a2);
            this.f541a.g().d(c2.p, a2);
        }
        AppLovinAd a3 = k7.a(appLovinAd, this.f541a);
        Context e = e();
        String a4 = a(a3, appLovinAd, e);
        if (StringUtils.isValidString(a4)) {
            a("interstitialAdShowFailed", a4, appLovinAd);
        } else {
            if (((Boolean) this.f541a.a(v4.L5)).booleanValue() && a((com.applovin.impl.sdk.ad.b) a3)) {
                return;
            }
            a((com.applovin.impl.sdk.ad.b) a3, e);
        }
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }

    public AppLovinAdClickListener b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.ad.b bVar) {
        this.f541a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f541a.O().a("InterstitialAdDialogWrapper", "Re-showing the current ad after app launch.");
        }
        showAndRender(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Lifecycle lifecycle, AppLovinAd appLovinAd, ViewGroup viewGroup, Activity activity) {
        a((com.applovin.impl.sdk.ad.b) appLovinAd, viewGroup, new AppLovinFullscreenAdViewObserver(lifecycle, this), activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.applovin.impl.sdk.ad.b bVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver) {
        appLovinFullscreenAdViewObserver.onDestroy();
        a(bVar, appLovinAdDisplayListener, str, th, (AppLovinFullscreenActivity) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Context context) {
        Intent intent = new Intent(context, (Class<?>) (this.h.X0() ? AppLovinFullscreenImmersiveActivity.class : AppLovinFullscreenActivity.class));
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f541a.j0());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        if (this.f541a.e().a() == null && ((Boolean) this.f541a.a(v4.m2)).booleanValue()) {
            intent.addFlags(8388608);
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    protected boolean a(com.applovin.impl.sdk.ad.b bVar) {
        List a2 = k7.a(!bVar.O0(), bVar, this.f541a, com.applovin.impl.sdk.k.o());
        if (a2.isEmpty()) {
            return false;
        }
        String str = "Missing ad resources: " + a2;
        if (((Boolean) this.f541a.a(v4.H5)).booleanValue()) {
            com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", "Failing ad display due to missing resources: " + a2);
            a("missingCachedAdResources", str, bVar);
            HashMap<String, String> hashMap = CollectionUtils.hashMap("error_message", str);
            CollectionUtils.putStringIfValid("details", "Failing ad display", hashMap);
            this.f541a.E().a(c2.z0, "missingCachedAdResources", hashMap);
            return true;
        }
        com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", "Streaming ad due to missing ad resources: " + a2);
        bVar.Q0();
        HashMap<String, String> hashMap2 = CollectionUtils.hashMap("error_message", str);
        CollectionUtils.putStringIfValid("details", "Streaming ad", hashMap2);
        this.f541a.E().a(c2.z0, "missingCachedAdResources", hashMap2);
        return false;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd, final ViewGroup viewGroup, final Lifecycle lifecycle) {
        if (appLovinAd.getType() != AppLovinAdType.INCENTIVIZED) {
            Map a2 = e2.a((AppLovinAdImpl) appLovinAd);
            CollectionUtils.putStringIfValid("source", "showInterstitialAdView", a2);
            this.f541a.g().d(c2.p, a2);
        }
        if (viewGroup != null && lifecycle != null) {
            final AppLovinAd a3 = k7.a(appLovinAd, this.f541a);
            final Activity v0 = this.f541a.v0();
            String a4 = a(a3, appLovinAd, v0);
            if (StringUtils.isValidString(a4)) {
                a("interstitialAdShowFailed", a4, appLovinAd);
                return;
            } else {
                if (((Boolean) this.f541a.a(v4.L5)).booleanValue() && a((com.applovin.impl.sdk.ad.b) a3)) {
                    return;
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        m2.this.a(lifecycle, a3, viewGroup, v0);
                    }
                });
                return;
            }
        }
        com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
        a("interstitialAdShowFailed", "Failed to show interstitial: attempting to show ad with null container view or lifecycle object", appLovinAd);
    }

    class b implements v1.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f543a;
        final /* synthetic */ AppLovinFullscreenAdViewObserver b;
        final /* synthetic */ ViewGroup c;

        b(Activity activity, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, ViewGroup viewGroup) {
            this.f543a = activity;
            this.b = appLovinFullscreenAdViewObserver;
            this.c = viewGroup;
        }

        @Override // com.applovin.impl.v1.g
        public void a(v1 v1Var) {
            if (d.d(this.f543a)) {
                com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad when parent activity is finishing");
                m2.b(m2.this.h, m2.this.e, "Failed to show interstitial: attempting to show ad when parent activity is finishing", null, this.b);
                HashMap<String, String> hashMap = CollectionUtils.hashMap("source", "invalidActivity");
                CollectionUtils.putStringIfValid("error_message", "Failed to show interstitial: attempting to show ad when parent activity is finishing", hashMap);
                m2.this.f541a.g().a(c2.s, m2.this.h, hashMap);
                return;
            }
            this.b.setPresenter(v1Var);
            try {
                v1Var.a(this.c);
            } catch (Throwable th) {
                String str = "Failed to show interstitial: presenter threw exception " + th;
                com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", str);
                m2.b(m2.this.h, m2.this.e, str, th, this.b);
                HashMap<String, String> hashMap2 = CollectionUtils.hashMap("source", "presentContainerView");
                CollectionUtils.putStringIfValid("error_message", str, hashMap2);
                CollectionUtils.putStringIfValid("top_main_method", th.toString(), hashMap2);
                m2.this.f541a.g().a(c2.s, m2.this.h, hashMap2);
            }
        }

        @Override // com.applovin.impl.v1.g
        public void a(String str, Throwable th) {
            m2.b(m2.this.h, m2.this.e, str, th, this.b);
            HashMap<String, String> hashMap = CollectionUtils.hashMap("source", "renderInterstitialAdView");
            CollectionUtils.putStringIfValid("error_message", str, hashMap);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), hashMap);
            m2.this.f541a.g().a(c2.s, m2.this.h, hashMap);
        }
    }

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th, AppLovinFullscreenActivity appLovinFullscreenActivity) {
        com.applovin.impl.sdk.o.c("InterstitialAdDialogWrapper", str, th);
        if (appLovinAdDisplayListener instanceof k2) {
            q2.a(appLovinAdDisplayListener, str);
        } else {
            q2.b(appLovinAdDisplayListener, bVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss("failed_to_display_ad");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m2$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                m2.this.a(appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m2$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                m2.this.a(i);
            }
        });
    }

    public void a() {
        this.g = null;
        this.d = null;
        this.f = null;
        this.e = null;
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f541a.k().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2, Context context) {
        if (context == null) {
            com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            return "Failed to show interstitial: stale activity reference provided";
        }
        if (appLovinAd == null) {
            com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", "Unable to retrieve the loaded ad: " + appLovinAd2);
            return "Unable to retrieve the loaded ad";
        }
        if (!((AppLovinAdImpl) appLovinAd).hasShown() || !((Boolean) this.f541a.a(v4.G1)).booleanValue()) {
            return null;
        }
        com.applovin.impl.sdk.o.h("InterstitialAdDialogWrapper", "Attempting to show ad again: " + appLovinAd);
        return "Attempting to show ad again";
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.f541a.f().a(bVar);
        this.h = bVar;
        long g = g();
        this.f541a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f541a.O().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + g + "ms...");
        }
        if (((Boolean) this.f541a.a(v4.W0)).booleanValue()) {
            this.f541a.h().a(this.h);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.m2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                m2.this.a(context);
            }
        }, g);
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final ViewGroup viewGroup, final AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, final Activity activity) {
        this.f541a.f().a(bVar);
        this.h = bVar;
        long g = g();
        this.f541a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f541a.O().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + g + "ms...");
        }
        if (((Boolean) this.f541a.a(v4.W0)).booleanValue()) {
            this.f541a.h().a(this.h);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.m2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                m2.this.a(viewGroup, activity, appLovinFullscreenAdViewObserver);
            }
        }, g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Activity activity, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver) {
        this.f541a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f541a.O().a("InterstitialAdDialogWrapper", "Presenting ad in a containerView(" + viewGroup + ")");
        }
        viewGroup.setBackgroundColor(-16777216);
        v1.a(this.h, this.g, this.e, this.f, this.c, this.f541a, activity, new b(activity, appLovinFullscreenAdViewObserver, viewGroup));
    }

    private void a(String str, String str2, AppLovinAd appLovinAd) {
        if (this.e != null) {
            if (this.e instanceof k2) {
                ((k2) this.e).onAdDisplayFailed(str2);
            } else {
                this.e.adHidden(appLovinAd);
            }
        }
        Map a2 = e2.a((AppLovinAdImpl) appLovinAd);
        CollectionUtils.putStringIfValid("source", str, a2);
        CollectionUtils.putStringIfValid("error_message", str2, a2);
        this.f541a.g().d(c2.s, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.d != null) {
            this.d.adReceived(appLovinAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        if (this.d != null) {
            this.d.failedToReceiveAd(i);
        }
    }
}

package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.browser.customtabs.CustomTabsSession;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.k;
import com.applovin.impl.b2;
import com.applovin.impl.b6;
import com.applovin.impl.b8;
import com.applovin.impl.c2;
import com.applovin.impl.c4;
import com.applovin.impl.e2;
import com.applovin.impl.e4;
import com.applovin.impl.k2;
import com.applovin.impl.k7;
import com.applovin.impl.l8;
import com.applovin.impl.m1;
import com.applovin.impl.p6;
import com.applovin.impl.q2;
import com.applovin.impl.r4;
import com.applovin.impl.s;
import com.applovin.impl.s2;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.impl.x4;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a implements AppLovinCommunicatorSubscriber, AppLovinBroadcastManager.Receiver {
    private volatile AppLovinAdLoadListener A;
    private volatile AppLovinAdDisplayListener B;
    private volatile AppLovinAdViewEventListener C;
    private volatile AppLovinAdClickListener D;

    /* renamed from: a, reason: collision with root package name */
    private Context f369a;
    private ViewGroup b;
    private com.applovin.impl.sdk.k c;
    private AppLovinAdServiceImpl d;
    private o e;
    private AppLovinCommunicator f;
    private b g;
    private AppLovinAdSize i;
    private String j;
    private CustomTabsSession k;
    private com.applovin.impl.adview.c l;
    private e m;
    private com.applovin.impl.adview.b n;
    private WebView o;
    private k p;
    private Runnable q;
    private Runnable r;
    private final Map h = Collections.synchronizedMap(new HashMap());
    private volatile com.applovin.impl.sdk.ad.b s = null;
    private volatile AppLovinAd t = null;
    private f u = null;
    private f v = null;
    private final AtomicReference w = new AtomicReference();
    private final AtomicBoolean x = new AtomicBoolean();
    private volatile boolean y = false;
    private volatile boolean z = false;

    /* renamed from: com.applovin.impl.adview.a$a, reason: collision with other inner class name */
    class C0087a extends r4 {
        C0087a() {
        }

        @Override // com.applovin.impl.r4
        protected Map a() {
            return CollectionUtils.hashMap("name", "AdViewController:GAWebView");
        }
    }

    public interface b {
        void a(a aVar);
    }

    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                a.this.n.setVisibility(8);
            }
        }

        /* synthetic */ c(a aVar, C0087a c0087a) {
            this();
        }
    }

    private class d implements Runnable {

        /* renamed from: com.applovin.impl.adview.a$d$a, reason: collision with other inner class name */
        class C0088a implements k.a {
            C0088a() {
            }

            @Override // com.applovin.impl.adview.k.a
            public void a() {
                a.this.n.addView(a.this.p, new ViewGroup.LayoutParams(-1, -1));
            }

            @Override // com.applovin.impl.adview.k.a
            public void onFailure() {
                o unused = a.this.e;
                if (o.a()) {
                    a.this.e.b("AppLovinAdView", "Watermark failed to render.");
                }
            }
        }

        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.s != null) {
                if (a.this.n == null) {
                    o.h("AppLovinAdView", "Unable to render advertisement for ad #" + a.this.s.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                    q2.a(a.this.C, a.this.s, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
                    HashMap<String, String> hashMap = CollectionUtils.hashMap("source", "renderTask");
                    CollectionUtils.putStringIfValid("error_message", "Ad view failed to render due to null adView", hashMap);
                    a.this.c.g().a(c2.s, a.this.s, hashMap);
                    return;
                }
                a.this.v();
                o unused = a.this.e;
                if (o.a()) {
                    a.this.e.a("AppLovinAdView", "Rendering advertisement ad for #" + a.this.s.getAdIdNumber() + "...");
                }
                a.b(a.this.n, a.this.s.getSize());
                if (a.this.p != null) {
                    b8.c(a.this.p);
                    a.this.p = null;
                }
                b2 b2Var = new b2(a.this.h, a.this.c);
                if (b2Var.c()) {
                    a.this.p = new k(b2Var, a.this.f369a);
                    a.this.p.a(new C0088a());
                }
                a.this.n.setAdHtmlLoaded(false);
                a.this.n.a(a.this.s);
                if (a.this.s.getSize() == AppLovinAdSize.INTERSTITIAL || a.this.z) {
                    return;
                }
                a.this.s.setHasShown(true);
            }
        }

        /* synthetic */ d(a aVar, C0087a c0087a) {
            this();
        }
    }

    static class e implements AppLovinAdLoadListener {

        /* renamed from: a, reason: collision with root package name */
        private final a f374a;

        e(a aVar, com.applovin.impl.sdk.k kVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("No view specified");
            }
            if (kVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f374a = aVar;
        }

        private a a() {
            return this.f374a;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            a a2 = a();
            if (a2 != null) {
                a2.b(appLovinAd);
            } else {
                o.h("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            a a2 = a();
            if (a2 != null) {
                a2.b(i);
            }
        }
    }

    private void E() {
        if (this.e != null && o.a() && o.a()) {
            this.e.a("AppLovinAdView", "Destroying...");
        }
        l8.b(this.n);
        this.n = null;
        l8.b(this.o);
        this.o = null;
        this.k = null;
        this.A = null;
        this.B = null;
        this.D = null;
        this.C = null;
        AppLovinBroadcastManager.unregisterReceiver(this);
        this.z = true;
    }

    private void m() {
        if (o.a()) {
            this.e.a("AppLovinAdView", "handleApplicationPaused()");
        }
        b("javascript:al_onAppPaused();");
    }

    private void n() {
        if (o.a()) {
            this.e.a("AppLovinAdView", "handleApplicationResumed()");
        }
        b("javascript:al_onAppResumed();");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        this.n.loadDataWithBaseURL(RemoteSettings.FORWARD_SLASH_STRING, "<html></html>", "text/html", null, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        com.applovin.impl.adview.b bVar;
        d();
        if (this.b == null || (bVar = this.n) == null || bVar.getParent() != null) {
            return;
        }
        this.b.addView(this.n);
        b(this.n, this.s.getSize());
        if (this.s.isOpenMeasurementEnabled()) {
            this.s.getAdEventTracker().a((View) this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        if (this.n != null && this.u != null) {
            a();
        }
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        if (this.u != null) {
            if (o.a()) {
                this.e.a("AppLovinAdView", "Detaching expanded ad: " + this.u.b());
            }
            this.v = this.u;
            this.u = null;
            a(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        com.applovin.impl.sdk.ad.a b2;
        f fVar = this.v;
        if (fVar == null && this.u == null) {
            return;
        }
        if (fVar != null) {
            b2 = fVar.b();
            this.v.dismiss();
            this.v = null;
        } else {
            b2 = this.u.b();
            this.u.dismiss();
            this.u = null;
        }
        q2.a(this.C, b2, (AppLovinAdView) this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        f().loadUrl("chrome://crash");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.applovin.impl.sdk.ad.b bVar = this.s;
        s2 s2Var = new s2();
        s2Var.a().a(bVar).a(i());
        if (!k7.a(bVar.getSize())) {
            s2Var.a().a("Fullscreen Ad Properties").b(bVar);
        }
        s2Var.a(this.c);
        s2Var.a();
        if (o.a()) {
            this.e.a("AppLovinAdView", s2Var.toString());
        }
    }

    private void x() {
        if (this.s.c1()) {
            int c2 = this.c.q().c();
            if (com.applovin.impl.sdk.i.a(c2)) {
                this.n.a("javascript:al_muteSwitchOn();");
            } else if (c2 == 2) {
                this.n.a("javascript:al_muteSwitchOff();");
            }
        }
    }

    private void y() {
        if (k7.a(this.i)) {
            if (((Boolean) this.c.a(v4.C1)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
            if (((Boolean) this.c.a(v4.D1)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_shown"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_hidden"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_failure"));
            }
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_intent_launch_success"));
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_intent_launch_failure"));
            if (((Boolean) this.c.a(v4.E1)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.external_redirect_success"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.external_redirect_failure"));
            }
            if (((Boolean) this.c.a(v4.F1)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.preload_success"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.preload_failure"));
            }
        }
    }

    public void A() {
        if (o.a()) {
            this.e.a("AppLovinAdView", "AdView fully watched...");
        }
        b bVar = this.g;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void B() {
        y();
        if (this.s != null && this.s.B0()) {
            com.applovin.impl.g.a(this.n, this.c);
        }
        b("javascript:al_onAttachedToWindow();");
    }

    public void C() {
        if (this.y) {
            if (this.s == null || !this.s.m1()) {
                q2.b(this.B, this.s);
            }
            if (this.s != null && this.s.isOpenMeasurementEnabled() && k7.a(this.s.getSize())) {
                this.s.getAdEventTracker().f();
            }
            if (this.n != null && this.u != null) {
                if (o.a()) {
                    this.e.a("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                }
                c();
            } else if (o.a()) {
                this.e.a("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
            }
            b("javascript:al_onDetachedFromWindow();");
        }
    }

    public void D() {
        if (!this.y || this.z) {
            return;
        }
        this.z = true;
    }

    public void F() {
        if (this.y) {
            AppLovinAd appLovinAd = (AppLovinAd) this.w.getAndSet(null);
            if (appLovinAd != null) {
                c(appLovinAd);
            }
            this.z = false;
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "a";
    }

    public AppLovinAdSize k() {
        return this.i;
    }

    public String l() {
        return this.j;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.t();
                }
            });
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        action.hashCode();
        switch (action) {
            case "com.applovin.custom_intent_launch_failure":
            case "com.applovin.custom_intent_launch_success":
                a(action, map);
                break;
            case "com.applovin.external_redirect_success":
            case "com.applovin.external_redirect_failure":
                c(action, map);
                break;
            case "com.applovin.custom_tabs_failure":
            case "com.applovin.custom_tabs_hidden":
            case "com.applovin.custom_tabs_shown":
                b(action, map);
                break;
            case "com.applovin.application_paused":
                m();
                break;
            case "com.applovin.application_resumed":
                n();
                break;
            case "com.applovin.preload_success":
            case "com.applovin.preload_failure":
                d(action, map);
                break;
        }
    }

    public void u() {
        if (this.c == null || this.m == null || this.f369a == null || !this.y) {
            o.i("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.d.loadNextAd(this.j, this.i, this.m);
        }
    }

    public void w() {
        if ((this.f369a instanceof m1) && this.s != null && this.s.U() == b.EnumC0102b.DISMISS) {
            ((m1) this.f369a).dismiss("postitial_click");
        }
    }

    public void z() {
        if (this.u != null || this.v != null) {
            a();
            return;
        }
        if (o.a()) {
            this.e.a("AppLovinAdView", "Ad: " + this.s + " closed.");
        }
        a(this.r);
        q2.b(this.B, this.s);
        this.s = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, AppLovinAdSize appLovinAdSize) {
        if (view == null) {
            return;
        }
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        AppLovinAdSize appLovinAdSize2 = AppLovinAdSize.INTERSTITIAL;
        int i = -1;
        int applyDimension = (appLovinAdSize == appLovinAdSize2 || appLovinAdSize == AppLovinAdSize.BANNER) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getWidth(), displayMetrics);
        if (appLovinAdSize != appLovinAdSize2 && appLovinAdSize != AppLovinAdSize.BANNER) {
            i = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getHeight(), displayMetrics);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = applyDimension;
        layoutParams.height = i;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
        }
        view.setLayoutParams(layoutParams);
    }

    private void c() {
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.r();
            }
        });
    }

    private void d() {
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.s();
            }
        });
    }

    public AppLovinAdViewEventListener e() {
        return this.C;
    }

    public com.applovin.impl.adview.b f() {
        return this.n;
    }

    public com.applovin.impl.sdk.ad.b g() {
        return this.s;
    }

    public CustomTabsSession h() {
        return this.k;
    }

    public AppLovinAdView i() {
        return (AppLovinAdView) this.b;
    }

    public com.applovin.impl.sdk.k j() {
        return this.c;
    }

    private void d(String str, Map map) {
        a(l8.d(str, map));
    }

    public void c(int i) {
        String a2 = b8.a(i);
        if (o.a()) {
            this.e.a("AppLovinAdView", "onWindowVisibilityChanged( " + a2 + " )");
        }
        b("javascript:al_onWindowVisibilityChanged( " + a2 + " );");
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.A = appLovinAdLoadListener;
    }

    public void a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.B = appLovinAdDisplayListener;
    }

    public void c(AppLovinAd appLovinAd) {
        a(appLovinAd, (String) null);
    }

    public void a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.C = appLovinAdViewEventListener;
    }

    public void c(WebView webView) {
        a(webView, (String) null);
    }

    private void c(String str, Map map) {
        a(l8.c(str, map));
    }

    public void a(AppLovinAdClickListener appLovinAdClickListener) {
        this.D = appLovinAdClickListener;
    }

    private void a(AppLovinAdView appLovinAdView, com.applovin.impl.sdk.k kVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (appLovinAdSize != null) {
            this.c = kVar;
            this.d = kVar.k();
            this.e = kVar.O();
            this.f = AppLovinCommunicator.getInstance(context);
            this.i = appLovinAdSize;
            this.j = str;
            if (!(context instanceof AppLovinFullscreenActivity)) {
                context = context.getApplicationContext();
            }
            this.f369a = context;
            this.b = appLovinAdView;
            this.l = new com.applovin.impl.adview.c(this, kVar);
            C0087a c0087a = null;
            this.r = new c(this, c0087a);
            this.q = new d(this, c0087a);
            this.m = new e(this, kVar);
            a(appLovinAdSize);
            return;
        }
        throw new IllegalArgumentException("No ad size specified");
    }

    protected void a(AppLovinAdSize appLovinAdSize) {
        try {
            com.applovin.impl.adview.b bVar = new com.applovin.impl.adview.b(this.l, this.c, this.f369a);
            this.n = bVar;
            bVar.setBackgroundColor(0);
            this.n.setWillNotCacheDrawing(false);
            this.b.setBackgroundColor(0);
            this.b.addView(this.n);
            b(this.n, appLovinAdSize);
            if (!this.y) {
                a(this.r);
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.o();
                }
            });
            this.y = true;
        } catch (Throwable th) {
            o.c("AppLovinAdView", "Failed to initialize AdWebView", th);
            this.c.E().a("AppLovinAdView", "initAdWebView", th);
            this.x.set(true);
        }
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                a.this.q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        this.s.getAdEventTracker().c(webView);
        k kVar = this.p;
        if (kVar != null && kVar.a()) {
            c4 adEventTracker = this.s.getAdEventTracker();
            k kVar2 = this.p;
            adEventTracker.b(webView, Collections.singletonList(new e4(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier())));
        } else {
            this.s.getAdEventTracker().a((View) webView);
        }
        this.s.getAdEventTracker().h();
        this.s.getAdEventTracker().g();
    }

    public void a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (context == null) {
            o.h("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
            return;
        }
        if (appLovinAdSize == null && (appLovinAdSize = s.a(attributeSet)) == null) {
            appLovinAdSize = AppLovinAdSize.BANNER;
        }
        AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        if (appLovinSdk != null) {
            a(appLovinAdView, appLovinSdk.a(), appLovinAdSize2, str, context);
            if (s.b(attributeSet)) {
                u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MotionEvent motionEvent) {
        a aVar;
        if (this.u == null && (this.s instanceof com.applovin.impl.sdk.ad.a) && this.n != null) {
            com.applovin.impl.sdk.ad.a aVar2 = (com.applovin.impl.sdk.ad.a) this.s;
            Context context = this.f369a;
            Activity b2 = context instanceof Activity ? (Activity) context : b8.b(this.n, this.c);
            if (b2 != null && !b2.isFinishing()) {
                ViewGroup viewGroup = this.b;
                if (viewGroup != null) {
                    viewGroup.removeView(this.n);
                }
                f fVar = new f(aVar2, this.n, b2, this.c);
                this.u = fVar;
                fVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda10
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        a.this.a(dialogInterface);
                    }
                });
                this.u.show();
                q2.c(this.C, this.s, (AppLovinAdView) this.b);
                if (this.s.isOpenMeasurementEnabled()) {
                    this.s.getAdEventTracker().a((View) this.u.c());
                    return;
                }
                return;
            }
            o.h("AppLovinAdView", "Unable to expand ad. No Activity found.");
            Uri m = aVar2.m();
            if (m != null) {
                aVar = this;
                this.d.trackAndLaunchClick(aVar2, i(), aVar, m, motionEvent, null);
            } else {
                aVar = this;
            }
            aVar.n.a("javascript:al_onFailedExpand();");
        }
    }

    public void a(String str, Object obj) {
        this.h.put(str, obj);
    }

    public void a(boolean z) {
        if (o.a()) {
            this.e.a("AppLovinAdView", "onWindowFocusChanged( " + z + " )");
        }
        b("javascript:al_onWindowFocusChanged( " + z + " );");
    }

    public void a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            k7.b(appLovinAd, this.c);
            if (this.y) {
                if (appLovinAd.getSize() != AppLovinAdSize.INTERSTITIAL) {
                    Map a2 = e2.a((AppLovinAdImpl) appLovinAd);
                    CollectionUtils.putStringIfValid("source", "renderAd", a2);
                    this.c.g().d(c2.p, a2);
                }
                com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) k7.a(appLovinAd, this.c);
                if (bVar == null) {
                    o.h("AppLovinAdView", "Unable to retrieve the loaded ad: " + appLovinAd);
                    q2.a(this.B, "Unable to retrieve the loaded ad");
                    Map a3 = e2.a((AppLovinAdImpl) appLovinAd);
                    CollectionUtils.putStringIfValid("source", "noAdToRender", a3);
                    CollectionUtils.putStringIfValid("error_message", "Unable to retrieve the loaded ad", a3);
                    this.c.g().d(c2.s, a3);
                    return;
                }
                if (bVar == this.s) {
                    o.h("AppLovinAdView", "Attempting to show ad again: " + bVar);
                    if (((Boolean) this.c.a(v4.G1)).booleanValue()) {
                        if (this.B instanceof k2) {
                            q2.a(this.B, "Attempting to show ad again");
                        } else if (!k7.c(this.c)) {
                            this.c.g().a(c2.E0, bVar, CollectionUtils.hashMap("source", "attemptingAdReRender"));
                        } else {
                            throw new IllegalStateException("Attempting to show ad again");
                        }
                    }
                    HashMap<String, String> hashMap = CollectionUtils.hashMap("source", "attemptingAdReRender");
                    CollectionUtils.putStringIfValid("error_message", "Attempting to show ad again", hashMap);
                    this.c.g().a(c2.s, bVar, hashMap);
                    return;
                }
                if (o.a()) {
                    this.e.a("AppLovinAdView", "Rendering ad #" + bVar.getAdIdNumber() + " (" + bVar.getSize() + ")");
                }
                q2.b(this.B, this.s);
                if (this.s != null && this.s.isOpenMeasurementEnabled()) {
                    this.s.getAdEventTracker().f();
                }
                this.w.set(null);
                this.t = null;
                this.s = bVar;
                if (this.s.G0()) {
                    this.k = this.c.A().a(this);
                    this.c.A().b(this.s.D(), this.k);
                }
                if (!this.z && k7.a(this.i)) {
                    this.c.k().trackImpression(bVar);
                }
                if (this.u != null) {
                    c();
                }
                a(this.q);
                return;
            }
            o.i("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            return;
        }
        throw new IllegalArgumentException("No ad specified");
    }

    void b(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.z) {
                c(appLovinAd);
            } else {
                this.w.set(appLovinAd);
                if (o.a()) {
                    this.e.a("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
                }
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.a(appLovinAd);
                }
            });
            return;
        }
        if (o.a()) {
            this.e.b("AppLovinAdView", "No provided when to the view controller");
        }
        b(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        if (!this.z) {
            a(this.r);
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(i);
            }
        });
    }

    private void b(String str) {
        if (((Boolean) this.c.a(v4.C1)).booleanValue()) {
            a(str);
        }
    }

    private void b(String str, Map map) {
        a(l8.b(str, map));
    }

    public void b(Uri uri) {
        if (this.s != null && this.s.I0() && this.o == null) {
            String queryParameter = uri.getQueryParameter("tracking_id");
            if (TextUtils.isEmpty(queryParameter)) {
                this.c.O();
                if (o.a()) {
                    this.c.O().b("AppLovinAdView", "Invalid tracking id. Cannot initialize GA");
                    return;
                }
                return;
            }
            WebView webView = new WebView(this.f369a);
            this.o = webView;
            webView.setWebViewClient(new C0087a());
            this.o.getSettings().setJavaScriptEnabled(true);
            this.o.loadDataWithBaseURL((String) this.c.a(v4.Z6), "<html><head><link rel=\"icon\" href=\"data:,\"><G-SCRIPT_TAG></head><body></body></html>".replace("<G-SCRIPT_TAG>", "<script src='https://www.googletagmanager.com/gtag/js?id=<G-TRACKING_ID>'></script><script>window.dataLayer = window.dataLayer || [];function gtag(){dataLayer.push(arguments);}gtag('js', new Date());gtag('config', '<G-TRACKING_ID>')</script>".replace("<G-TRACKING_ID>", queryParameter)), "text/html", "UTF-8", null);
        }
    }

    public void a(final WebView webView, String str) {
        if (this.s == null) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                webView.setVisibility(0);
            }
        });
        if (!((Boolean) this.c.a(v4.m6)).booleanValue() || (str != null && str.startsWith(this.s.k()))) {
            try {
                if (this.s != this.t) {
                    this.t = this.s;
                    x();
                    this.n.setAdHtmlLoaded(true);
                    if (this.B != null) {
                        this.c.z().d(this.s);
                        if (this.s.C0()) {
                            this.c.g().a(c2.r, this.s, CollectionUtils.hashMap("details", e2.b(this.s)));
                        } else {
                            this.c.g().a(c2.q, this.s, CollectionUtils.hashMap("duration_ms", String.valueOf(SystemClock.elapsedRealtime() - this.s.J())));
                            q2.a(this.B, this.s);
                        }
                        if (this.s.d1()) {
                            String str2 = (String) this.c.q0().a(x4.S, "");
                            JSONObject jSONObject = new JSONObject();
                            JsonUtils.putString(jSONObject, "template_browser_package_name", str2);
                            this.n.a("javascript:al_onAdViewRendered(" + jSONObject + ");");
                        } else {
                            this.n.a("javascript:al_onAdViewRendered();");
                        }
                        if (this.s.C0()) {
                            this.n.a("javascript:al_onAdRestored( '" + this.s.h0() + "' );");
                        }
                    }
                    if ((this.s instanceof com.applovin.impl.sdk.ad.a) && this.s.isOpenMeasurementEnabled()) {
                        this.c.r0().a(new p6(this.c, "StartOMSDK", new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                a.this.b(webView);
                            }
                        }), b6.b.OTHER, 500L);
                    }
                }
            } catch (Throwable th) {
                o.c("AppLovinAdView", "Exception while notifying ad display listener", th);
                com.applovin.impl.sdk.k kVar = this.c;
                if (kVar != null) {
                    kVar.E().a("AppLovinAdView", "onAdHtmlLoaded", th);
                }
            }
        }
    }

    public void a(final MotionEvent motionEvent) {
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        a();
    }

    public void a() {
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.p();
            }
        });
    }

    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri, MotionEvent motionEvent, Bundle bundle) {
        a aVar;
        com.applovin.impl.sdk.ad.b bVar2;
        if (appLovinAdView != null) {
            aVar = this;
            bVar2 = bVar;
            this.d.trackAndLaunchClick(bVar2, appLovinAdView, aVar, uri, motionEvent, bundle);
        } else {
            aVar = this;
            bVar2 = bVar;
            if (o.a()) {
                aVar.e.b("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
            }
        }
        q2.a(aVar.D, bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.x.compareAndSet(true, false)) {
            a(this.i);
        }
        try {
            if (this.A != null) {
                this.A.adReceived(appLovinAd);
            }
        } catch (Throwable th) {
            o.h("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
            com.applovin.impl.sdk.k kVar = this.c;
            if (kVar != null) {
                kVar.E().a("AppLovinAdView", "notifyAdLoadedCallback", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        try {
            if (this.A != null) {
                this.A.failedToReceiveAd(i);
            }
        } catch (Throwable th) {
            o.c("AppLovinAdView", "Exception while running app load callback", th);
            com.applovin.impl.sdk.k kVar = this.c;
            if (kVar != null) {
                kVar.E().a("AppLovinAdView", "notifyAdLoadFailedCallback", th);
            }
        }
    }

    private void a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    private void a(String str, Map map) {
        a(l8.a(str, map));
    }

    private void a(String str) {
        if (this.s == null || this.n == null || !k7.a(this.s.getSize()) || !StringUtils.isValidString(str)) {
            return;
        }
        this.n.a(str);
    }

    public void a(Uri uri) {
        if (this.s == null || !this.s.I0()) {
            return;
        }
        if (this.o == null) {
            this.c.O();
            if (o.a()) {
                this.c.O().a("AppLovinAdView", "GA is not initialized. Cannot fire GA event");
                return;
            }
            return;
        }
        final String queryParameter = uri.getQueryParameter("event_name");
        final String queryParameter2 = uri.getQueryParameter("event_params_json");
        if (TextUtils.isEmpty(queryParameter)) {
            this.c.O();
            if (o.a()) {
                this.c.O().a("AppLovinAdView", "Invalid GA event name. Cannot fire GA event");
                return;
            }
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.a$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(queryParameter2, queryParameter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        String str3;
        if (StringUtils.isValidString(str)) {
            str3 = "gtag('event', '" + str2 + "', " + str + ");";
        } else {
            str3 = "gtag('event', '" + str2 + "')";
        }
        if (((Boolean) this.c.a(v4.O2)).booleanValue()) {
            l8.a(this.o, str3, this.c);
        } else {
            l8.a(this.o, str3);
        }
    }
}

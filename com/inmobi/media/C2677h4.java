package com.inmobi.media;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.h4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2677h4 extends X1 implements InterfaceC2961yb {
    public long b;
    public final String c;
    public final String d;
    public final String e;
    public final X3 f;
    public final InterfaceC2971z5 g;
    public final C2592c4 h;
    public final String i;
    public final AdConfig.RenderingConfig j;
    public final Lazy k;
    public R6 l;
    public boolean m;
    public boolean n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2677h4(Context context, long j, String placementType, String impressionId, String creativeId, X3 onLpLifecycleEvent, InterfaceC2971z5 interfaceC2971z5) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        Intrinsics.checkNotNullParameter(onLpLifecycleEvent, "onLpLifecycleEvent");
        this.b = j;
        this.c = placementType;
        this.d = impressionId;
        this.e = creativeId;
        this.f = onLpLifecycleEvent;
        this.g = interfaceC2971z5;
        this.i = "h4";
        LinkedHashMap linkedHashMap = O2.f2380a;
        this.j = ((AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null)).getRendering();
        this.k = LazyKt.lazy(C2609d4.f2543a);
        setImportantForAccessibility(2);
        getSettings().setJavaScriptEnabled(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        C2592c4 c2592c4 = new C2592c4("IN_CUSTOM_EXPAND", new C2626e4(this), new C2642f4(this), new C2661g4(this), interfaceC2971z5);
        setWebViewClient(c2592c4);
        this.h = c2592c4;
        if (getAdConfig().getEnableCookiesOnInAppBrowser()) {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
    }

    private final AdConfig getAdConfig() {
        return (AdConfig) this.k.getValue();
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final boolean a() {
        String TAG = this.i;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return g();
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final boolean d() {
        String TAG = this.i;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        return g();
    }

    @Override // com.inmobi.media.X1
    public final M6 f() {
        N6 n6 = new N6(true, "DEFAULT", getAdConfig().getCctEnabled(), false);
        Context context = getContext();
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        Intrinsics.checkNotNull(context);
        return new M6(context, n6, null, null, this, null, interfaceC2971z5);
    }

    public final boolean g() {
        return !this.j.getAutoRedirectionEnforcement() || ((getViewTouchTimestamp() > (-1L) ? 1 : (getViewTouchTimestamp() == (-1L) ? 0 : -1)) != 0 && ((SystemClock.elapsedRealtime() - getViewTouchTimestamp()) > this.j.getUserTouchResetTime() ? 1 : ((SystemClock.elapsedRealtime() - getViewTouchTimestamp()) == this.j.getUserTouchResetTime() ? 0 : -1)) < 0);
    }

    public final R6 getLandingPageTelemetryControlInfo() {
        return this.l;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public long getViewTouchTimestamp() {
        return this.b;
    }

    @Override // android.webkit.WebView
    public final void loadData(String data, String str, String str2) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.loadData(data, str, str2);
        C2592c4 c2592c4 = this.h;
        if (c2592c4 != null) {
            c2592c4.d = true;
        }
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        super.loadUrl(url);
        C2592c4 c2592c4 = this.h;
        if (c2592c4 != null) {
            c2592c4.d = true;
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        if (!this.n) {
            this.n = true;
            X3 x3 = this.f;
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            x3.invoke(Gb.a("IN_CUSTOM_EXPAND", "onScroll"));
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        setViewTouchTimestamp(SystemClock.elapsedRealtime());
        if (!this.m) {
            this.m = true;
            X3 x3 = this.f;
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            x3.invoke(Gb.a("IN_CUSTOM_EXPAND", "onInteraction"));
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setLandingPageTelemetryControlInfo(R6 r6) {
        this.l = r6;
        C2592c4 c2592c4 = this.h;
        if (c2592c4 == null) {
            return;
        }
        c2592c4.j = r6;
        c2592c4.k = new O6(r6, c2592c4);
    }

    public void setViewTouchTimestamp(long j) {
        this.b = j;
    }

    @Override // com.inmobi.media.InterfaceC2961yb
    public final void a(String triggerApi) {
        Intrinsics.checkNotNullParameter(triggerApi, "triggerApi");
        HashMap hashMap = new HashMap();
        hashMap.put("creativeId", this.e);
        hashMap.put("trigger", triggerApi);
        hashMap.put("impressionId", this.d);
        hashMap.put("adType", this.c);
        Pd pd = Pd.f2401a;
        Pd.b("BlockAutoRedirection", hashMap, Td.f2443a);
    }
}

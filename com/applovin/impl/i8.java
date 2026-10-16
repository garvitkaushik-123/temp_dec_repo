package com.applovin.impl;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.applovin.impl.i8;
import com.applovin.impl.q4;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class i8 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f484a;
    private final com.applovin.impl.sdk.o b;
    private WebView c;
    private boolean d;
    private final Set e = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: Access modifiers changed from: private */
    class a extends r4 {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f485a;

        public a(boolean z) {
            this.f485a = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            i8.this.c.destroy();
            i8.this.c = null;
        }

        @Override // com.applovin.impl.r4
        protected Map a() {
            return CollectionUtils.hashMap("name", "WebTrackerManagerWebViewClient");
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.f485a) {
                com.applovin.impl.sdk.o unused = i8.this.b;
                if (com.applovin.impl.sdk.o.a()) {
                    i8.this.b.a("WebTrackerManager", "Successfully initialized web view for postbacks");
                }
                i8.this.d = true;
            }
        }

        @Override // com.applovin.impl.r4, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (webView == i8.this.c) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i8$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        i8.a.this.b();
                    }
                });
            } else {
                i8.this.b(webView);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    public i8(com.applovin.impl.sdk.k kVar) {
        this.f484a = kVar;
        this.b = kVar.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        final WebView a2 = a(str);
        if (a2 != null) {
            this.e.add(a2);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.i8$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    i8.this.b(a2);
                }
            }, ((Integer) this.f484a.a(v4.I2)).intValue());
        } else if (com.applovin.impl.sdk.o.a()) {
            this.b.b("WebTrackerManager", "Failed to fire tracker since web view could not be created");
        }
    }

    public void b() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i8$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                i8.this.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        WebView a2 = a("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>", true);
        this.c = a2;
        if (a2 == null && com.applovin.impl.sdk.o.a()) {
            this.b.b("WebTrackerManager", "Failed to preload postback web view");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.network.e eVar, final AppLovinPostbackListener appLovinPostbackListener) {
        final String appendQueryParameters = StringUtils.appendQueryParameters(eVar.f(), eVar.i(), ((Boolean) this.f484a.a(v4.g3)).booleanValue());
        if (this.c == null) {
            WebView a2 = a("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>", true);
            this.c = a2;
            if (a2 == null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.b("WebTrackerManager", "Failed to fire postback since web view could not be created");
                }
                appLovinPostbackListener.onPostbackFailure(appendQueryParameters, -1);
                return;
            }
        }
        if (c() && !this.d) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("WebTrackerManager", "Failed to fire postback since web view was not initialized in time");
            }
            HashMap<String, String> hashMap = CollectionUtils.hashMap("top_main_method", "firePostback");
            hashMap.put("source", "webViewNotInitialized");
            hashMap.put("url", appendQueryParameters);
            this.f484a.E().d(c2.N0, hashMap);
            appLovinPostbackListener.onPostbackFailure(appendQueryParameters, -1);
            return;
        }
        String str = "al_firePostback('" + appendQueryParameters + "')";
        if (((Boolean) this.f484a.a(v4.O2)).booleanValue()) {
            l8.a(this.c, str, this.f484a).a(this.f484a.r0().a("evaluateJavascriptPromise"), new q4.b() { // from class: com.applovin.impl.i8$$ExternalSyntheticLambda0
                @Override // com.applovin.impl.q4.b
                public final void a(boolean z, Object obj, Object obj2) {
                    i8.this.a(appLovinPostbackListener, appendQueryParameters, z, (String) obj, (String) obj2);
                }
            });
        } else {
            l8.a(this.c, str);
            appLovinPostbackListener.onPostbackSuccess(appendQueryParameters);
        }
    }

    public void a(final com.applovin.impl.sdk.network.e eVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i8$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                i8.this.b(eVar, appLovinPostbackListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinPostbackListener appLovinPostbackListener, String str, boolean z, String str2, String str3) {
        if (z) {
            appLovinPostbackListener.onPostbackSuccess(str);
            return;
        }
        appLovinPostbackListener.onPostbackFailure(str, -1);
        Map map = CollectionUtils.map("top_main_method", "firePostback");
        map.put("source", "evaluateJavascriptFailed");
        map.put("url", str);
        CollectionUtils.putStringIfValid("error_message", str3, map);
        this.f484a.E().d(c2.N0, map);
    }

    private boolean c() {
        return ((Boolean) this.f484a.a(v4.N2)).booleanValue();
    }

    private WebView a(String str) {
        return a(str, false);
    }

    private WebView a(String str, boolean z) {
        k7.b();
        WebView b = k7.b(com.applovin.impl.sdk.k.o(), "web tracker");
        if (b == null) {
            return null;
        }
        b.getSettings().setJavaScriptEnabled(true);
        b.setWebViewClient(new a(z && c()));
        b.loadData("<html><head><link rel=\"icon\" href=\"data:,\">" + str + "</head><body></body></html>", "text/html", "UTF-8");
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(final WebView webView) {
        if (webView == null || !this.e.remove(webView)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i8$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                webView.destroy();
            }
        });
    }

    public void b(final String str) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("WebTrackerManager", "Failed to fire tracker due to empty script string");
            }
        } else {
            if (!str.startsWith("<script")) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.b.b("WebTrackerManager", "Failed to fire tracker due to improperly formatted script tag");
                    return;
                }
                return;
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i8$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    i8.this.c(str);
                }
            });
        }
    }
}

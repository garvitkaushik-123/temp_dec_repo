package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.CollectionUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
public class j8 extends r4 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.o f509a;
    private WeakReference b;

    public interface a {
        void a(Uri uri, com.applovin.impl.adview.l lVar);

        void a(com.applovin.impl.adview.l lVar);

        void a(com.applovin.impl.adview.l lVar, Bundle bundle);

        void b(Uri uri, com.applovin.impl.adview.l lVar);

        void b(com.applovin.impl.adview.l lVar);

        void c(com.applovin.impl.adview.l lVar);

        void d(com.applovin.impl.adview.l lVar);
    }

    public j8(com.applovin.impl.sdk.k kVar) {
        this.f509a = kVar.O();
    }

    public void a(WeakReference weakReference) {
        this.b = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a(webView, str);
        return true;
    }

    @Override // com.applovin.impl.r4
    protected Map a() {
        return CollectionUtils.hashMap("name", "WebViewButtonClient");
    }

    private void a(WebView webView, String str) {
        if (com.applovin.impl.sdk.o.a()) {
            this.f509a.d("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        }
        if (str == null || !(webView instanceof com.applovin.impl.adview.l)) {
            return;
        }
        com.applovin.impl.adview.l lVar = (com.applovin.impl.adview.l) webView;
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        String path = parse.getPath();
        a aVar = (a) this.b.get();
        if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
            if ("/track_click".equals(path)) {
                aVar.b(lVar);
                return;
            }
            if ("/close_ad".equals(path)) {
                aVar.a(lVar);
                return;
            }
            if ("/skip_ad".equals(path)) {
                aVar.d(lVar);
                return;
            }
            if ("/direct_download".equals(path)) {
                aVar.a(lVar, h7.a(parse));
                return;
            }
            if ("/load_url".equals(path)) {
                aVar.a(parse, lVar);
                return;
            }
            if ("/template_error".equals(path)) {
                aVar.b(parse, lVar);
                return;
            }
            if ("/fully_watched".equals(path)) {
                aVar.c(lVar);
                return;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.f509a.k("WebViewButtonClient", "Unknown URL: " + str);
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.f509a.k("WebViewButtonClient", "Path: " + path);
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcgp extends zzcgo {
    public zzcgp(zzcfg zzcfgVar, zzbcc zzbccVar, boolean z, zzecl zzeclVar) {
        super(zzcfgVar, zzbccVar, z, zzeclVar);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzY(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}

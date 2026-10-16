package com.applovin.impl;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class r4 extends WebViewClient {
    protected abstract Map a();

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        HashMap<String, String> hashMap = CollectionUtils.hashMap("top_main_method", "onRenderProcessGone");
        hashMap.putAll(a());
        if (o0.h()) {
            hashMap.put("source", renderProcessGoneDetail.didCrash() ? AppMeasurement.CRASH_ORIGIN : "non_crash");
            hashMap.put("details", "renderer_priority_at_exit=" + renderProcessGoneDetail.rendererPriorityAtExit());
        }
        com.applovin.impl.sdk.k kVar = com.applovin.impl.sdk.k.D0;
        if (kVar != null) {
            com.applovin.impl.sdk.k.D0.E().a(c2.N0, hashMap, ((Long) kVar.a(v4.o3)).longValue());
        }
        com.applovin.impl.sdk.o.g("RenderProcessGoneHandlingWebViewClient", "onRenderProcessGone() handled");
        return true;
    }
}

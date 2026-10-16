package com.fyber.inneractive.sdk.flow.storepromo.controller.webview;

import com.fyber.inneractive.sdk.web.m;

/* loaded from: classes4.dex */
public final class a extends m {
    public final b h;

    public a(b bVar) {
        this.h = bVar;
        setWebViewClient(bVar);
        getSettings().setJavaScriptEnabled(true);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setOverScrollMode(2);
    }

    @Override // com.fyber.inneractive.sdk.web.m, android.webkit.WebView
    public final void destroy() {
        b bVar = this.h;
        bVar.f1218a = null;
        bVar.b = null;
        super.destroy();
    }
}

package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1272a;

    public c(e eVar) {
        this.f1272a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("clearing webview", new Object[0]);
        WebView webView = this.f1272a.e;
        if (webView != null) {
            webView.destroy();
            this.f1272a.e = null;
        }
    }
}

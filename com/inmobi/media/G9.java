package com.inmobi.media;

import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class G9 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2295a;

    public G9(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f2295a = new WeakReference(webView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView = (WebView) this.f2295a.get();
        WebSettings settings = webView != null ? webView.getSettings() : null;
        if (settings == null) {
            return;
        }
        settings.setBlockNetworkLoads(true);
    }
}

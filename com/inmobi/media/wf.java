package com.inmobi.media;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class wf extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(view, "view");
        return xf.a(view, renderProcessGoneDetail, "safe_web_view");
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b implements a {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final WebView f5950a;

    public b(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f5950a = webView;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge.a
    public void a() {
        this.f5950a.evaluateJavascript("notifyReadyEvent()", null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge.a
    public void a(boolean z) {
        this.f5950a.evaluateJavascript("setIsViewable(" + z + ')', null);
    }
}

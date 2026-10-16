package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class w extends WebViewClientCompat {
    public static final a g = new a(null);
    public static final int h = 8;
    public static final String i = "MraidWebViewClient";
    public static final String j = "com.moloco.sdk.xenoss.sdkdevkit.mraid.js";
    public static final String k = "mraid.js";

    /* renamed from: a, reason: collision with root package name */
    public final o f5919a;
    public final WebViewAssetLoader b;
    public final MutableStateFlow<Boolean> c;
    public final StateFlow<Boolean> d;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> e;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }

        public final Uri a(WebResourceRequest webResourceRequest) {
            String str;
            Uri url = webResourceRequest.getUrl();
            if (url == null || (str = url.toString()) == null) {
                str = "";
            }
            Uri parse = Uri.parse(StringsKt.replace(str, "mraid.js", w.j, true));
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            return parse;
        }
    }

    public w(Context context, o mraidJsCommandsSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidJsCommandsSource, "mraidJsCommandsSource");
        this.f5919a = mraidJsCommandsSource;
        WebViewAssetLoader build = new WebViewAssetLoader.Builder().addPathHandler(RemoteSettings.FORWARD_SLASH_STRING, new WebViewAssetLoader.AssetsPathHandler(context.getApplicationContext())).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.b = build;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.c = MutableStateFlow;
        this.d = MutableStateFlow;
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.e = MutableStateFlow2;
        this.f = FlowKt.asStateFlow(MutableStateFlow2);
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> a() {
        return this.f;
    }

    public final StateFlow<Boolean> b() {
        return this.d;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.c.setValue(Boolean.TRUE);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.c.setValue(Boolean.FALSE);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 23")
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        this.e.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.f5834a);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "onReceivedError " + str, null, false, 12, null);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.e.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.b);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "onRenderProcessGone", null, false, 12, null);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return this.b.shouldInterceptRequest(g.a(request));
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 24")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        return this.f5919a.a(str);
    }
}

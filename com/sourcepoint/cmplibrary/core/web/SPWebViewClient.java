package com.sourcepoint.cmplibrary.core.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.RenderingAppConnectionTimeoutException;
import com.sourcepoint.cmplibrary.exception.UrlLoadingException;
import com.sourcepoint.cmplibrary.exception.WebViewException;
import com.sourcepoint.cmplibrary.util.IOUtilsKt;
import com.sourcepoint.cmplibrary.util.WebViewUtilsKt;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SPWebViewClient.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 72\u00020\u0001:\u00017BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0019\u001a\u00020\tJ\u001c\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u001d\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u001f\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\"\u0010\"\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J*\u0010\"\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u000bH\u0017J&\u0010+\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\"\u0010.\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010%\u001a\u000201H\u0016J\u001a\u00102\u001a\u0002032\u0006\u0010\u001b\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0018\u00106\u001a\u0002032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000bH\u0017J\u001c\u00106\u001a\u0002032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00068"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/SPWebViewClient;", "Landroid/webkit/WebViewClient;", "wv", "Landroid/webkit/WebView;", "messageTimeout", "", "onError", "Lkotlin/Function1;", "Lcom/sourcepoint/cmplibrary/exception/ConsentLibExceptionK;", "", "onNoIntentActivitiesFoundFor", "", "timer", "Lcom/sourcepoint/cmplibrary/core/web/SpTimer;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "(Landroid/webkit/WebView;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/sourcepoint/cmplibrary/core/web/SpTimer;Lcom/sourcepoint/cmplibrary/exception/Logger;)V", "jsReceiverConfig", "Lkotlin/Function0;", "getJsReceiverConfig", "()Lkotlin/jvm/functions/Function0;", "setJsReceiverConfig", "(Lkotlin/jvm/functions/Function0;)V", "getWv", "()Landroid/webkit/WebView;", "cancelTimer", "onLoadResource", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "url", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", AdActivity.REQUEST_KEY_EXTRA, "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", IronSourceConstants.EVENTS_ERROR_CODE, "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "onRenderProcessGone", "", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "shouldOverrideUrlLoading", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SPWebViewClient extends WebViewClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(SPWebViewClient.class).getSimpleName();
    private Function0<String> jsReceiverConfig;
    private final Logger logger;
    private final long messageTimeout;
    private final Function1<ConsentLibExceptionK, Unit> onError;
    private final Function1<String, Unit> onNoIntentActivitiesFoundFor;
    private final SpTimer timer;
    private final WebView wv;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$1$lambda$0(String str) {
    }

    public final WebView getWv() {
        return this.wv;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SPWebViewClient(WebView wv, long j, Function1<? super ConsentLibExceptionK, Unit> onError, Function1<? super String, Unit> onNoIntentActivitiesFoundFor, SpTimer timer, Logger logger) {
        Intrinsics.checkNotNullParameter(wv, "wv");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onNoIntentActivitiesFoundFor, "onNoIntentActivitiesFoundFor");
        Intrinsics.checkNotNullParameter(timer, "timer");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.wv = wv;
        this.messageTimeout = j;
        this.onError = onError;
        this.onNoIntentActivitiesFoundFor = onNoIntentActivitiesFoundFor;
        this.timer = timer;
        this.logger = logger;
    }

    public final Function0<String> getJsReceiverConfig() {
        return this.jsReceiverConfig;
    }

    public final void setJsReceiverConfig(Function0<String> function0) {
        this.jsReceiverConfig = function0;
    }

    /* compiled from: SPWebViewClient.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/SPWebViewClient$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return SPWebViewClient.TAG;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(final WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        this.timer.executeDelay(this.messageTimeout, new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.core.web.SPWebViewClient$onPageStarted$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1 function1;
                long j;
                WebView webView = view;
                if (webView != null) {
                    webView.stopLoading();
                }
                function1 = this.onError;
                j = this.messageTimeout;
                function1.invoke(new RenderingAppConnectionTimeoutException(null, "There was an error while loading the rendering app. onConsentReady was not called within " + j + " seconds.", false, 5, null));
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onPageFinished(view, url);
        try {
            Function0<String> function0 = this.jsReceiverConfig;
            if (function0 != null) {
                view.evaluateJavascript(function0.invoke(), new ValueCallback() { // from class: com.sourcepoint.cmplibrary.core.web.SPWebViewClient$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) {
                        SPWebViewClient.onPageFinished$lambda$1$lambda$0((String) obj);
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                SPWebViewClient sPWebViewClient = this;
                view.loadUrl("javascript:" + IOUtilsKt.file2String("js_receiver.js"));
                Logger logger = this.logger;
                String name = SPWebViewClient.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                logger.d(name, "jsReceiverConfig is null!! \nThis means that the Legislation is not set and cannot deciding which is the correct link GDPR or CCPA?");
            }
        } catch (Throwable th) {
            this.onError.invoke(new WebViewException(th, "Unable to load jsReceiver into ConasentLibWebview.", false, 4, null));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(error, "error");
        super.onReceivedError(view, request, error);
        this.onError.invoke(new WebViewException(null, error.toString(), false, 5, null));
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Will be removed once we bump min supported API level to 24")
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        super.onReceivedError(view, errorCode, description, failingUrl);
        this.onError.invoke(new WebViewException(null, description, false, 5, null));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(error, "error");
        super.onReceivedSslError(view, handler, error);
        Function1<ConsentLibExceptionK, Unit> function1 = this.onError;
        String sslError = error.toString();
        Intrinsics.checkNotNullExpressionValue(sslError, "toString(...)");
        function1.invoke(new WebViewException(null, sslError, false, 5, null));
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.onError.invoke(new WebViewException(null, "The WebView rendering process crashed!", false, 5, null));
        return false;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Will be removed once we bump min supported API level to 24")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Context context = this.wv.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WebViewUtilsKt.loadLinkOnExternalBrowser(context, url, this.onNoIntentActivitiesFoundFor);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Context context = this.wv.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WebViewUtilsKt.loadLinkOnExternalBrowser(context, String.valueOf(request != null ? request.getUrl() : null), this.onNoIntentActivitiesFoundFor);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        String lineSeparator = System.lineSeparator();
        Map<String, String> responseHeaders = errorResponse != null ? errorResponse.getResponseHeaders() : null;
        Intrinsics.checkNotNull(responseHeaders);
        List<Pair> list = MapsKt.toList(responseHeaders);
        StringBuilder sb = new StringBuilder();
        for (Pair pair : list) {
            sb.append(pair.getFirst() + ":" + pair.getSecond() + " " + lineSeparator);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        String str = "Error loading SPWebViewClient " + lineSeparator + " StatusCode ---> " + errorResponse.getStatusCode() + " " + lineSeparator + sb2 + " ";
        Logger logger = this.logger;
        String name = getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        logger.e(name, str);
        this.onError.invoke(new UrlLoadingException(null, "The client failed to load the resource!!", false, 5, null));
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);
    }

    public final void cancelTimer() {
        this.timer.cancel();
    }
}

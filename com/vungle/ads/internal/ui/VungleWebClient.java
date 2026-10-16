package com.vungle.ads.internal.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.EvaluateJsError;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.omsdk.WebViewObserver;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import com.vungle.ads.internal.util.Logger;
import io.bidmachine.iab.mraid.MraidNativeFeature;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: VungleWebClient.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0002|}B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ \u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u000fH\u0002J\u0010\u0010U\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020\u001eH\u0002J\u000e\u0010V\u001a\u00020Q2\u0006\u0010W\u001a\u00020XJ\u0010\u0010Y\u001a\u00020Q2\u0006\u0010Z\u001a\u00020\u000fH\u0016J\u000e\u0010[\u001a\u00020Q2\u0006\u0010\\\u001a\u00020\u000fJ\u001c\u0010]\u001a\u00020Q2\b\u0010^\u001a\u0004\u0018\u0001082\b\u0010S\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010_\u001a\u00020Q2\b\u0010^\u001a\u0004\u0018\u0001082\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J*\u0010_\u001a\u00020Q2\b\u0010^\u001a\u0004\u0018\u0001082\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\u001eH\u0017J&\u0010h\u001a\u00020Q2\b\u0010^\u001a\u0004\u0018\u0001082\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u001c\u0010k\u001a\u00020\u000f2\b\u0010^\u001a\u0004\u0018\u0001082\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u001a\u0010n\u001a\u00020Q2\b\u0010o\u001a\u0004\u0018\u0001082\u0006\u0010p\u001a\u00020\u001eH\u0002J\u0010\u0010q\u001a\u00020Q2\u0006\u00100\u001a\u00020\u000fH\u0016J8\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020\u000f2\b\u0010t\u001a\u0004\u0018\u00010\u001e2\b\u0010u\u001a\u0004\u0018\u00010\u001e2\b\u0010v\u001a\u0004\u0018\u00010\u001e2\b\u0010w\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010x\u001a\u00020Q2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010y\u001a\u00020Q2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010z\u001a\u00020Q2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001c\u0010{\u001a\u00020\u000f2\b\u0010^\u001a\u0004\u0018\u0001082\b\u0010S\u001a\u0004\u0018\u00010\u001eH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010$\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R&\u0010(\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0011\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R&\u0010,\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R(\u00100\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0016\n\u0002\u00106\u0012\u0004\b1\u0010\u0011\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u00107\u001a\u0004\u0018\u0001088\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0011\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R&\u0010>\u001a\u0004\u0018\u00010?8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010E\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010I\u001a\u0004\u0018\u00010J8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bK\u0010\u0011\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006~"}, d2 = {"Lcom/vungle/ads/internal/ui/VungleWebClient;", "Landroid/webkit/WebViewClient;", "Lcom/vungle/ads/internal/ui/view/WebViewAPI;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "offloadExecutor", "Ljava/util/concurrent/ExecutorService;", "signalManager", "Lcom/vungle/ads/internal/signals/SignalManager;", N6.H, "Lcom/vungle/ads/internal/platform/Platform;", "(Lcom/vungle/ads/internal/model/AdPayload;Lcom/vungle/ads/internal/model/Placement;Ljava/util/concurrent/ExecutorService;Lcom/vungle/ads/internal/signals/SignalManager;Lcom/vungle/ads/internal/platform/Platform;)V", "collectConsent", "", "getCollectConsent$vungle_ads_release$annotations", "()V", "getCollectConsent$vungle_ads_release", "()Z", "setCollectConsent$vungle_ads_release", "(Z)V", "errorHandler", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "getErrorHandler$vungle_ads_release$annotations", "getErrorHandler$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "setErrorHandler$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;)V", "gdprAccept", "", "getGdprAccept$vungle_ads_release$annotations", "getGdprAccept$vungle_ads_release", "()Ljava/lang/String;", "setGdprAccept$vungle_ads_release", "(Ljava/lang/String;)V", "gdprBody", "getGdprBody$vungle_ads_release$annotations", "getGdprBody$vungle_ads_release", "setGdprBody$vungle_ads_release", "gdprDeny", "getGdprDeny$vungle_ads_release$annotations", "getGdprDeny$vungle_ads_release", "setGdprDeny$vungle_ads_release", "gdprTitle", "getGdprTitle$vungle_ads_release$annotations", "getGdprTitle$vungle_ads_release", "setGdprTitle$vungle_ads_release", C3040d4.h.o, "isViewable$vungle_ads_release$annotations", "isViewable$vungle_ads_release", "()Ljava/lang/Boolean;", "setViewable$vungle_ads_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "loadedWebView", "Landroid/webkit/WebView;", "getLoadedWebView$vungle_ads_release$annotations", "getLoadedWebView$vungle_ads_release", "()Landroid/webkit/WebView;", "setLoadedWebView$vungle_ads_release", "(Landroid/webkit/WebView;)V", "mraidDelegate", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;", "getMraidDelegate$vungle_ads_release$annotations", "getMraidDelegate$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;", "setMraidDelegate$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;)V", C3040d4.h.s, "getReady$vungle_ads_release$annotations", "getReady$vungle_ads_release", "setReady$vungle_ads_release", "webViewObserver", "Lcom/vungle/ads/internal/omsdk/WebViewObserver;", "getWebViewObserver$vungle_ads_release$annotations", "getWebViewObserver$vungle_ads_release", "()Lcom/vungle/ads/internal/omsdk/WebViewObserver;", "setWebViewObserver$vungle_ads_release", "(Lcom/vungle/ads/internal/omsdk/WebViewObserver;)V", "handleWebViewError", "", "errorMsg", "url", "didCrash", "isCriticalAsset", "notifyDiskAvailableSize", ContentDisposition.Parameters.Size, "", "notifyPropertiesChange", "skipCmdQueue", "notifySilentModeChange", "silentModeEnabled", "onPageFinished", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "onReceivedError", AdActivity.REQUEST_KEY_EXTRA, "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", IronSourceConstants.EVENTS_ERROR_CODE, "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "runJavascriptOnWebView", "webView", "injectJs", "setAdVisibility", "setConsentStatus", "collectedConsent", "title", PglCryptUtils.KEY_MESSAGE, "accept", "deny", "setErrorHandler", "setMraidDelegate", "setWebViewObserver", "shouldOverrideUrlLoading", "Companion", "VungleWebViewRenderProcessClient", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class VungleWebClient extends WebViewClient implements WebViewAPI {
    private static final String TAG = "VungleWebClient";
    private final AdPayload advertisement;
    private boolean collectConsent;
    private WebViewAPI.WebClientErrorHandler errorHandler;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private Boolean isViewable;
    private WebView loadedWebView;
    private WebViewAPI.MraidDelegate mraidDelegate;
    private final ExecutorService offloadExecutor;
    private final Placement placement;
    private final Platform platform;
    private boolean ready;
    private final SignalManager signalManager;
    private WebViewObserver webViewObserver;

    public static /* synthetic */ void getCollectConsent$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getErrorHandler$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprAccept$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprBody$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprDeny$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprTitle$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getLoadedWebView$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMraidDelegate$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getReady$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getWebViewObserver$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void isViewable$vungle_ads_release$annotations() {
    }

    public /* synthetic */ VungleWebClient(AdPayload adPayload, Placement placement, ExecutorService executorService, SignalManager signalManager, Platform platform, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adPayload, placement, executorService, (i & 8) != 0 ? null : signalManager, (i & 16) != 0 ? null : platform);
    }

    public VungleWebClient(AdPayload advertisement, Placement placement, ExecutorService offloadExecutor, SignalManager signalManager, Platform platform) {
        Intrinsics.checkNotNullParameter(advertisement, "advertisement");
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(offloadExecutor, "offloadExecutor");
        this.advertisement = advertisement;
        this.placement = placement;
        this.offloadExecutor = offloadExecutor;
        this.signalManager = signalManager;
        this.platform = platform;
    }

    /* renamed from: getCollectConsent$vungle_ads_release, reason: from getter */
    public final boolean getCollectConsent() {
        return this.collectConsent;
    }

    public final void setCollectConsent$vungle_ads_release(boolean z) {
        this.collectConsent = z;
    }

    /* renamed from: getGdprTitle$vungle_ads_release, reason: from getter */
    public final String getGdprTitle() {
        return this.gdprTitle;
    }

    public final void setGdprTitle$vungle_ads_release(String str) {
        this.gdprTitle = str;
    }

    /* renamed from: getGdprBody$vungle_ads_release, reason: from getter */
    public final String getGdprBody() {
        return this.gdprBody;
    }

    public final void setGdprBody$vungle_ads_release(String str) {
        this.gdprBody = str;
    }

    /* renamed from: getGdprAccept$vungle_ads_release, reason: from getter */
    public final String getGdprAccept() {
        return this.gdprAccept;
    }

    public final void setGdprAccept$vungle_ads_release(String str) {
        this.gdprAccept = str;
    }

    /* renamed from: getGdprDeny$vungle_ads_release, reason: from getter */
    public final String getGdprDeny() {
        return this.gdprDeny;
    }

    public final void setGdprDeny$vungle_ads_release(String str) {
        this.gdprDeny = str;
    }

    /* renamed from: getLoadedWebView$vungle_ads_release, reason: from getter */
    public final WebView getLoadedWebView() {
        return this.loadedWebView;
    }

    public final void setLoadedWebView$vungle_ads_release(WebView webView) {
        this.loadedWebView = webView;
    }

    /* renamed from: getReady$vungle_ads_release, reason: from getter */
    public final boolean getReady() {
        return this.ready;
    }

    public final void setReady$vungle_ads_release(boolean z) {
        this.ready = z;
    }

    /* renamed from: getMraidDelegate$vungle_ads_release, reason: from getter */
    public final WebViewAPI.MraidDelegate getMraidDelegate() {
        return this.mraidDelegate;
    }

    public final void setMraidDelegate$vungle_ads_release(WebViewAPI.MraidDelegate mraidDelegate) {
        this.mraidDelegate = mraidDelegate;
    }

    /* renamed from: getErrorHandler$vungle_ads_release, reason: from getter */
    public final WebViewAPI.WebClientErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public final void setErrorHandler$vungle_ads_release(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        this.errorHandler = webClientErrorHandler;
    }

    /* renamed from: getWebViewObserver$vungle_ads_release, reason: from getter */
    public final WebViewObserver getWebViewObserver() {
        return this.webViewObserver;
    }

    public final void setWebViewObserver$vungle_ads_release(WebViewObserver webViewObserver) {
        this.webViewObserver = webViewObserver;
    }

    /* renamed from: isViewable$vungle_ads_release, reason: from getter */
    public final Boolean getIsViewable() {
        return this.isViewable;
    }

    public final void setViewable$vungle_ads_release(Boolean bool) {
        this.isViewable = bool;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setConsentStatus(boolean collectedConsent, String title, String message, String accept, String deny) {
        this.collectConsent = collectedConsent;
        this.gdprTitle = title;
        this.gdprBody = message;
        this.gdprAccept = accept;
        this.gdprDeny = deny;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setMraidDelegate(WebViewAPI.MraidDelegate mraidDelegate) {
        this.mraidDelegate = mraidDelegate;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(final WebView view, String url) {
        Logger.INSTANCE.d(TAG, "MRAID Command " + url);
        String str = url;
        if (str == null || str.length() == 0) {
            Logger.INSTANCE.e(TAG, "Invalid URL ");
            return false;
        }
        Uri parse = Uri.parse(url);
        if (parse == null || parse.getScheme() == null) {
            return false;
        }
        String scheme = parse.getScheme();
        if (Intrinsics.areEqual(scheme, "mraid")) {
            final String host = parse.getHost();
            if (host != null) {
                if (Intrinsics.areEqual("propertiesChangeCompleted", host)) {
                    if (!this.ready) {
                        this.ready = true;
                        final Handler handler = new Handler(Looper.getMainLooper());
                        this.offloadExecutor.submit(new Runnable() { // from class: com.vungle.ads.internal.ui.VungleWebClient$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                VungleWebClient.m9399shouldOverrideUrlLoading$lambda6$lambda1(VungleWebClient.this, handler, view);
                            }
                        });
                    }
                } else {
                    final WebViewAPI.MraidDelegate mraidDelegate = this.mraidDelegate;
                    if (mraidDelegate != null) {
                        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                        for (String param : parse.getQueryParameterNames()) {
                            Intrinsics.checkNotNullExpressionValue(param, "param");
                            JsonElementBuildersKt.put(jsonObjectBuilder, param, parse.getQueryParameter(param));
                        }
                        final JsonObject build = jsonObjectBuilder.build();
                        final Handler handler2 = new Handler(Looper.getMainLooper());
                        this.offloadExecutor.submit(new Runnable() { // from class: com.vungle.ads.internal.ui.VungleWebClient$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                VungleWebClient.m9401shouldOverrideUrlLoading$lambda6$lambda5$lambda4(WebViewAPI.MraidDelegate.this, host, build, handler2, this, view);
                            }
                        });
                        return true;
                    }
                }
                return true;
            }
        } else if (StringsKt.equals("http", scheme, true) || StringsKt.equals("https", scheme, true)) {
            Logger.INSTANCE.d(TAG, "Open URL" + url);
            WebViewAPI.MraidDelegate mraidDelegate2 = this.mraidDelegate;
            if (mraidDelegate2 != null) {
                JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                JsonElementBuildersKt.put(jsonObjectBuilder2, "url", url);
                mraidDelegate2.processCommand("openNonMraid", jsonObjectBuilder2.build());
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-1, reason: not valid java name */
    public static final void m9399shouldOverrideUrlLoading$lambda6$lambda1(final VungleWebClient this$0, Handler handler, final WebView webView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        final String str = "window.vungle.mraidBridge.notifyReadyEvent(" + this$0.advertisement.createMRAIDArgs() + ')';
        handler.post(new Runnable() { // from class: com.vungle.ads.internal.ui.VungleWebClient$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VungleWebClient.m9400shouldOverrideUrlLoading$lambda6$lambda1$lambda0(VungleWebClient.this, webView, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-1$lambda-0, reason: not valid java name */
    public static final void m9400shouldOverrideUrlLoading$lambda6$lambda1$lambda0(VungleWebClient this$0, WebView webView, String injectJs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(injectJs, "$injectJs");
        this$0.runJavascriptOnWebView(webView, injectJs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-5$lambda-4, reason: not valid java name */
    public static final void m9401shouldOverrideUrlLoading$lambda6$lambda5$lambda4(WebViewAPI.MraidDelegate it, String command, JsonObject args, Handler handler, final VungleWebClient this$0, final WebView webView) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(command, "$command");
        Intrinsics.checkNotNullParameter(args, "$args");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it.processCommand(command, args)) {
            handler.post(new Runnable() { // from class: com.vungle.ads.internal.ui.VungleWebClient$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VungleWebClient.m9402shouldOverrideUrlLoading$lambda6$lambda5$lambda4$lambda3(VungleWebClient.this, webView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-6$lambda-5$lambda-4$lambda-3, reason: not valid java name */
    public static final void m9402shouldOverrideUrlLoading$lambda6$lambda5$lambda4$lambda3(VungleWebClient this$0, WebView webView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyCommandComplete()");
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (view == null) {
            return;
        }
        this.loadedWebView = view;
        if (view != null) {
            view.setVisibility(0);
        }
        notifyPropertiesChange(true);
        if (Build.VERSION.SDK_INT >= 29) {
            view.setWebViewRenderProcessClient(new VungleWebViewRenderProcessClient(this.errorHandler));
        }
        WebViewObserver webViewObserver = this.webViewObserver;
        if (webViewObserver != null) {
            webViewObserver.onPageFinished(view);
        }
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void notifyPropertiesChange(boolean skipCmdQueue) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder2, "width", Integer.valueOf(webView.getWidth()));
            JsonElementBuildersKt.put(jsonObjectBuilder2, "height", Integer.valueOf(webView.getHeight()));
            JsonObject build = jsonObjectBuilder2.build();
            JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder3, VastAttributes.HORIZONTAL_POSITION, (Number) 0);
            JsonElementBuildersKt.put(jsonObjectBuilder3, VastAttributes.VERTICAL_POSITION, (Number) 0);
            JsonElementBuildersKt.put(jsonObjectBuilder3, "width", Integer.valueOf(webView.getWidth()));
            JsonElementBuildersKt.put(jsonObjectBuilder3, "height", Integer.valueOf(webView.getHeight()));
            JsonObject build2 = jsonObjectBuilder3.build();
            JsonObjectBuilder jsonObjectBuilder4 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder4, "sms", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "tel", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "calendar", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "storePicture", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, MraidNativeFeature.FEATURE_INLINE_VIDEO, (Boolean) false);
            JsonObject build3 = jsonObjectBuilder4.build();
            JsonObject jsonObject = build;
            jsonObjectBuilder.put("maxSize", jsonObject);
            jsonObjectBuilder.put("screenSize", jsonObject);
            JsonObject jsonObject2 = build2;
            jsonObjectBuilder.put("defaultPosition", jsonObject2);
            jsonObjectBuilder.put("currentPosition", jsonObject2);
            jsonObjectBuilder.put("supports", build3);
            JsonElementBuildersKt.put(jsonObjectBuilder, "placementType", this.advertisement.templateType());
            Boolean bool = this.isViewable;
            if (bool != null) {
                JsonElementBuildersKt.put(jsonObjectBuilder, C3040d4.h.o, Boolean.valueOf(bool.booleanValue()));
            }
            JsonElementBuildersKt.put(jsonObjectBuilder, N6.F, "android");
            JsonElementBuildersKt.put(jsonObjectBuilder, "osVersion", String.valueOf(Build.VERSION.SDK_INT));
            JsonElementBuildersKt.put(jsonObjectBuilder, "incentivized", Boolean.valueOf(this.placement.isRewardedVideo()));
            JsonElementBuildersKt.put(jsonObjectBuilder, "version", "1.0");
            Platform platform = this.platform;
            if (platform != null) {
                JsonElementBuildersKt.put(jsonObjectBuilder, "isSilent", Boolean.valueOf(platform.isSilentModeEnabled()));
            }
            if (this.collectConsent) {
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentRequired", (Boolean) true);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentTitleText", this.gdprTitle);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentBodyText", this.gdprBody);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentAcceptButtonText", this.gdprAccept);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentDenyButtonText", this.gdprDeny);
            } else {
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentRequired", (Boolean) false);
            }
            if (!ConfigManager.INSTANCE.signalsDisabled()) {
                SignalManager signalManager = this.signalManager;
                String uuid = signalManager != null ? signalManager.getUuid() : null;
                if (uuid != null && uuid.length() != 0) {
                    SignalManager signalManager2 = this.signalManager;
                    JsonElementBuildersKt.put(jsonObjectBuilder, JsonStorageKeyNames.SESSION_ID_KEY, signalManager2 != null ? signalManager2.getUuid() : null);
                }
            }
            JsonElementBuildersKt.put(jsonObjectBuilder, "sdkVersion", BuildConfig.VERSION_NAME);
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObjectBuilder.build() + AbstractJsonLexerKt.COMMA + skipCmdQueue + ')');
        }
    }

    public final void notifyDiskAvailableSize(long size) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            runJavascriptOnWebView(webView, "window.vungle.mraidBridgeExt.notifyAvailableDiskSpace(" + size + ')');
        }
    }

    public final void notifySilentModeChange(boolean silentModeEnabled) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder, "isSilent", Boolean.valueOf(silentModeEnabled));
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + jsonObjectBuilder.build() + ')');
        }
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setAdVisibility(boolean isViewable) {
        this.isViewable = Boolean.valueOf(isViewable);
        notifyPropertiesChange(false);
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setErrorHandler(WebViewAPI.WebClientErrorHandler errorHandler) {
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        this.errorHandler = errorHandler;
    }

    @Override // com.vungle.ads.internal.ui.view.WebViewAPI
    public void setWebViewObserver(WebViewObserver webViewObserver) {
        this.webViewObserver = webViewObserver;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Java")
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        String valueOf = String.valueOf(errorResponse != null ? Integer.valueOf(errorResponse.getStatusCode()) : null);
        String valueOf2 = String.valueOf(request != null ? request.getUrl() : null);
        boolean z = request != null && request.isForMainFrame();
        Logger.INSTANCE.e(TAG, "Http Error desc " + valueOf + ' ' + z + " for URL " + valueOf2);
        handleWebViewError(valueOf, valueOf2, isCriticalAsset(valueOf2) && z);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        String valueOf = String.valueOf(error != null ? error.getDescription() : null);
        String valueOf2 = String.valueOf(request != null ? request.getUrl() : null);
        boolean z = request != null && request.isForMainFrame();
        Logger.INSTANCE.e(TAG, "Error desc " + valueOf + ' ' + z + " for URL " + valueOf2);
        handleWebViewError(valueOf, valueOf2, isCriticalAsset(valueOf2) && z);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        this.loadedWebView = null;
        Logger.INSTANCE.w(TAG, "onRenderProcessGone url: " + (view != null ? view.getUrl() : null) + ", did crash: " + (detail != null ? Boolean.valueOf(detail.didCrash()) : null));
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            return webClientErrorHandler.onWebRenderingProcessGone(view, detail != null ? Boolean.valueOf(detail.didCrash()) : null);
        }
        return super.onRenderProcessGone(view, detail);
    }

    private final void handleWebViewError(String errorMsg, String url, boolean didCrash) {
        String str = url + ' ' + errorMsg;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            webClientErrorHandler.onReceivedError(str, didCrash);
        }
    }

    private final boolean isCriticalAsset(String url) {
        if (url.length() > 0) {
            return this.advertisement.isCriticalAsset(url);
        }
        return false;
    }

    private final void runJavascriptOnWebView(WebView webView, String injectJs) {
        try {
            Logger.INSTANCE.w(TAG, "mraid Injecting JS " + injectJs);
            if (webView != null) {
                webView.evaluateJavascript(injectJs, null);
            }
        } catch (Throwable th) {
            new EvaluateJsError("Evaluate js failed " + th.getLocalizedMessage()).setLogEntry$vungle_ads_release(this.advertisement.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    /* compiled from: VungleWebClient.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vungle/ads/internal/ui/VungleWebClient$VungleWebViewRenderProcessClient;", "Landroid/webkit/WebViewRenderProcessClient;", "errorHandler", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "(Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;)V", "onRenderProcessResponsive", "", "webView", "Landroid/webkit/WebView;", "webViewRenderProcess", "Landroid/webkit/WebViewRenderProcess;", "onRenderProcessUnresponsive", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class VungleWebViewRenderProcessClient extends WebViewRenderProcessClient {
        private WebViewAPI.WebClientErrorHandler errorHandler;

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            Intrinsics.checkNotNullParameter(webView, "webView");
        }

        public VungleWebViewRenderProcessClient(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Logger.INSTANCE.w(VungleWebClient.TAG, "onRenderProcessUnresponsive(Title = " + webView.getTitle() + ", URL = " + webView.getOriginalUrl() + ", (webViewRenderProcess != null) = " + (webViewRenderProcess != null));
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }
}

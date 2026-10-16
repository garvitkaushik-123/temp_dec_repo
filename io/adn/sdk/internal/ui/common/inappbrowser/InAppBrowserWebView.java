package io.adn.sdk.internal.ui.common.inappbrowser;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppBrowserWebView.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0003J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "webViewClientDelegate", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserWebViewClient;", "eventListener", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEventListener;", "configureWebView", "", "setEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "loadUrl", "url", "", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InAppBrowserWebView extends WebView {
    public static final int $stable = 8;
    private InAppBrowserEventListener eventListener;
    private final InAppBrowserWebViewClient webViewClientDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppBrowserWebView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.webViewClientDelegate = new InAppBrowserWebViewClient();
        configureWebView();
    }

    private final void configureWebView() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setWebViewClient(this.webViewClientDelegate);
        setWebChromeClient(new WebChromeClient());
    }

    public final void setEventListener(InAppBrowserEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.eventListener = listener;
        this.webViewClientDelegate.setEventListener(listener);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        super.loadUrl(url);
        InAppBrowserEventListener inAppBrowserEventListener = this.eventListener;
        if (inAppBrowserEventListener != null) {
            inAppBrowserEventListener.onEvent(new InAppBrowserEvent.LoadInitiated(url));
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            Result.Companion companion = Result.INSTANCE;
            InAppBrowserWebView inAppBrowserWebView = this;
            stopLoading();
            setWebViewClient(new WebViewClient());
            removeAllViews();
            this.eventListener = null;
            super.destroy();
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}

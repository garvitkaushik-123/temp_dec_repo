package io.adn.sdk.internal.ui.common.inappbrowser;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.ads.internal.ui.AdActivity;
import io.adn.sdk.internal.common.model.UrlInfo;
import io.adn.sdk.internal.common.utils.UriKt;
import io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent;
import io.adn.sdk.publisher.inappbrowser.AdnWebViewError;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppBrowserWebViewClient.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J&\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\u0017\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0017J\u001c\u0010\u001c\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\tH\u0002J\f\u0010 \u001a\u00020\u0015*\u00020\tH\u0002J\f\u0010!\u001a\u00020\u000b*\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserWebViewClient;", "Landroid/webkit/WebViewClient;", "<init>", "()V", "eventListener", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEventListener;", "currentNavigationState", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserWebViewClient$NavigationState;", "lastVisitedUrl", "", "setEventListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onPageStarted", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/webkit/WebView;", "url", "favicon", "Landroid/graphics/Bitmap;", "doUpdateVisitedHistory", "isReload", "", "onPageFinished", "onReceivedError", IronSourceConstants.EVENTS_ERROR_CODE, "", "description", "failingUrl", "shouldOverrideUrlLoading", AdActivity.REQUEST_KEY_EXTRA, "Landroid/webkit/WebResourceRequest;", "shouldOverrideNavigation", "isValidWebUrl", "showErrorPage", "NavigationState", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InAppBrowserWebViewClient extends WebViewClient {
    public static final int $stable = 8;
    private NavigationState currentNavigationState = NavigationState.None;
    private InAppBrowserEventListener eventListener;
    private String lastVisitedUrl;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: InAppBrowserWebViewClient.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserWebViewClient$NavigationState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Started", "Failed", "Loaded", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class NavigationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NavigationState[] $VALUES;
        public static final NavigationState None = new NavigationState("None", 0);
        public static final NavigationState Started = new NavigationState("Started", 1);
        public static final NavigationState Failed = new NavigationState("Failed", 2);
        public static final NavigationState Loaded = new NavigationState("Loaded", 3);

        private static final /* synthetic */ NavigationState[] $values() {
            return new NavigationState[]{None, Started, Failed, Loaded};
        }

        public static EnumEntries<NavigationState> getEntries() {
            return $ENTRIES;
        }

        static {
            NavigationState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private NavigationState(String str, int i) {
        }

        public static NavigationState valueOf(String str) {
            return (NavigationState) Enum.valueOf(NavigationState.class, str);
        }

        public static NavigationState[] values() {
            return (NavigationState[]) $VALUES.clone();
        }
    }

    public final void setEventListener(InAppBrowserEventListener listener) {
        this.eventListener = listener;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        this.currentNavigationState = NavigationState.Started;
        InAppBrowserEventListener inAppBrowserEventListener = this.eventListener;
        if (inAppBrowserEventListener != null) {
            inAppBrowserEventListener.onEvent(new InAppBrowserEvent.PageLoadStarted(url));
        }
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
        if (Intrinsics.areEqual(this.lastVisitedUrl, url) || isReload) {
            return;
        }
        this.lastVisitedUrl = url;
        InAppBrowserEventListener inAppBrowserEventListener = this.eventListener;
        if (inAppBrowserEventListener != null) {
            inAppBrowserEventListener.onEvent(new InAppBrowserEvent.PageHistoryUpdated(url));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (this.currentNavigationState == NavigationState.Failed || view == null || view.getProgress() != 100) {
            return;
        }
        this.currentNavigationState = NavigationState.Loaded;
        InAppBrowserEventListener inAppBrowserEventListener = this.eventListener;
        if (inAppBrowserEventListener != null) {
            inAppBrowserEventListener.onEvent(new InAppBrowserEvent.PageLoadFinished(url));
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 23")
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        if (this.currentNavigationState == NavigationState.Failed) {
            return;
        }
        this.currentNavigationState = NavigationState.Failed;
        InAppBrowserEventListener inAppBrowserEventListener = this.eventListener;
        if (inAppBrowserEventListener != null) {
            inAppBrowserEventListener.onEvent(new InAppBrowserEvent.LoadError(failingUrl, new AdnWebViewError(errorCode, description)));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Uri url;
        String uri;
        if (request == null || (url = request.getUrl()) == null || (uri = url.toString()) == null) {
            return false;
        }
        return shouldOverrideNavigation(uri);
    }

    private final boolean shouldOverrideNavigation(String url) {
        UrlInfo analyzeUrl = UriKt.analyzeUrl(url);
        if (!analyzeUrl.isValid()) {
            return true;
        }
        if (!analyzeUrl.isDeeplink()) {
            return false;
        }
        InAppBrowserEventListener inAppBrowserEventListener = this.eventListener;
        if (inAppBrowserEventListener != null) {
            inAppBrowserEventListener.onEvent(new InAppBrowserEvent.DeepLinkRequested(url));
        }
        return true;
    }

    private final boolean isValidWebUrl(String str) {
        return str.length() > 0 && !Intrinsics.areEqual(str, "file:///android_asset/adn_error_page.html");
    }

    private final void showErrorPage(WebView webView) {
        webView.loadUrl("file:///android_asset/adn_error_page.html");
    }
}

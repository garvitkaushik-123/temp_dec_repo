package io.adn.sdk.internal.ui.common.inappbrowser;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.data.service.ExternalLinkNavigator;
import io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserListener;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppBrowserImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserImpl;", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowser;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEventListener;", "url", "", "browserWebView", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserWebView;", "browserTracker", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserTracker;", "externalLinkNavigator", "Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserWebView;Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserTracker;Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;)V", "getUrl", "()Ljava/lang/String;", "uuid", "getUuid", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserListener;", "getView", "load", "", "goBack", "goForward", "reload", "canGoBack", "", "canGoForward", "setListener", "release", "onEvent", "event", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InAppBrowserImpl implements AdnInAppBrowser, InAppBrowserEventListener {
    public static final int $stable = 8;
    private final InAppBrowserTracker browserTracker;
    private final InAppBrowserWebView browserWebView;
    private final ExternalLinkNavigator externalLinkNavigator;
    private AdnInAppBrowserListener listener;
    private final String url;
    private final String uuid;

    public InAppBrowserImpl(String url, InAppBrowserWebView browserWebView, InAppBrowserTracker browserTracker, ExternalLinkNavigator externalLinkNavigator) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(browserWebView, "browserWebView");
        Intrinsics.checkNotNullParameter(browserTracker, "browserTracker");
        Intrinsics.checkNotNullParameter(externalLinkNavigator, "externalLinkNavigator");
        this.url = url;
        this.browserWebView = browserWebView;
        this.browserTracker = browserTracker;
        this.externalLinkNavigator = externalLinkNavigator;
        this.uuid = ConversionsKt.randomUUID();
        browserWebView.setEventListener(this);
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public String getUrl() {
        return this.url;
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public String getUuid() {
        return this.uuid;
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    /* renamed from: getView, reason: from getter */
    public InAppBrowserWebView getBrowserWebView() {
        return this.browserWebView;
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public void load() {
        this.browserWebView.loadUrl(getUrl());
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public void goBack() {
        this.browserWebView.goBack();
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public void goForward() {
        this.browserWebView.goForward();
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public void reload() {
        this.browserWebView.reload();
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public boolean canGoBack() {
        return this.browserWebView.canGoBack();
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public boolean canGoForward() {
        return this.browserWebView.canGoForward();
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public void setListener(AdnInAppBrowserListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser
    public void release() {
        this.listener = null;
        this.browserTracker.onBrowserClosed();
        this.browserWebView.destroy();
    }

    @Override // io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEventListener
    public void onEvent(InAppBrowserEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof InAppBrowserEvent.DeepLinkRequested) {
            this.externalLinkNavigator.openDeeplink(((InAppBrowserEvent.DeepLinkRequested) event).getUrl());
            return;
        }
        if (event instanceof InAppBrowserEvent.PageLoadStarted) {
            AdnInAppBrowserListener adnInAppBrowserListener = this.listener;
            if (adnInAppBrowserListener != null) {
                adnInAppBrowserListener.onPageStarted(((InAppBrowserEvent.PageLoadStarted) event).getUrl());
                return;
            }
            return;
        }
        if (event instanceof InAppBrowserEvent.PageLoadFinished) {
            AdnInAppBrowserListener adnInAppBrowserListener2 = this.listener;
            if (adnInAppBrowserListener2 != null) {
                adnInAppBrowserListener2.onPageFinished(((InAppBrowserEvent.PageLoadFinished) event).getUrl());
            }
            this.browserTracker.onPageFinished(((InAppBrowserEvent.PageLoadFinished) event).getUrl());
            return;
        }
        if (event instanceof InAppBrowserEvent.LoadError) {
            AdnInAppBrowserListener adnInAppBrowserListener3 = this.listener;
            if (adnInAppBrowserListener3 != null) {
                InAppBrowserEvent.LoadError loadError = (InAppBrowserEvent.LoadError) event;
                adnInAppBrowserListener3.onPageError(loadError.getUrl(), loadError.getError());
            }
            this.browserTracker.onPageLoadError(((InAppBrowserEvent.LoadError) event).getUrl());
            return;
        }
        if (event instanceof InAppBrowserEvent.LoadInitiated) {
            this.browserTracker.onBrowserStart(((InAppBrowserEvent.LoadInitiated) event).getUrl());
        } else {
            if (!(event instanceof InAppBrowserEvent.PageHistoryUpdated)) {
                throw new NoWhenBranchMatchedException();
            }
            this.browserTracker.onPageHistoryUpdated(((InAppBrowserEvent.PageHistoryUpdated) event).getUrl());
        }
    }
}

package io.adn.sdk.publisher.inappbrowser;

import kotlin.Metadata;

/* compiled from: AdnInAppBrowserLauncher.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "", "open", "", "inAppBrowser", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowser;", "isInternalDeeplink", "", "url", "", "openInternalDeeplink", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnInAppBrowserLauncher {
    boolean isInternalDeeplink(String url);

    void open(AdnInAppBrowser inAppBrowser);

    void openInternalDeeplink(String url);
}

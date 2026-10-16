package io.adn.sdk.internal.ui.common.inappbrowser;

import android.content.Context;
import io.adn.sdk.internal.data.service.ExternalLinkNavigator;
import io.adn.sdk.internal.domain.repository.AdTracker;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowser;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserRegistry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppBrowserFactory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserFactory;", "", "<init>", "()V", "create", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowser;", "context", "Landroid/content/Context;", "sessionIndex", "", "url", "", "trackingUrls", "", "tracker", "Lio/adn/sdk/internal/domain/repository/AdTracker;", "externalLinkNavigator", "Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class InAppBrowserFactory {
    public static final int $stable = 0;

    public final AdnInAppBrowser create(Context context, int sessionIndex, String url, List<String> trackingUrls, AdTracker tracker, ExternalLinkNavigator externalLinkNavigator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(trackingUrls, "trackingUrls");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Intrinsics.checkNotNullParameter(externalLinkNavigator, "externalLinkNavigator");
        InAppBrowserImpl inAppBrowserImpl = new InAppBrowserImpl(url, new InAppBrowserWebView(context), new InAppBrowserTracker(sessionIndex, trackingUrls, tracker), externalLinkNavigator);
        AdnInAppBrowserRegistry.INSTANCE.save$adn_sdk_release(inAppBrowserImpl);
        return inAppBrowserImpl;
    }
}

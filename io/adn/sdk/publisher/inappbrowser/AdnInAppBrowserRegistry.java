package io.adn.sdk.publisher.inappbrowser;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnInAppBrowserRegistry.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0006J\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000fJ\r\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserRegistry;", "", "<init>", "()V", "browserMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowser;", "save", "", "browser", "save$adn_sdk_release", "get", "uuid", "remove", "remove$adn_sdk_release", "clear", "clear$adn_sdk_release", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnInAppBrowserRegistry {
    public static final AdnInAppBrowserRegistry INSTANCE = new AdnInAppBrowserRegistry();
    private static final ConcurrentHashMap<String, AdnInAppBrowser> browserMap = new ConcurrentHashMap<>();
    public static final int $stable = 8;

    private AdnInAppBrowserRegistry() {
    }

    public final void save$adn_sdk_release(AdnInAppBrowser browser) {
        Intrinsics.checkNotNullParameter(browser, "browser");
        browserMap.put(browser.getUuid(), browser);
    }

    public final AdnInAppBrowser get(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return browserMap.get(uuid);
    }

    public final void remove$adn_sdk_release(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        browserMap.remove(uuid);
    }

    public final void clear$adn_sdk_release() {
        Collection<AdnInAppBrowser> values = browserMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((AdnInAppBrowser) it.next()).release();
        }
        browserMap.clear();
    }
}

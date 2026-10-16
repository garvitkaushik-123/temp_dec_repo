package io.adn.sdk.internal.data.service;

import android.net.Uri;
import kotlin.Metadata;

/* compiled from: ExternalLinkNavigator.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lio/adn/sdk/internal/data/service/ExternalLinkNavigator;", "", "open", "", "url", "", "uri", "Landroid/net/Uri;", "openDeeplink", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface ExternalLinkNavigator {
    boolean open(Uri uri);

    boolean open(String url);

    boolean openDeeplink(String url);
}

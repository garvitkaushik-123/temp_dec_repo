package com.fyber.marketplace.fairbid.bridge;

import android.app.Activity;
import com.fyber.marketplace.fairbid.bridge.MarketplaceFullscreenDisplayEventsListener;

/* loaded from: classes4.dex */
public interface MarketplaceFullscreenAd<T extends MarketplaceFullscreenDisplayEventsListener> extends MarketplaceBridgeAd {
    boolean isAvailable();

    void show(Activity activity, T t);
}

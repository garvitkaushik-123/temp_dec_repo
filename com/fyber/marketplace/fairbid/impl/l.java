package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.marketplace.fairbid.bridge.MarketplaceOnUserAgentAvailableListener;

/* loaded from: classes4.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarketplaceOnUserAgentAvailableListener f1841a;

    public l(MarketplaceOnUserAgentAvailableListener marketplaceOnUserAgentAvailableListener) {
        this.f1841a = marketplaceOnUserAgentAvailableListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAConfigManager iAConfigManager;
        int i = 0;
        while (true) {
            iAConfigManager = IAConfigManager.O;
            if (!iAConfigManager.y.f1776a.get() || iAConfigManager.y.d.compareAndSet(true, true) || i >= 100) {
                break;
            }
            IAlog.a("UserAgentProvider | waiting on user agent", new Object[0]);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            i++;
        }
        String a2 = iAConfigManager.y.a();
        if (a2.isEmpty()) {
            return;
        }
        IAlog.a("UserAgentAvailable", new Object[0]);
        this.f1841a.onUserAgentAvailable(a2);
    }
}

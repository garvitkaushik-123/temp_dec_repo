package com.fyber.marketplace.fairbid.impl;

import android.app.Application;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;

/* loaded from: classes4.dex */
public final class m implements IAConfigManager.OnConfigurationReadyAndValidListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarketplaceBridgeAd f1842a;
    public final /* synthetic */ MarketplaceAdLoadListener b;
    public final /* synthetic */ n c;

    public m(n nVar, MarketplaceBridgeAd marketplaceBridgeAd, MarketplaceAdLoadListener marketplaceAdLoadListener) {
        this.c = nVar;
        this.f1842a = marketplaceBridgeAd;
        this.b = marketplaceAdLoadListener;
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (!IAConfigManager.e()) {
            MarketplaceAdLoadListener marketplaceAdLoadListener = this.b;
            if (marketplaceAdLoadListener != null) {
                marketplaceAdLoadListener.onAdLoadFailed(MarketplaceAdLoadError.FMP_NOT_READY_TO_LOAD_ADS);
                return;
            }
            return;
        }
        this.c.getClass();
        IAlog.a("maybeInitOmidSdk", new Object[0]);
        IAConfigManager iAConfigManager2 = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager2.K;
        if (eVar == null || !eVar.f1268a) {
            Application application = com.fyber.inneractive.sdk.util.o.f1770a;
            IAlog.c("initOmidSdk", new Object[0]);
            r.f1777a.execute(new a0(iAConfigManager2, application));
        }
        this.f1842a.load();
    }
}

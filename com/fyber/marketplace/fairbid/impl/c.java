package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.response.e f1836a;
    public final /* synthetic */ com.fyber.inneractive.sdk.interfaces.c b;
    public final /* synthetic */ InneractiveUnitController c;
    public final /* synthetic */ MarketplaceAdLoadListener d;
    public final /* synthetic */ e e;

    public c(e eVar, InneractiveUnitController inneractiveUnitController, MarketplaceAdLoadListener marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.e eVar2, com.fyber.inneractive.sdk.interfaces.c cVar) {
        this.e = eVar;
        this.f1836a = eVar2;
        this.b = cVar;
        this.c = inneractiveUnitController;
        this.d = marketplaceAdLoadListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        e eVar = this.e;
        r featureProvider = eVar.mMarketplaceAuctionParameters.getFeatureProvider(eVar.mPlacementId);
        if (featureProvider == null) {
            featureProvider = r.a();
        }
        r rVar = featureProvider;
        com.fyber.inneractive.sdk.response.e eVar2 = this.f1836a;
        com.fyber.inneractive.sdk.config.global.e eVar3 = new com.fyber.inneractive.sdk.config.global.e();
        ImpressionData impressionData = eVar2.t;
        eVar3.f1088a = impressionData != null ? impressionData.getDemandId() : null;
        try {
            eVar3.b = Long.valueOf(IAConfigManager.O.d);
        } catch (NumberFormatException unused) {
            IAlog.a("invalid publisherId", new Object[0]);
        }
        rVar.a(eVar3);
        com.fyber.inneractive.sdk.interfaces.c cVar = this.b;
        com.fyber.inneractive.sdk.response.e eVar4 = this.f1836a;
        z = this.e.mMuted;
        b bVar = new b(this);
        com.fyber.inneractive.sdk.flow.k kVar = (com.fyber.inneractive.sdk.flow.k) cVar;
        kVar.h = z;
        kVar.a(null, eVar4, rVar, bVar, null);
    }
}

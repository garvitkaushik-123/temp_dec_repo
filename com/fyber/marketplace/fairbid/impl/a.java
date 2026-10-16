package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarketplaceAdLoadListener f1834a;
    public final /* synthetic */ com.fyber.inneractive.sdk.response.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ InneractiveUnitController e;
    public final /* synthetic */ e f;

    public a(e eVar, MarketplaceAdLoadListener marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar, String str, Map map, InneractiveUnitController inneractiveUnitController) {
        this.f = eVar;
        this.f1834a = marketplaceAdLoadListener;
        this.b = aVar;
        this.c = str;
        this.d = map;
        this.e = inneractiveUnitController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.access$000(this.f, this.e, this.f1834a, this.f.parseResponseData(this.f1834a, this.b, this.c, this.d), this.f.getAdContentLoader(this.f1834a, this.b));
    }
}

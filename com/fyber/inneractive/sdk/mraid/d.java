package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* loaded from: classes4.dex */
public final class d implements com.fyber.inneractive.sdk.factories.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAMraidKit f1302a;

    public d(IAMraidKit iAMraidKit) {
        this.f1302a = iAMraidKit;
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        boolean isMRaidSpotContent;
        isMRaidSpotContent = this.f1302a.isMRaidSpotContent(inneractiveAdSpot);
        return isMRaidSpotContent;
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final com.fyber.inneractive.sdk.interfaces.d a() {
        return new com.fyber.inneractive.sdk.renderers.k();
    }
}

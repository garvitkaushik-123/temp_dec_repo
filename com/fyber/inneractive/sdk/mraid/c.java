package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* loaded from: classes4.dex */
public final class c implements com.fyber.inneractive.sdk.factories.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAMraidKit f1300a;

    public c(IAMraidKit iAMraidKit) {
        this.f1300a = iAMraidKit;
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        boolean isMRaidSpotContent;
        isMRaidSpotContent = this.f1300a.isMRaidSpotContent(inneractiveAdSpot);
        return isMRaidSpotContent;
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final com.fyber.inneractive.sdk.interfaces.f b(InneractiveAdSpot inneractiveAdSpot) {
        return new com.fyber.inneractive.sdk.renderers.s();
    }
}

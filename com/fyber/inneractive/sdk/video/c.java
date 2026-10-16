package com.fyber.inneractive.sdk.video;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.factories.g;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.interfaces.f;
import com.fyber.inneractive.sdk.renderers.p;
import com.fyber.inneractive.sdk.renderers.u;

/* loaded from: classes4.dex */
public final class c implements g {
    @Override // com.fyber.inneractive.sdk.factories.g
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof r0);
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final f b(InneractiveAdSpot inneractiveAdSpot) {
        InneractiveAdRequest inneractiveAdRequest = inneractiveAdSpot.getAdContent().f1249a;
        return (inneractiveAdSpot.getAdContent().d() && (inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen())) ? new u() : new p();
    }
}

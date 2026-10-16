package com.fyber.inneractive.sdk.video;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.renderers.o;

/* loaded from: classes4.dex */
public final class d implements com.fyber.inneractive.sdk.factories.a {
    @Override // com.fyber.inneractive.sdk.factories.a
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof r0);
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final com.fyber.inneractive.sdk.interfaces.d a() {
        return new o();
    }
}

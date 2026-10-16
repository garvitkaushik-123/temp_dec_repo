package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.s0;
import com.fyber.inneractive.sdk.renderers.u;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class InneractiveAdViewVideoContentController extends s0 {
    @Override // com.fyber.inneractive.sdk.flow.h0
    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() instanceof r0;
    }

    public void pauseVideo() {
    }

    public void playVideo() {
    }

    public void setControlledRenderer(u uVar) {
        new WeakReference(uVar);
    }
}

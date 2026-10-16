package com.instagram.common.viewpoint.core;

import android.R;

/* loaded from: assets/audience_network/classes2.dex */
public class PQ extends AbstractRunnableC1416Wc {
    public final /* synthetic */ AnimationAnimationListenerC1483Yu A00;

    public PQ(AnimationAnimationListenerC1483Yu animationAnimationListenerC1483Yu) {
        this.A00 = animationAnimationListenerC1483Yu;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        this.A00.A00.finish(3);
        this.A00.A00.A05().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}

package com.instagram.common.viewpoint.core;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* loaded from: assets/audience_network/classes2.dex */
public class GX extends AbstractRunnableC1416Wc {
    public final /* synthetic */ InterfaceC1751dp A00;
    public final /* synthetic */ C1752dq A01;

    public GX(C1752dq c1752dq, InterfaceC1751dp interfaceC1751dp) {
        this.A01 = c1752dq;
        this.A00 = interfaceC1751dp;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new GY(this));
        this.A01.startAnimation(alphaAnimation);
    }
}

package com.instagram.common.viewpoint.core;

import android.view.animation.Animation;

/* renamed from: com.facebook.ads.redexgen.X.Ym, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class AnimationAnimationListenerC1475Ym implements Animation.AnimationListener {
    public final /* synthetic */ ViewOnClickListenerC07906x A00;

    public AnimationAnimationListenerC1475Ym(ViewOnClickListenerC07906x viewOnClickListenerC07906x) {
        this.A00 = viewOnClickListenerC07906x;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        ((PZ) this.A00).A08.finish(16);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}

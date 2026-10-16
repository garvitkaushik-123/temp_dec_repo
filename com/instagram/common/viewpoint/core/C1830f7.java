package com.instagram.common.viewpoint.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.f7, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1830f7 extends AnimatorListenerAdapter {
    public final /* synthetic */ C06933c A00;

    public C1830f7(C06933c c06933c) {
        this.A00 = c06933c;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Handler handler;
        handler = this.A00.A00.A04;
        handler.postDelayed(new C0938Di(this), 2000L);
    }
}

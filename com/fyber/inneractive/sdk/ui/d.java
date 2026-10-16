package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.R;

/* loaded from: classes4.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f1742a;
    public final /* synthetic */ FyberAdIdentifierLocal b;

    public d(FyberAdIdentifierLocal fyberAdIdentifierLocal, AnimatorSet animatorSet) {
        this.b = fyberAdIdentifierLocal;
        this.f1742a = animatorSet;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        FyberAdIdentifierLocal fyberAdIdentifierLocal = this.b;
        if (fyberAdIdentifierLocal.o) {
            fyberAdIdentifierLocal.m.setImageResource(R.drawable.ia_fyber_info_button);
            FyberAdIdentifierLocal fyberAdIdentifierLocal2 = this.b;
            FyberAdIdentifierLocal.a(fyberAdIdentifierLocal2.m, fyberAdIdentifierLocal2.g);
        } else {
            Bitmap bitmap = fyberAdIdentifierLocal.r;
            if (bitmap != null) {
                fyberAdIdentifierLocal.m.setImageBitmap(bitmap);
            } else {
                fyberAdIdentifierLocal.m.setImageResource(R.drawable.ia_digital_turbine_logo);
            }
            FyberAdIdentifierLocal.a(this.b.m, null);
        }
        this.f1742a.start();
        this.b.p = this.f1742a;
    }
}

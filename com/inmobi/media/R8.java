package com.inmobi.media;

import android.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R8 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2417a;

    public R8(T8 view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f2417a = new WeakReference(view);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        T8 t8 = (T8) this.f2417a.get();
        if (t8 == null) {
            return;
        }
        int visibility = t8.getVisibility();
        if (visibility == 4 || visibility == 8) {
            Intrinsics.checkNotNull(animation.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Float");
            if (((Float) r6).floatValue() >= 1.0d) {
                t8.a();
                return;
            }
            return;
        }
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        t8.l = 360 * ((Float) animatedValue).floatValue();
        t8.invalidate();
    }
}

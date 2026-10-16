package com.inmobi.media;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.b1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2572b1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2523a = "b1";
    public final ArrayList b = new ArrayList();
    public boolean c;

    public static C2554a1 a(ValueAnimator valueAnimator, C2613d8 c2613d8) {
        valueAnimator.setDuration(0L);
        valueAnimator.setStartDelay(0L);
        P8 p8 = c2613d8.d.k;
        if (p8 != null) {
            O8 o8 = p8.f2397a;
            O8 o82 = p8.b;
            if (o82 != null) {
                valueAnimator.setDuration(o82.a() * 1000);
            }
            if (o8 != null) {
                valueAnimator.setStartDelay(o8.a() * 1000);
            }
        }
        return new C2554a1(valueAnimator);
    }

    public static ValueAnimator b(final View view, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final C2697i8 c2697i8 = layoutParams instanceof C2697i8 ? (C2697i8) layoutParams : null;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.inmobi.media.b1$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2572b1.b(C2697i8.this, view, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public static final void b(C2697i8 c2697i8, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        if (c2697i8 != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            c2697i8.b = (int) ((Float) animatedValue).floatValue();
        }
        view.setLayoutParams(c2697i8);
        view.requestLayout();
    }

    public static ValueAnimator a(final View view, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final C2697i8 c2697i8 = layoutParams instanceof C2697i8 ? (C2697i8) layoutParams : null;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.inmobi.media.b1$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C2572b1.a(C2697i8.this, view, valueAnimator);
            }
        });
        Intrinsics.checkNotNull(ofFloat);
        return ofFloat;
    }

    public static final void a(C2697i8 c2697i8, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        if (c2697i8 != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            c2697i8.f2598a = (int) ((Float) animatedValue).floatValue();
        }
        view.setLayoutParams(c2697i8);
        view.requestLayout();
    }

    public final void a(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C2554a1 c2554a1 = (C2554a1) it.next();
            if (!c2554a1.c) {
                ValueAnimator valueAnimator = c2554a1.f2512a;
                Intrinsics.checkNotNull(valueAnimator, "null cannot be cast to non-null type android.animation.ValueAnimator");
                valueAnimator.setCurrentPlayTime(c2554a1.b);
                valueAnimator.start();
            }
            if (!this.b.contains(c2554a1)) {
                this.b.add(c2554a1);
            }
        }
    }

    public final void a() {
        if (this.c) {
            this.c = false;
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                C2554a1 c2554a1 = (C2554a1) it.next();
                ValueAnimator valueAnimator = c2554a1.f2512a;
                Intrinsics.checkNotNull(valueAnimator, "null cannot be cast to non-null type android.animation.ValueAnimator");
                c2554a1.b = valueAnimator.getCurrentPlayTime();
                if (valueAnimator.getAnimatedFraction() == 1.0d) {
                    c2554a1.c = true;
                }
                valueAnimator.cancel();
            }
        }
    }
}

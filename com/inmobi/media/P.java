package com.inmobi.media;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RelativeLayout;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes4.dex */
public abstract class P {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f2389a;
    public EnumC2813pa b;
    public float c;
    public boolean d;

    public P(RelativeLayout adBackgroundView) {
        Intrinsics.checkNotNullParameter(adBackgroundView, "adBackgroundView");
        this.f2389a = adBackgroundView;
        this.b = AbstractC2829qa.a(U3.g());
        this.c = 1.0f;
    }

    public abstract void a();

    public void a(EnumC2813pa orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.b = orientation;
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public final void e() {
        T3 t3;
        T3 t32;
        RelativeLayout.LayoutParams layoutParams;
        if (this.c == 1.0f) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(10);
            this.f2389a.setLayoutParams(layoutParams2);
            return;
        }
        if (this.d) {
            V3 v3 = U3.f2447a;
            Context context = this.f2389a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Intrinsics.checkNotNullParameter(context, "context");
            Display a2 = U3.a(context);
            if (a2 == null) {
                t32 = U3.b;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                a2.getRealMetrics(displayMetrics);
                t3 = new T3(displayMetrics.widthPixels, displayMetrics.heightPixels);
                t32 = t3;
            }
        } else {
            V3 v32 = U3.f2447a;
            Context context2 = this.f2389a.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            Intrinsics.checkNotNullParameter(context2, "context");
            Display a3 = U3.a(context2);
            if (a3 == null) {
                t32 = U3.b;
            } else {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                a3.getMetrics(displayMetrics2);
                t3 = new T3(displayMetrics2.widthPixels, displayMetrics2.heightPixels);
                t32 = t3;
            }
        }
        Objects.toString(this.b);
        if (AbstractC2829qa.b(this.b)) {
            layoutParams = new RelativeLayout.LayoutParams(MathKt.roundToInt(t32.f2435a * this.c), -1);
            layoutParams.addRule(9);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, MathKt.roundToInt(t32.b * this.c));
            layoutParams3.addRule(10);
            layoutParams = layoutParams3;
        }
        this.f2389a.setLayoutParams(layoutParams);
    }

    public abstract void f();

    public abstract void g();
}

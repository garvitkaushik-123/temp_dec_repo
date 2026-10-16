package com.ironsource;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.X2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class X2 extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Yf f3120a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X2(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3120a = new a();
    }

    public final Yf getViewBinder() {
        return this.f3120a;
    }

    public static final class a implements Yf {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(V0 adTools, long j) {
            Intrinsics.checkNotNullParameter(adTools, "$adTools");
            adTools.e().h().a(true, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final V0 adTools, final long j) {
            Intrinsics.checkNotNullParameter(adTools, "$adTools");
            adTools.d(new Runnable() { // from class: com.ironsource.X2$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    X2.a.d(V0.this, j);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(V0 adTools, long j) {
            Intrinsics.checkNotNullParameter(adTools, "$adTools");
            adTools.e().h().a(j);
        }

        @Override // com.ironsource.Yf
        public void a(View view, FrameLayout.LayoutParams layoutParams, final V0 adTools) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
            Intrinsics.checkNotNullParameter(adTools, "adTools");
            final View childAt = X2.this.getChildAt(0);
            final long b = C3334ub.s.d().g().b();
            if (b <= 0) {
                X2.this.removeView(childAt);
                X2.this.addView(view, layoutParams);
                adTools.d(new Runnable() { // from class: com.ironsource.X2$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        X2.a.a(V0.this, b);
                    }
                });
                return;
            }
            adTools.d(new Runnable() { // from class: com.ironsource.X2$a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    X2.a.b(V0.this, b);
                }
            });
            view.setAlpha(0.0f);
            X2.this.addView(view, layoutParams);
            if (childAt != null) {
                final X2 x2 = X2.this;
                childAt.animate().alpha(0.0f).setDuration(b).withStartAction(new Runnable() { // from class: com.ironsource.X2$a$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        X2.a.a(childAt);
                    }
                }).withEndAction(new Runnable() { // from class: com.ironsource.X2$a$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        X2.a.a(X2.this, childAt, childAt);
                    }
                }).start();
            }
            view.animate().alpha(1.0f).setDuration(b).withEndAction(new Runnable() { // from class: com.ironsource.X2$a$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    X2.a.c(V0.this, b);
                }
            }).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(V0 adTools, long j) {
            Intrinsics.checkNotNullParameter(adTools, "$adTools");
            adTools.e().h().a(false, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View this_apply) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this_apply.setEnabled(false);
            this_apply.setClickable(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(X2 this$0, View view, View this_apply) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this$0.removeView(view);
            this_apply.setEnabled(true);
            this_apply.setClickable(true);
        }
    }
}

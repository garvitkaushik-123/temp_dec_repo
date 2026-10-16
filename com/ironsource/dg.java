package com.ironsource;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class dg {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3420zc f3259a;
    private View b;
    private boolean c;
    private final ViewTreeObserver.OnGlobalLayoutListener d;
    private final ViewTreeObserver.OnWindowFocusChangeListener e;
    private final Rect f;

    public dg(InterfaceC3420zc onVisibilityChangeListener) {
        Intrinsics.checkNotNullParameter(onVisibilityChangeListener, "onVisibilityChangeListener");
        this.f3259a = onVisibilityChangeListener;
        this.d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.ironsource.dg$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                dg.a(dg.this);
            }
        };
        this.e = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.ironsource.dg$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                dg.a(dg.this, z);
            }
        };
        this.f = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dg this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        View view = this.b;
        if (view != null && (viewTreeObserver2 = view.getViewTreeObserver()) != null) {
            viewTreeObserver2.removeOnGlobalLayoutListener(this.d);
        }
        View view2 = this.b;
        if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnWindowFocusChangeListener(this.e);
        }
        this.b = null;
    }

    public final boolean c() {
        View view = this.b;
        if (view != null) {
            return eg.a(view, this.f);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(dg this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = view;
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
        view.getViewTreeObserver().addOnWindowFocusChangeListener(this.e);
    }

    private final void a() {
        boolean c = c();
        if (this.c != c) {
            this.c = c;
            this.f3259a.a(c);
        }
    }
}

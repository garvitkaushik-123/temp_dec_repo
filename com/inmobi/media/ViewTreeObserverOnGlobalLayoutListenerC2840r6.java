package com.inmobi.media;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.r6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC2840r6 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f2692a;
    public final InterfaceC2971z5 b;
    public int c;
    public int d;

    public ViewTreeObserverOnGlobalLayoutListenerC2840r6(FrameLayout view, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f2692a = view;
        this.b = interfaceC2971z5;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        try {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                String str = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).a(str, "close called");
            }
            this.c = B2.b(this.f2692a.getWidth() / U3.b());
            this.d = B2.b(this.f2692a.getHeight() / U3.b());
            this.f2692a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Boolean bool = Boolean.FALSE;
            synchronized (bool) {
                bool.notify();
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.b;
            if (interfaceC2971z52 != null) {
                String str2 = AbstractC2921w6.f2741a;
                ((A5) interfaceC2971z52).b(str2, rf.a(e, H6.a(str2, "access$getTAG$p(...)", "SDK encountered unexpected error in JavaScriptBridge$1.onGlobalLayout(); ")));
            }
        }
    }
}

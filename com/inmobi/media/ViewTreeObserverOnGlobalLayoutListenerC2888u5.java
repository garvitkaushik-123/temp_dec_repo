package com.inmobi.media;

import android.view.ViewTreeObserver;
import com.inmobi.ads.InMobiBanner;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.u5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC2888u5 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiBanner f2720a;

    public ViewTreeObserverOnGlobalLayoutListenerC2888u5(InMobiBanner inMobiBanner) {
        this.f2720a = inMobiBanner;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        InterfaceC2971z5 p;
        boolean b;
        try {
            this.f2720a.i = B2.b(r0.getMeasuredWidth() / U3.b());
            this.f2720a.j = B2.b(r0.getMeasuredHeight() / U3.b());
            b = this.f2720a.b();
            if (b) {
                this.f2720a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        } catch (Exception e) {
            R1 mAdManager = this.f2720a.getMAdManager();
            if (mAdManager == null || (p = mAdManager.p()) == null) {
                return;
            }
            String access$getTAG$cp = InMobiBanner.access$getTAG$cp();
            Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
            ((A5) p).a(access$getTAG$cp, "InMobiBanner$1.onGlobalLayout() handler threw unexpected error: ", e);
        }
    }
}

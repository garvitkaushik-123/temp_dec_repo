package com.inmobi.media;

import android.os.Bundle;
import androidx.browser.customtabs.EngagementSignalsCallback;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.j2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2708j2 implements EngagementSignalsCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2724k2 f2607a;

    public C2708j2(C2724k2 c2724k2) {
        this.f2607a = c2724k2;
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public final void onGreatestScrollPercentageIncreased(int i, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public final void onSessionEnded(boolean z, Bundle extras) {
        InterfaceC2624e2 interfaceC2624e2;
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (z && (interfaceC2624e2 = (InterfaceC2624e2) this.f2607a.i.get()) != null) {
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            interfaceC2624e2.a(Gb.a("IN_NATIVE_BROWSER", "onInteraction"));
        }
        InterfaceC2624e2 interfaceC2624e22 = (InterfaceC2624e2) this.f2607a.i.get();
        if (interfaceC2624e22 != null) {
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            interfaceC2624e22.a(Gb.a("IN_NATIVE_BROWSER", "onClose"));
        }
    }

    @Override // androidx.browser.customtabs.EngagementSignalsCallback
    public final void onVerticalScrollEvent(boolean z, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        C2724k2 c2724k2 = this.f2607a;
        if (c2724k2.h) {
            return;
        }
        c2724k2.h = true;
        InterfaceC2624e2 interfaceC2624e2 = (InterfaceC2624e2) c2724k2.i.get();
        if (interfaceC2624e2 != null) {
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            interfaceC2624e2.a(Gb.a("IN_NATIVE_BROWSER", "onScroll"));
        }
    }
}

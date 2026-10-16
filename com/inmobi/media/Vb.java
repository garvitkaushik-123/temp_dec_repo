package com.inmobi.media;

import androidx.webkit.Profile;
import com.ironsource.C3355vf;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Vb implements InterfaceC2914w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2463a;

    public Vb(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        this.f2463a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2463a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "onAdScreenDisplayFailed");
        }
        this.f2463a.getListener().c();
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void b(Object obj) {
        InterfaceC2971z5 interfaceC2971z5 = this.f2463a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, C3355vf.m);
        }
        if (Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, this.f2463a.getViewState())) {
            this.f2463a.setAndUpdateViewState("Hidden");
        }
        this.f2463a.z();
    }

    @Override // com.inmobi.media.InterfaceC2914w
    public final void a(Object obj) {
        InterfaceC2971z5 interfaceC2971z5 = this.f2463a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "onAdScreenDisplayed");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2463a;
        if (gestureDetectorOnGestureListenerC2634ec.b == 0) {
            gestureDetectorOnGestureListenerC2634ec.M = false;
        }
        gestureDetectorOnGestureListenerC2634ec.getListener().e(this.f2463a);
    }
}

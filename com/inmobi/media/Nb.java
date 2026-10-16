package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Nb extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2374a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Nb(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        super(1);
        this.f2374a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2374a;
        InterfaceC2971z5 interfaceC2971z5 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z5 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onRenderProcessGone");
        }
        gestureDetectorOnGestureListenerC2634ec.getListener().a(gestureDetectorOnGestureListenerC2634ec, booleanValue);
        return Unit.INSTANCE;
    }
}

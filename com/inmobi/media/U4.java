package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class U4 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnumC2813pa f2448a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U4(EnumC2813pa enumC2813pa) {
        super(1);
        this.f2448a = enumC2813pa;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        GestureDetectorOnGestureListenerC2634ec it = (GestureDetectorOnGestureListenerC2634ec) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        EnumC2813pa orientation = this.f2448a;
        it.getClass();
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        InterfaceC2971z5 interfaceC2971z5 = it.i;
        if (interfaceC2971z5 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "handle orientationChange " + it + ' ' + orientation);
        }
        int a2 = AbstractC2829qa.a(orientation);
        InterfaceC2971z5 interfaceC2971z52 = it.i;
        if (interfaceC2971z52 != null) {
            String TAG2 = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "fireOrientationChange " + it + ' ' + a2);
        }
        it.c("window.imraid.broadcastEvent('orientationChange','" + a2 + "');");
        return Unit.INSTANCE;
    }
}

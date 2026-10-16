package com.inmobi.media;

import android.view.ViewParent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.e4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2626e4 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2677h4 f2556a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2626e4(C2677h4 c2677h4) {
        super(0);
        this.f2556a = c2677h4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC2575b4 interfaceC2575b4;
        ViewParent parent = this.f2556a.getParent();
        Y3 y3 = parent instanceof Y3 ? (Y3) parent : null;
        if (y3 != null && (interfaceC2575b4 = y3.d) != null) {
            InterfaceC2930x interfaceC2930x = ((C2694i5) interfaceC2575b4).f2596a.b;
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) interfaceC2930x : null;
            if (gestureDetectorOnGestureListenerC2634ec != null) {
                gestureDetectorOnGestureListenerC2634ec.p();
            }
        }
        return Unit.INSTANCE;
    }
}

package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class X3 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y3 f2478a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X3(Y3 y3) {
        super(1);
        this.f2478a = y3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        JSONObject jsonObject = (JSONObject) obj;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        InterfaceC2575b4 interfaceC2575b4 = this.f2478a.d;
        if (interfaceC2575b4 != null) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            InterfaceC2930x interfaceC2930x = ((C2694i5) interfaceC2575b4).f2596a.b;
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) interfaceC2930x : null;
            if (gestureDetectorOnGestureListenerC2634ec != null) {
                gestureDetectorOnGestureListenerC2634ec.a(jsonObject);
            }
        }
        return Unit.INSTANCE;
    }
}

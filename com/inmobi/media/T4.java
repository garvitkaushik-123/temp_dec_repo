package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class T4 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final T4 f2436a = new T4();

    public T4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        GestureDetectorOnGestureListenerC2634ec it = (GestureDetectorOnGestureListenerC2634ec) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        InterfaceC2971z5 interfaceC2971z5 = it.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z5).a(str, Ob.a(it, str, "TAG", "fireBackButtonPressedEvent "));
        }
        String str2 = it.I;
        if (str2 != null) {
            it.a(str2, "broadcastEvent('backButtonPressed')");
        }
        return Unit.INSTANCE;
    }
}

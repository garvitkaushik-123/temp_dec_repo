package com.inmobi.media;

import android.view.ViewParent;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.g4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2661g4 extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2677h4 f2576a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2661g4(C2677h4 c2677h4) {
        super(2);
        this.f2576a = c2677h4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String trackerName = (String) obj;
        Map macros = (Map) obj2;
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        ViewParent parent = this.f2576a.getParent();
        Y3 y3 = parent instanceof Y3 ? (Y3) parent : null;
        if (y3 != null) {
            Intrinsics.checkNotNullParameter(trackerName, "trackerName");
            Intrinsics.checkNotNullParameter(macros, "macros");
            InterfaceC2575b4 interfaceC2575b4 = y3.d;
            if (interfaceC2575b4 != null) {
                Intrinsics.checkNotNullParameter(trackerName, "trackerName");
                Intrinsics.checkNotNullParameter(macros, "macros");
                InterfaceC2930x interfaceC2930x = ((C2694i5) interfaceC2575b4).f2596a.b;
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) interfaceC2930x : null;
                if (gestureDetectorOnGestureListenerC2634ec != null) {
                    gestureDetectorOnGestureListenerC2634ec.a(trackerName, macros);
                }
            }
        }
        return Unit.INSTANCE;
    }
}

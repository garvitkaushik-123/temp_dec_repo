package com.inmobi.media;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class L6 extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M6 f2350a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L6(M6 m6) {
        super(2);
        this.f2350a = m6;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String trackerName = (String) obj;
        Map macros = (Map) obj2;
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        Ub ub = this.f2350a.d;
        if (ub != null) {
            Intrinsics.checkNotNullParameter(trackerName, "trackerName");
            Intrinsics.checkNotNullParameter(macros, "macros");
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = ub.f2452a;
            if (!gestureDetectorOnGestureListenerC2634ec.e) {
                gestureDetectorOnGestureListenerC2634ec.a(trackerName, macros);
            }
        }
        return Unit.INSTANCE;
    }
}

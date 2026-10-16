package com.inmobi.media;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.u2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2885u2 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2885u2 f2717a = new C2885u2();

    public C2885u2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AtomicBoolean atomicBoolean;
        C2607d2 event = (C2607d2) obj;
        Intrinsics.checkNotNullParameter(event, "event");
        int i = event.f2542a;
        if (i == 1 || i == 2) {
            Intrinsics.checkNotNullExpressionValue(C2933x2.f(), "access$getTAG$p(...)");
            atomicBoolean = C2933x2.h;
            atomicBoolean.set(false);
        } else if (i != 10) {
            if (i != 11) {
                Intrinsics.checkNotNullExpressionValue(C2933x2.f(), "access$getTAG$p(...)");
            } else if (!Boolean.parseBoolean(event.b)) {
                C2933x2.f2748a.h();
            }
        } else if (Intrinsics.areEqual("available", event.b)) {
            C2933x2.f2748a.h();
        }
        return Unit.INSTANCE;
    }
}

package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.r1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2835r1 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2835r1 f2689a = new C2835r1();

    public C2835r1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2607d2 event = (C2607d2) obj;
        Intrinsics.checkNotNullParameter(event, "event");
        int i = event.f2542a;
        if (i == 1 || i == 2) {
            C2868t1 c2868t1 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
            C2868t1.m.set(false);
        } else if (i != 10) {
            C2868t1 c2868t12 = C2868t1.f2707a;
            Intrinsics.checkNotNullExpressionValue("t1", "access$getTAG$p(...)");
        } else if (Intrinsics.areEqual("available", event.b)) {
            C2868t1 c2868t13 = C2868t1.f2707a;
            if (!C2868t1.j.get()) {
                c2868t13.c();
            }
        } else {
            C2868t1 c2868t14 = C2868t1.f2707a;
            C2868t1.d();
        }
        return Unit.INSTANCE;
    }
}

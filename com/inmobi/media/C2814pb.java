package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.pb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2814pb extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2894ub f2671a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2814pb(C2894ub c2894ub) {
        super(1);
        this.f2671a = c2894ub;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2633eb data = (C2633eb) obj;
        Intrinsics.checkNotNullParameter(data, "data");
        int incrementAndGet = this.f2671a.c.incrementAndGet();
        C2894ub c2894ub = this.f2671a;
        if (incrementAndGet == c2894ub.e) {
            if (data.f2563a == 0 && data.b == 0) {
                c2894ub.a(new C2668gb((short) 2234), (C2633eb) null);
            } else {
                StringsKt.trimMargin$default("No of In-App Purchases: " + data.f2563a + "\n                                    | and No of Subscriptions: " + data.b, null, 1, null);
                this.f2671a.a(C2684hb.f2588a, data);
            }
        }
        return Unit.INSTANCE;
    }
}

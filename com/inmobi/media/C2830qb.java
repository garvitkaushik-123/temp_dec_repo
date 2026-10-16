package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.qb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2830qb extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2894ub f2684a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2830qb(C2894ub c2894ub) {
        super(1);
        this.f2684a = c2894ub;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AbstractC2781nb result = (AbstractC2781nb) obj;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result instanceof C2749lb) {
            this.f2684a.a(new C2651fb(String.valueOf(((C2749lb) result).f2633a)), (C2633eb) null);
        } else {
            C2894ub c2894ub = this.f2684a;
            c2894ub.a(new C2814pb(c2894ub));
        }
        return Unit.INSTANCE;
    }
}

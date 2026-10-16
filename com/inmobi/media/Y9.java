package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Y9 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Z9 f2495a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y9(Z9 z9) {
        super(1);
        this.f2495a = z9;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        P9 it = (P9) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        InterfaceC2971z5 interfaceC2971z5 = this.f2495a.b;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("NovatiqDataHandler", "Novatiq hyper id synced");
        }
        return Unit.INSTANCE;
    }
}

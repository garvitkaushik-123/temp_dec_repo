package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class V9 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W9 f2462a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V9(W9 w9) {
        super(1);
        this.f2462a = w9;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Da result = (Da) obj;
        Intrinsics.checkNotNullParameter(result, "pingResult");
        W9 w9 = this.f2462a;
        w9.getClass();
        Intrinsics.checkNotNullParameter(result, "result");
        w9.b.a(result);
        return Unit.INSTANCE;
    }
}

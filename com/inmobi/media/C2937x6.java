package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.x6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2937x6 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2588c0 f2751a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2937x6(C2588c0 c2588c0) {
        super(1);
        this.f2751a = c2588c0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        P9 it = (P9) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f2751a.invoke(it.d);
        return Unit.INSTANCE;
    }
}

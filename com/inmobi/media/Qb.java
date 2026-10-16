package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Qb extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Qb f2409a = new Qb();

    public Qb() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2750lc it = (C2750lc) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        it.b();
        return Unit.INSTANCE;
    }
}

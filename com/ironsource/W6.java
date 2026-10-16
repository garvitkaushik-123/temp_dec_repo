package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class W6 implements X6 {

    /* renamed from: a, reason: collision with root package name */
    private final long f3107a;
    private final EnumC2989a7 b;

    public W6(long j, EnumC2989a7 recoveryStrategy) {
        Intrinsics.checkNotNullParameter(recoveryStrategy, "recoveryStrategy");
        this.f3107a = j;
        this.b = recoveryStrategy;
    }

    @Override // com.ironsource.X6
    public long a() {
        return this.f3107a;
    }

    @Override // com.ironsource.X6
    public EnumC2989a7 b() {
        return this.b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public W6(Z6 feature) {
        this(feature.a(), feature.c());
        Intrinsics.checkNotNullParameter(feature, "feature");
    }
}

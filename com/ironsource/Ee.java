package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class Ee {

    /* renamed from: a, reason: collision with root package name */
    private final N f2848a;

    public Ee(N n) {
        this.f2848a = n;
    }

    public final N a() {
        return this.f2848a;
    }

    public abstract Le b();

    public final C3322u a(InterfaceC3317tb<Ee, C3322u> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }
}

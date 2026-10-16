package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Qe {

    /* renamed from: a, reason: collision with root package name */
    private final String f3018a;
    private final String b;

    public Qe(String identifier, String baseConst) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(baseConst, "baseConst");
        this.f3018a = identifier;
        this.b = baseConst;
    }

    public final String a() {
        return this.f3018a + "_" + this.b;
    }
}

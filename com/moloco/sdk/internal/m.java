package com.moloco.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class m {
    public static final int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5434a;
    public final int b;

    public m(String description, int i) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.f5434a = description;
        this.b = i;
    }

    public final String a() {
        return this.f5434a;
    }

    public final int b() {
        return this.b;
    }
}

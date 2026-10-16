package com.moloco.sdk.internal.publisher.nativead.parser;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends Exception {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final int f5555a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b;

    public b(int i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c errorSubType) {
        Intrinsics.checkNotNullParameter(errorSubType, "errorSubType");
        this.f5555a = i;
        this.b = errorSubType;
    }

    public final int a() {
        return this.f5555a;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b() {
        return this.b;
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3490a {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f6138a;
    public final Integer b;
    public final AbstractC3491b c;

    public C3490a(String str, Integer num, AbstractC3491b child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.f6138a = str;
        this.b = num;
        this.c = child;
    }

    public final AbstractC3491b a() {
        return this.c;
    }

    public final String b() {
        return this.f6138a;
    }

    public final Integer c() {
        return this.b;
    }
}

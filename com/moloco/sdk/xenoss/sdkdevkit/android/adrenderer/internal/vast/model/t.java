package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class t {
    public static final int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f6157a;
    public final i b;

    public t(String resource, i creativeType) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        this.f6157a = resource;
        this.b = creativeType;
    }

    public final i a() {
        return this.b;
    }

    public final String b() {
        return this.f6157a;
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.n, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3464n implements InterfaceC3463m {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5920a;

    public C3464n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f5920a = context;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m
    public boolean a(String uri) {
        boolean b2;
        Intrinsics.checkNotNullParameter(uri, "uri");
        b2 = o.b(this.f5920a, uri);
        return b2;
    }
}

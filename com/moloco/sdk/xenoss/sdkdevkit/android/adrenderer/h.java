package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h implements InterfaceC3450c {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final y f5769a;
    public final f b;
    public final f c;

    public h(y vastOptions, f mraidOptions, f staticOptions) {
        Intrinsics.checkNotNullParameter(vastOptions, "vastOptions");
        Intrinsics.checkNotNullParameter(mraidOptions, "mraidOptions");
        Intrinsics.checkNotNullParameter(staticOptions, "staticOptions");
        this.f5769a = vastOptions;
        this.b = mraidOptions;
        this.c = staticOptions;
    }

    public final f a() {
        return this.b;
    }

    public final f b() {
        return this.c;
    }

    public final y c() {
        return this.f5769a;
    }
}

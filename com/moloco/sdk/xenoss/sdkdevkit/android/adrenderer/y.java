package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class y implements InterfaceC3450c {
    public static final int i = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6351a;
    public final Boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final Function2<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> h;

    public y() {
        this(false, null, 0, 0, 0, false, false, null, 255, null);
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.f;
    }

    public final int c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final Boolean e() {
        return this.b;
    }

    public final int f() {
        return this.c;
    }

    public final boolean g() {
        return this.f6351a;
    }

    public final Function2<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> h() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(boolean z, Boolean bool, int i2, int i3, int i4, boolean z2, boolean z3, Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> VastRenderer) {
        Intrinsics.checkNotNullParameter(VastRenderer, "VastRenderer");
        this.f6351a = z;
        this.b = bool;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = z2;
        this.g = z3;
        this.h = VastRenderer;
    }

    public /* synthetic */ y(boolean z, Boolean bool, int i2, int i3, int i4, boolean z2, boolean z3, Function2 function2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? true : z, (i5 & 2) != 0 ? null : bool, (i5 & 4) != 0 ? 5 : i2, (i5 & 8) != 0 ? 5 : i3, (i5 & 16) == 0 ? i4 : 5, (i5 & 32) != 0 ? false : z2, (i5 & 64) == 0 ? z3 : false, (i5 & 128) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(0L, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i) null, (Function2) null, (Function2) null, (Function2) null, (K) null, 1023, (Object) null) : function2);
    }
}

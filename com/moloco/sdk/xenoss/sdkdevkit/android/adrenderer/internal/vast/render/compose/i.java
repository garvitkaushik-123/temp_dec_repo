package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class i {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f6224a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;

    public i() {
        this(null, null, null, 7, null);
    }

    public final Function0<Unit> a() {
        return this.b;
    }

    public final Function0<Unit> b() {
        return this.c;
    }

    public final Function0<Unit> c() {
        return this.f6224a;
    }

    public i(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        this.f6224a = function0;
        this.b = function02;
        this.c = function03;
    }

    public /* synthetic */ i(Function0 function0, Function0 function02, Function0 function03, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0, (i & 2) != 0 ? null : function02, (i & 4) != 0 ? null : function03);
    }
}

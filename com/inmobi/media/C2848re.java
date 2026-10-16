package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.re, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2848re {

    /* renamed from: a, reason: collision with root package name */
    public final int f2698a;
    public final int b;
    public final int c;
    public final Lambda d;

    /* JADX WARN: Multi-variable type inference failed */
    public C2848re(int i, int i2, int i3, Function0 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.f2698a = i;
        this.b = i2;
        this.c = i3;
        this.d = (Lambda) action;
    }
}

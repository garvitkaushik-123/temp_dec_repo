package com.ironsource;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.je, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3151je {
    private static Boolean b;

    /* renamed from: a, reason: collision with root package name */
    public static final C3151je f3381a = new C3151je();
    private static EnumC3135ie c = EnumC3135ie.NOT_INIT;

    private C3151je() {
    }

    public final synchronized EnumC3135ie a() {
        return c;
    }

    public final EnumC3135ie b() {
        Boolean bool = b;
        if (bool == null ? true : Intrinsics.areEqual(bool, Boolean.FALSE)) {
            return EnumC3135ie.NOT_INIT;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return c;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final synchronized void a(EnumC3135ie enumC3135ie) {
        Intrinsics.checkNotNullParameter(enumC3135ie, "<set-?>");
        c = enumC3135ie;
    }

    public final void a(boolean z) {
        b = Boolean.valueOf(z);
    }
}

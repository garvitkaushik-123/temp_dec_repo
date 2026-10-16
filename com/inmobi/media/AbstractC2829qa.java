package com.inmobi.media;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.qa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2829qa {
    public static final EnumC2813pa a(byte b) {
        return b == 1 ? EnumC2813pa.f2670a : b == 2 ? EnumC2813pa.c : b == 3 ? EnumC2813pa.b : b == 4 ? EnumC2813pa.d : EnumC2813pa.f2670a;
    }

    public static final boolean b(EnumC2813pa enumC2813pa) {
        Intrinsics.checkNotNullParameter(enumC2813pa, "<this>");
        return enumC2813pa == EnumC2813pa.b || enumC2813pa == EnumC2813pa.d;
    }

    public static final int a(EnumC2813pa enumC2813pa) {
        Intrinsics.checkNotNullParameter(enumC2813pa, "<this>");
        int ordinal = enumC2813pa.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        if (ordinal == 1) {
            return 90;
        }
        if (ordinal == 2) {
            return 180;
        }
        if (ordinal == 3) {
            return 270;
        }
        throw new NoWhenBranchMatchedException();
    }
}

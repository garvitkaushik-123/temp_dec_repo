package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Ga {
    public static final boolean a(Da da) {
        Intrinsics.checkNotNullParameter(da, "<this>");
        int i = da.b;
        if ((400 <= i && i < 600) || i <= 0) {
            return false;
        }
        String str = da.c;
        return str == null || str.length() == 0;
    }
}

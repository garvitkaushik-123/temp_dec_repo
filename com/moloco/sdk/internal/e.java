package com.moloco.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {
    public static final String a() {
        String packageName = com.moloco.sdk.internal.android_context.b.a(null, 1, null).getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }
}

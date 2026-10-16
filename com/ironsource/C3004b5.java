package com.ironsource;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* renamed from: com.ironsource.b5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3004b5 {

    /* renamed from: a, reason: collision with root package name */
    public static final C3004b5 f3194a = new C3004b5();

    private C3004b5() {
    }

    private final int a(Context context, int i) {
        return MathKt.roundToInt(i / context.getResources().getDisplayMetrics().density);
    }

    public final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context, context.getResources().getDisplayMetrics().widthPixels);
    }

    public final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context, context.getResources().getDisplayMetrics().heightPixels);
    }
}

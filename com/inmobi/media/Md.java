package com.inmobi.media;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Md {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f2365a = LazyKt.lazy(Ld.f2355a);

    @JvmStatic
    public static final void a(Runnable runnable, long j) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ((Handler) f2365a.getValue()).postDelayed(runnable, j);
    }

    @JvmStatic
    public static final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ((Handler) f2365a.getValue()).post(runnable);
    }
}

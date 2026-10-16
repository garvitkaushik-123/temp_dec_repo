package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class R7 implements Cf {
    private static boolean c;
    private static final I9 e;
    private static final I9 f;
    private static final I9 g;

    /* renamed from: a, reason: collision with root package name */
    public static final R7 f3025a = new R7();
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static final Lazy d = LazyKt.lazy(a.f3026a);

    static final class a extends Lambda implements Function0<Qd> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3026a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Qd invoke() {
            return new Qd(0, null, null, 7, null);
        }
    }

    static {
        I9 i9 = new I9("isadplayer-background");
        i9.start();
        i9.a();
        e = i9;
        I9 i92 = new I9("isadplayer-publisher-callbacks");
        i92.start();
        i92.a();
        f = i92;
        I9 i93 = new I9("isadplayer-release");
        i93.start();
        i93.a();
        g = i93;
    }

    private R7() {
    }

    private final boolean f(Runnable runnable) {
        return c && b().getQueue().contains(runnable);
    }

    public final void a(boolean z) {
        c = z;
    }

    public final void b(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        a(this, action, 0L, 2, (Object) null);
    }

    public final void c(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        b(this, action, 0L, 2, null);
    }

    public final void d(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        c(this, action, 0L, 2, null);
    }

    public final void e(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (f(action)) {
            b().remove(action);
        } else {
            g.b(action);
        }
    }

    private final Qd b() {
        return (Qd) d.getValue();
    }

    public static /* synthetic */ void c(R7 r7, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        r7.d(runnable, j);
    }

    @Override // com.ironsource.Cf
    public void a(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        c(this, action, 0L, 2, null);
    }

    public final boolean d() {
        return c;
    }

    public static /* synthetic */ void a(R7 r7, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        r7.b(runnable, j);
    }

    public final void b(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        e.a(action, j);
    }

    public final void c(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        f.a(action, j);
    }

    public final void d(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        b.postDelayed(action, j);
    }

    public static /* synthetic */ void b(R7 r7, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        r7.c(runnable, j);
    }

    @Override // com.ironsource.Cf
    public void a(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (c) {
            b().schedule(action, j, TimeUnit.MILLISECONDS);
        } else {
            g.a(action, j);
        }
    }

    public final ThreadPoolExecutor c() {
        return b();
    }

    public final Looper a() {
        return e.getLooper();
    }
}

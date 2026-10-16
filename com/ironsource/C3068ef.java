package com.ironsource;

import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.ironsource.ef, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3068ef {

    /* renamed from: a, reason: collision with root package name */
    public static final C3068ef f3275a = new C3068ef();
    private static final Lazy b = LazyKt.lazy(a.f3276a);

    /* renamed from: com.ironsource.ef$a */
    static final class a extends Lambda implements Function0<Qd> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3276a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Qd invoke() {
            return new Qd(16, null, null, 6, null);
        }
    }

    private C3068ef() {
    }

    public final void a(Runnable action) {
        Intrinsics.checkNotNullParameter(action, "action");
        a(this, action, 0L, 2, null);
    }

    private final Qd a() {
        return (Qd) b.getValue();
    }

    public static /* synthetic */ void a(C3068ef c3068ef, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        c3068ef.a(runnable, j);
    }

    public final void a(Runnable action, long j) {
        Intrinsics.checkNotNullParameter(action, "action");
        a().schedule(action, j, TimeUnit.MILLISECONDS);
    }
}

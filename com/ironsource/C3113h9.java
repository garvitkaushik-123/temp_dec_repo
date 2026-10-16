package com.ironsource;

import android.os.Handler;
import com.ironsource.environment.thread.IronSourceThreadManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.h9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3113h9 {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f3334a;

    /* renamed from: com.ironsource.h9$a */
    public static final class a extends Pd {
        final /* synthetic */ Runnable b;

        a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // com.ironsource.Pd
        public void a() {
            this.b.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3113h9() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.ironsource.Pd] */
    private final void c(Runnable runnable) {
        a aVar = runnable instanceof Pd ? (Pd) runnable : new a(runnable);
        if (Thread.currentThread().getId() == this.f3334a.getLooper().getThread().getId()) {
            aVar.run();
        } else {
            a(this, aVar, 0L, 2, null);
        }
    }

    public final Handler a() {
        return this.f3334a;
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        c(runnable);
    }

    public C3113h9(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f3334a = handler;
    }

    public static /* synthetic */ void a(C3113h9 c3113h9, Pd pd, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        c3113h9.a(pd, j);
    }

    public /* synthetic */ C3113h9(Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Handler(IronSourceThreadManager.INSTANCE.getSharedManagersThread().getLooper()) : handler);
    }

    public final void a(Pd task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.f3334a.postDelayed(task, j);
    }

    public final void a(Pd task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.f3334a.removeCallbacks(task);
    }

    public final void a(Runnable callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        c(callback);
    }
}

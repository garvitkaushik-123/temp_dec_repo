package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class I9 extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    private Handler f2909a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I9(String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public final void a(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        a(this, task, 0L, 2, null);
    }

    public final void b(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Handler handler = this.f2909a;
        if (handler != null) {
            handler.removeCallbacks(task);
        }
    }

    public static /* synthetic */ void a(I9 i9, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        i9.a(runnable, j);
    }

    public final void a(Runnable task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        Handler handler = this.f2909a;
        if (handler != null) {
            handler.postDelayed(task, j);
        }
    }

    public final void a() {
        this.f2909a = new Handler(getLooper());
    }
}

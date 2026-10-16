package com.ironsource;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
final class C5 extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    private Handler f2811a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5(String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public final void a(Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Handler handler = this.f2811a;
        if (handler != null) {
            handler.post(task);
        }
    }

    public final void a() {
        this.f2811a = new Handler(getLooper());
    }
}

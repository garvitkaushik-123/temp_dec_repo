package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.o7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ExecutorC2793o7 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f2659a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f2659a.post(runnable);
    }
}

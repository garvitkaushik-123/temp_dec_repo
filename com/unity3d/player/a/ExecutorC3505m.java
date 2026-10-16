package com.unity3d.player.a;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.unity3d.player.a.m, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class ExecutorC3505m implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6532a;

    public ExecutorC3505m(Handler handler) {
        this.f6532a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (!this.f6532a.post(runnable)) {
            throw new RejectedExecutionException(this.f6532a + " is shutting down");
        }
    }
}

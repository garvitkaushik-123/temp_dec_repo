package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2570b extends G3 {
    public final long b;
    public final RunnableC2552a c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;
    public final Handler f;
    public ScheduledExecutorService g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2570b(long j, H3 listener) {
        super(listener);
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b = j;
        this.c = new RunnableC2552a(this);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = new Handler(Looper.getMainLooper());
    }

    public static final StackTraceElement[] a(C2570b c2570b) {
        c2570b.getClass();
        return Looper.getMainLooper().getThread().getStackTrace();
    }

    public static final void b(C2570b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.d.getAndSet(true)) {
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this$0.g;
        if (scheduledExecutorService == null || scheduledExecutorService.scheduleAtFixedRate(this$0.c, 0L, this$0.b, TimeUnit.MILLISECONDS) == null) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new K5("ANRWatchDog"));
            this$0.g = newSingleThreadScheduledExecutor;
            if (newSingleThreadScheduledExecutor != null) {
                newSingleThreadScheduledExecutor.scheduleAtFixedRate(this$0.c, 0L, this$0.b, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.inmobi.media.G3
    public final void a() {
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2570b.b(C2570b.this);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ie.f2319a.execute(runnable);
    }

    @Override // com.inmobi.media.G3
    public final void b() {
        if (this.d.getAndSet(false)) {
            this.d.set(false);
            this.e.set(false);
            ScheduledExecutorService scheduledExecutorService = this.g;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.g = null;
        }
    }
}

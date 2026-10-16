package com.inmobi.media;

import com.adjust.sdk.Constants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class O4 extends Fa {
    public final Object g;
    public ScheduledExecutorService h;
    public ScheduledFuture i;
    public ExecutorService j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O4(Pa dao, C2558a5 listener, Ka networkHandler) {
        super(dao, listener, networkHandler);
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(networkHandler, "networkHandler");
        this.g = new Object();
    }

    public static final void a(O4 this$0, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue("O4", "TAG");
        int high = this$0.f.getMaxBatchSize().getHigh();
        Pa pa = this$0.f2284a;
        Integer valueOf = Integer.valueOf(high);
        Intrinsics.checkNotNullParameter(Constants.HIGH, HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
        List filterNotNull = CollectionsKt.filterNotNull(T1.a(pa, "priority = ? AND retry_count = 0 AND time_created < ?", new String[]{Constants.HIGH, String.valueOf(j)}, null, null, "time_created ASC", valueOf, 12));
        while (!filterNotNull.isEmpty() && this$0.d != Ca.f2252a) {
            Intrinsics.checkNotNullExpressionValue("O4", "TAG");
            filterNotNull.size();
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                this$0.a((C2976za) it.next(), this$0.j, new N4(this$0));
            }
            Pa pa2 = this$0.f2284a;
            Intrinsics.checkNotNullParameter(Constants.HIGH, HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            List filterNotNull2 = CollectionsKt.filterNotNull(T1.a(pa2, "priority = ? AND retry_count = 0 AND time_created < ?", new String[]{Constants.HIGH, String.valueOf(j)}, null, null, "time_created ASC", null, 12));
            ArrayList arrayList = new ArrayList();
            for (Object obj : filterNotNull2) {
                if (!this$0.e.containsKey(((C2976za) obj).b)) {
                    arrayList.add(obj);
                }
            }
            filterNotNull = CollectionsKt.take(arrayList, high);
        }
    }

    public static final Thread b(Runnable runnable) {
        Thread thread = new Thread(runnable, "TIM-HighPriorityParallelPing");
        thread.setDaemon(true);
        return thread;
    }

    public final void c() {
        final long currentTimeMillis = System.currentTimeMillis();
        ExecutorService executorService = this.j;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.inmobi.media.O4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    O4.a(O4.this, currentTimeMillis);
                }
            });
        }
    }

    public final void d() {
        synchronized (this.g) {
            ScheduledFuture scheduledFuture = this.i;
            if (scheduledFuture != null) {
                Intrinsics.checkNotNull(scheduledFuture);
                if (!scheduledFuture.isDone()) {
                    return;
                }
            }
            long high = this.f.getInterval().getHigh();
            if (high <= 0) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("O4", "TAG");
            ScheduledExecutorService scheduledExecutorService = this.h;
            this.i = scheduledExecutorService != null ? scheduledExecutorService.scheduleWithFixedDelay(new Runnable() { // from class: com.inmobi.media.O4$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    O4.a(O4.this);
                }
            }, 0L, high, TimeUnit.SECONDS) : null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void e() {
        synchronized (this.g) {
            ScheduledFuture scheduledFuture = this.i;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.i = null;
            Unit unit = Unit.INSTANCE;
        }
        ExecutorService executorService = this.j;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    public final void b() {
        Intrinsics.checkNotNullExpressionValue("O4", "TAG");
        Ca ca = Ca.b;
        if (a(ca)) {
            this.d = ca;
        }
        synchronized (this.g) {
            ScheduledFuture scheduledFuture = this.i;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.i = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r1.isShutdown() != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r1.isShutdown() != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        synchronized (this.g) {
            ScheduledExecutorService scheduledExecutorService = this.h;
            if (scheduledExecutorService != null) {
                Intrinsics.checkNotNull(scheduledExecutorService);
            }
            this.h = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.inmobi.media.O4$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return O4.a(runnable);
                }
            });
            ExecutorService executorService = this.j;
            if (executorService != null) {
                Intrinsics.checkNotNull(executorService);
            }
            this.j = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.inmobi.media.O4$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return O4.b(runnable);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "TIM-HighPriorityPollingPing");
        thread.setDaemon(true);
        return thread;
    }

    public static final void a(O4 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        try {
            Intrinsics.checkNotNullExpressionValue("O4", "TAG");
            if (this$0.d != Ca.f2252a) {
                int high = this$0.f.getMaxBatchSize().getHigh();
                this$0.f2284a.a("time_created < ?", new String[]{String.valueOf(System.currentTimeMillis() - (this$0.f.getExpiry().getHigh() * 1000))});
                List filterNotNull = CollectionsKt.filterNotNull(this$0.f2284a.a(Integer.valueOf(high)));
                if (filterNotNull.isEmpty()) {
                    Pa pa = this$0.f2284a;
                    Intrinsics.checkNotNullParameter(Constants.HIGH, HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
                    if (T1.a(pa, "priority = ?", new String[]{Constants.HIGH}, 12) == 0) {
                        this$0.b();
                        return;
                    }
                }
                Intrinsics.checkNotNullExpressionValue("O4", "TAG");
                filterNotNull.size();
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    this$0.a((C2976za) it.next(), this$0.j, new M4(this$0));
                }
            }
        } catch (Error unused) {
            Intrinsics.checkNotNullExpressionValue("O4", "TAG");
        } catch (Exception unused2) {
            Intrinsics.checkNotNullExpressionValue("O4", "TAG");
        }
    }
}

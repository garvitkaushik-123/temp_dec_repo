package com.inmobi.media;

import com.adjust.sdk.Constants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class W9 extends Fa {
    public final Object g;
    public ScheduledFuture h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W9(Pa dao, E3 listener, Ka networkHandler) {
        super(dao, listener, networkHandler);
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(networkHandler, "networkHandler");
        this.g = new Object();
    }

    public final void a() {
        synchronized (this.g) {
            ScheduledFuture scheduledFuture = this.h;
            if (scheduledFuture != null) {
                Intrinsics.checkNotNull(scheduledFuture);
                if (!scheduledFuture.isDone()) {
                    return;
                }
            }
            long normal = this.f.getInterval().getNormal();
            if (normal <= 0) {
                return;
            }
            int i = AbstractC2970z4.f2771a;
            this.h = ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).scheduleWithFixedDelay(new Runnable() { // from class: com.inmobi.media.W9$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    W9.a(W9.this);
                }
            }, 0L, normal, TimeUnit.SECONDS);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b() {
        synchronized (this.g) {
            ScheduledFuture scheduledFuture = this.h;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.h = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void a(W9 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.d != Ca.f2252a) {
            int normal = this$0.f.getMaxBatchSize().getNormal();
            this$0.f2284a.a("time_created < ?", new String[]{String.valueOf(System.currentTimeMillis() - (this$0.f.getExpiry().getNormal() * 1000))});
            Pa pa = this$0.f2284a;
            Integer valueOf = Integer.valueOf(normal);
            Intrinsics.checkNotNullParameter(Constants.NORMAL, HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            List filterNotNull = CollectionsKt.filterNotNull(T1.a(pa, "priority = ? AND retryAfter <= ?", new String[]{Constants.NORMAL, String.valueOf(System.currentTimeMillis())}, null, null, "time_created ASC", valueOf, 12));
            if (filterNotNull.isEmpty()) {
                Pa pa2 = this$0.f2284a;
                Intrinsics.checkNotNullParameter(Constants.NORMAL, HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
                if (T1.a(pa2, "priority = ?", new String[]{Constants.NORMAL}, 12) == 0) {
                    Ca ca = Ca.b;
                    if (this$0.a(ca)) {
                        this$0.d = ca;
                    }
                    synchronized (this$0.g) {
                        ScheduledFuture scheduledFuture = this$0.h;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this$0.h = null;
                        Unit unit = Unit.INSTANCE;
                    }
                    return;
                }
            }
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                this$0.a((C2976za) it.next(), (ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue(), new V9(this$0));
            }
        }
    }
}

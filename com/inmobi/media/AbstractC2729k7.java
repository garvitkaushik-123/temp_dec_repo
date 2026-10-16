package com.inmobi.media;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.k7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2729k7 {
    public static void a(final Z6 dao, final long j, final int i) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        if (AbstractC2745l7.d.getAndSet(true)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.k7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2729k7.b(Z6.this, j, i);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ie.f2319a.schedule(runnable, 10000L, TimeUnit.MILLISECONDS);
    }

    public static final void b(Z6 dao, long j, int i) {
        Intrinsics.checkNotNullParameter(dao, "$dao");
        dao.getClass();
        for (Y6 y6 : T1.a(dao, "id NOT IN (SELECT id FROM ( SELECT id FROM logs_v2 WHERE saveTimestamp > " + j + " ORDER BY saveTimestamp DESC LIMIT " + i + ") AS foo);", null, null, null, null, null, 62)) {
            if (y6 != null) {
                AbstractC2761m7.a(y6.f2492a);
                dao.a(y6);
            }
        }
        AbstractC2745l7.d.set(false);
    }

    public static Object a(Function0 run) {
        Semaphore semaphore;
        Intrinsics.checkNotNullParameter(run, "run");
        try {
            Result.Companion companion = Result.INSTANCE;
            try {
                try {
                    semaphore = AbstractC2745l7.c;
                    semaphore.acquire();
                    run.invoke();
                } catch (Exception e) {
                    S5 s5 = S5.f2425a;
                    C2640f2 event = new C2640f2(e);
                    Intrinsics.checkNotNullParameter(event, "event");
                    S5.d.a(event);
                    semaphore = AbstractC2745l7.c;
                }
                semaphore.release();
                return Result.m10241constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                AbstractC2745l7.c.release();
                throw th;
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th2));
        }
    }
}

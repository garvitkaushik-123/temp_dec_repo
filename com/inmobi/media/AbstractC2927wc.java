package com.inmobi.media;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.wc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2927wc {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f2744a;

    static {
        Intrinsics.checkNotNullExpressionValue("wc", "getSimpleName(...)");
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(...)");
        f2744a = newSetFromMap;
    }

    public static void a(C2895uc c2895uc, long j) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        int ordinal = c2895uc.f.ordinal();
        if (ordinal == 0) {
            scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue();
        } else {
            if (ordinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue();
        }
        scheduledThreadPoolExecutor.schedule(new RunnableC2943xc(c2895uc, C2911vc.f2735a), j, TimeUnit.MILLISECONDS);
    }
}

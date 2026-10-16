package com.inmobi.media;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.y2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2949y2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Ua f2758a;

    static {
        int i = Ua.f2451a;
        K5 threadFactory = new K5("ClickManagerExecutor", true);
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
        Ua ua = new Ua(TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadFactory);
        Intrinsics.checkNotNull(ua, "null cannot be cast to non-null type com.inmobi.commons.sdk.PriorityExecutor");
        f2758a = ua;
    }

    public static void a(Runnable runnable, Ta ta) {
        try {
            Ua ua = f2758a;
            ua.getClass();
            Intrinsics.checkNotNull(ta);
            ua.execute(new E2(runnable, ta));
        } catch (RejectedExecutionException unused) {
        }
    }
}

package com.inmobi.media;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.l7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2745l7 {

    /* renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f2631a;
    public static final ExecutorService b;
    public static final Semaphore c;
    public static final AtomicBoolean d;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5, new K5("Log", true));
        Intrinsics.checkNotNullExpressionValue(newScheduledThreadPool, "newScheduledThreadPool(...)");
        f2631a = newScheduledThreadPool;
        b = Executors.newSingleThreadExecutor(new K5("LogSingle", true));
        c = new Semaphore(1);
        d = new AtomicBoolean(false);
    }
}

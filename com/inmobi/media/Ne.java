package com.inmobi.media;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ne implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2377a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r) {
        Intrinsics.checkNotNullParameter(r, "r");
        return new Thread(r, "VastNetworkTask #" + this.f2377a.getAndIncrement());
    }
}

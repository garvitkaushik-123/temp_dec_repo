package com.fyber.inneractive.sdk.network;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class g0 implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f1320a = new AtomicInteger(100);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, String.format(Locale.ENGLISH, "FyberMarketplace-Network-%02d", Integer.valueOf(this.f1320a.getAndIncrement())));
    }
}

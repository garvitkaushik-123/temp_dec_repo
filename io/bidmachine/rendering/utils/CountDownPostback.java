package io.bidmachine.rendering.utils;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes8.dex */
public class CountDownPostback implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f7189a;
    private final AtomicInteger b;

    public CountDownPostback(int count, Runnable runnable) {
        this.f7189a = runnable;
        this.b = new AtomicInteger(count);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.decrementAndGet() > 0) {
            return;
        }
        this.f7189a.run();
    }
}

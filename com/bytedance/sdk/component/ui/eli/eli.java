package com.bytedance.sdk.component.ui.eli;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class eli implements ThreadFactory {
    private final AtomicInteger DbA = new AtomicInteger(1);
    private final ThreadGroup eli;

    public eli(String str) {
        this.eli = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.eli, runnable, "tt_img_" + this.DbA.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}

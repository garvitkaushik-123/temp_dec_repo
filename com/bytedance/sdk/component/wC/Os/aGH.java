package com.bytedance.sdk.component.wC.Os;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class aGH implements ThreadFactory {
    public static volatile boolean Os;
    protected final String DbA;
    private final AtomicInteger aGH = new AtomicInteger(1);
    protected final ThreadGroup eli;

    public aGH(String str) {
        this.eli = new ThreadGroup("pag_g_".concat(String.valueOf(str)));
        this.DbA = eli(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        if (Os) {
            return null;
        }
        Thread eli = eli(this.eli, runnable, this.DbA + "_" + this.aGH.getAndIncrement());
        if (eli.isDaemon()) {
            eli.setDaemon(false);
        }
        return eli;
    }

    protected Thread eli(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }

    public static String eli(String str) {
        return "pag_".concat(String.valueOf(str));
    }
}

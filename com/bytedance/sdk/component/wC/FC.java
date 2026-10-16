package com.bytedance.sdk.component.wC;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class FC implements ThreadFactory {
    public static final String THREAD_GROUP_NAME_PRE = "csj_g_";
    public static final String THREAD_NAME_PRE = "csj_";
    public static volatile boolean sCrashHappened;
    protected final String DbA;
    protected int Os;
    private final AtomicInteger aGH;
    protected final ThreadGroup eli;

    public FC(String str) {
        this(5, str);
    }

    public FC(int i, String str) {
        this.aGH = new AtomicInteger(1);
        this.Os = i;
        this.eli = new ThreadGroup(THREAD_GROUP_NAME_PRE.concat(String.valueOf(str)));
        this.DbA = THREAD_NAME_PRE.concat(String.valueOf(str));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        if (sCrashHappened) {
            return null;
        }
        Thread eli = eli(this.eli, runnable, this.DbA + this.aGH.getAndIncrement());
        if (eli.isDaemon()) {
            eli.setDaemon(false);
        }
        int i = this.Os;
        if (i > 10 || i <= 0) {
            this.Os = 5;
        }
        eli.setPriority(this.Os);
        return eli;
    }

    protected Thread eli(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }
}

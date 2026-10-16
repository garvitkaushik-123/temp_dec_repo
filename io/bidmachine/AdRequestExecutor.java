package io.bidmachine;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
class AdRequestExecutor extends ThreadPoolExecutor {
    private static volatile AdRequestExecutor instance;

    public static AdRequestExecutor get() {
        if (instance == null) {
            synchronized (AdRequestExecutor.class) {
                if (instance == null) {
                    instance = new AdRequestExecutor(Runtime.getRuntime().availableProcessors() * 2);
                }
            }
        }
        return instance;
    }

    AdRequestExecutor(int nThreads) {
        super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }
}

package io.bidmachine.core;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes7.dex */
final class ProcessPriorityThreadFactory implements ThreadFactory {
    private final int threadPriority;

    ProcessPriorityThreadFactory(int threadPriority) {
        this.threadPriority = threadPriority;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(this.threadPriority);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.bidmachine.core.ProcessPriorityThreadFactory.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread t, Throwable e) {
                Logger.w(e);
            }
        });
        return thread;
    }
}

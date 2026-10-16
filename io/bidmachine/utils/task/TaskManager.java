package io.bidmachine.utils.task;

import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public interface TaskManager {
    void cancel(CancelableTask task);

    void execute(Runnable task);

    void schedule(CancelableTask task, long delay, TimeUnit timeUnit);

    default void schedule(CancelableTask task, long delayMs) {
        schedule(task, delayMs, TimeUnit.MILLISECONDS);
    }
}

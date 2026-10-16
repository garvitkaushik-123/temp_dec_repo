package io.bidmachine.rendering.utils.taskmanager;

import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public interface TaskManager {
    void cancel(Runnable task);

    void execute(Runnable task);

    default void schedule(Runnable task, long delayMs) {
        schedule(task, delayMs, TimeUnit.MILLISECONDS);
    }

    void schedule(Runnable task, long delay, TimeUnit timeUnit);
}

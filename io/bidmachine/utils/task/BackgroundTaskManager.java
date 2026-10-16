package io.bidmachine.utils.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class BackgroundTaskManager implements TaskManager {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(CORE_POOL_SIZE);
    private final Map<Runnable, Future<?>> futureMap = new ConcurrentHashMap();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
    }

    @Override // io.bidmachine.utils.task.TaskManager
    public void execute(Runnable task) {
        try {
            this.executor.execute(task);
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.utils.task.TaskManager
    public void schedule(CancelableTask task, long delay, TimeUnit timeUnit) {
        try {
            task.setCancel(false);
            this.futureMap.put(task, this.executor.schedule(new ScheduledTask(task), delay, timeUnit));
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.utils.task.TaskManager
    public void cancel(CancelableTask task) {
        try {
            task.setCancel(true);
            Future<?> removeFuture = removeFuture(task);
            if (removeFuture == null) {
                return;
            }
            removeFuture.cancel(false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Future<?> removeFuture(Runnable task) {
        try {
            return this.futureMap.remove(task);
        } catch (Throwable unused) {
            return null;
        }
    }

    Map<Runnable, Future<?>> getFutureMap() {
        return this.futureMap;
    }

    private class ScheduledTask implements Runnable {
        private final Runnable runnable;

        public ScheduledTask(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            BackgroundTaskManager.this.removeFuture(this.runnable);
            this.runnable.run();
        }
    }
}

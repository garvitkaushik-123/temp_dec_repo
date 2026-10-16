package io.bidmachine;

import io.bidmachine.utils.task.BackgroundTaskManager;
import io.bidmachine.utils.task.CancelableTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class BidTokenTaskManager {
    private static volatile BackgroundTaskManager instance;

    private static BackgroundTaskManager get() {
        BackgroundTaskManager backgroundTaskManager;
        BackgroundTaskManager backgroundTaskManager2 = instance;
        if (backgroundTaskManager2 != null) {
            return backgroundTaskManager2;
        }
        synchronized (BackgroundTaskManager.class) {
            backgroundTaskManager = instance;
            if (backgroundTaskManager == null) {
                backgroundTaskManager = new BackgroundTaskManager();
                instance = backgroundTaskManager;
            }
        }
        return backgroundTaskManager;
    }

    public static void execute(Runnable task) {
        get().execute(task);
    }

    public static void schedule(CancelableTask task, long delay, TimeUnit timeUnit) {
        get().schedule(task, delay, timeUnit);
    }

    public static void cancel(CancelableTask task) {
        get().cancel(task);
    }
}

package io.bidmachine;

import io.bidmachine.utils.task.BackgroundTaskManager;
import io.bidmachine.utils.task.TaskManager;

/* loaded from: classes7.dex */
class CommonBackgroundTaskManager {
    private static volatile TaskManager instance;

    CommonBackgroundTaskManager() {
    }

    public static TaskManager get() {
        TaskManager taskManager;
        TaskManager taskManager2 = instance;
        if (taskManager2 != null) {
            return taskManager2;
        }
        synchronized (CommonBackgroundTaskManager.class) {
            taskManager = instance;
            if (taskManager == null) {
                taskManager = new BackgroundTaskManager();
                instance = taskManager;
            }
        }
        return taskManager;
    }
}

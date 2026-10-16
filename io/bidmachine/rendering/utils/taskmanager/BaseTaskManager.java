package io.bidmachine.rendering.utils.taskmanager;

import io.bidmachine.rendering.utils.Cancelable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public abstract class BaseTaskManager implements TaskManager {
    private void a(Runnable task, boolean isCancel) {
        try {
            if (task instanceof Cancelable) {
                ((Cancelable) task).setCancel(isCancel);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void cancel(Runnable task) {
        a(task, true);
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void execute(Runnable task) {
        a(task, false);
    }

    @Override // io.bidmachine.rendering.utils.taskmanager.TaskManager
    public void schedule(Runnable task, long delay, TimeUnit timeUnit) {
        a(task, false);
    }
}

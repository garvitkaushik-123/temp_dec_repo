package io.bidmachine.utils.task;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public abstract class CancelableTask implements Runnable {
    private final AtomicBoolean isCanceled = new AtomicBoolean(false);

    public abstract void runTask();

    public boolean isCanceled() {
        return this.isCanceled.get();
    }

    public void setCancel(boolean isCancel) {
        this.isCanceled.set(isCancel);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isCanceled()) {
            return;
        }
        runTask();
    }
}

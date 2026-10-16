package io.bidmachine.rendering.utils.taskmanager;

import io.bidmachine.rendering.utils.Cancelable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes8.dex */
public abstract class CancelableTask implements Runnable, Cancelable {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f7200a = new AtomicBoolean(false);

    @Override // io.bidmachine.rendering.utils.Cancelable
    public boolean isCanceled() {
        return this.f7200a.get();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (isCanceled()) {
            return;
        }
        runTask();
    }

    public abstract void runTask();

    @Override // io.bidmachine.rendering.utils.Cancelable
    public void setCancel(boolean isCancel) {
        this.f7200a.set(isCancel);
    }
}

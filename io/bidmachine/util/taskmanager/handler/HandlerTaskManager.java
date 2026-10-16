package io.bidmachine.util.taskmanager.handler;

import android.os.Handler;
import android.os.Looper;
import io.bidmachine.util.taskmanager.BaseTaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HandlerTaskManager.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lio/bidmachine/util/taskmanager/handler/HandlerTaskManager;", "Lio/bidmachine/util/taskmanager/BaseTaskManager;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "getHandler", "()Landroid/os/Handler;", "cancelTask", "", "task", "Ljava/lang/Runnable;", "isCurrentThread", "", "scheduleTask", "delayMs", "", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public class HandlerTaskManager extends BaseTaskManager {
    private final Handler handler;

    public final Handler getHandler() {
        return this.handler;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HandlerTaskManager(Looper looper) {
        this(new Handler(looper));
        Intrinsics.checkNotNullParameter(looper, "looper");
    }

    public HandlerTaskManager(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void scheduleTask(Runnable task, long delayMs) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        if (delayMs > 0) {
            this.handler.postDelayed(task, delayMs);
        } else if (isCurrentThread()) {
            task.run();
        } else {
            this.handler.post(task);
        }
    }

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void cancelTask(Runnable task) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        this.handler.removeCallbacks(task);
    }

    private final boolean isCurrentThread() {
        return Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper());
    }
}

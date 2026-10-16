package io.bidmachine.util.taskmanager;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lio/bidmachine/util/taskmanager/TaskManager;", "", "cancel", "", "task", "Ljava/lang/Runnable;", "execute", "executeSafely", "", "schedule", "delayMs", "", "delay", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "scheduleSafely", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface TaskManager {
    void cancel(Runnable task);

    void schedule(Runnable task, long delayMs) throws Throwable;

    default void execute(Runnable task) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        schedule(task, 0L);
    }

    default void schedule(Runnable task, long delay, TimeUnit timeUnit) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        schedule(task, timeUnit.toMillis(delay));
    }

    default boolean executeSafely(Runnable task) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            TaskManager taskManager = this;
            execute(task);
            bool = true;
        } catch (Throwable unused) {
            bool = null;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }

    default boolean scheduleSafely(Runnable task, long delayMs) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            TaskManager taskManager = this;
            schedule(task, delayMs);
            bool = true;
        } catch (Throwable unused) {
            bool = null;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }

    default boolean scheduleSafely(Runnable task, long delay, TimeUnit timeUnit) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            TaskManager taskManager = this;
            schedule(task, delay, timeUnit);
            bool = true;
        } catch (Throwable unused) {
            bool = null;
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }
}

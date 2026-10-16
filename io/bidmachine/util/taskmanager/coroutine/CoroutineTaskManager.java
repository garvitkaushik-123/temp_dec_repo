package io.bidmachine.util.taskmanager.coroutine;

import io.bidmachine.util.taskmanager.BaseTaskManager;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: CoroutineTaskManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/bidmachine/util/taskmanager/coroutine/CoroutineTaskManager;", "Lio/bidmachine/util/taskmanager/BaseTaskManager;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "jobMap", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Job;", "cancelTask", "", "task", "getScheduledTaskCount", "", "scheduleTask", "delayMs", "", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public class CoroutineTaskManager extends BaseTaskManager {
    private final CoroutineScope coroutineScope;
    private final Map<Runnable, Job> jobMap;

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoroutineTaskManager(CoroutineContext coroutineContext) {
        this(CoroutineScopeKt.CoroutineScope(coroutineContext));
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
    }

    public CoroutineTaskManager(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.jobMap = new ConcurrentHashMap();
    }

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void scheduleTask(Runnable task, long delayMs) throws Throwable {
        Job launch$default;
        Intrinsics.checkNotNullParameter(task, "task");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, CoroutineStart.LAZY, new CoroutineTaskManager$scheduleTask$1(delayMs, this, task, null), 1, null);
        this.jobMap.put(task, launch$default);
        launch$default.start();
    }

    @Override // io.bidmachine.util.taskmanager.BaseTaskManager
    protected void cancelTask(Runnable task) throws Throwable {
        Intrinsics.checkNotNullParameter(task, "task");
        Job remove = this.jobMap.remove(task);
        if (remove != null) {
            Job.DefaultImpls.cancel$default(remove, (CancellationException) null, 1, (Object) null);
        }
    }

    public final int getScheduledTaskCount() {
        return this.jobMap.size();
    }
}

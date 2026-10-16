package com.sourcepoint.cmplibrary.core.web;

import com.sourcepoint.cmplibrary.core.ExecutorManager;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpTimer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/SpTimerImpl;", "Lcom/sourcepoint/cmplibrary/core/web/SpTimer;", "executorManager", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "(Lcom/sourcepoint/cmplibrary/core/ExecutorManager;)V", "getExecutorManager", "()Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "timer", "Ljava/util/Timer;", "getTimer", "()Ljava/util/Timer;", "setTimer", "(Ljava/util/Timer;)V", "cancel", "", "executeDelay", "delay", "", "block", "Lkotlin/Function0;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
final class SpTimerImpl implements SpTimer {
    private final ExecutorManager executorManager;
    private Timer timer;

    public SpTimerImpl(ExecutorManager executorManager) {
        Intrinsics.checkNotNullParameter(executorManager, "executorManager");
        this.executorManager = executorManager;
        this.timer = new Timer();
    }

    public final ExecutorManager getExecutorManager() {
        return this.executorManager;
    }

    public final Timer getTimer() {
        return this.timer;
    }

    public final void setTimer(Timer timer) {
        Intrinsics.checkNotNullParameter(timer, "<set-?>");
        this.timer = timer;
    }

    @Override // com.sourcepoint.cmplibrary.core.web.SpTimer
    public void executeDelay(long delay, final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.timer.scheduleAtFixedRate(new TimerTask() { // from class: com.sourcepoint.cmplibrary.core.web.SpTimerImpl$executeDelay$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ExecutorManager executorManager = SpTimerImpl.this.getExecutorManager();
                final Function0<Unit> function0 = block;
                executorManager.executeOnMain(new Function0<Unit>() { // from class: com.sourcepoint.cmplibrary.core.web.SpTimerImpl$executeDelay$1$run$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function0.invoke();
                    }
                });
                cancel();
            }
        }, delay, 1L);
    }

    @Override // com.sourcepoint.cmplibrary.core.web.SpTimer
    public void cancel() {
        this.timer.cancel();
        this.timer = new Timer();
    }
}

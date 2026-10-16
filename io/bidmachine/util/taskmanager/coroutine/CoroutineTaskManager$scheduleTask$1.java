package io.bidmachine.util.taskmanager.coroutine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: CoroutineTaskManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.bidmachine.util.taskmanager.coroutine.CoroutineTaskManager$scheduleTask$1", f = "CoroutineTaskManager.kt", i = {0}, l = {30}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class CoroutineTaskManager$scheduleTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ Runnable $task;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoroutineTaskManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineTaskManager$scheduleTask$1(long j, CoroutineTaskManager coroutineTaskManager, Runnable runnable, Continuation<? super CoroutineTaskManager$scheduleTask$1> continuation) {
        super(2, continuation);
        this.$delayMs = j;
        this.this$0 = coroutineTaskManager;
        this.$task = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutineTaskManager$scheduleTask$1 coroutineTaskManager$scheduleTask$1 = new CoroutineTaskManager$scheduleTask$1(this.$delayMs, this.this$0, this.$task, continuation);
        coroutineTaskManager$scheduleTask$1.L$0 = obj;
        return coroutineTaskManager$scheduleTask$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineTaskManager$scheduleTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            long j = this.$delayMs;
            if (j > 0) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        try {
            this.$task.run();
            Unit unit = Unit.INSTANCE;
        } catch (Throwable unused) {
        }
        this.this$0.cancel(this.$task);
        return Unit.INSTANCE;
    }
}

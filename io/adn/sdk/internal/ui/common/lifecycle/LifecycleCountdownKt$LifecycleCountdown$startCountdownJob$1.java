package io.adn.sdk.internal.ui.common.lifecycle;

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

/* compiled from: LifecycleCountdown.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.lifecycle.LifecycleCountdownKt$LifecycleCountdown$startCountdownJob$1", f = "LifecycleCountdown.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LifecycleCountdownKt$LifecycleCountdown$startCountdownJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleCountdownState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LifecycleCountdownKt$LifecycleCountdown$startCountdownJob$1(LifecycleCountdownState lifecycleCountdownState, Continuation<? super LifecycleCountdownKt$LifecycleCountdown$startCountdownJob$1> continuation) {
        super(2, continuation);
        this.$state = lifecycleCountdownState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LifecycleCountdownKt$LifecycleCountdown$startCountdownJob$1(this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LifecycleCountdownKt$LifecycleCountdown$startCountdownJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0031 -> B:5:0x0034). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$state.isCountdownFinished()) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$state.decrementTimeLeft();
            if (!this.$state.isCountdownFinished()) {
                this.label = 1;
                if (DelayKt.delay(this.$state.getTimeInterval(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.$state.decrementTimeLeft();
                if (!this.$state.isCountdownFinished()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}

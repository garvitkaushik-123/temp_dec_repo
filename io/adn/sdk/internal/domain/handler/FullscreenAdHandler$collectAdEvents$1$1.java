package io.adn.sdk.internal.domain.handler;

import io.adn.sdk.internal.domain.model.ad.FullscreenAdEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FullscreenAdHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.handler.FullscreenAdHandler$collectAdEvents$1$1", f = "FullscreenAdHandler.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdHandler$collectAdEvents$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<FullscreenAdEvent> $flow;
    int label;
    final /* synthetic */ FullscreenAdHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FullscreenAdHandler$collectAdEvents$1$1(Flow<? extends FullscreenAdEvent> flow, FullscreenAdHandler fullscreenAdHandler, Continuation<? super FullscreenAdHandler$collectAdEvents$1$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.this$0 = fullscreenAdHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenAdHandler$collectAdEvents$1$1(this.$flow, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FullscreenAdHandler$collectAdEvents$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<FullscreenAdEvent> flow = this.$flow;
            final FullscreenAdHandler fullscreenAdHandler = this.this$0;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: io.adn.sdk.internal.domain.handler.FullscreenAdHandler$collectAdEvents$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((FullscreenAdEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(FullscreenAdEvent fullscreenAdEvent, Continuation<? super Unit> continuation) {
                    FullscreenAdHandler.this.onAdEvent(fullscreenAdEvent);
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

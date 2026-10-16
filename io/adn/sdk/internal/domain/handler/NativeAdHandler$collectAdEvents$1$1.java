package io.adn.sdk.internal.domain.handler;

import io.adn.sdk.internal.domain.model.ad.NativeAdEvent;
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

/* compiled from: NativeAdHandler.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.handler.NativeAdHandler$collectAdEvents$1$1", f = "NativeAdHandler.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class NativeAdHandler$collectAdEvents$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<NativeAdEvent> $flow;
    int label;
    final /* synthetic */ NativeAdHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NativeAdHandler$collectAdEvents$1$1(Flow<? extends NativeAdEvent> flow, NativeAdHandler nativeAdHandler, Continuation<? super NativeAdHandler$collectAdEvents$1$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.this$0 = nativeAdHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeAdHandler$collectAdEvents$1$1(this.$flow, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NativeAdHandler$collectAdEvents$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<NativeAdEvent> flow = this.$flow;
            final NativeAdHandler nativeAdHandler = this.this$0;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: io.adn.sdk.internal.domain.handler.NativeAdHandler$collectAdEvents$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((NativeAdEvent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(NativeAdEvent nativeAdEvent, Continuation<? super Unit> continuation) {
                    NativeAdHandler.this.onAdEvent(nativeAdEvent);
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

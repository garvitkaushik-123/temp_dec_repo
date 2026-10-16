package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* compiled from: Limit.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
final class FlowKt__LimitKt$drop$2$1<T> implements FlowCollector {
    final /* synthetic */ int $count;
    final /* synthetic */ Ref.IntRef $skipped;
    final /* synthetic */ FlowCollector<T> $this_flow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$drop$2$1(Ref.IntRef intRef, int i, FlowCollector<? super T> flowCollector) {
        this.$skipped = intRef;
        this.$count = i;
        this.$this_flow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$drop$2$1$emit$1 flowKt__LimitKt$drop$2$1$emit$1;
        int i;
        if (continuation instanceof FlowKt__LimitKt$drop$2$1$emit$1) {
            flowKt__LimitKt$drop$2$1$emit$1 = (FlowKt__LimitKt$drop$2$1$emit$1) continuation;
            if ((flowKt__LimitKt$drop$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$drop$2$1$emit$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$drop$2$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__LimitKt$drop$2$1$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.$skipped.element < this.$count) {
                        this.$skipped.element++;
                        int i2 = this.$skipped.element;
                        return Unit.INSTANCE;
                    }
                    FlowCollector<T> flowCollector = this.$this_flow;
                    flowKt__LimitKt$drop$2$1$emit$1.label = 1;
                    if (flowCollector.emit(t, flowKt__LimitKt$drop$2$1$emit$1) == coroutine_suspended) {
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
        flowKt__LimitKt$drop$2$1$emit$1 = new FlowKt__LimitKt$drop$2$1$emit$1(this, continuation);
        Object obj2 = flowKt__LimitKt$drop$2$1$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__LimitKt$drop$2$1$emit$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }
}

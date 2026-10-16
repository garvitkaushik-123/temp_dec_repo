package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* compiled from: Reduce.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
final class FlowKt__ReduceKt$reduce$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
    final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ReduceKt$reduce$2(Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3) {
        this.$accumulator = objectRef;
        this.$operation = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
        int i;
        Ref.ObjectRef<Object> objectRef;
        T t2;
        Ref.ObjectRef<Object> objectRef2;
        if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
            flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
            if ((flowKt__ReduceKt$reduce$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ReduceKt$reduce$2$emit$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__ReduceKt$reduce$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__ReduceKt$reduce$2$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef = this.$accumulator;
                    if (objectRef.element != NullSurrogateKt.NULL) {
                        Function3<S, T, Continuation<? super S>, Object> function3 = this.$operation;
                        Object obj2 = this.$accumulator.element;
                        flowKt__ReduceKt$reduce$2$emit$1.L$0 = objectRef;
                        flowKt__ReduceKt$reduce$2$emit$1.label = 1;
                        Object invoke = function3.invoke(obj2, t, flowKt__ReduceKt$reduce$2$emit$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        t2 = invoke;
                        objectRef2 = objectRef;
                    }
                    objectRef.element = t;
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef2 = (Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
                t2 = obj;
                T t3 = t2;
                objectRef = objectRef2;
                t = t3;
                objectRef.element = t;
                return Unit.INSTANCE;
            }
        }
        flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
        Object obj3 = flowKt__ReduceKt$reduce$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ReduceKt$reduce$2$emit$1.label;
        if (i != 0) {
        }
        T t32 = t2;
        objectRef = objectRef2;
        t = t32;
        objectRef.element = t;
        return Unit.INSTANCE;
    }
}

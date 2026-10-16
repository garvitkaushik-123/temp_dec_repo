package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Swipeable.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "anchors", "", "", "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SwipeableState$snapTo$2<T> implements FlowCollector {
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$snapTo$2(T t, SwipeableState<T> swipeableState) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Map) obj, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        SwipeableState$snapTo$2$emit$1 swipeableState$snapTo$2$emit$1;
        int i;
        Float offset;
        Object snapInternalToOffset;
        SwipeableState$snapTo$2<T> swipeableState$snapTo$2;
        if (continuation instanceof SwipeableState$snapTo$2$emit$1) {
            swipeableState$snapTo$2$emit$1 = (SwipeableState$snapTo$2$emit$1) continuation;
            if ((swipeableState$snapTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                swipeableState$snapTo$2$emit$1.label -= Integer.MIN_VALUE;
                Object obj = swipeableState$snapTo$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = swipeableState$snapTo$2$emit$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    offset = SwipeableKt.getOffset(map, this.$targetValue);
                    if (offset == null) {
                        throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                    }
                    SwipeableState<T> swipeableState = this.this$0;
                    float floatValue = offset.floatValue();
                    swipeableState$snapTo$2$emit$1.L$0 = this;
                    swipeableState$snapTo$2$emit$1.label = 1;
                    snapInternalToOffset = swipeableState.snapInternalToOffset(floatValue, swipeableState$snapTo$2$emit$1);
                    if (snapInternalToOffset == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    swipeableState$snapTo$2 = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    swipeableState$snapTo$2 = (SwipeableState$snapTo$2) swipeableState$snapTo$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                swipeableState$snapTo$2.this$0.setCurrentValue(swipeableState$snapTo$2.$targetValue);
                return Unit.INSTANCE;
            }
        }
        swipeableState$snapTo$2$emit$1 = new SwipeableState$snapTo$2$emit$1(this, continuation);
        Object obj2 = swipeableState$snapTo$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = swipeableState$snapTo$2$emit$1.label;
        if (i != 0) {
        }
        swipeableState$snapTo$2.this$0.setCurrentValue(swipeableState$snapTo$2.$targetValue);
        return Unit.INSTANCE;
    }
}

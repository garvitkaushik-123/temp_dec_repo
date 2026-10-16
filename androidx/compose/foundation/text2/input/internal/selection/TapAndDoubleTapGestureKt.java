package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: TapAndDoubleTapGesture.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0007\u001a*\u0010\b\u001a\u00020\u0006*\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0080@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"awaitSecondDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "firstUp", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeUntilUp", "", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTapAndDoubleTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;", "onDoubleTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;Landroidx/compose/foundation/text2/input/internal/selection/TapOnPosition;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TapAndDoubleTapGestureKt {
    public static /* synthetic */ Object detectTapAndDoubleTap$default(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            tapOnPosition = null;
        }
        if ((i & 2) != 0) {
            tapOnPosition2 = null;
        }
        return detectTapAndDoubleTap(pointerInputScope, tapOnPosition, tapOnPosition2, continuation);
    }

    public static final Object detectTapAndDoubleTap(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2(pointerInputScope, tapOnPosition, tapOnPosition2, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitSecondDown(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation<? super PointerInputChange> continuation) {
        return awaitPointerEventScope.withTimeoutOrNull(awaitPointerEventScope.getViewConfiguration().getDoubleTapTimeoutMillis(), new TapAndDoubleTapGestureKt$awaitSecondDown$2(pointerInputChange, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[LOOP:0: B:11:0x0051->B:12:0x0053, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0042 -> B:10:0x0045). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object consumeUntilUp(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        TapAndDoubleTapGestureKt$consumeUntilUp$1 tapAndDoubleTapGestureKt$consumeUntilUp$1;
        int i;
        int size;
        int i2;
        int i3;
        int size2;
        if (continuation instanceof TapAndDoubleTapGestureKt$consumeUntilUp$1) {
            tapAndDoubleTapGestureKt$consumeUntilUp$1 = (TapAndDoubleTapGestureKt$consumeUntilUp$1) continuation;
            if ((tapAndDoubleTapGestureKt$consumeUntilUp$1.label & Integer.MIN_VALUE) != 0) {
                tapAndDoubleTapGestureKt$consumeUntilUp$1.label -= Integer.MIN_VALUE;
                Object obj = tapAndDoubleTapGestureKt$consumeUntilUp$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = tapAndDoubleTapGestureKt$consumeUntilUp$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    tapAndDoubleTapGestureKt$consumeUntilUp$1.L$0 = awaitPointerEventScope;
                    tapAndDoubleTapGestureKt$consumeUntilUp$1.label = 1;
                    obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, tapAndDoubleTapGestureKt$consumeUntilUp$1, 1, null);
                    if (obj == coroutine_suspended) {
                    }
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i2 = 0;
                    while (i3 < size) {
                    }
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    size2 = changes2.size();
                    while (i2 < size2) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                awaitPointerEventScope = (AwaitPointerEventScope) tapAndDoubleTapGestureKt$consumeUntilUp$1.L$0;
                ResultKt.throwOnFailure(obj);
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                i2 = 0;
                for (i3 = 0; i3 < size; i3++) {
                    changes3.get(i3).consume();
                }
                List<PointerInputChange> changes22 = pointerEvent2.getChanges();
                size2 = changes22.size();
                while (i2 < size2) {
                    if (changes22.get(i2).getPressed()) {
                        tapAndDoubleTapGestureKt$consumeUntilUp$1.L$0 = awaitPointerEventScope;
                        tapAndDoubleTapGestureKt$consumeUntilUp$1.label = 1;
                        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, tapAndDoubleTapGestureKt$consumeUntilUp$1, 1, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerEvent pointerEvent22 = (PointerEvent) obj;
                        List<PointerInputChange> changes32 = pointerEvent22.getChanges();
                        size = changes32.size();
                        i2 = 0;
                        while (i3 < size) {
                        }
                        List<PointerInputChange> changes222 = pointerEvent22.getChanges();
                        size2 = changes222.size();
                        while (i2 < size2) {
                        }
                    } else {
                        i2++;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        tapAndDoubleTapGestureKt$consumeUntilUp$1 = new TapAndDoubleTapGestureKt$consumeUntilUp$1(continuation);
        Object obj2 = tapAndDoubleTapGestureKt$consumeUntilUp$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = tapAndDoubleTapGestureKt$consumeUntilUp$1.label;
        if (i != 0) {
        }
    }
}

package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u0017H\u0082Hø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a!\u0010\u001b\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0014\u001aa\u0010\u001d\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f26\u0010 \u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0080@ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aY\u0010)\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0086@ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a!\u0010-\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0014\u001aK\u0010/\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0!H\u0080Hø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aY\u00104\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0086@ø\u0001\u0000¢\u0006\u0004\b5\u0010,\u001a!\u00106\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0004\b7\u0010\u0014\u001aa\u00108\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f26\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0080@ø\u0001\u0000¢\u0006\u0004\b9\u0010(\u001aY\u0010:\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010*\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&0!H\u0086@ø\u0001\u0000¢\u0006\u0004\b;\u0010,\u001a\u0080\u0001\u0010<\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010B\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010E\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010B\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u001101¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010F\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010G\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a\u0080\u0001\u0010H\u001a\u00020&*\u00020=2\u0014\b\u0002\u0010>\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&0\u00172\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0@26\u0010I\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\r¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020&0!H\u0086@¢\u0006\u0002\u0010D\u001a3\u0010J\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\bK\u0010\u001a\u001a]\u0010J\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u00172\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00180\u0017H\u0080Hø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a3\u0010O\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u001a\u001a\u001e\u0010Q\u001a\u00020\u0018*\u00020R2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001e\u0010U\u001a\u00020\r*\u00020V2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u00020\u0001*\u00020ZH\u0000\u001a3\u0010[\u001a\u00020\u0018*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020&0\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u001a\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n\"\u0010\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"BidirectionalPointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getBidirectionalPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "HorizontalPointerDirectionConfig", "getHorizontalPointerDirectionConfig", "VerticalPointerDirectionConfig", "getVerticalPointerDirectionConfig", "defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "pointerDirectionConfig", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/PointerDirectionConfig;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "toPointerDirectionConfig", "Landroidx/compose/foundation/gestures/Orientation;", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$HorizontalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: calculateDeltaChange-k-4lQ0M */
        public float mo670calculateDeltaChangek4lQ0M(long offset) {
            return Math.abs(Offset.m3822getXimpl(offset));
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: calculatePostSlopOffset-8S9VItk */
        public long mo671calculatePostSlopOffset8S9VItk(long totalPositionChange, float touchSlop) {
            return OffsetKt.Offset(Offset.m3822getXimpl(totalPositionChange) - (Math.signum(Offset.m3822getXimpl(totalPositionChange)) * touchSlop), Offset.m3823getYimpl(totalPositionChange));
        }
    };
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$VerticalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: calculateDeltaChange-k-4lQ0M */
        public float mo670calculateDeltaChangek4lQ0M(long offset) {
            return Math.abs(Offset.m3823getYimpl(offset));
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: calculatePostSlopOffset-8S9VItk */
        public long mo671calculatePostSlopOffset8S9VItk(long totalPositionChange, float touchSlop) {
            return OffsetKt.Offset(Offset.m3822getXimpl(totalPositionChange), Offset.m3823getYimpl(totalPositionChange) - (Math.signum(Offset.m3823getYimpl(totalPositionChange)) * touchSlop));
        }
    };
    private static final PointerDirectionConfig BidirectionalPointerDirectionConfig = new PointerDirectionConfig() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$BidirectionalPointerDirectionConfig$1
        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: calculateDeltaChange-k-4lQ0M, reason: not valid java name */
        public float mo670calculateDeltaChangek4lQ0M(long offset) {
            return Offset.m3820getDistanceimpl(offset);
        }

        @Override // androidx.compose.foundation.gestures.PointerDirectionConfig
        /* renamed from: calculatePostSlopOffset-8S9VItk, reason: not valid java name */
        public long mo671calculatePostSlopOffset8S9VItk(long totalPositionChange, float touchSlop) {
            return Offset.m3826minusMKHz9U(totalPositionChange, Offset.m3829timestuRUvjQ(Offset.m3817divtuRUvjQ(totalPositionChange, mo670calculateDeltaChangek4lQ0M(totalPositionChange)), touchSlop));
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:13:0x0191 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x013f -> B:17:0x00b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0184 -> B:11:0x018b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01ac -> B:16:0x0194). Please report as a decompilation issue!!! */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m659awaitTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        int i;
        PointerDirectionConfig pointerDirectionConfig;
        Ref.LongRef longRef;
        float f;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
        long m3838getZeroF1C5BW0;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef2;
        PointerDirectionConfig pointerDirectionConfig2;
        long j2;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        long j3;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i3;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
                int i4 = 1;
                PointerEventPass pointerEventPass2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    int m5286getTouchT8wyACA = PointerType.INSTANCE.m5286getTouchT8wyACA();
                    PointerDirectionConfig pointerDirectionConfig3 = BidirectionalPointerDirectionConfig;
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    float m668pointerSlopE8SPZFQ = m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), m5286getTouchT8wyACA);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = j;
                    pointerDirectionConfig = pointerDirectionConfig3;
                    longRef = longRef3;
                    f = m668pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    function22 = function2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j4 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.J$0;
                    f = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
                    pointerInputChange = (PointerInputChange) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
                    PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
                    Function2<? super PointerInputChange, ? super Offset, Unit> function23 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    pointerEventPass = null;
                    char c = 2;
                    DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = j4;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    function22 = function23;
                    longRef = longRef4;
                    pointerDirectionConfig = pointerDirectionConfig4;
                    if (!pointerInputChange.isConsumed()) {
                        return pointerEventPass;
                    }
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$13;
                    pointerEventPass2 = pointerEventPass;
                    i4 = 1;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                        long j5 = m3838getZeroF1C5BW0;
                        dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
                        obj3 = awaitPointerEvent$default;
                        longRef2 = longRef;
                        pointerDirectionConfig2 = pointerDirectionConfig;
                        j2 = j5;
                        PointerEvent pointerEvent = (PointerEvent) obj3;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        size = changes.size();
                        int i5 = 0;
                        i2 = 0;
                        while (true) {
                            if (i2 < size) {
                                pointerEventPass = pointerEventPass2;
                                j3 = j2;
                                obj = pointerEventPass;
                                break;
                            }
                            obj = changes.get(i2);
                            i3 = i2;
                            pointerEventPass = pointerEventPass2;
                            j3 = j2;
                            if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                                break;
                            }
                            i2 = i3 + 1;
                            j2 = j3;
                            pointerEventPass2 = pointerEventPass;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                            return pointerEventPass;
                        }
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i5 >= size2) {
                                    obj2 = pointerEventPass;
                                    break;
                                }
                                obj2 = changes2.get(i5);
                                if (((PointerInputChange) obj2).getPressed()) {
                                    break;
                                }
                                i5++;
                            }
                            PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                            if (pointerInputChange2 == null) {
                                return pointerEventPass;
                            }
                            longRef2.element = pointerInputChange2.getId();
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                            pointerDirectionConfig = pointerDirectionConfig2;
                            longRef = longRef2;
                            pointerEventPass2 = pointerEventPass;
                            i4 = 1;
                            m3838getZeroF1C5BW0 = j3;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = longRef;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, pointerEventPass2);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        } else {
                            long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j3, Offset.m3826minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition()));
                            if (pointerDirectionConfig2.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) < f) {
                                PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0 = function22;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1 = pointerDirectionConfig2;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3 = longRef2;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$4 = pointerInputChange;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0 = f;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.J$0 = m3827plusMKHz9U;
                                c = 2;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label = 2;
                                if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitTouchSlopOrCancellation$1) != coroutine_suspended) {
                                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                                    m3838getZeroF1C5BW0 = m3827plusMKHz9U;
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    longRef = longRef2;
                                    if (!pointerInputChange.isConsumed()) {
                                    }
                                }
                            } else {
                                function22.invoke(pointerInputChange, Offset.m3811boximpl(pointerDirectionConfig2.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f)));
                                if (pointerInputChange.isConsumed()) {
                                    return pointerInputChange;
                                }
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
                                m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                pointerDirectionConfig = pointerDirectionConfig2;
                                longRef = longRef2;
                                pointerEventPass2 = pointerEventPass;
                                i4 = 1;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = longRef;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = f;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                                dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, pointerEventPass2);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                long j6 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.J$0;
                f = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
                Ref.LongRef longRef5 = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
                pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
                Function2<? super PointerInputChange, ? super Offset, Unit> function24 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj3);
                longRef2 = longRef5;
                awaitPointerEventScope2 = awaitPointerEventScope4;
                j2 = j6;
                function22 = function24;
                PointerEvent pointerEvent2 = (PointerEvent) obj3;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                int i52 = 0;
                i2 = 0;
                while (true) {
                    if (i2 < size) {
                    }
                    i2 = i3 + 1;
                    j2 = j3;
                    pointerEventPass2 = pointerEventPass;
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    return pointerEventPass;
                }
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                }
            }
        }
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(continuation);
        Object obj32 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
        int i42 = 1;
        PointerEventPass pointerEventPass22 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0049 -> B:10:0x004c). Please report as a decompilation issue!!! */
    /* renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m665dragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$1;
        int i;
        PointerInputChange pointerInputChange;
        if (continuation instanceof DragGestureDetectorKt$drag$1) {
            dragGestureDetectorKt$drag$1 = (DragGestureDetectorKt$drag$1) continuation;
            if ((dragGestureDetectorKt$drag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$drag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$drag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                    dragGestureDetectorKt$drag$1.L$1 = function1;
                    dragGestureDetectorKt$drag$1.label = 1;
                    obj = m651awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
                    if (obj == coroutine_suspended) {
                    }
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Function1<? super PointerInputChange, Unit> function12 = (Function1) dragGestureDetectorKt$drag$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    function1 = function12;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            return Boxing.boxBoolean(true);
                        }
                        function1.invoke(pointerInputChange);
                        j = pointerInputChange.getId();
                        dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                        dragGestureDetectorKt$drag$1.L$1 = function1;
                        dragGestureDetectorKt$drag$1.label = 1;
                        obj = m651awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange == null) {
                            return Boxing.boxBoolean(false);
                        }
                    }
                }
            }
        }
        dragGestureDetectorKt$drag$1 = new DragGestureDetectorKt$drag$1(continuation);
        Object obj2 = dragGestureDetectorKt$drag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$drag$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cb, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0068 -> B:10:0x006d). Please report as a decompilation issue!!! */
    /* renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m651awaitDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$1;
        int i;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) {
            dragGestureDetectorKt$awaitDragOrCancellation$1 = (DragGestureDetectorKt$awaitDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitDragOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitDragOrCancellation$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitDragOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef3 = longRef2;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i3);
                        if (PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                            break;
                        }
                        i3++;
                    }
                    PointerInputChange pointerInputChange3 = pointerInputChange;
                    if (pointerInputChange3 == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i2 >= size2) {
                                    pointerInputChange2 = null;
                                    break;
                                }
                                pointerInputChange2 = changes2.get(i2);
                                if (pointerInputChange2.getPressed()) {
                                    break;
                                }
                                i2++;
                            }
                            PointerInputChange pointerInputChange4 = pointerInputChange2;
                            if (pointerInputChange4 != null) {
                                longRef3.element = pointerInputChange4.getId();
                                longRef = longRef3;
                            }
                        }
                        dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
                        dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.LongRef longRef4 = longRef;
                        obj = awaitPointerEvent$default;
                        longRef3 = longRef4;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i22 = 0;
                        int i32 = 0;
                        while (true) {
                            if (i32 < size3) {
                            }
                            i32++;
                        }
                        PointerInputChange pointerInputChange32 = pointerInputChange;
                        if (pointerInputChange32 == null) {
                            pointerInputChange32 = null;
                        }
                    }
                    if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                        return null;
                    }
                    return pointerInputChange32;
                }
                ResultKt.throwOnFailure(obj);
                if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                longRef = new Ref.LongRef();
                longRef.element = j;
                awaitPointerEventScope2 = awaitPointerEventScope;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                if (awaitPointerEvent$default != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitDragOrCancellation$1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m672invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m672invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$5(function1, function2, function02, function0, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m673invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m673invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function1, function0, function02, function2, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0191 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x013f -> B:17:0x00b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0184 -> B:11:0x018b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01b0 -> B:16:0x0194). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m662awaitVerticalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        int i;
        PointerDirectionConfig pointerDirectionConfig;
        Ref.LongRef longRef;
        float f;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
        long m3838getZeroF1C5BW0;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        Ref.LongRef longRef2;
        PointerDirectionConfig pointerDirectionConfig2;
        long j2;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        long j3;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i3;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
                int i4 = 1;
                PointerEventPass pointerEventPass2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    int m5286getTouchT8wyACA = PointerType.INSTANCE.m5286getTouchT8wyACA();
                    PointerDirectionConfig pointerDirectionConfig3 = VerticalPointerDirectionConfig;
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    float m668pointerSlopE8SPZFQ = m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), m5286getTouchT8wyACA);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = j;
                    pointerDirectionConfig = pointerDirectionConfig3;
                    longRef = longRef3;
                    f = m668pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    function22 = function2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j4 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.J$0;
                    f = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
                    pointerInputChange = (PointerInputChange) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
                    PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    pointerEventPass = null;
                    char c = 2;
                    DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = j4;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    function22 = function23;
                    longRef = longRef4;
                    pointerDirectionConfig = pointerDirectionConfig4;
                    if (!pointerInputChange.isConsumed()) {
                        return pointerEventPass;
                    }
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13;
                    pointerEventPass2 = pointerEventPass;
                    i4 = 1;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                        long j5 = m3838getZeroF1C5BW0;
                        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
                        obj3 = awaitPointerEvent$default;
                        longRef2 = longRef;
                        pointerDirectionConfig2 = pointerDirectionConfig;
                        j2 = j5;
                        PointerEvent pointerEvent = (PointerEvent) obj3;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        size = changes.size();
                        int i5 = 0;
                        i2 = 0;
                        while (true) {
                            if (i2 < size) {
                                pointerEventPass = pointerEventPass2;
                                j3 = j2;
                                obj = pointerEventPass;
                                break;
                            }
                            obj = changes.get(i2);
                            i3 = i2;
                            pointerEventPass = pointerEventPass2;
                            j3 = j2;
                            if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                                break;
                            }
                            i2 = i3 + 1;
                            j2 = j3;
                            pointerEventPass2 = pointerEventPass;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                            return pointerEventPass;
                        }
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i5 >= size2) {
                                    obj2 = pointerEventPass;
                                    break;
                                }
                                obj2 = changes2.get(i5);
                                if (((PointerInputChange) obj2).getPressed()) {
                                    break;
                                }
                                i5++;
                            }
                            PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                            if (pointerInputChange2 == null) {
                                return pointerEventPass;
                            }
                            longRef2.element = pointerInputChange2.getId();
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                            pointerDirectionConfig = pointerDirectionConfig2;
                            longRef = longRef2;
                            pointerEventPass2 = pointerEventPass;
                            i4 = 1;
                            m3838getZeroF1C5BW0 = j3;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = longRef;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        } else {
                            long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j3, Offset.m3826minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition()));
                            if (pointerDirectionConfig2.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) >= f) {
                                function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m3823getYimpl(pointerDirectionConfig2.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f))));
                                if (pointerInputChange.isConsumed()) {
                                    return pointerInputChange;
                                }
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                                m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                pointerDirectionConfig = pointerDirectionConfig2;
                                longRef = longRef2;
                                pointerEventPass2 = pointerEventPass;
                                i4 = 1;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = longRef;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = f;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            } else {
                                PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0 = function22;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1 = pointerDirectionConfig2;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3 = longRef2;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$4 = pointerInputChange;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0 = f;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.J$0 = m3827plusMKHz9U;
                                c = 2;
                                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label = 2;
                                if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) != coroutine_suspended) {
                                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
                                    m3838getZeroF1C5BW0 = m3827plusMKHz9U;
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    longRef = longRef2;
                                    if (!pointerInputChange.isConsumed()) {
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                long j6 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.J$0;
                f = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
                Ref.LongRef longRef5 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
                pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
                Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj3);
                longRef2 = longRef5;
                awaitPointerEventScope2 = awaitPointerEventScope4;
                j2 = j6;
                function22 = function24;
                PointerEvent pointerEvent2 = (PointerEvent) obj3;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                int i52 = 0;
                i2 = 0;
                while (true) {
                    if (i2 < size) {
                    }
                    i2 = i3 + 1;
                    j2 = j3;
                    pointerEventPass2 = pointerEventPass;
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    return pointerEventPass;
                }
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(continuation);
        Object obj32 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
        int i42 = 1;
        PointerEventPass pointerEventPass22 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0141 -> B:17:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0186 -> B:11:0x018d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01b2 -> B:16:0x0196). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m661awaitVerticalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
        int i2;
        float f;
        Ref.LongRef longRef;
        PointerDirectionConfig pointerDirectionConfig;
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12;
        long m3838getZeroF1C5BW0;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        Ref.LongRef longRef2;
        float f2;
        long j2;
        int size;
        int i3;
        PointerEventPass pointerEventPass;
        long j3;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i4;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj3 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
                int i5 = 1;
                PointerEventPass pointerEventPass2 = null;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    PointerDirectionConfig pointerDirectionConfig2 = VerticalPointerDirectionConfig;
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    float m668pointerSlopE8SPZFQ = m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = j;
                    f = m668pointerSlopE8SPZFQ;
                    longRef = longRef3;
                    pointerDirectionConfig = pointerDirectionConfig2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    function22 = function2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j4 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.J$0;
                    float f3 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
                    pointerInputChange = (PointerInputChange) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
                    PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    pointerEventPass = null;
                    char c = 2;
                    DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = j4;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    function22 = function23;
                    longRef = longRef4;
                    f = f3;
                    pointerDirectionConfig = pointerDirectionConfig3;
                    if (!pointerInputChange.isConsumed()) {
                        return pointerEventPass;
                    }
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$13;
                    pointerEventPass2 = pointerEventPass;
                    i5 = 1;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                        long j5 = m3838getZeroF1C5BW0;
                        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12;
                        obj3 = awaitPointerEvent$default;
                        longRef2 = longRef;
                        f2 = f;
                        j2 = j5;
                        PointerEvent pointerEvent = (PointerEvent) obj3;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        size = changes.size();
                        int i6 = 0;
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                pointerEventPass = pointerEventPass2;
                                j3 = j2;
                                obj = pointerEventPass;
                                break;
                            }
                            obj = changes.get(i3);
                            i4 = i3;
                            pointerEventPass = pointerEventPass2;
                            j3 = j2;
                            if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                                break;
                            }
                            i3 = i4 + 1;
                            j2 = j3;
                            pointerEventPass2 = pointerEventPass;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                            return pointerEventPass;
                        }
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i6 >= size2) {
                                    obj2 = pointerEventPass;
                                    break;
                                }
                                obj2 = changes2.get(i6);
                                if (((PointerInputChange) obj2).getPressed()) {
                                    break;
                                }
                                i6++;
                            }
                            PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                            if (pointerInputChange2 == null) {
                                return pointerEventPass;
                            }
                            longRef2.element = pointerInputChange2.getId();
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
                            f = f2;
                            longRef = longRef2;
                            pointerEventPass2 = pointerEventPass;
                            i5 = 1;
                            m3838getZeroF1C5BW0 = j3;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = longRef;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = f;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = i5;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        } else {
                            long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j3, Offset.m3826minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition()));
                            if (pointerDirectionConfig.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) >= f2) {
                                function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m3823getYimpl(pointerDirectionConfig.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f2))));
                                if (pointerInputChange.isConsumed()) {
                                    return pointerInputChange;
                                }
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
                                m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                f = f2;
                                longRef = longRef2;
                                pointerEventPass2 = pointerEventPass;
                                i5 = 1;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$0 = function22;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$3 = longRef;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.F$0 = f;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12.label = i5;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            } else {
                                PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = pointerDirectionConfig;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = longRef2;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerInputChange;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = f2;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.J$0 = m3827plusMKHz9U;
                                c = 2;
                                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = 2;
                                if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) != coroutine_suspended) {
                                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
                                    m3838getZeroF1C5BW0 = m3827plusMKHz9U;
                                    f = f2;
                                    longRef = longRef2;
                                    if (!pointerInputChange.isConsumed()) {
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                long j6 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.J$0;
                float f4 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
                Ref.LongRef longRef5 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
                PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
                Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj3);
                f2 = f4;
                pointerDirectionConfig = pointerDirectionConfig4;
                longRef2 = longRef5;
                awaitPointerEventScope2 = awaitPointerEventScope4;
                j2 = j6;
                function22 = function24;
                PointerEvent pointerEvent2 = (PointerEvent) obj3;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                int i62 = 0;
                i3 = 0;
                while (true) {
                    if (i3 < size) {
                    }
                    i3 = i4 + 1;
                    j2 = j3;
                    pointerEventPass2 = pointerEventPass;
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    return pointerEventPass;
                }
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(continuation);
        Object obj32 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
        int i52 = 1;
        PointerEventPass pointerEventPass22 = null;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ea, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m3823getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f) == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007a -> B:10:0x007f). Please report as a decompilation issue!!! */
    /* renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m669verticalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$1;
        int i;
        long j2;
        AwaitPointerEventScope awaitPointerEventScope2;
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$12;
        Function1<? super PointerInputChange, Unit> function12;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$verticalDrag$1) {
            dragGestureDetectorKt$verticalDrag$1 = (DragGestureDetectorKt$verticalDrag$1) continuation;
            if ((dragGestureDetectorKt$verticalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$verticalDrag$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$verticalDrag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$verticalDrag$1.label;
                int i2 = 1;
                PointerInputChange pointerInputChange3 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    j2 = j;
                    if (!m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
                        function12 = function1;
                        longRef = new Ref.LongRef();
                        longRef.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$verticalDrag$12.L$2 = awaitPointerEventScope3;
                        dragGestureDetectorKt$verticalDrag$12.L$3 = longRef;
                        dragGestureDetectorKt$verticalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, null, dragGestureDetectorKt$verticalDrag$12, i2, null);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                    return Boxing.boxBoolean(pointerInputChange3 == null);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$verticalDrag$1.L$3;
                awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$2;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$1;
                Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$verticalDrag$1.L$0;
                ResultKt.throwOnFailure(obj);
                dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
                function12 = function13;
                longRef = longRef2;
                PointerEvent pointerEvent = (PointerEvent) obj;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i3);
                    if (PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange;
                if (pointerInputChange4 == null) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                        List<PointerInputChange> changes2 = pointerEvent.getChanges();
                        int size2 = changes2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                pointerInputChange2 = null;
                                break;
                            }
                            pointerInputChange2 = changes2.get(i4);
                            if (pointerInputChange2.getPressed()) {
                                break;
                            }
                            i4++;
                        }
                        PointerInputChange pointerInputChange5 = pointerInputChange2;
                        if (pointerInputChange5 != null) {
                            longRef.element = pointerInputChange5.getId();
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            i2 = 1;
                            dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                            dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                            dragGestureDetectorKt$verticalDrag$12.L$2 = awaitPointerEventScope3;
                            dragGestureDetectorKt$verticalDrag$12.L$3 = longRef;
                            dragGestureDetectorKt$verticalDrag$12.label = i2;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, null, dragGestureDetectorKt$verticalDrag$12, i2, null);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            awaitPointerEventScope4 = awaitPointerEventScope2;
                            obj = awaitPointerEvent$default;
                        }
                    }
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i32 = 0;
                    while (true) {
                        if (i32 < size3) {
                        }
                        i32++;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
                if (pointerInputChange42 != null && !pointerInputChange42.isConsumed()) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
                        pointerInputChange3 = pointerInputChange42;
                    } else {
                        function12.invoke(pointerInputChange42);
                        awaitPointerEventScope2 = awaitPointerEventScope4;
                        j2 = pointerInputChange42.getId();
                        i2 = 1;
                        longRef = new Ref.LongRef();
                        longRef.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$verticalDrag$12.L$2 = awaitPointerEventScope3;
                        dragGestureDetectorKt$verticalDrag$12.L$3 = longRef;
                        dragGestureDetectorKt$verticalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, null, dragGestureDetectorKt$verticalDrag$12, i2, null);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                }
                return Boxing.boxBoolean(pointerInputChange3 == null);
            }
        }
        dragGestureDetectorKt$verticalDrag$1 = new DragGestureDetectorKt$verticalDrag$1(continuation);
        Object obj2 = dragGestureDetectorKt$verticalDrag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$verticalDrag$1.label;
        int i22 = 1;
        PointerInputChange pointerInputChange32 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d5, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m3823getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0068 -> B:10:0x006d). Please report as a decompilation issue!!! */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m660awaitVerticalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
        int i;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef3 = longRef2;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 < size) {
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i2);
                        if (PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                            break;
                        }
                        i2++;
                    }
                    PointerInputChange pointerInputChange3 = pointerInputChange;
                    if (pointerInputChange3 == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (r9 >= size2) {
                                    pointerInputChange2 = null;
                                    break;
                                }
                                pointerInputChange2 = changes2.get(r9);
                                if (pointerInputChange2.getPressed()) {
                                    break;
                                }
                                r9++;
                            }
                            PointerInputChange pointerInputChange4 = pointerInputChange2;
                            if (pointerInputChange4 != null) {
                                longRef3.element = pointerInputChange4.getId();
                                longRef = longRef3;
                            }
                        }
                        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
                        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.LongRef longRef4 = longRef;
                        obj = awaitPointerEvent$default;
                        longRef3 = longRef4;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i22 = 0;
                        while (true) {
                            if (i22 < size3) {
                            }
                            i22++;
                        }
                        PointerInputChange pointerInputChange32 = pointerInputChange;
                        if (pointerInputChange32 == null) {
                            pointerInputChange32 = null;
                        }
                    }
                    if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                        return null;
                    }
                    return pointerInputChange32;
                }
                ResultKt.throwOnFailure(obj);
                if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                longRef = new Ref.LongRef();
                longRef.element = j;
                awaitPointerEventScope2 = awaitPointerEventScope;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
                if (awaitPointerEvent$default != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m675invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m675invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectVerticalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0191 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x013f -> B:17:0x00b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0184 -> B:11:0x018b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01b0 -> B:16:0x0194). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m655awaitHorizontalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        int i;
        PointerDirectionConfig pointerDirectionConfig;
        Ref.LongRef longRef;
        float f;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
        long m3838getZeroF1C5BW0;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        Ref.LongRef longRef2;
        PointerDirectionConfig pointerDirectionConfig2;
        long j2;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        long j3;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i3;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
                int i4 = 1;
                PointerEventPass pointerEventPass2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    int m5286getTouchT8wyACA = PointerType.INSTANCE.m5286getTouchT8wyACA();
                    PointerDirectionConfig pointerDirectionConfig3 = HorizontalPointerDirectionConfig;
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    float m668pointerSlopE8SPZFQ = m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), m5286getTouchT8wyACA);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = j;
                    pointerDirectionConfig = pointerDirectionConfig3;
                    longRef = longRef3;
                    f = m668pointerSlopE8SPZFQ;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    function22 = function2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j4 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.J$0;
                    f = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
                    pointerInputChange = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
                    PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    pointerEventPass = null;
                    char c = 2;
                    DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = j4;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    function22 = function23;
                    longRef = longRef4;
                    pointerDirectionConfig = pointerDirectionConfig4;
                    if (!pointerInputChange.isConsumed()) {
                        return pointerEventPass;
                    }
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13;
                    pointerEventPass2 = pointerEventPass;
                    i4 = 1;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                        long j5 = m3838getZeroF1C5BW0;
                        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
                        obj3 = awaitPointerEvent$default;
                        longRef2 = longRef;
                        pointerDirectionConfig2 = pointerDirectionConfig;
                        j2 = j5;
                        PointerEvent pointerEvent = (PointerEvent) obj3;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        size = changes.size();
                        int i5 = 0;
                        i2 = 0;
                        while (true) {
                            if (i2 < size) {
                                pointerEventPass = pointerEventPass2;
                                j3 = j2;
                                obj = pointerEventPass;
                                break;
                            }
                            obj = changes.get(i2);
                            i3 = i2;
                            pointerEventPass = pointerEventPass2;
                            j3 = j2;
                            if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                                break;
                            }
                            i2 = i3 + 1;
                            j2 = j3;
                            pointerEventPass2 = pointerEventPass;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                            return pointerEventPass;
                        }
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i5 >= size2) {
                                    obj2 = pointerEventPass;
                                    break;
                                }
                                obj2 = changes2.get(i5);
                                if (((PointerInputChange) obj2).getPressed()) {
                                    break;
                                }
                                i5++;
                            }
                            PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                            if (pointerInputChange2 == null) {
                                return pointerEventPass;
                            }
                            longRef2.element = pointerInputChange2.getId();
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                            pointerDirectionConfig = pointerDirectionConfig2;
                            longRef = longRef2;
                            pointerEventPass2 = pointerEventPass;
                            i4 = 1;
                            m3838getZeroF1C5BW0 = j3;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = longRef;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        } else {
                            long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j3, Offset.m3826minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition()));
                            if (pointerDirectionConfig2.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) >= f) {
                                function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m3822getXimpl(pointerDirectionConfig2.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f))));
                                if (pointerInputChange.isConsumed()) {
                                    return pointerInputChange;
                                }
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                                m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                pointerDirectionConfig = pointerDirectionConfig2;
                                longRef = longRef2;
                                pointerEventPass2 = pointerEventPass;
                                i4 = 1;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = longRef;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = f;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            } else {
                                PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0 = function22;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1 = pointerDirectionConfig2;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3 = longRef2;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$4 = pointerInputChange;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0 = f;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.J$0 = m3827plusMKHz9U;
                                c = 2;
                                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label = 2;
                                if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) != coroutine_suspended) {
                                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
                                    m3838getZeroF1C5BW0 = m3827plusMKHz9U;
                                    pointerDirectionConfig = pointerDirectionConfig2;
                                    longRef = longRef2;
                                    if (!pointerInputChange.isConsumed()) {
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                long j6 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.J$0;
                f = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
                Ref.LongRef longRef5 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
                pointerDirectionConfig2 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
                Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj3);
                longRef2 = longRef5;
                awaitPointerEventScope2 = awaitPointerEventScope4;
                j2 = j6;
                function22 = function24;
                PointerEvent pointerEvent2 = (PointerEvent) obj3;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                int i52 = 0;
                i2 = 0;
                while (true) {
                    if (i2 < size) {
                    }
                    i2 = i3 + 1;
                    j2 = j3;
                    pointerEventPass2 = pointerEventPass;
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    return pointerEventPass;
                }
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(continuation);
        Object obj32 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
        int i42 = 1;
        PointerEventPass pointerEventPass22 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0141 -> B:17:0x00b4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0186 -> B:11:0x018d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01b2 -> B:16:0x0196). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m654awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
        int i2;
        float f;
        Ref.LongRef longRef;
        PointerDirectionConfig pointerDirectionConfig;
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12;
        long m3838getZeroF1C5BW0;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        Ref.LongRef longRef2;
        float f2;
        long j2;
        int size;
        int i3;
        PointerEventPass pointerEventPass;
        long j3;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i4;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj3 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
                int i5 = 1;
                PointerEventPass pointerEventPass2 = null;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    PointerDirectionConfig pointerDirectionConfig2 = HorizontalPointerDirectionConfig;
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    float m668pointerSlopE8SPZFQ = m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = j;
                    f = m668pointerSlopE8SPZFQ;
                    longRef = longRef3;
                    pointerDirectionConfig = pointerDirectionConfig2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    function22 = function2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j4 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.J$0;
                    float f3 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
                    pointerInputChange = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
                    PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
                    Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    pointerEventPass = null;
                    char c = 2;
                    DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
                    m3838getZeroF1C5BW0 = j4;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    function22 = function23;
                    longRef = longRef4;
                    f = f3;
                    pointerDirectionConfig = pointerDirectionConfig3;
                    if (!pointerInputChange.isConsumed()) {
                        return pointerEventPass;
                    }
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$13;
                    pointerEventPass2 = pointerEventPass;
                    i5 = 1;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = i5;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                        long j5 = m3838getZeroF1C5BW0;
                        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12;
                        obj3 = awaitPointerEvent$default;
                        longRef2 = longRef;
                        f2 = f;
                        j2 = j5;
                        PointerEvent pointerEvent = (PointerEvent) obj3;
                        List<PointerInputChange> changes = pointerEvent.getChanges();
                        size = changes.size();
                        int i6 = 0;
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                pointerEventPass = pointerEventPass2;
                                j3 = j2;
                                obj = pointerEventPass;
                                break;
                            }
                            obj = changes.get(i3);
                            i4 = i3;
                            pointerEventPass = pointerEventPass2;
                            j3 = j2;
                            if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                                break;
                            }
                            i3 = i4 + 1;
                            j2 = j3;
                            pointerEventPass2 = pointerEventPass;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                            return pointerEventPass;
                        }
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i6 >= size2) {
                                    obj2 = pointerEventPass;
                                    break;
                                }
                                obj2 = changes2.get(i6);
                                if (((PointerInputChange) obj2).getPressed()) {
                                    break;
                                }
                                i6++;
                            }
                            PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                            if (pointerInputChange2 == null) {
                                return pointerEventPass;
                            }
                            longRef2.element = pointerInputChange2.getId();
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
                            f = f2;
                            longRef = longRef2;
                            pointerEventPass2 = pointerEventPass;
                            i5 = 1;
                            m3838getZeroF1C5BW0 = j3;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = function22;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = longRef;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = f;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = i5;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        } else {
                            long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j3, Offset.m3826minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition()));
                            if (pointerDirectionConfig.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) >= f2) {
                                function22.invoke(pointerInputChange, Boxing.boxFloat(Offset.m3822getXimpl(pointerDirectionConfig.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f2))));
                                if (pointerInputChange.isConsumed()) {
                                    return pointerInputChange;
                                }
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
                                m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                f = f2;
                                longRef = longRef2;
                                pointerEventPass2 = pointerEventPass;
                                i5 = 1;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = function22;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = longRef;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.L$4 = pointerEventPass2;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = f;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12.label = i5;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            } else {
                                PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = pointerDirectionConfig;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = longRef2;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerInputChange;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = f2;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.J$0 = m3827plusMKHz9U;
                                c = 2;
                                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = 2;
                                if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) != coroutine_suspended) {
                                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$13 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
                                    m3838getZeroF1C5BW0 = m3827plusMKHz9U;
                                    f = f2;
                                    longRef = longRef2;
                                    if (!pointerInputChange.isConsumed()) {
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                long j6 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.J$0;
                float f4 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
                Ref.LongRef longRef5 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
                PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
                Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj3);
                f2 = f4;
                pointerDirectionConfig = pointerDirectionConfig4;
                longRef2 = longRef5;
                awaitPointerEventScope2 = awaitPointerEventScope4;
                j2 = j6;
                function22 = function24;
                PointerEvent pointerEvent2 = (PointerEvent) obj3;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                int i62 = 0;
                i3 = 0;
                while (true) {
                    if (i3 < size) {
                    }
                    i3 = i4 + 1;
                    j2 = j3;
                    pointerEventPass2 = pointerEventPass;
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    return pointerEventPass;
                }
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(continuation);
        Object obj32 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
        int i52 = 1;
        PointerEventPass pointerEventPass22 = null;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ea, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m3822getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f) == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007a -> B:10:0x007f). Please report as a decompilation issue!!! */
    /* renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m666horizontalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$1;
        int i;
        long j2;
        AwaitPointerEventScope awaitPointerEventScope2;
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$12;
        Function1<? super PointerInputChange, Unit> function12;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$horizontalDrag$1) {
            dragGestureDetectorKt$horizontalDrag$1 = (DragGestureDetectorKt$horizontalDrag$1) continuation;
            if ((dragGestureDetectorKt$horizontalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$horizontalDrag$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$horizontalDrag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$horizontalDrag$1.label;
                int i2 = 1;
                PointerInputChange pointerInputChange3 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    j2 = j;
                    if (!m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
                        function12 = function1;
                        longRef = new Ref.LongRef();
                        longRef.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$horizontalDrag$12.L$2 = awaitPointerEventScope3;
                        dragGestureDetectorKt$horizontalDrag$12.L$3 = longRef;
                        dragGestureDetectorKt$horizontalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, null, dragGestureDetectorKt$horizontalDrag$12, i2, null);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                    return Boxing.boxBoolean(pointerInputChange3 == null);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$horizontalDrag$1.L$3;
                awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$2;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$1;
                Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$horizontalDrag$1.L$0;
                ResultKt.throwOnFailure(obj);
                dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
                function12 = function13;
                longRef = longRef2;
                PointerEvent pointerEvent = (PointerEvent) obj;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i3);
                    if (PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange;
                if (pointerInputChange4 == null) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                        List<PointerInputChange> changes2 = pointerEvent.getChanges();
                        int size2 = changes2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                pointerInputChange2 = null;
                                break;
                            }
                            pointerInputChange2 = changes2.get(i4);
                            if (pointerInputChange2.getPressed()) {
                                break;
                            }
                            i4++;
                        }
                        PointerInputChange pointerInputChange5 = pointerInputChange2;
                        if (pointerInputChange5 != null) {
                            longRef.element = pointerInputChange5.getId();
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            i2 = 1;
                            dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                            dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                            dragGestureDetectorKt$horizontalDrag$12.L$2 = awaitPointerEventScope3;
                            dragGestureDetectorKt$horizontalDrag$12.L$3 = longRef;
                            dragGestureDetectorKt$horizontalDrag$12.label = i2;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, null, dragGestureDetectorKt$horizontalDrag$12, i2, null);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            awaitPointerEventScope4 = awaitPointerEventScope2;
                            obj = awaitPointerEvent$default;
                        }
                    }
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i32 = 0;
                    while (true) {
                        if (i32 < size3) {
                        }
                        i32++;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
                if (pointerInputChange42 != null && !pointerInputChange42.isConsumed()) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
                        pointerInputChange3 = pointerInputChange42;
                    } else {
                        function12.invoke(pointerInputChange42);
                        awaitPointerEventScope2 = awaitPointerEventScope4;
                        j2 = pointerInputChange42.getId();
                        i2 = 1;
                        longRef = new Ref.LongRef();
                        longRef.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                        dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorKt$horizontalDrag$12.L$2 = awaitPointerEventScope3;
                        dragGestureDetectorKt$horizontalDrag$12.L$3 = longRef;
                        dragGestureDetectorKt$horizontalDrag$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, null, dragGestureDetectorKt$horizontalDrag$12, i2, null);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                }
                return Boxing.boxBoolean(pointerInputChange3 == null);
            }
        }
        dragGestureDetectorKt$horizontalDrag$1 = new DragGestureDetectorKt$horizontalDrag$1(continuation);
        Object obj2 = dragGestureDetectorKt$horizontalDrag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$horizontalDrag$1.label;
        int i22 = 1;
        PointerInputChange pointerInputChange32 = null;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d5, code lost:
    
        if ((androidx.compose.ui.geometry.Offset.m3822getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0068 -> B:10:0x006d). Please report as a decompilation issue!!! */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m653awaitHorizontalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
        int i;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object awaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef3 = longRef2;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 < size) {
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i2);
                        if (PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                            break;
                        }
                        i2++;
                    }
                    PointerInputChange pointerInputChange3 = pointerInputChange;
                    if (pointerInputChange3 == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (r9 >= size2) {
                                    pointerInputChange2 = null;
                                    break;
                                }
                                pointerInputChange2 = changes2.get(r9);
                                if (pointerInputChange2.getPressed()) {
                                    break;
                                }
                                r9++;
                            }
                            PointerInputChange pointerInputChange4 = pointerInputChange2;
                            if (pointerInputChange4 != null) {
                                longRef3.element = pointerInputChange4.getId();
                                longRef = longRef3;
                            }
                        }
                        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
                        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.LongRef longRef4 = longRef;
                        obj = awaitPointerEvent$default;
                        longRef3 = longRef4;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i22 = 0;
                        while (true) {
                            if (i22 < size3) {
                            }
                            i22++;
                        }
                        PointerInputChange pointerInputChange32 = pointerInputChange;
                        if (pointerInputChange32 == null) {
                            pointerInputChange32 = null;
                        }
                    }
                    if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                        return null;
                    }
                    return pointerInputChange32;
                }
                ResultKt.throwOnFailure(obj);
                if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                longRef = new Ref.LongRef();
                longRef.element = j;
                awaitPointerEventScope2 = awaitPointerEventScope;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
                if (awaitPointerEvent$default != coroutine_suspended) {
                }
            }
        }
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$2
                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m674invokek4lQ0M(long j) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m674invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectHorizontalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0105, code lost:
    
        if (r0 != false) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008e -> B:10:0x0094). Please report as a decompilation issue!!! */
    /* renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m663dragVnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Boolean> function12, Function1<? super PointerInputChange, Boolean> function13, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$2;
        int i;
        long j2;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Boolean> function14;
        Function1<? super PointerInputChange, Boolean> function15;
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$22;
        Function1<? super PointerInputChange, Unit> function16;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object awaitPointerEvent$default;
        PointerEventPass pointerEventPass;
        Object obj;
        Object obj2;
        PointerInputChange pointerInputChange;
        int i2;
        if (continuation instanceof DragGestureDetectorKt$drag$2) {
            dragGestureDetectorKt$drag$2 = (DragGestureDetectorKt$drag$2) continuation;
            if ((dragGestureDetectorKt$drag$2.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$2.label -= Integer.MIN_VALUE;
                Object obj3 = dragGestureDetectorKt$drag$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$drag$2.label;
                int i3 = 1;
                PointerEventPass pointerEventPass2 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    j2 = j;
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
                        return null;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    function14 = function12;
                    function15 = function13;
                    dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
                    function16 = function1;
                    longRef = new Ref.LongRef();
                    longRef.element = j2;
                    awaitPointerEventScope3 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$1 = function16;
                    dragGestureDetectorKt$drag$22.L$2 = function14;
                    dragGestureDetectorKt$drag$22.L$3 = function15;
                    dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                    dragGestureDetectorKt$drag$22.L$5 = longRef;
                    dragGestureDetectorKt$drag$22.label = i3;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$drag$2.L$5;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$4;
                    Function1<? super PointerInputChange, Boolean> function17 = (Function1) dragGestureDetectorKt$drag$2.L$3;
                    Function1<? super PointerInputChange, Boolean> function18 = (Function1) dragGestureDetectorKt$drag$2.L$2;
                    Function1<? super PointerInputChange, Unit> function19 = (Function1) dragGestureDetectorKt$drag$2.L$1;
                    AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$0;
                    ResultKt.throwOnFailure(obj3);
                    dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
                    function16 = function19;
                    Ref.LongRef longRef3 = longRef2;
                    function14 = function18;
                    function15 = function17;
                    PointerEvent pointerEvent = (PointerEvent) obj3;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 < size) {
                            pointerEventPass = pointerEventPass2;
                            obj = pointerEventPass;
                            break;
                        }
                        obj = changes.get(i4);
                        pointerEventPass = pointerEventPass2;
                        i2 = i4;
                        if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef3.element)) {
                            break;
                        }
                        i4 = i2 + 1;
                        pointerEventPass2 = pointerEventPass;
                    }
                    PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    obj2 = pointerEventPass;
                                    break;
                                }
                                obj2 = changes2.get(i5);
                                if (((PointerInputChange) obj2).getPressed()) {
                                    break;
                                }
                                i5++;
                            }
                            PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                            pointerInputChange = pointerInputChange2;
                            if (pointerInputChange3 != null) {
                                longRef3.element = pointerInputChange3.getId();
                                awaitPointerEventScope2 = awaitPointerEventScope4;
                                pointerEventPass2 = pointerEventPass;
                                i3 = 1;
                                longRef = longRef3;
                                dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                                dragGestureDetectorKt$drag$22.L$1 = function16;
                                dragGestureDetectorKt$drag$22.L$2 = function14;
                                dragGestureDetectorKt$drag$22.L$3 = function15;
                                dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                                dragGestureDetectorKt$drag$22.L$5 = longRef;
                                dragGestureDetectorKt$drag$22.label = i3;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
                                if (awaitPointerEvent$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Ref.LongRef longRef4 = longRef;
                                awaitPointerEventScope4 = awaitPointerEventScope2;
                                obj3 = awaitPointerEvent$default;
                                longRef3 = longRef4;
                            }
                        } else {
                            boolean booleanValue = function14.invoke(pointerInputChange2).booleanValue();
                            pointerInputChange = pointerInputChange2;
                        }
                        PointerEvent pointerEvent2 = (PointerEvent) obj3;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i42 = 0;
                        while (true) {
                            if (i42 < size3) {
                            }
                            i42 = i2 + 1;
                            pointerEventPass2 = pointerEventPass;
                        }
                        PointerInputChange pointerInputChange22 = (PointerInputChange) obj;
                        if (pointerInputChange22 == null) {
                            pointerInputChange = pointerEventPass;
                        }
                    }
                    if (pointerInputChange == 0 || function15.invoke(pointerInputChange).booleanValue()) {
                        return pointerEventPass;
                    }
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                        return pointerInputChange;
                    }
                    function16.invoke(pointerInputChange);
                    j2 = pointerInputChange.getId();
                    awaitPointerEventScope2 = awaitPointerEventScope4;
                    pointerEventPass2 = pointerEventPass;
                    i3 = 1;
                    longRef = new Ref.LongRef();
                    longRef.element = j2;
                    awaitPointerEventScope3 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$drag$22.L$1 = function16;
                    dragGestureDetectorKt$drag$22.L$2 = function14;
                    dragGestureDetectorKt$drag$22.L$3 = function15;
                    dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                    dragGestureDetectorKt$drag$22.L$5 = longRef;
                    dragGestureDetectorKt$drag$22.label = i3;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                }
            }
        }
        dragGestureDetectorKt$drag$2 = new DragGestureDetectorKt$drag$2(continuation);
        Object obj32 = dragGestureDetectorKt$drag$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$drag$2.label;
        int i32 = 1;
        PointerEventPass pointerEventPass22 = null;
        if (i != 0) {
        }
    }

    /* renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m664dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Boolean> function12, Function1<? super PointerInputChange, Boolean> function13, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        long j2 = j;
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = j2;
            while (true) {
                PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i2);
                    if (Boolean.valueOf(PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                        break;
                    }
                    i2++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.getId();
                } else if (function12.invoke(pointerInputChange2).booleanValue()) {
                    break;
                }
            }
            if (pointerInputChange2 == null || function13.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            j2 = pointerInputChange2.getId();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m652awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            PointerInputChange pointerInputChange3 = null;
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                longRef.element = pointerInputChange5.getId();
            } else if (function1.invoke(pointerInputChange2).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0137 -> B:17:0x00b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x017b -> B:11:0x0181). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01a2 -> B:16:0x018b). Please report as a decompilation issue!!! */
    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m657awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, PointerDirectionConfig pointerDirectionConfig, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        int i2;
        long m3838getZeroF1C5BW0;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        PointerDirectionConfig pointerDirectionConfig2;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$12;
        float f;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        long j2;
        Function2<? super PointerInputChange, ? super Offset, Unit> function23;
        Ref.LongRef longRef2;
        List<PointerInputChange> changes;
        int size;
        int i3;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i4;
        List<PointerInputChange> list;
        int i5;
        Object awaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj3 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label;
                int i6 = 1;
                PointerEventPass pointerEventPass = null;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj3);
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    float m668pointerSlopE8SPZFQ = m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = j;
                    m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    longRef = longRef3;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    pointerDirectionConfig2 = pointerDirectionConfig;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
                    f = m668pointerSlopE8SPZFQ;
                    function22 = function2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = function22;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j3 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.J$0;
                    float f2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
                    PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$4;
                    Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
                    Function2<? super PointerInputChange, ? super Offset, Unit> function24 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
                    PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    char c = 2;
                    long j4 = j3;
                    pointerDirectionConfig2 = pointerDirectionConfig3;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
                    f = f2;
                    longRef = longRef4;
                    function23 = function24;
                    PointerEventPass pointerEventPass2 = null;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    if (!pointerInputChange2.isConsumed()) {
                        return pointerEventPass2;
                    }
                    pointerEventPass = pointerEventPass2;
                    function22 = function23;
                    m3838getZeroF1C5BW0 = j4;
                    i6 = 1;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = function22;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = longRef;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = f;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, pointerEventPass);
                    if (awaitPointerEvent$default != coroutine_suspended) {
                        j2 = m3838getZeroF1C5BW0;
                        function23 = function22;
                        longRef2 = longRef;
                        obj3 = awaitPointerEvent$default;
                        long j5 = j2;
                        PointerEvent pointerEvent = (PointerEvent) obj3;
                        changes = pointerEvent.getChanges();
                        size = changes.size();
                        int i7 = 0;
                        i3 = 0;
                        while (true) {
                            if (i3 < size) {
                                obj = pointerEventPass;
                                break;
                            }
                            obj = changes.get(i3);
                            i4 = i3;
                            list = changes;
                            i5 = size;
                            if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                                break;
                            }
                            i3 = i4 + 1;
                            changes = list;
                            size = i5;
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                            return pointerEventPass;
                        }
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            while (true) {
                                if (i7 >= size2) {
                                    obj2 = pointerEventPass;
                                    break;
                                }
                                obj2 = changes2.get(i7);
                                if (((PointerInputChange) obj2).getPressed()) {
                                    break;
                                }
                                i7++;
                            }
                            PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                            if (pointerInputChange3 == null) {
                                return pointerEventPass;
                            }
                            longRef2.element = pointerInputChange3.getId();
                            function22 = function23;
                            i6 = 1;
                            longRef = longRef2;
                            m3838getZeroF1C5BW0 = j5;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = function22;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = longRef;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = f;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, pointerEventPass);
                            if (awaitPointerEvent$default != coroutine_suspended) {
                            }
                        } else {
                            pointerEventPass2 = pointerEventPass;
                            Ref.LongRef longRef5 = longRef2;
                            long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j5, Offset.m3826minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition()));
                            if (pointerDirectionConfig2.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) < f) {
                                PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = function23;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = longRef5;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerInputChange;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = f;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.J$0 = m3827plusMKHz9U;
                                c = 2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 2;
                                if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12) != coroutine_suspended) {
                                    longRef = longRef5;
                                    pointerInputChange2 = pointerInputChange;
                                    j4 = m3827plusMKHz9U;
                                    if (!pointerInputChange2.isConsumed()) {
                                    }
                                }
                            } else {
                                c = 2;
                                function23.invoke(pointerInputChange, Offset.m3811boximpl(pointerDirectionConfig2.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f)));
                                if (pointerInputChange.isConsumed()) {
                                    return pointerInputChange;
                                }
                                pointerEventPass = pointerEventPass2;
                                function22 = function23;
                                m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                longRef = longRef5;
                                i6 = 1;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = pointerDirectionConfig2;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = function22;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = longRef;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerEventPass;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = f;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.J$0 = m3838getZeroF1C5BW0;
                                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, pointerEventPass);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                long j6 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.J$0;
                float f3 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
                longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
                function23 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
                PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj3);
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
                f = f3;
                j2 = j6;
                pointerDirectionConfig2 = pointerDirectionConfig4;
                awaitPointerEventScope2 = awaitPointerEventScope4;
                long j52 = j2;
                PointerEvent pointerEvent2 = (PointerEvent) obj3;
                changes = pointerEvent2.getChanges();
                size = changes.size();
                int i72 = 0;
                i3 = 0;
                while (true) {
                    if (i3 < size) {
                    }
                    i3 = i4 + 1;
                    changes = list;
                    size = i5;
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    return pointerEventPass;
                }
                if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                }
            }
        }
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(continuation);
        Object obj32 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label;
        int i62 = 1;
        PointerEventPass pointerEventPass4 = null;
        if (i2 != 0) {
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM$$forInline, reason: not valid java name */
    private static final Object m658awaitPointerSlopOrCancellationpn7EDYM$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, int i, PointerDirectionConfig pointerDirectionConfig, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        long m3838getZeroF1C5BW0;
        PointerInputChange pointerInputChange2;
        if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float m668pointerSlopE8SPZFQ = m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        long m3838getZeroF1C5BW02 = Offset.INSTANCE.m3838getZeroF1C5BW0();
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                int i3 = i2;
                if (Boolean.valueOf(PointerId.m5189equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2 = i3 + 1;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.getId();
            } else {
                m3838getZeroF1C5BW02 = Offset.m3827plusMKHz9U(m3838getZeroF1C5BW02, Offset.m3826minusMKHz9U(pointerInputChange3.getPosition(), pointerInputChange3.getPreviousPosition()));
                if (pointerDirectionConfig.mo670calculateDeltaChangek4lQ0M(m3838getZeroF1C5BW02) < m668pointerSlopE8SPZFQ) {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                } else {
                    function2.invoke(pointerInputChange3, Offset.m3811boximpl(pointerDirectionConfig.mo671calculatePostSlopOffset8S9VItk(m3838getZeroF1C5BW02, m668pointerSlopE8SPZFQ)));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    m3838getZeroF1C5BW02 = m3838getZeroF1C5BW0;
                }
            }
            m3838getZeroF1C5BW0 = m3838getZeroF1C5BW02;
            m3838getZeroF1C5BW02 = m3838getZeroF1C5BW0;
        }
    }

    static {
        float m6389constructorimpl = Dp.m6389constructorimpl((float) 0.125d);
        mouseSlop = m6389constructorimpl;
        float m6389constructorimpl2 = Dp.m6389constructorimpl(18);
        defaultTouchSlop = m6389constructorimpl2;
        mouseToTouchSlopRatio = m6389constructorimpl / m6389constructorimpl2;
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getBidirectionalPointerDirectionConfig() {
        return BidirectionalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation orientation) {
        return orientation == Orientation.Vertical ? VerticalPointerDirectionConfig : HorizontalPointerDirectionConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m656awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.ObjectRef objectRef;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitLongPressOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label -= Integer.MIN_VALUE;
                Object obj = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                        return null;
                    }
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            pointerInputChange = null;
                            break;
                        }
                        pointerInputChange = changes.get(i2);
                        if (PointerId.m5189equalsimpl0(pointerInputChange.getId(), j)) {
                            break;
                        }
                        i2++;
                    }
                    pointerInputChange2 = pointerInputChange;
                    if (pointerInputChange2 == 0) {
                        return null;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef3.element = pointerInputChange2;
                    long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                    try {
                        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(objectRef3, objectRef2, null);
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = pointerInputChange2;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = objectRef2;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                        if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (PointerEventTimeoutCancellationException unused) {
                        objectRef = objectRef2;
                        PointerInputChange pointerInputChange3 = (PointerInputChange) objectRef.element;
                        if (pointerInputChange3 != null) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
                    pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (PointerEventTimeoutCancellationException unused2) {
                        PointerInputChange pointerInputChange32 = (PointerInputChange) objectRef.element;
                        return pointerInputChange32 != null ? pointerInputChange2 : pointerInputChange32;
                    }
                }
                return null;
            }
        }
        dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
        Object obj2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        if (i != 0) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m667isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m5189equalsimpl0(pointerInputChange.getId(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m668pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m5279equalsimpl0(i, PointerType.INSTANCE.m5284getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }
}

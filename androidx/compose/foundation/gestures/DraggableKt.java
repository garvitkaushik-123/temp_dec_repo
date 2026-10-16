package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a!\u0010\b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\t\u001aR\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017\u001aY\u0010\u0018\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00102\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aÉ\u0001\u0010\"\u001a\u00020#*\u00020#2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010\u0011\u001a\u00020\u00102>\b\u0002\u0010*\u001a8\b\u0001\u0012\u0004\u0012\u00020,\u0012\u0013\u0012\u00110\r¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000700\u0012\u0006\u0012\u0004\u0018\u0001010+¢\u0006\u0002\b22>\b\u0002\u00103\u001a8\b\u0001\u0012\u0004\u0012\u00020,\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(4\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000700\u0012\u0006\u0012\u0004\u0018\u0001010+¢\u0006\u0002\b22\b\b\u0002\u0010\u001e\u001a\u00020\u0010¢\u0006\u0002\u00105\u001aG\u00106\u001a\u00020\u0010*\u00020\u000e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001e\u0010<\u001a\u00020\u0006*\u00020\r2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u001e\u0010<\u001a\u00020\u0006*\u00020?2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b@\u0010>\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"NoOpDragScope", "Landroidx/compose/foundation/gestures/DragScope;", "DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "", "startDragImmediately", "Lkotlin/Function0;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "pointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/foundation/gestures/PointerDirectionConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "startEvent", "initialDelta", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "reverseDirection", "hasDragged", "awaitDrag-Su4bsnU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;JLandroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "onDragOrUp", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onDrag", "onDragOrUp-Axegvzg", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/jvm/functions/Function1;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DraggableKt {
    private static final DragScope NoOpDragScope = new DragScope() { // from class: androidx.compose.foundation.gestures.DraggableKt$NoOpDragScope$1
        @Override // androidx.compose.foundation.gestures.DragScope
        public void dragBy(float pixels) {
        }
    };

    public static final DraggableState DraggableState(Function1<? super Float, Unit> function1) {
        return new DefaultDraggableState(function1);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> function1, Composer composer, int i) {
        composer.startReplaceableGroup(-183245213);
        ComposerKt.sourceInformation(composer, "C(rememberDraggableState)142@6209L29,143@6250L61:Draggable.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, i, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:141)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = DraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$rememberDraggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                    invoke(f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f) {
                    rememberUpdatedState.getValue().invoke(Float.valueOf(f));
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return draggableState;
    }

    public static /* synthetic */ Modifier draggable$default(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3 function3, Function3 function32, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return draggable(modifier, draggableState, orientation, z, (i & 8) != 0 ? null : mutableInteractionSource, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? new DraggableKt$draggable$1(null) : function3, (i & 64) != 0 ? new DraggableKt$draggable$2(null) : function32, (i & 128) != 0 ? false : z3);
    }

    public static final Modifier draggable(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, final boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z3) {
        return modifier.then(new DraggableElement(draggableState, new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange pointerInputChange) {
                return true;
            }
        }, orientation, z, mutableInteractionSource, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(z2);
            }
        }, function3, new DraggableKt$draggable$5(function32, orientation, null), z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0135, code lost:
    
        if (r1 == r3) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0295 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0257 -> B:13:0x025e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDownAndSlop(AwaitPointerEventScope awaitPointerEventScope, Function1<? super PointerInputChange, Boolean> function1, Function0<Boolean> function0, VelocityTracker velocityTracker, PointerDirectionConfig pointerDirectionConfig, Continuation<? super Pair<PointerInputChange, Offset>> continuation) {
        DraggableKt$awaitDownAndSlop$1 draggableKt$awaitDownAndSlop$1;
        int i;
        Function0<Boolean> function02;
        AwaitPointerEventScope awaitPointerEventScope2;
        PointerDirectionConfig pointerDirectionConfig2;
        Function1<? super PointerInputChange, Boolean> function12;
        final VelocityTracker velocityTracker2;
        PointerInputChange pointerInputChange;
        AwaitPointerEventScope awaitPointerEventScope3;
        final Ref.LongRef longRef;
        Function2 function2;
        float m668pointerSlopE8SPZFQ;
        Ref.LongRef longRef2;
        long m3838getZeroF1C5BW0;
        PointerEventPass pointerEventPass;
        PointerEventPass pointerEventPass2;
        DraggableKt$awaitDownAndSlop$1 draggableKt$awaitDownAndSlop$12;
        long j;
        Ref.LongRef longRef3;
        Ref.LongRef longRef4;
        float f;
        PointerEvent pointerEvent;
        int size;
        PointerEvent pointerEvent2;
        float f2;
        Object obj;
        PointerInputChange pointerInputChange2;
        Object obj2;
        Object awaitPointerEvent$default;
        if (continuation instanceof DraggableKt$awaitDownAndSlop$1) {
            draggableKt$awaitDownAndSlop$1 = (DraggableKt$awaitDownAndSlop$1) continuation;
            if ((draggableKt$awaitDownAndSlop$1.label & Integer.MIN_VALUE) != 0) {
                draggableKt$awaitDownAndSlop$1.label -= Integer.MIN_VALUE;
                Object obj3 = draggableKt$awaitDownAndSlop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = draggableKt$awaitDownAndSlop$1.label;
                int i2 = 3;
                int i3 = 0;
                int i4 = 1;
                PointerEventPass pointerEventPass3 = null;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    PointerEventPass pointerEventPass4 = PointerEventPass.Initial;
                    draggableKt$awaitDownAndSlop$1.L$0 = awaitPointerEventScope;
                    draggableKt$awaitDownAndSlop$1.L$1 = function1;
                    function02 = function0;
                    draggableKt$awaitDownAndSlop$1.L$2 = function02;
                    draggableKt$awaitDownAndSlop$1.L$3 = velocityTracker;
                    draggableKt$awaitDownAndSlop$1.L$4 = pointerDirectionConfig;
                    draggableKt$awaitDownAndSlop$1.label = 1;
                    obj3 = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, pointerEventPass4, draggableKt$awaitDownAndSlop$1);
                    if (obj3 != coroutine_suspended) {
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        pointerDirectionConfig2 = pointerDirectionConfig;
                        function12 = function1;
                        velocityTracker2 = velocityTracker;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    pointerDirectionConfig2 = (PointerDirectionConfig) draggableKt$awaitDownAndSlop$1.L$4;
                    velocityTracker2 = (VelocityTracker) draggableKt$awaitDownAndSlop$1.L$3;
                    function02 = (Function0) draggableKt$awaitDownAndSlop$1.L$2;
                    function12 = (Function1) draggableKt$awaitDownAndSlop$1.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                } else if (i == 2) {
                    pointerDirectionConfig2 = (PointerDirectionConfig) draggableKt$awaitDownAndSlop$1.L$2;
                    velocityTracker2 = (VelocityTracker) draggableKt$awaitDownAndSlop$1.L$1;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    PointerInputChange pointerInputChange3 = (PointerInputChange) obj3;
                    VelocityTrackerKt.addPointerInputChange(velocityTracker2, pointerInputChange3);
                    longRef = new Ref.LongRef();
                    longRef.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange4, Offset offset) {
                            m687invokeUv8p0NA(pointerInputChange4, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m687invokeUv8p0NA(PointerInputChange pointerInputChange4, long j2) {
                            VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, pointerInputChange4);
                            pointerInputChange4.consume();
                            longRef.element = j2;
                        }
                    };
                    long id = pointerInputChange3.getId();
                    int type = pointerInputChange3.getType();
                    if (!DragGestureDetectorKt.m667isPointerUpDmW0f2w(awaitPointerEventScope3.getCurrentEvent(), id)) {
                        m668pointerSlopE8SPZFQ = DragGestureDetectorKt.m668pointerSlopE8SPZFQ(awaitPointerEventScope3.getViewConfiguration(), type);
                        longRef2 = new Ref.LongRef();
                        longRef2.element = id;
                        m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                        draggableKt$awaitDownAndSlop$1.L$0 = pointerDirectionConfig2;
                        draggableKt$awaitDownAndSlop$1.L$1 = longRef;
                        draggableKt$awaitDownAndSlop$1.L$2 = function2;
                        draggableKt$awaitDownAndSlop$1.L$3 = awaitPointerEventScope3;
                        draggableKt$awaitDownAndSlop$1.L$4 = longRef2;
                        draggableKt$awaitDownAndSlop$1.L$5 = pointerEventPass3;
                        draggableKt$awaitDownAndSlop$1.F$0 = m668pointerSlopE8SPZFQ;
                        draggableKt$awaitDownAndSlop$1.J$0 = m3838getZeroF1C5BW0;
                        draggableKt$awaitDownAndSlop$1.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass3, draggableKt$awaitDownAndSlop$1, i4, pointerEventPass3);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    pointerEventPass = null;
                    pointerEventPass2 = null;
                    if (pointerEventPass == null) {
                    }
                } else if (i == 3) {
                    long j2 = draggableKt$awaitDownAndSlop$1.J$0;
                    float f3 = draggableKt$awaitDownAndSlop$1.F$0;
                    longRef4 = (Ref.LongRef) draggableKt$awaitDownAndSlop$1.L$4;
                    AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$1.L$3;
                    Function2 function22 = (Function2) draggableKt$awaitDownAndSlop$1.L$2;
                    longRef3 = (Ref.LongRef) draggableKt$awaitDownAndSlop$1.L$1;
                    PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) draggableKt$awaitDownAndSlop$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    draggableKt$awaitDownAndSlop$12 = draggableKt$awaitDownAndSlop$1;
                    f = f3;
                    pointerDirectionConfig2 = pointerDirectionConfig3;
                    j = j2;
                    awaitPointerEventScope3 = awaitPointerEventScope4;
                    function2 = function22;
                    DraggableKt$awaitDownAndSlop$1 draggableKt$awaitDownAndSlop$13 = draggableKt$awaitDownAndSlop$12;
                    pointerEvent = (PointerEvent) obj3;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    while (true) {
                        if (i3 < size) {
                        }
                        i3++;
                        f = f2;
                        pointerEvent = pointerEvent2;
                        pointerEventPass3 = pointerEventPass2;
                    }
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 != 0) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                        }
                        i3 = 0;
                        i4 = 1;
                        draggableKt$awaitDownAndSlop$1.L$0 = pointerDirectionConfig2;
                        draggableKt$awaitDownAndSlop$1.L$1 = longRef;
                        draggableKt$awaitDownAndSlop$1.L$2 = function2;
                        draggableKt$awaitDownAndSlop$1.L$3 = awaitPointerEventScope3;
                        draggableKt$awaitDownAndSlop$1.L$4 = longRef2;
                        draggableKt$awaitDownAndSlop$1.L$5 = pointerEventPass3;
                        draggableKt$awaitDownAndSlop$1.F$0 = m668pointerSlopE8SPZFQ;
                        draggableKt$awaitDownAndSlop$1.J$0 = m3838getZeroF1C5BW0;
                        draggableKt$awaitDownAndSlop$1.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass3, draggableKt$awaitDownAndSlop$1, i4, pointerEventPass3);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    longRef = longRef3;
                    pointerEventPass = pointerEventPass2;
                    if (pointerEventPass == null) {
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j3 = draggableKt$awaitDownAndSlop$1.J$0;
                    float f4 = draggableKt$awaitDownAndSlop$1.F$0;
                    PointerInputChange pointerInputChange4 = (PointerInputChange) draggableKt$awaitDownAndSlop$1.L$5;
                    longRef4 = (Ref.LongRef) draggableKt$awaitDownAndSlop$1.L$4;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) draggableKt$awaitDownAndSlop$1.L$3;
                    Function2 function23 = (Function2) draggableKt$awaitDownAndSlop$1.L$2;
                    Ref.LongRef longRef5 = (Ref.LongRef) draggableKt$awaitDownAndSlop$1.L$1;
                    PointerDirectionConfig pointerDirectionConfig4 = (PointerDirectionConfig) draggableKt$awaitDownAndSlop$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    m668pointerSlopE8SPZFQ = f4;
                    Object obj4 = coroutine_suspended;
                    pointerDirectionConfig2 = pointerDirectionConfig4;
                    pointerEventPass2 = null;
                    long j4 = j3;
                    awaitPointerEventScope3 = awaitPointerEventScope5;
                    function2 = function23;
                    longRef3 = longRef5;
                    if (!pointerInputChange4.isConsumed()) {
                        coroutine_suspended = obj4;
                        longRef2 = longRef4;
                        longRef = longRef3;
                        pointerEventPass3 = pointerEventPass2;
                        i2 = 3;
                        m3838getZeroF1C5BW0 = j4;
                        i3 = 0;
                        i4 = 1;
                        draggableKt$awaitDownAndSlop$1.L$0 = pointerDirectionConfig2;
                        draggableKt$awaitDownAndSlop$1.L$1 = longRef;
                        draggableKt$awaitDownAndSlop$1.L$2 = function2;
                        draggableKt$awaitDownAndSlop$1.L$3 = awaitPointerEventScope3;
                        draggableKt$awaitDownAndSlop$1.L$4 = longRef2;
                        draggableKt$awaitDownAndSlop$1.L$5 = pointerEventPass3;
                        draggableKt$awaitDownAndSlop$1.F$0 = m668pointerSlopE8SPZFQ;
                        draggableKt$awaitDownAndSlop$1.J$0 = m3838getZeroF1C5BW0;
                        draggableKt$awaitDownAndSlop$1.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass3, draggableKt$awaitDownAndSlop$1, i4, pointerEventPass3);
                        if (awaitPointerEvent$default != coroutine_suspended) {
                            draggableKt$awaitDownAndSlop$12 = draggableKt$awaitDownAndSlop$1;
                            f = m668pointerSlopE8SPZFQ;
                            obj3 = awaitPointerEvent$default;
                            j = m3838getZeroF1C5BW0;
                            longRef3 = longRef;
                            longRef4 = longRef2;
                            DraggableKt$awaitDownAndSlop$1 draggableKt$awaitDownAndSlop$132 = draggableKt$awaitDownAndSlop$12;
                            pointerEvent = (PointerEvent) obj3;
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            size = changes2.size();
                            while (true) {
                                if (i3 < size) {
                                    pointerEvent2 = pointerEvent;
                                    f2 = f;
                                    pointerEventPass2 = pointerEventPass3;
                                    obj = pointerEventPass2;
                                    break;
                                }
                                obj = changes2.get(i3);
                                pointerEventPass2 = pointerEventPass3;
                                pointerEvent2 = pointerEvent;
                                f2 = f;
                                if (PointerId.m5189equalsimpl0(((PointerInputChange) obj).getId(), longRef4.element)) {
                                    break;
                                }
                                i3++;
                                f = f2;
                                pointerEvent = pointerEvent2;
                                pointerEventPass3 = pointerEventPass2;
                            }
                            pointerInputChange2 = (PointerInputChange) obj;
                            if (pointerInputChange2 != 0 && !pointerInputChange2.isConsumed()) {
                                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                                    obj4 = coroutine_suspended;
                                    long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j, Offset.m3826minusMKHz9U(pointerInputChange2.getPosition(), pointerInputChange2.getPreviousPosition()));
                                    if (pointerDirectionConfig2.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) < f2) {
                                        PointerEventPass pointerEventPass5 = PointerEventPass.Final;
                                        draggableKt$awaitDownAndSlop$132.L$0 = pointerDirectionConfig2;
                                        draggableKt$awaitDownAndSlop$132.L$1 = longRef3;
                                        draggableKt$awaitDownAndSlop$132.L$2 = function2;
                                        draggableKt$awaitDownAndSlop$132.L$3 = awaitPointerEventScope3;
                                        draggableKt$awaitDownAndSlop$132.L$4 = longRef4;
                                        draggableKt$awaitDownAndSlop$132.L$5 = pointerInputChange2;
                                        float f5 = f2;
                                        draggableKt$awaitDownAndSlop$132.F$0 = f5;
                                        draggableKt$awaitDownAndSlop$132.J$0 = m3827plusMKHz9U;
                                        draggableKt$awaitDownAndSlop$132.label = 4;
                                        if (awaitPointerEventScope3.awaitPointerEvent(pointerEventPass5, draggableKt$awaitDownAndSlop$132) == obj4) {
                                            return obj4;
                                        }
                                        pointerInputChange4 = pointerInputChange2;
                                        m668pointerSlopE8SPZFQ = f5;
                                        j4 = m3827plusMKHz9U;
                                        draggableKt$awaitDownAndSlop$1 = draggableKt$awaitDownAndSlop$132;
                                        if (!pointerInputChange4.isConsumed()) {
                                        }
                                    } else {
                                        float f6 = f2;
                                        function2.invoke(pointerInputChange2, Offset.m3811boximpl(pointerDirectionConfig2.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f6)));
                                        if (pointerInputChange2.isConsumed()) {
                                            longRef = longRef3;
                                            pointerEventPass = pointerInputChange2;
                                            return pointerEventPass == null ? TuplesKt.to(pointerEventPass, Offset.m3811boximpl(longRef.element)) : pointerEventPass2;
                                        }
                                        draggableKt$awaitDownAndSlop$1 = draggableKt$awaitDownAndSlop$132;
                                        longRef2 = longRef4;
                                        longRef = longRef3;
                                        m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                                        coroutine_suspended = obj4;
                                        m668pointerSlopE8SPZFQ = f6;
                                        pointerEventPass3 = pointerEventPass2;
                                        i2 = 3;
                                    }
                                } else {
                                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                                    int size2 = changes3.size();
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= size2) {
                                            obj2 = pointerEventPass2;
                                            break;
                                        }
                                        obj2 = changes3.get(i5);
                                        if (((PointerInputChange) obj2).getPressed()) {
                                            break;
                                        }
                                        i5++;
                                    }
                                    PointerInputChange pointerInputChange5 = (PointerInputChange) obj2;
                                    if (pointerInputChange5 != null) {
                                        longRef4.element = pointerInputChange5.getId();
                                        m668pointerSlopE8SPZFQ = f2;
                                        draggableKt$awaitDownAndSlop$1 = draggableKt$awaitDownAndSlop$132;
                                        longRef2 = longRef4;
                                        longRef = longRef3;
                                        m3838getZeroF1C5BW0 = j;
                                        pointerEventPass3 = pointerEventPass2;
                                        i2 = 3;
                                    }
                                }
                                i3 = 0;
                                i4 = 1;
                                draggableKt$awaitDownAndSlop$1.L$0 = pointerDirectionConfig2;
                                draggableKt$awaitDownAndSlop$1.L$1 = longRef;
                                draggableKt$awaitDownAndSlop$1.L$2 = function2;
                                draggableKt$awaitDownAndSlop$1.L$3 = awaitPointerEventScope3;
                                draggableKt$awaitDownAndSlop$1.L$4 = longRef2;
                                draggableKt$awaitDownAndSlop$1.L$5 = pointerEventPass3;
                                draggableKt$awaitDownAndSlop$1.F$0 = m668pointerSlopE8SPZFQ;
                                draggableKt$awaitDownAndSlop$1.J$0 = m3838getZeroF1C5BW0;
                                draggableKt$awaitDownAndSlop$1.label = i2;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass3, draggableKt$awaitDownAndSlop$1, i4, pointerEventPass3);
                                if (awaitPointerEvent$default != coroutine_suspended) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    longRef = longRef3;
                    pointerEventPass = pointerEventPass2;
                    if (pointerEventPass == null) {
                    }
                }
                pointerInputChange = (PointerInputChange) obj3;
                if (function12.invoke(pointerInputChange).booleanValue()) {
                    return null;
                }
                if (function02.invoke().booleanValue()) {
                    pointerInputChange.consume();
                    VelocityTrackerKt.addPointerInputChange(velocityTracker2, pointerInputChange);
                    return TuplesKt.to(pointerInputChange, Offset.m3811boximpl(Offset.INSTANCE.m3838getZeroF1C5BW0()));
                }
                draggableKt$awaitDownAndSlop$1.L$0 = awaitPointerEventScope2;
                draggableKt$awaitDownAndSlop$1.L$1 = velocityTracker2;
                draggableKt$awaitDownAndSlop$1.L$2 = pointerDirectionConfig2;
                draggableKt$awaitDownAndSlop$1.L$3 = null;
                draggableKt$awaitDownAndSlop$1.L$4 = null;
                draggableKt$awaitDownAndSlop$1.label = 2;
                AwaitPointerEventScope awaitPointerEventScope6 = awaitPointerEventScope2;
                obj3 = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope6, false, null, draggableKt$awaitDownAndSlop$1, 2, null);
                awaitPointerEventScope3 = awaitPointerEventScope6;
            }
        }
        draggableKt$awaitDownAndSlop$1 = new DraggableKt$awaitDownAndSlop$1(continuation);
        Object obj32 = draggableKt$awaitDownAndSlop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = draggableKt$awaitDownAndSlop$1.label;
        int i22 = 3;
        int i32 = 0;
        int i42 = 1;
        PointerEventPass pointerEventPass32 = null;
        if (i != 0) {
        }
        pointerInputChange = (PointerInputChange) obj32;
        if (function12.invoke(pointerInputChange).booleanValue()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: awaitDrag-Su4bsnU, reason: not valid java name */
    public static final Object m683awaitDragSu4bsnU(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, long j, final VelocityTracker velocityTracker, final SendChannel<? super DragEvent> sendChannel, final boolean z, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super Boolean> continuation) {
        sendChannel.mo11746trySendJP2dKIU(new DragEvent.DragStarted(Offset.m3826minusMKHz9U(pointerInputChange.getPosition(), OffsetKt.Offset(Offset.m3822getXimpl(j) * Math.signum(Offset.m3822getXimpl(pointerInputChange.getPosition())), Offset.m3823getYimpl(j) * Math.signum(Offset.m3823getYimpl(pointerInputChange.getPosition())))), null));
        sendChannel.mo11746trySendJP2dKIU(new DragEvent.DragDelta(z ? Offset.m3829timestuRUvjQ(j, -1.0f) : j, null));
        return m684onDragOrUpAxegvzg(awaitPointerEventScope, function1, pointerInputChange.getId(), new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDrag$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange2) {
                invoke2(pointerInputChange2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PointerInputChange pointerInputChange2) {
                VelocityTrackerKt.addPointerInputChange(VelocityTracker.this, pointerInputChange2);
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    return;
                }
                long positionChange = PointerEventKt.positionChange(pointerInputChange2);
                pointerInputChange2.consume();
                SendChannel<DragEvent> sendChannel2 = sendChannel;
                if (z) {
                    positionChange = Offset.m3829timestuRUvjQ(positionChange, -1.0f);
                }
                sendChannel2.mo11746trySendJP2dKIU(new DragEvent.DragDelta(positionChange, null));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f7, code lost:
    
        if (r1.invoke(r14).booleanValue() != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0086 -> B:10:0x008b). Please report as a decompilation issue!!! */
    /* renamed from: onDragOrUp-Axegvzg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m684onDragOrUpAxegvzg(AwaitPointerEventScope awaitPointerEventScope, Function1<? super PointerInputChange, Boolean> function1, long j, Function1<? super PointerInputChange, Unit> function12, Continuation<? super Boolean> continuation) {
        DraggableKt$onDragOrUp$1 draggableKt$onDragOrUp$1;
        int i;
        long j2;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function13;
        DraggableKt$onDragOrUp$1 draggableKt$onDragOrUp$12;
        Function1<? super PointerInputChange, Boolean> function14;
        PointerInputChange pointerInputChange;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object awaitPointerEvent$default;
        Unit unit;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        if (continuation instanceof DraggableKt$onDragOrUp$1) {
            draggableKt$onDragOrUp$1 = (DraggableKt$onDragOrUp$1) continuation;
            if ((draggableKt$onDragOrUp$1.label & Integer.MIN_VALUE) != 0) {
                draggableKt$onDragOrUp$1.label -= Integer.MIN_VALUE;
                Object obj = draggableKt$onDragOrUp$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = draggableKt$onDragOrUp$1.label;
                int i2 = 1;
                PointerEventPass pointerEventPass = null;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Ref.LongRef longRef2 = (Ref.LongRef) draggableKt$onDragOrUp$1.L$4;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) draggableKt$onDragOrUp$1.L$3;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) draggableKt$onDragOrUp$1.L$2;
                    Function1<? super PointerInputChange, Unit> function15 = (Function1) draggableKt$onDragOrUp$1.L$1;
                    Function1<? super PointerInputChange, Boolean> function16 = (Function1) draggableKt$onDragOrUp$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    draggableKt$onDragOrUp$12 = draggableKt$onDragOrUp$1;
                    function14 = function16;
                    longRef = longRef2;
                    function13 = function15;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    int size = changes.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            awaitPointerEventScope4 = awaitPointerEventScope3;
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes.get(i3);
                        awaitPointerEventScope4 = awaitPointerEventScope3;
                        if (PointerId.m5189equalsimpl0(pointerInputChange2.getId(), longRef.element)) {
                            break;
                        }
                        i3++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    pointerInputChange = pointerInputChange2;
                    if (pointerInputChange == null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            int size2 = changes2.size();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= size2) {
                                    pointerInputChange3 = null;
                                    break;
                                }
                                pointerInputChange3 = changes2.get(i4);
                                if (pointerInputChange3.getPressed()) {
                                    break;
                                }
                                i4++;
                            }
                            PointerInputChange pointerInputChange4 = pointerInputChange3;
                            if (pointerInputChange4 != null) {
                                longRef.element = pointerInputChange4.getId();
                                awaitPointerEventScope3 = awaitPointerEventScope4;
                                awaitPointerEventScope2 = awaitPointerEventScope5;
                                i2 = 1;
                                pointerEventPass = null;
                                draggableKt$onDragOrUp$12.L$0 = function14;
                                draggableKt$onDragOrUp$12.L$1 = function13;
                                draggableKt$onDragOrUp$12.L$2 = awaitPointerEventScope2;
                                draggableKt$onDragOrUp$12.L$3 = awaitPointerEventScope3;
                                draggableKt$onDragOrUp$12.L$4 = longRef;
                                draggableKt$onDragOrUp$12.label = i2;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, draggableKt$onDragOrUp$12, i2, pointerEventPass);
                                if (awaitPointerEvent$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                awaitPointerEventScope5 = awaitPointerEventScope2;
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
                            awaitPointerEventScope3 = awaitPointerEventScope4;
                        }
                        pointerInputChange = pointerInputChange2;
                        if (pointerInputChange == null) {
                            pointerInputChange = null;
                        }
                    }
                    if (pointerInputChange == null || pointerInputChange.isConsumed()) {
                        pointerInputChange = null;
                    } else if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                        function13.invoke(pointerInputChange);
                        awaitPointerEventScope2 = awaitPointerEventScope5;
                        pointerEventPass = null;
                        j2 = pointerInputChange.getId();
                        i2 = 1;
                        longRef = new Ref.LongRef();
                        longRef.element = j2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        draggableKt$onDragOrUp$12.L$0 = function14;
                        draggableKt$onDragOrUp$12.L$1 = function13;
                        draggableKt$onDragOrUp$12.L$2 = awaitPointerEventScope2;
                        draggableKt$onDragOrUp$12.L$3 = awaitPointerEventScope3;
                        draggableKt$onDragOrUp$12.L$4 = longRef;
                        draggableKt$onDragOrUp$12.label = i2;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, draggableKt$onDragOrUp$12, i2, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                        }
                    }
                    if (pointerInputChange == null) {
                        function13.invoke(pointerInputChange);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    return Boxing.boxBoolean(unit == null);
                }
                ResultKt.throwOnFailure(obj);
                j2 = j;
                if (DragGestureDetectorKt.m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
                    function13 = function12;
                    pointerInputChange = null;
                    if (pointerInputChange == null) {
                    }
                    return Boxing.boxBoolean(unit == null);
                }
                awaitPointerEventScope2 = awaitPointerEventScope;
                function13 = function12;
                draggableKt$onDragOrUp$12 = draggableKt$onDragOrUp$1;
                function14 = function1;
                longRef = new Ref.LongRef();
                longRef.element = j2;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                draggableKt$onDragOrUp$12.L$0 = function14;
                draggableKt$onDragOrUp$12.L$1 = function13;
                draggableKt$onDragOrUp$12.L$2 = awaitPointerEventScope2;
                draggableKt$onDragOrUp$12.L$3 = awaitPointerEventScope3;
                draggableKt$onDragOrUp$12.L$4 = longRef;
                draggableKt$onDragOrUp$12.label = i2;
                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, draggableKt$onDragOrUp$12, i2, pointerEventPass);
                if (awaitPointerEvent$default == coroutine_suspended) {
                }
            }
        }
        draggableKt$onDragOrUp$1 = new DraggableKt$onDragOrUp$1(continuation);
        Object obj2 = draggableKt$onDragOrUp$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = draggableKt$onDragOrUp$1.label;
        int i22 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-3MmeM6k, reason: not valid java name */
    public static final float m685toFloat3MmeM6k(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m3823getYimpl(j) : Offset.m3822getXimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-sF-c-tU, reason: not valid java name */
    public static final float m686toFloatsFctU(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m6625getYimpl(j) : Velocity.m6624getXimpl(j);
    }
}

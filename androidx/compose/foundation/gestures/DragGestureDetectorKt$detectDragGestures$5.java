package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {175, 884, 926, 192}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointerDirectionConfig$iv", "pointer$iv", "touchSlop$iv", "totalPositionChange$iv", "$this$awaitEachGesture", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "touchSlop$iv", "totalPositionChange$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "F$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "F$0", "J$0"})
/* loaded from: classes.dex */
final class DragGestureDetectorKt$detectDragGestures$5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    float F$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0109, code lost:
    
        if (r15 == r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0233, code lost:
    
        if (r2 == r1) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00a8, code lost:
    
        if (r2 == r1) goto L73;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01cc  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v11, types: [androidx.compose.ui.input.pointer.PointerEventPass, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00d1 -> B:21:0x01e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0148 -> B:21:0x01e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x01c2 -> B:18:0x01c3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01e3 -> B:21:0x01e4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x024c -> B:29:0x00ee). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        Object awaitFirstDown$default;
        PointerInputChange pointerInputChange;
        Ref.LongRef longRef;
        Object obj2;
        Ref.LongRef longRef2;
        PointerDirectionConfig pointerDirectionConfig;
        float f;
        AwaitPointerEventScope awaitPointerEventScope2;
        long j;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        Ref.LongRef longRef3;
        char c;
        PointerInputChange pointerInputChange4;
        long id;
        Object m665dragjO51t88;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        char c2 = 3;
        int i2 = 2;
        int i3 = 1;
        ?? r7 = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            this.L$0 = awaitPointerEventScope;
            this.label = 1;
            awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, this, 2, null);
        } else if (i == 1) {
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = awaitPointerEventScope3;
            awaitFirstDown$default = obj;
        } else {
            if (i == 2) {
                long j2 = this.J$0;
                float f2 = this.F$0;
                Ref.LongRef longRef4 = (Ref.LongRef) this.L$5;
                PointerDirectionConfig pointerDirectionConfig2 = (PointerDirectionConfig) this.L$4;
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$3;
                Ref.LongRef longRef5 = (Ref.LongRef) this.L$2;
                PointerInputChange pointerInputChange5 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                f = f2;
                awaitPointerEventScope = awaitPointerEventScope4;
                awaitPointerEventScope2 = awaitPointerEventScope5;
                longRef2 = longRef4;
                pointerDirectionConfig = pointerDirectionConfig2;
                j = j2;
                longRef = longRef5;
                pointerInputChange = pointerInputChange5;
                PointerEvent pointerEvent = (PointerEvent) obj2;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes.get(i4);
                    List<PointerInputChange> list = changes;
                    int i5 = size;
                    int i6 = i4;
                    if (PointerId.m5189equalsimpl0(pointerInputChange2.getId(), longRef2.element)) {
                        break;
                    }
                    i4 = i6 + 1;
                    changes = list;
                    size = i5;
                }
                pointerInputChange3 = pointerInputChange2;
                if (pointerInputChange3 != null && !pointerInputChange3.isConsumed()) {
                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                        List<PointerInputChange> changes2 = pointerEvent.getChanges();
                        int size2 = changes2.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size2) {
                                pointerInputChange4 = null;
                                break;
                            }
                            pointerInputChange4 = changes2.get(i7);
                            if (pointerInputChange4.getPressed()) {
                                break;
                            }
                            i7++;
                        }
                        PointerInputChange pointerInputChange6 = pointerInputChange4;
                        if (pointerInputChange6 != null) {
                            longRef2.element = pointerInputChange6.getId();
                            i2 = 2;
                            i3 = 1;
                            r7 = 0;
                        }
                    } else {
                        longRef3 = longRef2;
                        long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j, Offset.m3826minusMKHz9U(pointerInputChange3.getPosition(), pointerInputChange3.getPreviousPosition()));
                        if (pointerDirectionConfig.mo670calculateDeltaChangek4lQ0M(m3827plusMKHz9U) < f) {
                            this.L$0 = awaitPointerEventScope2;
                            this.L$1 = pointerInputChange;
                            this.L$2 = longRef;
                            this.L$3 = awaitPointerEventScope;
                            this.L$4 = pointerDirectionConfig;
                            this.L$5 = longRef3;
                            this.L$6 = pointerInputChange3;
                            this.F$0 = f;
                            this.J$0 = m3827plusMKHz9U;
                            c = 3;
                            this.label = 3;
                            if (awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, this) != coroutine_suspended) {
                                j = m3827plusMKHz9U;
                                if (!pointerInputChange3.isConsumed()) {
                                }
                            }
                            return coroutine_suspended;
                        }
                        c = 3;
                        long mo671calculatePostSlopOffset8S9VItk = pointerDirectionConfig.mo671calculatePostSlopOffset8S9VItk(m3827plusMKHz9U, f);
                        pointerInputChange3.consume();
                        longRef.element = mo671calculatePostSlopOffset8S9VItk;
                        if (pointerInputChange3.isConsumed()) {
                            awaitPointerEventScope = awaitPointerEventScope2;
                            if (pointerInputChange3 == null) {
                            }
                            if (pointerInputChange3 != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        j = Offset.INSTANCE.m3838getZeroF1C5BW0();
                        i2 = 2;
                        longRef2 = longRef3;
                        r7 = 0;
                        i3 = 1;
                    }
                    this.L$0 = awaitPointerEventScope2;
                    this.L$1 = pointerInputChange;
                    this.L$2 = longRef;
                    this.L$3 = awaitPointerEventScope;
                    this.L$4 = pointerDirectionConfig;
                    this.L$5 = longRef2;
                    this.L$6 = r7;
                    this.F$0 = f;
                    this.J$0 = j;
                    this.label = i2;
                    obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, r7, this, i3, r7);
                }
                awaitPointerEventScope = awaitPointerEventScope2;
                pointerInputChange3 = null;
                c = 3;
                if (pointerInputChange3 == null) {
                }
                if (pointerInputChange3 != null) {
                }
                return Unit.INSTANCE;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                m665dragjO51t88 = obj;
                if (!((Boolean) m665dragjO51t88).booleanValue()) {
                    this.$onDragCancel.invoke();
                } else {
                    this.$onDragEnd.invoke();
                }
                return Unit.INSTANCE;
            }
            long j3 = this.J$0;
            float f3 = this.F$0;
            PointerInputChange pointerInputChange7 = (PointerInputChange) this.L$6;
            Ref.LongRef longRef6 = (Ref.LongRef) this.L$5;
            PointerDirectionConfig pointerDirectionConfig3 = (PointerDirectionConfig) this.L$4;
            AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$3;
            Ref.LongRef longRef7 = (Ref.LongRef) this.L$2;
            PointerInputChange pointerInputChange8 = (PointerInputChange) this.L$1;
            AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            longRef3 = longRef6;
            awaitPointerEventScope2 = awaitPointerEventScope7;
            longRef = longRef7;
            c = 3;
            pointerInputChange3 = pointerInputChange7;
            j = j3;
            awaitPointerEventScope = awaitPointerEventScope6;
            pointerDirectionConfig = pointerDirectionConfig3;
            f = f3;
            pointerInputChange = pointerInputChange8;
            if (!pointerInputChange3.isConsumed()) {
                awaitPointerEventScope = awaitPointerEventScope2;
                pointerInputChange3 = null;
                if (pointerInputChange3 == null && !pointerInputChange3.isConsumed()) {
                    c2 = c;
                    i2 = 2;
                    i3 = 1;
                    r7 = 0;
                    id = pointerInputChange.getId();
                    int type = pointerInputChange.getType();
                    PointerDirectionConfig bidirectionalPointerDirectionConfig = DragGestureDetectorKt.getBidirectionalPointerDirectionConfig();
                    if (!DragGestureDetectorKt.m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                        c = c2;
                        pointerInputChange3 = r7;
                        if (pointerInputChange3 == null) {
                        }
                        if (pointerInputChange3 != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    float m668pointerSlopE8SPZFQ = DragGestureDetectorKt.m668pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), type);
                    Ref.LongRef longRef8 = new Ref.LongRef();
                    longRef8.element = id;
                    j = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    longRef2 = longRef8;
                    pointerDirectionConfig = bidirectionalPointerDirectionConfig;
                    f = m668pointerSlopE8SPZFQ;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    this.L$0 = awaitPointerEventScope2;
                    this.L$1 = pointerInputChange;
                    this.L$2 = longRef;
                    this.L$3 = awaitPointerEventScope;
                    this.L$4 = pointerDirectionConfig;
                    this.L$5 = longRef2;
                    this.L$6 = r7;
                    this.F$0 = f;
                    this.J$0 = j;
                    this.label = i2;
                    obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, r7, this, i3, r7);
                } else {
                    if (pointerInputChange3 != null) {
                        this.$onDragStart.invoke(Offset.m3811boximpl(pointerInputChange3.getPosition()));
                        this.$onDrag.invoke(pointerInputChange3, Offset.m3811boximpl(longRef.element));
                        long id2 = pointerInputChange3.getId();
                        final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.label = 4;
                        m665dragjO51t88 = DragGestureDetectorKt.m665dragjO51t88(awaitPointerEventScope, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange9) {
                                invoke2(pointerInputChange9);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange pointerInputChange9) {
                                function2.invoke(pointerInputChange9, Offset.m3811boximpl(PointerEventKt.positionChange(pointerInputChange9)));
                                pointerInputChange9.consume();
                            }
                        }, this);
                    }
                    return Unit.INSTANCE;
                }
            } else {
                i2 = 2;
                i3 = 1;
                longRef2 = longRef3;
                r7 = 0;
                this.L$0 = awaitPointerEventScope2;
                this.L$1 = pointerInputChange;
                this.L$2 = longRef;
                this.L$3 = awaitPointerEventScope;
                this.L$4 = pointerDirectionConfig;
                this.L$5 = longRef2;
                this.L$6 = r7;
                this.F$0 = f;
                this.J$0 = j;
                this.label = i2;
                obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, r7, this, i3, r7);
            }
        }
        pointerInputChange = (PointerInputChange) awaitFirstDown$default;
        longRef = new Ref.LongRef();
        longRef.element = Offset.INSTANCE.m3838getZeroF1C5BW0();
        id = pointerInputChange.getId();
        int type2 = pointerInputChange.getType();
        PointerDirectionConfig bidirectionalPointerDirectionConfig2 = DragGestureDetectorKt.getBidirectionalPointerDirectionConfig();
        if (!DragGestureDetectorKt.m667isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
        }
    }
}

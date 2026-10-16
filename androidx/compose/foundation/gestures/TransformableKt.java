package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;

/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0082@¢\u0006\u0002\u0010\u000b\u001a<\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0007\u001a&\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"detectZoom", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "panZoomLock", "", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "enabled", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformableKt {
    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1<Offset, Boolean>() { // from class: androidx.compose.foundation.gestures.TransformableKt$transformable$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Offset offset) {
                return m738invokek4lQ0M(offset.getPackedValue());
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final Boolean m738invokek4lQ0M(long j) {
                return true;
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x02b1, code lost:
    
        if (r6 != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x02b3, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0205, code lost:
    
        if (r13.invoke(androidx.compose.ui.geometry.Offset.m3811boximpl(r9)).booleanValue() != false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02b8 A[EDGE_INSN: B:97:0x02b8->B:96:0x02b8 BREAK  A[LOOP:0: B:13:0x02a3->B:16:0x02b5], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0287 -> B:12:0x0296). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z, Channel<TransformEvent> channel, Function1<? super Offset, Boolean> function1, Continuation<? super Unit> continuation) {
        TransformableKt$detectZoom$1 transformableKt$detectZoom$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        Channel<TransformEvent> channel2;
        Function1<? super Offset, Boolean> function12;
        boolean z2;
        float f;
        long j;
        int i2;
        int i3;
        float f2;
        float f3;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super Offset, Boolean> function13;
        AwaitPointerEventScope awaitPointerEventScope3;
        float f4;
        float f5;
        Channel<TransformEvent> channel3;
        int size;
        int i4;
        int i5;
        TransformableKt$detectZoom$1 transformableKt$detectZoom$12;
        float f6;
        long j2;
        int i6;
        int i7;
        Object awaitPointerEvent;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerEvent pointerEvent;
        float f7;
        int i8;
        int i9;
        Channel<TransformEvent> channel4;
        long j3;
        float f8;
        long j4;
        int size2;
        int i10;
        int size3;
        int i11;
        int size4;
        int i12;
        if (continuation instanceof TransformableKt$detectZoom$1) {
            transformableKt$detectZoom$1 = (TransformableKt$detectZoom$1) continuation;
            if ((transformableKt$detectZoom$1.label & Integer.MIN_VALUE) != 0) {
                transformableKt$detectZoom$1.label -= Integer.MIN_VALUE;
                TransformableKt$detectZoom$1 transformableKt$detectZoom$13 = transformableKt$detectZoom$1;
                obj = transformableKt$detectZoom$13.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = transformableKt$detectZoom$13.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
                    float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
                    transformableKt$detectZoom$13.L$0 = awaitPointerEventScope;
                    channel2 = channel;
                    transformableKt$detectZoom$13.L$1 = channel2;
                    function12 = function1;
                    transformableKt$detectZoom$13.L$2 = function12;
                    z2 = z;
                    transformableKt$detectZoom$13.Z$0 = z2;
                    transformableKt$detectZoom$13.F$0 = 0.0f;
                    transformableKt$detectZoom$13.F$1 = 1.0f;
                    transformableKt$detectZoom$13.J$0 = m3838getZeroF1C5BW0;
                    transformableKt$detectZoom$13.I$0 = 0;
                    transformableKt$detectZoom$13.F$2 = touchSlop;
                    transformableKt$detectZoom$13.I$1 = 0;
                    transformableKt$detectZoom$13.label = 1;
                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, transformableKt$detectZoom$13, 2, null) != coroutine_suspended) {
                        f = touchSlop;
                        j = m3838getZeroF1C5BW0;
                        i2 = 0;
                        i3 = 0;
                        f2 = 1.0f;
                        f3 = 0.0f;
                        awaitPointerEventScope2 = awaitPointerEventScope;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i5 = transformableKt$detectZoom$13.I$2;
                        i8 = transformableKt$detectZoom$13.I$1;
                        f7 = transformableKt$detectZoom$13.F$2;
                        i9 = transformableKt$detectZoom$13.I$0;
                        j3 = transformableKt$detectZoom$13.J$0;
                        float f9 = transformableKt$detectZoom$13.F$1;
                        f3 = transformableKt$detectZoom$13.F$0;
                        boolean z3 = transformableKt$detectZoom$13.Z$0;
                        pointerEvent = (PointerEvent) transformableKt$detectZoom$13.L$3;
                        Function1<? super Offset, Boolean> function14 = (Function1) transformableKt$detectZoom$13.L$2;
                        Channel<TransformEvent> channel5 = (Channel) transformableKt$detectZoom$13.L$1;
                        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) transformableKt$detectZoom$13.L$0;
                        ResultKt.throwOnFailure(obj);
                        f2 = f9;
                        channel4 = channel5;
                        awaitPointerEventScope4 = awaitPointerEventScope5;
                        function12 = function14;
                        z2 = z3;
                        awaitPointerEvent = obj;
                        List<PointerInputChange> changes = ((PointerEvent) awaitPointerEvent).getChanges();
                        size3 = changes.size();
                        Object obj2 = coroutine_suspended;
                        i11 = 0;
                        while (true) {
                            if (i11 >= size3) {
                                break;
                            }
                            if (changes.get(i11).isConsumed()) {
                                break;
                            }
                            i11++;
                        }
                        boolean z4 = false;
                        if (i5 == 0 && !z4) {
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            size4 = changes2.size();
                            for (i12 = 0; i12 < size4; i12++) {
                                if (changes2.get(i12).getPressed()) {
                                    i2 = i8;
                                    f = f7;
                                    i3 = i9;
                                    channel2 = channel4;
                                    j = j3;
                                    awaitPointerEventScope2 = awaitPointerEventScope4;
                                    coroutine_suspended = obj2;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    i2 = transformableKt$detectZoom$13.I$1;
                    f = transformableKt$detectZoom$13.F$2;
                    i3 = transformableKt$detectZoom$13.I$0;
                    j = transformableKt$detectZoom$13.J$0;
                    float f10 = transformableKt$detectZoom$13.F$1;
                    float f11 = transformableKt$detectZoom$13.F$0;
                    boolean z5 = transformableKt$detectZoom$13.Z$0;
                    Function1<? super Offset, Boolean> function15 = (Function1) transformableKt$detectZoom$13.L$2;
                    Channel<TransformEvent> channel6 = (Channel) transformableKt$detectZoom$13.L$1;
                    AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) transformableKt$detectZoom$13.L$0;
                    ResultKt.throwOnFailure(obj);
                    f5 = f10;
                    channel3 = channel6;
                    z2 = z5;
                    f4 = f11;
                    function13 = function15;
                    awaitPointerEventScope3 = awaitPointerEventScope6;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    size = changes3.size();
                    int i13 = i2;
                    i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            i5 = 0;
                            break;
                        }
                        if (changes3.get(i4).isConsumed()) {
                            i5 = 1;
                            break;
                        }
                        i4++;
                    }
                    if (i5 != 0) {
                        float calculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent2);
                        float calculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent2);
                        float f12 = f5;
                        float f13 = f4;
                        long calculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent2);
                        if (i3 == 0) {
                            f6 = f12 * calculateZoom;
                            float f14 = f13 + calculateRotation;
                            long m3827plusMKHz9U = Offset.m3827plusMKHz9U(j, calculatePan);
                            int i14 = i3;
                            float calculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent2, false);
                            float abs = Math.abs(1 - f6) * calculateCentroidSize;
                            float abs2 = Math.abs(((3.1415927f * f14) * calculateCentroidSize) / 180.0f);
                            float m3820getDistanceimpl = Offset.m3820getDistanceimpl(m3827plusMKHz9U);
                            if (abs > f || abs2 > f || (m3820getDistanceimpl > f && function13.invoke(Offset.m3811boximpl(calculatePan)).booleanValue())) {
                                i6 = (!z2 || abs2 >= f) ? 0 : 1;
                                channel3.mo11746trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                                j4 = m3827plusMKHz9U;
                                i7 = 1;
                            } else {
                                i6 = i13;
                                j4 = m3827plusMKHz9U;
                                i7 = i14;
                            }
                            f8 = f14;
                        } else {
                            f6 = f12;
                            f8 = f13;
                            j4 = j;
                            i6 = i13;
                            i7 = i3;
                        }
                        if (i7 == 0) {
                            transformableKt$detectZoom$12 = transformableKt$detectZoom$13;
                        } else {
                            float f15 = i6 != 0 ? 0.0f : calculateRotation;
                            if (f15 != 0.0f) {
                                transformableKt$detectZoom$12 = transformableKt$detectZoom$13;
                            } else if (calculateZoom == 1.0f) {
                                transformableKt$detectZoom$12 = transformableKt$detectZoom$13;
                                if (!Offset.m3819equalsimpl0(calculatePan, Offset.INSTANCE.m3838getZeroF1C5BW0())) {
                                }
                                List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                                size2 = changes4.size();
                                for (i10 = 0; i10 < size2; i10++) {
                                    PointerInputChange pointerInputChange = changes4.get(i10);
                                    if (PointerEventKt.positionChanged(pointerInputChange)) {
                                        pointerInputChange.consume();
                                    }
                                }
                            } else {
                                transformableKt$detectZoom$12 = transformableKt$detectZoom$13;
                            }
                            channel3.mo11746trySendJP2dKIU(new TransformEvent.TransformDelta(calculateZoom, calculatePan, f15, null));
                            List<PointerInputChange> changes42 = pointerEvent2.getChanges();
                            size2 = changes42.size();
                            while (i10 < size2) {
                            }
                        }
                        j2 = j4;
                        f3 = f8;
                    } else {
                        int i15 = i3;
                        transformableKt$detectZoom$12 = transformableKt$detectZoom$13;
                        channel3.mo11746trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                        f6 = f5;
                        f3 = f4;
                        j2 = j;
                        i6 = i13;
                        i7 = i15;
                    }
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    TransformableKt$detectZoom$1 transformableKt$detectZoom$14 = transformableKt$detectZoom$12;
                    transformableKt$detectZoom$14.L$0 = awaitPointerEventScope3;
                    transformableKt$detectZoom$14.L$1 = channel3;
                    transformableKt$detectZoom$14.L$2 = function13;
                    transformableKt$detectZoom$14.L$3 = pointerEvent2;
                    transformableKt$detectZoom$14.Z$0 = z2;
                    transformableKt$detectZoom$14.F$0 = f3;
                    transformableKt$detectZoom$14.F$1 = f6;
                    transformableKt$detectZoom$14.J$0 = j2;
                    transformableKt$detectZoom$14.I$0 = i7;
                    transformableKt$detectZoom$14.F$2 = f;
                    transformableKt$detectZoom$14.I$1 = i6;
                    transformableKt$detectZoom$14.I$2 = i5;
                    transformableKt$detectZoom$14.label = 3;
                    awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, transformableKt$detectZoom$14);
                    if (awaitPointerEvent != coroutine_suspended) {
                        awaitPointerEventScope4 = awaitPointerEventScope3;
                        function12 = function13;
                        pointerEvent = pointerEvent2;
                        long j5 = j2;
                        f7 = f;
                        i8 = i6;
                        i9 = i7;
                        channel4 = channel3;
                        transformableKt$detectZoom$13 = transformableKt$detectZoom$14;
                        f2 = f6;
                        j3 = j5;
                        List<PointerInputChange> changes5 = ((PointerEvent) awaitPointerEvent).getChanges();
                        size3 = changes5.size();
                        Object obj22 = coroutine_suspended;
                        i11 = 0;
                        while (true) {
                            if (i11 >= size3) {
                            }
                            i11++;
                        }
                        boolean z42 = false;
                        if (i5 == 0) {
                            List<PointerInputChange> changes22 = pointerEvent.getChanges();
                            size4 = changes22.size();
                            while (i12 < size4) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                i2 = transformableKt$detectZoom$13.I$1;
                f = transformableKt$detectZoom$13.F$2;
                i3 = transformableKt$detectZoom$13.I$0;
                j = transformableKt$detectZoom$13.J$0;
                f2 = transformableKt$detectZoom$13.F$1;
                f3 = transformableKt$detectZoom$13.F$0;
                boolean z6 = transformableKt$detectZoom$13.Z$0;
                function12 = (Function1) transformableKt$detectZoom$13.L$2;
                Channel<TransformEvent> channel7 = (Channel) transformableKt$detectZoom$13.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) transformableKt$detectZoom$13.L$0;
                ResultKt.throwOnFailure(obj);
                z2 = z6;
                channel2 = channel7;
                transformableKt$detectZoom$13.L$0 = awaitPointerEventScope2;
                transformableKt$detectZoom$13.L$1 = channel2;
                transformableKt$detectZoom$13.L$2 = function12;
                transformableKt$detectZoom$13.L$3 = null;
                transformableKt$detectZoom$13.Z$0 = z2;
                transformableKt$detectZoom$13.F$0 = f3;
                transformableKt$detectZoom$13.F$1 = f2;
                transformableKt$detectZoom$13.J$0 = j;
                transformableKt$detectZoom$13.I$0 = i3;
                transformableKt$detectZoom$13.F$2 = f;
                transformableKt$detectZoom$13.I$1 = i2;
                transformableKt$detectZoom$13.label = 2;
                obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$13, 1, null);
                if (obj != coroutine_suspended) {
                    float f16 = f3;
                    f5 = f2;
                    channel3 = channel2;
                    f4 = f16;
                    AwaitPointerEventScope awaitPointerEventScope7 = awaitPointerEventScope2;
                    function13 = function12;
                    awaitPointerEventScope3 = awaitPointerEventScope7;
                    PointerEvent pointerEvent22 = (PointerEvent) obj;
                    List<PointerInputChange> changes32 = pointerEvent22.getChanges();
                    size = changes32.size();
                    int i132 = i2;
                    i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                        }
                        i4++;
                    }
                    if (i5 != 0) {
                    }
                    PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                    TransformableKt$detectZoom$1 transformableKt$detectZoom$142 = transformableKt$detectZoom$12;
                    transformableKt$detectZoom$142.L$0 = awaitPointerEventScope3;
                    transformableKt$detectZoom$142.L$1 = channel3;
                    transformableKt$detectZoom$142.L$2 = function13;
                    transformableKt$detectZoom$142.L$3 = pointerEvent22;
                    transformableKt$detectZoom$142.Z$0 = z2;
                    transformableKt$detectZoom$142.F$0 = f3;
                    transformableKt$detectZoom$142.F$1 = f6;
                    transformableKt$detectZoom$142.J$0 = j2;
                    transformableKt$detectZoom$142.I$0 = i7;
                    transformableKt$detectZoom$142.F$2 = f;
                    transformableKt$detectZoom$142.I$1 = i6;
                    transformableKt$detectZoom$142.I$2 = i5;
                    transformableKt$detectZoom$142.label = 3;
                    awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass2, transformableKt$detectZoom$142);
                    if (awaitPointerEvent != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        transformableKt$detectZoom$1 = new TransformableKt$detectZoom$1(continuation);
        TransformableKt$detectZoom$1 transformableKt$detectZoom$132 = transformableKt$detectZoom$1;
        obj = transformableKt$detectZoom$132.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = transformableKt$detectZoom$132.label;
        if (i != 0) {
        }
        transformableKt$detectZoom$132.L$0 = awaitPointerEventScope2;
        transformableKt$detectZoom$132.L$1 = channel2;
        transformableKt$detectZoom$132.L$2 = function12;
        transformableKt$detectZoom$132.L$3 = null;
        transformableKt$detectZoom$132.Z$0 = z2;
        transformableKt$detectZoom$132.F$0 = f3;
        transformableKt$detectZoom$132.F$1 = f2;
        transformableKt$detectZoom$132.J$0 = j;
        transformableKt$detectZoom$132.I$0 = i3;
        transformableKt$detectZoom$132.F$2 = f;
        transformableKt$detectZoom$132.I$1 = i2;
        transformableKt$detectZoom$132.label = 2;
        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$132, 1, null);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}

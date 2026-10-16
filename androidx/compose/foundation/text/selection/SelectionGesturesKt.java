package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* compiled from: SelectionGestures.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\b\u001a\u00020\u0006*\u00020\tH\u0082@¢\u0006\u0002\u0010\n\u001a&\u0010\u000b\u001a\u00020\u0005*\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u0012*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0000\u001a\"\u0010\u001e\u001a\u00020\u0012*\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u00020\u001a*\u00020\u001a2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\"H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"ClicksSlop", "", "STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "offset1", "Landroidx/compose/ui/geometry/Offset;", "offset2", "distanceIsTolerable-2x9bVx0", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JJ)Z", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionGesturesKt {
    public static final double ClicksSlop = 100.0d;
    private static final int STATIC_KEY = 8675309;

    public static final Modifier updateSelectionTouchMode(Modifier modifier, Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf(STATIC_KEY), new SelectionGesturesKt$updateSelectionTouchMode$1(function1, null));
    }

    public static final Modifier selectionGestureInput(Modifier modifier, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new SelectionGesturesKt$selectionGestureInput$1(mouseSelectionObserver, textDragObserver, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
    
        if (r12 != r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelection(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelection$1 selectionGesturesKt$touchSelection$1;
        Object obj;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelection$1) {
                selectionGesturesKt$touchSelection$1 = (SelectionGesturesKt$touchSelection$1) continuation;
                if ((selectionGesturesKt$touchSelection$1.label & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelection$1.label -= Integer.MIN_VALUE;
                    obj = selectionGesturesKt$touchSelection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = selectionGesturesKt$touchSelection$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                        long id = pointerInputChange.getId();
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelection$1.label = 1;
                        obj = DragGestureDetectorKt.m656awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, selectionGesturesKt$touchSelection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    PointerInputChange pointerInputChange3 = changes.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                        pointerInputChange3.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        PointerInputChange pointerInputChange4 = (PointerInputChange) selectionGesturesKt$touchSelection$1.L$2;
                        textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = pointerInputChange4;
                        awaitPointerEventScope = awaitPointerEventScope2;
                    }
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 != null && m1316distanceIsTolerable2x9bVx0(awaitPointerEventScope, pointerInputChange.getPosition(), pointerInputChange2.getPosition())) {
                        textDragObserver.mo1223onStartk4lQ0M(pointerInputChange2.getPosition());
                        long id2 = pointerInputChange2.getId();
                        Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                                invoke2(pointerInputChange5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PointerInputChange pointerInputChange5) {
                                TextDragObserver.this.mo1222onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                                pointerInputChange5.consume();
                            }
                        };
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = null;
                        selectionGesturesKt$touchSelection$1.label = 2;
                        obj = DragGestureDetectorKt.m665dragjO51t88(awaitPointerEventScope, id2, function1, selectionGesturesKt$touchSelection$1);
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 != null) {
                textDragObserver.mo1223onStartk4lQ0M(pointerInputChange2.getPosition());
                long id22 = pointerInputChange2.getId();
                Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelection$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange5) {
                        invoke2(pointerInputChange5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(PointerInputChange pointerInputChange5) {
                        TextDragObserver.this.mo1222onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange5));
                        pointerInputChange5.consume();
                    }
                };
                selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelection$1.L$2 = null;
                selectionGesturesKt$touchSelection$1.label = 2;
                obj = DragGestureDetectorKt.m665dragjO51t88(awaitPointerEventScope, id22, function12, selectionGesturesKt$touchSelection$1);
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
        selectionGesturesKt$touchSelection$1 = new SelectionGesturesKt$touchSelection$1(continuation);
        obj = selectionGesturesKt$touchSelection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$touchSelection$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
    
        if (r11 == r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ee, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ec, code lost:
    
        if (r11 == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$1;
        int i;
        final SelectionAdjustment none;
        if (continuation instanceof SelectionGesturesKt$mouseSelection$1) {
            selectionGesturesKt$mouseSelection$1 = (SelectionGesturesKt$mouseSelection$1) continuation;
            if ((selectionGesturesKt$mouseSelection$1.label & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$mouseSelection$1.label -= Integer.MIN_VALUE;
                Object obj = selectionGesturesKt$mouseSelection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = selectionGesturesKt$mouseSelection$1.label;
                int i2 = 0;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    clicksCounter.update(pointerEvent);
                    PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                    if (TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                        if (mouseSelectionObserver.mo1295onExtendk4lQ0M(pointerInputChange.getPosition())) {
                            long id = pointerInputChange.getId();
                            Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$1
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
                                    if (MouseSelectionObserver.this.mo1296onExtendDragk4lQ0M(pointerInputChange2.getPosition())) {
                                        pointerInputChange2.consume();
                                    }
                                }
                            };
                            selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.label = 1;
                            obj = DragGestureDetectorKt.m665dragjO51t88(awaitPointerEventScope, id, function1, selectionGesturesKt$mouseSelection$1);
                        }
                    } else {
                        int clicks = clicksCounter.getClicks();
                        if (clicks == 1) {
                            none = SelectionAdjustment.INSTANCE.getNone();
                        } else if (clicks == 2) {
                            none = SelectionAdjustment.INSTANCE.getWord();
                        } else {
                            none = SelectionAdjustment.INSTANCE.getParagraph();
                        }
                        if (mouseSelectionObserver.mo1297onStart3MmeM6k(pointerInputChange.getPosition(), none)) {
                            long id2 = pointerInputChange.getId();
                            Function1<PointerInputChange, Unit> function12 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$shouldConsumeUp$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    if (MouseSelectionObserver.this.mo1294onDrag3MmeM6k(pointerInputChange2.getPosition(), none)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                            };
                            selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.label = 2;
                            obj = DragGestureDetectorKt.m665dragjO51t88(awaitPointerEventScope, id2, function12, selectionGesturesKt$mouseSelection$1);
                        }
                    }
                } else if (i == 1) {
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size = changes.size();
                        while (i2 < size) {
                            PointerInputChange pointerInputChange2 = changes.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size2 = changes2.size();
                        while (i2 < size2) {
                            PointerInputChange pointerInputChange3 = changes2.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            }
        }
        selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(continuation);
        Object obj2 = selectionGesturesKt$mouseSelection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$mouseSelection$1.label;
        int i22 = 0;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0043 -> B:10:0x0046). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        SelectionGesturesKt$awaitDown$1 selectionGesturesKt$awaitDown$1;
        int i;
        int size;
        int i2;
        if (continuation instanceof SelectionGesturesKt$awaitDown$1) {
            selectionGesturesKt$awaitDown$1 = (SelectionGesturesKt$awaitDown$1) continuation;
            if ((selectionGesturesKt$awaitDown$1.label & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$awaitDown$1.label -= Integer.MIN_VALUE;
                Object obj = selectionGesturesKt$awaitDown$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = selectionGesturesKt$awaitDown$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    PointerEventPass pointerEventPass = PointerEventPass.Main;
                    selectionGesturesKt$awaitDown$1.L$0 = awaitPointerEventScope;
                    selectionGesturesKt$awaitDown$1.label = 1;
                    obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, selectionGesturesKt$awaitDown$1);
                    if (obj == coroutine_suspended) {
                    }
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i2 = 0;
                    while (i2 < size) {
                    }
                    return pointerEvent;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$awaitDown$1.L$0;
                ResultKt.throwOnFailure(obj);
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                size = changes2.size();
                i2 = 0;
                while (i2 < size) {
                    if (PointerEventKt.changedToDownIgnoreConsumed(changes2.get(i2))) {
                        i2++;
                    } else {
                        PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                        selectionGesturesKt$awaitDown$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$awaitDown$1.label = 1;
                        obj = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, selectionGesturesKt$awaitDown$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerEvent pointerEvent22 = (PointerEvent) obj;
                        List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                        size = changes22.size();
                        i2 = 0;
                        while (i2 < size) {
                        }
                    }
                }
                return pointerEvent22;
            }
        }
        selectionGesturesKt$awaitDown$1 = new SelectionGesturesKt$awaitDown$1(continuation);
        Object obj2 = selectionGesturesKt$awaitDown$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$awaitDown$1.label;
        if (i != 0) {
        }
    }

    /* renamed from: distanceIsTolerable-2x9bVx0, reason: not valid java name */
    private static final boolean m1316distanceIsTolerable2x9bVx0(AwaitPointerEventScope awaitPointerEventScope, long j, long j2) {
        return Offset.m3820getDistanceimpl(Offset.m3826minusMKHz9U(j, j2)) < awaitPointerEventScope.getViewConfiguration().getTouchSlop();
    }

    public static final boolean isPrecisePointer(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m5279equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m5284getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}

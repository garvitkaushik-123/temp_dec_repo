package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;

/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1", f = "Draggable.kt", i = {}, l = {456}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class AbstractDraggableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AbstractDraggableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractDraggableNode$pointerInputNode$1(AbstractDraggableNode abstractDraggableNode, Continuation<? super AbstractDraggableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = abstractDraggableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AbstractDraggableNode$pointerInputNode$1 abstractDraggableNode$pointerInputNode$1 = new AbstractDraggableNode$pointerInputNode$1(this.this$0, continuation);
        abstractDraggableNode$pointerInputNode$1.L$0 = obj;
        return abstractDraggableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((AbstractDraggableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            if (!this.this$0.getEnabled()) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, this.this$0, null), this) == coroutine_suspended) {
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

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {458}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AbstractDraggableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, AbstractDraggableNode abstractDraggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = abstractDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            CancellationException e;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (this.$$this$SuspendingPointerInputModifierNode.awaitPointerEventScope(new C00091(coroutineScope2, this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (CancellationException e2) {
                    coroutineScope = coroutineScope2;
                    e = e2;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        throw e;
                    }
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException e3) {
                    e = e3;
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }

        /* compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1$1", f = "Draggable.kt", i = {0, 1, 1}, l = {460, 475}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "isDragSuccessful"}, s = {"L$0", "L$0", "I$0"})
        /* renamed from: androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00091 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            int I$0;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ AbstractDraggableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00091(CoroutineScope coroutineScope, AbstractDraggableNode abstractDraggableNode, Continuation<? super C00091> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.this$0 = abstractDraggableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00091 c00091 = new C00091(this.$$this$coroutineScope, this.this$0, continuation);
                c00091.L$0 = obj;
                return c00091;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00091) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Can't wrap try/catch for region: R(11:26|(1:28)|29|30|31|32|33|34|35|36|(9:38|9|10|11|(0)(0)|17|18|19|(2:73|74)(0))) */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x013d, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x0158, code lost:
            
                r5 = r1;
                r4 = r16;
                r3 = r17;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x013b, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:60:0x014f, code lost:
            
                r4 = r16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x0144, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
            
                r16 = r3;
                r17 = r4;
                r11 = r8;
             */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x013f, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:65:0x0140, code lost:
            
                r16 = r3;
                r11 = r8;
             */
            /* JADX WARN: Code restructure failed: missing block: B:67:0x0152, code lost:
            
                r0 = e;
             */
            /* JADX WARN: Code restructure failed: missing block: B:68:0x0153, code lost:
            
                r11 = r2;
                r16 = r3;
                r17 = r4;
             */
            /* JADX WARN: Code restructure failed: missing block: B:69:0x014b, code lost:
            
                r0 = th;
             */
            /* JADX WARN: Code restructure failed: missing block: B:70:0x014c, code lost:
            
                r11 = r2;
                r16 = r3;
             */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0100  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0163  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0186 A[Catch: all -> 0x0187, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0187, blocks: (B:43:0x015d, B:46:0x0186), top: B:42:0x015d }] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x019d  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x01c4  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x01d1  */
            /* JADX WARN: Removed duplicated region for block: B:73:0x01d8  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x0129  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00df -> B:9:0x00e5). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0163 -> B:18:0x0180). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01d1 -> B:19:0x0052). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                DefaultConstructorMarker defaultConstructorMarker;
                Throwable th;
                DragEvent dragEvent;
                Channel channel;
                VelocityTracker velocityTracker;
                VelocityTracker velocityTracker2;
                CancellationException e;
                Channel channel2;
                DefaultConstructorMarker defaultConstructorMarker2;
                AwaitPointerEventScope awaitPointerEventScope2;
                Object obj2;
                Pair pair;
                boolean z;
                VelocityTracker velocityTracker3;
                Channel channel3;
                Object m683awaitDragSu4bsnU;
                Function1 function1;
                Function0 function0;
                VelocityTracker velocityTracker4;
                DragEvent dragEvent2;
                Channel channel4;
                VelocityTracker velocityTracker5;
                VelocityTracker velocityTracker6;
                C00091 c00091 = this;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = c00091.label;
                int i2 = 0;
                DefaultConstructorMarker defaultConstructorMarker3 = null;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) c00091.L$0;
                    if (CoroutineScopeKt.isActive(c00091.$$this$coroutineScope)) {
                    }
                } else if (i == 1) {
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) c00091.L$0;
                    ResultKt.throwOnFailure(obj);
                    defaultConstructorMarker2 = null;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    obj2 = obj;
                    pair = (Pair) obj2;
                    if (pair == null) {
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i3 = c00091.I$0;
                    CoroutineScope coroutineScope = (CoroutineScope) c00091.L$2;
                    AbstractDraggableNode abstractDraggableNode = (AbstractDraggableNode) c00091.L$1;
                    AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) c00091.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        m683awaitDragSu4bsnU = obj;
                        defaultConstructorMarker = null;
                    } catch (CancellationException e2) {
                        e = e2;
                        defaultConstructorMarker = null;
                        try {
                            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                throw e;
                            }
                            ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractDraggableNode, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                            DragEvent.DragCancelled dragCancelled = DragEvent.DragCancelled.INSTANCE;
                            channel2 = abstractDraggableNode.channel;
                            channel2.mo11746trySendJP2dKIU(dragCancelled);
                            awaitPointerEventScope = awaitPointerEventScope4;
                            c00091 = this;
                            defaultConstructorMarker3 = defaultConstructorMarker;
                            if (CoroutineScopeKt.isActive(c00091.$$this$coroutineScope)) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractDraggableNode, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                            if (i2 == 0) {
                                velocityTracker = abstractDraggableNode.velocityTracker;
                                long m5307calculateVelocityAH228Gc = velocityTracker.m5307calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                                velocityTracker2 = abstractDraggableNode.velocityTracker;
                                velocityTracker2.resetTracking();
                                dragEvent = new DragEvent.DragStopped(Velocity.m6630timesadjELrA(m5307calculateVelocityAH228Gc, abstractDraggableNode.getReverseDirection() ? -1.0f : 1.0f), defaultConstructorMarker);
                            } else {
                                dragEvent = DragEvent.DragCancelled.INSTANCE;
                            }
                            channel = abstractDraggableNode.channel;
                            channel.mo11746trySendJP2dKIU(dragEvent);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        defaultConstructorMarker = null;
                        i2 = i3;
                        float maximumFlingVelocity2 = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractDraggableNode, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                        if (i2 == 0) {
                        }
                        channel = abstractDraggableNode.channel;
                        channel.mo11746trySendJP2dKIU(dragEvent);
                        throw th;
                    }
                    try {
                    } catch (CancellationException e3) {
                        e = e3;
                        if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        i2 = i3;
                        float maximumFlingVelocity22 = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractDraggableNode, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                        if (i2 == 0) {
                        }
                        channel = abstractDraggableNode.channel;
                        channel.mo11746trySendJP2dKIU(dragEvent);
                        throw th;
                    }
                    boolean booleanValue = ((Boolean) m683awaitDragSu4bsnU).booleanValue();
                    float maximumFlingVelocity3 = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractDraggableNode, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                    if (booleanValue) {
                        dragEvent2 = DragEvent.DragCancelled.INSTANCE;
                    } else {
                        velocityTracker5 = abstractDraggableNode.velocityTracker;
                        long m5307calculateVelocityAH228Gc2 = velocityTracker5.m5307calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity3, maximumFlingVelocity3));
                        velocityTracker6 = abstractDraggableNode.velocityTracker;
                        velocityTracker6.resetTracking();
                        dragEvent2 = new DragEvent.DragStopped(Velocity.m6630timesadjELrA(m5307calculateVelocityAH228Gc2, abstractDraggableNode.getReverseDirection() ? -1.0f : 1.0f), defaultConstructorMarker);
                    }
                    channel4 = abstractDraggableNode.channel;
                    channel4.mo11746trySendJP2dKIU(dragEvent2);
                    awaitPointerEventScope = awaitPointerEventScope4;
                    c00091 = this;
                    defaultConstructorMarker3 = defaultConstructorMarker;
                    if (CoroutineScopeKt.isActive(c00091.$$this$coroutineScope)) {
                        function1 = c00091.this$0._canDrag;
                        function0 = c00091.this$0._startDragImmediately;
                        velocityTracker4 = c00091.this$0.velocityTracker;
                        c00091.L$0 = awaitPointerEventScope;
                        c00091.L$1 = defaultConstructorMarker3;
                        c00091.L$2 = defaultConstructorMarker3;
                        c00091.label = 1;
                        obj2 = DraggableKt.awaitDownAndSlop(awaitPointerEventScope, function1, function0, velocityTracker4, c00091.this$0.getPointerDirectionConfig(), c00091);
                        if (obj2 != coroutine_suspended) {
                            AwaitPointerEventScope awaitPointerEventScope5 = awaitPointerEventScope;
                            defaultConstructorMarker2 = defaultConstructorMarker3;
                            awaitPointerEventScope2 = awaitPointerEventScope5;
                            pair = (Pair) obj2;
                            if (pair == null) {
                                final AbstractDraggableNode abstractDraggableNode2 = c00091.this$0;
                                CoroutineScope coroutineScope2 = c00091.$$this$coroutineScope;
                                z = abstractDraggableNode2.isListeningForEvents;
                                if (!z) {
                                    abstractDraggableNode2.startListeningForEvents();
                                }
                                PointerInputChange pointerInputChange = (PointerInputChange) pair.getFirst();
                                long packedValue = ((Offset) pair.getSecond()).getPackedValue();
                                DefaultConstructorMarker defaultConstructorMarker4 = defaultConstructorMarker2;
                                velocityTracker3 = abstractDraggableNode2.velocityTracker;
                                channel3 = abstractDraggableNode2.channel;
                                Channel channel5 = channel3;
                                boolean reverseDirection = abstractDraggableNode2.getReverseDirection();
                                Function1<PointerInputChange, Boolean> function12 = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.AbstractDraggableNode$pointerInputNode$1$1$1$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(PointerInputChange pointerInputChange2) {
                                        return Boolean.valueOf(!(AbstractDraggableNode.this.getPointerDirectionConfig().mo670calculateDeltaChangek4lQ0M(PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2)) == 0.0f));
                                    }
                                };
                                c00091.L$0 = awaitPointerEventScope2;
                                c00091.L$1 = abstractDraggableNode2;
                                c00091.L$2 = coroutineScope2;
                                c00091.I$0 = 0;
                                c00091.label = 2;
                                defaultConstructorMarker = defaultConstructorMarker4;
                                AbstractDraggableNode abstractDraggableNode3 = abstractDraggableNode2;
                                CoroutineScope coroutineScope3 = coroutineScope2;
                                m683awaitDragSu4bsnU = DraggableKt.m683awaitDragSu4bsnU(awaitPointerEventScope2, pointerInputChange, packedValue, velocityTracker3, channel5, reverseDirection, function12, c00091);
                                if (m683awaitDragSu4bsnU != coroutine_suspended) {
                                    awaitPointerEventScope4 = awaitPointerEventScope2;
                                    i3 = 0;
                                    abstractDraggableNode = abstractDraggableNode3;
                                    coroutineScope = coroutineScope3;
                                    boolean booleanValue2 = ((Boolean) m683awaitDragSu4bsnU).booleanValue();
                                    float maximumFlingVelocity32 = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractDraggableNode, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                                    if (booleanValue2) {
                                    }
                                    channel4 = abstractDraggableNode.channel;
                                    channel4.mo11746trySendJP2dKIU(dragEvent2);
                                    awaitPointerEventScope = awaitPointerEventScope4;
                                    c00091 = this;
                                    defaultConstructorMarker3 = defaultConstructorMarker;
                                    if (CoroutineScopeKt.isActive(c00091.$$this$coroutineScope)) {
                                        return Unit.INSTANCE;
                                    }
                                }
                            } else {
                                DefaultConstructorMarker defaultConstructorMarker5 = defaultConstructorMarker2;
                                awaitPointerEventScope = awaitPointerEventScope2;
                                defaultConstructorMarker3 = defaultConstructorMarker5;
                                c00091 = this;
                                if (CoroutineScopeKt.isActive(c00091.$$this$coroutineScope)) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            }
        }
    }
}

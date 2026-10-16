package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;

/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1", f = "Transformable.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TransformableNode$pointerInputNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TransformableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableNode$pointerInputNode$1(TransformableNode transformableNode, Continuation<? super TransformableNode$pointerInputNode$1> continuation) {
        super(2, continuation);
        this.this$0 = transformableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableNode$pointerInputNode$1 transformableNode$pointerInputNode$1 = new TransformableNode$pointerInputNode$1(this.this$0, continuation);
        transformableNode$pointerInputNode$1.L$0 = obj;
        return transformableNode$pointerInputNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((TransformableNode$pointerInputNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            z = this.this$0.enabled;
            if (!z) {
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

    /* compiled from: Transformable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1", f = "Transformable.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TransformableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PointerInputScope pointerInputScope, TransformableNode transformableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = transformableNode;
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

        /* compiled from: Transformable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1", f = "Transformable.kt", i = {0, 0, 1}, l = {158, 161}, m = "invokeSuspend", n = {"$this$launch", "event", "$this$launch"}, s = {"L$0", "L$1", "L$0"})
        /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ TransformableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00151(TransformableNode transformableNode, Continuation<? super C00151> continuation) {
                super(2, continuation);
                this.this$0 = transformableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00151 c00151 = new C00151(this.this$0, continuation);
                c00151.L$0 = obj;
                return c00151;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0085, code lost:
            
                if (r10.transform(androidx.compose.foundation.MutatePriority.UserInput, new androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00151.C00161(r4, r9.this$0, null), r9) == r0) goto L23;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0088 -> B:9:0x0036). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope;
                T t;
                CoroutineScope coroutineScope2;
                Ref.ObjectRef objectRef;
                Ref.ObjectRef objectRef2;
                TransformableState transformableState;
                Channel channel;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                } else if (i == 1) {
                    objectRef2 = (Ref.ObjectRef) this.L$2;
                    objectRef = (Ref.ObjectRef) this.L$1;
                    coroutineScope2 = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    t = obj;
                    objectRef2.element = t;
                    if (objectRef.element instanceof TransformEvent.TransformStarted) {
                        transformableState = this.this$0.state;
                        this.L$0 = coroutineScope2;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 2;
                    }
                    coroutineScope = coroutineScope2;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (CancellationException unused) {
                    }
                    coroutineScope = coroutineScope3;
                }
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    objectRef2 = new Ref.ObjectRef();
                    channel = this.this$0.channel;
                    this.L$0 = coroutineScope;
                    this.L$1 = objectRef2;
                    this.L$2 = objectRef2;
                    this.label = 1;
                    Object receive = channel.receive(this);
                    if (receive != coroutine_suspended) {
                        coroutineScope2 = coroutineScope;
                        t = receive;
                        objectRef = objectRef2;
                        objectRef2.element = t;
                        if (objectRef.element instanceof TransformEvent.TransformStarted) {
                        }
                        coroutineScope = coroutineScope2;
                        if (!CoroutineScopeKt.isActive(coroutineScope)) {
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                }
            }

            /* compiled from: Transformable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1", f = "Transformable.kt", i = {0}, l = {166}, m = "invokeSuspend", n = {"$this$transform"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00161 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.ObjectRef<TransformEvent> $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ TransformableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00161(Ref.ObjectRef<TransformEvent> objectRef, TransformableNode transformableNode, Continuation<? super C00161> continuation) {
                    super(2, continuation);
                    this.$event = objectRef;
                    this.this$0 = transformableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00161 c00161 = new C00161(this.$event, this.this$0, continuation);
                    c00161.L$0 = obj;
                    return c00161;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
                    return ((C00161) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0061 -> B:5:0x0064). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    TransformScope transformScope;
                    Channel channel;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        transformScope = (TransformScope) this.L$0;
                        if (!(this.$event.element instanceof TransformEvent.TransformStopped)) {
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Ref.ObjectRef<TransformEvent> objectRef = (Ref.ObjectRef) this.L$1;
                        transformScope = (TransformScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        T t = obj;
                        objectRef.element = t;
                        if (!(this.$event.element instanceof TransformEvent.TransformStopped)) {
                            TransformEvent transformEvent = this.$event.element;
                            TransformEvent.TransformDelta transformDelta = transformEvent instanceof TransformEvent.TransformDelta ? (TransformEvent.TransformDelta) transformEvent : null;
                            if (transformDelta != null) {
                                transformScope.mo646transformByd4ec7I(transformDelta.getZoomChange(), transformDelta.getPanChange(), transformDelta.getRotationChange());
                            }
                            objectRef = this.$event;
                            channel = this.this$0.channel;
                            this.L$0 = transformScope;
                            this.L$1 = objectRef;
                            this.label = 1;
                            Object receive = channel.receive(this);
                            t = receive;
                            if (receive == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef.element = t;
                            if (!(this.$event.element instanceof TransformEvent.TransformStopped)) {
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C00151(this.this$0, null), 1, null);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$$this$SuspendingPointerInputModifierNode, new AnonymousClass2(this.this$0, coroutineScope, null), this) == coroutine_suspended) {
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

        /* compiled from: Transformable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2", f = "Transformable.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransformableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TransformableNode transformableNode, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = transformableNode;
                this.$$this$coroutineScope = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$$this$coroutineScope, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Channel channel;
                boolean z;
                Channel channel2;
                Function1 function1;
                Object detectZoom;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            z = this.this$0.lockRotationOnZoomPan;
                            channel2 = this.this$0.channel;
                            function1 = this.this$0.updatedCanPan;
                            this.label = 1;
                            detectZoom = TransformableKt.detectZoom(awaitPointerEventScope, z, channel2, function1, this);
                            if (detectZoom == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                    } catch (CancellationException e) {
                        if (!CoroutineScopeKt.isActive(this.$$this$coroutineScope)) {
                            throw e;
                        }
                    }
                    return Unit.INSTANCE;
                } finally {
                    channel = this.this$0.channel;
                    channel.mo11746trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                }
            }
        }
    }
}

package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.time.DurationKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
    final /* synthetic */ Function1<Offset, Unit> $onLongPress;
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = pointerInputScope;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function12;
        this.$onTap = function13;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapGestures, new AnonymousClass1(coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, pressGestureScopeImpl, null), this) == coroutine_suspended) {
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

    /* compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {100, 114, 129, ModuleDescriptor.MODULE_VERSION, 156, 178}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "longPressTimeout", "$this$awaitEachGesture", "upOrCancel", "secondDown"}, s = {"L$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$coroutineScope = coroutineScope;
            this.$onPress = function3;
            this.$onLongPress = function1;
            this.$onDoubleTap = function12;
            this.$onTap = function13;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0257, code lost:
        
            if (r2 == r1) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x021f, code lost:
        
            if (r2.withTimeout(r4, new androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2.AnonymousClass1.AnonymousClass9(r18.$$this$coroutineScope, r18.$onDoubleTap, r18.$onTap, r11, r18.$pressScope, null), r18) == r1) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x015f, code lost:
        
            if (r7 != r1) goto L46;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0229  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x023c  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0109 A[Catch: PointerEventTimeoutCancellationException -> 0x0139, TryCatch #1 {PointerEventTimeoutCancellationException -> 0x0139, blocks: (B:55:0x0103, B:57:0x0109, B:59:0x011d), top: B:54:0x0103 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x011d A[Catch: PointerEventTimeoutCancellationException -> 0x0139, TRY_LEAVE, TryCatch #1 {PointerEventTimeoutCancellationException -> 0x0139, blocks: (B:55:0x0103, B:57:0x0109, B:59:0x011d), top: B:54:0x0103 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x00d7  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object awaitFirstDown$default;
            AwaitPointerEventScope awaitPointerEventScope;
            PointerInputChange pointerInputChange;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function32;
            long longPressTimeoutMillis;
            Ref.ObjectRef objectRef;
            Object withTimeout;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange2;
            Ref.ObjectRef objectRef2;
            AwaitPointerEventScope awaitPointerEventScope3;
            Function1<Offset, Unit> function1;
            Object consumeUntilUp;
            T t;
            Object awaitSecondDown;
            Ref.ObjectRef objectRef3;
            AwaitPointerEventScope awaitPointerEventScope4;
            PointerInputChange pointerInputChange3;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function33;
            AwaitPointerEventScope awaitPointerEventScope5;
            PointerInputChange pointerInputChange4;
            Ref.ObjectRef objectRef4;
            Function1<Offset, Unit> function12;
            Function1<Offset, Unit> function13;
            Object consumeUntilUp2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope6;
                    this.label = 1;
                    awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope6, false, null, this, 3, null);
                    if (awaitFirstDown$default != coroutine_suspended) {
                        awaitPointerEventScope = awaitPointerEventScope6;
                        pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                        pointerInputChange.consume();
                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new C00131(this.$pressScope, null), 3, null);
                        function3 = this.$onPress;
                        function32 = TapGestureDetectorKt.NoPressGesture;
                        if (function3 != function32) {
                            BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$onPress, this.$pressScope, pointerInputChange, null), 3, null);
                        }
                        longPressTimeoutMillis = this.$onLongPress == null ? awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis() : DurationKt.MAX_MILLIS;
                        objectRef = new Ref.ObjectRef();
                        try {
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = pointerInputChange;
                            this.L$2 = objectRef;
                            this.L$3 = objectRef;
                            this.J$0 = longPressTimeoutMillis;
                            this.label = 2;
                            withTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new AnonymousClass3(null), this);
                        } catch (PointerEventTimeoutCancellationException unused) {
                            awaitPointerEventScope3 = awaitPointerEventScope;
                            function1 = this.$onLongPress;
                            if (function1 != null) {
                                function1.invoke(Offset.m3811boximpl(pointerInputChange.getPosition()));
                            }
                            this.L$0 = awaitPointerEventScope3;
                            this.L$1 = objectRef;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = longPressTimeoutMillis;
                            this.label = 3;
                            consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this);
                            break;
                        }
                        if (withTimeout != coroutine_suspended) {
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            pointerInputChange2 = pointerInputChange;
                            objectRef2 = objectRef;
                            t = withTimeout;
                            try {
                                objectRef.element = t;
                                if (objectRef2.element != 0) {
                                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                                } else {
                                    ((PointerInputChange) objectRef2.element).consume();
                                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                                }
                                objectRef = objectRef2;
                            } catch (PointerEventTimeoutCancellationException unused2) {
                                objectRef = objectRef2;
                                pointerInputChange = pointerInputChange2;
                                awaitPointerEventScope3 = awaitPointerEventScope2;
                                function1 = this.$onLongPress;
                                if (function1 != null) {
                                }
                                this.L$0 = awaitPointerEventScope3;
                                this.L$1 = objectRef;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.J$0 = longPressTimeoutMillis;
                                this.label = 3;
                                consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this);
                            }
                            if (objectRef.element != 0) {
                                if (this.$onDoubleTap != null) {
                                    this.L$0 = awaitPointerEventScope2;
                                    this.L$1 = objectRef;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.J$0 = longPressTimeoutMillis;
                                    this.label = 4;
                                    awaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) objectRef.element, this);
                                    if (awaitSecondDown != coroutine_suspended) {
                                        objectRef3 = objectRef;
                                        awaitPointerEventScope4 = awaitPointerEventScope2;
                                        pointerInputChange3 = (PointerInputChange) awaitSecondDown;
                                        if (pointerInputChange3 == null) {
                                            BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function34 = this.$onPress;
                                            function33 = TapGestureDetectorKt.NoPressGesture;
                                            if (function34 != function33) {
                                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                            }
                                            try {
                                                this.L$0 = awaitPointerEventScope4;
                                                this.L$1 = objectRef3;
                                                this.L$2 = pointerInputChange3;
                                                this.label = 5;
                                                break;
                                            } catch (PointerEventTimeoutCancellationException unused3) {
                                                awaitPointerEventScope5 = awaitPointerEventScope4;
                                                pointerInputChange4 = pointerInputChange3;
                                                objectRef4 = objectRef3;
                                                function12 = this.$onTap;
                                                if (function12 != null) {
                                                }
                                                function13 = this.$onLongPress;
                                                if (function13 != null) {
                                                }
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.L$2 = null;
                                                this.label = 6;
                                                consumeUntilUp2 = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, this);
                                                break;
                                            }
                                        } else {
                                            Function1<Offset, Unit> function14 = this.$onTap;
                                            if (function14 != null) {
                                                function14.invoke(Offset.m3811boximpl(((PointerInputChange) objectRef3.element).getPosition()));
                                            }
                                        }
                                    }
                                } else {
                                    Function1<Offset, Unit> function15 = this.$onTap;
                                    if (function15 != null) {
                                        function15.invoke(Offset.m3811boximpl(((PointerInputChange) objectRef.element).getPosition()));
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = awaitPointerEventScope7;
                    awaitFirstDown$default = obj;
                    pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                    pointerInputChange.consume();
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new C00131(this.$pressScope, null), 3, null);
                    function3 = this.$onPress;
                    function32 = TapGestureDetectorKt.NoPressGesture;
                    if (function3 != function32) {
                    }
                    if (this.$onLongPress == null) {
                    }
                    objectRef = new Ref.ObjectRef();
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = pointerInputChange;
                    this.L$2 = objectRef;
                    this.L$3 = objectRef;
                    this.J$0 = longPressTimeoutMillis;
                    this.label = 2;
                    withTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new AnonymousClass3(null), this);
                    if (withTimeout != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 2:
                    longPressTimeoutMillis = this.J$0;
                    objectRef = (Ref.ObjectRef) this.L$3;
                    Ref.ObjectRef objectRef5 = (Ref.ObjectRef) this.L$2;
                    pointerInputChange = (PointerInputChange) this.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        pointerInputChange2 = pointerInputChange;
                        objectRef2 = objectRef5;
                        t = obj;
                        objectRef.element = t;
                        if (objectRef2.element != 0) {
                        }
                        objectRef = objectRef2;
                    } catch (PointerEventTimeoutCancellationException unused4) {
                        objectRef = objectRef5;
                        awaitPointerEventScope3 = awaitPointerEventScope;
                        function1 = this.$onLongPress;
                        if (function1 != null) {
                        }
                        this.L$0 = awaitPointerEventScope3;
                        this.L$1 = objectRef;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.J$0 = longPressTimeoutMillis;
                        this.label = 3;
                        consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this);
                        break;
                    }
                    if (objectRef.element != 0) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    longPressTimeoutMillis = this.J$0;
                    objectRef = (Ref.ObjectRef) this.L$1;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    if (objectRef.element != 0) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    longPressTimeoutMillis = this.J$0;
                    Ref.ObjectRef objectRef6 = (Ref.ObjectRef) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope8 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef3 = objectRef6;
                    awaitPointerEventScope4 = awaitPointerEventScope8;
                    awaitSecondDown = obj;
                    pointerInputChange3 = (PointerInputChange) awaitSecondDown;
                    if (pointerInputChange3 == null) {
                    }
                    return Unit.INSTANCE;
                case 5:
                    pointerInputChange4 = (PointerInputChange) this.L$2;
                    objectRef4 = (Ref.ObjectRef) this.L$1;
                    awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (PointerEventTimeoutCancellationException unused5) {
                        function12 = this.$onTap;
                        if (function12 != null) {
                            function12.invoke(Offset.m3811boximpl(((PointerInputChange) objectRef4.element).getPosition()));
                        }
                        function13 = this.$onLongPress;
                        if (function13 != null) {
                            function13.invoke(Offset.m3811boximpl(pointerInputChange4.getPosition()));
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 6;
                        consumeUntilUp2 = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, this);
                        break;
                    }
                    return Unit.INSTANCE;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00131(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00131> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00131(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$pressScope.reset(this) == coroutine_suspended) {
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
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputChange $down;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$down = pointerInputChange;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$onPress, this.$pressScope, this.$down, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    Offset m3811boximpl = Offset.m3811boximpl(this.$down.getPosition());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, m3811boximpl, this) == coroutine_suspended) {
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
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
        static final class AnonymousClass3 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                return ((AnonymousClass3) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                Object waitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default((AwaitPointerEventScope) this.L$0, null, this, 1, null);
                return waitForUpOrCancellation$default == coroutine_suspended ? coroutine_suspended : waitForUpOrCancellation$default;
            }
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.cancel();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
        static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
        static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass7(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$pressScope.reset(this) == coroutine_suspended) {
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
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
        static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ PointerInputChange $secondDown;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass8(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass8> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$secondDown = pointerInputChange;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass8(this.$onPress, this.$pressScope, this.$secondDown, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    Offset m3811boximpl = Offset.m3811boximpl(this.$secondDown.getPosition());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, m3811boximpl, this) == coroutine_suspended) {
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
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9", f = "TapGestureDetector.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9, reason: invalid class name */
        static final class AnonymousClass9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ Ref.ObjectRef<PointerInputChange> $upOrCancel;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass9(CoroutineScope coroutineScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Ref.ObjectRef<PointerInputChange> objectRef, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass9> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onDoubleTap = function1;
                this.$onTap = function12;
                this.$upOrCancel = objectRef;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, this.$upOrCancel, this.$pressScope, continuation);
                anonymousClass9.L$0 = obj;
                return anonymousClass9;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = TapGestureDetectorKt.waitForUpOrCancellation$default((AwaitPointerEventScope) this.L$0, null, this, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange == null) {
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$pressScope, null), 3, null);
                    Function1<Offset, Unit> function1 = this.$onTap;
                    if (function1 == null) {
                        return null;
                    }
                    function1.invoke(Offset.m3811boximpl(this.$upOrCancel.element.getPosition()));
                    return Unit.INSTANCE;
                }
                pointerInputChange.consume();
                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new C00141(this.$pressScope, null), 3, null);
                this.$onDoubleTap.invoke(Offset.m3811boximpl(pointerInputChange.getPosition()));
                return Unit.INSTANCE;
            }

            /* compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1, reason: invalid class name and collision with other inner class name */
            static final class C00141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00141(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00141> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00141(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                }
            }

            /* compiled from: TapGestureDetector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$pressScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                }
            }
        }

        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10, reason: invalid class name */
        static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass10(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass10> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass10(this.$pressScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }
        }
    }
}

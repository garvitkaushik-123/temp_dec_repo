package androidx.compose.foundation.text2.input.internal.selection;

import adn.analytics.Analytics;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TapAndDoubleTapGesture.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2", f = "TapAndDoubleTapGesture.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TapOnPosition $onDoubleTap;
    final /* synthetic */ TapOnPosition $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapAndDoubleTap;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation<? super TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2> continuation) {
        super(2, continuation);
        this.$this_detectTapAndDoubleTap = pointerInputScope;
        this.$onTap = tapOnPosition;
        this.$onDoubleTap = tapOnPosition2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2(this.$this_detectTapAndDoubleTap, this.$onTap, this.$onDoubleTap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: TapAndDoubleTapGesture.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1", f = "TapAndDoubleTapGesture.kt", i = {0, 1, 1, 2, 2, 3, 3, 4}, l = {44, 50, 54, 64, 69, Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture", "longPressTimeout", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0"})
    /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapOnPosition $onDoubleTap;
        final /* synthetic */ TapOnPosition $onTap;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TapOnPosition tapOnPosition, TapOnPosition tapOnPosition2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onTap = tapOnPosition;
            this.$onDoubleTap = tapOnPosition2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onTap, this.$onDoubleTap, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x00dc, code lost:
        
            if (r10 == r0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
        
            if (r10 == r0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00eb, code lost:
        
            if (r10 != r0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
        
            if (r10 != r0) goto L29;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v6 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object consumeUntilUp;
            Object consumeUntilUp2;
            PointerInputChange pointerInputChange;
            long j;
            AwaitPointerEventScope awaitPointerEventScope;
            AwaitPointerEventScope awaitPointerEventScope2;
            AwaitPointerEventScope awaitPointerEventScope3;
            AwaitPointerEventScope awaitPointerEventScope4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                try {
                } catch (PointerEventTimeoutCancellationException unused) {
                    this.L$0 = null;
                    this.label = 6;
                    consumeUntilUp2 = TapAndDoubleTapGestureKt.consumeUntilUp(r1, this);
                }
            } catch (PointerEventTimeoutCancellationException unused2) {
                this.L$0 = r1;
                this.J$0 = j;
                this.label = 3;
                consumeUntilUp = TapAndDoubleTapGestureKt.consumeUntilUp(r1, this);
                awaitPointerEventScope2 = r1;
            }
            switch (r1) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope5;
                    this.label = 1;
                    obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope5, false, null, this, 3, null);
                    if (obj != coroutine_suspended) {
                        awaitPointerEventScope4 = awaitPointerEventScope5;
                        ((PointerInputChange) obj).consume();
                        j = awaitPointerEventScope4.getViewConfiguration().getLongPressTimeoutMillis();
                        this.L$0 = awaitPointerEventScope4;
                        this.J$0 = j;
                        this.label = 2;
                        obj = awaitPointerEventScope4.withTimeout(j, new C00341(null), this);
                        r1 = awaitPointerEventScope4;
                        if (obj == coroutine_suspended) {
                        }
                        pointerInputChange = (PointerInputChange) obj;
                        awaitPointerEventScope = r1;
                        if (pointerInputChange != null) {
                            pointerInputChange.consume();
                            TapOnPosition tapOnPosition = this.$onTap;
                            if (tapOnPosition != null) {
                                tapOnPosition.mo1480onEventk4lQ0M(pointerInputChange.getPosition());
                            }
                            if (this.$onDoubleTap != null) {
                                this.L$0 = awaitPointerEventScope;
                                this.J$0 = j;
                                this.label = 4;
                                obj = TapAndDoubleTapGestureKt.awaitSecondDown(awaitPointerEventScope, pointerInputChange, this);
                                awaitPointerEventScope3 = awaitPointerEventScope;
                                break;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                case 1:
                    AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope4 = awaitPointerEventScope6;
                    ((PointerInputChange) obj).consume();
                    j = awaitPointerEventScope4.getViewConfiguration().getLongPressTimeoutMillis();
                    this.L$0 = awaitPointerEventScope4;
                    this.J$0 = j;
                    this.label = 2;
                    obj = awaitPointerEventScope4.withTimeout(j, new C00341(null), this);
                    r1 = awaitPointerEventScope4;
                    if (obj == coroutine_suspended) {
                    }
                    pointerInputChange = (PointerInputChange) obj;
                    awaitPointerEventScope = r1;
                    if (pointerInputChange != null) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    j = this.J$0;
                    AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r1 = awaitPointerEventScope7;
                    pointerInputChange = (PointerInputChange) obj;
                    awaitPointerEventScope = r1;
                    if (pointerInputChange != null) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    j = this.J$0;
                    AwaitPointerEventScope awaitPointerEventScope8 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope2 = awaitPointerEventScope8;
                    pointerInputChange = null;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    if (pointerInputChange != null) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    j = this.J$0;
                    AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope3 = awaitPointerEventScope9;
                    if (((PointerInputChange) obj) != null) {
                        this.L$0 = awaitPointerEventScope3;
                        this.label = 5;
                        Object withTimeout = awaitPointerEventScope3.withTimeout(j, new AnonymousClass2(this.$onDoubleTap, null), this);
                        r1 = awaitPointerEventScope3;
                        break;
                    }
                    return Unit.INSTANCE;
                case 5:
                    AwaitPointerEventScope awaitPointerEventScope10 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r1 = awaitPointerEventScope10;
                    return Unit.INSTANCE;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: TapAndDoubleTapGesture.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1", f = "TapAndDoubleTapGesture.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00341 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            C00341(Continuation<? super C00341> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00341 c00341 = new C00341(continuation);
                c00341.L$0 = obj;
                return c00341;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                return ((C00341) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

        /* compiled from: TapAndDoubleTapGesture.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2", f = "TapAndDoubleTapGesture.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt$detectTapAndDoubleTap$2$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TapOnPosition $onDoubleTap;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TapOnPosition tapOnPosition, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$onDoubleTap = tapOnPosition;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onDoubleTap, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                if (pointerInputChange != null) {
                    pointerInputChange.consume();
                    this.$onDoubleTap.mo1480onEventk4lQ0M(pointerInputChange.getPosition());
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapAndDoubleTap, new AnonymousClass1(this.$onTap, this.$onDoubleTap, null), this) == coroutine_suspended) {
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

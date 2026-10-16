package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3457g {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.CountdownFlowKt$countdownSecondsFlow$1", f = "CountdownFlow.kt", i = {0, 0, 1, 1, 2, 2}, l = {26, 29, 30}, m = "invokeSuspend", n = {"$this$flow", "secondsLeft", "$this$flow", "secondsLeft", "$this$flow", "secondsLeft"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g$a */
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super UInt>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5844a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = i;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super UInt> flowCollector, Continuation<? super Unit> continuation) {
            return ((a) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.d, continuation);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0073, code lost:
        
            if (r4.emit(r8, r7) == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(1000, r7) == r0) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0073 -> B:12:0x0049). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector2 = (FlowCollector) this.c;
                i = this.d;
                UInt m10330boximpl = UInt.m10330boximpl(i);
                this.c = flowCollector2;
                this.f5844a = i;
                this.b = 1;
                if (flowCollector2.emit(m10330boximpl, this) != coroutine_suspended) {
                    flowCollector = flowCollector2;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i = this.f5844a;
                    flowCollector = (FlowCollector) this.c;
                    ResultKt.throwOnFailure(obj);
                    i = UInt.m10336constructorimpl(i - 1);
                    UInt m10330boximpl2 = UInt.m10330boximpl(i);
                    this.c = flowCollector;
                    this.f5844a = i;
                    this.b = 3;
                } else if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            i = this.f5844a;
            flowCollector = (FlowCollector) this.c;
            ResultKt.throwOnFailure(obj);
            if (Integer.compareUnsigned(i, 0) <= 0) {
                return Unit.INSTANCE;
            }
            this.c = flowCollector;
            this.f5844a = i;
            this.b = 2;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.CountdownFlowKt$countdownSecondsStateFlow$1", f = "CountdownFlow.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g$b */
    public static final class b extends SuspendLambda implements Function2<FlowCollector<? super UInt>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5845a;
        public /* synthetic */ Object b;
        public final /* synthetic */ Ref.IntRef c;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g$b$a */
        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f5846a;
            public final /* synthetic */ FlowCollector<UInt> b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Ref.IntRef intRef, FlowCollector<? super UInt> flowCollector) {
                this.f5846a = intRef;
                this.b = flowCollector;
            }

            public final Object a(int i, Continuation<? super Unit> continuation) {
                this.f5846a.element = i;
                Object emit = this.b.emit(UInt.m10330boximpl(i), continuation);
                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((UInt) obj).getData(), continuation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = intRef;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super UInt> flowCollector, Continuation<? super Unit> continuation) {
            return ((b) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.c, continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5845a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.b;
                Flow<UInt> a2 = C3457g.a(this.c.element);
                a aVar = new a(this.c, flowCollector);
                this.f5845a = 1;
                if (a2.collect(aVar, this) == coroutine_suspended) {
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

    public static final Flow<UInt> a(int i) {
        return FlowKt.flow(new a(i, null));
    }

    public static final StateFlow<UInt> a(int i, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        return FlowKt.stateIn(FlowKt.flow(new b(intRef, null)), scope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), UInt.m10330boximpl(i));
    }
}

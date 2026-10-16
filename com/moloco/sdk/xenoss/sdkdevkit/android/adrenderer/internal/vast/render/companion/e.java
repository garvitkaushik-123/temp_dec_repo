package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.x;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final int f6196a;
    public final x b;
    public final StateFlow<d.a> c;

    public static final class a implements Flow<d.a> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f6197a;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e$a$a, reason: collision with other inner class name */
        public static final class C0541a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f6198a;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.CompanionGoNextActionImpl$special$$inlined$map$1$2", f = "CompanionGoNextAction.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.e$a$a$a, reason: collision with other inner class name */
            public static final class C0542a extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f6199a;
                public int b;
                public Object c;

                public C0542a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f6199a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return C0541a.this.emit(null, this);
                }
            }

            public C0541a(FlowCollector flowCollector) {
                this.f6198a = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, Continuation continuation) {
                C0542a c0542a;
                int i;
                d.a b;
                if (continuation instanceof C0542a) {
                    c0542a = (C0542a) continuation;
                    int i2 = c0542a.b;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0542a.b = i2 - Integer.MIN_VALUE;
                        Object obj2 = c0542a.f6199a;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0542a.b;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.f6198a;
                            b = f.b(((UInt) obj).getData());
                            c0542a.b = 1;
                            if (flowCollector.emit(b, c0542a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
                c0542a = new C0542a(continuation);
                Object obj22 = c0542a.f6199a;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0542a.b;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }
        }

        public a(Flow flow) {
            this.f6197a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super d.a> flowCollector, Continuation continuation) {
            Object collect = this.f6197a.collect(new C0541a(flowCollector), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    public /* synthetic */ e(int i, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, coroutineScope);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> m() {
        return this.c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d
    public void reset() {
        this.b.a(this.f6196a);
    }

    public e(int i, CoroutineScope scope) {
        d.a b;
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f6196a = i;
        x xVar = new x(i, scope, null);
        this.b = xVar;
        a aVar = new a(xVar.a());
        SharingStarted WhileSubscribed$default = SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null);
        b = f.b(i);
        this.c = FlowKt.stateIn(aVar, scope, WhileSubscribed$default, b);
    }
}

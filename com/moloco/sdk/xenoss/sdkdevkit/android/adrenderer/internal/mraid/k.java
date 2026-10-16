package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.webkit.WebView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class k implements j {
    public static final int i = 8;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5898a;
    public Function0<Unit> b;
    public final CoroutineScope c;
    public final WebView d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d e;
    public final MutableSharedFlow<l> f;
    public final SharedFlow<l> g;
    public final StateFlow<n.f> h;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidFullscreenContentControllerImpl$onEvent$1", f = "MraidFullscreenContentControllerImpl.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5899a;
        public final /* synthetic */ l c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = lVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return k.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5899a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = k.this.f;
                l lVar = this.c;
                this.f5899a = 1;
                if (mutableSharedFlow.emit(lVar, this) == coroutine_suspended) {
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

    public static final class b implements Flow<n.f> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f5900a;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f5901a;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidFullscreenContentControllerImpl$special$$inlined$mapNotNull$1$2", f = "MraidFullscreenContentControllerImpl.kt", i = {}, l = {52}, m = "emit", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a, reason: collision with other inner class name */
            public static final class C0485a extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f5902a;
                public int b;
                public Object c;

                public C0485a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f5902a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f5901a = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, Continuation continuation) {
                C0485a c0485a;
                int i;
                if (continuation instanceof C0485a) {
                    c0485a = (C0485a) continuation;
                    int i2 = c0485a.b;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0485a.b = i2 - Integer.MIN_VALUE;
                        Object obj2 = c0485a.f5902a;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0485a.b;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.f5901a;
                            n nVar = (n) obj;
                            n.f fVar = nVar instanceof n.f ? (n.f) nVar : null;
                            if (fVar != null) {
                                c0485a.b = 1;
                                if (flowCollector.emit(fVar, c0485a) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
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
                c0485a = new C0485a(continuation);
                Object obj22 = c0485a.f5902a;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0485a.b;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }
        }

        public b(Flow flow) {
            this.f5900a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super n.f> flowCollector, Continuation continuation) {
            Object collect = this.f5900a.collect(new a(flowCollector), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    public /* synthetic */ k(boolean z, Function0 function0, CoroutineScope coroutineScope, int i2, WebView webView, SharedFlow sharedFlow, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, coroutineScope, i2, webView, sharedFlow);
    }

    public static Object b(k kVar) {
        return Reflection.property0(new PropertyReference0Impl(kVar.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    public static final Unit q() {
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    public void D() {
        a(l.f5903a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean K() {
        return this.f5898a;
    }

    public final Function0<Unit> S() {
        return this.b;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public SharedFlow<l> a() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    public WebView c() {
        return this.d;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        this.b.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    public StateFlow<n.f> e() {
        return this.h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> m() {
        return this.e.m();
    }

    public k(boolean z, Function0<Unit> closeFullscreenAdRepresentation, CoroutineScope scope, int i2, WebView webView, SharedFlow<? extends n> mraidJsCommands) {
        Intrinsics.checkNotNullParameter(closeFullscreenAdRepresentation, "closeFullscreenAdRepresentation");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(mraidJsCommands, "mraidJsCommands");
        this.f5898a = z;
        this.b = closeFullscreenAdRepresentation;
        this.c = scope;
        this.d = webView;
        this.e = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.f.a(i2, scope);
        MutableSharedFlow<l> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f = MutableSharedFlow$default;
        this.g = MutableSharedFlow$default;
        this.h = FlowKt.stateIn(new b(mraidJsCommands), scope, SharingStarted.INSTANCE.getEagerly(), null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void b(a.AbstractC0571a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        a(l.b);
    }

    public final void a(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.b = function0;
    }

    public final Job a(l lVar) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(lVar, null), 3, null);
        return launch$default;
    }

    public /* synthetic */ k(boolean z, Function0 function0, CoroutineScope coroutineScope, int i2, WebView webView, SharedFlow sharedFlow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i3 & 2) != 0 ? new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return k.q();
            }
        } : function0, coroutineScope, i2, webView, sharedFlow, null);
    }
}

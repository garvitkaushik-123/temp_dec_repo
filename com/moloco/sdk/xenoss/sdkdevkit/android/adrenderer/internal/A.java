package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.StaticAdActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class A implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5771a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i c;
    public final CoroutineScope d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a e;
    public final y f;
    public final MutableStateFlow<Boolean> g;
    public final Lazy h;
    public final MutableStateFlow<Boolean> i;
    public final StateFlow<Boolean> j;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$isAdDisplaying$2$1", f = "StaticFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5772a;
        public /* synthetic */ boolean b;
        public /* synthetic */ boolean c;

        public a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        public final Object a(boolean z, boolean z2, Continuation<? super Boolean> continuation) {
            a aVar = new a(continuation);
            aVar.b = z;
            aVar.c = z2;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Continuation<? super Boolean> continuation) {
            return a(bool.booleanValue(), bool2.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5772a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.b && this.c);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1", f = "StaticFullscreenAd.kt", i = {0}, l = {100}, m = "invokeSuspend", n = {"eventHandlers"}, s = {"L$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5773a;
        public /* synthetic */ Object b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f d;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e e;

        public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
            public a(Object obj) {
                super(0, obj, A.class, "onClose", "onClose()V", 0);
            }

            public final void a() {
                ((A) this.receiver).o();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1$eventHandlers$1", f = "StaticFullscreenAd.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.A$b$b, reason: collision with other inner class name */
        public static final class C0464b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5774a;
            public final /* synthetic */ A b;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e c;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1$eventHandlers$1$error$1", f = "StaticFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.A$b$b$a */
            public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, Continuation<? super Boolean>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5775a;
                public /* synthetic */ Object b;

                public a(Continuation<? super a> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, Continuation<? super Boolean> continuation) {
                    return ((a) create(gVar, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    a aVar = new a(continuation);
                    aVar.b = obj;
                    return aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5775a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.b) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0464b(A a2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar, Continuation<? super C0464b> continuation) {
                super(2, continuation);
                this.b = a2;
                this.c = eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0464b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0464b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5774a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> unrecoverableError = this.b.e.getUnrecoverableError();
                    a aVar = new a(null);
                    this.f5774a = 1;
                    obj = FlowKt.first(unrecoverableError, aVar, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) obj;
                if (gVar != null && (eVar = this.c) != null) {
                    eVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.h.b(gVar));
                }
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticFullscreenAdImpl$show$1$eventHandlers$2", f = "StaticFullscreenAd.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
        public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5776a;
            public final /* synthetic */ A b;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e c;

            public static final class a<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e f5777a;

                public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar) {
                    this.f5777a = eVar;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar = this.f5777a;
                    if (eVar != null) {
                        eVar.a();
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(A a2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar, Continuation<? super c> continuation) {
                super(2, continuation);
                this.b = a2;
                this.c = eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new c(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5776a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SharedFlow<Unit> clickthroughEvent = this.b.e.getClickthroughEvent();
                    a aVar = new a(this.c);
                    this.f5776a = 1;
                    if (clickthroughEvent.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.d = fVar;
            this.e = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = A.this.new b(this.d, this.e, continuation);
            bVar.b = obj;
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00c0 A[LOOP:1: B:20:0x00ba->B:22:0x00c0, LOOP_END] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Job launch$default;
            Job launch$default2;
            List listOf;
            b bVar;
            Throwable th;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5773a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0464b(A.this, this.e, null), 3, null);
                launch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new c(A.this, this.e, null), 3, null);
                listOf = CollectionsKt.listOf((Object[]) new Job[]{launch$default, launch$default2});
                try {
                    A.this.g.setValue(Boxing.boxBoolean(true));
                    StaticAdActivity.Companion companion = StaticAdActivity.INSTANCE;
                    Context context = A.this.f5771a;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = A.this.e;
                    a aVar2 = new a(A.this);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVar = this.d;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar = A.this.b;
                    this.b = listOf;
                    this.f5773a = 1;
                    bVar = this;
                    try {
                        if (companion.a(context, aVar, aVar2, fVar, zVar, bVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        it = listOf.iterator();
                        while (it.hasNext()) {
                            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
                        }
                        A.this.g.setValue(Boxing.boxBoolean(false));
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bVar = this;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                listOf = (List) this.b;
                try {
                    ResultKt.throwOnFailure(obj);
                    bVar = this;
                } catch (Throwable th4) {
                    th = th4;
                    bVar = this;
                    it = listOf.iterator();
                    while (it.hasNext()) {
                    }
                    A.this.g.setValue(Boxing.boxBoolean(false));
                    throw th;
                }
            }
            Iterator it2 = listOf.iterator();
            while (it2.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) it2.next(), (CancellationException) null, 1, (Object) null);
            }
            A.this.g.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    public A(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adm, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        this.f5771a = context;
        this.b = watermark;
        this.c = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.c;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.d = CoroutineScope;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a(context, null, new com.moloco.sdk.internal.services.t(externalLinkHandler, customUserEventBuilderService), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a(), false, null, 50, null);
        this.e = aVar;
        this.f = new y(adm, CoroutineScope, aVar);
        Boolean bool = Boolean.FALSE;
        this.g = StateFlowKt.MutableStateFlow(bool);
        this.h = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.A$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return A.f(A.this);
            }
        });
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.i = MutableStateFlow;
        this.j = MutableStateFlow;
    }

    public static final StateFlow f(A a2) {
        return FlowKt.stateIn(FlowKt.flowCombine(a2.g, a2.e.c(), new a(null)), a2.d, SharingStarted.INSTANCE.getEagerly(), Boolean.FALSE);
    }

    public static Object g(A a2) {
        return Reflection.property0(new PropertyReference0Impl(a2.f, y.class, "isLoaded", "isLoaded()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
        this.e.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.f.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m
    public StateFlow<Boolean> k() {
        return this.j;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a
    public StateFlow<Boolean> m() {
        return (StateFlow) this.h.getValue();
    }

    public final void o() {
        this.g.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j, InterfaceC3449b.a aVar) {
        this.f.a(j, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f options, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar) {
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new b(options, eVar, null), 3, null);
    }
}

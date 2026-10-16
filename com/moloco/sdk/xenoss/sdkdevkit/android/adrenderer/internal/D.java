package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.D;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.fullscreen.FullscreenWebviewActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class D implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w {
    public static final a q = new a(null);
    public static final int r = 8;
    public static final String s = "TemplateFullscreenAd";

    /* renamed from: a, reason: collision with root package name */
    public final Context f5778a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z b;
    public final InterfaceC3463m c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i d;
    public final MetricsRecorder e;
    public final CoroutineScope f;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.c g;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.b i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g j;
    public final Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> k;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.a l;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i m;
    public final MutableStateFlow<Boolean> n;
    public final Lazy o;
    public final MutableStateFlow<Boolean> p;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.TemplateFullscreenAdImpl$isAdDisplaying$2$1", f = "TemplateFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5779a;
        public /* synthetic */ boolean b;
        public /* synthetic */ boolean c;

        public b(Continuation<? super b> continuation) {
            super(3, continuation);
        }

        public final Object a(boolean z, boolean z2, Continuation<? super Boolean> continuation) {
            b bVar = new b(continuation);
            bVar.b = z;
            bVar.c = z2;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Continuation<? super Boolean> continuation) {
            return a(bool.booleanValue(), bool2.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5779a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = this.b;
            boolean z2 = this.c;
            MolocoLogger.info$default(MolocoLogger.INSTANCE, D.s, "isAdDisplaying final: " + (z && z2) + ", _isAdDisplaying: " + z + ", webViewIsDisplaying: " + z2, null, false, 12, null);
            return Boxing.boxBoolean(z && z2);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.TemplateFullscreenAdImpl$show$1", f = "TemplateFullscreenAd.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5780a;
        public /* synthetic */ Object b;
        public final /* synthetic */ d d;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.TemplateFullscreenAdImpl$show$1$1", f = "TemplateFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5781a;
            public final /* synthetic */ List<Job> b;
            public final /* synthetic */ D c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(List<? extends Job> list, D d, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = list;
                this.c = d;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                return ((a) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5781a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Iterator<T> it = this.b.iterator();
                while (it.hasNext()) {
                    Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
                }
                MolocoLogger.info$default(MolocoLogger.INSTANCE, D.s, "Calling close()", null, false, 12, null);
                FullscreenWebviewActivity.INSTANCE.a();
                Handler handler = new Handler(Looper.getMainLooper());
                final D d = this.c;
                handler.postDelayed(new Runnable() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.D$c$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        D.c.a.a(D.this);
                    }
                }, 1000L);
                return Unit.INSTANCE;
            }

            public static final void a(D d) {
                d.destroy();
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.TemplateFullscreenAdImpl$show$1$eventHandlers$1", f = "TemplateFullscreenAd.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5782a;
            public final /* synthetic */ D b;
            public final /* synthetic */ d c;

            public static final class a<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ d f5783a;

                public a(d dVar) {
                    this.f5783a = dVar;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                    this.f5783a.a();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(D d, d dVar, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = d;
                this.c = dVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5782a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableSharedFlow<Unit> c = this.b.i.c();
                    a aVar = new a(this.c);
                    this.f5782a = 1;
                    if (c.collect(aVar, this) == coroutine_suspended) {
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
        public c(d dVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.d = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = D.this.new c(this.d, continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Job launch$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5780a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.b, null, null, new b(D.this, this.d, null), 3, null);
                List listOf = CollectionsKt.listOf(launch$default);
                MutableSharedFlow<Unit> c = D.this.g.c();
                a aVar = new a(listOf, D.this, null);
                this.f5780a = 1;
                if (FlowKt.collectLatest(c, aVar, this) == coroutine_suspended) {
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

    public D(Context context, String adm, com.moloco.sdk.internal.services.s clickthroughService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5778a = context;
        this.b = watermark;
        this.c = externalLinkHandler;
        this.d = persistentHttpRequest;
        this.e = metricsRecorder;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.f = CoroutineScope;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.c cVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.c(CoroutineScope);
        this.g = cVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h hVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h(CoroutineScope);
        this.h = hVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.b bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.b(clickthroughService, CoroutineScope);
        this.i = bVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g gVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g(CoroutineScope);
        this.j = gVar;
        Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> of = SetsKt.setOf((Object[]) new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a[]{cVar, bVar, hVar, new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.a(metricsRecorder), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.f(externalLinkHandler), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.e(persistentHttpRequest), gVar});
        this.k = of;
        this.l = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.a(context, adm, of, bVar, hVar, gVar, metricsRecorder);
        Boolean bool = Boolean.FALSE;
        this.n = StateFlowKt.MutableStateFlow(bool);
        this.o = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.D$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return D.c(D.this);
            }
        });
        this.p = StateFlowKt.MutableStateFlow(bool);
    }

    public static final StateFlow c(D d2) {
        return FlowKt.stateIn(FlowKt.flowCombine(d2.n, d2.l.m(), new b(null)), d2.f, SharingStarted.INSTANCE.getEagerly(), Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        this.l.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.l.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m
    public StateFlow<Boolean> k() {
        return this.p;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a
    public StateFlow<Boolean> m() {
        return (StateFlow) this.o.getValue();
    }

    public static final class d implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v f5784a;
        public final /* synthetic */ D b;

        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v vVar, D d) {
            this.f5784a = vVar;
            this.b = d;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v vVar = this.f5784a;
            if (vVar != null) {
                vVar.a(internalShowError);
            }
            this.b.destroy();
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a() {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v vVar = this.f5784a;
            if (vVar != null) {
                vVar.a();
            }
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u options, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v vVar) {
        Intrinsics.checkNotNullParameter(options, "options");
        d dVar = new d(vVar, this);
        this.b.a(this.l.q());
        this.l.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v) dVar);
        FullscreenWebviewActivity.INSTANCE.a(this.f5778a, this.n, this.l, this.p);
        BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new c(dVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j, InterfaceC3449b.a aVar) {
        this.l.a(j, aVar);
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad;

import android.content.Context;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class a implements t<v> {
    public static final int o = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Set<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> f5941a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.b b;
    public final h c;
    public final g d;
    public final MetricsRecorder e;
    public final CoroutineScope f;
    public final d g;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge.a j;
    public final Lazy k;
    public final MutableStateFlow<Boolean> l;
    public final Lazy m;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.loader.a n;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.WebviewAd$isAdDisplaying$2$1", f = "WebviewAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.a$a, reason: collision with other inner class name */
    public static final class C0496a extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5942a;
        public /* synthetic */ boolean b;
        public /* synthetic */ boolean c;

        public C0496a(Continuation<? super C0496a> continuation) {
            super(3, continuation);
        }

        public final Object a(boolean z, boolean z2, Continuation<? super Boolean> continuation) {
            C0496a c0496a = new C0496a(continuation);
            c0496a.b = z;
            c0496a.c = z2;
            return c0496a.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Continuation<? super Boolean> continuation) {
            return a(bool.booleanValue(), bool2.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5942a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.b && this.c);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.WebviewAd$show$1", f = "WebviewAd.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5944a;
        public final /* synthetic */ v c;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.WebviewAd$show$1$error$1", f = "WebviewAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.a$c$a, reason: collision with other inner class name */
        public static final class C0497a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a, Continuation<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5945a;
            public /* synthetic */ Object b;

            public C0497a(Continuation<? super C0497a> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a aVar, Continuation<? super Boolean> continuation) {
                return ((C0497a) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0497a c0497a = new C0497a(continuation);
                c0497a.b = obj;
                return c0497a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5945a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a) this.b) != null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v vVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = vVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5944a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a.this.l.setValue(Boxing.boxBoolean(true));
                StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> unrecoverableError = a.this.q().getUnrecoverableError();
                C0497a c0497a = new C0497a(null);
                this.f5944a = 1;
                obj = FlowKt.first(unrecoverableError, c0497a, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a) obj;
            if (aVar != null) {
                this.c.a(aVar);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, final String adm, Set<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.a> eventHandlers, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.b clickthroughEventHandler, h contentLoadedHandler, g playListItemDisplayingEventHandler, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(eventHandlers, "eventHandlers");
        Intrinsics.checkNotNullParameter(clickthroughEventHandler, "clickthroughEventHandler");
        Intrinsics.checkNotNullParameter(contentLoadedHandler, "contentLoadedHandler");
        Intrinsics.checkNotNullParameter(playListItemDisplayingEventHandler, "playListItemDisplayingEventHandler");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5941a = eventHandlers;
        this.b = clickthroughEventHandler;
        this.c = contentLoadedHandler;
        this.d = playListItemDisplayingEventHandler;
        this.e = metricsRecorder;
        this.f = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        d dVar = new d(eventHandlers, metricsRecorder);
        this.g = dVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b(context, contentLoadedHandler, playListItemDisplayingEventHandler, metricsRecorder, null, 16, null);
        bVar.addJavascriptInterface(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.a(dVar), "AndroidTemplateBridge");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.b bVar2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.b(context, bVar, clickthroughEventHandler);
        this.h = bVar2;
        bVar2.b();
        this.i = bVar;
        this.j = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge.b(bVar);
        this.k = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.a(adm, this);
            }
        });
        this.l = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.m = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.a$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.b(a.this);
            }
        });
        this.n = k();
    }

    public static final StateFlow b(a aVar) {
        return FlowKt.stateIn(FlowKt.flowCombine(aVar.l, aVar.i.a(), new C0496a(null)), aVar.f, SharingStarted.INSTANCE.getEagerly(), Boolean.FALSE);
    }

    public static Object c(a aVar) {
        return Reflection.property0(new PropertyReference0Impl(aVar.n, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.loader.a.class, "isLoaded", "isLoaded()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        this.l.setValue(Boolean.FALSE);
        this.h.remove();
        this.i.destroy();
        CoroutineScopeKt.cancel$default(this.f, null, 1, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.n.isLoaded();
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.loader.a k() {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.loader.a) this.k.getValue();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a
    public StateFlow<Boolean> m() {
        return (StateFlow) this.m.getValue();
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a o() {
        return this.h;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b q() {
        return this.i;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.bridge.a t() {
        return this.j;
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b> y() {
        return this.i.getOrientation$moloco_sdk_release();
    }

    public static final class b implements InterfaceC3449b.a {
        public final /* synthetic */ InterfaceC3449b.a b;

        public b(InterfaceC3449b.a aVar) {
            this.b = aVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
        public void a() {
            a.this.q().a(a.this.o());
            InterfaceC3449b.a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
            Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
            InterfaceC3449b.a aVar = this.b;
            if (aVar != null) {
                aVar.a(timeoutError);
            }
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
            Intrinsics.checkNotNullParameter(internalError, "internalError");
            InterfaceC3449b.a aVar = this.b;
            if (aVar != null) {
                aVar.a(internalError);
            }
        }
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.h = aVar;
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.loader.a a(String str, a aVar) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.loader.a(str, aVar.f, aVar.i);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t
    public void a(v listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new c(listener, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j, InterfaceC3449b.a aVar) {
        k().a(j, new b(aVar));
    }
}

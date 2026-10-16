package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.publisher.u;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class u<T extends AdShowListener> implements FullscreenAd<T>, r {
    public static final int t = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5581a;
    public final InterfaceC3442f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final String d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i e;
    public final InterfaceC3463m f;
    public final Function1<com.moloco.sdk.internal.ortb.model.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> g;
    public final t<T> h;
    public final AdFormatType i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z j;
    public final C3427a k;
    public final MetricsRecorder l;
    public final CoroutineScope m;
    public final TimerEvent n;
    public TimerEvent o;
    public final AdLoad p;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h q;
    public com.moloco.sdk.internal.ortb.model.a r;
    public Function1<? super Boolean, Unit> s;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Long, Duration> {
        public a(Object obj) {
            super(1, obj, C3427a.class, "calculateTimeout", "calculateTimeout-5sfh64U(J)J", 0);
        }

        public final long a(long j) {
            return ((C3427a) this.receiver).a(j);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Duration invoke(Long l) {
            return Duration.m11565boximpl(a(l.longValue()));
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<com.moloco.sdk.internal.ortb.model.c, InterfaceC3449b> {
        public b(Object obj) {
            super(1, obj, u.class, "recreateXenossAd", "recreateXenossAd(Lcom/moloco/sdk/internal/ortb/model/Bid;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/AdLoad;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC3449b invoke(com.moloco.sdk.internal.ortb.model.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((u) this.receiver).a(p0);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1", f = "FullscreenAdImpl.kt", i = {}, l = {267, 269}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5582a;
        public final /* synthetic */ InterfaceC3448a b;
        public final /* synthetic */ y c;
        public final /* synthetic */ u<T> d;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$1", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5583a;
            public /* synthetic */ boolean b;

            public a(Continuation<? super a> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Boolean> continuation) {
                return ((a) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(continuation);
                aVar.b = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5583a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.b);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$2", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5584a;
            public /* synthetic */ boolean b;

            public b(Continuation<? super b> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Boolean> continuation) {
                return ((b) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(continuation);
                bVar.b = ((Boolean) obj).booleanValue();
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5584a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(!this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC3448a interfaceC3448a, y yVar, u<? super T> uVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = interfaceC3448a;
            this.c = yVar;
            this.d = uVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.first(r6, r1, r5) == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.first(r6, r1, r5) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5582a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> m = this.b.m();
                a aVar = new a(null);
                this.f5582a = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    y yVar = this.c;
                    if (yVar != null) {
                        yVar.onAdHidden(MolocoAdKt.createAdInfo$default(this.d.d, null, 2, null));
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            y yVar2 = this.c;
            if (yVar2 != null) {
                yVar2.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.d.d, null, 2, null));
            }
            StateFlow<Boolean> m2 = this.b.m();
            b bVar = new b(null);
            this.f5582a = 2;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$load$1", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5585a;
        public final /* synthetic */ u<T> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(u<? super T> uVar, String str, AdLoad.Listener listener, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = uVar;
            this.c = str;
            this.d = listener;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5585a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.p.load(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    public static final class f implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u<T> f5587a;
        public final /* synthetic */ y b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(u<? super T> uVar, y yVar) {
            this.f5587a = uVar;
            this.b = yVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            u<T> uVar = this.f5587a;
            uVar.a(com.moloco.sdk.internal.t.a(uVar.d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a() {
            y yVar = this.b;
            if (yVar != null) {
                yVar.onAdClicked(MolocoAdKt.createAdInfo$default(this.f5587a.d, null, 2, null));
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$show$2", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5588a;
        public final /* synthetic */ T b;
        public final /* synthetic */ u<T> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(T t, u<? super T> uVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = t;
            this.c = uVar;
        }

        public static final j b(u uVar) {
            return uVar.a();
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5588a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            InterfaceC3448a interfaceC3448a = null;
            if (this.b != null) {
                t tVar = this.c.h;
                T t = this.b;
                InterfaceC3442f interfaceC3442f = this.c.b;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = this.c.c;
                final u<T> uVar = this.c;
                Function0 function0 = new Function0() { // from class: com.moloco.sdk.internal.publisher.u$g$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return u.g.a(u.this);
                    }
                };
                final u<T> uVar2 = this.c;
                tVar.a(new C(t, interfaceC3442f, aVar, function0, new Function0() { // from class: com.moloco.sdk.internal.publisher.u$g$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return u.g.b(u.this);
                    }
                }, this.c.i, this.c.l));
            } else {
                this.c.h.a((y) null);
            }
            y d = this.c.h.d();
            if (this.c.h.a() instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a2 = this.c.h.a();
                if (a2 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) {
                    interfaceC3448a = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) a2;
                }
            } else {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a3 = this.c.h.a();
                if (a3 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) {
                    interfaceC3448a = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) a3;
                }
            }
            if (interfaceC3448a == null || !this.c.isLoaded()) {
                if (d != null) {
                    d.a(com.moloco.sdk.internal.t.a(this.c.d, MolocoAdError.ErrorType.AD_SHOW_ERROR_NOT_LOADED, com.moloco.sdk.internal.o.d));
                }
                return Unit.INSTANCE;
            }
            if (interfaceC3448a.m().getValue().booleanValue()) {
                if (d != null) {
                    d.a(com.moloco.sdk.internal.t.a(this.c.d, MolocoAdError.ErrorType.AD_SHOW_ERROR_ALREADY_DISPLAYING, com.moloco.sdk.internal.o.e));
                }
                return Unit.INSTANCE;
            }
            this.c.a(interfaceC3448a, d);
            if (interfaceC3448a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) interfaceC3448a).a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u) this.c.b(d));
            } else if (interfaceC3448a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) interfaceC3448a).a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) this.c.q, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h) this.c.a(d));
            }
            return Unit.INSTANCE;
        }

        public static final com.moloco.sdk.internal.ortb.model.r a(u uVar) {
            return uVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Context context, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, InterfaceC3463m externalLinkHandler, Function1<? super com.moloco.sdk.internal.ortb.model.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> generateAggregatedOptions, t<T> adDataHolder, AdFormatType adFormatType, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(generateAggregatedOptions, "generateAggregatedOptions");
        Intrinsics.checkNotNullParameter(adDataHolder, "adDataHolder");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5581a = context;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = adUnitId;
        this.e = persistentHttpRequest;
        this.f = externalLinkHandler;
        this.g = generateAggregatedOptions;
        this.h = adDataHolder;
        this.i = adFormatType;
        this.j = watermark;
        this.k = adCreateLoadTimeoutManager;
        this.l = metricsRecorder;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.m = CoroutineScope;
        TimerEvent startTimerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.q.c());
        String c2 = com.moloco.sdk.internal.client_metrics_data.c.c.c();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.n = startTimerEvent.withTag(c2, lowerCase);
        this.p = C3431e.a(CoroutineScope, new a(adCreateLoadTimeoutManager), adUnitId, new b(this), adFormatType, a.C0463a.f5749a.b(), metricsRecorder);
        this.q = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h) generateAggregatedOptions.invoke(null);
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.m, null, 1, null);
        a(this, null, 1, null);
        this.s = null;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.k.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.p.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.l.recordTimerEvent(this.n);
        this.o = this.l.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.p.c());
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new d(this, bidResponseJson, listener, null), 3, null);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.k.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    public void show(T t2) {
        TimerEvent timerEvent = this.o;
        if (timerEvent != null) {
            MetricsRecorder metricsRecorder = this.l;
            String c2 = com.moloco.sdk.internal.client_metrics_data.c.c.c();
            String lowerCase = this.i.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            metricsRecorder.recordTimerEvent(timerEvent.withTag(c2, lowerCase));
        }
        MetricsRecorder metricsRecorder2 = this.l;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.z.c());
        String c3 = com.moloco.sdk.internal.client_metrics_data.c.c.c();
        String lowerCase2 = this.i.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        metricsRecorder2.recordCountEvent(countEvent.withTag(c3, lowerCase2));
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new g(t2, this, null), 3, null);
    }

    public final com.moloco.sdk.internal.ortb.model.r c() {
        return this.h.e();
    }

    public final Function1<Boolean, Unit> d() {
        return this.s;
    }

    public final Boolean e() {
        StateFlow<Boolean> k;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a2 = this.h.a();
        if (a2 == null || (k = a2.k()) == null) {
            return null;
        }
        return k.getValue();
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i b() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a2 = this.h.a();
        if (a2 != null) {
            return a2.getCreativeType();
        }
        return null;
    }

    public final f b(y yVar) {
        return new f(this, yVar);
    }

    public final j a() {
        return this.h.c();
    }

    public static /* synthetic */ void a(u uVar, com.moloco.sdk.internal.s sVar, int i, Object obj) {
        if ((i & 1) != 0) {
            sVar = null;
        }
        uVar.a(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.moloco.sdk.internal.s sVar) {
        StateFlow<Boolean> m;
        t<T> tVar = this.h;
        Job b2 = tVar.b();
        if (b2 != null) {
            Job.DefaultImpls.cancel$default(b2, (CancellationException) null, 1, (Object) null);
        }
        tVar.a((Job) null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a2 = this.h.a();
        boolean z = (a2 == null || (m = a2.m()) == null || !m.getValue().booleanValue()) ? false : true;
        t<T> tVar2 = this.h;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a3 = tVar2.a();
        if (a3 != null) {
            a3.destroy();
        }
        tVar2.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?>) null);
        t<T> tVar3 = this.h;
        y d2 = tVar3.d();
        tVar3.a((y) null);
        if (sVar != null && d2 != null) {
            d2.a(sVar);
        }
        if (z && d2 != null) {
            d2.onAdHidden(MolocoAdKt.createAdInfo$default(this.d, null, 2, null));
        }
        this.h.a((com.moloco.sdk.internal.ortb.model.r) null);
        this.h.a((j) null);
    }

    public static final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u<T> f5586a;
        public final /* synthetic */ y b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(u<? super T> uVar, y yVar) {
            this.f5586a = uVar;
            this.b = yVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x
        public void a(boolean z) {
            String c;
            com.moloco.sdk.internal.ortb.model.a aVar = this.f5586a.r;
            if (aVar != null) {
                u<T> uVar = this.f5586a;
                if (aVar.a() && ((!z || aVar.e()) && (c = aVar.c()) != null)) {
                    uVar.e.a(c);
                }
            }
            Function1<Boolean, Unit> d = this.f5586a.d();
            if (d != null) {
                d.invoke(Boolean.valueOf(z));
            }
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            u<T> uVar = this.f5586a;
            uVar.a(com.moloco.sdk.internal.t.a(uVar.d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a() {
            y yVar = this.b;
            if (yVar != null) {
                yVar.onAdClicked(MolocoAdKt.createAdInfo$default(this.f5586a.d, null, 2, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC3449b a(com.moloco.sdk.internal.ortb.model.c cVar) {
        com.moloco.sdk.internal.ortb.model.p g2;
        a(this, null, 1, null);
        com.moloco.sdk.internal.ortb.model.n a2 = cVar.e().a();
        if (a2 != null ? Intrinsics.areEqual(a2.a(), Boolean.TRUE) : false) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u> a3 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.n.a(this.f5581a, cVar.a(), new com.moloco.sdk.internal.services.t(this.f, this.c), this.j, this.l);
            t<T> tVar = this.h;
            tVar.a(a3);
            com.moloco.sdk.internal.ortb.model.d e2 = cVar.e();
            tVar.a(e2 != null ? e2.i() : null);
            tVar.a(cVar.c() != null ? new j(cVar.c(), Float.valueOf(cVar.g())) : null);
            return a3;
        }
        Function1<com.moloco.sdk.internal.ortb.model.p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> function1 = this.g;
        com.moloco.sdk.internal.ortb.model.d e3 = cVar.e();
        this.q = function1.invoke(e3 != null ? e3.g() : null);
        com.moloco.sdk.internal.ortb.model.d e4 = cVar.e();
        this.r = (e4 == null || (g2 = e4.g()) == null) ? null : g2.a();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> a4 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.n.a(this.f5581a, this.c, null, cVar, this.f, this.j, 4, null);
        t<T> tVar2 = this.h;
        tVar2.a(a4);
        com.moloco.sdk.internal.ortb.model.d e5 = cVar.e();
        tVar2.a(e5 != null ? e5.i() : null);
        tVar2.a(cVar.c() != null ? new j(cVar.c(), Float.valueOf(cVar.g())) : null);
        return a4;
    }

    public final void a(InterfaceC3448a interfaceC3448a, y yVar) {
        Job launch$default;
        t<T> tVar = this.h;
        Job b2 = tVar.b();
        if (b2 != null) {
            Job.DefaultImpls.cancel$default(b2, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new c(interfaceC3448a, yVar, this, null), 3, null);
        tVar.a(launch$default);
    }

    public final void a(Function1<? super Boolean, Unit> function1) {
        this.s = function1;
    }

    public final e a(y yVar) {
        return new e(this, yVar);
    }

    public /* synthetic */ u(Context context, InterfaceC3442f interfaceC3442f, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, InterfaceC3463m interfaceC3463m, Function1 function1, t tVar, AdFormatType adFormatType, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C3427a c3427a, MetricsRecorder metricsRecorder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, interfaceC3442f, aVar, str, iVar, interfaceC3463m, function1, (i & 128) != 0 ? new t(null, null, null, null, null, 31, null) : tVar, adFormatType, zVar, c3427a, metricsRecorder);
    }
}

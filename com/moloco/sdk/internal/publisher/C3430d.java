package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.K;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdErrorKt;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* renamed from: com.moloco.sdk.internal.publisher.d, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3430d implements AdLoad {
    public static final a o = new a(null);
    public static final int p = 8;
    public static final String q = "AdLoad";

    /* renamed from: a, reason: collision with root package name */
    public final Function1<Long, Duration> f5503a;
    public final String b;
    public final Function1<com.moloco.sdk.internal.ortb.model.c, InterfaceC3449b> c;
    public final com.moloco.sdk.internal.ortb.a d;
    public final p e;
    public final AdFormatType f;
    public final K g;
    public final MetricsRecorder h;
    public final CoroutineScope i;
    public boolean j;
    public String k;
    public com.moloco.sdk.internal.ortb.model.e l;
    public final TimerEvent m;
    public Job n;

    /* renamed from: com.moloco.sdk.internal.publisher.d$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$load$2", f = "AdLoad.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.internal.publisher.d$b */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5504a;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;
        public final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, AdLoad.Listener listener, long j, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = listener;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3430d.this.new b(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            com.moloco.sdk.internal.ortb.model.d e;
            com.moloco.sdk.internal.ortb.model.d e2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5504a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C3430d c3430d = C3430d.this;
                String str = this.c;
                this.f5504a = 1;
                obj = c3430d.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String str2 = (String) obj;
            if (str2 == null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdLoadImpl", "Could not pre-process the bid response. Failing the load() call.", null, false, 12, null);
                AdLoad.Listener listener = this.d;
                if (listener != null) {
                    listener.onAdLoadFailed(MolocoAdErrorKt.createAdErrorInfo(C3430d.this.b, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR));
                }
                MetricsRecorder metricsRecorder = C3430d.this.h;
                TimerEvent withTag = C3430d.this.m.withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE);
                com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.b;
                String c = cVar.c();
                MolocoAdError.ErrorType errorType = MolocoAdError.ErrorType.AD_BID_PARSE_ERROR;
                TimerEvent withTag2 = withTag.withTag(c, String.valueOf(errorType.getErrorCode()));
                com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.c;
                String c2 = cVar2.c();
                String name = C3430d.this.f.name();
                Locale locale = Locale.ROOT;
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                metricsRecorder.recordTimerEvent(withTag2.withTag(c2, lowerCase));
                MetricsRecorder metricsRecorder2 = C3430d.this.h;
                CountEvent withTag3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.l.c()).withTag(cVar.c(), String.valueOf(errorType.getErrorCode()));
                String c3 = cVar2.c();
                String lowerCase2 = C3430d.this.f.name().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                metricsRecorder2.recordCountEvent(withTag3.withTag(c3, lowerCase2));
                return Unit.INSTANCE;
            }
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.info$default(molocoLogger, C3430d.q, "Processed the bidResponse, proceeding with the load() call.", null, false, 12, null);
            x a2 = C3433g.a(this.d, C3430d.this.m, C3430d.this.f, C3430d.this.h);
            if (Intrinsics.areEqual(C3430d.this.k, str2)) {
                if (C3430d.this.isLoaded()) {
                    com.moloco.sdk.internal.ortb.model.r rVar = null;
                    MolocoAd createAdInfo$default = MolocoAdKt.createAdInfo$default(C3430d.this.b, null, 2, null);
                    long j = this.e;
                    C3430d c3430d2 = C3430d.this;
                    com.moloco.sdk.internal.ortb.model.c a3 = c3430d2.a(c3430d2.l);
                    a2.a(createAdInfo$default, j, (a3 == null || (e2 = a3.e()) == null) ? null : e2.i());
                    C3430d c3430d3 = C3430d.this;
                    com.moloco.sdk.internal.ortb.model.c a4 = c3430d3.a(c3430d3.l);
                    if (a4 != null && (e = a4.e()) != null) {
                        rVar = e.i();
                    }
                    a2.a(createAdInfo$default, rVar);
                    return Unit.INSTANCE;
                }
                Job job = C3430d.this.n;
                if (job != null && job.isActive()) {
                    MolocoLogger.info$default(molocoLogger, C3430d.q, "Already loading ad " + C3430d.this.f + ' ' + C3430d.this.b + ". Returning", null, false, 12, null);
                    return Unit.INSTANCE;
                }
            }
            C3430d.this.a(str2, this.e, a2);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl", f = "AdLoad.kt", i = {0}, l = {162}, m = "processBidResponse", n = {"bidResponseJson"}, s = {"L$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.d$c */
    public static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5505a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C3430d.this.a((String) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1", f = "AdLoad.kt", i = {0}, l = {183}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.d$d, reason: collision with other inner class name */
    public static final class C0441d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5506a;
        public /* synthetic */ Object b;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ x f;

        /* renamed from: com.moloco.sdk.internal.publisher.d$d$a */
        public static final class a implements InterfaceC3449b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C3430d f5507a;
            public final /* synthetic */ x b;
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c c;

            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoad$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.internal.publisher.d$d$a$a, reason: collision with other inner class name */
            public static final class C0442a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5508a;
                public final /* synthetic */ C3430d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0442a(C3430d c3430d, x xVar, com.moloco.sdk.internal.ortb.model.c cVar, Continuation<? super C0442a> continuation) {
                    super(2, continuation);
                    this.b = c3430d;
                    this.c = xVar;
                    this.d = cVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0442a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0442a(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    com.moloco.sdk.internal.ortb.model.d e;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5508a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.j = true;
                    x xVar = this.c;
                    MolocoAd createAdInfo = MolocoAdKt.createAdInfo(this.b.b, Boxing.boxFloat(this.d.g()));
                    C3430d c3430d = this.b;
                    com.moloco.sdk.internal.ortb.model.c a2 = c3430d.a(c3430d.l);
                    xVar.a(createAdInfo, (a2 == null || (e = a2.e()) == null) ? null : e.i());
                    return Unit.INSTANCE;
                }
            }

            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadError$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.internal.publisher.d$d$a$b */
            public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5509a;
                public final /* synthetic */ C3430d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(C3430d c3430d, x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar, Continuation<? super b> continuation) {
                    super(2, continuation);
                    this.b = c3430d;
                    this.c = xVar;
                    this.d = cVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new b(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    com.moloco.sdk.internal.ortb.model.d e;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5509a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.j = false;
                    x xVar = this.c;
                    com.moloco.sdk.internal.s a2 = com.moloco.sdk.internal.t.a(this.b.b, MolocoAdError.ErrorType.AD_LOAD_FAILED, this.d);
                    C3430d c3430d = this.b;
                    com.moloco.sdk.internal.ortb.model.c a3 = c3430d.a(c3430d.l);
                    xVar.a(a2, (a3 == null || (e = a3.e()) == null) ? null : e.i());
                    return Unit.INSTANCE;
                }
            }

            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadTimeout$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.internal.publisher.d$d$a$c */
            public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5510a;
                public final /* synthetic */ C3430d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(C3430d c3430d, x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar, Continuation<? super c> continuation) {
                    super(2, continuation);
                    this.b = c3430d;
                    this.c = xVar;
                    this.d = aVar;
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

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    com.moloco.sdk.internal.ortb.model.d e;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5510a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.j = false;
                    x xVar = this.c;
                    com.moloco.sdk.internal.s a2 = com.moloco.sdk.internal.t.a(this.b.b, MolocoAdError.ErrorType.AD_LOAD_TIMEOUT_ERROR, this.d);
                    C3430d c3430d = this.b;
                    com.moloco.sdk.internal.ortb.model.c a3 = c3430d.a(c3430d.l);
                    xVar.a(a2, (a3 == null || (e = a3.e()) == null) ? null : e.i());
                    return Unit.INSTANCE;
                }
            }

            public a(C3430d c3430d, x xVar, com.moloco.sdk.internal.ortb.model.c cVar) {
                this.f5507a = c3430d;
                this.b = xVar;
                this.c = cVar;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
            public void a() {
                BuildersKt__Builders_commonKt.launch$default(this.f5507a.i, null, null, new C0442a(this.f5507a, this.b, this.c, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                BuildersKt__Builders_commonKt.launch$default(this.f5507a.i, null, null, new c(this.f5507a, this.b, timeoutError, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                Intrinsics.checkNotNullParameter(internalError, "internalError");
                BuildersKt__Builders_commonKt.launch$default(this.f5507a.i, null, null, new b(this.f5507a, this.b, internalError, null), 3, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0441d(String str, long j, x xVar, Continuation<? super C0441d> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = j;
            this.f = xVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0441d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0441d c0441d = C3430d.this.new C0441d(this.d, this.e, this.f, continuation);
            c0441d.b = obj;
            return c0441d;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            com.moloco.sdk.internal.ortb.model.e eVar;
            CoroutineScope coroutineScope;
            com.moloco.sdk.internal.ortb.model.c a2;
            com.moloco.sdk.internal.ortb.model.d e;
            com.moloco.sdk.internal.ortb.model.d e2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5506a;
            com.moloco.sdk.internal.ortb.model.r rVar = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.b;
                C3430d.this.j = false;
                if (!Intrinsics.areEqual(C3430d.this.k, this.d)) {
                    C3430d.this.k = this.d;
                    C3430d.this.l = null;
                }
                eVar = C3430d.this.l;
                if (eVar == null) {
                    com.moloco.sdk.internal.ortb.a aVar = C3430d.this.d;
                    String str = this.d;
                    this.b = coroutineScope2;
                    this.f5506a = 1;
                    Object a3 = aVar.a(str, this);
                    if (a3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                    obj = a3;
                }
                a2 = eVar == null ? C3430d.this.a(eVar) : null;
                if (a2 == null) {
                    ((InterfaceC3449b) C3430d.this.c.invoke(a2)).a(((Duration) C3430d.this.f5503a.invoke(Boxing.boxLong(this.e))).getRawValue(), new a(C3430d.this, this.f, a2));
                    return Unit.INSTANCE;
                }
                x xVar = this.f;
                C3430d c3430d = C3430d.this;
                com.moloco.sdk.internal.s a4 = com.moloco.sdk.internal.t.a(c3430d.b, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR, com.moloco.sdk.internal.o.c);
                com.moloco.sdk.internal.ortb.model.c a5 = c3430d.a(c3430d.l);
                if (a5 != null && (e = a5.e()) != null) {
                    rVar = e.i();
                }
                xVar.a(a4, rVar);
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.b;
            ResultKt.throwOnFailure(obj);
            C3430d c3430d2 = C3430d.this;
            x xVar2 = this.f;
            long j = this.e;
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            CoroutineScopeKt.ensureActive(coroutineScope);
            if (vVar instanceof v.b) {
                com.moloco.sdk.internal.ortb.model.e eVar2 = (com.moloco.sdk.internal.ortb.model.e) ((v.b) vVar).a();
                c3430d2.l = eVar2;
                MolocoAd createAdInfo$default = MolocoAdKt.createAdInfo$default(c3430d2.b, null, 2, null);
                com.moloco.sdk.internal.ortb.model.c a6 = c3430d2.a(c3430d2.l);
                xVar2.a(createAdInfo$default, j, (a6 == null || (e2 = a6.e()) == null) ? null : e2.i());
                eVar = eVar2;
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, C3430d.q, "startLoadJob failed to parse BID json string.", (Throwable) ((v.a) vVar).a(), false, 8, null);
                eVar = null;
            }
            if (eVar == null) {
            }
            if (a2 == null) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3430d(CoroutineScope scope, Function1<? super Long, Duration> timeout, String adUnitId, Function1<? super com.moloco.sdk.internal.ortb.model.c, ? extends InterfaceC3449b> recreateXenossAdLoader, com.moloco.sdk.internal.ortb.a parseBidResponse, p adLoadPreprocessor, AdFormatType adFormatType, K webViewChecker, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(recreateXenossAdLoader, "recreateXenossAdLoader");
        Intrinsics.checkNotNullParameter(parseBidResponse, "parseBidResponse");
        Intrinsics.checkNotNullParameter(adLoadPreprocessor, "adLoadPreprocessor");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(webViewChecker, "webViewChecker");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5503a = timeout;
        this.b = adUnitId;
        this.c = recreateXenossAdLoader;
        this.d = parseBidResponse;
        this.e = adLoadPreprocessor;
        this.f = adFormatType;
        this.g = webViewChecker;
        this.h = metricsRecorder;
        this.i = CoroutineScopeKt.plus(scope, com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.m = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.j.c());
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.j;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(this.g.a());
        if (m10244exceptionOrNullimpl != null) {
            MolocoLogger.INSTANCE.error(q, "WebView Error: " + m10244exceptionOrNullimpl.getMessage(), m10244exceptionOrNullimpl, true);
            if (listener != null) {
                listener.onAdLoadFailed(MolocoAdErrorKt.createAdErrorInfo(this.b, MolocoAdError.ErrorType.AD_LOAD_WEBVIEW_FAILED));
                return;
            }
            return;
        }
        long a2 = a.h.f5756a.h().a();
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdLoadImpl", "load() called with bidResponseJson: " + bidResponseJson, false, 4, null);
        this.m.startTimer();
        MetricsRecorder metricsRecorder = this.h;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.j.c());
        String c2 = com.moloco.sdk.internal.client_metrics_data.c.c.c();
        String lowerCase = this.f.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(c2, lowerCase));
        BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new b(bidResponseJson, listener, a2, null), 3, null);
    }

    public final com.moloco.sdk.internal.ortb.model.c a(com.moloco.sdk.internal.ortb.model.e eVar) {
        List<com.moloco.sdk.internal.ortb.model.s> b2;
        com.moloco.sdk.internal.ortb.model.s sVar;
        List<com.moloco.sdk.internal.ortb.model.c> b3;
        if (eVar == null || (b2 = eVar.b()) == null || (sVar = b2.get(0)) == null || (b3 = sVar.b()) == null) {
            return null;
        }
        return b3.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, Continuation<? super String> continuation) {
        c cVar;
        int i;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.d = i2 - Integer.MIN_VALUE;
                Object obj = cVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    p pVar = this.e;
                    cVar.f5505a = str;
                    cVar.d = 1;
                    obj = pVar.a(str, cVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) cVar.f5505a;
                    ResultKt.throwOnFailure(obj);
                }
                String str2 = (String) obj;
                return str2 == null ? str2 : str;
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.d;
        if (i != 0) {
        }
        String str22 = (String) obj2;
        if (str22 == null) {
        }
    }

    public final void a(String str, long j, x xVar) {
        Job launch$default;
        Job job = this.n;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new C0441d(str, j, xVar, null), 3, null);
        this.n = launch$default;
    }
}

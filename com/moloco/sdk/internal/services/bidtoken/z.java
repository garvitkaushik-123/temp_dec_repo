package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes6.dex */
public final class z implements y {
    public static final int i = 8;
    public final InterfaceC3437a b;
    public final CoroutineScope c;
    public final v d;
    public final String e;
    public boolean f;
    public final Mutex g;
    public Job h;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$bidToken$2", f = "ServerBidTokenService.kt", i = {}, l = {190, Sdk.SDKError.Reason.AD_RESPONSE_EMPTY_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function1<Continuation<? super k>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5666a;
        public final /* synthetic */ MetricsRecorder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MetricsRecorder metricsRecorder, Continuation<? super a> continuation) {
            super(1, continuation);
            this.c = metricsRecorder;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super k> continuation) {
            return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return z.this.new a(this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
        
            if (r10 == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5666a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] Acquired lock, fetching status of current token");
                v vVar = z.this.d;
                this.f5666a = 1;
                obj = vVar.a(this);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
            }
            B b = (B) obj;
            z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken status: " + b);
            if (!b.b()) {
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] bidToken needs refresh, fetching new token");
                z zVar = z.this;
                MetricsRecorder metricsRecorder = this.c;
                k b2 = e.b();
                this.f5666a = 2;
                Object a2 = zVar.a(metricsRecorder, b2, false, false, this);
                return a2 == coroutine_suspended ? coroutine_suspended : a2;
            }
            MetricsRecorder metricsRecorder2 = this.c;
            CountEvent withTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.u.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), "true").withTag("initial_fetch", "false");
            B b3 = B.b;
            metricsRecorder2.recordCountEvent(withTag.withTag("expiring", b != b3 ? "false" : "true"));
            k a3 = z.this.d.a();
            if (b != b3) {
                z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken doesn't need refresh, returning cached");
                return a3;
            }
            z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken is expiring, returning cached, and refreshing async");
            z.this.a(this.c);
            return a3;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl", f = "ServerBidTokenService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {129, 173}, m = "fetchServerBidToken$moloco_sdk_release", n = {"this", "metricsRecorder", "defaultTokenOnError", "bidTokenTimer", "asyncFetch", "wasExpiring", "this", "bidTokenFetchResult"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5667a;
        public Object b;
        public Object c;
        public Object d;
        public boolean e;
        public boolean f;
        public /* synthetic */ Object g;
        public int i;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return z.this.a(null, null, false, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$fetchServerBidToken$bidTokenComponents$1", f = "ServerBidTokenService.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5668a;
        public final /* synthetic */ com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m> vVar, Continuation<? super c> continuation) {
            super(1, continuation);
            this.c = vVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return z.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5668a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                v vVar = z.this.d;
                k kVar = (k) ((v.b) this.c).a();
                this.f5668a = 1;
                if (vVar.a(kVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$refreshTokenAsyncOnExpiry$1", f = "ServerBidTokenService.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5669a;
        public final /* synthetic */ MetricsRecorder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MetricsRecorder metricsRecorder, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = metricsRecorder;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return z.this.new d(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            d dVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5669a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] Fetching token from server");
                z zVar = z.this;
                MetricsRecorder metricsRecorder = this.c;
                k b = e.b();
                this.f5669a = 1;
                dVar = this;
                if (zVar.a(metricsRecorder, b, true, true, dVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                dVar = this;
            }
            z.this.b("[Thread: " + Thread.currentThread().getName() + "] Finished fetching token from server");
            return Unit.INSTANCE;
        }
    }

    public z(InterfaceC3437a bidTokenApi, CoroutineScope scope, v tokenCache) {
        Intrinsics.checkNotNullParameter(bidTokenApi, "bidTokenApi");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(tokenCache, "tokenCache");
        this.b = bidTokenApi;
        this.c = scope;
        this.d = tokenCache;
        this.e = "ServerBidTokenServiceImpl";
        this.f = true;
        this.g = MutexKt.Mutex$default(false, 1, null);
    }

    public final void b(String str) {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, null, false, 12, null);
    }

    public final void a(MetricsRecorder metricsRecorder) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        b("[Thread: " + Thread.currentThread().getName() + "] Refreshing token async");
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.w.c());
        Job job = this.h;
        metricsRecorder.recordCountEvent(countEvent.withTag("async", String.valueOf(job != null ? job.isActive() : false)));
        Job job2 = this.h;
        if (job2 != null && job2.isActive()) {
            b("[Thread: " + Thread.currentThread().getName() + "] Async refresh already in progress. Returning");
            return;
        }
        b("[Thread: " + Thread.currentThread().getName() + "] Scheduling to fetch token from server");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new d(metricsRecorder, null), 3, null);
        this.h = launch$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(MetricsRecorder metricsRecorder, k kVar, boolean z, boolean z2, Continuation<? super k> continuation) {
        b bVar;
        int i2;
        k kVar2;
        boolean z3;
        TimerEvent timerEvent;
        boolean z4;
        MetricsRecorder metricsRecorder2;
        z zVar;
        com.moloco.sdk.internal.v vVar;
        z zVar2;
        com.moloco.sdk.internal.v vVar2;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i3 = bVar.i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                bVar.i = i3 - Integer.MIN_VALUE;
                Object obj = bVar.g;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = bVar.i;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    TimerEvent startTimerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.m.c());
                    b("[Thread: " + Thread.currentThread().getName() + "] fetchServerBidToken");
                    InterfaceC3437a interfaceC3437a = this.b;
                    bVar.f5667a = this;
                    bVar.b = metricsRecorder;
                    kVar2 = kVar;
                    bVar.c = kVar2;
                    bVar.d = startTimerEvent;
                    bVar.e = z;
                    z3 = z2;
                    bVar.f = z3;
                    bVar.i = 1;
                    Object a2 = interfaceC3437a.a(metricsRecorder, bVar);
                    if (a2 != coroutine_suspended) {
                        timerEvent = startTimerEvent;
                        obj = a2;
                        z4 = z;
                        metricsRecorder2 = metricsRecorder;
                        zVar = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    vVar2 = (com.moloco.sdk.internal.v) bVar.b;
                    zVar2 = (z) bVar.f5667a;
                    ResultKt.throwOnFailure(obj);
                    k kVar3 = (k) ((v.b) vVar2).a();
                    zVar2.f = false;
                    return kVar3;
                }
                boolean z5 = bVar.f;
                z4 = bVar.e;
                timerEvent = (TimerEvent) bVar.d;
                kVar2 = (k) bVar.c;
                metricsRecorder2 = (MetricsRecorder) bVar.b;
                z zVar3 = (z) bVar.f5667a;
                ResultKt.throwOnFailure(obj);
                z3 = z5;
                zVar = zVar3;
                vVar = (com.moloco.sdk.internal.v) obj;
                if (!(vVar instanceof v.a)) {
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.t.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    CountEvent withTag = countEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE);
                    com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.b;
                    v.a aVar = (v.a) vVar;
                    metricsRecorder2.recordCountEvent(withTag.withTag(cVar2.c(), String.valueOf(((com.moloco.sdk.internal.m) aVar.a()).b())).withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
                    metricsRecorder2.recordTimerEvent(timerEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar2.c(), String.valueOf(((com.moloco.sdk.internal.m) aVar.a()).b())).withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, zVar.e, "bidtoken request failed: " + ((com.moloco.sdk.internal.m) aVar.a()).b() + ", details: " + ((com.moloco.sdk.internal.m) aVar.a()).a(), null, false, 12, null);
                    return kVar2;
                }
                if (vVar instanceof v.b) {
                    CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.t.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder2.recordCountEvent(countEvent2.withTag(cVar3.c(), "success").withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
                    metricsRecorder2.recordTimerEvent(timerEvent.withTag(cVar3.c(), "success").withTag("initial_fetch", String.valueOf(zVar.f)).withTag("was_expiring", String.valueOf(z3)).withTag("async", String.valueOf(z4)));
                    metricsRecorder2.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.u.c()).withTag(cVar3.c(), "false").withTag("initial_fetch", String.valueOf(zVar.f)).withTag("async", String.valueOf(z4)));
                    zVar.b("[Thread: " + Thread.currentThread().getName() + "] bidtoken request success");
                    Mutex mutex = zVar.g;
                    c cVar4 = zVar.new c(vVar, null);
                    bVar.f5667a = zVar;
                    bVar.b = vVar;
                    bVar.c = null;
                    bVar.d = null;
                    bVar.i = 2;
                    if (com.moloco.sdk.internal.utils.a.a(mutex, cVar4, bVar) != coroutine_suspended) {
                        zVar2 = zVar;
                        vVar2 = vVar;
                        k kVar32 = (k) ((v.b) vVar2).a();
                        zVar2.f = false;
                        return kVar32;
                    }
                    return coroutine_suspended;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        bVar = new b(continuation);
        Object obj2 = bVar.g;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = bVar.i;
        if (i2 != 0) {
        }
        vVar = (com.moloco.sdk.internal.v) obj2;
        if (!(vVar instanceof v.a)) {
        }
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.y
    public Object a(MetricsRecorder metricsRecorder, Continuation<? super k> continuation) {
        b("[Thread: " + Thread.currentThread().getName() + "] Fetching bidToken(), acquiring lock");
        return com.moloco.sdk.internal.utils.a.a(this.g, new a(metricsRecorder, null), continuation);
    }

    public final void a(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.e, "[Thread: " + Thread.currentThread().getName() + "] " + str, false, 4, null);
    }
}

package com.moloco.sdk.internal.ilrd.provider;

import android.content.Context;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.moloco.sdk.IlrdRequest;
import com.moloco.sdk.internal.ilrd.c;
import com.moloco.sdk.internal.ilrd.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class b implements c {
    public static final a h = new a(null);
    public static final int i = 8;
    public static final String j = "IronsourceIlrd";

    /* renamed from: a, reason: collision with root package name */
    public final Context f5430a;
    public final CoroutineScope b;
    public final com.moloco.sdk.internal.ilrd.model.a c;
    public final Lazy d;
    public final Lazy e;
    public final MutableStateFlow<g> f;
    public final MutableSharedFlow<c.a.C0433a> g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: com.moloco.sdk.internal.ilrd.provider.b$b, reason: collision with other inner class name */
    public static final class C0436b implements ImpressionDataListener {

        @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.provider.IronsourceIlrd$createCallback$1$onImpressionSuccess$1", f = "IronsourceIlrd.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.internal.ilrd.provider.b$b$a */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5432a;
            public final /* synthetic */ b b;
            public final /* synthetic */ c.a.C0433a c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, c.a.C0433a c0433a, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = bVar;
                this.c = c0433a;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5432a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableSharedFlow mutableSharedFlow = this.b.g;
                    c.a.C0433a c0433a = this.c;
                    this.f5432a = 1;
                    if (mutableSharedFlow.emit(c0433a, this) == coroutine_suspended) {
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

        public C0436b() {
        }

        @Override // com.ironsource.mediationsdk.impressionData.ImpressionDataListener
        public void onImpressionSuccess(ImpressionData impressionData) {
            if (CoroutineScopeKt.isActive(b.this.b) && impressionData != null) {
                BuildersKt__Builders_commonKt.launch$default(b.this.b, null, null, new a(b.this, b.this.a(impressionData), null), 3, null);
            }
        }
    }

    public b(Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f5430a = context;
        this.b = scope;
        this.c = com.moloco.sdk.internal.ilrd.model.a.b;
        this.d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ilrd.provider.b$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return b.d(b.this);
            }
        });
        this.e = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ilrd.provider.b$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return b.c(b.this);
            }
        });
        this.f = StateFlowKt.MutableStateFlow(g.c.b);
        this.g = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static final SharedFlow c(b bVar) {
        return FlowKt.asSharedFlow(bVar.g);
    }

    public static final StateFlow d(b bVar) {
        return FlowKt.asStateFlow(bVar.f);
    }

    private final Object e() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class.forName("com.ironsource.mediationsdk.IronSource");
            Class.forName("com.ironsource.mediationsdk.impressionData.ImpressionData");
            IronSource.addImpressionDataListener(d());
            m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl == null) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m10241constructorimpl(Unit.INSTANCE);
        }
        Result.Companion companion4 = Result.INSTANCE;
        return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
    }

    @Override // com.moloco.sdk.internal.ilrd.c
    public StateFlow<g> getState() {
        return (StateFlow) this.d.getValue();
    }

    @Override // com.moloco.sdk.internal.ilrd.c
    public synchronized Object b() {
        Object e;
        e = e();
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(e);
        if (m10244exceptionOrNullimpl != null) {
            this.f.setValue(new g.a(m10244exceptionOrNullimpl.toString()));
        }
        if (Result.m10248isSuccessimpl(e)) {
            this.f.setValue(g.b.b);
        }
        return e;
    }

    @Override // com.moloco.sdk.internal.ilrd.c
    public SharedFlow<c.a.C0433a> c() {
        return (SharedFlow) this.e.getValue();
    }

    public final C0436b d() {
        return new C0436b();
    }

    @Override // com.moloco.sdk.internal.ilrd.c
    public com.moloco.sdk.internal.ilrd.model.a a() {
        return this.c;
    }

    public final c.a.C0433a a(ImpressionData impressionData) {
        IlrdRequest.LevelPlayImpression.Builder newBuilder = IlrdRequest.LevelPlayImpression.newBuilder();
        try {
            Result.Companion companion = Result.INSTANCE;
            String auctionId = impressionData.getAuctionId();
            Result.m10241constructorimpl(auctionId != null ? newBuilder.setAuctionId(auctionId) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            String adFormat = impressionData.getAdFormat();
            Result.m10241constructorimpl(adFormat != null ? newBuilder.setAdFormat(adFormat) : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th2));
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            String adNetwork = impressionData.getAdNetwork();
            Result.m10241constructorimpl(adNetwork != null ? newBuilder.setNetworkName(adNetwork) : null);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th3));
        }
        try {
            Result.Companion companion7 = Result.INSTANCE;
            String instanceName = impressionData.getInstanceName();
            Result.m10241constructorimpl(instanceName != null ? newBuilder.setInstanceName(instanceName) : null);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th4));
        }
        try {
            Result.Companion companion9 = Result.INSTANCE;
            String instanceId = impressionData.getInstanceId();
            Result.m10241constructorimpl(instanceId != null ? newBuilder.setInstanceId(instanceId) : null);
        } catch (Throwable th5) {
            Result.Companion companion10 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th5));
        }
        try {
            Result.Companion companion11 = Result.INSTANCE;
            String country = impressionData.getCountry();
            Result.m10241constructorimpl(country != null ? newBuilder.setCountryCode(country) : null);
        } catch (Throwable th6) {
            Result.Companion companion12 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th6));
        }
        try {
            Result.Companion companion13 = Result.INSTANCE;
            String placement = impressionData.getPlacement();
            Result.m10241constructorimpl(placement != null ? newBuilder.setPlacement(placement) : null);
        } catch (Throwable th7) {
            Result.Companion companion14 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th7));
        }
        try {
            Result.Companion companion15 = Result.INSTANCE;
            Double revenue = impressionData.getRevenue();
            Result.m10241constructorimpl(revenue != null ? newBuilder.setRevenue(revenue.doubleValue()) : null);
        } catch (Throwable th8) {
            Result.Companion companion16 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th8));
        }
        try {
            Result.Companion companion17 = Result.INSTANCE;
            String precision = impressionData.getPrecision();
            Result.m10241constructorimpl(precision != null ? newBuilder.setPrecision(precision) : null);
        } catch (Throwable th9) {
            Result.Companion companion18 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th9));
        }
        try {
            Result.Companion companion19 = Result.INSTANCE;
            String ab = impressionData.getAb();
            Result.m10241constructorimpl(ab != null ? newBuilder.setAb(ab) : null);
        } catch (Throwable th10) {
            Result.Companion companion20 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th10));
        }
        try {
            Result.Companion companion21 = Result.INSTANCE;
            String segmentName = impressionData.getSegmentName();
            Result.m10241constructorimpl(segmentName != null ? newBuilder.setSegmentName(segmentName) : null);
        } catch (Throwable th11) {
            Result.Companion companion22 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th11));
        }
        try {
            Result.Companion companion23 = Result.INSTANCE;
            Double lifetimeRevenue = impressionData.getLifetimeRevenue();
            Result.m10241constructorimpl(lifetimeRevenue != null ? newBuilder.setLifetimeRevenue(lifetimeRevenue.doubleValue()) : null);
        } catch (Throwable th12) {
            Result.Companion companion24 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th12));
        }
        try {
            Result.Companion companion25 = Result.INSTANCE;
            String encryptedCPM = impressionData.getEncryptedCPM();
            Result.m10241constructorimpl(encryptedCPM != null ? newBuilder.setEncryptedCpm(encryptedCPM) : null);
        } catch (Throwable th13) {
            Result.Companion companion26 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th13));
        }
        try {
            Result.Companion companion27 = Result.INSTANCE;
            String creativeId = impressionData.getCreativeId();
            Result.m10241constructorimpl(creativeId != null ? newBuilder.setCreativeId(creativeId) : null);
        } catch (Throwable th14) {
            Result.Companion companion28 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th14));
        }
        IlrdRequest.LevelPlayImpression build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return new c.a.C0433a(build);
    }
}

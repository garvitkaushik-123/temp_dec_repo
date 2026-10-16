package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import adn.analytics.Analytics;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class F implements InterfaceC3449b {
    public static final int j = 8;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.ortb.model.c f5785a;
    public final CoroutineScope b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d c;
    public final InterfaceC3460j d;
    public final boolean e;
    public com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> f;
    public final MutableStateFlow<Boolean> g;
    public final StateFlow<Boolean> h;
    public Job i;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1", f = "VastAdLoad.kt", i = {0}, l = {Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER, MBSupportMuteAdType.REWARD_VIDEO}, m = "invokeSuspend", n = {"decDeferred"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5786a;
        public /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC3449b.a d;
        public final /* synthetic */ long e;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1", f = "VastAdLoad.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.F$a$a, reason: collision with other inner class name */
        public static final class C0465a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3459i>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5787a;
            public final /* synthetic */ long b;
            public final /* synthetic */ C3459i c;
            public final /* synthetic */ F d;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.F$a$a$a, reason: collision with other inner class name */
            public static final class C0466a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3459i>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5788a;
                public final /* synthetic */ C3459i b;
                public final /* synthetic */ F c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0466a(C3459i c3459i, F f, Continuation<? super C0466a> continuation) {
                    super(2, continuation);
                    this.b = c3459i;
                    this.c = f;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3459i> continuation) {
                    return ((C0466a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0466a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f5788a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        C3459i c3459i = this.b;
                        if (c3459i == null) {
                            return null;
                        }
                        F f = this.c;
                        InterfaceC3460j interfaceC3460j = f.d;
                        com.moloco.sdk.internal.ortb.model.d e = f.f5785a.e();
                        String e2 = e != null ? e.e() : null;
                        this.f5788a = 1;
                        obj = interfaceC3460j.a(c3459i, e2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (C3459i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0465a(long j, C3459i c3459i, F f, Continuation<? super C0465a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = c3459i;
                this.d = f;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3459i> continuation) {
                return ((C0465a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0465a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5787a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0466a c0466a = new C0466a(this.c, this.d, null);
                    this.f5787a = 1;
                    obj = TimeoutKt.m11744withTimeoutOrNullKLykuaI(j, c0466a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                C3459i c3459i = (C3459i) obj;
                return c3459i == null ? this.c : c3459i;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1", f = "VastAdLoad.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5789a;
            public final /* synthetic */ long b;
            public final /* synthetic */ F c;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.F$a$b$a, reason: collision with other inner class name */
            public static final class C0467a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5790a;
                public final /* synthetic */ F b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0467a(F f, Continuation<? super C0467a> continuation) {
                    super(2, continuation);
                    this.b = f;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
                    return ((C0467a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0467a(this.b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f5790a;
                    if (i != 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar = this.b.c;
                    String a2 = this.b.f5785a.a();
                    String a3 = com.moloco.sdk.internal.ortb.model.f.a(this.b.f5785a);
                    this.f5790a = 1;
                    Object a4 = dVar.a(a2, a3, false, this);
                    return a4 == coroutine_suspended ? coroutine_suspended : a4;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, F f, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = f;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5789a;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                long j = this.b;
                C0467a c0467a = new C0467a(this.c, null);
                this.f5789a = 1;
                Object m11743withTimeoutKLykuaI = TimeoutKt.m11743withTimeoutKLykuaI(j, c0467a, this);
                return m11743withTimeoutKLykuaI == coroutine_suspended ? coroutine_suspended : m11743withTimeoutKLykuaI;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC3449b.a aVar, long j, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = aVar;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = F.this.new a(this.d, this.e, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00d7  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.Deferred] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Deferred async$default;
            Deferred async$default2;
            com.moloco.sdk.internal.ortb.model.p g;
            com.moloco.sdk.internal.ortb.model.j i;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar;
            InterfaceC3449b.a aVar2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.f5786a;
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.b;
                    if (F.this.a() instanceof v.b) {
                        InterfaceC3449b.a aVar3 = this.d;
                        if (aVar3 != null) {
                            aVar3.a();
                        }
                        return Unit.INSTANCE;
                    }
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(this.e, F.this, null), 3, null);
                    com.moloco.sdk.internal.ortb.model.d e = F.this.f5785a.e();
                    async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0465a(this.e, (e == null || (g = e.g()) == null || (i = g.i()) == null) ? null : com.moloco.sdk.internal.l.a(i), F.this, null), 3, null);
                    this.b = async$default2;
                    this.f5786a = 1;
                    obj = async$default.await(this);
                    r1 = async$default2;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (r1 != 1) {
                        if (r1 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar4 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) this.b;
                        ResultKt.throwOnFailure(obj);
                        aVar = aVar4;
                        F.this.a(new v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar, null, null, null, null, (C3459i) obj, 15, null)));
                        F.this.g.setValue(Boxing.boxBoolean(true));
                        aVar2 = this.d;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                        return Unit.INSTANCE;
                    }
                    Deferred deferred = (Deferred) this.b;
                    ResultKt.throwOnFailure(obj);
                    r1 = deferred;
                }
                com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
                if (!(vVar instanceof v.b)) {
                    if (!(vVar instanceof v.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    F.this.a(r1, this.d, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
                    return Unit.INSTANCE;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar).a();
                this.b = aVar5;
                this.f5786a = 2;
                Object await = r1.await(this);
                if (await != coroutine_suspended) {
                    aVar = aVar5;
                    obj = await;
                    F.this.a(new v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar, null, null, null, null, (C3459i) obj, 15, null)));
                    F.this.g.setValue(Boxing.boxBoolean(true));
                    aVar2 = this.d;
                    if (aVar2 != null) {
                    }
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (TimeoutCancellationException unused) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, G.f5794a, "main VAST ad didn't load due to timeout", false, 4, null);
                Job.DefaultImpls.cancel$default((Job) r1, (CancellationException) null, 1, (Object) null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar6 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.b;
                F.this.a(new v.a(aVar6));
                InterfaceC3449b.a aVar7 = this.d;
                if (aVar7 != null) {
                    aVar7.a(aVar6);
                }
                return Unit.INSTANCE;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1", f = "VastAdLoad.kt", i = {0, 1, 1}, l = {Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 135}, m = "invokeSuspend", n = {"$this$launch", "vastAdDeferred", "decDeferred"}, s = {"L$0", "L$0", "L$1"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5791a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ InterfaceC3449b.a e;
        public final /* synthetic */ long f;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1", f = "VastAdLoad.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3459i>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5792a;
            public final /* synthetic */ long b;
            public final /* synthetic */ C3459i c;
            public final /* synthetic */ F d;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.F$b$a$a, reason: collision with other inner class name */
            public static final class C0468a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3459i>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5793a;
                public final /* synthetic */ C3459i b;
                public final /* synthetic */ F c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0468a(C3459i c3459i, F f, Continuation<? super C0468a> continuation) {
                    super(2, continuation);
                    this.b = c3459i;
                    this.c = f;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3459i> continuation) {
                    return ((C0468a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0468a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f5793a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        C3459i c3459i = this.b;
                        if (c3459i == null) {
                            return null;
                        }
                        F f = this.c;
                        InterfaceC3460j interfaceC3460j = f.d;
                        com.moloco.sdk.internal.ortb.model.d e = f.f5785a.e();
                        String e2 = e != null ? e.e() : null;
                        this.f5793a = 1;
                        obj = interfaceC3460j.a(c3459i, e2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (C3459i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, C3459i c3459i, F f, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = c3459i;
                this.d = f;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3459i> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5792a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0468a c0468a = new C0468a(this.c, this.d, null);
                    this.f5792a = 1;
                    obj = TimeoutKt.m11744withTimeoutOrNullKLykuaI(j, c0468a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                C3459i c3459i = (C3459i) obj;
                return c3459i == null ? this.c : c3459i;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC3449b.a aVar, long j, Continuation<? super b> continuation) {
            super(2, continuation);
            this.e = aVar;
            this.f = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = F.this.new b(this.e, this.f, continuation);
            bVar.c = obj;
            return bVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x007b, code lost:
        
            if (r15 == r0) goto L41;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0120  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Deferred async$default;
            com.moloco.sdk.internal.v vVar;
            com.moloco.sdk.internal.ortb.model.p g;
            com.moloco.sdk.internal.ortb.model.j i;
            com.moloco.sdk.internal.v vVar2;
            F f;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar;
            InterfaceC3449b.a aVar2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.b;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.c;
                if (F.this.a() instanceof v.b) {
                    InterfaceC3449b.a aVar3 = this.e;
                    if (aVar3 != null) {
                        aVar3.a();
                    }
                    return Unit.INSTANCE;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar = F.this.c;
                String a2 = F.this.f5785a.a();
                String a3 = com.moloco.sdk.internal.ortb.model.f.a(F.this.f5785a);
                this.c = coroutineScope;
                this.b = 1;
                obj = dVar.a(a2, a3, true, this);
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar4 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) this.f5791a;
                        f = (F) this.c;
                        ResultKt.throwOnFailure(obj);
                        aVar = aVar4;
                        f.a(new v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar, null, null, null, null, (C3459i) obj, 15, null)));
                        F.this.g.setValue(Boxing.boxBoolean(true));
                        aVar2 = this.e;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                        return Unit.INSTANCE;
                    }
                    async$default = (Deferred) this.f5791a;
                    vVar = (com.moloco.sdk.internal.v) this.c;
                    ResultKt.throwOnFailure(obj);
                    vVar2 = (com.moloco.sdk.internal.v) obj;
                    if (vVar2 instanceof v.b) {
                        if (!(vVar2 instanceof v.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        MolocoLogger.debug$default(MolocoLogger.INSTANCE, G.f5794a, "main VAST ad didn't load due to failure or timeout", false, 4, null);
                        v.a aVar5 = (v.a) vVar2;
                        if (((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k) aVar5.a()).d()) {
                            F.this.b(async$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) aVar5.a());
                        } else {
                            F.this.a(async$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) aVar5.a());
                        }
                        return Unit.INSTANCE;
                    }
                    F f2 = F.this;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar).a();
                    this.c = f2;
                    this.f5791a = aVar6;
                    this.b = 3;
                    Object await = async$default.await(this);
                    if (await != coroutine_suspended) {
                        f = f2;
                        obj = await;
                        aVar = aVar6;
                        f.a(new v.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a.a(aVar, null, null, null, null, (C3459i) obj, 15, null)));
                        F.this.g.setValue(Boxing.boxBoolean(true));
                        aVar2 = this.e;
                        if (aVar2 != null) {
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                coroutineScope = (CoroutineScope) this.c;
                ResultKt.throwOnFailure(obj);
            }
            CoroutineScope coroutineScope2 = coroutineScope;
            com.moloco.sdk.internal.v vVar3 = (com.moloco.sdk.internal.v) obj;
            com.moloco.sdk.internal.ortb.model.d e = F.this.f5785a.e();
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, null, new a(this.f, (e == null || (g = e.g()) == null || (i = g.i()) == null) ? null : com.moloco.sdk.internal.l.a(i), F.this, null), 3, null);
            if (!(vVar3 instanceof v.b)) {
                if (!(vVar3 instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                F.this.a(async$default, this.e, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar3).a());
                return Unit.INSTANCE;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar2 = F.this.c;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar7 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVar3).a();
            long j = this.f;
            this.c = vVar3;
            this.f5791a = async$default;
            this.b = 2;
            Object a4 = dVar2.a(aVar7, j, this);
            if (a4 != coroutine_suspended) {
                vVar = vVar3;
                obj = a4;
                vVar2 = (com.moloco.sdk.internal.v) obj;
                if (vVar2 instanceof v.b) {
                }
            }
            return coroutine_suspended;
        }
    }

    public F(com.moloco.sdk.internal.ortb.model.c bid, CoroutineScope scope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, InterfaceC3460j decLoader, boolean z) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(loadVast, "loadVast");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        this.f5785a = bid;
        this.b = scope;
        this.c = loadVast;
        this.d = decLoader;
        this.e = z;
        this.f = new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.f5841a);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.g = MutableStateFlow;
        this.h = FlowKt.asStateFlow(MutableStateFlow);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.h;
    }

    public final void c(long j2, InterfaceC3449b.a aVar) {
        Job launch$default;
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new b(aVar, j2, null), 3, null);
        this.i = launch$default;
    }

    public final com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> a() {
        return this.f;
    }

    public final void b(long j2, InterfaceC3449b.a aVar) {
        Job launch$default;
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new a(aVar, j2, null), 3, null);
        this.i = launch$default;
    }

    public final void a(com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<set-?>");
        this.f = vVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j2, InterfaceC3449b.a aVar) {
        if (this.e) {
            c(j2, aVar);
        } else {
            b(j2, aVar);
        }
    }

    public final void b(Deferred<C3459i> deferred, InterfaceC3449b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.b;
        this.f = new v.a(cVar);
        if (aVar != null) {
            aVar.a(aVar2);
        }
    }

    public final void a(Deferred<C3459i> deferred, InterfaceC3449b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        MolocoLogger.error$default(MolocoLogger.INSTANCE, G.f5794a, "Vast AD failed to load: " + cVar, null, false, 12, null);
        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        this.f = new v.a(cVar);
        if (aVar != null) {
            aVar.a(cVar);
        }
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import adn.analytics.Analytics;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class s implements InterfaceC3449b {
    public static final int h = 8;

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f5923a;
    public final com.moloco.sdk.internal.ortb.model.c b;
    public final InterfaceC3460j c;
    public final Function1<Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> d;
    public final MutableStateFlow<Boolean> e;
    public final StateFlow<Boolean> f;
    public com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> g;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1", f = "MraidAdLoad.kt", i = {0}, l = {60, Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER}, m = "invokeSuspend", n = {"decDeferred"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5924a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ InterfaceC3449b.a e;
        public final /* synthetic */ long f;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$decDeferred$1", f = "MraidAdLoad.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s$a$a, reason: collision with other inner class name */
        public static final class C0488a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3459i>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5925a;
            public final /* synthetic */ long b;
            public final /* synthetic */ C3459i c;
            public final /* synthetic */ s d;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$decDeferred$1$1", f = "MraidAdLoad.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s$a$a$a, reason: collision with other inner class name */
            public static final class C0489a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3459i>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public Object f5926a;
                public int b;
                public final /* synthetic */ C3459i c;
                public final /* synthetic */ s d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0489a(C3459i c3459i, s sVar, Continuation<? super C0489a> continuation) {
                    super(2, continuation);
                    this.c = c3459i;
                    this.d = sVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3459i> continuation) {
                    return ((C0489a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0489a(this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    C3459i c3459i;
                    com.moloco.sdk.internal.ortb.model.d e;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.b;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        C3459i c3459i2 = this.c;
                        String str = null;
                        if (c3459i2 == null) {
                            return null;
                        }
                        s sVar = this.d;
                        try {
                            InterfaceC3460j interfaceC3460j = sVar.c;
                            com.moloco.sdk.internal.ortb.model.c cVar = sVar.b;
                            if (cVar != null && (e = cVar.e()) != null) {
                                str = e.e();
                            }
                            this.f5926a = c3459i2;
                            this.b = 1;
                            Object a2 = interfaceC3460j.a(c3459i2, str, this);
                            if (a2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            c3459i = c3459i2;
                            obj = a2;
                        } catch (Exception unused) {
                            return c3459i2;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        c3459i = (C3459i) this.f5926a;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception unused2) {
                            return c3459i;
                        }
                    }
                    return (C3459i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0488a(long j, C3459i c3459i, s sVar, Continuation<? super C0488a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = c3459i;
                this.d = sVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3459i> continuation) {
                return ((C0488a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0488a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5925a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0489a c0489a = new C0489a(this.c, this.d, null);
                    this.f5925a = 1;
                    obj = TimeoutKt.m11744withTimeoutOrNullKLykuaI(j, c0489a, this);
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

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$mraidLoadResultDeferred$1", f = "MraidAdLoad.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5927a;
            public final /* synthetic */ long b;
            public final /* synthetic */ s c;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.MraidAdLoad$load$1$mraidLoadResultDeferred$1$1", f = "MraidAdLoad.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s$a$b$a, reason: collision with other inner class name */
            public static final class C0490a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5928a;
                public final /* synthetic */ s b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0490a(s sVar, Continuation<? super C0490a> continuation) {
                    super(2, continuation);
                    this.b = sVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
                    return ((C0490a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0490a(this.b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f5928a;
                    if (i != 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = this.b.d;
                    this.f5928a = 1;
                    Object invoke = function1.invoke(this);
                    return invoke == coroutine_suspended ? coroutine_suspended : invoke;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(long j, s sVar, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = sVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5927a;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                long j = this.b;
                C0490a c0490a = new C0490a(this.c, null);
                this.f5927a = 1;
                Object m11744withTimeoutOrNullKLykuaI = TimeoutKt.m11744withTimeoutOrNullKLykuaI(j, c0490a, this);
                return m11744withTimeoutOrNullKLykuaI == coroutine_suspended ? coroutine_suspended : m11744withTimeoutOrNullKLykuaI;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC3449b.a aVar, long j, Continuation<? super a> continuation) {
            super(2, continuation);
            this.e = aVar;
            this.f = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = s.this.new a(this.e, this.f, continuation);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00fb  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r1v10, types: [kotlinx.coroutines.Deferred, kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Deferred async$default;
            Deferred async$default2;
            com.moloco.sdk.internal.ortb.model.d e;
            com.moloco.sdk.internal.ortb.model.p g;
            com.moloco.sdk.internal.ortb.model.j i;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVar;
            s sVar;
            InterfaceC3449b.a aVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.b;
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.c;
                    if (s.this.a() instanceof v.b) {
                        InterfaceC3449b.a aVar2 = this.e;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                        return Unit.INSTANCE;
                    }
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new b(this.f, s.this, null), 3, null);
                    com.moloco.sdk.internal.ortb.model.c cVar2 = s.this.b;
                    async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0488a(this.f, (cVar2 == null || (e = cVar2.e()) == null || (g = e.g()) == null || (i = g.i()) == null) ? null : com.moloco.sdk.internal.l.a(i), s.this, null), 3, null);
                    this.c = async$default2;
                    this.b = 1;
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
                        cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) this.f5924a;
                        sVar = (s) this.c;
                        ResultKt.throwOnFailure(obj);
                        sVar.a(new v.b(cVar.a((C3459i) obj)));
                        s.this.e.setValue(Boxing.boxBoolean(true));
                        aVar = this.e;
                        if (aVar != null) {
                            aVar.a();
                        }
                        return Unit.INSTANCE;
                    }
                    Deferred deferred = (Deferred) this.c;
                    ResultKt.throwOnFailure(obj);
                    r1 = deferred;
                }
                com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
                if (vVar == null) {
                    InterfaceC3449b.a aVar3 = this.e;
                    if (aVar3 != null) {
                        aVar3.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.c);
                    }
                } else {
                    if (!(vVar instanceof v.a)) {
                        if (!(vVar instanceof v.b)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        s sVar2 = s.this;
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVar3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((v.b) vVar).a();
                        this.c = sVar2;
                        this.f5924a = cVar3;
                        this.b = 2;
                        Object await = r1.await(this);
                        if (await != coroutine_suspended) {
                            cVar = cVar3;
                            obj = await;
                            sVar = sVar2;
                            sVar.a(new v.b(cVar.a((C3459i) obj)));
                            s.this.e.setValue(Boxing.boxBoolean(true));
                            aVar = this.e;
                            if (aVar != null) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    InterfaceC3449b.a aVar4 = this.e;
                    if (aVar4 != null) {
                        aVar4.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
                    }
                    Job.DefaultImpls.cancel$default((Job) r1, (CancellationException) null, 1, (Object) null);
                }
                return Unit.INSTANCE;
            } catch (TimeoutCancellationException unused) {
                Job.DefaultImpls.cancel$default((Job) r1, (CancellationException) null, 1, (Object) null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar5 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.f;
                s.this.a(new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.e));
                InterfaceC3449b.a aVar6 = this.e;
                if (aVar6 != null) {
                    aVar6.a(aVar5);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(CoroutineScope scope, com.moloco.sdk.internal.ortb.model.c cVar, InterfaceC3460j decLoader, Function1<? super Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, ? extends Object> loadAndReadyMraid) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        Intrinsics.checkNotNullParameter(loadAndReadyMraid, "loadAndReadyMraid");
        this.f5923a = scope;
        this.b = cVar;
        this.c = decLoader;
        this.d = loadAndReadyMraid;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.e = MutableStateFlow;
        this.f = MutableStateFlow;
        this.g = new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.f);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.f;
    }

    public final com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> a() {
        return this.g;
    }

    public final void a(com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<set-?>");
        this.g = vVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j, InterfaceC3449b.a aVar) {
        BuildersKt__Builders_commonKt.launch$default(this.f5923a, null, null, new a(aVar, j, null), 3, null);
    }
}

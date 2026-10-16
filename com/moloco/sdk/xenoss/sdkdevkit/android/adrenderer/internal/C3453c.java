package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3453c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p {
    public static final int s = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5820a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b;
    public final com.moloco.sdk.internal.ortb.model.c c;
    public final InterfaceC3463m d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z e;
    public final String f;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i g;
    public final CoroutineScope h;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> i;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> j;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> k;
    public final q l;
    public final MutableStateFlow<Boolean> m;
    public final StateFlow<Boolean> n;
    public final MutableStateFlow<Boolean> o;
    public final StateFlow<Boolean> p;
    public final MutableStateFlow<Boolean> q;
    public final StateFlow<Boolean> r;

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5821a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f5770a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5821a = iArr;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$load$1", f = "AggregatedFullscreenAd.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$b */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5822a;
        public final /* synthetic */ long c;
        public final /* synthetic */ InterfaceC3449b.a d;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$b$a */
        public static final class a implements InterfaceC3449b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InterfaceC3449b.a f5823a;
            public final /* synthetic */ C3453c b;

            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0475a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f5824a;

                static {
                    int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.values().length];
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f5770a.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.c.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f5824a = iArr;
                }
            }

            public a(InterfaceC3449b.a aVar, C3453c c3453c) {
                this.f5823a = aVar;
                this.b = c3453c;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
            public void a() {
                InterfaceC3449b.a aVar = this.f5823a;
                if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i creativeType = this.b.getCreativeType();
                int i = creativeType == null ? -1 : C0475a.f5824a[creativeType.ordinal()];
                if (i == -1) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, this.b.f, "creativeType is null", null, false, 12, null);
                    return;
                }
                if (i == 1) {
                    InterfaceC3449b.a aVar = this.f5823a;
                    if (aVar != null) {
                        aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.e);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    InterfaceC3449b.a aVar2 = this.f5823a;
                    if (aVar2 != null) {
                        aVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.f);
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                InterfaceC3449b.a aVar3 = this.f5823a;
                if (aVar3 != null) {
                    aVar3.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.g);
                }
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                Intrinsics.checkNotNullParameter(internalError, "internalError");
                InterfaceC3449b.a aVar = this.f5823a;
                if (aVar != null) {
                    aVar.a(internalError);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, InterfaceC3449b.a aVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3453c.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5822a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C3453c c3453c = C3453c.this;
                this.f5822a = 1;
                if (c3453c.b(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l o = C3453c.this.o();
            if (o != null) {
                o.a(this.c, new a(this.d, C3453c.this));
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd", f = "AggregatedFullscreenAd.kt", i = {0}, l = {67}, m = "prepareAd", n = {"this"}, s = {"L$0"})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$c, reason: collision with other inner class name */
    public static final class C0476c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5825a;
        public /* synthetic */ Object b;
        public int d;

        public C0476c(Continuation<? super C0476c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C3453c.this.b(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$2", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$d */
    public static final class d extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5826a;
        public /* synthetic */ boolean b;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((d) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = C3453c.this.new d(continuation);
            dVar.b = ((Boolean) obj).booleanValue();
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5826a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C3453c.this.m.setValue(Boxing.boxBoolean(this.b));
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$3", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$e */
    public static final class e extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5827a;
        public /* synthetic */ boolean b;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((e) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = C3453c.this.new e(continuation);
            eVar.b = ((Boolean) obj).booleanValue();
            return eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5827a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C3453c.this.o.setValue(Boxing.boxBoolean(this.b));
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$4", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$f */
    public static final class f extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5828a;
        public /* synthetic */ boolean b;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((f) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = C3453c.this.new f(continuation);
            fVar.b = ((Boolean) obj).booleanValue();
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5828a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C3453c.this.q.setValue(Boxing.boxBoolean(this.b));
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedFullscreenAd$prepareAd$crType$1", f = "AggregatedFullscreenAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.c$g */
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5829a;

        public g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3453c.this.new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5829a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i c = C3458h.f5847a.c(C3453c.this.c.a());
            C3453c.this.g = c;
            return c;
        }
    }

    public C3453c(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i iVar, com.moloco.sdk.internal.ortb.model.c bid, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        this.f5820a = context;
        this.b = customUserEventBuilderService;
        this.c = bid;
        this.d = externalLinkHandler;
        this.e = watermark;
        this.f = "AggregatedFullscreenAd";
        this.g = iVar;
        this.h = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.l = new q();
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.m = MutableStateFlow;
        this.n = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.o = MutableStateFlow2;
        this.p = MutableStateFlow2;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(bool);
        this.q = MutableStateFlow3;
        this.r = MutableStateFlow3;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.h, null, 1, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> o = o();
        if (o != null) {
            o.destroy();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public StateFlow<Boolean> isLoaded() {
        return this.n;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m
    public StateFlow<Boolean> k() {
        return this.r;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a
    public StateFlow<Boolean> m() {
        return this.p;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> o() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> lVar = this.i;
        if (lVar != null) {
            return lVar;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> lVar2 = this.j;
        return lVar2 == null ? this.k : lVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(Continuation<? super Unit> continuation) {
        C0476c c0476c;
        int i;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i creativeType;
        C3453c c3453c;
        int i2;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> o;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> o2;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> o3;
        StateFlow<Boolean> k;
        Flow onEach;
        StateFlow<Boolean> m;
        Flow onEach2;
        StateFlow<Boolean> isLoaded;
        Flow onEach3;
        com.moloco.sdk.internal.ortb.model.o k2;
        if (continuation instanceof C0476c) {
            c0476c = (C0476c) continuation;
            int i3 = c0476c.d;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c0476c.d = i3 - Integer.MIN_VALUE;
                Object obj = c0476c.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0476c.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    creativeType = getCreativeType();
                    if (creativeType != null) {
                        c3453c = this;
                        i2 = a.f5821a[creativeType.ordinal()];
                        if (i2 == 1) {
                            c3453c.i = c3453c.l.a(c3453c.f5820a, c3453c.c, a.g.f5755a.b().h(), c3453c.e);
                        } else if (i2 == 2) {
                            q qVar = c3453c.l;
                            Context context = c3453c.f5820a;
                            CoroutineScope coroutineScope = c3453c.h;
                            com.moloco.sdk.internal.ortb.model.c cVar = c3453c.c;
                            InterfaceC3463m interfaceC3463m = c3453c.d;
                            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar = c3453c.e;
                            MutableStateFlow<Boolean> mutableStateFlow = c3453c.o;
                            com.moloco.sdk.internal.ortb.model.p g2 = cVar.e().g();
                            c3453c.j = qVar.a(context, coroutineScope, cVar, interfaceC3463m, zVar, mutableStateFlow, (g2 == null || (k2 = g2.k()) == null) ? false : k2.i());
                        } else {
                            if (i2 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            c3453c.k = c3453c.l.a(c3453c.f5820a, c3453c.b, c3453c.c.a(), c3453c.d, c3453c.e);
                        }
                        o = c3453c.o();
                        if (o != null && (isLoaded = o.isLoaded()) != null && (onEach3 = FlowKt.onEach(isLoaded, c3453c.new d(null))) != null) {
                            FlowKt.launchIn(onEach3, c3453c.h);
                        }
                        o2 = c3453c.o();
                        if (o2 != null && (m = o2.m()) != null && (onEach2 = FlowKt.onEach(m, c3453c.new e(null))) != null) {
                            FlowKt.launchIn(onEach2, c3453c.h);
                        }
                        o3 = c3453c.o();
                        if (o3 != null && (k = o3.k()) != null && (onEach = FlowKt.onEach(k, c3453c.new f(null))) != null) {
                            FlowKt.launchIn(onEach, c3453c.h);
                        }
                        return Unit.INSTANCE;
                    }
                    CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
                    g gVar = new g(null);
                    c0476c.f5825a = this;
                    c0476c.d = 1;
                    obj = BuildersKt.withContext(coroutineContext, gVar, c0476c);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    c3453c = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    c3453c = (C3453c) c0476c.f5825a;
                    ResultKt.throwOnFailure(obj);
                }
                creativeType = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i) obj;
                i2 = a.f5821a[creativeType.ordinal()];
                if (i2 == 1) {
                }
                o = c3453c.o();
                if (o != null) {
                    FlowKt.launchIn(onEach3, c3453c.h);
                }
                o2 = c3453c.o();
                if (o2 != null) {
                    FlowKt.launchIn(onEach2, c3453c.h);
                }
                o3 = c3453c.o();
                if (o3 != null) {
                    FlowKt.launchIn(onEach, c3453c.h);
                }
                return Unit.INSTANCE;
            }
        }
        c0476c = new C0476c(continuation);
        Object obj2 = c0476c.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0476c.d;
        if (i != 0) {
        }
        creativeType = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i) obj2;
        i2 = a.f5821a[creativeType.ordinal()];
        if (i2 == 1) {
        }
        o = c3453c.o();
        if (o != null) {
        }
        o2 = c3453c.o();
        if (o2 != null) {
        }
        o3 = c3453c.o();
        if (o3 != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
    public void a(long j, InterfaceC3449b.a aVar) {
        BuildersKt__Builders_commonKt.launch$default(this.h, null, null, new b(j, aVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h options, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g gVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(options, "options");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> lVar = this.i;
        if (lVar != null) {
            lVar.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y>) options.c(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y) gVar);
            Unit unit2 = Unit.INSTANCE;
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> lVar2 = this.j;
        if (lVar2 != null) {
            lVar2.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f>) options.a(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f) gVar);
            Unit unit3 = Unit.INSTANCE;
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> lVar3 = this.k;
        if (lVar3 != null) {
            lVar3.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f>) options.b(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f) gVar);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null || gVar == null) {
            return;
        }
        gVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.b.f5833a);
        Unit unit4 = Unit.INSTANCE;
    }
}

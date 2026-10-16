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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3452b extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> {
    public static final int z = 8;
    public final Context h;
    public final com.moloco.sdk.internal.ortb.model.c i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h j;
    public final InterfaceC3463m k;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z l;
    public final com.moloco.sdk.internal.A m;
    public final CoroutineScope n;
    public final com.moloco.sdk.internal.services.s o;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h p;
    public final String q;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i r;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g s;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> t;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> u;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> v;
    public final InterfaceC3449b w;
    public final MutableStateFlow<Boolean> x;
    public final StateFlow<Boolean> y;

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a */
    public static final class a implements InterfaceC3449b {

        /* renamed from: a, reason: collision with root package name */
        public final MutableStateFlow<Boolean> f5810a;
        public final StateFlow<Boolean> b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a d;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0470a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f5811a;

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
                f5811a = iArr;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$load$1", f = "AggregatedBanner.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b, reason: collision with other inner class name */
        public static final class C0471b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5812a;
            public final /* synthetic */ C3452b c;
            public final /* synthetic */ long d;
            public final /* synthetic */ InterfaceC3449b.a e;

            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b$a, reason: collision with other inner class name */
            public static final class C0472a implements InterfaceC3449b.a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ InterfaceC3449b.a f5813a;
                public final /* synthetic */ C3452b b;

                /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C0473a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f5814a;

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
                        f5814a = iArr;
                    }
                }

                public C0472a(InterfaceC3449b.a aVar, C3452b c3452b) {
                    this.f5813a = aVar;
                    this.b = c3452b;
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
                public void a() {
                    InterfaceC3449b.a aVar = this.f5813a;
                    if (aVar != null) {
                        aVar.a();
                    }
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
                public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                    Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i creativeType = this.b.getCreativeType();
                    int i = creativeType == null ? -1 : C0473a.f5814a[creativeType.ordinal()];
                    if (i == -1) {
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.b.q, "creativeType is null", new Throwable(), false, 8, null);
                        return;
                    }
                    if (i == 1) {
                        InterfaceC3449b.a aVar = this.f5813a;
                        if (aVar != null) {
                            aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.h);
                            return;
                        }
                        return;
                    }
                    if (i == 2) {
                        InterfaceC3449b.a aVar2 = this.f5813a;
                        if (aVar2 != null) {
                            aVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.i);
                            return;
                        }
                        return;
                    }
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InterfaceC3449b.a aVar3 = this.f5813a;
                    if (aVar3 != null) {
                        aVar3.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.j);
                    }
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b.a
                public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                    Intrinsics.checkNotNullParameter(internalError, "internalError");
                    InterfaceC3449b.a aVar = this.f5813a;
                    if (aVar != null) {
                        aVar.a(internalError);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0471b(C3452b c3452b, long j, InterfaceC3449b.a aVar, Continuation<? super C0471b> continuation) {
                super(2, continuation);
                this.c = c3452b;
                this.d = j;
                this.e = aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0471b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return a.this.new C0471b(this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5812a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = a.this;
                    this.f5812a = 1;
                    if (aVar.a(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C bannerImpl = this.c.getBannerImpl();
                if (bannerImpl != null) {
                    bannerImpl.a(this.d, new C0472a(this.e, this.c));
                }
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1", f = "AggregatedBanner.kt", i = {0}, l = {151}, m = "prepareBanner", n = {"this"}, s = {"L$0"})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$c */
        public static final class c extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            public Object f5815a;
            public /* synthetic */ Object b;
            public int d;

            public c(Continuation<? super c> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= Integer.MIN_VALUE;
                return a.this.a(this);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$2", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$d */
        public static final class d extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5816a;
            public /* synthetic */ boolean b;

            public d(Continuation<? super d> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                return ((d) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                d dVar = a.this.new d(continuation);
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
                if (this.f5816a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                a.this.f5810a.setValue(Boxing.boxBoolean(this.b));
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$3", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$e */
        public static final class e extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5817a;
            public /* synthetic */ boolean b;
            public final /* synthetic */ C3452b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(C3452b c3452b, Continuation<? super e> continuation) {
                super(2, continuation);
                this.c = c3452b;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                return ((e) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                e eVar = new e(this.c, continuation);
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
                if (this.f5817a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.c.x.setValue(Boxing.boxBoolean(this.b));
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$crType$1", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$f */
        public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5818a;
            public final /* synthetic */ C3452b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(C3452b c3452b, Continuation<? super f> continuation) {
                super(2, continuation);
                this.b = c3452b;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i> continuation) {
                return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new f(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f5818a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i c = C3458h.f5847a.c(this.b.i.a());
                this.b.r = c;
                return c;
            }
        }

        public a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar) {
            this.d = aVar;
            MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
            this.f5810a = MutableStateFlow;
            this.b = FlowKt.asStateFlow(MutableStateFlow);
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
        public StateFlow<Boolean> isLoaded() {
            return this.b;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b
        public void a(long j, InterfaceC3449b.a aVar) {
            BuildersKt__Builders_commonKt.launch$default(C3452b.this.n, null, null, new C0471b(C3452b.this, j, aVar, null), 3, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object a(Continuation<? super Unit> continuation) {
            c cVar;
            int i;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i creativeType;
            a aVar;
            int i2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C bannerImpl;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C bannerImpl2;
            StateFlow<Boolean> m;
            Flow onEach;
            StateFlow<Boolean> isLoaded;
            Flow onEach2;
            if (continuation instanceof c) {
                cVar = (c) continuation;
                int i3 = cVar.d;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    cVar.d = i3 - Integer.MIN_VALUE;
                    Object obj = cVar.b;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = cVar.d;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        MolocoLogger.debug$default(MolocoLogger.INSTANCE, C3452b.this.q, "Preparing banner", false, 4, null);
                        creativeType = C3452b.this.getCreativeType();
                        if (creativeType != null) {
                            aVar = this;
                            i2 = C0470a.f5811a[creativeType.ordinal()];
                            if (i2 == 1) {
                                C3452b.this.m.a(C3452b.this);
                                C3452b.this.t = new H(C3452b.this.h, aVar.d, C3452b.this.j.c(), C3452b.this.k, C3452b.this.n, new F(C3452b.this.i, C3452b.this.n, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f.a(C3452b.this.h), a.C0463a.f5749a.a(), false));
                            } else if (i2 == 2) {
                                C3452b.this.u = new t(C3452b.this.h, C3452b.this.i.a(), C3452b.this.k, C3452b.this.l, null, C3452b.this.n, 16, null);
                            } else if (i2 == 3) {
                                Context context = C3452b.this.h;
                                com.moloco.sdk.internal.services.s sVar = C3452b.this.o;
                                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar = C3452b.this.p;
                                com.moloco.sdk.internal.ortb.model.m c2 = C3452b.this.i.e().c();
                                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a(context, null, sVar, hVar, (c2 != null ? c2.a() : null) != null, null, 34, null);
                                C3452b.this.v = new z(C3452b.this.h, C3452b.this.l, aVar2, new y(C3452b.this.i.a(), C3452b.this.n, aVar2), C3452b.this.n, null, 32, null);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            bannerImpl = C3452b.this.getBannerImpl();
                            if (bannerImpl != null && (isLoaded = bannerImpl.isLoaded()) != null && (onEach2 = FlowKt.onEach(isLoaded, aVar.new d(null))) != null) {
                                FlowKt.launchIn(onEach2, C3452b.this.n);
                            }
                            bannerImpl2 = C3452b.this.getBannerImpl();
                            if (bannerImpl2 != null && (m = bannerImpl2.m()) != null && (onEach = FlowKt.onEach(m, new e(C3452b.this, null))) != null) {
                                FlowKt.launchIn(onEach, C3452b.this.n);
                            }
                            C3452b c3452b = C3452b.this;
                            c3452b.setAdShowListener(c3452b.getAdShowListener());
                            return Unit.INSTANCE;
                        }
                        CoroutineContext coroutineContext = com.moloco.sdk.internal.scheduling.b.a().getDefault();
                        f fVar = new f(C3452b.this, null);
                        cVar.f5815a = this;
                        cVar.d = 1;
                        obj = BuildersKt.withContext(coroutineContext, fVar, cVar);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVar = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        aVar = (a) cVar.f5815a;
                        ResultKt.throwOnFailure(obj);
                    }
                    creativeType = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i) obj;
                    i2 = C0470a.f5811a[creativeType.ordinal()];
                    if (i2 == 1) {
                    }
                    bannerImpl = C3452b.this.getBannerImpl();
                    if (bannerImpl != null) {
                        FlowKt.launchIn(onEach2, C3452b.this.n);
                    }
                    bannerImpl2 = C3452b.this.getBannerImpl();
                    if (bannerImpl2 != null) {
                        FlowKt.launchIn(onEach, C3452b.this.n);
                    }
                    C3452b c3452b2 = C3452b.this;
                    c3452b2.setAdShowListener(c3452b2.getAdShowListener());
                    return Unit.INSTANCE;
                }
            }
            cVar = new c(continuation);
            Object obj2 = cVar.b;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = cVar.d;
            if (i != 0) {
            }
            creativeType = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i) obj2;
            i2 = C0470a.f5811a[creativeType.ordinal()];
            if (i2 == 1) {
            }
            bannerImpl = C3452b.this.getBannerImpl();
            if (bannerImpl != null) {
            }
            bannerImpl2 = C3452b.this.getBannerImpl();
            if (bannerImpl2 != null) {
            }
            C3452b c3452b22 = C3452b.this;
            c3452b22.setAdShowListener(c3452b22.getAdShowListener());
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$destroy$1", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b, reason: collision with other inner class name */
    public static final class C0474b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5819a;

        public C0474b(Continuation<? super C0474b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0474b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3452b.this.new C0474b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5819a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C3452b.super.destroy();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C bannerImpl = C3452b.this.getBannerImpl();
            if (bannerImpl != null) {
                bannerImpl.destroy();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3452b(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i iVar, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h options, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, com.moloco.sdk.internal.A viewLifecycleOwner, CoroutineScope scope, com.moloco.sdk.internal.services.s clickthroughService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h buttonTracker) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.h = context;
        this.i = bid;
        this.j = options;
        this.k = externalLinkHandler;
        this.l = watermark;
        this.m = viewLifecycleOwner;
        this.n = scope;
        this.o = clickthroughService;
        this.p = buttonTracker;
        this.q = "AggregatedBanner";
        setTag("MolocoAggregatedBannerView");
        this.r = iVar;
        this.w = new a(customUserEventBuilderService);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.x = MutableStateFlow;
        this.y = FlowKt.asStateFlow(MutableStateFlow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<?> getBannerImpl() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> c = this.t;
        if (c != null) {
            return c;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> c2 = this.u;
        return c2 == null ? this.v : c2;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        BuildersKt__Builders_commonKt.launch$default(this.n, null, null, new C0474b(null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public InterfaceC3449b getAdLoader() {
        return this.w;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.r;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getAdShowListener() {
        return this.s;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public void k() {
        setAdView(getBannerImpl());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a
    public StateFlow<Boolean> m() {
        return this.y;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public void setAdShowListener(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g gVar) {
        this.s = gVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> c = this.t;
        if (c != null) {
            c.setAdShowListener(gVar);
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> c2 = this.u;
        if (c2 == null) {
            c2 = this.v;
        }
        if (c2 != null) {
            c2.setAdShowListener(gVar);
        }
    }
}

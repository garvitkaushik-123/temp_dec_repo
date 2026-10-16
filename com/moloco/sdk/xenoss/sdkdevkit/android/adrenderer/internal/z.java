package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class z extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> {
    public static final int p = 8;
    public final Context h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a j;
    public final y k;
    public final CoroutineScope l;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d m;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i n;
    public final Lazy o;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$isAdDisplaying$2$1", f = "StaticBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6343a;
        public /* synthetic */ boolean b;
        public /* synthetic */ boolean c;

        public a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        public final Object a(boolean z, boolean z2, Continuation<? super Boolean> continuation) {
            a aVar = new a(continuation);
            aVar.b = z;
            aVar.c = z2;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Continuation<? super Boolean> continuation) {
            return a(bool.booleanValue(), bool2.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6343a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.b && this.c);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1", f = "StaticBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f6344a;
        public /* synthetic */ Object b;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1$1", f = "StaticBanner.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6345a;
            public final /* synthetic */ z b;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1$1$error$1", f = "StaticBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z$b$a$a, reason: collision with other inner class name */
            public static final class C0569a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g, Continuation<? super Boolean>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f6346a;
                public /* synthetic */ Object b;

                public C0569a(Continuation<? super C0569a> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar, Continuation<? super Boolean> continuation) {
                    return ((C0569a) create(gVar, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0569a c0569a = new C0569a(continuation);
                    c0569a.b = obj;
                    return c0569a;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f6346a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) this.b) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(z zVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = zVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e adShowListener;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6345a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> unrecoverableError = this.b.j.getUnrecoverableError();
                    C0569a c0569a = new C0569a(null);
                    this.f6345a = 1;
                    obj = FlowKt.first(unrecoverableError, c0569a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g gVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g) obj;
                if (gVar != null && (adShowListener = this.b.getAdShowListener()) != null) {
                    adShowListener.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.h.a(gVar));
                }
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.StaticBannerView$prepareAdViewForDisplay$1$2", f = "StaticBanner.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z$b$b, reason: collision with other inner class name */
        public static final class C0570b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f6347a;
            public final /* synthetic */ z b;

            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z$b$b$a */
            public static final class a<T> implements FlowCollector {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ z f6348a;

                public a(z zVar) {
                    this.f6348a = zVar;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e adShowListener = this.f6348a.getAdShowListener();
                    if (adShowListener != null) {
                        adShowListener.a();
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0570b(z zVar, Continuation<? super C0570b> continuation) {
                super(2, continuation);
                this.b = zVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0570b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0570b(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6347a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SharedFlow<Unit> clickthroughEvent = this.b.j.getClickthroughEvent();
                    a aVar = new a(this.b);
                    this.f6347a = 1;
                    if (clickthroughEvent.collect(aVar, this) == coroutine_suspended) {
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

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = z.this.new b(continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f6344a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new a(z.this, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0570b(z.this, null), 3, null);
            z zVar = z.this;
            FrameLayout a2 = zVar.m.a(z.this.h, z.this.j);
            z.this.getWatermark().a(a2);
            zVar.setAdView(a2);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ z(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a aVar, y yVar, CoroutineScope coroutineScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d dVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, zVar, aVar, yVar, coroutineScope, (i & 32) != 0 ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d() : dVar);
    }

    public static final StateFlow d(z zVar) {
        return FlowKt.stateIn(FlowKt.flowCombine(super.m(), zVar.j.c(), new a(null)), zVar.l, SharingStarted.INSTANCE.getEagerly(), Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        super.destroy();
        this.j.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.n;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z getWatermark() {
        return this.i;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public void k() {
        BuildersKt.launch(this.l, EmptyCoroutineContext.INSTANCE, CoroutineStart.DEFAULT, new b(null));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3448a
    public StateFlow<Boolean> m() {
        return (StateFlow) this.o.getValue();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public y getAdLoader() {
        return this.k;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.a staticWebView, y adLoader, CoroutineScope scope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.d webViewWrapper) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(staticWebView, "staticWebView");
        Intrinsics.checkNotNullParameter(adLoader, "adLoader");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(webViewWrapper, "webViewWrapper");
        this.h = context;
        this.i = watermark;
        this.j = staticWebView;
        this.k = adLoader;
        this.l = scope;
        this.m = webViewWrapper;
        setTag("MolocoStaticBannerView");
        this.n = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.c;
        this.o = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z.d(z.this);
            }
        });
    }
}

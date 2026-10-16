package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.common_adapter_internal.AdapterAccess;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.client_metrics_data.d;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class b extends WebView {
    public static final a i = new a(null);
    public static final int j = 8;
    public static final String k = "TemplateWebView";

    /* renamed from: a, reason: collision with root package name */
    public final h f5959a;
    public final g b;
    public final MetricsRecorder c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c d;
    public final CoroutineScope e;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b> f;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> g;
    public final StateFlow<Boolean> h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2", f = "TemplateWebView.kt", i = {0}, l = {140}, m = "invokeSuspend", n = {"timerEvent"}, s = {"L$0"})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b, reason: collision with other inner class name */
    public static final class C0502b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v<Unit, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5960a;
        public int b;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2$isLoadOperationTimedOut$1", f = "TemplateWebView.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b$a */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5961a;
            public final /* synthetic */ b b;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2$isLoadOperationTimedOut$1$1", f = "TemplateWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b$a$a, reason: collision with other inner class name */
            public static final class C0503a extends SuspendLambda implements Function3<Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a, Continuation<? super Pair<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5962a;
                public /* synthetic */ boolean b;
                public /* synthetic */ Object c;

                public C0503a(Continuation<? super C0503a> continuation) {
                    super(3, continuation);
                }

                public final Object a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a aVar, Continuation<? super Pair<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>> continuation) {
                    C0503a c0503a = new C0503a(continuation);
                    c0503a.b = z;
                    c0503a.c = aVar;
                    return c0503a.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a aVar, Continuation<? super Pair<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>> continuation) {
                    return a(bool.booleanValue(), aVar, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5962a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    boolean z = this.b;
                    return TuplesKt.to(Boxing.boxBoolean(z), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a) this.c);
                }
            }

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2$isLoadOperationTimedOut$1$2", f = "TemplateWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b$a$b, reason: collision with other inner class name */
            public static final class C0504b extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>, Continuation<? super Boolean>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5963a;
                public /* synthetic */ Object b;

                public C0504b(Continuation<? super C0504b> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Pair<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> pair, Continuation<? super Boolean> continuation) {
                    return ((C0504b) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0504b c0504b = new C0504b(continuation);
                    c0504b.b = obj;
                    return c0504b;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5963a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Pair pair = (Pair) this.b;
                    return Boxing.boxBoolean(((Boolean) pair.component1()).booleanValue() || ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a) pair.component2()) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<Boolean, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5961a;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                Flow flowCombine = FlowKt.flowCombine(this.b.d.b(), this.b.d.a(), new C0503a(null));
                C0504b c0504b = new C0504b(null);
                this.f5961a = 1;
                Object first = FlowKt.first(flowCombine, c0504b, this);
                return first == coroutine_suspended ? coroutine_suspended : first;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0502b(String str, long j, Continuation<? super C0502b> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super v<Unit, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>> continuation) {
            return ((C0502b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0502b(this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TimerEvent timerEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TimerEvent startTimerEvent = b.this.c.startTimerEvent(d.r.c());
                try {
                    b.this.loadDataWithBaseURL(null, this.d, "text/html", "UTF-8", null);
                    long j = this.e;
                    a aVar = new a(b.this, null);
                    this.f5960a = startTimerEvent;
                    this.b = 1;
                    Object m11744withTimeoutOrNullKLykuaI = TimeoutKt.m11744withTimeoutOrNullKLykuaI(j, aVar, this);
                    if (m11744withTimeoutOrNullKLykuaI == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    timerEvent = startTimerEvent;
                    obj = m11744withTimeoutOrNullKLykuaI;
                } catch (Exception e) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, b.k, "loadHtml failed to load the provided html", e, false, 8, null);
                    MetricsRecorder metricsRecorder = b.this.c;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.E.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    CountEvent withTag = countEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE);
                    com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.b;
                    metricsRecorder.recordCountEvent(withTag.withTag(cVar2.c(), "invalid_url"));
                    b.this.c.recordTimerEvent(startTimerEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar2.c(), "invalid_url"));
                    return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.b);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                timerEvent = (TimerEvent) this.f5960a;
                ResultKt.throwOnFailure(obj);
            }
            if (obj == null) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, b.k, "Ad failed to load due to timeout", null, false, 12, null);
                MetricsRecorder metricsRecorder2 = b.this.c;
                CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.E.c());
                com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.d;
                CountEvent withTag2 = countEvent2.withTag(cVar3.c(), AnalyticsConstants.EVENT_FAILURE);
                com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.b;
                metricsRecorder2.recordCountEvent(withTag2.withTag(cVar4.c(), "timeout_error"));
                b.this.c.recordTimerEvent(timerEvent.withTag(cVar3.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar4.c(), "timeout_error"));
                return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.f);
            }
            boolean booleanValue = b.this.d.b().getValue().booleanValue();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a value = b.this.d.a().getValue();
            if (value != null) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, b.k, "Ad failed to load due to unrecoverable error: " + value.name(), null, false, 12, null);
                MetricsRecorder metricsRecorder3 = b.this.c;
                CountEvent countEvent3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.E.c());
                com.moloco.sdk.internal.client_metrics_data.c cVar5 = com.moloco.sdk.internal.client_metrics_data.c.d;
                CountEvent withTag3 = countEvent3.withTag(cVar5.c(), AnalyticsConstants.EVENT_FAILURE);
                com.moloco.sdk.internal.client_metrics_data.c cVar6 = com.moloco.sdk.internal.client_metrics_data.c.b;
                metricsRecorder3.recordCountEvent(withTag3.withTag(cVar6.c(), value.name()));
                b.this.c.recordTimerEvent(timerEvent.withTag(cVar5.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar6.c(), value.name()));
                return new v.a(value);
            }
            if (booleanValue) {
                MetricsRecorder metricsRecorder4 = b.this.c;
                CountEvent countEvent4 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.E.c());
                com.moloco.sdk.internal.client_metrics_data.c cVar7 = com.moloco.sdk.internal.client_metrics_data.c.d;
                metricsRecorder4.recordCountEvent(countEvent4.withTag(cVar7.c(), "success"));
                b.this.c.recordTimerEvent(timerEvent.withTag(cVar7.c(), "success"));
                return new v.b(Unit.INSTANCE);
            }
            MetricsRecorder metricsRecorder5 = b.this.c;
            CountEvent countEvent5 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.E.c());
            com.moloco.sdk.internal.client_metrics_data.c cVar8 = com.moloco.sdk.internal.client_metrics_data.c.d;
            CountEvent withTag4 = countEvent5.withTag(cVar8.c(), AnalyticsConstants.EVENT_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar9 = com.moloco.sdk.internal.client_metrics_data.c.b;
            metricsRecorder5.recordCountEvent(withTag4.withTag(cVar9.c(), "unknown_error"));
            b.this.c.recordTimerEvent(timerEvent.withTag(cVar8.c(), AnalyticsConstants.EVENT_FAILURE).withTag(cVar9.c(), "unknown_error"));
            return new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.f5974a);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$startCollectingPlaylistItemDisplaying$1", f = "TemplateWebView.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5964a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a c;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f5965a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a b;

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$startCollectingPlaylistItemDisplaying$1$1$1", f = "TemplateWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$c$a$a, reason: collision with other inner class name */
            public static final class C0505a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public int f5966a;
                public final /* synthetic */ b b;
                public final /* synthetic */ g.a c;

                /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$c$a$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C0506a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f5967a;

                    static {
                        int[] iArr = new int[g.a.values().length];
                        try {
                            iArr[g.a.d.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[g.a.c.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        f5967a = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0505a(b bVar, g.a aVar, Continuation<? super C0505a> continuation) {
                    super(2, continuation);
                    this.b = bVar;
                    this.c = aVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0505a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0505a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f5966a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    WebSettings settings = this.b.getSettings();
                    int i = C0506a.f5967a[this.c.ordinal()];
                    settings.setMediaPlaybackRequiresUserGesture(i != 1 ? i != 2 ? this.b.getSettings().getMediaPlaybackRequiresUserGesture() : false : true);
                    return Unit.INSTANCE;
                }
            }

            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$startCollectingPlaylistItemDisplaying$1$1", f = "TemplateWebView.kt", i = {0, 0}, l = {85}, m = "emit", n = {"this", "creativeType"}, s = {"L$0", "L$1"})
            /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$c$a$b, reason: collision with other inner class name */
            public static final class C0507b extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                public Object f5968a;
                public Object b;
                public /* synthetic */ Object c;
                public final /* synthetic */ a<T> d;
                public int e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0507b(a<? super T> aVar, Continuation<? super C0507b> continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= Integer.MIN_VALUE;
                    return this.d.emit(null, this);
                }
            }

            public a(b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a aVar) {
                this.f5965a = bVar;
                this.b = aVar;
            }

            /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(8:5|6|7|(1:(2:10|11)(2:19|20))(3:21|22|(1:24)(1:25))|12|(1:14)(1:18)|15|16))|28|6|7|(0)(0)|12|(0)(0)|15|16) */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x00e2, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00e3, code lost:
            
                com.moloco.sdk.internal.MolocoLogger.info$default(com.moloco.sdk.internal.MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b.k, "Failed to access WebView settings", r0, false, 8, null);
             */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0081 A[Catch: Exception -> 0x00e2, TryCatch #0 {Exception -> 0x00e2, blocks: (B:11:0x0032, B:12:0x005a, B:14:0x0081, B:18:0x00c3, B:22:0x0041), top: B:7:0x0026 }] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x00c3 A[Catch: Exception -> 0x00e2, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e2, blocks: (B:11:0x0032, B:12:0x005a, B:14:0x0081, B:18:0x00c3, B:22:0x0041), top: B:7:0x0026 }] */
            /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(g.a aVar, Continuation<? super Unit> continuation) {
                C0507b c0507b;
                int i;
                a<T> aVar2;
                if (continuation instanceof C0507b) {
                    c0507b = (C0507b) continuation;
                    int i2 = c0507b.e;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0507b.e = i2 - Integer.MIN_VALUE;
                        Object obj = c0507b.c;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c0507b.e;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            MainCoroutineDispatcher main = Dispatchers.getMain();
                            C0505a c0505a = new C0505a(this.f5965a, aVar, null);
                            c0507b.f5968a = this;
                            c0507b.b = aVar;
                            c0507b.e = 1;
                            if (BuildersKt.withContext(main, c0505a, c0507b) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aVar2 = this;
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            aVar = (g.a) c0507b.b;
                            aVar2 = (a) c0507b.f5968a;
                            ResultKt.throwOnFailure(obj);
                        }
                        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                        MolocoLogger.info$default(molocoLogger, b.k, "Set playback: " + aVar2.f5965a.getSettings().getMediaPlaybackRequiresUserGesture(), null, false, 12, null);
                        if (aVar != g.a.d) {
                            MolocoLogger.info$default(molocoLogger, b.k, "Playlist item displaying event is MRAID, setting orientation to: " + aVar2.b.e().getValue(), null, false, 12, null);
                            aVar2.f5965a.f.setValue(n.a.i.a(aVar2.b.e().getValue()));
                            aVar2.b.d();
                        } else {
                            MolocoLogger.info$default(molocoLogger, b.k, "Playlist item displaying event is not MRAID, setting orientation to none", null, false, 12, null);
                            aVar2.f5965a.f.setValue(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.d, false, 2, null));
                        }
                        return Unit.INSTANCE;
                    }
                }
                c0507b = new C0507b(this, continuation);
                Object obj2 = c0507b.c;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0507b.e;
                if (i != 0) {
                }
                MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger2, b.k, "Set playback: " + aVar2.f5965a.getSettings().getMediaPlaybackRequiresUserGesture(), null, false, 12, null);
                if (aVar != g.a.d) {
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a aVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5964a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableSharedFlow<g.a> c = b.this.b.c();
                    a aVar = new a(b.this, this.c);
                    this.f5964a = 1;
                    if (c.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            } catch (Exception e) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.k, "Error collecting playlist item displaying events", e, false, 8, null);
                return Unit.INSTANCE;
            }
        }
    }

    public /* synthetic */ b(Context context, h hVar, g gVar, MetricsRecorder metricsRecorder, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c cVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, hVar, gVar, metricsRecorder, (i2 & 16) != 0 ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c(hVar, metricsRecorder) : cVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        super.destroy();
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b> getOrientation$moloco_sdk_release() {
        return this.f;
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> getUnrecoverableError() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.e, null, 1, null);
    }

    public final StateFlow<Boolean> a() {
        return this.h;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, h contentLoadedEventHandler, g playListItemDisplayingEventHandler, MetricsRecorder metricsRecorder, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c webViewClientImpl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentLoadedEventHandler, "contentLoadedEventHandler");
        Intrinsics.checkNotNullParameter(playListItemDisplayingEventHandler, "playListItemDisplayingEventHandler");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        Intrinsics.checkNotNullParameter(webViewClientImpl, "webViewClientImpl");
        this.f5959a = contentLoadedEventHandler;
        this.b = playListItemDisplayingEventHandler;
        this.c = metricsRecorder;
        this.d = webViewClientImpl;
        this.e = CoroutineScopeKt.CoroutineScope(AdapterAccess.INSTANCE.DispatcherProvider().getMain());
        this.f = StateFlowKt.MutableStateFlow(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.d, false, 2, null));
        setWebViewClient(webViewClientImpl);
        setScrollBarStyle(0);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        setSaveEnabled(false);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        setBackgroundColor(0);
        this.g = webViewClientImpl.a();
        this.h = webViewClientImpl.c();
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a mraidCommunicationHub) {
        Intrinsics.checkNotNullParameter(mraidCommunicationHub, "mraidCommunicationHub");
        BuildersKt__Builders_commonKt.launch$default(this.e, null, null, new c(mraidCommunicationHub, null), 3, null);
    }

    public final Object a(String str, long j2, Continuation<? super v<Unit, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a>> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C0502b(str, j2, null), continuation);
    }
}

package com.moloco.sdk.internal.publisher;

import android.content.Context;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.InterfaceC3424a;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.error.b;
import com.moloco.sdk.internal.i;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.service_locator.a;
import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.StateFlow;

/* renamed from: com.moloco.sdk.internal.publisher.b, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3428b {
    public static final a f = new a(null);
    public static final int g = 8;
    public static final String h = "UNABLE_TO_CREATE_AD";
    public static final String i = "AdCreator";

    /* renamed from: a, reason: collision with root package name */
    public final StateFlow<Initialization> f5491a;
    public final I b;
    public final C3429c c;
    public final Function1<Continuation<? super InterfaceC3424a>, Object> d;
    public final CoroutineContext e;

    /* renamed from: com.moloco.sdk.internal.publisher.b$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: com.moloco.sdk.internal.publisher.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0440b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5492a;

        static {
            int[] iArr = new int[Initialization.values().length];
            try {
                iArr[Initialization.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Initialization.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f5492a = iArr;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator", f = "AdCreator.kt", i = {0, 0, 0}, l = {TTAdConstant.PACKAGE_NAME_CODE}, m = "awaitAdFactoryWithTimeoutOrNull", n = {"createAdType", "metricsRecorder", "awaitTimer"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: com.moloco.sdk.internal.publisher.b$c */
    public static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5493a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return C3428b.this.a(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$awaitAdFactoryWithTimeoutOrNull$2", f = "AdCreator.kt", i = {}, l = {TTAdConstant.PACKAGE_NAME_CODE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.internal.publisher.b$d */
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InterfaceC3424a>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5494a;
        public final /* synthetic */ Function1<Continuation<? super InterfaceC3424a>, Object> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Continuation<? super InterfaceC3424a>, ? extends Object> function1, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InterfaceC3424a> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5494a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super InterfaceC3424a>, Object> function1 = this.b;
            this.f5494a = 1;
            Object invoke = function1.invoke(this);
            return invoke == coroutine_suspended ? coroutine_suspended : invoke;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createBanner$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {69}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.b$e */
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5495a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super e> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3428b.this.new e(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            s sVar;
            String a2;
            Object a3;
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sVar = s.f5579a;
                long invoke = C3428b.this.b.invoke();
                a2 = C3428b.this.a();
                TimerEvent withTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar.name()).withTag("initial_sdk_init_state", a2);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Creating " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                C3428b c3428b = C3428b.this;
                Function1 function1 = c3428b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f5495a = sVar;
                this.b = a2;
                this.c = withTag;
                this.d = invoke;
                this.e = 1;
                a3 = c3428b.a(function1, sVar, metricsRecorder, this);
                if (a3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = withTag;
                j = invoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                a2 = (String) this.b;
                sVar = (s) this.f5495a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                a3 = obj;
            }
            String str = a2;
            s sVar2 = sVar;
            InterfaceC3424a interfaceC3424a = (InterfaceC3424a) a3;
            if (interfaceC3424a != null) {
                Context a4 = com.moloco.sdk.service_locator.a.f5748a.a();
                InterfaceC3442f e = a.b.f5750a.e();
                String str2 = this.h;
                a.h hVar = a.h.f5756a;
                ViewParent b = interfaceC3424a.b(a4, e, str2, hVar.j(), hVar.f(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C3427a(AdFormatType.BANNER, com.moloco.sdk.internal.mediators.b.a(this.j), null), hVar.i(), i.c.d, this.g);
                if (b != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.i.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(cVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag("initial_sdk_init_state", str));
                    this.g.recordTimerEvent(timerEvent.withTag(cVar.c(), "success"));
                    if (b instanceof r) {
                        ((r) b).setCreateAdObjectStartTime(j);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Created " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(b);
                }
            }
            MolocoAdError.AdCreateError a5 = C3428b.this.a(this.h, str, timerEvent, sVar2, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C3428b.i, "Failed to create " + sVar2 + " with reason: " + a5, null, false, 12, null);
            return new v.a(a5);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createBannerTablet$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.b$f */
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5496a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super f> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3428b.this.new f(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            s sVar;
            String a2;
            Object a3;
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sVar = s.b;
                long invoke = C3428b.this.b.invoke();
                a2 = C3428b.this.a();
                TimerEvent withTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar.name()).withTag("initial_sdk_init_state", a2);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Creating " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                C3428b c3428b = C3428b.this;
                Function1 function1 = c3428b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f5496a = sVar;
                this.b = a2;
                this.c = withTag;
                this.d = invoke;
                this.e = 1;
                a3 = c3428b.a(function1, sVar, metricsRecorder, this);
                if (a3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = withTag;
                j = invoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                a2 = (String) this.b;
                sVar = (s) this.f5496a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                a3 = obj;
            }
            String str = a2;
            s sVar2 = sVar;
            InterfaceC3424a interfaceC3424a = (InterfaceC3424a) a3;
            if (interfaceC3424a != null) {
                Context a4 = com.moloco.sdk.service_locator.a.f5748a.a();
                InterfaceC3442f e = a.b.f5750a.e();
                String str2 = this.h;
                a.h hVar = a.h.f5756a;
                ViewParent c = interfaceC3424a.c(a4, e, str2, hVar.j(), hVar.f(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C3427a(AdFormatType.BANNER, com.moloco.sdk.internal.mediators.b.a(this.j), null), hVar.i(), i.d.d, this.g);
                if (c != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.i.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(cVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag("initial_sdk_init_state", str));
                    this.g.recordTimerEvent(timerEvent.withTag(cVar.c(), "success"));
                    if (c instanceof r) {
                        ((r) c).setCreateAdObjectStartTime(j);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Created " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(c);
                }
            }
            MolocoAdError.AdCreateError a5 = C3428b.this.a(this.h, str, timerEvent, sVar2, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C3428b.i, "Failed to create " + sVar2 + " with reason: " + a5, null, false, 12, null);
            return new v.a(a5);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createInterstitial$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {264}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.b$g */
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5497a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super g> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3428b.this.new g(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            s sVar;
            String a2;
            Object a3;
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sVar = s.f;
                long invoke = C3428b.this.b.invoke();
                a2 = C3428b.this.a();
                TimerEvent withTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar.name()).withTag("initial_sdk_init_state", a2);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Creating " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                C3428b c3428b = C3428b.this;
                Function1 function1 = c3428b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f5497a = sVar;
                this.b = a2;
                this.c = withTag;
                this.d = invoke;
                this.e = 1;
                a3 = c3428b.a(function1, sVar, metricsRecorder, this);
                if (a3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = withTag;
                j = invoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                a2 = (String) this.b;
                sVar = (s) this.f5497a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                a3 = obj;
            }
            String str = a2;
            s sVar2 = sVar;
            InterfaceC3424a interfaceC3424a = (InterfaceC3424a) a3;
            if (interfaceC3424a != null) {
                Context a4 = com.moloco.sdk.service_locator.a.f5748a.a();
                InterfaceC3442f e = a.b.f5750a.e();
                String str2 = this.h;
                a.h hVar = a.h.f5756a;
                InterstitialAd a5 = interfaceC3424a.a(a4, e, str2, hVar.j(), hVar.f(), a.i.f5757a.c(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C3427a(AdFormatType.INTERSTITIAL, com.moloco.sdk.internal.mediators.b.b(this.j), null), this.g);
                if (a5 != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.i.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(cVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag("initial_sdk_init_state", str.toString()));
                    this.g.recordTimerEvent(timerEvent.withTag(cVar.c(), "success"));
                    if (a5 instanceof r) {
                        ((r) a5).setCreateAdObjectStartTime(j);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Created " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(a5);
                }
            }
            MolocoAdError.AdCreateError a6 = C3428b.this.a(this.h, str, timerEvent, sVar2, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C3428b.i, "Failed to create " + sVar2 + " with reason: " + a6, null, false, 12, null);
            return new v.a(a6);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createMREC$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {169}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.b$h */
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5498a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super h> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3428b.this.new h(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            s sVar;
            String a2;
            Object a3;
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sVar = s.c;
                long a4 = C3428b.this.b.a();
                a2 = C3428b.this.a();
                TimerEvent withTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar.name()).withTag("initial_sdk_init_state", a2);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Creating " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                C3428b c3428b = C3428b.this;
                Function1 function1 = c3428b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f5498a = sVar;
                this.b = a2;
                this.c = withTag;
                this.d = a4;
                this.e = 1;
                a3 = c3428b.a(function1, sVar, metricsRecorder, this);
                if (a3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = withTag;
                j = a4;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                a2 = (String) this.b;
                sVar = (s) this.f5498a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                a3 = obj;
            }
            String str = a2;
            s sVar2 = sVar;
            InterfaceC3424a interfaceC3424a = (InterfaceC3424a) a3;
            if (interfaceC3424a != null) {
                Context a5 = com.moloco.sdk.service_locator.a.f5748a.a();
                InterfaceC3442f e = a.b.f5750a.e();
                String str2 = this.h;
                a.h hVar = a.h.f5756a;
                ViewParent a6 = interfaceC3424a.a(a5, e, str2, hVar.j(), hVar.f(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C3427a(AdFormatType.MREC, com.moloco.sdk.internal.mediators.b.a(this.j), null), hVar.i(), i.b.d, this.g);
                if (a6 != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.i.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(cVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag("initial_sdk_init_state", str.toString()));
                    this.g.recordTimerEvent(timerEvent.withTag(cVar.c(), "success"));
                    if (a6 instanceof r) {
                        ((r) a6).setCreateAdObjectStartTime(j);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Created " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(a6);
                }
            }
            MolocoAdError.AdCreateError a7 = C3428b.this.a(this.h, str, timerEvent, sVar2, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C3428b.i, "Failed to create " + sVar2 + " with reason: " + a7, null, false, 12, null);
            return new v.a(a7);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createNativeAd$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.b$i */
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5499a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super i> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3428b.this.new i(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            s sVar;
            String a2;
            Object a3;
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sVar = s.d;
                long a4 = C3428b.this.b.a();
                a2 = C3428b.this.a();
                TimerEvent withTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar.name()).withTag("initial_sdk_init_state", a2);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Creating " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                C3428b c3428b = C3428b.this;
                Function1 function1 = c3428b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f5499a = sVar;
                this.b = a2;
                this.c = withTag;
                this.d = a4;
                this.e = 1;
                a3 = c3428b.a(function1, sVar, metricsRecorder, this);
                if (a3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = withTag;
                j = a4;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                a2 = (String) this.b;
                sVar = (s) this.f5499a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                a3 = obj;
            }
            String str = a2;
            s sVar2 = sVar;
            InterfaceC3424a interfaceC3424a = (InterfaceC3424a) a3;
            if (interfaceC3424a != null) {
                Context a5 = com.moloco.sdk.service_locator.a.f5748a.a();
                InterfaceC3442f e = a.b.f5750a.e();
                com.moloco.sdk.internal.services.n i2 = a.e.f5753a.i();
                String str2 = this.h;
                a.h hVar = a.h.f5756a;
                NativeAd a6 = interfaceC3424a.a(a5, e, i2, str2, hVar.j(), hVar.f(), a.i.f5757a.c(), hVar.i(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C3427a(AdFormatType.NATIVE, com.moloco.sdk.internal.mediators.b.c(this.j), null), hVar.h(), a.C0463a.f5749a.b(), this.g);
                if (a6 != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.i.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(cVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag("initial_sdk_init_state", str.toString()));
                    this.g.recordTimerEvent(timerEvent.withTag(cVar.c(), "success"));
                    if (a6 instanceof r) {
                        ((r) a6).setCreateAdObjectStartTime(j);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Created " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(a6);
                }
            }
            MolocoAdError.AdCreateError a7 = C3428b.this.a(this.h, str, timerEvent, sVar2, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C3428b.i, "Failed to create " + sVar2 + " with reason: " + a7, null, false, 12, null);
            return new v.a(a7);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createRewardedInterstitial$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {Sdk.SDKError.Reason.MRAID_JS_CALL_EMPTY_VALUE}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.b$j */
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5500a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super j> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3428b.this.new j(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            s sVar;
            String a2;
            Object a3;
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sVar = s.g;
                long invoke = C3428b.this.b.invoke();
                a2 = C3428b.this.a();
                TimerEvent withTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar.name()).withTag("initial_sdk_init_state", a2);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Creating " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                C3428b c3428b = C3428b.this;
                Function1 function1 = c3428b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f5500a = sVar;
                this.b = a2;
                this.c = withTag;
                this.d = invoke;
                this.e = 1;
                a3 = c3428b.a(function1, sVar, metricsRecorder, this);
                if (a3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = withTag;
                j = invoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                a2 = (String) this.b;
                sVar = (s) this.f5500a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                a3 = obj;
            }
            String str = a2;
            s sVar2 = sVar;
            InterfaceC3424a interfaceC3424a = (InterfaceC3424a) a3;
            if (interfaceC3424a != null) {
                Context a4 = com.moloco.sdk.service_locator.a.f5748a.a();
                InterfaceC3442f e = a.b.f5750a.e();
                String str2 = this.h;
                a.h hVar = a.h.f5756a;
                RewardedInterstitialAd b = interfaceC3424a.b(a4, e, str2, hVar.j(), hVar.f(), a.i.f5757a.c(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C3427a(AdFormatType.REWARDED, com.moloco.sdk.internal.mediators.b.b(this.j), null), this.g);
                if (b != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.i.c());
                    com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(cVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag("initial_sdk_init_state", str));
                    this.g.recordTimerEvent(timerEvent.withTag(cVar.c(), "success"));
                    if (b instanceof r) {
                        ((r) b).setCreateAdObjectStartTime(j);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C3428b.i, "Created " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(b);
                }
            }
            MolocoAdError.AdCreateError a5 = C3428b.this.a(this.h, str, timerEvent, sVar2, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C3428b.i, "Failed to create " + sVar2 + " with reason: " + a5, null, false, 12, null);
            return new v.a(a5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3428b(StateFlow<? extends Initialization> initializationState, I timeProviderService, C3429c adCreatorConfiguration, Function1<? super Continuation<? super InterfaceC3424a>, ? extends Object> awaitAdFactory) {
        Intrinsics.checkNotNullParameter(initializationState, "initializationState");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(adCreatorConfiguration, "adCreatorConfiguration");
        Intrinsics.checkNotNullParameter(awaitAdFactory, "awaitAdFactory");
        this.f5491a = initializationState;
        this.b = timeProviderService;
        this.c = adCreatorConfiguration;
        this.d = awaitAdFactory;
        this.e = com.moloco.sdk.internal.scheduling.b.a().getDefault();
    }

    public final Object d(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new h(metricsRecorder, str2, str3, str, null), continuation);
    }

    public final Object e(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new i(metricsRecorder, str2, str3, str, null), continuation);
    }

    public final Object f(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new j(metricsRecorder, str2, str3, str, null), continuation);
    }

    public static /* synthetic */ Object d(C3428b c3428b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c3428b.d(str, str2, metricsRecorder, str3, continuation);
    }

    public static /* synthetic */ Object e(C3428b c3428b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c3428b.e(str, str2, metricsRecorder, str3, continuation);
    }

    public static /* synthetic */ Object f(C3428b c3428b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c3428b.f(str, str2, metricsRecorder, str3, continuation);
    }

    public final Object b(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new f(metricsRecorder, str2, str3, str, null), continuation);
    }

    public final Object c(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new g(metricsRecorder, str2, str3, str, null), continuation);
    }

    public static /* synthetic */ Object b(C3428b c3428b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c3428b.b(str, str2, metricsRecorder, str3, continuation);
    }

    public static /* synthetic */ Object c(C3428b c3428b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c3428b.c(str, str2, metricsRecorder, str3, continuation);
    }

    public final Object a(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new e(metricsRecorder, str2, str3, str, null), continuation);
    }

    public static /* synthetic */ Object a(C3428b c3428b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c3428b.a(str, str2, metricsRecorder, str3, (Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>) continuation);
    }

    public final MolocoAdError.AdCreateError a(String str, String str2, TimerEvent timerEvent, s sVar, MetricsRecorder metricsRecorder) {
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.i.c());
        com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
        CountEvent withTag = countEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE).withTag("initial_sdk_init_state", str2).withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar.name());
        Initialization value = this.f5491a.getValue();
        int i2 = value == null ? -1 : C0440b.f5492a[value.ordinal()];
        if (i2 == -1) {
            com.moloco.sdk.internal.error.b f2 = a.b.f5750a.f();
            StringBuilder sb = new StringBuilder("CREATE_");
            String upperCase = sVar.name().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            b.a.a(f2, sb.append(upperCase).append("_AD_FAILED_SDK_INIT_NOT_COMPLETED").toString(), null, 2, null);
            TimerEvent withTag2 = timerEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.b;
            metricsRecorder.recordTimerEvent(withTag2.withTag(cVar2.c(), "sdk_init_not_completed"));
            metricsRecorder.recordCountEvent(withTag.withTag(cVar2.c(), "sdk_init_not_completed"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Cannot retrieve AdFactory as SDK init was not called or not completed", null, false, 12, null);
            return MolocoAdError.AdCreateError.SDK_INIT_WAS_NOT_COMPLETED;
        }
        if (i2 == 1) {
            b.a.a(a.b.f5750a.f(), h, null, 2, null);
            TimerEvent withTag3 = timerEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.b;
            metricsRecorder.recordTimerEvent(withTag3.withTag(cVar3.c(), "unable_to_create_ad"));
            metricsRecorder.recordCountEvent(withTag.withTag(cVar3.c(), "unable_to_create_ad"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Could not find the adUnitId that was requested for load: " + str, null, false, 12, null);
            return MolocoAdError.AdCreateError.UNABLE_TO_CREATE_AD;
        }
        if (i2 == 2) {
            com.moloco.sdk.internal.error.b f3 = a.b.f5750a.f();
            StringBuilder sb2 = new StringBuilder("CREATE_");
            String upperCase2 = sVar.name().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            b.a.a(f3, sb2.append(upperCase2).append("_AD_FAILED_SDK_INIT_FAILED").toString(), null, 2, null);
            TimerEvent withTag4 = timerEvent.withTag(cVar.c(), AnalyticsConstants.EVENT_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.c cVar4 = com.moloco.sdk.internal.client_metrics_data.c.b;
            metricsRecorder.recordTimerEvent(withTag4.withTag(cVar4.c(), "sdk_init_failed"));
            metricsRecorder.recordCountEvent(withTag.withTag(cVar4.c(), "sdk_init_failed"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Cannot create AdFactory as SDK init was failure", null, false, 12, null);
            return MolocoAdError.AdCreateError.SDK_INIT_FAILED;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Function1<? super Continuation<? super InterfaceC3424a>, ? extends Object> function1, s sVar, MetricsRecorder metricsRecorder, Continuation<? super InterfaceC3424a> continuation) {
        c cVar;
        int i2;
        TimerEvent startTimerEvent;
        Object m11744withTimeoutOrNullKLykuaI;
        s sVar2 = sVar;
        MetricsRecorder metricsRecorder2 = metricsRecorder;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i3 = cVar.f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                cVar.f = i3 - Integer.MIN_VALUE;
                Object obj = cVar.d;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = cVar.f;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    startTimerEvent = metricsRecorder2.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.i.c());
                    Duration duration = this.c.c().get(sVar2);
                    long rawValue = duration != null ? duration.getRawValue() : this.c.d();
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "Waiting for AdFactory with timeout: " + ((Object) Duration.m11616toStringimpl(rawValue)), null, false, 12, null);
                    d dVar = new d(function1, null);
                    cVar.f5493a = sVar2;
                    cVar.b = metricsRecorder2;
                    cVar.c = startTimerEvent;
                    cVar.f = 1;
                    m11744withTimeoutOrNullKLykuaI = TimeoutKt.m11744withTimeoutOrNullKLykuaI(rawValue, dVar, cVar);
                    if (m11744withTimeoutOrNullKLykuaI == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    TimerEvent timerEvent = (TimerEvent) cVar.c;
                    metricsRecorder2 = (MetricsRecorder) cVar.b;
                    s sVar3 = (s) cVar.f5493a;
                    ResultKt.throwOnFailure(obj);
                    startTimerEvent = timerEvent;
                    sVar2 = sVar3;
                    m11744withTimeoutOrNullKLykuaI = obj;
                }
                InterfaceC3424a interfaceC3424a = (InterfaceC3424a) m11744withTimeoutOrNullKLykuaI;
                MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "AdFactory received: " + (interfaceC3424a != null), null, false, 12, null);
                metricsRecorder2.recordTimerEvent(startTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), interfaceC3424a == null ? "success" : AnalyticsConstants.EVENT_FAILURE));
                return m11744withTimeoutOrNullKLykuaI;
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.d;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = cVar.f;
        if (i2 != 0) {
        }
        InterfaceC3424a interfaceC3424a2 = (InterfaceC3424a) m11744withTimeoutOrNullKLykuaI;
        MolocoLogger.info$default(MolocoLogger.INSTANCE, i, "AdFactory received: " + (interfaceC3424a2 != null), null, false, 12, null);
        metricsRecorder2.recordTimerEvent(startTimerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.c.c.c(), sVar2.name()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), interfaceC3424a2 == null ? "success" : AnalyticsConstants.EVENT_FAILURE));
        return m11744withTimeoutOrNullKLykuaI;
    }

    public final String a() {
        String name;
        Initialization value = this.f5491a.getValue();
        if (value == null || (name = value.name()) == null) {
            return "not_invoked_or_in_progress";
        }
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase == null ? "not_invoked_or_in_progress" : lowerCase;
    }
}

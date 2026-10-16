package com.moloco.sdk.internal.publisher.nativead;

import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.C3427a;
import com.moloco.sdk.internal.publisher.C3433g;
import com.moloco.sdk.internal.publisher.nativead.c;
import com.moloco.sdk.internal.publisher.r;
import com.moloco.sdk.internal.publisher.x;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* loaded from: classes6.dex */
public final class b implements NativeAd, r {
    public static final a p = new a(null);
    public static final int q = 8;
    public static final String r = "NativeAdImpl";

    /* renamed from: a, reason: collision with root package name */
    public final String f5529a;
    public final c b;
    public final com.moloco.sdk.internal.publisher.nativead.a c;
    public final InterfaceC3442f d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a e;
    public final InterfaceC3463m f;
    public final i g;
    public final C3427a h;
    public final MetricsRecorder i;
    public NativeAd.InteractionListener j;
    public final AdFormatType k;
    public final CoroutineScope l;
    public final TimerEvent m;
    public d n;
    public Job o;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdImpl$load$1", f = "NativeAdImpl.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"adLoadListenerWithTracker"}, s = {"L$0"})
    /* renamed from: com.moloco.sdk.internal.publisher.nativead.b$b, reason: collision with other inner class name */
    public static final class C0444b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5530a;
        public int b;
        public final /* synthetic */ AdLoad.Listener d;
        public final /* synthetic */ String e;

        /* renamed from: com.moloco.sdk.internal.publisher.nativead.b$b$a */
        public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
            public a(Object obj) {
                super(0, obj, b.class, "handleGeneralAdClick", "handleGeneralAdClick()V", 0);
            }

            public final void a() {
                ((b) this.receiver).handleGeneralAdClick();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0444b(AdLoad.Listener listener, String str, Continuation<? super C0444b> continuation) {
            super(2, continuation);
            this.d = listener;
            this.e = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0444b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0444b(this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            x xVar;
            Object obj2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                b bVar = b.this;
                x a2 = bVar.a(bVar.m, this.d);
                c cVar = b.this.b;
                String str = this.e;
                TimerEvent timerEvent = b.this.m;
                this.f5530a = a2;
                this.b = 1;
                Object b = cVar.b(str, timerEvent, a2, this);
                if (b == coroutine_suspended) {
                    return coroutine_suspended;
                }
                xVar = a2;
                obj2 = b;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                xVar = (x) this.f5530a;
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).getValue();
            }
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj2);
            if (m10244exceptionOrNullimpl != null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, b.r, "Failed to load native ad.", m10244exceptionOrNullimpl, false, 8, null);
                return Unit.INSTANCE;
            }
            c.b bVar2 = (c.b) obj2;
            b bVar3 = b.this;
            bVar3.a(new d(bVar3.f5529a, bVar2.d(), bVar2.e(), bVar3.d, bVar3.e, bVar3.k, bVar3.g, bVar3.f, bVar3.i));
            bVar3.getAssets().a(bVar2.f());
            bVar3.getAssets().a(new a(bVar3));
            xVar.a(MolocoAdKt.createAdInfo(bVar3.f5529a, Boxing.boxFloat(bVar2.d().g())), bVar2.d().e().i());
            return Unit.INSTANCE;
        }
    }

    public b(String adUnitId, c nativeAdLoader, com.moloco.sdk.internal.publisher.nativead.a assets, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, InterfaceC3463m externalLinkHandler, i persistentHttpRequest, C3427a createLoadTimeoutManager, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(nativeAdLoader, "nativeAdLoader");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(createLoadTimeoutManager, "createLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5529a = adUnitId;
        this.b = nativeAdLoader;
        this.c = assets;
        this.d = appLifecycleTrackerService;
        this.e = customUserEventBuilderService;
        this.f = externalLinkHandler;
        this.g = persistentHttpRequest;
        this.h = createLoadTimeoutManager;
        this.i = metricsRecorder;
        this.k = AdFormatType.NATIVE;
        this.l = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.m = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.d.j.c());
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.l, null, 1, null);
        getAssets().a();
        setInteractionListener(null);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.h.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public NativeAd.InteractionListener getInteractionListener() {
        return this.j;
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void handleGeneralAdClick() {
        NativeAd.InteractionListener interactionListener = getInteractionListener();
        if (interactionListener != null) {
            interactionListener.onGeneralClickHandled();
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void handleImpression() {
        NativeAd.InteractionListener interactionListener = getInteractionListener();
        if (interactionListener != null) {
            interactionListener.onImpressionHandled();
        }
        d dVar = this.n;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return getAssets().c() != null;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public synchronized void load(String bidResponseJson, AdLoad.Listener listener) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        Job job = this.o;
        if (job != null && job.isActive()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, r, "load() called while another load operation is in progress. Ignoring this call.", null, false, 12, null);
        } else if (isLoaded()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, r, "load() called but ad is already loaded. Ignoring this call.", null, false, 12, null);
        } else {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.l, null, null, new C0444b(listener, bidResponseJson, null), 3, null);
            this.o = launch$default;
        }
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.h.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void setInteractionListener(NativeAd.InteractionListener interactionListener) {
        this.j = interactionListener;
    }

    public final Job c() {
        return this.o;
    }

    public final CoroutineScope e() {
        return this.l;
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public com.moloco.sdk.internal.publisher.nativead.a getAssets() {
        return this.c;
    }

    public final d a() {
        return this.n;
    }

    public final void a(d dVar) {
        this.n = dVar;
    }

    public final void a(Job job) {
        this.o = job;
    }

    public final x a(TimerEvent timerEvent, AdLoad.Listener listener) {
        return C3433g.a(listener, timerEvent, this.k, this.i);
    }
}

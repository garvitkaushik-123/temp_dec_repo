package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.internal.w;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.Locale;
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

/* loaded from: classes6.dex */
public final class z implements y {
    public static final a j = new a(null);
    public static final int k = 8;
    public static final String l = "InternalAdShowListenerImpl";

    /* renamed from: a, reason: collision with root package name */
    public final AdShowListener f5595a;
    public final InterfaceC3442f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final Function0<com.moloco.sdk.internal.ortb.model.r> d;
    public final Function0<j> e;
    public final com.moloco.sdk.internal.w f;
    public final com.moloco.sdk.internal.f g;
    public final AdFormatType h;
    public final MetricsRecorder i;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InternalAdShowListenerImpl$onAdShowSuccess$2$1", f = "InternalAdShowListener.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5596a;
        public final /* synthetic */ long c;
        public final /* synthetic */ j d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, j jVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return z.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b bVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5596a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = z.this.c;
                long j = this.c;
                a.AbstractC0571a.e eVar = a.AbstractC0571a.e.b;
                String a2 = this.d.a();
                this.f5596a = 1;
                bVar = this;
                obj = aVar.a(j, eVar, a2, bVar);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                bVar = this;
            }
            z.this.g.a((String) obj);
            return Unit.INSTANCE;
        }
    }

    public z(AdShowListener adShowListener, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, Function0<com.moloco.sdk.internal.ortb.model.r> provideSdkEvents, Function0<j> provideBUrlData, com.moloco.sdk.internal.w sdkEventUrlTracker, com.moloco.sdk.internal.f bUrlTracker, AdFormatType adType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        Intrinsics.checkNotNullParameter(provideBUrlData, "provideBUrlData");
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        Intrinsics.checkNotNullParameter(bUrlTracker, "bUrlTracker");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5595a = adShowListener;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = provideSdkEvents;
        this.e = provideBUrlData;
        this.f = sdkEventUrlTracker;
        this.g = bUrlTracker;
        this.h = adType;
        this.i = metricsRecorder;
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdClicked(MolocoAd molocoAd) {
        String a2;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, l, "onAdClicked: " + molocoAd, false, 4, null);
        this.b.b();
        com.moloco.sdk.internal.ortb.model.r invoke = this.d.invoke();
        if (invoke != null && (a2 = invoke.a()) != null) {
            w.a.a(this.f, a2, System.currentTimeMillis(), null, 4, null);
        }
        MetricsRecorder metricsRecorder = this.i;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.C.c());
        String c = com.moloco.sdk.internal.client_metrics_data.c.c.c();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(c, lowerCase));
        AdShowListener adShowListener = this.f5595a;
        if (adShowListener != null) {
            adShowListener.onAdClicked(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdHidden(MolocoAd molocoAd) {
        String c;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, l, "onAdHidden: " + molocoAd, false, 4, null);
        com.moloco.sdk.internal.ortb.model.r invoke = this.d.invoke();
        if (invoke != null && (c = invoke.c()) != null) {
            w.a.a(this.f, c, System.currentTimeMillis(), null, 4, null);
        }
        AdShowListener adShowListener = this.f5595a;
        if (adShowListener != null) {
            adShowListener.onAdHidden(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdShowSuccess(MolocoAd molocoAd) {
        z zVar;
        String m;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, l, "onAdShowSuccess: " + molocoAd, false, 4, null);
        com.moloco.sdk.internal.ortb.model.r invoke = this.d.invoke();
        if (invoke != null && (m = invoke.m()) != null) {
            w.a.a(this.f, m, System.currentTimeMillis(), null, 4, null);
        }
        j invoke2 = this.e.invoke();
        if (invoke2 != null) {
            zVar = this;
            BuildersKt__Builders_commonKt.launch$default(com.moloco.sdk.internal.scheduling.c.f5599a.b(), null, null, zVar.new b(System.currentTimeMillis(), invoke2, null), 3, null);
        } else {
            zVar = this;
        }
        MetricsRecorder metricsRecorder = zVar.i;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.A.c());
        String c = com.moloco.sdk.internal.client_metrics_data.c.c.c();
        String lowerCase = zVar.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(c, lowerCase));
        AdShowListener adShowListener = zVar.f5595a;
        if (adShowListener != null) {
            adShowListener.onAdShowSuccess(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void a(com.moloco.sdk.internal.s internalError) {
        String k2;
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, l, "onAdShowFailed: " + internalError, false, 4, null);
        com.moloco.sdk.internal.ortb.model.r invoke = this.d.invoke();
        if (invoke != null && (k2 = invoke.k()) != null) {
            this.f.a(k2, System.currentTimeMillis(), internalError);
        }
        MetricsRecorder metricsRecorder = this.i;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.B.c());
        String c = com.moloco.sdk.internal.client_metrics_data.c.c.c();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(c, lowerCase).withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), String.valueOf(internalError.c().getErrorType())));
        AdShowListener adShowListener = this.f5595a;
        if (adShowListener != null) {
            adShowListener.onAdShowFailed(internalError.c());
        }
    }
}

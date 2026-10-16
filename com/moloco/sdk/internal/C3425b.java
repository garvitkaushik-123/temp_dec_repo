package com.moloco.sdk.internal;

import android.content.Context;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.publisher.C3427a;
import com.moloco.sdk.internal.publisher.E;
import com.moloco.sdk.internal.publisher.G;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.internal.b, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3425b implements InterfaceC3424a {
    public static final int e = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Init.SDKInitResponse f5370a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a b;
    public final com.moloco.sdk.internal.services.s c;
    public final Lazy d;

    /* renamed from: com.moloco.sdk.internal.b$a */
    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a> {
        public final /* synthetic */ InterfaceC3463m b;
        public final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC3463m interfaceC3463m, Context context) {
            super(1, Intrinsics.Kotlin.class, "createVastController", "createNativeAd$createVastController(Lcom/moloco/sdk/internal/AdFactoryImpl;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ExternalLinkHandler;Landroid/content/Context;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/Ad;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/vast/render/ad/AdController;", 0);
            this.b = interfaceC3463m;
            this.c = context;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return C3425b.b(C3425b.this, this.b, this.c, p0);
        }
    }

    public C3425b(Init.SDKInitResponse initResponse, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.internal.services.s clickthroughService) {
        Intrinsics.checkNotNullParameter(initResponse, "initResponse");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        this.f5370a = initResponse;
        this.b = customUserEventBuilderService;
        this.c = clickthroughService;
        this.d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.b$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(C3425b.a(C3425b.this));
            }
        });
    }

    @Override // com.moloco.sdk.internal.InterfaceC3424a
    public Banner b(Context context, InterfaceC3442f appLifecycleTrackerService, String adUnitId, K viewVisibilityTracker, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, A viewLifecycleOwnerSingleton, i bannerSize, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return com.moloco.sdk.internal.publisher.l.a(context, appLifecycleTrackerService, this.b, adUnitId, a(), externalLinkHandler, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, this.c, metricsRecorder);
    }

    @Override // com.moloco.sdk.internal.InterfaceC3424a
    public Banner c(Context context, InterfaceC3442f appLifecycleTrackerService, String adUnitId, K viewVisibilityTracker, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, A viewLifecycleOwnerSingleton, i bannerSize, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return com.moloco.sdk.internal.publisher.l.a(context, appLifecycleTrackerService, this.b, adUnitId, a(), externalLinkHandler, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, this.c, metricsRecorder);
    }

    public final boolean a() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public static final boolean a(C3425b c3425b) {
        return c3425b.f5370a.getVerifyBannerVisible();
    }

    @Override // com.moloco.sdk.internal.InterfaceC3424a
    public Banner a(Context context, InterfaceC3442f appLifecycleTrackerService, String adUnitId, K viewVisibilityTracker, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, A viewLifecycleOwnerSingleton, i bannerSize, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return com.moloco.sdk.internal.publisher.l.a(context, appLifecycleTrackerService, this.b, adUnitId, a(), externalLinkHandler, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, this.c, metricsRecorder);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a b(C3425b c3425b, InterfaceC3463m interfaceC3463m, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar) {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.a(aVar, interfaceC3463m, context, c3425b.b, true, Boolean.FALSE, 0, 0, 0, false, false);
    }

    @Override // com.moloco.sdk.internal.InterfaceC3424a
    public NativeAd a(Context context, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.internal.services.n audioService, String adUnitId, K viewVisibilityTracker, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, A viewLifecycleOwnerSingleton, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, I timeProvider, com.moloco.sdk.internal.services.K webViewAvailabilityChecker, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(audioService, "audioService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(webViewAvailabilityChecker, "webViewAvailabilityChecker");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new com.moloco.sdk.internal.publisher.nativead.b(adUnitId, new com.moloco.sdk.internal.publisher.nativead.c(context, adUnitId, new com.moloco.sdk.internal.publisher.o(com.moloco.sdk.internal.ortb.c.a(), com.moloco.sdk.internal.publisher.q.a()), new com.moloco.sdk.internal.publisher.nativead.parser.a(), adCreateLoadTimeoutManager, metricsRecorder, timeProvider, webViewAvailabilityChecker), new com.moloco.sdk.internal.publisher.nativead.a(context, viewVisibilityTracker, viewLifecycleOwnerSingleton, watermark, new a(externalLinkHandler, context)), appLifecycleTrackerService, this.b, externalLinkHandler, persistentHttpRequest, adCreateLoadTimeoutManager, metricsRecorder);
    }

    @Override // com.moloco.sdk.internal.InterfaceC3424a
    public RewardedInterstitialAd b(Context context, InterfaceC3442f appLifecycleTrackerService, String adUnitId, K viewVisibilityTracker, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, MetricsRecorder metricsRecorder) {
        RewardedInterstitialAd a2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        a2 = G.a(context, appLifecycleTrackerService, this.b, adUnitId, externalLinkHandler, persistentHttpRequest, (r22 & 64) != 0 ? new com.moloco.sdk.internal.publisher.t(null, null, null, null, null, 31, null) : null, watermark, adCreateLoadTimeoutManager, metricsRecorder);
        return a2;
    }

    @Override // com.moloco.sdk.internal.InterfaceC3424a
    public InterstitialAd a(Context context, InterfaceC3442f appLifecycleTrackerService, String adUnitId, K viewVisibilityTracker, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, MetricsRecorder metricsRecorder) {
        InterstitialAd a2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        a2 = E.a(context, appLifecycleTrackerService, this.b, adUnitId, externalLinkHandler, persistentHttpRequest, (r22 & 64) != 0 ? new com.moloco.sdk.internal.publisher.t(null, null, null, null, null, 31, null) : null, watermark, adCreateLoadTimeoutManager, metricsRecorder);
        return a2;
    }
}

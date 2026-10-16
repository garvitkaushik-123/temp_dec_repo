package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3452b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes6.dex */
public final class l {

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function8<Context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, com.moloco.sdk.internal.ortb.model.c, InterfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z, com.moloco.sdk.internal.A, com.moloco.sdk.internal.services.s, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5515a = new a();

        public a() {
            super(8, l.class, "createXenossAggregatedBanner", "createXenossAggregatedBanner(Landroid/content/Context;Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService;Lcom/moloco/sdk/internal/ortb/model/Bid;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ExternalLinkHandler;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/Watermark;Lcom/moloco/sdk/internal/ViewLifecycleOwner;Lcom/moloco/sdk/internal/services/ClickthroughService;Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/ui/ButtonTracker;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/XenossBannerView;", 1);
        }

        @Override // kotlin.jvm.functions.Function8
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> invoke(Context p0, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a p1, com.moloco.sdk.internal.ortb.model.c p2, InterfaceC3463m p3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z p4, com.moloco.sdk.internal.A p5, com.moloco.sdk.internal.services.s p6, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h p7) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            Intrinsics.checkNotNullParameter(p3, "p3");
            Intrinsics.checkNotNullParameter(p4, "p4");
            Intrinsics.checkNotNullParameter(p5, "p5");
            Intrinsics.checkNotNullParameter(p6, "p6");
            Intrinsics.checkNotNullParameter(p7, "p7");
            return l.b(p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, c> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5516a = new b();

        public b() {
            super(1, l.class, "createXenossAggregatedAdShowListener", "createXenossAggregatedAdShowListener(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/VastAdShowListener;)Lcom/moloco/sdk/internal/publisher/BannerKt$createXenossAggregatedAdShowListener$1;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return l.b(p0);
        }
    }

    public static final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x f5517a;

        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar) {
            this.f5517a = xVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a() {
            this.f5517a.a();
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            this.f5517a.a(internalShowError);
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x
        public void a(boolean z) {
            this.f5517a.a(z);
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> b(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, com.moloco.sdk.internal.ortb.model.c cVar, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, com.moloco.sdk.internal.A a2, com.moloco.sdk.internal.services.s sVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar) {
        return new C3452b(context, aVar, null, cVar, a(cVar.e().g()), interfaceC3463m, zVar, a2, CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), sVar, hVar);
    }

    public static final Banner a(Context context, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, boolean z, InterfaceC3463m externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C3427a adCreateLoadTimeoutManager, com.moloco.sdk.internal.A viewLifecycleOwnerSingleton, com.moloco.sdk.internal.i bannerSize, com.moloco.sdk.internal.services.s clickthroughService, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerSingleton, "viewLifecycleOwnerSingleton");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new m(context, appLifecycleTrackerService, customUserEventBuilderService, adUnitId, z, externalLinkHandler, a.f5515a, b.f5516a, watermark, adCreateLoadTimeoutManager, viewLifecycleOwnerSingleton, bannerSize, clickthroughService, metricsRecorder);
    }

    public static final c b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar) {
        return new c(xVar);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h a(com.moloco.sdk.internal.ortb.model.p pVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h a2;
        return (pVar == null || (a2 = com.moloco.sdk.internal.d.a(pVar)) == null) ? com.moloco.sdk.internal.d.a() : a2;
    }
}

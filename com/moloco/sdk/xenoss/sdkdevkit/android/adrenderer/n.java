package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3453c;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.D;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n {
    public static /* synthetic */ l a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, i iVar, com.moloco.sdk.internal.ortb.model.c cVar, InterfaceC3463m interfaceC3463m, z zVar, int i, Object obj) {
        if ((i & 4) != 0) {
            iVar = null;
        }
        return a(context, aVar, iVar, cVar, interfaceC3463m, zVar);
    }

    public static final l<g, h> a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, i iVar, com.moloco.sdk.internal.ortb.model.c bid, InterfaceC3463m externalLinkHandler, z watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        return new C3453c(context, customUserEventBuilderService, iVar, bid, externalLinkHandler, watermark);
    }

    public static final l<v, u> a(Context context, String adm, com.moloco.sdk.internal.services.s clickthroughService, z watermark, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new D(context, adm, clickthroughService, watermark, a.h.f5756a.f(), a.i.f5757a.c(), metricsRecorder);
    }
}

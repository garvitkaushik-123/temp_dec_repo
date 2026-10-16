package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class A {
    public static /* synthetic */ y a(AdShowListener adShowListener, InterfaceC3442f interfaceC3442f, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, Function0 function0, Function0 function02, com.moloco.sdk.internal.w wVar, com.moloco.sdk.internal.f fVar, AdFormatType adFormatType, MetricsRecorder metricsRecorder, int i, Object obj) {
        if ((i & 32) != 0) {
            wVar = com.moloco.sdk.internal.y.b();
        }
        return a(adShowListener, interfaceC3442f, aVar, function0, function02, wVar, (i & 64) != 0 ? com.moloco.sdk.internal.h.a() : fVar, adFormatType, metricsRecorder);
    }

    public static final y a(AdShowListener adShowListener, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, Function0<com.moloco.sdk.internal.ortb.model.r> provideSdkEvents, Function0<j> provideBUrlData, com.moloco.sdk.internal.w sdkEventUrlTracker, com.moloco.sdk.internal.f bUrlTracker, AdFormatType adType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        Intrinsics.checkNotNullParameter(provideBUrlData, "provideBUrlData");
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        Intrinsics.checkNotNullParameter(bUrlTracker, "bUrlTracker");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new z(adShowListener, appLifecycleTrackerService, customUserEventBuilderService, provideSdkEvents, provideBUrlData, sdkEventUrlTracker, bUrlTracker, adType, metricsRecorder);
    }
}

package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class C<T extends AdShowListener> implements y {
    public static final int g = 8;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f5484a;
    public final T b;
    public final InterfaceC3442f c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a d;
    public final AdFormatType e;
    public final MetricsRecorder f;

    public C(T adShowListener, InterfaceC3442f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, Function0<com.moloco.sdk.internal.ortb.model.r> provideSdkEvents, Function0<j> provideBUrlData, AdFormatType adFormatType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(adShowListener, "adShowListener");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        Intrinsics.checkNotNullParameter(provideBUrlData, "provideBUrlData");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5484a = A.a(adShowListener, appLifecycleTrackerService, customUserEventBuilderService, provideSdkEvents, provideBUrlData, null, null, adFormatType, metricsRecorder, 96, null);
        this.b = adShowListener;
        this.c = appLifecycleTrackerService;
        this.d = customUserEventBuilderService;
        this.e = adFormatType;
        this.f = metricsRecorder;
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void a(com.moloco.sdk.internal.s internalError) {
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        this.f5484a.a(internalError);
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdClicked(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f5484a.onAdClicked(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdHidden(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f5484a.onAdHidden(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdShowSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f5484a.onAdShowSuccess(molocoAd);
    }

    public final T a() {
        return this.b;
    }
}

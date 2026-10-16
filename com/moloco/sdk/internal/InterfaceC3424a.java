package com.moloco.sdk.internal;

import android.content.Context;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.publisher.C3427a;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3442f;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;

/* renamed from: com.moloco.sdk.internal.a, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3424a {
    Banner a(Context context, InterfaceC3442f interfaceC3442f, String str, K k, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C3427a c3427a, A a2, i iVar, MetricsRecorder metricsRecorder);

    InterstitialAd a(Context context, InterfaceC3442f interfaceC3442f, String str, K k, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C3427a c3427a, MetricsRecorder metricsRecorder);

    NativeAd a(Context context, InterfaceC3442f interfaceC3442f, com.moloco.sdk.internal.services.n nVar, String str, K k, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, A a2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C3427a c3427a, I i, com.moloco.sdk.internal.services.K k2, MetricsRecorder metricsRecorder);

    Banner b(Context context, InterfaceC3442f interfaceC3442f, String str, K k, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C3427a c3427a, A a2, i iVar, MetricsRecorder metricsRecorder);

    RewardedInterstitialAd b(Context context, InterfaceC3442f interfaceC3442f, String str, K k, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C3427a c3427a, MetricsRecorder metricsRecorder);

    Banner c(Context context, InterfaceC3442f interfaceC3442f, String str, K k, InterfaceC3463m interfaceC3463m, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C3427a c3427a, A a2, i iVar, MetricsRecorder metricsRecorder);
}

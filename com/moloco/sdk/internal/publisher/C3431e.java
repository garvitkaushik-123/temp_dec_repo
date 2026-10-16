package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.services.K;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3449b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: com.moloco.sdk.internal.publisher.e, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3431e {
    public static final AdLoad a(CoroutineScope scope, Function1<? super Long, Duration> timeout, String adUnitId, Function1<? super com.moloco.sdk.internal.ortb.model.c, ? extends InterfaceC3449b> recreateXenossAdLoader, AdFormatType adFormatType, K webViewChecker, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(recreateXenossAdLoader, "recreateXenossAdLoader");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(webViewChecker, "webViewChecker");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new C3430d(scope, timeout, adUnitId, recreateXenossAdLoader, com.moloco.sdk.internal.ortb.c.a(), q.a(), adFormatType, webViewChecker, metricsRecorder);
    }
}

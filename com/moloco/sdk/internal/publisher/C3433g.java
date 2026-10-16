package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.internal.publisher.g, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3433g {
    public static final x a(AdLoad.Listener listener, TimerEvent acmLoadTimerEvent, AdFormatType adFormatType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(acmLoadTimerEvent, "acmLoadTimerEvent");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new C3432f(listener, com.moloco.sdk.internal.y.b(), acmLoadTimerEvent, adFormatType, metricsRecorder);
    }
}

package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.publisher.MolocoBidTokenListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes6.dex */
public interface h {
    Object a(MetricsRecorder metricsRecorder, MolocoBidTokenListener molocoBidTokenListener, Continuation<? super Unit> continuation);
}

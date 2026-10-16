package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.Init;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MediationInfo;
import kotlin.coroutines.Continuation;

/* loaded from: classes6.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5692a = a.f5693a;
    public static final long b = 3000;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5693a = new a();
        public static final long b = 3000;
    }

    Object a(String str, MediationInfo mediationInfo, MetricsRecorder metricsRecorder, Continuation<? super v<Init.SDKInitResponse, j>> continuation);
}

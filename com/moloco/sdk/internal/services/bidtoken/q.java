package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.service_locator.a;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* loaded from: classes6.dex */
public interface q {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5655a = a.f5656a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5656a = new a();

        public final q a() {
            return new r(a.h.f5756a.h(), o.f5641a.a(), com.moloco.sdk.internal.services.encryption.a.f5674a.a(), com.moloco.sdk.internal.services.bidtoken.providers.l.f5649a.a());
        }
    }

    Object a(MetricsRecorder metricsRecorder, String str, f fVar, Continuation<? super Result<String>> continuation);
}

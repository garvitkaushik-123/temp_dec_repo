package com.moloco.sdk.internal.error.crash;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d implements c {
    public static final int e = 8;

    /* renamed from: a, reason: collision with root package name */
    public final List<com.moloco.sdk.internal.error.crash.filters.a> f5396a;
    public final com.moloco.sdk.internal.error.api.a b;
    public final MetricsRecorder c;
    public final String d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends com.moloco.sdk.internal.error.crash.filters.a> exceptionFilters, com.moloco.sdk.internal.error.api.a errorReporter, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(exceptionFilters, "exceptionFilters");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5396a = exceptionFilters;
        this.b = errorReporter;
        this.c = metricsRecorder;
        this.d = "CrashHandlerService";
    }

    @Override // com.moloco.sdk.internal.error.crash.c
    public void a(Throwable crash) {
        Intrinsics.checkNotNullParameter(crash, "crash");
        if (!b(crash)) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.d, "App Crashed", null, false, 12, null);
        } else {
            this.c.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.D.c()));
            this.b.a(crash);
        }
    }

    public final boolean b(Throwable th) {
        Iterator<com.moloco.sdk.internal.error.crash.filters.a> it = this.f5396a.iterator();
        while (it.hasNext()) {
            if (it.next().a(th)) {
                return true;
            }
        }
        return false;
    }
}

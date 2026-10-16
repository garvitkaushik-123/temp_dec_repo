package com.inmobi.media;

import android.os.Build;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Xd {

    /* renamed from: a, reason: collision with root package name */
    public TelemetryConfig f2486a;

    public Xd(TelemetryConfig telemetryConfig) {
        Intrinsics.checkNotNullParameter(telemetryConfig, "telemetryConfig");
        this.f2486a = telemetryConfig;
    }

    public final void a(C2606d1 c2606d1) {
        if (Build.VERSION.SDK_INT < 30 || c2606d1 == null || c2606d1.g != 6) {
            return;
        }
        a("ANREvent", c2606d1);
    }

    public final void a(String str, T5 t5) {
        if (this.f2486a.getPriorityEventsList().contains(str) && t5 != null && Ie.a(t5)) {
            Pd.b(str, new LinkedHashMap(), Td.f2443a);
        }
    }
}

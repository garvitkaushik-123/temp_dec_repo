package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.TelemetryConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Na implements N2 {
    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof TelemetryConfig) {
            Oa.f2385a = (TelemetryConfig) config;
            TelemetryConfig telemetryConfig = Oa.f2385a;
            Oa.b.f2400a = 1 - Oa.f2385a.getPingSamplingFactor();
        }
    }
}

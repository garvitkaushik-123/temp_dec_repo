package com.inmobi.media;

import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.TelemetryConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Oa {

    /* renamed from: a, reason: collision with root package name */
    public static TelemetryConfig f2385a;
    public static final Pc b;

    static {
        Na na = new Na();
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a("telemetry", Uc.b(), na);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig");
        TelemetryConfig telemetryConfig = (TelemetryConfig) a2;
        f2385a = telemetryConfig;
        b = new Pc(1 - telemetryConfig.getPingSamplingFactor());
    }

    public static void a(String eventType, Map keyValueMap) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(keyValueMap, "keyValueMap");
        if (Intrinsics.areEqual(eventType, "PingDBMaxLimitReached")) {
            Pd pd = Pd.f2401a;
            Pd.b(eventType, keyValueMap, Td.f2443a);
        } else if (b.a()) {
            double d = 1;
            keyValueMap.put("samplingRate", Integer.valueOf((int) ((d - f2385a.getSamplingFactor()) * (d - f2385a.getPingSamplingFactor()) * 100)));
            Pd pd2 = Pd.f2401a;
            Pd.b(eventType, keyValueMap, Td.f2443a);
        }
    }
}

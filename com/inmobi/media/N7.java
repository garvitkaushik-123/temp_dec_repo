package com.inmobi.media;

import com.inmobi.commons.core.configs.TelemetryConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class N7 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final N7 f2372a = new N7();

    public N7() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LinkedHashMap linkedHashMap = O2.f2380a;
        return ((TelemetryConfig) AbstractC2808p5.a("telemetry", "null cannot be cast to non-null type com.inmobi.commons.core.configs.TelemetryConfig", null)).getLpConfig();
    }
}

package com.inmobi.media;

import com.inmobi.commons.core.configs.CrashConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class U5 {

    /* renamed from: a, reason: collision with root package name */
    public final Pc f2449a;
    public final Pc b;
    public final Pc c;
    public final Pc d;

    public U5(CrashConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f2449a = new Pc(config.getCrashConfig().getSamplingPercent());
        this.b = new Pc(config.getCatchConfig().getSamplingPercent());
        this.c = new Pc(config.getAnr().getWatchdog().getSamplingPercent());
        this.d = new Pc(config.getAnr().getAppExitReason().getSamplingPercent());
    }
}

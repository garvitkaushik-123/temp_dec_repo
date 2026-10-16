package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class Ra extends lf {
    public final AdConfig.ViewabilityConfig n;
    public final int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ra(ff visibilityChecker, AdConfig.ViewabilityConfig viewabilityConfig, byte b, InterfaceC2971z5 interfaceC2971z5) {
        super(visibilityChecker, b, interfaceC2971z5);
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        this.n = viewabilityConfig;
        this.o = 100;
    }

    @Override // com.inmobi.media.lf
    public int c() {
        AdConfig.ViewabilityConfig viewabilityConfig = this.n;
        return viewabilityConfig != null ? viewabilityConfig.getVisibilityThrottleMillis() : this.o;
    }

    @Override // com.inmobi.media.lf
    public final void d() {
        g();
    }
}

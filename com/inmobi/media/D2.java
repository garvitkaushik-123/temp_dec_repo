package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class D2 extends X4 {
    public final int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D2(AdConfig.ViewabilityConfig viewabilityConfig, InterfaceC2971z5 interfaceC2971z5) {
        super(viewabilityConfig, (byte) 1, interfaceC2971z5);
        P4 visibilityChecker = S4.k;
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        this.q = 500;
    }

    @Override // com.inmobi.media.X4, com.inmobi.media.Ra, com.inmobi.media.lf
    public final int c() {
        AdConfig.ViewabilityConfig viewabilityConfig = this.n;
        return viewabilityConfig != null ? viewabilityConfig.getCompanionVisibilityThrottleMillis() : this.q;
    }
}

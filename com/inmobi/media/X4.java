package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class X4 extends Ra {
    public final int p;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public X4(AdConfig.ViewabilityConfig viewabilityConfig, byte b, InterfaceC2971z5 interfaceC2971z5) {
        super(visibilityChecker, viewabilityConfig, b, interfaceC2971z5);
        P4 visibilityChecker = S4.k;
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        this.p = 1000;
    }

    @Override // com.inmobi.media.Ra, com.inmobi.media.lf
    public int c() {
        AdConfig.ViewabilityConfig viewabilityConfig = this.n;
        return viewabilityConfig != null ? viewabilityConfig.getWebVisibilityThrottleMillis() : this.p;
    }
}

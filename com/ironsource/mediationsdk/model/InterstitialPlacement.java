package com.ironsource.mediationsdk.model;

import com.ironsource.Tc;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message = "This class is deprecated and will be removed in version 9.0.0.")
/* loaded from: classes6.dex */
public final class InterstitialPlacement extends BasePlacement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterstitialPlacement(int i, String placementName, boolean z, Tc tc) {
        super(i, placementName, z, tc);
        Intrinsics.checkNotNullParameter(placementName, "placementName");
    }
}

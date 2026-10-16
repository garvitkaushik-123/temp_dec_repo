package com.ironsource;

import com.ironsource.mediationsdk.model.BasePlacement;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Kb extends BasePlacement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kb(int i, String placementName, boolean z, Tc tc) {
        super(i, placementName, z, tc);
        Intrinsics.checkNotNullParameter(placementName, "placementName");
    }
}

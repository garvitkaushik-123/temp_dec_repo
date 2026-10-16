package com.ironsource;

import com.ironsource.mediationsdk.model.BasePlacement;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.i3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3124i3 extends BasePlacement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3124i3(int i, String placementName, boolean z, Tc tc) {
        super(i, placementName, z, tc);
        Intrinsics.checkNotNullParameter(placementName, "placementName");
    }

    @Override // com.ironsource.mediationsdk.model.BasePlacement
    public String toString() {
        return super.toString() + ", placementId: " + getPlacementId();
    }
}

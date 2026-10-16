package com.ironsource.mediationsdk.model;

import com.ironsource.Tc;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message = "This class is deprecated and will be removed in version 9.0.0.")
/* loaded from: classes6.dex */
public final class Placement extends BasePlacement {
    private String e;
    private int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Placement(int i, String placementName, boolean z, String rewardName, int i2, Tc tc) {
        super(i, placementName, z, tc);
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(rewardName, "rewardName");
        this.f = i2;
        this.e = rewardName;
    }

    public final int getRewardAmount() {
        return this.f;
    }

    public final String getRewardName() {
        return this.e;
    }

    @Override // com.ironsource.mediationsdk.model.BasePlacement
    public String toString() {
        return super.toString() + ", reward name: " + this.e + " , amount: " + this.f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Placement(BasePlacement placement) {
        super(placement.getPlacementId(), placement.getPlacementName(), placement.isDefault(), placement.getPlacementAvailabilitySettings());
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.e = "";
    }
}

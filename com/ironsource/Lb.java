package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Lb extends C3070f0 {
    public /* synthetic */ Lb(UUID uuid, String str, Placement placement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, (i & 4) != 0 ? null : placement);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lb(UUID adId, String adUnitId, Placement placement) {
        super(IronSource.AD_UNIT.NATIVE_AD, adId, adUnitId, placement, null, null, 48, null);
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
    }

    public Lb() {
        this(C3347v7.f3910a.a(), "", null, 4, null);
    }
}

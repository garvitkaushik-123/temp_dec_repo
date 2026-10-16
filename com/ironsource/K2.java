package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class K2 extends C3070f0 {
    private final LevelPlayAdSize g;
    private final Boolean h;
    private final Long i;

    public /* synthetic */ K2(UUID uuid, String str, Placement placement, LevelPlayAdSize levelPlayAdSize, Boolean bool, Long l, C3203mf c3203mf, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uuid, str, (i & 4) != 0 ? null : placement, (i & 8) != 0 ? LevelPlayAdSize.BANNER : levelPlayAdSize, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : c3203mf, (i & 128) != 0 ? null : d);
    }

    public final LevelPlayAdSize h() {
        return this.g;
    }

    public final Boolean i() {
        return this.h;
    }

    public final Long j() {
        return this.i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K2(UUID adId, String adUnitId, Placement placement, LevelPlayAdSize adSize, Boolean bool, Long l, C3203mf c3203mf, Double d) {
        super(IronSource.AD_UNIT.BANNER, adId, adUnitId, placement, c3203mf, d);
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        this.g = adSize;
        this.h = bool;
        this.i = l;
    }

    public K2() {
        this(C3347v7.f3910a.a(), "", null, null, null, null, null, null, 252, null);
    }
}

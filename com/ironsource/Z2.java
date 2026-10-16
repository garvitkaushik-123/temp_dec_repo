package com.ironsource;

import com.ironsource.mediationsdk.ISBannerSize;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Z2 extends Yc {
    private final C3205n0 b;
    private final ISBannerSize c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z2(C3205n0 adTools, ISBannerSize size, String placement) {
        super(placement);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.b = adTools;
        this.c = size;
    }

    @Override // com.ironsource.Yc, com.ironsource.C0
    public Map<String, Object> a(A0 a0) {
        Map<String, Object> mutableMap = MapsKt.toMutableMap(super.a(a0));
        this.b.a(mutableMap, this.c);
        return mutableMap;
    }
}

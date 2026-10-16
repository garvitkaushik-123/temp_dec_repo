package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.n, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3204n extends G5 {

    /* renamed from: a, reason: collision with root package name */
    private final IronSource.AD_UNIT f3593a;
    private final UUID b;
    private final String c;

    public C3204n(IronSource.AD_UNIT adFormat, UUID adId, String adUnitId) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.f3593a = adFormat;
        this.b = adId;
        this.c = adUnitId;
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 a0) {
        return a(new C3070f0(this.f3593a, this.b, this.c, null, null, null, 56, null));
    }
}

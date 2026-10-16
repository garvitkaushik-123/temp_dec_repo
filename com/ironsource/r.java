package com.ironsource;

import com.ironsource.InterfaceC3094g7;
import com.ironsource.mediationsdk.IronSource;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r implements InterfaceC3094g7, InterfaceC3094g7.a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<IronSource.AD_UNIT, AtomicBoolean> f3661a = MapsKt.mapOf(TuplesKt.to(IronSource.AD_UNIT.REWARDED_VIDEO, new AtomicBoolean(false)), TuplesKt.to(IronSource.AD_UNIT.INTERSTITIAL, new AtomicBoolean(false)), TuplesKt.to(IronSource.AD_UNIT.BANNER, new AtomicBoolean(false)));

    @Override // com.ironsource.InterfaceC3094g7.a
    public void a(IronSource.AD_UNIT adFormat, boolean z) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        AtomicBoolean atomicBoolean = this.f3661a.get(adFormat);
        if (atomicBoolean != null) {
            atomicBoolean.set(z);
        }
    }

    @Override // com.ironsource.InterfaceC3094g7
    public boolean a(IronSource.AD_UNIT adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        AtomicBoolean atomicBoolean = this.f3661a.get(adFormat);
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }
}

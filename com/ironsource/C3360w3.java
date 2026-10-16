package com.ironsource;

import com.ironsource.F;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.w3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3360w3 extends F {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3360w3(AbstractC3340v0 adUnitData, kg waterfallInstances) {
        super(adUnitData, waterfallInstances);
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
    }

    @Override // com.ironsource.F
    public void a(AbstractC3407z instance, F.b loadSelection) {
        String str;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        if (!instance.u()) {
            IronLog.INTERNAL.verbose(instance.d().name() + " - Instance " + instance.p() + " (non-bidder) is ready to load");
            loadSelection.a().add(instance);
            return;
        }
        loadSelection.a(true);
        if (loadSelection.e()) {
            str = "Advanced Loading: Starting to load bidder " + instance.p() + ". No other instances will be loaded at the same time.";
            loadSelection.a().add(instance);
        } else {
            str = "Advanced Loading: Won't start loading bidder " + instance.p() + " as a non bidder is being loaded";
        }
        IronLog.INTERNAL.verbose(instance.d().name() + " - " + str);
    }

    @Override // com.ironsource.F
    public boolean a(F.b loadSelection) {
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        return super.a(loadSelection) || loadSelection.d();
    }
}

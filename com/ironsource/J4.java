package com.ironsource;

import com.ironsource.F;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class J4 extends F {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J4(AbstractC3340v0 adUnitData, kg waterfallInstances) {
        super(adUnitData, waterfallInstances);
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(waterfallInstances, "waterfallInstances");
    }

    @Override // com.ironsource.F
    public void a(AbstractC3407z instance, F.b loadSelection) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(loadSelection, "loadSelection");
        IronLog.INTERNAL.verbose(instance.d().name() + " - Instance " + instance.q() + " is ready to load");
        loadSelection.a().add(instance);
    }
}

package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.IronSourceNetwork;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Vb implements Ub {
    @Override // com.ironsource.Ub
    public void a(B9 adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        try {
            IronSourceNetwork.destroyAd(adInstance);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.ADAPTER_API.verbose("destroy ad with identifier: " + adInstance.e() + " failed. error: " + e.getMessage());
        }
    }
}

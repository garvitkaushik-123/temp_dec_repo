package com.ironsource;

import com.ironsource.D0;
import com.ironsource.K8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public class V0 extends C3205n0 {
    private final C3205n0 g;
    private final R0 h;
    private InterfaceC3106h2 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V0(C3205n0 adTools, AbstractC3340v0 adUnitData, D0.b level) {
        super(adTools, level);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        Intrinsics.checkNotNullParameter(level, "level");
        this.g = adTools;
        R0 a2 = C3051df.a(adUnitData, adUnitData.e().c());
        Intrinsics.checkNotNullExpressionValue(a2, "getAdUnitPerformance(\n  …auctionSavedHistoryLimit)");
        this.h = a2;
    }

    public final void a(InterfaceC3106h2 interfaceC3106h2) {
        this.i = interfaceC3106h2;
    }

    public final void c(Pd task) {
        Intrinsics.checkNotNullParameter(task, "task");
        C3068ef.a(C3068ef.f3275a, task, 0L, 2, null);
    }

    public final String e(String serverData) {
        Intrinsics.checkNotNullParameter(serverData, "serverData");
        String c = com.ironsource.mediationsdk.d.b().c(serverData);
        Intrinsics.checkNotNullExpressionValue(c, "getInstance().getDynamic…romServerData(serverData)");
        return c;
    }

    public final R0 h() {
        return this.h;
    }

    public final InterfaceC3106h2 i() {
        return this.i;
    }

    public final String j() {
        return com.ironsource.mediationsdk.p.j().i();
    }

    public final IronSourceSegment k() {
        return C3051df.a();
    }

    public final K8.a l() {
        return C3334ub.s.a().h();
    }

    public final BaseAdAdapter<?, ?> a(A instanceData) {
        Intrinsics.checkNotNullParameter(instanceData, "instanceData");
        return com.ironsource.mediationsdk.c.b().a(instanceData.u(), instanceData.h(), instanceData.i().b().b());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V0(V0 adUnitTools, D0.b level) {
        super(adUnitTools, level);
        Intrinsics.checkNotNullParameter(adUnitTools, "adUnitTools");
        Intrinsics.checkNotNullParameter(level, "level");
        this.g = adUnitTools.g;
        this.h = adUnitTools.h;
        this.i = adUnitTools.i;
    }

    public final BaseAdAdapter<?, ?> a(NetworkSettings providerSettings, IronSource.AD_UNIT adFormat, UUID adId) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adId, "adId");
        return com.ironsource.mediationsdk.c.b().a(providerSettings, adFormat, adId);
    }

    public final String a(long j, String instanceName) {
        Intrinsics.checkNotNullParameter(instanceName, "instanceName");
        String transId = IronSourceUtils.getTransId(j, instanceName);
        Intrinsics.checkNotNullExpressionValue(transId, "getTransId(timeStamp, instanceName)");
        return transId;
    }
}

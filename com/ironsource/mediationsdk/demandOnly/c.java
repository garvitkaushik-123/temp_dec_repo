package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.A5;
import com.ironsource.C3193m5;
import com.ironsource.T4;
import com.ironsource.V2;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class c implements i.a {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, d> f3512a = new ConcurrentHashMap<>();
    private T4 b;

    public c(List<NetworkSettings> list, V2 v2, String str, String str2, T4 t4) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean k = v2.k();
        this.b = t4;
        com.ironsource.mediationsdk.e eVar = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(v2.d(), sessionId));
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter a2 = com.ironsource.mediationsdk.c.b().a(networkSettings, networkSettings.getBannerSettings(), true);
                if (a2 != null) {
                    d dVar = new d(str, str2, networkSettings, v2.b(), a2, eVar);
                    dVar.a(k);
                    this.f3512a.put(dVar.l(), dVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.a
    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        d dVar = this.f3512a.get(str);
        if (dVar != null) {
            dVar.a(iSDemandOnlyBannerLayout);
            return;
        }
        this.b.a(A5.BN_DO_INSTANCE_NOT_FOUND_IN_LOAD, str);
        IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Banner");
        IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
        iSDemandOnlyBannerLayout.getListener().a(str, buildNonExistentInstanceError);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.a
    public void a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        d dVar = this.f3512a.get(str);
        if (dVar == null) {
            this.b.a(A5.BN_DO_INSTANCE_NOT_FOUND_IN_LOAD, str);
            IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Banner");
            IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
            iSDemandOnlyBannerLayout.getListener().a(str, buildNonExistentInstanceError);
            return;
        }
        dVar.a(iSDemandOnlyBannerLayout, new o.a(IronSourceAES.decode(C3193m5.b().c(), str2)));
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.a
    public synchronized void a(String str) {
        d dVar = this.f3512a.get(str);
        if (dVar == null) {
            this.b.a(A5.BN_DO_INSTANCE_NOT_FOUND_IN_DESTROY, str);
            IronLog.API.error(ErrorBuilder.buildNonExistentInstanceError("Banner").getErrorMessage());
            return;
        }
        dVar.r();
    }
}

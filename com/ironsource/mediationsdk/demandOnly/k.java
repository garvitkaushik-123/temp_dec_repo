package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.A5;
import com.ironsource.C3193m5;
import com.ironsource.C3260q4;
import com.ironsource.Gd;
import com.ironsource.T4;
import com.ironsource.W7;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.demandOnly.i;
import com.ironsource.mediationsdk.demandOnly.o;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class k implements i.c {

    /* renamed from: a, reason: collision with root package name */
    private final T4 f3522a;
    private final ConcurrentHashMap<String, l> b;
    private final W7<ISDemandOnlyRewardedVideoListener> c;

    public k(List<NetworkSettings> list, Gd gd, com.ironsource.mediationsdk.c cVar, W7<ISDemandOnlyRewardedVideoListener> w7, String str, String str2, T4 t4) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean d = gd.d();
        com.ironsource.mediationsdk.f fVar = new com.ironsource.mediationsdk.f(gd.k(), sessionId);
        this.b = new ConcurrentHashMap<>();
        this.f3522a = t4;
        this.c = w7;
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter a2 = cVar.a(networkSettings, networkSettings.getRewardedVideoSettings(), true);
                if (a2 != null) {
                    l lVar = new l(str, str2, networkSettings, this.c.a(networkSettings.getSubProviderId()), gd.i(), a2, new com.ironsource.mediationsdk.e(fVar));
                    lVar.a(d);
                    this.b.put(networkSettings.getSubProviderId(), lVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public void a(h.d dVar) {
        String e = dVar.e();
        try {
            l lVar = this.b.get(e);
            if (lVar == null) {
                this.f3522a.a(A5.RV_DO_BUSINESS_INSTANCE_NOT_FOUND_IN_LOAD, e);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(e).onRewardedVideoAdLoadFailed(e, buildNonExistentInstanceError);
                return;
            }
            if (dVar.c()) {
                lVar.b(new o.a(IronSourceAES.decode(C3193m5.b().c(), dVar.b())));
            } else {
                lVar.c();
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideo exception " + e2.getMessage());
            IronLog.API.error(buildLoadFailedError.getErrorMessage());
            this.c.a(e).onRewardedVideoAdLoadFailed(e, buildLoadFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public void b(String str) {
        try {
            l lVar = this.b.get(str);
            if (lVar != null) {
                lVar.d();
                return;
            }
            this.f3522a.a(A5.RV_DO_BUSINESS_INSTANCE_NOT_FOUND_IN_SHOW, str);
            IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
            IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
            this.c.a(str).onRewardedVideoAdShowFailed(str, buildNonExistentInstanceError);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, "showRewardedVideo exception " + e.getMessage());
            IronLog.API.error(buildShowFailedError.getErrorMessage());
            this.c.a(str).onRewardedVideoAdShowFailed(str, buildShowFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.c
    public boolean a(String str) {
        l lVar = this.b.get(str);
        if (lVar == null) {
            this.f3522a.a(A5.RV_DO_INSTANCE_NOT_FOUND_IN_AVAILABILITY_CHECK, str);
            return false;
        }
        return lVar.a();
    }

    public ConcurrentHashMap<String, l> a() {
        return this.b;
    }
}

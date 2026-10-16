package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import com.ironsource.A5;
import com.ironsource.C3193m5;
import com.ironsource.C3260q4;
import com.ironsource.C3366w9;
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
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class f implements i.b {

    /* renamed from: a, reason: collision with root package name */
    private final T4 f3516a;
    private final ConcurrentHashMap<String, g> b;
    private final W7<ISDemandOnlyInterstitialListener> c;

    public f(List<NetworkSettings> list, C3366w9 c3366w9, com.ironsource.mediationsdk.c cVar, W7<ISDemandOnlyInterstitialListener> w7, String str, String str2, T4 t4) {
        String sessionId = IronSourceUtils.getSessionId();
        boolean j = c3366w9.j();
        com.ironsource.mediationsdk.f fVar = new com.ironsource.mediationsdk.f(c3366w9.g(), sessionId);
        this.b = new ConcurrentHashMap<>();
        this.f3516a = t4;
        this.c = w7;
        for (NetworkSettings networkSettings : list) {
            if (networkSettings.isIronSource()) {
                AbstractAdapter a2 = cVar.a(networkSettings, networkSettings.getInterstitialSettings(), true);
                if (a2 != null) {
                    g gVar = new g(str, str2, networkSettings, this.c.a(networkSettings.getSubProviderId()), c3366w9.e(), a2, new com.ironsource.mediationsdk.e(fVar));
                    gVar.a(j);
                    this.b.put(networkSettings.getSubProviderId(), gVar);
                }
            } else {
                IronLog.INTERNAL.error("cannot load " + networkSettings.getProviderTypeForReflection());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(h.d dVar) {
        String e = dVar.e();
        String b = dVar.b();
        try {
            g gVar = this.b.get(e);
            if (gVar == null) {
                this.f3516a.a(A5.IS_DO_INSTANCE_NOT_FOUND_IN_LOAD, e);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(e).onInterstitialAdLoadFailed(e, buildNonExistentInstanceError);
                return;
            }
            if (TextUtils.isEmpty(b)) {
                gVar.b();
            } else {
                gVar.a(new o.a(IronSourceAES.decode(C3193m5.b().c(), b)));
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial exception " + e2.getMessage());
            IronLog.API.error(buildLoadFailedError.getErrorMessage());
            this.c.a(e).onInterstitialAdLoadFailed(e, buildLoadFailedError);
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public boolean b(String str) {
        g gVar = this.b.get(str);
        if (gVar != null) {
            return gVar.a();
        }
        this.f3516a.a(A5.IS_DO_INSTANCE_NOT_FOUND_IN_AVAILABILITY_CHECK, str);
        return false;
    }

    @Override // com.ironsource.mediationsdk.demandOnly.i.b
    public void a(String str) {
        try {
            g gVar = this.b.get(str);
            if (gVar == null) {
                this.f3516a.a(A5.IS_DO_INSTANCE_NOT_FOUND_IN_SHOW, str);
                IronSourceError buildNonExistentInstanceError = ErrorBuilder.buildNonExistentInstanceError("Interstitial");
                IronLog.API.error(buildNonExistentInstanceError.getErrorMessage());
                this.c.a(str).onInterstitialAdShowFailed(str, buildNonExistentInstanceError);
                return;
            }
            gVar.e();
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial exception " + e.getMessage());
            IronLog.API.error(buildShowFailedError.getErrorMessage());
            this.c.a(str).onInterstitialAdShowFailed(str, buildShowFailedError);
        }
    }

    public ConcurrentHashMap<String, g> a() {
        return this.b;
    }
}

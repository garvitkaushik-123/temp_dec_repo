package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.A5;
import com.ironsource.C3000b1;
import com.ironsource.C3038d2;
import com.ironsource.C3089g2;
import com.ironsource.C3126i5;
import com.ironsource.C3207n2;
import com.ironsource.C3210n5;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3413z5;
import com.ironsource.Id;
import com.ironsource.InterfaceC3001b2;
import com.ironsource.K8;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.demandOnly.a;
import com.ironsource.mediationsdk.demandOnly.j;
import com.ironsource.mediationsdk.demandOnly.m;
import com.ironsource.mediationsdk.demandOnly.n;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class l extends m implements n.b, RewardedVideoSmashListener, InterfaceC3001b2 {
    private C3126i5 n;
    private C3126i5 o;
    private ISDemandOnlyRewardedVideoListener p;
    private C3038d2 q;
    private com.ironsource.mediationsdk.e r;
    private p s;
    private final K8 t;
    private final K8.a u;

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("load timed out state=" + l.this.k());
            l.this.a(new IronSourceError(1055, "load timed out"));
        }
    }

    l(String str, String str2, NetworkSettings networkSettings, ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener, long j, AbstractAdapter abstractAdapter, com.ironsource.mediationsdk.e eVar) {
        super(new C3000b1(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.s = new p.b();
        this.t = C3334ub.U().s();
        this.u = C3334ub.O().h();
        this.p = iSDemandOnlyRewardedVideoListener;
        this.f = j;
        this.r = eVar;
        this.f3524a.initRewardedVideoForDemandOnly(str, str2, this.c, this);
    }

    private void c(o oVar) {
        this.n = new C3126i5();
        a(s());
        if (!n()) {
            a(new IronSourceError(j.a.k, "loadRewardedVideoWithAdm: must be called by bidder instance"));
            return;
        }
        try {
            d.a aVar = (d.a) oVar.a(new C3210n5());
            C3207n2 a2 = new a.C0296a(aVar.h()).a(h());
            if (a2 == null) {
                IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm invalid enriched adm");
                a(A5.RV_INSTANCE_LOAD_FAILED, (Object[][]) null);
                a(buildLoadFailedError);
                return;
            }
            String k = a2.k();
            if (k == null) {
                IronLog.INTERNAL.error("serverData is null");
                a(new IronSourceError(1062, "No available ad to load"));
                return;
            }
            b(k);
            a(aVar.a());
            a(aVar.f());
            a(A5.TROUBLESHOOT_RV_INSTANCE_LOAD_WITH_ADM, (Object[][]) null);
            this.q.a(a2.b());
            this.o = new C3126i5();
            this.f3524a.loadRewardedVideoForBidding(this.c, null, k, this);
        } catch (Exception e) {
            C3260q4.d().a(e);
            a(ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm: Exception= " + e.getMessage()));
        }
    }

    private IronSourceError q() {
        return a(m.a.SHOW_IN_PROGRESS) ? new IronSourceError(1067, "showRewardedVideo error: can't show ad while an ad is already showing") : a(m.a.LOAD_IN_PROGRESS) ? new IronSourceError(1068, "showRewardedVideo error: can't show ad while an ad is loading") : new IronSourceError(1069, "showRewardedVideo error: no available ads to show");
    }

    private com.ironsource.mediationsdk.i r() {
        String str = i() + h();
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.m);
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(true);
        iVar.c(true);
        iVar.d(str);
        iVar.c(l());
        iVar.a(this.t.a(this.m));
        C3089g2 c3089g2 = new C3089g2(h(), false);
        c3089g2.a(this.s.value());
        Map<String, Object> rewardedVideoBiddingData = this.f3524a.getRewardedVideoBiddingData(this.c, new JSONObject());
        if (rewardedVideoBiddingData != null) {
            c3089g2.b(rewardedVideoBiddingData);
        }
        iVar.a(c3089g2);
        return iVar;
    }

    private TimerTask s() {
        return new a();
    }

    private void t() {
        this.o = new C3126i5();
        this.f3524a.loadRewardedVideo(this.c, null, this);
    }

    private void u() {
        if (!this.r.a()) {
            IronLog.INTERNAL.verbose("can't load the rewarded video the auction isn't enabled");
            a(new IronSourceError(1063, "Missing server configuration"));
            return;
        }
        a(A5.TROUBLESHOOT_RV_INSTANCE_AUCTION_REQUEST, (Object[][]) null);
        com.ironsource.mediationsdk.i r = r();
        IronLog.INTERNAL.verbose("auction waterfallString = " + r.r());
        a(A5.TROUBLESHOOT_RV_INSTANCE_AUCTION_REQUEST_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, r.r()}});
        this.r.a(ContextProvider.getInstance().getApplicationContext(), r, this);
    }

    private void v() {
        this.g = null;
        this.h = null;
        this.j = null;
        this.q = new C3038d2();
    }

    private void w() {
        this.n = new C3126i5();
        a(s());
        if (n()) {
            IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideo must be called by non bidder instances");
            a(A5.RV_INSTANCE_LOAD_FAILED, (Object[][]) null);
            a(buildLoadFailedError);
        } else if (o()) {
            u();
        } else {
            t();
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public boolean a() {
        boolean z = false;
        if (!a(m.a.LOADED)) {
            a(A5.RV_INSTANCE_READY_FALSE, (Object[][]) null);
            return false;
        }
        try {
            z = this.f3524a.isRewardedVideoAvailable(this.c);
            a(z ? A5.RV_INSTANCE_READY_TRUE : A5.RV_INSTANCE_READY_FALSE, (Object[][]) null);
            return z;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("exception=" + e.getMessage());
            return z;
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public void b(o oVar) {
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(new m.a[]{aVar, aVar2}, aVar3);
        if (a2 != aVar && a2 != aVar2) {
            a(new IronSourceError(1053, a2 == aVar3 ? "load already in progress" : "cannot load because show is in progress"));
            return;
        }
        v();
        a(A5.RV_BUSINESS_INSTANCE_LOAD, (Object[][]) null);
        c(oVar);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public void d() {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", state=" + k());
        a(A5.RV_INSTANCE_SHOW, (Object[][]) null);
        if (a(m.a.LOADED, m.a.SHOW_IN_PROGRESS)) {
            this.f3524a.showRewardedVideo(this.c, this);
        } else {
            onRewardedVideoAdShowFailed(q());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(A5.RV_BUSINESS_INSTANCE_CLICKED, new Object[0][]);
        this.p.onRewardedVideoAdClicked(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        b(m.a.NOT_LOADED);
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(A5.RV_INSTANCE_CLOSED, new Object[][]{new Object[]{"sessionDepth", Integer.valueOf(this.t.a(this.m))}});
        this.u.b(this.m);
        this.p.onRewardedVideoAdClosed(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(A5.RV_BUSINESS_INSTANCE_OPENED, new Object[0][]);
        a(this.q.a(), IronSourceUtils.getCurrentMethodName());
        this.p.onRewardedVideoAdOpened(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        Map<String, Object> j = j();
        if (!TextUtils.isEmpty(com.ironsource.mediationsdk.p.j().i())) {
            j.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, com.ironsource.mediationsdk.p.j().i());
        }
        if (com.ironsource.mediationsdk.p.j().p() != null) {
            for (String str : com.ironsource.mediationsdk.p.j().p().keySet()) {
                j.put("custom_" + str, com.ironsource.mediationsdk.p.j().p().get(str));
            }
        }
        Placement a2 = com.ironsource.mediationsdk.p.j().e().c().f().a();
        if (a2 != null) {
            j.put("placement", a2.getPlacementName());
            j.put(IronSourceConstants.EVENTS_REWARD_NAME, a2.getRewardName());
            j.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(a2.getRewardAmount()));
        } else {
            IronLog.INTERNAL.error("defaultPlacement is null");
        }
        C3413z5 c3413z5 = new C3413z5(A5.RV_BUSINESS_INSTANCE_REWARDED, new JSONObject(j));
        c3413z5.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(c3413z5.d(), h()));
        Id.i().a(c3413z5);
        this.p.onRewardedVideoAdRewarded(l());
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.toString() + " instance name= " + h() + " state=" + k());
        b(m.a.NOT_LOADED);
        a(A5.RV_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        this.p.onRewardedVideoAdShowFailed(l(), ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h());
        a(A5.RV_INSTANCE_VISIBLE, new Object[0][]);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose("error=" + ironSourceError.getErrorMessage() + "instance name= " + h() + " state=" + k());
        a(A5.TROUBLESHOOT_RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(C3126i5.a(this.o))}});
        a(ironSourceError);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose("instance name= " + h() + " state=" + k());
        p();
        a(A5.TROUBLESHOOT_RV_INSTANCE_LOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(C3126i5.a(this.o))}});
        if (a(m.a.LOAD_IN_PROGRESS, m.a.LOADED)) {
            a(A5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(C3126i5.a(this.n))}});
            a(this.q.c(), IronSourceUtils.getCurrentMethodName());
            this.p.onRewardedVideoAdLoadSuccess(l());
        }
    }

    void a(IronSourceError ironSourceError) {
        IronLog.INTERNAL.verbose("instanceName = " + h() + ", error = " + ironSourceError.getErrorMessage());
        p();
        if (a(m.a.LOAD_IN_PROGRESS, m.a.NOT_LOADED)) {
            a(ironSourceError, C3126i5.a(this.n));
            a(this.q.b(), IronSourceUtils.getCurrentMethodName());
            this.p.onRewardedVideoAdLoadFailed(l(), ironSourceError);
        }
    }

    private void a(A5 a5, Object[][] objArr) {
        Map<String, Object> j = j();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    j.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(e));
            }
        }
        Id.i().a(new C3413z5(a5, new JSONObject(j)));
    }

    private void a(IronSourceError ironSourceError, long j) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(A5.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        } else {
            a(A5.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.n.b
    public void c() {
        String str;
        IronLog.INTERNAL.verbose("state=" + k());
        m.a aVar = m.a.NOT_LOADED;
        m.a aVar2 = m.a.LOADED;
        m.a aVar3 = m.a.LOAD_IN_PROGRESS;
        m.a a2 = a(new m.a[]{aVar, aVar2}, aVar3);
        if (a2 != aVar && a2 != aVar2) {
            if (a2 == aVar3) {
                str = "load already in progress";
            } else {
                str = "cannot load because show is in progress";
            }
            this.p.onRewardedVideoAdLoadFailed(l(), new IronSourceError(1053, str));
            return;
        }
        v();
        a(A5.RV_BUSINESS_INSTANCE_LOAD, (Object[][]) null);
        w();
    }

    private void a(List<String> list, String str) {
        a(list, h(), i(), this.j, str);
    }

    @Override // com.ironsource.InterfaceC3001b2
    public void a(d.a aVar, int i, long j, int i2, String str) {
        String str2;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        this.g = aVar.a();
        this.h = aVar.f();
        this.s = aVar.a(l());
        a.C0296a c0296a = new a.C0296a(aVar.h());
        if (c0296a.isEmpty()) {
            str2 = "";
        } else {
            C3207n2 c3207n2 = c0296a.get(0);
            this.q.a(c3207n2.b());
            this.q.c(c3207n2.h());
            this.q.b(c3207n2.g());
            str2 = c3207n2.k();
            b(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            a(A5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str}});
        }
        a(A5.TROUBLESHOOT_RV_INSTANCE_AUCTION_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        a(A5.TROUBLESHOOT_RV_INSTANCE_AUCTION_RESPONSE_WATERFALL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, c0296a.b()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (c0296a.isEmpty()) {
                IronSourceError ironSourceError = new IronSourceError(1058, "There is no available ad to load");
                ironLog.error("rewardedVideo - empty waterfall");
                a(ironSourceError);
                return;
            }
            c(str2);
        }
    }

    private void c(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (a(m.a.LOAD_IN_PROGRESS)) {
            if (str == null) {
                ironLog.verbose("serverData is null");
                a(new IronSourceError(1062, "No available ad to load"));
            } else {
                a(A5.TROUBLESHOOT_RV_INSTANCE_LOAD_WITH_ADM, (Object[][]) null);
                this.f3524a.loadRewardedVideoForBidding(this.c, null, str, this);
            }
        }
    }

    @Override // com.ironsource.S1
    public void a(List<C3207n2> list, String str, C3207n2 c3207n2, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        IronLog.INTERNAL.error("Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    @Override // com.ironsource.S1
    public void a(int i, String str, int i2, String str2, long j) {
        IronLog.INTERNAL.verbose("Auction failed. error " + i + " - " + str);
        this.g = null;
        this.h = null;
        a(A5.TROUBLESHOOT_RV_INSTANCE_AUCTION_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}, new Object[]{IronSourceConstants.EVENTS_EXT1, k()}});
        if (a(m.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(j.a.j, "No available ad to load"));
        }
    }
}

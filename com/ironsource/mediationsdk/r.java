package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.A3;
import com.ironsource.A5;
import com.ironsource.C3000b1;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3413z5;
import com.ironsource.Id;
import com.ironsource.InterfaceC3131ia;
import com.ironsource.K8;
import com.ironsource.V9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class r extends y implements RewardedVideoSmashListener, A3 {
    private b h;
    private InterfaceC3131ia i;
    private Timer j;
    private int k;
    private String l;
    private String m;
    private Placement n;
    private long o;
    private String p;
    private JSONObject q;
    private int r;
    private String s;
    private final Object t;
    private final Object u;
    private long v;
    private final K8.a w;

    protected enum b {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
    }

    public r(String str, String str2, NetworkSettings networkSettings, InterfaceC3131ia interfaceC3131ia, int i, AbstractAdapter abstractAdapter, int i2) {
        super(new C3000b1(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.t = new Object();
        this.u = new Object();
        this.w = C3334ub.O().h();
        this.l = str;
        this.m = str2;
        this.i = interfaceC3131ia;
        this.j = null;
        this.k = i;
        this.f = i2;
        this.h = b.NO_INIT;
        this.v = 0L;
        if (r()) {
            t();
        }
    }

    private void C() {
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (TextUtils.isEmpty(pluginType)) {
                return;
            }
            this.f3591a.setPluginData(pluginType);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            a("setCustomParams() " + th.getMessage());
        }
    }

    private void D() {
        synchronized (this.u) {
            Timer timer = new Timer();
            this.j = timer;
            timer.schedule(new a(), this.k * 1000);
        }
    }

    private void E() {
        synchronized (this.u) {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
        }
    }

    private boolean c(A5 a5) {
        return a5 == A5.RV_BUSINESS_INSTANCE_LOAD || a5 == A5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS || a5 == A5.RV_INSTANCE_LOAD_FAILED || a5 == A5.RV_INSTANCE_LOAD_FAILED_REASON || a5 == A5.RV_INSTANCE_LOAD_NO_FILL || a5 == A5.RV_BUSINESS_INSTANCE_OPENED || a5 == A5.RV_INSTANCE_CLOSED || a5 == A5.RV_INSTANCE_SHOW || a5 == A5.RV_INSTANCE_SHOW_FAILED || a5 == A5.RV_BUSINESS_INSTANCE_CLICKED || a5 == A5.RV_BUSINESS_INSTANCE_REWARDED;
    }

    private void t() {
        a("isBidder = " + p() + ", shouldEarlyInit = " + s());
        a(b.INIT_IN_PROGRESS);
        C();
        try {
            this.f3591a.initRewardedVideoWithCallback(this.l, this.m, this.d, this);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            b("initForBidding exception: " + th.getLocalizedMessage());
            onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long v() {
        return new Date().getTime() - this.o;
    }

    public boolean A() {
        if (this.h != b.LOADED) {
            return false;
        }
        try {
            return this.f3591a.isRewardedVideoAvailable(this.d);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            b("isReadyToShow exception: " + th.getLocalizedMessage());
            a(A5.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 5002}, new Object[]{"reason", th.getLocalizedMessage()}});
            return false;
        }
    }

    public void B() {
        a(A5.RV_CAP_SESSION);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:55:0x010e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(java.lang.String r12, org.json.JSONObject r13) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.r.a(java.lang.String, org.json.JSONObject):void");
    }

    public void b(boolean z) {
        b(A5.RV_INSTANCE_SHOW_CHANCE, new Object[][]{new Object[]{"status", z ? "true" : "false"}});
    }

    @Override // com.ironsource.A3
    public void collectBiddingData(AdData adData, BiddingDataCallback biddingDataCallback) {
        a(A5.RV_INSTANCE_COLLECT_TOKEN);
        try {
            this.f3591a.collectRewardedVideoBiddingData(this.d, adData != null ? V9.a(adData.getAdUnitData()) : null, biddingDataCallback);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            b("collectBiddingData exception: " + th.getLocalizedMessage());
            IronLog.INTERNAL.error(th.toString());
        }
    }

    @Override // com.ironsource.mediationsdk.y
    public IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.REWARDED_VIDEO;
    }

    @Override // com.ironsource.mediationsdk.y
    public String k() {
        return "LWSProgRvSmash";
    }

    @Override // com.ironsource.mediationsdk.y
    public int l() {
        return 2;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        a("onRewardedVideoAdClicked");
        this.i.b(this, this.n);
        b(A5.RV_BUSINESS_INSTANCE_CLICKED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        a("onRewardedVideoAdClosed");
        synchronized (this.t) {
            if (this.h != b.SHOW_IN_PROGRESS) {
                b(A5.RV_INSTANCE_CLOSED);
                a(A5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_adClosed)}, new Object[]{"reason", "adClosed: " + this.h}});
            } else {
                a(b.ENDED);
                this.v = new Date().getTime();
                this.i.c(this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
        a("onRewardedVideoAdEnded");
        this.i.e(this);
        b(A5.RV_INSTANCE_ENDED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        a("onRewardedVideoAdOpened");
        this.i.f(this);
        b(A5.RV_BUSINESS_INSTANCE_OPENED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        a("onRewardedVideoAdRewarded");
        long time = new Date().getTime();
        this.i.a(this, this.n);
        Map<String, Object> m = m();
        Placement placement = this.n;
        if (placement != null) {
            m.put("placement", placement.getPlacementName());
            m.put(IronSourceConstants.EVENTS_REWARD_NAME, this.n.getRewardName());
            m.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.n.getRewardAmount()));
        }
        if (!TextUtils.isEmpty(p.j().i())) {
            m.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, p.j().i());
        }
        if (p.j().p() != null) {
            for (String str : p.j().p().keySet()) {
                m.put("custom_" + str, p.j().p().get(str));
            }
        }
        if (!TextUtils.isEmpty(this.p)) {
            m.put("auctionId", this.p);
        }
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.length() > 0) {
            m.put("genericParams", this.q);
        }
        A5 a5 = A5.RV_BUSINESS_INSTANCE_REWARDED;
        if (c(a5)) {
            Id.i().a(m, this.r, this.s);
        }
        m.put("sessionDepth", Integer.valueOf(this.f));
        C3413z5 c3413z5 = new C3413z5(a5, new JSONObject(m));
        c3413z5.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(c3413z5.d(), c()));
        long j = this.v;
        if (j != 0) {
            long j2 = time - j;
            a("onRewardedVideoAdRewarded timeAfterClosed=" + j2);
            c3413z5.a("duration", Long.valueOf(j2));
        }
        Id.i().a(c3413z5);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        b(A5.RV_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}});
        synchronized (this.t) {
            if (this.h != b.SHOW_IN_PROGRESS) {
                a(A5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showFailed)}, new Object[]{"reason", "showFailed: " + this.h}});
            } else {
                a(b.ENDED);
                this.i.a(ironSourceError, this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
        a("onRewardedVideoAdStarted");
        this.i.b(this);
        b(A5.RV_INSTANCE_STARTED);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        a("onRewardedVideoAdVisible");
        b(A5.RV_INSTANCE_VISIBLE);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z) {
        boolean z2;
        a("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.h.name());
        synchronized (this.t) {
            if (this.h == b.LOAD_IN_PROGRESS) {
                a(z ? b.LOADED : b.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                a(A5.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.h.name()}});
                return;
            } else {
                a(A5.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK)}, new Object[]{"duration", Long.valueOf(v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.h.name()}});
                return;
            }
        }
        E();
        a(z ? A5.RV_BUSINESS_INSTANCE_LOAD_SUCCESS : A5.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(v())}});
        if (z) {
            this.i.a(this);
        } else {
            this.i.d(this);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        a("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage());
        E();
        a(A5.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1033}, new Object[]{"duration", Long.valueOf(v())}});
        a(A5.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(v())}});
        synchronized (this.t) {
            if (this.h != b.INIT_IN_PROGRESS) {
                a(A5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{"reason", "initFailed: " + this.h}});
            } else {
                a(b.NO_INIT);
                this.i.d(this);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
        a("onRewardedVideoInitSuccess");
        synchronized (this.t) {
            if (this.h != b.INIT_IN_PROGRESS) {
                a(A5.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initSuccess)}, new Object[]{"reason", "initSuccess: " + this.h}});
            } else {
                a(b.NOT_LOADED);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(A5.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(v())}});
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.g = Long.valueOf(System.currentTimeMillis());
        }
        a(A5.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(v())}});
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
    }

    public String u() {
        return this.p;
    }

    public LoadWhileShowSupportState w() {
        try {
            return this.f3591a.getLoadWhileShowSupportState(this.d);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            b("Exception while calling adapter.getLoadWhileShowSupportState() - " + th.getLocalizedMessage());
            return LoadWhileShowSupportState.NONE;
        }
    }

    public Placement x() {
        return this.n;
    }

    public boolean y() {
        return this.h == b.LOADED;
    }

    public boolean z() {
        b bVar = this.h;
        return bVar == b.INIT_IN_PROGRESS || bVar == b.LOAD_IN_PROGRESS;
    }

    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i;
            int i2;
            boolean z;
            r rVar = r.this;
            b bVar = rVar.h;
            b bVar2 = b.LOAD_IN_PROGRESS;
            String str = "Rewarded Video - load instance time out";
            if (bVar == bVar2 || bVar == b.INIT_IN_PROGRESS) {
                if (bVar == bVar2) {
                    i = 1025;
                } else {
                    i = 1032;
                    str = "Rewarded Video - init instance time out";
                }
                rVar.a(b.NOT_LOADED);
                i2 = i;
                z = true;
            } else {
                i2 = 510;
                z = false;
            }
            r.this.a(str);
            if (z) {
                r.this.a(A5.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"duration", Long.valueOf(r.this.v())}});
                r.this.a(A5.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(r.this.v())}});
                r rVar2 = r.this;
                rVar2.i.d(rVar2);
                return;
            }
            r.this.a(A5.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{"duration", Long.valueOf(r.this.v())}, new Object[]{IronSourceConstants.EVENTS_EXT1, r.this.h.name()}});
        }
    }

    private void b(A5 a5) {
        b(a5, null);
    }

    public void b(A5 a5, Object[][] objArr) {
        a(a5, objArr, true);
    }

    public r(r rVar, InterfaceC3131ia interfaceC3131ia, AbstractAdapter abstractAdapter, int i, String str, JSONObject jSONObject, int i2, String str2) {
        this(rVar.l, rVar.m, rVar.b.h(), interfaceC3131ia, rVar.k, abstractAdapter, i);
        this.p = str;
        this.q = jSONObject;
        this.r = i2;
        this.s = str2;
    }

    public void a(Placement placement) {
        E();
        a("showVideo()");
        this.n = placement;
        a(b.SHOW_IN_PROGRESS);
        b(A5.RV_INSTANCE_SHOW);
        try {
            this.f3591a.showRewardedVideo(this.d, this);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            b("showVideo exception: " + th.getLocalizedMessage());
            onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        a("current state=" + this.h + ", new state=" + bVar);
        synchronized (this.t) {
            this.h = bVar;
        }
    }

    public void a(A5 a5) {
        a(a5, null, false);
    }

    public void a(A5 a5, Object[][] objArr) {
        a(a5, objArr, false);
    }

    private void a(A5 a5, Object[][] objArr, boolean z) {
        Placement placement;
        Map<String, Object> m = m();
        if (!TextUtils.isEmpty(this.p)) {
            m.put("auctionId", this.p);
        }
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.length() > 0) {
            m.put("genericParams", this.q);
        }
        if (z && (placement = this.n) != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            m.put("placement", this.n.getPlacementName());
        }
        if (c(a5)) {
            Id.i().a(m, this.r, this.s);
        }
        m.put("sessionDepth", Integer.valueOf(this.f));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    m.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, c() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        Id.i().a(new C3413z5(a5, new JSONObject(m)));
        if (a5 == A5.RV_INSTANCE_CLOSED) {
            this.w.b(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
    }
}

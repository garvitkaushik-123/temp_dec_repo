package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.A5;
import com.ironsource.B3;
import com.ironsource.C3;
import com.ironsource.C3147ja;
import com.ironsource.C3184ld;
import com.ironsource.C3207n2;
import com.ironsource.C3241p2;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3413z5;
import com.ironsource.C3422ze;
import com.ironsource.CallableC3394y3;
import com.ironsource.Gd;
import com.ironsource.Id;
import com.ironsource.InterfaceC3131ia;
import com.ironsource.InterfaceC3183lc;
import com.ironsource.InterfaceC3221o;
import com.ironsource.Kd;
import com.ironsource.L7;
import com.ironsource.Ld;
import com.ironsource.N7;
import com.ironsource.O5;
import com.ironsource.S1;
import com.ironsource.Y9;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class q extends m implements InterfaceC3131ia, Ld, S1, N7, InterfaceC3183lc, InterfaceC3221o {
    private e A;
    private long B;
    private Boolean C;
    private final Object D;
    private O5 E;
    private final long F;
    private final L7.a G;
    private final L7 H;
    private C3147ja e;
    private ConcurrentHashMap<String, C3207n2> f;
    private ConcurrentHashMap<String, h.a> g;
    private C3207n2 h;
    private h i;
    private com.ironsource.mediationsdk.e j;
    private JSONObject k;
    private Kd l;
    private boolean m;
    private boolean n;
    private long o;
    private String p;
    private int q;
    private NetworkStateReceiver r;
    private boolean s;
    private final ConcurrentHashMap<String, r> t;
    private C3422ze u;
    private int v;
    private String w;
    private int x;
    private boolean y;
    private boolean z;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f3560a;
        final /* synthetic */ Gd b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        a(NetworkSettings networkSettings, Gd gd, String str, String str2) {
            this.f3560a = networkSettings;
            this.b = gd;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.a(this.f3560a, this.b, this.c, this.d);
        }
    }

    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            q.this.j();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.d("makeAuction()");
            q.this.o = new Date().getTime();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            q.this.b(hashMap, arrayList, sb, arrayList2);
            q.this.a(hashMap, arrayList, sb, arrayList2);
        }
    }

    class d implements B3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f3563a;
        final /* synthetic */ StringBuilder b;
        final /* synthetic */ List c;

        d(Map map, StringBuilder sb, List list) {
            this.f3563a = map;
            this.b = sb;
            this.c = list;
        }

        @Override // com.ironsource.B3.b
        public void a(List<C3> list, long j, List<String> list2) {
            q.this.c(A5.RV_COLLECT_TOKENS_COMPLETED, Y9.a(new Object[][]{new Object[]{"duration", Long.valueOf(j)}}));
            for (C3 c3 : list) {
                r rVar = (r) q.this.t.get(c3.c());
                if (c3.a() != null) {
                    this.f3563a.put(c3.c(), c3.a());
                    this.b.append(c3.d()).append(c3.c()).append(",");
                    if (rVar != null) {
                        rVar.a(A5.RV_INSTANCE_COLLECT_TOKEN_SUCCESS, new Object[][]{new Object[]{"duration", Long.valueOf(c3.e())}});
                    }
                } else if (rVar != null) {
                    rVar.a(A5.RV_INSTANCE_COLLECT_TOKEN_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(c3.e())}, new Object[]{"reason", c3.b()}});
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                r rVar2 = (r) q.this.t.get(it.next());
                if (rVar2 != null) {
                    rVar2.a(A5.RV_INSTANCE_COLLECT_TOKEN_TIMED_OUT, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
                }
            }
            q.this.a((Map<String, Object>) this.f3563a, (List<String>) this.c, this.b.toString());
        }

        @Override // com.ironsource.B3.b
        public void onFailure(String str) {
            q.this.c(A5.RV_COLLECT_TOKENS_FAILED, Y9.a(new Object[][]{new Object[]{"reason", str}}));
            q.this.a((Map<String, Object>) this.f3563a, (List<String>) this.c, this.b.toString());
        }
    }

    private enum e {
        RV_STATE_INITIATING,
        RV_STATE_AUCTION_IN_PROGRESS,
        RV_STATE_NOT_LOADED,
        RV_STATE_LOADING_SMASHES,
        RV_STATE_READY_TO_SHOW
    }

    public q(List<NetworkSettings> list, Gd gd, String str, String str2, HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        super(hashSet, ironSourceSegment);
        this.p = "";
        this.s = false;
        this.v = 1;
        this.D = new Object();
        this.G = C3334ub.O().x();
        this.H = C3334ub.U().w();
        long time = new Date().getTime();
        c(A5.RV_MANAGER_INIT_STARTED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.LWS_RV_MANAGER_NAME}}));
        a(e.RV_STATE_INITIATING);
        this.C = null;
        this.x = gd.g();
        this.y = gd.j();
        this.w = "";
        this.k = null;
        C3241p2 k = gd.k();
        this.z = false;
        this.e = new C3147ja(gd.k().f(), gd.k().i());
        this.f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
        this.B = new Date().getTime();
        this.m = k.g() > 0;
        this.n = k.n();
        if (this.m) {
            this.j = new com.ironsource.mediationsdk.e(IronSource.AD_UNIT.REWARDED_VIDEO, k, this);
        }
        this.l = new Kd(k, this);
        ConcurrentHashMap<String, r> concurrentHashMap = new ConcurrentHashMap<>();
        this.t = concurrentHashMap;
        a(list, gd, str, str2);
        this.i = new h(list, k.c());
        C3422ze c3422ze = new C3422ze();
        this.u = c3422ze;
        c3422ze.a(new ArrayList(concurrentHashMap.values()));
        this.E = new O5(gd.c(), this);
        this.F = gd.l();
        c(A5.RV_MANAGER_INIT_ENDED, Y9.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}}));
        a(k.k());
    }

    private void a(List<NetworkSettings> list, Gd gd, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<NetworkSettings> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(it.next(), gd, str, str2));
        }
        IronSourceThreadManager.INSTANCE.executeTasks(gd.f(), gd.o(), arrayList);
    }

    private List<C3207n2> g() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (r rVar : this.t.values()) {
            if (!rVar.p() && !this.u.b(rVar) && this.e.b(rVar)) {
                copyOnWriteArrayList.add(new C3207n2(rVar.c()));
            }
        }
        return copyOnWriteArrayList;
    }

    private void h() {
        a(e.RV_STATE_NOT_LOADED);
        if (!this.z) {
            b(false);
        }
        this.l.a();
    }

    private void i() {
        if (this.e.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(A5.TROUBLESHOOTING_RV_LOAD_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{"reason", "waterfall is empty"}}));
            h();
            return;
        }
        a(e.RV_STATE_LOADING_SMASHES);
        int i = 0;
        for (int i2 = 0; i2 < this.e.c().size() && i < this.x; i2++) {
            r rVar = this.e.c().get(i2);
            if (rVar.h()) {
                if (this.y && rVar.p()) {
                    if (i != 0) {
                        String str = "Advanced Loading: Won't start loading bidder " + rVar.c() + " as a non bidder is being loaded";
                        d(str);
                        IronSourceUtils.sendAutomationLog(str);
                        return;
                    } else {
                        String str2 = "Advanced Loading: Starting to load bidder " + rVar.c() + ". No other instances will be loaded at the same time.";
                        d(str2);
                        IronSourceUtils.sendAutomationLog(str2);
                        g(rVar);
                        return;
                    }
                }
                g(rVar);
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this.D) {
            e eVar = this.A;
            e eVar2 = e.RV_STATE_AUCTION_IN_PROGRESS;
            if (eVar != eVar2) {
                a(eVar2);
                AsyncTask.execute(new c());
            }
        }
    }

    private void k() {
        a(g(), "fallback_" + System.currentTimeMillis(), this.k);
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void b(r rVar) {
        a(rVar, "onRewardedVideoAdStarted");
        C3184ld.a().c();
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void c(r rVar) {
        a(rVar, "onRewardedVideoAdClosed, mediation state: " + this.A.name());
        C3184ld.a().b(this.e.a(rVar.u()));
        this.z = false;
        boolean z = this.A == e.RV_STATE_READY_TO_SHOW;
        StringBuilder sb = new StringBuilder();
        if (z) {
            Iterator<r> it = this.e.c().iterator();
            while (it.hasNext()) {
                r next = it.next();
                if (next.y()) {
                    sb.append(next.c() + ";");
                }
            }
        }
        rVar.b(A5.RV_INSTANCE_CLOSED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, "otherRVAvailable = " + (sb.length() > 0 ? "true|" + ((Object) sb) : "false")}});
        if (rVar.equals(this.e.f())) {
            this.e.a((r) null);
            if (this.A != e.RV_STATE_READY_TO_SHOW) {
                b(false);
            }
        }
    }

    @Override // com.ironsource.N7
    public boolean d() {
        if ((!this.s || IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) && this.A == e.RV_STATE_READY_TO_SHOW && !this.z) {
            Iterator<r> it = this.e.c().iterator();
            while (it.hasNext()) {
                if (it.next().A()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void e(r rVar) {
        a(rVar, "onRewardedVideoAdEnded");
        C3184ld.a().b();
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void f(r rVar) {
        this.e.a(rVar);
        this.v++;
        a(rVar, "onRewardedVideoAdOpened");
        if (this.m) {
            C3207n2 c3207n2 = this.f.get(rVar.c());
            if (c3207n2 != null) {
                C3147ja c3147ja = this.e;
                c3147ja.a(c3147ja.d(), c3207n2.a(this.w), c3207n2.d());
                this.j.a(c3207n2, rVar.g(), this.h, this.w);
                this.g.put(rVar.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
                a(c3207n2, this.w);
            } else {
                String c2 = rVar.c();
                c("onRewardedVideoAdOpened showing instance " + c2 + " missing from waterfall");
                a(A5.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1011}, new Object[]{"reason", "Showing missing " + this.A}, new Object[]{IronSourceConstants.EVENTS_EXT1, c2}}));
            }
        }
        C3184ld.a().c(this.e.a(rVar.u()));
        b(false);
        this.l.c();
    }

    @Override // com.ironsource.N7
    public void shouldTrackNetworkState(Context context, boolean z) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager Should Track Network State: " + z, 0);
        try {
            this.s = z;
            if (z) {
                if (this.r == null) {
                    this.r = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.r, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.r != null) {
                context.getApplicationContext().unregisterReceiver(this.r);
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error("Got an error from receiver with message: " + e2.getMessage());
        }
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void b(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdClicked");
        C3184ld.a().a(placement, this.e.a(rVar.u()));
    }

    @Override // com.ironsource.Ld
    public void b() {
        d("onLoadTriggered: RV load was triggered in " + this.A + " state");
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC3394y3> list2) {
        for (r rVar : this.t.values()) {
            if (!this.u.b(rVar) && this.e.b(rVar)) {
                if (rVar.p()) {
                    list2.add(new CallableC3394y3(rVar.g(), rVar.c(), null, rVar, null, null));
                } else {
                    list.add(rVar.c());
                    sb.append(rVar.g() + rVar.c() + ",");
                }
            }
        }
    }

    private void g(r rVar) {
        String k = this.f.get(rVar.c()).k();
        JSONObject a2 = this.f.get(rVar.c()).a();
        rVar.c(k);
        rVar.a(k, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkSettings networkSettings, Gd gd, String str, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(String.format("Start initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
        AbstractAdapter a2 = com.ironsource.mediationsdk.c.b().a(networkSettings, networkSettings.getRewardedVideoSettings(), false);
        if (a2 != null) {
            r rVar = new r(str, str2, networkSettings, this, gd.h(), a2, this.v);
            this.t.put(rVar.c(), rVar);
        }
        ironLog.verbose(String.format("Done initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName()));
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void d(r rVar) {
        String str;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        synchronized (this.D) {
            a(rVar, "onLoadError mState=" + this.A);
            if (rVar.u() == this.e.d() && this.A != e.RV_STATE_AUCTION_IN_PROGRESS) {
                this.g.put(rVar.c(), h.a.ISAuctionPerformanceFailedToLoad);
                e eVar = this.A;
                if (eVar == e.RV_STATE_LOADING_SMASHES || eVar == e.RV_STATE_READY_TO_SHOW) {
                    Iterator<r> it = this.e.c().iterator();
                    boolean z = false;
                    boolean z2 = false;
                    while (it.hasNext()) {
                        r next = it.next();
                        if (next.h()) {
                            if (this.y && next.p()) {
                                if (!z && !z2) {
                                    String str2 = "Advanced Loading: Starting to load bidder " + next.c() + ". No other instances will be loaded at the same time.";
                                    d(str2);
                                    IronSourceUtils.sendAutomationLog(str2);
                                }
                                if (z) {
                                    str = "a non bidder is being loaded";
                                } else {
                                    str = "a non bidder was already loaded successfully";
                                }
                                String str3 = "Advanced Loading: Won't start loading bidder " + next.c() + " as " + str;
                                d(str3);
                                IronSourceUtils.sendAutomationLog(str3);
                            }
                            if (this.f.get(next.c()) != null) {
                                copyOnWriteArrayList.add(next);
                                if (!this.y || !rVar.p() || next.p() || copyOnWriteArrayList.size() >= this.x) {
                                    break;
                                } else {
                                    z = true;
                                }
                            } else {
                                continue;
                            }
                        } else if (next.z()) {
                            z = true;
                        } else if (next.A()) {
                            z2 = true;
                        }
                    }
                    if (copyOnWriteArrayList.size() == 0 && !z2 && !z) {
                        d("onLoadError(): No other available smashes");
                        if (!this.z) {
                            b(false);
                        }
                        a(A5.TROUBLESHOOTING_RV_LOAD_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 509}, new Object[]{"reason", "Mediation No fill"}}));
                        a(e.RV_STATE_NOT_LOADED);
                        this.l.a();
                    }
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (it2.hasNext()) {
                        g((r) it2.next());
                    }
                    return;
                }
                return;
            }
            d("onLoadError was invoked with auctionId:" + rVar.u() + " and the current id is " + this.e.d());
            rVar.a(A5.RV_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 4}, new Object[]{"reason", "loadError wrong auction ID " + this.A}});
        }
    }

    private void b(boolean z) {
        a(z, (Map<String, Object>) null);
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 0);
    }

    private void b(A5 a5) {
        a(a5, (Map<String, Object>) null, false, false);
    }

    private void b(A5 a5, Map<String, Object> map) {
        a(a5, map, true, true);
    }

    private void c(r rVar, Placement placement) {
        d("showVideo()");
        this.u.a(rVar);
        if (this.u.b(rVar)) {
            rVar.B();
            IronSourceUtils.sendAutomationLog(rVar.c() + " rewarded video is now session capped");
        }
        L7.a aVar = this.G;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String placementName = placement.getPlacementName();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        aVar.a(applicationContext, placementName, ad_unit);
        if (this.H.c(ContextProvider.getInstance().getApplicationContext(), placement, ad_unit)) {
            a(A5.RV_CAP_PLACEMENT);
        }
        this.E.a();
        rVar.a(placement);
    }

    @Override // com.ironsource.N7
    public void a(Activity activity, Placement placement) {
        synchronized (this.D) {
            if (placement == null) {
                a("showRewardedVideo error: empty default placement");
                IronSourceError ironSourceError = new IronSourceError(1021, "showRewardedVideo error: empty default placement");
                C3184ld a2 = C3184ld.a();
                C3147ja c3147ja = this.e;
                a2.a(ironSourceError, c3147ja.a(c3147ja.d()));
                a(A5.RV_CALLBACK_SHOW_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1021}, new Object[]{"reason", "showRewardedVideo error: empty default placement"}}), false, true);
                return;
            }
            this.w = placement.getPlacementName();
            b("showRewardedVideo(" + placement + ")");
            r rVar = null;
            b(A5.RV_API_SHOW_CALLED, activity != null ? Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, IronSourceConstants.EVENTS_INIT_CONTEXT_FLOW}}) : null);
            if (this.z) {
                a("showRewardedVideo error: can't show ad while an ad is already showing");
                IronSourceError ironSourceError2 = new IronSourceError(1022, "showRewardedVideo error: can't show ad while an ad is already showing");
                C3184ld a3 = C3184ld.a();
                C3147ja c3147ja2 = this.e;
                a3.a(ironSourceError2, c3147ja2.a(c3147ja2.d()));
                b(A5.RV_CALLBACK_SHOW_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1022}, new Object[]{"reason", "showRewardedVideo error: can't show ad while an ad is already showing"}}));
                return;
            }
            if (this.A != e.RV_STATE_READY_TO_SHOW) {
                a("showRewardedVideo error: show called while no ads are available");
                IronSourceError ironSourceError3 = new IronSourceError(1023, "showRewardedVideo error: show called while no ads are available");
                C3184ld a4 = C3184ld.a();
                C3147ja c3147ja3 = this.e;
                a4.a(ironSourceError3, c3147ja3.a(c3147ja3.d()));
                b(A5.RV_CALLBACK_SHOW_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1023}, new Object[]{"reason", "showRewardedVideo error: show called while no ads are available"}}));
                return;
            }
            if (this.H.c(ContextProvider.getInstance().getApplicationContext(), placement, IronSource.AD_UNIT.REWARDED_VIDEO)) {
                String str = "showRewardedVideo error: placement " + this.w + " is capped";
                a(str);
                IronSourceError ironSourceError4 = new IronSourceError(IronSourceError.ERROR_PLACEMENT_CAPPED, str);
                C3184ld a5 = C3184ld.a();
                C3147ja c3147ja4 = this.e;
                a5.a(ironSourceError4, c3147ja4.a(c3147ja4.d()));
                b(A5.RV_CALLBACK_SHOW_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_PLACEMENT_CAPPED)}, new Object[]{"reason", str}}));
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<r> it = this.e.c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                r next = it.next();
                if (next.A()) {
                    this.z = true;
                    next.b(true);
                    a(e.RV_STATE_NOT_LOADED);
                    rVar = next;
                    break;
                }
                if (next.e() != null) {
                    stringBuffer.append(next.c() + ":" + next.e() + ",");
                }
                next.b(false);
            }
            if (rVar == null) {
                d("showRewardedVideo(): No ads to show");
                C3184ld a6 = C3184ld.a();
                IronSourceError buildNoAdsToShowError = ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
                C3147ja c3147ja5 = this.e;
                a6.a(buildNoAdsToShowError, c3147ja5.a(c3147ja5.d()));
                HashMap hashMap = new HashMap();
                hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, 509);
                hashMap.put("reason", "showRewardedVideo(): No ads to show");
                if (stringBuffer.length() != 0) {
                    hashMap.put(IronSourceConstants.EVENTS_EXT1, stringBuffer.toString());
                }
                b(A5.RV_CALLBACK_SHOW_FAILED, hashMap);
                this.l.b();
                return;
            }
            c(rVar, placement);
        }
    }

    private boolean c(A5 a5) {
        return a5 == A5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS || a5 == A5.RV_AUCTION_SUCCESS || a5 == A5.RV_AUCTION_FAILED || a5 == A5.RV_AD_UNIT_CAPPED;
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(A5 a5, Map<String, Object> map) {
        a(a5, map, false, false);
    }

    private boolean c(boolean z) {
        Boolean bool = this.C;
        if (bool == null) {
            return false;
        }
        if (z && !bool.booleanValue() && d()) {
            return true;
        }
        return !z && this.C.booleanValue();
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void a(r rVar) {
        synchronized (this.D) {
            a(rVar, "onLoadSuccess mState=" + this.A);
            if (rVar.u() == this.e.d() && this.A != e.RV_STATE_AUCTION_IN_PROGRESS) {
                this.g.put(rVar.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
                e eVar = this.A;
                e eVar2 = e.RV_STATE_LOADING_SMASHES;
                if (eVar == eVar2) {
                    a(e.RV_STATE_READY_TO_SHOW);
                    a(A5.RV_BUSINESS_MEDIATION_LOAD_SUCCESS, Y9.a(new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.o)}}));
                    this.E.a(0L);
                    if (this.m) {
                        C3207n2 c3207n2 = this.f.get(rVar.c());
                        if (c3207n2 != null) {
                            C3147ja c3147ja = this.e;
                            c3147ja.a(c3147ja.d(), c3207n2.a(""), c3207n2.d());
                            this.j.a(c3207n2, rVar.g(), this.h);
                            this.j.a(this.e.c(), this.f, rVar.g(), this.h, c3207n2);
                        } else {
                            String c2 = rVar.c();
                            c("onLoadSuccess winner instance " + c2 + " missing from waterfall. auctionId: " + rVar.u() + " and the current id is " + this.e.d());
                            a(A5.TROUBLESHOOTING_RV_NOTIFICATIONS_ERROR, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}, new Object[]{"reason", "Loaded missing " + eVar2}, new Object[]{IronSourceConstants.EVENTS_EXT1, c2}}));
                        }
                    }
                    b(true);
                }
                return;
            }
            d("onLoadSuccess was invoked with auctionId: " + rVar.u() + " and the current id is " + this.e.d());
            rVar.a(A5.RV_MANAGER_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 2}, new Object[]{"reason", "onLoadSuccess wrong auction ID " + this.A}});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: " + str, 0);
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void a(IronSourceError ironSourceError, r rVar) {
        C3207n2 c3207n2;
        if (this.m && (c3207n2 = this.f.get(rVar.c())) != null) {
            C3147ja c3147ja = this.e;
            c3147ja.a(c3147ja.d(), c3207n2.a(this.w), c3207n2.d());
        }
        a(rVar, "onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.z = false;
        b(A5.RV_CALLBACK_SHOW_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"reason", ironSourceError.getErrorMessage()}}));
        C3184ld.a().a(ironSourceError, this.e.a(rVar.u()));
        this.g.put(rVar.c(), h.a.ISAuctionPerformanceFailedToShow);
        if (this.A != e.RV_STATE_READY_TO_SHOW) {
            b(false);
        }
        this.l.b();
    }

    @Override // com.ironsource.InterfaceC3131ia
    public void a(r rVar, Placement placement) {
        a(rVar, "onRewardedVideoAdRewarded");
        C3184ld.a().b(placement, this.e.a(rVar.u()));
    }

    @Override // com.ironsource.S1
    public void a(List<C3207n2> list, String str, C3207n2 c3207n2, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        d("makeAuction(): success");
        this.h = c3207n2;
        this.q = i;
        this.k = jSONObject;
        this.p = "";
        if (!TextUtils.isEmpty(str2)) {
            a(A5.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{"reason", str2}}));
        }
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        a(jSONObject2, ad_unit);
        if (this.b.a(ad_unit)) {
            a(A5.RV_AD_UNIT_CAPPED, Y9.a(new Object[][]{new Object[]{"auctionId", str}}));
            h();
        } else {
            a(list, str, this.k);
            a(A5.RV_AUCTION_SUCCESS, Y9.a(new Object[][]{new Object[]{"duration", Long.valueOf(j)}}));
            i();
        }
    }

    @Override // com.ironsource.S1
    public void a(int i, String str, int i2, String str2, long j) {
        String str3 = "Auction failed (error " + i + " - " + str + ")";
        d(str3);
        IronSourceUtils.sendAutomationLog("RV: " + str3);
        this.q = i2;
        this.p = str2;
        this.k = null;
        if (this.n) {
            d("Moving to fallback waterfall");
            k();
        }
        if (TextUtils.isEmpty(str)) {
            a(A5.RV_AUCTION_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{"duration", Long.valueOf(j)}}));
        } else {
            a(A5.RV_AUCTION_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(j)}}));
        }
        i();
    }

    private void a(long j) {
        if (this.u.a()) {
            d("all smashes are capped");
            a(A5.TROUBLESHOOTING_RV_LOAD_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80001}, new Object[]{"reason", "all smashes are capped"}}));
            h();
            return;
        }
        a(IronSource.AD_UNIT.REWARDED_VIDEO);
        if (this.m) {
            if (!this.g.isEmpty()) {
                this.i.a(this.g);
                this.g.clear();
            }
            new Timer().schedule(new b(), j);
            return;
        }
        d("auction fallback flow starting");
        k();
        if (this.e.c().isEmpty()) {
            d("loadSmashes -  waterfall is empty");
            a(A5.TROUBLESHOOTING_RV_LOAD_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 80004}, new Object[]{"reason", "waterfall is empty"}}));
            h();
        } else {
            b(A5.RV_BUSINESS_MEDIATION_LOAD);
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<CallableC3394y3> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        B3 b3 = new B3();
        d dVar = new d(map, sb, list);
        b(A5.RV_COLLECT_TOKENS);
        b3.a(list2, dVar, this.F, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        if (map.keySet().size() == 0 && list.size() == 0) {
            c(A5.RV_AUCTION_FAILED, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1005}, new Object[]{"duration", 0}}));
            d("makeAuction() failed - No candidates available for auctioning");
            h();
        } else {
            d("makeAuction() - request waterfall is: " + str);
            b(A5.RV_BUSINESS_MEDIATION_LOAD);
            b(A5.RV_AUCTION_REQUEST);
            c(A5.RV_AUCTION_REQUEST_WATERFALL, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, str.toString()}}));
            this.j.a(ContextProvider.getInstance().getApplicationContext(), map, list, this.i, this.v, this.c);
        }
    }

    private void a(List<C3207n2> list, String str, JSONObject jSONObject) {
        this.f.clear();
        this.g.clear();
        CopyOnWriteArrayList<r> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (C3207n2 c3207n2 : list) {
            sb.append(a(c3207n2) + ",");
            r rVar = this.t.get(c3207n2.c());
            if (rVar != null) {
                AbstractAdapter a2 = com.ironsource.mediationsdk.c.b().a(rVar.b.h());
                if (a2 != null) {
                    r rVar2 = new r(rVar, this, a2, this.v, str, jSONObject, this.q, this.p);
                    rVar2.a(true);
                    copyOnWriteArrayList.add(rVar2);
                    this.f.put(rVar2.c(), c3207n2);
                    this.g.put(c3207n2.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                }
            } else {
                d("updateWaterfall() - could not find matching smash for auction response item " + c3207n2.c());
            }
        }
        this.e.a(copyOnWriteArrayList, str);
        if (this.e.a()) {
            a(A5.TROUBLESHOOTING_RV_WATERFALL_OVERHEAD, Y9.a(new Object[][]{new Object[]{"reason", "waterfalls hold too many with size=" + this.e.e()}}));
        }
        d("updateWaterfall() - next waterfall is " + sb.toString());
        if (sb.length() == 0) {
            d("Updated waterfall is empty");
        }
        a(A5.RV_AUCTION_RESPONSE_WATERFALL, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, sb.toString()}}));
    }

    private String a(C3207n2 c3207n2) {
        String str;
        r rVar = this.t.get(c3207n2.c());
        if (rVar != null) {
            str = Integer.toString(rVar.g());
        } else {
            str = TextUtils.isEmpty(c3207n2.k()) ? "1" : "2";
        }
        return str + c3207n2.c();
    }

    private void a(e eVar) {
        d("current state=" + this.A + ", new state=" + eVar);
        this.A = eVar;
    }

    private void a(boolean z, Map<String, Object> map) {
        A5 a5;
        synchronized (this.D) {
            Boolean bool = this.C;
            if (bool == null || bool.booleanValue() != z) {
                this.C = Boolean.valueOf(z);
                long time = new Date().getTime() - this.B;
                this.B = new Date().getTime();
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("duration", Long.valueOf(time));
                if (z) {
                    a5 = A5.RV_CALLBACK_AVAILABILITY_TRUE;
                } else {
                    a5 = A5.RV_CALLBACK_AVAILABILITY_FALSE;
                }
                a(a5, map);
                C3184ld a2 = C3184ld.a();
                C3147ja c3147ja = this.e;
                a2.a(z, c3147ja.a(c3147ja.d()));
            }
        }
    }

    private void a(r rVar, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "LWSProgRvManager: " + (rVar.c() + " : " + str), 0);
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, str, 3);
    }

    private void a(A5 a5, Map<String, Object> map) {
        a(a5, map, false, true);
    }

    private void a(A5 a5) {
        a(a5, (Map<String, Object>) null, true, true);
    }

    private void a(A5 a5, Map<String, Object> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 2);
        if (z2 && !TextUtils.isEmpty(this.e.d())) {
            hashMap.put("auctionId", this.e.d());
        }
        JSONObject jSONObject = this.k;
        if (jSONObject != null && jSONObject.length() > 0) {
            hashMap.put("genericParams", this.k);
        }
        if (z && !TextUtils.isEmpty(this.w)) {
            hashMap.put("placement", this.w);
        }
        if (c(a5)) {
            Id.i().a(hashMap, this.q, this.p);
        }
        hashMap.put("sessionDepth", Integer.valueOf(this.v));
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    hashMap.putAll(map);
                }
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "LWSProgRvManager: RV sendMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        Id.i().a(new C3413z5(a5, new JSONObject(hashMap)));
    }

    @Override // com.ironsource.InterfaceC3221o
    public void a() {
        a(e.RV_STATE_NOT_LOADED);
        a(false, Y9.a(new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS)}, new Object[]{"reason", "loaded ads are expired"}}));
        a(0L);
    }

    @Override // com.ironsource.InterfaceC3183lc
    public void a(boolean z) {
        if (this.s) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z, 0);
            if (c(z)) {
                b(z);
            }
        }
    }
}

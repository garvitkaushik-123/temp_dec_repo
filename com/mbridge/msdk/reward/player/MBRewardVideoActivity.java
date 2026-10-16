package com.mbridge.msdk.reward.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.g;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.reward.adapter.RewardUnitCacheManager;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.orglistener.h;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.video.signal.impl.k;
import com.mbridge.msdk.videocommon.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_LOCAL_REQUEST_ID = "lRid";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";
    private MBridgeBTContainer A;
    private WindVaneWebView B;
    private com.mbridge.msdk.video.bt.module.listener.a C;
    private String D;
    private String E;
    private boolean F;
    private String N;
    private com.mbridge.msdk.foundation.same.report.metrics.c O;
    private boolean Q;
    private String f;
    private String g;
    private String h;
    private com.mbridge.msdk.videocommon.entity.c i;
    private int m;
    private int n;
    private int o;
    private h r;
    private com.mbridge.msdk.videocommon.setting.c s;
    private com.mbridge.msdk.videocommon.download.a v;
    private CampaignEx w;
    private List<com.mbridge.msdk.videocommon.download.a> x;
    private List<CampaignEx> y;
    private MBTempContainer z;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean p = false;
    private boolean q = false;
    private boolean t = false;
    private boolean u = false;
    private int G = 1;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private boolean P = false;
    private AdSession R = null;
    private MediaEvents S = null;
    private AdEvents T = null;
    private long U = 0;
    private String V = "";
    private Boolean W = null;
    private int X = 0;
    private boolean Y = false;
    private boolean Z = false;
    private com.mbridge.msdk.video.dynview.listener.a a0 = new a();
    private com.mbridge.msdk.video.dynview.listener.d b0 = new b();

    class a implements com.mbridge.msdk.video.dynview.listener.a {
        a() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.a
        public void a(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            if (map.containsKey(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                MBRewardVideoActivity.this.j = ((Integer) map.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE)).intValue();
            }
            if (map.containsKey(C3040d4.h.L)) {
                int intValue = ((Integer) map.get(C3040d4.h.L)).intValue();
                if (MBRewardVideoActivity.this.y == null || MBRewardVideoActivity.this.y.size() <= 0 || intValue < 1) {
                    return;
                }
                MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                mBRewardVideoActivity.w = (CampaignEx) mBRewardVideoActivity.y.get(intValue);
                MBRewardVideoActivity.m(MBRewardVideoActivity.this);
                int i = intValue - 1;
                if (MBRewardVideoActivity.this.y.get(i) != null) {
                    MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
                    MBRewardVideoActivity.b(mBRewardVideoActivity2, ((CampaignEx) mBRewardVideoActivity2.y.get(i)).getVideoLength());
                }
                MBRewardVideoActivity mBRewardVideoActivity3 = MBRewardVideoActivity.this;
                MBRewardVideoActivity.this.w.setVideoCompleteTime(mBRewardVideoActivity3.a(mBRewardVideoActivity3.w.getVideoCompleteTime(), MBRewardVideoActivity.this.G));
                MBRewardVideoActivity.this.w.setShowIndex(MBRewardVideoActivity.this.G);
                MBRewardVideoActivity.this.w.setShowType(1);
                MBRewardVideoActivity mBRewardVideoActivity4 = MBRewardVideoActivity.this;
                mBRewardVideoActivity4.c(mBRewardVideoActivity4.w);
            }
        }
    }

    class d implements com.mbridge.msdk.foundation.feedback.a {
        d() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            MBRewardVideoActivity.this.onPause();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            MBRewardVideoActivity.this.onResume();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            MBRewardVideoActivity.this.onResume();
        }
    }

    private static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f4690a;
        private final String b;
        private final String c;

        public e(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.f4690a = list;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f4690a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f4690a) {
                    if (aVar != null && aVar.c() != null) {
                        CampaignEx c = aVar.c();
                        try {
                            AppletModelManager.getInstance().remove(c);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                p0.b("MBRewardVideoActivity", "AppletModelManager remove error", e);
                            }
                        }
                        com.mbridge.msdk.videocommon.download.b.getInstance().c(this.b, c.getRequestId() + c.getId() + c.getVideoUrlEncode());
                        if (c.getRewardTemplateMode() != null) {
                            if (!TextUtils.isEmpty(c.getRewardTemplateMode().e())) {
                                com.mbridge.msdk.videocommon.a.e(this.b + "_" + c.getId() + "_" + this.c + "_" + c.getRewardTemplateMode().e());
                                com.mbridge.msdk.videocommon.a.b(c.getAdType(), c);
                            }
                            if (!TextUtils.isEmpty(c.getCMPTEntryUrl())) {
                                com.mbridge.msdk.videocommon.a.e(this.b + "_" + this.c + "_" + c.getCMPTEntryUrl());
                            }
                            com.mbridge.msdk.videocommon.cache.a.a().a(this.b, c);
                        }
                    }
                }
            } catch (Exception e2) {
                p0.a("MBRewardVideoActivity", e2.getMessage());
            }
        }
    }

    private static final class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f4691a;
        private final String b;

        public f(String str, List<com.mbridge.msdk.videocommon.download.a> list) {
            this.f4691a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f4691a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f4691a) {
                    if (aVar != null && aVar.c() != null) {
                        com.mbridge.msdk.videocommon.cache.a.a().a(aVar.c(), this.b);
                    }
                }
            } catch (Throwable th) {
                p0.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    static /* synthetic */ int m(MBRewardVideoActivity mBRewardVideoActivity) {
        int i = mBRewardVideoActivity.G;
        mBRewardVideoActivity.G = i + 1;
        return i;
    }

    public void changeHalfScreenPadding(int i) {
        int f2;
        int g;
        int g2;
        float f3;
        try {
            CampaignEx campaignEx = this.w;
            if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
                return;
            }
            getWindow().getDecorView().setBackgroundColor(-1728053248);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams.gravity = 17;
            if (this.w.getRewardTemplateMode().b() == 0) {
                if (i == 2) {
                    f2 = (int) (u0.f(this) * 0.6f);
                    g2 = u0.g(this);
                    f3 = g2 * 0.6f;
                } else {
                    f2 = (int) (u0.f(this) * 0.6f);
                    g = u0.g(this);
                    f3 = g * 0.7f;
                }
            } else if (this.w.getRewardTemplateMode().b() == 2) {
                f2 = (int) (u0.f(this) * 0.6f);
                g2 = u0.g(this);
                f3 = g2 * 0.6f;
            } else {
                f2 = (int) (u0.f(this) * 0.6f);
                g = u0.g(this);
                f3 = g * 0.7f;
            }
            layoutParams.height = f2;
            layoutParams.width = (int) f3;
            this.z.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            p0.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    public int findID(String str) {
        return h0.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return h0.a(getApplicationContext(), str, "layout");
    }

    @Override // android.app.Activity
    public void finish() {
        this.Y = true;
        com.mbridge.msdk.foundation.controller.c.m().b(0);
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.z = null;
        }
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f);
        if (this.R != null) {
            p0.b("omsdk", "mbrewardvideoac finish");
            this.R.removeAllFriendlyObstructions();
            this.R.finish();
            this.R = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.A = null;
        }
        super.finish();
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onBackPressed() {
        this.Z = true;
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.z != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.z.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        List<com.mbridge.msdk.videocommon.download.a> list;
        String str = "";
        super.onCreate(bundle);
        MBridgeConstans.isRewardActivityShowing = true;
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        this.U = SystemClock.elapsedRealtime();
        this.V = TextUtils.isEmpty(this.V) ? "onCreate" : this.V + "_onCreate";
        try {
            Intent intent = getIntent();
            this.f = intent.getStringExtra(INTENT_UNITID);
            this.g = intent.getStringExtra(MBridgeConstans.PLACEMENT_ID);
            this.i = com.mbridge.msdk.videocommon.entity.c.a(intent.getStringExtra(INTENT_REWARD));
            this.h = intent.getStringExtra(INTENT_USERID);
            this.j = intent.getIntExtra(INTENT_MUTE, 2);
            this.k = intent.getBooleanExtra(INTENT_ISIV, false);
            com.mbridge.msdk.foundation.controller.c m = com.mbridge.msdk.foundation.controller.c.m();
            boolean z = this.k;
            int i = MBSupportMuteAdType.INTERSTITIAL_VIDEO;
            m.b(z ? 287 : 94);
            this.l = intent.getBooleanExtra(INTENT_ISBID, false);
            this.E = intent.getStringExtra(INTENT_EXTRADATA);
            boolean booleanExtra = intent.getBooleanExtra("is_refactor", false);
            this.P = booleanExtra;
            if (booleanExtra) {
                this.r = MBridgeGlobalCommon.showRewardListenerMap.get(this.f);
            } else {
                this.r = com.mbridge.msdk.reward.controller.a.f0.get(this.f);
            }
            if (this.k) {
                this.m = intent.getIntExtra(INTENT_IVREWARD_MODETYPE, 0);
                this.n = intent.getIntExtra(INTENT_IVREWARD_VALUETYPE, 0);
                this.o = intent.getIntExtra(INTENT_IVREWARD_VALUE, 0);
            }
            this.p = intent.getBooleanExtra(INTENT_ISBIG_OFFER, false);
            this.x = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f);
            this.y = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f);
            int findLayout = findLayout("mbridge_more_offer_activity");
            if (!h0.a(findLayout)) {
                b("no mbridge_more_offer_activity layout");
                return;
            }
            setContentView(findLayout);
            if (TextUtils.isEmpty(this.f)) {
                b("data empty error");
                return;
            }
            com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this);
            this.jsFactory = bVar;
            registerJsFactory(bVar);
            h hVar = this.r;
            if (hVar == null) {
                b("showRewardListener is null");
                return;
            }
            this.X = hVar.hashCode();
            com.mbridge.msdk.videocommon.setting.c cVar = RewardUnitCacheManager.getInstance().get(this.g, this.f);
            this.s = cVar;
            if (cVar == null) {
                com.mbridge.msdk.videocommon.setting.c c2 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.f);
                this.s = c2;
                if (c2 == null) {
                    this.s = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f, this.k);
                }
            }
            com.mbridge.msdk.videocommon.setting.c cVar2 = this.s;
            if (cVar2 != null) {
                this.i.a(cVar2.d());
                this.i.b(this.s.s());
            }
            com.mbridge.msdk.videocommon.entity.c cVar3 = this.i;
            if (cVar3 != null && cVar3.a() <= 0) {
                this.i.a(1);
            }
            int a2 = h0.a(this, "mbridge_reward_activity_open", "anim");
            int a3 = h0.a(this, "mbridge_reward_activity_stay", "anim");
            if (h0.a(a2) && h0.a(a3)) {
                overridePendingTransition(a2, a3);
            }
            if (bundle != null) {
                try {
                    this.u = bundle.getBoolean(SAVE_STATE_KEY_REPORT);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            p0.a("DynamicViewCampaignResourceDownloader", "进入 show，大模板 " + this.p);
            if (!this.p) {
                List<com.mbridge.msdk.videocommon.download.a> list2 = this.x;
                if (list2 != null && list2.size() > 0) {
                    this.v = this.x.get(0);
                }
                com.mbridge.msdk.videocommon.download.a aVar = this.v;
                if (aVar != null) {
                    this.w = aVar.c();
                    this.v.b(true);
                    this.v.d(false);
                    CampaignEx campaignEx = this.w;
                    if (campaignEx != null) {
                        this.N = campaignEx.getCurrentLocalRid();
                        this.w.setShowIndex(1);
                        this.w.setShowType(1);
                        com.mbridge.msdk.reward.controller.a.b0 = this.w.getEcppv();
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.w.getMaitve(), this.w.getMaitve_src());
                    }
                }
                CampaignEx campaignEx2 = this.w;
                if (campaignEx2 != null && !g.a(campaignEx2, this, (View) null, campaignEx2.getImpReportType())) {
                    b("env is exception");
                    return;
                }
                if (this.v != null && this.w != null && this.i != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.w);
                    a(arrayList);
                    b(this.w);
                    j();
                    if (com.mbridge.msdk.util.b.a()) {
                        return;
                    }
                    e();
                    return;
                }
                b("data empty error");
                return;
            }
            a(this.y);
            this.D = "";
            List<CampaignEx> list3 = this.y;
            if (list3 != null && list3.size() > 0) {
                CampaignEx campaignEx3 = this.y.get(0);
                if (!g.a(this.y, this, (View) null, campaignEx3.getImpReportType())) {
                    b("env is exception");
                    return;
                }
                b(campaignEx3);
                str = campaignEx3.getCMPTEntryUrl();
                this.D = campaignEx3.getRequestId();
                this.N = campaignEx3.getCurrentLocalRid();
                com.mbridge.msdk.reward.controller.a.b0 = campaignEx3.getEcppv();
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx3.getMaitve(), campaignEx3.getMaitve_src());
            }
            WindVaneWebView a4 = a(this.f + "_" + this.D + "_" + str);
            this.B = a4;
            if (a4 == null) {
                if (this.v == null && (list = this.x) != null && list.size() > 0) {
                    this.v = this.x.get(0);
                }
                if (this.v == null) {
                    com.mbridge.msdk.videocommon.download.b bVar2 = com.mbridge.msdk.videocommon.download.b.getInstance();
                    if (!this.k) {
                        i = 94;
                    }
                    this.v = bVar2.a(i, this.f, this.l);
                }
                com.mbridge.msdk.videocommon.download.a aVar2 = this.v;
                if (aVar2 != null) {
                    this.w = aVar2.c();
                    this.v.b(true);
                    this.v.d(false);
                }
                if (this.v != null && this.w != null && this.i != null) {
                    this.p = false;
                    List<CampaignEx> a5 = com.mbridge.msdk.videocommon.cache.a.a().a(this.y);
                    if (a5 == null) {
                        b("no available campaign");
                        return;
                    }
                    int size = a5.size();
                    if (size == 0) {
                        b("no available campaign");
                        return;
                    }
                    if (a5.get(0) == null || !a5.get(0).isDynamicView()) {
                        j();
                    } else if (size == 1) {
                        CampaignEx campaignEx4 = a5.get(0);
                        this.w = campaignEx4;
                        if (campaignEx4 != null) {
                            this.N = campaignEx4.getCurrentLocalRid();
                            this.w.setCampaignIsFiltered(true);
                        }
                        c(this.w);
                    } else {
                        b(a5);
                    }
                }
                b("data empty error");
                return;
            }
            b(this.y.get(0));
            WindVaneWebView windVaneWebView = this.B;
            if (windVaneWebView != null) {
                a1.a(windVaneWebView, this.y.get(0).getLocalRequestId(), this.y.get(0).getLocalAllowTrackClick());
                try {
                    k kVar = (k) this.B.getObject();
                    kVar.setAdEvents(this.T);
                    kVar.setAdSession(this.R);
                    kVar.setVideoEvents(this.S);
                    this.B.setObject(kVar);
                } catch (Exception e3) {
                    p0.b("MBRewardVideoActivity", e3.getMessage());
                }
            }
            k();
            if (com.mbridge.msdk.util.b.a()) {
                return;
            }
            e();
        } catch (Throwable th) {
            a(this.y);
            b("onCreate error" + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onDestroy() {
        this.V = TextUtils.isEmpty(this.V) ? "onDestroy" : this.V + "_onDestroy";
        super.onDestroy();
        f();
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("activity_life_cycle", TextUtils.isEmpty(this.V) ? "unKnown" : this.V);
        eVar.a("activity_duration", Long.valueOf(SystemClock.elapsedRealtime() - this.U));
        Boolean bool = this.W;
        eVar.a("is_unexpected_destroy", Integer.valueOf(bool == null ? 0 : bool.booleanValue() ? 1 : 2));
        eVar.a("is_listener_null", Integer.valueOf(this.r == null ? 1 : 2));
        eVar.a("is_called_finish", Integer.valueOf(this.Y ? 1 : 2));
        eVar.a("is_back_pressed", Integer.valueOf(this.Z ? 1 : 2));
        h hVar = this.r;
        eVar.a("is_listener_change", Integer.valueOf(hVar != null ? hVar.hashCode() == this.X ? 1 : 2 : 0));
        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000151", this.w, eVar);
        g();
        com.mbridge.msdk.video.module.report.b.a(this.f);
        h();
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.z = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.A = null;
        }
        this.a0 = null;
        this.b0 = null;
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f + "_1");
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f + "_2");
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e(this.x, this.f, this.D));
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.V = TextUtils.isEmpty(this.V) ? C3040d4.h.t0 : this.V + "_onPause";
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.V = TextUtils.isEmpty(this.V) ? "onRestart" : this.V + "_onRestart";
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onResume() {
        MBridgeVideoView mBridgeVideoView;
        super.onResume();
        this.V = TextUtils.isEmpty(this.V) ? C3040d4.h.u0 : this.V + "_onResume";
        if (com.mbridge.msdk.foundation.feedback.b.f) {
            MBTempContainer mBTempContainer = this.z;
            if (mBTempContainer == null || (mBridgeVideoView = mBTempContainer.mbridgeVideoView) == null) {
                return;
            }
            mBridgeVideoView.setCover(false);
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new f(this.f, this.x));
        } catch (Throwable th) {
            p0.b("MBRewardVideoActivity", th.getMessage());
        }
        MBTempContainer mBTempContainer2 = this.z;
        if (mBTempContainer2 != null) {
            mBTempContainer2.onResume();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.u);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.V = TextUtils.isEmpty(this.V) ? "onStart" : this.V + "_onStart";
        if (com.mbridge.msdk.foundation.feedback.b.f) {
            return;
        }
        new d();
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.onStart();
            this.w.setCampaignUnitId(this.f);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.f + "_1", this.w);
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStart();
            List<CampaignEx> list = this.y;
            if (list != null && list.size() > 0) {
                CampaignEx campaignEx = this.y.get(0);
                campaignEx.setCampaignUnitId(this.f);
                com.mbridge.msdk.foundation.feedback.b.b().a(this.f + "_1", campaignEx);
            }
        }
        if (this.F) {
            return;
        }
        com.mbridge.msdk.foundation.feedback.b.b().a(this.f + "_1", 1);
        com.mbridge.msdk.foundation.feedback.b.b().d(this.f + "_2");
        this.F = true;
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.V = TextUtils.isEmpty(this.V) ? "onStop" : this.V + "_onStop";
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(h0.a(this, "mbridge_transparent_theme", "style"));
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity
    public void setTopControllerPadding(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        this.I = i2;
        this.K = i3;
        this.J = i4;
        this.L = i5;
        this.M = i;
        MBTempContainer mBTempContainer = this.z;
        if (mBTempContainer != null) {
            mBTempContainer.setNotchPadding(i, i2, i3, i4, i5);
            i10 = i5;
            i9 = i4;
            i8 = i3;
            i7 = i2;
            i6 = i;
        } else {
            i6 = i;
            i7 = i2;
            i8 = i3;
            i9 = i4;
            i10 = i5;
        }
        MBridgeBTContainer mBridgeBTContainer = this.A;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i6, i7, i8, i9, i10);
        }
        com.mbridge.msdk.video.dynview.constant.a.a(i6, i7, i8, i9, i10);
    }

    class c implements com.mbridge.msdk.video.bt.module.listener.a {
        c() {
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a() {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.a(MBRewardVideoActivity.this.O);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void b(String str, String str2) {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.b(str, str2);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(boolean z, com.mbridge.msdk.videocommon.entity.c cVar) {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.a(MBRewardVideoActivity.this.O, z, cVar);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(boolean z, int i) {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.a(z, i);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(String str) {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.a(MBRewardVideoActivity.this.O, str);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(boolean z, String str, String str2) {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.a(z, str, str2);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(String str, String str2) {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.a(str, str2);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.listener.a
        public void a(int i, String str, String str2) {
            if (MBRewardVideoActivity.this.r != null) {
                MBRewardVideoActivity.this.r.a(i, str, str2);
            }
        }
    }

    static /* synthetic */ int b(MBRewardVideoActivity mBRewardVideoActivity, int i) {
        int i2 = mBRewardVideoActivity.H - i;
        mBRewardVideoActivity.H = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CampaignEx campaignEx) {
        CampaignEx c2;
        try {
            List<com.mbridge.msdk.videocommon.download.a> list = this.x;
            if (list != null && list.size() > 0) {
                for (com.mbridge.msdk.videocommon.download.a aVar : this.x) {
                    if (aVar != null && (c2 = aVar.c()) != null && TextUtils.equals(c2.getId(), campaignEx.getId()) && TextUtils.equals(c2.getRequestId(), campaignEx.getRequestId())) {
                        this.v = aVar;
                    }
                }
            }
            this.p = true;
            j();
            MBTempContainer mBTempContainer = this.z;
            if (mBTempContainer != null) {
                mBTempContainer.setNotchPadding(this.M, this.I, this.K, this.J, this.L);
            }
        } catch (Exception e2) {
            p0.b("MBRewardVideoActivity", e2.getMessage());
            b("more offer to one offer exception");
        }
    }

    private void d(CampaignEx campaignEx) {
        com.mbridge.msdk.reward.player.a.a(this, campaignEx, this.s, this.f);
    }

    private void e() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            BitmapDrawable a2 = com.mbridge.msdk.foundation.controller.c.m().a(this.f, this.k ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
            if (a2 != null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
                u0.a(imageView, a2, getResources().getDisplayMetrics());
                ((ViewGroup) ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(1)).getChildAt(0)).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                AdSession adSession = this.R;
                if (adSession != null) {
                    adSession.addFriendlyObstruction(imageView, FriendlyObstructionPurpose.OTHER, null);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        h hVar = this.r;
        if (hVar == null || !(hVar instanceof com.mbridge.msdk.video.bt.module.orglistener.b)) {
            return;
        }
        try {
            com.mbridge.msdk.video.bt.module.orglistener.b bVar = (com.mbridge.msdk.video.bt.module.orglistener.b) hVar;
            Boolean d2 = bVar.d();
            Boolean c2 = bVar.c();
            if (d2 == null && c2 == null) {
                this.W = null;
            } else {
                Boolean bool = Boolean.FALSE;
                this.W = Boolean.valueOf(bool.equals(d2) && bool.equals(c2));
            }
        } catch (Throwable th) {
            p0.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    private void g() {
        h hVar;
        try {
            Boolean bool = this.W;
            if ((bool == null || bool.booleanValue()) && (hVar = this.r) != null) {
                hVar.a(this.O, "show fail : unexpected destroy");
            }
        } catch (Throwable th) {
            p0.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    private void h() {
        try {
            List<CampaignEx> list = this.y;
            if (list != null && list.size() > 0) {
                Iterator<CampaignEx> it = this.y.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            CampaignEx campaignEx = this.w;
            if (campaignEx != null) {
                a(campaignEx);
            }
        } catch (Throwable th) {
            p0.b("MBRewardVideoActivity", th.getMessage());
        }
    }

    private com.mbridge.msdk.video.bt.module.listener.a i() {
        if (this.C == null) {
            this.C = new c();
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        List<CampaignEx> list;
        RewardPlus rewardPlus;
        CampaignEx campaignEx;
        List<CampaignEx> list2;
        int findID = findID("mbridge_temp_container");
        if (!h0.a(findID)) {
            b("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        MBTempContainer mBTempContainer = (MBTempContainer) findViewById(findID);
        this.z = mBTempContainer;
        if (mBTempContainer == null) {
            b("env error");
        }
        List<CampaignEx> list3 = this.y;
        if (list3 == null || list3.size() <= 0 || !this.y.get(0).isDynamicView()) {
            this.z.setVisibility(0);
        } else {
            new com.mbridge.msdk.video.dynview.ui.b().a(this.z, 500L);
        }
        changeHalfScreenPadding(-1);
        this.z.setActivity(this);
        this.z.setBidCampaign(this.l);
        this.z.setBigOffer(this.p);
        this.z.setUnitId(this.f);
        this.z.setCampaign(this.w);
        if (this.w.getDynamicTempCode() == 5 && (list2 = this.y) != null && list2.size() > 1) {
            View findViewById = findViewById(findID("mbridge_reward_root_container"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(-16777216);
            }
            this.z.removeAllViews();
            this.z.setCampOrderViewData(this.y, this.H);
            this.z.setCamPlayOrderCallback(this.a0, this.G);
        }
        this.z.setCampaignDownLoadTask(this.v);
        this.z.setIV(this.k);
        CampaignEx campaignEx2 = this.w;
        if (campaignEx2 == null || campaignEx2.getAdSpaceT() != 2) {
            this.z.setIVRewardEnable(this.m, this.n, this.o);
        } else {
            this.z.setIVRewardEnable(0, 0, 0);
        }
        this.z.setMute(this.j);
        CampaignEx campaignEx3 = this.w;
        if (((campaignEx3 != null && (rewardPlus = campaignEx3.getRewardPlus()) != null) || ((list = this.y) != null && list.size() > 0 && this.y.get(0) != null && (rewardPlus = this.y.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.entity.c cVar = new com.mbridge.msdk.videocommon.entity.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.a() < 0) {
                cVar.a(1);
            }
            this.i = cVar;
        }
        this.z.setReward(this.i);
        this.z.setRewardUnitSetting(this.s);
        this.z.setPlacementId(this.g);
        this.z.setUserId(this.h);
        this.z.setShowRewardListener(this.r);
        this.z.setDeveloperExtraData(this.E);
        this.z.init(this);
        this.z.setAdSession(this.R);
        this.z.setAdEvents(this.T);
        this.z.setVideoEvents(this.S);
        this.z.onCreate();
        if (!com.mbridge.msdk.util.b.a() || (campaignEx = this.w) == null) {
            return;
        }
        d(campaignEx);
    }

    private void k() {
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        int findID = findID("mbridge_bt_container");
        if (!h0.a(findID)) {
            b("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        MBridgeBTContainer mBridgeBTContainer = (MBridgeBTContainer) findViewById(findID);
        this.A = mBridgeBTContainer;
        if (mBridgeBTContainer == null) {
            b("env error");
        }
        this.A.setVisibility(0);
        com.mbridge.msdk.video.bt.module.listener.a i = i();
        this.C = i;
        this.A.setBTContainerCallback(i);
        this.A.setShowRewardVideoListener(this.r);
        this.A.setChoiceOneCallback(this.b0);
        this.A.setCampaigns(this.y);
        this.A.setCampaignDownLoadTasks(this.x);
        this.A.setRewardUnitSetting(this.s);
        this.A.setUnitId(this.f);
        this.A.setPlacementId(this.g);
        this.A.setUserId(this.h);
        this.A.setActivity(this);
        CampaignEx campaignEx = this.w;
        if (((campaignEx != null && (rewardPlus = campaignEx.getRewardPlus()) != null) || (this.y.get(0) != null && (rewardPlus = this.y.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            com.mbridge.msdk.videocommon.entity.c cVar = new com.mbridge.msdk.videocommon.entity.c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.a() < 0) {
                cVar.a(1);
            }
            this.i = cVar;
        }
        this.A.setReward(this.i);
        this.A.setIVRewardEnable(this.m, this.n, this.o);
        this.A.setIV(this.k);
        this.A.setMute(this.j);
        this.A.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.A.setDeveloperExtraData(this.E);
        this.A.init(this);
        this.A.setAdSession(this.R);
        this.A.setVideoEvents(this.S);
        this.A.setAdEvents(this.T);
        this.A.onCreate(this.P);
        if (!com.mbridge.msdk.util.b.a() || (list = this.y) == null || list.size() <= 0 || this.y.get(0) == null) {
            return;
        }
        d(this.y.get(0));
    }

    private void b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.isActiveOm() && this.R == null) {
                    AdSession a2 = com.mbridge.msdk.omsdk.b.a(getApplicationContext(), false, campaignEx.getOmid(), campaignEx.getRequestId(), campaignEx.getId(), this.f, campaignEx.getVideoUrlEncode(), campaignEx.getRequestIdNotice());
                    this.R = a2;
                    if (a2 != null) {
                        this.T = AdEvents.createAdEvents(a2);
                        this.S = MediaEvents.createMediaEvents(this.R);
                    }
                }
            } catch (Throwable th) {
                p0.b("MBRewardVideoActivity", th.getMessage());
            }
        }
    }

    private WindVaneWebView a(String str) {
        a.C0420a b2 = com.mbridge.msdk.videocommon.a.b(str);
        if (b2 != null) {
            return b2.b();
        }
        return null;
    }

    class b implements com.mbridge.msdk.video.dynview.listener.d {
        b() {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.d
        public void a(CampaignEx campaignEx) {
            if (campaignEx == null) {
                MBRewardVideoActivity.this.b("campaign is null");
                return;
            }
            if (MBRewardVideoActivity.this.A != null) {
                new com.mbridge.msdk.video.dynview.ui.b().b(MBRewardVideoActivity.this.A, 500L);
            }
            MBRewardVideoActivity.this.w = campaignEx;
            MBRewardVideoActivity.this.w.setShowType(2);
            MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
            mBRewardVideoActivity.c(mBRewardVideoActivity.w);
        }

        @Override // com.mbridge.msdk.video.dynview.listener.d
        public void a() {
            if (MBRewardVideoActivity.this.A != null) {
                new com.mbridge.msdk.video.dynview.ui.b().b(MBRewardVideoActivity.this.A, 500L);
            }
            MBRewardVideoActivity.this.p = true;
            MBRewardVideoActivity.this.j();
            if (MBRewardVideoActivity.this.z != null) {
                MBRewardVideoActivity.this.z.setNotchPadding(MBRewardVideoActivity.this.M, MBRewardVideoActivity.this.I, MBRewardVideoActivity.this.K, MBRewardVideoActivity.this.J, MBRewardVideoActivity.this.L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2) {
        List<CampaignEx> list = this.y;
        if (list != null && list.size() != 0) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < this.y.size(); i5++) {
                if (this.y.get(0) != null) {
                    if (i5 == 0) {
                        i4 = this.y.get(0).getVideoCompleteTime();
                    }
                    i3 += this.y.get(i5).getVideoLength();
                }
            }
            if (i2 == 1) {
                if (i == 0) {
                    if (i3 >= 45) {
                        return 45;
                    }
                } else if (i3 > i) {
                    if (i > 45) {
                        return 45;
                    }
                }
                return i3;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < i2 - 1; i7++) {
                if (this.y.get(i7) != null) {
                    i6 += this.y.get(i7).getVideoLength();
                }
            }
            if (i4 > i6) {
                return i4 - i6;
            }
            return 0;
        }
        return i;
    }

    private void e(CampaignEx campaignEx) {
        if (campaignEx != null) {
            int a2 = a(campaignEx.getVideoCompleteTime(), this.G);
            this.w = campaignEx;
            campaignEx.setCampaignIsFiltered(true);
            this.G = 1;
            this.w.setVideoCompleteTime(a2);
            this.w.setShowIndex(this.G);
            this.w.setShowType(1);
            c(this.w);
            return;
        }
        b("campaign is less");
    }

    private void b(List<CampaignEx> list) {
        int i;
        if (list == null) {
            b("no available campaign");
            return;
        }
        if (list.size() == 0) {
            b("no available campaign");
            return;
        }
        if (list.get(0) != null) {
            i = list.get(0).getDynamicTempCode();
            this.N = list.get(0).getCurrentLocalRid();
        } else {
            i = 0;
        }
        if (i != 5) {
            k();
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (campaignEx != null) {
                this.H += campaignEx.getVideoLength();
            }
        }
        e(list.get(0));
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getImageUrl());
            }
            if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
                return;
            }
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getIconUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        p0.b("MBRewardVideoActivity", str);
        a(this.y);
        h hVar = this.r;
        if (hVar != null) {
            hVar.a(this.O, str);
        }
        finish();
    }

    private void a(List<CampaignEx> list) {
        CampaignEx campaignEx;
        if (this.Q) {
            return;
        }
        if (list == null) {
            try {
                if (this.p) {
                    list = this.y;
                } else {
                    list = new ArrayList<>();
                    List<com.mbridge.msdk.videocommon.download.a> list2 = this.x;
                    if (list2 != null && list2.get(0) != null && this.x.get(0).c() != null) {
                        list.add(this.x.get(0).c());
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        String str = "";
        if (list != null && !list.isEmpty() && (campaignEx = list.get(0)) != null) {
            str = campaignEx.getCurrentLocalRid();
        }
        if (!TextUtils.isEmpty(str)) {
            this.O = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(str);
        }
        if (this.O == null) {
            this.O = new com.mbridge.msdk.foundation.same.report.metrics.c();
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f);
            eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(this.l ? 1 : 0));
            eVar.a("adtp", Integer.valueOf(this.k ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94));
            eVar.a("lrid", this.N);
            eVar.a("his_reason", "show campaign is null");
            this.O.a("2000129", eVar);
        }
        if (list != null) {
            this.O.b(list);
        }
        this.Q = true;
        com.mbridge.msdk.reward.report.metrics.a.a().a("2000129", this.O);
    }
}

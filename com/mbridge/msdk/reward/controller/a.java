package com.mbridge.msdk.reward.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.cache.a;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.x0;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.adapter.b;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardVideoController.java */
/* loaded from: classes6.dex */
public class a {
    public static String b0 = "";
    public static String c0;
    private static ConcurrentHashMap<String, Integer> d0 = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> e0 = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, i> f0 = new ConcurrentHashMap<>();
    private Queue<Integer> I;
    private String J;
    private CopyOnWriteArrayList<CampaignEx> S;
    private List<CampaignEx> T;

    /* renamed from: a, reason: collision with root package name */
    private Context f4667a;
    private com.mbridge.msdk.reward.adapter.c b;
    private com.mbridge.msdk.videocommon.setting.c c;
    private com.mbridge.msdk.videocommon.setting.a d;
    private volatile InterVideoOutListener e;
    private volatile h f;
    private String g;
    private String h;
    private MBridgeIds i;
    g j;
    private String k;
    private volatile String l;
    private String m;
    private int q;
    private int r;
    private int s;
    private boolean x;
    private int n = 0;
    private int p = 2;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean y = false;
    private String z = "";
    private String A = "";
    private ArrayList<Integer> B = new ArrayList<>(7);
    private boolean C = false;
    private final Object D = new Object();
    public boolean E = false;
    int F = 25;
    int G = 1;
    private List<CampaignEx> H = new ArrayList();
    private com.mbridge.msdk.foundation.db.g K = null;
    private volatile boolean L = true;
    private volatile boolean M = false;
    private volatile boolean N = false;
    private volatile boolean O = false;
    private volatile boolean P = false;
    private volatile boolean Q = false;
    private volatile boolean R = false;
    volatile boolean U = false;
    volatile boolean V = false;
    volatile boolean W = false;
    volatile boolean X = false;
    volatile boolean Y = false;
    private JSONArray Z = new JSONArray();
    private int a0 = 1;
    private Handler o = new com.mbridge.msdk.reward.controller.b(this);

    /* compiled from: RewardVideoController.java */
    /* renamed from: com.mbridge.msdk.reward.controller.a$a, reason: collision with other inner class name */
    class C0375a implements com.mbridge.msdk.videocommon.net.c {
        C0375a() {
        }

        @Override // com.mbridge.msdk.videocommon.net.c
        public void a(String str) {
        }

        @Override // com.mbridge.msdk.videocommon.net.c
        public void onFailed(String str) {
        }
    }

    /* compiled from: RewardVideoController.java */
    class c implements b.n {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f4674a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ CopyOnWriteArrayList c;
        final /* synthetic */ boolean d;
        final /* synthetic */ int e;

        c(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, boolean z, int i) {
            this.b = campaignEx;
            this.c = copyOnWriteArrayList;
            this.d = z;
            this.e = i;
            this.f4674a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar) {
            String unitId = bVar == null ? "" : bVar.e().getUnitId();
            a aVar = a.this;
            aVar.c(unitId, (List<CampaignEx>) aVar.T);
            if (bVar != null) {
                bVar.c("errorCode: 3202 errorMessage: temp resource download failed");
            }
            if (this.f4674a == null) {
                this.f4674a = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.f4674a.b(this.c);
            this.f4674a.a(bVar);
            if (!this.d && a.this.f != null) {
                if (a.this.X) {
                    return;
                }
                a.this.X = true;
                a.this.f.b(bVar, this.f4674a);
                return;
            }
            if (this.e != 1 || a.this.X || a.this.f == null) {
                return;
            }
            a.this.X = true;
            a.this.f.b(bVar, this.f4674a);
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, String str3, String str4) {
        }
    }

    /* compiled from: RewardVideoController.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.K == null) {
                    a.this.K = com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d());
                }
                com.mbridge.msdk.foundation.db.h a2 = com.mbridge.msdk.foundation.db.h.a(a.this.K);
                if (a2 != null) {
                    a2.b(a.this.h);
                }
            } catch (Throwable unused) {
                p0.b("RewardVideoController", "can't find DailyPlayCapDao");
            }
        }
    }

    /* compiled from: RewardVideoController.java */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.reward.adapter.c f4679a;
        private final int b;
        private final boolean c;
        private boolean d = false;
        private int e;
        private String f;
        private com.mbridge.msdk.foundation.same.report.metrics.c g;

        public f(com.mbridge.msdk.reward.adapter.c cVar, int i, boolean z, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar2) {
            this.f4679a = cVar;
            this.b = i;
            this.c = z;
            if (cVar != null) {
                cVar.c(false);
            }
            this.f = str;
            this.g = cVar2;
        }

        public void a() {
            this.d = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f4679a;
            if (cVar != null) {
                cVar.c(true);
            }
            p0.b("RewardVideoController", "adSource=" + this.b + " CommonCancelTimeTask mIsDevCall：" + this.c);
            a.this.a(com.mbridge.msdk.foundation.error.a.a(880023, "v3 is timeout"), this.g);
        }

        public void a(int i) {
            this.e = i;
        }
    }

    /* compiled from: RewardVideoController.java */
    public class g implements com.mbridge.msdk.reward.adapter.a {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.reward.adapter.c f4680a;
        private boolean b;
        private f c;

        public g(com.mbridge.msdk.reward.adapter.c cVar, boolean z) {
            this.f4680a = cVar;
            this.b = z;
        }

        public void a(f fVar) {
            this.c = fVar;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            f fVar = this.c;
            if (fVar != null) {
                fVar.a();
                a.this.o.removeCallbacks(this.c);
            }
            if (a.this.f != null) {
                a.this.f.a(a.this.l, a.this.h, cVar);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            f fVar = this.c;
            if (fVar != null) {
                fVar.a();
                a.this.o.removeCallbacks(this.c);
            }
            a.this.a(list);
            if (a.this.f != null) {
                if (list != null && list.size() == 1) {
                    CampaignEx campaignEx = list.get(0);
                    if (!com.mbridge.msdk.foundation.same.c.a(a.this.f4667a, campaignEx) && campaignEx.getFilterAdsVideoCallState() == 0) {
                        if (a.this.a0 <= 1) {
                            com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880020, "load exception second");
                            if (cVar != null) {
                                cVar.a(a2);
                                cVar.b(true);
                            }
                            a.this.f.a(a2, cVar);
                            return;
                        }
                        a.m(a.this);
                        return;
                    }
                }
                a.this.f.c(a.this.l, a.this.h, cVar);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            f fVar = this.c;
            if (fVar != null) {
                fVar.a();
                a.this.o.removeCallbacks(this.c);
            }
            com.mbridge.msdk.reward.adapter.c cVar2 = this.f4680a;
            if (cVar2 != null) {
                cVar2.a((com.mbridge.msdk.reward.adapter.a) null);
                this.f4680a = null;
            }
            a.this.a(list);
            if (a.this.f != null) {
                a.this.f.a(bVar, cVar);
            }
        }
    }

    /* compiled from: RewardVideoController.java */
    public final class h {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<InterVideoOutListener> f4681a;
        private volatile AtomicInteger b;
        private Handler c;
        private String d;
        private boolean e;

        /* synthetic */ h(a aVar, InterVideoOutListener interVideoOutListener, Handler handler, String str, C0375a c0375a) {
            this(interVideoOutListener, handler, str);
        }

        public void c(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            Handler handler = this.c;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f4681a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.b.get() == 2 || this.c == null) {
                return;
            }
            a.m(a.this);
            this.b.set(2);
            if (a.this.O) {
                return;
            }
            a.this.O = true;
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            cVar.b(a.this.H);
            a.this.a("2000048", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putString("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.c.sendMessage(obtain);
            }
        }

        public void d(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            Handler handler = this.c;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f4681a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.b.get() == 2 || this.c == null) {
                return;
            }
            if (this.b.get() == 1) {
                this.b.set(3);
            }
            if (a.this.O) {
                return;
            }
            a.this.O = true;
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            cVar.a(true);
            cVar.b(a.this.H);
            a.this.a("2000048", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putSerializable("metrics_data_lrid", cVar.o());
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.c.sendMessage(obtain);
            }
            if (a.this.P) {
                this.b.set(2);
            }
        }

        private h(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.f4681a = new WeakReference<>(interVideoOutListener);
            this.b = new AtomicInteger(0);
            this.c = handler;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f4681a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.c == null || a.this.N) {
                return;
            }
            a.this.N = true;
            a.this.a("2000127", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
                if (cVar != null) {
                    bundle.putString("metrics_data_lrid", cVar.o());
                }
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                this.c.sendMessage(obtain);
                if (r0.a().a("l_s_i_l_v_s", false)) {
                    d(str, str2, cVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.b.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            this.b.set(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f4681a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if ((this.b.get() != 1 && this.b.get() != 3) || this.c == null || a.this.N) {
                return;
            }
            a.this.N = true;
            a.this.a("2000127", cVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                if (cVar != null) {
                    bundle.putString("metrics_data_lrid", cVar.o());
                }
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                this.c.sendMessage(obtain);
                if (r0.a().a("l_s_i_l_v_s", false)) {
                    c(str, str2, cVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f4681a;
            a.this.a("2000047", cVar, weakReference != null ? weakReference.get() : null);
            if (this.c != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                if (cVar != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", cVar.o());
                    obtain.setData(bundle);
                }
                this.c.sendMessage(obtain);
            }
        }

        public void a(com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            String str;
            com.mbridge.msdk.foundation.same.report.metrics.c cVar2;
            CampaignEx campaignEx;
            if (bVar != null && cVar != null) {
                str = bVar.g();
                cVar.a(bVar);
            } else {
                str = "";
            }
            if (a.this.b == null || a.this.a0 != 1) {
                cVar2 = cVar;
            } else {
                a.this.b.a(a.this.j);
                CopyOnWriteArrayList<CampaignEx> f = a.this.b.f();
                CampaignEx campaignEx2 = (a.this.H == null || a.this.H.size() == 0) ? null : (CampaignEx) a.this.H.get(0);
                if (campaignEx2 == null) {
                    if (f == null || f.size() == 0) {
                        campaignEx = null;
                        if (a.this.u || !((campaignEx == null || TextUtils.isEmpty(campaignEx.getNLRid())) && (f == null || f.size() == 0))) {
                            cVar2 = cVar;
                        } else {
                            cVar2 = cVar;
                            if (a.this.b.a(campaignEx, true, bVar, 2, cVar2)) {
                                return;
                            }
                        }
                        a.this.b.a((com.mbridge.msdk.reward.adapter.a) null);
                    } else {
                        campaignEx2 = f.get(0);
                    }
                }
                campaignEx = campaignEx2;
                if (a.this.u) {
                }
                cVar2 = cVar;
                a.this.b.a((com.mbridge.msdk.reward.adapter.a) null);
            }
            Handler handler = this.c;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f4681a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.b.get() == 2 || this.c == null) {
                return;
            }
            a.this.P = true;
            if (!a.this.R || str.contains("resource load timeout")) {
                a.this.Q = true;
            }
            if (a.this.O) {
                this.b.set(2);
            }
            if (a.this.P && a.this.Q && !a.this.O) {
                if (a.this.a0 > 1) {
                    a.m(a.this);
                    a.this.b.a(a.this.j);
                    return;
                }
                this.b.set(2);
                a.this.a("2000047", cVar2, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = str;
                    obtain.what = 16;
                    if (cVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", cVar2.o());
                        obtain.setData(bundle);
                    }
                    this.c.sendMessage(obtain);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            String str;
            WeakReference<InterVideoOutListener> weakReference = this.f4681a;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.b.get() == 2 || this.c == null) {
                return;
            }
            a.this.Q = true;
            if (bVar == null) {
                str = "";
            } else {
                str = bVar.g();
            }
            if (str.contains("resource load timeout")) {
                a.this.P = true;
            }
            if (a.this.Q && a.this.P && !a.this.O) {
                this.b.set(2);
                if (interVideoOutListener != null) {
                    Message obtain = Message.obtain();
                    obtain.obj = str;
                    obtain.what = 16;
                    if (cVar != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", cVar.o());
                        obtain.setData(bundle);
                    }
                    this.c.sendMessage(obtain);
                }
                if (cVar == null) {
                    cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                }
                cVar.a(true);
                a.this.a("2000047", cVar, interVideoOutListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            this.b.set(2);
            b(str, cVar);
        }

        public void a(boolean z) {
            this.e = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RewardVideoController.java */
    public final class i extends com.mbridge.msdk.video.bt.module.orglistener.b {
        private a c;
        private Handler d;
        private int e;

        /* compiled from: RewardVideoController.java */
        /* renamed from: com.mbridge.msdk.reward.controller.a$i$a, reason: collision with other inner class name */
        class RunnableC0382a implements Runnable {
            RunnableC0382a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.c != null) {
                    i.this.c.a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, a.this.t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, a.this.h, true, 1));
                }
            }
        }

        /* synthetic */ i(a aVar, a aVar2, Handler handler, C0375a c0375a) {
            this(aVar2, handler);
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void b(String str, String str2) {
            try {
                a aVar = this.c;
                if (aVar == null || aVar.e == null) {
                    return;
                }
                try {
                    this.c.e.onVideoComplete(a.this.i);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e.getMessage());
                    }
                }
                this.e = 5;
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e2.getMessage());
                }
            }
        }

        public void e() {
            a.this.B.clear();
            this.c = null;
        }

        private i(a aVar, Handler handler) {
            this.e = 0;
            this.c = aVar;
            this.d = handler;
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.E = false;
            try {
                com.mbridge.msdk.reward.candidate.a aVar = new com.mbridge.msdk.reward.candidate.a(a.this.h, a.this.t);
                a aVar2 = this.c;
                aVar.a(cVar.o(), (aVar2 == null || aVar2.b == null) ? "" : this.c.b.H, 3, a.b0);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e.getMessage());
                }
            }
            try {
                a aVar3 = this.c;
                if (aVar3 != null) {
                    aVar3.C = true;
                    if (this.c.b != null) {
                        this.c.b.H = "";
                    }
                    this.c.q();
                    if (a.this.u) {
                        a.this.a();
                    }
                    a aVar4 = a.this;
                    aVar4.a("2000130", cVar, aVar4.e, "");
                    b();
                    if (this.c.e != null) {
                        this.c.e.onAdShow(a.this.i);
                        this.e = 2;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", th.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z, com.mbridge.msdk.videocommon.entity.c cVar2) {
            try {
                a aVar = this.c;
                if (aVar != null && aVar.e != null) {
                    if (cVar2 == null) {
                        cVar2 = com.mbridge.msdk.videocommon.entity.c.a(this.c.m);
                    }
                    if (a.this.u) {
                        a.this.a();
                        a.this.v();
                        com.mbridge.msdk.foundation.same.buffer.b.d(a.this.h, a.this.m());
                    }
                    this.c.e.onAdClose(a.this.i, new RewardInfo(z, cVar2.c(), String.valueOf(cVar2.a())));
                    this.e = 7;
                    this.c.C = false;
                    e();
                }
                com.mbridge.msdk.foundation.same.report.metrics.d.b().b("2000152", cVar, null);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
            try {
                a aVar = a.this;
                aVar.E = false;
                if (this.c != null) {
                    if (aVar.u) {
                        a.this.a();
                    }
                    this.c.C = false;
                    a.this.a("2000131", cVar, this.c.e, str);
                    a();
                    if (this.c.e != null) {
                        try {
                            this.c.e.onShowFail(cVar, a.this.i, str);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                p0.b("RewardVideoController", e.getMessage());
                            }
                        }
                        this.e = 4;
                    }
                }
            } catch (Exception e2) {
                this.e = 0;
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(boolean z, String str, String str2) {
            try {
                a aVar = this.c;
                if (aVar == null || aVar.e == null) {
                    return;
                }
                if (a.this.u) {
                    a.this.a();
                }
                this.c.C = false;
                try {
                    this.c.e.onVideoAdClicked(z, a.this.i);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e.getMessage());
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(boolean z, int i) {
            try {
                a aVar = this.c;
                if (aVar == null || aVar.e == null) {
                    return;
                }
                try {
                    this.c.e.onAdCloseWithIVReward(a.this.i, new RewardInfo(z, i));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e.getMessage());
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(String str, String str2) {
            try {
                a aVar = this.c;
                if (aVar == null || aVar.e == null) {
                    return;
                }
                try {
                    this.c.e.onEndcardShow(a.this.i);
                    com.mbridge.msdk.foundation.feedback.b.b().a(str2 + "_2", 2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e.getMessage());
                    }
                }
                this.e = 6;
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
        public void a(int i, String str, String str2) {
            this.e = i;
            a aVar = this.c;
            if (aVar == null || aVar.u || this.c.t || this.c.c == null || !this.c.c.a(this.e) || this.c.f == null || this.c.f.a() == 1 || this.c.f.a() == 3 || a.this.B.contains(Integer.valueOf(this.e))) {
                return;
            }
            a.this.B.add(Integer.valueOf(this.e));
            int f = this.c.c.f() * 1000;
            if (this.e == 4) {
                f = 3000;
            }
            Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1001001);
                this.d.sendEmptyMessageDelayed(1001001, f);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0382a(), f);
            }
        }
    }

    /* compiled from: RewardVideoController.java */
    public class j {
        public j() {
        }

        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.a0++;
            a aVar = a.this;
            aVar.b(aVar.x, str, cVar);
        }
    }

    static /* synthetic */ int m(a aVar) {
        int i2 = aVar.a0;
        aVar.a0 = i2 - 1;
        return i2;
    }

    private void w() {
        com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f4667a)).b(this.h);
    }

    private void x() {
        try {
            List<CampaignEx> c2 = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f4667a)).c(this.h);
            if (c2 == null || c2.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : c2) {
                if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                } else {
                    com.mbridge.msdk.videocommon.a.e(this.h + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl());
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        com.mbridge.msdk.videocommon.a.e(this.h + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", e2.getMessage());
            }
        }
    }

    public void f(boolean z) {
        this.y = z;
    }

    public MBridgeIds g() {
        return this.i;
    }

    public List<CampaignEx> h() {
        return this.T;
    }

    public CopyOnWriteArrayList<CampaignEx> i() {
        return this.S;
    }

    public String j() {
        com.mbridge.msdk.reward.adapter.c cVar = this.b;
        return cVar != null ? cVar.g() : "";
    }

    public h k() {
        return this.f;
    }

    public String l() {
        return this.l;
    }

    public String m() {
        com.mbridge.msdk.reward.adapter.c cVar = this.b;
        return cVar != null ? cVar.a(this.C) : "";
    }

    public com.mbridge.msdk.reward.adapter.c n() {
        return this.b;
    }

    public InterVideoOutListener o() {
        return this.e;
    }

    public String p() {
        return this.h;
    }

    public void q() {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e());
    }

    public boolean r() {
        return this.u;
    }

    public boolean s() {
        return this.x;
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return (this.e == null || this.f == null) ? false : true;
    }

    public void v() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.C || (concurrentHashMap = e0) == null || concurrentHashMap.containsKey(m())) {
            return;
        }
        e0.remove(m());
    }

    private com.mbridge.msdk.foundation.same.report.metrics.c b(boolean z, String str, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        String a2;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
        try {
            b(z);
            if (TextUtils.isEmpty(str)) {
                a2 = SameMD5.getMD5(u0.d());
            } else {
                a2 = a(str);
            }
            this.A = a2;
            cVar2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(a2);
            if (cVar2 == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(a2, cVar);
                    cVar.d(true);
                    cVar2 = cVar;
                } catch (Exception e2) {
                    e = e2;
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e.getMessage());
                    }
                    return cVar;
                }
            }
            cVar2.i(a2);
            cVar2.n(this.h);
            if (eVar != null) {
                if (eVar.a("adtp")) {
                    cVar2.a(Integer.parseInt((String) eVar.b("adtp")));
                }
                if (eVar.a(CampaignEx.JSON_KEY_HB)) {
                    String str2 = (String) eVar.b(CampaignEx.JSON_KEY_HB);
                    cVar2.h(str2);
                    if (str2.equals("1")) {
                        cVar2.g(str);
                    }
                }
            }
            cVar2.f(z ? "2" : "1");
            if (z) {
                com.mbridge.msdk.reward.report.metrics.a.a().a("2000123", cVar2);
            }
            return cVar2;
        } catch (Exception e3) {
            e = e3;
            cVar = cVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() <= 0 || this.O) {
                    return;
                }
                com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).b(list, str);
            } catch (Throwable th) {
                p0.b("RewardVideoController", th.getMessage());
            }
        }
    }

    private void f() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.f4667a, this.l, this.h);
        this.b = cVar;
        cVar.d(this.t);
        this.b.e(this.u);
        if (this.t) {
            this.b.a(this.q, this.r, this.s);
        }
        this.b.a(this.c);
    }

    public void d(boolean z) {
        this.t = z;
        if (z) {
            this.p = com.mbridge.msdk.foundation.same.a.X;
        } else {
            this.p = com.mbridge.msdk.foundation.same.a.W;
        }
    }

    public void e(boolean z) {
        this.u = z;
    }

    public void e() {
        n0.b();
    }

    /* compiled from: RewardVideoController.java */
    class d implements b.n {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f4675a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ CopyOnWriteArrayList c;
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c d;
        final /* synthetic */ boolean e;
        final /* synthetic */ int f;

        d(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar, boolean z, int i) {
            this.b = campaignEx;
            this.c = copyOnWriteArrayList;
            this.d = cVar;
            this.e = z;
            this.f = i;
            this.f4675a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, String str3, String str4) {
            a.this.V = true;
            if (!a.this.U || a.this.W || a.this.o == null) {
                return;
            }
            a.this.W = true;
            a.this.o.post(new RunnableC0380a(str3, str, str2));
        }

        @Override // com.mbridge.msdk.reward.adapter.b.n
        public void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar) {
            String str3;
            if (bVar == null) {
                str3 = "";
            } else {
                str3 = bVar.e().getUnitId();
                bVar.c("errorCode: 3203 errorMessage: tpl temp resource download failed");
            }
            a aVar = a.this;
            aVar.c(str3, (List<CampaignEx>) aVar.T);
            if (this.f4675a == null) {
                this.f4675a = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.f4675a.a(bVar);
            this.f4675a.b(this.c);
            a.this.V = false;
            if (a.this.f == null || a.this.X) {
                return;
            }
            a.this.X = true;
            a.this.f.b(bVar, this.f4675a);
        }

        /* compiled from: RewardVideoController.java */
        /* renamed from: com.mbridge.msdk.reward.controller.a$d$a, reason: collision with other inner class name */
        class RunnableC0380a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4676a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            RunnableC0380a(String str, String str2, String str3) {
                this.f4676a = str;
                this.b = str2;
                this.c = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b b = com.mbridge.msdk.reward.adapter.b.b();
                boolean z = a.this.y;
                Handler handler = a.this.o;
                boolean z2 = a.this.t;
                boolean z3 = a.this.u;
                String str = this.f4676a;
                String requestIdNotice = d.this.b.getRequestIdNotice();
                String str2 = this.b;
                String str3 = this.c;
                String cMPTEntryUrl = d.this.b.getCMPTEntryUrl();
                int i = a.this.p;
                d dVar = d.this;
                b.a(z, handler, z2, z3, str, requestIdNotice, str2, str3, cMPTEntryUrl, i, dVar.b, dVar.c, H5DownLoadManager.getInstance().getH5ResAddress(d.this.b.getCMPTEntryUrl()), this.c, a.this.c, new C0381a(), true);
            }

            /* compiled from: RewardVideoController.java */
            /* renamed from: com.mbridge.msdk.reward.controller.a$d$a$a, reason: collision with other inner class name */
            class C0381a implements b.o {
                C0381a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0420a c0420a) {
                    d dVar = d.this;
                    com.mbridge.msdk.reward.adapter.c cVar = dVar.d;
                    if (cVar != null && cVar.a(dVar.c, dVar.e, dVar.f)) {
                        if (a.this.f == null || a.this.Y) {
                            return;
                        }
                        a.this.Y = true;
                        p0.a("RewardVideoController", "Cache onVideoLoadSuccess");
                        d dVar2 = d.this;
                        a.this.a(dVar2.c);
                        d dVar3 = d.this;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = dVar3.f4675a;
                        if (cVar2 != null) {
                            cVar2.b(dVar3.c);
                        }
                        a.this.f.d(str2, str3, d.this.f4675a);
                        return;
                    }
                    a aVar = a.this;
                    aVar.c(str3, (List<CampaignEx>) aVar.T);
                    if (a.this.f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                    d dVar4 = d.this;
                    if (dVar4.f4675a == null) {
                        dVar4.f4675a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    d dVar5 = d.this;
                    dVar5.f4675a.b(dVar5.c);
                    d.this.f4675a.a(a2);
                    a.this.f.b(a2, d.this.f4675a);
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0420a c0420a, com.mbridge.msdk.foundation.error.b bVar) {
                    RunnableC0380a runnableC0380a = RunnableC0380a.this;
                    a aVar = a.this;
                    aVar.c(runnableC0380a.c, (List<CampaignEx>) aVar.T);
                    if (a.this.f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    if (bVar != null) {
                        bVar.c("errorCode: 3303 errorMessage: tpl temp preload failed");
                    }
                    d dVar = d.this;
                    if (dVar.f4675a == null) {
                        dVar.f4675a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    d dVar2 = d.this;
                    dVar2.f4675a.b(dVar2.c);
                    d.this.f4675a.a(bVar);
                    a.this.f.b(bVar, d.this.f4675a);
                }
            }
        }
    }

    private boolean d() {
        if (this.b == null) {
            f();
        }
        com.mbridge.msdk.reward.adapter.c cVar = this.b;
        if (cVar != null) {
            return cVar.b(true);
        }
        return false;
    }

    public void c(String str, String str2) {
        try {
            this.f4667a = com.mbridge.msdk.foundation.controller.c.m().d();
            this.h = str2;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.l = str;
            this.i = new MBridgeIds(this.l, this.h);
            this.d = com.mbridge.msdk.videocommon.setting.b.b().c();
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new com.mbridge.msdk.reward.controller.c(this.f4667a, this.h));
            if (this.K == null) {
                this.K = com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d());
            }
        } catch (Throwable th) {
            p0.b("RewardVideoController", th.getMessage(), th);
        }
    }

    public void a(int i2) {
        this.p = i2;
    }

    public void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            x0.b(this.f4667a, "MBridge_ConfirmTitle" + this.h, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            x0.b(this.f4667a, "MBridge_ConfirmContent" + this.h, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            x0.b(this.f4667a, "MBridge_CancelText" + this.h, str4.trim());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        x0.b(this.f4667a, "MBridge_ConfirmText" + this.h, str3.trim());
    }

    private void d(String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar.n(this.h);
            cVar.a(this.t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("event_name", str);
            eVar.a("reason", str2);
            cVar.a("m_temp_is_ready_check", eVar);
            com.mbridge.msdk.reward.report.metrics.a.a().a("m_temp_is_ready_check", cVar);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: RewardVideoController.java */
    class b implements b.h {

        /* renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.metrics.c f4669a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ boolean c;
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c d;
        final /* synthetic */ int e;

        b(CampaignEx campaignEx, boolean z, com.mbridge.msdk.reward.adapter.c cVar, int i) {
            this.b = campaignEx;
            this.c = z;
            this.d = cVar;
            this.e = i;
            this.f4669a = com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.h
        public void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            a.this.U = true;
            if (this.c) {
                if (!a.this.V || a.this.W || a.this.o == null) {
                    return;
                }
                a.this.W = true;
                a.this.o.post(new RunnableC0378b(str3, str, str2, copyOnWriteArrayList));
                return;
            }
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.o == null) {
                    com.mbridge.msdk.reward.adapter.c cVar = this.d;
                    if (cVar == null || !cVar.a(copyOnWriteArrayList, this.c, this.e)) {
                        a aVar = a.this;
                        aVar.c(str2, (List<CampaignEx>) aVar.T);
                        if (a.this.f != null && !a.this.X) {
                            a.this.X = true;
                            com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                            if (this.f4669a == null) {
                                this.f4669a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                            }
                            this.f4669a.b(a.this.S);
                            this.f4669a.a(a2);
                            a.this.f.b(a2, this.f4669a);
                        }
                    } else if (a.this.f != null && !a.this.Y) {
                        a.this.Y = true;
                        p0.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                        a.this.a(copyOnWriteArrayList);
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = this.f4669a;
                        if (cVar2 != null) {
                            cVar2.b(copyOnWriteArrayList);
                        }
                        a.this.f.d(str, str2, this.f4669a);
                    }
                } else {
                    a.this.o.post(new RunnableC0376a(next, copyOnWriteArrayList, str, str2, str3));
                }
            }
        }

        /* compiled from: RewardVideoController.java */
        /* renamed from: com.mbridge.msdk.reward.controller.a$b$a, reason: collision with other inner class name */
        class RunnableC0376a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignEx f4670a;
            final /* synthetic */ CopyOnWriteArrayList b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;

            RunnableC0376a(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, String str, String str2, String str3) {
                this.f4670a = campaignEx;
                this.b = copyOnWriteArrayList;
                this.c = str;
                this.d = str2;
                this.e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b.b().a(a.this.y, a.this.o, a.this.t, a.this.u, null, this.f4670a.getRewardTemplateMode().e(), a.this.p, b.this.b, this.b, H5DownLoadManager.getInstance().getH5ResAddress(this.f4670a.getRewardTemplateMode().e()), this.c, this.d, this.e, this.f4670a.getRequestIdNotice(), a.this.c, new C0377a());
            }

            /* compiled from: RewardVideoController.java */
            /* renamed from: com.mbridge.msdk.reward.controller.a$b$a$a, reason: collision with other inner class name */
            class C0377a implements b.o {
                C0377a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0420a c0420a) {
                    RunnableC0376a runnableC0376a = RunnableC0376a.this;
                    b bVar = b.this;
                    com.mbridge.msdk.reward.adapter.c cVar = bVar.d;
                    if (cVar != null && cVar.a(runnableC0376a.b, bVar.c, bVar.e)) {
                        if (a.this.f == null || a.this.Y) {
                            return;
                        }
                        a.this.Y = true;
                        RunnableC0376a runnableC0376a2 = RunnableC0376a.this;
                        a.this.a(runnableC0376a2.b);
                        a.this.f.d(str2, str3, b.this.f4669a);
                        return;
                    }
                    a aVar = a.this;
                    aVar.c(str3, (List<CampaignEx>) aVar.T);
                    if (a.this.f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                    b bVar2 = b.this;
                    if (bVar2.f4669a == null) {
                        bVar2.f4669a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    RunnableC0376a runnableC0376a3 = RunnableC0376a.this;
                    b.this.f4669a.b(runnableC0376a3.b);
                    b.this.f4669a.a(a2);
                    a.this.f.b(a2, b.this.f4669a);
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0420a c0420a, com.mbridge.msdk.foundation.error.b bVar) {
                    RunnableC0376a runnableC0376a = RunnableC0376a.this;
                    a aVar = a.this;
                    aVar.c(runnableC0376a.d, (List<CampaignEx>) aVar.T);
                    if (a.this.f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    bVar.c("errorCode: 3301 errorMessage: temp preload failed");
                    b bVar2 = b.this;
                    if (bVar2.f4669a == null) {
                        bVar2.f4669a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    b bVar3 = b.this;
                    bVar3.f4669a.b(a.this.S);
                    b.this.f4669a.a(bVar);
                    a.this.f.b(bVar, b.this.f4669a);
                }
            }
        }

        /* compiled from: RewardVideoController.java */
        /* renamed from: com.mbridge.msdk.reward.controller.a$b$b, reason: collision with other inner class name */
        class RunnableC0378b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4672a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ CopyOnWriteArrayList d;

            RunnableC0378b(String str, String str2, String str3, CopyOnWriteArrayList copyOnWriteArrayList) {
                this.f4672a = str;
                this.b = str2;
                this.c = str3;
                this.d = copyOnWriteArrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.reward.adapter.b.b().a(a.this.y, a.this.o, a.this.t, a.this.u, this.f4672a, b.this.b.getRequestIdNotice(), this.b, this.c, b.this.b.getCMPTEntryUrl(), a.this.p, b.this.b, this.d, H5DownLoadManager.getInstance().getH5ResAddress(b.this.b.getCMPTEntryUrl()), this.c, a.this.c, new C0379a(), true);
            }

            /* compiled from: RewardVideoController.java */
            /* renamed from: com.mbridge.msdk.reward.controller.a$b$b$a, reason: collision with other inner class name */
            class C0379a implements b.o {
                C0379a() {
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, String str4, String str5, a.C0420a c0420a) {
                    RunnableC0378b runnableC0378b = RunnableC0378b.this;
                    b bVar = b.this;
                    com.mbridge.msdk.reward.adapter.c cVar = bVar.d;
                    if (cVar != null && cVar.a(runnableC0378b.d, bVar.c, bVar.e)) {
                        if (a.this.f == null || a.this.Y) {
                            return;
                        }
                        a.this.Y = true;
                        p0.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                        RunnableC0378b runnableC0378b2 = RunnableC0378b.this;
                        a.this.a(runnableC0378b2.d);
                        RunnableC0378b runnableC0378b3 = RunnableC0378b.this;
                        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = b.this.f4669a;
                        if (cVar2 != null) {
                            cVar2.b(runnableC0378b3.d);
                        }
                        a.this.f.d(str2, str3, b.this.f4669a);
                        return;
                    }
                    a aVar = a.this;
                    aVar.c(str3, (List<CampaignEx>) aVar.T);
                    if (a.this.f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880015, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                    b bVar2 = b.this;
                    if (bVar2.f4669a == null) {
                        bVar2.f4669a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    b.this.f4669a.a(a2);
                    RunnableC0378b runnableC0378b4 = RunnableC0378b.this;
                    b.this.f4669a.b(runnableC0378b4.d);
                    a.this.f.b(a2, b.this.f4669a);
                }

                @Override // com.mbridge.msdk.reward.adapter.b.o
                public void a(String str, String str2, String str3, a.C0420a c0420a, com.mbridge.msdk.foundation.error.b bVar) {
                    RunnableC0378b runnableC0378b = RunnableC0378b.this;
                    a aVar = a.this;
                    aVar.c(runnableC0378b.c, (List<CampaignEx>) aVar.T);
                    if (a.this.f == null || a.this.X) {
                        return;
                    }
                    a.this.X = true;
                    if (bVar != null) {
                        bVar.c("errorCode: 3302 errorMessage: tpl preload failed");
                    }
                    b bVar2 = b.this;
                    if (bVar2.f4669a == null) {
                        bVar2.f4669a = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    RunnableC0378b runnableC0378b2 = RunnableC0378b.this;
                    b.this.f4669a.b(runnableC0378b2.d);
                    b.this.f4669a.a(bVar);
                    a.this.f.b(bVar, b.this.f4669a);
                }
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.h
        public void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.error.b bVar) {
            a.this.U = false;
            a aVar = a.this;
            aVar.c(aVar.h, (List<CampaignEx>) a.this.T);
            if (a.this.f == null || a.this.X) {
                return;
            }
            a.this.X = true;
            if (this.f4669a == null) {
                this.f4669a = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            this.f4669a.b(copyOnWriteArrayList);
            if (bVar != null) {
                bVar.c("errorCode: 3201 errorMessage: campaign resource download failed");
            }
            this.f4669a.a(bVar);
            a.this.f.b(bVar, this.f4669a);
        }
    }

    public void a(int i2, int i3, int i4) {
        this.q = i2;
        this.r = i3;
        if (i3 == com.mbridge.msdk.foundation.same.a.K) {
            this.s = i4 < 0 ? 5 : i4;
        }
        if (i3 == com.mbridge.msdk.foundation.same.a.J) {
            this.s = i4 < 0 ? 80 : i4;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i2 == com.mbridge.msdk.foundation.same.a.H ? 0 : 1);
            jSONObject.put("ivRewardPlayValueMode", i3 == com.mbridge.msdk.foundation.same.a.J ? 0 : 1);
            jSONObject.put("ivRewardPlayValue", i4);
            com.mbridge.msdk.setting.h.b().i(this.h, jSONObject.toString());
        } catch (Exception unused) {
            p0.b("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public boolean c(boolean z) {
        try {
            if (c()) {
                if (z) {
                    d("is_ready_start", "over cap check error");
                    com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a("type", 10);
                    cVar.a("m_offer_ready", eVar);
                    a(false, cVar, (List<CampaignEx>) this.b.h());
                }
            } else if (this.u) {
                try {
                    return a(z);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e2.getMessage());
                    }
                }
            } else {
                return d();
            }
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", th.getMessage());
            }
        }
        return false;
    }

    public static void a(String str, int i2) {
        try {
            if (d0 == null || !z0.b(str)) {
                return;
            }
            d0.put(str, Integer.valueOf(i2));
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", e2.getMessage());
            }
        }
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (concurrentHashMap = e0) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        e0.put(str, str2);
    }

    private boolean c() {
        try {
            if (this.K == null) {
                this.K = com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d());
            }
            com.mbridge.msdk.foundation.db.h a2 = com.mbridge.msdk.foundation.db.h.a(this.K);
            if (this.c == null) {
                this.c = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.h, this.t);
            }
            int k = this.c.k();
            if (a2 != null) {
                return a2.a(this.h, k);
            }
            return false;
        } catch (Throwable unused) {
            p0.b("RewardVideoController", "cap check error");
            return false;
        }
    }

    private void b(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f != null) {
            String b2 = com.mbridge.msdk.foundation.error.a.b(880001, "");
            com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880001, "");
            if (cVar != null) {
                cVar.a(a2);
                cVar.b(true);
            }
            this.f.a(b2, cVar);
        }
    }

    public void a() {
        try {
            String str = "";
            MBridgeIds mBridgeIds = this.i;
            if (mBridgeIds != null) {
                if (!this.C) {
                    mBridgeIds.setBidToken("");
                    return;
                }
                String m = m();
                if (TextUtils.isEmpty(m)) {
                    return;
                }
                ConcurrentHashMap<String, String> concurrentHashMap = e0;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(m) && !TextUtils.isEmpty(e0.get(m))) {
                    str = e0.get(m);
                }
                this.i.setBidToken(str);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private CopyOnWriteArrayList<CampaignEx> b(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int i2 = 1;
                    for (CampaignEx campaignEx : list) {
                        if (campaignEx != null) {
                            if (campaignEx.getVcn() > i2) {
                                i2 = campaignEx.getVcn();
                            }
                            if (campaignEx.getTokenRule() == 1) {
                                String requestId = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        List list2 = (List) linkedHashMap.get(requestId);
                                        if (list2 != null) {
                                            list2.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(campaignEx);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        List list3 = (List) linkedHashMap2.get(requestId2);
                                        if (list3 != null) {
                                            list3.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(campaignEx);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (linkedHashMap2.size() + linkedHashMap.size() >= i2 && linkedHashMap.size() > 0 && linkedHashMap.entrySet() != null && linkedHashMap.entrySet().iterator() != null && linkedHashMap.entrySet().iterator().next() != null && ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() != null) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.buffer.b.a(this.h, str, i2);
                        return copyOnWriteArrayList;
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e2.getMessage());
                }
            }
        }
        return copyOnWriteArrayList;
    }

    public void a(InterVideoOutListener interVideoOutListener) {
        this.e = interVideoOutListener;
        this.f = new h(this, interVideoOutListener, this.o, this.h, null);
    }

    public void a(boolean z, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        a(z, "", eVar);
    }

    public void a(boolean z, String str, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        a aVar;
        com.mbridge.msdk.foundation.same.report.metrics.c b2 = b(z, str, eVar);
        this.z = str;
        if (this.f == null) {
            aVar = this;
            aVar.f = new h(aVar, null, this.o, this.h, null);
        } else {
            aVar = this;
        }
        if (aVar.f != null && aVar.f.a() == 1) {
            a(z, b2);
            return;
        }
        aVar.a0 = 1;
        if (aVar.f != null && aVar.f.a() == 3) {
            aVar.L = false;
        } else {
            aVar.L = true;
            if (aVar.f != null) {
                aVar.f.a(1);
            }
        }
        aVar.x = z;
        aVar.o.removeMessages(1001001);
        aVar.O = false;
        aVar.N = false;
        aVar.P = false;
        aVar.Q = false;
        x();
        w();
        com.mbridge.msdk.reward.adapter.b.b().c();
        try {
            if (TextUtils.isEmpty(str)) {
                if (aVar.t) {
                    com.mbridge.msdk.timer.b.getInstance().addInterstitialList(aVar.l, aVar.h);
                } else {
                    com.mbridge.msdk.timer.b.getInstance().addRewardList(aVar.l, aVar.h);
                }
            }
            if (aVar.u && TextUtils.isEmpty(str)) {
                a(b2);
                return;
            }
            if (com.mbridge.msdk.system.a.map == null) {
                b(b2);
                return;
            }
            com.mbridge.msdk.videocommon.setting.c c2 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), aVar.h);
            aVar.c = c2;
            if (c2 == null) {
                aVar.J = com.mbridge.msdk.foundation.controller.c.m().b();
                com.mbridge.msdk.videocommon.setting.b.b().a(aVar.J, com.mbridge.msdk.foundation.controller.c.m().c(), aVar.h, new C0375a());
                aVar.c = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), aVar.h, aVar.t);
            }
            if (!TextUtils.isEmpty(aVar.l)) {
                aVar.c.f(aVar.l);
            }
            int n = aVar.c.n() * 1000;
            if (aVar.o != null) {
                Message obtain = Message.obtain();
                obtain.what = 1001002;
                if (b2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", b2.o());
                    obtain.setData(bundle);
                }
                aVar.o.sendMessageDelayed(obtain, n);
            }
            aVar.I = aVar.c.z();
            try {
                a(z, str, b2);
            } catch (Exception e2) {
                if (aVar.f != null) {
                    com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880020, "load exception");
                    if (b2 != null) {
                        b2.a(a2);
                        b2.b(true);
                    }
                    aVar.f.a(a2, b2);
                }
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e2.getMessage());
                }
            }
        } catch (Exception e3) {
            if (aVar.f != null) {
                com.mbridge.msdk.foundation.error.b a3 = com.mbridge.msdk.foundation.error.a.a(880001, "");
                if (b2 != null) {
                    b2.a(a3);
                    b2.b(true);
                }
                aVar.f.a(a3, b2);
            }
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", e3.getMessage());
            }
        }
    }

    private boolean b(String str, String str2) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.b;
            if (cVar == null || !str.equals(cVar.j())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.f4667a, this.l, str);
                this.b = cVar2;
                cVar2.d(this.t);
                this.b.e(this.u);
            }
            this.b.a(this.p);
            this.b.a(this.c);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", e2.getMessage());
            }
        }
        List<CampaignEx> b2 = com.mbridge.msdk.videocommon.cache.a.a().b(str, 1, this.u);
        this.T = com.mbridge.msdk.videocommon.cache.a.a().a(str, 1, this.u);
        if (b2 != null && b2.size() > 0) {
            com.mbridge.msdk.videocommon.cache.a.a().a(str, b2, str2);
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.S;
            if (copyOnWriteArrayList == null) {
                this.S = new CopyOnWriteArrayList<>();
            } else {
                copyOnWriteArrayList.clear();
            }
            for (CampaignEx campaignEx : b2) {
                campaignEx.setLocalRequestId(str2);
                this.S.add(campaignEx);
            }
            a(this.S);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.S;
        if (copyOnWriteArrayList2 == null) {
            return false;
        }
        copyOnWriteArrayList2.clear();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x003c, code lost:
    
        if (r8.h.equals(r0.j()) == false) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        Exception exc;
        f fVar;
        com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(cVar);
        String str2 = a2.o() + "label_second";
        a2.i(str2);
        com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(str2, a2);
        try {
            com.mbridge.msdk.reward.adapter.c cVar2 = this.b;
            if (cVar2 != null) {
                try {
                } catch (Exception e2) {
                    exc = e2;
                    com.mbridge.msdk.foundation.error.b a3 = com.mbridge.msdk.foundation.error.a.a(880020, exc.getMessage());
                    a2.a(a3);
                    a2.b(true);
                    a(a3, a2);
                    if (MBridgeConstans.DEBUG) {
                        return;
                    }
                    p0.b("RewardVideoController", exc.getMessage());
                    return;
                }
            }
            com.mbridge.msdk.reward.adapter.c cVar3 = new com.mbridge.msdk.reward.adapter.c(this.f4667a, this.l, this.h);
            this.b = cVar3;
            cVar3.d(this.t);
            this.b.e(this.u);
            if (this.t) {
                this.b.a(this.q, this.r, this.s);
            }
            if (a2.j() != null && !a2.j().isEmpty()) {
                this.Z.put(a2.j().get(0).getId());
            }
            this.b.a(this.p);
            this.b.a(this.c);
            try {
                fVar = new f(this.b, this.G, z, str, a2);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
        try {
            fVar.a(this.F);
            this.j.a(fVar);
            this.b.a(this.j);
            this.b.a(1, this.Z.toString());
            this.b.a(this.G, this.F, z, str, this.y, a2);
            this.o.postDelayed(fVar, this.F * 1000);
        } catch (Exception e5) {
            e = e5;
            exc = e;
            com.mbridge.msdk.foundation.error.b a32 = com.mbridge.msdk.foundation.error.a.a(880020, exc.getMessage());
            a2.a(a32);
            a2.b(true);
            a(a32, a2);
            if (MBridgeConstans.DEBUG) {
            }
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f != null) {
            com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880035, "");
            if (cVar != null) {
                cVar.a(a2);
                cVar.b(true);
            }
            this.f.a("bidToken is empty", cVar);
        }
    }

    private boolean b() {
        if (this.b == null) {
            f();
        }
        List<com.mbridge.msdk.foundation.entity.c> a2 = com.mbridge.msdk.videocommon.cache.a.a().a(this.h);
        if (a2 == null || a2.size() <= 0) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar : a2) {
            if (cVar != null) {
                this.b.c(cVar.a());
                this.b.b(cVar.d());
                if (this.b.m()) {
                    return true;
                }
                com.mbridge.msdk.videocommon.cache.a.a().d(this.h, cVar.a());
            }
        }
        return false;
    }

    private void a(boolean z, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (!this.x) {
            if (z) {
                this.x = z;
            }
        } else if (z) {
            String b2 = com.mbridge.msdk.foundation.error.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading");
            com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880016, "errorCode: 3501 errorMessage: current unit is loading");
            if (cVar != null) {
                cVar.a(a2);
                cVar.b(true);
            }
            this.f.b(b2, cVar);
        }
    }

    private void b(boolean z) {
        List<String> e2;
        if (z) {
            try {
                com.mbridge.msdk.foundation.db.e a2 = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(this.f4667a));
                if (a2 != null && (e2 = a2.e(this.h)) != null && e2.size() > 0) {
                    Iterator<String> it = e2.iterator();
                    while (it.hasNext()) {
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().d(it.next());
                    }
                }
                LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.metrics.c> c2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().c();
                if (c2 == null || c2.size() <= 0) {
                    return;
                }
                Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c>> it2 = c2.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c> next = it2.next();
                    if (next != null && next.getValue().z()) {
                        it2.remove();
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private void a(boolean z, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        com.mbridge.msdk.reward.candidate.a aVar;
        com.mbridge.msdk.foundation.cache.c cVar2;
        String str2 = str;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar3 = cVar;
        if (this.f != null) {
            if (!this.u) {
                this.R = b(this.h, cVar3.o());
                if (this.R) {
                    if (!c()) {
                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.S;
                        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                            return;
                        }
                        try {
                            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                            eVar.a("cache", 1);
                            cVar3.a("2000127", eVar);
                            cVar3.a("2000048", eVar);
                            cVar3.a(copyOnWriteArrayList);
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                p0.b("RewardVideoController", e2.getMessage());
                            }
                        }
                        this.f.b(this.l, this.h, cVar3);
                        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
                        this.f.a(this.u);
                        com.mbridge.msdk.reward.adapter.c cVar4 = this.b;
                        if (cVar4 != null && cVar4.a(copyOnWriteArrayList, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                            a(copyOnWriteArrayList);
                            this.f.d(this.l, this.h, cVar3);
                        } else {
                            a(copyOnWriteArrayList, this.b);
                        }
                        if (this.L) {
                            com.mbridge.msdk.reward.adapter.c cVar5 = this.b;
                            if (cVar5 != null) {
                                cVar5.c(this.S);
                            }
                            a(this.I, z, str2, cVar3);
                            return;
                        }
                        return;
                    }
                    p0.a("RewardVideoController", "非BID，本地存在可用的缓存，超过上限");
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.S;
                    if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
                        Iterator<CampaignEx> it = this.S.iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.cache.a.a().a(it.next(), this.h);
                        }
                    }
                    com.mbridge.msdk.reward.adapter.c cVar6 = this.b;
                    if (cVar6 != null) {
                        cVar6.c(this.S);
                    }
                    if (z) {
                        if (this.f != null) {
                            String b2 = com.mbridge.msdk.foundation.error.a.b(880019, "");
                            cVar3.a(com.mbridge.msdk.foundation.error.a.a(880019, ""));
                            cVar3.b(true);
                            this.f.a(b2, cVar3);
                            return;
                        }
                        return;
                    }
                    this.R = false;
                    this.f.a(this.u);
                    a(this.I, z, str2, cVar3);
                    return;
                }
                if (!c()) {
                    this.R = false;
                    com.mbridge.msdk.reward.adapter.c cVar7 = this.b;
                    if (cVar7 != null) {
                        cVar7.c(this.S);
                    }
                    this.f.a(this.u);
                    a(this.I, z, str2, cVar3);
                    return;
                }
                if (z) {
                    if (this.f != null) {
                        String b3 = com.mbridge.msdk.foundation.error.a.b(880019, "");
                        cVar3.a(com.mbridge.msdk.foundation.error.a.a(880019, ""));
                        cVar3.b(true);
                        this.f.a(b3, cVar3);
                        return;
                    }
                    return;
                }
                this.R = false;
                com.mbridge.msdk.reward.adapter.c cVar8 = this.b;
                if (cVar8 != null) {
                    cVar8.c(this.S);
                }
                this.f.a(this.u);
                a(this.I, z, str2, cVar3);
                return;
            }
            List<CampaignEx> b4 = com.mbridge.msdk.videocommon.cache.a.a().b(this.h, 1, this.u, "");
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = null;
            if (b4 != null && b4.size() > 0) {
                if (!c()) {
                    if (this.b == null) {
                        f();
                    }
                    CopyOnWriteArrayList<CampaignEx> a2 = a(str2, b4);
                    if (a2 != null && a2.size() > 0) {
                        a(a2, str2, cVar3);
                        return;
                    }
                    try {
                        com.mbridge.msdk.reward.candidate.a aVar2 = new com.mbridge.msdk.reward.candidate.a(this.h, this.t);
                        com.mbridge.msdk.foundation.cache.c cVar9 = new com.mbridge.msdk.foundation.cache.c();
                        try {
                            if (aVar2.a(str2)) {
                                cVar9 = aVar2.a(str2, cVar3, (CampaignEx) null, new com.mbridge.msdk.foundation.error.b(880038), 1, this.b);
                                if (cVar9 != null && cVar9.g() == com.mbridge.msdk.foundation.cache.c.l && cVar9.c() != null && cVar9.c().size() > 0 && this.b != null) {
                                    CopyOnWriteArrayList<CampaignEx> c2 = cVar9.c();
                                    ArrayList arrayList = new ArrayList();
                                    Iterator<CampaignEx> it2 = b4.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        CampaignEx next = it2.next();
                                        if (next != null) {
                                            String requestId = next.getRequestId();
                                            if (!TextUtils.isEmpty(requestId)) {
                                                for (int i2 = 0; i2 < c2.size(); i2++) {
                                                    CampaignEx campaignEx2 = c2.get(i2);
                                                    if (campaignEx2 != null) {
                                                        if (requestId.equals(campaignEx2.getRequestId())) {
                                                            break;
                                                        } else if (i2 == c2.size() - 1) {
                                                            arrayList.add(next);
                                                        }
                                                    }
                                                }
                                                if (c2.size() == 0) {
                                                    arrayList.add(next);
                                                }
                                            }
                                        }
                                    }
                                    this.b.c(arrayList);
                                    this.b.a(cVar9.c(), false, true, true);
                                    copyOnWriteArrayList3 = new CopyOnWriteArrayList<>(cVar9.c());
                                }
                            } else {
                                copyOnWriteArrayList3 = b(str2, b4);
                                if (copyOnWriteArrayList3.size() > 0) {
                                    com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str2, copyOnWriteArrayList3);
                                }
                                cVar9.d("cb is closed");
                                cVar9.a(com.mbridge.msdk.foundation.cache.c.k);
                            }
                            try {
                                aVar2.a(cVar, str2, cVar9, (List<a.b>) null, (JSONObject) null, 1);
                                cVar3 = cVar;
                                str2 = str2;
                                if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                                    a(copyOnWriteArrayList3, str2, cVar3);
                                    if (this.b != null && !aVar2.a(str2)) {
                                        this.b.c(copyOnWriteArrayList3);
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                cVar3 = cVar;
                                str2 = str2;
                                if (MBridgeConstans.DEBUG) {
                                    p0.b("RewardVideoController", e.getMessage());
                                }
                                this.R = false;
                                this.f.a(this.u);
                                a(this.I, z, str2, cVar3);
                                return;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            cVar3 = cVar;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                    this.R = false;
                    this.f.a(this.u);
                    a(this.I, z, str2, cVar3);
                    return;
                }
                com.mbridge.msdk.videocommon.cache.a.a().b(this.h, str2);
                if (!z || this.f == null) {
                    return;
                }
                String b5 = com.mbridge.msdk.foundation.error.a.b(880019, "");
                com.mbridge.msdk.foundation.error.b a3 = com.mbridge.msdk.foundation.error.a.a(880019, "");
                if (cVar3 != null) {
                    cVar3.a(a3);
                    cVar3.b(true);
                }
                this.f.a(b5, cVar3);
                return;
            }
            if (!c()) {
                try {
                    aVar = new com.mbridge.msdk.reward.candidate.a(this.h, this.t);
                    cVar2 = new com.mbridge.msdk.foundation.cache.c();
                    try {
                        if (aVar.a(str2)) {
                            if (this.b == null) {
                                com.mbridge.msdk.reward.adapter.c cVar10 = new com.mbridge.msdk.reward.adapter.c(this.f4667a, this.l, this.h);
                                this.b = cVar10;
                                cVar10.d(this.t);
                                this.b.e(this.u);
                                if (this.t) {
                                    this.b.a(this.q, this.r, this.s);
                                }
                                this.b.a(this.p);
                                this.b.a(this.c);
                            }
                            cVar2 = aVar.a(str2, cVar3, (CampaignEx) null, new com.mbridge.msdk.foundation.error.b(880038), 1, this.b);
                            if (cVar2 != null && cVar2.g() == com.mbridge.msdk.foundation.cache.c.l && cVar2.c() != null && cVar2.c().size() > 0 && this.b != null) {
                                CopyOnWriteArrayList<CampaignEx> c3 = cVar2.c();
                                if (b4 != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator<CampaignEx> it3 = b4.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            break;
                                        }
                                        CampaignEx next2 = it3.next();
                                        if (next2 != null) {
                                            String requestId2 = next2.getRequestId();
                                            if (!TextUtils.isEmpty(requestId2)) {
                                                for (int i3 = 0; i3 < c3.size(); i3++) {
                                                    CampaignEx campaignEx3 = c3.get(i3);
                                                    if (campaignEx3 != null) {
                                                        if (requestId2.equals(campaignEx3.getRequestId())) {
                                                            break;
                                                        } else if (i3 == c3.size() - 1) {
                                                            arrayList2.add(next2);
                                                        }
                                                    }
                                                }
                                                if (c3.size() == 0) {
                                                    arrayList2.add(next2);
                                                }
                                            }
                                        }
                                    }
                                    this.b.c(arrayList2);
                                }
                                this.b.a(cVar2.c(), false, true, true);
                                copyOnWriteArrayList3 = new CopyOnWriteArrayList<>(cVar2.c());
                            }
                        } else {
                            copyOnWriteArrayList3 = b(str2, b4);
                            if (copyOnWriteArrayList3.size() > 0) {
                                com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(str2, copyOnWriteArrayList3);
                            }
                            cVar2.d("cb is closed 2");
                            cVar2.a(com.mbridge.msdk.foundation.cache.c.k);
                        }
                    } catch (Exception e6) {
                        e = e6;
                        cVar3 = cVar;
                    }
                } catch (Exception e7) {
                    e = e7;
                }
                try {
                    aVar.a(cVar, str2, cVar2, (List<a.b>) null, (JSONObject) null, 1);
                    cVar3 = cVar;
                    str2 = str2;
                    if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                        a(copyOnWriteArrayList3, str2, cVar3);
                        if (this.b != null && !aVar.a(str2)) {
                            this.b.c(copyOnWriteArrayList3);
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    cVar3 = cVar;
                    str2 = str2;
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e.getMessage());
                    }
                    this.R = false;
                    this.f.a(this.u);
                    a(this.I, z, str2, cVar3);
                    return;
                }
                this.R = false;
                this.f.a(this.u);
                a(this.I, z, str2, cVar3);
                return;
            }
            com.mbridge.msdk.videocommon.cache.a.a().b(this.h, str2);
            if (!z || this.f == null) {
                return;
            }
            String b6 = com.mbridge.msdk.foundation.error.a.b(880019, "");
            com.mbridge.msdk.foundation.error.b a4 = com.mbridge.msdk.foundation.error.a.a(880019, "");
            if (cVar3 != null) {
                cVar3.a(a4);
                cVar3.b(true);
            }
            this.f.a(b6, cVar3);
        }
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("cache", 1);
            cVar.a("2000127", eVar);
            cVar.a("2000048", eVar);
            cVar.a(copyOnWriteArrayList);
        } catch (Exception e2) {
            p0.b("RewardVideoController", e2.getMessage());
        }
        this.R = true;
        this.f.a(this.u);
        this.f.b(this.l, this.h, cVar);
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        a(campaignEx.getRequestId(), str);
        com.mbridge.msdk.reward.adapter.c cVar2 = this.b;
        if (cVar2 != null && cVar2.a(copyOnWriteArrayList, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
            a(copyOnWriteArrayList);
            this.f.d(this.l, this.h, cVar);
        } else {
            a(copyOnWriteArrayList, this.b);
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (CampaignEx campaignEx : list) {
                if (campaignEx != null && str.equals(campaignEx.getBidToken())) {
                    copyOnWriteArrayList.add(campaignEx);
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        boolean isEmpty = TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        boolean z = !isEmpty;
        int nscpt = campaignEx.getNscpt();
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        com.mbridge.msdk.reward.adapter.b.b().a(this.f4667a, z, nscpt, this.u, this.t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94, this.l, this.h, campaignEx.getRequestId(), copyOnWriteArrayList, new b(campaignEx, z, cVar, nscpt), new c(campaignEx, copyOnWriteArrayList, z, nscpt));
        if (isEmpty) {
            return;
        }
        com.mbridge.msdk.reward.adapter.b.b().a(this.f4667a, campaignEx, this.l, this.h, campaignEx.getRequestId(), new d(campaignEx, copyOnWriteArrayList, cVar, z, nscpt));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Queue<Integer> queue, boolean z, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar2;
        Exception exc;
        Integer poll;
        try {
            this.F = 25;
            this.G = 1;
            if (queue != null) {
                try {
                    if (queue.size() > 0 && (poll = queue.poll()) != null) {
                        this.F = poll.intValue();
                    }
                } catch (Exception e2) {
                    exc = e2;
                    cVar2 = cVar;
                    com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880020, "load mv api error:" + exc.getMessage());
                    if (cVar2 != null) {
                    }
                    a(a2, cVar2);
                    if (MBridgeConstans.DEBUG) {
                    }
                }
            }
            try {
                cVar2 = cVar;
            } catch (Exception e3) {
                e = e3;
                cVar2 = cVar;
            }
            try {
                a(this.G, this.F, z, str, cVar2);
            } catch (Exception e4) {
                e = e4;
                Exception exc2 = e;
                try {
                    com.mbridge.msdk.foundation.error.b a3 = com.mbridge.msdk.foundation.error.a.a(880020, "load mv api error:" + exc2.getMessage());
                    if (cVar2 != null) {
                        cVar2.a(a3);
                        cVar2.b(true);
                    }
                    a(a3, cVar2);
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", exc2.getMessage());
                    }
                } catch (Exception e5) {
                    e = e5;
                    exc = e;
                    com.mbridge.msdk.foundation.error.b a22 = com.mbridge.msdk.foundation.error.a.a(880020, "load mv api error:" + exc.getMessage());
                    if (cVar2 != null) {
                        cVar2.a(a22);
                        cVar2.b(true);
                    }
                    a(a22, cVar2);
                    if (MBridgeConstans.DEBUG) {
                        return;
                    }
                    p0.b("RewardVideoController", exc.getMessage());
                }
            }
        } catch (Exception e6) {
            e = e6;
            cVar2 = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        if (this.f != null) {
            this.Q = true;
            this.f.a(bVar, cVar);
        }
    }

    public void a(int i2, int i3, boolean z, String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar2 = this.b;
            if (cVar2 == null || !this.h.equals(cVar2.j())) {
                com.mbridge.msdk.reward.adapter.c cVar3 = new com.mbridge.msdk.reward.adapter.c(this.f4667a, this.l, this.h);
                this.b = cVar3;
                cVar3.d(this.t);
                this.b.e(this.u);
            }
            if (this.t) {
                this.b.a(this.q, this.r, this.s);
            }
            this.H = new ArrayList();
            this.b.a(this.p);
            this.b.a(this.c);
            f fVar = new f(this.b, i2, z, str, cVar);
            fVar.a(i3);
            g gVar = new g(this.b, z);
            this.j = gVar;
            gVar.a(fVar);
            this.b.a(this.j);
            this.b.a(0, "");
            this.b.a(new j());
            this.b.a(i2, i3, z, str, this.y, cVar);
            this.o.postDelayed(fVar, i3 * 1000);
        } catch (Exception e2) {
            com.mbridge.msdk.foundation.error.b a2 = com.mbridge.msdk.foundation.error.a.a(880020, e2.getMessage());
            if (cVar != null) {
                cVar.a(a2);
                cVar.b(true);
            }
            a(a2, cVar);
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", e2.getMessage());
            }
        }
    }

    private void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        com.mbridge.msdk.videocommon.setting.c cVar2;
        com.mbridge.msdk.videocommon.setting.c cVar3;
        boolean l;
        boolean m;
        try {
            if (this.b == null) {
                f();
            }
            if (this.b != null) {
                p0.b("RewardVideoController", "controller 819");
                if (this.u) {
                    l = a(false);
                } else {
                    l = this.b.l();
                }
                C0375a c0375a = null;
                if (l) {
                    p0.c("RewardVideoController", "invoke adapter show isReady");
                    i iVar = new i(this, this, this.o, c0375a);
                    f0.put(this.h, iVar);
                    this.b.a(iVar, str, this.g, this.p, this.k, cVar);
                    this.E = false;
                    return;
                }
                if (this.u) {
                    m = b();
                } else {
                    m = this.b.m();
                }
                if (m) {
                    p0.c("RewardVideoController", "invoke adapter show isSpareOfferReady");
                    i iVar2 = new i(this, this, this.o, c0375a);
                    f0.put(this.h, iVar2);
                    this.b.a(iVar2, str, this.g, this.p, this.k, cVar);
                    this.E = false;
                    return;
                }
            }
            this.E = false;
            a("2000131", cVar, this.e, "can't show because load is failed");
            if (this.e != null) {
                try {
                    this.e.onShowFail(cVar, this.i, "can't show because load is failed");
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e2.getMessage());
                    }
                }
            }
            if (this.t || this.u || (cVar3 = this.c) == null || !cVar3.a(4) || this.f == null || this.f.a() == 1 || this.f.a() == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.h, true, 1));
        } catch (Exception e3) {
            this.E = false;
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", e3.getLocalizedMessage());
            }
            a("2000131", cVar, this.e, "show exception");
            if (this.e != null) {
                try {
                    this.e.onShowFail(cVar, this.i, "show exception");
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e3.getMessage());
                    }
                }
            }
            if (this.t || this.u || (cVar2 = this.c) == null || !cVar2.a(4) || this.f == null || this.f.a() == 1 || this.f.a() == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.h, true, 1));
        }
    }

    private boolean a(boolean z) {
        if (this.b == null) {
            f();
        }
        List<com.mbridge.msdk.foundation.entity.c> a2 = com.mbridge.msdk.videocommon.cache.a.a().a(this.h);
        String str = this.A;
        if (a2 == null || a2.size() <= 0) {
            if (z) {
                d("is_ready_ctir_false", "no effective campaign list");
                com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                cVar.i(str);
                cVar.g(this.z);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 8);
                cVar.a("m_offer_ready", eVar);
                a(false, cVar, (List<CampaignEx>) this.b.h());
            }
            return false;
        }
        String d2 = com.mbridge.msdk.foundation.same.buffer.b.d(this.h);
        boolean a3 = TextUtils.isEmpty(d2) ? false : a(a2, d2, z);
        if (z) {
            d("is_ready_ctir_" + a3, "");
        }
        if (!a3) {
            for (com.mbridge.msdk.foundation.entity.c cVar2 : a2) {
                if (cVar2 != null) {
                    this.b.c(cVar2.a());
                    this.b.b(cVar2.d());
                    if (this.b.b(z)) {
                        cVar2.d();
                        return true;
                    }
                }
            }
        } else if (z) {
            com.mbridge.msdk.foundation.same.report.metrics.c cVar3 = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar3.i(str);
            a(a3, cVar3, this.b.h());
        }
        return a3;
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.c> list, String str, boolean z) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar : list) {
            if (cVar != null && str.equals(cVar.b())) {
                this.b.c(cVar.a());
                this.b.b(cVar.d());
                if (this.b.l()) {
                    if (!z) {
                        return true;
                    }
                    com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    cVar2.i(cVar.d());
                    a(false, cVar2, (List<CampaignEx>) this.b.h());
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2, String str3, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        com.mbridge.msdk.videocommon.setting.c cVar;
        com.mbridge.msdk.videocommon.setting.c cVar2;
        com.mbridge.msdk.videocommon.setting.c cVar3;
        com.mbridge.msdk.videocommon.setting.c cVar4;
        com.mbridge.msdk.foundation.same.report.metrics.c a2 = a(eVar);
        try {
            this.m = str;
            this.g = str2;
            this.k = str3;
        } catch (Exception e2) {
            this.E = false;
            if (MBridgeConstans.DEBUG) {
            }
            a("2000131", a2, this.e, "show exception");
            if (this.e != null) {
            }
            if (this.t) {
                return;
            } else {
                return;
            }
        }
        synchronized (this.D) {
            if (this.E) {
                a("2000131", a2, this.e, "campaing is show progressing ");
                if (this.e != null) {
                    try {
                        this.e.onShowFail(a2, this.i, "campaing is show progressing ");
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardVideoController", e3.getMessage());
                        }
                    }
                }
                return;
            }
            this.E = true;
            Context context = this.f4667a;
            if (context == null) {
                a("2000131", a2, this.e, "context is null");
                if (this.e != null) {
                    try {
                        this.e.onShowFail(a2, this.i, "context is null");
                    } catch (Exception e4) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardVideoController", e4.getMessage());
                        }
                    }
                }
                if (!this.t && !this.u && (cVar4 = this.c) != null && cVar4.a(4) && this.f != null && this.f.a() != 1 && this.f.a() != 3) {
                    a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.h, true, 1));
                }
                this.E = false;
                return;
            }
            if (this.t && !u0.l(context) && r0.a().a("s_a_w_n_c", true)) {
                a("2000131", a2, this.e, "network exception");
                if (this.e != null) {
                    try {
                        this.e.onShowFail(a2, this.i, "network exception");
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardVideoController", e5.getMessage());
                        }
                    }
                }
                if (!this.t && !this.u && (cVar3 = this.c) != null && cVar3.a(4) && this.f != null && this.f.a() != 1 && this.f.a() != 3) {
                    a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.h, true, 1));
                }
                this.E = false;
                return;
            }
            if (c()) {
                a("2000131", a2, this.e, "Play more than limit");
                if (this.e != null) {
                    try {
                        this.e.onShowFail(a2, this.i, "Play more than limit");
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardVideoController", e6.getMessage());
                        }
                    }
                }
                if (!this.t && !this.u && (cVar2 = this.c) != null && cVar2.a(4) && this.f != null && this.f.a() != 1 && this.f.a() != 3) {
                    a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.h, true, 1));
                }
                this.E = false;
                return;
            }
            if (TextUtils.isEmpty(this.g)) {
                this.g = com.mbridge.msdk.foundation.tools.f.d();
            }
            try {
                String format = new SimpleDateFormat("dd").format(new Date());
                String str4 = (String) x0.a(this.f4667a, "reward_date", "0");
                if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(format) && !str4.equals(format)) {
                    x0.b(this.f4667a, "reward_date", format);
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e7.getMessage());
                }
            }
            a(str, a2);
            return;
            this.E = false;
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoController", e2.getLocalizedMessage());
            }
            a("2000131", a2, this.e, "show exception");
            if (this.e != null) {
                try {
                    this.e.onShowFail(a2, this.i, "show exception");
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoController", e2.getMessage());
                    }
                }
            }
            if (this.t || this.u || (cVar = this.c) == null || !cVar.a(4) || this.f == null || this.f.a() == 1 || this.f.a() == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, 94, this.h, true, 1));
        }
    }

    private com.mbridge.msdk.foundation.same.report.metrics.c a(com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        CampaignEx campaignEx;
        try {
            CopyOnWriteArrayList<CampaignEx> b2 = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.h);
            String str = "";
            if (b2 != null && b2.size() > 0 && (campaignEx = b2.get(0)) != null) {
                str = campaignEx.getCurrentLocalRid();
            }
            com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = TextUtils.isEmpty(str) ? null : com.mbridge.msdk.foundation.same.report.metrics.d.b().c().get(str);
            if (cVar2 != null) {
                cVar2.b(b2);
                cVar2.a("2000128", eVar);
                cVar2.i(str);
                cVar2.n(this.h);
                com.mbridge.msdk.reward.report.metrics.a.a().a("2000128", cVar2);
                return cVar2;
            }
            cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            try {
                cVar.n(this.h);
                eVar.a("metrics_data_reason", "未获取到待展示的campaign信息 本地new metricsData");
                cVar.a("2000128", eVar);
                if (TextUtils.isEmpty(str)) {
                    cVar.i(SameMD5.getMD5(u0.d()));
                } else {
                    cVar.i(str);
                    cVar.b(b2);
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(str, cVar);
                }
                com.mbridge.msdk.reward.report.metrics.a.a().a("2000128", cVar);
                return cVar;
            } catch (Exception e2) {
                e = e2;
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoController", e.getMessage());
                }
                return cVar;
            }
        } catch (Exception e3) {
            e = e3;
            cVar = null;
        }
    }

    public void a(List<CampaignEx> list) {
        if (list != null && list.size() > 0) {
            this.H = list;
        } else {
            this.H = new ArrayList();
        }
    }

    private String a(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = SameMD5.getMD5(u0.d());
            }
            String[] split = str.split("_");
            if (split != null && split.length >= 3) {
                str2 = split[2];
            }
            return TextUtils.isEmpty(str2) ? SameMD5.getMD5(u0.d()) : str2;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(Message message) {
        Bundle data;
        com.mbridge.msdk.foundation.same.report.metrics.c b2;
        if (message != null) {
            try {
                data = message.getData();
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (data != null) {
                b2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(data.getString("metrics_data_lrid"));
                return b2 != null ? new com.mbridge.msdk.foundation.same.report.metrics.c() : b2;
            }
        }
        b2 = null;
        if (b2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, InterVideoOutListener interVideoOutListener) {
        if (this.x) {
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                cVar.b(this.H);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                if (interVideoOutListener != null) {
                    eVar.a("listener_state", 1);
                } else {
                    eVar.a("listener_state", 2);
                }
                cVar.a(str, eVar);
                com.mbridge.msdk.reward.report.metrics.a.a().a(str, cVar);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, InterVideoOutListener interVideoOutListener, String str2) {
        if (cVar == null) {
            try {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                cVar.b(this.H);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        if (!TextUtils.isEmpty(str2)) {
            eVar.a("reason", str2);
        }
        if (interVideoOutListener != null) {
            eVar.a("listener_state", 1);
        } else {
            eVar.a("listener_state", 2);
        }
        cVar.a(str, eVar);
        com.mbridge.msdk.reward.report.metrics.a.a().a(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d A[Catch: Exception -> 0x009f, TryCatch #0 {Exception -> 0x009f, blocks: (B:25:0x0009, B:27:0x000f, B:29:0x0016, B:30:0x002c, B:4:0x0036, B:8:0x003d, B:11:0x0072, B:13:0x0085, B:15:0x0093), top: B:24:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        String str;
        String str2;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
        String str3 = "";
        if (list != null) {
            try {
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (list.size() > 0) {
                if (list.get(0) == null) {
                    str = "";
                } else {
                    str3 = list.get(0).getLocalRequestId();
                    str = list.get(0).getNLRid();
                }
                cVar2.i(str3);
                cVar2.b(list);
                str2 = str3;
                str3 = str;
                if (!TextUtils.isEmpty(str3)) {
                    return cVar;
                }
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("cache", 1);
                eVar.a(CampaignEx.JSON_KEY_HB, 1);
                eVar.a("auto_load", 2);
                cVar2.a("2000127", eVar);
                cVar2.a("2000048", eVar);
                cVar2.a(this.t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
                cVar2.h("1");
                cVar2.f("2");
                if (!TextUtils.isEmpty(str2) && !com.mbridge.msdk.foundation.same.report.metrics.d.b().c().containsKey(str2)) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(str2, cVar2);
                    return cVar2;
                }
                return cVar2;
            }
        }
        str2 = "";
        if (!TextUtils.isEmpty(str3)) {
        }
    }

    private void a(boolean z, com.mbridge.msdk.foundation.same.report.metrics.c cVar, List<CampaignEx> list) {
        if (cVar == null) {
            cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        }
        if (list != null && list.size() > 0) {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx != null) {
                cVar.i(campaignEx.getLocalRequestId());
                cVar.g(campaignEx.getBidToken());
            }
            cVar.b(list);
        }
        a(z, cVar, (com.mbridge.msdk.foundation.same.report.metrics.e) null);
    }

    private void a(boolean z, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        if (eVar == null) {
            eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        }
        cVar.n(this.h);
        cVar.a(this.t ? MBSupportMuteAdType.INTERSTITIAL_VIDEO : 94);
        eVar.a("result", Integer.valueOf(z ? 1 : 2));
        eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(this.u ? 1 : 0));
        cVar.a("m_offer_ready", eVar);
        com.mbridge.msdk.reward.report.metrics.a.a().a("m_offer_ready", cVar);
    }
}

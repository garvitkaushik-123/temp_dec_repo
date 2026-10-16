package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: UnitCacheControllerRefactor.java */
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f5279a;
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> b;
    private final Context c;
    private final String d;
    private com.mbridge.msdk.videocommon.setting.c e;
    private final int f;
    private final CopyOnWriteArrayList<CampaignEx> g;
    private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.download.a> h;

    /* compiled from: UnitCacheControllerRefactor.java */
    private static final class a implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private final String f5280a;
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> b;
        private final com.mbridge.msdk.videocommon.listener.a c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.f5280a = str;
            this.b = concurrentHashMap;
            this.c = aVar;
        }

        private void b(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoRefactorManager", this.f5280a + " videoDownloadListener onDownLoadDone error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardVideoRefactorManager", this.f5280a + " videoDownloadListener onDownLoadDone error: " + e2.getMessage());
                        }
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            b(str);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            b(str, str2);
        }

        private void b(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardVideoRefactorManager", this.f5280a + " videoDownloadListener onDownLoadFailed error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.b;
            if (concurrentHashMap != null) {
                Iterator<com.mbridge.msdk.videocommon.listener.a> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(str, str2);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardVideoRefactorManager", this.f5280a + " videoDownloadListener onDownLoadFailed error: " + e2.getMessage());
                        }
                    }
                }
            }
        }
    }

    public k(List<CampaignEx> list, String str, int i) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.h = new ConcurrentHashMap<>();
        this.c = com.mbridge.msdk.foundation.controller.c.m().d();
        this.d = str;
        this.f = i;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    private String b(CampaignEx campaignEx) {
        return campaignEx == null ? "" : campaignEx.getendcard_url();
    }

    private int c() {
        com.mbridge.msdk.videocommon.setting.c b = b(h());
        if (b == null) {
            return 0;
        }
        try {
            return b.g();
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            p0.a("RewardVideoRefactorManager", h() + " getCDRate error " + e.getMessage());
            return 0;
        }
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            p0.a("RewardVideoRefactorManager", h() + " getVideoCtnType error " + e.getMessage());
            return 1;
        }
    }

    private void f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
            if (this.h.containsKey(str)) {
                return;
            }
            a(campaignEx, str, (com.mbridge.msdk.videocommon.download.a) null);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoRefactorManager", h() + " handlerCampaignLoadEvent error", e);
            }
        }
    }

    private boolean g(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            p0.a("RewardVideoRefactorManager", h() + " isPlayerAbleAds error:" + th.getMessage());
            return false;
        }
    }

    public void a() {
    }

    public void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.f5279a = aVar;
    }

    public void h(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.g.add(campaignEx);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoRefactorManager", h() + " update error", e);
                }
            }
        }
    }

    public com.mbridge.msdk.videocommon.download.a i() {
        List<com.mbridge.msdk.videocommon.download.a> list;
        if (this.g.size() == 0) {
            p0.a("RewardVideoRefactorManager", h() + " isReady campaignExes is null");
            return null;
        }
        try {
            list = a((List<CampaignEx>) this.g, false);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoRefactorManager", h() + " isReady error", e);
            }
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public void j() {
        a(this.g);
    }

    public void k() {
    }

    public void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.b == null) {
            this.b = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, aVar);
    }

    private com.mbridge.msdk.videocommon.setting.c b(String str) {
        try {
            if (this.e == null) {
                this.e = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), str, b() == 287);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.a("RewardVideoRefactorManager", h() + " getRewardUnitSetting error " + e.getMessage());
            }
        }
        return this.e;
    }

    private String e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoRefactorManager", h() + " getVideoTemplateUrl error", e);
            }
        }
        return "";
    }

    public com.mbridge.msdk.videocommon.download.a d() {
        try {
            return i();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            p0.b("RewardVideoRefactorManager", h() + " getCampaignDownLoadTask error:" + th.getMessage());
            return null;
        }
    }

    public String h() {
        return this.d;
    }

    private int g() {
        try {
            return b(this.d).w();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            p0.a("RewardVideoRefactorManager", h() + " getRewardReadyRate error:" + th.getMessage());
            return 100;
        }
    }

    public void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.g.addAll(list);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardVideoRefactorManager", h() + " update error", e);
                }
            }
        }
    }

    private int f() {
        if (TextUtils.isEmpty(h())) {
            return 1;
        }
        try {
            com.mbridge.msdk.videocommon.setting.c b = b(h());
            if (b != null) {
                return b.l();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.a("RewardVideoRefactorManager", h() + " getDlnet error " + e.getMessage());
            }
        }
        return 1;
    }

    public void c(String str) {
        com.mbridge.msdk.videocommon.download.a remove;
        CampaignEx c;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (this.h.containsKey(str) && (remove = this.h.remove(str)) != null && (c = remove.c()) != null) {
                this.g.remove(c);
                if (MBridgeConstans.DEBUG) {
                    p0.a("RewardVideoRefactorManager", h() + " removeCampaignDownloadTask campaign name: " + c.getAppName());
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoRefactorManager", h() + " removeCampaignDownloadTask error:" + e.getMessage());
            }
        }
    }

    public k(CampaignEx campaignEx, String str, int i) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.h = new ConcurrentHashMap<>();
        this.c = com.mbridge.msdk.foundation.controller.c.m().d();
        this.d = str;
        this.f = i;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null) {
                    f(next);
                }
            }
            return;
        }
        p0.a("RewardVideoRefactorManager", h() + " load campaignExes is null");
    }

    public int b() {
        return this.f;
    }

    private boolean b(CampaignEx campaignEx, String str, com.mbridge.msdk.videocommon.download.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if ((aVar == null || !aVar.s()) && !campaignEx.isDynamicView()) {
            return ((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) && campaignEx.getLoadTimeoutState() == 0 && g.a(str) == null) ? false : true;
        }
        return true;
    }

    public CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> e() {
        try {
            CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.h);
            return copyOnWriteArrayList;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            p0.b("RewardVideoRefactorManager", h() + " getCampaignDownLoadTaskList error:" + e.getMessage());
            return null;
        }
    }

    public List<com.mbridge.msdk.videocommon.download.a> a(List<CampaignEx> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            int size = list.size();
            for (CampaignEx campaignEx : list) {
                if (campaignEx != null) {
                    a(z, arrayList, size, campaignEx);
                }
            }
            return arrayList;
        }
        p0.a("RewardVideoRefactorManager", h() + " isReady campaignExes is null");
        return arrayList;
    }

    private int c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return g();
    }

    private void a(boolean z, List<com.mbridge.msdk.videocommon.download.a> list, int i, CampaignEx campaignEx) {
        try {
            String str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
            a(z, list, campaignEx, a(campaignEx, str, this.h.get(str)), i);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardVideoRefactorManager", h() + " isReady error", e);
            }
        }
    }

    private com.mbridge.msdk.videocommon.download.a a(CampaignEx campaignEx, String str, com.mbridge.msdk.videocommon.download.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        com.mbridge.msdk.videocommon.download.a a2 = a(campaignEx);
        a2.x();
        this.h.put(str, a2);
        return a2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:5|6|7|(5:9|10|11|12|(17:14|15|16|(2:18|(13:20|(2:23|24)|50|(2:52|(8:54|(2:57|58)|31|(1:49)(1:36)|37|(1:39)|40|(4:42|(1:44)|45|46)(1:48)))|63|(2:57|58)|31|(0)|49|37|(0)|40|(0)(0)))|65|(2:23|24)|50|(0)|63|(0)|31|(0)|49|37|(0)|40|(0)(0)))(1:74)|69|15|16|(0)|65|(0)|50|(0)|63|(0)|31|(0)|49|37|(0)|40|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x007a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x007b, code lost:
    
        r0 = r15;
        r15 = r0;
        r5 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: Exception -> 0x007a, TRY_LEAVE, TryCatch #3 {Exception -> 0x007a, blocks: (B:16:0x0035, B:18:0x003e), top: B:15:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0059 A[Catch: Exception -> 0x0074, TRY_LEAVE, TryCatch #4 {Exception -> 0x0074, blocks: (B:24:0x0050, B:50:0x0053, B:52:0x0059), top: B:23:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0069 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(boolean z, List<com.mbridge.msdk.videocommon.download.a> list, CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, int i) {
        com.mbridge.msdk.videocommon.download.a aVar2;
        Exception exc;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int loadTimeoutState;
        if (list == null || campaignEx == null || aVar == null) {
            return;
        }
        try {
            loadTimeoutState = campaignEx.getLoadTimeoutState();
        } catch (Exception e) {
            e = e;
            aVar2 = aVar;
        }
        if (aVar.r()) {
            aVar2 = aVar;
        } else {
            aVar2 = aVar;
            try {
            } catch (Exception e2) {
                e = e2;
                exc = e;
                z2 = false;
                z3 = false;
                z4 = z3;
                if (MBridgeConstans.DEBUG) {
                }
                z5 = z2;
                if (aVar2.n()) {
                }
                aVar2.a(z6);
                if (z6) {
                }
                if (MBridgeConstans.DEBUG) {
                }
            }
            if (!a(campaignEx, aVar2, c(campaignEx), z, f())) {
                z5 = false;
                aVar2.e(z5);
                if (!aVar2.p()) {
                    if (!a(b(campaignEx), campaignEx, aVar2)) {
                        z3 = false;
                        if (loadTimeoutState == 0 && z3) {
                            try {
                                aVar2.c(true);
                            } catch (Exception e3) {
                                z2 = z5;
                                exc = e3;
                                z4 = false;
                                if (MBridgeConstans.DEBUG) {
                                }
                                z5 = z2;
                                if (aVar2.n()) {
                                }
                                aVar2.a(z6);
                                if (z6) {
                                }
                                if (MBridgeConstans.DEBUG) {
                                }
                            }
                        }
                        if (!aVar2.s()) {
                            if (!b(campaignEx, e(campaignEx), aVar2)) {
                                z4 = false;
                                if (loadTimeoutState == 0 && z4) {
                                    try {
                                        aVar2.f(true);
                                    } catch (Exception e4) {
                                        z2 = z5;
                                        exc = e4;
                                        if (MBridgeConstans.DEBUG) {
                                            p0.b("RewardVideoRefactorManager", h() + " checkResourceReadyState error", exc);
                                        }
                                        z5 = z2;
                                        if (aVar2.n()) {
                                        }
                                        aVar2.a(z6);
                                        if (z6) {
                                        }
                                        if (MBridgeConstans.DEBUG) {
                                        }
                                    }
                                }
                                z6 = !aVar2.n() || (z5 && z3 && z4);
                                aVar2.a(z6);
                                if (z6) {
                                    list.add(aVar2);
                                }
                                if (MBridgeConstans.DEBUG) {
                                    return;
                                }
                                ArrayList<Integer> rsIgnoreCheckRule = campaignEx.getRsIgnoreCheckRule();
                                if (rsIgnoreCheckRule == null) {
                                    rsIgnoreCheckRule = new ArrayList<>();
                                }
                                p0.b("RewardVideoRefactorManager", h() + "  campaign name = " + campaignEx.getAppName() + "\n\t\tcampaign id = " + campaignEx.getId() + "\n\t\trequest id = " + campaignEx.getRequestId() + "\n\t\tadType = " + b() + "\n\t\tunitID = " + h() + "\n\t\tisReady = " + z6 + "\n\t\tisDynamicView = " + campaignEx.isDynamicView() + "\n\t\tisTPL = " + (!TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) + "\n\t\tcurrentSuccessSize = " + list.size() + "\n\t\tisReadyCheckSize = " + i + "\n\t\ttotalCampaignSize = " + this.g.size() + "\n\t\tlinkType = " + campaignEx.getLinkType() + "\n\t\tloadTimeoutState = " + campaignEx.getLoadTimeoutState() + "\n\t\tisVideoReady = " + z5 + "\n\t\t\tisIgnore = " + rsIgnoreCheckRule.contains(0) + "\n\t\t\treadyRate == " + c(campaignEx) + "\n\t\t\tCDRate = " + c() + "\n\t\t\tdlnet = " + f() + "\n\t\t\tctn = " + d(campaignEx) + "\n\t\t\tdownloadState = " + a(aVar2.j()) + "\n\t\tisTemplateReady = " + z4 + "\n\t\t\tisIgnore = " + rsIgnoreCheckRule.contains(1) + "\n\t\tisEndCardReady = " + z3 + "\n\t\t\tisIgnore = " + rsIgnoreCheckRule.contains(2) + "\n\t\t\tisOnlyPlayable = " + g(campaignEx) + "\n\t\t\tisPlayableEndCard(dynamicView) = " + u0.l(campaignEx.getendcard_url()));
                                return;
                            }
                        }
                        z4 = true;
                        if (loadTimeoutState == 0) {
                            aVar2.f(true);
                        }
                        if (aVar2.n()) {
                        }
                        aVar2.a(z6);
                        if (z6) {
                        }
                        if (MBridgeConstans.DEBUG) {
                        }
                    }
                }
                z3 = true;
                if (loadTimeoutState == 0) {
                    aVar2.c(true);
                }
                if (!aVar2.s()) {
                }
                z4 = true;
                if (loadTimeoutState == 0) {
                }
                if (aVar2.n()) {
                }
                aVar2.a(z6);
                if (z6) {
                }
                if (MBridgeConstans.DEBUG) {
                }
            }
        }
        z5 = true;
        aVar2.e(z5);
        if (!aVar2.p()) {
        }
        z3 = true;
        if (loadTimeoutState == 0) {
        }
        if (!aVar2.s()) {
        }
        z4 = true;
        if (loadTimeoutState == 0) {
        }
        if (aVar2.n()) {
        }
        aVar2.a(z6);
        if (z6) {
        }
        if (MBridgeConstans.DEBUG) {
        }
    }

    private String a(int i) {
        if (i == 0) {
            return "DOWNLOAD_READY";
        }
        if (i == 1) {
            return "DOWNLOAD_RUN";
        }
        if (i == 2) {
            return "DOWNLOAD_PAUSE";
        }
        if (i == 4) {
            return "DOWNLOAD_STOP";
        }
        if (i != 5) {
            return "Unknown";
        }
        return "DOWNLOAD_DONE";
    }

    private com.mbridge.msdk.videocommon.download.a a(CampaignEx campaignEx) {
        com.mbridge.msdk.videocommon.download.a aVar;
        com.mbridge.msdk.videocommon.download.a aVar2 = null;
        try {
            aVar = new com.mbridge.msdk.videocommon.download.a(this.c, campaignEx, h(), f());
        } catch (Exception e) {
            e = e;
        }
        try {
            aVar.e(campaignEx);
            aVar.a(b());
            aVar.d(c(campaignEx));
            aVar.b(c());
            aVar.e(d(campaignEx));
            aVar.a((c) null);
            aVar.a(new a(h(), this.b, this.f5279a));
            return aVar;
        } catch (Exception e2) {
            e = e2;
            aVar2 = aVar;
            if (MBridgeConstans.DEBUG) {
                p0.a("RewardVideoRefactorManager", h() + " createAndStartCampaignDownloadTask error " + e.getMessage());
            }
            return aVar2;
        }
    }

    private boolean a(com.mbridge.msdk.videocommon.download.a aVar, int i) {
        if (aVar == null || TextUtils.isEmpty(aVar.d())) {
            return true;
        }
        return i == 0 ? (aVar.c() == null || TextUtils.isEmpty(aVar.c().getVideoUrlEncode())) ? false : true : Utils.getDownloadRate(aVar.e(), aVar.h()) >= i;
    }

    private boolean a(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, int i, boolean z, int i2) {
        if (aVar == null || campaignEx == null) {
            return false;
        }
        if (aVar.r() || g(campaignEx) || TextUtils.isEmpty(aVar.d()) || i2 == 3) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(0)) {
            return true;
        }
        if (campaignEx.getIsTimeoutCheckVideoStatus() == 1 && campaignEx.getVideoCheckType() == 1) {
            return true;
        }
        long h = aVar.h();
        long e = aVar.e();
        if (z && campaignEx.getVideoCheckType() == 1) {
            if (i == 0) {
                return true;
            }
            if ((e != 0 || h != 0) && h >= (i / 100) * e) {
                campaignEx.setIsTimeoutCheckVideoStatus(1);
                return true;
            }
        }
        return a(aVar, i);
    }

    private boolean a(String str, CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar) {
        if (campaignEx != null && aVar != null) {
            try {
                if (aVar.p()) {
                    p0.a("RewardVideoRefactorManager", h() + " checkEndCardZipOrSourceDownLoad endCard download success");
                    return true;
                }
                if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    return true;
                }
                if ((campaignEx.isDynamicView() && !u0.l(str)) || z0.a(str) || a(str, campaignEx)) {
                    return true;
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    p0.a("RewardVideoRefactorManager", h() + " checkEndCardDownload error " + th.getMessage());
                }
            }
        }
        return false;
    }

    private boolean a(String str, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !g(campaignEx)) {
            return true;
        }
        if ((campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) && !z0.b(g.a(str))) {
            return z0.b(g.b(str));
        }
        return true;
    }

    public com.mbridge.msdk.videocommon.download.a a(String str) {
        if (!TextUtils.isEmpty(str) && this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }
}

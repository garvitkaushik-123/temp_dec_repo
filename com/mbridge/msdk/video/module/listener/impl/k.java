package com.mbridge.msdk.video.module.listener.impl;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3288s;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.foundation.tools.z0;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: StatisticsOnNotifyListener.java */
/* loaded from: classes6.dex */
public class k extends f {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f5152a;
    protected CampaignEx b;
    protected List<CampaignEx> c;
    protected boolean d;
    protected com.mbridge.msdk.videocommon.download.a e;
    protected com.mbridge.msdk.videocommon.entity.c f;
    protected String g;
    protected String h;
    protected com.mbridge.msdk.video.module.listener.a i;
    protected int j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;

    /* compiled from: StatisticsOnNotifyListener.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k kVar = k.this;
                if (!kVar.f5152a || kVar.b == null || !z0.b(kVar.g) || com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                    return;
                }
                com.mbridge.msdk.foundation.db.i a2 = com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                fVar.a(System.currentTimeMillis());
                fVar.b(k.this.g);
                fVar.a(k.this.b.getId());
                a2.a(fVar);
            } catch (Throwable th) {
                p0.b("NotifyListener", th.getMessage(), th);
            }
        }
    }

    /* compiled from: StatisticsOnNotifyListener.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k kVar = k.this;
                if (kVar.f5152a && kVar.b != null && z0.b(kVar.g)) {
                    com.mbridge.msdk.videocommon.cache.a a2 = com.mbridge.msdk.videocommon.cache.a.a();
                    k kVar2 = k.this;
                    a2.a(kVar2.b, kVar2.g);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
            try {
                com.mbridge.msdk.videocommon.cache.a a3 = com.mbridge.msdk.videocommon.cache.a.a();
                k kVar3 = k.this;
                a3.b(kVar3.h, kVar3.b.getAdType());
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                p0.a("NotifyListener", th.getMessage());
            }
        }
    }

    /* compiled from: StatisticsOnNotifyListener.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).b(k.this.b.getId());
            } catch (Throwable th) {
                p0.b("NotifyListener", th.getMessage(), th);
            }
        }
    }

    /* compiled from: StatisticsOnNotifyListener.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.videocommon.download.a aVar;
            try {
                if (r0.a().a("c_r_v_f_w_s_e", false)) {
                    return;
                }
                k kVar = k.this;
                if (!kVar.f5152a || (aVar = kVar.e) == null) {
                    return;
                }
                if (aVar.c() != null && !TextUtils.isEmpty(k.this.e.c().getVideoUrlEncode())) {
                    com.mbridge.msdk.foundation.db.m.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a(k.this.e.c().getVideoUrlEncode());
                }
                if (TextUtils.isEmpty(k.this.e.k())) {
                    return;
                }
                File file = new File(k.this.e.k());
                if (file.exists() && file.isFile() && file.delete()) {
                    p0.a("NotifyListener", "DEL File :" + file.getAbsolutePath());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public k(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.entity.c cVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i, boolean z) {
        this.d = false;
        this.i = new f();
        this.j = 1;
        if (!z && campaignEx != null && z0.b(str2) && aVar != null && aVar2 != null) {
            this.b = campaignEx;
            this.h = str;
            this.g = str2;
            this.e = aVar;
            this.f = cVar;
            this.i = aVar2;
            this.f5152a = true;
            this.j = i;
            this.d = false;
            return;
        }
        if (!z || campaignEx == null || !z0.b(str2) || aVar2 == null) {
            return;
        }
        this.b = campaignEx;
        this.h = str;
        this.g = str2;
        this.e = aVar;
        this.f = cVar;
        this.i = aVar2;
        this.f5152a = true;
        this.j = i;
        this.d = true;
    }

    private void d() {
        if (!this.f5152a || com.mbridge.msdk.foundation.same.buffer.b.k == null || TextUtils.isEmpty(this.b.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.buffer.b.a(this.g, this.b, C3288s.j);
    }

    private void m() {
        new Thread(new c()).start();
    }

    public void a(CampaignEx campaignEx) {
        this.b = campaignEx;
    }

    public void b(int i) {
        if (this.b != null) {
            if (i == 1 || i == 2) {
                com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, i, this.j);
            }
        }
    }

    public void c() {
        a aVar = new a();
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
        } else {
            aVar.run();
        }
    }

    protected void e() {
        d dVar = new d();
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(dVar);
        } else {
            dVar.run();
        }
    }

    public void g() {
        if (!this.f5152a || this.b == null) {
            return;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000061", this.b.getId(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.g, l0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
        nVar.b(this.b.isMraid() ? com.mbridge.msdk.foundation.entity.n.N : com.mbridge.msdk.foundation.entity.n.O);
        com.mbridge.msdk.foundation.same.report.g.b(nVar, com.mbridge.msdk.foundation.controller.c.m().d(), this.g);
    }

    protected void h() {
        try {
            if (!this.f5152a || this.k || TextUtils.isEmpty(this.b.getImpressionURL())) {
                return;
            }
            this.k = true;
            if (this.b.isBidCampaign()) {
                f();
            }
            String impressionURL = this.b.getImpressionURL();
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.g, this.b.getSpareOfferFlag() == 1 ? impressionURL + "&to=1&cbt=" + this.b.getCbt() + "&tmorl=" + this.j : impressionURL + "&to=0&cbt=" + this.b.getCbt() + "&tmorl=" + this.j, false, true, com.mbridge.msdk.click.retry.a.m);
            com.mbridge.msdk.video.module.report.b.d(com.mbridge.msdk.foundation.controller.c.m().d(), this.b);
            m();
            d();
        } catch (Throwable th) {
            p0.b("NotifyListener", th.getMessage(), th);
        }
    }

    protected void i() {
        CampaignEx campaignEx;
        Map<String, Long> map;
        try {
            CampaignEx campaignEx2 = this.b;
            if (campaignEx2 != null && campaignEx2.isDynamicView() && this.d && !this.b.isCampaignIsFiltered()) {
                this.l = true;
                return;
            }
            if (!this.f5152a || (campaignEx = this.b) == null || TextUtils.isEmpty(campaignEx.getOnlyImpressionURL()) || (map = com.mbridge.msdk.foundation.same.buffer.b.l) == null || map.containsKey(this.b.getOnlyImpressionURL()) || this.l) {
                return;
            }
            com.mbridge.msdk.foundation.same.buffer.b.l.put(this.b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
            String onlyImpressionURL = this.b.getOnlyImpressionURL();
            String str = this.b.getSpareOfferFlag() == 1 ? onlyImpressionURL + "&to=1&cbt=" + this.b.getCbt() + "&tmorl=" + this.j : onlyImpressionURL + "&to=0&cbt=" + this.b.getCbt() + "&tmorl=" + this.j;
            if (!this.d) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.g, str, false, true, com.mbridge.msdk.click.retry.a.n);
                b();
            } else if (this.b.isCampaignIsFiltered()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.g, str, false, true, com.mbridge.msdk.click.retry.a.n);
                b();
            }
            this.l = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void j() {
        CampaignEx campaignEx;
        List<String> pv_urls;
        try {
            if (!this.f5152a || this.m || (campaignEx = this.b) == null) {
                return;
            }
            this.m = true;
            if ((campaignEx.isDynamicView() && this.d && !this.b.isCampaignIsFiltered()) || (pv_urls = this.b.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.b, this.g, it.next(), false, true);
            }
        } catch (Throwable th) {
            p0.b("NotifyListener", th.getMessage());
        }
    }

    protected void k() {
        CampaignEx campaignEx = this.b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getCampaignUnitId()) || this.b.getNativeVideoTracking() == null || this.b.getNativeVideoTracking().i() == null) {
            return;
        }
        Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
        CampaignEx campaignEx2 = this.b;
        com.mbridge.msdk.click.a.a(d2, campaignEx2, campaignEx2.getCampaignUnitId(), this.b.getNativeVideoTracking().i(), false, false);
    }

    protected void l() {
        com.mbridge.msdk.videocommon.download.a aVar = this.e;
        if (aVar != null) {
            aVar.d(true);
        }
    }

    private void f() {
        if (this.b != null) {
            try {
                HashMap hashMap = new HashMap();
                List<com.mbridge.msdk.foundation.entity.d> a2 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.b.getCampaignUnitId(), this.b.getRequestId());
                if (a2 == null || a2.size() <= 0 || a2.get(0) == null) {
                    return;
                }
                if (a2.get(0).c() == 1) {
                    hashMap.put("encrypt_p=", "encrypt_p=" + a2.get(0).b());
                    hashMap.put("irlfa=", "irlfa=1");
                    for (Map.Entry entry : hashMap.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        CampaignEx campaignEx = this.b;
                        campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str, str2));
                        CampaignEx campaignEx2 = this.b;
                        campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str, str2));
                    }
                }
                p0.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.b.getRequestId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(List<CampaignEx> list) {
        this.c = list;
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        super.a(i, obj);
        this.i.a(i, obj);
    }

    public void a(int i, String str) {
        if (this.b != null) {
            com.mbridge.msdk.foundation.same.report.g.c(new com.mbridge.msdk.foundation.entity.n("2000062", this.b.getId(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.g, l0.s(com.mbridge.msdk.foundation.controller.c.m().d()), i, str), com.mbridge.msdk.foundation.controller.c.m().d(), this.g);
        }
    }

    public void b() {
        try {
            b bVar = new b();
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(bVar);
            } else {
                bVar.run();
            }
        } catch (Throwable th) {
            p0.b("NotifyListener", th.getMessage(), th);
        }
    }

    public void a(int i) {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i == 1 || i == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&endscreen_type=").append(i);
                    } else {
                        sb.append("?endscreen_type=").append(i);
                    }
                    noticeUrl = sb.toString();
                } else if (i == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.b.setNoticeUrl(noticeUrl);
            }
        }
    }

    protected void a() {
        com.mbridge.msdk.videocommon.download.b.getInstance().a(false);
    }

    protected void a(String str) {
        List<CampaignEx> list;
        if (this.b == null || (list = this.c) == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("camp_position")) {
                this.b = this.c.get(jSONObject.getInt("camp_position"));
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("NotifyListener", e.getMessage());
            }
        }
    }

    protected void b(String str) {
        try {
            if (this.b != null) {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("url", this.b.getVideoUrlEncode());
                eVar.a("reason", str);
                String noticeUrl = this.b.getNoticeUrl();
                String clickURL = this.b.getClickURL();
                if (TextUtils.isEmpty(noticeUrl)) {
                    if (!TextUtils.isEmpty(clickURL)) {
                        eVar.a("offer_url", clickURL);
                    }
                } else {
                    eVar.a("offer_url", noticeUrl);
                }
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000021", this.b, eVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

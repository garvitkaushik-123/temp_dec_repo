package com.mbridge.msdk.mbbanner.controll;

import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.d1;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbbanner.common.manager.c;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;

/* compiled from: BannerController.java */
/* loaded from: classes6.dex */
public class a {
    private static String x = "BannerController";

    /* renamed from: a, reason: collision with root package name */
    private String f4479a;
    private String b;
    private String c;
    private MBridgeIds d;
    private boolean e;
    private int f;
    private MBBannerView g;
    private int h;
    private int i;
    private int j;
    private BannerAdListener l;
    private CampaignUnit m;
    private c n;
    private l o;
    private j p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int k = -1;
    private com.mbridge.msdk.mbbanner.common.listener.c v = new C0353a();
    private com.mbridge.msdk.mbbanner.common.listener.b w = new b();

    public a(MBBannerView mBBannerView, BannerSize bannerSize, String str, String str2) {
        this.g = mBBannerView;
        if (bannerSize != null) {
            this.h = bannerSize.getHeight();
            this.i = bannerSize.getWidth();
        }
        this.f4479a = str2;
        str = TextUtils.isEmpty(str) ? "" : str;
        this.b = str;
        this.d = new MBridgeIds(str, this.f4479a);
        f();
    }

    private int a(int i) {
        if (i > 0) {
            if (i < 10) {
                return 10;
            }
            if (i > 180) {
                return 180;
            }
        }
        return i;
    }

    private boolean a(View view) {
        return true;
    }

    private void l() {
        l e = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.f4479a);
        this.o = e;
        if (e == null) {
            this.o = l.i(this.f4479a);
        }
        if (this.k == -1) {
            this.j = a(this.o.D());
        }
        if (this.f == 0) {
            boolean z = this.o.g() == 1;
            this.e = z;
            c cVar = this.n;
            if (cVar != null) {
                cVar.c(z);
            }
        }
    }

    private void f() {
        b(com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c());
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.s || !this.t) {
            return;
        }
        if (!a(this.g)) {
            a(new com.mbridge.msdk.foundation.error.b(880044));
        } else if (this.m != null) {
            if (this.n == null) {
                this.n = new c(this.g, this.v, this.b, this.f4479a, this.e, this.o);
            }
            this.n.a(this.c);
            this.n.b(this.q);
            this.n.d(this.r);
            this.n.a(this.e, this.f);
            this.n.b(this.m);
        } else {
            a(new com.mbridge.msdk.foundation.error.b(880043));
        }
        this.t = false;
    }

    private void k() {
        MBBannerView mBBannerView = this.g;
        if (mBBannerView != null) {
            if (!this.q || !this.r || this.u || d1.a(mBBannerView, 1)) {
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(2, this.b, this.f4479a, null, null);
            } else {
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(3, this.b, this.f4479a, new com.mbridge.msdk.mbbanner.common.data.a(this.i + VastAttributes.HORIZONTAL_POSITION + this.h, this.j * 1000), this.w);
            }
            if (this.q) {
                return;
            }
            com.mbridge.msdk.mbbanner.common.manager.a.b().a(4, this.b, this.f4479a, null, null);
            com.mbridge.msdk.mbbanner.common.manager.a.b().b(this.f4479a);
        }
    }

    public void c() {
        if (this.s) {
            return;
        }
        k();
        l();
        com.mbridge.msdk.mbbanner.common.data.a aVar = new com.mbridge.msdk.mbbanner.common.data.a(this.i + VastAttributes.HORIZONTAL_POSITION + this.h, this.j * 1000);
        aVar.c(this.b);
        aVar.a(true);
        aVar.b(com.mbridge.msdk.mbbanner.common.report.a.b(""));
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(this.b, this.f4479a, aVar, this.w);
    }

    public String d() {
        CampaignUnit campaignUnit = this.m;
        return campaignUnit != null ? com.mbridge.msdk.foundation.same.c.b(campaignUnit.getAds()) : "";
    }

    public String e() {
        CampaignUnit campaignUnit = this.m;
        return (campaignUnit == null || campaignUnit.getRequestId() == null) ? "" : this.m.getRequestId();
    }

    public void g() {
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(4, this.b, this.f4479a, new com.mbridge.msdk.mbbanner.common.data.a(this.i + VastAttributes.HORIZONTAL_POSITION + this.h, this.j * 1000), this.w);
    }

    public void h() {
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(3, this.b, this.f4479a, new com.mbridge.msdk.mbbanner.common.data.a(this.i + VastAttributes.HORIZONTAL_POSITION + this.h, this.j * 1000), this.w);
    }

    public void i() {
        this.s = true;
        if (this.l != null) {
            this.l = null;
        }
        if (this.w != null) {
            this.w = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        if (this.g != null) {
            this.g = null;
        }
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(4, this.b, this.f4479a, null, null);
        com.mbridge.msdk.mbbanner.common.manager.a.b().b(this.f4479a);
        com.mbridge.msdk.mbbanner.common.manager.a.b().c();
        c cVar = this.n;
        if (cVar != null) {
            cVar.h();
        }
    }

    /* compiled from: BannerController.java */
    class b implements com.mbridge.msdk.mbbanner.common.listener.b {
        b() {
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void a(String str, CampaignUnit campaignUnit, boolean z) {
            a.this.m = campaignUnit;
            a.this.a(1, (com.mbridge.msdk.foundation.error.b) null);
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void b(com.mbridge.msdk.foundation.error.b bVar) {
            a.this.a(bVar.f(), bVar);
            a.this.c();
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void a(com.mbridge.msdk.foundation.error.b bVar) {
            a.this.a(2, bVar);
            a.this.a(bVar.f(), bVar);
            a.this.c();
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void a(String str, int i, boolean z) {
            if (a.this.g != null) {
                a.this.t = true;
                a.this.j();
            }
        }
    }

    public void b(int i) {
        int a2 = a(i);
        this.k = a2;
        this.j = a2;
    }

    private void b(String str, String str2) {
        if (this.p == null) {
            this.p = new j();
        }
        this.p.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, str2, this.f4479a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.error.b bVar) {
        CampaignUnit campaignUnit;
        String str2 = "";
        if (bVar != null) {
            try {
                str2 = bVar.g();
                if (TextUtils.isEmpty(str)) {
                    str = bVar.f();
                }
            } catch (Throwable th) {
                p0.b(x, th.getMessage());
            }
        }
        if (TextUtils.isEmpty(str) && (campaignUnit = this.m) != null) {
            str = campaignUnit.getLocalRequestId();
        }
        com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(this.f4479a, str);
        CampaignUnit campaignUnit2 = this.m;
        a2.b(campaignUnit2 != null ? campaignUnit2.getAds() : null);
        a2.a(bVar);
        CampaignUnit campaignUnit3 = this.m;
        if (campaignUnit3 != null && !campaignUnit3.getAds().isEmpty()) {
            a2.d(TextUtils.isEmpty(this.m.getAds().get(0).getBannerUrl()) ? 1 : 2);
        }
        a2.b(true);
        com.mbridge.msdk.mbbanner.common.report.a.a("2000047", a2, (e) null);
        BannerAdListener bannerAdListener = this.l;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.d, str2);
        }
    }

    public void b(boolean z) {
        this.q = z;
        b();
        j();
    }

    public void b() {
        k();
        c cVar = this.n;
        if (cVar != null) {
            cVar.b(this.q);
            this.n.d(this.r);
        }
    }

    /* compiled from: BannerController.java */
    /* renamed from: com.mbridge.msdk.mbbanner.controll.a$a, reason: collision with other inner class name */
    class C0353a implements com.mbridge.msdk.mbbanner.common.listener.c {
        C0353a() {
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a(List<CampaignEx> list) {
            p0.b(a.x, "onShowSuccessed:");
            if (a.this.l != null) {
                a.this.l.onLoadSuccessed(a.this.d);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(a.this.f4479a, list.get(0).getLocalRequestId());
                a2.b(list);
                a2.g(1);
                a2.d(TextUtils.isEmpty(list.get(0).getBannerUrl()) ? 2 : 1);
                com.mbridge.msdk.mbbanner.common.report.a.a("2000048", a2, (e) null);
            } catch (Exception e) {
                p0.b(a.x, e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void b() {
            if (a.this.l != null) {
                a.this.l.onCloseBanner(a.this.d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void c() {
            if (a.this.l != null) {
                a.this.l.onClick(a.this.d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void d() {
            if (a.this.l != null) {
                a.this.l.closeFullScreen(a.this.d);
                a.this.u = false;
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(3, a.this.b, a.this.f4479a, new com.mbridge.msdk.mbbanner.common.data.a(a.this.i + VastAttributes.HORIZONTAL_POSITION + a.this.h, a.this.j * 1000), a.this.w);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void onLeaveApp() {
            if (a.this.l != null) {
                a.this.l.onLeaveApp(a.this.d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a(CampaignEx campaignEx) {
            a.this.c();
            if (a.this.l != null) {
                a.this.l.onLogImpression(a.this.d);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(a.this.f4479a, campaignEx.getLocalRequestId());
                a2.a(campaignEx);
                a2.h(campaignEx.isBidCampaign() ? "1" : "0");
                int i = 1;
                a2.g(a.this.n != null ? a.this.n.c() : 1);
                if (a.this.j != 0) {
                    i = 2;
                }
                a2.b(i);
                a2.c(a.this.j);
                com.mbridge.msdk.mbbanner.common.report.a.a("2000128", a2, (e) null);
                com.mbridge.msdk.mbbanner.common.report.a.a("2000130", a2, (e) null);
            } catch (Exception e) {
                p0.b(a.x, e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a(com.mbridge.msdk.foundation.error.b bVar) {
            a.this.a(bVar);
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a() {
            if (a.this.l != null) {
                a.this.l.showFullScreen(a.this.d);
                a.this.u = true;
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(2, a.this.b, a.this.f4479a, null, null);
            }
        }
    }

    public void c(boolean z) {
        this.r = z;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.mbridge.msdk.foundation.error.b bVar) {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(this.f4479a, bVar == null ? this.m.getLocalRequestId() : bVar.f());
            e eVar = new e();
            eVar.a("result", Integer.valueOf(i));
            CampaignUnit campaignUnit = this.m;
            if (campaignUnit != null && !campaignUnit.getAds().isEmpty()) {
                CampaignEx campaignEx = this.m.getAds().get(0);
                if (campaignEx != null) {
                    a2.d(TextUtils.isEmpty(campaignEx.getBannerUrl()) ? 2 : 1);
                }
                a2.b(this.m.getAds());
            }
            if (bVar != null) {
                a2.a(bVar);
            }
            com.mbridge.msdk.mbbanner.common.report.a.a("2000126", a2, eVar);
        } catch (Exception e) {
            p0.b(x, e.getMessage());
        }
    }

    public void a(BannerSize bannerSize) {
        if (bannerSize != null) {
            this.h = bannerSize.getHeight();
            this.i = bannerSize.getWidth();
        }
    }

    public void a(boolean z) {
        this.e = z;
        this.f = z ? 1 : 2;
    }

    public void a(String str, String str2) {
        boolean z;
        if (this.h >= 1 && this.i >= 1) {
            try {
                z = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
            } catch (Exception e) {
                p0.b(x, e.getMessage());
                z = false;
            }
            if (!z) {
                a(str2, new com.mbridge.msdk.foundation.error.b(880029));
                return;
            }
            this.c = str2;
            com.mbridge.msdk.mbbanner.common.data.a aVar = new com.mbridge.msdk.mbbanner.common.data.a(this.i + VastAttributes.HORIZONTAL_POSITION + this.h, this.j * 1000);
            aVar.a(str);
            aVar.c(this.b);
            aVar.b(str2);
            com.mbridge.msdk.mbbanner.common.manager.a.b().b(this.b, this.f4479a, aVar, this.w);
            com.mbridge.msdk.mbbanner.common.manager.a.b().a(1, this.b, this.f4479a, aVar, this.w);
            return;
        }
        a(str2, new com.mbridge.msdk.foundation.error.b(880037));
    }

    public void a(BannerAdListener bannerAdListener) {
        this.l = bannerAdListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar) {
        a(this.c, bVar);
        if (bVar.b() != 880044) {
            c();
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        c cVar = this.n;
        if (cVar != null) {
            cVar.a(i, i2, i3, i4);
        }
    }
}

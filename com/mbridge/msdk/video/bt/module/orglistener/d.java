package com.mbridge.msdk.video.bt.module.orglistener;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: ProxyShowRewardListener.java */
/* loaded from: classes6.dex */
public class d extends b {
    private h c;
    private com.mbridge.msdk.videocommon.setting.c d;
    private String e;
    private String f;
    private boolean g;
    private Context h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;

    public d(Context context, boolean z, com.mbridge.msdk.videocommon.setting.c cVar, CampaignEx campaignEx, h hVar, String str, String str2) {
        this.c = hVar;
        this.d = cVar;
        this.e = str2;
        this.f = str;
        this.g = z;
        this.h = context;
        a(cVar, campaignEx);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x001a, B:8:0x0024, B:9:0x002d, B:11:0x0037, B:13:0x003d, B:15:0x0044, B:17:0x004e, B:20:0x0052, B:22:0x0056), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x001a, B:8:0x0024, B:9:0x002d, B:11:0x0037, B:13:0x003d, B:15:0x0044, B:17:0x004e, B:20:0x0052, B:22:0x0056), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.mbridge.msdk.videocommon.setting.c cVar, CampaignEx campaignEx) {
        long j;
        try {
            String b = com.mbridge.msdk.foundation.controller.c.m().b();
            if (!TextUtils.isEmpty(b)) {
                com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(b);
                if (d == null) {
                    d = com.mbridge.msdk.setting.h.b().a();
                }
                if (d != null) {
                    j = d.a0() * 1000;
                    com.mbridge.msdk.videocommon.setting.a c = com.mbridge.msdk.videocommon.setting.b.b().c();
                    long e = c != null ? c.e() : 0L;
                    if (campaignEx == null) {
                        if (!campaignEx.isSpareOffer(e, j)) {
                            campaignEx.setSpareOfferFlag(0);
                            campaignEx.setCbt(0);
                            return;
                        }
                        campaignEx.setSpareOfferFlag(1);
                        if (cVar.A() == 1) {
                            campaignEx.setCbt(1);
                            return;
                        } else {
                            campaignEx.setCbt(0);
                            return;
                        }
                    }
                    return;
                }
            }
            j = 0;
            com.mbridge.msdk.videocommon.setting.a c2 = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (c2 != null) {
            }
            if (campaignEx == null) {
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.c;
        if (hVar != null) {
            hVar.b(str, str2);
            this.c.a(5, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        super.a(cVar);
        if (this.c == null || this.i) {
            return;
        }
        this.i = true;
        b();
        this.c.a(cVar);
        this.c.a(2, this.f, this.e);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, boolean z, com.mbridge.msdk.videocommon.entity.c cVar2) {
        super.a(cVar, z, cVar2);
        h hVar = this.c;
        if (hVar == null || this.k) {
            return;
        }
        this.k = true;
        hVar.a(7, this.f, this.e);
        this.c.a(cVar, z, cVar2);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z, int i) {
        super.a(z, i);
        h hVar = this.c;
        if (hVar == null || this.k) {
            return;
        }
        hVar.a(z, i);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str) {
        super.a(cVar, str);
        if (this.c == null || this.j) {
            return;
        }
        this.j = true;
        a();
        this.c.a(cVar, str);
        this.c.a(4, this.f, this.e);
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(boolean z, String str, String str2) {
        super.a(z, str, str2);
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(z, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.orglistener.b, com.mbridge.msdk.video.bt.module.orglistener.h
    public void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(str, str2);
            this.c.a(6, str, str2);
        }
    }
}

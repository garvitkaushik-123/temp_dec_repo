package com.mbridge.msdk.mbbanner.common.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: BannerLoader.java */
/* loaded from: classes6.dex */
public class b {
    private static final String n = "b";

    /* renamed from: a, reason: collision with root package name */
    private Context f4450a;
    private com.mbridge.msdk.mbbanner.common.data.b c;
    private com.mbridge.msdk.mbbanner.common.util.a d;
    private com.mbridge.msdk.mbbanner.common.listener.b e;
    private com.mbridge.msdk.mbbanner.common.listener.d f;
    private int b = 0;
    private volatile boolean g = false;
    private Timer h = new Timer();
    private volatile List<String> i = new ArrayList();
    private volatile boolean j = false;
    private volatile boolean k = false;
    private volatile boolean l = false;
    private String m = "";

    /* compiled from: BannerLoader.java */
    class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4451a;
        final /* synthetic */ CampaignEx b;

        a(String str, CampaignEx campaignEx) {
            this.f4451a = str;
            this.b = campaignEx;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (b.this.g) {
                return;
            }
            b.this.g = true;
            b.this.a(this.f4451a, -1, "", false, this.b);
        }
    }

    /* compiled from: BannerLoader.java */
    class c extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4452a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ Context c;

        c(String str, CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f4452a = str;
            this.b = campaignEx;
            this.c = context;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f4452a);
            cVar.a(str, eVar);
            com.mbridge.msdk.mbbanner.common.report.a.a(str, cVar, this.b, this.c, null);
        }
    }

    /* compiled from: BannerLoader.java */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignUnit f4453a;

        d(CampaignUnit campaignUnit) {
            this.f4453a = campaignUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.c(b.n, "在单独子线程保存数据库 开始");
            j.a(g.a(b.this.f4450a)).a();
            CampaignUnit campaignUnit = this.f4453a;
            if (campaignUnit != null && campaignUnit.getAds() != null && this.f4453a.getAds().size() > 0) {
                BannerUtils.uisList(b.this.f4450a, this.f4453a.getAds());
            }
            p0.c(b.n, "在单独子线程保存数据库 完成");
        }
    }

    /* compiled from: BannerLoader.java */
    private static class e implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        private b f4454a;
        private String b;
        private CampaignEx c;

        public e(b bVar, String str, CampaignEx campaignEx) {
            this.f4454a = bVar;
            this.b = str;
            this.c = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            String str3;
            if (MBridgeConstans.DEBUG) {
                p0.c(b.n, "DownloadImageListener campaign image fail");
            }
            b bVar = this.f4454a;
            if (bVar != null) {
                str3 = str2;
                bVar.a(this.b, 1, str3, false, this.c);
            } else {
                str3 = str2;
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(this.b, this.c.getCurrentLocalRid());
                a2.a(this.c);
                a2.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                a2.e(10);
                eVar.a("resource_type", 10);
                eVar.a("result", 3);
                eVar.a("url", str3);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_end", a2, eVar);
            } catch (Throwable th) {
                p0.b(b.n, th.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            String str2;
            if (MBridgeConstans.DEBUG) {
                p0.c(b.n, "DownloadImageListener campaign image success");
            }
            b bVar = this.f4454a;
            if (bVar != null) {
                str2 = str;
                bVar.a(this.b, 1, str2, true, this.c);
            } else {
                str2 = str;
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(this.b, this.c.getCurrentLocalRid());
                a2.a(this.c);
                a2.e(10);
                a2.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("resource_type", 10);
                eVar.a("result", 1);
                eVar.a("url", str2);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_end", a2, eVar);
            } catch (Throwable th) {
                p0.b(b.n, th.getMessage());
            }
        }
    }

    public b(Context context, com.mbridge.msdk.mbbanner.common.data.b bVar, com.mbridge.msdk.mbbanner.common.listener.b bVar2, com.mbridge.msdk.mbbanner.common.util.a aVar) {
        this.f4450a = context.getApplicationContext();
        this.c = bVar;
        this.e = bVar2;
        this.d = aVar;
    }

    private void b(String str, List<CampaignEx> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (CampaignEx campaignEx : list) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                this.i.add(campaignEx.getImageUrl());
                com.mbridge.msdk.foundation.same.image.b.a(this.f4450a).a(campaignEx.getImageUrl(), new e(this, str, campaignEx));
                com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(str, campaignEx.getCurrentLocalRid());
                a2.a(campaignEx);
                a2.e(10);
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("resource_type", 10);
                com.mbridge.msdk.mbbanner.common.report.a.a("m_download_start", a2, eVar);
            }
        }
    }

    private void a(String str, int i) {
        if (this.l) {
            return;
        }
        if ((this.j || this.k) && this.i.size() == 0) {
            p0.c(n, "在子线程处理业务逻辑 完成");
            this.g = true;
            this.l = true;
            this.h.cancel();
            this.d.a(this.e, str, i);
            this.f.a(str);
        }
    }

    private void b(String str, String str2, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        a(str, 3, str2, true, campaignEx);
    }

    private void a(String str, CampaignEx campaignEx) {
        String str2 = n;
        p0.c(str2, "在子线程处理业务逻辑 完成");
        p0.c(str2, "downloadResource--> Fail");
        this.g = true;
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880027);
        MBridgeIds mBridgeIds = new MBridgeIds();
        mBridgeIds.setUnitId(str);
        bVar.a(mBridgeIds);
        bVar.b(this.c.a());
        bVar.a(campaignEx);
        this.d.b(this.e, bVar);
        this.f.a(str);
    }

    /* compiled from: BannerLoader.java */
    /* renamed from: com.mbridge.msdk.mbbanner.common.manager.b$b, reason: collision with other inner class name */
    class C0348b extends com.mbridge.msdk.mbbanner.common.response.a {
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.data.a c;

        C0348b(com.mbridge.msdk.mbbanner.common.data.a aVar) {
            this.c = aVar;
        }

        @Override // com.mbridge.msdk.mbbanner.common.response.a
        public void a(CampaignUnit campaignUnit) {
            try {
                p0.c(b.n, "requestCampaign--> Succeed");
                campaignUnit.setLocalRequestId(this.c.b());
                b.this.d.a(b.this.e, campaignUnit, this.unitId);
                b.this.a(this.unitId, this.c.b(), campaignUnit);
            } catch (Exception e) {
                p0.c(b.n, "requestCampaign--> Fail with exception = " + e.getMessage());
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880000);
                bVar.a(new MBridgeIds(this.placementId, this.unitId));
                bVar.b(this.c.b());
                bVar.a((campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().isEmpty()) ? null : campaignUnit.getAds().get(0));
                bVar.a((Throwable) e);
                b.this.d.a(b.this.e, bVar);
                b.this.f.a(this.unitId);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.response.a
        public void a(int i, String str) {
            p0.c(b.n, "requestCampaign--> Fail errorCode:" + i + " msg:" + str);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
            bVar.c(i + "#" + str);
            bVar.a(new MBridgeIds(this.placementId, this.unitId));
            bVar.b(this.c.b());
            b.this.d.a(b.this.e, bVar);
            b.this.f.a(this.unitId);
        }
    }

    private String b() {
        return this.c.d();
    }

    private void b(String str) {
        this.c.b(str);
    }

    public void a(String str, int i, String str2, boolean z, CampaignEx campaignEx) {
        if (!z) {
            if (i == -1) {
                p0.b(n, " unitId =" + str + " --> time out!");
            }
            this.h.cancel();
            a(str, campaignEx);
            return;
        }
        if (i == 1) {
            p0.c(n, "downloadResource--> Success Image");
            synchronized (this) {
                this.i.remove(str2);
                if (this.i.size() == 0) {
                    a(str, i);
                }
            }
            return;
        }
        if (i == 2) {
            p0.c(n, "downloadResource--> Success banner_html");
            this.k = true;
            a(str, i);
        } else if (i == 3) {
            p0.c(n, "downloadResource--> Success banner_url");
            this.j = true;
            a(str, i);
        }
    }

    private void a(String str, int i, CampaignEx campaignEx) {
        this.h.schedule(new a(str, campaignEx), i);
    }

    public void a(String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.d dVar) {
        boolean z;
        try {
            p0.c(n, "requestCampaign--> started");
            this.f = dVar;
            C0348b c0348b = new C0348b(aVar);
            c0348b.setUnitId(str2);
            c0348b.setPlacementId(str);
            c0348b.setAdType(296);
            com.mbridge.msdk.mbbanner.common.request.a aVar2 = new com.mbridge.msdk.mbbanner.common.request.a(this.f4450a);
            this.b = a(str2);
            com.mbridge.msdk.foundation.same.net.wrapper.e a2 = com.mbridge.msdk.mbbanner.common.data.c.a(false, this.f4450a, str2, b(), this.b, aVar);
            String d2 = u0.d(str2);
            if (!TextUtils.isEmpty(d2)) {
                a2.a(com.mbridge.msdk.foundation.same.report.j.b, d2);
            }
            String a3 = aVar.a();
            if (TextUtils.isEmpty(a3)) {
                z = false;
            } else {
                c0348b.a(a3);
                z = true;
            }
            this.d.a(z);
            aVar2.choiceV3OrV5BySetting(1, a2, c0348b, a3, 30000L);
        } catch (Exception e2) {
            p0.b(n, e2.getMessage());
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
            bVar.a(new MBridgeIds(str, str2));
            this.d.a(this.e, bVar);
            this.f.a(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, CampaignUnit campaignUnit) {
        com.mbridge.msdk.foundation.error.b bVar;
        CampaignEx campaignEx;
        if (campaignUnit == null) {
            com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880003);
            MBridgeIds mBridgeIds = new MBridgeIds();
            mBridgeIds.setUnitId(str);
            bVar2.a(mBridgeIds);
            bVar2.b(str2);
            this.d.a(this.e, bVar2);
            this.f.a(str);
            return;
        }
        List<CampaignEx> a2 = a(str, campaignUnit);
        a(campaignUnit);
        int i = 0;
        if (a2 != null && a2.size() != 0) {
            p0.c(n, "在子线程处理业务逻辑 开始");
            CampaignEx campaignEx2 = a2.get(0);
            a(str, 60000, campaignEx2);
            b(campaignUnit.getSessionId());
            a(str, a2);
            String trim = campaignEx2.getBannerUrl().trim();
            if (!TextUtils.isEmpty(trim)) {
                b(str, trim, campaignEx2);
                if (a2.size() > 0) {
                    while (i < a2.size()) {
                        a2.get(i).setBannerUrl(campaignEx2.getBannerUrl());
                        a2.get(i).setHasMBTplMark(true);
                        i++;
                    }
                }
            } else {
                String trim2 = campaignEx2.getBannerHtml().trim();
                if (!TextUtils.isEmpty(trim2)) {
                    String a3 = a(str, trim2, campaignEx2);
                    if (a2.size() > 0) {
                        while (i < a2.size()) {
                            a2.get(i).setBannerHtml(a3);
                            a2.get(i).setHasMBTplMark(trim2.contains("<MBTPLMARK>"));
                            i++;
                        }
                    }
                } else {
                    this.k = true;
                    this.j = true;
                }
            }
            b(str, a2);
            return;
        }
        p0.c(n, "tryDownloadOnLoadSuccess 返回的campaign 没有符合下载规则的");
        if (this.m.contains("INSTALLED")) {
            bVar = new com.mbridge.msdk.foundation.error.b(880021, "APP ALREADY INSTALLED");
        } else {
            bVar = new com.mbridge.msdk.foundation.error.b(880003);
        }
        MBridgeIds mBridgeIds2 = new MBridgeIds();
        mBridgeIds2.setUnitId(str);
        bVar.a(mBridgeIds2);
        bVar.b(str2);
        if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && (campaignEx = campaignUnit.getAds().get(0)) != null) {
            bVar.a(campaignEx);
        }
        this.d.a(this.e, bVar);
        this.f.a(str);
    }

    private List<CampaignEx> a(String str, CampaignUnit campaignUnit) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (campaignUnit != null) {
            try {
                if (campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    p0.c(n, "getNeedShowList 总共返回的campaign有：" + ads.size());
                    x.a(ads);
                    int i = 0;
                    while (i < ads.size()) {
                        CampaignEx campaignEx = ads.get(i);
                        if (campaignEx == null || campaignEx.getOfferType() == 99 || (TextUtils.isEmpty(campaignEx.getBannerUrl()) && TextUtils.isEmpty(campaignEx.getBannerHtml()) && TextUtils.isEmpty(campaignEx.getImageUrl()))) {
                            str2 = str;
                        } else {
                            if (u0.c(campaignEx)) {
                                campaignEx.setRtinsType(u0.c(this.f4450a, campaignEx.getPackageName()) ? 1 : 2);
                            }
                            if (com.mbridge.msdk.foundation.same.c.b(this.f4450a, campaignEx)) {
                                arrayList.add(campaignEx);
                            } else {
                                u0.a(str, campaignEx, com.mbridge.msdk.foundation.same.a.x);
                                this.m = "APP ALREADY INSTALLED";
                            }
                            str2 = str;
                            a(campaignEx, this.f4450a, (com.mbridge.msdk.foundation.same.report.metrics.c) null, str2, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
                        }
                        i++;
                        str = str2;
                    }
                    p0.c(n, "getNeedShowList 返回有以下带有视频素材的campaign：" + arrayList.size());
                    return arrayList;
                }
            } catch (Exception e2) {
                p0.b(n, e2.getMessage());
            }
        }
        return arrayList;
    }

    private void a(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, context, cVar, new c(str, campaignEx, context, aVar));
        } catch (Exception e2) {
            p0.b(n, e2.getMessage());
        }
    }

    private String a(String str, String str2, CampaignEx campaignEx) {
        File file;
        Throwable th;
        FileOutputStream fileOutputStream;
        File file2;
        String str3 = "";
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    String b = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
                    String md5 = SameMD5.getMD5(b1.b(str2));
                    if (TextUtils.isEmpty(md5)) {
                        md5 = String.valueOf(System.currentTimeMillis());
                    }
                    file2 = new File(b, md5.concat(".html"));
                    Uri.parse(str2).getPath();
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            p0.b(n, e3.getMessage());
        }
        try {
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.flush();
            str3 = file2.getAbsolutePath();
            fileOutputStream.close();
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            p0.b(n, e.getMessage());
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            file = new File(str3);
            if (!file.exists()) {
            }
            a(str, 2, str2, false, campaignEx);
            return str3;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (Exception e5) {
                    p0.b(n, e5.getMessage());
                    throw th;
                }
            }
            throw th;
        }
        file = new File(str3);
        if (!file.exists() && file.isFile() && file.canRead()) {
            a(str, 2, str2, true, campaignEx);
        } else {
            a(str, 2, str2, false, campaignEx);
        }
        return str3;
    }

    private void a(CampaignUnit campaignUnit) {
        new Thread(new d(campaignUnit)).start();
    }

    private int a(String str) {
        try {
            int c2 = this.c.c();
            if (c2 > this.c.b()) {
                return 0;
            }
            return c2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void a(String str, List<CampaignEx> list) {
        int i = this.b;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    i += list.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (i > this.c.b()) {
            p0.c(n, "saveNextOffset 重置offset为0");
            i = 0;
        }
        p0.c(n, "saveNextOffset 算出 下次的offset是:" + i);
        if (z0.b(str)) {
            this.c.a(i);
        }
    }
}

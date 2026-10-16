package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: UnitCacheCtroller.java */
/* loaded from: classes6.dex */
public class l {
    private com.mbridge.msdk.videocommon.listener.a c;
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> e;
    private Context h;
    private String j;
    private com.mbridge.msdk.videocommon.setting.c k;
    private int m;
    private k p;
    private boolean q;

    /* renamed from: a, reason: collision with root package name */
    private List<CampaignEx> f5281a = new ArrayList();
    private boolean b = true;
    private String d = "";
    private c f = new a();
    private CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> g = new CopyOnWriteArrayList<>();
    private long i = 3600;
    private int l = 1;
    com.mbridge.msdk.setting.l n = null;
    com.mbridge.msdk.setting.l o = null;

    /* compiled from: UnitCacheCtroller.java */
    class a implements c {
        a() {
        }

        @Override // com.mbridge.msdk.videocommon.download.c
        public void onProgress(long j, int i) {
            if (i == 5 || i == 4) {
                l.this.b = true;
                l.this.d();
            }
            if (i == 2) {
                l.this.b = true;
            }
        }
    }

    public l(Context context, List<CampaignEx> list, String str, int i) {
        this.m = 1;
        try {
            boolean b2 = j.a().b(i);
            this.q = b2;
            if (b2) {
                this.j = str;
                this.m = i;
                this.p = new k(list, str, i);
                return;
            }
        } catch (Exception unused) {
            this.p = null;
            this.q = false;
        }
        this.h = com.mbridge.msdk.foundation.controller.c.m().d();
        List<CampaignEx> list2 = this.f5281a;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.j = str;
        this.m = i;
        a(this.f5281a);
    }

    private boolean a(CampaignEx.c cVar) {
        return true;
    }

    public CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> c() {
        k kVar;
        return (!this.q || (kVar = this.p) == null) ? this.g : kVar.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x003e A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00db A[Catch: all -> 0x022c, TryCatch #1 {, blocks: (B:12:0x0016, B:14:0x001f, B:15:0x0021, B:16:0x0027, B:18:0x002d, B:21:0x0036, B:22:0x003e, B:24:0x0044, B:27:0x0054, B:30:0x005b, B:32:0x0061, B:33:0x0063, B:36:0x006f, B:37:0x007f, B:39:0x0090, B:41:0x0094, B:42:0x009c, B:43:0x00a0, B:49:0x00b5, B:51:0x00b9, B:52:0x00cd, B:54:0x00d1, B:55:0x00d7, B:57:0x00db, B:59:0x00df, B:60:0x00f3, B:62:0x00f7, B:63:0x0125, B:65:0x012a, B:66:0x0130, B:70:0x016d, B:71:0x0171, B:73:0x0176, B:78:0x017e, B:81:0x0183, B:83:0x0187, B:84:0x0190, B:86:0x0194, B:90:0x019e, B:91:0x01a2, B:94:0x01c7, B:97:0x01cc, B:99:0x01d0, B:104:0x01de, B:110:0x01e7, B:112:0x01f2, B:115:0x01f6, B:119:0x01fa, B:122:0x0200, B:135:0x020b, B:140:0x0213, B:125:0x0218, B:130:0x0225, B:133:0x0222, B:154:0x00fc, B:156:0x0100, B:159:0x0115, B:161:0x011b, B:163:0x011f, B:177:0x022a), top: B:11:0x0016, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012a A[Catch: all -> 0x022c, TryCatch #1 {, blocks: (B:12:0x0016, B:14:0x001f, B:15:0x0021, B:16:0x0027, B:18:0x002d, B:21:0x0036, B:22:0x003e, B:24:0x0044, B:27:0x0054, B:30:0x005b, B:32:0x0061, B:33:0x0063, B:36:0x006f, B:37:0x007f, B:39:0x0090, B:41:0x0094, B:42:0x009c, B:43:0x00a0, B:49:0x00b5, B:51:0x00b9, B:52:0x00cd, B:54:0x00d1, B:55:0x00d7, B:57:0x00db, B:59:0x00df, B:60:0x00f3, B:62:0x00f7, B:63:0x0125, B:65:0x012a, B:66:0x0130, B:70:0x016d, B:71:0x0171, B:73:0x0176, B:78:0x017e, B:81:0x0183, B:83:0x0187, B:84:0x0190, B:86:0x0194, B:90:0x019e, B:91:0x01a2, B:94:0x01c7, B:97:0x01cc, B:99:0x01d0, B:104:0x01de, B:110:0x01e7, B:112:0x01f2, B:115:0x01f6, B:119:0x01fa, B:122:0x0200, B:135:0x020b, B:140:0x0213, B:125:0x0218, B:130:0x0225, B:133:0x0222, B:154:0x00fc, B:156:0x0100, B:159:0x0115, B:161:0x011b, B:163:0x011f, B:177:0x022a), top: B:11:0x0016, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d() {
        int g;
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.j();
            return;
        }
        b();
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                if (!a(this.g)) {
                    this.b = true;
                }
                Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = this.g.iterator();
                while (it.hasNext()) {
                    Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                    if (next != null) {
                        Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it2 = next.entrySet().iterator();
                        while (it2.hasNext()) {
                            com.mbridge.msdk.videocommon.download.a value = it2.next().getValue();
                            if (value != null && !value.o()) {
                                if (this.m == 95) {
                                    this.b = true;
                                }
                                int j = value.j();
                                CampaignEx c = value.c();
                                if (c != null && j == 0) {
                                    j = com.mbridge.msdk.videocommon.download.b.getInstance().b(c.getId(), c.getVideoUrlEncode());
                                }
                                int i = j;
                                value.a(new b(c));
                                int b2 = b(c);
                                if (this.m == 1) {
                                    if (this.n == null) {
                                        this.n = com.mbridge.msdk.setting.l.i(this.j);
                                    }
                                    b2 = a(c);
                                }
                                int i2 = b2;
                                value.d(i2);
                                int i3 = this.m;
                                if (i3 != 94 && i3 != 287 && i3 != 95) {
                                    if (i3 == 298) {
                                        if (this.o == null) {
                                            this.o = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                                        }
                                        com.mbridge.msdk.setting.l lVar = this.o;
                                        if (lVar != null) {
                                            g = lVar.i();
                                            if (this.m == 1) {
                                                if (this.n == null) {
                                                    this.n = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                                                }
                                                com.mbridge.msdk.setting.l lVar2 = this.n;
                                                if (lVar2 != null) {
                                                    g = lVar2.i();
                                                }
                                            }
                                            value.b(g);
                                            int videoCtnType = c != null ? c.getVideoCtnType() : 1;
                                            value.e(videoCtnType);
                                            p0.b("UnitCacheCtroller", "ready_rate : " + i2 + " cd_rate : " + g + " videoCtnType : " + videoCtnType);
                                            if (a(value, b(c))) {
                                                String videoUrlEncode = c != null ? c.getVideoUrlEncode() : "";
                                                com.mbridge.msdk.videocommon.listener.a aVar = this.c;
                                                if (aVar != null) {
                                                    int i4 = this.m;
                                                    if (i4 == 297 || i4 == 298) {
                                                        try {
                                                            aVar.a(videoUrlEncode);
                                                        } catch (Exception e) {
                                                            if (MBridgeConstans.DEBUG) {
                                                                p0.b("UnitCacheCtroller", e.getMessage());
                                                            }
                                                        }
                                                    }
                                                }
                                                ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.e;
                                                if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                                                    com.mbridge.msdk.videocommon.listener.a aVar2 = this.e.get((c != null ? c.getRequestId() : "") + "_" + c.getSecondRequestIndex());
                                                    if (aVar2 != null) {
                                                        try {
                                                            aVar2.a(videoUrlEncode);
                                                        } catch (Exception e2) {
                                                            if (MBridgeConstans.DEBUG) {
                                                                p0.b("UnitCacheCtroller", e2.getMessage());
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (i != 1 && (i != 5 || !a(value, i2))) {
                                                if (i == 4) {
                                                    continue;
                                                } else {
                                                    if (l0.s(this.h) != 9 && this.l == 2) {
                                                        return;
                                                    }
                                                    if (i == 2 || this.b) {
                                                        value.a(this.f);
                                                        if (a(value, i2)) {
                                                            int i5 = this.m;
                                                            if (i5 == 94 || i5 == 287) {
                                                                value.w();
                                                            }
                                                        } else {
                                                            int i6 = this.m;
                                                            if (i6 == 1 || i6 == 95 || i6 == 298) {
                                                                this.b = false;
                                                            }
                                                            value.w();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    g = 0;
                                    if (this.m == 1) {
                                    }
                                    value.b(g);
                                    if (c != null) {
                                    }
                                    value.e(videoCtnType);
                                    p0.b("UnitCacheCtroller", "ready_rate : " + i2 + " cd_rate : " + g + " videoCtnType : " + videoCtnType);
                                    if (a(value, b(c))) {
                                    }
                                    if (i != 1) {
                                        continue;
                                    } else if (i == 4) {
                                    }
                                }
                                if (this.k == null) {
                                    this.k = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.j, this.m == 287);
                                }
                                com.mbridge.msdk.videocommon.setting.c cVar = this.k;
                                g = cVar != null ? cVar.g() : 0;
                                value.b(g);
                                if (c != null) {
                                }
                                value.e(videoCtnType);
                                p0.b("UnitCacheCtroller", "ready_rate : " + i2 + " cd_rate : " + g + " videoCtnType : " + videoCtnType);
                                if (a(value, b(c))) {
                                }
                                if (i != 1) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void e() {
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.k();
            return;
        }
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = this.g.iterator();
                    while (it.hasNext()) {
                        Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                        if (next != null) {
                            Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it2 = next.entrySet().iterator();
                            while (it2.hasNext()) {
                                com.mbridge.msdk.videocommon.download.a value = it2.next().getValue();
                                if (value != null && value.j() == 1) {
                                    value.c("playing and stop download");
                                    value.b();
                                    this.g.remove(next);
                                    return;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("UnitCacheCtroller", th.getMessage());
                }
            }
        }
    }

    public void f(CampaignEx campaignEx) {
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.h(campaignEx);
            return;
        }
        List<CampaignEx> list = this.f5281a;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        a(this.f5281a);
    }

    public void b(List<CampaignEx> list) {
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.a(list);
            return;
        }
        List<CampaignEx> list2 = this.f5281a;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        a(this.f5281a);
    }

    public void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.a(aVar);
        } else {
            this.c = aVar;
        }
    }

    private int c(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.o == null) {
                    this.o = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                }
                return this.o.C();
            }
            if (campaignEx.getAdType() == 42) {
                return a((CampaignEx) null);
            }
            if (this.k == null) {
                this.k = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.j, false);
            }
            return this.k.w();
        } catch (Throwable th) {
            p0.b("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }

    public void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.a(str, aVar);
            return;
        }
        if (this.e == null) {
            this.e = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.e.put(str, aVar);
    }

    /* compiled from: UnitCacheCtroller.java */
    class b implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f5283a;

        b(CampaignEx campaignEx) {
            this.f5283a = campaignEx;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar;
            if (l.this.c != null) {
                l.this.c.a(str);
            }
            if (l.this.e == null || l.this.e.size() <= 0 || this.f5283a == null || (aVar = (com.mbridge.msdk.videocommon.listener.a) l.this.e.get(this.f5283a.getRequestId() + "_" + this.f5283a.getSecondRequestIndex())) == null) {
                return;
            }
            aVar.a(str);
            l.this.e.remove(this.f5283a.getRequestId() + "_" + this.f5283a.getSecondRequestIndex());
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar;
            if (l.this.c != null) {
                l.this.c.a(str, str2);
            }
            CampaignEx campaignEx = this.f5283a;
            if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || this.f5283a.getRsIgnoreCheckRule().size() <= 0 || !this.f5283a.getRsIgnoreCheckRule().contains(0)) {
                if (l.this.e == null || l.this.e.size() <= 0 || this.f5283a == null || (aVar = (com.mbridge.msdk.videocommon.listener.a) l.this.e.get(this.f5283a.getRequestId() + "_" + this.f5283a.getSecondRequestIndex())) == null) {
                    return;
                }
                aVar.a(str, str2);
                l.this.e.remove(this.f5283a.getRequestId() + "_" + this.f5283a.getSecondRequestIndex());
                return;
            }
            p0.c("UnitCacheCtroller", "Is not check video download status");
        }
    }

    public void b() {
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList;
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.a();
            return;
        }
        if (r0.a().a("u_n_c_e_d", true) || (copyOnWriteArrayList = this.g) == null) {
            return;
        }
        try {
            synchronized (copyOnWriteArrayList) {
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (i < this.g.size()) {
                    Map<String, com.mbridge.msdk.videocommon.download.a> map = this.g.get(i);
                    Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        com.mbridge.msdk.videocommon.download.a value = it.next().getValue();
                        if (value != null) {
                            if (currentTimeMillis - value.i() > this.i * 1000 && value.j() == 1) {
                                value.c("download timeout");
                                value.c(this.l);
                                value.b();
                                this.g.remove(map);
                                i--;
                            }
                            if (value.j() != 1 && value.j() != 5 && value.j() != 0) {
                                value.b();
                                this.g.remove(map);
                                i--;
                            }
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(List<CampaignEx> list) {
        String str;
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList;
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.get(0) != null) {
            this.d = list.get(0).getCurrentLocalRid();
        }
        a();
        b();
        int i = this.m;
        if (i != 1) {
            if (i != 287) {
                if (i == 298) {
                    com.mbridge.msdk.setting.l a2 = com.mbridge.msdk.setting.h.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                    this.o = a2;
                    if (a2 == null) {
                        this.o = com.mbridge.msdk.setting.h.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                    }
                    com.mbridge.msdk.setting.l lVar = this.o;
                    if (lVar != null) {
                        this.i = lVar.p();
                        this.l = this.o.q();
                    }
                } else if (i != 94) {
                    if (i == 95) {
                        try {
                            if (!TextUtils.isEmpty(this.j)) {
                                com.mbridge.msdk.setting.l e = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                                if (e == null) {
                                    e = com.mbridge.msdk.setting.l.j(this.j);
                                }
                                if (e != null) {
                                    this.i = e.p();
                                    this.l = e.q();
                                }
                            }
                        } catch (Exception unused) {
                            p0.b("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                            return;
                        }
                    }
                }
            }
            try {
                com.mbridge.msdk.videocommon.setting.a c = com.mbridge.msdk.videocommon.setting.b.b().c();
                if (c == null) {
                    com.mbridge.msdk.videocommon.setting.b.b().a();
                }
                if (c != null) {
                    this.i = c.c();
                }
                if (!TextUtils.isEmpty(this.j)) {
                    this.k = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                }
                com.mbridge.msdk.videocommon.setting.c cVar = this.k;
                if (cVar != null) {
                    this.l = cVar.l();
                }
            } catch (Exception unused2) {
                p0.b("UnitCacheCtroller", "make sure your had put reward jar into your project");
                return;
            }
        } else {
            try {
                if (!TextUtils.isEmpty(this.j)) {
                    com.mbridge.msdk.setting.l e2 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.j);
                    this.n = e2;
                    if (e2 == null) {
                        this.n = com.mbridge.msdk.setting.l.i(this.j);
                    }
                    com.mbridge.msdk.setting.l lVar2 = this.n;
                    if (lVar2 != null) {
                        this.i = lVar2.p();
                        this.l = this.n.q();
                    }
                }
            } catch (Exception unused3) {
                p0.b("UnitCacheCtroller", "make sure your had put native video jar into your project");
                return;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            CampaignEx campaignEx = list.get(i2);
            if (campaignEx != null) {
                int i3 = this.m;
                if (i3 != 94 && i3 != 287) {
                    str = campaignEx.getId() + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                } else {
                    str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                }
                if ((d(campaignEx) || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && (copyOnWriteArrayList = this.g) != null) {
                    synchronized (copyOnWriteArrayList) {
                        int i4 = 0;
                        while (true) {
                            try {
                                if (i4 < this.g.size()) {
                                    Map<String, com.mbridge.msdk.videocommon.download.a> map = this.g.get(i4);
                                    if (map == null || !map.containsKey(str)) {
                                        i4++;
                                    } else {
                                        com.mbridge.msdk.videocommon.download.a aVar = map.get(str);
                                        if (aVar != null) {
                                            aVar.e(campaignEx);
                                            aVar.c(this.l);
                                            aVar.b(false);
                                            map.remove(str);
                                            map.put(str, aVar);
                                            this.g.set(i4, map);
                                        }
                                        e(campaignEx);
                                    }
                                } else {
                                    com.mbridge.msdk.videocommon.download.a aVar2 = new com.mbridge.msdk.videocommon.download.a(this.h, campaignEx, this.j, this.l);
                                    aVar2.c(this.l);
                                    aVar2.a(this.m);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(str, aVar2);
                                    this.g.add(hashMap);
                                    break;
                                }
                            } finally {
                            }
                        }
                    }
                }
            }
        }
        List<CampaignEx> list2 = this.f5281a;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.f5281a.clear();
    }

    private void e(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("cache", 1);
                eVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(b(campaignEx)));
                if (b(campaignEx) == 100) {
                    eVar.a("resumed_breakpoint", "2");
                } else {
                    eVar.a("resumed_breakpoint", "1");
                }
                eVar.a("resource_type", 4);
                eVar.a("scenes", "1");
                eVar.a("url", campaignEx.getVideoUrlEncode());
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_download_start", campaignEx, eVar);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return c(campaignEx);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01f4 A[Catch: Exception -> 0x02a6, all -> 0x02a8, TryCatch #1 {all -> 0x02a8, blocks: (B:12:0x001b, B:17:0x0027, B:19:0x0033, B:21:0x006e, B:22:0x0073, B:24:0x007b, B:25:0x008b, B:27:0x0091, B:29:0x009f, B:32:0x00a9, B:33:0x00b3, B:35:0x00b9, B:50:0x00da, B:53:0x00e2, B:56:0x00e9, B:58:0x00f9, B:59:0x0101, B:63:0x015f, B:65:0x0171, B:68:0x017b, B:72:0x0182, B:74:0x0188, B:75:0x0220, B:79:0x0195, B:83:0x019d, B:86:0x019f, B:88:0x01a5, B:90:0x01ab, B:92:0x01ad, B:95:0x01b0, B:97:0x01bd, B:99:0x01c7, B:101:0x01d4, B:106:0x01ee, B:108:0x01f4, B:110:0x01fa, B:112:0x0203, B:114:0x0205, B:120:0x0218, B:123:0x0230, B:126:0x023b, B:128:0x023f, B:130:0x0249, B:132:0x024f, B:135:0x0255, B:137:0x0257, B:140:0x0261, B:142:0x026b, B:144:0x0271, B:147:0x0277, B:150:0x010f, B:152:0x0115, B:154:0x011f, B:157:0x0128, B:159:0x012e, B:161:0x0134, B:162:0x013f, B:164:0x0145, B:167:0x014b, B:169:0x014d, B:171:0x0157, B:174:0x015d, B:200:0x02ad, B:181:0x02b0, B:185:0x0035, B:187:0x0041, B:190:0x0057, B:192:0x029d, B:193:0x02a4, B:197:0x004b), top: B:11:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0205 A[Catch: Exception -> 0x02a6, all -> 0x02a8, TRY_ENTER, TryCatch #1 {all -> 0x02a8, blocks: (B:12:0x001b, B:17:0x0027, B:19:0x0033, B:21:0x006e, B:22:0x0073, B:24:0x007b, B:25:0x008b, B:27:0x0091, B:29:0x009f, B:32:0x00a9, B:33:0x00b3, B:35:0x00b9, B:50:0x00da, B:53:0x00e2, B:56:0x00e9, B:58:0x00f9, B:59:0x0101, B:63:0x015f, B:65:0x0171, B:68:0x017b, B:72:0x0182, B:74:0x0188, B:75:0x0220, B:79:0x0195, B:83:0x019d, B:86:0x019f, B:88:0x01a5, B:90:0x01ab, B:92:0x01ad, B:95:0x01b0, B:97:0x01bd, B:99:0x01c7, B:101:0x01d4, B:106:0x01ee, B:108:0x01f4, B:110:0x01fa, B:112:0x0203, B:114:0x0205, B:120:0x0218, B:123:0x0230, B:126:0x023b, B:128:0x023f, B:130:0x0249, B:132:0x024f, B:135:0x0255, B:137:0x0257, B:140:0x0261, B:142:0x026b, B:144:0x0271, B:147:0x0277, B:150:0x010f, B:152:0x0115, B:154:0x011f, B:157:0x0128, B:159:0x012e, B:161:0x0134, B:162:0x013f, B:164:0x0145, B:167:0x014b, B:169:0x014d, B:171:0x0157, B:174:0x015d, B:200:0x02ad, B:181:0x02b0, B:185:0x0035, B:187:0x0041, B:190:0x0057, B:192:0x029d, B:193:0x02a4, B:197:0x004b), top: B:11:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b A[Catch: all -> 0x02a8, Exception -> 0x02aa, TryCatch #0 {Exception -> 0x02aa, blocks: (B:12:0x001b, B:17:0x0027, B:21:0x006e, B:22:0x0073, B:24:0x007b, B:25:0x008b, B:27:0x0091, B:29:0x009f, B:185:0x0035, B:187:0x0041, B:190:0x0057, B:197:0x004b), top: B:11:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.mbridge.msdk.videocommon.download.a b(int i, boolean z) {
        com.mbridge.msdk.videocommon.download.a aVar;
        int i2;
        char c;
        int i3;
        List<CampaignEx> list;
        int i4;
        List<CampaignEx> list2;
        com.mbridge.msdk.videocommon.download.a aVar2;
        int i5;
        char c2;
        k kVar;
        int i6 = i;
        boolean z2 = z;
        if (this.q && (kVar = this.p) != null) {
            return kVar.i();
        }
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.g;
        com.mbridge.msdk.videocommon.download.a aVar3 = null;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                try {
                    i2 = this.m;
                    c = 287;
                    i3 = 94;
                } catch (Exception e) {
                    e = e;
                    aVar = aVar3;
                }
                try {
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return aVar;
                }
                if (i2 != 94 && i2 != 287) {
                    list = com.mbridge.msdk.videocommon.cache.a.a().c(this.j, 1);
                    if (list == null) {
                        return null;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    i4 = 0;
                    while (i4 < this.g.size()) {
                        Map<String, com.mbridge.msdk.videocommon.download.a> map = this.g.get(i4);
                        Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.download.a value = it.next().getValue();
                            if (value == null || value.c() == null) {
                                list2 = list;
                                aVar2 = aVar3;
                                i5 = i3;
                            } else {
                                aVar2 = aVar3;
                                CampaignEx c3 = value.c();
                                Iterator<CampaignEx> it2 = list.iterator();
                                boolean z3 = false;
                                while (it2.hasNext()) {
                                    if (c3.getId().equals(it2.next().getId())) {
                                        z3 = true;
                                    }
                                }
                                if (z3 && ((!z2 || c3.isBidCampaign()) && (z2 || !c3.isBidCampaign()))) {
                                    String str = c3.getendcard_url();
                                    String videoUrlEncode = c3.getVideoUrlEncode();
                                    String str2 = "";
                                    if (c3.getRewardTemplateMode() != null) {
                                        str2 = c3.getRewardTemplateMode().e();
                                    }
                                    String str3 = str2;
                                    CampaignEx.c rewardTemplateMode = c3.getRewardTemplateMode();
                                    if (this.m == i3 || i6 == 287) {
                                        if (TextUtils.isEmpty(str3) || str3.contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a(this.m, c3, str3)) {
                                            if (b(str, c3)) {
                                                if (value.o()) {
                                                    value.t();
                                                } else if (z0.a(videoUrlEncode)) {
                                                    if (a(rewardTemplateMode)) {
                                                        return value;
                                                    }
                                                } else if (a(value, b(c3)) && a(rewardTemplateMode)) {
                                                    return value;
                                                }
                                            }
                                        }
                                        list2 = list;
                                        i5 = 94;
                                        c2 = 287;
                                        z2 = z;
                                        c = c2;
                                        aVar3 = aVar2;
                                        i3 = i5;
                                        list = list2;
                                        i6 = i;
                                    }
                                    boolean isEmpty = TextUtils.isEmpty(value.f());
                                    int j = value.j();
                                    if (this.m == 298 && a(value, b(c3))) {
                                        return value;
                                    }
                                    if (j == 5) {
                                        if (value.o()) {
                                            value.t();
                                            this.g.remove(map);
                                            list2 = list;
                                        } else {
                                            if (isEmpty) {
                                                return (a(str, c3) && a(rewardTemplateMode)) ? value : aVar2;
                                            }
                                            value.a(0, 0);
                                            if (this.m == 95) {
                                                return value;
                                            }
                                            list2 = list;
                                            i5 = 94;
                                            c2 = 287;
                                            z2 = z;
                                            c = c2;
                                            aVar3 = aVar2;
                                            i3 = i5;
                                            list = list2;
                                            i6 = i;
                                        }
                                    } else {
                                        if (!r0.a().a("u_n_c_e_d", true)) {
                                            long i7 = value.i();
                                            if (value.j() == 1) {
                                                list2 = list;
                                                if (currentTimeMillis - i7 > this.i * 1000) {
                                                    value.c("download timeout");
                                                    value.b();
                                                    this.g.remove(map);
                                                    i4--;
                                                    int i8 = this.m;
                                                    if (i8 != 1) {
                                                        if (i8 == 94) {
                                                        }
                                                    }
                                                    z2 = z;
                                                    list = list2;
                                                    aVar3 = aVar2;
                                                    c = 287;
                                                    i3 = 94;
                                                    i6 = i;
                                                }
                                                if (this.m != 95) {
                                                    if (!value.o()) {
                                                        return value;
                                                    }
                                                    value.t();
                                                    this.g.remove(map);
                                                } else if (!r0.a().a("u_n_c_e_d", true) && (j == 4 || j == 2)) {
                                                    this.g.remove(map);
                                                    value.b();
                                                } else {
                                                    if (j == 1) {
                                                        if (value.o()) {
                                                            i5 = 94;
                                                            c2 = 287;
                                                            z2 = z;
                                                            c = c2;
                                                            aVar3 = aVar2;
                                                            i3 = i5;
                                                            list = list2;
                                                            i6 = i;
                                                        } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY && a(value, b(c3)) && a(str, c3) && a(rewardTemplateMode)) {
                                                            return value;
                                                        }
                                                    }
                                                    int i9 = this.m;
                                                    i5 = 94;
                                                    c2 = 287;
                                                    if ((i9 == 94 || i9 == 287) && a(value, b(c3)) && a(str, c3) && a(rewardTemplateMode)) {
                                                        return value;
                                                    }
                                                    z2 = z;
                                                    c = c2;
                                                    aVar3 = aVar2;
                                                    i3 = i5;
                                                    list = list2;
                                                    i6 = i;
                                                }
                                            }
                                        }
                                        list2 = list;
                                        if (this.m != 95) {
                                        }
                                    }
                                    i4--;
                                    z2 = z;
                                    list = list2;
                                    aVar3 = aVar2;
                                    c = 287;
                                    i3 = 94;
                                    i6 = i;
                                }
                                list2 = list;
                                i5 = i3;
                            }
                            c2 = c;
                            z2 = z;
                            c = c2;
                            aVar3 = aVar2;
                            i3 = i5;
                            list = list2;
                            i6 = i;
                        }
                        i4++;
                        z2 = z;
                        i3 = i3;
                        list = list;
                        i6 = i;
                    }
                    aVar = aVar3;
                    return aVar;
                }
                List<CampaignEx> b2 = com.mbridge.msdk.videocommon.cache.a.a().b(this.j, 1, z2);
                if ((b2 == null || b2.size() == 0) && (i6 == 94 || i6 == 287)) {
                    b2 = com.mbridge.msdk.videocommon.cache.a.a().c(this.j, 1, z2);
                }
                if (b2 != null) {
                    p0.a("UnitCacheCtroller", "UnitCache isReady campaignList = " + b2.size());
                    list = b2;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    i4 = 0;
                    while (i4 < this.g.size()) {
                    }
                    aVar = aVar3;
                    return aVar;
                }
                p0.a("UnitCacheCtroller", "UnitCache isReady campaignList = 0");
                return null;
            } finally {
            }
        }
    }

    public l(Context context, CampaignEx campaignEx, String str, int i) {
        this.m = 1;
        try {
            boolean b2 = j.a().b(i);
            this.q = b2;
            if (b2) {
                this.j = str;
                this.m = i;
                this.p = new k(campaignEx, str, i);
                return;
            }
        } catch (Exception unused) {
            this.p = null;
            this.q = false;
        }
        this.h = com.mbridge.msdk.foundation.controller.c.m().d();
        List<CampaignEx> list = this.f5281a;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        this.j = str;
        this.m = i;
        a(this.f5281a);
    }

    private boolean d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void a() {
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i = 0;
                    while (i < this.g.size()) {
                        Map<String, com.mbridge.msdk.videocommon.download.a> map = this.g.get(i);
                        Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.download.a value = it.next().getValue();
                            if (value != null && value.c() != null && value.o()) {
                                value.t();
                                this.g.remove(map);
                                i--;
                            }
                        }
                        i++;
                    }
                }
            } catch (Throwable unused) {
                p0.b("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    public List<com.mbridge.msdk.videocommon.download.a> a(String str, int i, boolean z, List<CampaignEx> list, boolean z2, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        long j;
        String str2;
        String str3;
        int i2;
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            return kVar.a(list, z2);
        }
        List<CampaignEx> list2 = list;
        ArrayList arrayList = new ArrayList();
        String str4 = "";
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    while (i3 < this.g.size()) {
                        Map<String, com.mbridge.msdk.videocommon.download.a> map = this.g.get(i3);
                        Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            try {
                                com.mbridge.msdk.videocommon.download.a value = it.next().getValue();
                                if (value != null && value.c() != null) {
                                    CampaignEx c = value.c();
                                    boolean z3 = false;
                                    for (CampaignEx campaignEx : list2) {
                                        if (c != null && campaignEx != null && !TextUtils.isEmpty(c.getRequestId()) && !TextUtils.isEmpty(campaignEx.getRequestId()) && c.getId().equals(campaignEx.getId()) && c.getRequestId().equals(campaignEx.getRequestId())) {
                                            if (!TextUtils.isEmpty(campaignEx.getNLRid())) {
                                                c.setNLRid(campaignEx.getNLRid());
                                            }
                                            z3 = true;
                                        }
                                    }
                                    if (!z3) {
                                        str4 = "campaign is not available";
                                        j = currentTimeMillis;
                                    } else if ((!z || c.isBidCampaign()) && (z || !c.isBidCampaign())) {
                                        String str5 = c.getendcard_url();
                                        String videoUrlEncode = c.getVideoUrlEncode();
                                        String str6 = "";
                                        if (c.getRewardTemplateMode() != null) {
                                            str6 = c.getRewardTemplateMode().e();
                                        }
                                        String str7 = str6;
                                        String str8 = str4;
                                        try {
                                            CampaignEx.c rewardTemplateMode = c.getRewardTemplateMode();
                                            j = currentTimeMillis;
                                            if (i == 94 || i == 287) {
                                                if (!TextUtils.isEmpty(str7) && !str7.contains(CampaignEx.KEY_IS_CMPT_ENTRY) && !a(i, c, str7)) {
                                                    str3 = "template is null or download is not ready";
                                                } else {
                                                    if (b(str5, c)) {
                                                        if (value.o()) {
                                                            value.t();
                                                            str3 = "task is displayed";
                                                        } else {
                                                            if (z0.a(videoUrlEncode)) {
                                                                if (a(rewardTemplateMode)) {
                                                                    arrayList.add(value);
                                                                    str4 = str8;
                                                                } else {
                                                                    str2 = "image list is downloading or fail";
                                                                }
                                                            } else if (a(value, b(c), z2) && a(rewardTemplateMode)) {
                                                                arrayList.add(value);
                                                                str4 = str8;
                                                            } else {
                                                                str2 = "video and image list is downloading or fail";
                                                            }
                                                            currentTimeMillis = j;
                                                        }
                                                    } else {
                                                        str2 = "endcard is downloading or fail";
                                                    }
                                                    str8 = str2;
                                                }
                                                str4 = str3;
                                            }
                                            boolean isEmpty = TextUtils.isEmpty(value.f());
                                            int j2 = value.j();
                                            if (j2 == 5) {
                                                if (value.o()) {
                                                    value.t();
                                                    this.g.remove(map);
                                                    i3--;
                                                    str3 = "task is displayed";
                                                } else {
                                                    if (!isEmpty) {
                                                        value.a(0, 0);
                                                        if (i == 95) {
                                                            arrayList.add(value);
                                                        } else {
                                                            str3 = "resource path is not effective";
                                                        }
                                                    } else {
                                                        if (!a(str5, c) || !a(rewardTemplateMode)) {
                                                            return null;
                                                        }
                                                        arrayList.add(value);
                                                    }
                                                    str4 = str8;
                                                }
                                                str4 = str3;
                                            } else {
                                                int i4 = i3;
                                                if (r0.a().a("u_n_c_e_d", true)) {
                                                    i3 = i4;
                                                } else {
                                                    long i5 = value.i();
                                                    if (value.j() != 1 || j - i5 <= this.i * 1000) {
                                                        i3 = i4;
                                                    } else {
                                                        value.c("download timeout");
                                                        value.b();
                                                        this.g.remove(map);
                                                        i3 = i4 - 1;
                                                        if (i != 1 && i != 94) {
                                                            str8 = "video download time over dlct";
                                                        }
                                                        list2 = list;
                                                        str4 = "video download time over dlct";
                                                        currentTimeMillis = j;
                                                    }
                                                    i2 = (j2 == 4 || j2 == 2) ? 1 : 1;
                                                    this.g.remove(map);
                                                    value.b();
                                                    i3--;
                                                    str3 = "video download stop or pause";
                                                    str4 = str3;
                                                }
                                                if (j2 == i2) {
                                                    if (value.o()) {
                                                        str3 = "video was displayed";
                                                        str4 = str3;
                                                    } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                        if (a(value, b(c), z2) && a(str5, c) && a(rewardTemplateMode)) {
                                                            arrayList.add(value);
                                                            str4 = str8;
                                                        } else {
                                                            str8 = "video or endcard or image list is downloading or fail";
                                                        }
                                                    }
                                                }
                                                if (i != 94 && i != 287) {
                                                    list2 = list;
                                                    str4 = str8;
                                                    currentTimeMillis = j;
                                                }
                                                if (a(value, b(c), z2) && a(str5, c) && a(rewardTemplateMode)) {
                                                    arrayList.add(value);
                                                    str4 = str8;
                                                } else {
                                                    str3 = "video or endcard or image list is downloading or fail";
                                                    str4 = str3;
                                                }
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            str4 = str8;
                                            e.printStackTrace();
                                            if (arrayList.size() == 0) {
                                                eVar.a("is_ready_fail_reason", str4);
                                            }
                                            return arrayList;
                                        }
                                    } else {
                                        list2 = list;
                                    }
                                    list2 = list;
                                    currentTimeMillis = j;
                                }
                                j = currentTimeMillis;
                                str4 = "task or task's campaign is NULL";
                                i3 = i3;
                                list2 = list;
                                currentTimeMillis = j;
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        i3++;
                        list2 = list;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
        }
        try {
            if (arrayList.size() == 0 && eVar != null) {
                eVar.a("is_ready_fail_reason", str4);
            }
        } catch (Throwable th) {
            p0.b("UnitCacheCtroller", th.getMessage());
        }
        return arrayList;
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !d(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
            return z0.b(H5DownLoadManager.getInstance().getH5ResAddress(str)) || z0.b(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str));
        }
        p0.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
        return true;
    }

    public void b(String str) {
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList;
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            kVar.c(str);
            return;
        }
        try {
            synchronized (this.g) {
                if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.g) != null && copyOnWriteArrayList.size() > 0) {
                    Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = this.g.iterator();
                    while (it.hasNext()) {
                        Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                        if (next != null) {
                            for (Map.Entry<String, com.mbridge.msdk.videocommon.download.a> entry : next.entrySet()) {
                                if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                    this.g.remove(next);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("UnitCacheCtroller", e.getMessage());
            }
        }
    }

    public boolean a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx = list.get(i);
            if (campaignEx == null || !a(new com.mbridge.msdk.videocommon.download.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, str, this.l), b(campaignEx), false) || !a(campaignEx.getendcard_url(), campaignEx)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(com.mbridge.msdk.videocommon.download.a aVar, int i) {
        long h = aVar.h();
        long e = aVar.e();
        if (TextUtils.isEmpty(aVar.d())) {
            p0.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i == 0) {
            if (aVar.c() != null && !TextUtils.isEmpty(aVar.c().getVideoUrlEncode())) {
                return true;
            }
        } else if (e > 0 && h * 100 >= e * i) {
            if (i != 100 || aVar.j() == 5) {
                return true;
            }
            aVar.b();
            return false;
        }
        return false;
    }

    public static boolean a(com.mbridge.msdk.videocommon.download.a aVar, int i, boolean z) {
        long h = aVar.h();
        long e = aVar.e();
        if (TextUtils.isEmpty(aVar.d())) {
            p0.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx c = aVar.c();
        if (c != null) {
            if (c.getRsIgnoreCheckRule() != null && c.getRsIgnoreCheckRule().size() > 0 && c.getRsIgnoreCheckRule().contains(0)) {
                p0.c("UnitCacheCtroller", "Is not check video download status");
                return true;
            }
            if (c.getIsTimeoutCheckVideoStatus() == 1 && c.getVideoCheckType() == 1) {
                return true;
            }
            if (z && c.getVideoCheckType() == 1) {
                if (i == 0) {
                    return true;
                }
                if ((e != 0 || h != 0) && h >= (i / 100) * e) {
                    c.setIsTimeoutCheckVideoStatus(1);
                    return true;
                }
            }
        }
        return a(aVar, i);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                return (campaignEx.isDynamicView() && !u0.l(str)) || z0.a(str) || b(str, campaignEx);
            }
            p0.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } catch (Throwable th) {
            p0.b("UnitCacheCtroller", th.getMessage(), th);
            return false;
        }
    }

    private boolean a(int i, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            p0.c("UnitCacheCtroller", "Is not check template download status");
            return true;
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0) {
            p0.a("UnitCacheCtroller", "check template 下载情况：" + H5DownLoadManager.getInstance().getH5ResAddress(str));
            if (H5DownLoadManager.getInstance().getH5ResAddress(str) == null) {
                return false;
            }
        }
        return true;
    }

    public com.mbridge.msdk.videocommon.download.a a(int i, boolean z) {
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            return kVar.d();
        }
        try {
            return b(i, z);
        } catch (Throwable th) {
            p0.b("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    public com.mbridge.msdk.videocommon.download.a a(String str) {
        k kVar;
        if (this.q && (kVar = this.p) != null) {
            return kVar.a(str);
        }
        CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = this.g.iterator();
                while (it.hasNext()) {
                    Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                    if (next != null && next.containsKey(str)) {
                        return next.get(str);
                    }
                }
            } catch (Throwable unused) {
                p0.b("UnitCacheCtroller", "failed to get campaignTast by cid");
            }
            return null;
        }
    }

    private boolean a(CopyOnWriteArrayList<Map<String, com.mbridge.msdk.videocommon.download.a>> copyOnWriteArrayList) {
        try {
            Iterator<Map<String, com.mbridge.msdk.videocommon.download.a>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                Map<String, com.mbridge.msdk.videocommon.download.a> next = it.next();
                if (next != null) {
                    Iterator<Map.Entry<String, com.mbridge.msdk.videocommon.download.a>> it2 = next.entrySet().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getValue().j() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private int a(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.setting.l lVar = this.n;
            if (lVar != null) {
                return lVar.C();
            }
            return 100;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            p0.b("UnitCacheCtroller", e.getMessage());
            return 100;
        }
    }
}

package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DownLoadManager.java */
/* loaded from: classes6.dex */
public class b {
    private static volatile b f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5271a = false;
    private ConcurrentHashMap<String, l> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> c;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> d;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> e;

    private b() {
    }

    public static b getInstance() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b();
                }
            }
        }
        return f;
    }

    public a a(String str, String str2) {
        l c = c(str);
        if (c != null) {
            return c.a(str2);
        }
        return null;
    }

    public CopyOnWriteArrayList<CampaignEx> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.d.get(str);
    }

    public l c(String str) {
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.b.get(str);
    }

    public l createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (!this.b.containsKey(str)) {
            l lVar = new l(context, copyOnWriteArrayList, str, i);
            if (i == 94 || i == 287) {
                lVar.a(copyOnWriteArrayList.get(0).getRequestId() + "_" + copyOnWriteArrayList.get(0).getSecondRequestIndex(), aVar);
            } else {
                lVar.a(aVar);
            }
            this.b.put(str, lVar);
            return lVar;
        }
        l lVar2 = this.b.get(str);
        if (lVar2 == null) {
            lVar2 = new l(context, copyOnWriteArrayList, str, i);
            this.b.put(str, lVar2);
        }
        if (i == 94 || i == 287) {
            lVar2.a(copyOnWriteArrayList.get(0).getRequestId() + "_" + copyOnWriteArrayList.get(0).getSecondRequestIndex(), aVar);
        } else {
            lVar2.a(aVar);
        }
        lVar2.b(copyOnWriteArrayList);
        return lVar2;
    }

    public void load(String str) {
        l c = c(str);
        if (c != null) {
            c.d();
        }
    }

    public boolean b(int i, String str, boolean z) {
        try {
            l c = c(str);
            if (c != null) {
                return c.b(i, z) != null;
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public CopyOnWriteArrayList<a> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public void c(String str, String str2) {
        l c = c(str);
        if (c != null) {
            try {
                c.b(str2);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("DownLoadManager", e.getMessage());
                }
            }
        }
    }

    public a a(int i, String str, boolean z) {
        l c = c(str);
        if (c != null) {
            return c.a(i, z);
        }
        return null;
    }

    public boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list) {
        return a(i, str, z, i2, z2, i3, list, false, null);
    }

    public boolean a(int i, String str, List<CampaignEx> list) {
        String str2;
        l c = c(str);
        if (c == null) {
            str2 = str;
            c = createUnitCache(com.mbridge.msdk.foundation.controller.c.m().d(), str2, (CopyOnWriteArrayList<CampaignEx>) list, i, (com.mbridge.msdk.videocommon.listener.a) null);
        } else {
            str2 = str;
        }
        if (c != null) {
            return c.a(list, str2);
        }
        return false;
    }

    public void b(boolean z) {
        this.f5271a = z;
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                l value = it.next().getValue();
                if (value != null) {
                    value.e();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x0185, code lost:
    
        if (r2.size() > 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x018c, code lost:
    
        if (r12.c != null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x018e, code lost:
    
        r12.c = new java.util.concurrent.ConcurrentHashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0197, code lost:
    
        if (r12.e != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0199, code lost:
    
        r12.e = new java.util.concurrent.ConcurrentHashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01a2, code lost:
    
        if (r12.d != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01a4, code lost:
    
        r12.d = new java.util.concurrent.ConcurrentHashMap<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01ab, code lost:
    
        if (r13 == null) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01b1, code lost:
    
        if (r13.size() <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01b3, code lost:
    
        r0 = new java.util.concurrent.CopyOnWriteArrayList<>();
        r2 = new java.util.concurrent.CopyOnWriteArrayList<>();
        r3 = new java.util.concurrent.CopyOnWriteArrayList<>();
        r13 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01ca, code lost:
    
        if (r13.hasNext() == false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01cc, code lost:
    
        r4 = r13.next();
        r5 = new java.util.concurrent.ConcurrentHashMap();
        r6 = r4.c();
        r5.put(r6.getId() + r6.getVideoUrlEncode() + r6.getBidToken(), r4);
        r0.add(r5);
        r2.add(r6);
        r3.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0209, code lost:
    
        a(r14, r0, r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0122, code lost:
    
        if (r3.size() >= r16) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list, boolean z3, com.mbridge.msdk.foundation.same.report.metrics.e eVar) {
        Exception exc;
        boolean z4;
        CampaignEx campaignEx;
        boolean z5 = false;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    l c = c(str);
                    if (c != null) {
                        List<a> a2 = c.a(str, i, z, list, z3, eVar);
                        if (a2 != null && a2.size() != 0) {
                            if (z2) {
                                if (list.size() <= 0 || (campaignEx = list.get(0)) == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                    z4 = false;
                                } else {
                                    p0.c("DownLoadManager", "Is not check video download status with TPL");
                                    z4 = true;
                                }
                                try {
                                    if (i3 == 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (a aVar : a2) {
                                            for (CampaignEx campaignEx2 : list) {
                                                if (aVar != null && aVar.c() != null && campaignEx2 != null && campaignEx2.getId().equals(aVar.c().getId()) && campaignEx2.getRequestId().equals(aVar.c().getRequestId())) {
                                                    arrayList.add(aVar);
                                                }
                                            }
                                        }
                                        z5 = arrayList.size() > 0 ? true : z4;
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        for (a aVar2 : a2) {
                                            for (CampaignEx campaignEx3 : list) {
                                                if (aVar2 != null && aVar2.c() != null && campaignEx3 != null && campaignEx3.getId().equals(aVar2.c().getId()) && campaignEx3.getRequestId().equals(aVar2.c().getRequestId())) {
                                                    arrayList2.add(aVar2);
                                                }
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    exc = e;
                                    z5 = z4;
                                    if (MBridgeConstans.DEBUG) {
                                        exc.printStackTrace();
                                    }
                                    return z5;
                                }
                            } else {
                                ArrayList arrayList3 = new ArrayList();
                                for (a aVar3 : a2) {
                                    for (CampaignEx campaignEx4 : list) {
                                        if (aVar3 != null && aVar3.c() != null && campaignEx4 != null && campaignEx4.getId().equals(aVar3.c().getId()) && campaignEx4.getRequestId().equals(aVar3.c().getRequestId())) {
                                            arrayList3.add(aVar3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return z5;
                }
            } catch (Exception e2) {
                exc = e2;
            }
        }
        return z5;
    }

    public int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> c;
        a value;
        CampaignEx c2;
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                l value2 = it.next().getValue();
                if (value2 != null && (c = value2.c()) != null) {
                    int size = c.size();
                    for (int i = 0; i < size; i++) {
                        Map<String, a> map = c.get(i);
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                            if (it2.hasNext() && (value = it2.next().getValue()) != null && (c2 = value.c()) != null) {
                                String videoUrlEncode = c2.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.j();
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public l createUnitCache(Context context, String str, CampaignEx campaignEx, int i, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.b.containsKey(str)) {
            l lVar = this.b.get(str);
            if (lVar == null) {
                lVar = new l(context, campaignEx, str, i);
                this.b.put(str, lVar);
            }
            if (i != 94 && i != 287) {
                lVar.a(aVar);
            } else {
                lVar.a(campaignEx.getRequestId() + "_" + campaignEx.getSecondRequestIndex(), aVar);
            }
            lVar.f(campaignEx);
            return lVar;
        }
        l lVar2 = new l(context, campaignEx, str, i);
        if (i != 94 && i != 287) {
            lVar2.a(aVar);
        } else {
            lVar2.a(campaignEx.getRequestId() + "_" + campaignEx.getSecondRequestIndex(), aVar);
        }
        this.b.put(str, lVar2);
        return lVar2;
    }

    private void a(String str, CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2, CopyOnWriteArrayList<a> copyOnWriteArrayList3) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList4;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
            if (campaignEx.getSecondRequestIndex() == 1 && (concurrentHashMap = this.d) != null && (copyOnWriteArrayList4 = concurrentHashMap.get(str)) != null && copyOnWriteArrayList4.size() > 0 && copyOnWriteArrayList4.get(0).getLocalRequestId().equals(campaignEx.getLocalRequestId())) {
                return;
            }
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> concurrentHashMap2 = this.c;
        if (concurrentHashMap2 == null) {
            this.c = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap2.remove(str);
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap3 = this.e;
        if (concurrentHashMap3 == null) {
            this.e = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap3.remove(str);
        }
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap4 = this.d;
        if (concurrentHashMap4 == null) {
            this.d = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap4.remove(str);
        }
        this.c.put(str, copyOnWriteArrayList);
        this.d.put(str, copyOnWriteArrayList2);
        this.e.put(str, copyOnWriteArrayList3);
    }

    public void a(boolean z) {
        if (z) {
            if (this.f5271a) {
                return;
            }
        } else {
            this.f5271a = false;
        }
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, l>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().d();
            }
        }
    }

    public void a() {
        ConcurrentHashMap<String, l> concurrentHashMap = this.b;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, l> entry : concurrentHashMap.entrySet()) {
                a(entry.getValue(), entry.getKey());
            }
        }
    }

    private void a(l lVar, String str) {
        try {
            com.mbridge.msdk.videocommon.setting.c c = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), str);
            if (c == null) {
                return;
            }
            if (c.l() == 2) {
                lVar.e();
            } else {
                lVar.d();
            }
        } catch (Exception e) {
            p0.b("DownLoadManager", e.getMessage());
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.mbridge.msdk.setting.l e2 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str);
                if (e2 == null) {
                    e2 = com.mbridge.msdk.setting.l.j(str);
                }
                if (e2.q() == 2) {
                    lVar.e();
                } else {
                    lVar.d();
                }
            } catch (Exception e3) {
                p0.b("DownLoadManager", e3.getMessage());
            }
        }
    }
}

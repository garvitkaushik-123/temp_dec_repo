package com.mbridge.msdk.videocommon.cache;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.videocommon.setting.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: VideoCampaignCache.java */
/* loaded from: classes6.dex */
public class a {
    private static final String b = "com.mbridge.msdk.videocommon.cache.a";
    private static a c;

    /* renamed from: a, reason: collision with root package name */
    private e f5266a;

    /* compiled from: VideoCampaignCache.java */
    /* renamed from: com.mbridge.msdk.videocommon.cache.a$a, reason: collision with other inner class name */
    class RunnableC0421a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5267a;
        final /* synthetic */ CampaignEx b;

        RunnableC0421a(String str, CampaignEx campaignEx) {
            this.f5267a = str;
            this.b = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f5267a, this.b);
        }
    }

    private a() {
        try {
            Context d = c.m().d();
            if (d != null) {
                this.f5266a = e.a(g.a(d));
            } else {
                p0.b(b, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public void b(String str, String str2) {
        if (this.f5266a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f5266a.a(str, str2);
    }

    public CopyOnWriteArrayList<CampaignEx> c(String str, int i) {
        List<CampaignEx> a2;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a2 = this.f5266a.a(str, 0, 0, i)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : a2) {
                    if (campaignEx != null) {
                        copyOnWriteArrayList2.add(campaignEx);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e) {
                e = e;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public synchronized void d(String str, String str2) {
        try {
            this.f5266a.f(str2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CampaignEx> b(String str, int i, boolean z) {
        return b(str, i, z, "");
    }

    public CopyOnWriteArrayList<CampaignEx> b(String str, int i, boolean z, String str2) {
        Exception exc;
        List<CampaignEx> a2;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.setting.a c2 = b.b().c();
            long e = c2 != null ? c2.e() : 0L;
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    a2 = this.f5266a.a(str, 0, 0, i, str2);
                } else {
                    a2 = this.f5266a.a(str, 0, 0, i, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (a2 != null) {
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                    try {
                        for (CampaignEx campaignEx : a2) {
                            if (campaignEx != null && (campaignEx.getReadyState() == 0 || campaignEx.getLoadTimeoutState() == 1)) {
                                long plct = campaignEx.getPlct() * 1000;
                                long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                                if ((plct > 0 && plct >= timestamp) || (plct <= 0 && e >= timestamp)) {
                                    copyOnWriteArrayList2.add(campaignEx);
                                }
                            }
                        }
                        return copyOnWriteArrayList2;
                    } catch (Exception e2) {
                        exc = e2;
                        copyOnWriteArrayList = copyOnWriteArrayList2;
                        exc.printStackTrace();
                        return copyOnWriteArrayList;
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            exc = e3;
        }
    }

    public void a(String str, List<CampaignEx> list, String str2, int i) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || TextUtils.isEmpty(str2) || (eVar = this.f5266a) == null) {
            return;
        }
        eVar.a(str, list, str2, i);
    }

    public void a(String str, List<CampaignEx> list) {
        e eVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f5266a) == null) {
            return;
        }
        eVar.b(str, list);
    }

    public void a(String str, List<CampaignEx> list, String str2) {
        e eVar;
        try {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (eVar = this.f5266a) == null) {
                return;
            }
            eVar.a(str, list, str2);
        } catch (Exception e) {
            p0.b(b, e.getMessage());
        }
    }

    public List<CampaignEx> c(String str, int i, boolean z) {
        return c(str, i, z, "");
    }

    public List<CampaignEx> c(String str, int i, boolean z, String str2) {
        long a0;
        List<CampaignEx> a2;
        ArrayList arrayList = null;
        try {
            com.mbridge.msdk.setting.g d = h.b().d(c.m().b());
            if (d != null) {
                a0 = d.a0();
            } else {
                a0 = h.b().a().a0();
            }
            long j = a0 * 1000;
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    a2 = this.f5266a.a(str, 0, 0, i, str2);
                } else {
                    a2 = this.f5266a.a(str, 0, 0, i, false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (a2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (CampaignEx campaignEx : a2) {
                            if (campaignEx != null && campaignEx.getReadyState() == 0) {
                                long plctb = campaignEx.getPlctb() * 1000;
                                long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                                if ((plctb <= 0 && j >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                                    arrayList2.add(campaignEx);
                                }
                            }
                        }
                        return arrayList2;
                    } catch (Exception e) {
                        e = e;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list != null) {
            try {
                com.mbridge.msdk.videocommon.setting.a c2 = b.b().c();
                long e = c2 != null ? c2.e() : 0L;
                long currentTimeMillis = System.currentTimeMillis();
                if (list.size() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        for (CampaignEx campaignEx : list) {
                            if (campaignEx != null) {
                                long plct = campaignEx.getPlct() * 1000;
                                long timestamp = currentTimeMillis - campaignEx.getTimestamp();
                                if ((plct > 0 && plct >= timestamp) || (plct <= 0 && e >= timestamp)) {
                                    arrayList2.add(campaignEx);
                                }
                            }
                        }
                        return arrayList2;
                    } catch (Exception e2) {
                        e = e2;
                        arrayList = arrayList2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return arrayList;
    }

    public void b(String str, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new RunnableC0421a(str, campaignEx));
    }

    public void b(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> f;
        try {
            if (TextUtils.isEmpty(str) || (f = this.f5266a.f(str)) == null || f.size() <= 0) {
                return;
            }
            com.mbridge.msdk.setting.g d = h.b().d(c.m().b());
            if (d == null) {
                d = h.b().a();
            }
            long a0 = d != null ? d.a0() : 0L;
            long currentTimeMillis = System.currentTimeMillis();
            for (com.mbridge.msdk.foundation.entity.c cVar : f.values()) {
                if (cVar != null) {
                    long e = cVar.e();
                    if (e <= 0) {
                        e = a0;
                    }
                    if (cVar.f() + (e * 1000) < currentTimeMillis && !TextUtils.isEmpty(cVar.a())) {
                        p0.b("HBOPTIMIZE", "不在有效期范围内 删除" + cVar.a());
                        d(str, cVar.a());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public List<com.mbridge.msdk.foundation.entity.c> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f5266a.d(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int a(String str, int i, boolean z, String str2) {
        List<CampaignEx> a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                a2 = this.f5266a.a(str, 0, 0, i, str2);
            } else {
                a2 = this.f5266a.a(str, 0, 0, i, false);
            }
            if (a2 == null) {
                return 0;
            }
            for (CampaignEx campaignEx : a2) {
                if (campaignEx != null && campaignEx.getReadyState() == 0) {
                    arrayList.add(campaignEx);
                }
            }
            return arrayList.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void c(String str, String str2) {
        e eVar = this.f5266a;
        if (eVar != null) {
            eVar.c(str, str2);
        }
    }

    public List<CampaignEx> a(String str, int i, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f5266a.a(str, 0, 0, i, z);
        } catch (Exception e) {
            p0.b(b, e.getLocalizedMessage());
            return null;
        }
    }

    public void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    com.mbridge.msdk.foundation.same.buffer.b.c(str, campaignEx.getRequestId());
                }
                String localRequestId = campaignEx.getLocalRequestId();
                if (!TextUtils.isEmpty(localRequestId)) {
                    boolean z = true;
                    if (campaignEx.getSecondRequestIndex() != 1 && !localRequestId.contains("label_second")) {
                        z = false;
                    }
                    if (localRequestId.contains("label_second")) {
                        localRequestId = localRequestId.replace("label_second", "");
                    }
                    if (z) {
                        this.f5266a.a(str, localRequestId, localRequestId + "label_second");
                        return;
                    } else {
                        this.f5266a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                        return;
                    }
                }
                this.f5266a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void b(String str, int i) {
        int f;
        try {
            com.mbridge.msdk.setting.g d = h.b().d(c.m().b());
            if (d == null) {
                d = h.b().a();
            }
            f = d.f();
        } catch (Exception e) {
            p0.b(b, e.getMessage());
        }
        if (f == 0) {
            return;
        }
        boolean z = true;
        List<CampaignEx> b2 = this.f5266a.b(str, i, f == 2);
        if (b2 != null && b2.size() > 0) {
            for (CampaignEx campaignEx : b2) {
                com.mbridge.msdk.videocommon.a.e(campaignEx.getCampaignUnitId() + "_" + campaignEx.getId() + "_" + campaignEx.getRequestIdNotice() + "_" + campaignEx.getCMPTEntryUrl());
            }
        }
        e eVar = this.f5266a;
        if (f != 2) {
            z = false;
        }
        eVar.a(str, i, z);
    }

    public void a(String str, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String localRequestId = campaignEx.getLocalRequestId();
                if (!TextUtils.isEmpty(localRequestId)) {
                    boolean z = true;
                    if (campaignEx.getSecondRequestIndex() != 1 && !localRequestId.contains("label_second")) {
                        z = false;
                    }
                    if (localRequestId.contains("label_second")) {
                        localRequestId = localRequestId.replace("label_second", "");
                    }
                    if (z) {
                        this.f5266a.a(str, localRequestId, localRequestId + "label_second");
                        return;
                    } else {
                        this.f5266a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                        return;
                    }
                }
                this.f5266a.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                this.f5266a.d(campaignEx.getId(), campaignEx.getRequestId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            List<com.mbridge.msdk.foundation.entity.c> d = this.f5266a.d(str);
            if (str2.contains("label_second")) {
                String replace = str2.replace("label_second", "");
                if (d == null || d.isEmpty() || TextUtils.isEmpty(replace)) {
                    return;
                }
                for (com.mbridge.msdk.foundation.entity.c cVar : d) {
                    if (replace.equals(cVar.d())) {
                        d(str, cVar.a());
                        com.mbridge.msdk.foundation.same.buffer.b.c(str, cVar.a());
                        return;
                    }
                }
                return;
            }
            String str3 = str2 + "label_second";
            if (d == null || d.isEmpty() || TextUtils.isEmpty(str3)) {
                return;
            }
            Iterator<com.mbridge.msdk.foundation.entity.c> it = d.iterator();
            while (it.hasNext()) {
                if (str3.equals(it.next().d())) {
                    for (com.mbridge.msdk.foundation.entity.c cVar2 : d) {
                        if (str2.equals(cVar2.d())) {
                            d(str, cVar2.a());
                            com.mbridge.msdk.foundation.same.buffer.b.c(str, cVar2.a());
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Exception e) {
            p0.b("videoCache", e.getMessage());
        }
    }

    public void a(String str, int i) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.c> d = this.f5266a.d(str);
            if (d == null || d.size() <= 0 || (size = d.size() - i) <= 0) {
                return;
            }
            for (int i2 = 0; i2 < size; i2++) {
                d(str, d.get(i2).a());
                com.mbridge.msdk.foundation.same.buffer.b.c(str, d.get(i2).a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
                return;
            }
            this.f5266a.a(list, str, str2, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void a(long j, String str) {
        try {
            this.f5266a.b(j, str);
        } catch (Exception e) {
            e.printStackTrace();
            p0.b(b, e.getMessage());
        }
    }
}

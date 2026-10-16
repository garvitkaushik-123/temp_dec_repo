package com.mbridge.msdk.interstitial.cache;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: InterstitialCamapignCache.java */
/* loaded from: classes6.dex */
public class a {
    private static final String b = "com.mbridge.msdk.interstitial.cache.a";
    private static a c;

    /* renamed from: a, reason: collision with root package name */
    private e f4409a;

    private a() {
        try {
            Context d = c.m().d();
            if (d != null) {
                this.f4409a = e.a(g.a(d));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public void b(CampaignEx campaignEx, String str) {
        try {
            if (this.f4409a == null || campaignEx == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f4409a.a(campaignEx, str, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CampaignEx> a(String str, int i) {
        List<CampaignEx> a2;
        ArrayList arrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a2 = this.f4409a.a(str, i, 0, 1)) == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                Iterator<CampaignEx> it = a2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(it.next());
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f4409a.e(campaignEx.getId(), str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(List<CampaignEx> list, String str) {
        if (list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<CampaignEx> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), str);
        }
    }

    public void a(String str, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
                return;
            }
            Iterator<CampaignEx> it = list.iterator();
            while (it.hasNext()) {
                b(it.next(), str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void a(long j, String str) {
        try {
            if (this.f4409a != null && j != 0 && !TextUtils.isEmpty(str)) {
                this.f4409a.a(j, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
            p0.b(b, e.getMessage());
        }
    }
}

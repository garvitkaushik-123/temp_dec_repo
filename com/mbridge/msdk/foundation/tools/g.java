package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.provider.Settings;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CheckUtils.java */
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4366a = "com.mbridge.msdk.foundation.tools.g";
    public static int b;

    public static int b(Context context) {
        if (b == 0) {
            b = a(context) ? 1 : -1;
        }
        return b;
    }

    private static boolean a(Context context) {
        return context != null && Settings.canDrawOverlays(context);
    }

    public static boolean a(CampaignEx campaignEx, Context context, View view, int i) {
        com.mbridge.msdk.foundation.entity.l a2 = a(view, i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        a(arrayList, a2);
        return a(a2, arrayList);
    }

    public static boolean b(CampaignEx campaignEx, Context context, View view, int i) {
        com.mbridge.msdk.foundation.entity.l a2 = a(view, i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        return a(a2, arrayList);
    }

    public static boolean a(List<CampaignEx> list, Context context, View view, int i) {
        com.mbridge.msdk.foundation.entity.l a2 = a(view, i);
        a(list, a2);
        return a(a2, list);
    }

    private static boolean a(com.mbridge.msdk.foundation.entity.l lVar, List<CampaignEx> list) {
        return lVar.a() || list == null || list.isEmpty() || list.get(0).getLocalCheckShow() == 0;
    }

    public static void a(List<CampaignEx> list, com.mbridge.msdk.foundation.entity.l lVar) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar2;
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("per", Integer.valueOf(b(com.mbridge.msdk.foundation.controller.c.m().d())));
            eVar.a("viewStatus", Integer.valueOf(lVar.b()));
            eVar.a("showe", Integer.valueOf(!lVar.a() ? 1 : 0));
            com.mbridge.msdk.foundation.same.report.metrics.c cVar3 = null;
            try {
                cVar2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(list.get(0).getCurrentLocalRid());
                if (cVar2 == null) {
                    try {
                        cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    } catch (Exception e) {
                        e = e;
                        cVar3 = cVar2;
                        cVar = cVar3;
                        p0.b(f4366a, e.getMessage());
                        cVar2 = cVar;
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_show_env", cVar2);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000130", eVar);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000131", eVar);
                    }
                    try {
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().c().put(list.get(0).getCurrentLocalRid(), cVar);
                        cVar2 = cVar;
                    } catch (Exception e2) {
                        e = e2;
                        p0.b(f4366a, e.getMessage());
                        cVar2 = cVar;
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_show_env", cVar2);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000130", eVar);
                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000131", eVar);
                    }
                }
                cVar2.a((CampaignEx) null);
                cVar2.b(list);
                cVar2.a("m_show_env", eVar);
            } catch (Exception e3) {
                e = e3;
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_show_env", cVar2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000130", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000131", eVar);
        } catch (Throwable th) {
            p0.b(f4366a, th.getMessage());
        }
    }

    public static com.mbridge.msdk.foundation.entity.l a(View view, int i) {
        com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
        if (view != null) {
            lVar.a(d1.a(view, i) ? 1 : 0);
        }
        return lVar;
    }
}

package com.mbridge.msdk.reward.candidate;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.cache.a;
import com.mbridge.msdk.foundation.cache.d;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.u0;
import io.bidmachine.media3.exoplayer.upstream.CmcdConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardCandidateController.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private d f4666a;

    public a(String str, boolean z) {
        try {
            this.f4666a = b.a().b(str, com.mbridge.msdk.videocommon.setting.b.b().a(c.m().b(), str, z).B());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(List<CampaignEx> list, String str, com.mbridge.msdk.reward.adapter.c cVar, String str2) {
        try {
            if (this.f4666a == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f4666a.a(com.mbridge.msdk.foundation.cache.a.f, 2, list, this.f4666a.a(list, str) > 0, "", "", -1, str2);
            d dVar = this.f4666a;
            JSONObject c = dVar.c(dVar.d(str));
            if (c == null || this.f4666a.b(str) <= 0.0d) {
                return;
            }
            a(this.f4666a.a(c.optInt("max_usage_limit", 10), 0L), c, c.optInt("max_cache_num", 20), -1.0d, cVar, new com.mbridge.msdk.foundation.same.report.metrics.c(), str, false, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public com.mbridge.msdk.foundation.cache.c a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, CampaignEx campaignEx, com.mbridge.msdk.foundation.error.b bVar, int i, com.mbridge.msdk.reward.adapter.c cVar2) {
        String requestId;
        com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
        if (campaignEx == null) {
            requestId = "";
        } else {
            try {
                try {
                    requestId = campaignEx.getRequestId();
                } catch (Exception unused) {
                    cVar3.d("getRewardCandidateCampaignList result exception");
                    cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
                    return cVar3;
                }
            } catch (Exception unused2) {
                cVar3.d("getCandidateCampaignList result exception");
                cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
                return cVar3;
            }
        }
        return a(str, cVar, requestId, bVar, i, cVar2);
    }

    private com.mbridge.msdk.foundation.cache.c a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str2, com.mbridge.msdk.foundation.error.b bVar, int i, com.mbridge.msdk.reward.adapter.c cVar2) {
        String str3;
        int i2;
        String str4;
        if (bVar != null) {
            int c = bVar.c();
            str3 = bVar.g();
            i2 = c;
        } else {
            str3 = null;
            i2 = 0;
        }
        String str5 = str3;
        d dVar = this.f4666a;
        if (dVar == null) {
            com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
            cVar3.d("can not get manager");
            cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
            return cVar3;
        }
        com.mbridge.msdk.foundation.cache.c a2 = dVar.a(str);
        if (a2.g() > com.mbridge.msdk.foundation.cache.c.j) {
            return a2;
        }
        String[] split = j0.a(str.split("_")[3]).split("\\|");
        double parseDouble = Double.parseDouble(split[0]);
        if (split.length <= 1) {
            str4 = "";
        } else {
            str4 = split[1];
        }
        com.mbridge.msdk.foundation.cache.c a3 = a(parseDouble, str4, cVar2, cVar, str, i);
        this.f4666a.a(a3.c(), cVar, str2, i2, str5, i, parseDouble);
        return a3;
    }

    private com.mbridge.msdk.foundation.cache.c a(double d, String str, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar2, String str2, int i) {
        com.mbridge.msdk.foundation.cache.c a2 = this.f4666a.a();
        try {
            if (a2.g() > 0) {
                return a2;
            }
            JSONObject c = this.f4666a.c(str);
            try {
                if (c != null) {
                    int optInt = c.optInt("max_usage_limit", 10);
                    int optInt2 = c.optInt("max_cache_num", 20);
                    if (optInt2 > 0) {
                        long j = 8640000;
                        long optLong = c.optLong("show_interval_time", 8640000L);
                        if (optLong != 0) {
                            j = optLong;
                        }
                        List<com.mbridge.msdk.foundation.cache.b> a3 = this.f4666a.a(optInt, System.currentTimeMillis() - (j * 1000));
                        if (a3 != null && a3.size() > 0) {
                            return a(a3, c, optInt2, d, cVar, cVar2, str2, true, i);
                        }
                        a2.d("no cache");
                        a2.a(com.mbridge.msdk.foundation.cache.c.k);
                        a(cVar2, str2, a2, (List<a.b>) null, c, 2);
                        return a2;
                    }
                    a2.d("max cache num error");
                    a2.a(com.mbridge.msdk.foundation.cache.c.k);
                    return a2;
                }
                a2.d("setting config not mapping");
                a2.a(com.mbridge.msdk.foundation.cache.c.k);
                return a2;
            } catch (Exception unused) {
                a2.d("getHighestCampaigns exception");
                a2.a(com.mbridge.msdk.foundation.cache.c.k);
                return a2;
            }
        } catch (Exception unused2) {
        }
    }

    private com.mbridge.msdk.foundation.cache.c a(List<com.mbridge.msdk.foundation.cache.b> list, JSONObject jSONObject, int i, double d, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar2, String str, boolean z, int i2) {
        List<com.mbridge.msdk.foundation.cache.b> list2;
        int i3;
        List<com.mbridge.msdk.foundation.cache.b> list3 = list;
        com.mbridge.msdk.foundation.cache.c cVar3 = new com.mbridge.msdk.foundation.cache.c();
        if (jSONObject == null) {
            cVar3.d("config is null");
            cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
            return cVar3;
        }
        if (list3 != null && list3.size() != 0) {
            for (int i4 = 0; i4 < list3.size(); i4++) {
                com.mbridge.msdk.foundation.cache.b bVar = list3.get(i4);
                if (bVar != null) {
                    cVar3.a(bVar.e());
                }
            }
            if (list3.size() > 0 && ((list3 = a(list3, cVar3)) == null || list3.size() == 0)) {
                cVar3.d("existed");
                cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
            }
            if (list3.size() > 0 && ((list3 = a(list3, cVar, cVar3)) == null || list3.size() == 0)) {
                cVar3.d("not ready");
                cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
            }
            ArrayList arrayList = null;
            if (list3 != null && list3.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                double optDouble = jSONObject.optDouble("t_disc", 0.8d);
                double optDouble2 = jSONObject.optDouble("u_disc", 0.95d);
                double optDouble3 = jSONObject.optDouble("max_ecppv_diff", 0.0d);
                int optInt = jSONObject.optInt("time_interval", 1800);
                int size = list3.size();
                double d2 = 0.0d;
                com.mbridge.msdk.foundation.cache.b bVar2 = null;
                int i5 = 0;
                while (i5 < size) {
                    com.mbridge.msdk.foundation.cache.b bVar3 = list3.get(i5);
                    if (bVar3 != null) {
                        i3 = i5;
                        double pow = Math.pow(optDouble2, bVar3.f()) * bVar3.b() * Math.pow(optDouble, (System.currentTimeMillis() - bVar3.h()) / (optInt * 1000.0d));
                        list2 = list3;
                        arrayList2.add(new a.b(pow, bVar3));
                        if (pow >= d - optDouble3 && pow > d2) {
                            d2 = pow;
                            bVar2 = bVar3;
                        }
                    } else {
                        list2 = list3;
                        i3 = i5;
                    }
                    i5 = i3 + 1;
                    list3 = list2;
                }
                d dVar = this.f4666a;
                if (dVar != null) {
                    dVar.a(arrayList2, i);
                }
                if (bVar2 != null) {
                    cVar3.a(bVar2.a());
                    cVar3.a(com.mbridge.msdk.foundation.cache.c.l);
                } else {
                    cVar3.d("no match campaign");
                    cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
                }
                arrayList = arrayList2;
            }
            if (z) {
                a(cVar2, str, cVar3, arrayList, jSONObject, 2);
            }
            return cVar3;
        }
        cVar3.d("candidate is null");
        cVar3.a(com.mbridge.msdk.foundation.cache.c.k);
        return cVar3;
    }

    private List<com.mbridge.msdk.foundation.cache.b> a(List<com.mbridge.msdk.foundation.cache.b> list, com.mbridge.msdk.foundation.cache.c cVar) {
        CopyOnWriteArrayList<CampaignEx> a2;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.mbridge.msdk.foundation.cache.b bVar = list.get(i);
            if (bVar != null && (a2 = bVar.a()) != null && a2.size() != 0) {
                int i2 = 0;
                boolean z = false;
                while (true) {
                    if (i2 >= a2.size()) {
                        break;
                    }
                    CampaignEx campaignEx = a2.get(i2);
                    boolean c = u0.c(c.m().d(), campaignEx.getPackageName());
                    if (c) {
                        cVar.b(bVar.e());
                        d dVar = this.f4666a;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                        z = c;
                    } else {
                        i2++;
                        z = c;
                    }
                }
                if (!z) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    private List<com.mbridge.msdk.foundation.cache.b> a(List<com.mbridge.msdk.foundation.cache.b> list, com.mbridge.msdk.reward.adapter.c cVar, com.mbridge.msdk.foundation.cache.c cVar2) {
        CopyOnWriteArrayList<CampaignEx> a2;
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.mbridge.msdk.foundation.cache.b bVar = list.get(i);
            if (bVar != null && (a2 = bVar.a()) != null && a2.size() != 0) {
                int i2 = 0;
                boolean z = false;
                while (true) {
                    if (i2 >= a2.size()) {
                        break;
                    }
                    CampaignEx campaignEx = a2.get(i2);
                    if (cVar == null || (z = cVar.a(a2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())))) {
                        i2++;
                    } else {
                        cVar2.c(bVar.e());
                        d dVar = this.f4666a;
                        if (dVar != null) {
                            dVar.a(bVar.d(), bVar.e(), 2, campaignEx.getEcppv());
                        }
                    }
                }
                if (z) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public boolean a(String str) {
        JSONObject c;
        try {
            d dVar = this.f4666a;
            if (dVar != null && (c = dVar.c(dVar.d(str))) != null) {
                return c.optInt("c_cb", 0) == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void a(String str, String str2, int i, String str3) {
        d dVar = this.f4666a;
        if (dVar != null) {
            dVar.a(str, str2, i, str3);
        }
    }

    public void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, com.mbridge.msdk.foundation.cache.c cVar2, List<a.b> list, JSONObject jSONObject, int i) {
        String str2;
        try {
            e eVar = new e();
            if (i == 1) {
                str2 = "cb";
            } else if (i == 2) {
                str2 = "candidate";
            } else if (i != 3) {
                str2 = "unknown";
            } else {
                str2 = "track";
            }
            eVar.a("scene", str2);
            d dVar = this.f4666a;
            if (dVar != null) {
                double b = dVar.b(str);
                if (b >= 0.0d) {
                    eVar.a("bp", j0.b(b + ""));
                }
                eVar.a("cb_state", a(str) ? "open" : "close");
                try {
                    d dVar2 = this.f4666a;
                    JSONObject c = dVar2.c(dVar2.d(str));
                    if (c != null) {
                        eVar.a("config", c.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cVar2 != null) {
                if (cVar2.g() == com.mbridge.msdk.foundation.cache.c.l) {
                    eVar.a("result", 1);
                } else {
                    eVar.a("result", 2);
                    eVar.a("reason", cVar2.e());
                }
                eVar.a("acr", cVar2.a());
                eVar.a("her", cVar2.d());
                eVar.a(CmcdConfiguration.KEY_NEXT_RANGE_REQUEST, cVar2.f());
                eVar.a("cer", cVar2.b());
            } else {
                eVar.a("result", 2);
                eVar.a("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    com.mbridge.msdk.foundation.cache.b a2 = list.get(i2).a();
                    if (a2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", j0.b(a2.b() + ""));
                        jSONObject2.put("showCount", a2.f());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - a2.h());
                        jSONArray.put(jSONObject2);
                    }
                }
                eVar.a("data", jSONArray.toString());
            }
            if (cVar != null) {
                cVar.j("m_candidate_data");
                cVar.e("m_candidate_data");
                cVar.a("m_candidate_data", eVar);
                if (cVar2 != null && cVar2.c() != null) {
                    cVar.b(cVar2.c());
                }
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().b("m_candidate_data", cVar, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

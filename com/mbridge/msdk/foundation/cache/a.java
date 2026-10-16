package com.mbridge.msdk.foundation.cache;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseCandidateCache.java */
/* loaded from: classes6.dex */
public class a {
    private static String e = "BaseCandidateCache";
    public static int f = 4;

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.foundation.db.c f4192a;
    private JSONArray b;
    private JSONObject c;
    private String d;

    /* compiled from: BaseCandidateCache.java */
    /* renamed from: com.mbridge.msdk.foundation.cache.a$a, reason: collision with other inner class name */
    class C0327a implements Comparator<b> {
        C0327a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return Double.compare(bVar.b, bVar2.b);
        }
    }

    /* compiled from: BaseCandidateCache.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.foundation.cache.b f4194a;
        private double b;

        public b(double d, com.mbridge.msdk.foundation.cache.b bVar) {
            this.b = d;
            this.f4194a = bVar;
        }

        public com.mbridge.msdk.foundation.cache.b a() {
            return this.f4194a;
        }
    }

    public void a(int i) {
        com.mbridge.msdk.foundation.db.c cVar = this.f4192a;
        if (cVar != null) {
            cVar.a(this.d, i);
            a(f, 1, null, true, "", "", i, this.d);
        }
    }

    public double b(String str) {
        c a2 = a(str);
        if (a2 != null && a2.g() != c.k && a2.g() != c.i) {
            try {
                String[] split = j0.a(str.split("_")[3]).split("\\|");
                if (split.length > 0) {
                    return Double.parseDouble(split[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1.0d;
    }

    public JSONObject c(String str) {
        JSONArray jSONArray = this.b;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() <= 1) {
            return this.b.optJSONObject(0);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.b.length(); i++) {
            try {
                JSONObject optJSONObject = this.b.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.getString("g"))) {
                    this.c = optJSONObject;
                    return optJSONObject;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public String d(String str) {
        c a2 = a(str);
        if (a2 != null && a2.g() != c.k && a2.g() != c.i) {
            String[] split = j0.a(str.split("_")[3]).split("\\|");
            if (split.length > 1) {
                return split[1];
            }
        }
        return "";
    }

    public void e(String str) {
        this.d = str;
    }

    public c a(String str) {
        c cVar = new c();
        if (!TextUtils.isEmpty(str) && str.split("_").length > 3 && !TextUtils.isEmpty(str.split("_")[3])) {
            JSONArray jSONArray = this.b;
            if (jSONArray != null && jSONArray.length() != 0) {
                String a2 = j0.a(str.split("_")[3]);
                if (TextUtils.isEmpty(a2)) {
                    cVar.d("bid token exception:decode error");
                    cVar.a(c.i);
                    return cVar;
                }
                String[] split = a2.split("\\|");
                if (split.length == 0) {
                    cVar.d("bid token can not get bid price");
                    cVar.a(c.i);
                    return cVar;
                }
                if (split.length > 0) {
                    try {
                        Double.parseDouble(split[0]);
                    } catch (Exception unused) {
                        cVar.d("bid token can not cast bid price");
                        cVar.a(c.i);
                        return cVar;
                    }
                }
                if (TextUtils.isEmpty(this.d)) {
                    cVar.d("unitId is empty");
                    cVar.a(c.k);
                }
                return cVar;
            }
            cVar.d("config is empty");
            cVar.a(c.i);
            return cVar;
        }
        cVar.d("bid token exception");
        cVar.a(c.i);
        return cVar;
    }

    private List<Map<Integer, String>> b(List<Map<Integer, String>> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Map<Integer, String> map = list.get(i2);
            if (map != null && map.size() > 0) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue(), i, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public void a(JSONArray jSONArray) {
        this.b = jSONArray;
    }

    public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar, String str, int i, String str2, int i2, double d) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        CampaignEx campaignEx = list.get(i3);
                        campaignEx.setReadyState(0);
                        if (cVar != null) {
                            campaignEx.setNLRid(cVar.o());
                        }
                        campaignEx.setNRid(str);
                        campaignEx.setReasond(str2);
                        campaignEx.setTyped(i);
                        String b2 = j0.b(d + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i2, str, b2));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i2, str, b2));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i2, str, b2));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i2, str, b2));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i2, str, b2));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i2, str, b2));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i2, str, b2));
                            nativeVideoTracking.k(a(nativeVideoTracking.k(), i2, str, b2));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i2, str, b2));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i2, str, b2));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i2, str, b2));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i2, str, b2));
                            nativeVideoTracking.t(a(nativeVideoTracking.u(), i2, str, b2));
                            nativeVideoTracking.u(a(nativeVideoTracking.u(), i2, str, b2));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i2, str, b2));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i2, str, b2));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i2, str, b2));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i2, str, b2));
                            nativeVideoTracking.i(a(nativeVideoTracking.i(), i2, str, b2));
                            nativeVideoTracking.j(a(nativeVideoTracking.j(), i2, str, b2));
                            nativeVideoTracking.l(a(nativeVideoTracking.l(), i2, str, b2));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i2, str, b2));
                            nativeVideoTracking.m(a(nativeVideoTracking.m(), i2, str, b2));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i2, str, b2));
                            nativeVideoTracking.n(a(nativeVideoTracking.n(), i2, str, b2));
                            nativeVideoTracking.a(b(nativeVideoTracking.o(), i2, str, b2));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i2, str, b2));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i2, str, b2));
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(a(campaignEx.getPv_urls(), i2, str, b2));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public c a() {
        JSONArray jSONArray;
        c cVar = new c();
        try {
            jSONArray = this.b;
        } catch (Exception unused) {
            cVar.d("checkConfigAndDB exception");
            cVar.a(c.k);
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            if (this.f4192a == null) {
                cVar.d("db error");
                cVar.a(c.k);
                return cVar;
            }
            return cVar;
        }
        cVar.d("setting config is null");
        cVar.a(c.i);
        return cVar;
    }

    public List<com.mbridge.msdk.foundation.cache.b> a(int i, long j) {
        if (i >= 0) {
            a(i);
        }
        com.mbridge.msdk.foundation.db.c cVar = this.f4192a;
        if (cVar != null) {
            return cVar.a(this.d, j);
        }
        return null;
    }

    public void a(List<b> list, int i) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new C0327a());
                    int size = list.size() - i;
                    if (size > 0) {
                        List<b> subList = list.subList(0, size);
                        if (this.f4192a == null || subList.size() <= 0) {
                            return;
                        }
                        for (int i2 = 0; i2 < subList.size(); i2++) {
                            com.mbridge.msdk.foundation.cache.b bVar = subList.get(i2).f4194a;
                            this.f4192a.a(this.d, bVar.e(), bVar.d());
                            a(f, 1, null, true, bVar.e(), bVar.d(), -1, this.d);
                        }
                    }
                }
            } catch (Exception e2) {
                p0.a(e, e2);
            }
        }
    }

    private String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (b1.c(str) > 0) {
            return str + "&ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    private String a(Map<Integer, String> map, int i, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, entry.getKey());
                jSONObject.put("url", a(value, i, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private String[] a(String[] strArr, int i, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = a(strArr[i2], i, str, str2);
        }
        return strArr2;
    }

    private List<String> a(List<String> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(a(list.get(i2), i, str, str2));
        }
        return arrayList;
    }

    public long a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return 0L;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return 0L;
        }
        String a2 = j0.a(ecppv);
        if (TextUtils.isEmpty(a2)) {
            return 0L;
        }
        try {
            if (Double.parseDouble(a2) <= 0.0d) {
                return 0L;
            }
            JSONObject c = c(d(str));
            int optInt = c != null ? c.optInt("max_cache_num", 20) : 20;
            com.mbridge.msdk.foundation.db.c cVar = this.f4192a;
            if (cVar == null || optInt <= 0) {
                return -1L;
            }
            return cVar.a(list, this.d);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public void a(String str, String str2, int i, String str3) {
        try {
            if (this.f4192a != null && !TextUtils.isEmpty(str3)) {
                if (i == 1) {
                    this.f4192a.a(str2, str, this.d, i);
                    a(f, 3, null, true, str2, str, -1, this.d);
                } else if (i == 2) {
                    this.f4192a.a(this.d, str2, str);
                    a(f, 1, null, true, str2, str, -1, this.d);
                } else {
                    if (i != 3) {
                        return;
                    }
                    this.f4192a.b(str2, str, this.d);
                    a(f, 4, null, true, str2, str, -1, this.d);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01a3 A[Catch: Exception -> 0x01b6, TryCatch #5 {Exception -> 0x01b6, blocks: (B:3:0x0011, B:6:0x0030, B:8:0x006c, B:11:0x007c, B:13:0x0082, B:17:0x0089, B:19:0x0094, B:22:0x009b, B:24:0x00a1, B:26:0x00a9, B:29:0x00b9, B:31:0x0106, B:33:0x011c, B:36:0x0125, B:39:0x012b, B:41:0x0139, B:43:0x013d, B:45:0x0148, B:47:0x014e, B:49:0x0156, B:52:0x0161, B:54:0x0173, B:56:0x018f, B:58:0x019b, B:60:0x01a3, B:61:0x01a8, B:68:0x0178, B:82:0x010b), top: B:2:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2, List<CampaignEx> list, boolean z, String str, String str2, int i3, String str3) {
        String str4;
        com.mbridge.msdk.foundation.same.report.metrics.c cVar;
        String str5;
        String str6;
        String str7;
        com.mbridge.msdk.foundation.db.c cVar2;
        e eVar = new e();
        try {
            eVar.a("type", i2 + "");
            eVar.a("result", z ? "1" : "2");
            eVar.a("max_usage_limit", i3 + "");
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str3 + "");
            eVar.a("scene", "db");
            JSONObject jSONObject = this.c;
            if (jSONObject != null) {
                eVar.a("config", jSONObject.toString());
            }
            String str8 = "rid";
            if (i2 == 1 && TextUtils.isEmpty(str2) && (cVar2 = this.f4192a) != null) {
                try {
                    List<com.mbridge.msdk.foundation.cache.b> a2 = cVar2.a(str3, -1, -1L);
                    JSONArray jSONArray = new JSONArray();
                    if (a2 != null && a2.size() > 0) {
                        int i4 = 0;
                        while (i4 < a2.size()) {
                            com.mbridge.msdk.foundation.cache.b bVar = a2.get(i4);
                            if (bVar != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(str8, bVar.e());
                                str4 = str8;
                                try {
                                    jSONObject2.put("ts", bVar.h());
                                    jSONObject2.put("lrid", bVar.d());
                                    jSONObject2.put("ecppv", j0.b(bVar.b() + ""));
                                    jSONObject2.put("state", bVar.g());
                                    jSONObject2.put("showCount", bVar.f());
                                    jSONObject2.put("interval_ts", bVar.c());
                                    jSONArray.put(jSONObject2);
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    cVar = null;
                                    if (list != null) {
                                    }
                                    str5 = str4;
                                    str6 = str;
                                    str7 = str2;
                                    eVar.a(str5, str6);
                                    eVar.a("lrid", str7);
                                    if (cVar == null) {
                                    }
                                    cVar.n(str3);
                                    cVar.a("m_candidate_db", eVar);
                                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
                                }
                            } else {
                                str4 = str8;
                            }
                            i4++;
                            str8 = str4;
                        }
                    }
                    str4 = str8;
                    eVar.a("cache", jSONArray.toString());
                } catch (JSONException e3) {
                    e = e3;
                    str4 = str8;
                }
            } else {
                str4 = "rid";
            }
            cVar = null;
            if (list != null || list.size() <= 0) {
                str5 = str4;
                str6 = str;
                str7 = str2;
            } else {
                try {
                    JSONArray jSONArray2 = new JSONArray();
                    int i5 = 0;
                    CampaignEx campaignEx = list.get(0);
                    if (campaignEx != null) {
                        str7 = campaignEx.getCurrentLocalRid();
                        try {
                            cVar = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(str7);
                        } catch (JSONException e4) {
                            e = e4;
                            str5 = str4;
                            e.printStackTrace();
                            str6 = str;
                            eVar.a(str5, str6);
                            eVar.a("lrid", str7);
                            if (cVar == null) {
                            }
                            cVar.n(str3);
                            cVar.a("m_candidate_db", eVar);
                            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
                        }
                    } else {
                        str7 = str2;
                    }
                    while (i5 < list.size()) {
                        CampaignEx campaignEx2 = list.get(i5);
                        if (campaignEx2 != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            str5 = str4;
                            try {
                                jSONObject3.put(str5, campaignEx2.getRequestId());
                                jSONObject3.put("rid_n", campaignEx2.getRequestIdNotice());
                                jSONArray2.put(jSONObject3);
                            } catch (JSONException e5) {
                                e = e5;
                                e.printStackTrace();
                                str6 = str;
                                eVar.a(str5, str6);
                                eVar.a("lrid", str7);
                                if (cVar == null) {
                                }
                                cVar.n(str3);
                                cVar.a("m_candidate_db", eVar);
                                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
                            }
                        } else {
                            str5 = str4;
                        }
                        i5++;
                        str4 = str5;
                    }
                    str5 = str4;
                    eVar.a("c_info", jSONArray2.toString());
                } catch (JSONException e6) {
                    e = e6;
                    str5 = str4;
                    str7 = str2;
                }
                str6 = str;
            }
            eVar.a(str5, str6);
            eVar.a("lrid", str7);
            if (cVar == null) {
                cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            }
            cVar.n(str3);
            cVar.a("m_candidate_db", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_candidate_db", cVar);
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }
}

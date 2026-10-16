package com.mbridge.msdk.setting;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BaseUnitSetting.java */
/* loaded from: classes6.dex */
public class c {
    private String A;
    private int D;
    private int E;
    private int I;
    private String K;
    private int N;
    private List<Integer> b;
    private List<Integer> c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private long k;
    private long l;
    private int m;
    private int n;
    private int o;
    private long p;
    private long q;
    private int r;
    private String s;
    private int t;
    private int u;
    private String z;

    /* renamed from: a, reason: collision with root package name */
    private String f4700a = "";
    private int j = 0;
    private int v = 30;
    private int w = 1;
    private int x = 10;
    private int y = 60;
    private int B = 1;
    private String C = "";
    private int F = 100;
    private int G = 60;
    private int H = 5000;
    private int J = 1;
    private String L = "";
    private String M = "";

    public static l a(JSONObject jSONObject) {
        l lVar;
        l lVar2 = null;
        if (jSONObject != null) {
            try {
                lVar = new l();
            } catch (Exception e) {
                e = e;
            }
            try {
                lVar.e(jSONObject.optString("unitId"));
                lVar.a(jSONObject.optString("ab_id"));
                lVar.f(jSONObject.optString("rid"));
                JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i)));
                    }
                    lVar.a(arrayList);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i2)));
                    }
                    lVar.b(arrayList2);
                }
                lVar.x(jSONObject.optInt("tpqn"));
                lVar.c(jSONObject.optInt("aqn"));
                lVar.b(jSONObject.optInt("acn"));
                lVar.z(jSONObject.optInt("wt"));
                int i3 = 1;
                lVar.o(jSONObject.optInt("iscasf", 1));
                lVar.w(jSONObject.optInt("spmxrt", 5000));
                lVar.c(jSONObject.optLong("current_time"));
                lVar.r(jSONObject.optInt("offset"));
                lVar.d(jSONObject.optLong("dlct", 3600L));
                lVar.d(jSONObject.optInt("autoplay", 0));
                lVar.k(jSONObject.optInt("dlnet", 2));
                lVar.c(jSONObject.optString("no_offer"));
                lVar.f(jSONObject.optInt("cb_type"));
                lVar.b(jSONObject.optLong("clct", 86400L));
                lVar.a(jSONObject.optLong("clcq", 300L));
                lVar.u(jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100));
                lVar.g(jSONObject.optInt("cd_rate", 0));
                lVar.i(jSONObject.optInt("content", 1));
                lVar.m(jSONObject.optInt("impt", 0));
                lVar.l(jSONObject.optInt("icon_type", 1));
                lVar.b(jSONObject.optString("no_ads_url", ""));
                lVar.t(jSONObject.optInt("playclosebtn_tm", -1));
                lVar.s(jSONObject.optInt("play_ctdown", 0));
                lVar.h(jSONObject.optInt("close_alert", 0));
                lVar.n(jSONObject.optInt("intershowlimit", 30));
                lVar.v(jSONObject.optInt("refreshFq", 60));
                lVar.e(jSONObject.optInt("closeBtn", 0));
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt <= 2 && optInt > 0) {
                    i3 = optInt;
                }
                lVar.y(i3);
                lVar.d(jSONObject.optString("placementid", ""));
                lVar.p(jSONObject.optInt("ltafemty", 10));
                lVar.q(jSONObject.optInt("ltorwc", 60));
                lVar.g(jSONObject.optString("vtag", ""));
                return lVar;
            } catch (Exception e2) {
                e = e2;
                lVar2 = lVar;
                e.printStackTrace();
                return lVar2;
            }
        }
        return lVar2;
    }

    public int A() {
        return this.D;
    }

    public int B() {
        return this.E;
    }

    public int C() {
        return this.F;
    }

    public int D() {
        return this.G;
    }

    public int E() {
        return this.H;
    }

    public int F() {
        return this.I;
    }

    public int G() {
        return this.J;
    }

    public String H() {
        return this.K;
    }

    public String I() {
        return this.L;
    }

    public String J() {
        return this.M;
    }

    public int K() {
        return this.N;
    }

    public int L() {
        return this.g;
    }

    public JSONObject M() {
        JSONObject jSONObject = new JSONObject();
        try {
            List<Integer> b = b();
            if (b != null && b.size() > 0) {
                int size = b.size();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(b.get(i));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            List<Integer> c = c();
            if (c != null && c.size() > 0) {
                int size2 = c.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < size2; i2++) {
                    jSONArray2.put(c.get(i2));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", F());
            jSONObject.put("aqn", f());
            jSONObject.put("acn", e());
            jSONObject.put("wt", K());
            jSONObject.put("current_time", o());
            jSONObject.put("offset", y());
            jSONObject.put("dlct", p());
            jSONObject.put("autoplay", L());
            jSONObject.put("dlnet", q());
            jSONObject.put("no_offer", x());
            jSONObject.put("cb_type", h());
            jSONObject.put("clct", k());
            jSONObject.put("clcq", j());
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, C());
            jSONObject.put("content", m());
            jSONObject.put("impt", s());
            jSONObject.put("icon_type", r());
            jSONObject.put("no_ads_url", w());
            jSONObject.put("playclosebtn_tm", B());
            jSONObject.put("play_ctdown", A());
            jSONObject.put("close_alert", l());
            jSONObject.put("closeBtn", g());
            jSONObject.put("refreshFq", D());
            jSONObject.put("countdown", n());
            jSONObject.put("allowSkip", d());
            jSONObject.put("tmorl", G());
            jSONObject.put("unitId", H());
            jSONObject.put("placementid", z());
            jSONObject.put("ltafemty", u());
            jSONObject.put("ltorwc", v());
            jSONObject.put("vtag", J());
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public List<Integer> b() {
        return this.b;
    }

    public void c(String str) {
        this.A = str;
    }

    public void d(int i) {
        this.g = i;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    public long j() {
        return this.k;
    }

    public long k() {
        return this.l;
    }

    public int l() {
        return this.m;
    }

    public int m() {
        return this.n;
    }

    public int n() {
        return this.o;
    }

    public long o() {
        return this.p;
    }

    public long p() {
        return this.q;
    }

    public int q() {
        return this.r;
    }

    public int r() {
        return this.t;
    }

    public int s() {
        return this.u;
    }

    public int t() {
        return this.w;
    }

    public int u() {
        return this.x;
    }

    public int v() {
        return this.y;
    }

    public String w() {
        return this.z;
    }

    public String x() {
        return this.A;
    }

    public void y(int i) {
        this.J = i;
    }

    public String z() {
        return this.C;
    }

    public void b(List<Integer> list) {
        this.c = list;
    }

    public List<Integer> c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public void e(int i) {
        this.h = i;
    }

    public void f(int i) {
        this.i = i;
    }

    public void g(int i) {
        this.j = i;
    }

    public void h(int i) {
        this.m = i;
    }

    public void i(int i) {
        this.n = i;
    }

    public void j(int i) {
        this.o = i;
    }

    public void k(int i) {
        this.r = i;
    }

    public void l(int i) {
        this.t = i;
    }

    public void m(int i) {
        this.u = i;
    }

    public void n(int i) {
        this.v = i;
    }

    public void o(int i) {
        this.w = i;
    }

    public void p(int i) {
        this.x = i;
    }

    public void q(int i) {
        this.y = i;
    }

    public void r(int i) {
        this.B = i;
    }

    public void s(int i) {
        this.D = i;
    }

    public void t(int i) {
        this.E = i;
    }

    public String toString() {
        List<Integer> list = this.b;
        String str = "";
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = this.b.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
        }
        return "offset = " + y() + " unitId = " + this.K + " fbPlacementId = " + this.s + str;
    }

    public void u(int i) {
        this.F = i;
    }

    public void v(int i) {
        this.G = i;
    }

    public void w(int i) {
        this.H = i;
    }

    public void x(int i) {
        this.I = i;
    }

    public int y() {
        return this.B;
    }

    public void z(int i) {
        this.N = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i;
    }

    public void d(long j) {
        this.q = j;
    }

    public void e(String str) {
        this.K = str;
    }

    public void f(String str) {
        this.L = str;
    }

    public void g(String str) {
        this.M = str;
    }

    public void b(long j) {
        this.l = j;
    }

    public void c(long j) {
        this.p = j;
    }

    public void d(String str) {
        this.C = str;
    }

    public void b(String str) {
        this.z = str;
    }

    public String a() {
        return this.f4700a;
    }

    public void a(String str) {
        this.f4700a = str;
        com.mbridge.msdk.foundation.controller.a.r.put(this.K, str);
    }

    public void a(List<Integer> list) {
        this.b = list;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.k = j;
    }
}

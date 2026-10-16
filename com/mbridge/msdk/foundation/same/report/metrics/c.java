package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MetricsData.java */
/* loaded from: classes6.dex */
public class c implements Serializable, Cloneable {
    private int A;
    private int B;
    private CampaignEx C;
    private CopyOnWriteArrayList<CampaignEx> D;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4329a;
    private Map<String, Map<String, String>> b;
    private Map<String, Map<String, String>> c;
    private Map<String, Map<String, String>> d;
    private Map<String, Long> e;
    private com.mbridge.msdk.foundation.error.b f;
    private String g;
    private CopyOnWriteArrayList<CampaignEx> h;
    private String i;
    private int j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private int z;

    public c() {
        this.f4329a = false;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.g = "";
        this.h = new CopyOnWriteArrayList<>();
        this.s = -1;
        this.u = false;
        this.w = false;
        this.D = new CopyOnWriteArrayList<>();
    }

    public boolean A() {
        return this.v;
    }

    public boolean B() {
        return this.f4329a;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    if (!this.D.isEmpty()) {
                        this.D.clear();
                    }
                    this.D.addAll(list);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String c() {
        return this.q;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void d(String str) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.e.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public void e(int i) {
        this.s = i;
    }

    public void f(String str) {
        this.q = str;
    }

    public List<CampaignEx> g() {
        return this.h;
    }

    public void h(String str) {
        this.p = str;
    }

    public void i(String str) {
        this.g = str;
    }

    public void j(String str) {
        this.r = str;
    }

    public void k(String str) {
        this.l = str;
    }

    public int l() {
        return this.s;
    }

    public void m(String str) {
        this.m = str;
    }

    public void n(String str) {
        this.i = str;
    }

    public String o() {
        return this.g;
    }

    public com.mbridge.msdk.foundation.error.b p() {
        return this.f;
    }

    public Map<String, Map<String, String>> q() {
        return this.d;
    }

    public Map<String, Map<String, String>> r() {
        return this.b;
    }

    public String s() {
        return this.l;
    }

    public String t() {
        return this.o;
    }

    public String u() {
        return this.m;
    }

    public int v() {
        return this.B;
    }

    public String w() {
        Map<String, String> map;
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        try {
            if (TextUtils.isEmpty(this.i)) {
                String str = this.g + this.r;
                Map<String, Map<String, String>> map2 = this.b;
                if (map2 != null && map2.containsKey(str) && (map = this.b.get(str)) != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    this.i = map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return this.i;
    }

    public String x() {
        return this.n;
    }

    public boolean y() {
        return this.u;
    }

    public boolean z() {
        return this.w;
    }

    public void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                if (!this.h.isEmpty()) {
                    this.h.clear();
                }
                this.h.addAll(list);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<String, String> c(String str) {
        com.mbridge.msdk.foundation.error.b p;
        com.mbridge.msdk.foundation.error.b p2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        try {
            this.r = str;
            eVar.a("ts", Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(w())) {
                eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, w());
            }
            if (this.j != 0) {
                eVar.a("adtp", Integer.valueOf(a()));
            }
            if (!TextUtils.isEmpty(n())) {
                eVar.a(CampaignEx.JSON_KEY_HB, n());
            }
            if (!TextUtils.isEmpty(f())) {
                eVar.a("bid_tk", f());
            }
            if (!TextUtils.isEmpty(str)) {
                eVar.a(C3040d4.h.W, str);
            }
            if (Arrays.asList(b.f4328a).contains(str)) {
                eVar.a("from_cache", y() ? "1" : "2");
            }
            if ("2000047".contains(str) && (p2 = p()) != null) {
                eVar.a("type", Integer.valueOf(p2.c()));
                eVar.a("reason", p2.g());
                if (!TextUtils.isEmpty(p2.h())) {
                    eVar.a("reason_d", p2.h());
                    eVar.a("type_d", Integer.valueOf(p2.i()));
                }
            }
            if ("2000048".contains(str) && (p = p()) != null && !TextUtils.isEmpty(p.h())) {
                eVar.a("type", Integer.valueOf(p.i()));
                eVar.a("reason", p.h());
            }
            if (this.j == 296) {
                eVar.a("auto_load", c());
                eVar.a("auto_refresh", Integer.valueOf(b()));
                eVar.a("auto_refresh_interval", Integer.valueOf(e()));
                eVar.a("content_type", Integer.valueOf(k()));
                eVar.a("temp_display_type", Integer.valueOf(v()));
            }
            a(eVar);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String str2 = this.g + str;
            Map<String, Map<String, String>> map = this.b;
            if (map == null || !map.containsKey(str2)) {
                return;
            }
            this.b.remove(str2);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public String f() {
        return this.k;
    }

    public void g(String str) {
        this.k = str;
    }

    public CampaignEx i() {
        return this.C;
    }

    public List<CampaignEx> j() {
        return this.D;
    }

    public int k() {
        return this.A;
    }

    public void l(String str) {
        this.o = str;
    }

    public int m() {
        return this.t;
    }

    public String n() {
        return this.p;
    }

    public void o(String str) {
        this.n = str;
    }

    public void d(boolean z) {
        this.x = z;
    }

    public void f(int i) {
        this.t = i;
    }

    public void g(int i) {
        this.B = i;
    }

    public void d(int i) {
        this.A = i;
    }

    public void b(String str, e eVar) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        try {
            String str2 = this.g + str;
            Map<String, Map<String, String>> map2 = this.c;
            if (map2 != null) {
                if (map2.containsKey(str2) && (map = this.c.get(str2)) != null) {
                    map.putAll(eVar.a());
                } else {
                    this.c.put(str2, eVar.a());
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void a(CampaignEx campaignEx) {
        this.C = campaignEx;
        if (campaignEx == null) {
            return;
        }
        try {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.D;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i >= this.D.size()) {
                        break;
                    }
                    if (this.D.get(i) != null && this.D.get(i).getId().equals(campaignEx.getId())) {
                        this.D.set(i, campaignEx);
                        break;
                    }
                    i++;
                }
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.h;
            if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (this.h.get(i2) != null && this.h.get(i2).getId().equals(campaignEx.getId())) {
                    this.h.set(i2, campaignEx);
                    return;
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public int e() {
        return this.z;
    }

    public long b(String str) {
        Map<String, Long> map;
        try {
            if (!TextUtils.isEmpty(str) && (map = this.e) != null && map.containsKey(str)) {
                Long l = this.e.get(str);
                return System.currentTimeMillis() - (l != null ? l.longValue() : 0L);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return 0L;
    }

    public int a() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public Map<String, String> a(String str) {
        return this.c.containsKey(str) ? this.c.remove(str) : new HashMap();
    }

    public void b(boolean z) {
        this.w = z;
    }

    public int b() {
        return this.y;
    }

    public void b(int i) {
        this.y = i;
    }

    public void a(String str, e eVar) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        try {
            String str2 = this.g + str;
            Map<String, Map<String, String>> map2 = this.b;
            if (map2 != null) {
                if (map2.containsKey(str2) && (map = this.b.get(str2)) != null) {
                    map.putAll(eVar.a());
                } else {
                    this.b.put(str2, eVar.a());
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void a(e eVar) {
        if ("2000126".equals(this.r)) {
            String a2 = com.mbridge.msdk.foundation.same.net.d.a(f());
            if (eVar != null) {
                eVar.a("dns_ty", Integer.valueOf(com.mbridge.msdk.setting.e.a().a(a2)));
                eVar.a("dns_hs", a2);
            }
        }
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void c(int i) {
        this.z = i;
    }

    public void a(com.mbridge.msdk.foundation.error.b bVar) {
        this.f = bVar;
    }

    public c(boolean z) {
        this.f4329a = false;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.g = "";
        this.h = new CopyOnWriteArrayList<>();
        this.s = -1;
        this.u = false;
        this.w = false;
        this.D = new CopyOnWriteArrayList<>();
        this.f4329a = z;
    }
}

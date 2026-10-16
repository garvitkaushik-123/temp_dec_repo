package com.ironsource;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.n2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3207n2 {
    public static final String A = "nurl";
    public static final String o = "adMarkup";
    public static final String p = "instance";
    public static final String q = "adData";
    public static final String r = "price";
    public static final String s = "serverData";
    public static final String t = "loadTimeout";
    public static final String u = "order";
    public static final String v = "show";
    public static final String w = "price";
    public static final String x = "notifications";
    public static final String y = "burl";
    public static final String z = "lurl";

    /* renamed from: a, reason: collision with root package name */
    private String f3597a;
    private String b;
    private JSONObject c;
    private String d;
    private Integer e;
    private int f;
    private int g;
    private int h;
    private final List<String> i;
    private final List<String> j;
    private final List<String> k;
    private ImpressionData l;
    private C3132ib m;
    private boolean n;

    public C3207n2(String str) {
        this.f3597a = null;
        this.b = "";
        this.c = null;
        this.d = "";
        this.e = null;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = null;
        this.m = null;
        this.n = true;
        this.f3597a = str;
    }

    private void a(JSONObject jSONObject, int i) {
        this.f = i;
        this.g = i;
        this.h = i;
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(v, i);
            this.g = optInt;
            this.h = jSONObject.optInt("price", optInt);
        }
    }

    public List<String> b() {
        return this.i;
    }

    public String c() {
        return this.f3597a;
    }

    public C3132ib d() {
        return this.m;
    }

    public int e() {
        return this.f;
    }

    public Integer f() {
        return this.e;
    }

    public List<String> g() {
        return this.j;
    }

    public List<String> h() {
        return this.k;
    }

    public String i() {
        return this.d;
    }

    public int j() {
        return this.h;
    }

    public String k() {
        return this.b;
    }

    public int l() {
        return this.g;
    }

    public boolean m() {
        return this.n;
    }

    public JSONObject a() {
        return this.c;
    }

    public ImpressionData a(String str) {
        ImpressionData impressionData = this.l;
        if (impressionData == null) {
            return null;
        }
        ImpressionData impressionData2 = new ImpressionData(impressionData);
        impressionData2.replaceMacroForPlacementWithValue(com.ironsource.mediationsdk.d.r, str);
        return impressionData2;
    }

    private void a(JSONObject jSONObject, String str, List<String> list) throws JSONException {
        if (jSONObject.has(str)) {
            list.addAll(V9.b(jSONObject.getJSONArray(str)));
        }
    }

    public C3207n2(JSONObject jSONObject) {
        this(jSONObject, -1, null);
    }

    public C3207n2(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        this.f3597a = null;
        this.b = "";
        this.c = null;
        this.d = "";
        this.e = null;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.j = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.k = arrayList3;
        this.l = null;
        this.m = null;
        this.n = true;
        try {
            if (jSONObject.has(p)) {
                this.f3597a = jSONObject.getString(p);
            }
            if (jSONObject.has("adMarkup")) {
                this.b = jSONObject.getString("adMarkup");
            } else if (jSONObject.has(s)) {
                this.b = jSONObject.getJSONObject(s).toString();
            }
            this.c = jSONObject.optJSONObject("adData");
            this.d = jSONObject.optString("price", "0");
            if (jSONObject.has(x)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(x);
                a(jSONObject3, y, arrayList);
                a(jSONObject3, z, arrayList2);
                a(jSONObject3, A, arrayList3);
            }
            this.l = new ImpressionData(V9.a(jSONObject2, jSONObject.optJSONObject(com.ironsource.mediationsdk.d.d)));
            this.m = jSONObject.has(com.ironsource.mediationsdk.d.e) ? C3132ib.a(jSONObject.getJSONObject(com.ironsource.mediationsdk.d.e)) : null;
            this.e = jSONObject.has(t) ? Integer.valueOf((int) TimeUnit.MILLISECONDS.toSeconds(jSONObject.getLong(t))) : null;
            a(jSONObject.optJSONObject(u), i);
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.n = false;
            IronLog.INTERNAL.error("exception " + e.getMessage());
        }
    }
}

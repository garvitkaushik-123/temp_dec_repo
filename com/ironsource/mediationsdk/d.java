package com.ironsource.mediationsdk;

import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.ironsource.A5;
import com.ironsource.C3018c2;
import com.ironsource.C3089g2;
import com.ironsource.C3207n2;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C3413z5;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.J9;
import com.ironsource.N6;
import com.ironsource.V1;
import com.ironsource.V9;
import com.ironsource.W0;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.p;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class d {
    public static final boolean A = false;
    private static d B = new d();
    public static final String c = "auctionId";
    public static final String d = "armData";
    public static final String e = "larmData";
    public static final String f = "isAdUnitCapped";
    public static final String g = "settings";
    public static final String h = "waterfall";
    public static final String i = "genericParams";
    public static final String j = "configurations";
    public static final String k = "instances";
    public static final String l = "${AUCTION_LOSS}";
    public static final String m = "${AUCTION_MBR}";
    public static final String n = "${AUCTION_PRICE}";
    public static final String o = "${DYNAMIC_DEMAND_SOURCE}";
    public static final String p = "${INSTANCE}";
    public static final String q = "${INSTANCE_TYPE}";
    public static final String r = "${PLACEMENT_NAME}";
    private static final String s = "adMarkup";
    private static final String t = "dynamicDemandSource";
    private static final String u = "params";
    public static final String v = "dlpl";
    public static final String w = "adUnit";
    public static final String x = "parallelLoad";
    public static final String y = "bidderExclusive";
    public static final String z = "showPriorityEnabled";

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f3502a = new AtomicBoolean(false);
    private final InterfaceC3381x7 b = C3334ub.U().i();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f3503a;
        private List<C3207n2> b;
        private C3207n2 c;
        private JSONObject d;
        private JSONObject e;
        private int f;
        private String g;
        private V1 h;

        public a(String str) {
            this.f3503a = str;
        }

        public String a() {
            return this.f3503a;
        }

        public JSONObject b() {
            return this.e;
        }

        public int c() {
            return this.f;
        }

        public String d() {
            return this.g;
        }

        public C3207n2 e() {
            return this.c;
        }

        public JSONObject f() {
            return this.d;
        }

        public V1 g() {
            return this.h;
        }

        public List<C3207n2> h() {
            return this.b;
        }

        public com.ironsource.mediationsdk.demandOnly.p a(String str) {
            V1 v1 = this.h;
            return v1 != null ? v1.a(str) : new p.b();
        }
    }

    static class b implements Runnable {
        private static final int d = 15000;

        /* renamed from: a, reason: collision with root package name */
        private String f3504a;
        private String b;
        private String c;

        public b(String str, String str2, String str3) {
            this.f3504a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0081 A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:3:0x0025, B:9:0x005a, B:11:0x0081, B:12:0x0086, B:16:0x0084), top: B:2:0x0025 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0084 A[Catch: Exception -> 0x0097, TryCatch #0 {Exception -> 0x0097, blocks: (B:3:0x0025, B:9:0x005a, B:11:0x0081, B:12:0x0086, B:16:0x0084), top: B:2:0x0025 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            String str = this.f3504a + ";" + this.b + ";" + this.c;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.c).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                httpURLConnection.disconnect();
                if (responseCode != 200 && responseCode != 204) {
                    z = false;
                    C3334ub.U().q().a(new C3413z5(!z ? A5.TROUBLESHOOTING_SEND_AUCTION_URL_SUCCESS : A5.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, new JSONObject().put(IronSourceConstants.EVENTS_PROVIDER, "Mediation").put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1).put(IronSourceConstants.EVENTS_EXT1, str).put(IronSourceConstants.EVENTS_ERROR_CODE, responseCode).put("reason", responseMessage)));
                }
                z = true;
                C3334ub.U().q().a(new C3413z5(!z ? A5.TROUBLESHOOTING_SEND_AUCTION_URL_SUCCESS : A5.TROUBLESHOOTING_FAILED_TO_SEND_AUCTION_URL, new JSONObject().put(IronSourceConstants.EVENTS_PROVIDER, "Mediation").put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1).put(IronSourceConstants.EVENTS_EXT1, str).put(IronSourceConstants.EVENTS_ERROR_CODE, responseCode).put("reason", responseMessage)));
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error("Send auction url failed with params - " + str + ";" + e.getMessage());
            }
        }
    }

    private enum c {
        NOT_SECURE,
        SECURE
    }

    public static d b() {
        return B;
    }

    public a a(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("auctionId");
        if (TextUtils.isEmpty(optString)) {
            throw new JSONException("Invalid auction response - auction id is missing");
        }
        a aVar = new a(optString);
        if (jSONObject.has("settings")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
            aVar.c = new C3207n2(jSONObject2);
            r3 = jSONObject2.has(d) ? jSONObject2.optJSONObject(d) : null;
            if (jSONObject2.has("genericParams")) {
                aVar.d = jSONObject2.optJSONObject("genericParams");
            }
            if (jSONObject2.has("configurations")) {
                aVar.e = jSONObject2.optJSONObject("configurations");
            }
            if (jSONObject2.has(k)) {
                aVar.h = new V1.a(jSONObject2.optJSONObject(k));
            }
        }
        aVar.b = new ArrayList();
        if (jSONObject.has(h)) {
            JSONArray jSONArray = jSONObject.getJSONArray(h);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                C3207n2 c3207n2 = new C3207n2(jSONArray.getJSONObject(i2), i2, r3);
                if (!c3207n2.m()) {
                    aVar.f = 1002;
                    aVar.g = "waterfall " + i2;
                    IronLog.INTERNAL.verbose("AuctionResponseItem " + i2 + " not valid - parsing error");
                    throw new JSONException("invalid response");
                }
                aVar.b.add(c3207n2);
            }
        }
        return aVar;
    }

    public String c(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str) || !V9.a(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("params")) {
                return "";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("parameters = " + jSONObject2);
            if (!jSONObject2.has("dynamicDemandSource")) {
                return "";
            }
            str2 = jSONObject2.getString("dynamicDemandSource");
            ironLog.verbose("demand source = " + str2);
            return str2;
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error("exception " + e2.getMessage());
            return str2;
        }
    }

    public Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        hashMap.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error("exception " + e2.getMessage());
        }
        return hashMap;
    }

    private c a() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? c.NOT_SECURE : c.SECURE;
    }

    JSONObject a(i iVar) throws JSONException {
        IronSource.AD_UNIT ad_unit;
        boolean z2;
        List<String> list;
        IronSource.AD_UNIT c2 = iVar.c();
        boolean t2 = iVar.t();
        Map<String, Object> h2 = iVar.h();
        List<String> l2 = iVar.l();
        h e2 = iVar.e();
        int o2 = iVar.o();
        ISBannerSize f2 = iVar.f();
        IronSourceSegment n2 = iVar.n();
        boolean p2 = iVar.p();
        boolean q2 = iVar.q();
        ArrayList<C3089g2> k2 = iVar.k();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> it = h2.keySet().iterator();
        while (true) {
            ad_unit = c2;
            z2 = t2;
            String str = "";
            list = l2;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            ISBannerSize iSBannerSize = f2;
            JSONObject jSONObject3 = new JSONObject();
            IronSourceSegment ironSourceSegment = n2;
            jSONObject3.put(N6.x0, 2);
            jSONObject3.put(N6.o0, new JSONObject((Map) h2.get(next)));
            if (e2 != null) {
                str = e2.a(next);
            }
            jSONObject3.put(N6.A0, str);
            jSONObject3.put("ts", q2 ? 1 : 0);
            jSONObject2.put(next, jSONObject3);
            c2 = ad_unit;
            t2 = z2 ? 1 : 0;
            l2 = list;
            f2 = iSBannerSize;
            n2 = ironSourceSegment;
        }
        ISBannerSize iSBannerSize2 = f2;
        IronSourceSegment ironSourceSegment2 = n2;
        int i2 = 2;
        for (String str2 : list) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(N6.x0, 1);
            jSONObject4.put(N6.A0, e2 != null ? e2.a(str2) : "");
            jSONObject2.put(str2, jSONObject4);
        }
        Iterator<C3089g2> it2 = k2.iterator();
        while (it2.hasNext()) {
            C3089g2 next2 = it2.next();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(N6.x0, next2.e() ? i2 : 1);
            Map<String, Object> f3 = next2.f();
            if (!f3.isEmpty()) {
                jSONObject5.put(N6.o0, new JSONObject(f3));
            }
            jSONObject5.put(N6.A0, e2 != null ? e2.a(next2.g()) : "");
            jSONObject5.put("ts", q2 ? 1 : 0);
            if (!next2.h().isEmpty()) {
                jSONObject5.put(v, next2.h());
            }
            jSONObject2.put(next2.g(), jSONObject5);
            i2 = 2;
        }
        jSONObject.put(N6.w0, jSONObject2);
        if (iVar.v()) {
            jSONObject.put(N6.w1, 1);
        }
        if (iVar.s()) {
            jSONObject.put("do", 1);
        }
        new J9().b(ContextProvider.getInstance().getApplicationContext());
        JSONObject a2 = new C3018c2(W0.a(ad_unit)).a();
        a(a2, false);
        a2.put(N6.y0, o2);
        a2.put(N6.z0, a().ordinal());
        if (ironSourceSegment2 != null) {
            a2.put(N6.i1, ironSourceSegment2.toJson());
        }
        jSONObject.put(N6.t0, a2);
        if (iSBannerSize2 != null) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(N6.q0, iSBannerSize2.getDescription());
            jSONObject6.put(N6.s0, iSBannerSize2.getWidth());
            jSONObject6.put(N6.r0, iSBannerSize2.getHeight());
            jSONObject.put(N6.p0, jSONObject6);
        }
        jSONObject.put(N6.k0, ad_unit.toString());
        if (iVar.b() != null) {
            jSONObject.put("adf", iVar.b());
        }
        if (iVar.d() != null) {
            jSONObject.put("mediationAdUnitId", iVar.d());
        }
        if (iVar.u() != null) {
            jSONObject.put(N6.n0, iVar.u());
        }
        jSONObject.put(N6.u0, !z2 ? 1 : 0);
        if (iVar.g() != null) {
            jSONObject.put(N6.s1, new JSONObject().put(N6.t1, iVar.g()));
        } else {
            Object remove = a2.remove(N6.s1);
            if (remove != null) {
                jSONObject.put(N6.s1, remove);
            }
        }
        if (p2) {
            jSONObject.put(N6.q1, 1);
        }
        return jSONObject;
    }

    public String a(String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7) {
        return str.replace(n, str4).replace(l, str6).replace(m, str5).replace(p, str2).replace(q, Integer.toString(i2)).replace(o, str3).replace(r, str7);
    }

    public String a(String str, int i2, C3207n2 c3207n2, String str2, String str3, String str4) {
        String i3 = c3207n2.i();
        return a(str, c3207n2.c(), i2, b().c(c3207n2.k()), i3, b().a(i3, str2), str3, str4);
    }

    public void a(String str, String str2, String str3) {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b(str, str2, str3));
    }

    public String a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("adMarkup")) {
                    return jSONObject.getString("adMarkup");
                }
            }
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error("exception " + e2.getMessage());
        }
        return str;
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        double parseDouble = Double.parseDouble(str);
        return Double.parseDouble(str2) == 0.0d ? "" : String.valueOf(Math.round((parseDouble / r7) * 1000.0d) / 1000.0d);
    }

    public void a(JSONObject jSONObject, boolean z2) {
        if (jSONObject == null || jSONObject.length() <= 0 || TextUtils.isEmpty(jSONObject.optString(N6.k1)) || !this.f3502a.compareAndSet(false, true)) {
            return;
        }
        C3334ub.U().q().a(new C3413z5(A5.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED, IronSourceUtils.getMediationAdditionalData(z2, true, -1)));
    }
}

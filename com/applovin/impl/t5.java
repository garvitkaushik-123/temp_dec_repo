package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.b6;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.q3;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.Y1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class t5 extends g5 {
    private final x2 g;
    private final JSONArray h;
    private final Context i;
    private final a.InterfaceC0097a j;

    public t5(x2 x2Var, JSONArray jSONArray, Context context, com.applovin.impl.sdk.k kVar, a.InterfaceC0097a interfaceC0097a) {
        super("TaskFetchMediatedAd", kVar, x2Var.b());
        this.g = x2Var;
        this.h = jSONArray;
        this.i = context;
        this.j = interfaceC0097a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        try {
            r0.c(jSONObject, this.f464a);
            r0.b(jSONObject, this.f464a);
            r0.a(jSONObject, this.f464a);
            i3.f(jSONObject, this.f464a);
            i3.d(jSONObject, this.f464a);
            i3.e(jSONObject, this.f464a);
            i3.g(jSONObject, this.f464a);
            this.f464a.m().a();
            MaxAdFormat a2 = this.g.a();
            MaxAdFormat formatFromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, null));
            if (a2 == formatFromString) {
                a(jSONObject);
                return;
            }
            String b = this.g.b();
            if (formatFromString == null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Mediated ad response is missing the ad format field for ad unit " + b);
                }
                if (jSONObject.has(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS)) {
                    HashMap hashMap = new HashMap(3);
                    CollectionUtils.putStringIfValid("details", "Missing ad format field", hashMap);
                    CollectionUtils.putStringIfValid("ad_unit_id", b, hashMap);
                    CollectionUtils.putStringIfValid("mcode", JsonUtils.getString(jSONObject, "mcode", ""), hashMap);
                    this.f464a.E().a(c2.M0, this.b, hashMap);
                }
                this.j.onAdLoadFailed(b, MaxAdapterError.NO_FILL);
                return;
            }
            String label = formatFromString.getLabel();
            String label2 = a2.getLabel();
            String str = "Incorrect format (" + label + ") loaded for (" + label2 + ") ad. Please verify if the ad unit ID (" + b + ") is assigned to the correct ad format.";
            if (k7.a(a2, formatFromString)) {
                com.applovin.impl.sdk.o.j(this.b, str);
                a(jSONObject);
                return;
            }
            k1.a(str, new Object[0]);
            com.applovin.impl.sdk.o.h(this.b, str);
            this.j.onAdLoadFailed(b, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str));
            HashMap<String, String> hashMap2 = CollectionUtils.hashMap("ad_unit_id", b);
            CollectionUtils.putStringIfValid("name", label2, hashMap2);
            CollectionUtils.putStringIfValid("details", label, hashMap2);
            this.f464a.E().a(c2.E0, "incompatible_ad_format", hashMap2);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to process mediated ad response for ad unit " + this.g.b(), th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private void c(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f464a.X().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData == null || !k7.h(com.applovin.impl.sdk.k.o())) {
            return;
        }
        JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
    }

    private void d(JSONObject jSONObject) {
        if (((Boolean) this.f464a.a(v4.C4)).booleanValue()) {
            r3 Y = this.f464a.Y();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            p3 p3Var = p3.f;
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) Y.a(p3Var, q3.a.AD_UNIT_ID));
            JsonUtils.putJSONObject(jSONObject2, "arpau", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.putAll(jSONObject4, (Map<String, ?>) Y.a(p3Var, q3.a.AD_FORMAT));
            JsonUtils.putJSONObject(jSONObject2, "arpaf", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            JsonUtils.putAll(jSONObject5, (Map<String, ?>) Y.a(p3.g, q3.a.AD));
            JsonUtils.putJSONObject(jSONObject2, "ttdasipa_ms", jSONObject5);
            JsonUtils.putJSONObject(jSONObject, "mediation_stats", jSONObject2);
        }
    }

    private String e() {
        return i3.a(this.f464a);
    }

    private String f() {
        return i3.b(this.f464a);
    }

    private JSONObject g() {
        Map a2 = this.f464a.B().a((Map) null, false, true);
        a2.putAll(this.g.c());
        JSONObject jSONObject = new JSONObject(a2);
        e(jSONObject);
        h(jSONObject);
        f(jSONObject);
        c(jSONObject);
        g(jSONObject);
        d(jSONObject);
        return jSONObject;
    }

    private Map h() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("AppLovin-Ad-Unit-Id", this.g.b());
        hashMap.put("AppLovin-Ad-Format", this.g.a().getLabel());
        Map d = this.g.d();
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", d.get("retry_attempt"), hashMap);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", d.get("retry_delay_sec"), hashMap);
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        t5 t5Var;
        JSONObject g;
        HashMap hashMap;
        MaxAdFormat a2 = this.g.a();
        String b = this.g.b();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Fetching next ad for " + a2.getLabel() + " ad unit " + b);
        }
        j2.a();
        if (((Boolean) this.f464a.a(v4.Q3)).booleanValue() && k7.j() && com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "User is connected to a VPN");
        }
        this.f464a.P().a(c2.T, a2, b, (MaxError) null);
        if (((Boolean) this.f464a.a(v4.C4)).booleanValue()) {
            r3 Y = this.f464a.Y();
            p3 p3Var = p3.f;
            Y.a(p3Var, q3.a(b));
            Y.a(p3Var, q3.a(a2));
        }
        k7.a(this.f464a, this.b);
        try {
            g = g();
            hashMap = new HashMap();
            if (!((Boolean) this.f464a.a(v4.q5)).booleanValue() && !((Boolean) this.f464a.a(v4.o5)).booleanValue()) {
                hashMap.put("rid", UUID.randomUUID().toString());
            }
            if (!((Boolean) this.f464a.a(v4.a5)).booleanValue()) {
                hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f464a.j0());
            }
            if (this.f464a.t0().c()) {
                hashMap.put("test_mode", "1");
            }
            List b2 = this.f464a.t0().b();
            String str = this.f464a.o0().getExtraParameters().get("fan");
            if (b2 != null && !b2.isEmpty()) {
                String join = String.join(",", b2);
                hashMap.put("filter_ad_network", join);
                if (!this.f464a.t0().c()) {
                    hashMap.put("fhkZsVqYC7", "1");
                }
                if (this.f464a.t0().d()) {
                    hashMap.put("force_ad_network", join);
                }
            } else if (StringUtils.isValidString(str)) {
                hashMap.put("filter_ad_network", str);
            }
            t5Var = this;
        } catch (Throwable th) {
            th = th;
            t5Var = this;
        }
        try {
            a aVar = t5Var.new a(com.applovin.impl.sdk.network.a.a(this.f464a).c("POST").a(h()).b(f()).a(e()).b(hashMap).a(g).b(((Boolean) this.f464a.a(o3.o8)).booleanValue()).a((Object) new JSONObject()).c(((Long) this.f464a.a(o3.j7)).intValue()).a(((Integer) this.f464a.a(v4.U2)).intValue()).b(((Long) this.f464a.a(o3.i7)).intValue()).a(s4.a.a(((Integer) this.f464a.a(v4.g5)).intValue())).f(true).a(), this.f464a, b, a2);
            aVar.c(o3.g7);
            aVar.b(o3.h7);
            t5Var.f464a.r0().a(aVar);
        } catch (Throwable th2) {
            th = th2;
            if (com.applovin.impl.sdk.o.a()) {
                t5Var.c.a(t5Var.b, "Unable to fetch ad for Ad Unit ID: " + b, th);
            }
            a("", 0, th.getMessage());
        }
    }

    class a extends j6 {
        final /* synthetic */ String m;
        final /* synthetic */ MaxAdFormat n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, String str, MaxAdFormat maxAdFormat) {
            super(aVar, kVar);
            this.m = str;
            this.n = maxAdFormat;
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (i != 200) {
                t5.this.a(str, i, null);
                return;
            }
            JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.l.a());
            JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.l.b());
            HashMap hashMap = new HashMap(6);
            CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), hashMap);
            CollectionUtils.putStringIfValid("code", String.valueOf(i), hashMap);
            CollectionUtils.putStringIfValid("ad_unit_id", this.m, hashMap);
            CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, this.n.getLabel(), hashMap);
            CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.l.a()), hashMap);
            CollectionUtils.putStringIfValid("response_size", String.valueOf(this.l.b()), hashMap);
            this.f464a.P().d(c2.U, hashMap);
            t5.this.b(jSONObject);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            t5.this.a(str, i, str2);
            this.f464a.E().a("fetchMediatedAd", str, i, str2);
        }
    }

    private void e(JSONObject jSONObject) {
        String b = this.g.b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", b);
        jSONObject2.put(FirebaseAnalytics.Param.AD_FORMAT, this.g.a().getLabel());
        Map map = CollectionUtils.map(this.g.d());
        com.applovin.impl.sdk.p a0 = this.f464a.a0();
        CollectionUtils.putStringIfValid("previous_request_id", a0.b(b), map);
        CollectionUtils.putStringIfValid("previous_loaded_request_id", a0.a(b), map);
        p.a c = a0.c(b);
        if (c != null) {
            if (Boolean.parseBoolean(this.f464a.o0().getExtraParameters().get("esc"))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", "AppLovin");
            } else {
                map.put("previous_winning_network", c.a());
                map.put("previous_winning_network_name", c.c());
            }
            if (this.f464a.R() != null) {
                Queue<v2> c2 = this.f464a.R().c(b);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (v2 v2Var : c2) {
                    arrayList.add(v2Var.c());
                    arrayList2.add(v2Var.getNetworkName());
                }
                CollectionUtils.putStringIfValid("queued_ad_networks", String.join(",", arrayList), map);
                CollectionUtils.putStringIfValid("queued_ad_network_names", String.join(",", arrayList2), map);
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void f(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Y1.e, new JSONArray(this.f464a.T().a()));
            jSONObject2.put("installed", t3.b(this.f464a));
            jSONObject2.put("initialized", this.f464a.S().b());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.f464a.S().a()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f464a.T().c()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f464a.T().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to populate adapter classNames", e);
            }
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    private void a(JSONObject jSONObject) {
        d6 d6Var = new d6(this.g, jSONObject, this.i, this.f464a, this.j);
        long j = JsonUtils.getLong(jSONObject, "process_waterfall_delay_ms", -1L);
        if (j > 0) {
            this.f464a.r0().a(d6Var, b6.b.MEDIATION, j, true);
        } else {
            this.f464a.r0().a(d6Var);
        }
    }

    private void h(JSONObject jSONObject) {
        JSONArray jSONArray = this.h;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f464a.o0().getExtraParameters()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2) {
        MaxErrorImpl maxErrorImpl;
        String b = this.g.b();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to fetch ad for ad unit " + b + ": server returned " + i);
        }
        if (i == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str2);
        } else if (i == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str2);
        } else if (StringUtils.isValidString(str2)) {
            maxErrorImpl = new MaxErrorImpl(-1000, str2);
        } else {
            maxErrorImpl = new MaxErrorImpl(-1);
        }
        HashMap hashMap = new HashMap(5);
        CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), hashMap);
        CollectionUtils.putStringIfValid("code", String.valueOf(i), hashMap);
        CollectionUtils.putStringIfValid("error_message", str2, hashMap);
        CollectionUtils.putStringIfValid("ad_unit_id", b, hashMap);
        CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, this.g.a().getLabel(), hashMap);
        this.f464a.P().d(c2.V, hashMap);
        q2.a(this.j, b, maxErrorImpl);
    }
}

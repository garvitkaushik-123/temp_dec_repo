package com.applovin.impl;

import android.app.ActivityManager;
import android.net.Uri;
import android.os.SystemClock;
import com.applovin.impl.b6;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class r5 extends g5 {
    private static final AtomicBoolean j = new AtomicBoolean();
    private final int g;
    private final Object h;
    private b i;

    public interface b {
        void a(JSONObject jSONObject);
    }

    private class c extends g5 {
        public c(com.applovin.impl.sdk.k kVar) {
            super("TaskTimeoutFetchBasicSettings", kVar, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r5.this.i != null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Timing out fetch basic settings...");
                }
                r5.this.a(new JSONObject());
            }
        }
    }

    public r5(int i, com.applovin.impl.sdk.k kVar, b bVar) {
        super("TaskFetchBasicSettings", kVar, true);
        this.h = new Object();
        this.g = i;
        this.i = bVar;
    }

    private HashMap b(String str) {
        return a(str, 0L, 0, null, null);
    }

    private String f() {
        return r0.a((String) this.f464a.a(v4.n0), "5.0/i", b());
    }

    private String g() {
        return r0.a((String) this.f464a.a(v4.m0), "5.0/i", b());
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.applovin.impl.sdk.k kVar = this.f464a;
            v4 v4Var = v4.o5;
            if (((Boolean) kVar.a(v4Var)).booleanValue() || ((Boolean) this.f464a.a(v4Var)).booleanValue()) {
                jSONObject.put("rid", UUID.randomUUID().toString());
            }
            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, AppLovinSdk.VERSION);
            JsonUtils.putStringIfValid(jSONObject, "ad_review_sdk_version", j.b());
            jSONObject.put("init_count", this.g);
            jSONObject.put("server_installed_at", this.f464a.a(v4.o));
            if (this.f464a.D0()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f464a.A0()) {
                jSONObject.put("first_install_v2", true);
            }
            JsonUtils.putStringIfValid(jSONObject, "process_name", k7.c(a()));
            JsonUtils.putBooleanIfValid(jSONObject, "is_main_process", k7.i(a()));
            JsonUtils.putStringIfValid(jSONObject, "plugin_version", (String) this.f464a.a(v4.I3));
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider", this.f464a.V());
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider_v2", this.f464a.D());
            jSONObject.put("installed_mediation_adapters", t3.b(this.f464a));
            Map E = this.f464a.B().E();
            jSONObject.put("package_name", E.get("package_name"));
            jSONObject.put(BidTokenRepositoryKt.APP_VERSION, E.get(BidTokenRepositoryKt.APP_VERSION));
            jSONObject.put("debug", E.get("debug"));
            jSONObject.put("tg", E.get("tg"));
            jSONObject.put("target_sdk", E.get("target_sdk"));
            jSONObject.put("session_id", E.get("session_id"));
            List list = (List) E.get("application_start_info");
            if (!CollectionUtils.isEmpty(list)) {
                JsonUtils.putJsonArray(jSONObject, "application_start_info", new JSONArray((Collection) list));
            }
            List list2 = (List) E.get("application_exit_info");
            if (!CollectionUtils.isEmpty(list2)) {
                JsonUtils.putJsonArray(jSONObject, "application_exit_info", new JSONArray((Collection) list2));
            }
            List<String> adUnitIds = this.f464a.K() != null ? this.f464a.K().getAdUnitIds() : null;
            if (adUnitIds != null && adUnitIds.size() > 0) {
                List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(adUnitIds);
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(removeTrimmedEmptyStrings, removeTrimmedEmptyStrings.size()));
            }
            jSONObject.put("IABTCF_TCString", E.get("IABTCF_TCString"));
            jSONObject.put("IABTCF_gdprApplies", E.get("IABTCF_gdprApplies"));
            Object obj = E.get("IABTCF_AddtlConsent");
            if (obj instanceof String) {
                JsonUtils.putStringIfValid(jSONObject, "IABTCF_AddtlConsent", (String) obj);
            }
            jSONObject.put("consent_flow_info", this.f464a.y().b());
            Map L = this.f464a.B().L();
            jSONObject.put(N6.H, L.get(N6.H));
            jSONObject.put(N6.F, L.get(N6.F));
            jSONObject.put("locale", L.get("locale"));
            jSONObject.put("brand", L.get("brand"));
            jSONObject.put("brand_name", L.get("brand_name"));
            jSONObject.put("hardware", L.get("hardware"));
            jSONObject.put(N6.B, L.get(N6.B));
            jSONObject.put("revision", L.get("revision"));
            jSONObject.put("is_tablet", L.get("is_tablet"));
            jSONObject.put("screen_size_in", L.get("screen_size_in"));
            jSONObject.put("supported_abis", L.get("supported_abis"));
            Object obj2 = L.get("video_decoders");
            if (obj2 != null) {
                jSONObject.put("video_decoders", obj2);
            }
            if (((Boolean) this.f464a.a(v4.T3)).booleanValue()) {
                jSONObject.put("mtl", this.f464a.n0().getLastTrimMemoryLevel());
            }
            try {
                ActivityManager activityManager = (ActivityManager) com.applovin.impl.sdk.k.o().getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("fm", memoryInfo.availMem);
                    jSONObject.put("tm", memoryInfo.totalMem);
                    jSONObject.put("lmt", memoryInfo.threshold);
                    jSONObject.put("lm", memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            v.a f = this.f464a.B().f();
            jSONObject.put("dnt", f.c());
            jSONObject.put("dnt_code", f.b().b());
            Boolean b2 = p0.c().b(a());
            if (((Boolean) this.f464a.a(v4.D3)).booleanValue() && StringUtils.isValidString(f.a()) && !Boolean.TRUE.equals(b2)) {
                jSONObject.put("idfa", f.a());
            }
            l.b F = this.f464a.B().F();
            if (((Boolean) this.f464a.a(v4.w3)).booleanValue() && F != null && !Boolean.TRUE.equals(b2)) {
                jSONObject.put("idfv", F.f702a);
                jSONObject.put("idfv_scope", F.b);
            }
            if (((Boolean) this.f464a.a(v4.z3)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f464a.v());
            }
            if (((Boolean) this.f464a.a(v4.B3)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f464a.i0());
            }
            if (((Boolean) this.f464a.a(v4.F3)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "art", this.f464a.s());
            }
            JsonUtils.putStringIfValid(jSONObject, "eventid", this.f464a.F());
            if (this.f464a.t0().c()) {
                jSONObject.put("test_mode", true);
            }
            List b3 = this.f464a.t0().b();
            if (b3 != null && !b3.isEmpty()) {
                jSONObject.put("test_mode_networks", b3);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.f464a.o0().getExtraParameters()));
            Map l0 = this.f464a.l0();
            if (!CollectionUtils.isEmpty(l0)) {
                jSONObject.put("segments", new JSONObject(l0));
            }
            if (this.g > 1) {
                ArrayService p = this.f464a.p();
                if (p.getIsDirectDownloadEnabled() != null) {
                    jSONObject.put("ah_dd_enabled", p.getIsDirectDownloadEnabled());
                }
                jSONObject.put("ah_sdk_version_code", p.getAppHubVersionCode());
                jSONObject.put("ah_random_user_token", StringUtils.emptyIfNull(p.getRandomUserToken()));
                jSONObject.put("ah_sdk_package_name", StringUtils.emptyIfNull(p.getAppHubPackageName()));
            }
        } catch (JSONException e) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to create JSON body", e);
            }
            this.f464a.E().a(this.b, "createJSONBody", e);
        }
        return jSONObject;
    }

    protected Map h() {
        HashMap hashMap = new HashMap();
        if (!((Boolean) this.f464a.a(v4.p5)).booleanValue() && !((Boolean) this.f464a.a(v4.o5)).booleanValue()) {
            hashMap.put("rid", UUID.randomUUID().toString());
        }
        if (!((Boolean) this.f464a.a(v4.a5)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f464a.j0());
        }
        CollectionUtils.putStringIfValid("connectEventKey", this.f464a.r(), hashMap);
        Boolean b2 = p0.b().b(a());
        if (b2 != null) {
            hashMap.put("huc", b2.toString());
        }
        Boolean b3 = p0.c().b(a());
        if (b3 != null) {
            hashMap.put("aru", b3.toString());
        }
        Boolean b4 = p0.a().b(a());
        if (b4 != null) {
            hashMap.put("dns", b4.toString());
        }
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!o0.j() && j.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(com.applovin.impl.sdk.k.o());
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Cannot update security provider", th);
                }
            }
        }
        this.f464a.w0().d(c2.f, b(g()));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.applovin.impl.sdk.network.a a2 = com.applovin.impl.sdk.network.a.a(this.f464a).b(g()).a(f()).b(h()).a(e()).b(((Boolean) this.f464a.a(v4.A5)).booleanValue()).c("POST").a((Object) new JSONObject()).a(((Integer) this.f464a.a(v4.a3)).intValue()).b(((Integer) this.f464a.a(v4.d3)).intValue()).c(((Integer) this.f464a.a(v4.Z2)).intValue()).e(((Boolean) this.f464a.a(v4.m3)).booleanValue()).a(s4.a.a(((Integer) this.f464a.a(v4.f5)).intValue())).f(true).a();
        this.f464a.r0().a(new c(this.f464a), b6.b.TIMEOUT, ((Integer) this.f464a.a(r3)).intValue() + 250);
        a aVar = new a(a2, this.f464a, d(), elapsedRealtime);
        aVar.c(v4.m0);
        aVar.b(v4.n0);
        this.f464a.r0().a(aVar);
    }

    class a extends j6 {
        final /* synthetic */ long m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z, long j) {
            super(aVar, kVar, z);
            this.m = j;
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.m;
            r5.this.a(jSONObject);
            this.f464a.w0().d(c2.g, r5.this.a(str, elapsedRealtime, i, jSONObject, null));
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to fetch basic SDK settings: server returned " + i);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.m;
            r5.this.a(jSONObject != null ? jSONObject : new JSONObject());
            this.f464a.w0().d(c2.h, r5.this.a(str, elapsedRealtime, i, jSONObject, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap a(String str, long j2, int i, JSONObject jSONObject, String str2) {
        Uri build = Uri.parse(str).buildUpon().clearQuery().build();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, C3040d4.i.D, build.getHost());
        if (jSONObject != null) {
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "auto_init_adapters", null);
            if (jSONArray != null) {
                JsonUtils.putInt(jSONObject2, "signal_provider_count", jSONArray.length());
            }
            if (jSONArray2 != null) {
                JsonUtils.putInt(jSONObject2, "auto_init_adapter_count", jSONArray2.length());
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("attempt_number", Integer.toString(this.g));
        hashMap.put("error_message", str2);
        hashMap.put("url", build.toString());
        hashMap.put("details", jSONObject2.toString());
        hashMap.put("duration_ms", Long.toString(j2));
        hashMap.put("code", Integer.toString(i));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        b bVar;
        synchronized (this.h) {
            bVar = this.i;
            this.i = null;
        }
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }
}

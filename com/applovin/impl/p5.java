package com.applovin.impl;

import com.applovin.impl.s4;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class p5 extends g5 {
    protected final u g;
    private final String h;

    public p5(u uVar, String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
        this.g = uVar;
        this.h = kVar.b();
    }

    private Map g() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("AppLovin-Zone-Id", this.g.e());
        if (this.g.f() != null) {
            hashMap.put("AppLovin-Ad-Size", this.g.f().getLabel());
        }
        if (this.g.g() != null) {
            hashMap.put("AppLovin-Ad-Type", this.g.g().getLabel());
        }
        return hashMap;
    }

    protected abstract g5 a(JSONObject jSONObject);

    protected void a(int i, String str) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to fetch " + this.g + " ad: server returned " + i);
        }
        this.f464a.g().a(c2.m, this.g, new AppLovinError(i, str));
    }

    protected void b(JSONObject jSONObject) {
        r0.c(jSONObject, this.f464a);
        r0.b(jSONObject, this.f464a);
        r0.a(jSONObject, this.f464a);
        u.a(jSONObject);
        this.f464a.r0().a(a(jSONObject));
    }

    protected abstract String e();

    protected abstract String f();

    protected Map h() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("zone_id", this.g.e());
        if (this.g.f() != null) {
            hashMap.put(ContentDisposition.Parameters.Size, this.g.f().getLabel());
        }
        if (this.g.g() != null) {
            hashMap.put("require", this.g.g().getLabel());
        }
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        s4.a aVar;
        Map map;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Fetching next ad of zone: " + this.g);
        }
        if (((Boolean) this.f464a.a(v4.Q3)).booleanValue() && k7.j() && com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "User is connected to a VPN");
        }
        k7.a(this.f464a, this.b);
        this.f464a.g().a(c2.k, this.g, (AppLovinError) null);
        try {
            JSONObject andResetCustomPostBody = this.f464a.k().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.f464a.a(v4.f3)).booleanValue()) {
                aVar = s4.a.a(((Integer) this.f464a.a(v4.i5)).intValue());
                JSONObject jSONObject = new JSONObject(this.f464a.B().a(h(), false, true));
                map = new HashMap();
                if (!((Boolean) this.f464a.a(v4.s5)).booleanValue() && !((Boolean) this.f464a.a(v4.o5)).booleanValue()) {
                    map.put("rid", UUID.randomUUID().toString());
                }
                if (!((Boolean) this.f464a.a(v4.a5)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f464a.j0());
                }
                JsonUtils.putAll(jSONObject, andResetCustomPostBody);
                andResetCustomPostBody = jSONObject;
            } else {
                s4.a a2 = s4.a.a(((Integer) this.f464a.a(v4.j5)).intValue());
                Map a3 = k7.a(this.f464a.B().a(h(), false, false));
                if (!((Boolean) this.f464a.a(v4.A6)).booleanValue()) {
                    a3.remove("video_decoders");
                }
                if (andResetCustomPostBody == null) {
                    str = "GET";
                    andResetCustomPostBody = null;
                }
                aVar = a2;
                map = a3;
            }
            if (k7.h(a()) || k7.j(a())) {
                map.putAll(this.f464a.k().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.h)) {
                map.put("sts", this.h);
            }
            a.C0105a f = com.applovin.impl.sdk.network.a.a(this.f464a).b(f()).a(e()).b(map).c(str).a(g()).a((Object) new JSONObject()).a(((Integer) this.f464a.a(v4.U2)).intValue()).c(((Boolean) this.f464a.a(v4.V2)).booleanValue()).d(((Boolean) this.f464a.a(v4.W2)).booleanValue()).c(((Integer) this.f464a.a(v4.T2)).intValue()).a(aVar).f(true);
            if (andResetCustomPostBody != null) {
                f.a(andResetCustomPostBody);
                f.b(((Boolean) this.f464a.a(v4.C5)).booleanValue());
            }
            a aVar2 = new a(f.a(), this.f464a);
            aVar2.c(v4.o0);
            aVar2.b(v4.p0);
            this.f464a.r0().a(aVar2);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to fetch ad for zone id: " + this.g, th);
            }
            a(0, th.getMessage());
        }
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (i == 200) {
                JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.l.a());
                JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.l.b());
                HashMap hashMap = new HashMap(5);
                CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), hashMap);
                CollectionUtils.putStringIfValid("code", String.valueOf(i), hashMap);
                CollectionUtils.putStringIfValid("ad_zone_id", p5.this.g.e(), hashMap);
                CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.l.a()), hashMap);
                CollectionUtils.putStringIfValid("response_size", String.valueOf(this.l.b()), hashMap);
                this.f464a.g().d(c2.l, hashMap);
                p5.this.b(jSONObject);
                return;
            }
            p5.this.a(i, MaxAdapterError.NO_FILL.getErrorMessage());
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            p5.this.a(i, str2);
            this.f464a.E().a("fetchAd", str, i, str2);
        }
    }
}

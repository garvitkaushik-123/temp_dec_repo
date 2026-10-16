package com.applovin.impl;

import com.applovin.impl.s4;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class h5 extends g5 {
    h5(com.applovin.impl.sdk.k kVar) {
        super("TaskApiSubmitData", kVar);
    }

    private void b(JSONObject jSONObject) {
        com.applovin.impl.sdk.l B = this.f464a.B();
        Map o = B.o();
        k7.a(N6.H, "type", o);
        k7.a("api_level", BidTokenRepositoryKt.SDK_VERSION, o);
        JsonUtils.putObject(jSONObject, "device_info", new JSONObject(o));
        Map E = B.E();
        k7.a(BidTokenRepositoryKt.SDK_VERSION, "applovin_sdk_version", E);
        k7.a("ia", "installed_at", E);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(E));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d(this.b, "Submitting user data...");
        }
        Map c = r0.c(this.f464a);
        JSONObject jSONObject = new JSONObject();
        b(jSONObject);
        if (((Boolean) this.f464a.a(v4.u5)).booleanValue() || ((Boolean) this.f464a.a(v4.o5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) c);
            c = null;
        }
        a(c, jSONObject);
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            h5.this.a(jSONObject);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            r0.a(i, this.f464a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.f464a.p0().a(v4.f, JsonUtils.getString(jSONObject2, "device_id", ""));
        this.f464a.p0().a(v4.j, JsonUtils.getString(jSONObject2, "device_token", ""));
        r0.a(jSONObject2, this.f464a);
    }

    private void a(Map map, JSONObject jSONObject) {
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f464a).b(r0.b("2.0/device", this.f464a)).a(r0.a("2.0/device", this.f464a)).b(map).a(jSONObject).c("POST").b(((Boolean) this.f464a.a(v4.B5)).booleanValue()).a((Object) new JSONObject()).a(((Integer) this.f464a.a(v4.X2)).intValue()).a(s4.a.a(((Integer) this.f464a.a(v4.m5)).intValue())).a(), this.f464a);
        aVar.c(v4.q0);
        aVar.b(v4.r0);
        this.f464a.r0().a(aVar);
    }
}

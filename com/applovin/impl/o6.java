package com.applovin.impl;

import com.applovin.impl.q0;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class o6 extends g5 {
    protected o6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    protected abstract void a(JSONObject jSONObject);

    void a(JSONObject jSONObject, q0.e eVar) {
        Map c = r0.c(this.f464a);
        if (((Boolean) this.f464a.a(v4.v5)).booleanValue() || ((Boolean) this.f464a.a(v4.o5)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) c);
            c = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f464a).b(r0.b(f(), this.f464a)).a(r0.a(f(), this.f464a)).b(c).a(jSONObject).c("POST").b(((Boolean) this.f464a.a(v4.E5)).booleanValue()).a((Object) new JSONObject()).a(g()).a(s4.a.a(((Integer) this.f464a.a(v4.n5)).intValue())).a(), this.f464a, eVar);
        aVar.c(v4.q0);
        aVar.b(v4.r0);
        this.f464a.r0().a(aVar);
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        String e = this.f464a.x0().e();
        if (((Boolean) this.f464a.a(v4.y3)).booleanValue() && StringUtils.isValidString(e)) {
            JsonUtils.putString(jSONObject, "cuid", e);
        }
        if (((Boolean) this.f464a.a(v4.A3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f464a.v());
        }
        if (((Boolean) this.f464a.a(v4.C3)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f464a.i0());
        }
        a(jSONObject);
        return jSONObject;
    }

    protected abstract String f();

    protected abstract int g();

    class a extends j6 {
        final /* synthetic */ q0.e m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, q0.e eVar) {
            super(aVar, kVar);
            this.m = eVar;
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            this.m.a(str, jSONObject, i);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            this.m.a(str, i, str2, jSONObject);
        }
    }

    protected void a(int i) {
        r0.a(i, this.f464a);
    }
}

package com.applovin.impl;

import com.applovin.impl.q0;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class m6 extends o6 {
    protected m6(String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
    }

    private JSONObject a(l4 l4Var) {
        JSONObject e = e();
        JsonUtils.putString(e, "result", l4Var.b());
        Map a2 = l4Var.a();
        if (a2 != null) {
            JsonUtils.putJSONObject(e, "params", new JSONObject(a2));
        }
        return e;
    }

    protected abstract void b(JSONObject jSONObject);

    @Override // com.applovin.impl.o6
    protected int g() {
        return ((Integer) this.f464a.a(v4.e1)).intValue();
    }

    protected abstract l4 h();

    protected abstract void i();

    @Override // java.lang.Runnable
    public void run() {
        l4 h = h();
        if (h != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Reporting pending reward: " + h + "...");
            }
            a(a(h), new a());
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Pending reward not found");
            }
            i();
        }
    }

    class a implements q0.e {
        a() {
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            m6.this.b(jSONObject);
        }

        @Override // com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            m6.this.a(i);
        }
    }
}

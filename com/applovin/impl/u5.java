package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.q0;
import com.applovin.impl.s4;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.v;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class u5 extends g5 {
    private final q0.e g;

    public u5(q0.e eVar, com.applovin.impl.sdk.k kVar) {
        super("TaskFetchMediationDebuggerInfo", kVar, true);
        this.g = eVar;
    }

    protected Map e() {
        HashMap hashMap = new HashMap();
        hashMap.put(BidTokenRepositoryKt.SDK_VERSION, AppLovinSdk.VERSION);
        if (!((Boolean) this.f464a.a(v4.a5)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f464a.j0());
        }
        Map E = this.f464a.B().E();
        hashMap.put("package_name", String.valueOf(E.get("package_name")));
        hashMap.put(BidTokenRepositoryKt.APP_VERSION, String.valueOf(E.get(BidTokenRepositoryKt.APP_VERSION)));
        Map L = this.f464a.B().L();
        hashMap.put(N6.H, String.valueOf(L.get(N6.H)));
        hashMap.put(N6.F, String.valueOf(L.get(N6.F)));
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map e = e();
        JSONObject a2 = a(a());
        if (((Boolean) this.f464a.a(v4.r5)).booleanValue() || ((Boolean) this.f464a.a(v4.o5)).booleanValue()) {
            JsonUtils.putAll(a2, (Map<String, ?>) e);
            e = null;
        }
        a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f464a).c("POST").b(i3.i(this.f464a)).a(i3.h(this.f464a)).b(e).a(a2).a((Object) new JSONObject()).c(((Long) this.f464a.a(o3.k7)).intValue()).a(s4.a.a(((Integer) this.f464a.a(v4.h5)).intValue())).a(), this.f464a, d());
        aVar.c(o3.g7);
        aVar.b(o3.h7);
        this.f464a.r0().a(aVar);
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z) {
            super(aVar, kVar, z);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            u5.this.g.a(str, jSONObject, i);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            u5.this.g.a(str, i, str2, jSONObject);
        }
    }

    private JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, "installed_mediation_adapters", t3.b(this.f464a));
        JsonUtils.putBoolean(jSONObject, "is_tablet", AppLovinSdkUtils.isTablet(context));
        v.a f = this.f464a.B().f();
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", f.b().b());
        JsonUtils.putStringIfValid(jSONObject, "idfa", f.a());
        Map l0 = this.f464a.l0();
        if (!CollectionUtils.isEmpty(l0)) {
            JsonUtils.putJSONObject(jSONObject, "segments", new JSONObject(l0));
        }
        return jSONObject;
    }
}

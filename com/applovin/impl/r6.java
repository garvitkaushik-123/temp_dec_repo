package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class r6 extends s6 {
    private final z2 g;

    public r6(z2 z2Var, com.applovin.impl.sdk.k kVar) {
        super("TaskValidateMaxReward", kVar);
        this.g = z2Var;
    }

    @Override // com.applovin.impl.o6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.g.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.g.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.g.e());
        JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, this.g.getFormat().getLabel());
        String m0 = this.g.m0();
        if (!StringUtils.isValidString(m0)) {
            m0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", m0);
        String C = this.g.C();
        if (!StringUtils.isValidString(C)) {
            C = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", C);
    }

    @Override // com.applovin.impl.o6
    protected String f() {
        return "2.0/mvr";
    }

    @Override // com.applovin.impl.s6
    protected boolean h() {
        return this.g.q0();
    }

    @Override // com.applovin.impl.s6
    protected void a(l4 l4Var) {
        this.g.a(l4Var);
    }

    @Override // com.applovin.impl.o6
    protected void a(int i) {
        String str;
        super.a(i);
        if (i >= 400 && i < 500) {
            str = "rejected";
        } else {
            str = "network_timeout";
        }
        this.g.a(l4.a(str));
        this.f464a.P().a(c2.h0, this.g, CollectionUtils.hashMap("error_message", str));
    }
}

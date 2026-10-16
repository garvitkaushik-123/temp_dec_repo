package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class q6 extends s6 {
    private final com.applovin.impl.sdk.ad.b g;
    private final AppLovinAdRewardListener h;

    public q6(com.applovin.impl.sdk.ad.b bVar, AppLovinAdRewardListener appLovinAdRewardListener, com.applovin.impl.sdk.k kVar) {
        super("TaskValidateAppLovinReward", kVar);
        this.g = bVar;
        this.h = appLovinAdRewardListener;
    }

    @Override // com.applovin.impl.o6
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.g.getAdZone().e());
        String clCode = this.g.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.o6
    public String f() {
        return "2.0/vr";
    }

    @Override // com.applovin.impl.s6
    protected boolean h() {
        return this.g.W0();
    }

    @Override // com.applovin.impl.s6
    protected void a(l4 l4Var) {
        this.g.a(l4Var);
        String b = l4Var.b();
        Map<String, String> a2 = l4Var.a();
        if (b.equals("accepted")) {
            this.h.userRewardVerified(this.g, a2);
            return;
        }
        if (b.equals("quota_exceeded")) {
            this.h.userOverQuota(this.g, a2);
        } else if (b.equals("rejected")) {
            this.h.userRewardRejected(this.g, a2);
        } else {
            this.h.validationRequestFailed(this.g, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    @Override // com.applovin.impl.o6
    protected void a(int i) {
        String str;
        super.a(i);
        if (i >= 400 && i < 500) {
            this.h.userRewardRejected(this.g, Collections.emptyMap());
            str = "rejected";
        } else {
            this.h.validationRequestFailed(this.g, i);
            str = "network_timeout";
        }
        this.g.a(l4.a(str));
    }
}

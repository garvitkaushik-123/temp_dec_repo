package com.fyber.inneractive.sdk.external;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.o;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class BidTokenProvider {
    public static String getBidderToken() {
        if (!InneractiveAdManager.wasInitialized()) {
            IAlog.b("BidTokenProvider: Cannot generate token. Please init Fyber Marketplace SDK.", new Object[0]);
            return null;
        }
        com.fyber.inneractive.sdk.bidder.b bVar = com.fyber.inneractive.sdk.bidder.b.h;
        bVar.getClass();
        if (IAConfigManager.d()) {
            IAlog.a("%sTCF purpose 1 disabled, returning null", IAlog.a(bVar));
            return null;
        }
        if (bVar.e.get() == null) {
            IAConfigManager.b();
            synchronized (bVar.g) {
                bVar.b();
            }
        } else {
            bVar.d();
        }
        String str = (String) bVar.e.get();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        String str2 = iAConfigManager.l;
        o oVar = iAConfigManager.u.b;
        String str3 = "token_size_limit";
        int a2 = oVar.a("token_size_limit", 4000, 1);
        if (!TextUtils.isEmpty(str2)) {
            str3 = "token_size_limit_" + str2.toLowerCase(Locale.US);
        }
        int a3 = oVar.a(str3, a2, 1);
        if (str == null || str.getBytes().length <= a3) {
            IAlog.c("token = %s", str);
            return str;
        }
        w wVar = new w(t.TOKEN_EXCEEDS_LIMIT);
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str2)) {
            str2 = "unknown";
        }
        try {
            jSONObject.put(com.moloco.sdk.acm.recorder.b.f5352a, str2);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", com.moloco.sdk.acm.recorder.b.f5352a, str2);
        }
        Integer valueOf = Integer.valueOf(str.getBytes().length);
        try {
            jSONObject.put("token_size", valueOf);
        } catch (Exception unused2) {
            IAlog.f("Got exception adding param to json object: %s, %s", "token_size", valueOf);
        }
        Integer valueOf2 = Integer.valueOf(a3);
        try {
            jSONObject.put("token_limit", valueOf2);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "token_limit", valueOf2);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
        IAlog.c("token exceeds the limit, returning null", new Object[0]);
        return null;
    }
}

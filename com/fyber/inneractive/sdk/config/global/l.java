package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.C3033ce;
import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingConfig;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1094a = new HashMap();

    public static l a(JSONObject jSONObject) {
        l lVar = new l();
        JSONArray optJSONArray = jSONObject.optJSONArray(AdaptiveRenderingConfig.NATIVE_FEATURES_KEY);
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            q qVar = new q();
            qVar.b = jSONObject2.getString("id");
            JSONObject optJSONObject = jSONObject2.optJSONObject("params");
            if (optJSONObject != null) {
                qVar.f1096a = new o(optJSONObject);
            } else {
                IAlog.a("RemoteFeature fromJson. feature %s has no params!", qVar.b);
            }
            JSONArray optJSONArray2 = jSONObject2.optJSONArray(C3033ce.d);
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    b bVar = new b();
                    bVar.f1086a = jSONObject3.getString("id");
                    bVar.b = jSONObject3.optInt("perc", 10);
                    JSONArray jSONArray = jSONObject3.getJSONArray("variants");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                        k kVar = new k();
                        kVar.b = jSONObject4.getString("id");
                        kVar.c = jSONObject4.getInt("perc");
                        JSONObject optJSONObject2 = jSONObject4.optJSONObject("params");
                        if (optJSONObject2 != null) {
                            kVar.f1096a = new o(optJSONObject2);
                        }
                        bVar.c.add(kVar);
                    }
                    b.a(bVar, jSONObject3.optJSONObject("include"), true);
                    b.a(bVar, jSONObject3.optJSONObject("exclude"), false);
                    qVar.c.put(bVar.f1086a, bVar);
                }
            }
            lVar.f1094a.put(qVar.b, qVar);
        }
        return lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return this.f1094a.equals(((l) obj).f1094a);
    }

    public final int hashCode() {
        return this.f1094a.hashCode();
    }

    public final String toString() {
        return String.format("remoteConfig - features: %s", this.f1094a.values());
    }
}

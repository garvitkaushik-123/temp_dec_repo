package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.util.a1;
import com.fyber.inneractive.sdk.util.z0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class u0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public Integer f1128a = 50;
    public Integer b = 50;
    public Set c = null;

    @Override // com.fyber.inneractive.sdk.util.z0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        a1.a(jSONObject, "pausePct", this.f1128a);
        a1.a(jSONObject, "playPct", this.b);
        JSONArray jSONArray = new JSONArray();
        Set<Vendor> set = this.c;
        if (set != null) {
            for (Vendor vendor : set) {
                if (vendor != null) {
                    jSONArray.put(vendor);
                }
            }
        }
        a1.a(jSONObject, VastAttributes.VENDOR, jSONArray);
        return jSONObject;
    }
}

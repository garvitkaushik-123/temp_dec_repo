package com.fyber.inneractive.sdk.config.remote;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public Integer f1123a;
    public Integer b;
    public Set c = null;

    public static k a(JSONObject jSONObject) {
        Vendor fromValue;
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("pausePct", Integer.MIN_VALUE);
        Integer valueOf = Integer.valueOf(optInt);
        int optInt2 = jSONObject.optInt("playPct", Integer.MIN_VALUE);
        Integer valueOf2 = Integer.valueOf(optInt2);
        k kVar = new k();
        if (optInt == Integer.MIN_VALUE) {
            valueOf = null;
        }
        kVar.f1123a = valueOf;
        if (optInt2 == Integer.MIN_VALUE) {
            valueOf2 = null;
        }
        kVar.b = valueOf2;
        JSONArray optJSONArray = jSONObject.optJSONArray(VastAttributes.VENDOR);
        if (optJSONArray != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i, null);
                if (!TextUtils.isEmpty(optString) && (fromValue = Vendor.fromValue(optString)) != null) {
                    linkedHashSet.add(fromValue);
                }
            }
            kVar.c = linkedHashSet;
        }
        return kVar;
    }
}

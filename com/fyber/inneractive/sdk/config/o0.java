package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.Track;
import com.fyber.inneractive.sdk.util.a1;
import com.fyber.inneractive.sdk.util.z0;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class o0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public Set f1109a = null;

    @Override // com.fyber.inneractive.sdk.util.z0
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Set set = this.f1109a;
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                jSONArray.put((Track) it.next());
            }
        }
        a1.a(jSONObject, "track", jSONArray);
        return jSONObject;
    }
}

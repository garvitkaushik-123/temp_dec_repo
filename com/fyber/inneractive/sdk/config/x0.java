package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.cache.session.e f1132a;
    public v0 d;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public boolean e = false;

    public final String a(UnitDisplayType unitDisplayType, String str) {
        Map map = (Map) this.b.get(unitDisplayType);
        return (map == null || map.get(str) == null) ? "" : (String) map.get(str);
    }

    public final void a(UnitDisplayType unitDisplayType, String str, String str2) {
        Map map = (Map) this.b.get(unitDisplayType);
        if (map == null) {
            map = new HashMap();
            this.b.put(unitDisplayType, map);
        }
        map.put(str, str2);
        v0 v0Var = this.d;
        if (v0Var == null || !this.e) {
            return;
        }
        ((com.fyber.inneractive.sdk.bidder.b) v0Var).d();
    }

    public final JSONArray a(UnitDisplayType unitDisplayType) {
        int i;
        com.fyber.inneractive.sdk.cache.session.e eVar = this.f1132a;
        if (eVar == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (com.fyber.inneractive.sdk.cache.session.enums.c cVar : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
                if (cVar != com.fyber.inneractive.sdk.cache.session.enums.c.NONE && (unitDisplayType == null || cVar.a() == unitDisplayType)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", cVar.a().value());
                    jSONObject.put("subType", cVar.name().toLowerCase(Locale.US).contains("video") ? "video" : "display");
                    com.fyber.inneractive.sdk.cache.session.k kVar = (com.fyber.inneractive.sdk.cache.session.k) eVar.b.get(cVar);
                    try {
                        i = Integer.parseInt(IAConfigManager.O.u.b.a("number_of_sessions", Integer.toString(5)));
                    } catch (Throwable unused) {
                        i = 5;
                    }
                    int i2 = i >= 0 ? i : 5;
                    if (i2 > 0 && kVar != null && kVar.size() >= i2) {
                        boolean b = cVar.b();
                        JSONArray jSONArray2 = new JSONArray();
                        ArrayList arrayList = new ArrayList(kVar);
                        Collections.sort(arrayList, new com.fyber.inneractive.sdk.cache.session.j());
                        Iterator it = arrayList.iterator();
                        int i3 = 0;
                        while (it.hasNext()) {
                            jSONArray2.put(((com.fyber.inneractive.sdk.cache.session.g) it.next()).a(false, b));
                            i3++;
                            if (i3 >= i2) {
                                break;
                            }
                        }
                        jSONObject.put("sessionData", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }
}

package com.fyber.inneractive.sdk.cache.session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f1047a;
    public final /* synthetic */ c b;

    public b(c cVar, JSONObject jSONObject) {
        this.b = cVar;
        this.f1047a = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar;
        e eVar = this.b.f1048a;
        JSONObject jSONObject = this.f1047a;
        eVar.getClass();
        for (com.fyber.inneractive.sdk.cache.session.enums.c cVar : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
            if (cVar != com.fyber.inneractive.sdk.cache.session.enums.c.NONE) {
                String name = cVar.name();
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONArray = jSONObject.getJSONArray(name);
                } catch (JSONException unused) {
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    g a2 = g.a(jSONArray.optJSONObject(i));
                    if (a2 != null && a2.f1053a != 0) {
                        eVar.a(cVar, a2);
                    }
                }
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("currentSession");
        if (optJSONObject != null) {
            h hVar = new h();
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2 = optJSONObject.getJSONArray("content");
            } catch (JSONException unused2) {
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2 = jSONArray2.getJSONObject(i2);
                } catch (JSONException unused3) {
                }
                com.fyber.inneractive.sdk.cache.session.enums.c a3 = com.fyber.inneractive.sdk.cache.session.enums.c.a(jSONObject2.optString("type"), jSONObject2.optString("subType"));
                g a4 = g.a(jSONObject2.optJSONObject("session_data"));
                if (a4 != null) {
                    hVar.put(a3, a4);
                }
            }
            for (com.fyber.inneractive.sdk.cache.session.enums.c cVar2 : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
                if (cVar2 != com.fyber.inneractive.sdk.cache.session.enums.c.NONE && (gVar = (g) hVar.get(cVar2)) != null && gVar.f1053a != 0) {
                    eVar.a(cVar2, gVar);
                }
            }
        }
        this.b.f1048a.getClass();
    }
}

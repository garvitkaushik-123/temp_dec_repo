package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f1086a;
    public int b;
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();

    public static void a(b bVar, JSONObject jSONObject, boolean z) {
        String next;
        d cVar;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                next = keys.next();
                next.getClass();
                next.hashCode();
                switch (next) {
                    case "demand":
                        cVar = new c(jSONObject.getJSONArray(next), z);
                        break;
                    case "pub_id":
                        cVar = new i(jSONObject.getJSONArray(next), z);
                        break;
                    case "placement_type":
                        cVar = new h(jSONObject.getJSONArray(next), z);
                        break;
                    case "os":
                        cVar = new f(z, jSONObject.getString(next));
                        break;
                    case "sdk":
                        cVar = new j(z, jSONObject.getString(next));
                        break;
                    default:
                        cVar = null;
                        break;
                }
                if (cVar != null) {
                    bVar.d.add(cVar);
                } else {
                    IAlog.a("b: Unsupported filter type: " + next, new Object[0]);
                }
            }
        }
    }

    public final String toString() {
        return String.format("experiment: id=%s, variants=%s, filters=%s", this.f1086a, this.c, this.d);
    }
}

package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class c implements com.fyber.inneractive.sdk.response.i {

    /* renamed from: a, reason: collision with root package name */
    public final i f1282a;
    public k b;
    public final int c;
    public final int d;
    public final String e;
    public String f;
    public String g;
    public final int h;
    public final HashMap i = new HashMap();

    public c(i iVar, int i, int i2, String str, int i3) {
        this.f1282a = iVar;
        this.c = i;
        this.d = i2;
        this.e = str;
        this.h = i3;
    }

    public final void a(x xVar, String str) {
        List list = (List) this.i.get(xVar);
        if (list == null) {
            list = new ArrayList();
            this.i.put(xVar, list);
        }
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    public final String toString() {
        StringBuilder append = new StringBuilder("Companion:  w:").append(this.c).append(" h:").append(this.d).append(" type:").append(this.f1282a.toString()).append(" creativeType: ");
        k kVar = this.b;
        return append.append(kVar != null ? kVar.mimeType : "none").append(" ctr:").append(this.g).append(" events:").append(this.i).toString();
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public final List a(x xVar) {
        if (xVar == null || this.i.isEmpty()) {
            return null;
        }
        return (List) this.i.get(xVar);
    }

    public final JSONObject a() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("w", this.c);
            jSONObject.put("h", this.d);
            jSONObject.put("type", this.f1282a.toString());
            k kVar = this.b;
            if (kVar != null) {
                str = kVar.mimeType;
            } else {
                str = "none";
            }
            jSONObject.put("creativeType", str);
            jSONObject.put("content", this.f);
            return jSONObject;
        } catch (JSONException e) {
            IAlog.a("Vast Parser: Failed creating Companion json object: %s", e.getMessage());
            return jSONObject;
        }
    }
}

package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class Ec extends AbstractC3052e {
    private final String i = Sc.f3051a;

    Ec(int i) {
        this.g = i;
    }

    @Override // com.ironsource.AbstractC3052e
    public String a() {
        return Sc.f3051a;
    }

    @Override // com.ironsource.AbstractC3052e
    public String c() {
        return "outcome";
    }

    @Override // com.ironsource.AbstractC3052e
    public String a(ArrayList<C3413z5> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f = new JSONObject();
        } else {
            this.f = jSONObject;
        }
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<C3413z5> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject a2 = a(it.next());
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
        }
        return a(jSONArray);
    }
}

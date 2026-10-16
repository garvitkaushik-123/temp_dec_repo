package com.fyber.inneractive.sdk.config.global;

import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f1087a = new HashSet();
    public final boolean b;

    public c(JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                long optLong = jSONArray.optLong(i);
                if (optLong != 0) {
                    this.f1087a.add(Long.valueOf(optLong));
                }
            }
        }
        this.b = z;
    }

    @Override // com.fyber.inneractive.sdk.config.global.d
    public final boolean a(e eVar) {
        if (this.f1087a.isEmpty() || eVar.f1088a == null) {
            return false;
        }
        Iterator it = this.f1087a.iterator();
        while (it.hasNext()) {
            if (((Long) it.next()).equals(eVar.f1088a)) {
                return !this.b;
            }
        }
        return this.b;
    }

    public final String toString() {
        return String.format("%s - %s include: %b", "demand", this.f1087a, Boolean.valueOf(this.b));
    }
}

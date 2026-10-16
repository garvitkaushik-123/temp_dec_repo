package com.inmobi.media;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Bf {

    /* renamed from: a, reason: collision with root package name */
    public final int f2247a;
    public final int b;
    public final int c;
    public final int d;

    public Bf(int i, int i2, int i3, int i4) {
        this.f2247a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("left", B2.a(this.f2247a));
            jSONObject.put("top", B2.a(this.b));
            jSONObject.put("right", B2.a(this.c));
            jSONObject.put("bottom", B2.a(this.d));
            return jSONObject;
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return new JSONObject();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bf)) {
            return false;
        }
        Bf bf = (Bf) obj;
        return this.f2247a == bf.f2247a && this.b == bf.b && this.c == bf.c && this.d == bf.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + ((Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f2247a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Insets(left=" + this.f2247a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ')';
    }
}

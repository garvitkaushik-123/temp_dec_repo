package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Z5 {

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f2504a;
    public final JSONArray b;
    public final Y6 c;

    public Z5(JSONObject vitals, JSONArray logs, Y6 data) {
        Intrinsics.checkNotNullParameter(vitals, "vitals");
        Intrinsics.checkNotNullParameter(logs, "logs");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f2504a = vitals;
        this.b = logs;
        this.c = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Z5)) {
            return false;
        }
        Z5 z5 = (Z5) obj;
        return Intrinsics.areEqual(this.f2504a, z5.f2504a) && Intrinsics.areEqual(this.b, z5.b) && Intrinsics.areEqual(this.c, z5.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f2504a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "IncompleteLogData(vitals=" + this.f2504a + ", logs=" + this.b + ", data=" + this.c + ')';
    }
}

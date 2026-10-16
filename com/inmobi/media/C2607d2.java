package com.inmobi.media;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.d2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2607d2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2542a;
    public final String b;
    public final Map c;

    public C2607d2(int i, int i2, String str) {
        str = (i2 & 2) != 0 ? null : str;
        this.f2542a = i;
        this.b = str;
        this.c = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2607d2)) {
            return false;
        }
        C2607d2 c2607d2 = (C2607d2) obj;
        return this.f2542a == c2607d2.f2542a && Intrinsics.areEqual(this.b, c2607d2.b) && Intrinsics.areEqual(this.c, c2607d2.c);
    }

    public final int hashCode() {
        int hashCode = Integer.hashCode(this.f2542a) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map map = this.c;
        return hashCode2 + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        return "BusEvent(eventId=" + this.f2542a + ", eventMessage=" + this.b + ", eventData=" + this.c + ')';
    }

    public C2607d2(int i, String str, Map map) {
        this.f2542a = i;
        this.b = str;
        this.c = map;
    }
}

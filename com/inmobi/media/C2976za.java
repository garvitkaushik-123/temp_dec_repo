package com.inmobi.media;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.za, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2976za {

    /* renamed from: a, reason: collision with root package name */
    public final String f2774a;
    public final String b;
    public final Map c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final int g;
    public final String h;
    public final long i;
    public final Long j;
    public final C2685hc k;

    public C2976za(String url, String id, Map headers, boolean z, String priority, boolean z2, int i, String ownerId, long j, Long l, C2685hc c2685hc) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(ownerId, "ownerId");
        this.f2774a = url;
        this.b = id;
        this.c = headers;
        this.d = z;
        this.e = priority;
        this.f = z2;
        this.g = i;
        this.h = ownerId;
        this.i = j;
        this.j = l;
        this.k = c2685hc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2976za)) {
            return false;
        }
        C2976za c2976za = (C2976za) obj;
        return Intrinsics.areEqual(this.f2774a, c2976za.f2774a) && Intrinsics.areEqual(this.b, c2976za.b) && Intrinsics.areEqual(this.c, c2976za.c) && this.d == c2976za.d && Intrinsics.areEqual(this.e, c2976za.e) && this.f == c2976za.f && this.g == c2976za.g && Intrinsics.areEqual(this.h, c2976za.h) && this.i == c2976za.i && Intrinsics.areEqual(this.j, c2976za.j) && Intrinsics.areEqual(this.k, c2976za.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.f2774a.hashCode() * 31)) * 31)) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (this.e.hashCode() + ((hashCode + i) * 31)) * 31;
        boolean z2 = this.f;
        int hashCode3 = (Long.hashCode(this.i) + ((this.h.hashCode() + ((Integer.hashCode(this.g) + ((hashCode2 + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31)) * 31)) * 31;
        Long l = this.j;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        C2685hc c2685hc = this.k;
        return hashCode4 + (c2685hc != null ? c2685hc.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Ping(url=");
        sb.append(this.f2774a).append(", id=").append(this.b).append(", headers=").append(this.c).append(", allowRedirects=").append(this.d).append(", priority=").append(this.e).append(", ackRequired=").append(this.f).append(", retryCount=").append(this.g).append(", ownerId=").append(this.h).append(", createdAt=").append(this.i).append(", retryAfterTimestamp=").append(this.j).append(", telemetryData=").append(this.k).append(')');
        return sb.toString();
    }
}

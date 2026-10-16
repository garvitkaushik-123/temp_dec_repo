package com.inmobi.media;

/* renamed from: com.inmobi.media.he, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2687he {

    /* renamed from: a, reason: collision with root package name */
    public final long f2590a;
    public final long b;
    public final long c;

    public C2687he(long j, long j2, long j3) {
        this.f2590a = j;
        this.b = j2;
        this.c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2687he)) {
            return false;
        }
        C2687he c2687he = (C2687he) obj;
        return this.f2590a == c2687he.f2590a && this.b == c2687he.b && this.c == c2687he.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.c) + ((Long.hashCode(this.b) + (Long.hashCode(this.f2590a) * 31)) * 31);
    }

    public final String toString() {
        return "TimeoutConfig(connectTimeoutInSec=" + this.f2590a + ", readTimeoutInSec=" + this.b + ", callTimeoutInSec=" + this.c + ')';
    }
}

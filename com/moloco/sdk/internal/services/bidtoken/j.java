package com.moloco.sdk.internal.services.bidtoken;

/* loaded from: classes6.dex */
public final class j {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f5636a;
    public final int b;
    public final long c;

    public j(long j, int i, long j2) {
        this.f5636a = j;
        this.b = i;
        this.c = j2;
    }

    public final long a() {
        return this.f5636a;
    }

    public final int b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f5636a == jVar.f5636a && this.b == jVar.b && this.c == jVar.c;
    }

    public final long f() {
        return this.f5636a;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f5636a) * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "BidTokenHttpRequestInfo(requestTimeoutMillis=" + this.f5636a + ", fetchRetryMax=" + this.b + ", fetchRetryDelayMillis=" + this.c + ')';
    }

    public final j a(long j, int i, long j2) {
        return new j(j, i, j2);
    }

    public static /* synthetic */ j a(j jVar, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = jVar.f5636a;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            i = jVar.b;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j2 = jVar.c;
        }
        return jVar.a(j3, i3, j2);
    }
}

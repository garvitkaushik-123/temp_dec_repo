package com.inmobi.media;

/* renamed from: com.inmobi.media.tc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2879tc {

    /* renamed from: a, reason: collision with root package name */
    public final int f2713a;
    public final int b;

    public C2879tc(int i, int i2) {
        this.f2713a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2879tc)) {
            return false;
        }
        C2879tc c2879tc = (C2879tc) obj;
        return this.f2713a == c2879tc.f2713a && this.b == c2879tc.b && Double.compare(1.0d, 1.0d) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(1.0d) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f2713a) * 31)) * 31);
    }

    public final String toString() {
        return "RetryPolicy(maxNoOfRetries=" + this.f2713a + ", delayInMillis=" + this.b + ", delayFactor=1.0)";
    }
}

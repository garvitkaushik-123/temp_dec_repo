package com.ironsource;

/* loaded from: classes6.dex */
public final class H0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f2888a;

    public H0(long j) {
        this.f2888a = j;
    }

    public final long a() {
        return this.f2888a;
    }

    public final long b() {
        return this.f2888a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H0) && this.f2888a == ((H0) obj).f2888a;
    }

    public int hashCode() {
        return Long.hashCode(this.f2888a);
    }

    public String toString() {
        return "AdUnitInteractionData(impressionTimeout=" + this.f2888a + ")";
    }

    public final H0 a(long j) {
        return new H0(j);
    }

    public static /* synthetic */ H0 a(H0 h0, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = h0.f2888a;
        }
        return h0.a(j);
    }
}

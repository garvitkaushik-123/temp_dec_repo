package com.moloco.sdk.internal.services.bidtoken;

/* loaded from: classes6.dex */
public final class f {
    public static final int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5632a;

    public f(boolean z) {
        this.f5632a = z;
    }

    public final boolean a() {
        return this.f5632a;
    }

    public final boolean b() {
        return this.f5632a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f5632a == ((f) obj).f5632a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.f5632a);
    }

    public String toString() {
        return "BidTokenConfig(dbtEnabled=" + this.f5632a + ')';
    }

    public final f a(boolean z) {
        return new f(z);
    }

    public static /* synthetic */ f a(f fVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fVar.f5632a;
        }
        return fVar.a(z);
    }
}

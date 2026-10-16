package com.ironsource;

/* renamed from: com.ironsource.sa, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3299sa {

    /* renamed from: a, reason: collision with root package name */
    private final long f3693a;
    private final long b;
    private final boolean c;

    public C3299sa(long j, long j2, boolean z) {
        this.f3693a = j;
        this.b = j2;
        this.c = z;
    }

    public final long a() {
        return this.f3693a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final long d() {
        return this.f3693a;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3299sa)) {
            return false;
        }
        C3299sa c3299sa = (C3299sa) obj;
        return this.f3693a == c3299sa.f3693a && this.b == c3299sa.b && this.c == c3299sa.c;
    }

    public final boolean f() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((Long.hashCode(this.f3693a) * 31) + Long.hashCode(this.b)) * 31;
        boolean z = this.c;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "LevelPlayBannerReloadAdUnitStrategyConfig(refreshInterval=" + this.f3693a + ", visibilityCheckerInterval=" + this.b + ", isAutoRefreshEnabled=" + this.c + ")";
    }

    public final C3299sa a(long j, long j2, boolean z) {
        return new C3299sa(j, j2, z);
    }

    public static /* synthetic */ C3299sa a(C3299sa c3299sa, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c3299sa.f3693a;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = c3299sa.b;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            z = c3299sa.c;
        }
        return c3299sa.a(j3, j4, z);
    }
}

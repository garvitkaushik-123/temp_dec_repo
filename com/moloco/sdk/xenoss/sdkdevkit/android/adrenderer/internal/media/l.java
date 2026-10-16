package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

/* loaded from: classes6.dex */
public final class l {
    public static final int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5871a;
    public final boolean b;
    public final double c;
    public final int d;

    public l(int i, boolean z, double d, int i2) {
        this.f5871a = i;
        this.b = z;
        this.c = d;
        this.d = i2;
    }

    public final int a() {
        return this.f5871a;
    }

    public final boolean b() {
        return this.b;
    }

    public final double c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.f5871a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f5871a == lVar.f5871a && this.b == lVar.b && Double.compare(this.c, lVar.c) == 0 && this.d == lVar.d;
    }

    public final int f() {
        return this.d;
    }

    public final double g() {
        return this.c;
    }

    public final boolean h() {
        return this.b;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f5871a) * 31) + Boolean.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "MediaConfig(chunkSize=" + this.f5871a + ", isStreamingEnabled=" + this.b + ", minStreamingPlayableDurationOnTimeoutSecs=" + this.c + ", mediaCacheDiskCleanUpLimit=" + this.d + ')';
    }

    public final l a(int i, boolean z, double d, int i2) {
        return new l(i, z, d, i2);
    }

    public static /* synthetic */ l a(l lVar, int i, boolean z, double d, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = lVar.f5871a;
        }
        if ((i3 & 2) != 0) {
            z = lVar.b;
        }
        if ((i3 & 4) != 0) {
            d = lVar.c;
        }
        if ((i3 & 8) != 0) {
            i2 = lVar.d;
        }
        int i4 = i2;
        return lVar.a(i, z, d, i4);
    }
}

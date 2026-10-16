package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class N3 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2959a;
    private final P3 b;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2960a;

        static {
            int[] iArr = new int[P3.values().length];
            try {
                iArr[P3.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[P3.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[P3.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2960a = iArr;
        }
    }

    public N3(boolean z, P3 p3) {
        this.f2959a = z;
        this.b = p3;
    }

    public final boolean a() {
        return this.f2959a;
    }

    public final P3 b() {
        return this.b;
    }

    public final P3 c() {
        return this.b;
    }

    public final boolean d() {
        return this.f2959a;
    }

    public final String e() {
        P3 p3 = this.b;
        int i = p3 == null ? -1 : a.f2960a[p3.ordinal()];
        if (i == 1) {
            return "Placement delivery is false";
        }
        if (i == 2) {
            return "In pacing mode";
        }
        if (i != 3) {
            return null;
        }
        return "Max ad cap reached";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N3)) {
            return false;
        }
        N3 n3 = (N3) obj;
        return this.f2959a == n3.f2959a && this.b == n3.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f2959a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        P3 p3 = this.b;
        return i + (p3 == null ? 0 : p3.hashCode());
    }

    public String toString() {
        return "CappingStatus(isCapped=" + this.f2959a + " reason=" + this.b + ")";
    }

    public /* synthetic */ N3(boolean z, P3 p3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : p3);
    }

    public final N3 a(boolean z, P3 p3) {
        return new N3(z, p3);
    }

    public static /* synthetic */ N3 a(N3 n3, boolean z, P3 p3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = n3.f2959a;
        }
        if ((i & 2) != 0) {
            p3 = n3.b;
        }
        return n3.a(z, p3);
    }
}

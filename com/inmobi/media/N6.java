package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class N6 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2371a;
    public final String b;
    public final boolean c;
    public final boolean d;

    public N6(boolean z, String landingScheme, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(landingScheme, "landingScheme");
        this.f2371a = z;
        this.b = landingScheme;
        this.c = z2;
        this.d = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N6)) {
            return false;
        }
        N6 n6 = (N6) obj;
        return this.f2371a == n6.f2371a && Intrinsics.areEqual(this.b, n6.b) && this.c == n6.c && this.d == n6.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.f2371a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = (this.b.hashCode() + (r0 * 31)) * 31;
        ?? r02 = this.c;
        int i = r02;
        if (r02 != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.d;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final String toString() {
        return "LandingPageState(isInAppBrowser=" + this.f2371a + ", landingScheme=" + this.b + ", isCCTEnabled=" + this.c + ", isPartialTabsEnabled=" + this.d + ')';
    }
}

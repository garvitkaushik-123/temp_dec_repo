package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3187a;
    private final boolean b;
    private final boolean c;

    public ag(boolean z, boolean z2, boolean z3) {
        this.f3187a = z;
        this.b = z2;
        this.c = z3;
    }

    public final boolean a() {
        return this.f3187a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.f3187a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ag)) {
            return false;
        }
        ag agVar = (ag) obj;
        return this.f3187a == agVar.f3187a && this.b == agVar.b && this.c == agVar.c;
    }

    public final boolean f() {
        return this.b;
    }

    public final JSONObject g() {
        JSONObject put = new JSONObject().put(C3061e8.k, this.f3187a).put(C3061e8.l, this.b).put(C3061e8.m, this.c);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n        .pu…ts.IS_SHOWN_KEY, isShown)");
        return put;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.f3187a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.b;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.c;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "ViewVisibilityParams(isVisible=" + this.f3187a + ", isWindowVisible=" + this.b + ", isShown=" + this.c + ")";
    }

    public final ag a(boolean z, boolean z2, boolean z3) {
        return new ag(z, z2, z3);
    }

    public static /* synthetic */ ag a(ag agVar, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = agVar.f3187a;
        }
        if ((i & 2) != 0) {
            z2 = agVar.b;
        }
        if ((i & 4) != 0) {
            z3 = agVar.c;
        }
        return agVar.a(z, z2, z3);
    }
}

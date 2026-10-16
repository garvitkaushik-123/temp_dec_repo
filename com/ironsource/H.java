package com.ironsource;

import com.ironsource.C3239p0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    private C3239p0.a f2887a;

    public H(C3239p0.a performance) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        this.f2887a = performance;
    }

    public final C3239p0.a a() {
        return this.f2887a;
    }

    public final C3239p0.a b() {
        return this.f2887a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof H) && this.f2887a == ((H) obj).f2887a;
    }

    public int hashCode() {
        return this.f2887a.hashCode();
    }

    public String toString() {
        return "AdInstancePerformance(performance=" + this.f2887a + ")";
    }

    public final H a(C3239p0.a performance) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        return new H(performance);
    }

    public final void b(C3239p0.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.f2887a = aVar;
    }

    public static /* synthetic */ H a(H h, C3239p0.a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = h.f2887a;
        }
        return h.a(aVar);
    }
}

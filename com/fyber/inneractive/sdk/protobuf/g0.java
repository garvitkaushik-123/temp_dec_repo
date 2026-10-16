package com.fyber.inneractive.sdk.protobuf;

/* loaded from: classes4.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1673a;
    public final int b;

    public g0(int i, Object obj) {
        this.f1673a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f1673a == g0Var.f1673a && this.b == g0Var.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f1673a) * 65535) + this.b;
    }
}

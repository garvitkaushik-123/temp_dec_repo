package com.fyber.inneractive.sdk.util;

/* loaded from: classes4.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public int f1758a;
    public int b;

    public f1(int i, int i2) {
        this.f1758a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f1.class == obj.getClass()) {
            f1 f1Var = (f1) obj;
            if (this.f1758a == f1Var.f1758a && this.b == f1Var.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f1758a * 31) + this.b;
    }
}

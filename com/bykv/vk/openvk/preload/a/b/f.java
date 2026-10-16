package com.bykv.vk.openvk.preload.a.b;

import java.math.BigDecimal;

/* compiled from: LazilyParsedNumber.java */
/* loaded from: classes3.dex */
public final class f extends Number {

    /* renamed from: a, reason: collision with root package name */
    private final String f898a;

    public f(String str) {
        this.f898a = str;
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.f898a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f898a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f898a).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.f898a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f898a).longValue();
        }
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f898a);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f898a);
    }

    public final String toString() {
        return this.f898a;
    }

    public final int hashCode() {
        return this.f898a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f898a;
        String str2 = ((f) obj).f898a;
        return str == str2 || str.equals(str2);
    }
}

package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class R2 {

    /* renamed from: a, reason: collision with root package name */
    public final byte f2412a;
    public final String b;

    public R2(byte b, String str) {
        this.f2412a = b;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof R2)) {
            return false;
        }
        R2 r2 = (R2) obj;
        return this.f2412a == r2.f2412a && Intrinsics.areEqual(this.b, r2.b);
    }

    public final int hashCode() {
        int hashCode = Byte.hashCode(this.f2412a) * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ConfigError(errorCode=" + ((int) this.f2412a) + ", errorMessage=" + this.b + ')';
    }
}

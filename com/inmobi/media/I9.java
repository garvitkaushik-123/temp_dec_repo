package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class I9 {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC2790o4 f2315a;
    public final String b;

    public I9(EnumC2790o4 errorCode, String str) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.f2315a = errorCode;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I9)) {
            return false;
        }
        I9 i9 = (I9) obj;
        return this.f2315a == i9.f2315a && Intrinsics.areEqual(this.b, i9.b);
    }

    public final int hashCode() {
        int hashCode = this.f2315a.hashCode() * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "NetworkError(errorCode=" + this.f2315a + ", errorMessage=" + this.b + ')';
    }
}

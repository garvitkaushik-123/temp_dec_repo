package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class W {

    /* renamed from: a, reason: collision with root package name */
    public final U0 f2465a;
    public final String b;
    public final Boolean c;
    public final String d;
    public final byte e;

    public W(U0 adUnitTelemetry, String str, Boolean bool, String str2, byte b) {
        Intrinsics.checkNotNullParameter(adUnitTelemetry, "adUnitTelemetry");
        this.f2465a = adUnitTelemetry;
        this.b = str;
        this.c = bool;
        this.d = str2;
        this.e = b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof W)) {
            return false;
        }
        W w = (W) obj;
        return Intrinsics.areEqual(this.f2465a, w.f2465a) && Intrinsics.areEqual(this.b, w.b) && Intrinsics.areEqual(this.c, w.c) && Intrinsics.areEqual(this.d, w.d) && this.e == w.e;
    }

    public final int hashCode() {
        int hashCode = this.f2465a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.c;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.d;
        return Byte.hashCode(this.e) + ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "AdNotReadyMetadata(adUnitTelemetry=" + this.f2465a + ", creativeType=" + this.b + ", isRewarded=" + this.c + ", markupType=" + this.d + ", adState=" + ((int) this.e) + ')';
    }
}

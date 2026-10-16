package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Da {

    /* renamed from: a, reason: collision with root package name */
    public final C2976za f2264a;
    public final int b;
    public final String c;
    public final long d;

    public Da(C2976za ping, int i, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(ping, "ping");
        this.f2264a = ping;
        this.b = i;
        this.c = str;
        this.d = currentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Da)) {
            return false;
        }
        Da da = (Da) obj;
        return Intrinsics.areEqual(this.f2264a, da.f2264a) && this.b == da.b && Intrinsics.areEqual(this.c, da.c) && this.d == da.d;
    }

    public final int hashCode() {
        int hashCode = (Integer.hashCode(this.b) + (this.f2264a.hashCode() * 31)) * 31;
        String str = this.c;
        return Long.hashCode(this.d) + ((hashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "PingResult(ping=" + this.f2264a + ", statusCode=" + this.b + ", error=" + this.c + ", timestamp=" + this.d + ')';
    }
}

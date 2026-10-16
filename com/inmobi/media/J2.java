package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class J2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2321a;
    public final String b;

    public J2(String url, String accountId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        this.f2321a = url;
        this.b = accountId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof J2)) {
            return false;
        }
        J2 j2 = (J2) obj;
        return Intrinsics.areEqual(this.f2321a, j2.f2321a) && Intrinsics.areEqual(this.b, j2.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f2321a.hashCode() * 31);
    }

    public final String toString() {
        return "ConfigIdentifier(url=" + this.f2321a + ", accountId=" + this.b + ')';
    }
}

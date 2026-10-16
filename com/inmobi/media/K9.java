package com.inmobi.media;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class K9 {

    /* renamed from: a, reason: collision with root package name */
    public final long f2340a;
    public final Map b;
    public final int c;
    public final String d;

    public K9(long j, Map headers, int i, String str) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f2340a = j;
        this.b = headers;
        this.c = i;
        this.d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K9)) {
            return false;
        }
        K9 k9 = (K9) obj;
        return this.f2340a == k9.f2340a && Intrinsics.areEqual(this.b, k9.b) && this.c == k9.c && Intrinsics.areEqual(this.d, k9.d);
    }

    public final int hashCode() {
        int hashCode = (Integer.hashCode(this.c) + ((this.b.hashCode() + (Long.hashCode(this.f2340a) * 31)) * 31)) * 31;
        String str = this.d;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "NetworkMetaData(timeTaken=" + this.f2340a + ", headers=" + this.b + ", contentLength=" + this.c + ", contentType=" + this.d + ')';
    }
}

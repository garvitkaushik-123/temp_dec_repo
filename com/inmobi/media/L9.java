package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class L9 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2352a;
    public final Map b;
    public final Map c;
    public final boolean d;

    public L9(String url, HashMap hashMap, boolean z) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f2352a = url;
        this.b = hashMap;
        this.c = null;
        this.d = z;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.f2352a = url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof L9)) {
            return false;
        }
        L9 l9 = (L9) obj;
        return Intrinsics.areEqual(this.f2352a, l9.f2352a) && Intrinsics.areEqual(this.b, l9.b) && Intrinsics.areEqual(this.c, l9.c) && Intrinsics.areEqual((Object) null, (Object) null) && this.d == l9.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.f2352a.hashCode() * 31;
        Map map = this.b;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map map2 = this.c;
        int hashCode3 = (hashCode2 + (map2 != null ? map2.hashCode() : 0)) * 961;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode3 + i;
    }

    public final String toString() {
        return "GetRequest(url=" + this.f2352a + ", headers=" + this.b + ", queryParams=" + this.c + ", retryPolicy=null, followRedirects=" + this.d + ')';
    }
}

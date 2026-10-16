package com.moloco.sdk.internal.services.init;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public static final int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5689a;

    public a(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        this.f5689a = appKey;
    }

    public final String a() {
        return this.f5689a;
    }

    public final String b() {
        return this.f5689a;
    }

    public final String c() {
        return this.f5689a + "___v1";
    }

    public final List<String> d() {
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.f5689a, ((a) obj).f5689a);
    }

    public int hashCode() {
        return this.f5689a.hashCode();
    }

    public String toString() {
        return "CacheKey(appKey=" + this.f5689a + ')';
    }

    public final a a(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        return new a(appKey);
    }

    public static /* synthetic */ a a(a aVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aVar.f5689a;
        }
        return aVar.a(str);
    }
}

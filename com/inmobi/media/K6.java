package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class K6 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2337a;
    public final Integer b;

    public K6(int i) {
        this.f2337a = i;
        this.b = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K6)) {
            return false;
        }
        K6 k6 = (K6) obj;
        return this.f2337a == k6.f2337a && Intrinsics.areEqual(this.b, k6.b);
    }

    public final int hashCode() {
        int hashCode = Integer.hashCode(this.f2337a) * 31;
        Integer num = this.b;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "OpenRequestResultData(result=" + this.f2337a + ", errorCode=" + this.b + ')';
    }

    public K6(int i, Integer num) {
        this.f2337a = i;
        this.b = num;
    }
}

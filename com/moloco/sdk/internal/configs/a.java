package com.moloco.sdk.internal.configs;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public static final int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5381a;
    public final int b;

    public a(String reportingUrl, int i) {
        Intrinsics.checkNotNullParameter(reportingUrl, "reportingUrl");
        this.f5381a = reportingUrl;
        this.b = i;
    }

    public final String a() {
        return this.f5381a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    public final String d() {
        return this.f5381a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f5381a, aVar.f5381a) && this.b == aVar.b;
    }

    public int hashCode() {
        return (this.f5381a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "OperationalMetricsConfig(reportingUrl=" + this.f5381a + ", pollingIntervalSeconds=" + this.b + ')';
    }

    public final a a(String reportingUrl, int i) {
        Intrinsics.checkNotNullParameter(reportingUrl, "reportingUrl");
        return new a(reportingUrl, i);
    }

    public static /* synthetic */ a a(a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aVar.f5381a;
        }
        if ((i2 & 2) != 0) {
            i = aVar.b;
        }
        return aVar.a(str, i);
    }
}

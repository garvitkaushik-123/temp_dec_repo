package io.bidmachine.analytics.internal;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6782a;
    private final a b;
    private final String c;

    public enum a {
        UNKNOWN,
        MONITOR_INVALID,
        MONITOR_NO_CONTENT,
        MONITOR_BAD_CONTENT,
        READER_INVALID,
        READER_NO_CONTENT,
        READER_BAD_CONTENT,
        READER_NO_ACCESS
    }

    public q0(String str, a aVar, String str2) {
        this.f6782a = str;
        this.b = aVar;
        this.c = str2;
    }

    public final String a() {
        return this.f6782a;
    }

    public final String b() {
        return this.c;
    }

    public final a c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return Intrinsics.areEqual(this.f6782a, q0Var.f6782a) && this.b == q0Var.b && Intrinsics.areEqual(this.c, q0Var.c);
    }

    public int hashCode() {
        return (((this.f6782a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "TrackerError(name=" + this.f6782a + ", type=" + this.b + ", reason=" + this.c + ')';
    }

    public /* synthetic */ q0(String str, a aVar, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, aVar, (i & 4) != 0 ? "" : str2);
    }
}

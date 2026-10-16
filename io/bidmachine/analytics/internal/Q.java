package io.bidmachine.analytics.internal;

import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class Q {
    public static final a g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f6669a;
    private final String b;
    private final String c;
    private final long d;
    private final Map e;
    private final q0 f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public Q(String str, String str2, String str3, long j, Map map, q0 q0Var) {
        this.f6669a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = map;
        this.f = q0Var;
    }

    public final Q a(String str, String str2, String str3, long j, Map map, q0 q0Var) {
        return new Q(str, str2, str3, j, map, q0Var);
    }

    public final q0 b() {
        return this.f;
    }

    public final String c() {
        return this.f6669a;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q = (Q) obj;
        return Intrinsics.areEqual(this.f6669a, q.f6669a) && Intrinsics.areEqual(this.b, q.b) && Intrinsics.areEqual(this.c, q.c) && this.d == q.d && Intrinsics.areEqual(this.e, q.e) && Intrinsics.areEqual(this.f, q.f);
    }

    public final long f() {
        return this.d;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f6669a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31;
        q0 q0Var = this.f;
        return hashCode + (q0Var == null ? 0 : q0Var.hashCode());
    }

    public String toString() {
        return "MonitorRecord(id=" + this.f6669a + ", name=" + this.b + ", sessionId=" + this.c + ", timestamp=" + this.d + ", data=" + this.e + ", error=" + this.f + ')';
    }

    public static /* synthetic */ Q a(Q q, String str, String str2, String str3, long j, Map map, q0 q0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            str = q.f6669a;
        }
        if ((i & 2) != 0) {
            str2 = q.b;
        }
        if ((i & 4) != 0) {
            str3 = q.c;
        }
        if ((i & 8) != 0) {
            j = q.d;
        }
        if ((i & 16) != 0) {
            map = q.e;
        }
        if ((i & 32) != 0) {
            q0Var = q.f;
        }
        long j2 = j;
        String str4 = str3;
        return q.a(str, str2, str4, j2, map, q0Var);
    }

    public final Map a() {
        return this.e;
    }

    public /* synthetic */ Q(String str, String str2, String str3, long j, Map map, q0 q0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UUID.randomUUID().toString() : str, str2, str3, (i & 8) != 0 ? System.currentTimeMillis() : j, (i & 16) != 0 ? MapsKt.emptyMap() : map, (i & 32) != 0 ? null : q0Var);
    }
}

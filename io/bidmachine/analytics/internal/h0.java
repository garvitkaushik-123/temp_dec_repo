package io.bidmachine.analytics.internal;

import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6700a;
    private final String b;
    private final long c;
    private final String d;
    private final a e;
    private final q0 f;
    private final boolean g;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f6701a;
        private final String b;

        public a(String str, String str2) {
            this.f6701a = str;
            this.b = str2;
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.f6701a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f6701a, aVar.f6701a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.f6701a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Rule(tag=" + this.f6701a + ", path=" + this.b + ')';
        }
    }

    public h0(String str, String str2, long j, String str3, a aVar, q0 q0Var, boolean z) {
        this.f6700a = str;
        this.b = str2;
        this.c = j;
        this.d = str3;
        this.e = aVar;
        this.f = q0Var;
        this.g = z;
    }

    public final h0 a(String str, String str2, long j, String str3, a aVar, q0 q0Var, boolean z) {
        return new h0(str, str2, j, str3, aVar, q0Var, z);
    }

    public final q0 b() {
        return this.f;
    }

    public final String c() {
        return this.f6700a;
    }

    public final String d() {
        return this.b;
    }

    public final a e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return Intrinsics.areEqual(this.f6700a, h0Var.f6700a) && Intrinsics.areEqual(this.b, h0Var.b) && this.c == h0Var.c && Intrinsics.areEqual(this.d, h0Var.d) && Intrinsics.areEqual(this.e, h0Var.e) && Intrinsics.areEqual(this.f, h0Var.f) && this.g == h0Var.g;
    }

    public final long f() {
        return this.c;
    }

    public final boolean g() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.f6700a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        q0 q0Var = this.f;
        int hashCode2 = (hashCode + (q0Var == null ? 0 : q0Var.hashCode())) * 31;
        boolean z = this.g;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ReaderRecord(id=" + this.f6700a + ", name=" + this.b + ", timestamp=" + this.c + ", dataHash=" + this.d + ", rule=" + this.e + ", error=" + this.f + ", isDirty=" + this.g + ')';
    }

    public static /* synthetic */ h0 a(h0 h0Var, String str, String str2, long j, String str3, a aVar, q0 q0Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = h0Var.f6700a;
        }
        if ((i & 2) != 0) {
            str2 = h0Var.b;
        }
        if ((i & 4) != 0) {
            j = h0Var.c;
        }
        if ((i & 8) != 0) {
            str3 = h0Var.d;
        }
        if ((i & 16) != 0) {
            aVar = h0Var.e;
        }
        if ((i & 32) != 0) {
            q0Var = h0Var.f;
        }
        if ((i & 64) != 0) {
            z = h0Var.g;
        }
        long j2 = j;
        return h0Var.a(str, str2, j2, str3, aVar, q0Var, z);
    }

    public final String a() {
        return this.d;
    }

    public /* synthetic */ h0(String str, String str2, long j, String str3, a aVar, q0 q0Var, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UUID.randomUUID().toString() : str, str2, (i & 4) != 0 ? System.currentTimeMillis() : j, str3, aVar, (i & 32) != 0 ? null : q0Var, (i & 64) != 0 ? true : z);
    }
}

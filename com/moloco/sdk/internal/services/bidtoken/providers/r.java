package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class r {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f5653a;
    public final Long b;
    public final Long c;

    public r() {
        this(null, null, null, 7, null);
    }

    public final Boolean a() {
        return this.f5653a;
    }

    public final Long b() {
        return this.b;
    }

    public final Long c() {
        return this.c;
    }

    public final Boolean d() {
        return this.f5653a;
    }

    public final Long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.f5653a, rVar.f5653a) && Intrinsics.areEqual(this.b, rVar.b) && Intrinsics.areEqual(this.c, rVar.c);
    }

    public final Long f() {
        return this.c;
    }

    public int hashCode() {
        Boolean bool = this.f5653a;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l = this.b;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.c;
        return hashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "MemoryInfoSignal(lowMemory=" + this.f5653a + ", threshold=" + this.b + ", totalMem=" + this.c + ')';
    }

    public r(Boolean bool, Long l, Long l2) {
        this.f5653a = bool;
        this.b = l;
        this.c = l2;
    }

    public final r a(Boolean bool, Long l, Long l2) {
        return new r(bool, l, l2);
    }

    public static /* synthetic */ r a(r rVar, Boolean bool, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = rVar.f5653a;
        }
        if ((i & 2) != 0) {
            l = rVar.b;
        }
        if ((i & 4) != 0) {
            l2 = rVar.c;
        }
        return rVar.a(bool, l, l2);
    }

    public /* synthetic */ r(Boolean bool, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2);
    }
}

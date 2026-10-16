package com.ironsource;

import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.g2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3089g2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3310a;
    private final boolean b;
    private boolean c;
    private String d;
    private Map<String, ? extends Object> e;
    private com.ironsource.mediationsdk.h f;
    private Map<String, Object> g;

    public C3089g2(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f3310a = name;
        this.b = z;
        this.d = "";
        this.e = MapsKt.emptyMap();
        this.g = new HashMap();
    }

    public final String a() {
        return this.f3310a;
    }

    public final boolean b() {
        return this.b;
    }

    public final Map<String, Object> c() {
        return this.g;
    }

    public final com.ironsource.mediationsdk.h d() {
        return this.f;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3089g2)) {
            return false;
        }
        C3089g2 c3089g2 = (C3089g2) obj;
        return Intrinsics.areEqual(this.f3310a, c3089g2.f3310a) && this.b == c3089g2.b;
    }

    public final Map<String, Object> f() {
        return this.e;
    }

    public final String g() {
        return this.f3310a;
    }

    public final String h() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f3310a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final boolean i() {
        return this.c;
    }

    public String toString() {
        return "AuctionRequestInstanceInfo(name=" + this.f3310a + ", bidder=" + this.b + ")";
    }

    public final C3089g2 a(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new C3089g2(name, z);
    }

    public final void b(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.e = map;
    }

    public static /* synthetic */ C3089g2 a(C3089g2 c3089g2, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3089g2.f3310a;
        }
        if ((i & 2) != 0) {
            z = c3089g2.b;
        }
        return c3089g2.a(str, z);
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void a(com.ironsource.mediationsdk.h hVar) {
        this.f = hVar;
    }

    public final void a(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.g = map;
    }
}

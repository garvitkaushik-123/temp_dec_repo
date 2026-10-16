package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class V8 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3099a;
    private final String b;
    private V c;
    private boolean d;
    private String e;
    private String f;

    public V8(String appKey, String userId) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.f3099a = appKey;
        this.b = userId;
    }

    public final String a() {
        return this.f3099a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean c() {
        return this.d;
    }

    public final String d() {
        return this.f3099a;
    }

    public final V e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V8)) {
            return false;
        }
        V8 v8 = (V8) obj;
        return Intrinsics.areEqual(this.f3099a, v8.f3099a) && Intrinsics.areEqual(this.b, v8.b);
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.e;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        return (this.f3099a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "InitConfig(appKey=" + this.f3099a + ", userId=" + this.b + ")";
    }

    public final V8 a(String appKey, String userId) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new V8(appKey, userId);
    }

    public final void b(String str) {
        this.e = str;
    }

    public static /* synthetic */ V8 a(V8 v8, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = v8.f3099a;
        }
        if ((i & 2) != 0) {
            str2 = v8.b;
        }
        return v8.a(str, str2);
    }

    public final void a(V v) {
        this.c = v;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final <T> T a(InterfaceC3317tb<V8, T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }
}

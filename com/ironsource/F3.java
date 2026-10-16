package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class F3 {

    /* renamed from: a, reason: collision with root package name */
    private String f2858a;
    private String b;
    private String c;

    public F3(String cachedAppKey, String cachedUserId, String cachedSettings) {
        Intrinsics.checkNotNullParameter(cachedAppKey, "cachedAppKey");
        Intrinsics.checkNotNullParameter(cachedUserId, "cachedUserId");
        Intrinsics.checkNotNullParameter(cachedSettings, "cachedSettings");
        this.f2858a = cachedAppKey;
        this.b = cachedUserId;
        this.c = cachedSettings;
    }

    public final String a() {
        return this.f2858a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.f2858a;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F3)) {
            return false;
        }
        F3 f3 = (F3) obj;
        return Intrinsics.areEqual(this.f2858a, f3.f2858a) && Intrinsics.areEqual(this.b, f3.b) && Intrinsics.areEqual(this.c, f3.c);
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        return (((this.f2858a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "CachedResponse(cachedAppKey=" + this.f2858a + ", cachedUserId=" + this.b + ", cachedSettings=" + this.c + ")";
    }

    public final F3 a(String cachedAppKey, String cachedUserId, String cachedSettings) {
        Intrinsics.checkNotNullParameter(cachedAppKey, "cachedAppKey");
        Intrinsics.checkNotNullParameter(cachedUserId, "cachedUserId");
        Intrinsics.checkNotNullParameter(cachedSettings, "cachedSettings");
        return new F3(cachedAppKey, cachedUserId, cachedSettings);
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public static /* synthetic */ F3 a(F3 f3, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = f3.f2858a;
        }
        if ((i & 2) != 0) {
            str2 = f3.b;
        }
        if ((i & 4) != 0) {
            str3 = f3.c;
        }
        return f3.a(str, str2, str3);
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f2858a = str;
    }
}

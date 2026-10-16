package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class u {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final v f6158a;
    public final String b;
    public final r c;

    public u(v event, String url, r rVar) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f6158a = event;
        this.b = url;
        this.c = rVar;
    }

    public final v a() {
        return this.f6158a;
    }

    public final String b() {
        return this.b;
    }

    public final r c() {
        return this.c;
    }

    public final v d() {
        return this.f6158a;
    }

    public final r e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f6158a == uVar.f6158a && Intrinsics.areEqual(this.b, uVar.b) && Intrinsics.areEqual(this.c, uVar.c);
    }

    public final String f() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = ((this.f6158a.hashCode() * 31) + this.b.hashCode()) * 31;
        r rVar = this.c;
        return hashCode + (rVar == null ? 0 : rVar.hashCode());
    }

    public String toString() {
        return "Tracking(event=" + this.f6158a + ", url=" + this.b + ", offset=" + this.c + ')';
    }

    public /* synthetic */ u(v vVar, String str, r rVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vVar, str, (i & 4) != 0 ? null : rVar);
    }

    public final u a(v event, String url, r rVar) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(url, "url");
        return new u(event, url, rVar);
    }

    public static /* synthetic */ u a(u uVar, v vVar, String str, r rVar, int i, Object obj) {
        if ((i & 1) != 0) {
            vVar = uVar.f6158a;
        }
        if ((i & 2) != 0) {
            str = uVar.b;
        }
        if ((i & 4) != 0) {
            rVar = uVar.c;
        }
        return uVar.a(vVar, str, rVar);
    }
}

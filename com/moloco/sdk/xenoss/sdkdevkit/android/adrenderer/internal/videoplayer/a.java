package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class a {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6309a;
    public final boolean b;
    public final boolean c;

    public a(boolean z, boolean z2, boolean z3) {
        this.f6309a = z;
        this.b = z2;
        this.c = z3;
    }

    public final boolean a() {
        return this.f6309a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.f6309a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6309a == aVar.f6309a && this.b == aVar.b && this.c == aVar.c;
    }

    public final boolean f() {
        return this.b;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.f6309a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "PlayingState(isPlaying=" + this.f6309a + ", isVisible=" + this.b + ", hasMore=" + this.c + ')';
    }

    public final a a(boolean z, boolean z2, boolean z3) {
        return new a(z, z2, z3);
    }

    public static /* synthetic */ a a(a aVar, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = aVar.f6309a;
        }
        if ((i & 2) != 0) {
            z2 = aVar.b;
        }
        if ((i & 4) != 0) {
            z3 = aVar.c;
        }
        return aVar.a(z, z2, z3);
    }

    public /* synthetic */ a(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3);
    }
}

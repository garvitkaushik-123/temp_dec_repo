package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public final class Cc {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2818a;
    private final int b;

    /* JADX WARN: Multi-variable type inference failed */
    public Cc() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public final boolean a() {
        return this.f2818a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        return this.f2818a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cc)) {
            return false;
        }
        Cc cc = (Cc) obj;
        return this.f2818a == cc.f2818a && this.b == cc.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f2818a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "OpenUrlConfigurations(isImmersive=" + this.f2818a + ", flags=" + this.b + ")";
    }

    public Cc(boolean z, int i) {
        this.f2818a = z;
        this.b = i;
    }

    public final Cc a(boolean z, int i) {
        return new Cc(z, i);
    }

    public static /* synthetic */ Cc a(Cc cc, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = cc.f2818a;
        }
        if ((i2 & 2) != 0) {
            i = cc.b;
        }
        return cc.a(z, i);
    }

    public /* synthetic */ Cc(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? com.google.android.exoplayer2.C.ENCODING_PCM_32BIT : i);
    }
}

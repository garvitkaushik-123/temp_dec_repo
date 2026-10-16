package com.moloco.sdk.internal.services;

/* loaded from: classes6.dex */
public final class E {
    public static final int i = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5613a;
    public final float b;
    public final int c;
    public final float d;
    public final float e;
    public final int f;
    public final float g;
    public final float h;

    public E(int i2, float f, int i3, float f2, float f3, int i4, float f4, float f5) {
        this.f5613a = i2;
        this.b = f;
        this.c = i3;
        this.d = f2;
        this.e = f3;
        this.f = i4;
        this.g = f4;
        this.h = f5;
    }

    public final int a() {
        return this.f5613a;
    }

    public final float b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e = (E) obj;
        return this.f5613a == e.f5613a && Float.compare(this.b, e.b) == 0 && this.c == e.c && Float.compare(this.d, e.d) == 0 && Float.compare(this.e, e.e) == 0 && this.f == e.f && Float.compare(this.g, e.g) == 0 && Float.compare(this.h, e.h) == 0;
    }

    public final int f() {
        return this.f;
    }

    public final float g() {
        return this.g;
    }

    public final float h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.f5613a) * 31) + Float.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h);
    }

    public final float i() {
        return this.e;
    }

    public final int j() {
        return this.f;
    }

    public final float k() {
        return this.d;
    }

    public final int l() {
        return this.c;
    }

    public final float m() {
        return this.b;
    }

    public final int n() {
        return this.f5613a;
    }

    public final float o() {
        return this.g;
    }

    public final float p() {
        return this.h;
    }

    public String toString() {
        return "ScreenInfo(screenWidthPx=" + this.f5613a + ", screenWidthDp=" + this.b + ", screenHeightPx=" + this.c + ", screenHeightDp=" + this.d + ", density=" + this.e + ", dpi=" + this.f + ", xdpi=" + this.g + ", ydpi=" + this.h + ')';
    }

    public final E a(int i2, float f, int i3, float f2, float f3, int i4, float f4, float f5) {
        return new E(i2, f, i3, f2, f3, i4, f4, f5);
    }

    public static /* synthetic */ E a(E e, int i2, float f, int i3, float f2, float f3, int i4, float f4, float f5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = e.f5613a;
        }
        if ((i5 & 2) != 0) {
            f = e.b;
        }
        if ((i5 & 4) != 0) {
            i3 = e.c;
        }
        if ((i5 & 8) != 0) {
            f2 = e.d;
        }
        if ((i5 & 16) != 0) {
            f3 = e.e;
        }
        if ((i5 & 32) != 0) {
            i4 = e.f;
        }
        if ((i5 & 64) != 0) {
            f4 = e.g;
        }
        if ((i5 & 128) != 0) {
            f5 = e.h;
        }
        float f6 = f4;
        float f7 = f5;
        float f8 = f3;
        int i6 = i4;
        return e.a(i2, f, i3, f2, f8, i6, f6, f7);
    }
}

package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model;

/* loaded from: classes6.dex */
public final class a {
    public static final int g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5940a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f5940a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public final int a() {
        return this.f5940a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5940a == aVar.f5940a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.e;
    }

    public final int h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f5940a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public final int i() {
        return this.f5940a;
    }

    public final int j() {
        return this.b;
    }

    public final int k() {
        return this.c;
    }

    public final int l() {
        return this.d;
    }

    public String toString() {
        return "AdTouch(viewPositionX=" + this.f5940a + ", viewPositionY=" + this.b + ", viewSizeHeight=" + this.c + ", viewSizeWidth=" + this.d + ", touchX=" + this.e + ", touchY=" + this.f + ')';
    }

    public final a a(int i, int i2, int i3, int i4, int i5, int i6) {
        return new a(i, i2, i3, i4, i5, i6);
    }

    public static /* synthetic */ a a(a aVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = aVar.f5940a;
        }
        if ((i7 & 2) != 0) {
            i2 = aVar.b;
        }
        if ((i7 & 4) != 0) {
            i3 = aVar.c;
        }
        if ((i7 & 8) != 0) {
            i4 = aVar.d;
        }
        if ((i7 & 16) != 0) {
            i5 = aVar.e;
        }
        if ((i7 & 32) != 0) {
            i6 = aVar.f;
        }
        int i8 = i5;
        int i9 = i6;
        return aVar.a(i, i2, i3, i4, i8, i9);
    }
}

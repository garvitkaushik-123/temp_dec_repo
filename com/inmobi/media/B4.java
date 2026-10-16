package com.inmobi.media;

/* loaded from: classes4.dex */
public final class B4 {

    /* renamed from: a, reason: collision with root package name */
    public final float f2241a;
    public final float b;
    public final int c;
    public final int d;

    public B4(float f, float f2, int i, int i2) {
        this.f2241a = f;
        this.b = f2;
        this.c = i;
        this.d = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B4)) {
            return false;
        }
        B4 b4 = (B4) obj;
        return Float.compare(this.f2241a, b4.f2241a) == 0 && Float.compare(this.b, b4.b) == 0 && this.c == b4.c && this.d == b4.d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.d) + ((Integer.hashCode(this.c) + ((Float.hashCode(this.b) + (Float.hashCode(this.f2241a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ExposureRectangle(x=" + this.f2241a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ')';
    }
}

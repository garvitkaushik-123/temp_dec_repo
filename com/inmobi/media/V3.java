package com.inmobi.media;

/* loaded from: classes4.dex */
public final class V3 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2459a;
    public final int b;
    public final float c;

    public V3(int i, float f, int i2) {
        this.f2459a = i;
        this.b = i2;
        this.c = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V3)) {
            return false;
        }
        V3 v3 = (V3) obj;
        return this.f2459a == v3.f2459a && this.b == v3.b && Float.compare(this.c, v3.c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.c) + ((Integer.hashCode(this.b) + (Integer.hashCode(this.f2459a) * 31)) * 31);
    }

    public final String toString() {
        return "DisplayProperties(width=" + this.f2459a + ", height=" + this.b + ", density=" + this.c + ')';
    }
}

package com.inmobi.media;

/* loaded from: classes4.dex */
public final class I3 {

    /* renamed from: a, reason: collision with root package name */
    public final long f2312a;
    public final long b;
    public final long c;

    public I3(long j, long j2, long j3) {
        this.f2312a = j;
        this.b = j2;
        this.c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I3)) {
            return false;
        }
        I3 i3 = (I3) obj;
        return this.f2312a == i3.f2312a && this.b == i3.b && this.c == i3.c;
    }

    public final int hashCode() {
        return Long.hashCode(this.c) + ((Long.hashCode(this.b) + (Long.hashCode(this.f2312a) * 31)) * 31);
    }

    public final String toString() {
        return "DeviceMemoryInfo(maxHeapSize=" + this.f2312a + ", freeHeapSize=" + this.b + ", currentHeapSize=" + this.c + ')';
    }
}

package com.inmobi.media;

/* renamed from: com.inmobi.media.q4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2823q4 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2679a;
    public final long b;
    public final long c;
    public final long d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final long i;
    public final long j;
    public String k;

    public C2823q4(int i, long j, long j2, long j3, int i2, int i3, int i4, int i5, long j4, long j5) {
        this.f2679a = i;
        this.b = j;
        this.c = j2;
        this.d = j3;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = j4;
        this.j = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2823q4)) {
            return false;
        }
        C2823q4 c2823q4 = (C2823q4) obj;
        return this.f2679a == c2823q4.f2679a && this.b == c2823q4.b && this.c == c2823q4.c && this.d == c2823q4.d && this.e == c2823q4.e && this.f == c2823q4.f && this.g == c2823q4.g && this.h == c2823q4.h && this.i == c2823q4.i && this.j == c2823q4.j;
    }

    public final int hashCode() {
        return Long.hashCode(this.j) + ((Long.hashCode(this.i) + ((Integer.hashCode(this.h) + ((Integer.hashCode(this.g) + ((Integer.hashCode(this.f) + ((Integer.hashCode(this.e) + ((Long.hashCode(this.d) + ((Long.hashCode(this.c) + ((Long.hashCode(this.b) + (Integer.hashCode(this.f2679a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "EventConfig(maxRetryCount=" + this.f2679a + ", timeToLiveInSec=" + this.b + ", processingInterval=" + this.c + ", ingestionLatencyInSec=" + this.d + ", minBatchSizeWifi=" + this.e + ", maxBatchSizeWifi=" + this.f + ", minBatchSizeMobile=" + this.g + ", maxBatchSizeMobile=" + this.h + ", retryIntervalWifi=" + this.i + ", retryIntervalMobile=" + this.j + ')';
    }
}

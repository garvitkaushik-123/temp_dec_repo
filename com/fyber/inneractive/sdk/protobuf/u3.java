package com.fyber.inneractive.sdk.protobuf;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
public final class u3 extends w3 {
    public u3(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, byte b) {
        if (x3.h) {
            x3.a(obj, j, b);
        } else {
            x3.b(obj, j, b);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final boolean b() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final double c(Object obj, long j) {
        return Double.longBitsToDouble(this.f1707a.getLong(obj, j));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final float d(Object obj, long j) {
        return Float.intBitsToFloat(this.f1707a.getInt(obj, j));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final byte b(Object obj, long j) {
        return x3.h ? x3.a(obj, j) : x3.b(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final boolean a(Object obj, long j) {
        return x3.h ? x3.a(obj, j) != 0 : x3.b(obj, j) != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, boolean z) {
        if (x3.h) {
            x3.a(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            x3.b(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, float f) {
        this.f1707a.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, double d) {
        this.f1707a.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final byte a(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(long j, byte[] bArr, long j2) {
        throw new UnsupportedOperationException();
    }
}

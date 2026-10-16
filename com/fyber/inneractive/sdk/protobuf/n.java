package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes4.dex */
public final class n extends q {
    private static final long serialVersionUID = 1;
    public final int e;
    public final int f;

    public n(byte[] bArr, int i, int i2) {
        super(bArr);
        s.a(i, i + i2, bArr.length);
        this.e = i;
        this.f = i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.q, com.fyber.inneractive.sdk.protobuf.s
    public final void a(int i, byte[] bArr) {
        System.arraycopy(this.d, this.e, bArr, 0, i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.q, com.fyber.inneractive.sdk.protobuf.s
    public final byte c(int i) {
        int i2 = this.f;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.d[this.e + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.q, com.fyber.inneractive.sdk.protobuf.s
    public final byte d(int i) {
        return this.d[this.e + i];
    }

    @Override // com.fyber.inneractive.sdk.protobuf.q
    public final int g() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.q, com.fyber.inneractive.sdk.protobuf.s
    public final int size() {
        return this.f;
    }

    public Object writeReplace() {
        byte[] bArr;
        int size = size();
        if (size == 0) {
            bArr = l1.b;
        } else {
            byte[] bArr2 = new byte[size];
            a(size, bArr2);
            bArr = bArr2;
        }
        return new q(bArr);
    }
}

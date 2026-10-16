package com.fyber.inneractive.sdk.protobuf;

import com.google.android.gms.nearby.uwb.RangingPosition;

/* loaded from: classes4.dex */
public final class y extends b0 {
    public final byte[] d;
    public final int e;
    public int f;

    public y(int i, byte[] bArr) {
        if (((bArr.length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        this.d = bArr;
        this.f = 0;
        this.e = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, int i2) {
        c(i, 5);
        e(i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void b(int i, int i2) {
        c(i, 0);
        f(i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void c(int i, int i2) {
        g((i << 3) | i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void d(long j) {
        if (!b0.c || this.e - this.f < 10) {
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.d;
                    int i = this.f;
                    this.f = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new z(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
                }
            }
            byte[] bArr2 = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while ((j & (-128)) != 0) {
            byte[] bArr3 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            x3.c.a((Object) bArr3, x3.f + i3, (byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        byte[] bArr4 = this.d;
        int i4 = this.f;
        this.f = i4 + 1;
        x3.c.a((Object) bArr4, x3.f + i4, (byte) j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void e(int i) {
        try {
            byte[] bArr = this.d;
            int i2 = this.f;
            int i3 = i2 + 1;
            this.f = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.f = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.f = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.f = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new z(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void f(int i) {
        if (i >= 0) {
            g(i);
        } else {
            d(i);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void g(int i) {
        if (b0.c && !d.a()) {
            int i2 = this.e;
            int i3 = this.f;
            if (i2 - i3 >= 5) {
                if ((i & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr = this.d;
                    this.f = i3 + 1;
                    x3.c.a((Object) bArr, x3.f + i3, (byte) i);
                    return;
                }
                byte[] bArr2 = this.d;
                this.f = i3 + 1;
                w3 w3Var = x3.c;
                long j = x3.f;
                w3Var.a((Object) bArr2, i3 + j, (byte) (i | 128));
                int i4 = i >>> 7;
                if ((i4 & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr3 = this.d;
                    int i5 = this.f;
                    this.f = i5 + 1;
                    w3Var.a((Object) bArr3, j + i5, (byte) i4);
                    return;
                }
                byte[] bArr4 = this.d;
                int i6 = this.f;
                this.f = i6 + 1;
                w3Var.a((Object) bArr4, i6 + j, (byte) (i4 | 128));
                int i7 = i >>> 14;
                if ((i7 & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr5 = this.d;
                    int i8 = this.f;
                    this.f = i8 + 1;
                    w3Var.a((Object) bArr5, j + i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.d;
                int i9 = this.f;
                this.f = i9 + 1;
                w3Var.a((Object) bArr6, i9 + j, (byte) (i7 | 128));
                int i10 = i >>> 21;
                if ((i10 & RangingPosition.RSSI_UNKNOWN) == 0) {
                    byte[] bArr7 = this.d;
                    int i11 = this.f;
                    this.f = i11 + 1;
                    w3Var.a((Object) bArr7, j + i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.d;
                int i12 = this.f;
                this.f = i12 + 1;
                w3Var.a((Object) bArr8, i12 + j, (byte) (i10 | 128));
                byte[] bArr9 = this.d;
                int i13 = this.f;
                this.f = i13 + 1;
                w3Var.a((Object) bArr9, j + i13, (byte) (i >>> 28));
                return;
            }
        }
        while ((i & RangingPosition.RSSI_UNKNOWN) != 0) {
            try {
                byte[] bArr10 = this.d;
                int i14 = this.f;
                this.f = i14 + 1;
                bArr10[i14] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new z(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
            }
        }
        byte[] bArr11 = this.d;
        int i15 = this.f;
        this.f = i15 + 1;
        bArr11[i15] = (byte) i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void c(long j) {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            int i2 = i + 1;
            this.f = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.f = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.f = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.f = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.f = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.f = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.f = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.f = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new z(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, long j) {
        c(i, 1);
        c(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void b(int i, long j) {
        c(i, 0);
        d(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, boolean z) {
        c(i, 0);
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void b(int i, s sVar) {
        c(1, 3);
        c(2, 0);
        g(i);
        a(3, sVar);
        c(1, 4);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(String str, int i) {
        c(i, 2);
        b(str);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, s sVar) {
        c(i, 2);
        g(sVar.size());
        sVar.a(this);
    }

    public final void b(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, i, this.d, this.f, i2);
            this.f += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new z(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)), e);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, d2 d2Var, t2 t2Var) {
        c(i, 2);
        g(((b) d2Var).getSerializedSize(t2Var));
        t2Var.a((Object) d2Var, this.f1659a);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, d2 d2Var) {
        c(1, 3);
        c(2, 0);
        g(i);
        c(3, 2);
        g(d2Var.getSerializedSize());
        d2Var.writeTo(this);
        c(1, 4);
    }

    public final void b(String str) {
        int i = this.f;
        try {
            int c = b0.c(str.length() * 3);
            int c2 = b0.c(str.length());
            if (c2 == c) {
                int i2 = i + c2;
                this.f = i2;
                int a2 = d4.f1666a.a(str, this.d, i2, this.e - i2);
                this.f = i;
                g((a2 - i) - c2);
                this.f = a2;
                return;
            }
            g(d4.a(str));
            byte[] bArr = this.d;
            int i3 = this.f;
            this.f = d4.f1666a.a(str, bArr, i3, this.e - i3);
        } catch (b4 e) {
            this.f = i;
            a(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new z(e2);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void d(int i, int i2) {
        c(i, 0);
        g(i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(byte b) {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new z(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.k
    public final void a(byte[] bArr, int i, int i2) {
        b(bArr, i, i2);
    }

    public final int a() {
        return this.e - this.f;
    }
}

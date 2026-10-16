package com.fyber.inneractive.sdk.protobuf;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes4.dex */
public final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1674a = true;
    public final byte[] b;
    public int c;
    public int d;
    public int e;
    public int f;

    public h(ByteBuffer byteBuffer) {
        this.b = byteBuffer.array();
        this.c = byteBuffer.position() + byteBuffer.arrayOffset();
        this.d = byteBuffer.limit() + byteBuffer.arrayOffset();
    }

    public final String a(boolean z) {
        c(2);
        int x = x();
        if (x == 0) {
            return "";
        }
        a(x);
        if (z) {
            byte[] bArr = this.b;
            int i = this.c;
            if (!d4.f1666a.b(bArr, i, i + x)) {
                throw new n1("Protocol message had invalid UTF-8.");
            }
        }
        String str = new String(this.b, this.c, x, l1.f1684a);
        this.c += x;
        return str;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object b(Class cls, h0 h0Var) {
        c(2);
        return d(p2.c.a(cls), h0Var);
    }

    public final Object c(t2 t2Var, h0 h0Var) {
        int i = this.f;
        this.f = ((this.e >>> 3) << 3) | 4;
        try {
            Object a2 = t2Var.a();
            t2Var.a(a2, this, h0Var);
            t2Var.c(a2);
            if (this.e == this.f) {
                return a2;
            }
            throw new n1("Failed to parse the message.");
        } finally {
            this.f = i;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int d() {
        c(0);
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int e() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long f() {
        c(0);
        return y();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long g() {
        c(1);
        a(8);
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final double h() {
        c(1);
        a(8);
        return Double.longBitsToDouble(w());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final boolean i() {
        int i;
        int i2;
        if (u() || (i = this.e) == (i2 = this.f)) {
            return false;
        }
        int i3 = i & 7;
        if (i3 == 0) {
            int i4 = this.d;
            int i5 = this.c;
            if (i4 - i5 >= 10) {
                byte[] bArr = this.b;
                int i6 = 0;
                while (i6 < 10) {
                    int i7 = i5 + 1;
                    if (bArr[i5] >= 0) {
                        this.c = i7;
                        break;
                    }
                    i6++;
                    i5 = i7;
                }
            }
            for (int i8 = 0; i8 < 10; i8++) {
                int i9 = this.c;
                if (i9 == this.d) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.b;
                this.c = i9 + 1;
                if (bArr2[i9] >= 0) {
                    return true;
                }
            }
            throw new n1("CodedInputStream encountered a malformed varint.");
        }
        if (i3 == 1) {
            a(8);
            this.c += 8;
            return true;
        }
        if (i3 == 2) {
            int x = x();
            a(x);
            this.c += x;
            return true;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                int i10 = n1.f1688a;
                throw new m1();
            }
            a(4);
            this.c += 4;
            return true;
        }
        this.f = ((i >>> 3) << 3) | 4;
        while (s() != Integer.MAX_VALUE && i()) {
        }
        if (this.e != this.f) {
            throw new n1("Failed to parse the message.");
        }
        this.f = i2;
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int j() {
        c(0);
        return w.b(x());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final float k() {
        c(5);
        a(4);
        return Float.intBitsToFloat(v());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long l() {
        c(0);
        return w.a(y());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int m() {
        c(5);
        a(4);
        return v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final String n() {
        return a(false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long o() {
        c(0);
        return y();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final String p() {
        return a(true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int q() {
        c(5);
        a(4);
        return v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final boolean r() {
        c(0);
        return x() != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int s() {
        if (u()) {
            return Integer.MAX_VALUE;
        }
        int x = x();
        this.e = x;
        if (x == this.f) {
            return Integer.MAX_VALUE;
        }
        return x >>> 3;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long t() {
        c(1);
        a(8);
        return w();
    }

    public final boolean u() {
        return this.c == this.d;
    }

    public final int v() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long w() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final int x() {
        int i;
        int i2 = this.c;
        int i3 = this.d;
        if (i3 == i2) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.b;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.c = i4;
            return b;
        }
        if (i3 - i4 < 9) {
            long j = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                int i6 = this.c;
                if (i6 == this.d) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.b;
                this.c = i6 + 1;
                j |= (r4 & Byte.MAX_VALUE) << i5;
                if ((bArr2[i6] & 128) == 0) {
                    return (int) j;
                }
            }
            throw new n1("CodedInputStream encountered a malformed varint.");
        }
        int i7 = i2 + 2;
        int i8 = (bArr[i4] << 7) ^ b;
        if (i8 < 0) {
            i = i8 ^ RangingPosition.RSSI_UNKNOWN;
        } else {
            int i9 = i2 + 3;
            int i10 = (bArr[i7] << Ascii.SO) ^ i8;
            if (i10 >= 0) {
                i = i10 ^ 16256;
            } else {
                int i11 = i2 + 4;
                int i12 = i10 ^ (bArr[i9] << Ascii.NAK);
                if (i12 < 0) {
                    i = (-2080896) ^ i12;
                    i7 = i11;
                } else {
                    i9 = i2 + 5;
                    byte b2 = bArr[i11];
                    int i13 = (i12 ^ (b2 << Ascii.FS)) ^ 266354560;
                    if (b2 < 0) {
                        int i14 = i2 + 6;
                        if (bArr[i9] < 0) {
                            i9 = i2 + 7;
                            if (bArr[i14] < 0) {
                                i14 = i2 + 8;
                                if (bArr[i9] < 0) {
                                    i9 = i2 + 9;
                                    if (bArr[i14] < 0) {
                                        int i15 = i2 + 10;
                                        if (bArr[i9] < 0) {
                                            throw new n1("CodedInputStream encountered a malformed varint.");
                                        }
                                        i9 = i15;
                                    }
                                }
                            }
                        }
                        i9 = i14;
                    }
                    i = i13;
                }
            }
            i7 = i9;
        }
        this.c = i7;
        return i;
    }

    public final long y() {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.c;
        int i2 = this.d;
        if (i2 == i) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.b;
        int i3 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            this.c = i3;
            return b;
        }
        long j5 = 0;
        if (i2 - i3 < 9) {
            for (int i4 = 0; i4 < 64; i4 += 7) {
                int i5 = this.c;
                if (i5 == this.d) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.b;
                this.c = i5 + 1;
                j5 |= (r1 & Byte.MAX_VALUE) << i4;
                if ((bArr2[i5] & 128) == 0) {
                    return j5;
                }
            }
            throw new n1("CodedInputStream encountered a malformed varint.");
        }
        int i6 = i + 2;
        int i7 = (bArr[i3] << 7) ^ b;
        if (i7 < 0) {
            j = i7 ^ RangingPosition.RSSI_UNKNOWN;
        } else {
            int i8 = i + 3;
            int i9 = (bArr[i6] << Ascii.SO) ^ i7;
            if (i9 >= 0) {
                j = i9 ^ 16256;
                i6 = i8;
            } else {
                int i10 = i + 4;
                int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                if (i11 < 0) {
                    j4 = (-2080896) ^ i11;
                } else {
                    long j6 = i11;
                    i6 = i + 5;
                    long j7 = j6 ^ (bArr[i10] << 28);
                    if (j7 >= 0) {
                        j3 = 266354560;
                    } else {
                        i10 = i + 6;
                        long j8 = j7 ^ (bArr[i6] << 35);
                        if (j8 < 0) {
                            j2 = -34093383808L;
                        } else {
                            i6 = i + 7;
                            j7 = j8 ^ (bArr[i10] << 42);
                            if (j7 >= 0) {
                                j3 = 4363953127296L;
                            } else {
                                i10 = i + 8;
                                j8 = j7 ^ (bArr[i6] << 49);
                                if (j8 < 0) {
                                    j2 = -558586000294016L;
                                } else {
                                    i6 = i + 9;
                                    long j9 = (j8 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                    if (j9 < 0) {
                                        int i12 = i + 10;
                                        if (bArr[i6] < 0) {
                                            throw new n1("CodedInputStream encountered a malformed varint.");
                                        }
                                        i6 = i12;
                                    }
                                    j = j9;
                                }
                            }
                        }
                        j4 = j2 ^ j8;
                    }
                    j = j3 ^ j7;
                }
                i6 = i10;
                j = j4;
            }
        }
        this.c = i6;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void e(List list) {
        int i;
        int i2;
        if (!(list instanceof a1)) {
            int i3 = this.e & 7;
            if (i3 == 2) {
                int x = x();
                d(x);
                int i4 = this.c + x;
                while (this.c < i4) {
                    list.add(Integer.valueOf(v()));
                }
                return;
            }
            if (i3 != 5) {
                int i5 = n1.f1688a;
                throw new m1();
            }
            do {
                list.add(Integer.valueOf(q()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        a1 a1Var = (a1) list;
        int i6 = this.e & 7;
        if (i6 == 2) {
            int x2 = x();
            d(x2);
            int i7 = this.c + x2;
            while (this.c < i7) {
                a1Var.c(v());
            }
            return;
        }
        if (i6 != 5) {
            int i8 = n1.f1688a;
            throw new m1();
        }
        do {
            a1Var.c(q());
            if (u()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (x() == this.e);
        this.c = i2;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void n(List list) {
        int i;
        int i2;
        if (!(list instanceof u1)) {
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(g()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (x() == this.e);
                this.c = i;
                return;
            }
            if (i3 != 2) {
                int i4 = n1.f1688a;
                throw new m1();
            }
            int x = x();
            e(x);
            int i5 = this.c + x;
            while (this.c < i5) {
                list.add(Long.valueOf(w()));
            }
            return;
        }
        u1 u1Var = (u1) list;
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                u1Var.a(g());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        if (i6 != 2) {
            int i7 = n1.f1688a;
            throw new m1();
        }
        int x2 = x();
        e(x2);
        int i8 = this.c + x2;
        while (this.c < i8) {
            u1Var.a(w());
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void p(List list) {
        int i;
        int i2;
        if (!(list instanceof a1)) {
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    int i4 = n1.f1688a;
                    throw new m1();
                }
                int x = this.c + x();
                while (this.c < x) {
                    list.add(Integer.valueOf(x()));
                }
                return;
            }
            do {
                c(0);
                list.add(Integer.valueOf(x()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        a1 a1Var = (a1) list;
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 != 2) {
                int i6 = n1.f1688a;
                throw new m1();
            }
            int x2 = this.c + x();
            while (this.c < x2) {
                a1Var.c(x());
            }
            return;
        }
        do {
            c(0);
            a1Var.c(x());
            if (u()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (x() == this.e);
        this.c = i2;
    }

    public final Object d(t2 t2Var, h0 h0Var) {
        int x = x();
        a(x);
        int i = this.d;
        int i2 = this.c + x;
        this.d = i2;
        try {
            Object a2 = t2Var.a();
            t2Var.a(a2, this, h0Var);
            t2Var.c(a2);
            if (this.c == i2) {
                return a2;
            }
            throw new n1("Failed to parse the message.");
        } finally {
            this.d = i;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void f(List list) {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 == 2) {
                int x = x();
                d(x);
                int i4 = this.c + x;
                while (this.c < i4) {
                    a1Var.c(v());
                }
                return;
            }
            if (i3 == 5) {
                do {
                    a1Var.c(m());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            int i5 = n1.f1688a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 2) {
            int x2 = x();
            d(x2);
            int i7 = this.c + x2;
            while (this.c < i7) {
                list.add(Integer.valueOf(v()));
            }
            return;
        }
        if (i6 == 5) {
            do {
                list.add(Integer.valueOf(m()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i8 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void j(List list) {
        int i;
        int i2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    d0Var.a(h());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int x = x();
                e(x);
                int i4 = this.c + x;
                while (this.c < i4) {
                    d0Var.a(Double.longBitsToDouble(w()));
                }
                return;
            }
            int i5 = n1.f1688a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                list.add(Double.valueOf(h()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i6 == 2) {
            int x2 = x();
            e(x2);
            int i7 = this.c + x2;
            while (this.c < i7) {
                list.add(Double.valueOf(Double.longBitsToDouble(w())));
            }
            return;
        }
        int i8 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void l(List list) {
        int i;
        int i2;
        if (list instanceof j) {
            j jVar = (j) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    jVar.a(r());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int x = this.c + x();
                while (this.c < x) {
                    jVar.a(x() != 0);
                }
                b(x);
                return;
            }
            int i4 = n1.f1688a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                list.add(Boolean.valueOf(r()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int x2 = this.c + x();
            while (this.c < x2) {
                list.add(Boolean.valueOf(x() != 0));
            }
            b(x2);
            return;
        }
        int i6 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void o(List list) {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    a1Var.c(x());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int x = this.c + x();
                while (this.c < x) {
                    a1Var.c(x());
                }
                b(x);
                return;
            }
            int i4 = n1.f1688a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Integer.valueOf(x()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int x2 = this.c + x();
            while (this.c < x2) {
                list.add(Integer.valueOf(x()));
            }
            b(x2);
            return;
        }
        int i6 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object b(t2 t2Var, h0 h0Var) {
        c(2);
        return d(t2Var, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void g(List list) {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int x = this.c + x();
                    while (this.c < x) {
                        u1Var.a(w.a(y()));
                    }
                    return;
                }
                int i4 = n1.f1688a;
                throw new m1();
            }
            do {
                c(0);
                u1Var.a(w.a(y()));
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int x2 = this.c + x();
                while (this.c < x2) {
                    list.add(Long.valueOf(w.a(y())));
                }
                return;
            }
            int i6 = n1.f1688a;
            throw new m1();
        }
        do {
            c(0);
            list.add(Long.valueOf(w.a(y())));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void m(List list) {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    u1Var.a(t());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int x = x();
                e(x);
                int i4 = this.c + x;
                while (this.c < i4) {
                    u1Var.a(w());
                }
                return;
            }
            int i5 = n1.f1688a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                list.add(Long.valueOf(t()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i6 == 2) {
            int x2 = x();
            e(x2);
            int i7 = this.c + x2;
            while (this.c < i7) {
                list.add(Long.valueOf(w()));
            }
            return;
        }
        int i8 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void q(List list) {
        a(list, false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void h(List list) {
        int i;
        if ((this.e & 7) == 2) {
            do {
                list.add(a());
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i2 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void k(List list) {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    u1Var.a(y());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int x = this.c + x();
                while (this.c < x) {
                    u1Var.a(y());
                }
                b(x);
                return;
            }
            int i4 = n1.f1688a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Long.valueOf(y()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int x2 = this.c + x();
            while (this.c < x2) {
                list.add(Long.valueOf(y()));
            }
            b(x2);
            return;
        }
        int i6 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int b() {
        c(0);
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void b(List list) {
        a(list, true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void b(List list, t2 t2Var, h0 h0Var) {
        int i;
        int i2 = this.e;
        if ((i2 & 7) == 2) {
            do {
                list.add(d(t2Var, h0Var));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == i2);
            this.c = i;
            return;
        }
        int i3 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object a(Class cls, h0 h0Var) {
        c(3);
        return c(p2.c.a(cls), h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object a(t2 t2Var, h0 h0Var) {
        c(3);
        return c(t2Var, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final s a() {
        s qVar;
        c(2);
        int x = x();
        if (x == 0) {
            return s.b;
        }
        a(x);
        if (this.f1674a) {
            byte[] bArr = this.b;
            int i = this.c;
            q qVar2 = s.b;
            qVar = new n(bArr, i, x);
        } else {
            byte[] bArr2 = this.b;
            int i2 = this.c;
            q qVar3 = s.b;
            s.a(i2, i2 + x, bArr2.length);
            qVar = new q(s.c.a(bArr2, i2, x));
        }
        this.c += x;
        return qVar;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int c() {
        c(0);
        return x();
    }

    public final void b(int i) {
        if (this.c != i) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void c(List list) {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int x = this.c + x();
                    while (this.c < x) {
                        a1Var.c(w.b(x()));
                    }
                    return;
                }
                int i4 = n1.f1688a;
                throw new m1();
            }
            do {
                c(0);
                a1Var.c(w.b(x()));
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int x2 = this.c + x();
                while (this.c < x2) {
                    list.add(Integer.valueOf(w.b(x())));
                }
                return;
            }
            int i6 = n1.f1688a;
            throw new m1();
        }
        do {
            c(0);
            list.add(Integer.valueOf(w.b(x())));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void d(List list) {
        int i;
        int i2;
        if (list instanceof q0) {
            q0 q0Var = (q0) list;
            int i3 = this.e & 7;
            if (i3 == 2) {
                int x = x();
                d(x);
                int i4 = this.c + x;
                while (this.c < i4) {
                    q0Var.a(Float.intBitsToFloat(v()));
                }
                return;
            }
            if (i3 == 5) {
                do {
                    q0Var.a(k());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            int i5 = n1.f1688a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 2) {
            int x2 = x();
            d(x2);
            int i7 = this.c + x2;
            while (this.c < i7) {
                list.add(Float.valueOf(Float.intBitsToFloat(v())));
            }
            return;
        }
        if (i6 == 5) {
            do {
                list.add(Float.valueOf(k()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i8 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void a(List list) {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    u1Var.a(y());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int x = this.c + x();
                while (this.c < x) {
                    u1Var.a(y());
                }
                b(x);
                return;
            }
            int i4 = n1.f1688a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Long.valueOf(y()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int x2 = this.c + x();
            while (this.c < x2) {
                list.add(Long.valueOf(y()));
            }
            b(x2);
            return;
        }
        int i6 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void i(List list) {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int x = this.c + x();
                    while (this.c < x) {
                        a1Var.c(x());
                    }
                    return;
                }
                int i4 = n1.f1688a;
                throw new m1();
            }
            do {
                c(0);
                a1Var.c(x());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int x2 = this.c + x();
                while (this.c < x2) {
                    list.add(Integer.valueOf(x()));
                }
                return;
            }
            int i6 = n1.f1688a;
            throw new m1();
        }
        do {
            c(0);
            list.add(Integer.valueOf(x()));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    public final void e(int i) {
        a(i);
        if ((i & 7) != 0) {
            throw new n1("Failed to parse the message.");
        }
    }

    public final void c(int i) {
        if ((this.e & 7) == i) {
            return;
        }
        int i2 = n1.f1688a;
        throw new m1();
    }

    public final void d(int i) {
        a(i);
        if ((i & 3) != 0) {
            throw new n1("Failed to parse the message.");
        }
    }

    public final void a(List list, boolean z) {
        int i;
        int i2;
        if ((this.e & 7) == 2) {
            if ((list instanceof q1) && !z) {
                q1 q1Var = (q1) list;
                do {
                    q1Var.a(a());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            do {
                list.add(a(z));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i3 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void a(List list, t2 t2Var, h0 h0Var) {
        int i;
        int i2 = this.e;
        if ((i2 & 7) == 3) {
            do {
                list.add(c(t2Var, h0Var));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == i2);
            this.c = i;
            return;
        }
        int i3 = n1.f1688a;
        throw new m1();
    }

    public final void a(int i) {
        if (i < 0 || i > this.d - this.c) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}

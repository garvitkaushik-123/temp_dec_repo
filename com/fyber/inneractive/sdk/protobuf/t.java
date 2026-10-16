package com.fyber.inneractive.sdk.protobuf;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class t extends w {
    public final byte[] e;
    public int f;
    public int g;
    public int h;
    public final int i;
    public int j;
    public int k = Integer.MAX_VALUE;

    public t(byte[] bArr, int i, int i2, boolean z) {
        this.e = bArr;
        this.f = i2 + i;
        this.h = i;
        this.i = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(int i) {
        if (this.j != i) {
            throw new n1("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int b() {
        return this.h - this.i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void c(int i) {
        this.k = i;
        z();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final boolean d() {
        return y() != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final double f() {
        return Double.longBitsToDouble(x());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int g() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int h() {
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long i() {
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final float j() {
        return Float.intBitsToFloat(w());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int k() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long l() {
        return y();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int m() {
        int i;
        int i2 = this.h;
        int i3 = this.f;
        if (i3 != i2) {
            byte[] bArr = this.e;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.h = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                            i5 = i9;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                int i12 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i12] < 0) {
                                        i12 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i12] < 0) {
                                                int i13 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i7 = i13;
                                                }
                                            }
                                        }
                                    }
                                }
                                i7 = i12;
                            }
                            i = i11;
                        }
                    }
                    i5 = i7;
                }
                this.h = i5;
                return i;
            }
        }
        long j = 0;
        for (int i14 = 0; i14 < 64; i14 += 7) {
            int i15 = this.h;
            if (i15 == this.f) {
                throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            byte[] bArr2 = this.e;
            this.h = i15 + 1;
            j |= (r3 & Byte.MAX_VALUE) << i14;
            if ((bArr2[i15] & 128) == 0) {
                return (int) j;
            }
        }
        throw new n1("CodedInputStream encountered a malformed varint.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int n() {
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long o() {
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int p() {
        return w.b(m());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long q() {
        return w.a(y());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final String r() {
        int m = m();
        if (m > 0) {
            int i = this.f;
            int i2 = this.h;
            if (m <= i - i2) {
                String str = new String(this.e, i2, m, l1.f1684a);
                this.h += m;
                return str;
            }
        }
        if (m == 0) {
            return "";
        }
        if (m < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final String s() {
        int m = m();
        if (m > 0) {
            int i = this.f;
            int i2 = this.h;
            if (m <= i - i2) {
                String a2 = d4.f1666a.a(this.e, i2, m);
                this.h += m;
                return a2;
            }
        }
        if (m == 0) {
            return "";
        }
        if (m <= 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int t() {
        if (c()) {
            this.j = 0;
            return 0;
        }
        int m = m();
        this.j = m;
        if ((m >>> 3) != 0) {
            return m;
        }
        throw new n1("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int u() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long v() {
        return y();
    }

    public final int w() {
        int i = this.h;
        if (this.f - i < 4) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.e;
        this.h = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long x() {
        int i = this.h;
        if (this.f - i < 8) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.e;
        this.h = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final long y() {
        long j;
        long j2;
        long j3;
        int i = this.h;
        int i2 = this.f;
        long j4 = 0;
        if (i2 != i) {
            byte[] bArr = this.e;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.h = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            j = (-2080896) ^ i9;
                            i4 = i8;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (bArr[i8] << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (bArr[i4] << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (bArr[i10] << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (bArr[i4] << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j3 ^ j6;
                        }
                    }
                }
                this.h = i4;
                return j;
            }
        }
        for (int i12 = 0; i12 < 64; i12 += 7) {
            int i13 = this.h;
            if (i13 == this.f) {
                throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            byte[] bArr2 = this.e;
            this.h = i13 + 1;
            j4 |= (r1 & Byte.MAX_VALUE) << i12;
            if ((bArr2[i13] & 128) == 0) {
                return j4;
            }
        }
        throw new n1("CodedInputStream encountered a malformed varint.");
    }

    public final void z() {
        int i = this.f + this.g;
        this.f = i;
        int i2 = i - this.i;
        int i3 = this.k;
        if (i2 <= i3) {
            this.g = 0;
            return;
        }
        int i4 = i2 - i3;
        this.g = i4;
        this.f = i - i4;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int d(int i) {
        if (i < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = (this.h - this.i) + i;
        int i3 = this.k;
        if (i2 > i3) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.k = i2;
        z();
        return i3;
    }

    public final void f(int i) {
        if (i >= 0) {
            int i2 = this.f;
            int i3 = this.h;
            if (i <= i2 - i3) {
                this.h = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final boolean c() {
        return this.h == this.f;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(int i, c2 c2Var, h0 h0Var) {
        int i2 = this.f1703a;
        if (i2 < this.b) {
            this.f1703a = i2 + 1;
            ((t0) c2Var).a(this, h0Var);
            a((i << 3) | 4);
            this.f1703a--;
            return;
        }
        throw new n1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final boolean e(int i) {
        int t;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f - this.h >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.e;
                    int i4 = this.h;
                    this.h = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw new n1("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                int i5 = this.h;
                if (i5 == this.f) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.e;
                this.h = i5 + 1;
                if (bArr2[i5] < 0) {
                    i3++;
                }
            }
            throw new n1("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i2 == 1) {
            f(8);
            return true;
        }
        if (i2 == 2) {
            f(m());
            return true;
        }
        if (i2 == 3) {
            do {
                t = t();
                if (t == 0) {
                    break;
                }
            } while (e(t));
            a(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            return false;
        }
        if (i2 == 5) {
            f(4);
            return true;
        }
        int i6 = n1.f1688a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(c2 c2Var, h0 h0Var) {
        int m = m();
        if (this.f1703a < this.b) {
            int d = d(m);
            this.f1703a++;
            ((t0) c2Var).a(this, h0Var);
            a(0);
            this.f1703a--;
            this.k = d;
            z();
            return;
        }
        throw new n1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final q e() {
        byte[] bArr;
        int m = m();
        if (m > 0) {
            int i = this.f;
            int i2 = this.h;
            if (m <= i - i2) {
                byte[] bArr2 = this.e;
                q qVar = s.b;
                s.a(i2, i2 + m, bArr2.length);
                q qVar2 = new q(s.c.a(bArr2, i2, m));
                this.h += m;
                return qVar2;
            }
        }
        if (m == 0) {
            return s.b;
        }
        if (m > 0) {
            int i3 = this.f;
            int i4 = this.h;
            if (m <= i3 - i4) {
                int i5 = m + i4;
                this.h = i5;
                bArr = Arrays.copyOfRange(this.e, i4, i5);
                q qVar3 = s.b;
                return new q(bArr);
            }
        }
        if (m > 0) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (m == 0) {
            bArr = l1.b;
            q qVar32 = s.b;
            return new q(bArr);
        }
        throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int a() {
        int i = this.k;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.h - this.i);
    }
}

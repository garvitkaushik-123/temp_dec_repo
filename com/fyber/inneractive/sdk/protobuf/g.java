package com.fyber.inneractive.sdk.protobuf;

import com.google.common.base.Ascii;

/* loaded from: classes4.dex */
public abstract class g {
    public static int a(int i, byte[] bArr, int i2, f fVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            fVar.f1670a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            fVar.f1670a = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            fVar.f1670a = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            fVar.f1670a = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                fVar.f1670a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    public static long b(int i, byte[] bArr) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int c(byte[] bArr, int i, f fVar) {
        int d = d(bArr, i, fVar);
        int i2 = fVar.f1670a;
        if (i2 < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            fVar.c = "";
            return d;
        }
        fVar.c = d4.f1666a.a(bArr, d, i2);
        return d + i2;
    }

    public static int d(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return a(b, bArr, i2, fVar);
        }
        fVar.f1670a = b;
        return i2;
    }

    public static int e(byte[] bArr, int i, f fVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            fVar.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        fVar.b = j2;
        return i3;
    }

    public static int b(byte[] bArr, int i, f fVar) {
        int d = d(bArr, i, fVar);
        int i2 = fVar.f1670a;
        if (i2 < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            fVar.c = "";
            return d;
        }
        fVar.c = new String(bArr, d, i2, l1.f1684a);
        return d + i2;
    }

    public static int c(int i, byte[] bArr, int i2, int i3, k1 k1Var, f fVar) {
        a1 a1Var = (a1) k1Var;
        int d = d(bArr, i2, fVar);
        a1Var.c(fVar.f1670a);
        while (d < i3) {
            int i4 = d + 1;
            byte b = bArr[d];
            if (b >= 0) {
                fVar.f1670a = b;
            } else {
                i4 = a(b, bArr, i4, fVar);
            }
            if (i != fVar.f1670a) {
                break;
            }
            d = i4 + 1;
            byte b2 = bArr[i4];
            if (b2 >= 0) {
                fVar.f1670a = b2;
            } else {
                d = a(b2, bArr, d, fVar);
            }
            a1Var.c(fVar.f1670a);
        }
        return d;
    }

    public static int b(int i, byte[] bArr, int i2, int i3, k1 k1Var, f fVar) {
        int d = d(bArr, i2, fVar);
        int i4 = fVar.f1670a;
        if (i4 < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 == 0) {
            k1Var.add("");
        } else {
            int i5 = d + i4;
            if (d4.f1666a.b(bArr, d, i5)) {
                k1Var.add(new String(bArr, d, i4, l1.f1684a));
                d = i5;
            } else {
                throw new n1("Protocol message had invalid UTF-8.");
            }
        }
        while (d < i3) {
            int i6 = d + 1;
            byte b = bArr[d];
            if (b >= 0) {
                fVar.f1670a = b;
            } else {
                i6 = a(b, bArr, i6, fVar);
            }
            if (i != fVar.f1670a) {
                break;
            }
            d = i6 + 1;
            byte b2 = bArr[i6];
            if (b2 >= 0) {
                fVar.f1670a = b2;
            } else {
                d = a(b2, bArr, d, fVar);
            }
            int i7 = fVar.f1670a;
            if (i7 < 0) {
                throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i7 == 0) {
                k1Var.add("");
            } else {
                int i8 = d + i7;
                if (d4.f1666a.b(bArr, d, i8)) {
                    k1Var.add(new String(bArr, d, i7, l1.f1684a));
                    d = i8;
                } else {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
            }
        }
        return d;
    }

    public static int a(int i, byte[] bArr, int i2, int i3, n3 n3Var, f fVar) {
        if ((i >>> 3) == 0) {
            throw new n1("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int e = e(bArr, i2, fVar);
            n3Var.a(i, Long.valueOf(fVar.b));
            return e;
        }
        if (i4 == 1) {
            n3Var.a(i, Long.valueOf(b(i2, bArr)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int d = d(bArr, i2, fVar);
            int i5 = fVar.f1670a;
            if (i5 >= 0) {
                if (i5 > bArr.length - d) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i5 == 0) {
                    n3Var.a(i, s.b);
                } else {
                    s.a(d, d + i5, bArr.length);
                    n3Var.a(i, new q(s.c.a(bArr, d, i5)));
                }
                return d + i5;
            }
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new n1("Protocol message contained an invalid tag (zero).");
            }
            n3Var.a(i, Integer.valueOf(a(i2, bArr)));
            return i2 + 4;
        }
        n3 n3Var2 = new n3();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int d2 = d(bArr, i2, fVar);
            int i8 = fVar.f1670a;
            if (i8 == i6) {
                i7 = i8;
                i2 = d2;
                break;
            }
            i2 = a(i8, bArr, d2, i3, n3Var2, fVar);
            i7 = i8;
        }
        if (i2 <= i3 && i7 == i6) {
            n3Var.a(i, n3Var2);
            return i2;
        }
        throw new n1("Failed to parse the message.");
    }

    public static int a(int i, byte[] bArr, int i2, int i3, f fVar) {
        if ((i >>> 3) == 0) {
            throw new n1("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return e(bArr, i2, fVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return d(bArr, i2, fVar) + fVar.f1670a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new n1("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = d(bArr, i2, fVar);
            i6 = fVar.f1670a;
            if (i6 == i5) {
                break;
            }
            i2 = a(i6, bArr, i2, i3, fVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new n1("Failed to parse the message.");
        }
        return i2;
    }

    public static int a(int i, byte[] bArr) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int a(byte[] bArr, int i, f fVar) {
        int d = d(bArr, i, fVar);
        int i2 = fVar.f1670a;
        if (i2 >= 0) {
            if (i2 > bArr.length - d) {
                throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i2 == 0) {
                fVar.c = s.b;
                return d;
            }
            int i3 = d + i2;
            s.a(d, i3, bArr.length);
            fVar.c = new q(s.c.a(bArr, d, i2));
            return i3;
        }
        throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static int a(t2 t2Var, byte[] bArr, int i, int i2, f fVar) {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = a(i4, bArr, i3, fVar);
            i4 = fVar.f1670a;
        }
        int i5 = i3;
        if (i4 >= 0 && i4 <= i2 - i5) {
            Object a2 = t2Var.a();
            int i6 = i5 + i4;
            t2Var.a(a2, bArr, i5, i6, fVar);
            t2Var.c(a2);
            fVar.c = a2;
            return i6;
        }
        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int a(t2 t2Var, byte[] bArr, int i, int i2, int i3, f fVar) {
        i2 i2Var = (i2) t2Var;
        Object a2 = i2Var.a();
        int a3 = i2Var.a(a2, bArr, i, i2, i3, fVar);
        i2Var.c(a2);
        fVar.c = a2;
        return a3;
    }

    public static int a(byte[] bArr, int i, k1 k1Var, f fVar) {
        a1 a1Var = (a1) k1Var;
        int d = d(bArr, i, fVar);
        int i2 = fVar.f1670a + d;
        while (d < i2) {
            int i3 = d + 1;
            byte b = bArr[d];
            if (b >= 0) {
                fVar.f1670a = b;
                d = i3;
            } else {
                d = a(b, bArr, i3, fVar);
            }
            a1Var.c(fVar.f1670a);
        }
        if (d == i2) {
            return d;
        }
        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int a(int i, byte[] bArr, int i2, int i3, k1 k1Var, f fVar) {
        int d = d(bArr, i2, fVar);
        int i4 = fVar.f1670a;
        if (i4 < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i4 == 0) {
            k1Var.add("");
        } else {
            k1Var.add(new String(bArr, d, i4, l1.f1684a));
            d += i4;
        }
        while (d < i3) {
            int i5 = d + 1;
            byte b = bArr[d];
            if (b >= 0) {
                fVar.f1670a = b;
            } else {
                i5 = a(b, bArr, i5, fVar);
            }
            if (i != fVar.f1670a) {
                break;
            }
            d = i5 + 1;
            byte b2 = bArr[i5];
            if (b2 >= 0) {
                fVar.f1670a = b2;
            } else {
                d = a(b2, bArr, d, fVar);
            }
            int i6 = fVar.f1670a;
            if (i6 < 0) {
                throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i6 == 0) {
                k1Var.add("");
            } else {
                k1Var.add(new String(bArr, d, i6, l1.f1684a));
                d += i6;
            }
        }
        return d;
    }
}

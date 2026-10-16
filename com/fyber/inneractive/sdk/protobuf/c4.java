package com.fyber.inneractive.sdk.protobuf;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class c4 extends z3 {
    public static int a(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            z3 z3Var = d4.f1666a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i2 == 1) {
            return d4.a(i, x3.c.b(bArr, x3.f + j));
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        w3 w3Var = x3.c;
        long j2 = x3.f;
        return d4.a(i, w3Var.b(bArr, j2 + j), w3Var.b(bArr, j + 1 + j2));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final String b(ByteBuffer byteBuffer, int i, int i2) {
        long j;
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        long j2 = x3.c.f1707a.getLong(byteBuffer, x3.g) + i;
        long j3 = i2 + j2;
        char[] cArr = new char[i2];
        int i3 = 0;
        while (true) {
            j = 1;
            if (j2 >= j3) {
                break;
            }
            byte a2 = x3.c.a(j2);
            if (!y3.a(a2)) {
                break;
            }
            j2++;
            cArr[i3] = (char) a2;
            i3++;
        }
        int i4 = i3;
        while (j2 < j3) {
            long j4 = j2 + j;
            w3 w3Var = x3.c;
            byte a3 = w3Var.a(j2);
            if (y3.a(a3)) {
                cArr[i4] = (char) a3;
                i4++;
                j2 = j4;
                while (j2 < j3) {
                    byte a4 = x3.c.a(j2);
                    if (!y3.a(a4)) {
                        break;
                    }
                    j2 += j;
                    cArr[i4] = (char) a4;
                    i4++;
                }
            } else if (a3 < -32) {
                if (j4 >= j3) {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
                j2 += 2;
                y3.a(a3, w3Var.a(j4), cArr, i4);
                i4++;
            } else if (a3 < -16) {
                if (j4 >= j3 - j) {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
                long j5 = j2 + 2;
                j2 += 3;
                y3.a(a3, w3Var.a(j4), w3Var.a(j5), cArr, i4);
                i4++;
            } else {
                if (j4 >= j3 - 2) {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
                byte a5 = w3Var.a(j4);
                long j6 = j2 + 3;
                byte a6 = w3Var.a(j2 + 2);
                j2 += 4;
                y3.a(a3, a5, a6, w3Var.a(j6), cArr, i4);
                i4 += 2;
                j = 1;
            }
        }
        return new String(cArr, 0, i4);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final int c(byte[] bArr, int i, int i2) {
        int i3;
        long j;
        if ((i | i2 | (bArr.length - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        long j2 = i;
        int i4 = (int) (i2 - j2);
        byte b = 0;
        long j3 = 1;
        if (i4 >= 16) {
            long j4 = j2;
            i3 = 0;
            while (true) {
                if (i3 >= i4) {
                    i3 = i4;
                    break;
                }
                long j5 = j4 + 1;
                if (x3.c.b(bArr, x3.f + j4) < 0) {
                    break;
                }
                i3++;
                j4 = j5;
            }
        } else {
            i3 = 0;
        }
        int i5 = i4 - i3;
        long j6 = j2 + i3;
        while (true) {
            byte b2 = b;
            while (true) {
                if (i5 <= 0) {
                    break;
                }
                long j7 = j6 + j3;
                b2 = x3.c.b(bArr, x3.f + j6);
                if (b2 < 0) {
                    j6 = j7;
                    break;
                }
                i5--;
                j6 = j7;
            }
            if (i5 == 0) {
                return b;
            }
            int i6 = i5 - 1;
            if (b2 >= -32) {
                if (b2 >= -16) {
                    j = j3;
                    if (i6 < 3) {
                        return a(bArr, b2, j6, i6);
                    }
                    i5 -= 4;
                    long j8 = j6 + j;
                    w3 w3Var = x3.c;
                    long j9 = x3.f;
                    byte b3 = w3Var.b(bArr, j9 + j6);
                    if (b3 > -65) {
                        return -1;
                    }
                    if ((((b3 + 112) + (b2 << Ascii.FS)) >> 30) != 0) {
                        return -1;
                    }
                    long j10 = 2 + j6;
                    if (w3Var.b(bArr, j8 + j9) > -65) {
                        return -1;
                    }
                    j6 += 3;
                    if (w3Var.b(bArr, j9 + j10) > -65) {
                        return -1;
                    }
                } else {
                    if (i6 < 2) {
                        return a(bArr, b2, j6, i6);
                    }
                    i5 -= 3;
                    long j11 = j6 + j3;
                    w3 w3Var2 = x3.c;
                    long j12 = x3.f;
                    j = j3;
                    byte b4 = w3Var2.b(bArr, j12 + j6);
                    if (b4 > -65) {
                        return -1;
                    }
                    if (b2 == -32 && b4 < -96) {
                        return -1;
                    }
                    if (b2 == -19 && b4 >= -96) {
                        return -1;
                    }
                    j6 += 2;
                    if (w3Var2.b(bArr, j12 + j11) > -65) {
                        return -1;
                    }
                }
                j3 = j;
                b = 0;
            } else {
                if (i6 == 0) {
                    return b2;
                }
                i5 -= 2;
                if (b2 < -62) {
                    return -1;
                }
                long j13 = j6 + j3;
                if (x3.c.b(bArr, x3.f + j6) > -65) {
                    return -1;
                }
                j6 = j13;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final String a(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = i;
            int i5 = 0;
            while (i4 < i3) {
                byte b = x3.c.b(bArr, x3.f + i4);
                if (!y3.a(b)) {
                    break;
                }
                i4++;
                cArr[i5] = (char) b;
                i5++;
            }
            int i6 = i5;
            while (i4 < i3) {
                int i7 = i4 + 1;
                w3 w3Var = x3.c;
                long j = x3.f;
                byte b2 = w3Var.b(bArr, i4 + j);
                if (y3.a(b2)) {
                    cArr[i6] = (char) b2;
                    i6++;
                    i4 = i7;
                    while (i4 < i3) {
                        byte b3 = x3.c.b(bArr, x3.f + i4);
                        if (!y3.a(b3)) {
                            break;
                        }
                        i4++;
                        cArr[i6] = (char) b3;
                        i6++;
                    }
                } else if (b2 < -32) {
                    if (i7 < i3) {
                        i4 += 2;
                        y3.a(b2, w3Var.b(bArr, j + i7), cArr, i6);
                        i6++;
                    } else {
                        throw new n1("Protocol message had invalid UTF-8.");
                    }
                } else if (b2 < -16) {
                    if (i7 < i3 - 1) {
                        int i8 = i4 + 2;
                        i4 += 3;
                        y3.a(b2, w3Var.b(bArr, i7 + j), w3Var.b(bArr, j + i8), cArr, i6);
                        i6++;
                    } else {
                        throw new n1("Protocol message had invalid UTF-8.");
                    }
                } else if (i7 < i3 - 2) {
                    y3.a(b2, w3Var.b(bArr, i7 + j), w3Var.b(bArr, i4 + 2 + j), w3Var.b(bArr, j + i4 + 3), cArr, i6);
                    i6 += 2;
                    i4 += 4;
                } else {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        char c;
        long j2;
        long j3;
        int i3;
        char c2;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
        }
        int i4 = 0;
        while (true) {
            j = 1;
            c = 128;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            x3.c.a((Object) bArr, x3.f + j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt2 = charSequence.charAt(i4);
            if (charAt2 >= c || j4 >= j5) {
                j2 = j;
                if (charAt2 >= 2048 || j4 > j5 - 2) {
                    long j6 = j4;
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || j6 > j5 - 3) {
                        if (j6 <= j5 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    w3 w3Var = x3.c;
                                    long j7 = x3.f;
                                    w3Var.a((Object) bArr, j7 + j6, (byte) ((codePoint >>> 18) | 240));
                                    c2 = 128;
                                    w3Var.a((Object) bArr, j7 + j6 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                    w3Var.a((Object) bArr, j7 + j6 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    w3Var.a((Object) bArr, j7 + j6 + 3, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                    j4 = j6 + 4;
                                    i4++;
                                    j = j2;
                                    c = c2;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new b4(i4 - 1, length);
                        }
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new b4(i4, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j6);
                    }
                    w3 w3Var2 = x3.c;
                    long j8 = x3.f;
                    w3Var2.a((Object) bArr, j8 + j6, (byte) ((charAt2 >>> '\f') | 480));
                    w3Var2.a((Object) bArr, j8 + j6 + j2, (byte) (((charAt2 >>> 6) & 63) | 128));
                    w3Var2.a((Object) bArr, j8 + j6 + 2, (byte) ((charAt2 & '?') | 128));
                    j3 = j6 + 3;
                } else {
                    long j9 = j4 + j2;
                    w3 w3Var3 = x3.c;
                    long j10 = x3.f;
                    long j11 = j4;
                    w3Var3.a((Object) bArr, j10 + j11, (byte) ((charAt2 >>> 6) | 960));
                    j4 = j11 + 2;
                    w3Var3.a((Object) bArr, j10 + j9, (byte) ((charAt2 & '?') | 128));
                    c2 = 128;
                    i4++;
                    j = j2;
                    c = c2;
                }
            } else {
                j3 = j4 + j;
                j2 = j;
                x3.c.a((Object) bArr, x3.f + j4, (byte) charAt2);
            }
            j4 = j3;
            c2 = 128;
            i4++;
            j = j2;
            c = c2;
        }
        return (int) j4;
    }
}

package io.bidmachine.iab.utils;

import com.google.common.base.Ascii;
import java.nio.charset.Charset;

/* loaded from: classes7.dex */
public class Base32 {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f6840a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM};

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f6841a;
        byte[] b;
        int c;
        int d;
        boolean e;
        int f;

        private b() {
        }
    }

    private int a(final int x, final int y) {
        int i = x - 2147483648;
        int i2 = y - 2147483648;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public String decode(final String encoded) {
        return decode(encoded.getBytes(Charset.forName("UTF-8")));
    }

    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v20 */
    private void a(final byte[] input, int inPos, final int inAvail, final b context) {
        boolean z;
        byte b2;
        if (context.e) {
            return;
        }
        ?? r3 = 1;
        if (inAvail < 0) {
            context.e = true;
        }
        int i = 0;
        int i2 = inPos;
        while (true) {
            if (i >= inAvail) {
                break;
            }
            int i3 = i2 + 1;
            byte b3 = input[i2];
            if (b3 == 61) {
                context.e = r3;
                break;
            }
            byte[] a2 = a(7, context);
            if (b3 >= 0) {
                byte[] bArr = f6840a;
                if (b3 < bArr.length && (b2 = bArr[b3]) >= 0) {
                    int i4 = (context.f + r3) % 8;
                    context.f = i4;
                    z = r3;
                    context.f6841a = (context.f6841a << 5) + b2;
                    if (i4 == 0) {
                        int i5 = context.c;
                        int i6 = i5 + 1;
                        context.c = i6;
                        a2[i5] = (byte) ((r12 >> 32) & 255);
                        int i7 = i5 + 2;
                        context.c = i7;
                        a2[i6] = (byte) ((r12 >> 24) & 255);
                        int i8 = i5 + 3;
                        context.c = i8;
                        a2[i7] = (byte) ((r12 >> 16) & 255);
                        int i9 = i5 + 4;
                        context.c = i9;
                        a2[i8] = (byte) ((r12 >> 8) & 255);
                        context.c = i5 + 5;
                        a2[i9] = (byte) (r12 & 255);
                    }
                    i++;
                    i2 = i3;
                    r3 = z;
                }
            }
            z = r3;
            i++;
            i2 = i3;
            r3 = z;
        }
        char c = r3;
        if (!context.e || context.f <= 0) {
            return;
        }
        byte[] a3 = a(7, context);
        switch (context.f) {
            case 1:
            case 2:
                int i10 = context.c;
                context.c = i10 + 1;
                a3[i10] = (byte) ((context.f6841a >> 2) & 255);
                return;
            case 3:
                int i11 = context.c;
                context.c = i11 + 1;
                a3[i11] = (byte) ((context.f6841a >> 7) & 255);
                return;
            case 4:
                context.f6841a = context.f6841a >> 4;
                int i12 = context.c;
                int i13 = i12 + 1;
                context.c = i13;
                a3[i12] = (byte) ((r5 >> 12) & 255);
                context.c = i12 + 2;
                a3[i13] = (byte) (r3 & 255);
                return;
            case 5:
                context.f6841a = context.f6841a >> c;
                int i14 = context.c;
                int i15 = i14 + 1;
                context.c = i15;
                a3[i14] = (byte) ((r3 >> 17) & 255);
                int i16 = i14 + 2;
                context.c = i16;
                a3[i15] = (byte) ((r3 >> 9) & 255);
                context.c = i14 + 3;
                a3[i16] = (byte) (r6 & 255);
                return;
            case 6:
                context.f6841a = context.f6841a >> 6;
                int i17 = context.c;
                int i18 = i17 + 1;
                context.c = i18;
                a3[i17] = (byte) ((r3 >> 22) & 255);
                int i19 = i17 + 2;
                context.c = i19;
                a3[i18] = (byte) ((r3 >> 14) & 255);
                context.c = i17 + 3;
                a3[i19] = (byte) (r6 & 255);
                return;
            case 7:
                context.f6841a = context.f6841a >> 3;
                int i20 = context.c;
                int i21 = i20 + 1;
                context.c = i21;
                a3[i20] = (byte) ((r6 >> 27) & 255);
                int i22 = i20 + 2;
                context.c = i22;
                a3[i21] = (byte) ((r6 >> 19) & 255);
                int i23 = i20 + 3;
                context.c = i23;
                a3[i22] = (byte) ((r6 >> 11) & 255);
                context.c = i20 + 4;
                a3[i23] = (byte) (r8 & 255);
                return;
            default:
                throw new IllegalStateException("Impossible modulus " + context.f);
        }
    }

    public String decode(final byte[] encodedBytes) {
        if (encodedBytes == null || encodedBytes.length == 0) {
            return new String(encodedBytes);
        }
        b bVar = new b();
        a(encodedBytes, 0, encodedBytes.length, bVar);
        a(encodedBytes, 0, -1, bVar);
        int i = bVar.c;
        byte[] bArr = new byte[i];
        a(bArr, i, bVar);
        return new String(bArr);
    }

    private byte[] a(final int size, final b context) {
        byte[] bArr = context.b;
        if (bArr == null) {
            context.b = new byte[Math.max(size, 8192)];
            context.c = 0;
            context.d = 0;
        } else {
            int i = context.c + size;
            if (i - bArr.length > 0) {
                return a(context, i);
            }
        }
        return context.b;
    }

    private byte[] a(final b context, final int minCapacity) {
        int length = context.b.length * 2;
        if (a(length, minCapacity) < 0) {
            length = minCapacity;
        }
        if (a(length, 2147483639) > 0) {
            length = Math.max(minCapacity, 2147483639);
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = context.b;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        context.b = bArr;
        return bArr;
    }

    private void a(final byte[] b2, final int bAvail, final b context) {
        if (context.b != null) {
            int min = Math.min(a(context), bAvail);
            System.arraycopy(context.b, context.d, b2, 0, min);
            int i = context.d + min;
            context.d = i;
            if (i >= context.c) {
                context.b = null;
            }
        }
    }

    private int a(final b context) {
        if (context.b != null) {
            return context.c - context.d;
        }
        return 0;
    }
}

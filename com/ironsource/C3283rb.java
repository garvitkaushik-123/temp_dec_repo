package com.ironsource;

import java.io.UnsupportedEncodingException;

/* renamed from: com.ironsource.rb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3283rb {
    private static final byte[] d = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    private a f3679a;
    private a b;
    private int[] c = new int[16];

    C3283rb() {
        this.f3679a = new a();
        this.b = new a();
        c();
    }

    private static int a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & i2) | (i4 & (~i2))) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & (~i4)) | (i2 & i4)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 ^ i2) ^ i4) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int d(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + (i3 ^ ((~i4) | i2)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    public byte[] a() {
        a aVar = this.b;
        if (!aVar.f3680a) {
            aVar.a(this.f3679a);
            a aVar2 = this.b;
            long j = aVar2.c;
            int i = (int) ((j >>> 3) & 63);
            a(aVar2, d, 0, i < 56 ? 56 - i : 120 - i);
            a(this.b, a(j), 0, 8);
            this.b.f3680a = true;
        }
        return a(this.b.b, 16);
    }

    public String b() {
        return a(a());
    }

    public void c() {
        this.f3679a.a();
        this.b.f3680a = false;
    }

    public String toString() {
        return b();
    }

    public void b(byte[] bArr, int i, int i2) {
        a(this.f3679a, bArr, i, i2);
    }

    public void b(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public void b(String str) {
        b(str.getBytes());
    }

    /* renamed from: com.ironsource.rb$a */
    private class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3680a;
        private int[] b;
        private long c;
        private byte[] d;

        private a() {
            this.f3680a = true;
            this.b = new int[4];
            this.d = new byte[64];
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            int[] iArr = this.b;
            iArr[0] = 1732584193;
            iArr[1] = -271733879;
            iArr[2] = -1732584194;
            iArr[3] = 271733878;
            this.c = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(a aVar) {
            byte[] bArr = aVar.d;
            byte[] bArr2 = this.d;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            int[] iArr = aVar.b;
            int[] iArr2 = this.b;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            this.f3680a = aVar.f3680a;
            this.c = aVar.c;
        }
    }

    public static String a(String str) {
        C3283rb c3283rb = new C3283rb();
        c3283rb.b(str);
        return c3283rb.b();
    }

    private void a(a aVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.b.f3680a = false;
        if (i2 + i > bArr.length) {
            i2 = bArr.length - i;
        }
        long j = aVar.c;
        int i4 = ((int) (j >>> 3)) & 63;
        aVar.c = j + (i2 << 3);
        int i5 = 64 - i4;
        if (i2 >= i5) {
            System.arraycopy(bArr, i, aVar.d, i4, i5);
            a(aVar, a(aVar.d, 64, 0));
            while (i5 + 63 < i2) {
                a(aVar, a(bArr, 64, i5));
                i5 += 64;
            }
            i4 = 0;
            i3 = i5;
        }
        if (i3 < i2) {
            for (int i6 = i3; i6 < i2; i6++) {
                aVar.d[(i4 + i6) - i3] = bArr[i6 + i];
            }
        }
    }

    public void a(byte[] bArr, int i) {
        b(bArr, 0, i);
    }

    public void a(byte b) {
        a(new byte[]{b}, 1);
    }

    public void a(String str, String str2) throws UnsupportedEncodingException {
        b(str.getBytes(str2));
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString();
    }

    private static byte[] a(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >>> 8) & 255), (byte) ((j >>> 16) & 255), (byte) ((j >>> 24) & 255), (byte) ((j >>> 32) & 255), (byte) ((j >>> 40) & 255), (byte) ((j >>> 48) & 255), (byte) ((j >>> 56) & 255)};
    }

    private static byte[] a(int[] iArr, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            int i4 = iArr[i2];
            bArr[i3] = (byte) (i4 & 255);
            bArr[i3 + 1] = (byte) ((i4 >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((i4 >>> 16) & 255);
            bArr[i3 + 3] = (byte) ((i4 >>> 24) & 255);
            i2++;
        }
        return bArr;
    }

    private int[] a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4 += 4) {
            this.c[i3] = (bArr[i4 + i2] & 255) | ((bArr[(i4 + 1) + i2] & 255) << 8) | ((bArr[(i4 + 2) + i2] & 255) << 16) | ((bArr[(i4 + 3) + i2] & 255) << 24);
            i3++;
        }
        return this.c;
    }

    private static void a(a aVar, int[] iArr) {
        int[] iArr2 = aVar.b;
        int i = iArr2[0];
        int i2 = iArr2[1];
        int i3 = iArr2[2];
        int i4 = iArr2[3];
        int a2 = a(i, i2, i3, i4, iArr[0], 7, -680876936);
        int a3 = a(i4, a2, i2, i3, iArr[1], 12, -389564586);
        int a4 = a(i3, a3, a2, i2, iArr[2], 17, 606105819);
        int a5 = a(i2, a4, a3, a2, iArr[3], 22, -1044525330);
        int a6 = a(a2, a5, a4, a3, iArr[4], 7, -176418897);
        int a7 = a(a3, a6, a5, a4, iArr[5], 12, 1200080426);
        int a8 = a(a4, a7, a6, a5, iArr[6], 17, -1473231341);
        int a9 = a(a5, a8, a7, a6, iArr[7], 22, -45705983);
        int a10 = a(a6, a9, a8, a7, iArr[8], 7, 1770035416);
        int a11 = a(a7, a10, a9, a8, iArr[9], 12, -1958414417);
        int a12 = a(a8, a11, a10, a9, iArr[10], 17, -42063);
        int a13 = a(a9, a12, a11, a10, iArr[11], 22, -1990404162);
        int a14 = a(a10, a13, a12, a11, iArr[12], 7, 1804603682);
        int a15 = a(a11, a14, a13, a12, iArr[13], 12, -40341101);
        int a16 = a(a12, a15, a14, a13, iArr[14], 17, -1502002290);
        int a17 = a(a13, a16, a15, a14, iArr[15], 22, 1236535329);
        int b = b(a14, a17, a16, a15, iArr[1], 5, -165796510);
        int b2 = b(a15, b, a17, a16, iArr[6], 9, -1069501632);
        int b3 = b(a16, b2, b, a17, iArr[11], 14, 643717713);
        int b4 = b(a17, b3, b2, b, iArr[0], 20, -373897302);
        int b5 = b(b, b4, b3, b2, iArr[5], 5, -701558691);
        int b6 = b(b2, b5, b4, b3, iArr[10], 9, 38016083);
        int b7 = b(b3, b6, b5, b4, iArr[15], 14, -660478335);
        int b8 = b(b4, b7, b6, b5, iArr[4], 20, -405537848);
        int b9 = b(b5, b8, b7, b6, iArr[9], 5, 568446438);
        int b10 = b(b6, b9, b8, b7, iArr[14], 9, -1019803690);
        int b11 = b(b7, b10, b9, b8, iArr[3], 14, -187363961);
        int b12 = b(b8, b11, b10, b9, iArr[8], 20, 1163531501);
        int b13 = b(b9, b12, b11, b10, iArr[13], 5, -1444681467);
        int b14 = b(b10, b13, b12, b11, iArr[2], 9, -51403784);
        int b15 = b(b11, b14, b13, b12, iArr[7], 14, 1735328473);
        int b16 = b(b12, b15, b14, b13, iArr[12], 20, -1926607734);
        int c = c(b13, b16, b15, b14, iArr[5], 4, -378558);
        int c2 = c(b14, c, b16, b15, iArr[8], 11, -2022574463);
        int c3 = c(b15, c2, c, b16, iArr[11], 16, 1839030562);
        int c4 = c(b16, c3, c2, c, iArr[14], 23, -35309556);
        int c5 = c(c, c4, c3, c2, iArr[1], 4, -1530992060);
        int c6 = c(c2, c5, c4, c3, iArr[4], 11, 1272893353);
        int c7 = c(c3, c6, c5, c4, iArr[7], 16, -155497632);
        int c8 = c(c4, c7, c6, c5, iArr[10], 23, -1094730640);
        int c9 = c(c5, c8, c7, c6, iArr[13], 4, 681279174);
        int c10 = c(c6, c9, c8, c7, iArr[0], 11, -358537222);
        int c11 = c(c7, c10, c9, c8, iArr[3], 16, -722521979);
        int c12 = c(c8, c11, c10, c9, iArr[6], 23, 76029189);
        int c13 = c(c9, c12, c11, c10, iArr[9], 4, -640364487);
        int c14 = c(c10, c13, c12, c11, iArr[12], 11, -421815835);
        int c15 = c(c11, c14, c13, c12, iArr[15], 16, 530742520);
        int c16 = c(c12, c15, c14, c13, iArr[2], 23, -995338651);
        int d2 = d(c13, c16, c15, c14, iArr[0], 6, -198630844);
        int d3 = d(c14, d2, c16, c15, iArr[7], 10, 1126891415);
        int d4 = d(c15, d3, d2, c16, iArr[14], 15, -1416354905);
        int d5 = d(c16, d4, d3, d2, iArr[5], 21, -57434055);
        int d6 = d(d2, d5, d4, d3, iArr[12], 6, 1700485571);
        int d7 = d(d3, d6, d5, d4, iArr[3], 10, -1894986606);
        int d8 = d(d4, d7, d6, d5, iArr[10], 15, -1051523);
        int d9 = d(d5, d8, d7, d6, iArr[1], 21, -2054922799);
        int d10 = d(d6, d9, d8, d7, iArr[8], 6, 1873313359);
        int d11 = d(d7, d10, d9, d8, iArr[15], 10, -30611744);
        int d12 = d(d8, d11, d10, d9, iArr[6], 15, -1560198380);
        int d13 = d(d9, d12, d11, d10, iArr[13], 21, 1309151649);
        int d14 = d(d10, d13, d12, d11, iArr[4], 6, -145523070);
        int d15 = d(d11, d14, d13, d12, iArr[11], 10, -1120210379);
        int d16 = d(d12, d15, d14, d13, iArr[2], 15, 718787259);
        int d17 = d(d13, d16, d15, d14, iArr[9], 21, -343485551);
        int[] iArr3 = aVar.b;
        iArr3[0] = iArr3[0] + d14;
        iArr3[1] = iArr3[1] + d17;
        iArr3[2] = iArr3[2] + d16;
        iArr3[3] = iArr3[3] + d15;
    }
}

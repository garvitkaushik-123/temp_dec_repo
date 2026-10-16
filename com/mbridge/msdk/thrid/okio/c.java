package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.text.Typography;

/* compiled from: Buffer.java */
/* loaded from: classes6.dex */
public final class c implements e, d, Cloneable, ByteChannel {
    private static final byte[] c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a, reason: collision with root package name */
    o f4899a;
    long b;

    /* compiled from: Buffer.java */
    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(c.this.b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            c cVar = c.this;
            if (cVar.b > 0) {
                return cVar.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return c.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return c.this.read(bArr, i, i2);
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.e, com.mbridge.msdk.thrid.okio.d
    public c a() {
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public f b(long j) throws EOFException {
        return new f(c(j));
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public String c() throws EOFException {
        return d(Long.MAX_VALUE);
    }

    @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public String d(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long a2 = a((byte) 10, 0L, j2);
        if (a2 != -1) {
            return h(a2);
        }
        if (j2 < size() && f(j2 - 1) == 13 && f(j2) == 10) {
            return h(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + cVar.o().b() + Typography.ellipsis);
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void e(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.b;
        if (j != cVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        o oVar = this.f4899a;
        o oVar2 = cVar.f4899a;
        int i = oVar.b;
        int i2 = oVar2.b;
        while (j2 < this.b) {
            long min = Math.min(oVar.c - i, oVar2.c - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (oVar.f4912a[i] != oVar2.f4912a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == oVar.c) {
                oVar = oVar.f;
                i = oVar.b;
            }
            if (i2 == oVar2.c) {
                oVar2 = oVar2.f;
                i2 = oVar2.b;
            }
            j2 += min;
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public boolean f() {
        return this.b == 0;
    }

    @Override // com.mbridge.msdk.thrid.okio.d, com.mbridge.msdk.thrid.okio.r, java.io.Flushable
    public void flush() {
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public short g() {
        return u.a(readShort());
    }

    String h(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (f(j2) == 13) {
                String g = g(j2);
                skip(2L);
                return g;
            }
        }
        String g2 = g(j);
        skip(1L);
        return g2;
    }

    public int hashCode() {
        o oVar = this.f4899a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.c;
            for (int i3 = oVar.b; i3 < i2; i3++) {
                i = (i * 31) + oVar.f4912a[i3];
            }
            oVar = oVar.f;
        } while (oVar != this.f4899a);
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[EDGE_INSN: B:40:0x009e->B:37:0x009e BREAK  A[LOOP:0: B:4:0x000b->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    @Override // com.mbridge.msdk.thrid.okio.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long i() {
        int i;
        if (this.b == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            o oVar = this.f4899a;
            byte[] bArr = oVar.f4912a;
            int i3 = oVar.b;
            int i4 = oVar.c;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else if (b >= 65 && b <= 70) {
                    i = b - 55;
                } else {
                    if (i2 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                    }
                    z = true;
                    if (i3 != i4) {
                        this.f4899a = oVar.b();
                        p.a(oVar);
                    } else {
                        oVar.b = i3;
                    }
                    if (!z) {
                        break;
                    }
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new c().a(j).writeByte((int) b).p());
                }
                j = (j << 4) | i;
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z) {
            }
        } while (this.f4899a != null);
        this.b -= i2;
        return j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public InputStream j() {
        return new a();
    }

    public final void k() {
        try {
            skip(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.b == 0) {
            return cVar;
        }
        o c2 = this.f4899a.c();
        cVar.f4899a = c2;
        c2.g = c2;
        c2.f = c2;
        for (o oVar = this.f4899a.f; oVar != this.f4899a; oVar = oVar.f) {
            cVar.f4899a.g.a(oVar.c());
        }
        cVar.b = this.b;
        return cVar;
    }

    public final long m() {
        long j = this.b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.f4899a.g;
        return (oVar.c >= 8192 || !oVar.e) ? j : j - (r3 - oVar.b);
    }

    public byte[] n() {
        try {
            return c(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public f o() {
        return new f(n());
    }

    public String p() {
        try {
            return a(this.b, u.f4915a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final f q() {
        long j = this.b;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    public int read(byte[] bArr, int i, int i2) {
        u.a(bArr.length, i, i2);
        o oVar = this.f4899a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(i2, oVar.c - oVar.b);
        System.arraycopy(oVar.f4912a, oVar.b, bArr, i, min);
        int i3 = oVar.b + min;
        oVar.b = i3;
        this.b -= min;
        if (i3 == oVar.c) {
            this.f4899a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public byte readByte() {
        long j = this.b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f4899a;
        int i = oVar.b;
        int i2 = oVar.c;
        int i3 = i + 1;
        byte b = oVar.f4912a[i];
        this.b = j - 1;
        if (i3 != i2) {
            oVar.b = i3;
            return b;
        }
        this.f4899a = oVar.b();
        p.a(oVar);
        return b;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public int readInt() {
        long j = this.b;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        o oVar = this.f4899a;
        int i = oVar.b;
        int i2 = oVar.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = oVar.f4912a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.b = j - 4;
        if (i5 != i2) {
            oVar.b = i5;
            return i6;
        }
        this.f4899a = oVar.b();
        p.a(oVar);
        return i6;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public short readShort() {
        long j = this.b;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        o oVar = this.f4899a;
        int i = oVar.b;
        int i2 = oVar.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = oVar.f4912a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.b = j - 2;
        if (i5 == i2) {
            this.f4899a = oVar.b();
            p.a(oVar);
        } else {
            oVar.b = i5;
        }
        return (short) i6;
    }

    public final long size() {
        return this.b;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.f4899a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.c - r0.b);
            long j2 = min;
            this.b -= j2;
            j -= j2;
            o oVar = this.f4899a;
            int i = oVar.b + min;
            oVar.b = i;
            if (i == oVar.c) {
                this.f4899a = oVar.b();
                p.a(oVar);
            }
        }
    }

    public String toString() {
        return q().toString();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(String str) {
        return a(str, 0, str.length());
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public byte[] c(long j) throws EOFException {
        u.a(this.b, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public int e() {
        return u.a(readInt());
    }

    public final byte f(long j) {
        u.a(this.b, j, 1L);
        long j2 = this.b;
        if (j2 - j > j) {
            o oVar = this.f4899a;
            long j3 = j;
            while (true) {
                int i = oVar.c;
                int i2 = oVar.b;
                long j4 = i - i2;
                if (j3 < j4) {
                    return oVar.f4912a[i2 + ((int) j3)];
                }
                j3 -= j4;
                oVar = oVar.f;
            }
        } else {
            long j5 = j - j2;
            o oVar2 = this.f4899a.g;
            while (true) {
                int i3 = oVar2.c;
                int i4 = oVar2.b;
                j5 += i3 - i4;
                if (j5 >= 0) {
                    return oVar2.f4912a[i4 + ((int) j5)];
                }
                oVar2 = oVar2.g;
            }
        }
    }

    public String g(long j) throws EOFException {
        return a(j, u.f4915a);
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            long j3 = j;
            u.a(this.b, j3, j2);
            if (j2 != 0) {
                cVar.b += j2;
                o oVar = this.f4899a;
                while (true) {
                    long j4 = oVar.c - oVar.b;
                    if (j3 < j4) {
                        break;
                    }
                    j3 -= j4;
                    oVar = oVar.f;
                }
                o oVar2 = oVar;
                long j5 = j2;
                while (j5 > 0) {
                    o c2 = oVar2.c();
                    int i = (int) (c2.b + j3);
                    c2.b = i;
                    c2.c = Math.min(i + ((int) j5), c2.c);
                    o oVar3 = cVar.f4899a;
                    if (oVar3 == null) {
                        c2.g = c2;
                        c2.f = c2;
                        cVar.f4899a = c2;
                    } else {
                        oVar3.g.a(c2);
                    }
                    j5 -= c2.c - c2.b;
                    oVar2 = oVar2.f;
                    j3 = 0;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    o b(int i) {
        if (i >= 1 && i <= 8192) {
            o oVar = this.f4899a;
            if (oVar == null) {
                o a2 = p.a();
                this.f4899a = a2;
                a2.g = a2;
                a2.f = a2;
                return a2;
            }
            o oVar2 = oVar.g;
            return (oVar2.c + i > 8192 || !oVar2.e) ? oVar2.a(p.a()) : oVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c writeShort(int i) {
        o b = b(2);
        byte[] bArr = b.f4912a;
        int i2 = b.c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        b.c = i2 + 2;
        this.b += 2;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                o b = b(1);
                int min = Math.min(i, 8192 - b.c);
                byteBuffer.get(b.f4912a, b.c, min);
                i -= min;
                b.c += min;
            }
            this.b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c writeByte(int i) {
        o b = b(1);
        byte[] bArr = b.f4912a;
        int i2 = b.c;
        b.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.b++;
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public long b(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.a(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c writeInt(int i) {
        o b = b(4);
        byte[] bArr = b.f4912a;
        int i2 = b.c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        b.c = i2 + 4;
        this.b += 4;
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.f4899a;
        if (oVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), oVar.c - oVar.b);
        byteBuffer.put(oVar.f4912a, oVar.b, min);
        int i = oVar.b + min;
        oVar.b = i;
        this.b -= min;
        if (i == oVar.c) {
            this.f4899a = oVar.b();
            p.a(oVar);
        }
        return min;
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public t b() {
        return t.d;
    }

    public c f(int i) {
        if (i < 128) {
            writeByte(i);
            return this;
        }
        if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
            return this;
        }
        if (i >= 65536) {
            if (i <= 1114111) {
                writeByte((i >> 18) | 240);
                writeByte(((i >> 12) & 63) | 128);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
                return this;
            }
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        if (i >= 55296 && i <= 57343) {
            writeByte(63);
            return this;
        }
        writeByte((i >> 12) | 224);
        writeByte(((i >> 6) & 63) | 128);
        writeByte((i & 63) | 128);
        return this;
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        o oVar = this.f4899a;
        int i = oVar.b;
        if (i + j > oVar.c) {
            return new String(c(j), charset);
        }
        String str = new String(oVar.f4912a, i, (int) j, charset);
        int i2 = (int) (oVar.b + j);
        oVar.b = i2;
        this.b -= j;
        if (i2 == oVar.c) {
            this.f4899a = oVar.b();
            p.a(oVar);
        }
        return str;
    }

    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public c a(String str, int i, int i2) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    o b = b(1);
                    byte[] bArr = b.f4912a;
                    int i3 = b.c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) charAt;
                    }
                    int i5 = b.c;
                    int i6 = (i3 + i) - i5;
                    b.c = i5 + i6;
                    this.b += i6;
                } else {
                    if (charAt2 < 2048) {
                        writeByte((charAt2 >> 6) | 192);
                        writeByte((charAt2 & '?') | 128);
                    } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (charAt2 <= 56319 && charAt3 >= 56320 && charAt3 <= 57343) {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i += 2;
                        } else {
                            writeByte(63);
                            i = i7;
                        }
                    } else {
                        writeByte((charAt2 >> '\f') | 224);
                        writeByte(((charAt2 >> 6) & 63) | 128);
                        writeByte((charAt2 & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c a(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o b = b(numberOfTrailingZeros);
        byte[] bArr = b.f4912a;
        int i = b.c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = c[(int) (15 & j)];
            j >>>= 4;
        }
        b.c += numberOfTrailingZeros;
        this.b += numberOfTrailingZeros;
        return this;
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(u.f4915a)) {
                    return a(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return write(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            u.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                o b = b(1);
                int min = Math.min(i3 - i, 8192 - b.c);
                System.arraycopy(bArr, i, b.f4912a, b.c, min);
                i += min;
                b.c += min;
            }
            this.b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = sVar.b(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (b == -1) {
                return j;
            }
            j += b;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public void a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar != this) {
            u.a(cVar.b, 0L, j);
            while (j > 0) {
                o oVar = cVar.f4899a;
                if (j < oVar.c - oVar.b) {
                    o oVar2 = this.f4899a;
                    o oVar3 = oVar2 != null ? oVar2.g : null;
                    if (oVar3 != null && oVar3.e) {
                        if ((oVar3.c + j) - (oVar3.d ? 0 : oVar3.b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            oVar.a(oVar3, (int) j);
                            cVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    cVar.f4899a = oVar.a((int) j);
                }
                o oVar4 = cVar.f4899a;
                long j2 = oVar4.c - oVar4.b;
                cVar.f4899a = oVar4.b();
                o oVar5 = this.f4899a;
                if (oVar5 == null) {
                    this.f4899a = oVar4;
                    oVar4.g = oVar4;
                    oVar4.f = oVar4;
                } else {
                    oVar5.g.a(oVar4).a();
                }
                cVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // com.mbridge.msdk.thrid.okio.e
    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j, long j2) {
        o oVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.b;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (oVar = this.f4899a) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    oVar = oVar.g;
                    j4 -= oVar.c - oVar.b;
                }
            } else {
                while (true) {
                    long j6 = (oVar.c - oVar.b) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    oVar = oVar.f;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = oVar.f4912a;
                int min = (int) Math.min(oVar.c, (oVar.b + j5) - j4);
                for (int i = (int) ((oVar.b + j7) - j4); i < min; i++) {
                    if (bArr[i] == b) {
                        return (i - oVar.b) + j4;
                    }
                }
                j4 += oVar.c - oVar.b;
                oVar = oVar.f;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
    }

    public final f a(int i) {
        if (i == 0) {
            return f.e;
        }
        return new q(this, i);
    }
}

package com.bytedance.sdk.component.DbA.eli.DbA;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class eli implements DbA, Os, Cloneable, ByteChannel {
    private static final byte[] Os = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    long DbA;
    ui eli;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean eli() {
        return this.DbA == 0;
    }

    public byte DbA() {
        if (this.DbA == 0) {
            throw new IllegalStateException("size == 0");
        }
        ui uiVar = this.eli;
        int i = uiVar.DbA;
        int i2 = uiVar.Os;
        int i3 = i + 1;
        byte b = uiVar.eli[i];
        this.DbA--;
        if (i3 == i2) {
            this.eli = uiVar.DbA();
            MGA.eli(uiVar);
            return b;
        }
        uiVar.DbA = i3;
        return b;
    }

    public String Os() {
        try {
            return eli(this.DbA, FC.eli);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String eli(long j, Charset charset) throws EOFException {
        FC.eli(this.DbA, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        ui uiVar = this.eli;
        if (uiVar.DbA + j > uiVar.Os) {
            return new String(eli(j), charset);
        }
        String str = new String(uiVar.eli, uiVar.DbA, (int) j, charset);
        uiVar.DbA = (int) (uiVar.DbA + j);
        this.DbA -= j;
        if (uiVar.DbA == uiVar.Os) {
            this.eli = uiVar.DbA();
            MGA.eli(uiVar);
        }
        return str;
    }

    public byte[] eli(long j) throws EOFException {
        FC.eli(this.DbA, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        eli(bArr);
        return bArr;
    }

    public void eli(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int eli = eli(bArr, i, bArr.length - i);
            if (eli == -1) {
                throw new EOFException();
            }
            i += eli;
        }
    }

    public int eli(byte[] bArr, int i, int i2) {
        FC.eli(bArr.length, i, i2);
        ui uiVar = this.eli;
        if (uiVar == null) {
            return -1;
        }
        int min = Math.min(i2, uiVar.Os - uiVar.DbA);
        System.arraycopy(uiVar.eli, uiVar.DbA, bArr, i, min);
        uiVar.DbA += min;
        this.DbA -= min;
        if (uiVar.DbA == uiVar.Os) {
            this.eli = uiVar.DbA();
            MGA.eli(uiVar);
        }
        return min;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ui uiVar = this.eli;
        if (uiVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), uiVar.Os - uiVar.DbA);
        byteBuffer.put(uiVar.eli, uiVar.DbA, min);
        uiVar.DbA += min;
        this.DbA -= min;
        if (uiVar.DbA == uiVar.Os) {
            this.eli = uiVar.DbA();
            MGA.eli(uiVar);
        }
        return min;
    }

    public eli eli(String str) {
        return eli(str, 0, str.length());
    }

    public eli eli(String str, int i, int i2) {
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (charAt2 < 128) {
                ui Os2 = Os(1);
                byte[] bArr = Os2.eli;
                int i3 = Os2.Os - i;
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
                int i5 = (i3 + i) - Os2.Os;
                Os2.Os += i5;
                this.DbA += i5;
            } else {
                if (charAt2 < 2048) {
                    DbA((charAt2 >> 6) | 192);
                    DbA((charAt2 & '?') | 128);
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    DbA((charAt2 >> '\f') | 224);
                    DbA(((charAt2 >> 6) & 63) | 128);
                    DbA((charAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char charAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        DbA(63);
                        i = i6;
                    } else {
                        int i7 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + 65536;
                        DbA((i7 >> 18) | 240);
                        DbA(((i7 >> 12) & 63) | 128);
                        DbA(((i7 >> 6) & 63) | 128);
                        DbA((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public eli eli(int i) {
        if (i < 128) {
            DbA(i);
            return this;
        }
        if (i < 2048) {
            DbA((i >> 6) | 192);
            DbA((i & 63) | 128);
            return this;
        }
        if (i >= 65536) {
            if (i <= 1114111) {
                DbA((i >> 18) | 240);
                DbA(((i >> 12) & 63) | 128);
                DbA(((i >> 6) & 63) | 128);
                DbA((i & 63) | 128);
                return this;
            }
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        if (i >= 55296 && i <= 57343) {
            DbA(63);
            return this;
        }
        DbA((i >> 12) | 224);
        DbA(((i >> 6) & 63) | 128);
        DbA((i & 63) | 128);
        return this;
    }

    public eli eli(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(FC.eli)) {
            return eli(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return DbA(bytes, 0, bytes.length);
    }

    public eli DbA(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        FC.eli(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            ui Os2 = Os(1);
            int min = Math.min(i3 - i, 8192 - Os2.Os);
            System.arraycopy(bArr, i, Os2.eli, Os2.Os, min);
            i += min;
            Os2.Os += min;
        }
        this.DbA += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            ui Os2 = Os(1);
            int min = Math.min(i, 8192 - Os2.Os);
            byteBuffer.get(Os2.eli, Os2.Os, min);
            i -= min;
            Os2.Os += min;
        }
        this.DbA += remaining;
        return remaining;
    }

    public eli DbA(int i) {
        ui Os2 = Os(1);
        byte[] bArr = Os2.eli;
        int i2 = Os2.Os;
        Os2.Os = i2 + 1;
        bArr[i2] = (byte) i;
        this.DbA++;
        return this;
    }

    public eli DbA(long j) {
        if (j == 0) {
            return DbA(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ui Os2 = Os(numberOfTrailingZeros);
        byte[] bArr = Os2.eli;
        int i = Os2.Os;
        for (int i2 = (Os2.Os + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = Os[(int) (15 & j)];
            j >>>= 4;
        }
        Os2.Os += numberOfTrailingZeros;
        this.DbA += numberOfTrailingZeros;
        return this;
    }

    ui Os(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        ui uiVar = this.eli;
        if (uiVar == null) {
            ui eli = MGA.eli();
            this.eli = eli;
            eli.kb = eli;
            eli.MGA = eli;
            return eli;
        }
        ui uiVar2 = uiVar.kb;
        return (uiVar2.Os + i > 8192 || !uiVar2.ui) ? uiVar2.eli(MGA.eli()) : uiVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof eli)) {
            return false;
        }
        eli eliVar = (eli) obj;
        long j = this.DbA;
        if (j != eliVar.DbA) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        ui uiVar = this.eli;
        ui uiVar2 = eliVar.eli;
        int i = uiVar.DbA;
        int i2 = uiVar2.DbA;
        while (j2 < this.DbA) {
            long min = Math.min(uiVar.Os - i, uiVar2.Os - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (uiVar.eli[i] != uiVar2.eli[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == uiVar.Os) {
                uiVar = uiVar.MGA;
                i = uiVar.DbA;
            }
            if (i2 == uiVar2.Os) {
                uiVar2 = uiVar2.MGA;
                i2 = uiVar2.DbA;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        ui uiVar = this.eli;
        if (uiVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = uiVar.Os;
            for (int i3 = uiVar.DbA; i3 < i2; i3++) {
                i = (i * 31) + uiVar.eli[i3];
            }
            uiVar = uiVar.MGA;
        } while (uiVar != this.eli);
        return i;
    }

    public String toString() {
        return ui().toString();
    }

    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public eli clone() {
        eli eliVar = new eli();
        if (this.DbA == 0) {
            return eliVar;
        }
        ui eli = this.eli.eli();
        eliVar.eli = eli;
        eli.kb = eli;
        eli.MGA = eli;
        ui uiVar = this.eli;
        while (true) {
            uiVar = uiVar.MGA;
            if (uiVar != this.eli) {
                eliVar.eli.kb.eli(uiVar.eli());
            } else {
                eliVar.DbA = this.DbA;
                return eliVar;
            }
        }
    }

    public final aGH ui() {
        long j = this.DbA;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.DbA);
        }
        return aGH((int) j);
    }

    public final aGH aGH(int i) {
        if (i == 0) {
            return aGH.Os;
        }
        return new kb(this, i);
    }
}

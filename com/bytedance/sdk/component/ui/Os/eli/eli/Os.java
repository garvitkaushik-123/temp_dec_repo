package com.bytedance.sdk.component.ui.Os.eli.eli;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
class Os implements Closeable {
    private final Charset DbA;
    private byte[] Os;
    private int aGH;
    private final InputStream eli;
    private int ui;

    public Os(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public Os(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(aGH.eli)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.eli = inputStream;
        this.DbA = charset;
        this.Os = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.eli) {
            if (this.Os != null) {
                this.Os = null;
                this.eli.close();
            }
        }
    }

    public String eli() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.eli) {
            if (this.Os == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.aGH >= this.ui) {
                Os();
            }
            for (int i3 = this.aGH; i3 != this.ui; i3++) {
                byte[] bArr2 = this.Os;
                if (bArr2[i3] == 10) {
                    if (i3 != this.aGH) {
                        i2 = i3 - 1;
                        if (bArr2[i2] == 13) {
                            byte[] bArr3 = this.Os;
                            int i4 = this.aGH;
                            String str = new String(bArr3, i4, i2 - i4, this.DbA.name());
                            this.aGH = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    byte[] bArr32 = this.Os;
                    int i42 = this.aGH;
                    String str2 = new String(bArr32, i42, i2 - i42, this.DbA.name());
                    this.aGH = i3 + 1;
                    return str2;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.ui - this.aGH) + 80) { // from class: com.bytedance.sdk.component.ui.Os.eli.eli.Os.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, Os.this.DbA.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr4 = this.Os;
                int i5 = this.aGH;
                byteArrayOutputStream.write(bArr4, i5, this.ui - i5);
                this.ui = -1;
                Os();
                i = this.aGH;
                while (i != this.ui) {
                    bArr = this.Os;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.aGH;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.aGH = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    public boolean DbA() {
        return this.ui == -1;
    }

    private void Os() throws IOException {
        InputStream inputStream = this.eli;
        byte[] bArr = this.Os;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.aGH = 0;
        this.ui = read;
    }
}

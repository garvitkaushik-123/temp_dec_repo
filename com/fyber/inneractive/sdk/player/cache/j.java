package com.fyber.inneractive.sdk.player.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class j implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f1352a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    public j(FileInputStream fileInputStream) {
        Charset charset = k.f1353a;
        charset.getClass();
        if (!charset.equals(charset)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f1352a = fileInputStream;
        this.b = charset;
        this.c = new byte[8192];
    }

    public final String a() {
        int i;
        synchronized (this.f1352a) {
            byte[] bArr = this.c;
            if (bArr == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                int read = this.f1352a.read(bArr, 0, bArr.length);
                if (read == -1) {
                    throw new EOFException();
                }
                this.d = 0;
                this.e = read;
            }
            for (int i2 = this.d; i2 != this.e; i2++) {
                byte[] bArr2 = this.c;
                if (bArr2[i2] == 10) {
                    int i3 = this.d;
                    if (i2 != i3) {
                        i = i2 - 1;
                        if (bArr2[i] == 13) {
                            String str = new String(bArr2, i3, i - i3, this.b.name());
                            this.d = i2 + 1;
                            return str;
                        }
                    }
                    i = i2;
                    String str2 = new String(bArr2, i3, i - i3, this.b.name());
                    this.d = i2 + 1;
                    return str2;
                }
            }
            i iVar = new i(this, (this.e - this.d) + 80);
            while (true) {
                byte[] bArr3 = this.c;
                int i4 = this.d;
                iVar.write(bArr3, i4, this.e - i4);
                this.e = -1;
                InputStream inputStream = this.f1352a;
                byte[] bArr4 = this.c;
                int read2 = inputStream.read(bArr4, 0, bArr4.length);
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.d = 0;
                this.e = read2;
                for (int i5 = 0; i5 != this.e; i5++) {
                    byte[] bArr5 = this.c;
                    if (bArr5[i5] == 10) {
                        int i6 = this.d;
                        if (i5 != i6) {
                            iVar.write(bArr5, i6, i5 - i6);
                        }
                        this.d = i5 + 1;
                        return iVar.toString();
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f1352a) {
            if (this.c != null) {
                this.c = null;
                this.f1352a.close();
            }
        }
    }
}

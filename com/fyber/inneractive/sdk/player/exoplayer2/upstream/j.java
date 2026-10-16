package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import java.io.InputStream;

/* loaded from: classes4.dex */
public final class j extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final h f1569a;
    public final k b;
    public long f;
    public boolean d = false;
    public boolean e = false;
    public final byte[] c = new byte[1];

    public j(h hVar, k kVar) {
        this.f1569a = hVar;
        this.b = kVar;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.e) {
            return;
        }
        this.f1569a.close();
        this.e = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.c;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (!this.e) {
            if (!this.d) {
                this.f1569a.a(this.b);
                this.d = true;
            }
            int read = this.f1569a.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.f += read;
            return read;
        }
        throw new IllegalStateException();
    }
}

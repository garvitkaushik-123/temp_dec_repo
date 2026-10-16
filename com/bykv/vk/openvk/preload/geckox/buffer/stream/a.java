package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: BufferInputStream.java */
/* loaded from: classes3.dex */
public final class a extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.buffer.a f948a;
    private long b;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    public a(com.bykv.vk.openvk.preload.geckox.buffer.a aVar) {
        this.f948a = aVar;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return this.f948a.b(bArr);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f948a.b(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        return this.f948a.a(j);
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long b = this.f948a.b() - this.f948a.c();
        if (b > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.b = i;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.f948a.b(this.b);
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f948a.d();
    }
}

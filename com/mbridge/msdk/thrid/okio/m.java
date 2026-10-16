package com.mbridge.msdk.thrid.okio;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink.java */
/* loaded from: classes6.dex */
final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    public final c f4909a = new c();
    public final r b;
    boolean c;

    m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = rVar;
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public c a() {
        return this.f4909a;
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public t b() {
        return this.b.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        try {
            c cVar = this.f4909a;
            long j = cVar.b;
            if (j > 0) {
                this.b.a(cVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            u.a(th);
        }
    }

    public d d() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long m = this.f4909a.m();
        if (m > 0) {
            this.b.a(this.f4909a, m);
        }
        return this;
    }

    @Override // com.mbridge.msdk.thrid.okio.d, com.mbridge.msdk.thrid.okio.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f4909a;
        long j = cVar.b;
        if (j > 0) {
            this.b.a(cVar, j);
        }
        this.b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d write(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4909a.write(bArr);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d writeByte(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4909a.writeByte(i);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d writeInt(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4909a.writeInt(i);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d writeShort(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4909a.writeShort(i);
        return d();
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public void a(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f4909a.a(cVar, j);
        d();
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d write(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c) {
            this.f4909a.write(bArr, i, i2);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d a(String str) throws IOException {
        if (!this.c) {
            this.f4909a.a(str);
            return d();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.c) {
            int write = this.f4909a.write(byteBuffer);
            d();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.mbridge.msdk.thrid.okio.d
    public d a(long j) throws IOException {
        if (!this.c) {
            this.f4909a.a(j);
            return d();
        }
        throw new IllegalStateException("closed");
    }
}

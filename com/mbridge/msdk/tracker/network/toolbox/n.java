package com.mbridge.msdk.tracker.network.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: PoolingByteArrayOutputStream.java */
/* loaded from: classes6.dex */
public class n extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private final c f4959a;

    public n(c cVar, int i) {
        this.f4959a = cVar;
        ((ByteArrayOutputStream) this).buf = cVar.a(Math.max(i, 256));
    }

    private void a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count + i;
        if (i2 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] a2 = this.f4959a.a(i2 * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a2, 0, ((ByteArrayOutputStream) this).count);
        this.f4959a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = a2;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4959a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f4959a.a(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        if (bArr != null) {
            super.write(bArr, i, i2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}

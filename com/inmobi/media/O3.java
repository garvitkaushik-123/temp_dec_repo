package com.inmobi.media;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class O3 extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P3 f2381a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O3(P3 p3, FileOutputStream fileOutputStream) {
        super(fileOutputStream);
        this.f2381a = p3;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            ((FilterOutputStream) this).out.close();
        } catch (IOException unused) {
            this.f2381a.c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public final void flush() {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException unused) {
            this.f2381a.c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) {
        try {
            ((FilterOutputStream) this).out.write(i);
        } catch (IOException unused) {
            this.f2381a.c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        try {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
        } catch (IOException unused) {
            this.f2381a.c = true;
        }
    }
}

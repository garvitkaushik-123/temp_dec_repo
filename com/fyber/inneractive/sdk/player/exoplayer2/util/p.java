package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class p extends BufferedOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1593a;

    public p(b bVar) {
        super(bVar);
    }

    public final void a(OutputStream outputStream) {
        if (!this.f1593a) {
            throw new IllegalStateException();
        }
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f1593a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1593a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th == null) {
            return;
        }
        int i = z.f1599a;
        throw th;
    }

    public p(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}

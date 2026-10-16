package com.mbridge.msdk.thrid.okio;

import java.io.IOException;

/* compiled from: ForwardingSink.java */
/* loaded from: classes6.dex */
public abstract class g implements r {

    /* renamed from: a, reason: collision with root package name */
    private final r f4902a;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4902a = rVar;
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public void a(c cVar, long j) throws IOException {
        this.f4902a.a(cVar, j);
    }

    @Override // com.mbridge.msdk.thrid.okio.r
    public t b() {
        return this.f4902a.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4902a.close();
    }

    @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
    public void flush() throws IOException {
        this.f4902a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f4902a.toString() + ")";
    }
}

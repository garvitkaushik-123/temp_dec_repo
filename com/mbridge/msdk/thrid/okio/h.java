package com.mbridge.msdk.thrid.okio;

import java.io.IOException;

/* compiled from: ForwardingSource.java */
/* loaded from: classes6.dex */
public abstract class h implements s {

    /* renamed from: a, reason: collision with root package name */
    private final s f4903a;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4903a = sVar;
    }

    @Override // com.mbridge.msdk.thrid.okio.s
    public t b() {
        return this.f4903a.b();
    }

    @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4903a.close();
    }

    public final s d() {
        return this.f4903a;
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f4903a.toString() + ")";
    }
}

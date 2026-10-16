package com.inmobi.media;

import java.io.Closeable;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class R3 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream[] f2413a;

    public R3(InputStream[] inputStreamArr) {
        this.f2413a = inputStreamArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        for (InputStream inputStream : this.f2413a) {
            Ge.a(inputStream);
        }
    }
}

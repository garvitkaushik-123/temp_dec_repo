package com.fyber.inneractive.sdk.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class t0 extends BufferedInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f1781a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(InputStream inputStream, AtomicInteger atomicInteger) {
        super(inputStream);
        this.f1781a = atomicInteger;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f1781a.getAndAdd(read);
        }
        return read;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        this.f1781a.set(0);
        super.reset();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        long skip;
        skip = super.skip(j);
        this.f1781a.addAndGet((int) skip);
        return skip;
    }
}

package com.fyber.inneractive.sdk.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class a extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f1656a;

    public a(InputStream inputStream, int i) {
        super(inputStream);
        this.f1656a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return Math.min(super.available(), this.f1656a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (this.f1656a <= 0) {
            return -1;
        }
        int read = super.read();
        if (read >= 0) {
            this.f1656a--;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) {
        long skip = super.skip(Math.min(j, this.f1656a));
        if (skip >= 0) {
            this.f1656a = (int) (this.f1656a - skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int i3 = this.f1656a;
        if (i3 <= 0) {
            return -1;
        }
        int read = super.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            this.f1656a -= read;
        }
        return read;
    }
}

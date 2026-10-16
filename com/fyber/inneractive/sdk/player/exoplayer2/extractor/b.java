package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class b {
    public static final byte[] g = new byte[4096];

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h f1405a;
    public final long b;
    public long c;
    public byte[] d = new byte[65536];
    public int e;
    public int f;

    public b(com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, long j, long j2) {
        this.f1405a = hVar;
        this.c = j;
        this.b = j2;
    }

    public final boolean a(byte[] bArr, int i, int i2, boolean z) {
        if (!a(i2, z)) {
            return false;
        }
        System.arraycopy(this.d, this.e - i2, bArr, i, i2);
        return true;
    }

    public final boolean b(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4 = this.f;
        if (i4 == 0) {
            i3 = 0;
        } else {
            int min = Math.min(i4, i2);
            System.arraycopy(this.d, 0, bArr, i, min);
            b(min);
            i3 = min;
        }
        while (i3 < i2 && i3 != -1) {
            i3 = a(bArr, i, i2, i3, z);
        }
        if (i3 != -1) {
            this.c += i3;
        }
        return i3 != -1;
    }

    public final boolean a(int i, boolean z) {
        int i2 = this.e + i;
        byte[] bArr = this.d;
        if (i2 > bArr.length) {
            int i3 = z.f1599a;
            this.d = Arrays.copyOf(this.d, Math.max(65536 + i2, Math.min(bArr.length * 2, i2 + 524288)));
        }
        int min = Math.min(this.f - this.e, i);
        while (min < i) {
            int i4 = i;
            boolean z2 = z;
            min = a(this.d, this.e, i4, min, z2);
            if (min == -1) {
                return false;
            }
            i = i4;
            z = z2;
        }
        int i5 = this.e + i;
        this.e = i5;
        this.f = Math.max(this.f, i5);
        return true;
    }

    public final void b(int i) {
        int i2 = this.f - i;
        this.f = i2;
        this.e = 0;
        byte[] bArr = this.d;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.d = bArr2;
    }

    public final void a(int i) {
        int min = Math.min(this.f, i);
        b(min);
        int i2 = min;
        while (i2 < i && i2 != -1) {
            i2 = a(g, -i2, Math.min(i, i2 + 4096), i2, false);
        }
        if (i2 != -1) {
            this.c += i2;
        }
    }

    public final int a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (!Thread.interrupted()) {
            int read = this.f1405a.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }
}

package com.fyber.inneractive.sdk.player.exoplayer2.decoder;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f1400a;
    public ByteBuffer c;
    public long d;
    public final b b = new b();
    public final int e = 0;

    public final void a() {
        this.f1400a = 0;
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean b(int i) {
        return (this.f1400a & i) == i;
    }

    public final ByteBuffer a(int i) {
        int i2 = this.e;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.c;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i + ")");
    }
}

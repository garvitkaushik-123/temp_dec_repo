package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes4.dex */
public final class v implements c {
    public int b = -1;
    public int c = -1;
    public int d = 0;
    public ByteBuffer e;
    public ByteBuffer f;
    public boolean g;

    public v() {
        ByteBuffer byteBuffer = c.f1382a;
        this.e = byteBuffer;
        this.f = byteBuffer;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final boolean a(int i, int i2, int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new b(i, i2, i3);
        }
        if (this.b == i && this.c == i2 && this.d == i3) {
            return false;
        }
        this.b = i;
        this.c = i2;
        this.d = i3;
        if (i3 != 2) {
            return true;
        }
        this.e = c.f1382a;
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final void b() {
        this.g = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final boolean c() {
        return this.g && this.f == c.f1382a;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final boolean d() {
        int i = this.d;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final int e() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final void f() {
        ByteBuffer byteBuffer = c.f1382a;
        this.f = byteBuffer;
        this.g = false;
        this.e = byteBuffer;
        this.b = -1;
        this.c = -1;
        this.d = 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final void flush() {
        this.f = c.f1382a;
        this.g = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[ADDED_TO_REGION, LOOP:2: B:24:0x0081->B:25:0x0083, LOOP_START, PHI: r0
      0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:10:0x0041, B:25:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(ByteBuffer byteBuffer) {
        int i;
        int i2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i3 = limit - position;
        int i4 = this.d;
        if (i4 == Integer.MIN_VALUE) {
            i3 /= 3;
        } else if (i4 != 3) {
            if (i4 == 1073741824) {
                i = i3 / 2;
                if (this.e.capacity() >= i) {
                    this.e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                } else {
                    this.e.clear();
                }
                i2 = this.d;
                if (i2 != Integer.MIN_VALUE) {
                    while (position < limit) {
                        this.e.put(byteBuffer.get(position + 1));
                        this.e.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else if (i2 == 3) {
                    while (position < limit) {
                        this.e.put((byte) 0);
                        this.e.put((byte) ((byteBuffer.get(position) & 255) + RangingPosition.RSSI_UNKNOWN));
                        position++;
                    }
                } else {
                    if (i2 != 1073741824) {
                        throw new IllegalStateException();
                    }
                    while (position < limit) {
                        this.e.put(byteBuffer.get(position + 2));
                        this.e.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                this.e.flip();
                this.f = this.e;
            }
            throw new IllegalStateException();
        }
        i = i3 * 2;
        if (this.e.capacity() >= i) {
        }
        i2 = this.d;
        if (i2 != Integer.MIN_VALUE) {
        }
        byteBuffer.position(byteBuffer.limit());
        this.e.flip();
        this.f = this.e;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.f;
        this.f = c.f1382a;
        return byteBuffer;
    }
}

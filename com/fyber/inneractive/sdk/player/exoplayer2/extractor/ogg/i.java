package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class i extends l {
    public static final int o = z.a("Opus");
    public static final byte[] p = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean n;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int i;
        byte[] bArr = nVar.f1591a;
        byte b = bArr[0];
        int i2 = b & 255;
        int i3 = b & 3;
        if (i3 != 0) {
            i = 2;
            if (i3 != 1 && i3 != 2) {
                i = bArr[1] & 63;
            }
        } else {
            i = 1;
        }
        int i4 = i2 >> 3;
        return (this.i * (i * (i4 >= 16 ? 2500 << r0 : i4 >= 12 ? 10000 << (i4 & 1) : (i4 & 3) == 3 ? 60000 : 10000 << r0))) / 1000000;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, long j, j jVar) {
        if (!this.n) {
            byte[] copyOf = Arrays.copyOf(nVar.f1591a, nVar.c);
            int i = copyOf[9] & 255;
            int i2 = ((copyOf[11] & 255) << 8) | (copyOf[10] & 255);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i2 * 1000000000) / 48000).array());
            arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((3840 * 1000000000) / 48000).array());
            jVar.f1468a = com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "audio/opus", -1, -1, i, 48000, arrayList, null, null);
            this.n = true;
            return true;
        }
        boolean z = nVar.b() == o;
        nVar.e(0);
        return z;
    }
}

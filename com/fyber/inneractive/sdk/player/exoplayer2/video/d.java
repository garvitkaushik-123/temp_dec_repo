package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.r;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f1603a;
    public final int b;

    public d(int i, List list) {
        this.f1603a = list;
        this.b = i;
    }

    public static d a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        try {
            nVar.e(nVar.b + 21);
            int j = nVar.j() & 3;
            int j2 = nVar.j();
            int i = nVar.b;
            int i2 = 0;
            for (int i3 = 0; i3 < j2; i3++) {
                nVar.e(nVar.b + 1);
                int o = nVar.o();
                for (int i4 = 0; i4 < o; i4++) {
                    int o2 = nVar.o();
                    i2 += o2 + 4;
                    nVar.e(nVar.b + o2);
                }
            }
            nVar.e(i);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < j2; i6++) {
                nVar.e(nVar.b + 1);
                int o3 = nVar.o();
                for (int i7 = 0; i7 < o3; i7++) {
                    int o4 = nVar.o();
                    System.arraycopy(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f1589a, 0, bArr, i5, 4);
                    int i8 = i5 + 4;
                    System.arraycopy(nVar.f1591a, nVar.b, bArr, i8, o4);
                    i5 = i8 + o4;
                    nVar.e(nVar.b + o4);
                }
            }
            return new d(j + 1, i2 == 0 ? null : Collections.singletonList(bArr));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new r("Error parsing HEVC config", e);
        }
    }
}

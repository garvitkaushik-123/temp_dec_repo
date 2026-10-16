package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.r;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List f1601a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public a(ArrayList arrayList, int i, int i2, int i3, float f) {
        this.f1601a = arrayList;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public static a a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        float f;
        int i;
        int i2;
        try {
            nVar.e(nVar.b + 4);
            int j = (nVar.j() & 3) + 1;
            if (j == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int j2 = nVar.j() & 31;
            for (int i3 = 0; i3 < j2; i3++) {
                int o = nVar.o();
                int i4 = nVar.b;
                nVar.e(i4 + o);
                byte[] bArr = nVar.f1591a;
                byte[] bArr2 = new byte[o + 4];
                System.arraycopy(com.fyber.inneractive.sdk.player.exoplayer2.util.d.f1583a, 0, bArr2, 0, 4);
                System.arraycopy(bArr, i4, bArr2, 4, o);
                arrayList.add(bArr2);
            }
            int j3 = nVar.j();
            for (int i5 = 0; i5 < j3; i5++) {
                int o2 = nVar.o();
                int i6 = nVar.b;
                nVar.e(i6 + o2);
                byte[] bArr3 = nVar.f1591a;
                byte[] bArr4 = new byte[o2 + 4];
                System.arraycopy(com.fyber.inneractive.sdk.player.exoplayer2.util.d.f1583a, 0, bArr4, 0, 4);
                System.arraycopy(bArr3, i6, bArr4, 4, o2);
                arrayList.add(bArr4);
            }
            if (j2 > 0) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.k a2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a((byte[]) arrayList.get(0), j, ((byte[]) arrayList.get(0)).length);
                int i7 = a2.b;
                int i8 = a2.c;
                f = a2.d;
                i = i7;
                i2 = i8;
            } else {
                f = 1.0f;
                i = -1;
                i2 = -1;
            }
            return new a(arrayList, j, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new r("Error parsing AVC config", e);
        }
    }
}

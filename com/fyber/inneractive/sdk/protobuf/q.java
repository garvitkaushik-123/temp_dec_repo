package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public class q extends p {
    private static final long serialVersionUID = 1;
    public final byte[] d;

    public q(byte[] bArr) {
        bArr.getClass();
        this.d = bArr;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public void a(int i, byte[] bArr) {
        System.arraycopy(this.d, 0, bArr, 0, i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public byte c(int i) {
        return this.d[i];
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public byte d(int i) {
        return this.d[i];
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public final s e(int i) {
        int a2 = s.a(0, i, size());
        return a2 == 0 ? s.b : new n(this.d, g(), a2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s) || size() != ((s) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof q)) {
            return obj.equals(this);
        }
        q qVar = (q) obj;
        int i = this.f1698a;
        int i2 = qVar.f1698a;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > qVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > qVar.size()) {
            throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Ran off end of other: 0, ", size, ", ").append(qVar.size()).toString());
        }
        byte[] bArr = this.d;
        byte[] bArr2 = qVar.d;
        int g = g() + size;
        int g2 = g();
        int g3 = qVar.g();
        while (g2 < g) {
            if (bArr[g2] != bArr2[g3]) {
                return false;
            }
            g2++;
            g3++;
        }
        return true;
    }

    public int g() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public int size() {
        return this.d.length;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public final void a(k kVar) {
        kVar.a(this.d, g(), size());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public final boolean c() {
        int g = g();
        return d4.f1666a.b(this.d, g, size() + g);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public final w d() {
        byte[] bArr = this.d;
        int g = g();
        int size = size();
        t tVar = new t(bArr, g, size, true);
        try {
            tVar.d(size);
            return tVar;
        } catch (n1 e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public final int a(int i, int i2) {
        byte[] bArr = this.d;
        int g = g();
        Charset charset = l1.f1684a;
        for (int i3 = g; i3 < g + i2; i3++) {
            i = (i * 31) + bArr[i3];
        }
        return i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s
    public final String e() {
        return new String(this.d, g(), size(), l1.f1684a);
    }
}

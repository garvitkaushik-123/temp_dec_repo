package com.fyber.inneractive.sdk.player.exoplayer2.decoder;

import android.media.MediaCodec;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f1399a;
    public int[] b;
    public int[] c;
    public final MediaCodec.CryptoInfo d;
    public final a e;

    public b() {
        int i = z.f1599a;
        MediaCodec.CryptoInfo cryptoInfo = i >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.d = cryptoInfo;
        this.e = i >= 24 ? new a(cryptoInfo) : null;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2) {
        this.b = iArr;
        this.c = iArr2;
        this.f1399a = bArr2;
        int i2 = z.f1599a;
        if (i2 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.d;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = 1;
            if (i2 >= 24) {
                a.a(this.e);
            }
        }
    }
}

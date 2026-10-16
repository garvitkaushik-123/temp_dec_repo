package com.instagram.common.viewpoint.core;

import android.media.MediaCodec;

/* renamed from: com.facebook.ads.redexgen.X.5z, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C07665z {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public byte[] A04;
    public byte[] A05;
    public int[] A06;
    public int[] A07;
    public final MediaCodec.CryptoInfo A08 = new MediaCodec.CryptoInfo();
    public final C07655y A09;

    public C07665z() {
        this.A09 = C5C.A02 >= 24 ? new C07655y(this.A08) : null;
    }

    public final MediaCodec.CryptoInfo A00() {
        return this.A08;
    }

    public final void A01(int i) {
        if (i == 0) {
            return;
        }
        if (this.A06 == null) {
            this.A06 = new int[1];
            this.A08.numBytesOfClearData = this.A06;
        }
        int[] iArr = this.A06;
        iArr[0] = iArr[0] + i;
    }

    public final void A02(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.A03 = i;
        this.A06 = iArr;
        this.A07 = iArr2;
        this.A05 = bArr;
        this.A04 = bArr2;
        this.A02 = i2;
        this.A01 = i3;
        this.A00 = i4;
        this.A08.numSubSamples = i;
        this.A08.numBytesOfClearData = iArr;
        this.A08.numBytesOfEncryptedData = iArr2;
        this.A08.key = bArr;
        this.A08.iv = bArr2;
        this.A08.mode = i2;
        if (C5C.A02 >= 24) {
            ((C07655y) AbstractC07133y.A01(this.A09)).A00(i3, i4);
        }
    }
}

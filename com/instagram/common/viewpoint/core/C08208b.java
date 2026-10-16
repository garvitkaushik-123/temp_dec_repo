package com.instagram.common.viewpoint.core;

import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;

/* renamed from: com.facebook.ads.redexgen.X.8b, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08208b implements InterfaceC2253mF {
    public long A00;
    public final long A01;
    public final C07224h A03 = new C07224h();
    public final C07224h A02 = new C07224h();

    public C08208b(long j, long j2, long j3) {
        this.A00 = j;
        this.A01 = j3;
        this.A03.A04(0L);
        this.A02.A04(j2);
    }

    public final void A00(long j) {
        this.A00 = j;
    }

    public final void A01(long j, long j2) {
        if (A02(j)) {
            return;
        }
        this.A03.A04(j);
        this.A02.A04(j2);
    }

    public final boolean A02(long j) {
        long lastIndexedTimeUs = this.A03.A03(this.A03.A02() - 1);
        return j - lastIndexedTimeUs < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2253mF
    public final long A7j() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final long A7t() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final HX A91(long j) {
        int A0C = C5C.A0C(this.A03, j, true, true);
        HZ hz = new HZ(this.A03.A03(A0C), this.A02.A03(A0C));
        if (hz.A01 != j) {
            int targetIndex = this.A03.A02();
            if (A0C != targetIndex - 1) {
                int targetIndex2 = A0C + 1;
                long A03 = this.A03.A03(targetIndex2);
                int targetIndex3 = A0C + 1;
                HZ nextSeekPoint = new HZ(A03, this.A02.A03(targetIndex3));
                return new HX(hz, nextSeekPoint);
            }
        }
        return new HX(hz);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2253mF
    public final long A9H(long j) {
        return this.A03.A03(C5C.A0C(this.A02, j, true, true));
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final boolean AAj() {
        return true;
    }
}

package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.mK, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2257mK implements InterfaceC1069Ik {
    public final /* synthetic */ MatroskaExtractor A00;

    public C2257mK(MatroskaExtractor matroskaExtractor) {
        this.A00 = matroskaExtractor;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final void A4i(int i, int i2, InterfaceC2280ms interfaceC2280ms) throws IOException {
        this.A00.A0U(i, i2, interfaceC2280ms);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final void A6N(int i) throws C3K {
        this.A00.A0S(i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final void A6a(int i, double d) throws C3K {
        this.A00.A0T(i, d);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final int A7u(int i) {
        return this.A00.A0R(i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final void AAH(int i, long j) throws C3K {
        this.A00.A0V(i, j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final boolean AAW(int i) {
        return this.A00.A0Y(i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final void AK9(int i, long j, long j2) throws C3K {
        this.A00.A0W(i, j, j2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1069Ik
    public final void AKK(int i, String str) throws C3K {
        this.A00.A0X(i, str);
    }
}

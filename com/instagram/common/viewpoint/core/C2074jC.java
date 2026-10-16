package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.redexgen.X.jC, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2074jC implements O3 {
    public final /* synthetic */ C1207Nu A00;

    public C2074jC(C1207Nu c1207Nu) {
        this.A00 = c1207Nu;
    }

    @Override // com.instagram.common.viewpoint.core.O3
    public final void AFF(AdError adError) {
        InterfaceC1206Nt interfaceC1206Nt;
        interfaceC1206Nt = this.A00.A04;
        interfaceC1206Nt.ACo(AdError.CACHE_ERROR);
    }

    @Override // com.instagram.common.viewpoint.core.O3
    public final void AFG() {
        InterfaceC1206Nt interfaceC1206Nt;
        interfaceC1206Nt = this.A00.A04;
        interfaceC1206Nt.ACp();
    }
}

package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.redexgen.X.jB, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2073jB implements SM {
    public final /* synthetic */ C1207Nu A00;

    public C2073jB(C1207Nu c1207Nu) {
        this.A00 = c1207Nu;
    }

    @Override // com.instagram.common.viewpoint.core.SM
    public final void ACx() {
        InterfaceC1206Nt interfaceC1206Nt;
        interfaceC1206Nt = this.A00.A04;
        interfaceC1206Nt.ACp();
    }

    @Override // com.instagram.common.viewpoint.core.SM
    public final void ACy() {
        InterfaceC1206Nt interfaceC1206Nt;
        interfaceC1206Nt = this.A00.A04;
        interfaceC1206Nt.ACo(AdError.CACHE_ERROR);
    }
}

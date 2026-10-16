package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Pc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1241Pc implements InterfaceC1297Rk {
    public final /* synthetic */ PZ A00;

    public C1241Pc(PZ pz) {
        this.A00 = pz;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1297Rk
    public final boolean AAI() {
        if (this.A00.A0E.canGoBack()) {
            this.A00.A0E.goBack();
            return true;
        }
        return false;
    }
}

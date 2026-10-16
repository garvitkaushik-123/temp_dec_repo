package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Xf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1442Xf implements ViewpointAction<C1386Uw, V1> {
    public XM A00;

    public C1442Xf(XM xm) {
        this.A00 = xm;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    @Override // com.instagram.common.viewpoint.core.ViewpointAction
    public final void A6R(C2538rN<C1386Uw, V1> c2538rN, InterfaceC2529rD interfaceC2529rD) {
        switch (interfaceC2529rD.A9U(c2538rN)) {
            case A02:
            case A04:
                this.A00.A02(c2538rN, interfaceC2529rD);
                break;
        }
    }
}

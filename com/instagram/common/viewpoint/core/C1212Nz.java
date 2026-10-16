package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Nz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1212Nz implements InterfaceC1620bh {
    public final /* synthetic */ NO A00;

    public C1212Nz(NO no) {
        this.A00 = no;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1620bh
    public final void ACt() {
        boolean A0X;
        A0X = this.A00.A0X();
        if (A0X) {
            this.A00.A0N();
            this.A00.A0g.setToolbarActionMessage("");
            this.A00.A0g.setToolbarActionMode(0);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1620bh
    public final void AEm() {
        XO xo;
        this.A00.A0K = false;
        xo = this.A00.A0U;
        xo.A07();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1620bh
    public final void AEn() {
        XO xo;
        this.A00.A0K = true;
        xo = this.A00.A0U;
        xo.A06();
    }
}

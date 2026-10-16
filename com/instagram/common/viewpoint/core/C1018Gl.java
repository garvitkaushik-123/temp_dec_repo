package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Gl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1018Gl implements InterfaceC1463Ya {
    public final /* synthetic */ AbstractC1016Gj A00;

    public C1018Gl(AbstractC1016Gj abstractC1016Gj) {
        this.A00 = abstractC1016Gj;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1463Ya
    public final void ACl(AbstractC1464Yb abstractC1464Yb) {
        if (abstractC1464Yb.getToolbarActionMode() == 8) {
            this.A00.A0g();
            return;
        }
        this.A00.A07.A04(VH.A07, null);
        if (this.A00.A0l()) {
            return;
        }
        this.A00.A05.A0F().AB0();
        this.A00.A0A.A4j(this.A00.A0B.A7w());
    }
}

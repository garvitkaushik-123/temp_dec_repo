package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Pa, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1239Pa implements InterfaceC1567aq {
    public final /* synthetic */ PZ A00;

    public C1239Pa(PZ pz) {
        this.A00 = pz;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF7(String str) {
        this.A00.A0C.setProgress(100);
        this.A00.A05 = false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF9(String str) {
        this.A00.A05 = true;
        this.A00.A0F.setUrl(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFY(int i) {
        if (this.A00.A05) {
            this.A00.A0C.setProgress(i);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFb(String str) {
        this.A00.A0F.setTitle(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFe() {
        this.A00.A0B.ADJ(14);
    }
}

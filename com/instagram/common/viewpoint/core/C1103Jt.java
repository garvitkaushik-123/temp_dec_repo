package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Jt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1103Jt implements InterfaceC1607bU {
    public final /* synthetic */ C1092Ji A00;

    public C1103Jt(C1092Ji c1092Ji) {
        this.A00 = c1092Ji;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1607bU
    public final void ADY() {
        VI vi;
        AbstractC1181Mt abstractC1181Mt;
        C1646c7 c1646c7;
        C1606bT c1606bT;
        C1606bT c1606bT2;
        C1646c7 c1646c72;
        AbstractC1181Mt abstractC1181Mt2;
        vi = this.A00.A0Y;
        vi.A04(VH.A0J, null);
        abstractC1181Mt = this.A00.A0W;
        if (abstractC1181Mt != null) {
            C1092Ji c1092Ji = this.A00;
            abstractC1181Mt2 = this.A00.A0W;
            c1092Ji.A0m(((AnonymousClass85) abstractC1181Mt2).A0M().toString());
        }
        c1646c7 = this.A00.A0b;
        if (c1646c7.A0D() != null) {
            c1646c72 = this.A00.A0b;
            c1646c72.A0D().ACQ();
        }
        c1606bT = this.A00.A09;
        if (c1606bT != null) {
            c1606bT2 = this.A00.A09;
            c1606bT2.A0B();
            this.A00.A09 = null;
        }
        this.A00.A0q(true);
    }
}

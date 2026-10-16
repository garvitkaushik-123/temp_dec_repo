package com.instagram.common.viewpoint.core;

import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public class EH extends AbstractC1216Od {
    public final /* synthetic */ EF A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EH(EF ef, double d, double d2, double d3, boolean z) {
        super(d, d2, d3, z);
        this.A00 = ef;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1216Od
    public final void A00(boolean z, boolean z2, C1218Of c1218Of) {
        C1929gi c1929gi;
        String str;
        Map A0J;
        boolean z3;
        c1929gi = this.A00.A0D;
        if (C1379Up.A0z(c1929gi)) {
            z3 = this.A00.A09;
            if (z3) {
                return;
            }
        }
        if (z2) {
            this.A00.A09 = true;
            EF ef = this.A00;
            str = this.A00.A0J;
            A0J = this.A00.A0J(EnumC1807ek.A03);
            ef.A0R(str, A0J);
        }
    }
}

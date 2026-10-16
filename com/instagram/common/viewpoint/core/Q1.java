package com.instagram.common.viewpoint.core;

import android.content.DialogInterface;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public class Q1 extends AbstractRunnableC1416Wc {
    public final /* synthetic */ DialogInterface A00;
    public final /* synthetic */ YR A01;

    public Q1(YR yr, DialogInterface dialogInterface) {
        this.A01 = yr;
        this.A00 = dialogInterface;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        InterfaceC1880fv interfaceC1880fv;
        InterfaceC1880fv interfaceC1880fv2;
        C1925ge c1925ge;
        Map<? extends String, ? extends String> A02;
        interfaceC1880fv = this.A01.A01.A02;
        if (interfaceC1880fv != null) {
            interfaceC1880fv2 = this.A01.A01.A02;
            c1925ge = this.A01.A01.A00;
            String A03 = WI.A03(c1925ge);
            C1894g9 c1894g9 = new C1894g9();
            A02 = this.A01.A01.A02(this.A01.A00.getText().toString());
            interfaceC1880fv2.AGx(A03, c1894g9.A05(A02).A08());
        }
        this.A00.cancel();
    }
}

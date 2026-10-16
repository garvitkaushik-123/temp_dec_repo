package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.aY, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1549aY implements View.OnClickListener {
    public final /* synthetic */ M8 A00;

    public ViewOnClickListenerC1549aY(M8 m8) {
        this.A00 = m8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1929gi c1929gi;
        InterfaceC1571au interfaceC1571au;
        InterfaceC1571au interfaceC1571au2;
        if (WU.A02(this)) {
            return;
        }
        try {
            c1929gi = this.A00.A08;
            c1929gi.A0F().A9w();
            interfaceC1571au = this.A00.A05;
            if (interfaceC1571au != null) {
                interfaceC1571au2 = this.A00.A05;
                interfaceC1571au2.ADO();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

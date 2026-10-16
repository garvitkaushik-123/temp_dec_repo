package com.instagram.common.viewpoint.core;

import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public class ZY implements View.OnClickListener {
    public final /* synthetic */ C1490Zb A00;

    public ZY(C1490Zb c1490Zb) {
        this.A00 = c1490Zb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        InterfaceC1494Zf interfaceC1494Zf;
        InterfaceC1494Zf interfaceC1494Zf2;
        if (WU.A02(this)) {
            return;
        }
        try {
            z = this.A00.A05;
            if (z) {
                interfaceC1494Zf2 = this.A00.A04;
                interfaceC1494Zf2.A53();
            } else {
                interfaceC1494Zf = this.A00.A04;
                interfaceC1494Zf.A54();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

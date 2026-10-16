package com.instagram.common.viewpoint.core;

import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public class ZZ implements View.OnClickListener {
    public final /* synthetic */ C1490Zb A00;

    public ZZ(C1490Zb c1490Zb) {
        this.A00 = c1490Zb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1494Zf interfaceC1494Zf;
        if (WU.A02(this)) {
            return;
        }
        try {
            interfaceC1494Zf = this.A00.A04;
            interfaceC1494Zf.AAp();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

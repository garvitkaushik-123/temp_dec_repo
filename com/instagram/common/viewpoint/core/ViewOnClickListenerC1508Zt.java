package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Zt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1508Zt implements View.OnClickListener {
    public final /* synthetic */ C1510Zv A00;

    public ViewOnClickListenerC1508Zt(C1510Zv c1510Zv) {
        this.A00 = c1510Zv;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1494Zf interfaceC1494Zf;
        if (WU.A02(this)) {
            return;
        }
        try {
            interfaceC1494Zf = this.A00.A02;
            interfaceC1494Zf.A9c();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

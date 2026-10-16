package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.cZ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1674cZ implements View.OnClickListener {
    public final /* synthetic */ KB A00;

    public ViewOnClickListenerC1674cZ(KB kb) {
        this.A00 = kb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1759dx interfaceC1759dx;
        InterfaceC1759dx interfaceC1759dx2;
        if (WU.A02(this)) {
            return;
        }
        try {
            interfaceC1759dx = this.A00.A08;
            if (interfaceC1759dx != null) {
                interfaceC1759dx2 = this.A00.A08;
                interfaceC1759dx2.A9l();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

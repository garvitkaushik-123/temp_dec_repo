package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.cW, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1671cW implements View.OnClickListener {
    public final /* synthetic */ KD A00;

    public ViewOnClickListenerC1671cW(KD kd) {
        this.A00 = kd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1759dx interfaceC1759dx;
        InterfaceC1759dx interfaceC1759dx2;
        if (WU.A02(this)) {
            return;
        }
        try {
            interfaceC1759dx = this.A00.A02;
            if (interfaceC1759dx != null) {
                interfaceC1759dx2 = this.A00.A02;
                interfaceC1759dx2.AJz();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Yz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1488Yz implements View.OnClickListener {
    public final /* synthetic */ Z2 A00;

    public ViewOnClickListenerC1488Yz(Z2 z2) {
        this.A00 = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0D();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

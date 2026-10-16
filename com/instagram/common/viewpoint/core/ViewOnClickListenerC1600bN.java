package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.bN, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1600bN implements View.OnClickListener {
    public final /* synthetic */ C1133Kx A00;

    public ViewOnClickListenerC1600bN(C1133Kx c1133Kx) {
        this.A00 = c1133Kx;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A02();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

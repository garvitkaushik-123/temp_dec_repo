package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.bg, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1619bg implements View.OnClickListener {
    public final /* synthetic */ C1621bi A00;

    public ViewOnClickListenerC1619bg(C1621bi c1621bi) {
        this.A00 = c1621bi;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A05();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

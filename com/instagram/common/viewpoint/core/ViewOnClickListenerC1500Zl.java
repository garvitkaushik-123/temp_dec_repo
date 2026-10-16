package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Zl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1500Zl implements View.OnClickListener {
    public final /* synthetic */ ME A00;

    public ViewOnClickListenerC1500Zl(ME me) {
        this.A00 = me;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0D.AAq();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Zq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1505Zq implements View.OnClickListener {
    public final /* synthetic */ MD A00;

    public ViewOnClickListenerC1505Zq(MD md) {
        this.A00 = md;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0D.A9c();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

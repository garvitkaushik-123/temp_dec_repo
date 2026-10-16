package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Zz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1514Zz implements View.OnClickListener {
    public final /* synthetic */ C1496Zh A00;
    public final /* synthetic */ MC A01;

    public ViewOnClickListenerC1514Zz(MC mc, C1496Zh c1496Zh) {
        this.A01 = mc;
        this.A00 = c1496Zh;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0D.AAq();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

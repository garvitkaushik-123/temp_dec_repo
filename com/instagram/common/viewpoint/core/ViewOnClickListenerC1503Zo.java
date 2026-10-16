package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Zo, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1503Zo implements View.OnClickListener {
    public final /* synthetic */ C1496Zh A00;
    public final /* synthetic */ MD A01;

    public ViewOnClickListenerC1503Zo(MD md, C1496Zh c1496Zh) {
        this.A01 = md;
        this.A00 = c1496Zh;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0D.AEr(EnumC1221Oi.A06);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

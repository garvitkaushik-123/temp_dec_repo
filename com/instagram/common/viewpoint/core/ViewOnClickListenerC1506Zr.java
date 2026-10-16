package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Zr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1506Zr implements View.OnClickListener {
    public final /* synthetic */ C1223Ok A00;
    public final /* synthetic */ C1496Zh A01;
    public final /* synthetic */ MD A02;

    public ViewOnClickListenerC1506Zr(MD md, C1496Zh c1496Zh, C1223Ok c1223Ok) {
        this.A02 = md;
        this.A01 = c1496Zh;
        this.A00 = c1223Ok;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0D.AF4(this.A00);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

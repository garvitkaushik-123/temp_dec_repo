package com.instagram.common.viewpoint.core;

import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public class Z5 implements View.OnClickListener {
    public final /* synthetic */ NO A00;

    public Z5(NO no) {
        this.A00 = no;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        VI vi;
        InterfaceC1470Yh interfaceC1470Yh;
        ZU zu;
        if (WU.A02(this)) {
            return;
        }
        try {
            vi = this.A00.A0T;
            vi.A04(VH.A07, null);
            interfaceC1470Yh = this.A00.A0W;
            zu = this.A00.A0X;
            interfaceC1470Yh.A4j(zu.A7w());
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

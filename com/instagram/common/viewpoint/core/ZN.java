package com.instagram.common.viewpoint.core;

import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public class ZN implements View.OnClickListener {
    public final /* synthetic */ MI A00;

    public ZN(MI mi) {
        this.A00 = mi;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ZP zp;
        if (WU.A02(this)) {
            return;
        }
        try {
            zp = this.A00.A07;
            zp.ADv();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

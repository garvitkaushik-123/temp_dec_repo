package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.fB, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1834fB implements View.OnClickListener {
    public final /* synthetic */ C0935Df A00;

    public ViewOnClickListenerC1834fB(C0935Df c0935Df) {
        this.A00 = c0935Df;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        VI vi;
        C1929gi c1929gi;
        C0966Ek c0966Ek;
        boolean A07;
        C0966Ek c0966Ek2;
        C0966Ek c0966Ek3;
        if (WU.A02(this)) {
            return;
        }
        try {
            vi = this.A00.A04;
            vi.A04(VH.A0l, null);
            c1929gi = this.A00.A03;
            c1929gi.A0F().A3m();
            c0966Ek = this.A00.A00;
            if (c0966Ek != null) {
                A07 = this.A00.A07();
                if (A07) {
                    c0966Ek3 = this.A00.A00;
                    c0966Ek3.setVolume(1.0f);
                } else {
                    c0966Ek2 = this.A00.A00;
                    c0966Ek2.setVolume(0.0f);
                }
                this.A00.A09();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

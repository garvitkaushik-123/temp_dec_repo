package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.cR, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1666cR implements View.OnClickListener {
    public final /* synthetic */ KE A00;

    public ViewOnClickListenerC1666cR(KE ke) {
        this.A00 = ke;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        AbstractC1181Mt abstractC1181Mt;
        AbstractC2094jd abstractC2094jd;
        Handler handler;
        Runnable runnable;
        AbstractC2094jd abstractC2094jd2;
        AbstractC1181Mt abstractC1181Mt2;
        if (WU.A02(this)) {
            return;
        }
        try {
            z = this.A00.A0M;
            if (!z) {
                this.A00.A0N = true;
                abstractC1181Mt = this.A00.A0b;
                if (abstractC1181Mt != null) {
                    KE ke = this.A00;
                    abstractC1181Mt2 = this.A00.A0b;
                    ke.A0f(((AnonymousClass85) abstractC1181Mt2).A0M().toString());
                }
                abstractC2094jd = this.A00.A0E;
                if (abstractC2094jd.A0q() >= 0) {
                    handler = this.A00.A08;
                    runnable = this.A00.A0h;
                    abstractC2094jd2 = this.A00.A0E;
                    handler.postDelayed(runnable, abstractC2094jd2.A0q());
                }
            }
            KE ke2 = this.A00;
            z2 = this.A00.A0M;
            ke2.A0i(z2 ? false : true);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

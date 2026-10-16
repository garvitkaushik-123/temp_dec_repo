package com.instagram.common.viewpoint.core;

import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.3x, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C07123x extends E2 {
    public final /* synthetic */ C0942Dm A00;

    public C07123x(C0942Dm c0942Dm) {
        this.A00 = c0942Dm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.UN
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(E3 e3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean A0G;
        Handler handler;
        int i;
        boolean z4;
        boolean A0G2;
        boolean z5;
        z = this.A00.A03;
        if (z) {
            z5 = this.A00.A02;
            if (z5) {
                return;
            }
        }
        z2 = this.A00.A05;
        if (!z2) {
            return;
        }
        z3 = this.A00.A04;
        if (!z3) {
            return;
        }
        this.A00.A05 = false;
        A0G = this.A00.A0G(EnumC1842fJ.A03);
        if (!A0G) {
            z4 = this.A00.A06;
            if (!z4) {
                A0G2 = this.A00.A0G(EnumC1842fJ.A02);
                if (!A0G2) {
                    return;
                }
                this.A00.A03();
                this.A00.A06(true, true);
                return;
            }
        }
        this.A00.A06 = false;
        handler = this.A00.A07;
        C0944Do c0944Do = new C0944Do(this);
        i = this.A00.A00;
        handler.postDelayed(c0944Do, i);
    }
}

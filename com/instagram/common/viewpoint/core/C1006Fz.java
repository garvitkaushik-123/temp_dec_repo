package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Fz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1006Fz implements InterfaceC1693cs {
    public final /* synthetic */ C1005Fy A00;

    public C1006Fz(C1005Fy c1005Fy) {
        this.A00 = c1005Fy;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1693cs
    public final void AGW(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1693cs
    public final void AGY(View view) {
        AbstractC1090Jg abstractC1090Jg = (AbstractC1090Jg) view;
        abstractC1090Jg.A1T();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) abstractC1090Jg.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}

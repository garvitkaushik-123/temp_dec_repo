package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.jD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2075jD implements InterfaceC1327Sp {
    public final /* synthetic */ AbstractC2094jd A00;
    public final /* synthetic */ InterfaceC1206Nt A01;
    public final /* synthetic */ C1207Nu A02;
    public final /* synthetic */ C1929gi A03;
    public final /* synthetic */ boolean A04;

    public C2075jD(C1207Nu c1207Nu, C1929gi c1929gi, boolean z, AbstractC2094jd abstractC2094jd, InterfaceC1206Nt interfaceC1206Nt) {
        this.A02 = c1207Nu;
        this.A03 = c1929gi;
        this.A04 = z;
        this.A00 = abstractC2094jd;
        this.A01 = interfaceC1206Nt;
    }

    private void A00(boolean z) {
        ArrayList arrayList;
        if (z) {
            if (C1379Up.A1q(this.A03) && this.A04) {
                arrayList = this.A02.A02;
                arrayList.add(AbstractC1714dD.A01(this.A03, this.A00, 1, new C2076jE(this)));
                return;
            } else {
                this.A01.ACp();
                return;
            }
        }
        this.A01.ACo(AdError.CACHE_ERROR);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADL() {
        A00(false);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADT() {
        A00(true);
    }
}

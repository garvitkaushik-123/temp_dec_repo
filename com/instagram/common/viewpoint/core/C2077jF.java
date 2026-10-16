package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.jF, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2077jF implements SM {
    public final /* synthetic */ AbstractC2094jd A00;
    public final /* synthetic */ InterfaceC1206Nt A01;
    public final /* synthetic */ C1207Nu A02;
    public final /* synthetic */ C1929gi A03;
    public final /* synthetic */ boolean A04;

    public C2077jF(C1207Nu c1207Nu, C1929gi c1929gi, boolean z, AbstractC2094jd abstractC2094jd, InterfaceC1206Nt interfaceC1206Nt) {
        this.A02 = c1207Nu;
        this.A03 = c1929gi;
        this.A04 = z;
        this.A00 = abstractC2094jd;
        this.A01 = interfaceC1206Nt;
    }

    @Override // com.instagram.common.viewpoint.core.SM
    public final void ACx() {
        ArrayList arrayList;
        if (C1379Up.A1q(this.A03) && this.A04) {
            arrayList = this.A02.A02;
            arrayList.add(AbstractC1714dD.A01(this.A03, this.A00, 1, new C2078jG(this)));
        } else {
            this.A01.ACp();
        }
    }

    @Override // com.instagram.common.viewpoint.core.SM
    public final void ACy() {
        this.A01.ACo(AdError.CACHE_ERROR);
    }
}

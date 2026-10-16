package com.instagram.common.viewpoint.core;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.7j, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08027j extends AbstractC2064j0 {
    public C08027j(C1929gi c1929gi, O7 o7) {
        super(c1929gi, o7);
    }

    private C2062iy A00(Runnable runnable) {
        return new C2062iy(this, runnable);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final NQ A0I() {
        C2116jz successfullyLoadedAdapter = (C2116jz) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0P() {
        C2116jz interstitialAdapter = (C2116jz) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2064j0
    public final void A0R(N1 n1, C1360Tw c1360Tw, C1358Tu c1358Tu, O8 o8) {
        C2116jz c2116jz = (C2116jz) n1;
        C2063iz c2063iz = new C2063iz(this, o8, c2116jz);
        A0H().postDelayed(c2063iz, c1360Tw.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
        }
        c2116jz.A0A(this.A0B, A00(c2063iz), o8, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}

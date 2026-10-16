package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.7y, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C08177y extends AbstractC2068j4 {
    public final /* synthetic */ C08157w A00;
    public final /* synthetic */ AbstractC2098jh A01;
    public final /* synthetic */ C08047l A02;
    public final /* synthetic */ boolean A03;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C08177y(C08157w c08157w, boolean z, boolean z2, C08047l c08047l, AbstractC2098jh abstractC2098jh) {
        super(z);
        this.A00 = c08157w;
        this.A03 = z2;
        this.A02 = c08047l;
        this.A01 = abstractC2098jh;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2068j4
    public final void A00() {
        NJ nj;
        nj = this.A00.A01;
        nj.AFp(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2068j4
    public final void A01(boolean z) {
        C1929gi c1929gi;
        WK wk;
        AtomicBoolean atomicBoolean;
        NJ nj;
        C1929gi c1929gi2;
        C1929gi c1929gi3;
        c1929gi = this.A00.A04;
        if (!C1379Up.A1t(c1929gi) || !this.A03) {
            wk = this.A00.A05;
            if (wk == WK.A0J) {
                c1929gi2 = this.A00.A04;
                c1929gi2.A0F().AER();
            }
            atomicBoolean = this.A00.A0C;
            atomicBoolean.set(true);
            nj = this.A00.A01;
            nj.AFm(this.A01);
            return;
        }
        C08157w c08157w = this.A00;
        c1929gi3 = this.A00.A04;
        c08157w.A06 = AbstractC1714dD.A01(c1929gi3, this.A02, 0, new C2107jq(this));
    }
}

package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.jr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2108jr implements SM {
    public final /* synthetic */ C08157w A00;
    public final /* synthetic */ boolean A01;

    public C2108jr(C08157w c08157w, boolean z) {
        this.A00 = c08157w;
        this.A01 = z;
    }

    @Override // com.instagram.common.viewpoint.core.SM
    public final void ACx() {
        C1929gi c1929gi;
        AtomicBoolean atomicBoolean;
        NJ nj;
        C1929gi c1929gi2;
        NQ nq;
        c1929gi = this.A00.A04;
        if (!C1379Up.A1t(c1929gi) || !this.A01) {
            atomicBoolean = this.A00.A0C;
            atomicBoolean.set(true);
            nj = this.A00.A01;
            nj.AFm(this.A00);
            return;
        }
        C08157w c08157w = this.A00;
        c1929gi2 = this.A00.A04;
        nq = this.A00.A03;
        c08157w.A06 = AbstractC1714dD.A01(c1929gi2, (C08047l) nq, 0, new C2109js(this));
    }

    @Override // com.instagram.common.viewpoint.core.SM
    public final void ACy() {
        NJ nj;
        nj = this.A00.A01;
        nj.AFp(this.A00, AdError.CACHE_ERROR);
    }
}

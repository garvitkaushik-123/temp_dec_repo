package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.jt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2110jt implements InterfaceC1327Sp {
    public final /* synthetic */ C08157w A00;

    public C2110jt(C08157w c08157w) {
        this.A00 = c08157w;
    }

    private void A00(boolean z) {
        NJ nj;
        AtomicBoolean atomicBoolean;
        NJ nj2;
        if (!z) {
            nj = this.A00.A01;
            nj.AFp(this.A00, AdError.CACHE_ERROR);
        } else {
            atomicBoolean = this.A00.A0C;
            atomicBoolean.set(true);
            nj2 = this.A00.A01;
            nj2.AFm(this.A00);
        }
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

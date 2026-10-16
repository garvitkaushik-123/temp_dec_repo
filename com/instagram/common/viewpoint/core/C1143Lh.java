package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Lh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1143Lh extends AbstractRunnableC1416Wc {
    public final WeakReference<C1874fp> A00;

    public C1143Lh(C1874fp c1874fp) {
        this.A00 = new WeakReference<>(c1874fp);
    }

    public C1143Lh(WeakReference<C1874fp> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C1874fp viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}

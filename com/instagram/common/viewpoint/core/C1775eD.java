package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* renamed from: com.facebook.ads.redexgen.X.eD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1775eD extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C1925ge A00;

    public C1775eD(C1925ge c1925ge) {
        this.A00 = c1925ge;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null) {
            dynamicLoader.createBidderTokenProviderApi().getBidderToken(this.A00);
        }
    }
}

package com.ironsource;

import com.ironsource.mediationsdk.ISBannerSize;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class T2 extends C3256q0 {
    private final ISBannerSize b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T2(C3070f0 adProperties, ISBannerSize iSBannerSize) {
        super(adProperties);
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        this.b = iSBannerSize;
    }

    @Override // com.ironsource.C3256q0, com.ironsource.InterfaceC3106h2
    public void a(com.ironsource.mediationsdk.i auctionRequestParams) {
        Intrinsics.checkNotNullParameter(auctionRequestParams, "auctionRequestParams");
        super.a(auctionRequestParams);
        auctionRequestParams.a(this.b);
    }
}

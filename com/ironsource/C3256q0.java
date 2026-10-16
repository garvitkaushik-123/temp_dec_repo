package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.q0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3256q0 implements InterfaceC3106h2 {

    /* renamed from: a, reason: collision with root package name */
    private final C3070f0 f3646a;

    public C3256q0(C3070f0 adProperties) {
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        this.f3646a = adProperties;
    }

    @Override // com.ironsource.InterfaceC3106h2
    public void a(com.ironsource.mediationsdk.i auctionRequestParams) {
        Intrinsics.checkNotNullParameter(auctionRequestParams, "auctionRequestParams");
        auctionRequestParams.b(this.f3646a.c());
        auctionRequestParams.a(this.f3646a.a().toString());
        auctionRequestParams.a(Boolean.TRUE);
    }
}

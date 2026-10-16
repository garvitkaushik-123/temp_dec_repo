package com.instagram.common.viewpoint.core;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* renamed from: com.facebook.ads.redexgen.X.6y, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C07916y implements InterfaceC1359Tv {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C07916y(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.instagram.common.viewpoint.core.VP
    public final void ACm() {
        WT.A00(new C1354Tq(this));
    }

    @Override // com.instagram.common.viewpoint.core.VP
    public final void ACq() {
        WT.A00(new C1355Tr(this));
    }

    @Override // com.instagram.common.viewpoint.core.VP
    public final void ADp(C1401Vm c1401Vm) {
        WT.A00(new C1357Tt(this, c1401Vm));
    }

    @Override // com.instagram.common.viewpoint.core.VP
    public final void AEl() {
        WT.A00(new C1353Tp(this));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1359Tv
    public final void AEq() {
        WT.A00(new C1356Ts(this));
    }
}

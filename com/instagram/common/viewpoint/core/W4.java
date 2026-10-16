package com.instagram.common.viewpoint.core;

import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;

/* loaded from: assets/audience_network/classes2.dex */
public class W4 implements VX {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ C1413Vz A01;

    public W4(C1413Vz c1413Vz, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = c1413Vz;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.instagram.common.viewpoint.core.VX
    public final void AJU() {
        this.A01.A00 = 1.0f;
        this.A00.setVolume(1.0f);
    }

    @Override // com.instagram.common.viewpoint.core.VX
    public final void AJZ(NativeAd nativeAd) {
        this.A01.A02 = nativeAd.getNativeOptions();
        this.A01.A0G();
        this.A01.A0H();
        this.A01.A0Q(UK.A0L(nativeAd.getInternalNativeAd()), new W0(UK.A0L(nativeAd.getInternalNativeAd())));
    }

    @Override // com.instagram.common.viewpoint.core.VX
    public final void AKY() {
        this.A01.A0J();
    }
}

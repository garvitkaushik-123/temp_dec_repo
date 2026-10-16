package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class KV implements XN {
    public final /* synthetic */ C6H A00;

    public KV(C6H c6h) {
        this.A00 = c6h;
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        AbstractC1464Yb abstractC1464Yb;
        AbstractC1464Yb abstractC1464Yb2;
        this.A00.A0B = false;
        abstractC1464Yb = this.A00.A05;
        if (abstractC1464Yb != null) {
            abstractC1464Yb2 = this.A00.A05;
            abstractC1464Yb2.setToolbarActionMode(this.A00.getCloseButtonStyle());
        }
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
        AbstractC1464Yb abstractC1464Yb;
        AbstractC1464Yb abstractC1464Yb2;
        abstractC1464Yb = this.A00.A05;
        if (abstractC1464Yb != null) {
            abstractC1464Yb2 = this.A00.A05;
            abstractC1464Yb2.setProgressImmediate(100.0f * (1.0f - (f / this.A00.getAdInfo().A0K().A00())));
        }
    }
}

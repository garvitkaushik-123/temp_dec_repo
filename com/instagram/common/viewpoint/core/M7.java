package com.instagram.common.viewpoint.core;

import android.widget.ImageView;

/* loaded from: assets/audience_network/classes2.dex */
public class M7 implements InterfaceC1568ar {
    public final /* synthetic */ M6 A00;

    public M7(M6 m6) {
        this.A00 = m6;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1568ar
    public final void ADB(boolean z) {
        boolean z2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        this.A00.A0D(z);
        z2 = this.A00.A0B;
        if (z2) {
            imageView = this.A00.A00;
            if (imageView != null) {
                imageView2 = this.A00.A00;
                imageView2.setEnabled(z);
                imageView3 = this.A00.A00;
                imageView3.setAlpha(z ? 1.0f : 0.3f);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1568ar
    public final void ADx(boolean z) {
        boolean z2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        this.A00.A0D(z);
        z2 = this.A00.A0B;
        if (z2) {
            imageView = this.A00.A02;
            if (imageView != null) {
                imageView2 = this.A00.A02;
                imageView2.setEnabled(z);
                imageView3 = this.A00.A02;
                imageView3.setAlpha(z ? 1.0f : 0.3f);
            }
        }
    }
}

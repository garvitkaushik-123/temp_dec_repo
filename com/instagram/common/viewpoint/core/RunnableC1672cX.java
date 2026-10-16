package com.instagram.common.viewpoint.core;

import android.widget.ImageView;

/* renamed from: com.facebook.ads.redexgen.X.cX, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1672cX implements Runnable {
    public final /* synthetic */ KB A00;

    public RunnableC1672cX(KB kb) {
        this.A00 = kb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView;
        ImageView imageView2;
        if (WU.A02(this)) {
            return;
        }
        try {
            imageView = this.A00.A03;
            if (imageView != null) {
                imageView2 = this.A00.A03;
                if (imageView2.getVisibility() == 0) {
                    this.A00.A0T(8);
                }
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

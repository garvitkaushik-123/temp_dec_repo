package com.instagram.common.viewpoint.core;

import android.widget.ImageView;

/* renamed from: com.facebook.ads.redexgen.X.a2, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1517a2 implements Runnable {
    public final /* synthetic */ C1519a4 A00;

    public RunnableC1517a2(C1519a4 c1519a4) {
        this.A00 = c1519a4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView;
        if (WU.A02(this)) {
            return;
        }
        try {
            imageView = this.A00.A02;
            if (imageView.getVisibility() == 0) {
                this.A00.A07(8);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

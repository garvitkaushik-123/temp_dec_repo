package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.bC, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1589bC {
    public static void A00(View view, boolean z, View.OnClickListener onClickListener) {
        if (!z) {
            view.setOnClickListener(onClickListener);
        } else {
            if (!z) {
                return;
            }
            ViewOnClickListenerC1588bB viewOnClickListenerC1588bB = new ViewOnClickListenerC1588bB(onClickListener);
            view.setOnClickListener(viewOnClickListenerC1588bB);
            view.setOnTouchListener(new ViewOnTouchListenerC1587bA(viewOnClickListenerC1588bB));
        }
    }
}

package com.instagram.common.viewpoint.core;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* renamed from: com.facebook.ads.redexgen.X.aC, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1527aC extends ViewOutlineProvider {
    public final /* synthetic */ float A00;
    public final /* synthetic */ C1534aJ A01;

    public C1527aC(C1534aJ c1534aJ, float f) {
        this.A01 = c1534aJ;
        this.A00 = f;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(XV.A00, XV.A00, view.getWidth(), view.getHeight(), this.A00);
    }
}

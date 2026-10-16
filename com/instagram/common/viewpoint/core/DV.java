package com.instagram.common.viewpoint.core;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public class DV extends AbstractRunnableC1416Wc {
    public final /* synthetic */ DS A00;

    public DV(DS ds) {
        this.A00 = ds;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        View view;
        Drawable drawable;
        this.A00.A02 = EnumC1842fJ.A04;
        view = this.A00.A07;
        drawable = this.A00.A05;
        YB.A0V(view, drawable);
    }
}

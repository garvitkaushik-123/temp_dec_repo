package com.instagram.common.viewpoint.core;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public class DY extends AbstractRunnableC1416Wc {
    public final /* synthetic */ DS A00;

    public DY(DS ds) {
        this.A00 = ds;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        View view;
        Drawable drawable;
        this.A00.A02 = EnumC1842fJ.A02;
        view = this.A00.A07;
        drawable = this.A00.A04;
        YB.A0V(view, drawable);
    }
}

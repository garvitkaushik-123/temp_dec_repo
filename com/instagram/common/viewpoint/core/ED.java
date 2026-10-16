package com.instagram.common.viewpoint.core;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class ED extends RelativeLayout implements InterfaceC1817eu {
    public C0966Ek A00;

    public ED(C1929gi c1929gi) {
        super(c1929gi);
    }

    public ED(C1929gi c1929gi, AttributeSet attributeSet, int i) {
        super(c1929gi, attributeSet, i);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(params);
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1817eu
    public final void AAv(C0966Ek c0966Ek) {
        this.A00 = c0966Ek;
        A07();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1817eu
    public final void AKV(C0966Ek c0966Ek) {
        A08();
        this.A00 = null;
    }

    public C0966Ek getVideoView() {
        return this.A00;
    }
}

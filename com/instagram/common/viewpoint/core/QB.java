package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class QB extends AbstractRunnableC1416Wc {
    public final /* synthetic */ ViewOnSystemUiVisibilityChangeListenerC1460Xx A00;

    public QB(ViewOnSystemUiVisibilityChangeListenerC1460Xx viewOnSystemUiVisibilityChangeListenerC1460Xx) {
        this.A00 = viewOnSystemUiVisibilityChangeListenerC1460Xx;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        this.A00.A02(false);
    }
}

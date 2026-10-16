package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* loaded from: assets/audience_network/classes2.dex */
public class W0 implements VV {
    public WeakReference<UK> A00;

    public W0(UK uk) {
        this.A00 = new WeakReference<>(uk);
    }

    @Override // com.instagram.common.viewpoint.core.VV
    public final void AFB(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1o(z, false);
        }
    }
}

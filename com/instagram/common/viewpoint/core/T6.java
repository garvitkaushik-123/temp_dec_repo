package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network/classes2.dex */
public final class T6 {
    public final AtomicBoolean A00 = new AtomicBoolean(false);

    public final void A00(boolean z) {
        this.A00.set(z);
    }

    public final boolean A01() {
        return this.A00.get();
    }
}

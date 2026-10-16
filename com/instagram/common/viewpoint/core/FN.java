package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public final class FN implements Runnable {
    public final FM A00;

    public FN(FM fm) {
        this.A00 = fm;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.AEj();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

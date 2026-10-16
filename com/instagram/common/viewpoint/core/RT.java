package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class RT implements Runnable {
    public final /* synthetic */ RU A00;

    public RT(RU ru) {
        this.A00 = ru;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A05 = 0L;
            this.A00.A06 = false;
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}

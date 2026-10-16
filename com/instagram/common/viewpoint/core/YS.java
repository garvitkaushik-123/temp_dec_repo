package com.instagram.common.viewpoint.core;

import java.util.concurrent.Executor;

/* loaded from: assets/audience_network/classes2.dex */
public final class YS {
    public static YS A02;
    public final C1252Pp A00;
    public final YU A01;

    public YS(C1929gi c1929gi, Executor executor, C1360Tw c1360Tw) {
        this.A01 = new YU(c1929gi);
        this.A00 = new C1252Pp(executor, c1360Tw, c1929gi);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C1929gi c1929gi, Executor executor, C1360Tw c1360Tw) {
        if (!C1379Up.A1c(c1929gi)) {
            return;
        }
        if (A02 == null) {
            A02 = new YS(c1929gi, executor, c1360Tw);
            A02.A00();
        } else {
            A02.A02(c1360Tw);
        }
    }

    private void A02(C1360Tw c1360Tw) {
        this.A00.A07(c1360Tw);
    }
}

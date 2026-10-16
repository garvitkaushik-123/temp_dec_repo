package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* renamed from: com.facebook.ads.redexgen.X.qP, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2494qP implements InterfaceC06923b {
    public final C2454pj A00 = new C2454pj();

    @MetaExoPlayerCustomization("Should be final")
    public abstract void A0H(int i, long j);

    public final int A00() {
        long A77 = A77();
        long A7s = A7s();
        if (A77 == -9223372036854775807L || A7s == -9223372036854775807L) {
            return 0;
        }
        if (A7s == 0) {
            return 100;
        }
        return C5C.A07((int) ((100 * A77) / A7s), 0, 100);
    }

    public void A01() {
        AKG(false);
    }

    public final void A02() {
        A03(A7h());
    }

    public final void A03(int i) {
        A0H(i, -9223372036854775807L);
    }

    public final void A04(long j) {
        A0H(A7h(), j);
    }
}

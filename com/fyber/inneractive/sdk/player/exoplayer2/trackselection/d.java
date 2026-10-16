package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class d extends g {
    public final AtomicReference c = new AtomicReference(new c());

    public static boolean a(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }
}

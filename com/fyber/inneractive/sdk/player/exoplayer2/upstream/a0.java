package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes4.dex */
public final class a0 extends IOException {
    public a0(Throwable th) {
        super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
    }
}

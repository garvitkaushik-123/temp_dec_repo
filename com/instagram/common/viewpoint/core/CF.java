package com.instagram.common.viewpoint.core;

import android.os.SystemClock;

/* loaded from: assets/audience_network/classes2.dex */
public final class CF implements InterfaceC1985hc {
    public static final CF A00 = new CF();

    public static CF A00() {
        return A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1985hc
    public final long ACf() {
        return SystemClock.elapsedRealtime();
    }
}

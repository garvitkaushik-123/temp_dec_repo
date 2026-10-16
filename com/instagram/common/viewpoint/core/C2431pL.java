package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* renamed from: com.facebook.ads.redexgen.X.pL, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2431pL implements AnonymousClass45 {
    @Override // com.instagram.common.viewpoint.core.AnonymousClass45
    public final C2429pJ A5P(Looper looper, Handler.Callback callback) {
        return new C2429pJ(new Handler(looper, callback));
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass45
    public final long A6J() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass45
    public final long AKe() {
        return SystemClock.uptimeMillis();
    }
}

package com.instagram.common.viewpoint.core;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.ads.redexgen.X.9N, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final /* synthetic */ class C9N implements Executor {
    public final /* synthetic */ Handler A00;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.A00.post(runnable);
    }
}

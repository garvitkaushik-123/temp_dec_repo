package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class T7 implements N1 {
    @Override // com.ironsource.N1
    public void a(W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IronLog.INTERNAL.verbose("Adding lifecycle event observer");
        com.ironsource.lifecycle.b.d().a(observer);
    }

    @Override // com.ironsource.N1
    public void b(W9 observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        IronLog.INTERNAL.verbose("Removing lifecycle event observer");
        com.ironsource.lifecycle.b.d().b(observer);
    }
}

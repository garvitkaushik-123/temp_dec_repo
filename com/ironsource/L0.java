package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface L0 {
    default void a() {
    }

    void a(IronSourceError ironSourceError);

    void a(C3289s0 c3289s0);

    default void b(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
    }
}

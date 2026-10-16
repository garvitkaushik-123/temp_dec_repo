package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface I {
    default void a(C3393y2 bannerAdInstance) {
        Intrinsics.checkNotNullParameter(bannerAdInstance, "bannerAdInstance");
    }

    default void a(C3127i6 fullscreenAdInstance) {
        Intrinsics.checkNotNullParameter(fullscreenAdInstance, "fullscreenAdInstance");
    }

    default void a(Fb nativeAdInstance) {
        Intrinsics.checkNotNullParameter(nativeAdInstance, "nativeAdInstance");
    }
}

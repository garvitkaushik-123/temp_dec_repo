package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface M0 {
    void a();

    void a(IronSourceError ironSourceError);

    void b(LevelPlayAdInfo levelPlayAdInfo);

    default void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }
}

package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* loaded from: classes6.dex */
public interface Eb {
    void a(LevelPlayAdInfo levelPlayAdInfo);

    void b(LevelPlayAdInfo levelPlayAdInfo);

    void onNativeAdLoadFailed(IronSourceError ironSourceError);
}

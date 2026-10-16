package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;

@Deprecated
/* loaded from: classes6.dex */
public interface LevelPlayRewardedVideoManualListener extends LevelPlayRewardedVideoBaseListener {
    void onAdLoadFailed(IronSourceError ironSourceError);

    void onAdReady(AdInfo adInfo);
}

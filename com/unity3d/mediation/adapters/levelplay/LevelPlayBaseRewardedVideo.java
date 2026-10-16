package com.unity3d.mediation.adapters.levelplay;

import com.ironsource.A3;
import com.ironsource.mediationsdk.adunit.adapter.BaseRewardedVideo;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.p;
import com.unity3d.mediation.adapters.levelplay.LevelPlayBaseAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class LevelPlayBaseRewardedVideo<NetworkAdapter extends LevelPlayBaseAdapter> extends BaseRewardedVideo<NetworkAdapter> implements A3 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelPlayBaseRewardedVideo(NetworkSettings networkSettings) {
        super(networkSettings);
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
    }

    @Override // com.ironsource.A3
    public void collectBiddingData(AdData adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
    }

    protected final String getDynamicUserId() {
        return p.j().i();
    }
}

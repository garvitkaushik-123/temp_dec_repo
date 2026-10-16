package com.mbridge.msdk.videocommon.listener;

import com.mbridge.msdk.foundation.same.report.metrics.c;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

/* loaded from: classes6.dex */
public interface InterVideoOutListener {
    void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo);

    void onAdCloseWithIVReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo);

    void onAdShow(MBridgeIds mBridgeIds);

    void onEndcardShow(MBridgeIds mBridgeIds);

    void onLoadSuccess(MBridgeIds mBridgeIds);

    void onShowFail(c cVar, MBridgeIds mBridgeIds, String str);

    void onVideoAdClicked(boolean z, MBridgeIds mBridgeIds);

    void onVideoComplete(MBridgeIds mBridgeIds);

    void onVideoLoadFail(MBridgeIds mBridgeIds, String str);

    void onVideoLoadSuccess(MBridgeIds mBridgeIds);
}

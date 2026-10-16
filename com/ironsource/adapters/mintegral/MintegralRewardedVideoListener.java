package com.ironsource.adapters.mintegral;

import com.ironsource.C3066ed;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.out.RewardVideoWithCodeListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MintegralRewardedVideoListener.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0015\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u001b\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ironsource/adapters/mintegral/MintegralRewardedVideoListener;", "Lcom/mbridge/msdk/out/RewardVideoWithCodeListener;", "placementId", "", "smashListener", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "adapterListener", "Lcom/ironsource/adapters/mintegral/MintegralAdapter;", "config", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Lorg/json/JSONObject;)V", "onAdClose", "", "bridgeIds", "Lcom/mbridge/msdk/out/MBridgeIds;", "rewardInfo", "Lcom/mbridge/msdk/out/RewardInfo;", "onAdShow", "onEndcardShow", C3066ed.f, "onShowFailWithCode", IronSourceConstants.EVENTS_ERROR_CODE, "", "errorMsg", "onVideoAdClicked", "onVideoComplete", "onVideoLoadFailWithCode", "onVideoLoadSuccess", "mintegraladapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MintegralRewardedVideoListener extends RewardVideoWithCodeListener {
    private final WeakReference<MintegralAdapter> adapterListener;
    private final JSONObject config;
    private final String placementId;
    private final WeakReference<RewardedVideoSmashListener> smashListener;

    public MintegralRewardedVideoListener(String placementId, WeakReference<RewardedVideoSmashListener> smashListener, WeakReference<MintegralAdapter> adapterListener, JSONObject config) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(smashListener, "smashListener");
        Intrinsics.checkNotNullParameter(adapterListener, "adapterListener");
        Intrinsics.checkNotNullParameter(config, "config");
        this.placementId = placementId;
        this.smashListener = smashListener;
        this.adapterListener = adapterListener;
        this.config = config;
    }

    @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.orglistener.g
    public void onVideoLoadSuccess(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.smashListener.get();
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.orglistener.g
    public void onLoadSuccess(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
    }

    @Override // com.mbridge.msdk.out.RewardVideoWithCodeListener
    public void onVideoLoadFailWithCode(MBridgeIds bridgeIds, int errorCode, String errorMsg) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId + "  errorCode=" + errorCode + " errorMsg=" + errorMsg);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.smashListener.get();
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.smashListener.get();
        if (rewardedVideoSmashListener2 != null) {
            if (errorCode == 708) {
                errorCode = 1058;
            }
            rewardedVideoSmashListener2.onRewardedVideoLoadFailed(new IronSourceError(errorCode, errorMsg));
        }
    }

    @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.orglistener.g
    public void onAdShow(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.smashListener.get();
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdOpened();
        }
    }

    @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.orglistener.g
    public void onAdClose(MBridgeIds bridgeIds, RewardInfo rewardInfo) {
        RewardedVideoSmashListener rewardedVideoSmashListener;
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId + " rewarded:" + (rewardInfo != null ? Boolean.valueOf(rewardInfo.isCompleteView()) : null));
        if (rewardInfo != null && rewardInfo.isCompleteView() && (rewardedVideoSmashListener = this.smashListener.get()) != null) {
            rewardedVideoSmashListener.onRewardedVideoAdRewarded();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.smashListener.get();
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdClosed();
        }
    }

    @Override // com.mbridge.msdk.out.RewardVideoWithCodeListener
    public void onShowFailWithCode(MBridgeIds bridgeIds, int errorCode, String errorMsg) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId + " errorCode=" + errorCode + " errorMsg=" + errorMsg);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.smashListener.get();
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.smashListener.get();
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdShowFailed(new IronSourceError(errorCode, errorMsg));
        }
    }

    @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.orglistener.g
    public void onVideoAdClicked(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.smashListener.get();
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdClicked();
        }
    }

    @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.orglistener.g
    public void onVideoComplete(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.smashListener.get();
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdEnded();
        }
    }

    @Override // com.mbridge.msdk.out.RewardVideoListener, com.mbridge.msdk.video.bt.module.orglistener.g
    public void onEndcardShow(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
    }
}

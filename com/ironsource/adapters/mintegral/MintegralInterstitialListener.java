package com.ironsource.adapters.mintegral;

import com.ironsource.C3355vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialWithCodeListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MintegralInterstitialListener.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u001c\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ironsource/adapters/mintegral/MintegralInterstitialListener;", "Lcom/mbridge/msdk/newinterstitial/out/NewInterstitialWithCodeListener;", "placementId", "", "smashListener", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "adapterListener", "Lcom/ironsource/adapters/mintegral/MintegralAdapter;", "config", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Lorg/json/JSONObject;)V", C3355vf.f, "", "bridgeIds", "Lcom/mbridge/msdk/out/MBridgeIds;", "onAdClose", "rewardInfo", "Lcom/mbridge/msdk/out/RewardInfo;", "onAdCloseWithNIReward", "onAdShow", "onEndcardShow", "onLoadCampaignSuccess", "onResourceLoadFailWithCode", IronSourceConstants.EVENTS_ERROR_CODE, "", "errorMsg", "onResourceLoadSuccess", "onShowFailWithCode", "onVideoComplete", "mintegraladapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MintegralInterstitialListener extends NewInterstitialWithCodeListener {
    private final WeakReference<MintegralAdapter> adapterListener;
    private final JSONObject config;
    private final String placementId;
    private final WeakReference<InterstitialSmashListener> smashListener;

    public MintegralInterstitialListener(String placementId, WeakReference<InterstitialSmashListener> smashListener, WeakReference<MintegralAdapter> adapterListener, JSONObject config) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(smashListener, "smashListener");
        Intrinsics.checkNotNullParameter(adapterListener, "adapterListener");
        Intrinsics.checkNotNullParameter(config, "config");
        this.placementId = placementId;
        this.smashListener = smashListener;
        this.adapterListener = adapterListener;
        this.config = config;
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onResourceLoadSuccess(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        InterstitialSmashListener interstitialSmashListener = this.smashListener.get();
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdReady();
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onLoadCampaignSuccess(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialWithCodeListener
    public void onResourceLoadFailWithCode(MBridgeIds bridgeIds, int errorCode, String errorMsg) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId + "  errorCode=" + errorCode + " errorMsg=" + errorMsg);
        MintegralAdapter mintegralAdapter = this.adapterListener.get();
        if (mintegralAdapter != null) {
            mintegralAdapter.disposeInterstitialAd(this.config);
        }
        InterstitialSmashListener interstitialSmashListener = this.smashListener.get();
        if (interstitialSmashListener != null) {
            if (errorCode == 708) {
                errorCode = 1158;
            }
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(errorCode, errorMsg));
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdShow(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        InterstitialSmashListener interstitialSmashListener = this.smashListener.get();
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdOpened();
        }
        InterstitialSmashListener interstitialSmashListener2 = this.smashListener.get();
        if (interstitialSmashListener2 != null) {
            interstitialSmashListener2.onInterstitialAdShowSucceeded();
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdClose(MBridgeIds bridgeIds, RewardInfo rewardInfo) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        MintegralAdapter mintegralAdapter = this.adapterListener.get();
        if (mintegralAdapter != null) {
            mintegralAdapter.disposeInterstitialAd(this.config);
        }
        InterstitialSmashListener interstitialSmashListener = this.smashListener.get();
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdClosed();
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialWithCodeListener
    public void onShowFailWithCode(MBridgeIds bridgeIds, int errorCode, String errorMsg) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId + " errorCode=" + errorCode + " errorMsg=" + errorMsg);
        MintegralAdapter mintegralAdapter = this.adapterListener.get();
        if (mintegralAdapter != null) {
            mintegralAdapter.disposeInterstitialAd(this.config);
        }
        InterstitialSmashListener interstitialSmashListener = this.smashListener.get();
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdShowFailed(new IronSourceError(errorCode, errorMsg));
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdClicked(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
        InterstitialSmashListener interstitialSmashListener = this.smashListener.get();
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onVideoComplete(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onAdCloseWithNIReward(MBridgeIds bridgeIds, RewardInfo rewardInfo) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
    }

    @Override // com.mbridge.msdk.newinterstitial.out.NewInterstitialListener
    public void onEndcardShow(MBridgeIds bridgeIds) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId=" + this.placementId);
    }
}

package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class z extends a<RewardedVideoAdListener> implements RewardedVideoSmashListener {
    public z(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, UUID uuid) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.REWARDED_VIDEO, uuid);
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.f3490a.loadRewardedVideoForBidding(jSONObject, jSONObject2, adData.getServerData(), this);
        } else {
            this.f3490a.loadRewardedVideo(jSONObject, jSONObject2, this);
        }
    }

    @Override // com.ironsource.mediationsdk.a
    protected void b(JSONObject jSONObject) {
        this.f3490a.disposeRewardedVideoAd(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.a
    protected boolean c(JSONObject jSONObject) {
        return this.f3490a.isRewardedVideoAvailable(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.a
    protected void f(JSONObject jSONObject) {
        this.f3490a.showRewardedVideo(jSONObject, this);
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdClicked();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdClosed();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdEnded();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdOpened();
            ((RewardedVideoAdListener) this.b.get()).onAdShowSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdRewarded();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdStarted();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdVisible();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z) {
        IronLog.INTERNAL.verbose(a("available = " + z));
        if (this.b.get() != null) {
            if (z) {
                ((RewardedVideoAdListener) this.b.get()).onAdLoadSuccess();
            } else {
                ((RewardedVideoAdListener) this.b.get()).onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, "");
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadFailed(b(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadSuccess();
        }
    }

    protected boolean b(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 1058;
    }

    @Override // com.ironsource.mediationsdk.a
    protected IronSource.AD_UNIT b() {
        return IronSource.AD_UNIT.REWARDED_VIDEO;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess(Map<String, Object> map) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadSuccess(map);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened(Map<String, Object> map) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdOpened(map);
            ((RewardedVideoAdListener) this.b.get()).onAdShowSuccess(map);
        }
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        this.f3490a.collectRewardedVideoBiddingData(jSONObject, jSONObject2, biddingDataCallback);
    }

    private boolean a(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 1057;
    }
}

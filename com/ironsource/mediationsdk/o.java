package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class o extends a<InterstitialAdListener> implements InterstitialSmashListener {
    public o(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, UUID uuid) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.INTERSTITIAL, uuid);
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.f3490a.loadInterstitialForBidding(jSONObject, jSONObject2, adData.getServerData(), this);
        } else {
            this.f3490a.loadInterstitial(jSONObject, jSONObject2, this);
        }
    }

    @Override // com.ironsource.mediationsdk.a
    protected void b(JSONObject jSONObject) {
        this.f3490a.disposeInterstitialAd(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.a
    protected boolean c(JSONObject jSONObject) {
        return this.f3490a.isInterstitialReady(jSONObject);
    }

    @Override // com.ironsource.mediationsdk.a
    protected void f(JSONObject jSONObject) {
        this.f3490a.showInterstitial(jSONObject, this);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdClicked();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdClosed();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdLoadFailed(a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdOpened();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdReady() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdLoadSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowSucceeded() {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdShowSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdVisible() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitSuccess() {
    }

    @Override // com.ironsource.mediationsdk.a
    protected IronSource.AD_UNIT b() {
        return IronSource.AD_UNIT.INTERSTITIAL;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdReady(Map<String, Object> map) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdLoadSuccess(map);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowSucceeded(Map<String, Object> map) {
        IronLog.ADAPTER_CALLBACK.verbose(a());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdShowSuccess(map);
        }
    }

    @Override // com.ironsource.mediationsdk.a
    protected void a(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        this.f3490a.collectInterstitialBiddingData(jSONObject, jSONObject2, biddingDataCallback);
    }

    protected boolean a(IronSourceError ironSourceError) {
        return ironSourceError.getErrorCode() == 1158;
    }
}

package com.ironsource.adapters.voodoo.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import com.ironsource.adapters.voodoo.VoodooAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnAdRequest;
import io.adn.sdk.publisher.AdnFullscreenAd;
import io.adn.sdk.publisher.AdnFullscreenAdListener;
import io.adn.sdk.publisher.AdnLoadTimeout;
import io.adn.sdk.publisher.AdnSdk;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: VoodooInterstitialAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001d\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\"J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010&\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ironsource/adapters/voodoo/interstitial/VoodooInterstitialAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractInterstitialAdapter;", "Lcom/ironsource/adapters/voodoo/VoodooAdapter;", N6.F1, "<init>", "(Lcom/ironsource/adapters/voodoo/VoodooAdapter;)V", "mPlacementIdToListener", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "mPlacementIdToAdListener", "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "mPlacementIdToAd", "Lio/adn/sdk/publisher/AdnFullscreenAd;", "mPlacementIdToAdAvailability", "", "initInterstitialForBidding", "", "appKey", "userId", "config", "Lorg/json/JSONObject;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onNetworkInitCallbackSuccess", "onNetworkInitCallbackFailed", "error", "loadInterstitialForBidding", "adData", C3207n2.s, C3040d4.g.H, "isInterstitialReady", "setInterstitialAdAvailability", "placementId", "isAvailable", "setInterstitialAdAvailability$adn_ironsource_adapter_release", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "collectInterstitialBiddingData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "adn-ironsource-adapter_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoodooInterstitialAdapter extends AbstractInterstitialAdapter<VoodooAdapter> {
    private final ConcurrentHashMap<String, AdnFullscreenAd> mPlacementIdToAd;
    private final ConcurrentHashMap<String, Boolean> mPlacementIdToAdAvailability;
    private final ConcurrentHashMap<String, AdnFullscreenAdListener> mPlacementIdToAdListener;
    private final ConcurrentHashMap<String, InterstitialSmashListener> mPlacementIdToListener;

    /* compiled from: VoodooInterstitialAdapter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VoodooAdapter.Companion.InitState.values().length];
            try {
                iArr[VoodooAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoodooAdapter.Companion.InitState.INIT_STATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoodooInterstitialAdapter(VoodooAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mPlacementIdToListener = new ConcurrentHashMap<>();
        this.mPlacementIdToAdListener = new ConcurrentHashMap<>();
        this.mPlacementIdToAd = new ConcurrentHashMap<>();
        this.mPlacementIdToAdAvailability = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String appKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String configStringValueFromKey = getConfigStringValueFromKey(config, VoodooAdapter.INSTANCE.getPlacementIdKey());
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey), "Interstitial"));
            return;
        }
        String configStringValueFromKey2 = getConfigStringValueFromKey(config, VoodooAdapter.INSTANCE.getAppIdKey());
        if (TextUtils.isEmpty(configStringValueFromKey2)) {
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey2), "Interstitial"));
            return;
        }
        IronLog.ADAPTER_API.verbose("appId = " + configStringValueFromKey2 + ", placementId = " + configStringValueFromKey);
        this.mPlacementIdToListener.put(configStringValueFromKey, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            IronLog.INTERNAL.verbose("onInterstitialInitSuccess - placementId = " + configStringValueFromKey);
            listener.onInterstitialInitSuccess();
        } else if (i == 2) {
            IronLog.INTERNAL.verbose("onInterstitialInitFailed - placementId = " + configStringValueFromKey);
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Voodoo sdk init failed", "Interstitial"));
        } else {
            getAdapter().initSdk(config);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Collection<InterstitialSmashListener> values = this.mPlacementIdToListener.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((InterstitialSmashListener) it.next()).onInterstitialInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        Collection<InterstitialSmashListener> values = this.mPlacementIdToListener.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((InterstitialSmashListener) it.next()).onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(error, "Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject adData, final String serverData, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config.optString(VoodooAdapter.INSTANCE.getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        Intrinsics.checkNotNull(optString);
        setInterstitialAdAvailability$adn_ironsource_adapter_release(optString, false);
        VoodooInterstitialAdListener voodooInterstitialAdListener = new VoodooInterstitialAdListener(new WeakReference(this), optString, listener);
        this.mPlacementIdToAdListener.put(optString, voodooInterstitialAdListener);
        Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
        Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "getCurrentActiveActivity(...)");
        final AdnFullscreenAd interstitialAdInstance = AdnSdk.getInterstitialAdInstance(currentActiveActivity, voodooInterstitialAdListener);
        this.mPlacementIdToAd.put(optString, interstitialAdInstance);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.voodoo.interstitial.VoodooInterstitialAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VoodooInterstitialAdapter.loadInterstitialForBidding$lambda$2(AdnFullscreenAd.this, serverData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadInterstitialForBidding$lambda$2(AdnFullscreenAd adnFullscreenAd, String str) {
        adnFullscreenAd.load(new AdnAdRequest.AdBidRequest(AdnAdPlacement.INTERSTITIAL, str, AdnLoadTimeout.MEDIATION));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String optString = config.optString(VoodooAdapter.INSTANCE.getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (isInterstitialReady(config)) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.voodoo.interstitial.VoodooInterstitialAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VoodooInterstitialAdapter.showInterstitial$lambda$3(VoodooInterstitialAdapter.this, optString);
                }
            });
        } else {
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
        Intrinsics.checkNotNull(optString);
        setInterstitialAdAvailability$adn_ironsource_adapter_release(optString, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInterstitial$lambda$3(VoodooInterstitialAdapter voodooInterstitialAdapter, String str) {
        AdnFullscreenAd adnFullscreenAd = voodooInterstitialAdapter.mPlacementIdToAd.get(str);
        if (adnFullscreenAd != null) {
            adnFullscreenAd.show();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        AdnFullscreenAd adnFullscreenAd;
        Intrinsics.checkNotNullParameter(config, "config");
        String configStringValueFromKey = getConfigStringValueFromKey(config, VoodooAdapter.INSTANCE.getPlacementIdKey());
        if (configStringValueFromKey.length() == 0) {
            return false;
        }
        Boolean bool = this.mPlacementIdToAdAvailability.get(configStringValueFromKey);
        if ((bool != null ? bool.booleanValue() : false) && (adnFullscreenAd = this.mPlacementIdToAd.get(configStringValueFromKey)) != null) {
            return adnFullscreenAd.isReady();
        }
        return false;
    }

    public final void setInterstitialAdAvailability$adn_ironsource_adapter_release(String placementId, boolean isAvailable) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        this.mPlacementIdToAdAvailability.put(placementId, Boolean.valueOf(isAvailable));
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Collection<AdnFullscreenAd> values = this.mPlacementIdToAd.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((AdnFullscreenAd) it.next()).destroy();
        }
        this.mPlacementIdToAd.clear();
        this.mPlacementIdToListener.clear();
        this.mPlacementIdToAdListener.clear();
        this.mPlacementIdToAdAvailability.clear();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback, AdnAdPlacement.INTERSTITIAL);
    }
}

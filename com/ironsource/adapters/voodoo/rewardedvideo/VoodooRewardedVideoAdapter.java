package com.ironsource.adapters.voodoo.rewardedvideo;

import android.app.Activity;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import com.ironsource.adapters.voodoo.VoodooAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
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

/* compiled from: VoodooRewardedVideoAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001d\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\"J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010&\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ironsource/adapters/voodoo/rewardedvideo/VoodooRewardedVideoAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractRewardedVideoAdapter;", "Lcom/ironsource/adapters/voodoo/VoodooAdapter;", N6.F1, "<init>", "(Lcom/ironsource/adapters/voodoo/VoodooAdapter;)V", "mPlacementIdToListener", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "mPlacementIdToAdListener", "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "mPlacementIdToAd", "Lio/adn/sdk/publisher/AdnFullscreenAd;", "mPlacementIdToAdAvailability", "", "initRewardedVideoWithCallback", "", "appKey", "userId", "config", "Lorg/json/JSONObject;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onNetworkInitCallbackSuccess", "onNetworkInitCallbackFailed", "error", "loadRewardedVideoForBidding", "adData", C3207n2.s, C3040d4.g.i, "isRewardedVideoAvailable", "setRewardedVideoAdAvailability", "placementId", "isAvailable", "setRewardedVideoAdAvailability$adn_ironsource_adapter_release", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "collectRewardedVideoBiddingData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "adn-ironsource-adapter_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoodooRewardedVideoAdapter extends AbstractRewardedVideoAdapter<VoodooAdapter> {
    private final ConcurrentHashMap<String, AdnFullscreenAd> mPlacementIdToAd;
    private final ConcurrentHashMap<String, Boolean> mPlacementIdToAdAvailability;
    private final ConcurrentHashMap<String, AdnFullscreenAdListener> mPlacementIdToAdListener;
    private final ConcurrentHashMap<String, RewardedVideoSmashListener> mPlacementIdToListener;

    /* compiled from: VoodooRewardedVideoAdapter.kt */
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
    public VoodooRewardedVideoAdapter(VoodooAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mPlacementIdToListener = new ConcurrentHashMap<>();
        this.mPlacementIdToAdListener = new ConcurrentHashMap<>();
        this.mPlacementIdToAd = new ConcurrentHashMap<>();
        this.mPlacementIdToAdAvailability = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String appKey, String userId, JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String configStringValueFromKey = getConfigStringValueFromKey(config, VoodooAdapter.INSTANCE.getPlacementIdKey());
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        String optString = config.optString(VoodooAdapter.INSTANCE.getAppIdKey());
        if (TextUtils.isEmpty(optString)) {
            Intrinsics.checkNotNull(optString);
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(optString), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronLog.ADAPTER_API.verbose("appId = " + optString + ", placementId = " + configStringValueFromKey);
        this.mPlacementIdToListener.put(configStringValueFromKey, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            IronLog.INTERNAL.verbose("onRewardedVideoInitSuccess - placementId = " + configStringValueFromKey);
            listener.onRewardedVideoInitSuccess();
        } else if (i == 2) {
            IronLog.INTERNAL.verbose("onRewardedVideoInitFailed - placementId = " + configStringValueFromKey);
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Voodoo sdk init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            getAdapter().initSdk(config);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Collection<RewardedVideoSmashListener> values = this.mPlacementIdToListener.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((RewardedVideoSmashListener) it.next()).onRewardedVideoInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        Collection<RewardedVideoSmashListener> values = this.mPlacementIdToListener.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((RewardedVideoSmashListener) it.next()).onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(error, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject adData, final String serverData, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config.optString(VoodooAdapter.INSTANCE.getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        Intrinsics.checkNotNull(optString);
        setRewardedVideoAdAvailability$adn_ironsource_adapter_release(optString, false);
        VoodooRewardedVideoAdListener voodooRewardedVideoAdListener = new VoodooRewardedVideoAdListener(new WeakReference(this), optString, listener);
        this.mPlacementIdToAdListener.put(optString, voodooRewardedVideoAdListener);
        Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
        Intrinsics.checkNotNullExpressionValue(currentActiveActivity, "getCurrentActiveActivity(...)");
        final AdnFullscreenAd rewardedAdInstance = AdnSdk.getRewardedAdInstance(currentActiveActivity, voodooRewardedVideoAdListener);
        this.mPlacementIdToAd.put(optString, rewardedAdInstance);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.voodoo.rewardedvideo.VoodooRewardedVideoAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VoodooRewardedVideoAdapter.loadRewardedVideoForBidding$lambda$2(AdnFullscreenAd.this, serverData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadRewardedVideoForBidding$lambda$2(AdnFullscreenAd adnFullscreenAd, String str) {
        adnFullscreenAd.load(new AdnAdRequest.AdBidRequest(AdnAdPlacement.REWARDED, str, AdnLoadTimeout.MEDIATION));
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String optString = config.optString(VoodooAdapter.INSTANCE.getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (isRewardedVideoAvailable(config)) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.voodoo.rewardedvideo.VoodooRewardedVideoAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VoodooRewardedVideoAdapter.showRewardedVideo$lambda$3(VoodooRewardedVideoAdapter.this, optString);
                }
            });
        } else {
            listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        Intrinsics.checkNotNull(optString);
        setRewardedVideoAdAvailability$adn_ironsource_adapter_release(optString, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRewardedVideo$lambda$3(VoodooRewardedVideoAdapter voodooRewardedVideoAdapter, String str) {
        AdnFullscreenAd adnFullscreenAd = voodooRewardedVideoAdapter.mPlacementIdToAd.get(str);
        if (adnFullscreenAd != null) {
            adnFullscreenAd.show();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
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

    public final void setRewardedVideoAdAvailability$adn_ironsource_adapter_release(String placementId, boolean isAvailable) {
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

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback, AdnAdPlacement.REWARDED);
    }
}

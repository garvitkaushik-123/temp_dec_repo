package com.ironsource.adapters.bidmachine.rewardedvideo;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import com.ironsource.adapters.bidmachine.BidMachineAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.bidmachine.AdsFormat;
import io.bidmachine.models.RequestBuilder;
import io.bidmachine.rewarded.RewardedAd;
import io.bidmachine.rewarded.RewardedRequest;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BidMachineRewardedVideoAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\r\u0010\u0016\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0017J,\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0015\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\nH\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0006H\u0000¢\u0006\u0002\b)J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ironsource/adapters/bidmachine/rewardedvideo/BidMachineRewardedVideoAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractRewardedVideoAdapter;", "Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;", N6.F1, "(Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;)V", "isRewardedVideoAdAvailable", "", "mRewardedRequest", "Lio/bidmachine/rewarded/RewardedRequest;", "mRewardedVideoAd", "Lio/bidmachine/rewarded/RewardedAd;", "mRewardedVideoAdListener", "Lcom/ironsource/adapters/bidmachine/rewardedvideo/BidMachineRewardedVideoAdListener;", "mRewardedVideoListener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "collectRewardedVideoBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "destroyRewardedVideoAd", "destroyRewardedVideoAd$bidmachineadapter_release", "initRewardedVideoWithCallback", "appKey", "", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isRewardedVideoAvailable", "loadRewardedVideoForBidding", C3207n2.s, "onNetworkInitCallbackSuccess", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "setRewardedVideoAd", "rewardedVideoAd", "setRewardedVideoAd$bidmachineadapter_release", "setRewardedVideoAdAvailability", "isAvailable", "setRewardedVideoAdAvailability$bidmachineadapter_release", C3040d4.g.i, "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BidMachineRewardedVideoAdapter extends AbstractRewardedVideoAdapter<BidMachineAdapter> {
    private boolean isRewardedVideoAdAvailable;
    private RewardedRequest mRewardedRequest;
    private RewardedAd mRewardedVideoAd;
    private BidMachineRewardedVideoAdListener mRewardedVideoAdListener;
    private RewardedVideoSmashListener mRewardedVideoListener;

    /* compiled from: BidMachineRewardedVideoAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BidMachineAdapter.Companion.InitState.values().length];
            try {
                iArr[BidMachineAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BidMachineAdapter.Companion.InitState.INIT_STATE_NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BidMachineAdapter.Companion.InitState.INIT_STATE_IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BidMachineRewardedVideoAdapter(BidMachineAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String appKey, String userId, JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        String sourceIdKey = BidMachineAdapter.INSTANCE.getSourceIdKey();
        String sourceId = config.optString(sourceIdKey);
        String str = sourceId;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(sourceIdKey));
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(sourceIdKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        this.mRewardedVideoListener = listener;
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            listener.onRewardedVideoInitSuccess();
        } else if (i == 2 || i == 3) {
            BidMachineAdapter adapter = getAdapter();
            Intrinsics.checkNotNullExpressionValue(sourceId, "sourceId");
            adapter.initSdk(sourceId);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mRewardedVideoListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject adData, String serverData, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        setRewardedVideoAdAvailability$bidmachineadapter_release(false);
        RewardedAd rewardedAd = new RewardedAd(ContextProvider.getInstance().getApplicationContext());
        BidMachineRewardedVideoAdListener bidMachineRewardedVideoAdListener = new BidMachineRewardedVideoAdListener(listener, new WeakReference(this));
        rewardedAd.setListener(bidMachineRewardedVideoAdListener);
        this.mRewardedVideoAdListener = bidMachineRewardedVideoAdListener;
        String optString = config.optString(BidMachineAdapter.INSTANCE.getPlacementIdKey());
        RequestBuilder bidPayload = new RewardedRequest.Builder().setBidPayload(serverData);
        Intrinsics.checkNotNullExpressionValue(bidPayload, "Builder()\n            .setBidPayload(serverData)");
        RewardedRequest.Builder builder = (RewardedRequest.Builder) bidPayload;
        String str = optString;
        if (str != null && str.length() != 0) {
            builder.setPlacementId(optString);
        }
        RewardedRequest rewardedRequest = (RewardedRequest) builder.build();
        this.mRewardedRequest = rewardedRequest;
        rewardedAd.load(rewardedRequest);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (!isRewardedVideoAvailable(config)) {
            listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            RewardedAd rewardedAd = this.mRewardedVideoAd;
            if (rewardedAd != null) {
                rewardedAd.show();
            }
        }
        setRewardedVideoAdAvailability$bidmachineadapter_release(false);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
        RewardedAd rewardedAd;
        Intrinsics.checkNotNullParameter(config, "config");
        return this.isRewardedVideoAdAvailable && (rewardedAd = this.mRewardedVideoAd) != null && rewardedAd.canShow() && !rewardedAd.isExpired();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback, AdsFormat.RewardedVideo, config);
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        IronLog.INTERNAL.verbose("adUnit = " + adUnit);
        if (adUnit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            destroyRewardedVideoAd$bidmachineadapter_release();
            this.mRewardedVideoListener = null;
            this.mRewardedVideoAdListener = null;
        }
    }

    public final void setRewardedVideoAd$bidmachineadapter_release(RewardedAd rewardedVideoAd) {
        Intrinsics.checkNotNullParameter(rewardedVideoAd, "rewardedVideoAd");
        this.mRewardedVideoAd = rewardedVideoAd;
    }

    public final void setRewardedVideoAdAvailability$bidmachineadapter_release(boolean isAvailable) {
        this.isRewardedVideoAdAvailable = isAvailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void destroyRewardedVideoAd$bidmachineadapter_release() {
        RewardedAd rewardedAd = this.mRewardedVideoAd;
        if (rewardedAd != null) {
        }
        RewardedAd rewardedAd2 = this.mRewardedVideoAd;
        if (rewardedAd2 != null) {
            rewardedAd2.destroy();
        }
        this.mRewardedVideoAd = null;
    }
}

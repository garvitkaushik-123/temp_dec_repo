package com.ironsource.adapters.bidmachine.interstitial;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import com.ironsource.adapters.bidmachine.BidMachineAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import io.bidmachine.AdsFormat;
import io.bidmachine.interstitial.InterstitialAd;
import io.bidmachine.interstitial.InterstitialRequest;
import io.bidmachine.models.RequestBuilder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BidMachineInterstitialAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\r\u0010\u0016\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0017J,\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J,\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0015\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\bH\u0000¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0006H\u0000¢\u0006\u0002\b)J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ironsource/adapters/bidmachine/interstitial/BidMachineInterstitialAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractInterstitialAdapter;", "Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;", N6.F1, "(Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;)V", "isinterstitialAdAvailable", "", "mInterstitialAd", "Lio/bidmachine/interstitial/InterstitialAd;", "mInterstitialAdListener", "Lcom/ironsource/adapters/bidmachine/interstitial/BidMachineInterstitialAdListener;", "mInterstitialListener", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "mInterstitialRequest", "Lio/bidmachine/interstitial/InterstitialRequest;", "collectInterstitialBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "destroyInterstitialAd", "destroyInterstitialAd$bidmachineadapter_release", "initInterstitialForBidding", "appKey", "", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isInterstitialReady", "loadInterstitialForBidding", C3207n2.s, "onNetworkInitCallbackSuccess", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "setInterstitialAd", "InterstitialAd", "setInterstitialAd$bidmachineadapter_release", "setInterstitialAdAvailability", "isAvailable", "setInterstitialAdAvailability$bidmachineadapter_release", C3040d4.g.H, "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BidMachineInterstitialAdapter extends AbstractInterstitialAdapter<BidMachineAdapter> {
    private boolean isinterstitialAdAvailable;
    private InterstitialAd mInterstitialAd;
    private BidMachineInterstitialAdListener mInterstitialAdListener;
    private InterstitialSmashListener mInterstitialListener;
    private InterstitialRequest mInterstitialRequest;

    /* compiled from: BidMachineInterstitialAdapter.kt */
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
    public BidMachineInterstitialAdapter(BidMachineAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String appKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        String sourceId = config.optString(BidMachineAdapter.INSTANCE.getSourceIdKey());
        if (TextUtils.isEmpty(sourceId)) {
            IronLog ironLog = IronLog.INTERNAL;
            Intrinsics.checkNotNullExpressionValue(sourceId, "sourceId");
            ironLog.error(getAdUnitIdMissingErrorString(sourceId));
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(sourceId), "Interstitial"));
            return;
        }
        this.mInterstitialListener = listener;
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            listener.onInterstitialInitSuccess();
        } else if (i == 2 || i == 3) {
            BidMachineAdapter adapter = getAdapter();
            Intrinsics.checkNotNullExpressionValue(sourceId, "sourceId");
            adapter.initSdk(sourceId);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        InterstitialSmashListener interstitialSmashListener = this.mInterstitialListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject adData, String serverData, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        setInterstitialAdAvailability$bidmachineadapter_release(false);
        InterstitialAd interstitialAd = new InterstitialAd(ContextProvider.getInstance().getApplicationContext());
        BidMachineInterstitialAdListener bidMachineInterstitialAdListener = new BidMachineInterstitialAdListener(new WeakReference(this), listener);
        interstitialAd.setListener(bidMachineInterstitialAdListener);
        this.mInterstitialAdListener = bidMachineInterstitialAdListener;
        String optString = config.optString(BidMachineAdapter.INSTANCE.getPlacementIdKey());
        RequestBuilder bidPayload = new InterstitialRequest.Builder().setBidPayload(serverData);
        Intrinsics.checkNotNullExpressionValue(bidPayload, "Builder()\n            .setBidPayload(serverData)");
        InterstitialRequest.Builder builder = (InterstitialRequest.Builder) bidPayload;
        String str = optString;
        if (str != null && str.length() != 0) {
            builder.setPlacementId(optString);
        }
        InterstitialRequest interstitialRequest = (InterstitialRequest) builder.build();
        this.mInterstitialRequest = interstitialRequest;
        interstitialAd.load(interstitialRequest);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (!isInterstitialReady(config)) {
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        } else {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null) {
                interstitialAd.show();
            }
        }
        setInterstitialAdAvailability$bidmachineadapter_release(false);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        InterstitialAd interstitialAd;
        Intrinsics.checkNotNullParameter(config, "config");
        return this.isinterstitialAdAvailable && (interstitialAd = this.mInterstitialAd) != null && interstitialAd.canShow() && !interstitialAd.isExpired();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback, AdsFormat.Interstitial, config);
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        IronLog.INTERNAL.verbose("adUnit = " + adUnit);
        if (adUnit == IronSource.AD_UNIT.INTERSTITIAL) {
            destroyInterstitialAd$bidmachineadapter_release();
            this.mInterstitialAdListener = null;
            this.mInterstitialListener = null;
        }
    }

    public final void setInterstitialAdAvailability$bidmachineadapter_release(boolean isAvailable) {
        this.isinterstitialAdAvailable = isAvailable;
    }

    public final void setInterstitialAd$bidmachineadapter_release(InterstitialAd InterstitialAd) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        this.mInterstitialAd = InterstitialAd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void destroyInterstitialAd$bidmachineadapter_release() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
        }
        InterstitialAd interstitialAd2 = this.mInterstitialAd;
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
        }
        this.mInterstitialAd = null;
    }
}

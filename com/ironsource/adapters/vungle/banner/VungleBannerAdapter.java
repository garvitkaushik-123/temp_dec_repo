package com.ironsource.adapters.vungle.banner;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.L2;
import com.ironsource.N6;
import com.ironsource.adapters.vungle.VungleAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adapter.AbstractBannerAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleBannerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: VungleBannerAdapter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J,\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\bH\u0016J,\u0010\u001b\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\bH\u0002J*\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\bH\u0016J4\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\bH\u0016J,\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u001a\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ironsource/adapters/vungle/banner/VungleBannerAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractBannerAdapter;", "Lcom/ironsource/adapters/vungle/VungleAdapter;", N6.F1, "(Lcom/ironsource/adapters/vungle/VungleAdapter;)V", "mBannerPlacementToListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mPlacementToBannerAd", "Lcom/vungle/ads/VungleBannerView;", "collectBannerBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", C3040d4.g.S, "getBannerSize", "Lcom/vungle/ads/VungleAdSize;", L2.u, "Lcom/ironsource/mediationsdk/ISBannerSize;", "initBannerForBidding", "appKey", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initBanners", "initBannersInternal", C3040d4.g.N, "banner", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "loadBannerForBidding", C3207n2.s, "loadBannerInternal", "placementId", "onNetworkInitCallbackFailed", "error", "onNetworkInitCallbackSuccess", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "vungleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VungleBannerAdapter extends AbstractBannerAdapter<VungleAdapter> {
    private final ConcurrentHashMap<String, BannerSmashListener> mBannerPlacementToListenerMap;
    private final ConcurrentHashMap<String, VungleBannerView> mPlacementToBannerAd;

    /* compiled from: VungleBannerAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VungleAdapter.Companion.InitState.values().length];
            try {
                iArr[VungleAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VungleAdapter.Companion.InitState.INIT_STATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VungleBannerAdapter(VungleAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mBannerPlacementToListenerMap = new ConcurrentHashMap<>();
        this.mPlacementToBannerAd = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String appKey, String userId, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        initBannersInternal(config, listener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(String appKey, String userId, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        initBannersInternal(config, listener);
    }

    private final void initBannersInternal(JSONObject config, BannerSmashListener listener) {
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        String appId = config.optString(VungleAdapter.APP_ID);
        String str = placementId;
        if (str == null || str.length() == 0) {
            IronLog ironLog = IronLog.INTERNAL;
            Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
            ironLog.error(getAdUnitIdMissingErrorString(placementId));
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementId), "Banner"));
            return;
        }
        String str2 = appId;
        if (str2 == null || str2.length() == 0) {
            IronLog ironLog2 = IronLog.INTERNAL;
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            ironLog2.error(getAdUnitIdMissingErrorString(appId));
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(appId), "Banner"));
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + placementId + ", appId = " + appId);
        ConcurrentHashMap<String, BannerSmashListener> concurrentHashMap = this.mBannerPlacementToListenerMap;
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        concurrentHashMap.put(placementId, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            listener.onBannerInitSuccess();
            return;
        }
        if (i == 2) {
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Vungle SDK init failed", "Banner"));
            return;
        }
        VungleAdapter adapter = getAdapter();
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getInstance().applicationContext");
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        adapter.initSDK(applicationContext, appId);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Collection<BannerSmashListener> values = this.mBannerPlacementToListenerMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mBannerPlacementToListenerMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((BannerSmashListener) it.next()).onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        Collection<BannerSmashListener> values = this.mBannerPlacementToListenerMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mBannerPlacementToListenerMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((BannerSmashListener) it.next()).onBannerInitFailed(ErrorBuilder.buildInitFailedError(error, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject adData, String serverData, IronSourceBannerLayout banner, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + placementId);
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        loadBannerInternal(placementId, banner, listener, serverData);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(JSONObject config, JSONObject adData, IronSourceBannerLayout banner, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String placementId = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + placementId);
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        loadBannerInternal(placementId, banner, listener, null);
    }

    private final void loadBannerInternal(String placementId, IronSourceBannerLayout banner, BannerSmashListener listener, String serverData) {
        IronLog.ADAPTER_API.verbose("placementId = " + placementId);
        if (banner == null) {
            IronLog.INTERNAL.verbose("banner is null");
            listener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
            return;
        }
        ISBannerSize size = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "banner.size");
        VungleAdSize bannerSize = getBannerSize(size);
        if (bannerSize == null) {
            listener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
            return;
        }
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getInstance().applicationContext");
        VungleBannerView vungleBannerView = new VungleBannerView(applicationContext, placementId, bannerSize);
        vungleBannerView.setAdListener(new VungleBannerAdListener(listener, placementId, vungleBannerView));
        this.mPlacementToBannerAd.put(placementId, vungleBannerView);
        IronLog.ADAPTER_API.verbose("bannerSize = " + bannerSize);
        vungleBannerView.load(serverData);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(final JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.vungle.banner.VungleBannerAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                VungleBannerAdapter.destroyBanner$lambda$4(config, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBanner$lambda$4(JSONObject config, VungleBannerAdapter this$0) {
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String optString = config.optString(VungleAdapter.PLACEMENT_ID);
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        VungleBannerView vungleBannerView = this$0.mPlacementToBannerAd.get(optString);
        if (vungleBannerView != null) {
            IronLog.ADAPTER_API.verbose("destroyBanner Vungle ad, with PlacementId - " + optString);
            vungleBannerView.finishAd();
            this$0.mPlacementToBannerAd.remove(optString);
        }
    }

    private final VungleAdSize getBannerSize(ISBannerSize bannerSize) {
        String description = bannerSize.getDescription();
        if (description == null) {
            return null;
        }
        switch (description.hashCode()) {
            case -387072689:
                if (description.equals("RECTANGLE")) {
                    return VungleAdSize.MREC;
                }
                return null;
            case 72205083:
                if (!description.equals("LARGE")) {
                    return null;
                }
                break;
            case 79011241:
                if (description.equals("SMART")) {
                    return AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? VungleAdSize.BANNER_LEADERBOARD : VungleAdSize.BANNER;
                }
                return null;
            case 1951953708:
                if (!description.equals("BANNER")) {
                    return null;
                }
                break;
            case 1999208305:
                if (description.equals("CUSTOM")) {
                    return VungleAdSize.INSTANCE.getAdSizeWithWidthAndHeight(bannerSize.getWidth(), bannerSize.getHeight());
                }
                return null;
            default:
                return null;
        }
        return VungleAdSize.BANNER;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        IronLog.INTERNAL.verbose("adUnit = " + adUnit);
        if (adUnit == IronSource.AD_UNIT.BANNER) {
            Collection<VungleBannerView> values = this.mPlacementToBannerAd.values();
            Intrinsics.checkNotNullExpressionValue(values, "mPlacementToBannerAd.values");
            for (final VungleBannerView vungleBannerView : values) {
                postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.vungle.banner.VungleBannerAdapter$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VungleBannerAdapter.releaseMemory$lambda$6$lambda$5(VungleBannerView.this);
                    }
                });
            }
            this.mBannerPlacementToListenerMap.clear();
            this.mPlacementToBannerAd.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseMemory$lambda$6$lambda$5(VungleBannerView bannerAd) {
        Intrinsics.checkNotNullParameter(bannerAd, "$bannerAd");
        bannerAd.finishAd();
    }
}

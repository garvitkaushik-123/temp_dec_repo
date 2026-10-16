package com.ironsource.adapters.bidmachine.banner;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.L2;
import com.ironsource.N6;
import com.ironsource.adapters.bidmachine.BidMachineAdapter;
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
import io.bidmachine.AdsFormat;
import io.bidmachine.banner.BannerRequest;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.banner.BannerView;
import io.bidmachine.models.RequestBuilder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BidMachineBannerAdapter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J,\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\bH\u0016J4\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0015\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\fH\u0000¢\u0006\u0002\b(R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ironsource/adapters/bidmachine/banner/BidMachineBannerAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractBannerAdapter;", "Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;", N6.F1, "(Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;)V", "mBannerAdListener", "Lcom/ironsource/adapters/bidmachine/banner/BidMachineBannerAdListener;", "mBannerListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mBannerRequest", "Lio/bidmachine/banner/BannerRequest;", "mBannerViewAd", "Lio/bidmachine/banner/BannerView;", "collectBannerBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", C3040d4.g.S, "destroyBannerViewAd", "getBannerSize", "Lio/bidmachine/banner/BannerSize;", L2.u, "Lcom/ironsource/mediationsdk/ISBannerSize;", "initBannerForBidding", "appKey", "", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "loadBannerForBidding", C3207n2.s, "banner", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "setBannerView", "ad", "setBannerView$bidmachineadapter_release", "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BidMachineBannerAdapter extends AbstractBannerAdapter<BidMachineAdapter> {
    private BidMachineBannerAdListener mBannerAdListener;
    private BannerSmashListener mBannerListener;
    private BannerRequest mBannerRequest;
    private BannerView mBannerViewAd;

    /* compiled from: BidMachineBannerAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            int[] iArr2 = new int[BannerSize.values().length];
            try {
                iArr2[BannerSize.Size_320x50.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BannerSize.Size_300x250.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BannerSize.Size_728x90.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BidMachineBannerAdapter(BidMachineAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String appKey, String userId, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        String sourceIdKey = BidMachineAdapter.INSTANCE.getSourceIdKey();
        String sourceId = config.optString(sourceIdKey);
        String str = sourceId;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(sourceIdKey));
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(sourceIdKey), "Banner"));
            return;
        }
        this.mBannerListener = listener;
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            listener.onBannerInitSuccess();
        } else if (i == 2 || i == 3) {
            BidMachineAdapter adapter = getAdapter();
            Intrinsics.checkNotNullExpressionValue(sourceId, "sourceId");
            adapter.initSdk(sourceId);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject adData, String serverData, final IronSourceBannerLayout banner, final BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        ISBannerSize size = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "banner.size");
        BannerSize bannerSize = getBannerSize(size);
        if (bannerSize == null) {
            listener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
            return;
        }
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        BidMachineBannerAdListener bidMachineBannerAdListener = new BidMachineBannerAdListener(listener, new WeakReference(this), new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, bannerSize.width), AdapterUtils.dpToPixels(applicationContext, bannerSize.height), 17));
        this.mBannerAdListener = bidMachineBannerAdListener;
        final BannerView bannerView = new BannerView(ContextProvider.getInstance().getApplicationContext());
        bannerView.setListener(bidMachineBannerAdListener);
        String optString = config.optString(BidMachineAdapter.INSTANCE.getPlacementIdKey());
        RequestBuilder bidPayload = new BannerRequest.Builder().setSize(bannerSize).setBidPayload(serverData);
        Intrinsics.checkNotNullExpressionValue(bidPayload, "Builder()\n            .s…setBidPayload(serverData)");
        BannerRequest.Builder builder = (BannerRequest.Builder) bidPayload;
        String str = optString;
        if (str != null && str.length() != 0) {
            builder.setPlacementId(optString);
        }
        this.mBannerRequest = (BannerRequest) builder.build();
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.bidmachine.banner.BidMachineBannerAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BidMachineBannerAdapter.loadBannerForBidding$lambda$0(IronSourceBannerLayout.this, listener, this, bannerView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadBannerForBidding$lambda$0(IronSourceBannerLayout banner, BannerSmashListener listener, BidMachineBannerAdapter this$0, BannerView bannerView) {
        Intrinsics.checkNotNullParameter(banner, "$banner");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerView, "$bannerView");
        bannerView.load((BannerView) this$0.mBannerRequest);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        IronLog.ADAPTER_API.verbose();
        destroyBannerViewAd();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        AdsFormat adsFormat;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        Object opt = adData != null ? adData.opt("bannerLayout") : null;
        if (!(opt instanceof IronSourceBannerLayout)) {
            IronLog.INTERNAL.verbose("Banner layout is invalid or not of type IronSourceBannerLayout");
            biddingDataCallback.onFailure("Banner layout is invalid or not of type IronSourceBannerLayout - BidMachine");
            return;
        }
        ISBannerSize size = ((IronSourceBannerLayout) opt).getSize();
        Intrinsics.checkNotNullExpressionValue(size, "size");
        BannerSize bannerSize = getBannerSize(size);
        if (bannerSize == null) {
            IronLog.INTERNAL.verbose("Unsupported or null banner size");
            biddingDataCallback.onFailure("Unsupported or null banner size - BidMachine");
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[bannerSize.ordinal()];
        if (i == 1) {
            adsFormat = AdsFormat.Banner_320x50;
        } else if (i == 2) {
            adsFormat = AdsFormat.Banner_300x250;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            adsFormat = AdsFormat.Banner_728x90;
        }
        getAdapter().collectBiddingData(biddingDataCallback, adsFormat, config);
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        IronLog.INTERNAL.verbose("adUnit = " + adUnit);
        if (adUnit == IronSource.AD_UNIT.BANNER) {
            destroyBannerViewAd();
        }
    }

    private final void destroyBannerViewAd() {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.bidmachine.banner.BidMachineBannerAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BidMachineBannerAdapter.destroyBannerViewAd$lambda$1(BidMachineBannerAdapter.this);
            }
        });
        this.mBannerViewAd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBannerViewAd$lambda$1(BidMachineBannerAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BannerView bannerView = this$0.mBannerViewAd;
        if (bannerView != null) {
            bannerView.setListener(null);
        }
        BannerView bannerView2 = this$0.mBannerViewAd;
        if (bannerView2 != null) {
            bannerView2.destroy();
        }
    }

    public final void setBannerView$bidmachineadapter_release(BannerView ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.mBannerViewAd = ad;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final BannerSize getBannerSize(ISBannerSize bannerSize) {
        if (bannerSize == null) {
            IronLog.INTERNAL.verbose("Banner size is null");
            return null;
        }
        String description = bannerSize.getDescription();
        if (description != null) {
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        return BannerSize.Size_300x250;
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        return AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()) ? BannerSize.Size_728x90 : BannerSize.Size_320x50;
                    }
                    break;
                case 446888797:
                    if (description.equals("LEADERBOARD")) {
                        return BannerSize.Size_728x90;
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        return BannerSize.Size_320x50;
                    }
                    break;
            }
        }
        return null;
    }
}

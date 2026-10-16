package com.ironsource.adapters.moloco.banner;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import com.ironsource.adapters.moloco.MolocoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adapter.AbstractBannerAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAdError;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MolocoBannerAdapter.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002JX\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001e2\u001e\b\u0002\u0010\"\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\u000e0#H\u0002J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u000eH\u0002J*\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001eH\u0002J,\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\fH\u0016J4\u0010,\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\u0012\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\u001a\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/ironsource/adapters/moloco/banner/MolocoBannerAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractBannerAdapter;", "Lcom/ironsource/adapters/moloco/MolocoAdapter;", N6.F1, "(Lcom/ironsource/adapters/moloco/MolocoAdapter;)V", "mAdLoadListener", "Lcom/ironsource/adapters/moloco/banner/MolocoBannerAdLoadListener;", "mAdShowListener", "Lcom/ironsource/adapters/moloco/banner/MolocoBannerAdShowListener;", "mAdView", "Lcom/moloco/sdk/publisher/Banner;", "mListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "collectBannerBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "createBannerLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "context", "Landroid/content/Context;", ContentDisposition.Parameters.Size, "Lcom/ironsource/mediationsdk/ISBannerSize;", "createBannerWithSize", "mediationInfo", "Lcom/moloco/sdk/publisher/MediationInfo;", "adUnitId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "layoutParams", C3207n2.s, "createCallback", "Lkotlin/Function2;", "Lcom/moloco/sdk/publisher/MolocoAdError$AdCreateError;", C3040d4.g.S, "destroyBannerViewAd", "handleBannerCreation", "adView", "initBannerForBidding", "appKey", "userId", "loadBannerForBidding", "banner", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "onNetworkInitCallbackFailed", "error", "onNetworkInitCallbackSuccess", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoBannerAdapter extends AbstractBannerAdapter<MolocoAdapter> {
    private MolocoBannerAdLoadListener mAdLoadListener;
    private MolocoBannerAdShowListener mAdShowListener;
    private Banner mAdView;
    private BannerSmashListener mListener;

    /* compiled from: MolocoBannerAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MolocoAdapter.Companion.InitState.values().length];
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_IN_PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MolocoBannerAdapter(MolocoAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String appKey, String userId, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        String configStringValueFromKey = getConfigStringValueFromKey(config, MolocoAdapter.INSTANCE.getAdUnitIdKey());
        String configStringValueFromKey2 = getConfigStringValueFromKey(config, MolocoAdapter.INSTANCE.getAppKey());
        if (configStringValueFromKey.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(configStringValueFromKey));
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey), "Banner"));
            return;
        }
        if (configStringValueFromKey2.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(configStringValueFromKey2));
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey2), "Banner"));
            return;
        }
        IronLog.ADAPTER_API.verbose("adUnitId = " + configStringValueFromKey + ", appKey = " + configStringValueFromKey2);
        this.mListener = listener;
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            listener.onBannerInitSuccess();
            return;
        }
        if (i == 2) {
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Moloco sdk init failed", "Banner"));
        } else if (i == 3 || i == 4) {
            getAdapter().initSdk(configStringValueFromKey2);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(error, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject adData, String serverData, IronSourceBannerLayout banner, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        String str = serverData;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("serverData is empty");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("serverData is empty"));
            return;
        }
        Context context = ContextProvider.getInstance().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISBannerSize size = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "banner.size");
        FrameLayout.LayoutParams createBannerLayoutParams = createBannerLayoutParams(context, size);
        String configStringValueFromKey = getConfigStringValueFromKey(config, MolocoAdapter.INSTANCE.getAdUnitIdKey());
        MediationInfo mediationInfo = MolocoAdapter.INSTANCE.getMediationInfo();
        ISBannerSize size2 = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size2, "banner.size");
        createBannerWithSize$default(this, size2, mediationInfo, configStringValueFromKey, listener, createBannerLayoutParams, serverData, null, 64, null);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        IronLog.ADAPTER_API.verbose();
        destroyBannerViewAd();
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
        IronLog.INTERNAL.verbose();
        destroyBannerViewAd();
        this.mAdLoadListener = null;
        this.mAdShowListener = null;
        this.mListener = null;
    }

    private final void destroyBannerViewAd() {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.moloco.banner.MolocoBannerAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MolocoBannerAdapter.destroyBannerViewAd$lambda$0(MolocoBannerAdapter.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBannerViewAd$lambda$0(MolocoBannerAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Banner banner = this$0.mAdView;
        if (banner != null) {
            banner.destroy();
        }
        this$0.mAdView = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final FrameLayout.LayoutParams createBannerLayoutParams(Context context, ISBannerSize size) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        String description = size.getDescription();
        if (description != null) {
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, 300), AdapterUtils.dpToPixels(context, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
                        break;
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        layoutParams = AdapterUtils.isLargeScreen(context) ? new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, 728), AdapterUtils.dpToPixels(context, 90)) : new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 50));
                        break;
                    }
                    break;
                case 446888797:
                    if (description.equals("LEADERBOARD")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, 728), AdapterUtils.dpToPixels(context, 90));
                        break;
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 50));
                        break;
                    }
                    break;
            }
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBannerCreation(Banner adView, BannerSmashListener listener, FrameLayout.LayoutParams layoutParams, String serverData) {
        if (adView != null) {
            this.mAdView = adView;
            this.mAdLoadListener = new MolocoBannerAdLoadListener(listener, layoutParams, adView);
            MolocoBannerAdShowListener molocoBannerAdShowListener = new MolocoBannerAdShowListener(listener);
            this.mAdShowListener = molocoBannerAdShowListener;
            Banner banner = this.mAdView;
            if (banner != null) {
                banner.setAdShowListener(molocoBannerAdShowListener);
                banner.load(serverData, this.mAdLoadListener);
            } else {
                banner = null;
            }
            if (banner != null) {
                return;
            }
        }
        listener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError(MolocoAdapter.INVALID_CONFIGURATION));
        Unit unit = Unit.INSTANCE;
    }

    static /* synthetic */ void createBannerWithSize$default(final MolocoBannerAdapter molocoBannerAdapter, ISBannerSize iSBannerSize, MediationInfo mediationInfo, String str, final BannerSmashListener bannerSmashListener, final FrameLayout.LayoutParams layoutParams, final String str2, Function2 function2, int i, Object obj) {
        molocoBannerAdapter.createBannerWithSize(iSBannerSize, mediationInfo, str, bannerSmashListener, layoutParams, str2, (i & 64) != 0 ? new Function2<Banner, MolocoAdError.AdCreateError, Unit>() { // from class: com.ironsource.adapters.moloco.banner.MolocoBannerAdapter$createBannerWithSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Banner banner, MolocoAdError.AdCreateError adCreateError) {
                invoke2(banner, adCreateError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Banner banner, MolocoAdError.AdCreateError adCreateError) {
                if (adCreateError == null) {
                    molocoBannerAdapter.handleBannerCreation(banner, BannerSmashListener.this, layoutParams, str2);
                    return;
                }
                IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError(String.valueOf(adCreateError.getErrorCode()), adCreateError.getDescription());
                Intrinsics.checkNotNullExpressionValue(buildShowFailedError, "buildShowFailedError(\n  …ription\n                )");
                BannerSmashListener.this.onBannerAdLoadFailed(buildShowFailedError);
            }
        } : function2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void createBannerWithSize(ISBannerSize size, MediationInfo mediationInfo, String adUnitId, BannerSmashListener listener, FrameLayout.LayoutParams layoutParams, String serverData, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> createCallback) {
        String description = size.getDescription();
        if (description != null) {
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        Moloco.createMREC(mediationInfo, adUnitId, null, createCallback);
                        return;
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())) {
                            Moloco.createBannerTablet(mediationInfo, adUnitId, null, createCallback);
                            return;
                        } else {
                            Moloco.createBanner(mediationInfo, adUnitId, null, createCallback);
                            return;
                        }
                    }
                    break;
                case 446888797:
                    if (description.equals("LEADERBOARD")) {
                        Moloco.createBannerTablet(mediationInfo, adUnitId, null, createCallback);
                        return;
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        Moloco.createBanner(mediationInfo, adUnitId, null, createCallback);
                        return;
                    }
                    break;
            }
        }
        Moloco.createBanner(mediationInfo, adUnitId, null, createCallback);
    }
}

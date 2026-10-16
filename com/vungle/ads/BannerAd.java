package com.vungle.ads;

import android.content.Context;
import com.ironsource.C3040d4;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.BannerAdInternal;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.AdPlayCallbackWrapper;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ThreadUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerAd.kt */
@Deprecated(message = "Use VungleBannerView instead")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0007J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/vungle/ads/BannerAd;", "Lcom/vungle/ads/BaseAd;", "context", "Landroid/content/Context;", "placementId", "", C3040d4.h.O, "Lcom/vungle/ads/VungleAdSize;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/VungleAdSize;)V", "Lcom/vungle/ads/BannerAdSize;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/BannerAdSize;)V", "adConfig", "Lcom/vungle/ads/AdConfig;", "(Landroid/content/Context;Ljava/lang/String;Lcom/vungle/ads/VungleAdSize;Lcom/vungle/ads/AdConfig;)V", "adPlayCallback", "Lcom/vungle/ads/internal/presenter/AdPlayCallbackWrapper;", "bannerView", "Lcom/vungle/ads/BannerView;", "constructAdInternal", "Lcom/vungle/ads/internal/BannerAdInternal;", "constructAdInternal$vungle_ads_release", "finishAd", "", "getAdViewSize", "getBannerView", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class BannerAd extends BaseAd {
    private final AdPlayCallbackWrapper adPlayCallback;
    private final VungleAdSize adSize;
    private BannerView bannerView;

    /* compiled from: BannerAd.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BannerAdSize.values().length];
            iArr[BannerAdSize.BANNER.ordinal()] = 1;
            iArr[BannerAdSize.BANNER_SHORT.ordinal()] = 2;
            iArr[BannerAdSize.BANNER_LEADERBOARD.ordinal()] = 3;
            iArr[BannerAdSize.VUNGLE_MREC.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BannerAd(Context context, String str, VungleAdSize vungleAdSize, AdConfig adConfig) {
        super(context, str, adConfig);
        this.adSize = vungleAdSize;
        AdInternal adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        Intrinsics.checkNotNull(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        this.adPlayCallback = ((BannerAdInternal) adInternal$vungle_ads_release).wrapCallback$vungle_ads_release(new AdPlayCallback() { // from class: com.vungle.ads.BannerAd$adPlayCallback$1
            @Override // com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdRewarded(String id) {
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdStart(String id) {
                BannerAd.this.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
                BannerAd.this.getAdInternal$vungle_ads_release().getValidationToPresentMetric().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAd.this.getAdInternal$vungle_ads_release().getValidationToPresentMetric(), BannerAd.this.getLogEntry(), (String) null, 4, (Object) null);
                BannerAd.this.getPresentToDisplayMetric().markStart();
                ThreadUtil threadUtil = ThreadUtil.INSTANCE;
                final BannerAd bannerAd = BannerAd.this;
                threadUtil.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$adPlayCallback$1$onAdStart$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BaseAdListener adListener = BannerAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdStart(BannerAd.this);
                        }
                    }
                });
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdImpression(String id) {
                ThreadUtil threadUtil = ThreadUtil.INSTANCE;
                final BannerAd bannerAd = BannerAd.this;
                threadUtil.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$adPlayCallback$1$onAdImpression$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BaseAdListener adListener = BannerAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdImpression(BannerAd.this);
                        }
                    }
                });
                BannerAd.this.getPresentToDisplayMetric().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAd.this.getPresentToDisplayMetric(), BannerAd.this.getLogEntry(), (String) null, 4, (Object) null);
                BannerAd.this.getDisplayToClickMetric().markStart();
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdEnd(String id) {
                ThreadUtil threadUtil = ThreadUtil.INSTANCE;
                final BannerAd bannerAd = BannerAd.this;
                threadUtil.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$adPlayCallback$1$onAdEnd$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BaseAdListener adListener = BannerAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdEnd(BannerAd.this);
                        }
                    }
                });
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdClick(String id) {
                ThreadUtil threadUtil = ThreadUtil.INSTANCE;
                final BannerAd bannerAd = BannerAd.this;
                threadUtil.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$adPlayCallback$1$onAdClick$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BaseAdListener adListener = BannerAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdClicked(BannerAd.this);
                        }
                    }
                });
                BannerAd.this.getDisplayToClickMetric().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAd.this.getDisplayToClickMetric(), BannerAd.this.getLogEntry(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallback
            public void onAdLeftApplication(String id) {
                ThreadUtil threadUtil = ThreadUtil.INSTANCE;
                final BannerAd bannerAd = BannerAd.this;
                threadUtil.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$adPlayCallback$1$onAdLeftApplication$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BaseAdListener adListener = BannerAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdLeftApplication(BannerAd.this);
                        }
                    }
                });
            }

            @Override // com.vungle.ads.internal.presenter.AdPlayCallback
            public void onFailure(final VungleError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                BannerAd.this.getShowToFailMetric().markEnd();
                AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(BannerAd.this.getShowToFailMetric(), BannerAd.this.getLogEntry(), String.valueOf(error.getCode()));
                ThreadUtil threadUtil = ThreadUtil.INSTANCE;
                final BannerAd bannerAd = BannerAd.this;
                threadUtil.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$adPlayCallback$1$onFailure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        BaseAdListener adListener = BannerAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdFailedToPlay(BannerAd.this, error);
                        }
                    }
                });
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerAd(Context context, String placementId, VungleAdSize adSize) {
        this(context, placementId, adSize, new AdConfig());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated(message = "Use VungleAdSize instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BannerAd(Context context, String placementId, BannerAdSize adSize) {
        this(context, placementId, r4, new AdConfig());
        VungleAdSize vungleAdSize;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        VungleAdSize.Companion companion = VungleAdSize.INSTANCE;
        int i = WhenMappings.$EnumSwitchMapping$0[adSize.ordinal()];
        if (i == 1) {
            vungleAdSize = VungleAdSize.BANNER;
        } else if (i == 2) {
            vungleAdSize = VungleAdSize.BANNER_SHORT;
        } else if (i == 3) {
            vungleAdSize = VungleAdSize.BANNER_LEADERBOARD;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            vungleAdSize = VungleAdSize.MREC;
        }
    }

    public final VungleAdSize getAdViewSize() {
        AdInternal adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        Intrinsics.checkNotNull(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        VungleAdSize updatedAdSize = ((BannerAdInternal) adInternal$vungle_ads_release).getUpdatedAdSize();
        return updatedAdSize == null ? this.adSize : updatedAdSize;
    }

    @Override // com.vungle.ads.BaseAd
    public BannerAdInternal constructAdInternal$vungle_ads_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new BannerAdInternal(context, this.adSize);
    }

    public final void finishAd() {
        ThreadUtil.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$finishAd$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BannerView bannerView;
                bannerView = BannerAd.this.bannerView;
                if (bannerView != null) {
                    bannerView.finishAdInternal(true);
                }
            }
        });
    }

    public final BannerView getBannerView() {
        Placement placement;
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk.SDKMetric.SDKMetricType.PLAY_AD_API), getLogEntry(), (String) null, 4, (Object) null);
        BannerView bannerView = this.bannerView;
        if (bannerView != null) {
            return bannerView;
        }
        getAdInternal$vungle_ads_release().getShowToValidationMetric().markStart();
        final VungleError canPlayAd = getAdInternal$vungle_ads_release().canPlayAd(true);
        if (canPlayAd != null) {
            if (getAdInternal$vungle_ads_release().isErrorTerminal$vungle_ads_release(canPlayAd.getCode())) {
                getAdInternal$vungle_ads_release().setAdState(AdInternal.AdState.ERROR);
            }
            ThreadUtil.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BannerAd$getBannerView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    BaseAdListener adListener = BannerAd.this.getAdListener();
                    if (adListener != null) {
                        adListener.onAdFailedToPlay(BannerAd.this, canPlayAd);
                    }
                }
            });
            return null;
        }
        AdPayload advertisement = getAdInternal$vungle_ads_release().getAdvertisement();
        if (advertisement == null || (placement = getAdInternal$vungle_ads_release().getPlacement()) == null) {
            return null;
        }
        getAdInternal$vungle_ads_release().cancelDownload$vungle_ads_release();
        try {
            try {
                this.bannerView = new BannerView(getContext(), placement, advertisement, getAdViewSize(), getAdConfig(), this.adPlayCallback, getAdInternal$vungle_ads_release().getBidPayload());
                getResponseToShowMetric().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric(), getLogEntry(), (String) null, 4, (Object) null);
                getAdInternal$vungle_ads_release().getShowToValidationMetric().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getAdInternal$vungle_ads_release().getShowToValidationMetric(), getLogEntry(), (String) null, 4, (Object) null);
                getAdInternal$vungle_ads_release().getValidationToPresentMetric().markStart();
                return this.bannerView;
            } catch (InstantiationException e) {
                Logger.INSTANCE.e("BannerAd", "Can not create banner view: " + e.getMessage(), e);
                getResponseToShowMetric().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric(), getLogEntry(), (String) null, 4, (Object) null);
                return null;
            }
        } catch (Throwable th) {
            getResponseToShowMetric().markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, getResponseToShowMetric(), getLogEntry(), (String) null, 4, (Object) null);
            throw th;
        }
    }
}

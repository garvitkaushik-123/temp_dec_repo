package io.bidmachine;

import android.graphics.Point;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.adcom.NativeDataAssetType;
import com.explorestack.protobuf.adcom.NativeImageAssetType;
import com.explorestack.protobuf.adcom.Placement;
import com.explorestack.protobuf.adcom.SizeUnit;
import com.explorestack.protobuf.adcom.VideoCreativeType;
import io.bidmachine.AdContentType;
import io.bidmachine.AdPlacementConfig;
import io.bidmachine.AdsType;
import io.bidmachine.ApiRequest;
import io.bidmachine.Constants;
import io.bidmachine.ContextProvider;
import io.bidmachine.MediaAssetType;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfig;
import io.bidmachine.ads.networks.nast.NastAdapter;
import io.bidmachine.ads.networks.vast.VastAdapter;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.core.Logger;
import io.bidmachine.displays.DisplayPlacementBuilder;
import io.bidmachine.displays.PlacementBuilder;
import io.bidmachine.displays.VideoPlacementBuilder;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public enum AdsType {
    Banner("banner", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new DisplayPlacementBuilder<UnifiedBannerAdRequestParams>(false) { // from class: io.bidmachine.AdsType.1
        @Override // io.bidmachine.displays.DisplayPlacementBuilder, io.bidmachine.displays.ISizableDisplayPlacement
        public Point getSize(ContextProvider contextProvider, UnifiedBannerAdRequestParams bannerRequest) {
            BannerSize bannerSize = bannerRequest.getAdRequestParameters().getBannerSize();
            return new Point(bannerSize.width, bannerSize.height);
        }
    }}),
    Interstitial("interstitial", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new DisplayPlacementBuilder(true), new VideoPlacementBuilder(true)}),
    Rewarded("rewarded", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new DisplayPlacementBuilder(true), new VideoPlacementBuilder(false)}),
    Native("native", new ApiRequest.ApiAuctionDataBinder(), new PlacementBuilder[]{new PlacementBuilder<UnifiedNativeAdRequestParams>() { // from class: io.bidmachine.displays.NativePlacementBuilder
        static final int AD_LABEL_ASSET_ID = 101;
        static final int CTA_ASSET_ID = 8;
        static final int DESC_ASSET_ID = 127;
        static final int ICON_ASSET_ID = 124;
        static final int IMAGE_ASSET_ID = 128;
        static final int PRIVACY_SHEET_ASSET_ID = 102;
        static final int RATING_ASSET_ID = 7;
        static final int TITLE_ASSET_ID = 123;
        static final int VIDEO_ASSET_ID = 4;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder adLabelAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder ctaAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder descAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder privacySheetAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder ratingAsset;
        private static final Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder titleAsset;

        @Override // io.bidmachine.displays.PlacementBuilder
        public /* bridge */ /* synthetic */ Message.Builder createPlacement(ContextProvider contextProvider, UnifiedNativeAdRequestParams adRequestParams, AdsType adsType, Collection networkConfigs, List networkAdUnits, AdPlacementConfig adPlacementConfig, int networksLoadingTimeOutSec) throws Exception {
            return createPlacement2(contextProvider, adRequestParams, adsType, (Collection<NetworkConfig>) networkConfigs, (List<NetworkAdUnit>) networkAdUnits, adPlacementConfig, networksLoadingTimeOutSec);
        }

        static {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            titleAsset = newBuilder;
            newBuilder.setId(123);
            newBuilder.setReq(true);
            newBuilder.setTitle(Placement.DisplayPlacement.NativeFormat.AssetFormat.TitleAssetFormat.newBuilder().setLen(104).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder2 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            descAsset = newBuilder2;
            newBuilder2.setId(127);
            newBuilder2.setReq(true);
            newBuilder2.setData(Placement.DisplayPlacement.NativeFormat.AssetFormat.DataAssetFormat.newBuilder().setType(NativeDataAssetType.NATIVE_DATA_ASSET_TYPE_DESC).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder3 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            ctaAsset = newBuilder3;
            newBuilder3.setId(8);
            newBuilder3.setReq(true);
            newBuilder3.setData(Placement.DisplayPlacement.NativeFormat.AssetFormat.DataAssetFormat.newBuilder().setType(NativeDataAssetType.NATIVE_DATA_ASSET_TYPE_CTA_TEXT).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder4 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            ratingAsset = newBuilder4;
            newBuilder4.setId(7);
            newBuilder4.setReq(false);
            newBuilder4.setData(Placement.DisplayPlacement.NativeFormat.AssetFormat.DataAssetFormat.newBuilder().setType(NativeDataAssetType.NATIVE_DATA_ASSET_TYPE_RATING).build());
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder5 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            adLabelAsset = newBuilder5;
            newBuilder5.setId(101);
            newBuilder5.setReq(false);
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder6 = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            privacySheetAsset = newBuilder6;
            newBuilder6.setId(102);
            newBuilder6.setReq(false);
        }

        static Placement.DisplayPlacement.NativeFormat.AssetFormat createIconAsset(UnifiedNativeAdRequestParams adRequestParams) {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            newBuilder.setId(124);
            newBuilder.setReq(adRequestParams.getAdRequestParameters().containsAssetType(MediaAssetType.Icon));
            newBuilder.setImg(Placement.DisplayPlacement.NativeFormat.AssetFormat.ImageAssetFormat.newBuilder().setType(NativeImageAssetType.NATIVE_IMAGE_ASSET_TYPE_ICON_IMAGE).addAllMime(Arrays.asList(Constants.IMAGE_MIME_TYPES)).build());
            return newBuilder.build();
        }

        static Placement.DisplayPlacement.NativeFormat.AssetFormat createImageAsset(UnifiedNativeAdRequestParams adRequestParams) {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            newBuilder.setId(128);
            newBuilder.setReq(adRequestParams.getAdRequestParameters().containsAssetType(MediaAssetType.Image));
            newBuilder.setImg(Placement.DisplayPlacement.NativeFormat.AssetFormat.ImageAssetFormat.newBuilder().setType(NativeImageAssetType.NATIVE_IMAGE_ASSET_TYPE_MAIN_IMAGE).addAllMime(Arrays.asList(Constants.IMAGE_MIME_TYPES)).build());
            return newBuilder.build();
        }

        static Placement.DisplayPlacement.NativeFormat.AssetFormat createVideoAsset(UnifiedNativeAdRequestParams adRequestParams) {
            Placement.DisplayPlacement.NativeFormat.AssetFormat.Builder newBuilder = Placement.DisplayPlacement.NativeFormat.AssetFormat.newBuilder();
            newBuilder.setId(4);
            newBuilder.setReq(adRequestParams.getAdRequestParameters().containsAssetType(MediaAssetType.Video));
            newBuilder.setVideo(Placement.VideoPlacement.newBuilder().setSkip(false).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_2_0).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_3_0).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_WRAPPER_2_0).addCtype(VideoCreativeType.VIDEO_CREATIVE_TYPE_VAST_WRAPPER_3_0).addAllMime(Arrays.asList(Constants.VIDEO_MIME_TYPES)).setMinbitr(56).setMaxbitr(4096).setMindur(5).setMaxdur(30).setLinearValue(1).build());
            return newBuilder.build();
        }

        {
            AdContentType adContentType = AdContentType.All;
        }

        /* renamed from: createPlacement, reason: avoid collision after fix types in other method */
        public Message.Builder createPlacement2(ContextProvider contextProvider, UnifiedNativeAdRequestParams adRequestParams, AdsType adsType, Collection<NetworkConfig> networkConfigs, List<NetworkAdUnit> networkAdUnits, AdPlacementConfig adPlacementConfig, int networksLoadingTimeOutSec) throws Exception {
            Placement.DisplayPlacement.Builder addAllMime = Placement.DisplayPlacement.newBuilder().setInstl(false).setUnit(SizeUnit.SIZE_UNIT_DIPS).addAllMime(Arrays.asList(Constants.IMAGE_MIME_TYPES)).addAllMime(Arrays.asList(Constants.VIDEO_MIME_TYPES));
            Placement.DisplayPlacement.NativeFormat.Builder newBuilder = Placement.DisplayPlacement.NativeFormat.newBuilder();
            newBuilder.addAsset(titleAsset);
            newBuilder.addAsset(descAsset);
            newBuilder.addAsset(ctaAsset);
            newBuilder.addAsset(ratingAsset);
            newBuilder.addAsset(createIconAsset(adRequestParams));
            newBuilder.addAsset(createImageAsset(adRequestParams));
            newBuilder.addAsset(createVideoAsset(adRequestParams));
            newBuilder.addAsset(adLabelAsset);
            newBuilder.addAsset(privacySheetAsset);
            addAllMime.setNativefmt(newBuilder);
            HeaderBiddingPlacement.Builder createHeaderBiddingPlacement = createHeaderBiddingPlacement(contextProvider, adRequestParams, adsType, networkConfigs, networkAdUnits, networksLoadingTimeOutSec);
            if (adPlacementConfig == null && createHeaderBiddingPlacement != null) {
                addAllMime.addExtProto(Any.pack(createHeaderBiddingPlacement.build()));
                return addAllMime;
            }
            if (adPlacementConfig != null) {
                addAllMime.addExtProto(Any.pack(createSdkPlacement(adPlacementConfig, createHeaderBiddingPlacement)));
            }
            return addAllMime;
        }

        @Override // io.bidmachine.displays.PlacementBuilder
        public AdObjectParams createAdObjectParams(Ad ad) {
            AdObjectParams createHeaderBiddingAdObjectParams = createHeaderBiddingAdObjectParams(ad);
            return (createHeaderBiddingAdObjectParams == null && ad.hasDisplay() && ad.getDisplay().hasNative()) ? new NativeAdObjectParams(ad) : createHeaderBiddingAdObjectParams;
        }
    }});

    private final ApiRequest.ApiAuctionDataBinder binder;
    private final String name;
    private final PlacementBuilder[] placementBuilders;
    private final Executor placementCreateExecutor = Executors.newFixedThreadPool(Math.max(8, Runtime.getRuntime().availableProcessors() * 4));

    AdsType(String name, ApiRequest.ApiAuctionDataBinder binder, PlacementBuilder[] placementBuilders) {
        this.name = name;
        this.binder = binder;
        this.placementBuilders = placementBuilders;
    }

    public String getName() {
        return this.name;
    }

    ApiRequest.ApiAuctionDataBinder getBinder() {
        return this.binder;
    }

    public boolean isFullscreen() {
        return this == Interstitial || this == Rewarded;
    }

    NetworkAdapter findNetworkAdapter(Ad ad) {
        HeaderBiddingAd obtainHeaderBiddingAd = obtainHeaderBiddingAd(ad);
        NetworkAdapter adapter = obtainHeaderBiddingAd != null ? NetworkRegistry.getAdapter(obtainHeaderBiddingAd.getBidder()) : null;
        if (adapter == null) {
            if (this == Native) {
                return NetworkRegistry.getAdapter(NastAdapter.KEY);
            }
            if (ad.hasDisplay()) {
                return NetworkRegistry.getAdapter("mraid");
            }
            if (ad.hasVideo()) {
                return NetworkRegistry.getAdapter(VastAdapter.KEY);
            }
        }
        return adapter;
    }

    AdObjectParams createAdObjectParams(Ad ad) {
        for (PlacementBuilder placementBuilder : this.placementBuilders) {
            AdObjectParams createAdObjectParams = placementBuilder.createAdObjectParams(ad);
            if (createAdObjectParams != null) {
                return createAdObjectParams;
            }
        }
        return null;
    }

    HeaderBiddingAd obtainHeaderBiddingAd(Ad ad) {
        for (PlacementBuilder placementBuilder : this.placementBuilders) {
            HeaderBiddingAd obtainHeaderBiddingAd = placementBuilder.obtainHeaderBiddingAd(ad);
            if (obtainHeaderBiddingAd != null) {
                return obtainHeaderBiddingAd;
            }
        }
        return null;
    }

    void collectPlacements(final ContextProvider contextProvider, final AdRequest adRequest, final UnifiedAdRequestParams adRequestParams, final Collection<NetworkConfig> networkConfigList, final List<Message.Builder> placementList, final List<NetworkAdUnit> networkAdUnits, final AdPlacementConfig adPlacementConfig, final int networksLoadingTimeOutSec) {
        AdsType adsType = this;
        final CountDownLatch countDownLatch = new CountDownLatch(adsType.placementBuilders.length);
        PlacementBuilder[] placementBuilderArr = adsType.placementBuilders;
        int length = placementBuilderArr.length;
        int i = 0;
        while (i < length) {
            final PlacementBuilder placementBuilder = placementBuilderArr[i];
            if (adRequest.isPlacementBuilderMatch(placementBuilder)) {
                adsType.placementCreateExecutor.execute(new Runnable() { // from class: io.bidmachine.AdsType.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Message.Builder createPlacement = placementBuilder.createPlacement(contextProvider, adRequestParams, AdsType.this, networkConfigList, networkAdUnits, adPlacementConfig, networksLoadingTimeOutSec);
                            synchronized (placementList) {
                                placementList.add(createPlacement);
                            }
                            countDownLatch.countDown();
                        } catch (Exception e) {
                            Logger.w(e);
                            countDownLatch.countDown();
                        }
                    }
                });
            } else {
                countDownLatch.countDown();
            }
            i++;
            adsType = this;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Logger.w(e);
        }
    }
}

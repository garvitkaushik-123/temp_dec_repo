package io.bidmachine.displays;

import android.text.TextUtils;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.AdContentType;
import io.bidmachine.AdPlacementConfig;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.CustomParams;
import io.bidmachine.Executable;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfig;
import io.bidmachine.core.Utils;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.sdk.Placement;
import io.bidmachine.unified.UnifiedAdRequestParams;
import java.util.Collection;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class PlacementBuilder<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    private final AdContentType contentType;
    private final HeaderBiddingPlacementBuilder<UnifiedAdRequestParamsType> headerBiddingPlacementBuilder = new HeaderBiddingPlacementBuilder<>();

    public abstract AdObjectParams createAdObjectParams(Ad ad);

    public abstract Message.Builder createPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType adRequestParams, AdsType adsType, Collection<NetworkConfig> networkConfigs, List<NetworkAdUnit> networkAdUnits, AdPlacementConfig adPlacementConfig, int networksLoadingTimeOutSec) throws Exception;

    PlacementBuilder(AdContentType contentType) {
        this.contentType = contentType;
    }

    public AdContentType getAdContentType() {
        return this.contentType;
    }

    @Deprecated
    public Message.Builder createPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType adRequestParams, AdsType adsType, Collection<NetworkConfig> networkConfigs, List<NetworkAdUnit> networkAdUnits, int networksLoadingTimeOutSec) throws Exception {
        return createPlacement(contextProvider, adRequestParams, adsType, networkConfigs, networkAdUnits, null, networksLoadingTimeOutSec);
    }

    public HeaderBiddingAd obtainHeaderBiddingAd(Ad ad) {
        return this.headerBiddingPlacementBuilder.obtainHeaderBiddingAd(ad);
    }

    HeaderBiddingPlacement.Builder createHeaderBiddingPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType adRequestParams, AdsType adsType, Collection<NetworkConfig> networkConfigs, List<NetworkAdUnit> networkAdUnits, int networksLoadingTimeOutSec) {
        return this.headerBiddingPlacementBuilder.createPlacement(contextProvider, adRequestParams, adsType, getAdContentType(), networkConfigs, networkAdUnits, networksLoadingTimeOutSec);
    }

    AdObjectParams createHeaderBiddingAdObjectParams(Ad ad) {
        return this.headerBiddingPlacementBuilder.createAdObjectParams(ad);
    }

    Placement createSdkPlacement(AdPlacementConfig adPlacementConfig, HeaderBiddingPlacement.Builder headerBiddingPlacementBuilder) {
        final Placement.Builder newBuilder = Placement.newBuilder();
        newBuilder.setAdType(adPlacementConfig.getAdsFormat().getAdsType().getName());
        String placementId = adPlacementConfig.getPlacementId();
        if (!TextUtils.isEmpty(placementId)) {
            newBuilder.setPlacementId(StringValue.of(placementId));
        }
        Utils.ifNotNull(adPlacementConfig.getCustomParams(), new Executable() { // from class: io.bidmachine.displays.PlacementBuilder$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                PlacementBuilder.lambda$createSdkPlacement$0(Placement.Builder.this, (CustomParams) obj);
            }
        });
        if (headerBiddingPlacementBuilder != null) {
            newBuilder.setHbPlacement(headerBiddingPlacementBuilder);
        }
        return newBuilder.build();
    }

    static /* synthetic */ void lambda$createSdkPlacement$0(Placement.Builder builder, CustomParams customParams) {
        Struct.Builder newBuilder = Struct.newBuilder();
        customParams.fillStructBuilder(newBuilder);
        if (newBuilder.getFieldsCount() > 0) {
            builder.setCustomData(newBuilder);
        }
    }
}

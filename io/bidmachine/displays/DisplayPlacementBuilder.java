package io.bidmachine.displays;

import android.graphics.Point;
import android.text.TextUtils;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.adcom.ApiFramework;
import com.explorestack.protobuf.adcom.Placement;
import com.explorestack.protobuf.adcom.PlacementPosition;
import com.explorestack.protobuf.adcom.SizeUnit;
import io.bidmachine.AdContentType;
import io.bidmachine.AdPlacementConfig;
import io.bidmachine.AdsType;
import io.bidmachine.Constants;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfig;
import io.bidmachine.core.Utils;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.unified.UnifiedAdRequestParams;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes7.dex */
public class DisplayPlacementBuilder<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> extends PlacementBuilder<UnifiedAdRequestParamsType> implements ISizableDisplayPlacement<UnifiedAdRequestParamsType> {
    private final boolean isFullscreen;

    public DisplayPlacementBuilder(boolean fullscreen) {
        super(AdContentType.Static);
        this.isFullscreen = fullscreen;
    }

    @Override // io.bidmachine.displays.PlacementBuilder
    public Message.Builder createPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType adRequestParams, AdsType adsType, Collection<NetworkConfig> networkConfigs, List<NetworkAdUnit> networkAdUnits, AdPlacementConfig adPlacementConfig, int networksLoadingTimeOutSec) throws Exception {
        Point size = getSize(contextProvider, adRequestParams);
        Placement.DisplayPlacement.Builder h = Placement.DisplayPlacement.newBuilder().addApi(ApiFramework.API_FRAMEWORK_MRAID_2_0).addApi(ApiFramework.API_FRAMEWORK_OMID_1_0).setUnit(SizeUnit.SIZE_UNIT_DIPS).addAllMime(Arrays.asList(Constants.IMAGE_MIME_TYPES)).setW(size.x).setH(size.y);
        if (this.isFullscreen) {
            h.setInstl(true);
            h.setPos(PlacementPosition.PLACEMENT_POSITION_FULLSCREEN);
        }
        HeaderBiddingPlacement.Builder createHeaderBiddingPlacement = createHeaderBiddingPlacement(contextProvider, adRequestParams, adsType, networkConfigs, networkAdUnits, networksLoadingTimeOutSec);
        if (adPlacementConfig == null && createHeaderBiddingPlacement != null) {
            h.addExtProto(Any.pack(createHeaderBiddingPlacement.build()));
            return h;
        }
        if (adPlacementConfig != null) {
            h.addExtProto(Any.pack(createSdkPlacement(adPlacementConfig, createHeaderBiddingPlacement)));
        }
        return h;
    }

    public Point getSize(ContextProvider contextProvider, UnifiedAdRequestParamsType adRequestParams) {
        return Utils.getScreenSize(contextProvider.getContext());
    }

    @Override // io.bidmachine.displays.PlacementBuilder
    public AdObjectParams createAdObjectParams(Ad ad) {
        if (!ad.hasDisplay()) {
            return null;
        }
        AdObjectParams createHeaderBiddingAdObjectParams = createHeaderBiddingAdObjectParams(ad);
        if (createHeaderBiddingAdObjectParams != null) {
            return createHeaderBiddingAdObjectParams;
        }
        Ad.Display display = ad.getDisplay();
        if (TextUtils.isEmpty(display.getAdm())) {
            return null;
        }
        DisplayAdObjectParams displayAdObjectParams = new DisplayAdObjectParams(ad);
        displayAdObjectParams.setCreativeAdm(display.getAdm());
        displayAdObjectParams.setWidth(display.getW());
        displayAdObjectParams.setHeight(display.getH());
        return displayAdObjectParams;
    }
}

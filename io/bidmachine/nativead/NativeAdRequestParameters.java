package io.bidmachine.nativead;

import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.AdPlacementConfig;
import io.bidmachine.AdRequestParameters;
import io.bidmachine.AdsFormat;
import io.bidmachine.MediaAssetType;
import io.bidmachine.utils.ProtoUtils;
import java.util.List;

/* loaded from: classes6.dex */
public class NativeAdRequestParameters extends AdRequestParameters {
    private final List<MediaAssetType> mediaAssetTypes;
    private boolean validateAssets;

    public NativeAdRequestParameters(List<MediaAssetType> mediaAssetTypes) {
        super(new AdPlacementConfig.Builder(AdsFormat.Native).build());
        this.validateAssets = true;
        this.mediaAssetTypes = mediaAssetTypes;
    }

    public List<MediaAssetType> getMediaAssetTypes() {
        return this.mediaAssetTypes;
    }

    public boolean containsAssetType(MediaAssetType mediaAssetType) {
        return this.mediaAssetTypes.isEmpty() || this.mediaAssetTypes.contains(mediaAssetType) || this.mediaAssetTypes.contains(MediaAssetType.All);
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isPlacementObjectValid(Placement placement) throws Throwable {
        return ProtoUtils.isNativePlacement(placement);
    }

    @Override // io.bidmachine.AdRequestParameters
    public boolean isParametersMatched(AdRequestParameters adRequestParameters) {
        return super.isParametersMatched(adRequestParameters) && (adRequestParameters instanceof NativeAdRequestParameters) && isParametersMatchedInternal((NativeAdRequestParameters) adRequestParameters);
    }

    public boolean isValidateAssets() {
        return this.validateAssets;
    }

    void setValidateAssets(boolean validateAssets) {
        this.validateAssets = validateAssets;
    }

    private boolean isParametersMatchedInternal(NativeAdRequestParameters nativeAdRequestParameters) {
        return MediaAssetType.isAll(nativeAdRequestParameters.mediaAssetTypes) || nativeAdRequestParameters.mediaAssetTypes.containsAll(this.mediaAssetTypes);
    }
}

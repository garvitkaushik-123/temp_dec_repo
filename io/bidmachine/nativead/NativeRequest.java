package io.bidmachine.nativead;

import io.bidmachine.AdRequest;
import io.bidmachine.CustomParams;
import io.bidmachine.MediaAssetType;
import io.bidmachine.NetworkConfig;
import io.bidmachine.PriceFloorParams;
import io.bidmachine.SessionAdParams;
import io.bidmachine.TargetingParams;
import io.bidmachine.UnifiedAdRequestParamsImpl;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.INativeRequestBuilder;
import io.bidmachine.models.RequestBuilder;
import io.bidmachine.protobuf.ResponsePayload;
import io.bidmachine.unified.UnifiedNativeAdRequestParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public final class NativeRequest extends AdRequest<NativeRequest, NativeAdRequestParameters, UnifiedNativeAdRequestParams> {

    public interface AdRequestListener extends AdRequest.AdRequestListener<NativeRequest> {
    }

    private NativeRequest(NativeAdRequestParameters nativeAdRequestParameters) {
        super(nativeAdRequestParameters);
    }

    public boolean containsAssetType(MediaAssetType mediaAssetType) {
        return getAdRequestParameters().containsAssetType(mediaAssetType);
    }

    @Override // io.bidmachine.AdRequest
    protected void processBidPayload(ResponsePayload responsePayload) {
        getAdRequestParameters().setValidateAssets(false);
        super.processBidPayload(responsePayload);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.AdRequest
    public UnifiedNativeAdRequestParams createUnifiedAdRequestParams(NativeAdRequestParameters adRequestParameters, TargetingParams targetingParams, DataRestrictions dataRestrictions) {
        return new NativeUnifiedAdRequestParams(adRequestParameters, targetingParams, dataRestrictions);
    }

    public static final class Builder extends AdRequest.AdRequestBuilderImpl<Builder, NativeRequest, NativeAdRequestParameters> implements INativeRequestBuilder<Builder> {
        private final List<MediaAssetType> mediaAssetTypes = new ArrayList<MediaAssetType>(MediaAssetType.values().length) { // from class: io.bidmachine.nativead.NativeRequest.Builder.1
            {
                add(MediaAssetType.Icon);
                add(MediaAssetType.Image);
            }
        };

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ AdRequest build() {
            return super.build();
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setBidPayload(String bidPayload) {
            return super.setBidPayload(bidPayload);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setCustomParams(CustomParams customParams) {
            return super.setCustomParams(customParams);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setListener(AdRequest.AdRequestListener listener) {
            return super.setListener(listener);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setLoadingTimeOut(Integer timeOutMs) {
            return super.setLoadingTimeOut(timeOutMs);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setNetworks(String jsonData) {
            return super.setNetworks(jsonData);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setNetworks(List networkConfigList) {
            return super.setNetworks((List<NetworkConfig>) networkConfigList);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setPlacementId(String placementId) {
            return super.setPlacementId(placementId);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setPriceFloorParams(PriceFloorParams priceFloorParams) {
            return super.setPriceFloorParams(priceFloorParams);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        @Deprecated
        public /* bridge */ /* synthetic */ RequestBuilder setSessionAdParams(SessionAdParams sessionAdParams) {
            return super.setSessionAdParams(sessionAdParams);
        }

        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl, io.bidmachine.models.RequestBuilder
        public /* bridge */ /* synthetic */ RequestBuilder setTargetingParams(TargetingParams userParams) {
            return super.setTargetingParams(userParams);
        }

        @Override // io.bidmachine.models.INativeRequestBuilder
        public Builder setMediaAssetTypes(MediaAssetType... types) {
            if (types.length > 0) {
                this.mediaAssetTypes.clear();
                this.mediaAssetTypes.addAll(Arrays.asList(types));
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl
        public NativeAdRequestParameters createAdRequestParameters() {
            return new NativeAdRequestParameters(this.mediaAssetTypes);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl
        public NativeRequest build(NativeAdRequestParameters nativeAdRequestParameters) {
            return new NativeRequest(nativeAdRequestParameters);
        }
    }

    private static class NativeUnifiedAdRequestParams extends UnifiedAdRequestParamsImpl<NativeAdRequestParameters> implements UnifiedNativeAdRequestParams {
        @Override // io.bidmachine.UnifiedAdRequestParamsImpl, io.bidmachine.unified.UnifiedAdRequestParams, io.bidmachine.unified.UnifiedFullscreenAdRequestParams
        public /* bridge */ /* synthetic */ NativeAdRequestParameters getAdRequestParameters() {
            return (NativeAdRequestParameters) super.getAdRequestParameters();
        }

        private NativeUnifiedAdRequestParams(NativeAdRequestParameters adRequestParameters, TargetingParams targetingParams, DataRestrictions dataRestrictions) {
            super(adRequestParameters, targetingParams, dataRestrictions);
        }
    }
}

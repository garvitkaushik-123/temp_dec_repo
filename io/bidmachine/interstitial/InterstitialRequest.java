package io.bidmachine.interstitial;

import io.bidmachine.AdContentType;
import io.bidmachine.AdRequest;
import io.bidmachine.CustomParams;
import io.bidmachine.FullScreenAdRequest;
import io.bidmachine.FullScreenAdRequestParameters;
import io.bidmachine.NetworkConfig;
import io.bidmachine.PriceFloorParams;
import io.bidmachine.SessionAdParams;
import io.bidmachine.TargetingParams;
import io.bidmachine.models.RequestBuilder;
import java.util.List;

/* loaded from: classes7.dex */
public final class InterstitialRequest extends FullScreenAdRequest<InterstitialRequest> {

    public interface AdRequestListener extends AdRequest.AdRequestListener<InterstitialRequest> {
    }

    private InterstitialRequest(FullScreenAdRequestParameters fullScreenAdRequestParameters) {
        super(fullScreenAdRequestParameters);
    }

    public static final class Builder extends FullScreenAdRequest.FullScreenRequestBuilder<Builder, InterstitialRequest> {
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

        @Override // io.bidmachine.FullScreenAdRequest.FullScreenRequestBuilder
        public Builder setAdContentType(AdContentType adContentType) {
            return (Builder) super.setAdContentType(adContentType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl
        public FullScreenAdRequestParameters createAdRequestParameters() {
            return new InterstitialAdRequestParameters(this.adContentType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.bidmachine.AdRequest.AdRequestBuilderImpl
        public InterstitialRequest build(FullScreenAdRequestParameters fullScreenAdRequestParameters) {
            return new InterstitialRequest(fullScreenAdRequestParameters);
        }
    }
}

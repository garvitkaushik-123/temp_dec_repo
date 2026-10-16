package io.bidmachine.models;

import io.bidmachine.AdRequest;
import io.bidmachine.CustomParams;
import io.bidmachine.NetworkConfig;
import io.bidmachine.PriceFloorParams;
import io.bidmachine.SessionAdParams;
import io.bidmachine.TargetingParams;
import io.bidmachine.models.RequestBuilder;
import java.util.List;

/* loaded from: classes7.dex */
public interface RequestBuilder<SelfType extends RequestBuilder, ReturnType extends AdRequest> {
    ReturnType build();

    SelfType setBidPayload(String bidPayload);

    SelfType setCustomParams(CustomParams customParams);

    SelfType setListener(AdRequest.AdRequestListener<ReturnType> listener);

    SelfType setLoadingTimeOut(Integer timeOutMs);

    SelfType setNetworks(String jsonData);

    SelfType setNetworks(List<NetworkConfig> networkConfigList);

    SelfType setPlacementId(String placementId);

    SelfType setPriceFloorParams(PriceFloorParams priceFloorParams);

    @Deprecated
    SelfType setSessionAdParams(SessionAdParams sessionAdParams);

    SelfType setTargetingParams(TargetingParams targetingParams);
}

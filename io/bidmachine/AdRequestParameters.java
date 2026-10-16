package io.bidmachine;

import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.ResponsePayload;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class AdRequestParameters {
    private AdPlacementConfig adPlacementConfig;
    private ResponsePayload bidPayload;
    private List<NetworkConfig> networkConfigList;
    private PriceFloorParams priceFloorParams;
    private TargetingParams targetingParams;
    private Integer timeOutMs;

    @Deprecated
    public SessionAdParams getSessionAdParams() {
        return null;
    }

    public abstract boolean isPlacementObjectValid(Placement placement) throws Throwable;

    protected AdRequestParameters(AdPlacementConfig adPlacementConfig) {
        this.adPlacementConfig = adPlacementConfig;
    }

    public AdPlacementConfig getAdPlacementConfig() {
        return this.adPlacementConfig;
    }

    void setAdPlacementConfig(AdPlacementConfig adPlacementConfig) {
        AdsFormat adsFormat = this.adPlacementConfig.getAdsFormat();
        AdsFormat adsFormat2 = adPlacementConfig.getAdsFormat();
        if (adsFormat != adsFormat2) {
            Logger.w("setAdPlacementConfig received different AdsFormat. Expected: " + adsFormat + ", actual: " + adsFormat2);
            adPlacementConfig = adPlacementConfig.copy(adsFormat, adPlacementConfig.getPlacementId(), adPlacementConfig.getCustomParams());
        }
        this.adPlacementConfig = adPlacementConfig;
    }

    public AdsType getAdsType() {
        return getAdsFormat().getAdsType();
    }

    public AdsFormat getAdsFormat() {
        return this.adPlacementConfig.getAdsFormat();
    }

    public PriceFloorParams getPriceFloorParams() {
        return this.priceFloorParams;
    }

    void setPriceFloorParams(PriceFloorParams priceFloorParams) {
        this.priceFloorParams = priceFloorParams;
    }

    public TargetingParams getTargetingParams() {
        return this.targetingParams;
    }

    void setTargetingParams(TargetingParams targetingParams) {
        this.targetingParams = targetingParams;
    }

    public List<NetworkConfig> getNetworkConfigList() {
        return this.networkConfigList;
    }

    void setNetworkConfigList(List<NetworkConfig> networkConfigList) {
        this.networkConfigList = networkConfigList;
    }

    public Integer getTimeOutMs() {
        return this.timeOutMs;
    }

    void setTimeOutMs(Integer timeOutMs) {
        this.timeOutMs = timeOutMs;
    }

    public ResponsePayload getBidPayload() {
        return this.bidPayload;
    }

    void setBidPayload(ResponsePayload bidPayload) {
        this.bidPayload = bidPayload;
    }

    public String getPlacementId() {
        return this.adPlacementConfig.getPlacementId();
    }

    public CustomParams getCustomParams() {
        return this.adPlacementConfig.getCustomParams();
    }

    public boolean isParametersMatched(AdRequestParameters adRequestParameters) {
        return getAdsType() == adRequestParameters.getAdsType();
    }

    public boolean isPricePassedByPriceFloor(double price) {
        PriceFloorParams priceFloorParams = this.priceFloorParams;
        if (priceFloorParams == null) {
            return true;
        }
        Map<String, Double> priceFloors = priceFloorParams.getPriceFloors();
        if (priceFloors.isEmpty()) {
            return true;
        }
        Iterator<Double> it = priceFloors.values().iterator();
        while (it.hasNext()) {
            if (price > it.next().doubleValue()) {
                return true;
            }
        }
        return false;
    }
}

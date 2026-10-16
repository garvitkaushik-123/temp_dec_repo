package io.bidmachine.ads.networks.gam;

import io.bidmachine.AdsFormat;
import java.util.List;

/* loaded from: classes7.dex */
public class GAMTypeConfig {
    private final AdsFormat adsFormat;
    private final int cacheSize;
    private final List<GAMUnitData> gamUnitDataList;

    public GAMTypeConfig(AdsFormat adsFormat, List<GAMUnitData> gamUnitDataList, int cacheSize) {
        this.adsFormat = adsFormat;
        this.cacheSize = cacheSize;
        this.gamUnitDataList = gamUnitDataList;
    }

    public AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public List<GAMUnitData> getGAMUnitDataList() {
        return this.gamUnitDataList;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }
}

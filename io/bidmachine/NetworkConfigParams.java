package io.bidmachine;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public interface NetworkConfigParams {
    String getFromNetworkParams(String key);

    EnumMap<AdsFormat, List<Map<String, String>>> obtainNetworkMediationConfigs(AdsFormat... adsFormats);

    Map<String, String> obtainNetworkParams();

    String removeFromNetworkParams(String key);
}

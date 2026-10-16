package io.bidmachine;

import io.bidmachine.core.Logger;
import io.bidmachine.unified.UnifiedAdRequestParams;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public abstract class NetworkConfig {
    static final String CONFIG_SKIP_INITIALIZATION = "skip_initialization";
    private Map<String, String> baseMediationConfig;
    private AdsType[] mergedAdsTypes;
    private final String networkKey;
    private AdsType[] supportedAdsTypes;
    private EnumMap<AdsFormat, List<Map<String, String>>> typedMediationConfigs;
    private final NetworkConfigParams networkConfigParams = new NetworkConfigParams() { // from class: io.bidmachine.NetworkConfig.1
        @Override // io.bidmachine.NetworkConfigParams
        public Map<String, String> obtainNetworkParams() {
            return new HashMap(NetworkConfig.this.networkParams);
        }

        @Override // io.bidmachine.NetworkConfigParams
        public String removeFromNetworkParams(String key) {
            return (String) NetworkConfig.this.networkParams.remove(key);
        }

        @Override // io.bidmachine.NetworkConfigParams
        public String getFromNetworkParams(String key) {
            return (String) NetworkConfig.this.networkParams.get(key);
        }

        @Override // io.bidmachine.NetworkConfigParams
        public EnumMap<AdsFormat, List<Map<String, String>>> obtainNetworkMediationConfigs(AdsFormat... adsFormats) {
            ArrayList arrayList;
            List list;
            if (adsFormats == null || adsFormats.length <= 0) {
                return null;
            }
            EnumMap<AdsFormat, List<Map<String, String>>> enumMap = null;
            for (AdsFormat adsFormat : adsFormats) {
                if (NetworkConfig.this.typedMediationConfigs == null || (list = (List) NetworkConfig.this.typedMediationConfigs.get(adsFormat)) == null) {
                    arrayList = null;
                } else {
                    arrayList = null;
                    for (int i = 0; i < list.size(); i++) {
                        Map map = (Map) list.get(i);
                        Map<String, String> prepareTypedMediationConfig = map != null ? NetworkConfig.this.prepareTypedMediationConfig(map) : null;
                        if (prepareTypedMediationConfig != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(prepareTypedMediationConfig);
                        }
                    }
                }
                if (arrayList != null) {
                    if (enumMap == null) {
                        enumMap = new EnumMap<>((Class<AdsFormat>) AdsFormat.class);
                    }
                    enumMap.put((EnumMap<AdsFormat, List<Map<String, String>>>) adsFormat, (AdsFormat) arrayList);
                }
            }
            return enumMap;
        }
    };
    private final Map<String, String> networkParams = new HashMap();

    protected abstract NetworkAdapter createNetworkAdapter();

    protected boolean useNetworkParamsAsMediationBase() {
        return true;
    }

    protected NetworkConfig(String networkKey, Map<String, String> networkParams) {
        this.networkKey = networkKey;
        withNetworkParams(networkParams);
    }

    public String getNetworkKey() {
        return this.networkKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T withNetworkParams(Map<String, String> config) {
        this.networkParams.clear();
        if (config != null) {
            this.networkParams.putAll(config);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T setNetworkParam(String key, String value) {
        this.networkParams.put(key, value);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T withBaseMediationConfig(Map<String, String> config) {
        this.baseMediationConfig = config;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T setBaseMediationParam(String key, String value) {
        if (this.baseMediationConfig == null) {
            this.baseMediationConfig = new HashMap();
        }
        this.baseMediationConfig.put(key, value);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends NetworkConfig> T internalSetSkipInitialization(boolean skipInitialization) {
        setNetworkParam(CONFIG_SKIP_INITIALIZATION, String.valueOf(skipInitialization));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends NetworkConfig> T withMediationConfig(AdsFormat adsFormat, Map<String, String> config) {
        if (config == null) {
            EnumMap<AdsFormat, List<Map<String, String>>> enumMap = this.typedMediationConfigs;
            if (enumMap != null) {
                enumMap.remove(adsFormat);
            }
            return this;
        }
        if (this.typedMediationConfigs == null) {
            this.typedMediationConfigs = new EnumMap<>(AdsFormat.class);
        }
        List<Map<String, String>> list = this.typedMediationConfigs.get(adsFormat);
        if (list == null) {
            list = new ArrayList<>();
            this.typedMediationConfigs.put((EnumMap<AdsFormat, List<Map<String, String>>>) adsFormat, (AdsFormat) list);
        }
        list.add(config);
        return this;
    }

    @Deprecated
    public <T extends NetworkConfig> T withMediationConfig(AdsFormat adsFormat, Map<String, String> map, Orientation orientation) {
        Logger.w("The parameter 'orientation' is no longer supported and has no effect.");
        return (T) withMediationConfig(adsFormat, map);
    }

    public NetworkConfig forAdTypes(AdsType... adsType) {
        this.supportedAdsTypes = adsType;
        return this;
    }

    public <T extends UnifiedAdRequestParams> List<NetworkAdUnit> createNetworkAdUnitList(AdsType adsType, T adRequestParams, AdContentType adContentType, NetworkAdapter networkAdapter) {
        List<Map<String, String>> value;
        ArrayList arrayList = new ArrayList();
        EnumMap<AdsFormat, List<Map<String, String>>> enumMap = this.typedMediationConfigs;
        if (enumMap != null) {
            for (Map.Entry<AdsFormat, List<Map<String, String>>> entry : enumMap.entrySet()) {
                AdsFormat key = entry.getKey();
                if (key.isMatch(adsType, adRequestParams, adContentType) && (value = entry.getValue()) != null) {
                    Iterator<Map<String, String>> it = value.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new NetworkAdUnit(networkAdapter, key, prepareTypedMediationConfig(it.next())));
                    }
                }
            }
        }
        return arrayList;
    }

    AdsType[] getSupportedAdsTypes(NetworkAdapter networkAdapter) {
        if (this.mergedAdsTypes == null) {
            ArrayList arrayList = new ArrayList();
            for (AdsType adsType : networkAdapter.getSupportedTypes()) {
                AdsType[] adsTypeArr = this.supportedAdsTypes;
                if (adsTypeArr == null || contains(adsTypeArr, adsType)) {
                    arrayList.add(adsType);
                }
            }
            this.mergedAdsTypes = (AdsType[]) arrayList.toArray(new AdsType[0]);
        }
        return this.mergedAdsTypes;
    }

    NetworkConfigParams getNetworkConfigParams() {
        return this.networkConfigParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> prepareTypedMediationConfig(Map<String, String> config) {
        HashMap hashMap = new HashMap();
        if (useNetworkParamsAsMediationBase()) {
            hashMap.putAll(this.networkParams);
        }
        Map<String, String> map = this.baseMediationConfig;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.putAll(config);
        return hashMap;
    }

    private boolean contains(Object[] array, Object v) {
        for (Object obj : array) {
            if (obj == v) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return getNetworkKey().equals(((NetworkConfig) o).getNetworkKey());
    }

    public int hashCode() {
        return getNetworkKey().hashCode();
    }
}

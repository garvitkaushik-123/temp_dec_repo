package com.unity3d.services.core.device.reader.builder;

import com.inmobi.sdk.InMobiSdk;
import com.ironsource.C3261q5;
import com.ironsource.N6;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.device.reader.DeviceInfoReaderExtended;
import com.unity3d.services.core.device.reader.DeviceInfoReaderFilterProvider;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithAuid;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithFilter;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithLifecycle;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithMetrics;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithPrivacy;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithRequestType;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithSessionId;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithStorageInfo;
import com.unity3d.services.core.device.reader.IDeviceInfoReader;
import com.unity3d.services.core.device.reader.IGameSessionIdReader;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.device.reader.MinimalDeviceInfoReader;
import com.unity3d.services.core.device.reader.pii.PiiDataProvider;
import com.unity3d.services.core.device.reader.pii.PiiTrackingStatusReader;
import com.unity3d.services.core.lifecycle.CachedLifecycle;
import com.unity3d.services.core.misc.JsonFlattenerRules;
import com.unity3d.services.core.misc.JsonStorageAggregator;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.Session;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.Framework;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes7.dex */
public class DeviceInfoReaderBuilder {
    private final ConfigurationReader _configurationReader;
    private final IGameSessionIdReader _gameSessionIdReader;
    private final PrivacyConfigStorage _privacyConfigStorage;

    public DeviceInfoReaderBuilder(ConfigurationReader configurationReader, PrivacyConfigStorage privacyConfigStorage, IGameSessionIdReader iGameSessionIdReader) {
        this._configurationReader = configurationReader;
        this._privacyConfigStorage = privacyConfigStorage;
        this._gameSessionIdReader = iGameSessionIdReader;
    }

    public IDeviceInfoReader build() {
        Storage storage = StorageManager.getStorage(StorageManager.StorageType.PRIVATE);
        Storage storage2 = StorageManager.getStorage(StorageManager.StorageType.PUBLIC);
        Storage storage3 = StorageManager.getStorage(StorageManager.StorageType.MEMORY);
        JsonStorageAggregator jsonStorageAggregator = new JsonStorageAggregator(Arrays.asList(storage2, storage));
        return new DeviceInfoReaderWithMetrics(new DeviceInfoReaderWithFilter(new DeviceInfoReaderWithPrivacy(new DeviceInfoReaderWithStorageInfo(new DeviceInfoReaderWithStorageInfo(new DeviceInfoReaderWithLifecycle(new DeviceInfoReaderExtended(new DeviceInfoReaderWithAuid(new DeviceInfoReaderWithSessionId(buildWithRequestType(InitRequestType.TOKEN), Session.INSTANCE))), CachedLifecycle.getLifecycleListener()), getMediationInfoRules(), storage3), getTsiRequestStorageRules(), jsonStorageAggregator), this._privacyConfigStorage, new PiiDataProvider(), new PiiTrackingStatusReader(jsonStorageAggregator)), new DeviceInfoReaderFilterProvider(storage).getFilterList()), (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class));
    }

    protected IDeviceInfoReader buildWithRequestType(InitRequestType initRequestType) {
        return new DeviceInfoReaderWithRequestType(new MinimalDeviceInfoReader(this._gameSessionIdReader), initRequestType);
    }

    private JsonFlattenerRules getTsiRequestStorageRules() {
        return new JsonFlattenerRules(Arrays.asList("privacy", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "framework", N6.F1, Framework.UNITY, "pipl", "configuration", AnalyticsConstants.SOURCE_USER_TYPE, JsonStorageKeyNames.UNIFIED_CONFIG_KEY), Collections.singletonList("value"), Arrays.asList("ts", "exclude", "pii", "nonBehavioral", "nonbehavioral"));
    }

    protected JsonFlattenerRules getMediationInfoRules() {
        return new JsonFlattenerRules(Collections.singletonList("mediation"), Collections.singletonList("value"), Arrays.asList("ts", C3261q5.f3652a));
    }
}

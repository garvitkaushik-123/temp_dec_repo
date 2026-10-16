package com.unity3d.services.core.device.reader;

import com.ironsource.N6;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class MinimalDeviceInfoReader implements IDeviceInfoReader {
    final IGameSessionIdReader _gameSessionIdReader;

    public MinimalDeviceInfoReader(IGameSessionIdReader iGameSessionIdReader) {
        this._gameSessionIdReader = iGameSessionIdReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        HashMap hashMap = new HashMap();
        hashMap.put(N6.H, "android");
        hashMap.put("sdkVersion", Integer.valueOf(SdkProperties.getVersionCode()));
        hashMap.put("sdkVersionName", SdkProperties.getVersionName());
        hashMap.put("idfi", Device.getIdfi());
        hashMap.put(JsonStorageKeyNames.GAME_SESSION_ID_NORMALIZED_KEY, this._gameSessionIdReader.getGameSessionIdAndStore());
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(AndroidGetAdPlayerContext.KEY_GAME_ID, ClientProperties.getGameId());
        return hashMap;
    }
}

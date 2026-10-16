package io.bidmachine;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class NetworkAssetManager {
    private static final String BID_MACHINE_ASSET_FILE_EXTENSION = "bmnetwork";
    private static final String BID_MACHINE_ASSET_PATH = "bm_networks";
    private static final String KEY_CLASSPATH = "classpath";
    private static final String KEY_NAME = "name";
    private static final String KEY_SDK_VERSION = "sdk_version";
    private static final String KEY_VERSION = "version";
    static final Map<String, NetworkAssetParams> NETWORK_ASSET_PARAMS_MAP = new ConcurrentHashMap();

    NetworkAssetManager() {
    }

    static Map<String, NetworkAssetParams> getNetworkAssetParamsMap(Context context) {
        Map<String, NetworkAssetParams> map = NETWORK_ASSET_PARAMS_MAP;
        if (!map.isEmpty()) {
            return map;
        }
        findNetworks(context);
        return map;
    }

    static void findNetworks(Context context) {
        String[] list;
        if (NETWORK_ASSET_PARAMS_MAP.isEmpty()) {
            try {
                AssetManager assets = context.getAssets();
                if (assets != null && (list = assets.list(BID_MACHINE_ASSET_PATH)) != null) {
                    for (String str : list) {
                        findNetwork(assets, str);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    static NetworkAssetParams getNetworkAssetParams(Context context, String networkName) {
        Map<String, NetworkAssetParams> map = NETWORK_ASSET_PARAMS_MAP;
        if (map.containsKey(networkName)) {
            return map.get(networkName);
        }
        try {
            AssetManager assets = context.getAssets();
            if (assets == null) {
                return null;
            }
            return findNetwork(assets, networkName + ".bmnetwork");
        } catch (Exception unused) {
            return null;
        }
    }

    private static NetworkAssetParams findNetwork(AssetManager assetManager, String networkFile) {
        NetworkAssetParams createNetworkParams = createNetworkParams(assetManager, networkFile);
        if (createNetworkParams != null) {
            NETWORK_ASSET_PARAMS_MAP.put(createNetworkParams.getName(), createNetworkParams);
        }
        return createNetworkParams;
    }

    private static NetworkAssetParams createNetworkParams(AssetManager assetManager, String networkFile) {
        if (TextUtils.isEmpty(networkFile)) {
            return null;
        }
        String readAssetByNetworkName = readAssetByNetworkName(assetManager, networkFile);
        if (TextUtils.isEmpty(readAssetByNetworkName)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(readAssetByNetworkName);
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("version");
        String optString3 = jSONObject.optString(KEY_CLASSPATH);
        String optString4 = jSONObject.optString("sdk_version");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
            return new NetworkAssetParams(optString, optString2, optString3, optString4);
        }
        return null;
    }

    private static String readAssetByNetworkName(AssetManager assetManager, String networkFile) {
        try {
            return Utils.streamToString(assetManager.open("bm_networks/" + networkFile));
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    static void reset() {
        NETWORK_ASSET_PARAMS_MAP.clear();
    }
}

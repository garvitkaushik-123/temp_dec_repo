package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.AdNetwork;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class NetworkConfigFactory {
    private static final String KEY_NETWORK = "network";
    private static final String KEY_FORMAT = "format";
    private static final String KEY_AD_UNITS = "ad_units";
    private static final String[] PRIVATE_FIELDS = {"network", KEY_FORMAT, KEY_AD_UNITS};

    NetworkConfigFactory() {
    }

    static NetworkConfig create(Context context, AdNetwork adNetwork) {
        NetworkConfig create;
        if (context == null) {
            return null;
        }
        final String name = adNetwork.getName();
        if (TextUtils.isEmpty(name) || (create = create(context, name, adNetwork.getCustomParamsMap())) == null) {
            return null;
        }
        for (AdNetwork.AdUnit adUnit : adNetwork.getAdUnitsList()) {
            AdsFormat byRemoteName = AdsFormat.byRemoteName(adUnit.getAdFormat());
            if (byRemoteName != null) {
                create.withMediationConfig(byRemoteName, adUnit.getCustomParamsMap());
            } else {
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String format;
                        format = String.format("Network (%s) adUnit register fail: %s not provided", name, NetworkConfigFactory.KEY_FORMAT);
                        return format;
                    }
                });
            }
        }
        return create;
    }

    static NetworkConfig create(Context context, JSONObject networkConfigJson) {
        final String str;
        if (context == null) {
            return null;
        }
        try {
            str = networkConfigJson.getString("network");
            try {
                final NetworkConfig create = create(context, str, Utils.toMap(networkConfigJson));
                if (create == null) {
                    return null;
                }
                JSONArray jSONArray = networkConfigJson.getJSONArray(KEY_AD_UNITS);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    AdsFormat byRemoteName = AdsFormat.byRemoteName(jSONObject.getString(KEY_FORMAT));
                    if (byRemoteName != null) {
                        create.withMediationConfig(byRemoteName, filterParams(Utils.toMap(jSONObject)));
                    } else {
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda2
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                String format;
                                format = String.format("Network (%s) adUnit register fail: %s not provided", str, NetworkConfigFactory.KEY_FORMAT);
                                return format;
                            }
                        });
                    }
                }
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda3
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String format;
                        format = String.format("Load network from json config completed successfully: %s", NetworkConfig.this.getNetworkKey());
                        return format;
                    }
                });
                return create;
            } catch (Throwable th) {
                th = th;
                Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda4
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String format;
                        format = String.format("Network (%s) load fail!", str);
                        return format;
                    }
                });
                Logger.w(th);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    private static NetworkConfig create(Context context, final String networkName, Map<String, String> networkParams) {
        NetworkAssetParams networkAssetParams = NetworkAssetManager.getNetworkAssetParams(context, networkName);
        if (networkAssetParams == null) {
            return null;
        }
        try {
            return (NetworkConfig) Class.forName(networkAssetParams.getClasspath()).getConstructor(Map.class).newInstance(filterParams(networkParams));
        } catch (Throwable th) {
            Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.NetworkConfigFactory$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Network (%s) load fail!", networkName);
                    return format;
                }
            });
            Logger.w(th);
            return null;
        }
    }

    private static Map<String, String> filterParams(Map<String, String> params) {
        if (params != null) {
            try {
                for (String str : PRIVATE_FIELDS) {
                    params.remove(str);
                }
            } catch (Exception unused) {
            }
        }
        return params;
    }
}

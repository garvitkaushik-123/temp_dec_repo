package com.ironsource.mediationsdk.adunit.adapter.utility;

import com.ironsource.V9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AdData {
    private final Map<String, Object> mAdUnitData;
    private final Map<String, Object> mConfiguration;
    private final String mServerData;

    public AdData(String str, Map<String, Object> map, Map<String, Object> map2) {
        this.mServerData = str;
        this.mConfiguration = map;
        this.mAdUnitData = map2;
    }

    public static AdData createAdDataForNetworkAdapter(JSONObject jSONObject, IronSource.AD_UNIT ad_unit, String str) {
        return createAdDataForNetworkAdapter(jSONObject, ad_unit, str, null);
    }

    public Map<String, Object> getAdUnitData() {
        return this.mAdUnitData;
    }

    public Boolean getBoolean(String str) {
        return (Boolean) this.mConfiguration.get(str);
    }

    public Map<String, Object> getConfiguration() {
        return this.mConfiguration;
    }

    public Integer getInt(String str) {
        return (Integer) this.mConfiguration.get(str);
    }

    public String getServerData() {
        return this.mServerData;
    }

    public String getString(String str) {
        return (String) this.mConfiguration.get(str);
    }

    public static AdData createAdDataForNetworkAdapter(JSONObject jSONObject, IronSource.AD_UNIT ad_unit, String str, IronSourceBannerLayout ironSourceBannerLayout) {
        HashMap hashMap = new HashMap();
        hashMap.put("adUnit", ad_unit);
        if (str != null) {
            hashMap.put("userId", str);
        }
        if (ironSourceBannerLayout != null) {
            hashMap.put("bannerLayout", ironSourceBannerLayout);
        }
        return new AdData(null, V9.a(jSONObject), hashMap);
    }
}

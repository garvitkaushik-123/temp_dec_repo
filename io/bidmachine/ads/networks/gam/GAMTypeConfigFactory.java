package io.bidmachine.ads.networks.gam;

import io.bidmachine.AdsFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class GAMTypeConfigFactory {
    private static final String KEY_AD_UNIT_ID = "ad_unit_id";
    private static final String KEY_CACHE_SIZE = "cache_size";
    private static final String KEY_FORMAT = "format";
    private static final String KEY_UNITS = "units";

    public static GAMTypeConfig create(JSONObject json) {
        try {
            AdsFormat byRemoteName = AdsFormat.byRemoteName(json.getString(KEY_FORMAT));
            if (byRemoteName == null) {
                return null;
            }
            String string = json.getString(KEY_AD_UNIT_ID);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = json.getJSONArray(KEY_UNITS);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(GAMUnitDataFactory.create(string, jSONArray.getJSONObject(i)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new GAMTypeConfig(byRemoteName, arrayList, json.optInt(KEY_CACHE_SIZE, 2));
        } catch (Throwable unused) {
            return null;
        }
    }
}

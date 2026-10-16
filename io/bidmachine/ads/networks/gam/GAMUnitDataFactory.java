package io.bidmachine.ads.networks.gam;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.bidmachine.core.Utils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class GAMUnitDataFactory {
    static GAMUnitData create(String adUnitId, JSONObject json) {
        try {
            return create(adUnitId, Utils.toMap(json));
        } catch (Throwable unused) {
            return null;
        }
    }

    static GAMUnitData create(String adUnitId, Map<String, String> params) {
        if (params.isEmpty()) {
            return null;
        }
        String str = params.get(FirebaseAnalytics.Param.SCORE);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = params.get("price");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return create(adUnitId, str, str2, params);
    }

    static GAMUnitData create(String adUnitId, String score, String price, Map<String, String> customTargeting) {
        return new GAMUnitData(adUnitId, Float.parseFloat(score), Float.parseFloat(price), customTargeting);
    }
}

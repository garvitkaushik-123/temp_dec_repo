package io.bidmachine.ads.networks.gam.versions.v21_0_0;

import android.text.TextUtils;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import io.bidmachine.ads.networks.gam.GAMLoader;
import io.bidmachine.ads.networks.gam.GAMUnitData;
import java.util.Map;

/* loaded from: classes7.dex */
class a {
    static AdManagerAdRequest a(GAMLoader gamLoader, GAMUnitData gamUnitData) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        String requestAgent = gamLoader.getRequestAgent();
        if (!TextUtils.isEmpty(requestAgent)) {
            builder.setRequestAgent(requestAgent);
        }
        for (Map.Entry<String, String> entry : gamUnitData.getCustomTargeting().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                builder.addCustomTargeting(key, value);
            }
        }
        return builder.build();
    }
}

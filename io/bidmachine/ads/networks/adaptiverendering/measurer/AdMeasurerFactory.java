package io.bidmachine.ads.networks.adaptiverendering.measurer;

import android.content.Context;
import android.text.TextUtils;
import com.iab.omid.library.appodeal.adsession.VerificationScriptResource;
import io.bidmachine.core.Logger;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.rendering.measurer.HtmlMeasurer;
import io.bidmachine.rendering.measurer.MeasurerFactory;
import io.bidmachine.rendering.measurer.VideoMeasurer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AdMeasurerFactory implements MeasurerFactory {
    static final String JAVA_SCRIPT_RESOURCE_URL = "java_script_resource_url";
    static final String OM = "om";
    static final String SKIP_OFFSET = "skip_offset";
    static final String VENDOR = "vendor";
    static final String VERIFICATIONS = "verifications";
    static final String VERIFICATION_PARAMETERS = "verification_parameters";

    @Override // io.bidmachine.rendering.measurer.MeasurerFactory
    public HtmlMeasurer createHtmlMeasurer(Context context, String name, Map<String, String> parameters) {
        if (name.equalsIgnoreCase(OM) && OMSDKSettings.isInitialized()) {
            return new OMHtmlMeasurer();
        }
        return null;
    }

    @Override // io.bidmachine.rendering.measurer.MeasurerFactory
    public VideoMeasurer createVideoMeasurer(Context context, String name, Map<String, String> parameters) {
        List<VerificationScriptResource> verificationScriptResourceList;
        if (!name.equalsIgnoreCase(OM) || !OMSDKSettings.isInitialized() || parameters == null || parameters.isEmpty() || (verificationScriptResourceList = getVerificationScriptResourceList(parameters)) == null || verificationScriptResourceList.isEmpty()) {
            return null;
        }
        return new OMVideoMeasurer(verificationScriptResourceList, getSkipOffsetSec(parameters));
    }

    static List<VerificationScriptResource> getVerificationScriptResourceList(Map<String, String> parameters) {
        String str = parameters.get(VERIFICATIONS);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    addVerificationScriptResource(arrayList, optJSONObject.optString(JAVA_SCRIPT_RESOURCE_URL), optJSONObject.optString("vendor"), optJSONObject.optString(VERIFICATION_PARAMETERS));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    static void addVerificationScriptResource(List<VerificationScriptResource> verificationScriptResourceList, String javaScriptResourceUrl, String vendor, String verificationParameters) {
        VerificationScriptResource createVerificationScriptResourceWithoutParameters;
        try {
            URL url = new URL(javaScriptResourceUrl);
            if (!TextUtils.isEmpty(vendor) && !TextUtils.isEmpty(verificationParameters)) {
                createVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(vendor, url, verificationParameters);
            } else {
                createVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
            }
            verificationScriptResourceList.add(createVerificationScriptResourceWithoutParameters);
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    static Float getSkipOffsetSec(Map<String, String> parameters) {
        if (TextUtils.isEmpty(parameters.get(SKIP_OFFSET))) {
            return null;
        }
        try {
            return Float.valueOf(Long.parseLong(r4) / 1000.0f);
        } catch (Throwable unused) {
            return null;
        }
    }
}

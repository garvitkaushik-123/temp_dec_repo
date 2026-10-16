package com.applovin.impl.sdk.ad;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.applovin.impl.adview.e;
import com.applovin.impl.d4;
import com.applovin.impl.f5;
import com.applovin.impl.n4;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a extends b implements n4 {
    private final String n;
    private final String o;
    private final String p;
    private final d4 q;

    public a(JSONObject jSONObject, JSONObject jSONObject2, k kVar) {
        super(jSONObject, jSONObject2, kVar);
        this.n = s1();
        this.o = w1();
        this.p = v1();
        this.q = new d4(this);
    }

    public static a a(JSONObject jSONObject, k kVar) {
        JSONObject jSONObject2;
        if (jSONObject == null || (jSONObject2 = JsonUtils.getJSONObject(jSONObject, "full_response", (JSONObject) null)) == null) {
            return null;
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject2, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray()), 0, (JSONObject) null);
        if (jSONObject3 == null) {
            return null;
        }
        String string = JsonUtils.getString(jSONObject3, AnalyticsConstants.CREATIVE_TYPE_HTML, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String string2 = JsonUtils.getString(jSONObject3, "video", "");
        JsonUtils.putString(jSONObject3, AnalyticsConstants.CREATIVE_TYPE_HTML, JsonUtils.getString(jSONObject, "original_html_source", ""));
        JsonUtils.putString(jSONObject3, "video", JsonUtils.getString(jSONObject, "original_video_uri_string", ""));
        a aVar = new a(jSONObject3, jSONObject2, kVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray, i, null);
            if (objectAtIndex instanceof String) {
                String str = (String) objectAtIndex;
                if (!TextUtils.isEmpty(str)) {
                    aVar.a(Uri.parse(str));
                }
            }
        }
        aVar.d(string);
        if (StringUtils.isValidString(string2)) {
            aVar.d(Uri.parse(string2));
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(f5 f5Var) {
        f5Var.b(AnalyticsConstants.CREATIVE_TYPE_HTML, this.n);
        f5Var.b("stream_url", this.p);
    }

    private String v1() {
        return getStringFromAdObject("stream_url", "");
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean K0() {
        return getBooleanFromFullResponse("is_persisted_ad", false);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public boolean O0() {
        return containsKeyForAdObject("stream_url");
    }

    @Override // com.applovin.impl.sdk.ad.b
    public void Q0() {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.a(new Consumer() { // from class: com.applovin.impl.sdk.ad.a$$ExternalSyntheticLambda0
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    a.this.t((f5) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, AnalyticsConstants.CREATIVE_TYPE_HTML, this.n);
            JsonUtils.putString(this.adObject, "stream_url", this.p);
        }
    }

    @Override // com.applovin.impl.sdk.ad.b
    public String S() {
        return this.o;
    }

    public void d(String str) {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.b(AnalyticsConstants.CREATIVE_TYPE_HTML, str);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, AnalyticsConstants.CREATIVE_TYPE_HTML, str);
        }
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        JSONObject deepCopy;
        JSONObject jSONObject;
        f5 f5Var = this.synchronizedFullResponse;
        if (f5Var != null) {
            jSONObject = f5Var.a();
        } else {
            synchronized (this.fullResponseLock) {
                deepCopy = JsonUtils.deepCopy(this.fullResponse);
            }
            jSONObject = deepCopy;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject2, AnalyticsConstants.CREATIVE_TYPE_HTML, this.n);
            JsonUtils.putString(jSONObject2, "video", this.o);
            JsonUtils.putString(jSONObject2, "stream_url", this.p);
        }
        return jSONObject;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean hasVideoUrl() {
        return v0() != null;
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public boolean isOpenMeasurementEnabled() {
        if (this.sdk.e0().e()) {
            return true;
        }
        return getBooleanFromAdObject(UnifiedMediationParams.KEY_OM_SDK_ENABLED, Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri m() {
        String stringFromAdObject = getStringFromAdObject(CampaignEx.JSON_KEY_CLICK_URL, "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri m0() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : m();
    }

    public e.a r1() {
        return a(getIntFromAdObject("expandable_style", e.a.INVISIBLE.b()));
    }

    public String s1() {
        return getStringFromAdObject(AnalyticsConstants.CREATIVE_TYPE_HTML, "");
    }

    public float t1() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    public String u1() {
        return this.p;
    }

    @Override // com.applovin.impl.sdk.ad.b
    public Uri v0() {
        String v1 = v1();
        if (StringUtils.isValidString(v1)) {
            return Uri.parse(v1);
        }
        String w1 = w1();
        if (StringUtils.isValidString(w1)) {
            return Uri.parse(w1);
        }
        return null;
    }

    public String w1() {
        return getStringFromAdObject("video", "");
    }

    public boolean x1() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", Boolean.FALSE);
        }
        return true;
    }

    public void y1() {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.c("stream_url");
            return;
        }
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    @Override // com.applovin.impl.sdk.ad.b, com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public d4 getAdEventTracker() {
        return this.q;
    }

    public void d(Uri uri) {
        f5 f5Var = this.synchronizedAdObject;
        if (f5Var != null) {
            f5Var.b("video", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "video", uri.toString());
        }
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "original_html_source", this.n);
        JsonUtils.putString(jSONObject, "original_video_uri_string", this.o);
        JsonUtils.putString(jSONObject, "original_video_stream_uri_string", this.p);
        ArrayList arrayList = new ArrayList();
        Iterator it = l().iterator();
        while (it.hasNext()) {
            arrayList.add(((Uri) it.next()).toString());
        }
        JsonUtils.putJsonArray(jSONObject, "cached_ad_html_resources_urls", new JSONArray((Collection) arrayList));
        f5 f5Var = this.synchronizedFullResponse;
        if (f5Var != null) {
            JsonUtils.putJSONObject(jSONObject, "full_response", f5Var.a());
            return jSONObject;
        }
        synchronized (this.fullResponseLock) {
            JsonUtils.putJSONObject(jSONObject, "full_response", this.fullResponse);
        }
        return jSONObject;
    }
}

package com.bytedance.sdk.openadsdk.Dfc.eli;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Dfc.eli.aGH;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.N6;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.iab.vast.tags.VastAttributes;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH<T extends aGH> implements Os {
    private String DbA;
    private String FC;
    private String Os;
    private String aAs;
    private String du;
    private String eli;
    private String kb;
    private String nlS;
    private final String aGH = BuildConfig.VERSION_NAME;
    private long ui = System.currentTimeMillis() / 1000;
    private int MGA = 0;
    private int wC = 0;

    private T aqO() {
        return this;
    }

    public static aGH<aGH> DbA() {
        return new aGH<>();
    }

    @Override // com.bytedance.sdk.openadsdk.Dfc.eli.Os
    public JSONObject eli() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ad_sdk_version", kb());
            jSONObject2.put(BidTokenRepositoryKt.APP_VERSION, dZ.wC());
            jSONObject2.put("timestamp", wC());
            jSONObject2.put("conn_type", nGm.DbA(dV.eli()));
            jSONObject2.put("appid", TextUtils.isEmpty(FC.DbA().aGH()) ? "" : FC.DbA().aGH());
            jSONObject2.put("device_info", Dfc());
            if (!TextUtils.isEmpty(Os())) {
                jSONObject2.put("type", Os());
            }
            jSONObject2.put(AndroidBridgeConstants.ERROR_CODE, du());
            if (!TextUtils.isEmpty(nlS())) {
                jSONObject2.put("error_msg", nlS());
            }
            if (!TextUtils.isEmpty(ui())) {
                jSONObject2.put("rit", ui());
            }
            if (!TextUtils.isEmpty(MGA())) {
                jSONObject2.put(CampaignEx.JSON_KEY_CREATIVE_ID, MGA());
            }
            if (FC() > 0) {
                jSONObject2.put("adtype", FC());
            }
            if (!TextUtils.isEmpty(aAs())) {
                jSONObject2.put("req_id", aAs());
            }
            if (!TextUtils.isEmpty(NU())) {
                jSONObject2.put("extra", NU());
            }
            String aGH = aGH();
            if (TextUtils.isEmpty(aGH)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(aGH);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            }
            if (jSONObject != null) {
                jSONObject.put("os_version_int", Build.VERSION.SDK_INT);
                jSONObject2.put("event_extra", jSONObject.toString());
            } else if (!TextUtils.isEmpty(aGH)) {
                jSONObject2.put("event_extra", aGH);
            }
            if (!TextUtils.isEmpty(nn())) {
                jSONObject2.put("duration", nn());
            }
        } catch (Throwable th) {
            Xb.Os("LogStatsBase", th.getMessage());
        }
        return jSONObject2;
    }

    private JSONObject Dfc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(N6.F, 1);
            jSONObject.put(N6.B, Build.MODEL);
            jSONObject.put(VastAttributes.VENDOR, Build.MANUFACTURER);
            jSONObject.put("package_name", dZ.MGA());
            jSONObject.put(N6.d0, dZ.aGH());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String Os() {
        return this.eli;
    }

    public T eli(String str) {
        this.eli = str;
        return aqO();
    }

    public String aGH() {
        return this.du;
    }

    public T DbA(String str) {
        this.du = str;
        return aqO();
    }

    public String ui() {
        return this.DbA;
    }

    public T Os(String str) {
        this.DbA = str;
        return aqO();
    }

    public String MGA() {
        return this.Os;
    }

    public T aGH(String str) {
        this.Os = str;
        return aqO();
    }

    public String kb() {
        return TextUtils.isEmpty(BuildConfig.VERSION_NAME) ? "" : BuildConfig.VERSION_NAME;
    }

    public long wC() {
        return this.ui;
    }

    public int FC() {
        return this.MGA;
    }

    public T eli(int i) {
        this.MGA = i;
        return aqO();
    }

    public String aAs() {
        return this.kb;
    }

    public T ui(String str) {
        this.kb = str;
        return aqO();
    }

    public int du() {
        return this.wC;
    }

    public T DbA(int i) {
        this.wC = i;
        return aqO();
    }

    public String nlS() {
        return this.FC;
    }

    public T MGA(String str) {
        this.FC = str;
        return aqO();
    }

    public String NU() {
        return this.aAs;
    }

    public T kb(String str) {
        this.aAs = str;
        return aqO();
    }

    public String nn() {
        return this.nlS;
    }

    public T wC(String str) {
        this.nlS = str;
        return aqO();
    }
}

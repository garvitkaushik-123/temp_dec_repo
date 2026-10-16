package com.bytedance.sdk.openadsdk.aGH.eli;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.Ue;
import com.bytedance.sdk.openadsdk.utils.VM;
import com.bytedance.sdk.openadsdk.utils.Vy;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private int DbA;
    private final Context Os;
    private final boolean aGH;
    private long eli;
    private final String ui;

    private static class eli {
        private static final Os eli = new Os();
    }

    public static Os eli() {
        return eli.eli;
    }

    private Os() {
        this.aGH = Os();
        this.Os = dV.eli().getApplicationContext();
        this.ui = ui();
    }

    public String eli(List<com.bytedance.sdk.openadsdk.aGH.eli> list) {
        String str;
        if (list.size() > 0 && list.get(0) != null && list.get(0).Os() != null) {
            str = list.get(0).Os().optString("app_log_url");
        } else {
            str = "";
        }
        return dZ.ui(str);
    }

    private void eli(com.bytedance.sdk.openadsdk.aGH.eli eliVar, boolean z) {
        if (eliVar == null) {
            return;
        }
        try {
            String optString = z ? eliVar.Os().optJSONObject("params").optString("log_extra", "") : eliVar.Os().optString("log_extra", "");
            long eli2 = ev.eli(optString);
            int aGH = ev.aGH(optString);
            if (eli2 == 0) {
                eli2 = this.eli;
            }
            this.eli = eli2;
            if (aGH == 0) {
                aGH = this.DbA;
            }
            this.DbA = aGH;
        } catch (Exception e) {
            Xb.Os("AdLogParamsGenerate", "getInfoFromLogExtra exception", e.getMessage());
        }
    }

    public JSONObject eli(List<com.bytedance.sdk.openadsdk.aGH.eli> list, long j, JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            eli(list.get(0), z);
            jSONObject2.put("header", jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.aGH.eli> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().eli(z));
            }
            if (z) {
                jSONObject2.put("event_v3", jSONArray);
                jSONObject2.put("magic_tag", "ss_app_log");
            } else {
                jSONObject2.put("event", jSONArray);
            }
            jSONObject2.put("_gen_time", j);
            jSONObject2.put("local_time", j / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public List<com.bytedance.sdk.openadsdk.aGH.eli> eli(List<com.bytedance.sdk.openadsdk.aGH.eli> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.aGH.eli eliVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject Os = eliVar.Os();
                jSONObject.putOpt("event", Os.optString("label"));
                long optLong = Os.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(optLong));
                jSONObject.putOpt("datetime", com.bytedance.sdk.openadsdk.aGH.MGA.Os.format(new Date(optLong)));
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> keys = Os.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.equals(next, "label")) {
                        jSONObject2.putOpt(next, Os.opt(next));
                    }
                }
                if (z) {
                    jSONObject2.putOpt("_ad_staging_flag", 3);
                }
                jSONObject.putOpt("params", jSONObject2);
                arrayList.add(new com.bytedance.sdk.openadsdk.aGH.MGA(eliVar.eli, jSONObject));
            } catch (Exception e) {
                Xb.Os("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    public List<com.bytedance.sdk.openadsdk.aGH.eli> DbA(List<com.bytedance.sdk.openadsdk.aGH.eli> list) {
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.sdk.openadsdk.aGH.eli eliVar : list) {
            try {
                JSONObject Os = eliVar.Os();
                Os.putOpt("_ad_staging_flag", 1);
                arrayList.add(new com.bytedance.sdk.openadsdk.aGH.eli(eliVar.eli, Os));
            } catch (Exception e) {
                Xb.Os("AdLogParamsGenerate", e.getMessage());
            }
        }
        return arrayList;
    }

    public JSONObject DbA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(N6.d0, dZ.aGH());
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put(BidTokenRepositoryKt.APP_VERSION, dZ.wC());
            jSONObject.put("sim_op", eli(this.Os));
            jSONObject.put("root", this.aGH ? 1 : 0);
            jSONObject.put("timezone", aGH());
            jSONObject.put("access", Vy.eli(this.Os));
            jSONObject.put(N6.F, C3040d4.d);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_type", this.ui);
            jSONObject.put(BidTokenRepositoryKt.DEVICE_MODEL, Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put(BidTokenRepositoryKt.DEVICE_MANUFACTURER, Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", SSo.ui(this.Os) + VastAttributes.HORIZONTAL_POSITION + SSo.Os(this.Os));
            jSONObject.put("display_density", eli(SSo.aAs(this.Os)));
            jSONObject.put("density_dpi", SSo.aAs(this.Os));
            jSONObject.put(C3114ha.b, "1371");
            jSONObject.put("device_id", com.bytedance.sdk.openadsdk.core.nlS.eli(this.Os));
            jSONObject.put("rom", MGA());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("ut", this.DbA);
            jSONObject.put("uid", this.eli);
            jSONObject.put("google_aid", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
            jSONObject.put("locale_language", DeviceUtils.aGH());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.ui() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", !DeviceUtils.DbA() ? 1 : 0);
            com.bytedance.sdk.openadsdk.core.settings.MGA aGH = dV.aGH();
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.ev.eli(this.Os, "tt_choose_language"));
            if (aGH.ujq("mnc")) {
                jSONObject.put("mnc", VM.Os());
            }
            if (aGH.ujq("mcc")) {
                jSONObject.put("mcc", VM.DbA());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private String eli(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean Os() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private int aGH() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / Constants.ONE_HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String ui() {
        if (DeviceUtils.Os(this.Os)) {
            return "tv";
        }
        if (DeviceUtils.DbA(this.Os)) {
            return "android_pad";
        }
        return "android";
    }

    private String eli(int i) {
        if (i == 120) {
            return "ldpi";
        }
        if (i == 160) {
            return "mdpi";
        }
        if (i == 240) {
            return "hdpi";
        }
        if (i == 320) {
            return "xhdpi";
        }
        if (i == 480) {
            return "xxhdpi";
        }
        if (i != 640) {
            return "mdpi";
        }
        return "xxxhdpi";
    }

    private String MGA() {
        StringBuilder sb = new StringBuilder();
        try {
            if (Ue.ui()) {
                sb.append("MIUI-");
            } else if (Ue.DbA()) {
                sb.append("FLYME-");
            } else {
                String nn = Ue.nn();
                if (Ue.eli(nn)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(nn)) {
                    sb.append(nn).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}

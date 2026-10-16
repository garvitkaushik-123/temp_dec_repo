package com.bytedance.sdk.openadsdk.component.kb;

import android.content.Context;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.MGA;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.multipro.DbA;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    public static File eli(String str) {
        return new File(CacheDirFactory.getICacheDir(0).DbA() + File.separator + str);
    }

    public static File DbA(String str) {
        return eli(dV.eli(), MGA.eli(dV.eli()).DbA(), str);
    }

    public static File eli(Context context, String str, String str2) {
        return kb.eli(context, DbA.Os(), str, str2);
    }

    public static void eli(File file) {
        if (file == null) {
            return;
        }
        try {
            kb.DbA(file);
        } catch (Throwable unused) {
        }
    }

    public static void eli(Context context) {
        try {
            MGA.eli(context).eli();
        } catch (Throwable unused) {
        }
    }

    public static String eli() {
        return kb.eli(dV.eli(), DbA.Os(), MGA.eli(dV.eli()).DbA()).getAbsolutePath();
    }

    public static void eli(JSONObject jSONObject, int i, boolean z) {
        try {
            String wC = FC.DbA().wC();
            int FC = FC.DbA().FC();
            JSONObject jSONObject2 = jSONObject.getJSONObject("creative");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", wC);
            if (!z) {
                jSONObject3.put("app_icon_id", "@".concat(String.valueOf(FC)));
            } else if (FC.DbA().FC() != 0) {
                jSONObject3.put("app_icon_id", "local://pag_open_icon_id");
            }
            jSONObject2.put("open_app_info", jSONObject3);
            if (jSONObject2.optJSONObject("video") == null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("video_duration", dV.aGH().CMM(String.valueOf(i)));
                jSONObject2.put("video", jSONObject4);
            }
        } catch (Exception e) {
            Xb.Os("TTAppOpenUtils", e.getMessage());
        }
    }

    public static int eli(ev evVar, int i) {
        return i - evVar.ox();
    }
}

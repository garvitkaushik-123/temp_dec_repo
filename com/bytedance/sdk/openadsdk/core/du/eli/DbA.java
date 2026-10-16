package com.bytedance.sdk.openadsdk.core.du.eli;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class DbA {
    protected final Context DbA;
    public eli MGA;
    protected int Os;
    protected double aGH;
    public int eli;
    public int ui;

    public static class eli {
        public int DbA;
        public boolean Os;
        public int eli;
    }

    public abstract com.bytedance.sdk.openadsdk.core.du.eli eli(String str, File file, List<Os> list);

    public DbA(Context context, int i, int i2) {
        this.Os = 0;
        this.aGH = 0.0d;
        if (i2 > 0 && i > 0) {
            this.aGH = i / i2;
        }
        float wC = SSo.wC(context);
        if (wC != 0.0f && i > 0) {
            this.Os = (int) (i / wC);
        }
        this.DbA = context.getApplicationContext();
    }

    protected void eli(Exception exc, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", exc.getMessage());
            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
            com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli("load_vast", jSONObject);
        } catch (Exception unused) {
        }
    }

    protected boolean eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    protected String eli(String str, List<Os> list) {
        int i = this.eli;
        String str2 = null;
        if (i >= 5) {
            return null;
        }
        this.eli = i + 1;
        if (str == null) {
            return null;
        }
        try {
            com.bytedance.sdk.component.kb.DbA.DbA Os = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
            Os.DbA(str);
            com.bytedance.sdk.component.kb.DbA eli2 = Os.eli();
            str2 = eli2.aGH();
            eli2.eli();
            return str2;
        } catch (Exception e) {
            eli(e, 0);
            if (!list.isEmpty()) {
                Os.DbA((ev) null, list, com.bytedance.sdk.openadsdk.core.du.eli.eli.WRAPPER_TIMEOUT, -1L, (String) null, (String) null);
            }
            return str2;
        }
    }
}

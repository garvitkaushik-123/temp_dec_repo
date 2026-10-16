package com.bytedance.sdk.openadsdk.core.aAs.MGA;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    private boolean Dfc;
    private final String FC;
    private boolean NU;
    private com.bytedance.adsdk.ugeno.DbA.Os Os;
    private com.bytedance.sdk.openadsdk.core.widget.ui aAs;
    private com.bytedance.adsdk.ugeno.DbA.Os aGH;
    private JSONArray aqO;
    private JSONObject du;
    private final Context kb;
    private final JSONObject nlS;
    private boolean nn;
    private com.bytedance.adsdk.ugeno.DbA.Os ui;
    private final ev wC;
    private int eli = -1;
    private int DbA = -1;
    private final String MGA = "UGenSwiperEvent";

    public aGH(Context context, ev evVar, String str, JSONObject jSONObject) {
        this.kb = context;
        this.wC = evVar;
        this.FC = str;
        this.nlS = jSONObject;
    }

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os<View> os) {
        com.bytedance.adsdk.ugeno.DbA.Os<View> aGH = os.aGH("swiperLayout");
        this.ui = aGH;
        if (aGH instanceof com.bytedance.adsdk.ugeno.Os) {
            this.aqO = this.nlS.optJSONArray("dpa_data");
            this.Os = os.aGH("swiperLeftArrow");
            this.aGH = os.aGH("swiperRightArrow");
            ((com.bytedance.adsdk.ugeno.Os) this.ui).eli(new com.bytedance.adsdk.ugeno.MGA.Os() { // from class: com.bytedance.sdk.openadsdk.core.aAs.MGA.aGH.1
                @Override // com.bytedance.adsdk.ugeno.MGA.Os
                public void eli(boolean z, int i) {
                }

                @Override // com.bytedance.adsdk.ugeno.MGA.Os
                public void eli(boolean z, int i, float f, int i2) {
                }

                @Override // com.bytedance.adsdk.ugeno.MGA.Os
                public void eli(boolean z, int i, int i2, boolean z2, boolean z3) {
                    aGH.this.DbA = i;
                    aGH.this.eli = i2;
                    aGH.this.NU = z;
                    aGH.this.nn = z2;
                    aGH.this.Dfc = z3;
                    aGH.this.eli(z, z2, z3);
                    aGH.this.eli(i);
                }
            });
        }
    }

    public void eli() {
        eli(this.NU, this.nn, this.Dfc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(boolean z, boolean z2, boolean z3) {
        com.bytedance.adsdk.ugeno.DbA.Os os = this.Os;
        if (os == null || this.aGH == null) {
            return;
        }
        View du = os.du();
        View du2 = this.aGH.du();
        JSONArray jSONArray = this.aqO;
        if (jSONArray != null && jSONArray.length() == 1) {
            du.setVisibility(8);
            du2.setVisibility(8);
            return;
        }
        if (z) {
            return;
        }
        if (z2) {
            if (du instanceof TextView) {
                eli((TextView) du, 90);
            }
            if (du2 instanceof TextView) {
                eli((TextView) du2, 255);
                return;
            }
            return;
        }
        if (z3) {
            if (du instanceof TextView) {
                eli((TextView) du, 255);
            }
            if (du2 instanceof TextView) {
                eli((TextView) du2, 90);
                return;
            }
            return;
        }
        if (du instanceof TextView) {
            eli((TextView) du, 255);
        }
        if (du2 instanceof TextView) {
            eli((TextView) du2, 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.wC, this.FC, "carousel_show", jSONObject);
    }

    private void eli(TextView textView, int i) {
        int currentTextColor = textView.getCurrentTextColor();
        textView.setTextColor(Color.argb(i, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
    }

    public void DbA() {
        int i;
        com.bytedance.adsdk.ugeno.DbA.Os os = this.ui;
        if (!(os instanceof com.bytedance.adsdk.ugeno.Os) || (i = this.eli) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.Os) os).eli(i - 1);
    }

    public void Os() {
        int i;
        com.bytedance.adsdk.ugeno.DbA.Os os = this.ui;
        if (!(os instanceof com.bytedance.adsdk.ugeno.Os) || (i = this.eli) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.Os) os).eli(i + 1);
    }

    public void eli(com.bytedance.sdk.openadsdk.core.widget.ui uiVar) {
        this.aAs = uiVar;
    }

    public boolean eli(NU nu) {
        JSONObject optJSONObject;
        this.du = null;
        int i = this.DbA;
        if (i != -1 && i != 0) {
            try {
                JSONObject Os = nu.Os();
                if (Os != null && (optJSONObject = Os.optJSONObject("related_dpa_click")) != null) {
                    boolean optBoolean = optJSONObject.optBoolean("enableOpenExternalUrl");
                    int optInt = optJSONObject.optInt("landingStyle");
                    if (optBoolean && optInt != -1) {
                        if (this.aqO != null) {
                            String eli = com.bytedance.adsdk.ugeno.Os.DbA.eli(optJSONObject.optString("url"), this.aqO.optJSONObject(this.DbA));
                            String eli2 = com.bytedance.adsdk.ugeno.Os.DbA.eli(optJSONObject.optString("fallback_url"), this.aqO.optJSONObject(this.DbA));
                            optJSONObject.put("url", eli);
                            optJSONObject.put("fallback_url", eli2);
                            eli(optJSONObject, this.aqO.optJSONObject(this.DbA));
                        }
                        eli(optJSONObject, nu.eli().du());
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                Xb.Os("UGenSwiperEvent", th.getMessage());
            }
        }
        return false;
    }

    private void eli(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("clickInfo");
        this.du = optJSONObject;
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    this.du.putOpt(next, com.bytedance.adsdk.ugeno.Os.DbA.eli((String) this.du.opt(next), jSONObject2));
                } catch (Throwable unused) {
                }
            }
            try {
                jSONObject.putOpt("clickInfo", this.du);
            } catch (Throwable unused2) {
            }
        }
    }

    public JSONObject aGH() {
        return this.du;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0008, code lost:
    
        if (r4 != 3) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean eli(int i, String str, String str2) {
        if (i != 1) {
            if (i == 2) {
                if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || !nGm.eli(str2)) {
                    return false;
                }
            }
        }
        return nGm.eli(str);
    }

    private void eli(JSONObject jSONObject, View view) {
        if (eli(jSONObject.optInt("landingStyle"), jSONObject.optString("url"), jSONObject.optString("fallback_url"))) {
            com.bytedance.sdk.openadsdk.core.nGm.eli(eli(view), this.kb instanceof Activity, jSONObject, this.wC, this.FC, dZ.eli(this.FC), null, this.aAs);
        }
    }

    private Context eli(View view) {
        Activity eli = view != null ? com.bytedance.sdk.component.utils.DbA.eli(view) : null;
        return eli == null ? this.kb : eli;
    }
}

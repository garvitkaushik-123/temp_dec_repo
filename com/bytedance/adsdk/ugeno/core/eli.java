package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private float DbA;
    private String MGA;
    private List<C0123eli> Os;
    private long aGH;
    private String eli;
    private long ui;

    public String eli() {
        return this.eli;
    }

    public void eli(String str) {
        this.eli = str;
    }

    public void eli(float f) {
        this.DbA = f;
    }

    public float DbA() {
        return this.DbA;
    }

    public List<C0123eli> Os() {
        return this.Os;
    }

    public void eli(List<C0123eli> list) {
        this.Os = list;
    }

    public long aGH() {
        return this.aGH;
    }

    public void eli(long j) {
        this.aGH = j;
    }

    public long ui() {
        return this.ui;
    }

    public void DbA(long j) {
        this.ui = j;
    }

    public String MGA() {
        return this.MGA;
    }

    public void DbA(String str) {
        this.MGA = str;
    }

    public static eli eli(String str, com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return eli(new JSONObject(str), os);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static eli eli(JSONObject jSONObject, com.bytedance.adsdk.ugeno.DbA.Os os) {
        return eli(jSONObject, null, os);
    }

    public static eli eli(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (jSONObject == null) {
            return null;
        }
        eli eliVar = new eli();
        eliVar.eli(jSONObject.optString("ordering"));
        String optString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", optString)) {
            eliVar.eli(-1.0f);
        } else {
            try {
                eliVar.eli(Float.parseFloat(optString));
            } catch (NumberFormatException unused) {
                eliVar.eli(0.0f);
            }
        }
        eliVar.eli(jSONObject.optLong("duration", 0L));
        eliVar.DbA(com.bytedance.adsdk.ugeno.kb.Os.eli(com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("startDelay"), os.nlS()), 0L));
        eliVar.DbA(jSONObject.optString("loopMode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("animators");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.kb.DbA.eli(jSONObject2, optJSONObject);
                }
                arrayList.add(C0123eli.eli(optJSONObject, os));
            }
            eliVar.eli(arrayList);
        }
        return eliVar;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.core.eli$eli, reason: collision with other inner class name */
    public static class C0123eli {
        private float DbA;
        private String FC;
        private float MGA;
        private String Os;
        private String aAs;
        private long aGH;
        private long eli;
        private float kb;
        private String ui;
        private float[] wC;

        public long eli() {
            return this.eli;
        }

        public void eli(long j) {
            this.eli = j;
        }

        public float DbA() {
            return this.DbA;
        }

        public void eli(float f) {
            this.DbA = f;
        }

        public String Os() {
            return this.Os;
        }

        public void eli(String str) {
            this.Os = str;
        }

        public long aGH() {
            return this.aGH;
        }

        public void DbA(long j) {
            this.aGH = j;
        }

        public String ui() {
            return this.ui;
        }

        public void DbA(String str) {
            this.ui = str;
        }

        public float MGA() {
            return this.MGA;
        }

        public void DbA(float f) {
            this.MGA = f;
        }

        public float kb() {
            return this.kb;
        }

        public void Os(float f) {
            this.kb = f;
        }

        public float[] wC() {
            return this.wC;
        }

        public void eli(float[] fArr) {
            this.wC = fArr;
        }

        public String FC() {
            return this.FC;
        }

        public String aAs() {
            return this.aAs;
        }

        public void Os(String str) {
            this.aAs = str;
        }

        public void aGH(String str) {
            this.FC = str;
        }

        public static C0123eli eli(JSONObject jSONObject, com.bytedance.adsdk.ugeno.DbA.Os os) {
            if (jSONObject == null) {
                return null;
            }
            C0123eli c0123eli = new C0123eli();
            c0123eli.eli(jSONObject.optLong("duration"));
            String optString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", optString)) {
                c0123eli.eli(-1.0f);
            } else {
                try {
                    c0123eli.eli(Float.parseFloat(optString));
                } catch (NumberFormatException unused) {
                    c0123eli.eli(0.0f);
                }
            }
            c0123eli.eli(jSONObject.optString("loopMode"));
            c0123eli.DbA(jSONObject.optString("type"));
            if (TextUtils.equals(c0123eli.ui(), "ripple")) {
                c0123eli.Os(jSONObject.optString("rippleColor"));
            }
            View du = os.du();
            Context context = du != null ? du.getContext() : null;
            if (TextUtils.equals(c0123eli.ui(), "backgroundColor")) {
                String eli = com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("valueTo"), os.nlS());
                int eli2 = com.bytedance.adsdk.ugeno.kb.eli.eli(jSONObject.optString("valueFrom"));
                int eli3 = com.bytedance.adsdk.ugeno.kb.eli.eli(eli);
                c0123eli.DbA(eli2);
                c0123eli.Os(eli3);
            } else if ((TextUtils.equals(c0123eli.ui(), "translateX") || TextUtils.equals(c0123eli.ui(), "translateY")) && context != null) {
                try {
                    float eli4 = com.bytedance.adsdk.ugeno.kb.wC.eli(context, (float) jSONObject.optDouble("valueFrom"));
                    float eli5 = com.bytedance.adsdk.ugeno.kb.wC.eli(context, (float) jSONObject.optDouble("valueTo"));
                    c0123eli.DbA(eli4);
                    c0123eli.Os(eli5);
                } catch (Exception unused2) {
                    Log.e("animation", "animation ");
                }
            } else {
                c0123eli.DbA((float) jSONObject.optDouble("valueFrom"));
                c0123eli.Os((float) jSONObject.optDouble("valueTo"));
            }
            c0123eli.aGH(jSONObject.optString("interpolator"));
            String eli6 = com.bytedance.adsdk.ugeno.Os.DbA.eli(jSONObject.optString("startDelay"), os.nlS());
            Log.d("TAG", "createAnimationModel: ");
            c0123eli.DbA(com.bytedance.adsdk.ugeno.kb.Os.eli(eli6, 0L));
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                float[] fArr = new float[optJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0123eli.ui(), "translateX") || TextUtils.equals(c0123eli.ui(), "translateY")) && context != null) {
                    while (i < optJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.kb.wC.eli(context, (float) eli.eli(optJSONArray.optString(i), os.nlS()));
                        i++;
                    }
                } else {
                    while (i < optJSONArray.length()) {
                        fArr[i] = (float) eli.eli(optJSONArray.optString(i), os.nlS());
                        i++;
                    }
                }
                c0123eli.eli(fArr);
            }
            return c0123eli;
        }
    }

    public static double eli(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.kb.Os.eli(com.bytedance.adsdk.ugeno.Os.DbA.eli((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}

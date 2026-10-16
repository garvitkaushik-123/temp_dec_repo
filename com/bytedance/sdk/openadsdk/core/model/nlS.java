package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    private final int[] DbA;
    private final SparseArray<Os.eli> Dfc;
    private final long FC;
    private final float MGA;
    private final int NU;
    private final int[] Os;
    private final JSONObject QX;
    private final long aAs;
    private final int[] aGH;
    private final int aqO;
    private final JSONObject dV;
    private final int du;
    private final int[] eli;
    private final float kb;
    private final String nGm;
    private final int nlS;
    private final int nn;
    private final float ui;
    private final float wC;

    private nlS(eli eliVar) {
        this.eli = eliVar.du;
        this.DbA = eliVar.nlS;
        this.aGH = eliVar.NU;
        this.Os = eliVar.aAs;
        this.ui = eliVar.FC;
        this.MGA = eliVar.wC;
        this.kb = eliVar.kb;
        this.wC = eliVar.MGA;
        this.FC = eliVar.ui;
        this.aAs = eliVar.aGH;
        this.du = eliVar.nn;
        this.nlS = eliVar.Dfc;
        this.NU = eliVar.aqO;
        this.nn = eliVar.nGm;
        this.Dfc = eliVar.dV;
        this.nGm = eliVar.QX;
        this.aqO = eliVar.Xb;
        this.dV = eliVar.bf;
        this.QX = eliVar.CMM;
    }

    public JSONObject eli() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.QX;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.QX.opt(next));
                    }
                } catch (Exception unused) {
                }
            }
            int[] iArr = this.eli;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.eli[1]));
            }
            int[] iArr2 = this.DbA;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.DbA[1]));
            }
            int[] iArr3 = this.Os;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.Os[1]));
            }
            int[] iArr4 = this.aGH;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.aGH[1]));
            }
            jSONObject.putOpt("down_x", Float.toString(this.ui)).putOpt("down_y", Float.toString(this.MGA)).putOpt("up_x", Float.toString(this.kb)).putOpt("up_y", Float.toString(this.wC)).putOpt("down_time", Long.valueOf(this.FC)).putOpt("up_time", Long.valueOf(this.aAs)).putOpt("toolType", Integer.valueOf(this.du)).putOpt("deviceId", Integer.valueOf(this.nlS)).putOpt("source", Integer.valueOf(this.NU)).putOpt("ft", eli(this.Dfc, this.nn)).putOpt("click_area_type", this.nGm);
            int i = this.aqO;
            if (i > 0) {
                jSONObject.putOpt("areaType", Integer.valueOf(i));
            }
            JSONObject jSONObject3 = this.dV;
            if (jSONObject3 != null) {
                jSONObject.putOpt("rectInfo", jSONObject3);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static JSONObject eli(SparseArray<Os.eli> sparseArray, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (sparseArray != null) {
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    Os.eli valueAt = sparseArray.valueAt(i2);
                    if (valueAt != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("force", Double.valueOf(valueAt.Os)).putOpt("mr", Double.valueOf(valueAt.DbA)).putOpt("phase", Integer.valueOf(valueAt.eli)).putOpt("ts", Long.valueOf(valueAt.aGH));
                        jSONArray.put(jSONObject2);
                        jSONObject.putOpt("ftc", Integer.valueOf(i)).putOpt("info", jSONArray);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static class eli {
        private JSONObject CMM;
        int DbA;
        private int Dfc;
        private float FC;
        private float MGA;
        private int[] NU;
        float Os;
        private String QX;
        private int Xb;
        private int[] aAs;
        private long aGH;
        private int aqO;
        private JSONObject bf;
        private SparseArray<Os.eli> dV;
        private int[] du;
        float eli;
        private float kb;
        private int nGm;
        private int[] nlS;
        private int nn;
        private long ui;
        private float wC;

        public eli eli(int i) {
            this.Xb = i;
            return this;
        }

        public eli eli(JSONObject jSONObject) {
            this.bf = jSONObject;
            return this;
        }

        public eli DbA(JSONObject jSONObject) {
            this.CMM = jSONObject;
            return this;
        }

        public eli DbA(int i) {
            this.nGm = i;
            return this;
        }

        public eli eli(SparseArray<Os.eli> sparseArray) {
            this.dV = sparseArray;
            return this;
        }

        public eli eli(float f) {
            this.eli = f;
            return this;
        }

        public eli Os(int i) {
            this.DbA = i;
            return this;
        }

        public eli DbA(float f) {
            this.Os = f;
            return this;
        }

        public eli eli(long j) {
            this.aGH = j;
            return this;
        }

        public eli DbA(long j) {
            this.ui = j;
            return this;
        }

        public eli Os(float f) {
            this.MGA = f;
            return this;
        }

        public eli aGH(float f) {
            this.kb = f;
            return this;
        }

        public eli ui(float f) {
            this.wC = f;
            return this;
        }

        public eli MGA(float f) {
            this.FC = f;
            return this;
        }

        public eli eli(int[] iArr) {
            this.aAs = iArr;
            return this;
        }

        public eli DbA(int[] iArr) {
            this.du = iArr;
            return this;
        }

        public eli Os(int[] iArr) {
            this.nlS = iArr;
            return this;
        }

        public eli aGH(int[] iArr) {
            this.NU = iArr;
            return this;
        }

        public eli aGH(int i) {
            this.nn = i;
            return this;
        }

        public eli ui(int i) {
            this.Dfc = i;
            return this;
        }

        public eli MGA(int i) {
            this.aqO = i;
            return this;
        }

        public eli eli(String str) {
            this.QX = str;
            return this;
        }

        public nlS eli() {
            return new nlS(this);
        }
    }
}

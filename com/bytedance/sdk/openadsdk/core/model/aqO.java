package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aqO implements com.bytedance.sdk.component.adexpress.Os {
    public final float DbA;
    public final boolean Dfc;
    public final int FC;
    public final long MGA;
    public JSONObject NU;
    public final float Os;
    public int QX;
    public final int aAs;
    public final float aGH;
    public int aqO;
    public JSONObject dV;
    public final String du;
    public final float eli;
    public final int kb;
    public boolean nGm;
    public int nlS;
    public SparseArray<Os.eli> nn;
    public final long ui;
    public final int wC;

    private aqO(eli eliVar) {
        this.nGm = false;
        this.eli = eliVar.kb;
        this.DbA = eliVar.MGA;
        this.Os = eliVar.ui;
        this.aGH = eliVar.aGH;
        this.ui = eliVar.Os;
        this.MGA = eliVar.DbA;
        this.kb = eliVar.wC;
        this.wC = eliVar.FC;
        this.FC = eliVar.aAs;
        this.aAs = eliVar.du;
        this.du = eliVar.NU;
        this.nn = eliVar.eli;
        this.Dfc = eliVar.QX;
        this.nlS = eliVar.nn;
        this.NU = eliVar.Dfc;
        this.aqO = eliVar.aqO;
        this.dV = eliVar.dV;
        this.nGm = eliVar.nGm;
        this.QX = eliVar.nlS;
    }

    public static class eli {
        private long DbA;
        private JSONObject Dfc;
        private int FC;
        private float MGA;
        private String NU;
        private long Os;
        private boolean QX;
        private int aAs;
        private float aGH;
        private int aqO;
        private JSONObject dV;
        private int du;
        private float kb;
        private int nlS;
        private int nn;
        private float ui;
        private int wC;
        private boolean nGm = false;
        protected SparseArray<Os.eli> eli = new SparseArray<>();

        public eli eli(int i) {
            this.aqO = i;
            return this;
        }

        public eli DbA(int i) {
            this.nn = i;
            return this;
        }

        public eli eli(JSONObject jSONObject) {
            this.Dfc = jSONObject;
            return this;
        }

        public eli eli(boolean z) {
            this.QX = z;
            return this;
        }

        public eli Os(int i) {
            this.nlS = i;
            return this;
        }

        public eli eli(long j) {
            this.DbA = j;
            return this;
        }

        public eli DbA(long j) {
            this.Os = j;
            return this;
        }

        public eli eli(float f) {
            this.aGH = f;
            return this;
        }

        public eli DbA(float f) {
            this.ui = f;
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

        public eli aGH(int i) {
            this.wC = i;
            return this;
        }

        public eli ui(int i) {
            this.FC = i;
            return this;
        }

        public eli MGA(int i) {
            this.aAs = i;
            return this;
        }

        public eli kb(int i) {
            this.du = i;
            return this;
        }

        public eli eli(String str) {
            this.NU = str;
            return this;
        }

        public eli eli(SparseArray<Os.eli> sparseArray) {
            this.eli = sparseArray;
            return this;
        }

        public eli DbA(JSONObject jSONObject) {
            this.dV = jSONObject;
            return this;
        }

        public eli DbA(boolean z) {
            this.nGm = z;
            return this;
        }

        public aqO eli() {
            return new aqO(this);
        }
    }
}

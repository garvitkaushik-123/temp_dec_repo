package com.bytedance.sdk.component.adexpress.DbA;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU {
    private int CMM;
    private final String Cp;
    private ui DbA;
    private int Dfc;
    private boolean FC;
    private boolean GB;
    private JSONObject KM;
    private String MGA;
    private String NU;
    private String Os;
    private int QX;
    private JSONObject Ue;
    private JSONObject VM;
    private double Vy;
    private int Xb;
    private int aAs;
    private FC aGH;
    private boolean aqO;
    private int bf;
    private final String cyF;
    private String dV;
    private long du;
    private JSONObject eli;
    private String ev;
    private int gG;
    private String kb;
    private int nGm;
    private int nlS;
    private Map<String, String> nn;
    private final boolean nro;
    private String oWW;
    private int qj;
    private int ui;
    private boolean ujq;
    private String wC;

    public NU(eli eliVar) {
        this.eli = eliVar.eli;
        this.DbA = eliVar.DbA;
        this.Os = eliVar.Os;
        this.aGH = eliVar.aGH;
        this.ui = eliVar.ui;
        this.MGA = eliVar.MGA;
        this.kb = eliVar.kb;
        this.wC = eliVar.wC;
        this.FC = eliVar.FC;
        this.aAs = eliVar.aAs;
        this.du = eliVar.du;
        this.nlS = eliVar.nlS;
        this.NU = eliVar.NU;
        this.nn = eliVar.nn;
        this.Dfc = eliVar.Dfc;
        this.aqO = eliVar.aqO;
        this.dV = eliVar.dV;
        this.nGm = eliVar.nGm;
        this.QX = eliVar.QX;
        this.Xb = eliVar.Xb;
        this.bf = eliVar.bf;
        this.CMM = eliVar.CMM;
        this.ev = eliVar.ev;
        this.Vy = eliVar.Vy;
        this.gG = eliVar.gG;
        this.ujq = eliVar.ujq;
        this.Ue = eliVar.Ue;
        this.KM = eliVar.KM;
        this.VM = eliVar.VM;
        this.GB = eliVar.GB;
        this.oWW = eliVar.oWW;
        this.qj = eliVar.cyF;
        this.nro = eliVar.qj;
        this.Cp = eliVar.nro;
        this.cyF = eliVar.Cp;
    }

    public boolean eli() {
        return this.ujq;
    }

    public double DbA() {
        return this.Vy;
    }

    public JSONObject Os() {
        ui uiVar;
        if (this.eli == null && (uiVar = this.DbA) != null) {
            this.eli = uiVar.eli();
        }
        return this.eli;
    }

    public String aGH() {
        return this.Os;
    }

    public FC ui() {
        return this.aGH;
    }

    public int MGA() {
        return this.ui;
    }

    public int kb() {
        return this.gG;
    }

    public boolean wC() {
        return this.FC;
    }

    public long FC() {
        return this.du;
    }

    public int aAs() {
        return this.nlS;
    }

    public Map<String, String> du() {
        return this.nn;
    }

    public int nlS() {
        return this.Dfc;
    }

    public boolean NU() {
        return this.aqO;
    }

    public String nn() {
        return this.dV;
    }

    public int Dfc() {
        return this.nGm;
    }

    public int aqO() {
        return this.QX;
    }

    public int dV() {
        return this.Xb;
    }

    public JSONObject nGm() {
        return this.Ue;
    }

    public JSONObject QX() {
        return this.KM;
    }

    public JSONObject Xb() {
        return this.VM;
    }

    public int bf() {
        return this.bf;
    }

    public int CMM() {
        return this.CMM;
    }

    public boolean ev() {
        return this.GB;
    }

    public String Vy() {
        return this.oWW;
    }

    public int gG() {
        return this.qj;
    }

    public boolean ujq() {
        return this.nro;
    }

    public String Ue() {
        return this.Cp;
    }

    public String KM() {
        return this.cyF;
    }

    public static class eli {
        private int CMM;
        private String Cp;
        private ui DbA;
        private int Dfc;
        private boolean FC;
        private boolean GB;
        private JSONObject KM;
        private String MGA;
        private String NU;
        private String Os;
        private int QX;
        private JSONObject Ue;
        private JSONObject VM;
        private double Vy;
        private int Xb;
        private int aAs;
        private FC aGH;
        private boolean aqO;
        private int bf;
        private int cyF;
        private String dV;
        private long du;
        private JSONObject eli;
        private String ev;
        private int gG;
        private String kb;
        private int nGm;
        private int nlS;
        private Map<String, String> nn;
        private String nro;
        private String oWW;
        private int ui;
        private String wC;
        private boolean ujq = true;
        private boolean qj = true;

        public eli eli(ui uiVar) {
            this.DbA = uiVar;
            return this;
        }

        public eli eli(boolean z) {
            this.ujq = z;
            return this;
        }

        public eli eli(String str) {
            this.Os = str;
            return this;
        }

        public eli eli(FC fc) {
            this.aGH = fc;
            return this;
        }

        public eli eli(int i) {
            this.ui = i;
            return this;
        }

        public eli DbA(String str) {
            this.MGA = str;
            return this;
        }

        public eli Os(String str) {
            this.kb = str;
            return this;
        }

        public eli aGH(String str) {
            this.wC = str;
            return this;
        }

        public eli DbA(boolean z) {
            this.FC = z;
            return this;
        }

        public eli Os(boolean z) {
            this.qj = z;
            return this;
        }

        public eli DbA(int i) {
            this.aAs = i;
            return this;
        }

        public eli eli(long j) {
            this.du = j;
            return this;
        }

        public eli Os(int i) {
            this.nlS = i;
            return this;
        }

        public eli eli(Map<String, String> map) {
            this.nn = map;
            return this;
        }

        public eli aGH(int i) {
            this.Dfc = i;
            return this;
        }

        public eli aGH(boolean z) {
            this.aqO = z;
            return this;
        }

        public eli ui(String str) {
            this.dV = str;
            return this;
        }

        public eli ui(int i) {
            this.gG = i;
            return this;
        }

        public eli ui(boolean z) {
            this.GB = z;
            return this;
        }

        public eli MGA(String str) {
            this.oWW = str;
            return this;
        }

        public eli MGA(int i) {
            this.cyF = i;
            return this;
        }

        public NU eli() {
            return new NU(this);
        }

        public eli eli(double d) {
            this.Vy = d;
            return this;
        }

        public eli kb(String str) {
            this.nro = str;
            return this;
        }

        public eli wC(String str) {
            this.Cp = str;
            return this;
        }
    }
}

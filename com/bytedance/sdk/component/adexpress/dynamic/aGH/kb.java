package com.bytedance.sdk.component.adexpress.dynamic.aGH;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.adexpress.dynamic.ui.du;
import com.ironsource.C3040d4;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb {
    public String DbA;
    private String MGA;
    public JSONObject Os;
    private MGA aGH;
    public int eli;
    private ui ui;

    public kb(ui uiVar) {
        this.ui = uiVar;
        this.eli = uiVar.eli();
        this.DbA = uiVar.Os();
        this.Os = uiVar.ui().DE();
        this.MGA = uiVar.aGH();
        if (com.bytedance.sdk.component.adexpress.aGH.Os() == 1) {
            this.aGH = uiVar.kb();
        } else {
            this.aGH = uiVar.ui();
        }
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            this.aGH = uiVar.ui();
        }
    }

    public int eli() {
        return (int) this.aGH.nn();
    }

    public int DbA() {
        return (int) this.aGH.dV();
    }

    public int Os() {
        return (int) this.aGH.Dfc();
    }

    public int aGH() {
        return (int) this.aGH.aqO();
    }

    public float ui() {
        return this.aGH.nGm();
    }

    public String MGA() {
        if (this.eli == 0) {
            if (!TextUtils.isEmpty(this.DbA)) {
                return this.DbA;
            }
            return this.Os.optString(com.bytedance.sdk.component.adexpress.aGH.kb.Os(com.bytedance.sdk.component.adexpress.aGH.eli()));
        }
        return "";
    }

    public int kb() {
        return eli(this.aGH.CMM());
    }

    public int wC() {
        String bf = this.aGH.bf();
        if ("left".equals(bf)) {
            return 17;
        }
        if ("center".equals(bf)) {
            return 4;
        }
        return "right".equals(bf) ? 3 : 2;
    }

    public int FC() {
        int wC = wC();
        if (wC == 4) {
            return 17;
        }
        return wC == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String aAs() {
        int i = this.eli;
        if (i == 2 || i == 13) {
            return this.DbA;
        }
        return "";
    }

    public String du() {
        if (this.eli == 1) {
            return this.DbA;
        }
        return "";
    }

    public String nlS() {
        return this.MGA;
    }

    public double NU() {
        if (this.eli == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.aGH.DbA() ? (int) r0 : Double.parseDouble(this.DbA);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double nn() {
        return this.aGH.QX();
    }

    public float Dfc() {
        return this.aGH.du();
    }

    public int aqO() {
        return eli(this.aGH.ujq());
    }

    public float dV() {
        return this.aGH.nlS();
    }

    public int nGm() {
        return this.aGH.yw();
    }

    public int QX() {
        return this.aGH.QMZ();
    }

    public boolean Xb() {
        return this.aGH.CH();
    }

    public String bf() {
        return this.aGH.Vy();
    }

    public void eli(float f) {
        this.aGH.eli(f);
    }

    public boolean CMM() {
        return this.aGH.jh();
    }

    public int ev() {
        return this.aGH.Za();
    }

    public String Vy() {
        return this.aGH.dZ();
    }

    public String gG() {
        return this.aGH.ZLD();
    }

    public long ujq() {
        return this.aGH.ID();
    }

    public int Ue() {
        String dZ = this.aGH.dZ();
        if ("skip-with-time-skip-btn".equals(this.ui.DbA()) || "skip".equals(this.ui.DbA()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.ui.DbA())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.ui.DbA()) && !"skip-with-time".equals(this.ui.DbA())) {
            if (this.eli == 10 && TextUtils.equals(this.aGH.SSo(), "click")) {
                return 5;
            }
            if (Gjg() && XU()) {
                return 0;
            }
            if (Gjg()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.ui.DbA())) {
                return 3;
            }
            if (!TextUtils.isEmpty(dZ) && !dZ.equals("none")) {
                if (dZ.equals("video") || (this.ui.eli() == 7 && TextUtils.equals(dZ, Constants.NORMAL))) {
                    return (com.bytedance.sdk.component.adexpress.aGH.DbA() && this.ui.ui() != null && this.ui.ui().Ib()) ? 11 : 4;
                }
                if (dZ.equals(Constants.NORMAL)) {
                    return 1;
                }
                return (dZ.equals("creative") || "slide".equals(this.aGH.SSo())) ? 2 : 0;
            }
        }
        return 0;
    }

    private boolean Gjg() {
        return (com.bytedance.sdk.component.adexpress.aGH.DbA() && (this.ui.DbA().contains("logo-union") || this.ui.DbA().contains("logounion") || this.ui.DbA().contains("logoad"))) || "logo-union".equals(this.ui.DbA()) || "logounion".equals(this.ui.DbA()) || "logoad".equals(this.ui.DbA());
    }

    public int KM() {
        return eli(this.aGH.ev());
    }

    public double VM() {
        return this.aGH.wC();
    }

    public int GB() {
        return this.aGH.Os();
    }

    public int oWW() {
        return this.aGH.DbA();
    }

    public int qj() {
        return this.aGH.ui();
    }

    public int nro() {
        return this.aGH.aGH();
    }

    public int Cp() {
        return this.aGH.FC();
    }

    public String cyF() {
        return this.aGH.aAs();
    }

    public String eU() {
        return this.aGH.SSo();
    }

    private boolean XU() {
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.DbA) && this.DbA.contains("adx:")) || du.DbA();
    }

    public static int eli(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals(C3040d4.h.T)) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (split.length == 4) {
                    return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return -16777216;
    }

    public static float[] DbA(String str) {
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (split != null && split.length == 4) {
            return new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])};
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public boolean eli(int i) {
        ui uiVar = this.ui;
        if (uiVar == null) {
            return false;
        }
        if (i == 1) {
            this.aGH = uiVar.kb();
        } else {
            this.aGH = uiVar.ui();
        }
        return this.aGH != null;
    }

    public boolean dZ() {
        return this.aGH.rH();
    }

    public int SSo() {
        return this.aGH.PfW();
    }

    public int Uv() {
        return this.aGH.eEH();
    }

    public String FS() {
        return this.aGH.eU();
    }

    public boolean jh() {
        return this.aGH.RY();
    }

    public int Za() {
        return this.aGH.kb();
    }

    public int ikX() {
        return this.aGH.Tju();
    }

    public int tGZ() {
        return this.aGH.XlF();
    }

    public int WfR() {
        return this.aGH.qWy();
    }

    public int ow() {
        return this.aGH.gAc();
    }

    public boolean TfR() {
        return this.aGH.vb();
    }

    public String QI() {
        return this.aGH.VM();
    }

    public String mm() {
        return this.aGH.hg();
    }

    public String oc() {
        return this.aGH.SjY();
    }

    public boolean rQ() {
        return this.aGH.NU();
    }

    public boolean Yw() {
        return this.aGH.oWW();
    }

    public String qyC() {
        return this.aGH.GB();
    }

    public int BH() {
        return this.aGH.qj();
    }

    public int BDs() {
        return this.aGH.nro();
    }

    public double tLO() {
        return this.aGH.Cp();
    }

    public double gHb() {
        return this.aGH.cyF();
    }

    public int Mc() {
        return this.aGH.Bnk();
    }

    public String DE() {
        return this.aGH.an();
    }

    public String GMY() {
        return this.aGH.iuv();
    }

    public boolean rH() {
        return this.aGH.HN();
    }

    public int eEH() {
        return this.aGH.ND();
    }

    public int PfW() {
        return this.aGH.XxP();
    }

    public int Ca() {
        return this.aGH.Hm();
    }

    public boolean yKf() {
        return this.aGH.vb();
    }

    public String rn() {
        return this.aGH.gG();
    }
}

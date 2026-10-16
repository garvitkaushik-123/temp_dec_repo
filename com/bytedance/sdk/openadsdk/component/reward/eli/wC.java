package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.webkit.DownloadListener;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC {
    public static int DbA = 1;
    public static int Os = 2;
    public static int eli;
    private FC MGA;
    private final boolean aGH;
    private aAs ui;

    public wC(eli eliVar, ev evVar) {
        boolean CQP = evVar.CQP();
        this.aGH = CQP;
        if (CQP) {
            this.ui = KM.MGA(evVar) ? new kb(eliVar) : new aAs(eliVar);
        } else {
            this.MGA = new FC(eliVar);
        }
    }

    public boolean eli() {
        FC fc = this.MGA;
        return fc != null && fc.dV();
    }

    public void eli(int i) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(i);
        }
    }

    public float DbA() {
        if (this.MGA != null) {
            return r0.aAs();
        }
        return 0.0f;
    }

    public boolean Os() {
        FC fc = this.MGA;
        if (fc != null) {
            return fc.aqO();
        }
        return true;
    }

    public void eli(boolean z) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.DbA(z);
        }
    }

    public com.bytedance.sdk.openadsdk.Xb.wC aGH() {
        FC fc = this.MGA;
        if (fc != null) {
            return fc.nGm();
        }
        return null;
    }

    public void ui() {
        FC fc = this.MGA;
        if (fc != null) {
            fc.MGA();
        }
    }

    public void MGA() {
        FC fc = this.MGA;
        if (fc != null) {
            fc.kb();
        }
    }

    public boolean kb() {
        FC fc = this.MGA;
        if (fc != null) {
            return fc.Dfc();
        }
        return false;
    }

    public int DbA(int i) {
        FC fc = this.MGA;
        if (fc != null) {
            return fc.Os(i);
        }
        return 0;
    }

    public void wC() {
        FC fc = this.MGA;
        if (fc != null) {
            fc.DbA();
        }
    }

    public void eli(JSONObject jSONObject) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(jSONObject);
        }
    }

    public void DbA(boolean z) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.MGA(z);
        }
    }

    public void eli(int i, ev evVar, boolean z) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(i, evVar, z);
        }
    }

    public long FC() {
        if (this.MGA != null) {
            return r0.FC();
        }
        return 0L;
    }

    public void aAs() {
        FC fc = this.MGA;
        if (fc != null) {
            fc.ui();
        }
    }

    public void Os(int i) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.DbA(i);
        }
    }

    public void eli(DownloadListener downloadListener) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(downloadListener);
        }
    }

    public void Os(boolean z) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(z);
        }
    }

    public com.bytedance.sdk.openadsdk.nlS.ui du() {
        FC fc = this.MGA;
        if (fc != null) {
            return fc.nn();
        }
        return null;
    }

    public void eli(String str) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.Os(str);
        }
    }

    public void eli(int i, String str, String str2) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(i, str, str2);
        }
    }

    public void eli(boolean z, String str, int i) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(z, str, i);
        }
    }

    public void aGH(boolean z) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.aGH(z);
        }
    }

    public void ui(boolean z) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.ui(z);
        }
    }

    public void DbA(String str) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.DbA(str);
        }
    }

    public void nlS() {
        FC fc = this.MGA;
        if (fc != null) {
            fc.aGH();
        }
    }

    public void Os(String str) {
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(str);
        }
    }

    public boolean aGH(int i) {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                return aas.FC();
            }
        } else {
            FC fc = this.MGA;
            if (fc != null && fc.FC() - this.MGA.aAs() >= i) {
                return true;
            }
        }
        return false;
    }

    public void NU() {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.aGH();
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.du();
        }
    }

    public void nn() {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.wC();
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.NU();
        }
    }

    public void ui(int i) {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.eli(i);
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(i);
        }
    }

    public void MGA(int i) {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.eli(i);
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.ui(i);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.ui uiVar) {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.eli(uiVar);
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(uiVar);
        }
    }

    public void Dfc() {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.eli();
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli();
        }
    }

    public void aqO() {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.ui();
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.nlS();
        }
    }

    public void kb(int i) {
        aAs aas;
        if (this.aGH && i != Os && (aas = this.ui) != null) {
            aas.MGA();
            return;
        }
        FC fc = this.MGA;
        if (fc == null || i == DbA) {
            return;
        }
        fc.Os();
    }

    public void eli(com.bytedance.sdk.openadsdk.nlS.MGA mga, boolean z) {
        if (this.aGH) {
            aAs aas = this.ui;
            if (aas != null) {
                aas.DbA(z);
                return;
            }
            return;
        }
        FC fc = this.MGA;
        if (fc != null) {
            fc.eli(mga, z);
        }
    }

    public boolean wC(int i) {
        if (this.aGH && i == DbA) {
            aAs aas = this.ui;
            if (aas != null) {
                return aas.aAs();
            }
            return false;
        }
        FC fc = this.MGA;
        if (fc != null) {
            return fc.wC();
        }
        return false;
    }

    public void dV() {
        aAs aas = this.ui;
        if (aas != null) {
            aas.du();
        }
    }

    public void MGA(boolean z) {
        aAs aas = this.ui;
        if (aas != null) {
            aas.Os(z);
        }
    }

    public void nGm() {
        aAs aas = this.ui;
        if (aas != null) {
            aas.Os();
        }
    }
}

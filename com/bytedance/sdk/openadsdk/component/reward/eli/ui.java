package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.utils.CMM;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui {
    private final com.bytedance.sdk.openadsdk.component.reward.view.wC DbA;
    private eli Os;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli eli;

    public interface eli {
        void eli(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA, int i);
    }

    public ui(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.eli = eliVar;
        this.DbA = new com.bytedance.sdk.openadsdk.component.reward.view.wC(eliVar);
    }

    public void eli() {
        this.DbA.eli();
    }

    public void DbA() {
        this.DbA.Os();
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.ui uiVar) {
        this.DbA.eli(uiVar);
    }

    public void eli(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA, int i) {
        int i2;
        if (this.eli != null) {
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("videoForceBreak", this.eli.DbA);
            com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA(this.eli.DbA);
        }
        new StringBuilder("showEndCard() called with: isSkip = [").append(z).append("], force = [").append(z2).append("], isFromLandingPage = [").append(z3).append("], mAdType = [").append(dbA);
        if (this.eli.SSo.isFinishing() || dbA == null) {
            return;
        }
        this.eli.eU.nlS();
        if (z2) {
            this.eli.Dfc.set(true);
        }
        boolean z4 = false;
        if (this.eli.DE && !this.eli.aqO.get() && !Xb.FC(this.eli.DbA) && (!Xb.DbA(this.eli.DbA) || !this.eli.Dfc.get() || !this.eli.dV.get())) {
            if ((Xb.DbA(this.eli.DbA) && z3) || !DbA(z2)) {
                return;
            }
            if (Xb.DbA(this.eli.DbA) || Xb.aGH(this.eli.DbA) || Xb.ui(this.eli.DbA)) {
                this.eli.Cp.Os(false);
                dbA.Dfc();
                return;
            }
        }
        if (this.eli.SSo.isDestroyed() || this.eli.SSo.isFinishing()) {
            return;
        }
        if (this.eli.DbA.nie()) {
            com.bytedance.sdk.openadsdk.component.reward.view.aAs aas = this.eli.ujq;
            com.bytedance.sdk.openadsdk.core.wC.Os brandBannerController = (aas == null || aas.eli() == null) ? null : aas.eli().getBrandBannerController();
            if (brandBannerController != null) {
                brandBannerController.DbA();
            }
            this.eli.SSo.finish();
            return;
        }
        eli eliVar = this.Os;
        if (eliVar != null) {
            eliVar.eli(z, z2, z3, dbA, i);
            return;
        }
        this.eli.ev.QX();
        this.eli.qj.KM();
        this.eli.du.set(false);
        if (!this.eli.eEH || !(this.eli.yKf instanceof com.bytedance.sdk.openadsdk.activity.ui) || this.eli.yKf.eU()) {
            this.eli.nlS.set(false);
        }
        this.eli.GB.eli();
        NU nu = this.eli.Cp;
        if (!this.eli.kb && this.eli.DbA.iiz()) {
            z4 = true;
        }
        nu.eli(z4);
        if (this.eli.aAs.getAndSet(true)) {
            return;
        }
        if (KM.DbA(this.eli.DbA)) {
            HashMap hashMap = new HashMap();
            if (this.eli.qj.eU()) {
                i2 = 1;
            } else {
                i2 = !this.eli.qj.QX() ? -1 : 2;
            }
            hashMap.put("webview_state", Integer.valueOf(i2));
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.eli.DbA, this.eli.ui, z, z2, z3, this.eli.SSo.isFinishing(), i, hashMap);
        }
        if (this.eli.DbA.ui() && KM.kb(this.eli.DbA) && z) {
            this.eli.Cp.aGH(true);
        }
        if (KM.kb(this.eli.DbA)) {
            this.eli.Cp.Os(true);
        }
        kb();
        if (KM.ui(this.eli.DbA) && this.eli.Gjg) {
            this.eli.eU.aGH(8);
            this.eli.Cp.Os(true);
            this.eli.eU.Os();
            if (this.eli.ujq != null) {
                this.eli.ujq.MGA();
            }
            this.eli.gG.nGm();
            return;
        }
        eli(z, dbA);
    }

    public void eli(boolean z, com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        if (KM.dV(this.eli.DbA)) {
            return;
        }
        this.eli.nGm.set(z);
        dbA.nn();
        if (this.eli.DbA.Kv()) {
            this.eli.Cp.aGH(false);
        } else {
            this.eli.Cp.aGH(KM.dV(this.eli.DbA));
        }
        this.eli.Cp.Os(KM.kb(this.eli.DbA));
        if (this.eli.DbA.ui() && KM.kb(this.eli.DbA) && z) {
            this.eli.Cp.aGH(true);
        }
        this.eli.qj.VM();
        if (this.eli.eU.Dfc != null) {
            this.eli.eU.Dfc.ui();
        }
        this.eli.eU.Os();
        if (this.eli.ujq != null) {
            this.eli.ujq.MGA();
        }
        if (this.eli.gG != null) {
            this.eli.gG.kb(wC.DbA);
        }
        if (!TextUtils.isEmpty(ev.eli(this.eli.FS, this.eli.DbA))) {
            CMM.eli(this.eli.SSo, KM.NU(this.eli.DbA), this.eli.DbA, DbA.eli.Os);
            return;
        }
        if (ev.Os(this.eli.DbA) && this.eli.nro != null) {
            this.eli.nro.MGA();
        }
        if (ev.eli(this.eli.DbA) || ((!ev.Os(this.eli.DbA) && this.eli.qj.SSo()) || (!ev.eli(this.eli.DbA, this.eli.qj.nGm(), this.eli.qj.jh(), this.eli.nro.nlS(), this.eli.qj.GB()) && !KM.kb(this.eli.DbA)))) {
            aGH();
            return;
        }
        if (!ev.aGH(this.eli.DbA) && !KM.kb(this.eli.DbA) && !ev.Os(this.eli.DbA)) {
            this.eli.qj.eli(true, 0, (String) null);
        }
        if (KM.kb(this.eli.DbA)) {
            if (KM.CMM(this.eli.DbA) && !this.eli.qj.eU()) {
                if (!this.eli.qj.nGm()) {
                    if (this.eli.gG.aGH() != null) {
                        this.eli.gG.aGH().eli(2);
                    }
                    this.eli.gG.ui();
                    return;
                } else {
                    if (this.eli.gG.aGH() != null) {
                        this.eli.gG.aGH().eli(-1);
                    }
                    this.eli.gG.MGA();
                    this.eli.Cp.aGH(false);
                    this.eli.gG.eli(this.eli.KM.ui());
                    return;
                }
            }
            if (this.eli.qj.eU() && this.eli.gG.aGH() != null) {
                this.eli.gG.aGH().eli(1);
            }
            DbA(dbA);
        } else {
            Os(dbA);
        }
        eli(dbA);
    }

    void eli(com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        this.eli.qj.eli(0.0f);
        this.eli.eU.eli(0.0f);
        if (!ev.Os(this.eli.DbA)) {
            this.eli.nro.eli(8);
            this.eli.qj.eli(0);
            this.eli.qj.Uv();
        } else {
            this.eli.qj.eli(8);
            this.eli.nro.eli(0);
            this.eli.nro.kb();
        }
        if (this.eli.kb) {
            SSo.eli((View) dbA.nn, 0);
            this.eli.eU.MGA(8);
        }
        this.eli.eU.aGH(8);
        this.eli.eU.kb();
        if (ev.Os(this.eli.DbA)) {
            this.eli.jh.sendEmptyMessageDelayed(800, 100L);
            return;
        }
        this.eli.jh.sendEmptyMessageDelayed(500, 100L);
        this.eli.qj.eli(this.eli.tGZ, true);
        this.eli.qj.Os(true);
        this.eli.qj.DbA(true);
        qj nlS = this.eli.qj.nlS();
        if (nlS != null) {
            nlS.eli("prerender_page_show", (JSONObject) null);
        }
    }

    public void DbA(com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        int KUA = this.eli.DbA.KUA();
        if (KM.dV(this.eli.DbA)) {
            KUA = (this.eli.DbA.oT() + 1) * 1000;
        }
        if (KUA == -1) {
            if (KM.wC(this.eli.DbA)) {
                if (KM.CMM(this.eli.DbA) && this.eli.gG.kb()) {
                    dbA.Dfc();
                    return;
                } else {
                    dbA.Vy();
                    return;
                }
            }
            dbA.Dfc();
        } else {
            if (KUA < 0) {
                return;
            }
            this.eli.Cp.aGH(false);
            if (KM.wC(this.eli.DbA)) {
                if (KM.CMM(this.eli.DbA) && this.eli.gG.kb()) {
                    this.eli.jh.sendEmptyMessageDelayed(600, KUA);
                } else {
                    this.eli.jh.sendEmptyMessageDelayed(1, KUA);
                    return;
                }
            } else {
                this.eli.jh.sendEmptyMessageDelayed(600, KUA);
            }
        }
        if (this.eli.GMY != null) {
            this.eli.GMY.eli(KUA);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.model.KM.FC(r4.eli.DbA) == false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Os(com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        boolean z;
        this.eli.wC = MGA();
        int i = this.eli.wC;
        if (this.eli.DbA.Dfc()) {
            return false;
        }
        if (this.eli.wC == -1) {
            if (this.eli.yKf == null && KM.wC(this.eli.DbA) && this.eli.qj.nGm()) {
                dbA.Vy();
            } else if (this.eli.yKf == null && KM.aAs(this.eli.DbA) && this.eli.qj.nGm()) {
                dbA.Vy();
            } else {
                dbA.Dfc();
                z = true;
            }
            z = false;
        } else {
            if (this.eli.wC >= 0) {
                this.eli.bf.set(false);
                Message obtain = Message.obtain();
                obtain.what = IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                obtain.arg1 = this.eli.wC;
                this.eli.jh.sendMessage(obtain);
            }
            z = false;
        }
        if (!(this.eli.qj.ujq() ? false : z) || this.eli.GMY == null || !this.eli.aGH()) {
            return true;
        }
        this.eli.GMY.eli(this.eli.wC);
        return true;
    }

    private int MGA() {
        int rfG = this.eli.DbA.rfG();
        if (rfG <= 5000 && rfG >= 0) {
            if (rfG < 1000) {
                rfG += 1000;
            }
            int eli2 = com.bytedance.sdk.openadsdk.core.dV.aGH().eli(this.eli.DbA.RTg());
            if (eli2 <= 5000 && eli2 >= 0) {
                if (eli2 < 1000) {
                    eli2 += 1000;
                }
                return Math.min(rfG, eli2);
            }
        }
        return -1;
    }

    private void kb() {
        if (KM.nGm(this.eli.DbA) && this.eli.tGZ) {
            this.eli.Cp.DbA(true);
            this.eli.gG.ui(true);
        }
    }

    public void Os() {
        this.DbA.aGH();
    }

    public void aGH() {
        eli(true);
    }

    public void eli(boolean z) {
        if (!ev.aGH(this.eli.DbA)) {
            this.eli.qj.eli(false, 408, "end_card_timeout");
        }
        this.eli.qj.oWW();
        this.eli.qj.eli(8);
        this.eli.nro.eli(8);
        if (this.eli.kb) {
            SSo.eli((View) this.eli.Mc.nn, 8);
            this.eli.eU.MGA(0);
        }
        this.eli.eU.aGH(8);
        if (this.eli.DbA.Kv()) {
            if (!this.DbA.eli(this.eli.ev)) {
                this.eli.SSo.finish();
            }
        } else {
            com.bytedance.sdk.openadsdk.activity.wC wCVar = this.eli.yKf;
            if (wCVar != null) {
                this.DbA.eli(wCVar.dZ().kb());
            }
            this.DbA.DbA();
        }
        this.eli.eU.kb();
        if (z) {
            Os(this.eli.Mc);
        }
        this.eli.Cp.Os(false);
        this.eli.KM.eli(this.eli.DbA.Txb());
    }

    public void eli(eli eliVar) {
        this.Os = eliVar;
    }

    public boolean ui() {
        return this.DbA.ui();
    }

    private boolean DbA(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.view.aGH eli2;
        if (!Xb.Os(this.eli.DbA) || (eli2 = this.eli.ujq.eli()) == null || eli2.aGH != 0 || z) {
            return true;
        }
        this.eli.Cp.Os(false);
        return false;
    }
}

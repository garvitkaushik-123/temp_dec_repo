package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.app.Activity;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class aAs {
    protected boolean Dfc;
    protected final ev FC;
    protected boolean NU;
    protected final String aAs;
    protected FrameLayout aqO;
    protected com.bytedance.sdk.openadsdk.Xb.eli.eli dV;
    protected final eli du;
    protected volatile boolean kb;
    protected AtomicBoolean nGm = new AtomicBoolean(false);
    protected boolean nlS;
    protected boolean nn;
    protected final Activity wC;

    public boolean FC() {
        return false;
    }

    public void eli(int i) {
    }

    public void eli(long j) {
    }

    public void wC() {
    }

    public aAs(eli eliVar) {
        this.du = eliVar;
        this.wC = eliVar.SSo;
        this.aAs = eliVar.ui;
        ev evVar = eliVar.DbA;
        this.FC = evVar;
        this.NU = KM.ui(evVar);
    }

    public void eli() {
        if (this.NU && !this.nlS) {
            this.nlS = true;
        }
    }

    public void DbA(boolean z) {
        if (this.NU && this.du.Za) {
            this.aqO = (FrameLayout) this.du.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.OPT);
            eli(z);
        }
    }

    protected void eli(boolean z) {
        if (this.aqO != null) {
            com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = new com.bytedance.sdk.openadsdk.Xb.eli.eli(this.du.FS, this.FC, this.du.QI, z, this.aqO);
            this.dV = eliVar;
            eliVar.eli(this.du.Uv);
            this.dV.eli(true, DbA());
        }
    }

    protected com.bytedance.sdk.openadsdk.nlS.MGA DbA() {
        return new com.bytedance.sdk.openadsdk.nlS.MGA() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.aAs.1
            @Override // com.bytedance.sdk.openadsdk.nlS.MGA
            public void eli() {
                aAs.this.du.Uv.DbA(false);
            }
        };
    }

    public void Os() {
        if (this.NU) {
            this.kb = true;
            Os(this.du.tGZ);
            this.dV.eli();
            kb();
            if (KM.aAs(this.FC)) {
                this.du.qj.MGA();
            }
        }
    }

    private void kb() {
        int KUA = this.FC.KUA();
        if (KUA == -1) {
            if (KM.FC(this.FC)) {
                com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.dV;
                if (eliVar != null && eliVar.ui()) {
                    this.du.QX.set(true);
                    this.du.Mc.Dfc();
                } else {
                    this.du.Mc.Vy();
                    return;
                }
            } else {
                this.du.QX.set(true);
                this.du.Mc.Dfc();
            }
        } else {
            if (KUA < 0) {
                return;
            }
            this.du.Cp.aGH(false);
            if (KM.FC(this.FC)) {
                com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar2 = this.dV;
                if (eliVar2 != null && eliVar2.ui()) {
                    this.du.jh.sendEmptyMessageDelayed(600, KUA);
                } else {
                    this.du.jh.sendEmptyMessageDelayed(1, KUA);
                    return;
                }
            } else {
                this.du.jh.sendEmptyMessageDelayed(600, KUA);
            }
        }
        if (this.du.GMY == null || !this.du.aGH()) {
            return;
        }
        this.du.GMY.eli(KUA);
    }

    public void aGH() {
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar;
        if (!this.NU || this.nGm.get() || (eliVar = this.dV) == null) {
            return;
        }
        eliVar.DbA();
    }

    public void ui() {
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar;
        if (!this.NU || this.nGm.get() || (eliVar = this.dV) == null) {
            return;
        }
        eliVar.Os();
    }

    public void MGA() {
        if (this.NU && !this.Dfc) {
            this.Dfc = true;
            com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.dV;
            if (eliVar != null) {
                eliVar.aGH();
            }
            FrameLayout frameLayout = this.aqO;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.ui uiVar) {
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar;
        if (this.NU && (eliVar = this.dV) != null) {
            eliVar.eli(uiVar);
        }
    }

    public void Os(boolean z) {
        if (this.NU && this.dV != null && this.kb) {
            this.dV.eli(z);
        }
    }

    public boolean aAs() {
        return this.kb;
    }

    public void du() {
        if (this.nGm.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.dV;
            if (eliVar != null) {
                eliVar.eli(true);
            }
            this.du.qj.kb(true);
            this.du.cyF.eli(true, this.du.Mc);
            if (this.du.cyF.ui()) {
                this.du.GMY.eli(this.du.wC);
                return;
            }
            this.du.qj.eli(this.du.tGZ, true);
            this.du.qj.Os(true);
            this.du.qj.DbA(true);
            this.du.jh.removeMessages(600);
            return;
        }
        this.du.qj.FC();
    }
}

package com.bytedance.sdk.openadsdk.component.reward.DbA;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.component.reward.eli.NU;
import com.bytedance.sdk.openadsdk.component.reward.eli.aqO;
import com.bytedance.sdk.openadsdk.component.reward.eli.dV;
import com.bytedance.sdk.openadsdk.component.reward.view.nlS;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* loaded from: classes3.dex */
public class eli {
    protected ev DbA;
    protected com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA FC;
    protected final nlS MGA;
    protected int Os;
    protected Ue aAs;
    protected int aGH;
    protected com.bytedance.sdk.openadsdk.component.reward.eli.eli eli;
    protected final dV kb;
    protected final aqO ui;
    protected final NU wC;

    public eli(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.eli = eliVar;
        this.DbA = eliVar.DbA;
        this.Os = eliVar.oc;
        this.aGH = eliVar.rQ;
        this.ui = eliVar.ev;
        this.MGA = eliVar.eU;
        this.kb = eliVar.qj;
        this.wC = eliVar.Cp;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA, Ue ue) {
        this.FC = dbA;
        this.aAs = ue;
    }

    public boolean eli() {
        return this.eli.DbA.Kv() || this.eli.DbA.GR() == 15 || this.eli.DbA.GR() == 5 || this.eli.DbA.GR() == 50;
    }

    public void eli(boolean z) {
        if (this.eli.aAs.get()) {
            return;
        }
        ev evVar = this.DbA;
        if (evVar != null && evVar.nie()) {
            this.wC.Os(false);
            this.wC.eli(true);
            this.eli.eU.DbA(8);
            this.eli.eU.aGH(8);
            return;
        }
        if (!z) {
            this.wC.Os(false);
            this.wC.eli(false);
            this.wC.aGH(false);
            this.eli.eU.MGA(8);
        } else {
            this.wC.eli(this.eli.DbA.iiz());
            if (KM.dV(this.eli.DbA) || eli()) {
                this.wC.Os(true);
            }
            if (eli() || ((this instanceof kb) && this.eli.DbA.ui())) {
                this.wC.aGH(true);
            } else {
                this.wC.ui();
                this.eli.eU.MGA(0);
            }
        }
        if (!z) {
            this.eli.eU.DbA(4);
            this.eli.eU.Os(8);
            this.eli.eU.aGH(8);
        } else if (this.eli.mm != com.bytedance.sdk.openadsdk.component.reward.view.aGH.eli) {
            this.eli.eU.DbA(8);
            this.eli.eU.aGH(8);
        } else {
            this.eli.eU.DbA(0);
            this.eli.eU.Os(0);
            this.eli.eU.aGH(0);
        }
    }

    public boolean DbA() {
        if (this.eli.yKf == null && this.eli.ev.kb() && (Xb.Os(this.eli.DbA) || !ev.ui(this.eli.DbA))) {
            return false;
        }
        if (!Xb.DbA(this.eli.DbA) || !this.eli.QX.get()) {
            return (this.eli.aAs.get() || this.eli.du.get() || KM.dV(this.eli.DbA)) ? false : true;
        }
        FrameLayout MGA = this.eli.eU.MGA();
        MGA.setVisibility(4);
        MGA.setVisibility(0);
        return false;
    }

    protected void Os() {
        if (KM.DbA(this.eli.DbA) && DeviceUtils.kb() == 0) {
            this.eli.tGZ = true;
        }
        this.eli.Cp.DbA(this.eli.tGZ);
    }
}

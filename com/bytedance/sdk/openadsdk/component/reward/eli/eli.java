package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.FC;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class eli {
    public boolean BH;
    public com.bytedance.sdk.openadsdk.component.reward.top.Os Ca;
    public final NU Cp;
    public boolean DE;
    public ev DbA;
    public final Context FS;
    public final Os GB;
    public com.bytedance.sdk.openadsdk.utils.nn GMY;
    public final du KM;
    private long Kp;
    public final int MGA;
    public com.bytedance.sdk.openadsdk.component.reward.DbA.DbA Mc;
    public final boolean Os;
    public boolean PfW;
    public final Activity SSo;
    public boolean TfR;
    public final nlS Ue;
    public final com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA Uv;
    public final MGA VM;
    public final aGH Vy;
    private long XU;
    public boolean Yw;
    public final boolean Za;
    public final boolean aGH;
    public final ui cyF;
    public final com.bytedance.sdk.openadsdk.component.reward.view.FC dZ;
    public boolean eEH;
    public final com.bytedance.sdk.openadsdk.component.reward.view.nlS eU;
    public final int eli;
    public final aqO ev;
    public final wC gG;
    public boolean gHb;
    public String ikX;
    public final Ue jh;
    public final boolean kb;
    public float mm;
    public final nn nro;
    public com.bytedance.sdk.openadsdk.nlS.FC oWW;
    public int oc;
    public int ow;
    public final dV qj;
    public boolean qyC;
    public boolean rH;
    public int rQ;
    public com.bytedance.sdk.openadsdk.component.reward.du rn;
    public boolean tGZ;
    public com.bytedance.sdk.openadsdk.common.NU tLO;
    public final String ui;
    public final com.bytedance.sdk.openadsdk.component.reward.view.aAs ujq;
    public int wC = 0;
    public int FC = 0;
    public final AtomicBoolean aAs = new AtomicBoolean(false);
    public final AtomicBoolean du = new AtomicBoolean(false);
    public final AtomicBoolean nlS = new AtomicBoolean(false);
    public final AtomicBoolean NU = new AtomicBoolean(false);
    public final AtomicBoolean nn = new AtomicBoolean(false);
    public final AtomicBoolean Dfc = new AtomicBoolean(false);
    public final AtomicBoolean aqO = new AtomicBoolean(false);
    public final AtomicBoolean dV = new AtomicBoolean(false);
    public final AtomicBoolean nGm = new AtomicBoolean(false);
    public final AtomicBoolean QX = new AtomicBoolean(false);
    public final AtomicBoolean Xb = new AtomicBoolean(false);
    public final AtomicBoolean bf = new AtomicBoolean(false);
    public final AtomicBoolean CMM = new AtomicBoolean(false);
    public boolean WfR = false;
    public int QI = 1;
    public long BDs = 0;
    public com.bytedance.sdk.openadsdk.activity.wC yKf = null;
    public boolean Gjg = true;

    public eli(Activity activity, Ue ue, ev evVar, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA, int i) {
        com.bytedance.sdk.openadsdk.component.reward.view.nlS nls;
        this.SSo = activity;
        this.Uv = dbA;
        Context eli = com.bytedance.sdk.openadsdk.core.dV.eli();
        this.FS = eli;
        this.DbA = evVar;
        this.eli = i;
        this.DE = i == 0 || i == 1;
        this.Za = i == 0 || i == 2;
        this.jh = ue;
        boolean z = evVar.XU().getDurationSlotType() == 7;
        this.aGH = z;
        this.ui = z ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.gHb = evVar.ui();
        this.kb = Xb.aAs(evVar);
        int RTg = evVar.RTg();
        this.MGA = RTg;
        this.tGZ = com.bytedance.sdk.openadsdk.core.dV.aGH().aqO(String.valueOf(RTg));
        this.Os = com.bytedance.sdk.openadsdk.core.settings.NU.nY().NU(String.valueOf(RTg));
        this.Ue = new nlS(this);
        if (i == 2) {
            nls = new com.bytedance.sdk.openadsdk.component.reward.view.NU(this);
        } else {
            nls = evVar.ui() ? new com.bytedance.sdk.openadsdk.component.reward.view.nlS(this) : new com.bytedance.sdk.openadsdk.component.reward.view.du(this);
        }
        this.eU = nls;
        this.dZ = new com.bytedance.sdk.openadsdk.component.reward.view.FC(this);
        this.ev = new aqO(this);
        this.Vy = new aGH(this);
        this.gG = new wC(this, evVar);
        this.ujq = new com.bytedance.sdk.openadsdk.component.reward.view.aAs(this);
        this.qj = new dV(this);
        this.nro = new nn(this);
        this.Cp = new NU(this);
        this.cyF = new ui(this);
        this.KM = new du(this);
        this.VM = new MGA(this);
        this.GB = new Os(this);
        this.oWW = new com.bytedance.sdk.openadsdk.nlS.FC(eli);
        this.GMY = com.bytedance.sdk.openadsdk.utils.FC.eli(activity, new FC.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.eli.1
            @Override // com.bytedance.sdk.openadsdk.utils.FC.eli
            public View eli() {
                if (eli.this.eU != null) {
                    return eli.this.eU.aAs();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.utils.FC.eli
            public void DbA() {
                if (eli.this.Cp != null) {
                    eli.this.Cp.ui();
                }
            }
        });
    }

    public void eli(boolean z) {
        this.qyC = z;
        this.Cp.aGH(z);
    }

    public void eli() {
        this.XU = SystemClock.elapsedRealtime();
    }

    public void DbA() {
        if (this.XU <= 0) {
            this.XU = SystemClock.elapsedRealtime();
        }
        this.Kp += SystemClock.elapsedRealtime() - this.XU;
    }

    public long Os() {
        return this.Kp + (SystemClock.elapsedRealtime() - this.XU);
    }

    public boolean aGH() {
        com.bytedance.sdk.openadsdk.activity.wC wCVar;
        return !this.rH || (wCVar = this.yKf) == null || !(wCVar instanceof com.bytedance.sdk.openadsdk.activity.ui) || ((com.bytedance.sdk.openadsdk.activity.ui) wCVar).eli;
    }
}

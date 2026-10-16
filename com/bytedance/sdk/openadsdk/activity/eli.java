package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.component.reward.eli.ui;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.aGH.eli;
import com.bytedance.sdk.openadsdk.utils.Dfc;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class eli extends wC implements Ue.eli, ui.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA {
    private boolean CMM;
    protected com.bytedance.sdk.openadsdk.component.reward.DbA.DbA DbA;
    private CountDownTimer KM;
    private final AtomicBoolean MGA;
    protected com.bytedance.sdk.openadsdk.component.reward.eli.eli Os;
    private boolean Ue;
    private int Vy;
    protected int aGH;
    private int bf;
    protected final Ue eli;
    private boolean ev;
    private long gG;
    private int kb;
    protected boolean ui;
    private long ujq;
    private Bundle wC;

    protected abstract void DbA();

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void DbA(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void QX() {
    }

    protected abstract void aAs();

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void dV() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(int i) {
    }

    public abstract void eli(Bundle bundle);

    public abstract boolean eli(long j, boolean z);

    protected abstract void ui();

    public eli(DbA dbA, ev evVar, int i, int i2, boolean z) {
        super(dbA, evVar, i, i2, z);
        this.eli = new Ue(Looper.getMainLooper(), this);
        boolean z2 = false;
        this.MGA = new AtomicBoolean(false);
        this.kb = 1;
        this.bf = 0;
        this.CMM = false;
        this.ui = false;
        this.Vy = 0;
        this.Ue = false;
        if (KM.Os(evVar) && evVar.gnF()) {
            z2 = true;
        }
        this.Ue = z2;
        Xb.eli("TTAD.AdScene", "current scene is isOnlyPlayable -> " + this.Ue);
        if (this.Ue) {
            int oT = evVar.oT() * 1000;
            this.Vy = oT;
            this.ujq = oT;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final void eli(Activity activity, Bundle bundle) {
        this.wC = bundle;
        super.eli(activity, bundle);
        eli(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final com.bytedance.sdk.openadsdk.component.reward.view.FC eli() {
        return this.Os.dZ;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(Activity activity, DbA.ui uiVar) {
        this.kb = this.FC.WO();
        eli(activity, this.FC, this.wC);
        if (this.Os.rH && this.FC.gnF()) {
            this.Os.tGZ = uiVar.aGH;
        }
        if (this.Os.rH && this.du > 0) {
            this.Os.tGZ = uiVar.aGH;
        }
        try {
            TfR();
            QI();
        } catch (Throwable th) {
            Xb.eli("TTAD.AdScene", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA();
            Uv();
        }
    }

    private void eli(Activity activity, ev evVar, Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = new com.bytedance.sdk.openadsdk.component.reward.eli.eli(activity, this.eli, evVar, this, 1);
        this.Os = eliVar;
        eliVar.rH = this.aAs.Os();
        this.Os.eEH = this.nn;
        this.Os.PfW = this.aAs.eli();
        this.Os.Ca = this.aAs.QX();
        this.Os.yKf = this;
        this.Os.oWW = this.aAs.dV();
        Intent intent = activity.getIntent();
        com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(this.Os, intent, bundle);
        if (intent != null) {
            com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(intent, this.Os);
            evVar.eli(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.Os.qyC) {
            DbA();
        }
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA eli = com.bytedance.sdk.openadsdk.component.reward.DbA.MGA.eli(this.Os);
        this.DbA = eli;
        this.Os.Mc = eli;
        this.Os.cyF.eli(this);
        if (this.Os.rH) {
            this.Os.ev.eli(new eli.InterfaceC0198eli() { // from class: com.bytedance.sdk.openadsdk.activity.eli.1
                @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.InterfaceC0198eli
                public void eli(int i) {
                    if (eli.this.aAs == null) {
                        return;
                    }
                    eli.this.aAs.DbA(eli.this, i);
                }
            });
            if (!this.aAs.bf()) {
                this.aAs.QX().setShowSound(ev.ui(evVar));
            }
        }
        Dfc.eli(this.Os);
        new StringBuilder("init: mAdType = ").append(this.DbA);
    }

    private void TfR() {
        this.Os.dZ.eli(this.DbA);
        this.DbA.eli(this, this.eli);
        this.DbA.du();
    }

    private void QI() {
        this.DbA.eli(this.Xb);
        this.aGH = (int) this.Os.ev.cyF();
        if (this.Os.rH) {
            eli(this.Os.KM.ui());
            eli(this.Os.KM.aGH());
        }
        ui();
        rQ();
    }

    private void eli(com.bytedance.sdk.openadsdk.core.DbA.DbA dbA) {
        if (dbA != null) {
            HashMap hashMap = new HashMap();
            try {
                int i = this.nlS + 1;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_show_order", i);
                hashMap.put("pag_json_data", jSONObject.toString());
            } catch (Throwable unused) {
            }
            dbA.eli(hashMap);
        }
    }

    private boolean mm() {
        if (this.Os.aAs.get() && this.Os.kb) {
            return false;
        }
        if (this.FC.ui()) {
            return this.Os.aAs.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(Activity activity) {
        super.eli(activity);
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.Os;
        if (eliVar == null) {
            return;
        }
        eliVar.Ue.eli();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void Os() {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA;
        super.Os();
        if (this.Os == null || (dbA = this.DbA) == null) {
            return;
        }
        dbA.dV();
        this.Os.WfR = true;
        if (mm()) {
            this.Os.Cp.eli(this.Os.DbA.iiz());
        }
        this.Os.eU.Dfc();
        this.Os.qj.CMM();
        this.Os.gG.NU();
        if (this.DbA.DbA()) {
            this.Os.ev.eli(this.DbA);
            if (this.Os.ev.Za()) {
                eli(this.Os.ev.nn(), true);
            } else if (this.Os.ev.kb() && this.aAs.bf()) {
                cyF();
            } else {
                this.Os.ev.eli(false, this, this.bf != 0);
            }
        }
        this.bf++;
        oc();
        if (this.Os.ujq != null) {
            this.Os.ujq.kb();
        }
        this.Os.Ue.eli(this.eli);
        if (this.aAs.bf()) {
            this.Os.ujq.eli(0, false);
        }
        this.DbA.QX();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.Ue) {
            long j = this.gG;
            if (j != 0 && currentTimeMillis - j > this.ujq) {
                Xb.eli("TTAD.AdScene", "onResume: Exceed playable_duration_time, switch to next ad");
                dZ().eli(this, DbA(8));
            } else {
                if (j != 0) {
                    this.ujq -= currentTimeMillis - j;
                }
                Xb.eli("TTAD.AdScene", "onResume: The playable display time has not yet arrived, continue the countdown -> remainingTime = " + this.ujq);
                eli(this.ujq);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.sdk.openadsdk.activity.eli$2] */
    private void eli(long j) {
        this.KM = new CountDownTimer(j, 1000L) { // from class: com.bytedance.sdk.openadsdk.activity.eli.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                eli.this.ujq = j2;
                Xb.eli("TTAD.AdScene", "onTick: remainingTime = " + eli.this.ujq);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                Xb.eli("TTAD.AdScene", "onFinish: remainingTime = " + eli.this.ujq);
                DbA dZ = eli.this.dZ();
                eli eliVar = eli.this;
                dZ.eli(eliVar, eliVar.DbA(8));
            }
        }.start();
    }

    private void oc() {
        if (this.FC.ui() && !this.CMM) {
            this.CMM = true;
            eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.eli.3
                @Override // java.lang.Runnable
                public void run() {
                    float[] eli;
                    if (!eli.this.aAs.bf()) {
                        eli = eli.this.Os.Ue.eli(eli.this.kb);
                    } else {
                        eli = new float[]{SSo.Os(eli.this.Os.SSo, eli.this.Os.dZ.getWidth()), SSo.Os(eli.this.Os.SSo, eli.this.Os.dZ.getHeight())};
                    }
                    com.bytedance.sdk.openadsdk.component.reward.eli.MGA mga = eli.this.Os.VM;
                    eli eliVar = eli.this;
                    mga.eli(eli, eliVar, eliVar.DbA);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void aGH() {
        super.aGH();
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.DbA;
        if (dbA == null) {
            return;
        }
        dbA.bf();
    }

    private void rQ() {
        if (this.FC.ui()) {
            return;
        }
        if (KM.dV(this.Os.DbA)) {
            eli(false, DbA.C0161DbA.Os);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.DbA;
        if (dbA != null) {
            dbA.eli(this.Os.eU.MGA());
            this.DbA.ujq();
        }
    }

    public final void eli(boolean z, int i) {
        eli(z, false, i);
    }

    public final void eli(boolean z, boolean z2, int i) {
        this.Os.cyF.eli(z, z2, false, this.Os.Mc, i);
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.DbA;
        if (dbA == null) {
            return;
        }
        dbA.eli(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void MGA() {
        Za();
        this.Os.DbA.oI();
        this.Os.DbA.Os(true);
        if (ev.ui(this.Os.DbA)) {
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.Os.DbA, this.Os.ui, this.Os.DbA.apl());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void kb() {
        Xb.eli("TTAD.AdScene", "onPlayableLoadingDismiss()---" + this.du);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(boolean z) {
        Xb.eli("TTAD.AdScene", "onPlayableHappenInteraction()---" + this.du + " isHappenInteraction:" + z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(String str, JSONObject jSONObject) {
        if (str == null || !"skipToNextAd".equals(str) || this.aAs == null) {
            return;
        }
        this.aAs.DbA(this, DbA(7));
    }

    protected final void wC() {
        Message message = new Message();
        message.what = 400;
        if (this.FC.Txb()) {
            eli(10000);
        }
        this.eli.sendMessageDelayed(message, 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void FC() {
        if (this.MGA.compareAndSet(false, true)) {
            Xb.eli("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            aAs();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void du() {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.DbA;
        if (dbA == null) {
            return;
        }
        dbA.NU();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final void nlS() {
        super.nlS();
        if (this.Os == null || com.bytedance.sdk.component.utils.DbA.eli(SSo())) {
            return;
        }
        this.Os.qj.qj();
        com.bytedance.sdk.openadsdk.utils.aGH.eli(SSo(), this.Os.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void NU() {
        super.NU();
        if (this.Ue) {
            this.gG = System.currentTimeMillis();
            Xb.eli("TTAD.AdScene", "onPause: remainingTime = " + this.ujq);
            CountDownTimer countDownTimer = this.KM;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        }
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.DbA;
        if (dbA == null) {
            return;
        }
        dbA.Xb();
        if (this.Os.ujq != null) {
            this.Os.ujq.wC();
        }
        if (this.aAs.bf()) {
            this.Os.ujq.eli(8, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void nn() {
        this.Os.ev.eU();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final View Dfc() {
        return this.Os.ev.dZ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void aqO() {
        if (!this.Os.nn.getAndSet(true) || KM.Os(this.Os.DbA)) {
            this.Os.KM.eli();
        }
    }

    protected final void nGm() {
        this.eli.removeMessages(400);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void Xb() {
        super.Xb();
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.DbA;
        if (dbA == null) {
            return;
        }
        dbA.CMM();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.ui.eli
    public void eli(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA, int i) {
        eli(z, z2, z3, i);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void bf() {
        super.bf();
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.DbA;
        if (dbA != null) {
            dbA.ev();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(wC wCVar, wC wCVar2, DbA.ui uiVar) {
        super.eli(wCVar, wCVar2, uiVar);
        if (wCVar == this && (wCVar2 instanceof ui)) {
            if (uiVar.DbA == 3) {
                this.Os.ev.eli(!this.Os.ev.Cp() ? 1 : 0, 2);
            } else if (uiVar.DbA == 6) {
                this.Os.ev.eli(!this.Os.ev.Cp() ? 1 : 0, !this.Os.ev.Cp() ? 1 : 0);
            } else if (uiVar.DbA == 5 && !ev.ui(this.Os.DbA) && uiVar.ui) {
                this.Os.ev.eli("skip", true);
            }
            this.Os.Cp.eli(false);
            this.Os.Cp.aGH(false);
        }
        Xb.eli("TTAD.AdScene", "【onActiveSceneChanged】" + this.du + ",scene = " + this + ",newScene = " + wCVar2 + ",oldScene = " + wCVar + ",isPlayable = " + this.dV + ",isNextShow=" + (this.du == wCVar2.du + 1));
        if (wCVar2.du != 0 || this.du == 0) {
            return;
        }
        this.FC.cxQ();
    }

    public void eli(float f) {
        if (this.aAs == null) {
            return;
        }
        this.aAs.eli(f);
        if (this.ev || this.FC.mm() == 43 || f < this.FC.SSo() / 100.0f) {
            return;
        }
        wC Xb = this.aAs.Xb();
        if (Xb instanceof eli) {
            ((eli) Xb).CMM();
        }
    }

    public void CMM() {
        if (!this.ev) {
            this.ev = true;
            WfR();
        } else {
            Xb.eli("TTAD.AdScene", "tryPreloadNextAdVideo: Already tried preloading the video");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public boolean ev() {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.Os;
        return eliVar != null && eliVar.ev.oWW();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    protected String Vy() {
        return this.Os.ikX;
    }

    protected DbA.ui DbA(int i) {
        DbA.ui uiVar = new DbA.ui(i, this.Os);
        uiVar.aGH = this.Os.tGZ;
        return uiVar;
    }

    public void gG() {
        this.aAs.eli(this, DbA(DbA.C0161DbA.DbA));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void Os(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.Os;
        if (eliVar == null || eliVar.KM == null) {
            return;
        }
        this.Os.KM.DbA(z);
        this.Os.KM.Os(z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void aGH(boolean z) {
        if (this.aAs != null) {
            this.aAs.eli(this, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public boolean Ue() {
        return this.Os.ujq.FC();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public List<ev> KM() {
        return this.aAs.ev();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void VM() {
        this.Os.KM.eli();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(Map<String, Object> map, float f, float f2) {
        super.eli(map, f, f2);
        this.aAs.eli(map, this, f, f2);
    }

    public void GB() {
        oc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void oWW() {
        com.bytedance.sdk.openadsdk.component.reward.view.aGH eli;
        super.oWW();
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.Os;
        if (eliVar == null || (eli = eliVar.ujq.eli()) == null || !eli.ev()) {
            return;
        }
        VM();
    }

    public void qj() {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.Os;
        if (eliVar == null) {
            return;
        }
        eliVar.ev.Dfc();
    }

    public void nro() {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.Os;
        if (eliVar != null && eliVar.ev.FC()) {
            this.Os.ev.Xb();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void Cp() {
        this.ui = true;
    }
}

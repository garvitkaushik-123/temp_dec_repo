package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.DbA;
import com.bytedance.sdk.openadsdk.utils.dZ;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui extends wC implements Ue.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA {
    private static String MGA;
    private static String bf;
    private static String kb;
    private static String ui;
    private static String wC;
    private Bundle CMM;
    protected final Ue DbA;
    private boolean GB;
    private JSONObject KM;
    protected com.bytedance.sdk.openadsdk.component.reward.DbA.DbA Os;
    private long Ue;
    private int VM;
    private DbA.ui Vy;
    protected com.bytedance.sdk.openadsdk.component.reward.eli.eli aGH;
    public boolean eli;
    private int ev;
    private boolean gG;
    private boolean oWW;
    private boolean ujq;

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void Cp() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final View Dfc() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void aGH(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public boolean eli(long j, boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void nn() {
    }

    public ui(DbA dbA, ev evVar, int i, int i2, boolean z, boolean z2, boolean z3) {
        super(dbA, evVar, i, i2, z2);
        this.DbA = new Ue(Looper.getMainLooper(), this);
        boolean z4 = false;
        this.ev = 0;
        this.oWW = true;
        this.dV = z;
        this.nn = dbA.DbA();
        if (z && KM.Os(evVar)) {
            z4 = true;
        }
        this.GB = z4;
        this.eli = z3;
        eli(evVar, this.CMM);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final void eli(Activity activity, Bundle bundle) {
        this.CMM = bundle;
        super.eli(activity, bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final com.bytedance.sdk.openadsdk.component.reward.view.FC eli() {
        return this.aGH.dZ;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(Activity activity, DbA.ui uiVar) {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar;
        this.Vy = uiVar;
        Intent intent = activity.getIntent();
        this.aqO = intent.getStringExtra("media_extra");
        this.Dfc = intent.getStringExtra("user_id");
        try {
            if (wC == null) {
                wC = com.bytedance.sdk.component.utils.ev.eli(this.aGH.FS, "tt_reward_msg");
                ui = com.bytedance.sdk.component.utils.ev.eli(this.aGH.FS, "tt_msgPlayable");
                kb = com.bytedance.sdk.component.utils.ev.eli(this.aGH.FS, "tt_negtiveBtnBtnText");
                bf = com.bytedance.sdk.component.utils.ev.eli(this.aGH.FS, "tt_postiveBtnText");
                MGA = com.bytedance.sdk.component.utils.ev.eli(this.aGH.FS, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            Xb.Os("TTAD.EndCardScene", th.getMessage());
        }
        if (uiVar != null && (eliVar = uiVar.Os) != null) {
            this.aGH.BDs = eliVar.BDs;
            this.aGH.tGZ = eliVar.tGZ;
            if ((this.nn || this.dV) && !eU()) {
                this.aGH.nlS.set(eliVar.nlS.get());
            }
            if (!this.GB) {
                this.aGH.NU.set(eliVar.NU.get());
                this.aGH.nn.set(eliVar.nn.get());
            }
            this.aGH.ev.eli(eliVar.ev.ui());
            eli(this.aGH, eliVar);
        }
        if (this.nn || this.dV) {
            try {
                qj();
            } catch (Throwable unused) {
                Uv();
            }
        }
        if (this.aGH != null && this.aAs != null) {
            this.aGH.rn = this.aAs.eli;
        }
        nro();
        TfR();
        du();
    }

    private void eli(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar, com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar2) {
        if (!this.nn || eU() || eliVar == null || eliVar2 == null) {
            return;
        }
        try {
            this.Ue = eliVar2.ev.NU();
            if (this.FC.Za()) {
                this.Ue = eliVar2.Os();
            }
            this.VM = eliVar2.ev.ev();
            this.KM = dZ.eli(this.FC, eliVar2.ev.aqO(), eliVar2.ev.dV());
        } catch (Throwable unused) {
        }
    }

    private void eli(ev evVar, Bundle bundle) {
        Activity SSo = SSo();
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = new com.bytedance.sdk.openadsdk.component.reward.eli.eli(SSo, this.DbA, evVar, this, 2);
        this.aGH = eliVar;
        eliVar.Gjg = this.dV;
        this.aGH.rH = this.aAs.Os();
        this.aGH.eEH = this.nn;
        this.aGH.PfW = this.aAs.eli();
        if (!this.eli) {
            this.aGH.Ca = this.aAs.QX();
        }
        this.aGH.yKf = this;
        this.aGH.oWW = this.aAs.dV();
        com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(this.aGH, SSo.getIntent(), bundle);
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA eli = com.bytedance.sdk.openadsdk.component.reward.DbA.MGA.eli(this.aGH);
        this.Os = eli;
        this.aGH.Mc = eli;
        new StringBuilder("init: mAdType = ").append(this.Os);
    }

    private void qj() {
        if (this.ujq) {
            return;
        }
        this.ujq = true;
        if (!this.eli) {
            this.aGH.Ca = this.aAs.QX();
        }
        this.aGH.dZ.eli(this.Os);
        this.Os.eli(this, this.DbA);
        this.Os.du();
    }

    private void nro() {
        if (this.gG) {
            return;
        }
        this.gG = true;
        if (KM.kb(this.aGH.DbA) || com.bytedance.sdk.openadsdk.bf.eli.eli("ivrv_new_arch_endcard_view_add_at_first", 0) == 1) {
            if (this.nn) {
                this.aAs.eli(eli(), eU());
            } else {
                this.aAs.eli(eli());
            }
        }
        this.Os.eli(this.Xb);
    }

    private void TfR() {
        final View aAs = this.aGH.eU.aAs();
        if (aAs != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.ui.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ui.this.aGH.qj.ujq()) {
                        boolean NU = ui.this.aGH.nro.NU();
                        ui.this.aGH.qj.MGA(NU);
                        ui.this.aGH.eU.MGA(8);
                        View view2 = aAs;
                        if (view2 instanceof com.bytedance.sdk.openadsdk.core.ui.aGH) {
                            ((com.bytedance.sdk.openadsdk.core.ui.aGH) view2).setImageResource(com.bytedance.sdk.component.utils.ev.aGH(ui.this.aGH.FS, "tt_close_btn"));
                        }
                        ui.this.aGH.jh.sendEmptyMessageDelayed(600, 5000L);
                        if (!ev.Os(ui.this.aGH.DbA)) {
                            return;
                        }
                        if (ev.Os(ui.this.aGH.DbA) && NU) {
                            return;
                        }
                    }
                    ui.this.aGH.qj.Ue();
                    ui.this.aGH.nro.du();
                    ui.this.aGH.KM.MGA();
                    if (KM.aGH(ui.this.aGH.DbA) && ui.this.eli(true, true, (Runnable) null)) {
                        return;
                    }
                    ui.this.Uv();
                }
            };
            aAs.setOnClickListener(onClickListener);
            aAs.setTag(aAs.getId(), onClickListener);
        }
        this.aGH.Cp.eli(new com.bytedance.sdk.openadsdk.component.reward.top.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.ui.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view) {
                ui uiVar = ui.this;
                if (uiVar.eli(KM.Os(uiVar.aGH.DbA), false, (Runnable) null) || ui.this.mm()) {
                    return;
                }
                if (KM.ui(ui.this.aGH.DbA)) {
                    if (KM.aAs(ui.this.aGH.DbA)) {
                        ui.this.aGH.gG.dV();
                        return;
                    }
                    View view2 = aAs;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        ui.this.Uv();
                        return;
                    }
                }
                if (KM.wC(ui.this.aGH.DbA)) {
                    if (ui.this.aGH.gG.eli()) {
                        ui.this.aGH.gG.eli(5);
                        return;
                    } else {
                        ui.this.aGH.qj.wC();
                        return;
                    }
                }
                if (KM.dV(ui.this.aGH.DbA) || (com.bytedance.sdk.openadsdk.core.model.Xb.eli(ui.this.aGH.DbA) && !ui.this.aGH.aqO.get())) {
                    if (!KM.wC(ui.this.aGH.DbA) && ui.this.aGH.gG.eli()) {
                        ui.this.aGH.gG.eli(4);
                    }
                    ui.this.Uv();
                    return;
                }
                ui.this.Uv();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view, String str) {
                ui.this.eli(str);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void DbA(View view) {
                ui.this.c_();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void Os(View view) {
                View view2 = aAs;
                if (view2 != null) {
                    view2.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void aGH(View view) {
                Log.e("TTAD.EndCardScene", "onPlayableChangeNext: click");
                ui.this.QI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QI() {
        try {
            int gG = this.aAs.gG();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("click_countdown_remaining", Math.max(gG, 0));
            com.bytedance.sdk.openadsdk.aGH.Os.kb(this.FC, this.aGH.ui, jSONObject);
        } catch (Throwable unused) {
        }
        gG();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void c_() {
        this.aGH.GB.eli(this.Os);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public boolean d_() {
        return this.aGH.tGZ;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(String str) {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA != null && dbA.aGH() != null) {
            this.Os.aGH().eli(this.aGH.tGZ);
        }
        this.aGH.tGZ = !r0.tGZ;
        new Object[]{"rewarded_video", "will set is Mute " + this.aGH.tGZ + " mLastVolume=" + this.aGH.oWW.eli()};
        this.aGH.ev.eli(this.aGH.tGZ, str);
        if (!KM.nGm(this.aGH.DbA) || this.aGH.aAs.get()) {
            this.aGH.qj.ui(this.aGH.tGZ);
            this.aGH.gG.MGA(this.aGH.tGZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mm() {
        if ((!this.nn && !this.dV) || eU()) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.FC, this.aGH.ui, "skip", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.ui.3
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("duration", ui.this.Ue);
                        jSONObject.put("percent", ui.this.VM);
                        if (ui.this.KM != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(AnalyticsConstants.SCENE_TYPE, ui.this.aGH.eli);
                            ui.this.KM.put("pag_json_data", jSONObject2.toString());
                            jSONObject.put("ad_extra_data", ui.this.KM);
                        }
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                }
            });
        } catch (Throwable unused) {
        }
        this.aAs.eli(this, true, false, false, 4);
        return true;
    }

    private boolean oc() {
        if (this.aGH.aAs.get() && this.aGH.kb) {
            return false;
        }
        if (this.FC.ui()) {
            return this.aGH.aAs.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(Activity activity) {
        super.eli(activity);
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.aGH;
        if (eliVar == null) {
            return;
        }
        eliVar.Ue.eli();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final void Os() {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA;
        super.Os();
        if (this.aGH == null || (dbA = this.Os) == null) {
            return;
        }
        dbA.dV();
        this.aGH.WfR = true;
        if (oc()) {
            this.aGH.Cp.eli(this.aGH.DbA.iiz());
        }
        this.aGH.eU.Dfc();
        this.aGH.qj.CMM();
        this.aGH.gG.NU();
        if (this.Os.DbA()) {
            this.aGH.ev.eli(this.Os);
            this.aGH.ev.eli(false, this, this.ev != 0);
        }
        this.ev++;
        if (this.aGH.ujq != null) {
            this.aGH.ujq.kb();
        }
        this.aGH.Ue.eli(this.DbA);
        this.Os.QX();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void aGH() {
        super.aGH();
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.bf();
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public final void eli(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.eli(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void MGA() {
        Za();
        this.aGH.DbA.oI();
        this.aGH.DbA.Os(true);
        if (ev.ui(this.aGH.DbA)) {
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.aGH.DbA, this.aGH.ui, this.aGH.DbA.apl());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(String str, JSONObject jSONObject) {
        if (str == null || !"skipToNextAd".equals(str) || this.aAs == null || eU()) {
            return;
        }
        if (this.aAs.Xb() == null && eli(KM.Os(this.aGH.DbA), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.ui.4
            @Override // java.lang.Runnable
            public void run() {
                ui.this.rQ();
            }
        })) {
            return;
        }
        rQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ() {
        DbA.ui uiVar = new DbA.ui(7, this.aGH);
        uiVar.aGH = this.aGH.tGZ;
        this.aAs.DbA(this, uiVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void e_() {
        Za();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void FC() {
        jh();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void du() {
        if (this.aAs == null) {
            return;
        }
        this.aGH.cyF.eli(this.Vy.eli.getBoolean("isSkip", false), this.Vy.eli.getBoolean("force", false), this.Vy.eli.getBoolean("isFromLandingPage", false), this.Os, this.Vy.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final void nlS() {
        super.nlS();
        if (this.aGH == null || com.bytedance.sdk.component.utils.DbA.eli(SSo())) {
            return;
        }
        this.aGH.qj.qj();
        com.bytedance.sdk.openadsdk.utils.aGH.eli(SSo(), this.aGH.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public final void NU() {
        super.NU();
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.Xb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void aqO() {
        if (!this.aGH.nn.getAndSet(true) || KM.dV(this.aGH.DbA)) {
            this.aGH.KM.eli();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void dV() {
        ikX();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void QX() {
        boolean z = false;
        boolean z2 = (1.0f - (this.aGH.gG.DbA() / ((float) this.aGH.DbA.oT()))) * 100.0f >= ((float) dV.aGH().gG(String.valueOf(this.aGH.MGA)).MGA);
        int eli = dV.aGH().eli(String.valueOf(this.aGH.MGA));
        if (eli == 0) {
            boolean MGA2 = this.aGH.qj.nlS().MGA();
            if (this.aGH.gG.Os()) {
                MGA2 = true;
            }
            z = z2 && MGA2;
        } else if (eli == 1) {
            z = z2;
        }
        if (z) {
            ikX();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void DbA(boolean z) {
        if (!z || this.aGH.rH) {
            return;
        }
        ikX();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void f_() {
        aGH(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public List<ev> KM() {
        return this.aAs.ev();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void kb() {
        Xb.eli("TTAD.EndCardScene", "onPlayableLoadingDismiss()---" + this.du + ",scene = " + this);
        if (this.aAs != null) {
            this.aAs.eli(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(boolean z) {
        if (this.aAs != null) {
            this.aAs.eli(this, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void bf() {
        super.bf();
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA != null) {
            dbA.ev();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public boolean ev() {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.aGH;
        return eliVar != null && eliVar.ev.oWW();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    protected boolean a_() {
        return this.aGH.aGH;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    protected String Vy() {
        return this.aGH.ikX;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public String b_() {
        return this.aGH.ui;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(wC wCVar, wC wCVar2, DbA.ui uiVar) {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar;
        super.eli(wCVar, wCVar2, uiVar);
        Xb.eli("TTAD.EndCardScene", "【onActiveSceneChanged】" + this.du + ",scene = " + this + ",newScene = " + wCVar2 + ",oldScene = " + wCVar + ",isPlayable = " + this.dV);
        boolean z = this.du == wCVar2.du + 1;
        if (wCVar != null && (eliVar = this.aGH) != null) {
            eliVar.tGZ = uiVar.aGH;
        }
        if (z) {
            Xb.eli("TTAD.EndCardScene", "preload index =" + this.du + ",new index =" + wCVar2.du + ",isPlayableProxy = " + this.dV);
            Yw();
        }
        if (wCVar == null && this.eli) {
            Xb.eli("TTAD.EndCardScene", "preload agg-endcard =" + this.du + ",new index =" + wCVar2.du + ",isPlayableProxy = " + this.dV);
            Yw();
        }
    }

    private void Yw() {
        try {
            qj();
        } catch (Throwable unused) {
            Uv();
        }
        nro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(final boolean z, boolean z2, final Runnable runnable) {
        if (!this.aGH.aGH || this.aAs.FC().getBoolean("reward_verify", false) || this.aAs.NU()) {
            return false;
        }
        if (!z2 && this.aAs.FC().getBoolean("user_has_give_up_reward", false)) {
            return false;
        }
        if (!dV.aGH().kb(String.valueOf(this.aGH.MGA))) {
            if (!z2) {
                return false;
            }
            if (runnable == null && z) {
                Uv();
                return true;
            }
        }
        this.aGH.Xb.set(true);
        if (z) {
            this.aGH.gG.nn();
        }
        final com.bytedance.sdk.openadsdk.core.widget.DbA dbA = new com.bytedance.sdk.openadsdk.core.widget.DbA(this.aGH.SSo);
        this.Os.NU = dbA;
        if (z) {
            this.Os.NU.eli(ui).DbA(MGA).Os(kb);
        } else {
            this.Os.NU.eli(wC).DbA(bf).Os(kb);
        }
        this.Os.NU.eli(new DbA.InterfaceC0204DbA() { // from class: com.bytedance.sdk.openadsdk.activity.ui.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.DbA.InterfaceC0204DbA
            public void eli() {
                if (z) {
                    ui.this.aGH.gG.ui(1000);
                }
                dbA.dismiss();
                ui.this.aGH.Xb.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.DbA.InterfaceC0204DbA
            public void DbA() {
                dbA.dismiss();
                ui.this.aAs.FC().putBoolean("user_has_give_up_reward", true);
                ui.this.aGH.Xb.set(false);
                ui.this.aGH.gG.MGA(Integer.MAX_VALUE);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                if (!z) {
                    ui.this.mm();
                    return;
                }
                if (KM.wC(ui.this.aGH.DbA)) {
                    if (ui.this.aGH.gG.eli()) {
                        ui.this.aGH.gG.eli(5);
                        return;
                    } else {
                        ui.this.aGH.qj.wC();
                        ui.this.mm();
                        return;
                    }
                }
                ui.this.aGH.KM.MGA();
                if (ui.this.aGH.gG.eli()) {
                    ui.this.aGH.gG.eli(4);
                }
                ui.this.Uv();
            }
        }).show();
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void Xb() {
        super.Xb();
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.CMM();
    }

    public void gG() {
        if (eU()) {
            return;
        }
        DbA.ui uiVar = new DbA.ui(8, this.aGH);
        uiVar.aGH = this.aGH.tGZ;
        if (this.aAs != null) {
            this.aAs.eli(this, uiVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void Os(boolean z) {
        long j = this.oWW ? this.aGH.BDs : 0L;
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.aGH;
        if (eliVar != null && eliVar.KM != null) {
            this.aGH.KM.DbA(z);
            this.aGH.KM.Os(z);
            if (z && j > 0) {
                this.aGH.BDs = j;
            }
        }
        if (z) {
            this.oWW = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq() {
        return this.aGH;
    }

    public boolean GB() {
        return this.aGH.qj.eU();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void VM() {
        aqO();
    }
}

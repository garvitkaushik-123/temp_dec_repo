package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.ujq;
import com.bytedance.sdk.openadsdk.utils.cyF;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static com.bytedance.sdk.openadsdk.eli.Os.DbA nn;
    private boolean Dfc;
    private com.bytedance.sdk.openadsdk.eli.Os.DbA NU;

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void DbA(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void QX() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean ev() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void f_() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        nn = this.NU;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void nGm() {
        com.bytedance.sdk.openadsdk.component.reward.view.aGH eli;
        super.nGm();
        if (this.DbA == null || (eli = this.DbA.ujq.eli()) == null) {
            return;
        }
        eli.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.ui() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.ui
            public void eli() {
                TTFullScreenVideoActivity.this.ujq();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.DbA == null || ev.ui(this.DbA.DbA)) {
            return;
        }
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = this.DbA.DbA.nY();
        if (nY == null) {
            com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA = new com.bykv.vk.openvk.eli.eli.eli.Os.DbA();
            dbA.eli(10.0d);
            this.DbA.DbA.eli(dbA);
        } else if (nY.MGA() <= 0.0d) {
            nY.eli(10.0d);
        }
    }

    private void eli(final String str) {
        cyF.Os(new com.bytedance.sdk.component.wC.wC("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.DbA(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.DbA.ikX, str);
                } catch (Throwable th) {
                    Xb.Os("TTAD.FSVA", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void eli(Intent intent) {
        super.eli(intent);
        this.DbA.BH = intent.getBooleanExtra("is_verity_playable", false);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            this.NU = Ue.eli().Os();
        }
        if (this.NU != null || bundle == null) {
            return;
        }
        this.NU = nn;
        nn = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void CMM() {
        final View aAs = this.DbA.eU.aAs();
        if (aAs != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTFullScreenVideoActivity.this.DbA.qj.ujq() && TTFullScreenVideoActivity.this.DbA.aAs.get()) {
                        boolean NU = TTFullScreenVideoActivity.this.DbA.nro.NU();
                        TTFullScreenVideoActivity.this.DbA.qj.MGA(NU);
                        TTFullScreenVideoActivity.this.DbA.eU.MGA(8);
                        View view2 = aAs;
                        if (view2 instanceof com.bytedance.sdk.openadsdk.core.ui.aGH) {
                            ((com.bytedance.sdk.openadsdk.core.ui.aGH) view2).setImageResource(com.bytedance.sdk.component.utils.ev.aGH(TTFullScreenVideoActivity.this.DbA.FS, "tt_close_btn"));
                        }
                        TTFullScreenVideoActivity.this.DbA.jh.sendEmptyMessageDelayed(600, 5000L);
                        if (!ev.Os(TTFullScreenVideoActivity.this.DbA.DbA)) {
                            return;
                        }
                        if (ev.Os(TTFullScreenVideoActivity.this.DbA.DbA) && NU) {
                            return;
                        }
                    }
                    TTFullScreenVideoActivity.this.DbA.qj.Ue();
                    TTFullScreenVideoActivity.this.DbA.nro.du();
                    TTFullScreenVideoActivity.this.DbA.KM.MGA();
                    TTFullScreenVideoActivity.this.finish();
                }
            };
            aAs.setOnClickListener(onClickListener);
            aAs.setTag(aAs.getId(), onClickListener);
        }
        this.DbA.Cp.eli(new com.bytedance.sdk.openadsdk.component.reward.top.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void aGH(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view) {
                com.bytedance.sdk.openadsdk.core.model.aGH UCq;
                com.bytedance.sdk.openadsdk.core.du.aGH eli;
                if (KM.MGA(TTFullScreenVideoActivity.this.DbA.DbA) || (KM.ui(TTFullScreenVideoActivity.this.DbA.DbA) && TTFullScreenVideoActivity.this.DbA.gG.wC(com.bytedance.sdk.openadsdk.component.reward.eli.wC.DbA))) {
                    if (KM.aAs(TTFullScreenVideoActivity.this.DbA.DbA)) {
                        TTFullScreenVideoActivity.this.DbA.gG.dV();
                        return;
                    }
                    View view2 = aAs;
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                }
                if (KM.wC(TTFullScreenVideoActivity.this.DbA.DbA) && (KM.dV(TTFullScreenVideoActivity.this.DbA.DbA) || TTFullScreenVideoActivity.this.DbA.aAs.get())) {
                    if (TTFullScreenVideoActivity.this.DbA.gG.eli()) {
                        TTFullScreenVideoActivity.this.DbA.gG.eli(5);
                        return;
                    } else {
                        TTFullScreenVideoActivity.this.DbA.qj.wC();
                        return;
                    }
                }
                if (KM.dV(TTFullScreenVideoActivity.this.DbA.DbA) || (com.bytedance.sdk.openadsdk.core.model.Xb.eli(TTFullScreenVideoActivity.this.DbA.DbA) && !TTFullScreenVideoActivity.this.DbA.aqO.get())) {
                    if (!KM.wC(TTFullScreenVideoActivity.this.DbA.DbA) && TTFullScreenVideoActivity.this.DbA.gG.eli()) {
                        TTFullScreenVideoActivity.this.DbA.gG.eli(4);
                    }
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                Dfc.eli eliVar = new Dfc.eli();
                eliVar.DbA(TTFullScreenVideoActivity.this.DbA.ev.nlS());
                eliVar.aGH(TTFullScreenVideoActivity.this.DbA.ev.gG());
                eliVar.Os(TTFullScreenVideoActivity.this.DbA.ev.aqO());
                eliVar.Os(3);
                eliVar.aGH(TTFullScreenVideoActivity.this.DbA.ev.Vy());
                eliVar.eli(TTFullScreenVideoActivity.this.DbA.ev.DbA());
                com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(TTFullScreenVideoActivity.this.DbA.ev.wC(), eliVar, TTFullScreenVideoActivity.this.DbA.ev.ui());
                ujq.Os(TTFullScreenVideoActivity.this.DbA.MGA);
                TTFullScreenVideoActivity.this.DbA.ev.eli("skip", false);
                TTFullScreenVideoActivity.this.DbA.Cp.aGH(false);
                if (TTFullScreenVideoActivity.this.DbA.Os) {
                    if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(TTFullScreenVideoActivity.this.DbA.DbA)) {
                        com.bytedance.sdk.openadsdk.component.reward.view.aGH eli2 = TTFullScreenVideoActivity.this.DbA.ujq.eli();
                        if (eli2 == null || eli2.aGH != 0) {
                            TTFullScreenVideoActivity.this.eli(true, 4);
                        }
                    } else {
                        TTFullScreenVideoActivity.this.eli(true, 4);
                    }
                    if (TTFullScreenVideoActivity.this.DbA.DbA != null && (UCq = TTFullScreenVideoActivity.this.DbA.DbA.UCq()) != null && (eli = UCq.eli()) != null) {
                        eli.MGA(TTFullScreenVideoActivity.this.DbA.ev.nlS());
                        eli.ui(TTFullScreenVideoActivity.this.DbA.ev.nlS());
                    }
                    com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(TTFullScreenVideoActivity.this.DbA.DbA, 5);
                }
                TTFullScreenVideoActivity.this.finish();
                if (TTFullScreenVideoActivity.this.DbA.DbA != null) {
                    eli.MGA(TTFullScreenVideoActivity.this.DbA.ev.nlS());
                    eli.ui(TTFullScreenVideoActivity.this.DbA.ev.nlS());
                }
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(TTFullScreenVideoActivity.this.DbA.DbA, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view, String str) {
                com.bytedance.sdk.openadsdk.core.model.aGH UCq;
                com.bytedance.sdk.openadsdk.core.du.aGH eli;
                TTFullScreenVideoActivity.this.DbA.tGZ = !TTFullScreenVideoActivity.this.DbA.tGZ;
                if (TTFullScreenVideoActivity.this.Os != null && TTFullScreenVideoActivity.this.Os.aGH() != null) {
                    TTFullScreenVideoActivity.this.Os.aGH().eli(TTFullScreenVideoActivity.this.DbA.tGZ);
                }
                TTFullScreenVideoActivity.this.DbA.ev.eli(TTFullScreenVideoActivity.this.DbA.tGZ, str);
                if (!KM.nGm(TTFullScreenVideoActivity.this.DbA.DbA) || TTFullScreenVideoActivity.this.DbA.aAs.get()) {
                    TTFullScreenVideoActivity.this.DbA.qj.ui(TTFullScreenVideoActivity.this.DbA.tGZ);
                    TTFullScreenVideoActivity.this.DbA.gG.MGA(TTFullScreenVideoActivity.this.DbA.tGZ);
                    if (TTFullScreenVideoActivity.this.DbA.DbA == null || (UCq = TTFullScreenVideoActivity.this.DbA.DbA.UCq()) == null || (eli = UCq.eli()) == null) {
                        return;
                    }
                    if (TTFullScreenVideoActivity.this.DbA.tGZ) {
                        eli.wC(TTFullScreenVideoActivity.this.DbA.ev.nlS());
                    } else {
                        eli.FC(TTFullScreenVideoActivity.this.DbA.ev.nlS());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void DbA(View view) {
                TTFullScreenVideoActivity.this.DbA.GB.eli(TTFullScreenVideoActivity.this.Os);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void Os(View view) {
                View view2 = aAs;
                if (view2 != null) {
                    view2.performClick();
                }
            }
        });
    }

    public boolean eli(long j, boolean z) {
        com.bytedance.sdk.openadsdk.aGH.kb kbVar = new com.bytedance.sdk.openadsdk.aGH.kb();
        kbVar.eli(System.currentTimeMillis(), 1.0f);
        if (this.Os != null && (this.Os instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.wC)) {
            this.DbA.ev.eli(((com.bytedance.sdk.openadsdk.component.reward.DbA.wC) this.Os).VM(), kbVar);
        } else {
            this.DbA.ev.eli(this.DbA.eU.MGA(), kbVar);
        }
        Os.eli eliVar = new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.5
            boolean eli;

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, int i) {
                if (this.eli) {
                    return;
                }
                this.eli = true;
                TTFullScreenVideoActivity.this.aGH.removeMessages(300);
                TTFullScreenVideoActivity.this.bf();
                TTFullScreenVideoActivity.this.DbA.ev.eli(j2, j2);
                TTFullScreenVideoActivity.this.DbA.QX.set(true);
                if (TTFullScreenVideoActivity.this.DbA.DbA.mm() == 36 && TTFullScreenVideoActivity.this.DbA.Os) {
                    TTFullScreenVideoActivity.this.DbA.Vy.Os().Os(TTFullScreenVideoActivity.this.DbA.DbA);
                    com.bytedance.sdk.openadsdk.utils.Dfc.DbA();
                }
                if (TTFullScreenVideoActivity.this.DbA.DbA.vOq()) {
                    TTFullScreenVideoActivity.this.DbA.DbA.FS(1);
                    TTFullScreenVideoActivity.this.DbA.eU.dV();
                }
                if (TTFullScreenVideoActivity.this.DbA.DbA.mm() == 21 && !TTFullScreenVideoActivity.this.DbA.DbA.nn()) {
                    TTFullScreenVideoActivity.this.DbA.DbA.aGH(true);
                    TTFullScreenVideoActivity.this.DbA.eU.dV();
                }
                if (TTFullScreenVideoActivity.this.du && TTFullScreenVideoActivity.this.DbA.ujq.du()) {
                    return;
                }
                if (TTFullScreenVideoActivity.this.DbA.Os) {
                    if (TTFullScreenVideoActivity.this.DbA.DbA.Za()) {
                        TTFullScreenVideoActivity.this.DbA.Cp.Os();
                        return;
                    }
                    TTFullScreenVideoActivity.this.eli(false, 5);
                    if (com.bytedance.sdk.openadsdk.core.model.Xb.DbA(TTFullScreenVideoActivity.this.DbA.DbA) && TTFullScreenVideoActivity.this.DbA.GMY != null) {
                        TTFullScreenVideoActivity.this.DbA.GMY.eli(0L);
                    }
                    if (ev.ui(TTFullScreenVideoActivity.this.DbA.DbA)) {
                        return;
                    }
                    TTFullScreenVideoActivity.this.DbA.ev.eli("skip", true);
                    return;
                }
                if (TTFullScreenVideoActivity.this.DbA.DbA.Za()) {
                    TTFullScreenVideoActivity.this.DbA.Cp.Os();
                    return;
                }
                if (!ev.ui(TTFullScreenVideoActivity.this.DbA.DbA)) {
                    TTFullScreenVideoActivity.this.DbA.ev.eli("skip", true);
                }
                TTFullScreenVideoActivity.this.finish();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void DbA(long j2, int i) {
                TTFullScreenVideoActivity.this.aGH.removeMessages(300);
                if (TTFullScreenVideoActivity.this.DbA.eU.Dfc != null) {
                    TTFullScreenVideoActivity.this.DbA.eU.Dfc.aAs();
                }
                if (TTFullScreenVideoActivity.this.DbA.ev.MGA()) {
                    TTFullScreenVideoActivity.this.Xb();
                    return;
                }
                TTFullScreenVideoActivity.this.DbA.ev.QX();
                new Object[]{"fullscreen_interstitial_ad", "onError、、、、、、、、"};
                if (TTFullScreenVideoActivity.this.DbA.Os) {
                    TTFullScreenVideoActivity.this.eli(false, true, 3);
                    TTFullScreenVideoActivity.this.DbA.ev.eli(!TTFullScreenVideoActivity.this.DbA.ev.Cp() ? 1 : 0, 2);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli() {
                TTFullScreenVideoActivity.this.aGH.removeMessages(300);
                TTFullScreenVideoActivity.this.bf();
                new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                if (TTFullScreenVideoActivity.this.DbA.Os) {
                    TTFullScreenVideoActivity.this.DbA.ev.eli(!TTFullScreenVideoActivity.this.DbA.ev.Cp() ? 1 : 0, !TTFullScreenVideoActivity.this.DbA.ev.Cp() ? 1 : 0);
                    TTFullScreenVideoActivity.this.eli(false, true, 6);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                TTFullScreenVideoActivity.this.DbA.ev.QX();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, long j3) {
                if (!TTFullScreenVideoActivity.this.DbA.WfR && TTFullScreenVideoActivity.this.DbA.ev.MGA()) {
                    TTFullScreenVideoActivity.this.DbA.ev.bf();
                }
                if (TTFullScreenVideoActivity.this.DbA.aAs.get()) {
                    return;
                }
                TTFullScreenVideoActivity.this.aGH.removeMessages(300);
                if (j2 != TTFullScreenVideoActivity.this.DbA.ev.NU()) {
                    TTFullScreenVideoActivity.this.bf();
                }
                TTFullScreenVideoActivity.this.DbA.ev.eli(j2, j3);
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                long j4 = j2 / 1000;
                tTFullScreenVideoActivity.MGA = (int) (tTFullScreenVideoActivity.DbA.ev.cyF() - j4);
                int i = (int) j4;
                if ((TTFullScreenVideoActivity.this.DbA.Xb.get() || TTFullScreenVideoActivity.this.DbA.du.get()) && TTFullScreenVideoActivity.this.DbA.ev.MGA()) {
                    TTFullScreenVideoActivity.this.DbA.ev.bf();
                }
                TTFullScreenVideoActivity.this.Os(i);
                if (TTFullScreenVideoActivity.this.MGA >= 0) {
                    TTFullScreenVideoActivity.this.DbA.Cp.eli(String.valueOf(TTFullScreenVideoActivity.this.MGA), null);
                }
            }
        };
        this.DbA.ev.eli(eliVar);
        if (this.DbA.eU.Dfc != null) {
            this.DbA.eU.Dfc.eli(eliVar);
        }
        return this.DbA.ev.eli(j, z, null, this.Os);
    }

    public void Os(int i) {
        int Fxk = this.DbA.DbA.Fxk();
        if (!dV.aGH().ui(String.valueOf(this.DbA.MGA)) || (!ev.ui(this.DbA.DbA) && !this.DbA.Os)) {
            if (i >= Fxk) {
                if (!this.DbA.qyC) {
                    this.DbA.eli(true);
                }
                aGH();
                return;
            }
            return;
        }
        if (!this.DbA.qyC) {
            this.DbA.eli(true);
        }
        if (i <= Fxk) {
            aGH(Fxk - i);
            this.DbA.Cp.ui(false);
        } else {
            aGH();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void aGH() {
        if (!ev.ui(this.DbA.DbA) && !this.DbA.Os) {
            this.DbA.Cp.eli(null, "X");
        } else {
            this.DbA.Cp.eli(null, TTAdDislikeToast.getSkipText());
        }
        this.DbA.Cp.ui(true);
    }

    private void aGH(int i) {
        this.DbA.Cp.eli(null, String.format(com.bytedance.sdk.component.utils.ev.eli(dV.eli(), "tt_skip_ad_time_text"), Integer.valueOf(i)));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void e_() {
        if (this.DbA.DbA.Nvn() != 100.0f) {
            this.Dfc = true;
        }
        ujq();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void nlS() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.eli.Os.DbA dbA = this.NU;
            if (dbA != null) {
                dbA.eli();
            }
        }
        if (Vy()) {
            this.DbA.ujq.nlS();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void MGA() {
        ujq();
        this.DbA.DbA.oI();
        this.DbA.DbA.Os(true);
        if (ev.ui(this.DbA.DbA)) {
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.DbA.DbA, this.DbA.ui, this.DbA.DbA.apl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ujq() {
        Xb.eli("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.eli.Os.DbA dbA = this.NU;
        if (dbA != null) {
            dbA.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.DbA != null) {
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("videoForceBreak", this.DbA.DbA);
            this.DbA.gG.eli(this.DbA.BH);
        }
        try {
            Ue();
        } catch (Exception unused) {
        }
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Ue();
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("recycleRes");
        }
        this.NU = null;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nn = null;
    }

    private void Ue() {
        if (this.kb) {
            return;
        }
        this.kb = true;
        Xb.eli("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.eli.Os.DbA dbA = this.NU;
        if (dbA != null) {
            dbA.DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.DbA == null || !DbA(this.DbA.DbA) || eli(this.DbA.DbA)) {
            return;
        }
        if (this.Dfc) {
            this.Dfc = false;
            finish();
        } else if (this.DbA.qj.nro()) {
            finish();
        }
    }

    private boolean eli(ev evVar) {
        return evVar == null || evVar.Nvn() == 100.0f;
    }

    private boolean DbA(ev evVar) {
        if (evVar == null) {
            return false;
        }
        return dV.aGH().QX(String.valueOf(this.DbA.MGA));
    }
}

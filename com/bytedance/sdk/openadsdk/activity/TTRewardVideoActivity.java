package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.reward.du;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.ev;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.ujq;
import com.bytedance.sdk.openadsdk.core.widget.DbA;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.gG;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static String QX;
    private static String Xb;
    private static String aqO;
    private static String dV;
    private static com.bytedance.sdk.openadsdk.eli.ui.eli ev;
    private static String nGm;
    private String CMM;
    protected com.bytedance.sdk.openadsdk.eli.ui.eli Dfc;
    protected int NU;
    private String bf;
    protected int nn;
    private boolean ujq;
    private final AtomicBoolean Vy = new AtomicBoolean(false);
    private int gG = -1;

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean ev() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        ev = this.Dfc;
        if (this.Vy.get() && this.DbA != null) {
            this.DbA.DbA.nro();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (aqO == null) {
                aqO = ev.eli(this, "tt_reward_msg");
                dV = ev.eli(this, "tt_msgPlayable");
                nGm = ev.eli(this, "tt_negtiveBtnBtnText");
                QX = ev.eli(this, "tt_postiveBtnText");
                Xb = ev.eli(this, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            Xb.Os("TTAD.RVA", th.getMessage());
        }
        if (bundle == null || this.DbA == null || this.DbA.DbA == null || !this.DbA.DbA.Cp()) {
            return;
        }
        this.Vy.set(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void Os() {
        super.Os();
        if (this.Vy.get() || this.DbA == null) {
            return;
        }
        this.DbA.rn = new du(new du.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.du.eli
            public void eli() {
                if (TTRewardVideoActivity.this.Vy.get() || TTRewardVideoActivity.this.ujq) {
                    return;
                }
                TTRewardVideoActivity.this.Os(1);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.DbA == null || this.DbA.rn == null) {
            return;
        }
        this.DbA.rn.DbA();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void nGm() {
        com.bytedance.sdk.openadsdk.component.reward.view.aGH eli;
        super.nGm();
        if (this.DbA == null || (eli = this.DbA.ujq.eli()) == null) {
            return;
        }
        eli.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.ui() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.ui
            public void eli() {
                TTRewardVideoActivity.this.VM();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.DbA == null || this.DbA.rn == null) {
            return;
        }
        this.DbA.rn.eli();
    }

    protected void eli(String str) {
        eli(str, false, 0, "", 0, "");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        ev = null;
    }

    private void eli(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        cyF.Os(new com.bytedance.sdk.component.wC.wC("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.DbA(0).executeRewardVideoCallback(TTRewardVideoActivity.this.DbA.ikX, str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    Xb.Os("TTAD.RVA", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(Bundle bundle) {
        if (!com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            this.Dfc = Ue.eli().DbA();
        }
        if (this.Dfc != null || bundle == null) {
            return;
        }
        this.Dfc = ev;
        ev = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void aGH() {
        this.DbA.Cp.eli(null, TTAdDislikeToast.getSkipText());
        this.DbA.Cp.ui(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void CMM() {
        final View aAs = this.DbA.eU.aAs();
        if (aAs != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTRewardVideoActivity.this.DbA.qj.ujq() && TTRewardVideoActivity.this.DbA.aAs.get()) {
                        boolean NU = TTRewardVideoActivity.this.DbA.nro.NU();
                        TTRewardVideoActivity.this.DbA.qj.MGA(NU);
                        TTRewardVideoActivity.this.DbA.eU.MGA(8);
                        View view2 = aAs;
                        if (view2 instanceof com.bytedance.sdk.openadsdk.core.ui.aGH) {
                            ((com.bytedance.sdk.openadsdk.core.ui.aGH) view2).setImageResource(ev.aGH(TTRewardVideoActivity.this.DbA.FS, "tt_close_btn"));
                        }
                        TTRewardVideoActivity.this.DbA.jh.sendEmptyMessageDelayed(600, 5000L);
                        if (!com.bytedance.sdk.openadsdk.core.model.ev.Os(TTRewardVideoActivity.this.DbA.DbA)) {
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.ev.Os(TTRewardVideoActivity.this.DbA.DbA) && NU) {
                            return;
                        }
                    }
                    TTRewardVideoActivity.this.DbA.qj.Ue();
                    TTRewardVideoActivity.this.DbA.nro.du();
                    TTRewardVideoActivity.this.DbA.KM.MGA();
                    if (KM.aGH(TTRewardVideoActivity.this.DbA.DbA)) {
                        TTRewardVideoActivity.this.eli(true, true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            };
            aAs.setOnClickListener(onClickListener);
            aAs.setTag(aAs.getId(), onClickListener);
        }
        this.DbA.Cp.eli(new com.bytedance.sdk.openadsdk.component.reward.top.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void aGH(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view) {
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.eli(KM.Os(tTRewardVideoActivity.DbA.DbA), false);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view, String str) {
                com.bytedance.sdk.openadsdk.core.model.aGH UCq;
                com.bytedance.sdk.openadsdk.core.du.aGH eli;
                if (TTRewardVideoActivity.this.Os != null && TTRewardVideoActivity.this.Os.aGH() != null) {
                    TTRewardVideoActivity.this.Os.aGH().eli(TTRewardVideoActivity.this.DbA.tGZ);
                }
                TTRewardVideoActivity.this.DbA.tGZ = !TTRewardVideoActivity.this.DbA.tGZ;
                new Object[]{"rewarded_video", "will set is Mute " + TTRewardVideoActivity.this.DbA.tGZ + " mLastVolume=" + TTRewardVideoActivity.this.DbA.oWW.eli()};
                TTRewardVideoActivity.this.DbA.ev.eli(TTRewardVideoActivity.this.DbA.tGZ, str);
                if (!KM.nGm(TTRewardVideoActivity.this.DbA.DbA) || TTRewardVideoActivity.this.DbA.aAs.get()) {
                    TTRewardVideoActivity.this.DbA.qj.ui(TTRewardVideoActivity.this.DbA.tGZ);
                    TTRewardVideoActivity.this.DbA.gG.MGA(TTRewardVideoActivity.this.DbA.tGZ);
                    if (TTRewardVideoActivity.this.DbA.DbA == null || (UCq = TTRewardVideoActivity.this.DbA.DbA.UCq()) == null || (eli = UCq.eli()) == null) {
                        return;
                    }
                    if (TTRewardVideoActivity.this.DbA.tGZ) {
                        eli.wC(TTRewardVideoActivity.this.DbA.ev.nlS());
                    } else {
                        eli.FC(TTRewardVideoActivity.this.DbA.ev.nlS());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void DbA(View view) {
                TTRewardVideoActivity.this.DbA.GB.eli(TTRewardVideoActivity.this.Os);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final boolean z, boolean z2) {
        if (!z2 && this.ujq && this.DbA.aAs.get()) {
            if (KM.wC(this.DbA.DbA)) {
                this.DbA.qj.wC();
                return;
            } else if (KM.aAs(this.DbA.DbA)) {
                this.DbA.gG.dV();
                return;
            }
        }
        if (!dV.aGH().kb(String.valueOf(this.DbA.MGA))) {
            if (!z2 && this.DbA.aAs.get()) {
                if (KM.wC(this.DbA.DbA)) {
                    this.DbA.qj.wC();
                    return;
                } else if (KM.aAs(this.DbA.DbA)) {
                    this.DbA.gG.dV();
                    return;
                }
            }
            if (z) {
                finish();
                return;
            } else {
                Ue();
                return;
            }
        }
        if (this.Vy.get()) {
            if (this.DbA.aAs.get()) {
                if (KM.wC(this.DbA.DbA)) {
                    this.DbA.qj.wC();
                    return;
                } else if (KM.aAs(this.DbA.DbA)) {
                    this.DbA.gG.dV();
                    return;
                }
            }
            if (z) {
                finish();
                return;
            } else {
                Ue();
                return;
            }
        }
        if (KM.wC(this.DbA.DbA) && this.DbA.qj.du().getVisibility() == 0) {
            this.DbA.qj.wC();
            return;
        }
        if (KM.aAs(this.DbA.DbA) && this.DbA.qj.aAs().getVisibility() == 0) {
            this.DbA.gG.dV();
            return;
        }
        this.DbA.Xb.set(true);
        this.DbA.ev.bf();
        if (z) {
            this.DbA.gG.nn();
        }
        final com.bytedance.sdk.openadsdk.core.widget.DbA dbA = new com.bytedance.sdk.openadsdk.core.widget.DbA(this);
        this.Os.NU = dbA;
        if (z) {
            this.Os.NU.eli(dV).DbA(Xb).Os(nGm);
        } else {
            this.Os.NU.eli(aqO).DbA(QX).Os(nGm);
        }
        this.Os.NU.eli(new DbA.InterfaceC0204DbA() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.DbA.InterfaceC0204DbA
            public void eli() {
                TTRewardVideoActivity.this.DbA.ev.Xb();
                if (z) {
                    TTRewardVideoActivity.this.DbA.gG.ui(1000);
                }
                dbA.dismiss();
                TTRewardVideoActivity.this.DbA.Xb.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.DbA.InterfaceC0204DbA
            public void DbA() {
                dbA.dismiss();
                TTRewardVideoActivity.this.ujq = true;
                TTRewardVideoActivity.this.DbA.Xb.set(false);
                TTRewardVideoActivity.this.DbA.gG.MGA(Integer.MAX_VALUE);
                if (z) {
                    if (KM.dV(TTRewardVideoActivity.this.DbA.DbA)) {
                        if (KM.wC(TTRewardVideoActivity.this.DbA.DbA)) {
                            if (TTRewardVideoActivity.this.DbA.gG.eli()) {
                                TTRewardVideoActivity.this.DbA.gG.eli(5);
                                return;
                            } else {
                                TTRewardVideoActivity.this.DbA.qj.wC();
                                return;
                            }
                        }
                        TTRewardVideoActivity.this.DbA.KM.MGA();
                        if (TTRewardVideoActivity.this.DbA.gG.eli()) {
                            TTRewardVideoActivity.this.DbA.gG.eli(4);
                        }
                        TTRewardVideoActivity.this.finish();
                        return;
                    }
                    if (KM.MGA(TTRewardVideoActivity.this.DbA.DbA)) {
                        if (KM.aAs(TTRewardVideoActivity.this.DbA.DbA)) {
                            TTRewardVideoActivity.this.DbA.gG.dV();
                            return;
                        } else {
                            TTRewardVideoActivity.this.DbA.KM.MGA();
                            TTRewardVideoActivity.this.finish();
                            return;
                        }
                    }
                }
                TTRewardVideoActivity.this.Ue();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a1, code lost:
    
        if (r3.DbA.aqO.get() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Ue() {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        Dfc.eli eliVar = new Dfc.eli();
        eliVar.DbA(this.DbA.ev.nlS());
        eliVar.aGH(this.DbA.ev.gG());
        eliVar.Os(this.DbA.ev.aqO());
        eliVar.Os(3);
        eliVar.aGH(this.DbA.ev.Vy());
        eliVar.eli(this.DbA.ev.DbA());
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.DbA.ev.wC(), eliVar, this.DbA.ev.ui());
        ujq.Os(this.DbA.MGA);
        this.DbA.ev.eli("skip", false);
        if (this.DbA.Os) {
            if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(this.DbA.DbA)) {
                com.bytedance.sdk.openadsdk.component.reward.view.aGH eli2 = this.DbA.ujq.eli();
                if (eli2 != null && eli2.aGH == 0) {
                    finish();
                } else {
                    eli(true, 4);
                }
            } else {
                eli(true, 4);
            }
            if (com.bytedance.sdk.openadsdk.core.model.Xb.eli(this.DbA.DbA)) {
            }
            UCq = this.DbA.DbA.UCq();
            if (UCq != null && (eli = UCq.eli()) != null) {
                long nlS = this.DbA.ev.nlS();
                eli.MGA(nlS);
                eli.ui(nlS);
            }
            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.DbA.DbA, 5);
        }
        finish();
        UCq = this.DbA.DbA.UCq();
        if (UCq != null) {
            long nlS2 = this.DbA.ev.nlS();
            eli.MGA(nlS2);
            eli.ui(nlS2);
        }
        com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.DbA.DbA, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void eli(Intent intent) {
        super.eli(intent);
        this.bf = intent.getStringExtra("media_extra");
        this.CMM = intent.getStringExtra("user_id");
    }

    public boolean eli(long j, boolean z) {
        com.bytedance.sdk.openadsdk.aGH.kb kbVar = new com.bytedance.sdk.openadsdk.aGH.kb();
        kbVar.eli(System.currentTimeMillis(), 1.0f);
        this.DbA.ev.eli(this.DbA.eU.MGA(), kbVar);
        Os.eli eliVar = new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.7
            boolean eli;

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, int i) {
                if (this.eli) {
                    return;
                }
                this.eli = true;
                TTRewardVideoActivity.this.aGH.removeMessages(300);
                TTRewardVideoActivity.this.bf();
                TTRewardVideoActivity.this.ujq();
                TTRewardVideoActivity.this.DbA.ev.eli(j2, j2);
                TTRewardVideoActivity.this.DbA.QX.set(true);
                if (TTRewardVideoActivity.this.DbA.DbA.mm() == 36 && TTRewardVideoActivity.this.DbA.Os) {
                    TTRewardVideoActivity.this.DbA.Vy.Os().Os(TTRewardVideoActivity.this.DbA.DbA);
                    com.bytedance.sdk.openadsdk.utils.Dfc.DbA();
                }
                if (TTRewardVideoActivity.this.DbA.DbA.vOq()) {
                    TTRewardVideoActivity.this.DbA.DbA.FS(1);
                    TTRewardVideoActivity.this.DbA.eU.dV();
                }
                if (TTRewardVideoActivity.this.DbA.DbA.mm() == 21 && !TTRewardVideoActivity.this.DbA.DbA.nn()) {
                    TTRewardVideoActivity.this.DbA.DbA.aGH(true);
                    TTRewardVideoActivity.this.DbA.eU.dV();
                }
                TTRewardVideoActivity.this.nn = (int) (System.currentTimeMillis() / 1000);
                if (TTRewardVideoActivity.this.du && TTRewardVideoActivity.this.DbA.ujq.du()) {
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.Xb.aGH(TTRewardVideoActivity.this.DbA.DbA) || com.bytedance.sdk.openadsdk.core.model.Xb.DbA(TTRewardVideoActivity.this.DbA.DbA) || com.bytedance.sdk.openadsdk.core.model.Xb.ui(TTRewardVideoActivity.this.DbA.DbA)) {
                    TTRewardVideoActivity.this.eli(false, 5);
                    if (!com.bytedance.sdk.openadsdk.core.model.Xb.DbA(TTRewardVideoActivity.this.DbA.DbA) || TTRewardVideoActivity.this.DbA.GMY == null) {
                        return;
                    }
                    TTRewardVideoActivity.this.DbA.GMY.eli(0L);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.Xb.eli(TTRewardVideoActivity.this.DbA.DbA) && !TTRewardVideoActivity.this.DbA.aqO.get()) {
                    TTRewardVideoActivity.this.DbA.eli(true);
                    TTRewardVideoActivity.this.DbA.Cp.ui(true);
                    return;
                }
                if (TTRewardVideoActivity.this.DbA.Os) {
                    if (TTRewardVideoActivity.this.DbA.DbA.Za()) {
                        TTRewardVideoActivity.this.DbA.Cp.Os();
                        return;
                    }
                    TTRewardVideoActivity.this.eli(false, 5);
                    if (com.bytedance.sdk.openadsdk.core.model.ev.ui(TTRewardVideoActivity.this.DbA.DbA)) {
                        return;
                    }
                    TTRewardVideoActivity.this.DbA.ev.eli("skip", true);
                    return;
                }
                if (TTRewardVideoActivity.this.DbA.DbA.Za()) {
                    TTRewardVideoActivity.this.DbA.Cp.Os();
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.core.model.ev.ui(TTRewardVideoActivity.this.DbA.DbA)) {
                    TTRewardVideoActivity.this.DbA.ev.eli("skip", true);
                }
                TTRewardVideoActivity.this.finish();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void DbA(long j2, int i) {
                TTRewardVideoActivity.this.aGH.removeMessages(300);
                if (TTRewardVideoActivity.this.DbA.eU.Dfc != null) {
                    TTRewardVideoActivity.this.DbA.eU.Dfc.aAs();
                }
                if (TTRewardVideoActivity.this.DbA.ev.MGA()) {
                    TTRewardVideoActivity.this.Xb();
                    return;
                }
                TTRewardVideoActivity.this.DbA.ev.QX();
                TTRewardVideoActivity.this.ujq();
                if (TTRewardVideoActivity.this.DbA.Os) {
                    TTRewardVideoActivity.this.DbA.ev.eli(!TTRewardVideoActivity.this.DbA.ev.Cp() ? 1 : 0, 2);
                    TTRewardVideoActivity.this.eli(false, true, 3);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli() {
                TTRewardVideoActivity.this.aGH.removeMessages(300);
                TTRewardVideoActivity.this.bf();
                TTRewardVideoActivity.this.ujq();
                if (TTRewardVideoActivity.this.DbA.Os) {
                    TTRewardVideoActivity.this.DbA.ev.eli(!TTRewardVideoActivity.this.DbA.ev.Cp() ? 1 : 0, !TTRewardVideoActivity.this.DbA.ev.Cp() ? 1 : 0);
                    TTRewardVideoActivity.this.eli(false, true, 6);
                } else {
                    TTRewardVideoActivity.this.finish();
                }
                TTRewardVideoActivity.this.DbA.ev.QX();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, long j3) {
                if (!TTRewardVideoActivity.this.DbA.WfR && TTRewardVideoActivity.this.DbA.ev.MGA()) {
                    TTRewardVideoActivity.this.DbA.ev.bf();
                }
                if (TTRewardVideoActivity.this.DbA.aAs.get()) {
                    return;
                }
                TTRewardVideoActivity.this.aGH.removeMessages(300);
                if (j2 != TTRewardVideoActivity.this.DbA.ev.NU()) {
                    TTRewardVideoActivity.this.bf();
                }
                TTRewardVideoActivity.this.DbA.ev.eli(j2, j3);
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                long j4 = j2 / 1000;
                double d = j4;
                tTRewardVideoActivity.MGA = (int) (tTRewardVideoActivity.DbA.ev.cyF() - d);
                if (TTRewardVideoActivity.this.MGA >= 0) {
                    TTRewardVideoActivity.this.DbA.Cp.eli(String.valueOf(TTRewardVideoActivity.this.MGA), null);
                }
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                tTRewardVideoActivity2.MGA = (int) (tTRewardVideoActivity2.DbA.ev.cyF() - d);
                int i = (int) j4;
                int YO = TTRewardVideoActivity.this.DbA.DbA.YO();
                boolean z2 = YO >= 0;
                if ((TTRewardVideoActivity.this.DbA.Xb.get() || TTRewardVideoActivity.this.DbA.du.get()) && TTRewardVideoActivity.this.DbA.ev.MGA()) {
                    TTRewardVideoActivity.this.DbA.ev.bf();
                }
                TTRewardVideoActivity.this.DbA.eU.ui(i);
                TTRewardVideoActivity.this.DbA(j2, j3);
                if (TTRewardVideoActivity.this.MGA > 0) {
                    TTRewardVideoActivity.this.DbA.Cp.aGH(true);
                    if (z2 && i >= YO) {
                        TTRewardVideoActivity.this.DbA.eli(true);
                        TTRewardVideoActivity.this.DbA.Cp.eli(String.valueOf(TTRewardVideoActivity.this.MGA), TTAdDislikeToast.getSkipText());
                        TTRewardVideoActivity.this.DbA.Cp.ui(true);
                        return;
                    }
                    TTRewardVideoActivity.this.DbA.Cp.eli(String.valueOf(TTRewardVideoActivity.this.MGA), null);
                }
            }
        };
        this.DbA.ev.eli(eliVar);
        if (this.DbA.eU.Dfc != null) {
            this.DbA.eU.Dfc.eli(eliVar);
        }
        boolean eli = this.DbA.ev.eli(j, z, null, this.Os);
        if (eli && !z) {
            this.NU = (int) (System.currentTimeMillis() / 1000);
        }
        return eli;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void e_() {
        VM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VM() {
        Xb.eli("BVA", "invoke callback onAdClicked, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.eli.ui.eli eliVar = this.Dfc;
        if (eliVar != null) {
            eliVar.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final boolean z, final int i, final String str, final int i2, final String str2, final int i3) {
        Xb.eli("BVA", "invoke callback onRewardVerify: " + z + ", " + i + ", " + str + ", " + i2 + ", " + str2 + "; " + this);
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onRewardVerify", z, i, str, i2, str2);
            du.eli(this.DbA.DbA, z, i3);
        } else {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.8
                @Override // java.lang.Runnable
                public void run() {
                    if (TTRewardVideoActivity.this.Dfc != null) {
                        TTRewardVideoActivity.this.Dfc.eli(z, i, str, i2, str2);
                        du.eli(TTRewardVideoActivity.this.DbA.DbA, z, i3);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void nlS() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.eli.ui.eli eliVar = this.Dfc;
            if (eliVar != null) {
                eliVar.eli();
            }
        }
        if (Vy()) {
            this.DbA.ujq.nlS();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void dV() {
        ujq();
    }

    protected void ujq() {
        Os(0);
    }

    protected void Os(final int i) {
        if (this.Vy.get() || this.ujq) {
            return;
        }
        this.Vy.set(true);
        if (this.DbA.rn != null) {
            this.DbA.rn.Os();
        }
        if (dV.aGH().Dfc(String.valueOf(this.DbA.MGA))) {
            eli(true, this.DbA.DbA.BH(), this.DbA.DbA.qyC(), 0, "", i);
        } else {
            dV.Os().eli(GB(), new CMM.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.CMM.DbA
                public void eli(int i2, String str) {
                    TTRewardVideoActivity.this.eli(false, 0, "", i2, str, i);
                }

                @Override // com.bytedance.sdk.openadsdk.core.CMM.DbA
                public void eli(ev.DbA dbA) {
                    boolean z = dbA.DbA;
                    TTRewardVideoActivity.this.eli(dbA.DbA, dbA.Os.eli(), dbA.Os.DbA(), 0, "", i);
                }
            });
        }
    }

    private JSONObject GB() {
        JSONObject jSONObject = new JSONObject();
        int ujq = (int) this.DbA.ev.ujq();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("reward_name", this.DbA.DbA.qyC());
            jSONObject.put("reward_amount", this.DbA.DbA.BH());
            jSONObject.put("network", nGm.Os(getApplicationContext()));
            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, BuildConfig.VERSION_NAME);
            int ND = this.DbA.DbA.ND();
            String str = "unKnow";
            if (ND == 2) {
                str = dZ.DbA();
            } else if (ND == 1) {
                str = dZ.aGH();
            }
            jSONObject.put("user_agent", str);
            JSONObject sIY = this.DbA.DbA.sIY();
            sIY.put("gaid", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
            jSONObject.put("extra", sIY);
            jSONObject.put("media_extra", this.bf);
            jSONObject.put("video_duration", this.DbA.DbA.nY().MGA());
            jSONObject.put("play_start_ts", this.NU);
            jSONObject.put("play_end_ts", this.nn);
            jSONObject.put("duration", ujq);
            jSONObject.put("user_id", this.CMM);
            jSONObject.put("trans_id", gG.eli().replace("-", ""));
            return jSONObject;
        } catch (Throwable th) {
            Xb.eli("TTAD.RVA", "", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void MGA() {
        VM();
        this.DbA.DbA.oI();
        this.DbA.DbA.Os(true);
        if (com.bytedance.sdk.openadsdk.core.model.ev.ui(this.DbA.DbA)) {
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.DbA.DbA, this.DbA.ui, this.DbA.DbA.apl());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(int i) {
        if (i == 10000) {
            ujq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        oWW();
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("recycleRes");
        }
        this.Dfc = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        if (this.DbA != null) {
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("videoForceBreak", this.DbA.DbA);
        }
        oWW();
        super.finish();
    }

    private void oWW() {
        if (this.kb) {
            return;
        }
        this.kb = true;
        Xb.eli("BVA", "invoke callback onAdClose, ".concat(String.valueOf(this)));
        if (this.DbA != null && this.DbA.rn != null) {
            this.DbA.rn.aGH();
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdClose");
            return;
        }
        com.bytedance.sdk.openadsdk.eli.ui.eli eliVar = this.Dfc;
        if (eliVar != null) {
            eliVar.DbA();
        }
    }

    protected void eli(long j, long j2) {
        if (j2 <= 0) {
            return;
        }
        if (this.gG == -1) {
            this.gG = Math.min(100, this.DbA.DbA.tLO());
        }
        if (((j / 1000.0f) / j2) * 100.0f >= this.gG) {
            ujq();
        }
    }

    public void DbA(long j, long j2) {
        boolean z = false;
        if (this.DbA != null) {
            if (this.DbA.DbA.tLO() >= 0 && this.DbA.DbA.fbF() >= 0) {
                z = true;
            }
            if (z) {
                j2 = this.DbA.DbA.fbF();
            }
        }
        long j3 = j + (this.DbA.ow * 1000);
        if (z) {
            eli(j3, j2);
            return;
        }
        if (this.gG == -1) {
            this.gG = dV.aGH().gG(String.valueOf(this.DbA.MGA)).MGA;
        }
        if (j2 <= 0) {
            return;
        }
        if (j2 >= 30000 && j3 >= 27000) {
            ujq();
        } else if ((j3 * 100) / j2 >= this.gG) {
            ujq();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
    
        if (r1 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (((1.0d - (r8.MGA / r8.DbA.ev.cyF())) * 100.0d) >= r0) goto L8;
     */
    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void QX() {
        int i = dV.aGH().gG(String.valueOf(this.DbA.MGA)).MGA;
        boolean z = true;
        boolean z2 = false;
        if (!KM.nGm(this.DbA.DbA)) {
            boolean z3 = (1.0f - (this.DbA.gG.DbA() / ((float) this.DbA.DbA.oT()))) * 100.0f >= ((float) i);
            int eli = dV.aGH().eli(String.valueOf(this.DbA.MGA));
            if (eli == 0) {
                boolean MGA = this.DbA.qj.nlS().MGA();
                if (this.DbA.gG.Os()) {
                    MGA = true;
                }
                if (z3) {
                }
                z = false;
                z2 = z;
            } else if (eli == 1) {
                z2 = z3;
            }
        }
        if (z2) {
            ujq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void DbA(boolean z) {
        if (z) {
            ujq();
            return;
        }
        if ((1.0d - (this.MGA / this.DbA.ev.cyF())) * 100.0d >= dV.aGH().gG(String.valueOf(this.DbA.MGA)).MGA) {
            ujq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void f_() {
        Os(2);
    }
}

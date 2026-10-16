package com.bytedance.sdk.openadsdk.activity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.ujq;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA extends eli {
    int MGA;
    private boolean kb;
    private boolean wC;

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    protected boolean a_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void f_() {
    }

    public MGA(DbA dbA, ev evVar, int i, int i2, boolean z) {
        super(dbA, evVar, i, i2, z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli
    public void DbA() {
        if (!ev.ui(this.Os.DbA) && !this.Os.Os) {
            this.Os.Cp.eli(null, "X");
        } else {
            this.Os.Cp.eli(null, TTAdDislikeToast.getSkipText());
        }
        this.Os.Cp.ui(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.activity.wC
    public void aGH() {
        super.aGH();
        if (this.Os == null || !DbA(this.Os.DbA) || eli(this.Os.DbA)) {
            return;
        }
        if (this.kb) {
            this.kb = false;
            Uv();
        } else if (this.Os.qj.nro()) {
            Uv();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public String b_() {
        return "fullscreen_interstitial_ad";
    }

    private boolean eli(ev evVar) {
        return evVar == null || evVar.Nvn() == 100.0f;
    }

    private boolean DbA(ev evVar) {
        if (evVar == null) {
            return false;
        }
        return dV.aGH().QX(String.valueOf(this.Os.MGA));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli
    protected void ui() {
        final View aAs = this.Os.eU.aAs();
        if (aAs != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.MGA.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (MGA.this.Os.qj.ujq() && MGA.this.Os.aAs.get()) {
                        boolean NU = MGA.this.Os.nro.NU();
                        MGA.this.Os.qj.MGA(NU);
                        MGA.this.Os.eU.MGA(8);
                        MGA.this.Os.jh.sendEmptyMessageDelayed(600, 5000L);
                        if (!ev.Os(MGA.this.Os.DbA)) {
                            return;
                        }
                        if (ev.Os(MGA.this.Os.DbA) && NU) {
                            return;
                        }
                    }
                    MGA.this.Os.qj.Ue();
                    MGA.this.Os.nro.du();
                    MGA.this.Os.KM.MGA();
                    MGA.this.Uv();
                }
            };
            aAs.setOnClickListener(onClickListener);
            aAs.setTag(aAs.getId(), onClickListener);
        }
        this.Os.Cp.eli(new com.bytedance.sdk.openadsdk.component.reward.top.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.MGA.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void aGH(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view) {
                com.bytedance.sdk.openadsdk.core.du.aGH eli;
                if (KM.wC(MGA.this.Os.DbA) && (KM.dV(MGA.this.Os.DbA) || MGA.this.Os.aAs.get())) {
                    if (MGA.this.Os.gG.eli()) {
                        MGA.this.Os.gG.eli(5);
                        return;
                    } else {
                        MGA.this.Os.qj.wC();
                        return;
                    }
                }
                if (KM.dV(MGA.this.Os.DbA) || (Xb.eli(MGA.this.Os.DbA) && !MGA.this.Os.aqO.get())) {
                    if (!KM.wC(MGA.this.Os.DbA) && MGA.this.Os.gG.eli()) {
                        MGA.this.Os.gG.eli(4);
                    }
                    MGA.this.Uv();
                    return;
                }
                MGA.this.Os.ev.GB();
                Dfc.eli eliVar = new Dfc.eli();
                eliVar.DbA(MGA.this.Os.ev.nlS());
                eliVar.aGH(MGA.this.Os.ev.gG());
                eliVar.Os(MGA.this.Os.ev.aqO());
                eliVar.Os(3);
                eliVar.aGH(MGA.this.Os.ev.Vy());
                eliVar.eli(MGA.this.Os.ev.DbA());
                com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(MGA.this.Os.ev.wC(), eliVar, MGA.this.Os.ev.ui());
                ujq.Os(MGA.this.Os.MGA);
                MGA.this.Os.ev.eli("skip", false);
                MGA.this.Os.Cp.aGH(false);
                if (MGA.this.Os.Os) {
                    MGA.this.eli(true, 4);
                } else {
                    MGA.this.Uv();
                }
                if (MGA.this.Os.DbA != null && MGA.this.Os.DbA.UCq() != null && MGA.this.Os.ev != null && (eli = MGA.this.Os.DbA.UCq().eli()) != null) {
                    eli.MGA(MGA.this.Os.ev.nlS());
                    eli.ui(MGA.this.Os.ev.nlS());
                }
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(MGA.this.Os.DbA, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view, String str) {
                MGA.this.eli(str);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void DbA(View view) {
                MGA.this.c_();
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

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void c_() {
        this.Os.GB.eli(this.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public boolean d_() {
        return this.Os.tGZ;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void eli(String str) {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        this.Os.tGZ = !this.Os.tGZ;
        if (this.Os.ujq != null && this.Os.ujq.eli() != null) {
            this.Os.ujq.eli().setSoundMute(this.Os.tGZ);
        }
        if (this.DbA != null && this.DbA.aGH() != null) {
            this.DbA.aGH().eli(this.Os.tGZ);
        }
        this.Os.ev.eli(this.Os.tGZ, str);
        if (!KM.nGm(this.Os.DbA) || this.Os.aAs.get()) {
            this.Os.qj.ui(this.Os.tGZ);
            if (this.Os.DbA == null || (UCq = this.Os.DbA.UCq()) == null || (eli = UCq.eli()) == null) {
                return;
            }
            if (this.Os.tGZ) {
                eli.wC(this.Os.ev.nlS());
            } else {
                eli.FC(this.Os.ev.nlS());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public boolean eli(long j, boolean z) {
        com.bytedance.sdk.openadsdk.aGH.kb kbVar;
        this.Os.ujq.DbA(false);
        this.wC = false;
        if (this.FC.ui()) {
            if (this.Os.ujq != null && this.Os.ujq.eli() != null) {
                kbVar = this.Os.ujq.eli().getAdShowTime();
            } else {
                kbVar = new com.bytedance.sdk.openadsdk.aGH.kb();
            }
            if (this.DbA != null && (this.DbA instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.wC) && !this.Os.TfR) {
                this.Os.ev.eli(((com.bytedance.sdk.openadsdk.component.reward.DbA.wC) this.DbA).VM(), kbVar);
            } else {
                this.Os.ev.eli(this.Os.ujq.DbA(), kbVar);
            }
            HashMap hashMap = new HashMap();
            if (this.Os.ujq != null) {
                hashMap.put("dynamic_show_type", Integer.valueOf(this.Os.ujq.aAs()));
                JSONObject eli = this.Os.ujq.eli((JSONObject) null);
                if (eli != null) {
                    Iterator<String> keys = eli.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            hashMap.put(next, eli.get(next));
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
            this.Os.ev.eli(new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.MGA.3
                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void eli(long j2, int i) {
                    if (MGA.this.wC) {
                        return;
                    }
                    MGA.this.wC = true;
                    MGA.this.eli.removeMessages(300);
                    MGA.this.nGm();
                    MGA.this.Os.ev.eli(j2, j2);
                    MGA.this.Os.ujq.DbA(true);
                    if (MGA.this.Os.DbA.mm() == 36 && MGA.this.Os.Os) {
                        MGA.this.Os.Vy.Os().Os(MGA.this.Os.DbA);
                        com.bytedance.sdk.openadsdk.utils.Dfc.DbA();
                    }
                    if (MGA.this.Os.DbA.mm() == 21 && !MGA.this.Os.DbA.nn()) {
                        MGA.this.Os.DbA.aGH(true);
                        MGA.this.Os.eU.dV();
                    }
                    if (MGA.this.Os.rH) {
                        DbA.ui DbA = MGA.this.DbA(5);
                        DbA.ui = true;
                        MGA.this.aAs.eli(MGA.this, DbA);
                        return;
                    }
                    if (MGA.this.ui && MGA.this.Os.ujq.du()) {
                        return;
                    }
                    if (MGA.this.Os.Os) {
                        if (MGA.this.Os.DbA.Za()) {
                            if (MGA.this.Os.ujq.aAs() == 1) {
                                MGA.this.Os.Cp.Os();
                                return;
                            }
                            return;
                        } else {
                            MGA.this.eli(false, 5);
                            if (ev.ui(MGA.this.Os.DbA)) {
                                return;
                            }
                            MGA.this.Os.ev.eli("skip", true);
                            return;
                        }
                    }
                    if (ev.ui(MGA.this.Os.DbA)) {
                        MGA.this.Uv();
                        return;
                    }
                    if (MGA.this.Os.ujq == null || MGA.this.Os.ujq.eli() == null) {
                        return;
                    }
                    MGA.this.Os.ujq.eli().setTime("0", 0, 0, false);
                    if (MGA.this.Os.ujq.FC()) {
                        MGA.this.Os.Cp.eli("0", "X");
                        MGA.this.Os.Cp.ui(true);
                        MGA.this.Os.Cp.Os();
                    }
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void DbA(long j2, int i) {
                    MGA.this.eli.removeMessages(300);
                    if (MGA.this.Os.eU.Dfc != null) {
                        MGA.this.Os.eU.Dfc.aAs();
                    }
                    if (MGA.this.Os.ev.MGA()) {
                        MGA.this.wC();
                        return;
                    }
                    MGA.this.Os.ev.QX();
                    new Object[]{"fullscreen_interstitial_ad", "onError、、、、、、、、"};
                    MGA.this.Os.ujq.eli(true);
                    DbA dbA = MGA.this.aAs;
                    MGA mga = MGA.this;
                    dbA.eli(mga, mga.DbA(3));
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void eli() {
                    MGA.this.eli.removeMessages(300);
                    MGA.this.nGm();
                    new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                    DbA dbA = MGA.this.aAs;
                    MGA mga = MGA.this;
                    dbA.eli(mga, mga.DbA(6));
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void eli(long j2, long j3) {
                    if (!MGA.this.Os.WfR && MGA.this.Os.ev.MGA()) {
                        MGA.this.Os.ev.DbA(true);
                    }
                    if (MGA.this.Os.aAs.get()) {
                        return;
                    }
                    MGA.this.eli.removeMessages(300);
                    if (j2 != MGA.this.Os.ev.NU()) {
                        MGA.this.nGm();
                    }
                    if (MGA.this.Os.ev.MGA()) {
                        MGA.this.Os.ev.eli(j2, j3);
                        MGA mga = MGA.this;
                        long j4 = j2 / 1000;
                        mga.MGA = (int) (mga.Os.ev.cyF() - j4);
                        int i = (int) j4;
                        if ((MGA.this.Os.Xb.get() || MGA.this.Os.du.get()) && MGA.this.Os.ev.MGA()) {
                            MGA.this.Os.ev.bf();
                        }
                        if (MGA.this.Os.ujq != null && MGA.this.Os.ujq.eli() != null) {
                            MGA.this.Os.ujq.eli().setTime(String.valueOf(MGA.this.MGA), i, 0, false);
                            MGA.this.Os.ujq.eli().eli(j2, j3);
                        }
                        MGA.this.eli((j2 * 1.0f) / j3);
                        if (MGA.this.Os.ujq.FC() || MGA.this.Os.DbA.nie()) {
                            MGA.this.ui(i);
                            if (MGA.this.MGA >= 0) {
                                MGA.this.Os.Cp.aGH(true);
                                MGA.this.Os.Cp.eli(String.valueOf(MGA.this.MGA), null);
                            }
                        }
                    }
                }
            });
            return this.Os.ev.eli(j, z, hashMap, this.DbA);
        }
        com.bytedance.sdk.openadsdk.aGH.kb kbVar2 = new com.bytedance.sdk.openadsdk.aGH.kb();
        kbVar2.eli(System.currentTimeMillis(), 1.0f);
        if (this.DbA != null && (this.DbA instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.wC)) {
            this.Os.ev.eli(((com.bytedance.sdk.openadsdk.component.reward.DbA.wC) this.DbA).VM(), kbVar2);
        } else {
            this.Os.ev.eli(this.Os.eU.MGA(), kbVar2);
        }
        Os.eli eliVar = new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.MGA.4
            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, int i) {
                if (MGA.this.wC) {
                    return;
                }
                MGA.this.wC = true;
                MGA.this.eli.removeMessages(300);
                MGA.this.nGm();
                MGA.this.Os.ev.eli(j2, j2);
                MGA.this.Os.QX.set(true);
                if (MGA.this.Os.DbA.vOq()) {
                    MGA.this.Os.DbA.FS(1);
                    MGA.this.Os.eU.dV();
                }
                if (MGA.this.Os.DbA.mm() == 21 && !MGA.this.Os.DbA.nn()) {
                    MGA.this.Os.DbA.aGH(true);
                    MGA.this.Os.eU.dV();
                }
                if (MGA.this.Os.rH) {
                    DbA.ui DbA = MGA.this.DbA(5);
                    DbA.ui = true;
                    MGA.this.aAs.eli(MGA.this, DbA);
                    return;
                }
                if (MGA.this.ui && MGA.this.Os.ujq.du()) {
                    return;
                }
                if (MGA.this.Os.Os) {
                    if (MGA.this.Os.DbA.Za()) {
                        MGA.this.Os.Cp.Os();
                        return;
                    }
                    MGA.this.eli(false, 5);
                    if (Xb.DbA(MGA.this.Os.DbA) && MGA.this.Os.GMY != null) {
                        MGA.this.Os.GMY.eli(0L);
                    }
                    if (ev.ui(MGA.this.Os.DbA)) {
                        return;
                    }
                    MGA.this.Os.ev.eli("skip", true);
                    return;
                }
                if (MGA.this.Os.DbA.Za()) {
                    MGA.this.Os.Cp.Os();
                    return;
                }
                if (!ev.ui(MGA.this.Os.DbA)) {
                    MGA.this.Os.ev.eli("skip", true);
                }
                MGA.this.Uv();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void DbA(long j2, int i) {
                MGA.this.eli.removeMessages(300);
                if (MGA.this.Os.eU.Dfc != null) {
                    MGA.this.Os.eU.Dfc.aAs();
                }
                if (MGA.this.Os.ev.MGA()) {
                    MGA.this.wC();
                    return;
                }
                MGA.this.Os.ev.QX();
                DbA dbA = MGA.this.aAs;
                MGA mga = MGA.this;
                dbA.eli(mga, mga.DbA(3));
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli() {
                MGA.this.eli.removeMessages(300);
                MGA.this.nGm();
                new Object[]{"fullscreen_interstitial_ad", "onTimeOut、、、、、、、、"};
                DbA dbA = MGA.this.aAs;
                MGA mga = MGA.this;
                dbA.eli(mga, mga.DbA(6));
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, long j3) {
                if (!MGA.this.Os.WfR && MGA.this.Os.ev.MGA()) {
                    MGA.this.Os.ev.DbA(true);
                }
                if (MGA.this.Os.aAs.get()) {
                    return;
                }
                MGA.this.eli.removeMessages(300);
                if (j2 != MGA.this.Os.ev.NU()) {
                    MGA.this.nGm();
                }
                MGA.this.Os.ev.eli(j2, j3);
                MGA mga = MGA.this;
                long j4 = j2 / 1000;
                mga.MGA = (int) (mga.Os.ev.cyF() - j4);
                int i = (int) j4;
                if ((MGA.this.Os.Xb.get() || MGA.this.Os.du.get()) && MGA.this.Os.ev.MGA()) {
                    MGA.this.Os.ev.bf();
                }
                MGA.this.ui(i);
                MGA.this.eli((j2 * 1.0f) / j3);
                if (MGA.this.MGA >= 0) {
                    MGA.this.Os.Cp.eli(String.valueOf(MGA.this.MGA), null);
                }
            }
        };
        this.Os.ev.eli(eliVar);
        if (this.Os.eU.Dfc != null) {
            this.Os.eU.Dfc.eli(eliVar);
        }
        return this.Os.ev.eli(j, z, null, this.DbA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(int i) {
        int Fxk = this.Os.DbA.Fxk();
        if (!dV.aGH().ui(String.valueOf(this.Os.MGA)) || (!ev.ui(this.Os.DbA) && !this.Os.Os)) {
            if (i >= Fxk) {
                if (!this.Os.qyC) {
                    this.Os.eli(true);
                }
                DbA();
                return;
            }
            return;
        }
        if (!this.Os.qyC) {
            this.Os.eli(true);
        }
        if (i <= Fxk) {
            MGA(Fxk - i);
            this.Os.Cp.ui(false);
        } else {
            DbA();
        }
    }

    private void MGA(int i) {
        this.Os.Cp.eli(null, new SpannableStringBuilder(String.format(com.bytedance.sdk.component.utils.ev.eli(dV.eli(), "tt_skip_ad_time_text"), Integer.valueOf(i))));
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void e_() {
        if (this.Os.DbA.Nvn() != 100.0f) {
            this.kb = true;
        }
        Za();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli
    protected void aAs() {
        jh();
        if (this.FC.ui()) {
            this.Os.ujq.nlS();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void cyF() {
        super.cyF();
        this.wC = false;
        this.Os.ujq.DbA(false);
        this.Os.ev.FS();
    }
}

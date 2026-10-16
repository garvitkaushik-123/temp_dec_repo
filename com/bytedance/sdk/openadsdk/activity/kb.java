package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.ujq;
import com.bytedance.sdk.openadsdk.core.widget.DbA;
import com.bytedance.sdk.openadsdk.utils.Dfc;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb extends eli {
    private static String CMM;
    private static String Vy;
    private static String bf;
    private static String ev;
    private static String gG;
    protected int MGA;
    private boolean Ue;
    protected int kb;
    private int ujq;
    int wC;

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void DbA(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    protected boolean a_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(Bundle bundle) {
    }

    public kb(DbA dbA, ev evVar, int i, int i2, boolean z) {
        super(dbA, evVar, i, i2, z);
        this.ujq = -1;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.activity.wC
    public void eli(Activity activity, DbA.ui uiVar) {
        super.eli(activity, uiVar);
        if (com.bytedance.sdk.component.utils.DbA.eli(activity)) {
            return;
        }
        Intent intent = activity.getIntent();
        this.aqO = intent.getStringExtra("media_extra");
        this.Dfc = intent.getStringExtra("user_id");
        try {
            if (Vy == null) {
                Vy = com.bytedance.sdk.component.utils.ev.eli(this.Os.FS, "tt_reward_msg");
                bf = com.bytedance.sdk.component.utils.ev.eli(this.Os.FS, "tt_msgPlayable");
                ev = com.bytedance.sdk.component.utils.ev.eli(this.Os.FS, "tt_negtiveBtnBtnText");
                gG = com.bytedance.sdk.component.utils.ev.eli(this.Os.FS, "tt_postiveBtnText");
                CMM = com.bytedance.sdk.component.utils.ev.eli(this.Os.FS, "tt_postiveBtnTextPlayable");
            }
        } catch (Throwable th) {
            Xb.Os("TTAD.RewardAdScene", th.getMessage());
        }
        if (this.Os == null || this.aAs == null) {
            return;
        }
        this.Os.rn = this.aAs.eli;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public String b_() {
        return "rewarded_video";
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli
    protected void DbA() {
        this.Os.Cp.eli(null, TTAdDislikeToast.getSkipText());
        this.Os.Cp.ui(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli
    protected void ui() {
        final View aAs = this.Os.eU.aAs();
        if (aAs != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.kb.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (kb.this.Os.qj.ujq() && kb.this.Os.aAs.get()) {
                        boolean NU = kb.this.Os.nro.NU();
                        kb.this.Os.qj.MGA(NU);
                        kb.this.Os.eU.MGA(8);
                        kb.this.Os.jh.sendEmptyMessageDelayed(600, 5000L);
                        if (!ev.Os(kb.this.Os.DbA)) {
                            return;
                        }
                        if (ev.Os(kb.this.Os.DbA) && NU) {
                            return;
                        }
                    }
                    kb.this.Os.qj.Ue();
                    kb.this.Os.nro.du();
                    kb.this.Os.KM.MGA();
                    if (KM.aGH(kb.this.Os.DbA)) {
                        kb.this.eli(true, true, (Runnable) null);
                    } else {
                        kb.this.Uv();
                    }
                }
            };
            aAs.setOnClickListener(onClickListener);
            aAs.setTag(aAs.getId(), onClickListener);
        }
        this.Os.Cp.eli(new com.bytedance.sdk.openadsdk.component.reward.top.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.kb.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void aGH(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view) {
                kb kbVar = kb.this;
                kbVar.eli(KM.Os(kbVar.Os.DbA), false, (Runnable) null);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void eli(View view, String str) {
                kb.this.eli(str);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.DbA
            public void DbA(View view) {
                kb.this.c_();
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
    public void eli(String str) {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        if (this.DbA != null && this.DbA.aGH() != null) {
            this.DbA.aGH().eli(this.Os.tGZ);
        }
        this.Os.tGZ = !this.Os.tGZ;
        if (this.Os.ujq != null && this.Os.ujq.eli() != null) {
            this.Os.ujq.eli().setSoundMute(this.Os.tGZ);
        }
        new Object[]{"rewarded_video", "will set is Mute " + this.Os.tGZ + " mLastVolume=" + this.Os.oWW.eli()};
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

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public boolean d_() {
        return this.Os.tGZ;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(int i) {
        if (i == 10000) {
            ikX();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public boolean eli(long j, boolean z) {
        com.bytedance.sdk.openadsdk.aGH.kb kbVar;
        this.Os.ujq.DbA(false);
        this.Ue = false;
        if (this.FC.ui()) {
            if (this.Os.ujq != null && this.Os.ujq.eli() != null) {
                kbVar = this.Os.ujq.eli().getAdShowTime();
            } else {
                kbVar = new com.bytedance.sdk.openadsdk.aGH.kb();
            }
            this.Os.ev.eli(this.Os.ujq.DbA(), kbVar);
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
            this.Os.ev.eli(new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.kb.3
                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void eli(long j2, int i) {
                    if (kb.this.Ue) {
                        return;
                    }
                    kb.this.Ue = true;
                    kb.this.eli.removeMessages(300);
                    kb.this.nGm();
                    kb.this.Os.ev.eli(j2, j2);
                    kb.this.Os.ujq.DbA(true);
                    kb.this.MGA = (int) (System.currentTimeMillis() / 1000);
                    if (!kb.this.Os.rH) {
                        kb.this.ikX();
                    }
                    if (kb.this.Os.DbA.mm() == 36 && kb.this.Os.Os) {
                        kb.this.Os.Vy.Os().Os(kb.this.Os.DbA);
                        Dfc.DbA();
                    }
                    if (kb.this.Os.DbA.mm() == 21 && !kb.this.Os.DbA.nn()) {
                        kb.this.Os.DbA.aGH(true);
                        kb.this.Os.eU.dV();
                    }
                    if (kb.this.Os.rH) {
                        DbA dbA = kb.this.aAs;
                        kb kbVar2 = kb.this;
                        dbA.eli(kbVar2, kbVar2.DbA(5));
                        return;
                    }
                    if (kb.this.ui && kb.this.Os.ujq.du()) {
                        return;
                    }
                    if (kb.this.Os.Os) {
                        if (kb.this.Os.DbA.Za()) {
                            if (kb.this.Os.ujq.aAs() == 1) {
                                kb.this.Os.Cp.Os();
                                return;
                            }
                            return;
                        } else {
                            kb.this.eli(false, 5);
                            if (ev.ui(kb.this.Os.DbA)) {
                                return;
                            }
                            kb.this.Os.ev.eli("skip", true);
                            return;
                        }
                    }
                    if (kb.this.Os.DbA.Za()) {
                        if (kb.this.Os.ujq.aAs() == 1) {
                            kb.this.Os.Cp.Os();
                        }
                    } else {
                        if (!ev.ui(kb.this.Os.DbA)) {
                            kb.this.Os.ev.eli("skip", true);
                        }
                        kb.this.Uv();
                    }
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void DbA(long j2, int i) {
                    kb.this.eli.removeMessages(300);
                    if (kb.this.Os.eU.Dfc != null) {
                        kb.this.Os.eU.Dfc.aAs();
                    }
                    if (kb.this.Os.ev.MGA()) {
                        kb.this.wC();
                        return;
                    }
                    if (!kb.this.Os.rH) {
                        kb.this.ikX();
                    }
                    kb.this.Os.ev.QX();
                    kb.this.Os.ujq.eli(true);
                    DbA dbA = kb.this.aAs;
                    kb kbVar2 = kb.this;
                    dbA.eli(kbVar2, kbVar2.DbA(3));
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void eli() {
                    kb.this.eli.removeMessages(300);
                    kb.this.nGm();
                    if (!kb.this.Os.rH) {
                        kb.this.ikX();
                    }
                    DbA dbA = kb.this.aAs;
                    kb kbVar2 = kb.this;
                    dbA.eli(kbVar2, kbVar2.DbA(6));
                }

                @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
                public void eli(long j2, long j3) {
                    if (!kb.this.Os.WfR && kb.this.Os.ev.MGA()) {
                        kb.this.Os.ev.DbA(true);
                    }
                    if (kb.this.Os.aAs.get()) {
                        return;
                    }
                    kb.this.eli.removeMessages(300);
                    if (j2 != kb.this.Os.ev.NU()) {
                        kb.this.nGm();
                    }
                    if (kb.this.Os.ev.MGA()) {
                        kb.this.Os.ev.eli(j2, j3);
                        int YO = kb.this.FC.YO();
                        boolean z2 = kb.this.Os.ujq.FC() && YO != -1 && YO >= 0;
                        kb kbVar2 = kb.this;
                        long j4 = j2 / 1000;
                        kbVar2.wC = (int) (kbVar2.Os.ev.cyF() - j4);
                        int i = (int) j4;
                        if ((kb.this.Os.Xb.get() || kb.this.Os.du.get()) && kb.this.Os.ev.MGA()) {
                            kb.this.Os.ev.bf();
                        }
                        if (kb.this.wC >= 0) {
                            kb.this.Os.Cp.eli(String.valueOf(kb.this.wC), null);
                        }
                        kb.this.Os.eU.ui(i);
                        kb.this.eli(j2, j3);
                        if (kb.this.Os.ujq != null && kb.this.Os.ujq.eli() != null) {
                            kb.this.Os.ujq.eli().setTime(String.valueOf(kb.this.wC), i, 0, false);
                            kb.this.Os.ujq.eli().eli(j2, j3);
                        }
                        kb.this.eli((j2 * 1.0f) / j3);
                        if (kb.this.wC > 0) {
                            if (z2 && i >= YO && kb.this.Os.DbA.mm() != 5) {
                                kb.this.Os.eli(true);
                                kb.this.Os.Cp.eli(String.valueOf(kb.this.wC), TTAdDislikeToast.getSkipText());
                                kb.this.Os.Cp.ui(true);
                                return;
                            }
                            kb.this.Os.Cp.eli(String.valueOf(kb.this.wC), null);
                        }
                    }
                }
            });
            boolean eli2 = this.Os.ev.eli(j, z, hashMap, this.DbA);
            if (eli2 && !z) {
                this.kb = (int) (System.currentTimeMillis() / 1000);
            }
            return eli2;
        }
        com.bytedance.sdk.openadsdk.aGH.kb kbVar2 = new com.bytedance.sdk.openadsdk.aGH.kb();
        kbVar2.eli(System.currentTimeMillis(), 1.0f);
        this.Os.ev.eli(this.Os.eU.MGA(), kbVar2);
        Os.eli eliVar = new Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.kb.4
            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, int i) {
                if (kb.this.Ue) {
                    return;
                }
                kb.this.Ue = true;
                kb.this.eli.removeMessages(300);
                kb.this.nGm();
                if (!kb.this.Os.rH) {
                    kb.this.ikX();
                }
                kb.this.Os.ev.eli(j2, j2);
                kb.this.Os.QX.set(true);
                if (kb.this.Os.DbA.vOq()) {
                    kb.this.Os.DbA.FS(1);
                    kb.this.Os.eU.dV();
                }
                if (kb.this.Os.DbA.mm() == 21 && !kb.this.Os.DbA.nn()) {
                    kb.this.Os.DbA.aGH(true);
                    kb.this.Os.eU.dV();
                }
                kb.this.MGA = (int) (System.currentTimeMillis() / 1000);
                if (kb.this.Os.rH) {
                    DbA.ui DbA = kb.this.DbA(5);
                    DbA.ui = true;
                    kb.this.aAs.eli(kb.this, DbA);
                    return;
                }
                if (kb.this.ui && kb.this.Os.ujq.du()) {
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.Xb.aGH(kb.this.Os.DbA) || com.bytedance.sdk.openadsdk.core.model.Xb.DbA(kb.this.Os.DbA) || com.bytedance.sdk.openadsdk.core.model.Xb.ui(kb.this.Os.DbA)) {
                    kb.this.eli(false, 5);
                    if (!com.bytedance.sdk.openadsdk.core.model.Xb.DbA(kb.this.Os.DbA) || kb.this.Os.GMY == null) {
                        return;
                    }
                    kb.this.Os.GMY.eli(0L);
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.model.Xb.eli(kb.this.Os.DbA) && !kb.this.Os.aqO.get()) {
                    kb.this.Os.eli(true);
                    kb.this.Os.Cp.ui(true);
                    return;
                }
                if (kb.this.Os.Os) {
                    if (kb.this.Os.DbA.Za()) {
                        kb.this.Os.Cp.Os();
                        return;
                    }
                    kb.this.eli(false, 5);
                    if (ev.ui(kb.this.Os.DbA)) {
                        return;
                    }
                    kb.this.Os.ev.eli("skip", true);
                    return;
                }
                if (kb.this.Os.DbA.Za()) {
                    kb.this.Os.Cp.Os();
                    return;
                }
                if (!ev.ui(kb.this.Os.DbA)) {
                    kb.this.Os.ev.eli("skip", true);
                }
                kb.this.Uv();
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void DbA(long j2, int i) {
                kb.this.eli.removeMessages(300);
                if (kb.this.Os.eU.Dfc != null) {
                    kb.this.Os.eU.Dfc.aAs();
                }
                if (kb.this.Os.ev.MGA()) {
                    kb.this.wC();
                    return;
                }
                kb.this.Os.ev.QX();
                if (!kb.this.Os.rH) {
                    kb.this.ikX();
                }
                DbA dbA = kb.this.aAs;
                kb kbVar3 = kb.this;
                dbA.eli(kbVar3, kbVar3.DbA(3));
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli() {
                kb.this.eli.removeMessages(300);
                kb.this.nGm();
                if (!kb.this.Os.rH) {
                    kb.this.ikX();
                }
                DbA dbA = kb.this.aAs;
                kb kbVar3 = kb.this;
                dbA.eli(kbVar3, kbVar3.DbA(6));
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
            public void eli(long j2, long j3) {
                if (!kb.this.Os.WfR && kb.this.Os.ev.MGA()) {
                    kb.this.Os.ev.DbA(true);
                }
                if (kb.this.Os.aAs.get()) {
                    return;
                }
                kb.this.eli.removeMessages(300);
                if (j2 != kb.this.Os.ev.NU()) {
                    kb.this.nGm();
                }
                kb.this.Os.ev.eli(j2, j3);
                kb kbVar3 = kb.this;
                long j4 = j2 / 1000;
                double d = j4;
                kbVar3.wC = (int) (kbVar3.Os.ev.cyF() - d);
                if (kb.this.wC >= 0) {
                    kb.this.Os.Cp.eli(String.valueOf(kb.this.wC), null);
                }
                kb kbVar4 = kb.this;
                kbVar4.wC = (int) (kbVar4.Os.ev.cyF() - d);
                int i = (int) j4;
                int YO = kb.this.FC.YO();
                boolean z2 = YO >= 0;
                if ((kb.this.Os.Xb.get() || kb.this.Os.du.get()) && kb.this.Os.ev.MGA()) {
                    kb.this.Os.ev.bf();
                }
                kb.this.Os.eU.ui(i);
                kb.this.eli(j2, j3);
                kb.this.eli((j2 * 1.0f) / j3);
                if (kb.this.wC > 0) {
                    kb.this.Os.Cp.aGH(true);
                    if (z2 && i >= YO) {
                        kb.this.Os.eli(true);
                        kb.this.Os.Cp.eli(String.valueOf(kb.this.wC), TTAdDislikeToast.getSkipText());
                        kb.this.Os.Cp.ui(true);
                        return;
                    }
                    kb.this.Os.Cp.eli(String.valueOf(kb.this.wC), null);
                }
            }
        };
        this.Os.ev.eli(eliVar);
        if (this.Os.eU.Dfc != null) {
            this.Os.eU.Dfc.eli(eliVar);
        }
        boolean eli3 = this.Os.ev.eli(j, z, null, this.DbA);
        if (eli3 && !z) {
            this.kb = (int) (System.currentTimeMillis() / 1000);
        }
        return eli3;
    }

    public void eli(long j, long j2) {
        if (this.Os.rH) {
            return;
        }
        if (this.FC != null && this.FC.tLO() >= 0 && this.FC.fbF() >= 0) {
            DbA(j, this.FC.fbF());
            return;
        }
        if (j2 <= 0) {
            return;
        }
        long j3 = j + (this.Os.ow * 1000);
        if (this.ujq == -1) {
            this.ujq = dV.aGH().gG(String.valueOf(this.Os.MGA)).MGA;
        }
        if (j2 >= 30000 && j3 >= 27000) {
            ikX();
        } else if ((j3 * 100) / j2 >= this.ujq) {
            ikX();
        }
    }

    protected void DbA(long j, long j2) {
        if (j2 <= 0) {
            return;
        }
        if (this.ujq == -1) {
            this.ujq = Math.min(100, this.FC.tLO());
        }
        if (((j / 1000.0f) / j2) * 100.0f >= this.ujq) {
            ikX();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void e_() {
        Za();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli
    protected void aAs() {
        jh();
        if (this.FC.ui()) {
            this.Os.ujq.nlS();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void dV() {
        ikX();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
    
        if (r1 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003d, code lost:
    
        if (((1.0d - (r8.wC / r8.Os.ev.cyF())) * 100.0d) >= r0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
    
        r2 = true;
     */
    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.activity.wC, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void QX() {
        if (!this.FC.Txb()) {
            return;
        }
        int i = dV.aGH().gG(String.valueOf(this.Os.MGA)).MGA;
        boolean z = false;
        if (!KM.nGm(this.Os.DbA)) {
            boolean z2 = (1.0f - (this.Os.gG.DbA() / ((float) this.Os.DbA.oT()))) * 100.0f >= ((float) i);
            int eli = dV.aGH().eli(String.valueOf(this.Os.MGA));
            if (eli == 0) {
                boolean MGA = this.Os.qj.nlS().MGA();
                if (this.Os.gG.Os()) {
                    MGA = true;
                }
                if (z2) {
                }
            } else if (eli == 1) {
                z = z2;
            }
            if (z) {
                ikX();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void f_() {
        aGH(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(final boolean z, boolean z2, final Runnable runnable) {
        if (!z2 && this.aAs.FC().getBoolean("user_has_give_up_reward", false) && (KM.wC(this.Os.DbA) || runnable != null)) {
            if (runnable == null) {
                TfR();
            }
            return false;
        }
        if (!dV.aGH().kb(String.valueOf(this.Os.MGA))) {
            if (runnable == null) {
                if (z) {
                    Uv();
                    return false;
                }
                TfR();
            }
            return false;
        }
        if (this.aAs.FC().getBoolean("reward_verify", false)) {
            if (runnable == null) {
                if (KM.wC(this.Os.DbA)) {
                    TfR();
                    return false;
                }
                if (z) {
                    Uv();
                    return false;
                }
                TfR();
            }
            return false;
        }
        this.Os.Xb.set(true);
        this.Os.ev.bf();
        if (z) {
            this.Os.gG.nn();
        }
        final com.bytedance.sdk.openadsdk.core.widget.DbA dbA = new com.bytedance.sdk.openadsdk.core.widget.DbA(SSo());
        this.DbA.NU = dbA;
        if (z) {
            this.DbA.NU.eli(bf).DbA(CMM).Os(ev);
        } else {
            this.DbA.NU.eli(Vy).DbA(gG).Os(ev);
        }
        this.DbA.NU.eli(new DbA.InterfaceC0204DbA() { // from class: com.bytedance.sdk.openadsdk.activity.kb.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.DbA.InterfaceC0204DbA
            public void eli() {
                kb.this.Os.ev.Xb();
                if (z) {
                    kb.this.Os.gG.ui(1000);
                }
                dbA.dismiss();
                kb.this.Os.Xb.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.DbA.InterfaceC0204DbA
            public void DbA() {
                dbA.dismiss();
                kb.this.aAs.FC().putBoolean("user_has_give_up_reward", true);
                kb.this.Os.Xb.set(false);
                kb.this.Os.gG.MGA(Integer.MAX_VALUE);
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                if (!z) {
                    kb.this.TfR();
                    return;
                }
                if (KM.wC(kb.this.Os.DbA)) {
                    if (!kb.this.Os.gG.eli()) {
                        kb.this.TfR();
                        return;
                    } else {
                        kb.this.Os.gG.eli(5);
                        return;
                    }
                }
                kb.this.Os.KM.MGA();
                if (kb.this.Os.gG.eli()) {
                    kb.this.Os.gG.eli(4);
                }
                kb.this.Uv();
            }
        }).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0088, code lost:
    
        if (r3.Os.aqO.get() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void TfR() {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        this.Os.ev.GB();
        Dfc.eli eliVar = new Dfc.eli();
        eliVar.DbA(this.Os.ev.nlS());
        eliVar.aGH(this.Os.ev.gG());
        eliVar.Os(this.Os.ev.aqO());
        eliVar.Os(3);
        eliVar.aGH(this.Os.ev.Vy());
        eliVar.eli(this.Os.ev.DbA());
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.Os.ev.wC(), eliVar, this.Os.ev.ui());
        ujq.Os(this.Os.MGA);
        this.Os.ev.eli("skip", false);
        if (this.Os.Os) {
            eli(true, 4);
            if (com.bytedance.sdk.openadsdk.core.model.Xb.eli(this.Os.DbA)) {
            }
            UCq = this.Os.DbA.UCq();
            if (UCq != null && (eli = UCq.eli()) != null) {
                long nlS = this.Os.ev.nlS();
                eli.MGA(nlS);
                eli.ui(nlS);
            }
            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.Os.DbA, 5);
        }
        Uv();
        UCq = this.Os.DbA.UCq();
        if (UCq != null) {
            long nlS2 = this.Os.ev.nlS();
            eli.MGA(nlS2);
            eli.ui(nlS2);
        }
        com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.Os.DbA, 5);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(final String str, final JSONObject jSONObject) {
        if ("skipToNextAd".equals(str) && this.Os.yKf != null && this.aAs.Xb() == null && eli(KM.Os(this.Os.DbA), false, new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.kb.6
            @Override // java.lang.Runnable
            public void run() {
                kb.super.eli(str, jSONObject);
            }
        })) {
            return;
        }
        super.eli(str, jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.wC
    public void cyF() {
        super.cyF();
        this.Ue = false;
        this.Os.ujq.DbA(false);
        this.Os.ev.FS();
    }
}

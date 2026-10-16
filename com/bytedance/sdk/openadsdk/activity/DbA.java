package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.sdk.openadsdk.component.reward.NU;
import com.bytedance.sdk.openadsdk.component.reward.du;
import com.bytedance.sdk.openadsdk.component.reward.eli.nlS;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static com.bytedance.sdk.openadsdk.eli.ui.eli DbA;
    private static com.bytedance.sdk.openadsdk.eli.Os.DbA Os;
    private Bundle Dfc;
    private final boolean FC;
    private final com.bytedance.sdk.openadsdk.nlS.FC MGA;
    private Activity NU;
    private boolean Xb;
    private final boolean aAs;
    private final ev aGH;
    private boolean aqO;
    private boolean dV;
    private com.bytedance.sdk.openadsdk.activity.Os du;
    public du eli;
    private com.bytedance.sdk.openadsdk.eli.ui.eli kb;
    private Runnable nGm;
    private final boolean nlS;
    private int nn;
    private com.bytedance.sdk.openadsdk.eli.Os.DbA wC;
    private final Bundle ui = new Bundle();
    private final nlS.DbA QX = new nlS.DbA();

    public DbA(Activity activity, ev evVar) {
        this.aGH = evVar;
        this.NU = activity;
        this.MGA = new com.bytedance.sdk.openadsdk.nlS.FC(activity.getApplicationContext());
        boolean dZ = evVar.dZ();
        this.FC = dZ;
        this.aAs = dZ && 39 == evVar.mm();
        this.nlS = dZ && 40 == evVar.mm();
        int mm = evVar.mm();
        if (mm == 43 || mm == 44) {
            this.du = new com.bytedance.sdk.openadsdk.activity.aGH(this.NU, evVar, this);
        } else {
            this.du = new FC(this.NU, evVar, this);
        }
        this.du.eli();
        ujq();
    }

    public boolean eli() {
        return this.nlS;
    }

    private void ujq() {
        if (this.aGH.Txb()) {
            this.eli = new du(new du.eli() { // from class: com.bytedance.sdk.openadsdk.activity.DbA.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.du.eli
                public void eli() {
                    wC wC;
                    if (DbA.this.FC().getBoolean("reward_verify", false) || DbA.this.NU() || DbA.this.FC().getBoolean("user_has_give_up_reward", false) || (wC = DbA.this.wC()) != null) {
                        return;
                    }
                    wC.aGH(1);
                }
            });
        }
    }

    public boolean DbA() {
        if (this.aGH != null && this.FC) {
            return this.aAs || this.nlS;
        }
        return false;
    }

    public boolean eli(ev evVar) {
        return (evVar == null || evVar.ke() == null || evVar.ke().Os() <= 0) ? false : true;
    }

    public boolean Os() {
        return this.FC;
    }

    public void eli(TTAdActivity tTAdActivity, Bundle bundle, com.bytedance.sdk.openadsdk.eli.ui.eli eliVar, com.bytedance.sdk.openadsdk.eli.Os.DbA dbA) {
        this.Dfc = bundle;
        this.nn = 1;
        this.kb = eliVar;
        this.wC = dbA;
        if (eliVar == null && bundle != null) {
            this.kb = DbA;
            DbA = null;
        }
        if (dbA == null && bundle != null) {
            this.wC = Os;
            Os = null;
        }
        this.du.eli(bundle);
    }

    public void eli(TTAdActivity tTAdActivity) {
        this.nn = 2;
        this.du.kb();
    }

    public void DbA(TTAdActivity tTAdActivity) {
        this.nn = 3;
        this.du.DbA();
        du duVar = this.eli;
        if (duVar != null) {
            duVar.DbA();
        }
        this.QX.eli(tTAdActivity, this.aGH.WO(), this.aGH.Nvn());
    }

    public void eli(boolean z) {
        this.du.eli(z);
    }

    public void Os(TTAdActivity tTAdActivity) {
        this.nn = 4;
        this.du.Os();
        du duVar = this.eli;
        if (duVar != null) {
            duVar.eli();
        }
    }

    public void aGH(TTAdActivity tTAdActivity) {
        this.nn = 5;
        this.du.wC();
    }

    public void eli(TTAdActivity tTAdActivity, Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(this.aGH, tTAdActivity != null ? tTAdActivity.getIntent() : null, bundle);
        com.bytedance.sdk.openadsdk.eli.ui.eli eliVar = this.kb;
        if (eliVar != null) {
            DbA = eliVar;
            return;
        }
        com.bytedance.sdk.openadsdk.eli.Os.DbA dbA = this.wC;
        if (dbA != null) {
            Os = dbA;
        }
    }

    public void ui(TTAdActivity tTAdActivity) {
        this.nn = 6;
        this.du.aGH();
        this.QX.eli(tTAdActivity);
        this.NU = null;
    }

    public void eli(wC wCVar, ui uiVar) {
        this.du.eli(wCVar, null, uiVar);
    }

    public void aGH() {
        Activity activity = this.NU;
        if (activity != null) {
            activity.finish();
        }
    }

    public Activity ui() {
        com.bytedance.sdk.openadsdk.activity.Os os = this.du;
        if (os != null) {
            return os.eli;
        }
        return null;
    }

    public void eli(Activity activity) {
        this.du.eli(activity);
    }

    public void MGA() {
        this.du.aAs();
    }

    public int kb() {
        return this.du.du();
    }

    public wC wC() {
        return this.du.nlS();
    }

    public Bundle FC() {
        return this.ui;
    }

    public void aAs() {
        com.bytedance.sdk.openadsdk.eli.ui.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.onAdClicked();
            return;
        }
        com.bytedance.sdk.openadsdk.eli.Os.DbA dbA = this.wC;
        if (dbA != null) {
            dbA.onAdClicked();
        }
    }

    public void du() {
        com.bytedance.sdk.openadsdk.eli.ui.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.DbA();
            return;
        }
        com.bytedance.sdk.openadsdk.eli.Os.DbA dbA = this.wC;
        if (dbA != null) {
            dbA.DbA();
        }
    }

    public void nlS() {
        if (Dfc()) {
            return;
        }
        aqO();
        com.bytedance.sdk.openadsdk.eli.ui.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.eli();
        } else {
            com.bytedance.sdk.openadsdk.eli.Os.DbA dbA = this.wC;
            if (dbA != null) {
                dbA.eli();
            }
        }
        Runnable runnable = this.nGm;
        if (runnable != null) {
            runnable.run();
            this.nGm = null;
        }
    }

    public boolean NU() {
        return this.dV;
    }

    public void nn() {
        this.dV = true;
        du duVar = this.eli;
        if (duVar != null) {
            duVar.Os();
        }
    }

    public void eli(final wC wCVar, final boolean z, final int i, final String str, final int i2, final String str2) {
        Activity activity;
        if (!this.aqO) {
            this.nGm = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.DbA.2
                @Override // java.lang.Runnable
                public void run() {
                    DbA.this.eli(wCVar, z, i, str, i2, str2);
                }
            };
            return;
        }
        if (NU()) {
            return;
        }
        nn();
        if (this.kb == null || (activity = this.NU) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.DbA.3
            @Override // java.lang.Runnable
            public void run() {
                DbA.this.kb.eli(z, i, str, i2, str2);
            }
        });
        if (Os()) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), wCVar.FC, wCVar.b_(), z ? "reward_success" : "reward_fail");
        }
    }

    public boolean Dfc() {
        return this.aqO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ue() {
        return this.du.ui();
    }

    public void aqO() {
        this.aqO = true;
        this.du.dV();
    }

    public void eli(com.bytedance.sdk.openadsdk.activity.eli eliVar, boolean z) {
        this.du.eli(eliVar, z);
    }

    public void eli(wC wCVar) {
        com.bytedance.sdk.openadsdk.activity.Os os = this.du;
        if (os == null) {
            return;
        }
        os.eli(wCVar);
    }

    public void eli(wC wCVar, boolean z) {
        com.bytedance.sdk.openadsdk.activity.Os os = this.du;
        if (os == null) {
            return;
        }
        os.eli(wCVar, z);
    }

    public com.bytedance.sdk.openadsdk.nlS.FC dV() {
        return this.MGA;
    }

    public void eli(View view) {
        this.du.eli(view);
    }

    public boolean nGm() {
        return this.du.MGA();
    }

    public void eli(View view, boolean z) {
        this.du.eli(view, z);
    }

    public boolean eli(wC wCVar, int i) {
        return this.du.eli(wCVar, i);
    }

    public void DbA(wC wCVar) {
        wCVar.eli(this.NU, this.Dfc);
        int i = this.nn;
        if (i == 2) {
            wCVar.nlS();
            return;
        }
        if (i == 3) {
            wCVar.nlS();
            wCVar.Os();
            wCVar.Os(true);
        } else if (i == 4) {
            wCVar.Os(false);
            wCVar.NU();
        } else {
            if (i != 5) {
                return;
            }
            wCVar.aGH();
        }
    }

    public com.bytedance.sdk.openadsdk.component.reward.top.Os QX() {
        return this.du.NU();
    }

    public wC Xb() {
        return this.du.nn();
    }

    public void eli(float f) {
        this.du.eli(f);
    }

    public void DbA(wC wCVar, ui uiVar) {
        this.du.eli(wCVar, uiVar);
    }

    public boolean bf() {
        return this.du instanceof com.bytedance.sdk.openadsdk.activity.aGH;
    }

    public void DbA(boolean z) {
        this.Xb = z;
    }

    public boolean CMM() {
        return this.Xb;
    }

    public List<ev> ev() {
        return this.du.aqO();
    }

    public void eli(Map<String, Object> map, wC wCVar, float f, float f2) {
        this.du.eli(map, wCVar, f, f2);
    }

    public void Vy() {
        this.du.nGm();
    }

    public static class ui {
        public final int DbA;
        public final com.bytedance.sdk.openadsdk.component.reward.eli.eli Os;
        public boolean aGH;
        public final Bundle eli = new Bundle();
        public boolean ui;

        public ui(int i, com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
            this.DbA = i;
            this.Os = eliVar;
        }

        public String toString() {
            return super.toString();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.activity.DbA$DbA, reason: collision with other inner class name */
    static abstract class AbstractC0166DbA implements Handler.Callback {
        private int CMM;
        protected ev DbA;
        private boolean Dfc;
        private boolean GB;
        private int KM;
        private boolean NU;
        protected float Os;
        private int QX;
        private boolean Ue;
        private boolean Vy;
        private int Xb;
        private final com.bytedance.sdk.openadsdk.component.reward.top.Os aAs;
        protected int aGH;
        private float aqO;
        private int bf;
        private final Context du;
        protected final DbA eli;
        private int ev;
        private boolean gG;
        private int nGm;
        private boolean nn;
        protected int ui;
        private int ujq;
        private final Handler FC = new Handler(Looper.getMainLooper(), this);
        private final int nlS = 1000;
        protected int MGA = -1;
        private int dV = 1000;
        private boolean VM = false;
        boolean kb = false;
        public int wC = -1;

        protected abstract int eli(ev evVar);

        public int eli() {
            return this.aGH;
        }

        public void eli(boolean z) {
            this.Vy = z;
            if (z) {
                int i = this.bf;
                int i2 = this.QX;
                this.nGm = i - i2;
                this.ev = i2;
                this.CMM = i;
            }
        }

        public void DbA() {
            this.GB = false;
            this.kb = false;
            this.KM = 0;
            this.wC = -1;
            this.VM = false;
            com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.aAs;
            if (os != null) {
                os.setShowPlayableNextAd(false, this.DbA);
            }
        }

        public AbstractC0166DbA(DbA dbA, ev evVar, com.bytedance.sdk.openadsdk.component.reward.top.Os os) {
            this.eli = dbA;
            this.DbA = evVar;
            this.aAs = os;
            this.du = os.getContext();
            this.aGH = eli(evVar);
        }

        public void eli(int i) {
            int i2 = this.ui;
            if (i != -1) {
                this.wC = i;
            }
            this.FC.removeMessages(i2);
        }

        public void DbA(int i) {
            if (this.wC != 2 || i == 1) {
                if (i != -1) {
                    this.wC = i;
                }
                if (this.FC.hasMessages(this.ui) || this.VM) {
                    return;
                }
                DbA dbA = this.eli;
                if (dbA == null || dbA.wC() == null || this.eli.wC().ujq() == null || !this.eli.wC().ujq().du.get()) {
                    int i2 = this.aGH;
                    boolean z = this.NU;
                    int i3 = this.ui;
                    if (i3 == 1 || i3 == 2) {
                        if (i2 < 0 || z || this.nn) {
                            return;
                        }
                        this.FC.sendEmptyMessageDelayed(i3, this.dV);
                        return;
                    }
                    if (i3 == 3) {
                        aGH(3);
                    } else if (i3 == 4) {
                        ui(4);
                    }
                }
            }
        }

        public void DbA(boolean z) {
            if (z) {
                this.dV = (int) (1000.0f / this.aqO);
            } else {
                this.dV = 1000;
            }
        }

        public void Os() {
            this.FC.removeMessages(this.ui);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                eli(message);
            } else if (message.what == 2) {
                eli(message);
            } else if (message.what == 3) {
                if (this.MGA > 0) {
                    kb();
                    if (this.MGA >= 0) {
                        eli(message.what, 1000);
                    }
                }
            } else if (message.what == 4 && this.GB) {
                ui();
                if (this.GB && !this.Ue) {
                    eli(message.what, 1000);
                }
            }
            return true;
        }

        private void eli(Message message) {
            if (this.aGH > 0) {
                com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.aAs;
                StringBuilder sb = new StringBuilder();
                int i = this.aGH;
                this.aGH = i - 1;
                os.setSkipText(sb.append(i).append("s").toString());
                kb();
                ui();
                if (this.aGH >= 0) {
                    eli(message.what, this.dV);
                    return;
                }
                return;
            }
            aGH(3);
            ui(4);
            wC();
        }

        private void eli(int i, int i2) {
            if (this.VM) {
                return;
            }
            this.FC.removeMessages(i);
            this.FC.sendEmptyMessageDelayed(i, i2);
        }

        private void kb() {
            int i = this.MGA;
            if (i > 0) {
                this.MGA = i - 1;
            }
            if (this.MGA == 0 && this.Dfc) {
                this.Dfc = false;
                DbA dbA = this.eli;
                if (dbA == null || dbA.wC() == null) {
                    return;
                }
                wC wC = this.eli.wC();
                if (wC instanceof com.bytedance.sdk.openadsdk.activity.ui) {
                    ((com.bytedance.sdk.openadsdk.activity.ui) wC).gG();
                }
            }
        }

        private void aGH(int i) {
            if (this.MGA > 0 && this.Dfc && i == 3) {
                this.ui = i;
                eli(i, 1000);
            }
        }

        private void ui(int i) {
            if (this.GB && i == 4) {
                this.ui = i;
                eli(i, 1000);
            }
        }

        private void wC() {
            if (this.eli.Ue()) {
                this.aAs.showSkipButton();
                this.NU = true;
            } else {
                this.nn = true;
                this.aAs.showCloseButton();
            }
            this.aAs.setShowPlayableNextAd(false, this.DbA);
        }

        public void Os(int i) {
            this.MGA = i;
            if (i > 0) {
                this.Dfc = true;
                if (this.aGH <= 0 || this.NU) {
                    aGH(3);
                }
            }
        }

        public void aGH() {
            if (this.NU || this.nn) {
                return;
            }
            eli(-1);
            this.VM = true;
            com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.aAs;
            if (os != null) {
                os.setSkipText("");
                this.aAs.setShowEndCardNextAd(true, this.DbA);
            }
        }

        public void ui() {
            int i = this.ujq;
            boolean z = this.gG;
            boolean z2 = this.Vy;
            boolean z3 = this.Ue;
            if (z && this.GB) {
                if (this.nn) {
                    this.GB = false;
                }
                if (z3) {
                    return;
                }
                int i2 = i + 1;
                this.ujq = i2;
                if (z2) {
                    this.CMM = this.bf;
                } else {
                    this.CMM = this.nGm + this.QX;
                }
                if (i2 >= this.nGm) {
                    if (!this.kb) {
                        this.KM++;
                        this.kb = true;
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("click_countdown_remaining", this.aGH);
                            jSONObject.put("hint_sequence", this.KM);
                            com.bytedance.sdk.openadsdk.aGH.Os.MGA(this.DbA, this.eli.wC().b_(), jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.activity.Os os = this.eli.du;
                    int i3 = this.ev;
                    this.ev = i3 - 1;
                    os.eli(i3, this.aGH);
                } else {
                    this.kb = false;
                    this.eli.du.eli(-1, this.aGH);
                }
                if (this.Vy && this.ujq >= this.Xb) {
                    boolean z4 = this.NU;
                    boolean z5 = this.nn;
                    if (!z4 && !z5) {
                        this.aAs.setShowPlayableNextAd(true, this.DbA);
                    }
                }
                if (this.ujq < this.CMM || this.eli.wC() == null) {
                    return;
                }
                wC wC = this.eli.wC();
                if (wC instanceof com.bytedance.sdk.openadsdk.activity.ui) {
                    this.FC.removeMessages(4);
                    ((com.bytedance.sdk.openadsdk.activity.ui) wC).gG();
                }
            }
        }

        public void eli(ev evVar, boolean z) {
            this.nGm = KM.ev(evVar);
            this.QX = KM.Ue(evVar);
            this.Xb = KM.KM(evVar);
            this.bf = KM.VM(evVar);
            this.ev = this.QX;
            this.gG = false;
            this.Vy = false;
            this.ujq = 0;
            this.GB = true;
            com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.aAs;
            if (os != null) {
                os.setShowPlayableNextAd(false, evVar);
            }
            this.Ue = z;
            if (this.aGH <= 0 || this.NU) {
                ui(4);
            }
        }

        public void MGA() {
            this.gG = true;
        }

        public void eli(int i, ev evVar) {
            if (evVar != null && evVar.CI() != null) {
                this.aqO = evVar.CI().eli();
                this.DbA = evVar;
            }
            int i2 = this.aGH;
            boolean z = this.NU;
            boolean z2 = this.nn;
            int i3 = this.ui;
            if (z || z2) {
                return;
            }
            float f = i;
            this.Os = f;
            if (f <= i2) {
                this.ui = 2;
                this.aGH = (int) f;
            } else if (i3 == 0) {
                this.ui = 1;
            }
            int i4 = this.ui;
            if (i3 == i4 && this.FC.hasMessages(i4)) {
                return;
            }
            this.FC.removeCallbacksAndMessages(null);
            this.FC.sendEmptyMessage(this.ui);
        }
    }

    static class aGH extends AbstractC0166DbA {
        private final int FC;
        private int aAs;
        private boolean du;

        public aGH(DbA dbA, ev evVar, com.bytedance.sdk.openadsdk.component.reward.top.Os os) {
            super(dbA, evVar, os);
            if (evVar != null) {
                if (evVar.tLO() >= 0) {
                    this.FC = Math.min(100, evVar.tLO());
                    return;
                } else {
                    this.FC = dV.aGH().gG(String.valueOf(evVar.RTg())).MGA;
                    return;
                }
            }
            this.FC = 100;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.DbA.AbstractC0166DbA
        protected int eli(ev evVar) {
            if (evVar != null) {
                return evVar.YP();
            }
            return 30;
        }

        @Override // com.bytedance.sdk.openadsdk.activity.DbA.AbstractC0166DbA
        public void eli(int i, ev evVar) {
            boolean z = this.ui == 0;
            int i2 = this.aGH;
            super.eli(i, evVar);
            if (!z) {
                if (this.Os < i2) {
                    this.aAs = (int) ((1.0f - (this.FC / 100.0f)) * this.aGH);
                }
            } else {
                if (this.ui == 1) {
                    this.aAs = 3;
                } else {
                    this.aAs = (int) ((1.0f - (this.FC / 100.0f)) * this.Os);
                }
                if (this.eli.eli != null) {
                    this.eli.eli.eli(this.aGH);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.activity.DbA.AbstractC0166DbA, android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (!this.du && this.aGH <= this.aAs) {
                this.du = true;
                wC wC = this.eli.wC();
                if (wC != null) {
                    wC.ikX();
                }
            }
            super.handleMessage(message);
            return true;
        }
    }

    static class eli extends AbstractC0166DbA {
        public eli(DbA dbA, ev evVar, com.bytedance.sdk.openadsdk.component.reward.top.Os os) {
            super(dbA, evVar, os);
        }

        @Override // com.bytedance.sdk.openadsdk.activity.DbA.AbstractC0166DbA
        protected int eli(ev evVar) {
            if (evVar != null) {
                return evVar.bnh();
            }
            return 5;
        }
    }

    public static class Os implements Runnable {
        private final ev eli;

        public Os(ev evVar) {
            this.eli = evVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.eli.JF()) {
                return;
            }
            if (this.eli.Txb()) {
                NU.eli(dV.eli()).eli(this.eli.XU());
            } else {
                com.bytedance.sdk.openadsdk.component.reward.ui.eli(dV.eli()).eli(this.eli.XU());
            }
        }
    }

    public int gG() {
        return this.du.FC();
    }

    public void DbA(wC wCVar, int i) {
        this.du.DbA(wCVar, i);
    }

    public void eli(wC wCVar, boolean z, boolean z2, boolean z3, int i) {
        this.du.eli(wCVar, z, z2, z3, i);
    }
}

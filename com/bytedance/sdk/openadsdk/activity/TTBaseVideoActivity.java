package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import com.bytedance.sdk.openadsdk.component.reward.NU;
import com.bytedance.sdk.openadsdk.component.reward.eli.nlS;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.VM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.utils.Dfc;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.oWW;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class TTBaseVideoActivity extends TTBaseActivity implements Ue.eli, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA {
    com.bytedance.sdk.openadsdk.component.reward.eli.eli DbA;
    private final nlS.DbA Dfc;
    protected oWW FC;
    int MGA;
    private boolean NU;
    protected com.bytedance.sdk.openadsdk.component.reward.DbA.DbA Os;
    int aAs;
    final Ue aGH;
    private final AtomicBoolean aqO;
    protected boolean du;
    public final String eli;
    boolean kb;
    protected com.bytedance.sdk.openadsdk.nlS.MGA nlS;
    private int nn;
    protected IListenerManager ui;

    protected abstract void CMM();

    public boolean Vy() {
        return false;
    }

    protected abstract void aGH();

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void aGH(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void dV() {
    }

    protected void eli(Intent intent) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean eli() {
        return true;
    }

    public abstract boolean ev();

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void kb() {
    }

    protected void nGm() {
    }

    protected abstract void nlS();

    public TTBaseVideoActivity() {
        this.eli = ev() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.aGH = new Ue(Looper.getMainLooper(), this);
        this.NU = false;
        this.nn = 0;
        this.aAs = 1;
        this.Dfc = new nlS.DbA();
        this.du = false;
        this.aqO = new AtomicBoolean(false);
        this.nlS = new com.bytedance.sdk.openadsdk.nlS.MGA() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.nlS.MGA
            public void eli() {
                TTBaseVideoActivity.this.QX();
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar;
        super.onCreate(bundle);
        Xb.eli("BVA", "onCreate ".concat(String.valueOf(this)));
        dV.DbA(getApplicationContext());
        if (!nn.ui()) {
            finish();
            return;
        }
        ev eli2 = com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(getIntent(), bundle, this);
        if (eli2 == null) {
            finish();
            return;
        }
        com.bytedance.sdk.openadsdk.utils.DbA.eli(eli2);
        this.aAs = eli2.WO();
        eli(eli2, bundle);
        if (bundle != null) {
            if (eli2.qj()) {
                this.aqO.set(true);
            }
            if (eli2.eU() && (eliVar = this.DbA) != null) {
                eliVar.NU.set(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar2 = this.DbA;
            if (eliVar2 != null) {
                eliVar2.KM.kb();
            }
        }
        try {
            Os();
            ujq();
        } catch (Throwable th) {
            Xb.eli("TTAD.BVA", "onCreate: ", th);
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA();
            finish();
        }
    }

    private void eli(ev evVar, Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = new com.bytedance.sdk.openadsdk.component.reward.eli.eli(this, this.aGH, evVar, this, 0);
        this.DbA = eliVar;
        com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(eliVar, getIntent(), bundle);
        Intent intent = getIntent();
        if (intent != null) {
            eli(intent);
            evVar.eli(intent.getLongExtra("start_show_time", 0L));
        }
        if (bundle != null && this.DbA.qyC) {
            aGH();
        }
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA eli2 = com.bytedance.sdk.openadsdk.component.reward.DbA.MGA.eli(this.DbA);
        this.Os = eli2;
        this.DbA.Mc = eli2;
        Dfc.eli(this.DbA);
        new StringBuilder("init: mAdType = ").append(this.Os);
    }

    protected void Os() {
        setContentView(this.DbA.dZ);
        this.DbA.dZ.eli(this.Os);
        this.Os.eli(this, this.aGH);
        this.Os.du();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        if (eliVar == null || eliVar.DbA == null) {
            return;
        }
        ev evVar = this.DbA.DbA;
        if (this.wC && !evVar.QmN() && !TextUtils.isEmpty(ev.eli(this, evVar))) {
            finish();
        }
        if (evVar.QmN()) {
            evVar.du(false);
        }
    }

    private void ujq() {
        com.bytedance.sdk.openadsdk.core.du.aGH eli2;
        this.Os.eli(this.nlS);
        this.MGA = (int) this.DbA.ev.cyF();
        CMM();
        ui();
        com.bytedance.sdk.openadsdk.core.model.aGH UCq = this.DbA.DbA.UCq();
        if (UCq == null || (eli2 = UCq.eli()) == null) {
            return;
        }
        eli2.eli(0L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        if (eliVar == null || eliVar.KM == null) {
            return;
        }
        this.DbA.KM.DbA(z);
        this.DbA.KM.Os(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void aqO() {
        if (!this.DbA.nn.getAndSet(true) || KM.Os(this.DbA.DbA)) {
            this.DbA.KM.eli();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void du() {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.NU();
    }

    public void eli(boolean z, int i) {
        eli(z, false, i);
    }

    public void eli(boolean z, boolean z2, int i) {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.eli(z, z2, false, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void nn() {
        this.DbA.ev.eU();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public View Dfc() {
        return this.DbA.ev.dZ();
    }

    protected void ui() {
        if (KM.Os(this.DbA.DbA)) {
            eli(false, DbA.C0161DbA.Os);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA != null) {
            dbA.eli(this.DbA.eU.MGA());
            this.Os.ujq();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Xb.eli("BVA", "onStart ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        if (eliVar == null) {
            return;
        }
        eliVar.qj.qj();
        com.bytedance.sdk.openadsdk.utils.aGH.eli(this, this.DbA.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA;
        super.onResume();
        Xb.eli("BVA", "onResume ".concat(String.valueOf(this)));
        if (this.DbA == null || (dbA = this.Os) == null) {
            return;
        }
        dbA.dV();
        this.DbA.WfR = true;
        this.Dfc.eli(this, this.DbA.QI, this.DbA.mm);
        if (VM()) {
            this.DbA.Cp.eli(this.DbA.DbA.iiz());
        }
        this.DbA.eU.Dfc();
        this.DbA.qj.CMM();
        this.DbA.gG.NU();
        if (this.Os.DbA()) {
            this.DbA.ev.eli(this.Os);
            this.DbA.ev.eli(false, this, this.nn != 0);
        }
        this.nn++;
        NU();
        if (this.DbA.ujq != null) {
            this.DbA.ujq.kb();
        }
        this.DbA.Ue.eli(this.aGH);
        this.Os.QX();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Xb.eli("BVA", "onPause ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.Xb();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Xb.eli("BVA", "onStop ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.bf();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Xb.eli("BVA", "onDestroy ".concat(String.valueOf(this)));
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        if (eliVar == null || this.Os == null) {
            return;
        }
        if (eliVar.BDs > 0 && this.DbA.NU.get()) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(String.valueOf(SystemClock.elapsedRealtime() - this.DbA.BDs), this.DbA.DbA, this.eli, this.DbA.ev.ui());
            this.DbA.BDs = 0L;
        }
        this.DbA.GB.DbA();
        this.aGH.removeCallbacksAndMessages(null);
        this.Os.CMM();
        com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.DbA.DbA);
        com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA(this.DbA.DbA);
        AdSlot XU = this.DbA.DbA.XU();
        if (!this.DbA.ev.oWW() && XU != null && TextUtils.isEmpty(XU.getBidAdm()) && !this.DbA.DbA.JF()) {
            nn.DbA().post(new eli(ev(), XU));
        }
        Dfc.eli();
        oWW oww = this.FC;
        if (oww != null) {
            oww.ui();
            this.FC = null;
        }
        this.Dfc.eli(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        if (eliVar == null) {
            super.onSaveInstanceState(bundle);
            return;
        }
        if (eliVar.NU.get()) {
            this.DbA.DbA.kb(true);
        }
        if (this.aqO.get()) {
            this.DbA.DbA.oWW();
        }
        com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(this.DbA, bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Ue();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void DbA() {
        Ue();
    }

    private void Ue() {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA;
        if (this.DbA == null || (dbA = this.Os) == null) {
            super.onBackPressed();
        } else {
            dbA.ev();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        if (eliVar == null) {
            return;
        }
        eliVar.Ue.eli();
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.eli(message);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public final void FC() {
        if (this.aqO.compareAndSet(false, true)) {
            Xb.eli("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            nlS();
        }
    }

    protected IListenerManager DbA(int i) {
        if (this.ui == null) {
            this.ui = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().eli(i));
        }
        return this.ui;
    }

    protected void NU() {
        if (Vy() && !this.NU) {
            this.NU = true;
            getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.component.reward.eli.MGA mga = TTBaseVideoActivity.this.DbA.VM;
                    float[] eli2 = TTBaseVideoActivity.this.DbA.Ue.eli(TTBaseVideoActivity.this.aAs);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    mga.eli(eli2, tTBaseVideoActivity, tTBaseVideoActivity.Os);
                    TTBaseVideoActivity.this.nGm();
                }
            });
        }
    }

    protected void Xb() {
        Message message = new Message();
        message.what = 400;
        if (ev()) {
            eli(10000);
        }
        this.aGH.sendMessageDelayed(message, 2000L);
    }

    protected void bf() {
        this.aGH.removeMessages(400);
    }

    private boolean VM() {
        if (this.DbA.aAs.get() && this.DbA.kb) {
            return false;
        }
        if ((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) {
            return this.DbA.aAs.get();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.DbA == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.utils.Ue.ui()) {
            SSo.DbA((Activity) this);
        }
        if (KM.kb(this.DbA.DbA) && !this.DbA.aAs.get()) {
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        } else {
            if (!KM.ui(this.DbA.DbA) || this.DbA.gG.wC(com.bytedance.sdk.openadsdk.component.reward.eli.wC.DbA)) {
                return;
            }
            ApmHelper.reportCustomError("invalid finish", "playable", new RuntimeException());
        }
    }

    protected void gG() {
        VM CI;
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.DbA;
        if (eliVar == null || eliVar.DbA == null || (CI = this.DbA.DbA.CI()) == null) {
            return;
        }
        if (CI.DbA() == 1 || CI.DbA() == 2) {
            com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar2 = this.DbA;
            this.FC = new oWW(eliVar2, eliVar2.DbA);
            if (this.DbA.ev != null) {
                this.DbA.ev.eli(this.FC);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public List<ev> KM() {
        return this.DbA.DbA.ro();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void Cp() {
        this.du = true;
    }

    private static class eli implements Runnable {
        AdSlot DbA;
        boolean eli;

        eli(boolean z, AdSlot adSlot) {
            this.eli = z;
            this.DbA = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.eli) {
                NU.eli(dV.eli()).eli(this.DbA);
            } else {
                com.bytedance.sdk.openadsdk.component.reward.ui.eli(dV.eli()).eli(this.DbA);
            }
        }
    }
}

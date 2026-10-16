package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.common.Dfc;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.aGH.eli;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.core.ujq;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.eU;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.ironsource.C3355vf;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTAppOpenAdActivity extends TTBaseActivity implements Ue.eli, eli.InterfaceC0198eli {
    private static com.bytedance.sdk.openadsdk.eli.aGH.DbA FC;
    private ev CMM;
    private com.bytedance.sdk.openadsdk.component.Os GB;
    private FrameLayout KM;
    private TTAdDislikeToast NU;
    private boolean QX;
    private int Ue;
    private boolean VM;
    private com.bytedance.sdk.openadsdk.eli.aGH.DbA Vy;
    private int Xb;
    private com.bytedance.sdk.openadsdk.aGH.kb aqO;
    private String bf;
    private float dV;
    private com.bytedance.sdk.openadsdk.component.MGA.DbA du;
    private IListenerManager ev;
    private float nGm;
    private Dfc nlS;
    private AdSlot oWW;
    private int ujq;
    protected final AtomicBoolean eli = new AtomicBoolean(false);
    protected final Ue DbA = new Ue(Looper.getMainLooper(), this);
    final AtomicBoolean Os = new AtomicBoolean(false);
    final AtomicBoolean aGH = new AtomicBoolean(false);
    private final com.bytedance.sdk.openadsdk.component.wC.eli aAs = new com.bytedance.sdk.openadsdk.component.wC.eli();
    protected boolean ui = false;
    private final AtomicBoolean nn = new AtomicBoolean(false);
    private eU Dfc = eU.Os();
    private final AtomicBoolean gG = new AtomicBoolean(false);
    long MGA = 0;
    private volatile boolean qj = false;
    int kb = -1;
    private final com.bytedance.sdk.openadsdk.component.eli nro = new com.bytedance.sdk.openadsdk.component.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.1
        @Override // com.bytedance.sdk.openadsdk.component.eli, com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
        public void DbA(long j, int i) {
            com.bytedance.sdk.openadsdk.component.wC.Os kb;
            new Object[]{"open_ad", "onError() called with: totalPlayTime = [" + j + "], percent = [" + i + C3040d4.i.e};
            if (TTAppOpenAdActivity.this.GB != null && (kb = TTAppOpenAdActivity.this.GB.kb()) != null) {
                TTAppOpenAdActivity.this.gG();
                kb.eli(true);
            }
            TTAppOpenAdActivity.this.ev();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli, com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
        public void eli() {
            new Object[]{"open_ad", "onTimeOut"};
            TTAppOpenAdActivity.this.gG();
            TTAppOpenAdActivity.this.ev();
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli, com.bykv.vk.openvk.eli.eli.eli.aGH.Os.eli
        public void eli(long j, long j2) {
            TTAppOpenAdActivity.this.aAs.DbA(j);
            if (!TTAppOpenAdActivity.this.ui && TTAppOpenAdActivity.this.GB != null && TTAppOpenAdActivity.this.GB.kb() != null && TTAppOpenAdActivity.this.GB.kb().ui()) {
                TTAppOpenAdActivity.this.GB.kb().wC();
            }
            TTAppOpenAdActivity.this.Dfc();
            if (TTAppOpenAdActivity.this.GB instanceof com.bytedance.sdk.openadsdk.component.DbA) {
                ((com.bytedance.sdk.openadsdk.component.DbA) TTAppOpenAdActivity.this.GB).eli(j, j2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli, com.bytedance.sdk.openadsdk.component.MGA.eli
        public void eli(View view) {
            TTAppOpenAdActivity.this.Vy();
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli, com.bytedance.sdk.openadsdk.component.MGA.eli
        public void DbA(View view) {
            TTAppOpenAdActivity.this.Os();
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli, com.bytedance.sdk.openadsdk.component.MGA.eli
        public void DbA() {
            TTAppOpenAdActivity.this.qj = true;
            new Object[]{"open_ad", "onCountDownFinish() called"};
            if (com.bytedance.sdk.openadsdk.bf.eli.eli("splash_auto_close_switch", 0) == 0) {
                TTAppOpenAdActivity.this.FC();
                TTAppOpenAdActivity.this.finish();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli, com.bytedance.sdk.openadsdk.component.MGA.eli
        public void eli(int i, boolean z) {
            if (TTAppOpenAdActivity.this.GB != null) {
                TTAppOpenAdActivity.this.GB.eli(i, z);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli
        public void Os() {
            TTAppOpenAdActivity.this.wC();
            TTAppOpenAdActivity.this.Dfc.ui();
            TTAppOpenAdActivity.this.Xb();
            if (TTAppOpenAdActivity.this.QX) {
                TTAppOpenAdActivity.this.nn();
            }
            if (TTAppOpenAdActivity.this.GB.kb() == null || TTAppOpenAdActivity.this.GB.kb().DbA() == null) {
                return;
            }
            TTAppOpenAdActivity.this.GB.kb().DbA().eli(TTAppOpenAdActivity.this);
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli
        public void aGH() {
            TTAppOpenAdActivity.this.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.component.eli
        public void ui() {
            TTAppOpenAdActivity.this.CMM();
        }
    };
    private final Runnable Cp = new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.5
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.model.aGH UCq;
            com.bytedance.sdk.openadsdk.core.du.aGH eli;
            if (TTAppOpenAdActivity.this.nn.get()) {
                return;
            }
            if (TTAppOpenAdActivity.this.CMM != null && (UCq = TTAppOpenAdActivity.this.CMM.UCq()) != null && (eli = UCq.eli()) != null) {
                eli.eli(0L);
            }
            TTAppOpenAdActivity.this.aqO = new com.bytedance.sdk.openadsdk.aGH.kb();
            TTAppOpenAdActivity.this.aqO.eli(System.currentTimeMillis(), 1.0f);
            TTAppOpenAdActivity.this.Dfc.ui();
            if (TTAppOpenAdActivity.this.du != null) {
                TTAppOpenAdActivity.this.du.DbA();
            }
            if (TTAppOpenAdActivity.this.GB != null) {
                TTAppOpenAdActivity.this.GB.ui();
            }
            TTAppOpenAdActivity.this.bf();
            View findViewById = TTAppOpenAdActivity.this.findViewById(R.id.content);
            JSONObject jSONObject = new JSONObject();
            if (findViewById != null) {
                try {
                    jSONObject.put("width", findViewById.getWidth());
                    jSONObject.put("height", findViewById.getHeight());
                    jSONObject.put("alpha", findViewById.getAlpha());
                } catch (JSONException e) {
                    Log.e("TTAppOpenAdActivity", "run: ", e);
                    TTAppOpenAdActivity.this.finish();
                    return;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("root_view", jSONObject.toString());
            jSONObject2.put("ad_root", TTAppOpenAdActivity.this.ujq);
            jSONObject2.put("openad_creative_type", TTAppOpenAdActivity.this.QX ? "video_normal_ad" : "image_normal_ad");
            if (com.bytedance.sdk.openadsdk.component.FC.wC.Os() == null) {
                jSONObject2.put("appicon_acquirefail", "1");
            }
            if (TTAppOpenAdActivity.this.VM || TTAppOpenAdActivity.this.CMM.Jt()) {
                jSONObject2.put("dynamic_show_type", TTAppOpenAdActivity.this.QX());
                TTAppOpenAdActivity.this.eli(jSONObject2);
            }
            jSONObject2.put("is_icon_only", TTAppOpenAdActivity.this.CMM.gG() ? 1 : 0);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(TTAppOpenAdActivity.this.CMM, "open_ad", jSONObject2);
            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(TTAppOpenAdActivity.this.findViewById(R.id.content), TTAppOpenAdActivity.this.CMM, new ui.eli(TTAppOpenAdActivity.this.QX()));
            com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(TTAppOpenAdActivity.this.CMM);
            TTAppOpenAdActivity.this.nn.set(true);
        }
    };

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean eli() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dV.DbA(getApplicationContext());
        if (!DbA(bundle)) {
            finish();
            return;
        }
        if (!nn.ui()) {
            finish();
            return;
        }
        if (bundle != null) {
            com.bytedance.sdk.openadsdk.aGH.Os.ui(this.CMM, "open_ad", (JSONObject) null);
        }
        this.QX = ev.ui(this.CMM);
        new Object[]{"open_ad", "onCreate: isVideo is " + this.QX};
        if (this.QX) {
            this.aAs.eli((float) this.CMM.nY().MGA());
        } else {
            this.aAs.eli(dV.aGH().CMM(String.valueOf(this.Xb)));
        }
        com.bytedance.sdk.openadsdk.component.MGA.DbA dbA = new com.bytedance.sdk.openadsdk.component.MGA.DbA(this.aAs);
        this.du = dbA;
        dbA.eli(this.nro);
        aAs();
        FrameLayout frameLayout = new FrameLayout(this);
        this.KM = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        try {
            setContentView(this.KM);
            this.KM.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.2
                /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: all -> 0x00c9, TryCatch #0 {all -> 0x00c9, blocks: (B:2:0x0000, B:4:0x0012, B:9:0x0024, B:11:0x002f, B:12:0x00a7, B:16:0x0064), top: B:1:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: all -> 0x00c9, TryCatch #0 {all -> 0x00c9, blocks: (B:2:0x0000, B:4:0x0012, B:9:0x0024, B:11:0x002f, B:12:0x00a7, B:16:0x0064), top: B:1:0x0000 }] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean z;
                    try {
                        int rH = TTAppOpenAdActivity.this.CMM.rH();
                        TTAppOpenAdActivity tTAppOpenAdActivity = TTAppOpenAdActivity.this;
                        if (tTAppOpenAdActivity.CMM != null && TTAppOpenAdActivity.this.CMM.BDs() == 2) {
                            z = true;
                            if (rH != 1) {
                                tTAppOpenAdActivity.VM = z;
                                if (!TTAppOpenAdActivity.this.VM) {
                                    TTAppOpenAdActivity tTAppOpenAdActivity2 = TTAppOpenAdActivity.this;
                                    TTAppOpenAdActivity tTAppOpenAdActivity3 = TTAppOpenAdActivity.this;
                                    tTAppOpenAdActivity2.GB = new com.bytedance.sdk.openadsdk.component.DbA(tTAppOpenAdActivity3, tTAppOpenAdActivity3.CMM, TTAppOpenAdActivity.this.KM, TTAppOpenAdActivity.this.nro, TTAppOpenAdActivity.this.Ue, TTAppOpenAdActivity.this.QX, TTAppOpenAdActivity.this.aAs, TTAppOpenAdActivity.this.du);
                                } else {
                                    TTAppOpenAdActivity tTAppOpenAdActivity4 = TTAppOpenAdActivity.this;
                                    TTAppOpenAdActivity tTAppOpenAdActivity5 = TTAppOpenAdActivity.this;
                                    tTAppOpenAdActivity4.GB = new com.bytedance.sdk.openadsdk.component.Os(tTAppOpenAdActivity5, tTAppOpenAdActivity5.CMM, TTAppOpenAdActivity.this.KM, TTAppOpenAdActivity.this.nro, TTAppOpenAdActivity.this.Ue, TTAppOpenAdActivity.this.QX, TTAppOpenAdActivity.this.aAs);
                                    TTAppOpenAdActivity.this.GB.eli(TTAppOpenAdActivity.this.nGm, TTAppOpenAdActivity.this.dV);
                                }
                                TTAppOpenAdActivity.this.GB.eli((ViewGroup) TTAppOpenAdActivity.this.KM);
                                TTAppOpenAdActivity.this.GB.eli();
                                TTAppOpenAdActivity.this.GB.DbA();
                            }
                        }
                        z = false;
                        tTAppOpenAdActivity.VM = z;
                        if (!TTAppOpenAdActivity.this.VM) {
                        }
                        TTAppOpenAdActivity.this.GB.eli((ViewGroup) TTAppOpenAdActivity.this.KM);
                        TTAppOpenAdActivity.this.GB.eli();
                        TTAppOpenAdActivity.this.GB.DbA();
                    } catch (Throwable th) {
                        TTAppOpenAdActivity.this.finish();
                        Xb.Os("TTAppOpenAdActivity", th.getMessage());
                    }
                }
            });
            try {
                final View decorView = getWindow().getDecorView();
                if (Build.VERSION.SDK_INT >= 35) {
                    decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.3
                        @Override // android.view.View.OnApplyWindowInsetsListener
                        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                            List<Rect> boundingRects;
                            try {
                                DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                                if (displayCutout != null && (boundingRects = displayCutout.getBoundingRects()) != null && !boundingRects.isEmpty()) {
                                    decorView.setPadding(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                                }
                            } catch (Throwable unused) {
                            }
                            return windowInsets;
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            com.bytedance.sdk.openadsdk.Dfc.Os.DbA();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        int bf;
        Log.d("TTAppOpenAdActivity", "startCountDownTimer() called");
        ev evVar = this.CMM;
        if (evVar != null && evVar.eli() >= 0) {
            bf = this.CMM.eli();
        } else {
            bf = dV.aGH().bf(String.valueOf(this.Xb));
        }
        this.du.eli(this.aAs.DbA());
        this.du.DbA(bf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        Xb.eli("TTAppOpenAdActivity", "invoke callback onAdDismiss, ".concat(String.valueOf(this)));
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdTimeOver");
            return;
        }
        com.bytedance.sdk.openadsdk.eli.aGH.DbA dbA = this.Vy;
        if (dbA != null) {
            dbA.Os();
        }
    }

    private void aAs() {
        this.Ue = this.CMM.WO();
        du();
    }

    private void du() {
        int min;
        int max;
        new Object[]{"open_ad", "changeScreenOrientation: mOrientation=" + this.Ue};
        nlS();
        Pair<Integer, Integer> du = SSo.du(getApplicationContext());
        if (this.Ue == 2) {
            min = Math.max(((Integer) du.first).intValue(), ((Integer) du.second).intValue());
            max = Math.min(((Integer) du.first).intValue(), ((Integer) du.second).intValue());
        } else {
            min = Math.min(((Integer) du.first).intValue(), ((Integer) du.second).intValue());
            max = Math.max(((Integer) du.first).intValue(), ((Integer) du.second).intValue());
        }
        this.dV = max;
        this.nGm = min;
        float eli = SSo.eli();
        if (SSo.Os((Activity) this)) {
            int i = this.Ue;
            if (i == 1) {
                this.dV -= eli;
            } else if (i == 2) {
                this.nGm -= eli;
            }
        }
        com.bytedance.sdk.openadsdk.component.Os os = this.GB;
        if (os != null) {
            os.eli(this.nGm, this.dV);
        }
    }

    private void nlS() {
        if (this.Ue == 2) {
            if (kb()) {
                setRequestedOrientation(8);
            } else {
                setRequestedOrientation(0);
            }
        } else {
            setRequestedOrientation(1);
        }
        if (this.Ue == 2 || !SSo.Os((Activity) this)) {
            getWindow().addFlags(1024);
        }
    }

    protected void Os() {
        if (isFinishing()) {
            return;
        }
        if (this.aGH.get()) {
            aqO();
            return;
        }
        if (this.nlS == null) {
            try {
                NU();
            } catch (Throwable th) {
                ApmHelper.reportCustomError("initDislike error", "TTAppOpenAdActivity", th);
            }
        }
        Dfc dfc = this.nlS;
        if (dfc != null) {
            dfc.eli();
        }
    }

    private void NU() {
        if (this.nlS == null) {
            Dfc dfc = new Dfc(this, this.CMM);
            this.nlS = dfc;
            dfc.setDislikeSource("video_player");
            this.nlS.setCallback(new Dfc.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.4
                @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                public void eli(View view) {
                    TTAppOpenAdActivity.this.Os.set(true);
                    TTAppOpenAdActivity.this.ui();
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(TTAppOpenAdActivity.this.CMM, 8);
                }

                @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                public void DbA(View view) {
                    TTAppOpenAdActivity.this.Os.set(false);
                    TTAppOpenAdActivity.this.aGH();
                    com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(TTAppOpenAdActivity.this.CMM, 4);
                }

                @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                public void eli(FilterWord filterWord) {
                    if (TTAppOpenAdActivity.this.aGH.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTAppOpenAdActivity.this.aGH.set(true);
                    TTAppOpenAdActivity.this.dV();
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        frameLayout.addView(this.nlS);
        if (this.NU == null) {
            TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this);
            this.NU = tTAdDislikeToast;
            frameLayout.addView(tTAdDislikeToast);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn() {
        if (!this.QX || this.CMM.gG() || this.qj) {
            return;
        }
        this.DbA.sendEmptyMessageDelayed(100, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dfc() {
        if (!this.QX || this.CMM.gG()) {
            return;
        }
        this.DbA.removeMessages(100);
    }

    private void aqO() {
        this.NU.show(TTAdDislikeToast.getDislikeTip());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV() {
        this.NU.show(TTAdDislikeToast.getDislikeSendTip());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        nGm();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void DbA() {
        nGm();
    }

    private void nGm() {
        if (dV.aGH().Xb(String.valueOf(this.Xb)) == 1) {
            if (this.aAs.Os() >= dV.aGH().bf(String.valueOf(this.Xb)) * 1000) {
                Vy();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (!this.VM) {
                this.Dfc.ui();
            }
            ev evVar = this.CMM;
            if (evVar != null && evVar.ip() && !this.CMM.CMM()) {
                this.CMM.MGA(true);
                ev evVar2 = this.CMM;
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar2, "open_ad", evVar2.nU());
            }
        } else if (this.nn.get()) {
            if (this.Dfc.MGA()) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(String.valueOf(this.Dfc.aGH()), this.CMM, "open_ad", this.aqO);
            }
            this.Dfc = eU.Os();
        }
        com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.CMM, z ? 4 : 8);
        com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(this.CMM, z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        com.bytedance.sdk.openadsdk.component.Os os;
        super.onResume();
        this.ui = true;
        if (this.eli.getAndSet(true)) {
            if (this.gG.get()) {
                ev();
                if (this.QX && (os = this.GB) != null && os.kb() != null) {
                    gG();
                    this.GB.kb().eli(3);
                }
                finish();
                return;
            }
            aGH();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.ui = false;
        ui();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.CMM != null) {
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("videoForceBreak", this.CMM);
        }
        this.DbA.removeCallbacksAndMessages(null);
        com.bytedance.sdk.openadsdk.component.MGA.DbA dbA = this.du;
        if (dbA != null) {
            dbA.ui();
        }
        com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(this.CMM);
        com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA(this.CMM);
        if (this.QX) {
            com.bytedance.sdk.openadsdk.component.aGH.eli.eli(this.CMM, this.aAs.Os(), this.aAs.DbA(), true);
        } else {
            com.bytedance.sdk.openadsdk.component.aGH.eli.eli(this.CMM, -1L, this.aAs.DbA(), false);
        }
        if (this.Dfc.MGA() && this.nn.get()) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(String.valueOf(this.Dfc.aGH()), this.CMM, "open_ad", this.aqO);
            this.Dfc = eU.Os();
        }
        com.bytedance.sdk.openadsdk.component.Os os = this.GB;
        if (os != null) {
            os.Os();
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("recycleRes");
        }
        FC();
        FC = null;
        this.Vy = null;
        Dfc dfc = this.nlS;
        if (dfc != null) {
            dfc.setCallback(null);
        }
        ev evVar = this.CMM;
        if (evVar == null || ev.kb(evVar) || this.CMM.JF()) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.MGA.eli(dV.eli()).eli(this.oWW);
    }

    void aGH() {
        if (this.Os.get()) {
            return;
        }
        if (this.QX) {
            com.bytedance.sdk.openadsdk.component.Os os = this.GB;
            if (os != null && os.kb() != null && this.GB.kb().MGA()) {
                this.GB.kb().du();
            }
            nn();
        }
        com.bytedance.sdk.openadsdk.component.MGA.DbA dbA = this.du;
        if (dbA != null) {
            dbA.Os();
        }
    }

    void ui() {
        if (this.QX) {
            com.bytedance.sdk.openadsdk.component.Os os = this.GB;
            if (os != null && os.kb() != null && this.GB.kb().ui()) {
                this.GB.kb().wC();
            }
            Dfc();
        }
        com.bytedance.sdk.openadsdk.component.MGA.DbA dbA = this.du;
        if (dbA != null) {
            dbA.aGH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int QX() {
        if (this.CMM.Jt()) {
            return 5;
        }
        if (this.VM) {
            return this.GB.aGH();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject eli(JSONObject jSONObject) {
        if (QX() == 0) {
            return this.GB.eli(jSONObject);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xb() {
        if (this.nn.get()) {
            return;
        }
        try {
            getWindow().getDecorView().post(this.Cp);
        } catch (Throwable unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf() {
        new Object[]{"open_ad", "callbackAdShow() called"};
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdShow");
            return;
        }
        com.bytedance.sdk.openadsdk.eli.aGH.DbA dbA = this.Vy;
        if (dbA != null) {
            dbA.eli();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CMM() {
        new Object[]{"open_ad", "callbackAdClick() called"};
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli(C3355vf.f);
        } else {
            com.bytedance.sdk.openadsdk.eli.aGH.DbA dbA = this.Vy;
            if (dbA != null) {
                dbA.onAdClicked();
            }
        }
        if (NU.nY().ev(String.valueOf(this.Xb))) {
            this.gG.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onAdSkip");
            return;
        }
        com.bytedance.sdk.openadsdk.eli.aGH.DbA dbA = this.Vy;
        if (dbA != null) {
            dbA.DbA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vy() {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        com.bytedance.sdk.openadsdk.component.Os os;
        new Object[]{"open_ad", "onUserWantSkip() called"};
        ujq.Os(this.Xb);
        ev();
        if (this.QX && (os = this.GB) != null && os.kb() != null) {
            gG();
            this.GB.kb().eli(4);
        }
        com.bytedance.sdk.openadsdk.component.aGH.eli.eli(this.CMM, (int) this.aAs.Os(), this.du.eli(), this.aAs.DbA());
        ev evVar = this.CMM;
        if (evVar != null && (UCq = evVar.UCq()) != null && (eli = UCq.eli()) != null) {
            com.bytedance.sdk.openadsdk.component.Os os2 = this.GB;
            long NU = (os2 == null || os2.kb() == null) ? 0L : this.GB.kb().NU();
            eli.MGA(NU);
            eli.ui(NU);
        }
        finish();
    }

    private void eli(final String str) {
        cyF.Os(new com.bytedance.sdk.component.wC.wC("AppOpenAd_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTAppOpenAdActivity.this.MGA().executeAppOpenAdCallback(TTAppOpenAdActivity.this.bf, str);
                } catch (Throwable th) {
                    Xb.Os("TTAppOpenAdActivity", "open_ad", "executeAppOpenAdCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected IListenerManager MGA() {
        if (this.ev == null) {
            this.ev = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().eli(7));
        }
        return this.ev;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SSo.eli((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (TTAppOpenAdActivity.this.isFinishing()) {
                            return;
                        }
                        TTAppOpenAdActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SSo.eli((Activity) TTAppOpenAdActivity.this);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        Xb.Os("TTAppOpenAdActivity", e.getMessage());
                    }
                }
            }
        });
    }

    private boolean DbA(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.CMM = com.bytedance.sdk.openadsdk.core.DbA.eli(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        Xb.Os("TTAppOpenAdActivity", "open_ad", "initData MultiGlobalInfo throws ", e);
                    }
                }
                this.bf = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            }
        } else {
            this.CMM = com.bytedance.sdk.openadsdk.core.Ue.eli().eli(com.bytedance.sdk.openadsdk.core.Ue.eli(getIntent()));
            this.Vy = com.bytedance.sdk.openadsdk.core.Ue.eli().aGH();
            com.bytedance.sdk.openadsdk.core.Ue.eli().ui();
        }
        eli(getIntent());
        eli(bundle);
        ev evVar = this.CMM;
        if (evVar == null) {
            new Object[]{"open_ad", "mMaterialMeta is null , no data to display ,the TTOpenAdActivity finished !!"};
            finish();
            return false;
        }
        this.oWW = evVar.XU();
        this.CMM.eli(this.MGA);
        this.Xb = this.CMM.RTg();
        com.bytedance.sdk.openadsdk.utils.DbA.eli(this.CMM);
        return true;
    }

    protected void eli(Intent intent) {
        if (intent != null) {
            this.ujq = intent.getIntExtra(FirebaseAnalytics.Param.AD_SOURCE, 0);
            this.MGA = intent.getLongExtra("start_show_time", 0L);
        }
    }

    protected void eli(Bundle bundle) {
        if (bundle != null) {
            if (this.Vy == null) {
                this.Vy = FC;
                FC = null;
            }
            try {
                int i = bundle.getInt("meta_index", -1);
                this.bf = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
                this.ujq = bundle.getInt(FirebaseAnalytics.Param.AD_SOURCE, 0);
                this.MGA = bundle.getLong("start_show_time", 0L);
                this.CMM = com.bytedance.sdk.openadsdk.core.Ue.eli().eli(i);
            } catch (Throwable th) {
                Xb.Os("TTAppOpenAdActivity", th.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            int eli = this.CMM != null ? com.bytedance.sdk.openadsdk.core.Ue.eli().eli(this.CMM) : -1;
            this.kb = eli;
            bundle.putInt("meta_index", eli);
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, this.bf);
            bundle.putInt(FirebaseAnalytics.Param.AD_SOURCE, this.ujq);
            bundle.putLong("start_show_time", this.MGA);
        } catch (Throwable th) {
            Xb.Os("TTAppOpenAdActivity", th.getMessage());
        }
        FC = this.Vy;
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        com.bytedance.sdk.openadsdk.core.model.aGH UCq;
        com.bytedance.sdk.openadsdk.core.du.aGH eli;
        com.bytedance.sdk.openadsdk.component.Os os;
        if (message.what == 100) {
            if (this.QX && (os = this.GB) != null && os.kb() != null) {
                gG();
                this.GB.kb().eli(1);
            }
            ev evVar = this.CMM;
            if (evVar != null && (UCq = evVar.UCq()) != null && (eli = UCq.eli()) != null) {
                eli.eli(com.bytedance.sdk.openadsdk.core.du.eli.eli.GENERAL_LINEAR_AD_ERROR);
            }
            ev();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG() {
        ev evVar;
        try {
            if (this.du == null || (evVar = this.CMM) == null || evVar.CI() == null) {
                return;
            }
            int DbA = this.CMM.CI().DbA();
            if (DbA == 1 || DbA == 2) {
                this.du.eli(DbA, this.CMM.CI().eli(), false);
                com.bytedance.sdk.openadsdk.component.Os os = this.GB;
                if (os == null || os.kb() == null) {
                    return;
                }
                this.GB.kb().DbA().eli(this.aAs.eli());
                this.GB.kb().DbA().eli(1.0f);
            }
        } catch (Throwable th) {
            Xb.Os("TTAppOpenAdActivity", th.getMessage());
        }
    }

    protected boolean kb() {
        try {
            return getIntent().getIntExtra("orientation_angle", 0) == 3;
        } catch (Exception e) {
            Xb.Os("TTAppOpenAdActivity", e.getMessage());
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.kb >= 0) {
            com.bytedance.sdk.openadsdk.core.Ue.eli().Os(this.kb);
            this.kb = -1;
        }
        com.bytedance.sdk.openadsdk.utils.aGH.eli(this, this.CMM);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.InterfaceC0198eli
    public void eli(int i) {
        if (i == 2 || i == 3 || i == 4) {
            gG();
        }
    }
}

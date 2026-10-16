package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.Xb.kb;
import com.bytedance.sdk.openadsdk.aGH.Os;
import com.bytedance.sdk.openadsdk.aGH.nlS;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.KM;
import com.bytedance.sdk.openadsdk.core.cyF;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.widget.aAs;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.du;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTPlayableLandingPageActivity extends TTBaseLandingPageActivity implements Ue.eli, com.bytedance.sdk.openadsdk.core.DbA.aGH, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA {
    private static final kb.eli Uv = new kb.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.1
    };
    private String CMM;
    private com.bytedance.sdk.openadsdk.Xb.wC Cp;
    TTAdDislikeToast DbA;
    private aAs Dfc;
    private String GB;
    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA KM;
    private com.bytedance.sdk.component.FC.MGA MGA;
    private com.bytedance.sdk.openadsdk.core.ui.aGH NU;
    private qj QX;
    private nlS SSo;
    private boolean Ue;
    private ev Vy;
    private int Xb;
    private com.bytedance.sdk.openadsdk.Xb.eli.eli Za;
    private String aqO;
    private String bf;
    private ILoader cyF;
    private String dV;
    private com.bytedance.sdk.openadsdk.aGH.aGH.ui dZ;
    private com.bytedance.sdk.openadsdk.core.ui.aGH du;
    KM eli;
    private boolean jh;
    private qj nGm;
    private com.bytedance.sdk.openadsdk.core.ui.aGH nlS;
    private Context nn;
    private boolean ujq;
    private boolean kb = true;
    private boolean FC = false;
    private boolean aAs = true;
    final AtomicBoolean Os = new AtomicBoolean(false);
    private final String ev = "embeded_ad";
    private final Ue gG = new Ue(Looper.getMainLooper(), this);
    private final AtomicBoolean VM = new AtomicBoolean(false);
    private final AtomicInteger oWW = new AtomicInteger(0);
    private final AtomicInteger qj = new AtomicInteger(0);
    private final AtomicInteger nro = new AtomicInteger(0);
    private boolean eU = false;
    int aGH = -1;
    protected com.bytedance.sdk.openadsdk.nlS.ui ui = new com.bytedance.sdk.openadsdk.nlS.ui() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.8
        @Override // com.bytedance.sdk.openadsdk.nlS.ui
        public void eli() {
            if (!TTPlayableLandingPageActivity.this.isFinishing() && com.bytedance.sdk.openadsdk.core.model.KM.nn(TTPlayableLandingPageActivity.this.Vy) && com.bytedance.sdk.openadsdk.core.model.KM.Dfc(TTPlayableLandingPageActivity.this.Vy)) {
                TTPlayableLandingPageActivity.this.gG.removeMessages(2);
                TTPlayableLandingPageActivity.this.gG.sendMessage(TTPlayableLandingPageActivity.this.eli(1, 0));
            }
        }
    };
    private int FS = 1;

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void Cp() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void DbA(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public View Dfc() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void FC() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public List<ev> KM() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void QX() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void aGH(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void aqO() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void dV() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void du() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void e_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(String str, JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void eli(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean eli() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public boolean eli(long j, boolean z) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void f_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void kb() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void nn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message eli(int i, int i2) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i;
        if (i == 3) {
            obtain.arg2 = i2;
        }
        return obtain;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!nn.ui()) {
            finish();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            dV.DbA(this);
            ui();
        } catch (Throwable unused) {
        }
        DbA(bundle);
        ev evVar = this.Vy;
        if (evVar == null) {
            return;
        }
        this.jh = evVar.CQP();
        int aqO = com.bytedance.sdk.openadsdk.core.model.KM.aqO(this.Vy);
        if (aqO == 0) {
            setRequestedOrientation(14);
        } else if (aqO == 1) {
            setRequestedOrientation(1);
        } else if (aqO == 2) {
            setRequestedOrientation(0);
            this.FS = 2;
        }
        this.nn = this;
        try {
            setContentView(nlS());
            Xb();
            NU();
            Vy();
            this.Za.eli(this);
            this.Za.eli(false, (com.bytedance.sdk.openadsdk.nlS.MGA) null);
            nGm();
            Os.eli.eli(SystemClock.elapsedRealtime() - elapsedRealtime, this.Vy, "embeded_ad", this.cyF, this.GB);
            com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.Za;
            if (eliVar != null) {
                eliVar.eli();
            }
        } catch (Throwable unused2) {
            finish();
        }
    }

    private View nlS() {
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(this);
        os.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.Za = new com.bytedance.sdk.openadsdk.Xb.eli.eli(this.nn, this.Vy, this.FS, this.eU, os, true);
        int DbA = SSo.DbA(this, 5.0f);
        this.NU = new com.bytedance.sdk.openadsdk.core.ui.aGH(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(SSo.DbA(this, 28.0f), SSo.DbA(this, 28.0f));
        layoutParams.rightMargin = SSo.DbA(this, 56.0f);
        layoutParams.topMargin = SSo.DbA(this, 20.0f);
        layoutParams.gravity = 8388661;
        this.NU.setLayoutParams(layoutParams);
        this.NU.setPadding(DbA, DbA, DbA, DbA);
        this.NU.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
        this.NU.setScaleType(ImageView.ScaleType.CENTER);
        this.NU.setImageDrawable(du.eli(this, "tt_unmute_wrapper"));
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(this);
        this.nlS = agh;
        agh.setPadding(DbA, DbA, DbA, DbA);
        this.nlS.setScaleType(ImageView.ScaleType.CENTER);
        this.nlS.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
        this.nlS.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(dV.eli(), "tt_reward_full_feedback"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(SSo.DbA(this, 28.0f), SSo.DbA(this, 28.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.rightMargin = SSo.DbA(this, 16.0f);
        layoutParams2.topMargin = SSo.DbA(this, 20.0f);
        this.nlS.setLayoutParams(layoutParams2);
        this.du = new com.bytedance.sdk.openadsdk.core.ui.aGH(this);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(SSo.DbA(this, 28.0f), SSo.DbA(this, 28.0f));
        layoutParams3.gravity = 8388659;
        layoutParams3.topMargin = SSo.DbA(this, 20.0f);
        layoutParams3.leftMargin = SSo.DbA(this, 16.0f);
        this.du.setLayoutParams(layoutParams3);
        this.du.setPadding(DbA, DbA, DbA, DbA);
        this.du.setScaleType(ImageView.ScaleType.FIT_XY);
        this.du.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
        this.du.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(this, "tt_white_lefterbackicon_titlebar"));
        this.du.setVisibility(0);
        os.addView(this.NU);
        os.addView(this.nlS);
        os.addView(this.du);
        return os;
    }

    private void NU() {
        if (this.Vy.yw() == 4) {
            this.KM = com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this.nn, "interaction");
        }
    }

    private void nGm() {
        int i = dV.aGH().gG(String.valueOf(this.Vy.RTg())).dV;
        if (i >= 0) {
            this.gG.sendEmptyMessageDelayed(1, i * 1000);
        } else {
            SSo.eli((View) this.du, 0);
        }
    }

    private void DbA(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                this.bf = intent.getStringExtra("url");
                this.Xb = intent.getIntExtra("source", -1);
                this.ujq = intent.getBooleanExtra("ad_pending_download", false);
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.Vy = com.bytedance.sdk.openadsdk.core.DbA.eli(new JSONObject(stringExtra));
                    } catch (Exception e) {
                        Xb.eli("TTPWPActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e);
                    }
                }
                this.aqO = intent.getStringExtra("adid");
                this.dV = intent.getStringExtra("log_extra");
                this.GB = intent.getStringExtra("gecko_id");
                this.CMM = intent.getStringExtra("web_title");
            } else {
                ev eli = com.bytedance.sdk.openadsdk.core.Ue.eli().eli(com.bytedance.sdk.openadsdk.core.Ue.eli(intent));
                this.Vy = eli;
                if (eli != null) {
                    this.bf = eli.wC();
                    this.Xb = this.Vy.aAs();
                    this.ujq = this.Vy.nlS();
                    this.aqO = this.Vy.umh();
                    this.dV = this.Vy.eu();
                    this.GB = this.Vy.QxD();
                    this.CMM = this.Vy.Pf();
                }
            }
        }
        if (bundle != null) {
            try {
                ev eli2 = com.bytedance.sdk.openadsdk.core.Ue.eli().eli(bundle.getInt("meta_index", -1));
                this.Vy = eli2;
                if (eli2 != null) {
                    this.aqO = eli2.umh();
                    this.dV = this.Vy.eu();
                    this.GB = this.Vy.QxD();
                    this.CMM = this.Vy.Pf();
                    this.bf = this.Vy.wC();
                    this.Xb = this.Vy.aAs();
                    this.ujq = this.Vy.nlS();
                }
            } catch (Throwable unused) {
            }
        }
        if (this.Vy == null) {
            finish();
            return;
        }
        try {
            this.eU = dV.aGH().aqO(this.Vy.XU().getCodeId());
        } catch (Throwable th) {
            Xb.Os("TTPWPActivity", th.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            int eli = this.Vy != null ? com.bytedance.sdk.openadsdk.core.Ue.eli().eli(this.Vy) : -1;
            this.aGH = eli;
            bundle.putInt("meta_index", eli);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private void Xb() {
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = this.du;
        if (agh != null) {
            agh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTPlayableLandingPageActivity.this.dZ != null) {
                        TTPlayableLandingPageActivity.this.dZ.wC();
                    }
                    TTPlayableLandingPageActivity.this.gG.sendMessage(TTPlayableLandingPageActivity.this.eli(4, 0));
                    TTPlayableLandingPageActivity.this.eli("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = this.nlS;
        if (agh2 != null) {
            agh2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.Os();
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.ui.aGH agh3 = this.NU;
        if (agh3 != null) {
            agh3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.eU = !r2.eU;
                    TTPlayableLandingPageActivity tTPlayableLandingPageActivity = TTPlayableLandingPageActivity.this;
                    tTPlayableLandingPageActivity.MGA(tTPlayableLandingPageActivity.eU);
                    if (TTPlayableLandingPageActivity.this.Cp != null) {
                        TTPlayableLandingPageActivity.this.Cp.eli(TTPlayableLandingPageActivity.this.eU);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.Vy, "embeded_ad", str);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.aGH >= 0) {
            com.bytedance.sdk.openadsdk.core.Ue.eli().Os(this.aGH);
            this.aGH = -1;
        }
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.dZ;
        if (uiVar != null) {
            uiVar.aAs();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        qj qjVar = this.nGm;
        if (qjVar != null) {
            qjVar.du();
            com.bytedance.sdk.component.FC.MGA mga = this.MGA;
            if (mga != null) {
                this.nGm.DbA(mga.getVisibility() == 0);
            }
        }
        qj qjVar2 = this.QX;
        if (qjVar2 != null) {
            qjVar2.du();
        }
        com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.Cp;
        if (wCVar != null) {
            wCVar.Os(true);
        }
        nlS nls = this.SSo;
        if (nls != null) {
            nls.kb();
        }
        if (DeviceUtils.kb() == 0) {
            this.eU = true;
        }
        MGA(this.eU);
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.Za;
        if (eliVar != null) {
            eliVar.DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        qj qjVar = this.nGm;
        if (qjVar != null) {
            qjVar.DbA(false);
        }
        com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.Cp;
        if (wCVar != null) {
            wCVar.eli(true);
            this.Cp.Os(false);
        }
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.Za;
        if (eliVar != null) {
            eliVar.Os();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.dZ;
        if (uiVar != null) {
            uiVar.FC();
        }
        nlS nls = this.SSo;
        if (nls != null) {
            nls.wC();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        bf();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void DbA() {
        bf();
    }

    private void bf() {
        super.onBackPressed();
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.dZ;
        if (uiVar != null) {
            uiVar.wC();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseLandingPageActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.Ue.eli().Os(this.Vy);
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.Za;
        if (eliVar != null) {
            eliVar.aGH();
        }
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.dZ;
        if (uiVar != null) {
            uiVar.eli(true);
            this.dZ.nlS();
        }
        this.gG.removeCallbacksAndMessages(null);
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.GB)) {
            Os.eli.eli(this.qj.get(), this.oWW.get(), this.Vy);
        }
        com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.cyF);
        com.bytedance.sdk.component.FC.MGA mga = this.MGA;
        if (mga != null) {
            cyF.eli(mga.getWebView());
            this.MGA.aqO();
        }
        this.MGA = null;
        qj qjVar = this.nGm;
        if (qjVar != null) {
            qjVar.nlS();
        }
        qj qjVar2 = this.QX;
        if (qjVar2 != null) {
            qjVar2.nlS();
        }
        com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.Cp;
        if (wCVar != null) {
            wCVar.cyF();
        }
        nlS nls = this.SSo;
        if (nls != null) {
            nls.aGH(true);
        }
        KM km = this.eli;
        if (km != null) {
            km.DbA();
        }
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        int i = message.what;
        if (i == 1) {
            SSo.eli((View) this.du, 0);
            return;
        }
        if (i != 2) {
            return;
        }
        aAs aas = this.Dfc;
        if (aas == null || !aas.aGH()) {
            int i2 = message.arg1;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                if (message.arg2 != 0) {
                    jSONObject.put("remove_loading_page_reason", message.arg2);
                }
                jSONObject.put("playable_url", this.bf);
                aAs aas2 = this.Dfc;
                jSONObject.put("duration", aas2 != null ? aas2.getDisplayDuration() : 0L);
            } catch (JSONException e) {
                Xb.eli("TTPWPActivity", "handleMsg json error", e);
            }
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.Vy, "embeded_ad", "remove_loading_page", jSONObject);
            this.gG.removeMessages(2);
            aAs aas3 = this.Dfc;
            if (aas3 != null) {
                aas3.Os();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.aGH
    public void ui(boolean z) {
        com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga;
        this.ujq = true;
        this.Ue = z;
        if (!z) {
            try {
                Toast.makeText(this.nn, "Download later", 0).show();
            } catch (Throwable unused) {
            }
        }
        if (!this.Ue || (mga = this.KM) == null) {
            return;
        }
        mga.Os(this.Vy);
    }

    protected void Os() {
        if (this.Vy == null || isFinishing()) {
            return;
        }
        if (this.Os.get()) {
            CMM();
            return;
        }
        if (this.eli == null) {
            aGH();
        }
        this.eli.eli(new KM.eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.KM.eli
            public void eli() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.KM.eli
            public void eli(int i, String str) {
                if (TTPlayableLandingPageActivity.this.Os.get() || TextUtils.isEmpty(str)) {
                    return;
                }
                TTPlayableLandingPageActivity.this.Os.set(true);
                TTPlayableLandingPageActivity.this.ev();
            }
        });
        KM km = this.eli;
        if (km != null) {
            km.eli();
        }
    }

    void aGH() {
        TTPlayableLandingPageActivity tTPlayableLandingPageActivity;
        if (this.Vy != null) {
            tTPlayableLandingPageActivity = this;
            tTPlayableLandingPageActivity.eli = new com.bytedance.sdk.openadsdk.Os.Os(tTPlayableLandingPageActivity, this.Vy.eu(), this.Vy.mS(), "", this.Vy);
        } else {
            tTPlayableLandingPageActivity = this;
        }
        if (tTPlayableLandingPageActivity.DbA == null) {
            tTPlayableLandingPageActivity.DbA = new TTAdDislikeToast(this);
            ((FrameLayout) findViewById(R.id.content)).addView(tTPlayableLandingPageActivity.DbA);
        }
    }

    private void CMM() {
        TTAdDislikeToast tTAdDislikeToast = this.DbA;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeTip());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        TTAdDislikeToast tTAdDislikeToast = this.DbA;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
        }
    }

    protected void MGA(boolean z) {
        Drawable eli;
        try {
            this.eU = z;
            if (z) {
                eli = du.eli(this.nn, "tt_mute_wrapper");
            } else {
                eli = du.eli(this.nn, "tt_unmute_wrapper");
            }
            this.NU.setImageDrawable(eli);
            com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.Cp;
            if (wCVar != null) {
                wCVar.eli(z);
            }
            com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.Za;
            if (eliVar != null) {
                eliVar.eli(z);
            }
        } catch (Exception e) {
            Xb.Os("TTPWPActivity", e.getMessage());
        }
    }

    private void Vy() {
        com.bytedance.sdk.openadsdk.core.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.core.DbA.eli(this, this.Vy, "embeded_ad", this.Xb) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.6
            @Override // com.bytedance.sdk.openadsdk.core.DbA.eli, com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
            public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                ev evVar = this.MGA;
                if (evVar == null || evVar.Yw() != 1 || z) {
                    super.eli(view, f, f2, f3, f4, sparseArray, z);
                    TTPlayableLandingPageActivity.this.gG();
                    TTPlayableLandingPageActivity.this.ujq = true;
                    TTPlayableLandingPageActivity.this.Ue = true;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("playable_url", TTPlayableLandingPageActivity.this.bf);
                    } catch (JSONException e) {
                        Xb.eli("TTPWPActivity", "onClick JSON ERROR", e);
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(TTPlayableLandingPageActivity.this.Vy, this.kb, "click_playable_download_button_loading", jSONObject);
                }
            }
        };
        eliVar.eli(this.KM);
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar2 = this.Za;
        if (eliVar2 != null) {
            eliVar2.eli(eliVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG() {
        com.bytedance.sdk.openadsdk.core.Ue.eli().DbA(this.Vy);
    }

    public void ui() {
        SSo.eli((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.7
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (TTPlayableLandingPageActivity.this.isFinishing()) {
                            return;
                        }
                        TTPlayableLandingPageActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SSo.eli((Activity) TTPlayableLandingPageActivity.this);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        Xb.Os("TTPWPActivity", e.getMessage());
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA
    public void MGA() {
        gG();
    }
}

package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.bytedance.sdk.component.utils.HomeWatcherReceiver;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.Xb.kb;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.ironsource.C3040d4;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FC implements Handler.Callback {
    private static final kb.eli aAs = new kb.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.1
    };
    private com.bytedance.sdk.openadsdk.Xb.wC CMM;
    private final eli Dfc;
    private boolean FC;
    private final ev NU;
    private com.bytedance.sdk.openadsdk.core.widget.aAs QX;
    private volatile boolean Vy;
    private HomeWatcherReceiver bf;
    private dV dV;
    private volatile boolean du;
    private boolean ev;
    private boolean gG;
    private final Activity nlS;
    private final String nn;
    private boolean ujq;
    private boolean wC;
    protected final AtomicBoolean eli = new AtomicBoolean(false);
    private final Handler aqO = new Handler(this);
    boolean DbA = false;
    boolean Os = false;
    long aGH = 0;
    int ui = 0;
    int MGA = 0;
    int kb = 0;
    private int nGm = 1;
    private boolean Xb = true;
    private final com.bytedance.sdk.openadsdk.nlS.ui Ue = new com.bytedance.sdk.openadsdk.nlS.ui() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.8
        @Override // com.bytedance.sdk.openadsdk.nlS.ui
        public void eli() {
            if (!FC.this.Dfc.SSo.isFinishing() && FC.this.Dfc.DbA.CJ() && KM.Dfc(FC.this.Dfc.DbA)) {
                FC.this.aqO.removeMessages(800);
                FC.this.aqO.sendMessage(FC.eli(1, 0));
            }
        }
    };

    public FC(eli eliVar) {
        this.wC = true;
        this.Dfc = eliVar;
        this.nlS = eliVar.SSo;
        this.nn = eliVar.ui;
        ev evVar = eliVar.DbA;
        this.NU = evVar;
        this.wC = KM.kb(evVar);
    }

    public static Message eli(int i, int i2) {
        Message obtain = Message.obtain();
        obtain.what = 800;
        obtain.arg1 = i;
        if (i == 3) {
            obtain.arg2 = i2;
        }
        return obtain;
    }

    public void eli(int i) {
        if (this.wC) {
            if (i == 5) {
                this.FC = true;
                if (KM.CMM(this.NU)) {
                    this.aqO.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
                    this.Dfc.jh.sendEmptyMessage(600);
                }
            }
            this.aqO.sendMessage(eli(i, 0));
        }
    }

    public void eli() {
        if (this.wC && !this.ev) {
            this.ev = true;
            this.dV = this.Dfc.qj;
            this.nGm = this.Dfc.QI;
            bf();
            if (CMM() && KM.dV(this.NU) && KM.Dfc(this.NU)) {
                Handler handler = this.aqO;
                handler.sendMessageDelayed(handler.obtainMessage(800, 2, KM.eli(2)), KM.QX(this.NU) * 1000);
            }
        }
    }

    public void eli(final com.bytedance.sdk.openadsdk.nlS.MGA mga, boolean z) {
        com.bytedance.sdk.openadsdk.Dfc.DbA dbA;
        com.bytedance.sdk.component.eli.dV DbA;
        com.bytedance.sdk.openadsdk.Xb.wC ui;
        if (this.wC && KM.kb(this.NU) && this.Dfc.Za) {
            if (com.bytedance.sdk.openadsdk.core.FC.DbA().dV()) {
                com.bytedance.sdk.openadsdk.Xb.kb.eli(aAs);
            }
            com.bytedance.sdk.openadsdk.Xb.eli eliVar = new com.bytedance.sdk.openadsdk.Xb.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.2
                @Override // com.bytedance.sdk.openadsdk.Xb.eli
                public void eli(int i, String str) {
                    super.eli(i, str);
                    if (FC.this.QX == null || !FC.this.QX.isShown()) {
                        return;
                    }
                    FC.this.aqO.sendMessage(FC.eli(3, KM.eli(i)));
                }

                @Override // com.bytedance.sdk.openadsdk.Xb.eli
                public com.bytedance.sdk.openadsdk.Xb.aGH eli() {
                    return FC.Xb();
                }

                @Override // com.bytedance.sdk.openadsdk.Xb.eli
                public void DbA() {
                    FC.this.Dfc.qj.nlS().Os(true);
                    com.bytedance.sdk.openadsdk.nlS.MGA mga2 = mga;
                    if (mga2 != null) {
                        mga2.eli();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.Xb.eli
                public void eli(JSONObject jSONObject) {
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(FC.this.NU, FC.this.nn, "playable_track", jSONObject);
                }
            };
            com.bytedance.sdk.openadsdk.Xb.Os os = new com.bytedance.sdk.openadsdk.Xb.Os() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.3
                @Override // com.bytedance.sdk.openadsdk.Xb.Os
                public void eli(String str, JSONObject jSONObject) {
                    FC.this.Dfc.qj.nlS().eli(str, jSONObject);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cid", this.NU.umh());
                jSONObject.put("log_extra", this.NU.eu());
                ui = com.bytedance.sdk.openadsdk.Xb.wC.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), this.Dfc.qj.aAs().getWebView(), os, eliVar).kb(this.Dfc.qj.gG()).ui(com.bytedance.sdk.openadsdk.common.DbA.eli(com.bytedance.sdk.openadsdk.core.dV.eli())).eli(com.bytedance.sdk.openadsdk.common.DbA.eli()).Os(jSONObject).eli("sdkEdition", com.bytedance.sdk.openadsdk.common.DbA.Os()).DbA(com.bytedance.sdk.openadsdk.common.DbA.ui()).aGH(com.bytedance.sdk.openadsdk.common.DbA.aGH()).aGH(false).eli(z).eli(KM.QX(this.NU)).DbA(KM.QX(this.NU)).ui(KM.dV(this.NU));
                this.CMM = ui;
            } catch (Exception unused) {
                if (this.CMM == null) {
                    dbA = new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.4
                        @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                        public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("PlayablePlugin_init").DbA(jSONObject2.toString());
                        }
                    };
                }
            } catch (Throwable th) {
                if (this.CMM == null) {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli("PlayablePlugin_init", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.4
                        @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                        public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("PlayablePlugin_is_null", true);
                            return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("PlayablePlugin_init").DbA(jSONObject2.toString());
                        }
                    });
                }
                throw th;
            }
            if (ui == null) {
                dbA = new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.4
                    @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                    public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("PlayablePlugin_is_null", true);
                        return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("PlayablePlugin_init").DbA(jSONObject2.toString());
                    }
                };
                com.bytedance.sdk.openadsdk.Dfc.Os.eli("PlayablePlugin_init", false, dbA);
            }
            if (this.CMM != null && !TextUtils.isEmpty(KM.du(this.NU))) {
                this.CMM.Os(KM.du(this.NU));
            }
            com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
            if (wCVar != null) {
                Set<String> du = wCVar.du();
                final WeakReference weakReference = new WeakReference(this.CMM);
                for (String str : du) {
                    if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (DbA = this.Dfc.qj.nlS().DbA()) != null) {
                        DbA.eli(str, new com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.5
                            @Override // com.bytedance.sdk.component.eli.ui
                            public JSONObject eli(JSONObject jSONObject2, com.bytedance.sdk.component.eli.MGA mga2) {
                                try {
                                    com.bytedance.sdk.openadsdk.Xb.wC wCVar2 = (com.bytedance.sdk.openadsdk.Xb.wC) weakReference.get();
                                    if (wCVar2 == null) {
                                        return null;
                                    }
                                    return wCVar2.aGH(eli(), jSONObject2);
                                } catch (Throwable unused2) {
                                    return null;
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.Xb.aGH Xb() {
        String MGA = com.bytedance.sdk.openadsdk.common.DbA.MGA();
        MGA.hashCode();
        switch (MGA) {
            case "2g":
                return com.bytedance.sdk.openadsdk.Xb.aGH.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.Xb.aGH.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.Xb.aGH.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.Xb.aGH.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.Xb.aGH.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.Xb.aGH.TYPE_UNKNOWN;
        }
    }

    private void bf() {
        if (this.wC) {
            this.QX = (com.bytedance.sdk.openadsdk.core.widget.aAs) this.Dfc.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.FYe);
        }
    }

    private boolean CMM() {
        if (this.QX == null) {
            return false;
        }
        if (this.NU.CJ() && KM.dV(this.NU)) {
            this.QX.DbA(this.NU, this.nGm);
            return true;
        }
        this.QX.Os();
        return false;
    }

    public void DbA() {
        if (this.wC && !this.eli.getAndSet(true)) {
            this.dV.Cp();
            if (KM.wC(this.NU)) {
                this.dV.kb();
            }
        }
    }

    public void eli(DownloadListener downloadListener) {
        com.bytedance.sdk.component.FC.MGA du;
        if (this.wC && (du = this.dV.du()) != null) {
            String ev = ev();
            if (TextUtils.isEmpty(ev)) {
                return;
            }
            du.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.eli.ui(this.nlS, this.dV.NU(), this.NU.umh(), null, false) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.6
                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    if (FC.this.Xb) {
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), FC.this.NU, FC.this.nn, "loading_h5_success");
                    }
                    super.onPageFinished(webView, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    FC.this.Xb = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    FC.this.Xb = false;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    FC.this.Xb = false;
                }
            });
            du.a_(ev);
            du.setDisplayZoomControls(false);
            du.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.dV.NU(), this.dV.nn()));
            du.setDownloadListener(downloadListener);
        }
    }

    private String ev() {
        String str;
        String ev = com.bytedance.sdk.openadsdk.core.dV.aGH().ev();
        if (TextUtils.isEmpty(ev) || this.NU.pu() == null) {
            return ev;
        }
        String DbA = this.NU.pu().DbA();
        double aGH = this.NU.pu().aGH();
        int ui = this.NU.pu().ui();
        if (this.NU.SjY() != null && !TextUtils.isEmpty(this.NU.SjY().eli())) {
            str = this.NU.SjY().eli();
        } else {
            str = "";
        }
        String umh = this.NU.umh();
        String Os = this.NU.pu().Os();
        String eli = this.NU.pu().eli();
        String DbA2 = this.NU.pu().DbA();
        String Pf = this.NU.Pf();
        StringBuilder sb = new StringBuilder("appname=");
        sb.append(URLEncoder.encode(DbA)).append("&stars=").append(aGH).append("&comments=").append(ui).append("&icon=").append(URLEncoder.encode(str)).append("&downloading=true&id=").append(URLEncoder.encode(umh)).append("&packageName=").append(URLEncoder.encode(Os)).append("&downloadUrl=").append(URLEncoder.encode(eli)).append("&name=").append(URLEncoder.encode(DbA2)).append("&orientation=").append(this.nGm == 1 ? C3040d4.h.D : C3040d4.h.C).append("&apptitle=").append(URLEncoder.encode(Pf));
        return ev + "?" + ((Object) sb);
    }

    public void Os() {
        if (this.wC && !this.ujq) {
            this.ujq = true;
            Os(false);
            eli(this.nlS.getApplicationContext());
            com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
            if (wCVar != null) {
                wCVar.cyF();
            }
            this.aqO.removeCallbacksAndMessages(null);
        }
    }

    public void eli(boolean z) {
        if (this.wC && z) {
            this.dV.aAs().setDomStorageEnabled(true);
        }
    }

    public void DbA(boolean z) {
        if (this.wC) {
            if (z) {
                try {
                    if (!TextUtils.isEmpty(this.dV.gG()) && this.dV.ev() != 0) {
                        com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli(this.dV.gG(), this.dV.ev(), this.dV.Vy());
                    }
                } catch (Throwable unused) {
                }
            }
            if (z) {
                try {
                    if (TextUtils.isEmpty(this.dV.gG())) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli().DbA(this.dV.gG());
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void aGH() {
        if (this.wC) {
            try {
                HomeWatcherReceiver homeWatcherReceiver = new HomeWatcherReceiver();
                this.bf = homeWatcherReceiver;
                homeWatcherReceiver.eli(new HomeWatcherReceiver.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.FC.7
                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.eli
                    public void eli() {
                        FC.this.Os = true;
                    }

                    @Override // com.bytedance.sdk.component.utils.HomeWatcherReceiver.eli
                    public void DbA() {
                        FC.this.Os = true;
                    }
                });
                this.nlS.getApplicationContext().registerReceiver(this.bf, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Throwable unused) {
            }
        }
    }

    private void eli(Context context) {
        if (this.wC) {
            try {
                this.bf.eli(null);
                context.getApplicationContext().unregisterReceiver(this.bf);
            } catch (Throwable unused) {
            }
        }
    }

    public void eli(String str) {
        if (this.wC && this.Os) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.aGH);
            } catch (JSONException e) {
                Xb.eli("TTAD.RFPM", "sendPlayableEvent error", e);
            }
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.NU, this.nn, str, jSONObject);
            if ("return_foreground".equals(str)) {
                this.Os = false;
            }
        }
    }

    public void ui() {
        if (this.wC && this.aGH <= 0) {
            this.aGH = System.currentTimeMillis();
            Handler handler = this.aqO;
            handler.sendMessage(handler.obtainMessage(DescriptorProtos.Edition.EDITION_LEGACY_VALUE, FC(), 0));
            Os(true);
        }
    }

    public void eli(JSONObject jSONObject) {
        if (this.wC && jSONObject != null) {
            try {
                jSONObject.put("duration", System.currentTimeMillis() - this.aGH);
            } catch (JSONException e) {
                Xb.eli("TTAD.RFPM", "endShow json error", e);
            }
        }
    }

    public void DbA(int i) {
        com.bytedance.sdk.openadsdk.core.widget.aAs aas;
        if (this.wC && (aas = this.QX) != null) {
            aas.setProgress(i);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.ui uiVar) {
        com.bytedance.sdk.openadsdk.core.widget.aAs aas;
        if (!this.wC || (aas = this.QX) == null || aas.getDownloadButton() == null) {
            return;
        }
        if (KM.dV(this.NU) || KM.CMM(this.NU)) {
            this.QX.getDownloadButton().setOnClickListener(uiVar);
            this.QX.getDownloadButton().setOnTouchListener(uiVar);
        }
    }

    public void MGA() {
        com.bytedance.sdk.openadsdk.Xb.wC wCVar;
        if (this.wC) {
            if (!KM.wC(this.NU) && this.QX.isShown() && this.Dfc.GMY != null) {
                this.Dfc.GMY.eli(FC() * 1000);
            }
            if (KM.nGm(this.NU) && this.QX.isShown()) {
                this.Dfc.cyF.DbA(this.Dfc.Mc);
            }
            com.bytedance.sdk.openadsdk.core.widget.aAs aas = this.QX;
            if (aas != null) {
                aas.Os();
            }
            if (this.eli.getAndSet(true)) {
                return;
            }
            if (this.Dfc.qj.eU() && (wCVar = this.CMM) != null) {
                wCVar.eli(1);
            }
            if (KM.kb(this.NU) && KM.CMM(this.NU)) {
                if (this.Dfc.qj != null && !this.Dfc.qj.eU()) {
                    int i = !this.Dfc.qj.nGm() ? 2 : 3;
                    com.bytedance.sdk.openadsdk.Xb.wC wCVar2 = this.CMM;
                    if (wCVar2 != null) {
                        wCVar2.eli(i);
                    }
                    if (KM.dV(this.Dfc.DbA)) {
                        eli(this.Dfc.MGA, this.Dfc.DbA, this.Dfc.DbA.Txb());
                        ui();
                        this.Dfc.Uv.aqO();
                    }
                    this.Dfc.cyF.eli(false);
                    this.Dfc.qj.cyF();
                    this.Vy = true;
                    this.Dfc.Cp.Os(false);
                    this.Dfc.gG.ui(true);
                    this.Dfc.tGZ = true;
                    if (KM.nGm(this.NU)) {
                        this.aqO.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
                        this.Dfc.Cp.aGH(false);
                        if (this.Dfc.jh != null) {
                            this.Dfc.jh.removeMessages(1);
                            this.Dfc.jh.sendEmptyMessageDelayed(600, 1000L);
                        }
                    }
                    com.bytedance.sdk.openadsdk.Xb.wC wCVar3 = this.CMM;
                    if (wCVar3 != null) {
                        wCVar3.Os(true);
                        return;
                    }
                    return;
                }
                this.Dfc.cyF.eli(this.Dfc.Mc);
            }
        }
    }

    public void kb() {
        if (this.wC && !this.QX.isShown()) {
            com.bytedance.sdk.openadsdk.core.widget.aAs aas = this.QX;
            if (aas != null) {
                aas.DbA(this.NU, this.nGm);
                this.QX.setProgress(this.Dfc.qj.aAs() != null ? this.Dfc.qj.aAs().getProgress() : 0);
            }
            com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
            if (wCVar != null) {
                wCVar.GB();
            }
        }
    }

    public boolean wC() {
        return this.du;
    }

    public void Os(boolean z) {
        if (this.wC) {
            this.du = z;
            if (z) {
                return;
            }
            this.aqO.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
        }
    }

    public int Os(int i) {
        return this.kb - (this.MGA - i);
    }

    public int FC() {
        return this.MGA;
    }

    public int aAs() {
        return this.ui;
    }

    public void eli(int i, ev evVar, boolean z) {
        if (this.wC && evVar != null) {
            this.MGA = evVar.oT();
            this.kb = com.bytedance.sdk.openadsdk.core.dV.aGH().eli(String.valueOf(i), z);
        }
    }

    public void aGH(int i) {
        this.ui = i - 1;
    }

    public void ui(int i) {
        this.ui = i;
    }

    public void du() {
        if (this.wC && this.CMM != null && SSo.aGH(this.Dfc.qj.aAs())) {
            this.CMM.Os(true);
        }
    }

    public void nlS() {
        if (this.wC) {
            com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
            if (wCVar != null) {
                wCVar.Os(false);
            }
            this.aqO.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
        }
    }

    public void aGH(boolean z) {
        com.bytedance.sdk.openadsdk.Xb.wC wCVar;
        if (this.wC && (wCVar = this.CMM) != null) {
            wCVar.Os(z);
        }
    }

    public void ui(boolean z) {
        com.bytedance.sdk.openadsdk.Xb.wC wCVar;
        if (this.wC && (wCVar = this.CMM) != null) {
            wCVar.eli(z);
        }
    }

    public void eli(int i, String str, String str2) {
        if (this.wC) {
            try {
                com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
                if (wCVar != null) {
                    wCVar.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(this.NU));
                    this.CMM.eli(i, str, str2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void eli(boolean z, String str, int i) {
        if (this.wC) {
            try {
                com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
                if (wCVar != null) {
                    wCVar.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(this.NU));
                    this.CMM.eli(z, str, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void DbA(String str) {
        com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
        if (wCVar != null) {
            if (!this.wC) {
                return;
            }
            wCVar.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(this.NU));
            this.CMM.FC(str);
        }
        if (Dfc()) {
            this.Dfc.qj.ui(true);
            this.Dfc.oWW.eli(true);
            this.Dfc.tGZ = true;
        }
    }

    public void Os(String str) {
        com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
        if (wCVar == null || !this.wC) {
            return;
        }
        wCVar.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(this.NU));
        this.CMM.wC(str);
    }

    public void NU() {
        if (this.wC) {
            this.aqO.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
            this.aqO.removeMessages(600);
        }
    }

    public void eli(long j) {
        if (this.wC) {
            Message obtain = Message.obtain();
            obtain.what = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
            obtain.arg1 = aAs();
            this.aqO.sendMessageDelayed(obtain, j);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.bytedance.sdk.openadsdk.core.widget.aAs aas;
        if (message.what == 900) {
            if (!this.du || !KM.dV(this.Dfc.DbA)) {
                return true;
            }
            int i = message.arg1;
            if (i > 0) {
                this.Dfc.Cp.aGH(true);
                int DbA = this.Dfc.gG.DbA(i);
                if (DbA == i) {
                    this.Dfc.Cp.eli(String.valueOf(i), null);
                } else if (DbA > 0) {
                    this.Dfc.Cp.eli(String.valueOf(i), String.format(com.bytedance.sdk.component.utils.ev.eli(this.Dfc.SSo.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(DbA)));
                } else if (KM.wC(this.NU) && !Dfc()) {
                    this.Dfc.Cp.eli(String.valueOf(i), com.bytedance.sdk.component.utils.ev.eli(this.Dfc.SSo.getApplicationContext(), "tt_reward_screen_skip_tx"));
                    this.Dfc.Cp.ui(true);
                } else {
                    this.Dfc.QX.set(true);
                    this.Dfc.Mc.Dfc();
                }
                Message obtain = Message.obtain();
                obtain.what = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
                obtain.arg1 = i - 1;
                this.aqO.sendMessageDelayed(obtain, 1000L);
                aGH(i);
            } else {
                if (KM.wC(this.NU) && (!KM.CMM(this.NU) || !this.Dfc.gG.kb())) {
                    this.Dfc.Cp.Os();
                    this.Dfc.Cp.ui(true);
                } else {
                    this.Dfc.Cp.aGH(false);
                    this.Dfc.QX.set(true);
                    this.Dfc.Mc.Dfc();
                }
                if (!this.FC) {
                    this.gG = true;
                }
            }
            this.Dfc.Uv.QX();
        } else {
            if (message.what != 800 || ((aas = this.QX) != null && (!aas.isShown() || this.QX.aGH()))) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("remove_loading_page_type", message.arg1);
                if (message.arg2 != 0) {
                    jSONObject.put("remove_loading_page_reason", message.arg2);
                }
                String nlS = KM.nlS(this.NU);
                eli eliVar = this.Dfc;
                if (eliVar != null && eliVar.qj != null) {
                    String gG = this.Dfc.qj.gG();
                    if (!TextUtils.isEmpty(gG)) {
                        nlS = gG;
                    }
                }
                jSONObject.put("playable_url", nlS);
                com.bytedance.sdk.openadsdk.core.widget.aAs aas2 = this.QX;
                r3 = aas2 != null ? aas2.getDisplayDuration() : 0L;
                jSONObject.put("duration", r3);
            } catch (JSONException e) {
                Xb.eli("TTAD.RFPM", "handleMessage json error", e);
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.Dfc.DbA, this.Dfc.ui, "remove_loading_page", jSONObject, r3);
            this.aqO.removeMessages(800);
            if (!this.nlS.isFinishing()) {
                this.Dfc.gG.ui();
            }
        }
        return true;
    }

    public com.bytedance.sdk.openadsdk.nlS.ui nn() {
        return this.Ue;
    }

    public void MGA(boolean z) {
        if (this.wC && z && !this.Dfc.gG.kb()) {
            com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.CMM;
            if (wCVar != null) {
                wCVar.eli(1);
            }
            boolean dV = KM.dV(this.NU);
            if ((dV || KM.CMM(this.NU)) && this.NU.CJ() && !KM.Dfc(this.NU)) {
                Handler handler = this.aqO;
                handler.sendMessageDelayed(handler.obtainMessage(800, 0, 0), 1000L);
            }
            if (dV) {
                this.Dfc.gG.wC();
                this.Dfc.qj.DbA(true);
                this.Dfc.qj.Os(true);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.Dfc.DbA, this.nn, "py_loading_success");
            }
        }
    }

    public boolean Dfc() {
        return this.Vy;
    }

    public boolean aqO() {
        return this.gG;
    }

    public boolean dV() {
        com.bytedance.sdk.openadsdk.core.widget.aAs aas = this.QX;
        return aas != null && aas.isShown();
    }

    public com.bytedance.sdk.openadsdk.Xb.wC nGm() {
        return this.CMM;
    }
}

package com.bytedance.sdk.openadsdk.core.wC;

import android.R;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.utils.Cp;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Vy extends com.bytedance.sdk.component.adexpress.ui.eli {
    private final Runnable CMM;
    private final Map<String, com.bytedance.sdk.openadsdk.QX.eli.eli.MGA> Dfc;
    private String FC;
    private String NU;
    private volatile int QX;
    private aAs Xb;
    private com.bytedance.sdk.openadsdk.core.model.ev aAs;
    private qj aqO;
    private final com.bytedance.sdk.component.wC.wC bf;
    private com.bytedance.sdk.component.adexpress.DbA.kb dV;
    private JSONObject du;
    com.bytedance.sdk.openadsdk.utils.eli kb;
    private ev.eli nGm;
    private com.bytedance.sdk.openadsdk.aGH.aGH.ui nlS;
    private com.bytedance.sdk.openadsdk.aGH.nlS nn;
    private Context wC;

    public Vy(Context context, com.bytedance.sdk.component.adexpress.DbA.NU nu, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        super(context, nu, themeStatusBroadcastReceiver);
        this.Dfc = Collections.synchronizedMap(new HashMap());
        this.QX = 0;
        this.bf = new com.bytedance.sdk.component.wC.wC("webviewrender_template") { // from class: com.bytedance.sdk.openadsdk.core.wC.Vy.1
            @Override // java.lang.Runnable
            public void run() {
                if (Vy.this.MGA.get()) {
                    return;
                }
                Vy vy = Vy.this;
                vy.du = vy.du().Os();
                Vy vy2 = Vy.this;
                vy2.eli(vy2.du);
                if (Vy.this.QX == 0) {
                    Vy.this.dV();
                }
                com.bytedance.sdk.openadsdk.core.nn.Os().post(Vy.this.CMM);
            }
        };
        this.CMM = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Vy.2
            @Override // java.lang.Runnable
            public void run() {
                if (Vy.this.MGA.get() || Vy.this.dV == null) {
                    return;
                }
                Vy.this.nlS();
                Vy vy = Vy.this;
                Vy.super.eli(vy.dV);
            }
        };
        if (this.aGH == null) {
            return;
        }
        this.wC = context;
        this.FC = nu.aGH();
        this.aAs = evVar;
        this.nlS = uiVar;
        themeStatusBroadcastReceiver.eli(this);
        dV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV() {
        if (this.aGH.getWebView() != null && cyF.MGA()) {
            nGm();
        } else {
            this.QX = 1;
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Vy.3
                @Override // java.lang.Runnable
                public void run() {
                    Vy.this.nGm();
                }
            });
        }
        if (!nn.DbA(this.aAs) || this.DbA) {
            return;
        }
        nn.eli(this.aAs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nGm() {
        if (this.aGH == null || this.aGH.getWebView() == null || this.QX == 2) {
            return;
        }
        this.NU = eli(this.aAs);
        this.aGH.setDisplayZoomControls(false);
        eli(Cp.eli(this.NU));
        NU();
        qj qjVar = new qj(this.wC);
        this.aqO = qjVar;
        qjVar.aGH(true);
        nn();
        this.QX = 2;
    }

    public static String eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        return com.bytedance.sdk.component.adexpress.eli.DbA.DbA.aGH((evVar == null || !evVar.qWy()) ? null : "v3");
    }

    public void nlS() {
        qj qjVar;
        if (this.aGH == null || this.aGH.getWebView() == null || (qjVar = this.aqO) == null) {
            return;
        }
        qjVar.DbA(this.aGH).eli(this.aAs).Os(this.aAs.umh()).aGH(this.aAs.eu()).DbA(dZ.eli(this.FC)).ui(this.aAs.WA()).eli(this).eli(this.du).eli(this.aGH).eli(this.nlS);
    }

    public void NU() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.aAs;
        if (evVar == null || evVar.RY() == null) {
            return;
        }
        this.nGm = this.aAs.RY();
    }

    public void nn() {
        if (this.aGH == null || this.aGH.getWebView() == null) {
            return;
        }
        this.aGH.setBackgroundColor(0);
        this.aGH.setBackgroundResource(R.color.transparent);
        eli(this.aGH);
        if (eli() != null) {
            this.nn = new com.bytedance.sdk.openadsdk.aGH.nlS(this.aAs, eli().getWebView()).DbA(false);
        }
        this.nn.eli(this.nlS);
        this.Xb = new aAs(this.wC, this.aqO, this.aAs, this.nn, du());
        this.aGH.setWebViewClient(this.Xb);
        this.aGH.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.aqO, this.nn));
        com.bytedance.sdk.component.adexpress.ui.ui.eli().eli(this.aGH, this.aqO);
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    protected void FC() {
        super.FC();
        com.bytedance.sdk.openadsdk.utils.eli ui = com.bytedance.sdk.openadsdk.core.Dfc.eli().ui();
        this.kb = ui;
        ui.eli(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    protected void aAs() {
        super.aAs();
        com.bytedance.sdk.openadsdk.utils.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.DbA(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli, com.bytedance.sdk.component.adexpress.DbA.aGH
    public void eli(com.bytedance.sdk.component.adexpress.DbA.kb kbVar) {
        this.dV = kbVar;
        cyF.DbA(this.bf);
    }

    private void eli(com.bytedance.sdk.component.FC.MGA mga) {
        if (mga == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(this.wC).eli(false).eli(mga.getWebView());
            mga.setVerticalScrollBarEnabled(false);
            mga.setHorizontalScrollBarEnabled(false);
            com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(mga);
            mga.nn();
            mga.setUserAgentString(com.bytedance.sdk.openadsdk.utils.QX.eli(mga.getWebView(), BuildConfig.VERSION_CODE));
            mga.setMixedContentMode(0);
            mga.setJavaScriptEnabled(true);
            mga.setJavaScriptCanOpenWindowsAutomatically(true);
            mga.setDomStorageEnabled(true);
            mga.setDatabaseEnabled(true);
            mga.setAllowFileAccess(false);
            mga.setSupportZoom(true);
            mga.setBuiltInZoomControls(true);
            mga.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            mga.setUseWideViewPort(true);
            mga.setCacheMode(-1);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.WebViewRender", e.toString());
        }
    }

    public aAs Dfc() {
        return this.Xb;
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    public com.bytedance.sdk.component.FC.MGA eli() {
        return this.aGH;
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    public void aGH() {
        if (this.MGA.get()) {
            return;
        }
        super.aGH();
        qj qjVar = this.aqO;
        if (qjVar != null) {
            qjVar.Os();
            this.aqO.nlS();
            this.aqO = null;
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.nn;
        if (nls != null) {
            nls.aGH(false);
        }
        com.bytedance.sdk.openadsdk.core.nn.Os().removeCallbacks(this.CMM);
        this.Dfc.clear();
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli, com.bytedance.sdk.component.adexpress.DbA.aGH
    public int Os() {
        return this.aAs.rH();
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    public void MGA() {
        if (eli() == null) {
            return;
        }
        try {
            eli().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    public void wC() {
        super.wC();
        if (this.aqO == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.aqO.eli("expressShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void DbA(int i) {
        if (this.aqO == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("zoom_type", i);
            this.aqO.eli("expressAdViewWillZoom", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.WebViewRender", e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    public void kb() {
        qj qjVar = this.aqO;
        if (qjVar == null) {
            return;
        }
        qjVar.eli("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli
    public void eli(int i) {
        if (i == this.ui) {
            return;
        }
        this.ui = i;
        DbA(i == 0);
    }

    private void DbA(boolean z) {
        if (this.aqO == null || this.aGH == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.aqO.eli("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    public qj aqO() {
        return this.aqO;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.eli
    public void onThemeChanged(int i) {
        if (this.aqO == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException unused) {
        }
        this.aqO.eli("themeChange", jSONObject);
    }

    public static boolean DbA(String str) {
        return "banner_call".equals(str) || "banner_ad".equals(str) || "slide_banner_ad".equals(str) || "banner_ad_landingpage".equals(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.ui.eli, com.bytedance.sdk.component.adexpress.DbA.du
    public void eli(com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        super.eli(nnVar);
        if (this.Os) {
            com.bytedance.sdk.component.utils.FC.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.Vy.4
                @Override // java.lang.Runnable
                public void run() {
                    WebView webView = Vy.this.aGH.getWebView();
                    if (webView != null) {
                        webView.resumeTimers();
                    }
                }
            }, 2000L);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        qj qjVar = this.aqO;
        if (qjVar != null) {
            qjVar.eli(dbA);
        }
    }
}

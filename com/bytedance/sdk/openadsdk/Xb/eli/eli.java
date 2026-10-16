package com.bytedance.sdk.openadsdk.Xb.eli;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Xb.kb;
import com.bytedance.sdk.openadsdk.Xb.ui;
import com.bytedance.sdk.openadsdk.Xb.wC;
import com.bytedance.sdk.openadsdk.aGH.nGm;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.widget.FC;
import com.bytedance.sdk.openadsdk.core.widget.aAs;
import com.bytedance.sdk.openadsdk.nlS.MGA;
import com.bytedance.sdk.openadsdk.utils.QX;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.C3040d4;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private final Context DbA;
    private AtomicBoolean Dfc;
    private final String FC;
    private aAs MGA;
    private volatile boolean NU;
    private final ev Os;
    private InterfaceC0160eli QX;
    private boolean Xb;
    private wC aAs;
    private final int aGH;
    private AtomicBoolean aqO;
    private FC dV;
    private MGA du;
    protected com.bytedance.sdk.component.FC.MGA eli;
    private qj kb;
    private com.bytedance.sdk.openadsdk.core.DbA.eli nGm;
    private boolean nlS;
    private volatile boolean nn;
    private final FrameLayout ui;
    private String wC;

    /* renamed from: com.bytedance.sdk.openadsdk.Xb.eli.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0160eli {
        void eli();
    }

    public eli(Context context, ev evVar, int i, boolean z, FrameLayout frameLayout) {
        this(context, evVar, i, z, frameLayout, false);
    }

    public eli(Context context, ev evVar, int i, boolean z, FrameLayout frameLayout, boolean z2) {
        this.nlS = true;
        this.Dfc = new AtomicBoolean(false);
        this.aqO = new AtomicBoolean(false);
        this.DbA = context;
        this.Os = evVar;
        this.aGH = i;
        String Os = dZ.Os(evVar.XU().getDurationSlotType());
        this.wC = Os;
        int eli = dZ.eli(Os);
        this.Xb = z2;
        if (z2) {
            this.wC = dZ.DbA(eli);
        }
        this.FC = KM.NU(evVar);
        this.ui = frameLayout;
        eli(frameLayout);
        eli(eli);
        Os(z);
        kb();
    }

    private void eli(FrameLayout frameLayout) {
        com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(this.DbA);
        this.eli = mga;
        mga.ui();
        this.eli.setLayerType(2, null);
        this.eli.setVisibility(4);
        this.eli.setBackgroundColor(-16777216);
        this.eli.setEnabled(true);
        this.eli.setTag(this.wC);
        this.eli.setMaterialMeta(this.Os.sO());
        this.eli.setLandingPage(true);
        frameLayout.addView(this.eli, new FrameLayout.LayoutParams(-1, -1));
        FC fc = new FC(this.DbA);
        this.dV = fc;
        fc.eli(this.Os, this.wC, this.nGm, this.Xb);
        frameLayout.addView(this.dV, new FrameLayout.LayoutParams(-1, -1));
        if (this.Os.CJ()) {
            aAs aas = new aAs(this.DbA);
            this.MGA = aas;
            aas.DbA();
            frameLayout.addView(this.MGA, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void eli(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("click_scence", 3);
        this.kb = new qj(this.DbA);
        this.kb.DbA(this.eli).eli(this.Os).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(this.Os)).Os(this.Os.umh()).aGH(this.Os.eu()).DbA(i).ui(this.Os.WA()).eli(this.eli).DbA(this.wC).eli(hashMap).eli(new nGm(3, this.wC, this.Os));
    }

    private void Os(boolean z) {
        dV DbA;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.Os.umh());
            jSONObject.put("log_extra", this.Os.eu());
        } catch (Throwable unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.FC.DbA().dV()) {
            kb.eli(new kb.eli() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.eli.1
            });
        }
        wC eli = wC.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), this.eli.getWebView(), new com.bytedance.sdk.openadsdk.Xb.Os() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.eli.2
            @Override // com.bytedance.sdk.openadsdk.Xb.Os
            public void eli(String str, JSONObject jSONObject2) {
                if (eli.this.kb != null) {
                    eli.this.kb.eli(str, jSONObject2);
                }
            }
        }, new com.bytedance.sdk.openadsdk.Xb.eli() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.eli.3
            @Override // com.bytedance.sdk.openadsdk.Xb.eli
            public com.bytedance.sdk.openadsdk.Xb.aGH eli() {
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

            @Override // com.bytedance.sdk.openadsdk.Xb.eli
            public void DbA() {
                eli.this.kb.Os(true);
                if (eli.this.du != null) {
                    eli.this.du.eli();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Xb.eli
            public void Os() {
                if (eli.this.kb.nn() != null) {
                    eli.this.kb.nn().eli(true);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Xb.eli
            public void eli(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("is_new_playable", 1);
                    if (eli.this.Os.UUL()) {
                        jSONObject3.put("is_pre_render", 1);
                    }
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                } catch (JSONException e) {
                    Xb.Os("PlayableManager", e.getMessage());
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(eli.this.Os, eli.this.wC, "playable_track", jSONObject2);
            }

            @Override // com.bytedance.sdk.openadsdk.Xb.eli
            public void eli(int i, String str) {
                eli.this.nlS = false;
                if (i == 2 || i == 3 || i == 4) {
                    eli.this.eli(2, i);
                } else if (i == 5) {
                    eli.this.eli(3, i);
                } else {
                    eli.this.eli(1, 0);
                }
            }
        });
        this.aAs = eli;
        eli.kb(this.FC).ui(com.bytedance.sdk.openadsdk.common.DbA.eli(com.bytedance.sdk.openadsdk.core.dV.eli())).DbA(com.bytedance.sdk.openadsdk.common.DbA.ui()).eli(com.bytedance.sdk.openadsdk.common.DbA.eli()).aGH(com.bytedance.sdk.openadsdk.common.DbA.aGH()).Os(jSONObject).Os(KM.du(this.Os)).aGH(true).eli(z).Os(false).eli(KM.QX(this.Os)).DbA(KM.QX(this.Os)).eli("sdkEdition", com.bytedance.sdk.openadsdk.common.DbA.Os()).ui(KM.MGA(this.Os)).MGA(this.wC);
        this.aAs.eli(ui.DbA(this.DbA));
        Set<String> du = this.aAs.du();
        final WeakReference weakReference = new WeakReference(this.aAs);
        for (String str : du) {
            if (!"subscribe_app_ad".equals(str) && !"adInfo".equals(str) && !"webview_time_track".equals(str) && !"download_app_ad".equals(str) && (DbA = this.kb.DbA()) != null) {
                DbA.eli(str, new com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.eli.4
                    @Override // com.bytedance.sdk.component.eli.ui
                    public JSONObject eli(JSONObject jSONObject2, com.bytedance.sdk.component.eli.MGA mga) {
                        try {
                            wC wCVar = (wC) weakReference.get();
                            if (wCVar == null) {
                                return null;
                            }
                            return wCVar.aGH(eli(), jSONObject2);
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                });
            }
        }
    }

    private void kb() {
        this.eli.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.eli.ui(com.bytedance.sdk.openadsdk.core.dV.eli(), this.kb, this.Os.umh(), null, true) { // from class: com.bytedance.sdk.openadsdk.Xb.eli.eli.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                try {
                    if (eli.this.Os.nY() != null && !TextUtils.isEmpty(eli.this.Os.nY().NU())) {
                        if (eli.this.aAs != null) {
                            eli.this.aAs.aAs(str);
                        }
                        String NU = KM.NU(eli.this.Os);
                        WebResourceResponse eli = com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(eli.this.Os.nY().NU(), NU, str);
                        if (eli != null) {
                            new Object[]{"Plb res: hit++ ", str};
                            if (eli.this.aAs != null) {
                                eli.this.aAs.du(str);
                            }
                            return eli;
                        }
                        new Object[]{"Plb res: hit no ", str};
                        return super.shouldInterceptRequest(webView, str);
                    }
                    return super.shouldInterceptRequest(webView, str);
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                eli.this.nlS = false;
                if (eli.this.aAs != null) {
                    eli.this.aAs.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(eli.this.Os));
                    eli.this.aAs.eli(i, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceRequest.isForMainFrame()) {
                    eli.this.nlS = false;
                    if (eli.this.aAs == null || webResourceError == null || webResourceRequest == null) {
                        return;
                    }
                    eli.this.aAs.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(eli.this.Os));
                    eli.this.aAs.eli(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    eli.this.nlS = false;
                    if (eli.this.aAs != null) {
                        eli.this.aAs.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(eli.this.Os));
                        eli.this.aAs.eli(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (eli.this.aAs != null) {
                    eli.this.aAs.FC(str);
                }
                if (eli.this.nlS) {
                    eli.this.eli(0, 0);
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), eli.this.Os, eli.this.wC, "py_loading_success");
                }
            }
        });
        this.eli.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.kb) { // from class: com.bytedance.sdk.openadsdk.Xb.eli.eli.6
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (eli.this.MGA == null || eli.this.MGA.getVisibility() != 0) {
                    return;
                }
                eli.this.MGA.setProgress(i);
            }
        });
        com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(this.DbA).eli(false).DbA(false).eli(this.eli.getWebView());
        com.bytedance.sdk.component.FC.MGA mga = this.eli;
        mga.setUserAgentString(QX.eli(mga.getWebView(), BuildConfig.VERSION_CODE));
        this.eli.setMixedContentMode(0);
    }

    public void eli(boolean z, MGA mga) {
        this.du = mga;
        this.aAs.DbA(z);
        com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().DbA(this.Os);
        this.eli.a_(this.FC);
        wC wCVar = this.aAs;
        if (wCVar != null) {
            wCVar.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(this.Os));
            this.aAs.wC(this.FC);
        }
    }

    public void eli() {
        boolean z;
        aAs aas;
        if (this.Dfc.getAndSet(true)) {
            return;
        }
        FrameLayout frameLayout = this.ui;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        Xb.eli("PlayableManager", "showPlayable() called with: hasLoading = [false], loadingViewIsHide = [" + this.nn + C3040d4.i.e);
        if (!this.nn && (aas = this.MGA) != null) {
            aas.DbA(this.Os, this.aGH);
            wC wCVar = this.aAs;
            if (wCVar != null) {
                wCVar.GB();
            }
            z = true;
        } else {
            this.aAs.Os(true);
            qj qjVar = this.kb;
            if (qjVar != null && qjVar.nn() != null) {
                this.kb.nn().kb();
            }
            z = false;
        }
        if (this.aAs != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("webview_state", this.aAs.SSo());
                jSONObject2.put("has_loading", z);
                jSONObject2.put("is_new_playable", 1);
                jSONObject.put("pag_json_data", jSONObject2.toString());
                jSONObject.put("playable_event", "start_show_plb");
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.Os, this.wC, "playable_track", jSONObject);
            this.aAs.MGA(com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(this.Os));
        }
        this.eli.setVisibility(0);
    }

    public void eli(final int i, final int i2) {
        wC wCVar;
        InterfaceC0160eli interfaceC0160eli;
        if (this.nn) {
            return;
        }
        this.nn = true;
        Xb.eli("PlayableManager", "onHidePlayableLoading() called with: hideReason = [" + i + "], errorDetail = [" + i2 + C3040d4.i.e);
        if (i == 2) {
            this.NU = true;
            this.aAs.eli(3);
        } else if (i == 1) {
            this.NU = true;
            this.aAs.eli(2);
        } else if (i == 3) {
            this.NU = true;
            this.aAs.eli(4);
        } else if (i == 0) {
            this.aAs.eli(1);
        }
        if (this.NU && (interfaceC0160eli = this.QX) != null) {
            interfaceC0160eli.eli();
        }
        if (this.Dfc.get() && (wCVar = this.aAs) != null) {
            wCVar.Os(true);
        }
        qj qjVar = this.kb;
        if (qjVar != null && qjVar.nn() != null) {
            this.kb.nn().kb();
        }
        aAs aas = this.MGA;
        if (aas != null) {
            aas.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.eli.7
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.NU) {
                        eli.this.dV.setVisibility(0);
                        eli.this.eli(true);
                    }
                    eli.this.MGA.Os();
                    if (eli.this.Dfc.get()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("remove_loading_page_type", i);
                            jSONObject2.put("remove_loading_page_reason", i2);
                            jSONObject2.put("playable_url", eli.this.FC);
                            jSONObject2.put("duration", eli.this.MGA.getDisplayDuration());
                            jSONObject2.put("is_new_playable", 1);
                            jSONObject.put("pag_json_data", jSONObject2.toString());
                            jSONObject.put("playable_event", "remove_loading_page");
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.aGH.Os.DbA(eli.this.Os, eli.this.wC, "playable_track", jSONObject);
                    }
                }
            });
        }
    }

    public void eli(boolean z) {
        wC wCVar = this.aAs;
        if (wCVar != null) {
            wCVar.eli(z);
        }
    }

    public void DbA() {
        if (!this.Dfc.get() || this.aAs == null) {
            return;
        }
        Xb.eli("PlayableManager", "onResume() called");
        this.aAs.Os(true);
    }

    public void Os() {
        if (!this.Dfc.get() || this.aAs == null) {
            return;
        }
        Xb.eli("PlayableManager", "onPause() called");
        this.aAs.Os(false);
    }

    public void aGH() {
        wC wCVar = this.aAs;
        if (wCVar != null) {
            wCVar.cyF();
        }
        com.bytedance.sdk.component.FC.MGA mga = this.eli;
        if (mga != null) {
            mga.aqO();
        }
        qj qjVar = this.kb;
        if (qjVar != null) {
            qjVar.nlS();
        }
        this.eli = null;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.eli eliVar) {
        this.nGm = eliVar;
        aAs aas = this.MGA;
        if (aas != null && aas.getDownloadButton() != null) {
            com.bytedance.sdk.openadsdk.core.ui.wC downloadButton = this.MGA.getDownloadButton();
            downloadButton.setOnClickListener(eliVar);
            downloadButton.setOnTouchListener(eliVar);
        }
        FC fc = this.dV;
        if (fc != null) {
            fc.setClickListener(eliVar);
        }
    }

    public boolean ui() {
        return this.NU;
    }

    public void eli(InterfaceC0160eli interfaceC0160eli) {
        this.QX = interfaceC0160eli;
    }

    public boolean MGA() {
        qj qjVar = this.kb;
        if (qjVar != null) {
            return qjVar.MGA();
        }
        return false;
    }

    public void DbA(boolean z) {
        wC wCVar = this.aAs;
        if (wCVar != null) {
            wCVar.ui(z);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        qj qjVar = this.kb;
        if (qjVar != null) {
            qjVar.eli(dbA);
        }
    }
}

package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.R;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.component.adexpress.aGH.FC;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.aGH.Os;
import com.bytedance.sdk.openadsdk.core.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.cyF;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.widget.eli.MGA;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.QX;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class dV implements com.bytedance.sdk.openadsdk.nlS.wC {
    private String BDs;
    private boolean BH;
    private boolean CMM;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli Cp;
    qj DbA;
    private int Dfc;
    private boolean FS;
    private final boolean NU;
    private boolean SSo;
    private ILoader TfR;
    private long Ue;
    private boolean Uv;
    private View Vy;
    private boolean Xb;
    private MGA.eli Yw;
    private long Za;
    protected String aGH;
    private com.bytedance.sdk.component.FC.MGA aqO;
    private boolean bf;
    private com.bytedance.sdk.component.FC.MGA dV;
    private boolean dZ;
    private final String du;
    private com.bytedance.sdk.openadsdk.core.widget.eli.ui eU;
    qj eli;
    private View ev;
    private float gG;
    private int nlS;
    private int nn;
    private boolean nro;
    private String ow;
    private com.bytedance.sdk.openadsdk.common.NU qj;
    private com.bytedance.sdk.openadsdk.common.aGH qyC;
    private boolean rQ;
    private int tGZ;
    private boolean tLO;
    com.bytedance.sdk.openadsdk.aGH.nlS ui;
    private float ujq;
    protected com.bytedance.sdk.openadsdk.aGH.aGH.ui wC;
    protected boolean Os = true;
    private boolean nGm = false;
    private final AtomicBoolean QX = new AtomicBoolean(true);
    int MGA = 0;
    String kb = "";
    boolean FC = false;
    private SparseArray<Os.eli> KM = new SparseArray<>();
    private boolean VM = true;
    private float GB = -1.0f;
    private float oWW = -1.0f;
    private boolean cyF = false;
    private long jh = -1;
    private volatile int ikX = 0;
    private int WfR = -1;
    private volatile int QI = 0;
    private volatile int mm = 0;
    private long oc = 0;
    public boolean aAs = false;
    private int gHb = -1;

    public interface aGH {
        void eli(WebView webView, int i);

        void eli(WebView webView, String str);

        void eli(WebView webView, String str, Bitmap bitmap);
    }

    static /* synthetic */ int Dfc(dV dVVar) {
        int i = dVVar.mm;
        dVVar.mm = i + 1;
        return i;
    }

    static /* synthetic */ int NU(dV dVVar) {
        int i = dVVar.QI;
        dVVar.QI = i + 1;
        return i;
    }

    static /* synthetic */ int aqO(dV dVVar) {
        int i = dVVar.ikX;
        dVVar.ikX = i + 1;
        return i;
    }

    public dV(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.Cp = eliVar;
        this.du = eliVar.ui;
        this.NU = eliVar.aGH;
    }

    public void eli() {
        if (this.CMM) {
            return;
        }
        this.CMM = true;
        this.nlS = this.Cp.QI;
        this.nn = this.Cp.oc;
        this.Dfc = this.Cp.rQ;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        DbA();
        this.oc = SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    void DbA() {
        com.bytedance.sdk.openadsdk.common.NU nu;
        this.ev = this.Cp.SSo.findViewById(R.id.content);
        boolean z = this.Cp.kb;
        this.nro = z;
        if (z && (nu = this.qj) != null) {
            this.aqO = nu.aGH();
        } else {
            com.bytedance.sdk.component.FC.MGA mga = (com.bytedance.sdk.component.FC.MGA) this.Cp.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.nn);
            this.aqO = mga;
            if (mga != null && ev.DbA(this.Cp.DbA)) {
                this.aqO.ui();
            } else {
                SSo.eli((View) this.aqO, 8);
            }
        }
        com.bytedance.sdk.component.FC.MGA mga2 = (com.bytedance.sdk.component.FC.MGA) this.Cp.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.aqO);
        this.dV = mga2;
        if (mga2 != null && KM.kb(this.Cp.DbA) && KM.wC(this.Cp.DbA)) {
            this.dV.ui();
            this.dV.setDisplayZoomControls(false);
        } else {
            SSo.eli((View) this.dV, 8);
        }
        com.bytedance.sdk.component.FC.MGA mga3 = this.aqO;
        if (mga3 != null) {
            mga3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (dV.this.aqO == null || dV.this.aqO.getViewTreeObserver() == null) {
                        return;
                    }
                    dV.this.aqO.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = dV.this.aqO.getMeasuredWidth();
                    int measuredHeight = dV.this.aqO.getMeasuredHeight();
                    if (dV.this.aqO.getVisibility() == 0) {
                        dV.this.eli(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        com.bytedance.sdk.component.FC.MGA mga4 = this.dV;
        if (mga4 != null) {
            mga4.setLandingPage(true);
            this.dV.setTag(KM.kb(this.Cp.DbA) ? this.du : "landingpage_endcard");
            this.dV.setWebViewClient(new MGA.eli());
            this.dV.setMaterialMeta(this.Cp.DbA.sO());
        }
    }

    public void eli(String str, final com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        eli(str, new aGH() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.12
            @Override // com.bytedance.sdk.openadsdk.component.reward.eli.dV.aGH
            public void eli(WebView webView, String str2) {
                if (dV.this.Cp.SSo.isFinishing()) {
                    return;
                }
                dV.this.Cp.gG.DbA(dV.this.nGm());
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.eli.dV.aGH
            public void eli(WebView webView, String str2, Bitmap bitmap) {
                if (dV.this.cyF || !KM.dV(dV.this.Cp.DbA)) {
                    return;
                }
                dV.this.cyF = true;
                dV.this.Cp.gG.eli(dV.this.Cp.MGA, dV.this.Cp.DbA, dV.this.Cp.DbA.Txb());
                if (!KM.wC(dV.this.Cp.DbA)) {
                    dV.this.Cp.jh.sendEmptyMessageDelayed(600, dV.this.Cp.gG.FC() * 1000);
                }
                dV.this.Cp.gG.aAs();
                dV.this.Cp.Uv.aqO();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.eli.dV.aGH
            public void eli(WebView webView, int i) {
                try {
                    if (!KM.dV(dV.this.Cp.DbA) || !dV.this.Cp.DbA.CJ() || dV.this.Cp.SSo.isFinishing()) {
                        if (!dV.this.Cp.kb || dV.this.Cp.tLO == null) {
                            return;
                        }
                        dV.this.Cp.tLO.eli(webView, i, dV.this.Yw);
                        return;
                    }
                    dV.this.Cp.gG.Os(i);
                } catch (Exception unused) {
                }
            }
        });
        if (KM.dV(this.Cp.DbA)) {
            eli(this.dV);
            this.Cp.gG.eli(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.13
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    dV.this.Cp.Vy.DbA();
                    com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA2 = dbA;
                    if (dbA2 != null) {
                        dbA2.MGA();
                    }
                }
            });
        }
        this.Cp.gG.Os(this.Cp.BH);
        eli(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.14
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                dV.this.Cp.Vy.DbA();
                com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA2 = dbA;
                if (dbA2 != null) {
                    dbA2.MGA();
                }
            }
        });
    }

    public void eli(com.bytedance.sdk.openadsdk.nlS.MGA mga, String str, final com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        if (this.aqO == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        final ev evVar = this.Cp.DbA;
        if (KM.kb(evVar)) {
            hashMap.put("click_scence", 3);
        } else {
            hashMap.put("click_scence", 2);
        }
        this.wC = tGZ();
        qj qjVar = new qj(this.Cp.SSo);
        this.eli = qjVar;
        qjVar.eli(this.Cp.Uv);
        String WA = evVar.WA();
        this.eli.DbA(this.aqO).eli(evVar).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(evVar)).Os(evVar.umh()).aGH(evVar.eu()).DbA(evVar.Txb() ? 7 : 5).eli(new DbA(this.aqO)).ui(WA).eli(this.aqO).DbA(dV() ? "landingpage_endcard" : str).eli(hashMap).eli(this.wC).eli(new com.bytedance.sdk.openadsdk.core.widget.ui() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.ui
            public void eli() {
                if (dV.this.eU != null) {
                    dV.this.eU.Os();
                }
                com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA2 = dbA;
                if (dbA2 != null) {
                    dbA2.MGA();
                }
            }
        }).eli(new qj.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.15
            @Override // com.bytedance.sdk.openadsdk.core.qj.eli
            public void eli() {
                dV.this.Za();
            }
        });
        HashMap hashMap2 = new HashMap();
        if (KM.wC(evVar)) {
            hashMap2.put("click_scence", 2);
        }
        qj qjVar2 = new qj(this.Cp.SSo);
        this.DbA = qjVar2;
        qjVar2.eli(this.Cp.Uv);
        qj ui = this.DbA.DbA(this.dV).eli(evVar).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(evVar)).Os(evVar.umh()).aGH(evVar.eu()).DbA(evVar.Txb() ? 7 : 5).eli(new DbA(this.dV)).eli(this.dV).ui(WA);
        if (dV()) {
            str = "landingpage_endcard";
        }
        ui.DbA(str).eli(hashMap2).eli(this.wC).eli(new com.bytedance.sdk.openadsdk.core.widget.ui() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.18
            @Override // com.bytedance.sdk.openadsdk.core.widget.ui
            public void eli() {
                if (dV.this.eU != null) {
                    dV.this.eU.Os();
                }
            }
        }).eli(new qj.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.17
            @Override // com.bytedance.sdk.openadsdk.core.qj.eli
            public void eli() {
                dV.this.Za();
            }
        });
        this.eli.eli(new Os(this.aqO));
        this.DbA.eli(new Os(this.dV));
        this.eli.eli(this.Cp.eU.aAs()).eli(this.Cp.BH).eli(mga).eli(this.Cp.gG.du()).eli(new com.bytedance.sdk.openadsdk.nlS.Os() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.19
            @Override // com.bytedance.sdk.openadsdk.nlS.Os
            public void eli(boolean z, int i, String str2) {
                if (z) {
                    dV.this.aAs = true;
                    if (dV.this.rQ) {
                        dV.this.rQ = false;
                        dV dVVar = dV.this;
                        dVVar.eli(dVVar.Cp.tGZ, true);
                    }
                }
                if (!ev.aGH(evVar) || KM.kb(evVar)) {
                    return;
                }
                dV.this.eli(z, i, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.nlS.Os
            public void eli() {
                dV.this.FS = true;
                dV.this.Cp.eU.aAs().performClick();
            }
        });
        this.eli.ui(this.SSo);
        this.DbA.eli(this.Cp.eU.aAs()).eli(new com.bytedance.sdk.openadsdk.nlS.Os() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.2
            @Override // com.bytedance.sdk.openadsdk.nlS.Os
            public void eli(boolean z, int i, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.nlS.Os
            public void eli() {
                dV.this.FS = true;
                dV.this.Cp.eU.aAs().performClick();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Za() {
        this.dZ = true;
        this.tLO = false;
        this.Cp.jh.removeMessages(600);
        this.Cp.jh.removeMessages(IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED);
        this.Cp.jh.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
        this.Cp.Cp.aGH(false);
        this.Cp.QX.set(true);
        this.Cp.Mc.Dfc();
        ev evVar = this.Cp.DbA;
        evVar.ip();
        if (evVar.ip() || !dZ.wC(KM.eli(evVar))) {
            return;
        }
        View aAs = this.Cp.eU.aAs();
        View.OnClickListener onClickListener = (View.OnClickListener) aAs.getTag(aAs.getId());
        if (onClickListener != null) {
            eli eliVar = new eli(this.Cp, aAs, onClickListener);
            aAs.setOnClickListener(eliVar);
            aAs.setOnTouchListener(eliVar);
        }
    }

    public boolean Os() {
        return this.FS;
    }

    public boolean aGH() {
        return this.Uv;
    }

    public void eli(int i, int i2) {
        if (this.eli == null || this.Cp.SSo.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i);
            jSONObject.put("height", i2);
            this.eli.eli(n.g, jSONObject);
        } catch (Exception e) {
            Log.e("TTAD.RFWVM", "", e);
        }
    }

    public void eli(boolean z) {
        this.Os = z;
    }

    public void ui() {
        if (KM.ui(this.Cp.DbA) && this.Cp.Gjg) {
            return;
        }
        MGA();
    }

    public void MGA() {
        ev evVar = this.Cp.DbA;
        if (TextUtils.isEmpty(ev.eli(this.Cp.FS, evVar))) {
            if (evVar != null && !evVar.Ue() && this.TfR == null && dV()) {
                this.ow = evVar.QxD();
                this.TfR = com.bytedance.sdk.openadsdk.kb.DbA.eli().DbA();
                int eli2 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(this.TfR, this.ow);
                this.tGZ = eli2;
                this.WfR = eli2 > 0 ? 2 : 0;
                if (!TextUtils.isEmpty(this.ow)) {
                    com.bytedance.sdk.openadsdk.aGH.nlS nls = this.ui;
                    if (nls != null) {
                        nls.eli(this.WfR);
                    }
                    Os.eli.eli(this.oc, evVar, "landingpage_endcard", this.TfR, this.ow);
                }
            }
            if ((!TextUtils.isEmpty(this.aGH) && this.aGH.contains("play.google.com/store")) || Xb.MGA(evVar) || Xb.ui(evVar)) {
                this.FC = true;
                return;
            }
            Log.d("TTAD.RFWVM", "preLoadEndCardForce: return mShouldPreloadEndCard " + this.Os + ",webViewIsLoading " + this.BH);
            if (this.Os) {
                boolean z = this.Cp.PfW;
                if (this.aqO != null && ((z || !TextUtils.isEmpty(this.aGH)) && ev.DbA(evVar))) {
                    if (this.BH) {
                        return;
                    }
                    String str = this.aGH + "&is_pre_render=1";
                    com.bytedance.sdk.openadsdk.aGH.nlS nls2 = this.ui;
                    if (nls2 != null) {
                        nls2.aGH();
                    }
                    if (KM.kb(evVar)) {
                        com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().DbA(evVar);
                    }
                    bf.eli(this.aqO, str);
                    this.Cp.gG.eli(str);
                    this.BH = true;
                    return;
                }
                if (ev.Os(evVar)) {
                    this.Cp.nro.Os();
                }
            }
        }
    }

    public void kb() {
        ev evVar = this.Cp.DbA;
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = evVar.nY();
        if (nY == null) {
            return;
        }
        String nlS = nY.nlS();
        this.BDs = nlS;
        if (TextUtils.isEmpty(nlS)) {
            return;
        }
        this.BDs = eli(this.BDs, evVar, this.nlS, this.Dfc, this.nn);
        this.dV.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.eli.ui(com.bytedance.sdk.openadsdk.core.dV.eli(), this.DbA, evVar.umh(), this.ui, evVar.XxP() || KM.kb(evVar)) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                if (dV.this.eli(str2)) {
                    return;
                }
                dV.this.bf = false;
                dV.this.MGA = i;
                dV.this.kb = str;
                if (dV.this.wC != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        dV.this.wC.eli(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || !dV.this.eli(webResourceRequest.getUrl().toString())) {
                    dV.this.bf = false;
                    if (dV.this.wC != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (webResourceError != null) {
                                jSONObject.put("code", webResourceError.getErrorCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                            }
                            dV.this.wC.eli(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceError != null) {
                        dV.this.MGA = webResourceError.getErrorCode();
                        dV.this.kb = String.valueOf(webResourceError.getDescription());
                    }
                    if (webResourceRequest == null) {
                        return;
                    }
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    dV.this.bf = false;
                    if (webResourceResponse != null) {
                        dV.this.MGA = webResourceResponse.getStatusCode();
                        dV.this.kb = "onReceivedHttpError";
                    }
                }
                if (dV.this.wC != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (webResourceResponse != null) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        }
                        dV.this.wC.eli(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceRequest != null) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (dV.this.wC != null) {
                    dV.this.wC.MGA();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (dV.this.wC != null) {
                    dV.this.wC.ui();
                }
            }
        });
        this.dV.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.DbA, this.ui) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (!dV.this.Cp.kb || dV.this.Cp.tLO == null) {
                    return;
                }
                dV.this.Cp.tLO.eli(webView, i, dV.this.Yw);
            }
        });
        bf.eli(this.dV, this.BDs);
        this.bf = true;
    }

    public void wC() {
        if (this.aqO == null) {
            return;
        }
        this.QX.set(this.bf);
        if (this.dV.getVisibility() == 0 && this.bf) {
            ikX();
            return;
        }
        this.Cp.Cp.Os(false);
        this.Cp.gG.kb(wC.Os);
        eli(this.eli, true, false);
        DbA(this.eli, false);
        eli(this.eli, false);
        this.aqO.aqO();
        if (this.bf) {
            this.dV.setVisibility(0);
            eli(this.DbA, this.Cp.tGZ, true);
            DbA(this.DbA, true);
            eli(this.DbA, true);
            this.Cp.jh.removeMessages(600);
            if (!this.Cp.cyF.Os(this.Cp.Mc)) {
                this.Cp.Mc.Vy();
            }
        } else {
            if (this.Cp.gG.eli()) {
                this.Cp.gG.eli(5);
            }
            this.Cp.cyF.aGH();
            this.Cp.GMY.eli(this.Cp.wC);
        }
        this.tLO = true;
    }

    private void ikX() {
        this.DbA.eli("showPlayableEndCardOverlay", (JSONObject) null);
        this.Cp.jh.sendEmptyMessageDelayed(600, 1000L);
        this.Cp.jh.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.5
            @Override // java.lang.Runnable
            public void run() {
                dV.this.Za();
            }
        }, 1000L);
        if (this.Cp.GMY != null) {
            this.Cp.GMY.eli(0L);
        }
    }

    public void FC() {
        this.eli.eli("showPlayableEndCardOverlay", (JSONObject) null);
        this.Cp.jh.sendEmptyMessageDelayed(600, 1000L);
        this.Cp.jh.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.6
            @Override // java.lang.Runnable
            public void run() {
                dV.this.Za();
            }
        }, 1000L);
        if (this.Cp.GMY != null) {
            this.Cp.GMY.eli(0L);
        }
    }

    public com.bytedance.sdk.component.FC.MGA aAs() {
        return this.aqO;
    }

    public com.bytedance.sdk.component.FC.MGA du() {
        return this.dV;
    }

    public qj nlS() {
        return this.eli;
    }

    public qj NU() {
        return this.DbA;
    }

    public com.bytedance.sdk.openadsdk.aGH.nlS nn() {
        return this.ui;
    }

    public void Dfc() {
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY;
        ev evVar = this.Cp.DbA;
        String MGA = evVar.MGA();
        if (!TextUtils.isEmpty(MGA) && this.Cp.yKf != null && (this.Cp.yKf.eU() || this.Cp.yKf.dZ().bf())) {
            this.aGH = MGA;
        } else if (!KM.ui(evVar)) {
            this.aGH = KM.NU(evVar);
        } else if (evVar != null && (nY = evVar.nY()) != null) {
            this.aGH = nY.nlS();
        }
        String eli2 = eli(this.aGH, evVar, this.nlS, this.Dfc, this.nn);
        this.aGH = eli2;
        if (TextUtils.isEmpty(eli2)) {
            return;
        }
        this.SSo = this.aGH.contains("use_second_endcard=1");
    }

    private static String eli(String str, ev evVar, int i, int i2, int i3) {
        String str2;
        String str3;
        float Nvn = evVar.Nvn();
        if (!TextUtils.isEmpty(str)) {
            if (i == 1) {
                if (str.contains("?")) {
                    str3 = str + C3040d4.i.c;
                } else {
                    str3 = str + "?";
                }
                str = str3 + "orientation=portrait";
            }
            if (str.contains("?")) {
                str2 = str + C3040d4.i.c;
            } else {
                str2 = str + "?";
            }
            str = str2 + "height=" + i2 + "&width=" + i3 + "&aspect_ratio=" + Nvn;
        }
        return !KM.kb(evVar) ? com.bytedance.sdk.openadsdk.utils.MGA.eli(str) : str;
    }

    public void aqO() {
        com.bytedance.sdk.component.FC.MGA mga = this.aqO;
        if (mga != null) {
            cyF.eli(mga.getWebView());
        }
        com.bytedance.sdk.component.FC.MGA mga2 = this.dV;
        if (mga2 != null) {
            cyF.eli(mga2.getWebView());
        }
        ev evVar = this.Cp.DbA;
        long j = this.Za;
        if (j > 0) {
            if (this.jh > 0) {
                this.Za = j + (SystemClock.elapsedRealtime() - this.jh);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("endcard_overlay_render_type", ev.Os(evVar) ? 7 : 0);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.Cp.DbA, this.du, "second_endcard_duration", jSONObject, this.Za);
        }
        this.aqO = null;
        if (this.wC != null && !Xb.aGH(evVar) && !Xb.ui(evVar) && !ev.Os(evVar)) {
            this.wC.eli(true);
            this.wC.nlS();
        }
        qj qjVar = this.eli;
        if (qjVar != null) {
            qjVar.nlS();
        }
        qj qjVar2 = this.DbA;
        if (qjVar2 != null) {
            qjVar2.nlS();
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.ui;
        if (nls != null) {
            nls.aGH(evVar.XxP() || KM.kb(evVar));
        }
        DeviceUtils.AudioInfoReceiver.DbA(this);
    }

    public void eli(int i) {
        SSo.eli((View) this.aqO, i);
        com.bytedance.sdk.component.FC.MGA mga = this.aqO;
        if (mga != null) {
            SSo.eli((View) mga.getWebView(), i);
        }
        ev evVar = this.Cp.DbA;
        if (this.aqO != null && (evVar.XxP() || KM.kb(evVar))) {
            this.aqO.setLandingPage(true);
            this.aqO.setTag(KM.kb(evVar) ? this.du : "landingpage_endcard");
            this.aqO.setMaterialMeta(evVar.sO());
        }
        if (i == 0 && KM.wC(evVar)) {
            kb();
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.common.NU nu) {
        this.qj = nu;
    }

    public void eli(float f) {
        SSo.eli(this.aqO, f);
    }

    public void DbA(boolean z) {
        eli(this.eli, z);
    }

    public void eli(qj qjVar, boolean z) {
        if (this.eli == null || this.Cp.SSo.isFinishing()) {
            return;
        }
        qjVar.DbA(z);
    }

    private void eli(String str, final aGH agh) {
        com.bytedance.sdk.component.FC.MGA mga;
        final ev evVar = this.Cp.DbA;
        com.bytedance.sdk.component.FC.MGA mga2 = this.aqO;
        if (mga2 == null || mga2.getWebView() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.nlS DbA2 = new com.bytedance.sdk.openadsdk.aGH.nlS(evVar, this.aqO.getWebView(), new com.bytedance.sdk.openadsdk.aGH.du() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.7
            @Override // com.bytedance.sdk.openadsdk.aGH.du
            public void eli(int i) {
                if (TextUtils.isEmpty(dV.this.ow)) {
                    return;
                }
                Os.eli.eli(dV.this.tGZ, dV.this.ikX, dV.this.mm, dV.this.QI - dV.this.mm, evVar, "landingpage_endcard", i);
            }
        }, this.WfR).DbA(true);
        this.ui = DbA2;
        this.Yw = DbA2.eli;
        this.ui.eli(dV() ? "landingpage_endcard" : str);
        this.ui.DbA(this.du);
        this.ui.Os(true);
        this.aqO.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.8
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                if (dV.this.ui != null) {
                    dV.this.ui.DbA(i2);
                }
            }
        });
        if (this.Cp.gG != null) {
            this.ui.eli(this.Cp.gG.aGH());
        }
        com.bytedance.sdk.openadsdk.common.aGH eli2 = dZ.eli(evVar, this.aqO, this.Cp.SSo, this.du);
        this.qyC = eli2;
        if (eli2 != null) {
            eli2.eli(dV() ? "landingpage_endcard" : str);
        }
        if (dV()) {
            dZ.eli(evVar, this.aqO);
        }
        com.bytedance.sdk.openadsdk.core.widget.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.widget.eli.ui(com.bytedance.sdk.openadsdk.core.dV.eli(), this.eli, evVar.umh(), this.qyC, this.ui, evVar.XxP() || KM.kb(evVar)) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.9
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                String str3;
                if (!KM.kb(evVar)) {
                    try {
                        if (TextUtils.isEmpty(dV.this.ow)) {
                            return super.shouldInterceptRequest(webView, str2);
                        }
                        dV.NU(dV.this);
                        WebResourceResponseModel eli3 = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(dV.this.TfR, dV.this.ow, str2);
                        if (eli3 != null && eli3.getWebResourceResponse() != null) {
                            dV.Dfc(dV.this);
                            return eli3.getWebResourceResponse();
                        }
                        if (eli3 != null && eli3.getMsg() == 2) {
                            dV.aqO(dV.this);
                        }
                        return super.shouldInterceptRequest(webView, str2);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.Xb.eli("TTAD.RFWVM", "shouldInterceptRequest url error", th);
                        return super.shouldInterceptRequest(webView, str2);
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                WebResourceResponse eli4 = com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(evVar.nY().NU(), KM.NU(evVar), str2);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (dV.this.wC != null) {
                    FC.eli eli5 = com.bytedance.sdk.component.adexpress.aGH.FC.eli(str2);
                    int i = eli4 != null ? 1 : 2;
                    if (eli5 == FC.eli.HTML) {
                        str3 = str2;
                        dV.this.wC.eli(str3, currentTimeMillis, currentTimeMillis2, i);
                    } else {
                        str3 = str2;
                        if (eli5 == FC.eli.JS) {
                            dV.this.wC.DbA(str3, currentTimeMillis, currentTimeMillis2, i);
                        }
                    }
                } else {
                    str3 = str2;
                }
                if (eli4 != null) {
                    new Object[]{"Plb res: hit++ ", str3};
                    return eli4;
                }
                new Object[]{"Plb res: hit no ", str3};
                return super.shouldInterceptRequest(webView, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.eli("TTAD.RFWVM", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str2, String str3) {
                super.onReceivedError(webView, i, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceError != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                    Log.i("TTAD.RFWVM", "onReceivedError WebResourceError : description=" + ((Object) webResourceError.getDescription()) + "  url =" + webResourceRequest.getUrl().toString());
                }
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || !dV.this.eli(webResourceRequest.getUrl().toString())) {
                    if (webResourceError != null && webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                        dV.this.Cp.gG.eli(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
                    }
                    if (webResourceRequest == null || webResourceRequest.isForMainFrame()) {
                        dV.this.QX.set(false);
                        dV.this.BH = false;
                    }
                    if (dV.this.wC != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (webResourceError != null) {
                                jSONObject.put("code", webResourceError.getErrorCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                            }
                            dV.this.wC.eli(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceError != null) {
                        dV.this.MGA = webResourceError.getErrorCode();
                        dV.this.kb = String.valueOf(webResourceError.getDescription());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                dV.this.Cp.gG.eli(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
                    Log.i("TTAD.RFWVM", "onReceivedHttpError:url =" + webResourceRequest.getUrl().toString());
                }
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    dV.this.QX.set(false);
                    dV.this.BH = false;
                    if (webResourceResponse != null) {
                        dV.this.MGA = webResourceResponse.getStatusCode();
                        dV.this.kb = "onReceivedHttpError";
                    }
                }
                if (dV.this.wC != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (webResourceResponse != null) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        }
                        dV.this.wC.eli(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceRequest != null) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                dV.this.BH = false;
                dV.this.Xb = true;
                if (dV.this.Cp.qj.ujq()) {
                    View aAs = dV.this.Cp.eU.aAs();
                    if (aAs instanceof com.bytedance.sdk.openadsdk.core.ui.aGH) {
                        ((com.bytedance.sdk.openadsdk.core.ui.aGH) aAs).setImageResource(com.bytedance.sdk.component.utils.ev.aGH(dV.this.Cp.FS, "tt_skip_btn"));
                    }
                }
                DeviceUtils.AudioInfoReceiver.eli(dV.this);
                dV.this.gHb = DeviceUtils.kb();
                if (dV.this.wC != null) {
                    dV.this.wC.MGA();
                }
                dV.this.Cp.gG.DbA(str2);
                aGH agh2 = agh;
                if (agh2 != null) {
                    agh2.eli(webView, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
                if (dV.this.wC != null) {
                    dV.this.wC.ui();
                }
                aGH agh2 = agh;
                if (agh2 != null) {
                    agh2.eli(webView, str2, bitmap);
                }
            }
        };
        this.eU = uiVar;
        this.aqO.setWebViewClient(uiVar);
        this.eU.eli(evVar);
        this.eU.eli(this.NU ? "rewarded_video" : "fullscreen_interstitial_ad");
        if (evVar.XxP() && (mga = this.aqO) != null && mga.getWebView() != null) {
            this.aqO.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.10
                private final int Os = com.bytedance.sdk.openadsdk.core.dV.DbA();

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int i;
                    if (dV.this.ui != null) {
                        dV.this.ui.eli(motionEvent);
                    }
                    if (dV.this.qyC != null) {
                        dV.this.qyC.eli(motionEvent);
                    }
                    try {
                        int actionMasked = motionEvent.getActionMasked();
                        if (actionMasked != 0) {
                            int i2 = 3;
                            if (actionMasked != 1) {
                                if (actionMasked != 2) {
                                    i2 = actionMasked != 3 ? -1 : 4;
                                } else {
                                    float rawX = motionEvent.getRawX();
                                    float rawY = motionEvent.getRawY();
                                    if (Math.abs(rawX - dV.this.gG) >= this.Os || Math.abs(rawY - dV.this.ujq) >= this.Os) {
                                        dV.this.VM = false;
                                    }
                                    dV.this.GB += Math.abs(motionEvent.getX() - dV.this.gG);
                                    dV.this.oWW += Math.abs(motionEvent.getY() - dV.this.ujq);
                                    int i3 = (System.currentTimeMillis() - dV.this.Ue <= 200 || (dV.this.GB <= 8.0f && dV.this.oWW <= 8.0f)) ? 2 : 1;
                                    if (dV.this.nro) {
                                        if (rawY - dV.this.ujq > 8.0f) {
                                            dV.this.qj.eli();
                                        }
                                        if (rawY - dV.this.ujq < -8.0f) {
                                            dV.this.qj.DbA();
                                        }
                                    }
                                    i = i3;
                                }
                            }
                            i = i2;
                        } else {
                            dV.this.VM = true;
                            dV.this.KM = new SparseArray();
                            dV.this.gG = motionEvent.getRawX();
                            dV.this.ujq = motionEvent.getRawY();
                            dV.this.Ue = System.currentTimeMillis();
                            try {
                                long landingPageClickBegin = dV.this.aqO.getLandingPageClickBegin();
                                if (landingPageClickBegin > 0 && landingPageClickBegin < dV.this.Ue) {
                                    dV.this.Ue = landingPageClickBegin;
                                    dV.this.aqO.setLandingPageClickBegin(-1L);
                                }
                            } catch (Exception unused) {
                            }
                            dV.this.GB = -1.0f;
                            dV.this.oWW = -1.0f;
                            i = 0;
                        }
                        dV.this.KM.put(motionEvent.getActionMasked(), new Os.eli(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
                        if (motionEvent.getAction() == 1 && view.getVisibility() == 0 && Float.valueOf(view.getAlpha()).intValue() == 1 && ((!dV.this.nGm || Xb.wC(evVar)) && dV.this.VM)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("down_x", dV.this.gG);
                            jSONObject.put("down_y", dV.this.ujq);
                            jSONObject.put("down_time", dV.this.Ue);
                            jSONObject.put("up_x", motionEvent.getRawX());
                            jSONObject.put("up_y", motionEvent.getRawY());
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                long landingPageClickEnd = dV.this.aqO.getLandingPageClickEnd();
                                if (landingPageClickEnd > 0 && landingPageClickEnd < currentTimeMillis) {
                                    try {
                                        dV.this.aqO.setLandingPageClickEnd(-1L);
                                    } catch (Exception unused2) {
                                    }
                                    currentTimeMillis = landingPageClickEnd;
                                }
                            } catch (Exception unused3) {
                            }
                            jSONObject.put("up_time", currentTimeMillis);
                            int[] iArr = new int[2];
                            if (dV.this.nro) {
                                dV dVVar = dV.this;
                                dVVar.Vy = dVVar.Cp.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.GMY);
                            } else {
                                dV dVVar2 = dV.this;
                                dVVar2.Vy = dVVar2.Cp.dZ.findViewById(520093713);
                            }
                            if (dV.this.Vy != null) {
                                dV.this.Vy.getLocationOnScreen(iArr);
                                jSONObject.put("button_x", iArr[0]);
                                jSONObject.put("button_y", iArr[1]);
                                jSONObject.put("button_width", dV.this.Vy.getWidth());
                                jSONObject.put("button_height", dV.this.Vy.getHeight());
                            }
                            if (dV.this.ev != null) {
                                int[] iArr2 = new int[2];
                                dV.this.ev.getLocationOnScreen(iArr2);
                                jSONObject.put("ad_x", iArr2[0]);
                                jSONObject.put("ad_y", iArr2[1]);
                                jSONObject.put("width", dV.this.ev.getWidth());
                                jSONObject.put("height", dV.this.ev.getHeight());
                            }
                            jSONObject.put("toolType", motionEvent.getToolType(0));
                            jSONObject.put("deviceId", motionEvent.getDeviceId());
                            jSONObject.put("source", motionEvent.getSource());
                            jSONObject.put("ft", com.bytedance.sdk.openadsdk.core.model.nlS.eli(dV.this.KM, com.bytedance.sdk.openadsdk.core.FC.DbA().eli() ? 1 : 2));
                            jSONObject.put("user_behavior_type", dV.this.VM ? 1 : 2);
                            jSONObject.put("click_scence", 2);
                            if (dV.this.eU != null) {
                                dV.this.eU.eli(jSONObject);
                            }
                            if (!dV.this.nGm && !Xb.kb(evVar)) {
                                if (dV.this.NU) {
                                    com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "rewarded_video", "click", jSONObject);
                                } else {
                                    com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "fullscreen_interstitial_ad", "click", jSONObject);
                                }
                                dV.this.nGm = true;
                            }
                            return false;
                        }
                    } catch (Throwable th) {
                        Log.e("TTAD.RFWVM", "TouchRecordTool onTouch error", th);
                    }
                    return false;
                }
            });
        }
        com.bytedance.sdk.component.FC.MGA mga3 = this.aqO;
        if (mga3 != null) {
            mga3.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.eli, this.ui, this.qyC) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.dV.11
                @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    aGH agh2 = agh;
                    if (agh2 != null) {
                        agh2.eli(webView, i);
                    }
                }
            });
        }
        eli(this.aqO);
        this.aqO.setLayerType(1, null);
        this.aqO.setBackgroundColor(-1);
        this.aqO.setDisplayZoomControls(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return this.Cp.DbA.XxP() && str.endsWith(".mp4");
    }

    public boolean dV() {
        String str = this.aGH;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void eli(DownloadListener downloadListener) {
        com.bytedance.sdk.component.FC.MGA mga = this.aqO;
        if (mga == null || downloadListener == null) {
            return;
        }
        mga.setDownloadListener(downloadListener);
    }

    public boolean nGm() {
        return this.QX.get();
    }

    public boolean QX() {
        return this.Xb;
    }

    public void eli(com.bytedance.sdk.component.FC.MGA mga) {
        if (mga == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(this.Cp.SSo).eli(false).DbA(false).eli(mga.getWebView());
        mga.setUserAgentString(QX.eli(mga.getWebView(), BuildConfig.VERSION_CODE));
        mga.setMixedContentMode(0);
    }

    public void Xb() {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.wC;
        if (uiVar != null) {
            uiVar.FC();
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.ui;
        if (nls != null) {
            nls.wC();
        }
    }

    public void bf() {
        com.bytedance.sdk.component.FC.MGA mga = this.aqO;
        if (mga != null) {
            mga.Dfc();
        }
        com.bytedance.sdk.component.FC.MGA mga2 = this.dV;
        if (mga2 != null) {
            mga2.Dfc();
        }
        if (this.jh > 0) {
            this.Za += SystemClock.elapsedRealtime() - this.jh;
            this.jh = 0L;
        }
        qj qjVar = this.eli;
        if (qjVar != null) {
            qjVar.DbA(false);
            DbA(this.eli, false);
            eli(this.eli, true, false);
        }
        if (this.DbA == null || !KM.wC(this.Cp.DbA)) {
            return;
        }
        this.DbA.DbA(false);
        DbA(this.DbA, false);
        eli(this.DbA, true, false);
    }

    public void Os(boolean z) {
        DbA(this.eli, z);
    }

    public void DbA(qj qjVar, boolean z) {
        try {
            this.Cp.gG.aGH(z);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            qjVar.eli(C3040d4.g.V, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void eli(boolean z, boolean z2) {
        eli(this.eli, z, z2);
    }

    public void eli(qj qjVar, boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z2);
            com.bytedance.sdk.openadsdk.activity.wC wCVar = this.Cp.yKf;
            if (wCVar != null) {
                jSONObject.put("multi_ads_show", wCVar.dZ().kb());
            }
            qjVar.eli("endcard_control_event", jSONObject);
            if (z2) {
                if (this.Xb) {
                    return;
                }
                this.rQ = true;
                return;
            }
            this.rQ = false;
        } catch (Exception unused) {
        }
    }

    public void aGH(boolean z) {
        if (KM.DbA(this.Cp.DbA)) {
            return;
        }
        ui(z);
    }

    public void ui(boolean z) {
        if (this.eli == null || this.Cp.SSo.isFinishing()) {
            return;
        }
        this.Cp.gG.ui(z);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.eli.eli("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void CMM() {
        com.bytedance.sdk.component.FC.MGA mga = this.aqO;
        if (mga != null) {
            mga.NU();
        }
        com.bytedance.sdk.component.FC.MGA mga2 = this.dV;
        if (mga2 != null) {
            mga2.NU();
        }
        if (this.jh == 0) {
            this.jh = SystemClock.elapsedRealtime();
        }
        ev evVar = this.Cp.DbA;
        qj qjVar = this.eli;
        if (qjVar != null) {
            qjVar.du();
            com.bytedance.sdk.component.FC.MGA mga3 = this.aqO;
            if (mga3 != null) {
                if (mga3.getVisibility() == 0) {
                    this.eli.DbA(true);
                    DbA(this.eli, true);
                    eli(this.eli, false, true);
                    if (KM.aAs(evVar) && !this.dZ && this.Cp.DbA.ip()) {
                        FC();
                    }
                } else {
                    this.eli.DbA(false);
                    DbA(this.eli, false);
                    eli(this.eli, true, false);
                }
            }
        }
        if (this.DbA != null && KM.wC(evVar)) {
            this.DbA.du();
            com.bytedance.sdk.component.FC.MGA mga4 = this.dV;
            if (mga4 != null) {
                if (mga4.getVisibility() == 0) {
                    this.DbA.DbA(true);
                    DbA(this.DbA, true);
                    eli(this.DbA, false, true);
                    if (!this.dZ && this.Cp.DbA.ip()) {
                        ikX();
                    }
                } else {
                    this.DbA.DbA(false);
                    DbA(this.DbA, false);
                    eli(this.DbA, true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.ui;
        if (nls != null) {
            nls.kb();
        }
    }

    public int ev() {
        return this.MGA;
    }

    public String Vy() {
        return this.kb;
    }

    public String gG() {
        return this.aGH;
    }

    public boolean ujq() {
        return ev.Os(this.Cp.DbA) ? this.SSo && !this.Uv && this.Cp.nro.nlS() : this.SSo && !this.Uv && this.QX.get() && this.Xb;
    }

    public void Ue() {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.wC;
        if (uiVar != null) {
            uiVar.wC();
        }
    }

    public void eli(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.wC;
        if (uiVar == null) {
            return;
        }
        if (z) {
            uiVar.DbA();
        } else {
            uiVar.eli(i, str);
        }
    }

    public void KM() {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.wC;
        if (uiVar != null) {
            uiVar.kb();
        }
    }

    public void VM() {
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.ui;
        if (nls != null) {
            nls.eli(System.currentTimeMillis());
        }
    }

    public boolean GB() {
        return this.FC;
    }

    public void oWW() {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.wC;
        if (uiVar != null) {
            uiVar.Os();
            this.wC.aGH();
        }
    }

    public void qj() {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.wC;
        if (uiVar != null) {
            uiVar.aAs();
        }
    }

    private com.bytedance.sdk.openadsdk.aGH.aGH.ui tGZ() {
        ev evVar = this.Cp.DbA;
        return new com.bytedance.sdk.openadsdk.aGH.nGm(KM.kb(evVar) ? 3 : 2, this.NU ? "rewarded_video" : "fullscreen_interstitial_ad", evVar);
    }

    public boolean nro() {
        qj qjVar = this.eli;
        if (qjVar == null) {
            return false;
        }
        return qjVar.FC();
    }

    @Override // com.bytedance.sdk.openadsdk.nlS.wC
    public void DbA(int i) {
        int i2 = this.gHb;
        if (i2 <= 0 && i > 0) {
            aGH(false);
        } else if (i2 > 0 && i == 0) {
            aGH(true);
        }
        this.gHb = i;
    }

    public void Cp() {
        SSo.eli((View) this.aqO, 0);
        SSo.eli((View) this.dV, 8);
    }

    public void cyF() {
        SSo.eli((View) this.dV, 8);
    }

    public void MGA(boolean z) {
        this.Uv = true;
        JSONObject jSONObject = new JSONObject();
        ev evVar = this.Cp.DbA;
        try {
            jSONObject.put("endcard_overlay_render_type", ev.Os(evVar) ? 7 : 0);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, this.du, "use_second_endcard", jSONObject);
        this.jh = SystemClock.elapsedRealtime();
        try {
            if (!ev.Os(evVar)) {
                this.eli.eli("click_endcard_close", (JSONObject) null);
            } else if (z) {
                this.Cp.nro.wC();
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, this.du, "endcard_close_skip", jSONObject);
            }
        } catch (Exception unused2) {
        }
        this.Cp.GMY.eli(this.Cp.wC);
    }

    public boolean eU() {
        return this.Xb && this.QX.get();
    }

    public boolean dZ() {
        return this.tLO;
    }

    public boolean SSo() {
        com.bytedance.sdk.component.FC.MGA mga = this.aqO;
        return mga == null || mga.getWebView() == null;
    }

    private static class DbA implements com.bytedance.sdk.openadsdk.nlS.eli {
        private final View eli;

        public DbA(View view) {
            this.eli = view;
        }

        @Override // com.bytedance.sdk.openadsdk.nlS.eli
        public int eli() {
            View view = this.eli;
            int measuredHeight = view != null ? view.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? SSo.ui(com.bytedance.sdk.openadsdk.core.dV.eli()) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.nlS.eli
        public int DbA() {
            View view = this.eli;
            int measuredWidth = view != null ? view.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? SSo.Os(com.bytedance.sdk.openadsdk.core.dV.eli()) : measuredWidth;
        }
    }

    private static class Os implements com.bytedance.sdk.openadsdk.nlS.aAs {
        private final com.bytedance.sdk.component.FC.MGA eli;

        private Os(com.bytedance.sdk.component.FC.MGA mga) {
            this.eli = mga;
        }

        @Override // com.bytedance.sdk.openadsdk.nlS.aAs
        public void eli() {
            com.bytedance.sdk.component.FC.MGA mga = this.eli;
            if (mga == null) {
                return;
            }
            mga.Dfc();
        }

        @Override // com.bytedance.sdk.openadsdk.nlS.aAs
        public void DbA() {
            com.bytedance.sdk.component.FC.MGA mga = this.eli;
            if (mga == null) {
                return;
            }
            mga.nGm();
        }
    }

    public void Uv() {
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.ui;
        if (nls != null) {
            nls.ui();
        }
    }

    private static class eli extends com.bytedance.sdk.openadsdk.core.DbA.eli implements DbA.eli {
        private final View DbA;
        private final View.OnClickListener Os;
        private final com.bytedance.sdk.openadsdk.component.reward.eli.eli eli;

        public eli(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar, View view, View.OnClickListener onClickListener) {
            super(eliVar.SSo, eliVar.DbA, eliVar.ui, eliVar.aGH ? 7 : 5);
            this.eli = eliVar;
            this.DbA = view;
            this.Os = onClickListener;
            HashMap hashMap = new HashMap();
            hashMap.put("close_auto_click", Boolean.TRUE);
            hashMap.put("click_scence", 2);
            eli(hashMap);
            eli(eliVar.Vy.Os());
            eli(this);
        }

        @Override // com.bytedance.sdk.openadsdk.core.DbA.eli, com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
        public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
            if (this.eli.DbA.ip()) {
                this.Os.onClick(view);
                this.DbA.setOnTouchListener(null);
                this.DbA.setOnClickListener(this.Os);
            } else {
                super.eli(view, f, f2, f3, f4, sparseArray, z);
                this.eli.Uv.e_();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
        public void eli(View view, int i) {
            this.DbA.setOnTouchListener(null);
            this.DbA.setOnClickListener(this.Os);
        }
    }

    public boolean FS() {
        return this.dZ;
    }

    public void kb(boolean z) {
        this.tLO = z;
    }

    public boolean jh() {
        return this.aAs;
    }
}

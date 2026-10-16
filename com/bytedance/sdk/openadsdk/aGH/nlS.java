package com.bytedance.sdk.openadsdk.aGH;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.QX;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.eli.MGA;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    private static final int[] Os = {10, 30, 50, 75, 100};
    private long CMM;
    private final AtomicInteger Cp;
    AtomicBoolean DbA;
    private final Context Dfc;
    private final AtomicBoolean FC;
    private volatile long FS;
    private long GB;
    private long KM;
    private int MGA;
    private String NU;
    private volatile long QI;
    private FC QX;
    private boolean SSo;
    private volatile long TfR;
    private long Ue;
    private du Uv;
    private long VM;
    private int Vy;
    private int WfR;
    private boolean Xb;
    private final AtomicBoolean Yw;
    private final AtomicInteger Za;
    private final AtomicBoolean aAs;
    private int aGH;
    private com.bytedance.sdk.openadsdk.core.widget.eli.MGA aqO;
    private int bf;
    private WeakReference<WebView> cyF;
    private boolean dV;
    private com.bytedance.sdk.openadsdk.aGH.aGH.ui dZ;
    private int du;
    private boolean eU;
    public MGA.eli eli;
    private long ev;
    private final ev gG;
    private final AtomicBoolean ikX;
    private final AtomicInteger jh;
    private final AtomicBoolean kb;
    private final AtomicBoolean mm;
    private com.bytedance.sdk.openadsdk.Xb.wC nGm;
    private boolean nlS;
    private String nn;
    private final boolean nro;
    private long oWW;
    private String oc;
    private volatile long ow;
    private boolean qj;
    private String qyC;
    private long rQ;
    private volatile int tGZ;
    private long ui;
    private String ujq;
    private final AtomicBoolean wC;

    public ev eli() {
        return this.gG;
    }

    public nlS(ev evVar, WebView webView, du duVar, int i) {
        this(evVar, webView);
        this.Uv = duVar;
        this.WfR = i;
    }

    public nlS(ev evVar, WebView webView) {
        this(evVar, webView, false);
    }

    public nlS(ev evVar, WebView webView, boolean z) {
        this.aGH = 0;
        this.ui = -1L;
        this.MGA = 1;
        this.kb = new AtomicBoolean(false);
        this.wC = new AtomicBoolean(false);
        this.FC = new AtomicBoolean(false);
        this.aAs = new AtomicBoolean(false);
        this.du = -1;
        this.Xb = false;
        this.bf = 0;
        this.DbA = new AtomicBoolean(false);
        this.ujq = "landingpage";
        this.Ue = 0L;
        this.KM = 0L;
        this.VM = 0L;
        this.GB = 0L;
        this.oWW = 0L;
        this.qj = false;
        this.nro = false;
        this.Cp = new AtomicInteger(0);
        this.eU = false;
        this.SSo = false;
        this.FS = 0L;
        this.jh = new AtomicInteger(0);
        this.Za = new AtomicInteger(0);
        this.ikX = new AtomicBoolean(false);
        this.tGZ = 0;
        this.WfR = -1;
        this.mm = new AtomicBoolean(false);
        this.Yw = new AtomicBoolean(false);
        Context eli2 = com.bytedance.sdk.openadsdk.core.dV.eli();
        this.Dfc = eli2;
        this.gG = evVar;
        if (webView == null) {
            return;
        }
        this.Xb = z;
        WeakReference<WebView> weakReference = new WeakReference<>(webView);
        this.cyF = weakReference;
        WebView webView2 = weakReference.get();
        if (webView2 == null) {
            return;
        }
        if (evVar != null && evVar.CH()) {
            com.bytedance.sdk.openadsdk.core.widget.eli.MGA mga = new com.bytedance.sdk.openadsdk.core.widget.eli.MGA(webView2, evVar, eli2, this.Xb);
            this.aqO = mga;
            this.eli = mga.Os();
        }
        if (evVar != null && evVar.OJ() && com.bytedance.sdk.openadsdk.core.settings.NU.nY().XU()) {
            this.QX = new FC(evVar, webView, this.Xb);
        }
        if (webView instanceof com.bytedance.sdk.component.FC.ui) {
            this.rQ = ((com.bytedance.sdk.component.FC.ui) webView2).eli;
        } else {
            this.rQ = System.currentTimeMillis();
        }
        try {
            webView2.addJavascriptInterface(new eli(), "JS_LANDING_PAGE_LOG_OBJ");
        } catch (Exception e) {
            Xb.eli("LandingPageLog", "addJavascriptInterface exception", e);
        }
        if (evVar != null && evVar.sIY() != null) {
            this.ui = evVar.sIY().optLong("page_id", -1L);
        }
        this.qyC = String.valueOf(SystemClock.elapsedRealtime());
    }

    public void eli(boolean z) {
        if (z) {
            this.bf = 1;
        }
    }

    public void eli(du duVar) {
        this.Uv = duVar;
    }

    public void eli(long j) {
        this.KM = j;
    }

    public void eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.eli.MGA mga = this.aqO;
        if (mga != null) {
            mga.eli(str);
        }
        FC fc = this.QX;
        if (fc != null) {
            fc.Os(str);
        }
        this.ujq = str;
    }

    public void eli(int i) {
        this.WfR = i;
    }

    public com.bytedance.sdk.openadsdk.aGH.aGH.ui DbA() {
        return this.dZ;
    }

    public void eli(com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar) {
        this.dZ = uiVar;
    }

    public nlS DbA(boolean z) {
        this.eU = z;
        return this;
    }

    public boolean Os() {
        return this.SSo;
    }

    public void DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.oc = str;
    }

    public void eli(com.bytedance.sdk.openadsdk.Xb.wC wCVar) {
        this.nGm = wCVar;
    }

    public void Os(boolean z) {
        this.SSo = z;
    }

    public void aGH() {
        if (FC()) {
            this.ow = SystemClock.elapsedRealtime();
            Os.eli(this.gG, this.oc);
        }
    }

    public void ui() {
        if (FC()) {
            this.TfR = SystemClock.elapsedRealtime();
            MGA();
        }
    }

    public void MGA() {
        if (FC() && this.TfR > 0 && this.QI > 0 && !this.mm.getAndSet(true)) {
            Os.DbA(this.QI - this.TfR, this.gG, this.oc, (String) null);
        }
    }

    public void eli(WebView webView, int i) {
        if (webView == null) {
            return;
        }
        if (this.FS == 0) {
            this.FS = SystemClock.elapsedRealtime();
        }
        if (this.VM == 0 && i > 0) {
            this.VM = System.currentTimeMillis();
        } else if (this.GB == 0 && i == 100) {
            this.GB = System.currentTimeMillis();
        }
        if (this.aGH != Os.length && ("landingpage".equals(this.ujq) || "landingpage_endcard".equals(this.ujq) || "landingpage_split_screen".equals(this.ujq) || "landingpage_direct".equals(this.ujq) || "aggregate_page".equals(this.ujq))) {
            int i2 = this.aGH;
            while (true) {
                int[] iArr = Os;
                if (i2 >= iArr.length || i < iArr[this.aGH]) {
                    break;
                }
                int i3 = i2 + 1;
                this.aGH = i3;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", webView.getUrl());
                    long j = this.ui;
                    if (j != -1) {
                        jSONObject.put("page_id", j);
                    }
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("pct", iArr[i2]);
                } catch (Exception unused) {
                }
                eli("progress_load_finish", jSONObject);
                i2 = i3;
            }
        }
        if (i == 100) {
            eli(false, SystemClock.elapsedRealtime());
            eli(webView.getUrl(), NotificationCompat.CATEGORY_PROGRESS, Math.min(this.GB - this.VM, TTAdConstant.AD_MAX_EVENT_TIME));
        }
    }

    private void eli(String str, String str2, long j) {
        if (this.FC.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (str.length() > 200) {
                    int indexOf = str.indexOf(38, 200);
                    int i = 300;
                    if (indexOf == -1 || indexOf > 300) {
                        indexOf = str.indexOf(63);
                    }
                    if (indexOf != -1 && indexOf <= 300) {
                        i = indexOf;
                    }
                    str = str.substring(0, i);
                }
                jSONObject.put("url", str);
                jSONObject.put("type", str2);
            } catch (Throwable unused) {
            }
            eli("load_finish_progress", jSONObject, j);
        }
    }

    public void eli(WebView webView, String str, Bitmap bitmap, boolean z, int i) {
        this.dV = z;
        this.Vy++;
        com.bytedance.sdk.openadsdk.core.widget.eli.MGA mga = this.aqO;
        if (mga != null && z) {
            mga.DbA(str);
            this.aqO.DbA();
        }
        FC fc = this.QX;
        if (fc != null && z) {
            fc.eli(str, i);
        }
        WeakReference<WebView> weakReference = this.cyF;
        WebView webView2 = weakReference != null ? weakReference.get() : null;
        if (webView2 != null) {
            try {
                WebBackForwardList copyBackForwardList = webView2.copyBackForwardList();
                if (copyBackForwardList != null && copyBackForwardList.getCurrentIndex() > this.tGZ) {
                    this.jh.incrementAndGet();
                }
                this.tGZ = copyBackForwardList.getCurrentIndex();
            } catch (Exception e) {
                Xb.eli("LandingPageLog", "copyBackForwardList exception", e);
            }
        }
        if (this.FS == 0) {
            this.FS = SystemClock.elapsedRealtime();
        }
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.dZ;
        if (uiVar != null) {
            uiVar.ui();
        }
        if (this.kb.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                int i2 = this.WfR;
                if (i2 >= 0) {
                    jSONObject.putOpt("preload_status", Integer.valueOf(i2));
                }
            } catch (Exception unused) {
            }
            eli("load_start", jSONObject);
        }
    }

    public void eli(WebView webView, String str, boolean z) {
        eli(false, SystemClock.elapsedRealtime());
        com.bytedance.sdk.openadsdk.core.widget.eli.MGA mga = this.aqO;
        if (mga != null && z) {
            mga.eli();
        }
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.dZ;
        if (uiVar != null) {
            uiVar.MGA();
        }
        FC fc = this.QX;
        if (fc != null && z) {
            fc.eli(str);
        }
        if (webView != null && !this.qj && this.eU) {
            this.qj = true;
            com.bytedance.sdk.component.utils.nn.eli(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.wC.compareAndSet(false, true)) {
            if (this.MGA != 3) {
                this.MGA = 2;
            }
            this.Ue = System.currentTimeMillis();
            boolean z2 = this.MGA == 2;
            int aAs = aAs();
            if (z2) {
                long j = this.GB - this.VM;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AndroidBridgeConstants.ERROR_CODE, this.du);
                    jSONObject.put("error_msg", this.NU);
                    jSONObject.put("error_url", this.nn);
                    int i = this.WfR;
                    if (i >= 0) {
                        jSONObject.put("preload_status", i);
                    }
                    jSONObject.put("first_page", aAs);
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    jSONObject.put("url", this.gG.dM());
                    jSONObject.put("preload_h5_type", this.gG.GB());
                } catch (Exception unused) {
                }
                eli(z, "0");
                long min = Math.min(j, TTAdConstant.AD_MAX_EVENT_TIME);
                eli("load_finish", jSONObject, min);
                if (FC()) {
                    this.QI = SystemClock.elapsedRealtime();
                    MGA();
                    Os.eli(this.gG, this.oc, this.QI - this.ow);
                }
                eli(str, "load_finish", min);
                du duVar = this.Uv;
                if (duVar != null) {
                    duVar.eli(aAs);
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(AndroidBridgeConstants.ERROR_CODE, this.du);
                jSONObject2.put("error_msg", this.NU);
                jSONObject2.put("error_url", this.nn);
                jSONObject2.put("first_page", aAs);
                int i2 = this.WfR;
                if (i2 >= 0) {
                    jSONObject2.put("preload_status", i2);
                }
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                jSONObject2.put("url", this.gG.dM());
                jSONObject2.put("preload_h5_type", this.gG.GB());
            } catch (Exception unused2) {
            }
            eli(z, "2");
            eli("load_fail", jSONObject2);
            if (FC()) {
                Os.eli(this.gG, this.oc, SystemClock.elapsedRealtime() - this.ow, this.du, this.NU, this.nn);
            }
            if (this.nlS) {
                jSONObject2.remove("render_type");
                jSONObject2.remove("render_type_2");
                eli("load_fail_main", jSONObject2);
            }
        }
    }

    private boolean FC() {
        ev evVar;
        return this.SSo && (evVar = this.gG) != null && evVar.Ue();
    }

    private String Os(String str) {
        return "javascript:".concat(String.valueOf(str));
    }

    public void eli(WebView webView, int i, String str, String str2, String str3, boolean z) {
        com.bytedance.sdk.openadsdk.aGH.aGH.ui uiVar = this.dZ;
        if (uiVar != null) {
            uiVar.eli((JSONObject) null);
        }
        if ((str3 == null || !str3.startsWith("image")) && this.MGA != 2) {
            this.MGA = 3;
        }
        this.du = i;
        this.NU = str;
        this.nn = str2;
        this.nlS = z;
    }

    public void kb() {
        if (this.oWW == 0) {
            this.oWW = System.currentTimeMillis();
        }
        this.Ue = System.currentTimeMillis();
        if ("landingpage".equals(this.ujq) || "landingpage_endcard".equals(this.ujq) || "landingpage_split_screen".equals(this.ujq) || "landingpage_direct".equals(this.ujq) || "aggregate_page".equals(this.ujq)) {
            if (this.Yw.compareAndSet(false, true)) {
                com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("landingStart", this.gG, this.qyC);
            } else {
                com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("landingContinue", this.gG, this.qyC);
            }
        }
        if (com.bytedance.sdk.openadsdk.core.model.Xb.MGA(this.gG) || com.bytedance.sdk.openadsdk.core.model.Xb.DbA(this.gG)) {
            eli(true, SystemClock.elapsedRealtime());
        }
    }

    public void wC() {
        if (("landingpage".equals(this.ujq) || "landingpage_endcard".equals(this.ujq) || "landingpage_split_screen".equals(this.ujq) || "landingpage_direct".equals(this.ujq) || "aggregate_page".equals(this.ujq) || "landingpage_split_ceiling".equals(this.ujq)) && this.MGA == 2) {
            if (this.KM > 0 || !Os()) {
                long currentTimeMillis = System.currentTimeMillis() - Math.max(this.Ue, this.KM);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_status", this.MGA);
                    jSONObject.put("max_scroll_percent", this.Cp.get());
                    jSONObject.put("jump_times", this.jh.getAndSet(0));
                    jSONObject.put("click_times", this.Za.getAndSet(0));
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                this.aAs.set(true);
                eli("stay_page", jSONObject, Math.min(currentTimeMillis, TTAdConstant.AD_MAX_EVENT_TIME));
                com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("landingPause", this.gG, this.qyC);
            }
        }
    }

    public void eli(com.bytedance.sdk.component.FC.MGA mga) {
        int mm;
        Bitmap eli2;
        ev evVar;
        if ((!"landingpage".equals(this.ujq) && !"landingpage_endcard".equals(this.ujq) && !"landingpage_split_screen".equals(this.ujq) && !"landingpage_direct".equals(this.ujq) && !"aggregate_page".equals(this.ujq)) || (mm = com.bytedance.sdk.openadsdk.core.dV.aGH().mm()) == 0 || new Random().nextInt(100) + 1 > mm || mga == null || mga.getWebView() == null || mga.getVisibility() != 0 || (eli2 = SSo.eli(mga)) == null || (evVar = this.gG) == null) {
            return;
        }
        SSo.eli(evVar, this.ujq, "landing_page_blank", eli2, mga.getUrl(), this.ui);
    }

    public void aGH(boolean z) {
        WeakReference<WebView> weakReference = this.cyF;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                webView.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
            } catch (Exception e) {
                Xb.eli("LandingPageLog", "removeJavascriptInterface exception", e);
            }
        }
        if (this.wC.compareAndSet(false, true)) {
            eli(z, "1");
            if (this.eU) {
                Os.eli(this.gG, this.ujq, System.currentTimeMillis() - this.oWW, this.WfR, aAs());
            }
        } else if (this.MGA == 2 && !this.aAs.get()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_status", this.MGA);
                jSONObject.put("max_scroll_percent", this.Cp.get());
                jSONObject.put("jump_times", this.jh.getAndSet(0));
                jSONObject.put("click_times", this.Za.getAndSet(0));
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (JSONException unused) {
            }
            eli("stay_page", jSONObject, 0L);
        }
        if ("landingpage".equals(this.ujq) || "landingpage_endcard".equals(this.ujq) || "landingpage_split_screen".equals(this.ujq) || "landingpage_direct".equals(this.ujq) || "aggregate_page".equals(this.ujq) || "landingpage_split_ceiling".equals(this.ujq)) {
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("landingFinish", this.gG, this.qyC);
        }
    }

    public void DbA(WebView webView, String str, boolean z) {
        FC fc = this.QX;
        if (fc == null || !z) {
            return;
        }
        fc.eli(webView, str);
    }

    private void eli(String str, JSONObject jSONObject) {
        eli(str, jSONObject, -1L);
    }

    private void eli(final String str, final JSONObject jSONObject, final long j) {
        if (!this.eU || this.gG == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.Xb.wC wCVar = this.nGm;
        final int eU = wCVar != null ? wCVar.eU() : -1;
        Os.eli(System.currentTimeMillis(), this.gG, this.ujq, str, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.nlS.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = null;
                if (jSONObject != null) {
                    try {
                        boolean DbA = KM.DbA(nlS.this.gG);
                        int i = 0;
                        jSONObject.put("is_playable", DbA ? 1 : 0);
                        jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(nlS.this.gG) ? 1 : 0);
                        if (DbA && ("load_finish".equals(str) || "load_fail".equals(str))) {
                            jSONObject.put("playable_has_show", eU);
                        }
                        if (com.bytedance.sdk.openadsdk.NU.eli.Os(nlS.this.gG)) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("is_lp_pre_render", nlS.this.bf);
                            jSONObject.put("pag_json_data", jSONObject3.toString());
                        }
                        if ("stay_page".equals(str)) {
                            JSONObject jSONObject4 = jSONObject;
                            if (nlS.this.Vy <= 1) {
                                i = 1;
                            }
                            jSONObject4.put("first_page", i);
                        }
                    } catch (JSONException unused) {
                    }
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        try {
                            jSONObject5.put("ad_extra_data", jSONObject.toString());
                            long j2 = j;
                            if (j2 > 0) {
                                jSONObject5.put("duration", j2);
                            }
                        } catch (JSONException unused2) {
                        }
                        jSONObject2 = jSONObject5;
                    } catch (JSONException unused3) {
                    }
                }
                new Object[]{"sendEvent", str, nlS.this.ujq, jSONObject2};
                return jSONObject2;
            }
        });
    }

    private class eli {
        private eli() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable unused) {
            }
            nlS.this.Cp.set(i);
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }
    }

    public void eli(MotionEvent motionEvent) {
        com.bytedance.sdk.openadsdk.core.widget.eli.MGA mga = this.aqO;
        if (mga != null && this.dV) {
            mga.eli(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.FS != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                this.Za.incrementAndGet();
                if (this.ikX.getAndSet(true)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", this.gG.dM());
                } catch (JSONException unused) {
                }
                eli("click_time", jSONObject, Math.max(SystemClock.elapsedRealtime() - this.FS, 0L));
            }
        }
    }

    public void eli(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.widget.eli.MGA mga = this.aqO;
        if (mga != null && z) {
            mga.Os(str);
        }
        FC fc = this.QX;
        if (fc == null || !z) {
            return;
        }
        fc.DbA(str);
    }

    public void DbA(int i) {
        com.bytedance.sdk.openadsdk.core.widget.eli.MGA mga = this.aqO;
        if (mga == null || !this.dV) {
            return;
        }
        mga.eli(i);
    }

    private void eli(boolean z, final String str) {
        if (z) {
            final int aAs = aAs();
            Os.eli(new com.bytedance.sdk.component.wC.wC("sendPrefLog") { // from class: com.bytedance.sdk.openadsdk.aGH.nlS.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.openadsdk.core.settings.kb CMM = com.bytedance.sdk.openadsdk.core.dV.aGH().CMM();
                        boolean eli2 = nlS.this.eli(CMM, str);
                        if (eli2) {
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.kb.DbA)) {
                                nlS.this.eli(aAs, str);
                                return;
                            }
                            if (TextUtils.isEmpty(CMM.Os) || !eli2) {
                                return;
                            }
                            String str2 = CMM.Os;
                            com.bytedance.sdk.component.kb.DbA.DbA Os2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
                            Os2.DbA(str2);
                            HashMap hashMap = new HashMap();
                            hashMap.put("content-type", "application/json; charset=utf-8");
                            Os2.aGH(hashMap);
                            Os2.eli(9);
                            Os2.eli("sendPrefLog");
                            Os2.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.nlS.2.1
                                @Override // com.bytedance.sdk.component.kb.eli.eli
                                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                                }

                                @Override // com.bytedance.sdk.component.kb.eli.eli
                                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                                    try {
                                        com.bytedance.sdk.openadsdk.core.settings.kb.DbA = dbA.aGH();
                                        nlS.this.eli(aAs, str);
                                    } catch (Exception e) {
                                        Xb.eli("LandingPageLog", "TTWebViewClient : onPageFinished", e);
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        Xb.Os(th.getMessage(), new Object[0]);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(int i, String str) {
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.kb.DbA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.settings.kb.DbA);
            jSONObject.putOpt("cid", eli().umh());
            jSONObject.putOpt("ad_id", eli().umh());
            jSONObject.put("log_extra", eli().eu());
            dZ.eli(sb, "\"/** adInfo **/\"", jSONObject.toString());
            dZ.eli(sb, "\"/** first_page **/\"", String.valueOf(i));
            dZ.eli(sb, "\"/** ix_to_externalurl **/\"", this.ui != -1 ? "1" : "0");
            dZ.eli(sb, "\"/** preload_status **/\"", this.WfR == 2 ? "2" : "0");
            dZ.eli(sb, "\"/** scene_state **/\"", str);
            dZ.eli(sb, "\"/** web_init_time **/\"", String.valueOf(this.rQ));
            dZ.eli(sb, "\"/** channel_name **/\"", "\"" + eli().QxD() + "\"");
            dZ.eli(sb, "\"/** session_id **/\"", "\"" + UUID.randomUUID().toString() + "\"");
            dZ.eli(sb, "\"/** web_url **/\"", "\"" + eli().dM() + "\"");
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                return;
            }
            final String Os2 = Os(sb2);
            WeakReference<WebView> weakReference = this.cyF;
            final WebView webView = weakReference != null ? weakReference.get() : null;
            if (TextUtils.isEmpty(Os2) || webView == null) {
                return;
            }
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.nlS.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.utils.nn.eli(webView, Os2);
                }
            });
        } catch (Throwable th) {
            Xb.Os(th.getMessage(), new Object[0]);
        }
    }

    private int aAs() {
        WeakReference<WebView> weakReference = this.cyF;
        WebView webView = weakReference != null ? weakReference.get() : null;
        if (webView != null) {
            try {
                WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                if (copyBackForwardList != null) {
                    if (copyBackForwardList.getCurrentIndex() == 0) {
                        return 1;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(com.bytedance.sdk.openadsdk.core.settings.kb kbVar, String str) {
        str.hashCode();
        switch (str) {
            case "0":
                return kbVar.aGH;
            case "1":
                return kbVar.ui;
            case "2":
                return kbVar.MGA;
            default:
                return false;
        }
    }

    public void eli(boolean z, long j) {
        if (z) {
            this.CMM = j;
        } else {
            this.ev = j;
        }
        if (this.CMM <= 0 || this.ev <= 0 || !this.dV || !this.DbA.compareAndSet(false, true)) {
            return;
        }
        eli(this.gG, this.ujq, this.ev - this.CMM, this.bf);
    }

    public static void eli(final ev evVar, final String str, final long j, final int i) {
        Os.eli(System.currentTimeMillis(), evVar, str, "lp_feeling_duration", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.nlS.4
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("is_lp_pre_render", i);
                    jSONObject3.put("meta_pre_render", evVar.SE() ? 1 : 0);
                    QX bf = evVar.bf();
                    if (bf == null) {
                        bf = new QX();
                    }
                    jSONObject3.put("pre_render_status", bf.Os());
                    jSONObject3.put("pre_render_use_gecko", bf.DbA());
                    jSONObject3.put("pre_render_add_type", bf.eli());
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                    new Object[]{"feeling duration is:", Long.valueOf(j), jSONObject2, str};
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }
}

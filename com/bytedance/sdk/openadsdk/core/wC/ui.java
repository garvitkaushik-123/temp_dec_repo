package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.wC.Os;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui extends com.bytedance.sdk.component.FC.MGA implements Os.InterfaceC0201Os {
    private int Dfc;
    private Os FC;
    AtomicBoolean MGA;
    private List<String> NU;
    private com.bytedance.sdk.openadsdk.core.model.ev aAs;
    protected boolean aGH;
    private long aqO;
    private String du;
    AtomicBoolean kb;
    private int nlS;
    private DbA nn;
    protected boolean ui;
    private ev wC;

    public interface DbA {
        View DbA();

        View eli();

        void eli(int i, int i2);

        void eli(View view, int i);

        void k_();
    }

    public ui(Context context) {
        super(context);
        this.aGH = false;
        this.ui = false;
        this.MGA = new AtomicBoolean(false);
        this.kb = new AtomicBoolean(false);
        this.nlS = 0;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, DbA dbA, String str) {
        this.nn = dbA;
        this.aAs = evVar;
        this.du = str;
        this.FC = new Os();
        this.wC = new ev(getContext());
        setWebViewClient(new eli(this));
        setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.core.wC.ui.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                ui.this.Dfc = i;
                super.onProgressChanged(webView, i);
                if (i >= 100) {
                    ui.this.eli();
                }
            }
        });
        com.bytedance.sdk.component.utils.FC.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.ui.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView = ui.this.getWebView();
                if (webView != null) {
                    webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.wC.ui.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            ui.this.wC.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                }
            }
        });
    }

    private void bf() {
        if (this.NU == null) {
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.aAs, this.du, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(new com.bytedance.sdk.component.wC.wC("dsp_html_error_url") { // from class: com.bytedance.sdk.openadsdk.core.wC.ui.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ui.this.NU != null && ui.this.kb.compareAndSet(false, true)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = ui.this.NU.iterator();
                            while (it.hasNext()) {
                                jSONArray.put((String) it.next());
                            }
                            jSONObject.put("url", jSONArray);
                            com.bytedance.sdk.openadsdk.aGH.Os.DbA(ui.this.aAs, ui.this.du, "dsp_html_error_url", jSONObject);
                            ui.this.NU = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.FC.MGA
    public void aqO() {
        this.FC.DbA();
        super.aqO();
    }

    public void eli(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.FC.eli(view, friendlyObstructionPurpose);
    }

    @Override // com.bytedance.sdk.component.FC.MGA, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aGH) {
            this.FC.eli(getWebView());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        this.ui = z;
        this.FC.eli(z);
    }

    @Override // com.bytedance.sdk.component.FC.MGA, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.FC.eli();
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", this.Dfc / 100.0f);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.aAs, this.du, "load_rate", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Os.InterfaceC0201Os
    public void eli(String str) {
        String str2;
        boolean z;
        View view;
        if (TextUtils.isEmpty(str) || this.aAs == null || !this.wC.DbA()) {
            return;
        }
        int eli2 = dZ.eli(this.du);
        View view2 = null;
        if (com.bytedance.sdk.component.utils.nGm.eli(str) || !(this.aAs.Eh() == null || TextUtils.isEmpty(this.aAs.Eh().eli()))) {
            str2 = str;
        } else {
            com.bytedance.sdk.openadsdk.core.model.NU nu = new com.bytedance.sdk.openadsdk.core.model.NU();
            nu.eli(str);
            this.aAs.eli(nu);
            str2 = null;
        }
        this.aAs.Os(true);
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.aAs;
        if (evVar == null || evVar.Eh() == null || TextUtils.isEmpty(this.aAs.Eh().eli())) {
            z = false;
        } else {
            z = Cp.eli(getContext(), this.aAs, eli2, this.du, true, (Map<String, Object>) null);
            if (!z && !TextUtils.isEmpty(this.aAs.Eh().DbA())) {
                str2 = this.aAs.Eh().DbA();
                com.bytedance.sdk.openadsdk.aGH.Os.eli(this.aAs, this.du, "open_fallback_url", (Map<String, Object>) null);
            }
        }
        String str3 = str2;
        if (!z) {
            if (TextUtils.isEmpty(str3)) {
                return;
            } else {
                Cp.eli(getContext(), this.aAs, eli2, (PAGNativeAd) null, (com.bytedance.sdk.openadsdk.core.Os.eli) null, this.du, true, str3);
            }
        }
        if (this.wC != null) {
            DbA dbA = this.nn;
            if (dbA != null) {
                View eli3 = dbA.eli();
                View DbA2 = this.nn.DbA();
                this.nn.eli(this, 2);
                view2 = DbA2;
                view = eli3;
            } else {
                view = null;
            }
            com.bytedance.sdk.openadsdk.core.model.nlS eli4 = this.wC.eli(getContext(), view2, view);
            HashMap hashMap = new HashMap();
            hashMap.put("click_scence", 1);
            com.bytedance.sdk.openadsdk.aGH.Os.eli("click", this.aAs, eli4, this.du, true, (Map<String, Object>) hashMap, this.wC.DbA() ? 1 : 2);
        }
        ev evVar2 = this.wC;
        if (evVar2 != null) {
            evVar2.eli();
        }
    }

    public void QX() {
        DbA dbA = this.nn;
        if (dbA != null) {
            dbA.k_();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.aqO);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.aAs, this.du, "render_html_success", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Os.InterfaceC0201Os
    public void eli(int i, int i2) {
        DbA dbA = this.nn;
        if (dbA != null) {
            dbA.eli(i, i2);
        }
        this.nlS = i2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i2);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.aqO);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.aAs, this.du, "render_html_fail", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Os.InterfaceC0201Os
    public void DbA(String str) {
        if (this.NU == null) {
            this.NU = new ArrayList();
        }
        this.NU.add(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Os.InterfaceC0201Os
    public void eli() {
        if (this.MGA.compareAndSet(false, true)) {
            this.aGH = true;
            this.FC.eli(getWebView());
            this.FC.eli(this.ui);
            QX();
            bf();
        }
    }

    public void Xb() {
        this.MGA.set(false);
        String cmk = this.aAs.cmk();
        if (TextUtils.isEmpty(cmk)) {
            return;
        }
        String eli2 = com.bytedance.sdk.openadsdk.core.du.ui.eli(cmk);
        String str = TextUtils.isEmpty(eli2) ? cmk : eli2;
        this.nlS = 0;
        eli(null, str, "text/html", "UTF-8", null);
        this.aqO = SystemClock.elapsedRealtime();
    }

    static class eli extends MGA.eli {
        public static final Set<String> eli = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.wC.ui.eli.1
            {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        };
        Os.InterfaceC0201Os DbA;

        public eli(Os.InterfaceC0201Os interfaceC0201Os) {
            this.DbA = interfaceC0201Os;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.DbA.eli(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest == null || webResourceResponse == null || webResourceRequest.getUrl() == null) {
                return;
            }
            if (webResourceRequest.isForMainFrame()) {
                eli(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
            }
            eli(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return;
            }
            eli(webResourceRequest.getUrl().toString());
        }

        private void eli(String str) {
            int lastIndexOf;
            Os.InterfaceC0201Os interfaceC0201Os;
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) > 0) {
                if (!eli.contains(str.substring(lastIndexOf).toLowerCase()) || (interfaceC0201Os = this.DbA) == null) {
                    return;
                }
                interfaceC0201Os.DbA(str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            Os.InterfaceC0201Os interfaceC0201Os = this.DbA;
            if (interfaceC0201Os != null) {
                interfaceC0201Os.eli();
            }
        }

        private void eli(String str, int i, String str2) {
            Os.InterfaceC0201Os interfaceC0201Os = this.DbA;
            if (interfaceC0201Os != null) {
                interfaceC0201Os.eli(106, i);
            }
        }
    }

    public static class Os {
        protected int eli = 0;
        private com.bytedance.sdk.openadsdk.core.du.MGA DbA = com.bytedance.sdk.openadsdk.core.du.MGA.eli();

        Os() {
        }

        public void eli(WebView webView) {
            if (webView != null && this.eli == 0) {
                if (this.DbA == null) {
                    this.DbA = com.bytedance.sdk.openadsdk.core.du.MGA.eli();
                }
                this.DbA.eli(webView);
                this.DbA.DbA();
                this.eli = 1;
            }
        }

        public void eli(boolean z) {
            com.bytedance.sdk.openadsdk.core.du.MGA mga;
            if (this.eli == 1 && z && (mga = this.DbA) != null) {
                mga.Os();
                this.eli = 3;
            }
        }

        public void eli(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
            com.bytedance.sdk.openadsdk.core.du.MGA mga = this.DbA;
            if (mga != null) {
                mga.eli(view, friendlyObstructionPurpose);
            }
        }

        public void eli() {
            com.bytedance.sdk.openadsdk.core.du.MGA mga;
            int i = this.eli;
            if (i != 0 && i != 4 && (mga = this.DbA) != null) {
                mga.aGH();
            }
            this.eli = 4;
            this.DbA = null;
        }

        public void DbA() {
            eli();
        }
    }
}

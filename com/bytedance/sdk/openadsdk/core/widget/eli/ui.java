package com.bytedance.sdk.openadsdk.core.widget.eli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.component.utils.DbA;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nlS;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.utils.CMM;
import com.bytedance.sdk.openadsdk.utils.QX;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui extends MGA.eli {
    private static final HashSet<String> bf;
    private String DbA;
    private final Stack<String> Dfc;
    protected boolean FC;
    protected final String MGA;
    private com.bytedance.sdk.openadsdk.common.aGH NU;
    private nlS Os;
    private JSONObject QX;
    private ev Xb;
    protected boolean aAs;
    protected final qj aGH;
    private boolean aqO;
    private TTCeilingLandingPageActivity.eli dV;
    private Map<String, Object> du;
    private final boolean eli;
    protected com.bytedance.sdk.openadsdk.aGH.nlS kb;
    private com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA nGm;
    private boolean nlS;
    private String nn;
    protected final Context ui;
    protected boolean wC;

    public void eli(nlS nls) {
        this.Os = nls;
    }

    public void eli(Map<String, Object> map) {
        this.du = map;
    }

    public void eli(JSONObject jSONObject) {
        this.QX = jSONObject;
    }

    public void eli(String str) {
        this.DbA = str;
    }

    public void eli(ev evVar) {
        this.Xb = evVar;
    }

    public ui(Context context, qj qjVar, String str, com.bytedance.sdk.openadsdk.common.aGH agh, com.bytedance.sdk.openadsdk.aGH.nlS nls, boolean z, boolean z2, TTCeilingLandingPageActivity.eli eliVar) {
        this(context, qjVar, str, agh, nls, z);
        this.aqO = z2;
        this.dV = eliVar;
    }

    public ui(Context context, qj qjVar, String str, com.bytedance.sdk.openadsdk.common.aGH agh, com.bytedance.sdk.openadsdk.aGH.nlS nls, boolean z) {
        this(context, qjVar, str, nls, z);
        this.NU = agh;
    }

    public ui(Context context, qj qjVar, String str, com.bytedance.sdk.openadsdk.aGH.nlS nls, boolean z) {
        this.wC = true;
        this.FC = true;
        this.aAs = false;
        this.ui = context;
        this.aGH = qjVar;
        this.MGA = str;
        this.kb = nls;
        this.eli = z;
        this.Dfc = new Stack<>();
    }

    public com.bytedance.sdk.openadsdk.aGH.nlS DbA() {
        return this.kb;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.kb;
        if (nls != null) {
            nls.DbA(webView, str, this.eli);
        }
        com.bytedance.sdk.openadsdk.common.aGH agh = this.NU;
        if (agh != null) {
            agh.eli(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, final String str) {
        ui uiVar;
        String str2;
        Uri parse;
        final String lowerCase;
        Intent intent;
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.kb;
        if (nls != null) {
            nls.eli(str, this.eli);
        }
        com.bytedance.sdk.openadsdk.common.aGH agh = this.NU;
        if (agh != null) {
            agh.eli(webView, str, this.eli);
        }
        if (eli(webView, str)) {
            return true;
        }
        ev evVar = this.Xb;
        if (evVar != null && evVar.NU() == 1 && ((com.bytedance.sdk.openadsdk.QX.eli.eli.ui.eli(str, this.Xb) || com.bytedance.sdk.openadsdk.QX.eli.eli.ui.eli(this.Xb, str)) && com.bytedance.sdk.openadsdk.QX.eli.eli.ui.DbA(this.Xb, this.ui, true))) {
            return true;
        }
        try {
            parse = Uri.parse(str);
            lowerCase = parse.getScheme().toLowerCase();
        } catch (Throwable unused) {
            uiVar = this;
            str2 = str;
        }
        if ("bytedance".equals(lowerCase)) {
            QX.eli(parse, this.aGH);
            return true;
        }
        if (Os(str)) {
            return true;
        }
        if (!nGm.eli(str)) {
            if (Xb.wC(this.Xb)) {
                eli(lowerCase, str);
                return true;
            }
            try {
                if (str.startsWith("intent:")) {
                    intent = Intent.parseUri(str, 1);
                } else if (str.startsWith("android-app:")) {
                    intent = Intent.parseUri(str, 2);
                } else {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(parse);
                    intent = intent2;
                }
                intent.addFlags(268435456);
                com.bytedance.sdk.component.utils.DbA.eli(this.ui, intent, new DbA.InterfaceC0150DbA() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.ui.1
                    @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
                    public void eli() {
                        ui.this.eli(lowerCase, true, 0, "", str);
                    }

                    @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
                    public void eli(Throwable th) {
                        ui.this.eli(lowerCase, false, 2, th.getMessage(), str);
                    }
                });
                uiVar = this;
                str2 = str;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.eli("WebChromeClient", "parseUri", th);
                uiVar = this;
                str2 = str;
                try {
                    uiVar.eli(lowerCase, false, 1, th.getMessage(), str2);
                } catch (Throwable unused2) {
                    qj qjVar = uiVar.aGH;
                    if (qjVar != null && qjVar.ui()) {
                        return true;
                    }
                    return super.shouldOverrideUrlLoading(webView, str2);
                }
            }
            com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA = uiVar.nGm;
            if (dbA != null) {
                dbA.aqO();
            }
            return true;
        }
        str2 = str;
        return super.shouldOverrideUrlLoading(webView, str2);
    }

    private void eli(String str, String str2) {
        if ((ui(str) || "market".equals(str)) && ((this.Os != null || this.QX != null) && DbA(str2))) {
            Os();
        }
        this.Os = null;
        this.QX = null;
    }

    public boolean DbA(String str) {
        String str2;
        String str3;
        if (this.ui == null) {
            return false;
        }
        ev evVar = this.Xb;
        if (evVar != null && evVar.pu() != null) {
            str2 = this.Xb.pu().Os();
            str3 = this.Xb.pu().eli();
        } else {
            str2 = "";
            str3 = "";
        }
        if (!com.bytedance.sdk.openadsdk.QX.eli.eli.Os.eli()) {
            return com.bytedance.sdk.openadsdk.QX.eli.eli.eli.eli(str, this.ui, this.DbA, this.Xb, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.QX.eli.eli.eli.eli(this.Xb, str2, this.ui, this.DbA, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.QX.eli.eli.aGH.eli(this.ui, str3, str2, this.DbA, this.Xb);
        }
        Context context = this.ui;
        ev evVar2 = this.Xb;
        return com.bytedance.sdk.openadsdk.QX.eli.eli.Os.eli(context, str, evVar2, dZ.DbA(evVar2), null, true) || com.bytedance.sdk.openadsdk.QX.eli.eli.ui.eli(this.Xb, str2, this.ui, this.DbA, (Map<String, Object>) null) || com.bytedance.sdk.openadsdk.QX.eli.eli.ui.eli(this.ui, str3, str2, this.DbA, this.Xb);
    }

    private boolean ui(String str) {
        if (Xb.wC(this.Xb)) {
            return TextUtils.equals(this.Xb.GXP(), str);
        }
        return false;
    }

    public void Os() {
        if (TextUtils.isEmpty(this.DbA) || !Xb.kb(this.Xb) || this.nlS) {
            return;
        }
        nlS nls = this.Os;
        if (nls != null) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli("click", this.Xb, nls, this.DbA, true, this.du, 1);
            this.nlS = true;
            return;
        }
        JSONObject jSONObject = this.QX;
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.Xb, this.DbA, "click", jSONObject);
            this.nlS = true;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.kb;
        if (nls != null) {
            nls.eli(webView, str, this.eli);
        }
        com.bytedance.sdk.openadsdk.common.aGH agh = this.NU;
        if (agh != null) {
            agh.DbA(webView, str, this.eli);
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        WebView webView2;
        String str2;
        ev evVar;
        super.onPageStarted(webView, str, bitmap);
        ev evVar2 = this.Xb;
        int eli = (evVar2 != null && evVar2.OJ() && com.bytedance.sdk.openadsdk.bf.eli.eli("opt_web_index", false)) ? dZ.eli(webView) : -1;
        new Object[]{"currentUrlIndex is:", Integer.valueOf(eli)};
        com.bytedance.sdk.openadsdk.aGH.nlS nls = this.kb;
        if (nls != null) {
            webView2 = webView;
            str2 = str;
            nls.eli(webView2, str2, bitmap, this.eli, eli);
        } else {
            webView2 = webView;
            str2 = str;
        }
        com.bytedance.sdk.openadsdk.common.aGH agh = this.NU;
        if (agh != null) {
            agh.Os(webView2, str2, this.eli);
        }
        if (this.eli && (evVar = this.Xb) != null && evVar.OJ() && this.Xb.Xb().eli() >= 2) {
            if (!TextUtils.isEmpty(str2) && !str2.equals(this.nn)) {
                if (this.Dfc.contains(str2)) {
                    while (!str2.equals(this.Dfc.peek())) {
                        this.Dfc.pop();
                    }
                } else {
                    this.Dfc.push(str2);
                }
            }
            this.nn = str2;
        }
        new Object[]{"mNeedHardwareAcceleration:", Boolean.valueOf(this.FC), "hasSetHardwareAccelerate", Boolean.valueOf(this.aAs)};
        if (!this.FC || this.aAs) {
            return;
        }
        this.aAs = true;
        Os.eli(this.ui).eli(true).DbA(webView2.getSettings().getBuiltInZoomControls()).eli(webView2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.kb == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.kb.eli(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str, webResourceRequest != null && webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.kb == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("accept")) {
            str = requestHeaders.get("accept");
        }
        this.kb.eli(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str, webResourceRequest != null && webResourceRequest.isForMainFrame());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.kb != null) {
            int i = 0;
            String str = "SslError: unknown";
            String str2 = null;
            if (sslError != null) {
                try {
                    i = sslError.getPrimaryError();
                    str = "SslError: ".concat(String.valueOf(sslError));
                    str2 = sslError.getUrl();
                } catch (Throwable unused2) {
                }
            }
            String str3 = str2;
            this.kb.eli(webView, i, str, str3, aGH(str3), true);
        }
    }

    public boolean Os(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if ("play.google.com".equals(parse.getHost())) {
                if (Xb.wC(this.Xb) && this.QX == null && this.Os == null) {
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(this.ui instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.setData(parse);
                intent.setPackage("com.android.vending");
                this.ui.startActivity(intent);
                Os();
                this.QX = null;
                this.Os = null;
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        bf = hashSet;
        hashSet.add("png");
        hashSet.add("ico");
        hashSet.add("jpg");
        hashSet.add("gif");
        hashSet.add("svg");
        hashSet.add("jpeg");
    }

    public static String aGH(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !bf.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return "image/".concat(String.valueOf(substring));
    }

    private boolean eli(WebView webView, String str) {
        if (!dZ.aGH(this.Xb) || this.Xb.Xb() == null || webView == null) {
            return false;
        }
        int eli = this.Xb.Xb().eli();
        int size = this.Dfc.size();
        if (this.aqO) {
            size++;
        }
        new Object[]{"boc_index is:", Integer.valueOf(eli), "currentIndex is:", Integer.valueOf(size)};
        if (size + 1 != eli) {
            return false;
        }
        CMM.eli(this.ui, str, this.Xb, DbA.eli.aGH);
        TTCeilingLandingPageActivity.eli eliVar = this.dV;
        if (eliVar != null) {
            eliVar.eli();
        }
        return true;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        this.nGm = dbA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final String str, final boolean z, final int i, final String str2, final String str3) {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.Xb, this.DbA, "lp_not_http_open", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.ui.2
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("schema", str);
                    jSONObject3.put("jump_url", str3);
                    jSONObject3.put("success", z);
                    jSONObject3.put("error_type", i);
                    jSONObject3.put("error_reason", str2);
                    jSONObject2.put("pag_json_data", jSONObject3.toString());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    new Object[]{"onLpNotHttpLpOpen, extJson is:", jSONObject};
                    return jSONObject;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.eli("WebChromeClient", "onLpNotHttpLpOpen", th);
                    return jSONObject;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.FC.MGA.eli, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            com.bytedance.sdk.component.adexpress.ui.ui.eli().DbA();
        } catch (Exception unused) {
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }
}

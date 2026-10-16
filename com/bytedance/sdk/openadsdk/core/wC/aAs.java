package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.aGH.FC;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.oWW;
import com.bytedance.sdk.openadsdk.core.qj;
import com.google.common.net.HttpHeaders;
import com.ironsource.D5;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class aAs extends com.bytedance.sdk.openadsdk.core.widget.eli.ui {
    private final com.bytedance.sdk.openadsdk.core.model.ev DbA;
    private com.bytedance.sdk.component.adexpress.DbA.NU Os;
    private boolean du;
    public ArrayList<Integer> eli;

    public aAs(Context context, qj qjVar, com.bytedance.sdk.openadsdk.core.model.ev evVar, com.bytedance.sdk.openadsdk.aGH.nlS nls, com.bytedance.sdk.component.adexpress.DbA.NU nu) {
        super(context, qjVar, evVar.umh(), nls, false);
        this.du = false;
        this.eli = new ArrayList<>();
        this.DbA = evVar;
        this.Os = nu;
        this.du = com.bytedance.sdk.openadsdk.bf.eli.eli("inject_data_normal_open", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    public int eli() {
        Iterator<Integer> it = this.eli.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() == 3 || next.intValue() == 2 || next.intValue() == -1) {
                return next.intValue();
            }
        }
        return TextUtils.isEmpty(aGH()) ? -1 : 1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|(2:1|2)|(2:4|(8:6|7|8|9|(1:13)|(2:17|18)|21|22))|26|7|8|9|(2:11|13)|(3:15|17|18)|21|22|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        com.bytedance.sdk.component.utils.Xb.eli("ExpressClient", "shouldInterceptRequest error2", r0);
     */
    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        String str2;
        long currentTimeMillis;
        com.bytedance.sdk.component.adexpress.eli.DbA.eli eli;
        long currentTimeMillis2;
        int i;
        try {
            currentTimeMillis = System.currentTimeMillis();
            eli = eli(webView, str);
            currentTimeMillis2 = System.currentTimeMillis();
        } catch (Throwable th) {
            th = th;
            str2 = str;
        }
        if (eli != null) {
            if (eli.eli() != null) {
                i = 1;
                str2 = str;
                eli(currentTimeMillis, currentTimeMillis2, str2, i);
                if (eli != null && eli.DbA() != 5) {
                    eli.DbA();
                    this.eli.add(Integer.valueOf(eli.DbA()));
                }
                if (eli != null && eli.eli() != null) {
                    new Object[]{"return WebResourceResponse by cache, url is:", str2};
                    return eli.eli();
                }
                return super.shouldInterceptRequest(webView, str2);
            }
        }
        i = 2;
        str2 = str;
        eli(currentTimeMillis, currentTimeMillis2, str2, i);
        if (eli != null) {
            eli.DbA();
            this.eli.add(Integer.valueOf(eli.DbA()));
        }
        if (eli != null) {
            new Object[]{"return WebResourceResponse by cache, url is:", str2};
            return eli.eli();
        }
        return super.shouldInterceptRequest(webView, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.wC = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.FC = false;
        super.onPageStarted(webView, str, bitmap);
        com.bytedance.sdk.component.adexpress.DbA.NU nu = this.Os;
        if (nu != null && nu.ev() && this.du) {
            new Object[]{"trigger SDK_INJECT_DATA in pageStart, templateInfo is：", this.Os.Os()};
            com.bytedance.sdk.component.utils.nn.eli(webView, "javascript:window.SDK_INJECT_DATA=" + this.Os.Os());
        }
    }

    private com.bytedance.sdk.component.adexpress.eli.DbA.eli eli(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.model.nGm ngm = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new Object[]{"url is:", str};
        if (str.equals("local://pag_open_icon_id") || str.equals(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli)) {
            com.bytedance.sdk.component.adexpress.eli.DbA.eli eliVar = new com.bytedance.sdk.component.adexpress.eli.DbA.eli();
            eliVar.eli(5);
            eliVar.eli(ui());
            return eliVar;
        }
        ev.eli RY = this.DbA.RY();
        if (RY != null && !TextUtils.isEmpty(str) && str.equals(RY.DbA())) {
            com.bytedance.sdk.component.adexpress.eli.DbA.eli eliVar2 = new com.bytedance.sdk.component.adexpress.eli.DbA.eli();
            eliVar2.eli(5);
            WebResourceResponse ui = ui(str);
            eliVar2.eli(ui);
            boolean z = ui != null;
            new Object[]{"webview cache result is:", Boolean.valueOf(z)};
            com.bytedance.sdk.openadsdk.core.aGH.eli.eli().eli(z);
            return eliVar2;
        }
        FC.eli eli = com.bytedance.sdk.component.adexpress.aGH.FC.eli(str);
        if (nn.DbA(this.DbA)) {
            com.bytedance.sdk.component.adexpress.eli.DbA.eli eli2 = eli(str, eli);
            if (eli2 != null) {
                return eli2;
            }
            com.bytedance.sdk.component.adexpress.eli.DbA.eli DbA = DbA(str, eli);
            if (DbA != null) {
                Log.d("ExpressClient", "interceptTemplate: Hit fetch file cache url=".concat(String.valueOf(str)));
                return DbA;
            }
            com.bytedance.sdk.component.adexpress.eli.DbA.eli Os = Os(str, eli);
            if (Os != null) {
                return Os;
            }
        }
        if (eli != FC.eli.IMAGE) {
            Iterator<com.bytedance.sdk.openadsdk.core.model.nGm> it = this.DbA.an().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.sdk.openadsdk.core.model.nGm next = it.next();
                if (!TextUtils.isEmpty(next.eli()) && !TextUtils.isEmpty(str)) {
                    String eli3 = next.eli();
                    if (eli3.startsWith("https")) {
                        eli3 = eli3.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(eli3)) {
                        ngm = next;
                        break;
                    }
                }
            }
        }
        if (eli == FC.eli.IMAGE || ngm != null) {
            com.bytedance.sdk.component.adexpress.eli.DbA.eli eliVar3 = new com.bytedance.sdk.component.adexpress.eli.DbA.eli();
            eliVar3.eli(5);
            eliVar3.eli(eli(str, com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(this.DbA, str)));
            return eliVar3;
        }
        return com.bytedance.sdk.component.adexpress.eli.DbA.DbA.eli(str, eli, "", aGH());
    }

    private com.bytedance.sdk.component.adexpress.eli.DbA.eli eli(String str, FC.eli eliVar) {
        oWW.eli MGA;
        JSONArray eli;
        oWW hg = this.DbA.hg();
        if (hg != null && (MGA = hg.MGA()) != null && (eli = MGA.eli()) != null && eli.length() > 0) {
            for (int i = 0; i < eli.length(); i++) {
                if (TextUtils.equals(com.bytedance.sdk.openadsdk.core.aAs.Os.eli(eli.optString(i), com.bytedance.sdk.openadsdk.core.settings.NU.nY().GMY()), str) && eliVar == FC.eli.IMAGE) {
                    com.bytedance.sdk.component.adexpress.eli.DbA.eli eliVar2 = new com.bytedance.sdk.component.adexpress.eli.DbA.eli();
                    eliVar2.eli(5);
                    eliVar2.eli(eli(str, com.bytedance.sdk.component.utils.ui.eli(str)));
                    return eliVar2;
                }
            }
        }
        return null;
    }

    private com.bytedance.sdk.component.adexpress.eli.DbA.eli DbA(String str, FC.eli eliVar) {
        oWW.eli MGA;
        JSONArray DbA;
        oWW hg = this.DbA.hg();
        if (hg == null || (MGA = hg.MGA()) == null || (DbA = MGA.DbA()) == null || DbA.length() <= 0) {
            return null;
        }
        return eli(DbA, str, eliVar);
    }

    private com.bytedance.sdk.component.adexpress.eli.DbA.eli Os(String str, FC.eli eliVar) {
        oWW.eli MGA;
        JSONArray Os;
        oWW hg = this.DbA.hg();
        if (hg == null || (MGA = hg.MGA()) == null || (Os = MGA.Os()) == null || Os.length() <= 0) {
            return null;
        }
        return eli(Os, str, eliVar);
    }

    private com.bytedance.sdk.component.adexpress.eli.DbA.eli eli(JSONArray jSONArray, String str, FC.eli eliVar) {
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (TextUtils.equals(com.bytedance.sdk.openadsdk.core.aAs.Os.eli(jSONArray.optString(i), com.bytedance.sdk.openadsdk.core.settings.NU.nY().GMY()), str)) {
                    com.bytedance.sdk.component.adexpress.eli.DbA.eli eliVar2 = new com.bytedance.sdk.component.adexpress.eli.DbA.eli();
                    eliVar2.eli(5);
                    eliVar2.eli(aGH(str, eliVar));
                    return eliVar2;
                }
            }
        }
        return null;
    }

    private WebResourceResponse aGH(String str, FC.eli eliVar) {
        InputStream DbA;
        if (TextUtils.isEmpty(str) || (DbA = nn.DbA(str)) == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(eliVar.eli(), "UTF-8", DbA);
        eli(webResourceResponse);
        return webResourceResponse;
    }

    private String aGH() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.DbA;
        if (evVar == null) {
            return null;
        }
        if (evVar.RY() != null) {
            return this.DbA.RY().du();
        }
        if (this.DbA.hg() != null) {
            return "v3";
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private WebResourceResponse ui() {
        InputStream openRawResource;
        int FC = com.bytedance.sdk.openadsdk.core.FC.DbA().FC();
        if (FC == 0) {
            return null;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.dV.eli().getResources();
        if (resources != null) {
            try {
                openRawResource = resources.openRawResource(FC);
            } catch (Resources.NotFoundException e) {
                com.bytedance.sdk.component.utils.Xb.Os("ExpressClient", e.toString());
            }
            if (openRawResource == null) {
                return new WebResourceResponse(FC.eli.IMAGE.eli(), "UTF-8", openRawResource);
            }
            return null;
        }
        openRawResource = null;
        if (openRawResource == null) {
        }
    }

    private WebResourceResponse ui(String str) {
        InputStream eli;
        if (TextUtils.isEmpty(str) || (eli = com.bytedance.sdk.openadsdk.core.aGH.eli.eli().eli(str)) == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse("audio/*", "UTF-8", eli);
        eli(webResourceResponse);
        return webResourceResponse;
    }

    private WebResourceResponse eli(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream eli = com.bytedance.sdk.openadsdk.FC.aGH.eli(str, str2);
            if (eli == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(FC.eli.IMAGE.eli(), D5.N, eli);
            try {
                eli(webResourceResponse2);
                return webResourceResponse2;
            } catch (Throwable th) {
                th = th;
                webResourceResponse = webResourceResponse2;
                com.bytedance.sdk.component.utils.Xb.eli("ExpressClient", "get image WebResourceResponse error", th);
                return webResourceResponse;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void eli(long j, long j2, String str, int i) {
        if (this.kb == null || this.kb.DbA() == null) {
            return;
        }
        FC.eli eli = com.bytedance.sdk.component.adexpress.aGH.FC.eli(str);
        if (eli == FC.eli.HTML) {
            this.kb.DbA().eli(str, j, j2, i);
        } else if (eli == FC.eli.JS) {
            this.kb.DbA().DbA(str, j, j2, i);
        }
    }

    private void eli(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        webResourceResponse.setResponseHeaders(hashMap);
    }
}

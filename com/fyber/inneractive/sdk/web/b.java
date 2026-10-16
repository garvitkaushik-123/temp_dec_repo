package com.fyber.inneractive.sdk.web;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.util.IAlog;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b extends i1 {
    public final com.fyber.inneractive.sdk.flow.endcard.q N;

    public b(com.fyber.inneractive.sdk.flow.endcard.q qVar, boolean z) {
        super(z, c0.INTERSTITIAL, null);
        this.N = qVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x007c, code lost:
    
        if (r5.equals("success") == false) goto L21;
     */
    @Override // com.fyber.inneractive.sdk.web.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String str, com.fyber.inneractive.sdk.util.e1 e1Var) {
        String str2;
        char c = 0;
        if (str != null) {
            Locale locale = Locale.US;
            if (str.toLowerCase(locale).startsWith("fmpendcard://".toLowerCase(locale))) {
                com.fyber.inneractive.sdk.flow.endcard.q qVar = this.N;
                if (qVar != null) {
                    g gVar = this.f;
                    j1 j1Var = this.g;
                    Uri parse = Uri.parse(str);
                    String authority = parse != null ? parse.getAuthority() : null;
                    if (!TextUtils.isEmpty(authority)) {
                        authority.getClass();
                        authority.hashCode();
                        switch (authority.hashCode()) {
                            case -1867169789:
                                break;
                            case -1086574198:
                                if (authority.equals(AnalyticsConstants.EVENT_FAILURE)) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 94750088:
                                if (authority.equals("click")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                String queryParameter = parse.getQueryParameter("version");
                                if (!TextUtils.isEmpty(queryParameter)) {
                                    qVar.c = queryParameter;
                                }
                                g gVar2 = this.f;
                                if (gVar2 != null) {
                                    gVar2.a(this);
                                    break;
                                }
                                break;
                            case 1:
                                String queryParameter2 = parse.getQueryParameter("version");
                                if (!TextUtils.isEmpty(queryParameter2)) {
                                    qVar.c = queryParameter2;
                                }
                                String queryParameter3 = parse.getQueryParameter("error");
                                if (gVar != null) {
                                    InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.COULD_NOT_LOAD_FMP_ENDCARD_TO_WEBVIEW);
                                    if (!TextUtils.isEmpty(queryParameter3)) {
                                        inneractiveInfrastructureError.setCause(new Exception(queryParameter3));
                                    }
                                    gVar.a(this, inneractiveInfrastructureError);
                                    break;
                                }
                                break;
                            case 2:
                                if (j1Var != null) {
                                    com.fyber.inneractive.sdk.model.vast.b bVar = qVar.b;
                                    com.fyber.inneractive.sdk.flow.endcard.k kVar = bVar.o;
                                    if (kVar != null) {
                                        com.fyber.inneractive.sdk.flow.endcard.b a2 = kVar.b.a();
                                        str2 = kVar.f1189a.e.b;
                                        com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Other);
                                        if (cVar == null && (cVar = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Html)) == null && (cVar = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Iframe)) == null) {
                                            cVar = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Static);
                                        }
                                        if (a2 != null && a2.j() && cVar != null) {
                                            String str3 = cVar.g.g;
                                            if (!TextUtils.isEmpty(str3)) {
                                                str2 = str3;
                                            }
                                        }
                                    } else {
                                        str2 = bVar.b;
                                    }
                                    j1Var.a(str2, e1Var);
                                    break;
                                }
                                break;
                        }
                    } else if (gVar != null) {
                        InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.COULD_NOT_LOAD_FMP_ENDCARD_TO_WEBVIEW);
                        if (!TextUtils.isEmpty("empty type")) {
                            inneractiveInfrastructureError2.setCause(new Exception("empty type"));
                        }
                        gVar.a(this, inneractiveInfrastructureError2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.web.l
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.web.l
    public final void c() {
    }

    @Override // com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.j
    public final void d() {
        if (this.N == null || this.f == null) {
            return;
        }
        this.f.a(this, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.WEBVIEW_FMP_ENDCARD_ERROR));
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final com.fyber.inneractive.sdk.measurement.tracker.e f() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.j
    public final void a(WebView webView) {
        String str;
        if (webView == null || this.N == null) {
            return;
        }
        webView.setLongClickable(false);
        webView.setOnLongClickListener(new com.fyber.inneractive.sdk.util.n0());
        com.fyber.inneractive.sdk.flow.endcard.q qVar = this.N;
        com.fyber.inneractive.sdk.flow.endcard.p pVar = (com.fyber.inneractive.sdk.flow.endcard.p) qVar.d.f();
        pVar.getClass();
        try {
            JSONObject jSONObject = new JSONObject();
            com.fyber.inneractive.sdk.util.a1.a(jSONObject, "name", pVar.j);
            JSONArray jSONArray = new JSONArray();
            String str2 = pVar.k;
            if (!TextUtils.isEmpty(str2)) {
                jSONArray.put(str2);
            }
            com.fyber.inneractive.sdk.util.a1.a(jSONObject, "icons", jSONArray);
            str = jSONObject.toString();
        } catch (Exception e) {
            IAlog.a("%s FMP End-Card JSON error: %s", e, pVar.f1183a, e.getMessage());
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            IAlog.f("%s FMP End-Card JSON required", qVar.f1199a);
            return;
        }
        com.fyber.inneractive.sdk.util.o0.a(webView, "loadAssets(" + str + ");");
    }

    @Override // com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.j
    public final void a() {
        super.a();
        if (this.f != null) {
            this.f.a(this, new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, com.fyber.inneractive.sdk.flow.i.WEBVIEW_FMP_ENDCARD_ERROR, new WebViewRendererProcessHasGoneError()));
        }
    }
}

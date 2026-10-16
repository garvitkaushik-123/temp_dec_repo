package com.bytedance.sdk.openadsdk.core.widget.eli;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.aGH.nlS;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.utils.QX;

/* loaded from: classes3.dex */
public class aGH extends WebChromeClient {
    private static final String eli = WebChromeClient.class.getSimpleName();
    private final qj DbA;
    private nlS Os;
    private com.bytedance.sdk.openadsdk.common.aGH aGH;

    public aGH(qj qjVar) {
        this.DbA = qjVar;
    }

    public aGH(qj qjVar, nlS nls, com.bytedance.sdk.openadsdk.common.aGH agh) {
        this(qjVar, nls);
        this.aGH = agh;
    }

    public aGH(qj qjVar, nlS nls) {
        this.DbA = qjVar;
        this.Os = nls;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            eli(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !eli(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    private boolean eli(final String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.regionMatches(true, 0, "bytedance:", 0, "bytedance:".length())) {
                nn.Os().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.aGH.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QX.eli(Uri.parse(str), aGH.this.DbA);
                    }
                });
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        nlS nls = this.Os;
        if (nls != null) {
            nls.eli(webView, i);
        }
        com.bytedance.sdk.openadsdk.common.aGH agh = this.aGH;
        if (agh != null) {
            agh.eli(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}

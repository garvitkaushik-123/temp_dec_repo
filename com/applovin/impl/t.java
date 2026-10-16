package com.applovin.impl;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.Map;

/* loaded from: classes2.dex */
public class t extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f733a;
    private final com.applovin.impl.sdk.o b;
    private final com.applovin.impl.adview.a c;

    public t(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.k kVar) {
        this.f733a = kVar;
        this.b = kVar.O();
        this.c = aVar;
    }

    private void a(String str, ConsoleMessage consoleMessage) {
        com.applovin.impl.sdk.ad.b g = this.c.g();
        if (g != null) {
            String str2 = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber();
            String str3 = str == null ? "AdWebView" : "AdWebView:" + str;
            Map a2 = e2.a((AppLovinAdImpl) g);
            a2.putAll(e2.a(g));
            a2.put("source", str3);
            a2.put("top_main_method", str2);
            a2.put("error_message", consoleMessage.message());
            this.f733a.E().d(c2.L0, a2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message();
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("AdWebView", str);
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
            return true;
        }
        String message = consoleMessage.message();
        if (message.contains("al_onPoststitialShow")) {
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.al_onPoststitialShow_evaluation_error"), null);
            a("onPoststitialShowEvaluationError", consoleMessage);
        } else if (message.contains("SyntaxError")) {
            a(null, consoleMessage);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.o.a()) {
            return true;
        }
        this.b.k("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.o.a()) {
            return true;
        }
        this.b.k("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.o.a()) {
            return true;
        }
        this.b.k("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        com.applovin.impl.adview.a aVar;
        if (i != 100 || (aVar = this.c) == null) {
            return;
        }
        aVar.c(webView);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.k("AdWebView", "console.log[" + i + "] :" + str);
        }
    }
}

package com.bytedance.sdk.component.eli;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class gG extends eli {
    static final /* synthetic */ boolean aAs = true;
    protected WebView FC;
    protected String wC;

    @Override // com.bytedance.sdk.component.eli.eli
    protected Context eli(aAs aas) {
        if (aas.ui != null) {
            return aas.ui;
        }
        if (aas.eli != null) {
            return aas.eli.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.eli.eli
    protected String eli() {
        return this.FC.getUrl();
    }

    @Override // com.bytedance.sdk.component.eli.eli
    protected void DbA(aAs aas) {
        this.FC = aas.eli;
        this.wC = aas.Os;
        if (aas.nn) {
            return;
        }
        Os();
    }

    protected void Os() {
        if (!aAs && this.FC == null) {
            throw new AssertionError();
        }
        this.FC.addJavascriptInterface(this, this.wC);
    }

    @Override // com.bytedance.sdk.component.eli.eli
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.eli.eli
    protected void DbA() {
        super.DbA();
        aGH();
    }

    protected void aGH() {
        this.FC.removeJavascriptInterface(this.wC);
    }

    @Override // com.bytedance.sdk.component.eli.eli
    protected void eli(String str, aqO aqo) {
        if (aqo != null && !TextUtils.isEmpty(aqo.wC)) {
            String str2 = aqo.wC;
            eli(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
            return;
        }
        super.eli(str, aqo);
    }

    @Override // com.bytedance.sdk.component.eli.eli
    protected void eli(String str) {
        eli(str, "javascript:" + this.wC + "._handleMessageFromToutiao(" + str + ")");
    }

    private void eli(String str, final String str2) {
        if (this.MGA || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.eli.gG.1
            @Override // java.lang.Runnable
            public void run() {
                if (gG.this.MGA) {
                    return;
                }
                try {
                    gG.this.FC.evaluateJavascript(str2, null);
                } catch (Throwable unused) {
                }
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.aGH.post(runnable);
        } else {
            runnable.run();
        }
    }
}

package com.bytedance.sdk.component.utils;

import android.webkit.WebView;

/* loaded from: classes3.dex */
public class nn {
    private static final eli eli = new DbA();

    private static class eli {
        private eli() {
        }

        public void eli(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    private static class DbA extends eli {
        private DbA() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.nn.eli
        public void eli(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    return;
                } catch (Throwable th) {
                    boolean z = th instanceof IllegalStateException;
                }
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void eli(WebView webView, String str) {
        eli.eli(webView, str);
    }
}

package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebView;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
public final class zzct {
    private static Boolean zza;

    private zzct() {
    }

    public static void zza(WebView webView, String str) {
        boolean booleanValue;
        synchronized (zzct.class) {
            if (zza == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zza = true;
                } catch (IllegalStateException unused) {
                    zza = false;
                }
            }
            booleanValue = zza.booleanValue();
        }
        if (booleanValue) {
            webView.evaluateJavascript(str, null);
        } else {
            webView.loadUrl("javascript:".concat(str));
        }
    }
}

package com.sourcepoint.cmplibrary.util;

import android.content.SharedPreferences;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AuthIdUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"setAuthId", "", "authId", "", "webView", "Landroid/webkit/WebView;", "setAuthIdOldApi", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthIdUtils {
    public static final void setAuthId(final String str, final WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (str != null) {
            webView.evaluateJavascript(StringsKt.trimIndent("\n                    document.cookie = \"authId=" + str + "\";\n            "), new ValueCallback() { // from class: com.sourcepoint.cmplibrary.util.AuthIdUtils$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    AuthIdUtils.setAuthId$lambda$1$lambda$0(str, webView, (String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setAuthId$lambda$1$lambda$0(String str, WebView webView, String str2) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        if (Intrinsics.areEqual(str2, "null")) {
            setAuthIdOldApi(str, webView);
        }
    }

    private static final void setAuthIdOldApi(String str, WebView webView) {
        SharedPreferences sharedPreferences = webView.getContext().getSharedPreferences(C3040d4.h.K, 0);
        if (str == null || sharedPreferences.contains("isAuthIdSet")) {
            return;
        }
        webView.loadUrl("javascript:document.cookie = \"authId=" + str + "\";");
        sharedPreferences.edit().putBoolean("isAuthIdSet", true).apply();
        String url = webView.getUrl();
        if (url != null) {
            webView.loadUrl(url);
        }
    }
}

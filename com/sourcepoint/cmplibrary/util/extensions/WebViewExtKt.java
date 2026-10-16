package com.sourcepoint.cmplibrary.util.extensions;

import android.webkit.WebView;
import com.sourcepoint.cmplibrary.model.exposed.SPConsents;
import com.sourcepoint.cmplibrary.model.exposed.SPConsentsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WebViewExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"EVENT_SP_PRELOAD", "", "EVENT_SP_READY", "preloadConsent", "", "Landroid/webkit/WebView;", "spConsents", "Lcom/sourcepoint/cmplibrary/model/exposed/SPConsents;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebViewExtKt {
    private static final String EVENT_SP_PRELOAD = "sp.loadConsent";
    private static final String EVENT_SP_READY = "sp.readyForConsent";

    public static final void preloadConsent(WebView webView, SPConsents spConsents) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(spConsents, "spConsents");
        String trimIndent = StringsKt.trimIndent("\n        window.postMessage({\n            name: \"sp.loadConsent\",\n            consent: " + SPConsentsKt.toWebViewConsentsJsonObject(spConsents) + "\n        }, \"*\")\n    ");
        webView.evaluateJavascript(StringsKt.trimIndent("\n        " + trimIndent + "\n        window.addEventListener('message', (event) => {\n            if (event && event.data && event.data.name === \"sp.readyForConsent\") {\n                " + trimIndent + "\n            }\n        })\n    "), null);
    }
}

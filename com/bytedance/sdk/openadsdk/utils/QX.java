package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class QX {
    public static void eli(Uri uri, com.bytedance.sdk.openadsdk.core.qj qjVar) {
        if (qjVar == null || !qjVar.eli(uri)) {
            return;
        }
        try {
            qjVar.DbA(uri);
        } catch (Exception e) {
            new StringBuilder("TTAndroidObj handleUri exception: ").append(e);
        }
    }

    public static String eli(WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(userAgentString);
        sb.append(" open_news open_news_u_s/").append(i);
        return sb.toString();
    }
}
